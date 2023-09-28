package yuyu.common.biz.validation;

import yuyu.common.biz.bzcommon.SkjStringUtil;
import yuyu.infr.validation.constraintvalidators.callback.InvalidCharacterCallback;


/**
 * 入力不可文字バリデーション用コールバック実装クラスです。
 */
public class RayInvalidCharacterCallback extends InvalidCharacterCallback{

    @Override
    public boolean check(String s){
        return SkjStringUtil.skjChk(s);
    }

}
