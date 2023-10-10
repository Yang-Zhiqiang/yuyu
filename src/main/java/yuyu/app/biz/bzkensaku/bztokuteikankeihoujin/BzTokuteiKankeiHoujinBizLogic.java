package yuyu.app.biz.bzkensaku.bztokuteikankeihoujin;

import javax.inject.Inject;

import org.slf4j.Logger;

/**
 * 特定関係法人照会 のビジネスロジックです。
 */
public class BzTokuteiKankeiHoujinBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzTokuteiKankeiHoujinUiBean uiBean;

    void init() {
        clear();
    }

    void clear() {
    }
}
