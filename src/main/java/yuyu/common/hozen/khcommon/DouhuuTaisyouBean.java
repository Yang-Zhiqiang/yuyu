package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;

/**
 * 契約保全 契約保全共通 同封対象者Beanクラス<br />
 */
public class DouhuuTaisyouBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private C_TuutisakuseitaisyouKbn tuutiSakuseiTaisyouKbn;

    private C_TrkKzkKbn trkKzkKbn;

    private String nmkj;

    public DouhuuTaisyouBean() {
        super();
    }

    public C_TuutisakuseitaisyouKbn getTuutiSakuseiTaisyouKbn() {
        return tuutiSakuseiTaisyouKbn;
    }

    public void setTuutiSakuseiTaisyouKbn(C_TuutisakuseitaisyouKbn pTuutiSakuseiTaisyouKbn) {
        tuutiSakuseiTaisyouKbn = pTuutiSakuseiTaisyouKbn;
    }

    public C_TrkKzkKbn getTrkKzkKbn() {
        return trkKzkKbn;
    }

    public void setTrkKzkKbn(C_TrkKzkKbn pTrkKzkKbn) {
        trkKzkKbn = pTrkKzkKbn;
    }

    public String getNmkj() {
        return nmkj;
    }

    public void setNmkj(String pNmkj) {
        nmkj = pNmkj;
    }
}
