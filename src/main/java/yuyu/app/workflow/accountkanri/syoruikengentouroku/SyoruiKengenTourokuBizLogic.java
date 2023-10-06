package yuyu.app.workflow.accountkanri.syoruikengentouroku;

import javax.inject.Inject;
import org.slf4j.Logger;

/**
 * 書類権限登録 のビジネスロジックです。
 */
public class SyoruiKengenTourokuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SyoruiKengenTourokuUiBean uiBean;

    void init() {
        clear();
    }

    void clear() {
    }
}
