package yuyu.common.workflowcore.core.iwfinfr.util;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64urlエンコードのユーティリティです。
 * <pre>
 * ○エンコード
 * 1.BASE64でテキスト化
 * 2."+"を"-"に置換
 * 3."/"を"_"に置換
 *
 * ○デコード
 * 1."-"を"+"に置換
 * 2."_"を"/"に置換
 * 3.BASE64でバイナリに戻す
 * </pre>
 */
public class IwfBase64Urls {


    public static String encode(byte[] pBinary){

        try {

            String base64 = new String(Base64.encodeBase64(pBinary));

            return base64.replaceAll("\\+", "-").replaceAll("\\/", "_");
        } catch (Exception e) {
            LoggerFactory.getLogger(IwfBase64Urls.class).debug("Base64urlエンコード失敗", e);
            return null;
        }

    }

    public static String encodeFromString(String pString) {
        try {
            return encode(pString.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeNonAsciiChar(String pString) {

        String regex = "[^\\x01-\\x7E]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pString);



        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(true) {
            if(index > pString.length()) {
                break;
            }

            if(!matcher.find(index)) {
                sb.append(pString.substring(index));
                break;
            } else {
                sb.append(pString.substring(index, matcher.start() - 1));
                sb.append(IwfBase64Urls.encodeFromString(pString.substring(matcher.start(), matcher.end())));
                index = matcher.end() + 1;
            }
        }

        return sb.toString();
    }


    public static byte[] decode(String pBase64url){

        if(pBase64url == null){
            return null;
        }

        try {

            String base64 = pBase64url.replaceAll("\\-", "+").replaceAll("\\_", "/");

            return Base64.decodeBase64(base64.getBytes());
        } catch (Exception e) {
            LoggerFactory.getLogger(IwfBase64Urls.class).debug("Base64urlデコード失敗", e);
            return null;
        }

    }

    public static String decodeToString(String pBase64url){

        if(pBase64url == null){
            return null;
        }
        try {
            return new String(decode(pBase64url), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
