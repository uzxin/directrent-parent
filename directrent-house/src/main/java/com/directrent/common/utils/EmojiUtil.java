package com.directrent.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 过滤表情
 * @author: YX
 * @date: 2020/09/10 21:22
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
