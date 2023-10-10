package yuyu.app.hozen.khozen.khnaiyoukakunin;

import static yuyu.app.hozen.khozen.khnaiyoukakunin.KhNaiyouKakuninConstants.*;

import javax.inject.Inject;
import org.slf4j.Logger;

/**
 * 契約保全内容確認 のビジネスロジックです。
 */
public class KhNaiyouKakuninBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhNaiyouKakuninUiBean uiBean;

    void init() {
        clear();
    }

    void clear() {
    }
}
