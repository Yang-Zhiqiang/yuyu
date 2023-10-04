package yuyu.batch.hozen.khinterf.khhokenkykidoufiletyusyutu;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 解約返戻金データ作成内部Beanクラス<br/>
 */
public class KaiyakuHenreikinDataSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency ssyPTumitatekin = BizCurrency.valueOf(0);

    private BizCurrency ssyKaiyakuhr = BizCurrency.valueOf(0);

    private BizCurrency ssySisuuRendouTmttkngk = BizCurrency.valueOf(0);

    private BizCurrency ssyTeirituTmttkngk = BizCurrency.valueOf(0);

    public BizCurrency getSsyPTumitatekin() {
        return ssyPTumitatekin;
    }

    public void setSsyPTumitatekin(BizCurrency pSsyPTumitatekin) {
        this.ssyPTumitatekin = pSsyPTumitatekin;
    }

    public BizCurrency getSsyKaiyakuhr() {
        return ssyKaiyakuhr;
    }

    public void setSsyKaiyakuhr(BizCurrency pSsyKaiyakuhr) {
        this.ssyKaiyakuhr = pSsyKaiyakuhr;
    }

    public BizCurrency getSsySisuuRendouTmttkngk() {
        return ssySisuuRendouTmttkngk;
    }

    public void setSsySisuuRendouTmttkngk(BizCurrency pSsySisuuRendouTmttkngk) {
        this.ssySisuuRendouTmttkngk = pSsySisuuRendouTmttkngk;
    }

    public BizCurrency getSsyTeirituTmttkngk() {
        return ssyTeirituTmttkngk;
    }

    public void setSsyTeirituTmttkngk(BizCurrency pSsyTeirituTmttkngk) {
        this.ssyTeirituTmttkngk = pSsyTeirituTmttkngk;
    }
}
