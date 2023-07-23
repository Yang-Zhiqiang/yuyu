package yuyu.infr.processor;

import javax.inject.Singleton;

import jp.co.slcs.swak.core.accesslog.AccessLog;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.web.filter.RequestLogFilter.RequestLogProps;
import jp.co.slcs.swak.web.filter.RequestLogFilter.RequestResultCode;
import jp.co.slcs.swak.web.processor.Preprocessor;
import yuyu.infr.exception.OutOfSystemUpTimeException;

@Singleton
public class YuyuPreprocessor extends Preprocessor {

    @Override
    protected void perform() {

        OnlineKadouCheck onlineKadouCheck = SWAKInjector.getInstance(OnlineKadouCheck.class);
        if (!onlineKadouCheck.isOnlineKadouOnOnline()) {
            AccessLog.KadouTimePast.log();
            RequestLogProps props = SWAKInjector.getInstance(RequestLogProps.class);
            props.setResultCode(RequestResultCode.LogicException);
            props.setForwardName("Exception:OutOfSystemUpTimeException");
            throw new OutOfSystemUpTimeException();
        }

        InvalidFunctionCheck invalidFunctionCheck = SWAKInjector.getInstance(InvalidFunctionCheck.class);
        invalidFunctionCheck.process();
    }
}
