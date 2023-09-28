package yuyu.common.biz.bzcommon;

import static yuyu.def.YuyuStandardCharsets.*;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Strings;

/**
 * SKJ関連のチェック、置換を行うクラスです。<br />
 * SKJとは住生基準漢字のことをさし、独自に定めた使用可能文字を表します。
 */
public class SkjStringUtil {

    private static Set<Character> invalidCharSet;

    static{
        invalidCharSet = new HashSet<Character>();

        invalidCharSet.add('①');    invalidCharSet.add('㍉');    invalidCharSet.add('㎏');    invalidCharSet.add('Σ');
        invalidCharSet.add('②');    invalidCharSet.add('㌔');    invalidCharSet.add('㏄');    invalidCharSet.add('√');
        invalidCharSet.add('③');    invalidCharSet.add('㌢');    invalidCharSet.add('㍻');    invalidCharSet.add('⊥');
        invalidCharSet.add('④');    invalidCharSet.add('㍍');    invalidCharSet.add('〝');    invalidCharSet.add('∠');
        invalidCharSet.add('⑤');    invalidCharSet.add('㌘');    invalidCharSet.add('〟');    invalidCharSet.add('∟');
        invalidCharSet.add('⑥');    invalidCharSet.add('㌧');    invalidCharSet.add('㏍');    invalidCharSet.add('⊿');
        invalidCharSet.add('⑦');    invalidCharSet.add('㌃');    invalidCharSet.add('㊤');    invalidCharSet.add('∩');
        invalidCharSet.add('⑧');    invalidCharSet.add('㌶');    invalidCharSet.add('㊥');    invalidCharSet.add('∪');
        invalidCharSet.add('⑨');    invalidCharSet.add('㍑');    invalidCharSet.add('㊦');
        invalidCharSet.add('⑩');    invalidCharSet.add('㍗');    invalidCharSet.add('㊧');
        invalidCharSet.add('⑪');    invalidCharSet.add('㌍');    invalidCharSet.add('㊨');
        invalidCharSet.add('⑫');    invalidCharSet.add('㌦');    invalidCharSet.add('㈲');
        invalidCharSet.add('⑬');    invalidCharSet.add('㌣');    invalidCharSet.add('㈹');
        invalidCharSet.add('⑭');    invalidCharSet.add('㌫');    invalidCharSet.add('㍾');
        invalidCharSet.add('⑮');    invalidCharSet.add('㍊');    invalidCharSet.add('㍽');
        invalidCharSet.add('⑯');    invalidCharSet.add('㌻');    invalidCharSet.add('㍼');
        invalidCharSet.add('⑰');    invalidCharSet.add('㎜');    invalidCharSet.add('≒');
        invalidCharSet.add('⑱');    invalidCharSet.add('㎝');    invalidCharSet.add('≡');
        invalidCharSet.add('⑲');    invalidCharSet.add('㎞');    invalidCharSet.add('∫');
        invalidCharSet.add('⑳');    invalidCharSet.add('㎎');    invalidCharSet.add('∮');
    }

    public static boolean skjChk(String target){
        if(Strings.isNullOrEmpty(target)){
            return true;
        }

        if(!target.equals(new String(target.getBytes(WINDOWS_31J),WINDOWS_31J))){
            return false;
        }

        return multiByteSkjCheck(target);
    }

    public static ReplaceSkjResultBean replaceSjk(String target){
        return replaceSjk(target,'■');
    }

    public static ReplaceSkjResultBean replaceSjk(String target, char replacement){

        ReplaceSkjResultBean result = new ReplaceSkjResultBean();

        if(Strings.isNullOrEmpty(target)){
            result.setReplacedString(target);
            result.setReplaced(false);
            return result;
        }

        StringBuilder sb = new StringBuilder();

        char[] charArray = target.toCharArray();
        for(char c : charArray){
            String str = String.valueOf(c);

            if(!skjChk(str)){
                sb.append(replacement);
            }else{
                sb.append(c);
            }
        }

        result.setReplacedString(sb.toString());
        result.setReplaced(!target.equals(sb.toString()));

        return result;
    }

    public static String convInvalidChar(String pParam){

        String result = pParam;

        String before[] = {"\u2212" ,"\u301c","\u2016","\u2014","\u00a6" };
        String after[]  = {"\uff0d" ,"\uff5e","\u2225","\u2015","\uffe4" };

        for (int i = 0; i < before.length; i++) {
            result = result.replaceAll(before[i], after[i]);
        }
        return result;
    }

    private static boolean multiByteSkjCheck(String s) {
        char[] charArray = s.toCharArray();
        for(char c : charArray){
            if(invalidCharSet.contains(c)){
                return false;
            }
        }
        return true;
    }
}
