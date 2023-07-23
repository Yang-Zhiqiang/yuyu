package yuyu.infr.processor;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.filter.RequestLogFilter.RequestLogProps;
import jp.co.slcs.swak.web.filter.RequestLogFilter.RequestResultCode;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.infr.common.invalidfunctioncheck.InvalidFunctionChecker;
import yuyu.infr.exception.InvalidFunctionException;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 機能有効チェッククラス<br />
 * 機能モード期間テーブルの有効区分　および　有効開始日を参照し、<br />
 * 実行中機能が有効であるかをチェックします。<br />
 */
@Singleton
class InvalidFunctionCheck {

    void process() {
        AS_Kinou kinou = SWAKInjector.getInstance(AS_Kinou.class);
        KinouMode kinouMode = SWAKInjector.getInstance(KinouMode.class);
        AS_KinouMode kinouModeTable = kinou.getKinouMode(kinouMode.getKinouMode());

        if (!InvalidFunctionChecker.isValid(kinou, kinouModeTable)) {
            RequestLogProps props = SWAKInjector.getInstance(RequestLogProps.class);
            props.setResultCode(RequestResultCode.LogicException);
            props.setForwardName("Exception:InvalidFunctionException");

            throw new InvalidFunctionException();
        }
    }

}
