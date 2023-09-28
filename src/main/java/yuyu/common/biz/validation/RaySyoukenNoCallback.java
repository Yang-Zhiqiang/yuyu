package yuyu.common.biz.validation;

import java.util.regex.Pattern;

import yuyu.common.biz.bzcommon.SyokenNoCheck;

/**
 * 証券番号バリデーション用コールバッククラスです。
 */
public class RaySyoukenNoCallback extends yuyu.infr.validation.constraintvalidators.callback.SyoukenNoCallback {

    private static final Pattern reg = Pattern.compile("^[a-zA-Z0-9]{1,11}$");

    @Override
    public boolean check(String s){

        if(s == null || s.length() == 0)
         {
            return true;
        }

        if(reg.matcher(s).find()){
            if(SyokenNoCheck.isValid(s)){
                return true;
            }
        }
        return false;
    }
}
