package yuyu.batch.hozen.khinterf.khhokenkykidoufiletyusyutu;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;

/**
 * 指数定率金額計算内部Beanクラス<br/>
 */
public class SisuuTeirituKinngakuKsBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency sisuuKihonS = BizCurrency.valueOf(0);

    private BizCurrency sisuuP = BizCurrency.valueOf(0);

    private BizCurrency sisuuKaiyakuhr = BizCurrency.valueOf(0);

    private BizCurrency teirituKihonS = BizCurrency.valueOf(0);

    private BizCurrency teirituP = BizCurrency.valueOf(0);

    private BizCurrency teirituKaiyakuhr = BizCurrency.valueOf(0);

    public BizCurrency getSisuuKihonS() {
        return sisuuKihonS;
    }

    public void setSisuuKihonS(BizCurrency pSisuuKihonS) {
        this.sisuuKihonS = pSisuuKihonS;
    }

    public BizCurrency getSisuuP() {
        return sisuuP;
    }

    public void setSisuuP(BizCurrency pSisuuP) {
        this.sisuuP = pSisuuP;
    }

    public BizCurrency getSisuuKaiyakuhr() {
        return sisuuKaiyakuhr;
    }

    public void setSisuuKaiyakuhr(BizCurrency pSisuuKaiyakuhr) {
        this.sisuuKaiyakuhr = pSisuuKaiyakuhr;
    }

    public BizCurrency getTeirituKihonS() {
        return teirituKihonS;
    }

    public void setTeirituKihonS(BizCurrency pTeirituKihonS) {
        this.teirituKihonS = pTeirituKihonS;
    }

    public BizCurrency getTeirituP() {
        return teirituP;
    }

    public void setTeirituP(BizCurrency pTeirituP) {
        this.teirituP = pTeirituP;
    }

    public BizCurrency getTeirituKaiyakuhr() {
        return teirituKaiyakuhr;
    }

    public void setTeirituKaiyakuhr(BizCurrency pTeirituKaiyakuhr) {
        this.teirituKaiyakuhr = pTeirituKaiyakuhr;
    }
}
