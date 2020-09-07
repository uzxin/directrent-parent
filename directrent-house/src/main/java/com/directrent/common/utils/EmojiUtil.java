package com.just.butterfly.biz.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @PackageName: com.just.butterfly.biz.common.util
 * @Description: 过滤表情符
 * @author: traveller
 * @date: 2019/2/19 11:08
 */
public class EmojiUtil {

    private EmojiUtil() {
    }


    public static String filter(String str) {

        if (str == null || str.trim().isEmpty()) {
            return str;
        }
        String pattern = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";
        String reStr = "";
        Pattern emoji = Pattern.compile(pattern);
        Matcher emojiMatcher = emoji.matcher(str);
        str = emojiMatcher.replaceAll(reStr);
        return str;
    }
}
