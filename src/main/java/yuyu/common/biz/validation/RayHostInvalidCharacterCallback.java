package yuyu.common.biz.validation;

import java.util.HashSet;
import java.util.Set;

import yuyu.infr.validation.constraintvalidators.callback.HostInvalidCharacterCallback;

import com.google.common.base.Strings;


/**
 * ホスト不可文字バリデーション用コールバッククラス実装です。
 */
public class RayHostInvalidCharacterCallback extends HostInvalidCharacterCallback{

    private static Set<Character> invalidCharSet;

    static{
        invalidCharSet = new HashSet<Character>();

        invalidCharSet.add('a');    invalidCharSet.add('ａ');
        invalidCharSet.add('b');    invalidCharSet.add('ｂ');
        invalidCharSet.add('c');    invalidCharSet.add('ｃ');
        invalidCharSet.add('d');    invalidCharSet.add('ｄ');
        invalidCharSet.add('e');    invalidCharSet.add('ｅ');
        invalidCharSet.add('f');    invalidCharSet.add('ｆ');
        invalidCharSet.add('g');    invalidCharSet.add('ｇ');
        invalidCharSet.add('h');    invalidCharSet.add('ｈ');
        invalidCharSet.add('i');    invalidCharSet.add('ｉ');
        invalidCharSet.add('j');    invalidCharSet.add('ｊ');
        invalidCharSet.add('k');    invalidCharSet.add('ｋ');
        invalidCharSet.add('l');    invalidCharSet.add('ｌ');
        invalidCharSet.add('m');    invalidCharSet.add('ｍ');
        invalidCharSet.add('n');    invalidCharSet.add('ｎ');
        invalidCharSet.add('o');    invalidCharSet.add('ｏ');
        invalidCharSet.add('p');    invalidCharSet.add('ｐ');
        invalidCharSet.add('q');    invalidCharSet.add('ｑ');
        invalidCharSet.add('r');    invalidCharSet.add('ｒ');
        invalidCharSet.add('s');    invalidCharSet.add('ｓ');
        invalidCharSet.add('t');    invalidCharSet.add('ｔ');
        invalidCharSet.add('u');    invalidCharSet.add('ｕ');
        invalidCharSet.add('v');    invalidCharSet.add('ｖ');
        invalidCharSet.add('w');    invalidCharSet.add('ｗ');
        invalidCharSet.add('x');    invalidCharSet.add('ｘ');
        invalidCharSet.add('y');    invalidCharSet.add('ｙ');
        invalidCharSet.add('z');    invalidCharSet.add('ｚ');
        invalidCharSet.add('ｦ');    invalidCharSet.add('ヲ');
        invalidCharSet.add('ｧ');    invalidCharSet.add('ァ');
        invalidCharSet.add('ｨ');    invalidCharSet.add('ィ');
        invalidCharSet.add('ｩ');    invalidCharSet.add('ゥ');
        invalidCharSet.add('ｪ');    invalidCharSet.add('ェ');
        invalidCharSet.add('ｫ');    invalidCharSet.add('ォ');
        invalidCharSet.add('ｬ');    invalidCharSet.add('ャ');
        invalidCharSet.add('ｭ');    invalidCharSet.add('ュ');
        invalidCharSet.add('ｮ');    invalidCharSet.add('ョ');
        invalidCharSet.add('ｯ');    invalidCharSet.add('ッ');
        invalidCharSet.add('!');    invalidCharSet.add('！');
        invalidCharSet.add('[');    invalidCharSet.add('［');
        invalidCharSet.add(']');    invalidCharSet.add('］');
        invalidCharSet.add('^');    invalidCharSet.add('＾');
        invalidCharSet.add('ｰ');    invalidCharSet.add('ー');
        invalidCharSet.add('`');    invalidCharSet.add('｀');
        invalidCharSet.add('{');    invalidCharSet.add('｛');
        invalidCharSet.add('|');    invalidCharSet.add('│');
        invalidCharSet.add('}');    invalidCharSet.add('｝');
        invalidCharSet.add('~');    invalidCharSet.add('￣');

    }

    @Override
    public boolean check(String s){

        if(Strings.isNullOrEmpty(s)){
            return true;
        }

        char[] charArray = s.toCharArray();
        for(char c : charArray){
            if(invalidCharSet.contains(c)){
                return false;
            }
        }

        return true;
    }

}
