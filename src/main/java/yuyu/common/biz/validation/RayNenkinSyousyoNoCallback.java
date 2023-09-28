package yuyu.common.biz.validation;

import java.util.regex.Pattern;

import yuyu.common.biz.bzcommon.SyokenNoCheck;

/**
 * 年金証書番号バリデーション用コールバッククラスです。
 */
public class RayNenkinSyousyoNoCallback extends yuyu.infr.validation.constraintvalidators.callback.NenkinSyousyoNoCallback {

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
