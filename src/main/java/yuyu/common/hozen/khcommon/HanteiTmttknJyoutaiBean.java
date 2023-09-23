package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約保全 契約保全共通 積立金状態判定Beanクラス
 */
public class HanteiTmttknJyoutaiBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String syono;

    private BizDate hanteiKijyunymd;

    private BizDate kykymd;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    public BizDate getHanteiKijyunymd() {
        return hanteiKijyunymd;
    }

    public void setHanteiKijyunymd(BizDate pHanteiKijyunymd) {
        hanteiKijyunymd = pHanteiKijyunymd;
    }

    public BizDate getKykymd() {
        return kykymd;
    }

    public void setKykymd(BizDate pKykymd) {
        kykymd = pKykymd;
    }
}
