package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_TsindousiteiKbn;

/**
 * 契約保全 契約保全共通 登録家族直送判定Beanクラス
 */
public class TrkkzkTyokusouhtBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate kijyunymd;

    private BizDate kykseiymd;

    private C_TsindousiteiKbn trkkzktsindousiteikbn;

    public BizDate getKijyunymd() {
        return kijyunymd;
    }

    public void setKijyunymd(BizDate pKijyunymd) {
        this.kijyunymd = pKijyunymd;
    }

    public BizDate getKykseiymd() {
        return kykseiymd;
    }

    public void setKykseiymd(BizDate pKykseiymd) {
        this.kykseiymd = pKykseiymd;
    }

    public C_TsindousiteiKbn getTrkkzktsindousiteikbn() {
        return trkkzktsindousiteikbn;
    }

    public void setTrkkzktsindousiteikbn(C_TsindousiteiKbn pTrkkzktsindousiteikbn) {
        this.trkkzktsindousiteikbn = pTrkkzktsindousiteikbn;
    }
}
