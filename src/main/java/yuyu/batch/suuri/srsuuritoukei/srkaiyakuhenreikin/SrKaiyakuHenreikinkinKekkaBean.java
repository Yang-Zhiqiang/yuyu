package yuyu.batch.suuri.srsuuritoukei.srkaiyakuhenreikin;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.hozen.khcommon.KeisanW;

/**
 * 当機能で必要な任意のオブジェクトを保持するBeanクラス
 */
public class SrKaiyakuHenreikinkinKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean resultFlg;

    private KeisanW keisanW;

    private BizNumber sjkkktyouseiyouriritu;

    public SrKaiyakuHenreikinkinKekkaBean() {

        resultFlg = false;
        sjkkktyouseiyouriritu = BizNumber.valueOf(0);
    }

    public boolean isResultFlg() {
        return resultFlg;
    }

    public void setResultFlg(boolean pResultFlg) {
        this.resultFlg = pResultFlg;
    }

    public KeisanW getKeisanW() {
        return keisanW;
    }

    public void setKeisanW(KeisanW pKeisanW) {
        this.keisanW = pKeisanW;
    }

    public BizNumber getSjkkktyouseiyouriritu() {
        return sjkkktyouseiyouriritu;
    }

    public void setSjkkktyouseiyouriritu(BizNumber pSjkkktyouseiyouriritu) {
        this.sjkkktyouseiyouriritu = pSjkkktyouseiyouriritu;
    }

}