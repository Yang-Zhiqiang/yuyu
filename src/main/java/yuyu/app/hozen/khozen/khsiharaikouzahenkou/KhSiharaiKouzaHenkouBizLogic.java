package yuyu.app.hozen.khozen.khsiharaikouzahenkou;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * 支払口座情報変更 のビジネスロジックです。
 */
public class KhSiharaiKouzaHenkouBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhSiharaiKouzaHenkouUiBean uiBean;

    void init() {
        clear();
    }

    void clear() {
    }
}
