package com.directrent.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 敏感词验证(调用网易接口)
 * 
 * @author zhangkaichuan
 * @date 2018年5月8日
 */
@Component
public class SensitiveVerificationClient {

	private final static Logger log = LoggerFactory.getLogger(SensitiveVerificationClient.class);

	// 文本在线检测地址
	private final static String TEXT_CHECK_URL = "https://as.dun.163yun.com/v3/text/check";
	// 普通图片在线检测地址
	private final static String IMAGE_CHECK_URL = "https://as.dun.163yun.com/v3/image/check";
	// Secretkey
	private final static String SECREEKEY = "384237ac1afb952ab6f1774eec9aca37";
	// SecretId
	private final static String SECREEID = "34f2ba51e78400bcdbb655bbbf4e00e2";
	// 普通文本的businessId
	private final static String BUSINESSID_TEXT = "6e4d670a9e17b94348a8c5ddf8cea2d9";
	// 普通图片的businessId
	private final static String BUSINESSID_IMAGE = "4870c31755c76accfc2ef777a75e26f9";

	private static enum SensitiveLabelEnum{
		LABEL_100(100, "色情"),
		LABEL_110(110, "性感"),
		LABEL_200(200, "广告"),
		LABEL_210(210, "二维码"),
		LABEL_300(300, "暴恐"),
		LABEL_400(400, "违禁"),
		LABEL_500(500, "涉政"),
		LABEL_600(600, "谩骂"),
		LABEL_700(700, "灌水");	

	    private Integer code;
	    private String name;
	    private static Map<Integer,SensitiveLabelEnum> enumMap = new HashMap<Integer,SensitiveLabelEnum>();
	    static {
	        for (SensitiveLabelEnum obj :  SensitiveLabelEnum.values()) {
	        	enumMap.put(obj.code, obj);
	        }
	    }
		public static SensitiveLabelEnum valueOf(Integer code){
			return enumMap.get(code);
		}
	    private SensitiveLabelEnum(Integer code, String name) {
	        this.code = code;
	        this.name = name;
	    }
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	    
	}
	
	/**
	 * 验证普通文本是否包含敏感词信息
	 * 
	 *
	 * @author zhangkaichuan
	 * @date 2018年5月8日
	 * @param text
	 *            要验证的文本
	 * @return null或者空字符串：验证通过；其余的都是错误信息
	 */
	public String verifyText(String text) {
		// 返回信息
		String msg = "";

		Map<String, String> params = new HashMap<String, String>();
		// 1.设置公共参数
		// 产品秘钥 id:secretId
		params.put("secretId", SECREEID);
		// 业务id:businessId
		params.put("businessId", BUSINESSID_TEXT);
		// 版本
		params.put("version", "v3.1");
		// 时间戳
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		// 随机数
		params.put("nonce", String.valueOf(new Random().nextInt()));

		// 2.设置私有参数
		params.put("dataId", String.valueOf(SnowflakeIdWorker.getInstance().nextId()));
		params.put("content", text);
		params.put("publishTime", String.valueOf(System.currentTimeMillis()));

		// 3.生成签名信息
		String signature = "";
		try {
			signature = SensitiveVerificationClient.genSignature(SECREEKEY, params);
		} catch (UnsupportedEncodingException e1) {
			log.error("网易敏感词验证普通文本接口签名参数生成异常", e1);
			return msg;
		}
		params.put("signature", signature);

		try {
			// 4.发送HTTP请求，这里使用的是HttpClient工具包，产品可自行选择自己熟悉的工具包发送请求
			String result = HttpClientUtil.sendGet(TEXT_CHECK_URL, params);
			JSONObject jsonObject = JSONObject.parseObject(result);
			if (jsonObject == null || jsonObject.isEmpty()) {
					log.error("文字验证的地址或格式有误！", text);
					return msg;
			}

			JSONObject resultJson = jsonObject.getJSONObject("result");
			// 返回json中的reslut不能为空
			if (resultJson == null || resultJson.isEmpty()) {
				log.error("文字验证的地址或格式有误!", text);
				return msg;
			}

			// 获取reslut中的action
			Integer action = resultJson.getInteger("action");
			//0：通过，1：嫌疑，2：不通过
			if (0 == action || 1 == action) {//通过和不确定有问题的时候都予以放行
				// 验证通过
				return msg;
			} else {
				JSONArray labelsJsonArray = resultJson.getJSONArray("labels");
				for(int i = 0; i < labelsJsonArray.size(); i++){
					Integer level = (Integer)labelsJsonArray.getJSONObject(0).get("level");//1：不确定，2：确定
					Integer label = (Integer)labelsJsonArray.getJSONObject(0).get("label");
					msg = "文字含有" + SensitiveLabelEnum.valueOf(label).getName() + "信息！";
					break;
				}
				return msg;
			}

		} catch (Exception e) {
			log.error("文字验证调用网易敏感词验证普通文本接口发生异常", e);
			return msg;
		} finally {

		}
	}

	/**
	 * 生成签名信息
	 * 
	 * @param secretKey
	 *            产品私钥
	 * @param params
	 *            接口请求参数名和参数值map，不包括signature参数名
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static String genSignature(String secretKey, Map<String, String> params)
			throws UnsupportedEncodingException {
		// 1. 参数名按照ASCII码表升序排序
		String[] keys = params.keySet().toArray(new String[0]);
		Arrays.sort(keys);

		// 2. 按照排序拼接参数名与参数值
		StringBuffer paramBuffer = new StringBuffer();
		for (String key : keys) {
			paramBuffer.append(key).append(params.get(key) == null ? "" : params.get(key));
		}
		// 3. 将secretKey拼接到最后
		paramBuffer.append(secretKey);

		// 4. MD5是128位长度的摘要算法，用16进制表示，一个十六进制的字符能表示4个位，所以签名后的字符串长度固定为32个十六进制字符。
		return DigestUtils.md5Hex(paramBuffer.toString().getBytes("UTF-8"));
	}

	/**
	 * 验证图片是否含有敏感词
	 * 
	 *
	 * @author zhangkaichuan
	 * @date 2018年5月8日
	 * @param imgs
	 * @return
	 */
	public String verifyImg(List<String> imgs) {
		// 返回信息
		String msg = "";
		if (imgs == null || imgs.size() <= 0) {
			return msg;
		}

		Map<String, String> headers = new HashMap<String, String>();
		Map<String, String> params = new HashMap<String, String>();
		// 1.设置公共参数
		// 产品秘钥 id:secretId
		params.put("secretId", SECREEID);
		// 业务id:businessId
		params.put("businessId", BUSINESSID_IMAGE);
		// 版本
		params.put("version", "v3.2");
		// 时间戳
		params.put("timestamp", String.valueOf(System.currentTimeMillis()));
		// 随机数
		params.put("nonce", String.valueOf(new Random().nextInt()));

		// 2.设置私有参数
		JSONArray jsonArray = new JSONArray();
		// 传图片url进行检测，name结构产品自行设计，用于唯一定位该图片数据
		JSONObject image = null;
		// 循环构建验证的图片参数
		for (String imgUrl : imgs) {
			image = new JSONObject();
			image.put("name", imgUrl);
			image.put("type", 1);
			image.put("data", imgUrl);
			jsonArray.add(image);
		}
		// 要验证的图片数组接送字符串
		params.put("images", jsonArray.toString());

		// 3.生成签名信息
		String signature = "";
		try {
			signature = SensitiveVerificationClient.genSignature(SECREEKEY, params);
		} catch (UnsupportedEncodingException e1) {
			log.error("图片检测网易敏感词验证普通图片接口签名参数生成异常", e1);
//			msg = "网易敏感词验证普通图片接口签名参数生成异常";
			return msg;
		}
		params.put("signature", signature);

		try {
			// 4.发送HTTP请求，这里使用的是HttpClient工具包，产品可自行选择自己熟悉的工具包发送请求
//			HttpResponse httpResponse = HttpUtils.doGet(httpClient, IMAGE_CHECK_URL, "", headers, params);
//			// 返回状态码
//			int httpStatusCode = httpResponse.getStatusLine().getStatusCode();
//			if (200 == httpStatusCode) {
//				// 请求成功
//				// 获取请求返回的json对象
//				String resultStr = EntityUtils.toString(httpResponse.getEntity());
//				JSONObject jsonObject = JSONObject.parseObject(resultStr);
//				// 返回结果不能为空
//				if (jsonObject == null || jsonObject.isEmpty()) {
//					log.error("图片检查，返回结果为空！请求检查参数="+params);
//					return msg;
//				}
//
//				// 获取reslut的json数组
//				JSONArray resultArray = jsonObject.getJSONArray("result");
//				// 返回json中的reslut不能为空
//				if (resultArray == null || resultArray.isEmpty()) {
//					log.error("图片检查，返回结果为空！请求检查参数="+params);
//					return msg;
//				}
//
//				JSONObject json = null;
//				JSONObject labelJson = null;
//				// 循环验证每个图片的验证返回信息
//				for (int i = 0; i < resultArray.size(); i++) {
//					json = resultArray.getJSONObject(i);
//					if (json != null) {
//						// 获取验证完成的status
//						int status = json.getIntValue("status");
////						图片检测状态码，定义为：0：检测成功，610：图片下载失败，620：图片格式错误，630：其它
//						if (0!= status) {
//							log.error("图片检测失败,失败原因="+status);
//							return msg;
//						}
//
//						// 图片验证成功则获取验证结果,获取labels
//						JSONArray labelsArr = json.getJSONArray("labels");
//						if (labelsArr != null && labelsArr.size() > 0) {
//							// 循环验证网易的验证结果，如果有一个不正常则返回
//							for (int j = 0; j < labelsArr.size(); j++) {
//								// 获取单个label的接送
//								labelJson = labelsArr.getJSONObject(j);
//								// 获取level
//								int level = labelJson.getIntValue("level");
//								//分类级别，0：正常，1：不确定，2：确定
//								if ( 2 == level) {
//									Integer label = labelJson.getIntValue("label");
//									// 图片有敏感信息
//									msg = "图片含有" + SensitiveLabelEnum.valueOf(label).getName() + "信息！";
//									return msg;
//								}
//							}
//						}
//
//					}
//				}
//
//			} else {
//				log.error("图片检测http返回状态码错误，返回结果为" + httpStatusCode);
////				msg = "http返回状态码错误，返回结果为" + httpStatusCode;
//				return msg;
//			}
		} catch (Exception e) {
			log.error("图片检测调用网易敏感词验证普通图片接口发生异常", e);
			return msg;
		} finally {

		}
		return msg;
	}
}
