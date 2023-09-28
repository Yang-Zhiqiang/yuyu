package yuyu.common.biz.validation;

import java.util.regex.Pattern;

import yuyu.common.biz.bzcommon.MousikomiNoCheck;

/**
 * 申込番号バリデーション用コールバッククラスです。
 */
public class RayMousikomiNoCallback extends yuyu.infr.validation.constraintvalidators.callback.MousikomiNoCallback {

    private static final Pattern reg = Pattern.compile("^[a-zA-Z0-9]{1,9}$");

    @Override
    public boolean check(String s){

        if(s == null || s.length() == 0)
         {
            return true;
        }

        if(reg.matcher(s).find()){
            if(MousikomiNoCheck.isValid(s)){
                return true;
            }
        }
        return false;
    }
}
