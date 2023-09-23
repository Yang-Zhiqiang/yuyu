package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Kaiyakujiyuu;

/**
 * 契約保全 契約保全共通 解約共通計算Beanクラス
 */
public class KeisanKaiyakuBean {

    private BizDate syoruiukeymd;

    private BizDate kaiykymd;

    private BizNumber yenshrkwsrate;

    private BizNumber gkshrkwsrate;

    private C_Kaiyakujiyuu kaiyakujiyuu;


    public BizDate getSyoruiukeymd() {
        return syoruiukeymd;
    }

    public void setSyoruiukeymd(BizDate pSyoruiukeymd) {
        this.syoruiukeymd = pSyoruiukeymd;
    }

    public BizDate getKaiykymd() {
        return kaiykymd;
    }

    public void setKaiykymd(BizDate pKaiykymd) {
        this.kaiykymd = pKaiykymd;
    }

    public BizNumber getYenshrkwsrate() {
        return yenshrkwsrate;
    }

    public void setYenshrkwsrate(BizNumber pYenshrkwsrate) {
        this.yenshrkwsrate = pYenshrkwsrate;
    }

    public BizNumber getGkshrkwsrate() {
        return gkshrkwsrate;
    }

    public void setGkshrkwsrate(BizNumber pGkshrkwsrate) {
        this.gkshrkwsrate = pGkshrkwsrate;
    }

    public C_Kaiyakujiyuu getKaiyakujiyuu() {
        return kaiyakujiyuu;
    }

    public void setKaiyakujiyuu(C_Kaiyakujiyuu pKaiyakujiyuu) {
        this.kaiyakujiyuu = pKaiyakujiyuu;
    }

}
