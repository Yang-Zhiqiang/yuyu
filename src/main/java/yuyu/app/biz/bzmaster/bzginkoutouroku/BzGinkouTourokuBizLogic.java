package yuyu.app.biz.bzmaster.bzginkoutouroku;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * 銀行登録 のビジネスロジックです。
 */
public class BzGinkouTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzGinkouTourokuUiBean uiBean;

    void init() {
        clear();
    }

    void clear() {
    }
}
