package yuyu.app.hozen.khozen.khkeiyakuhenkou;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * 契約変更 のビジネスロジックです。
 */
public class KhKeiyakuHenkouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhKeiyakuHenkouUiBean uiBean;

    void init() {
        clear();
    }

    void clear() {
    }
}
