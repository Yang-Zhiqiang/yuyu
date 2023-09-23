package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;


/**
 * 契約保全 契約保全共通 案内日設定
 */
public class SetAnnaibi {

    private BizDate seijyouAnnaibi = null;

    private BizDate tinyuuAnnaibi = null;

    public SetAnnaibi() {
        super();
    }

    public BizDate getSeijyouAnnaibi() {
        return seijyouAnnaibi;
    }

    public BizDate getTinyuuAnnaibi() {
        return tinyuuAnnaibi;
    }

    public void exec(BizDateYM pJyutouym) {

        SetHurikaebi setHurikaebi = SWAKInjector.getInstance(SetHurikaebi.class);
        setHurikaebi.exec(BizDate.valueOf(pJyutouym, 1).getNextMonth());
        seijyouAnnaibi = setHurikaebi.getTyokuzenAnnaibi();
        tinyuuAnnaibi = setHurikaebi.getTyokugoAnnaibi();
    }
}
