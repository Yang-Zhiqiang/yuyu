package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_DispKbn;

/**
 * 契約保全 契約保全共通 控除証明額計算結果Beanクラス
 */
public class KjsymgkKsnKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency koujyosyoumeigk;

    private C_DispKbn  keisanhukahyoujikbn ;

    private String keisanhukariyuucd;

    public void setKoujyosyoumeigk(BizCurrency pKoujyosyoumeigk) {
        this.koujyosyoumeigk = pKoujyosyoumeigk;
    }

    public BizCurrency getKoujyosyoumeigk() {
        return this.koujyosyoumeigk;
    }

    public void setKeisanhukahyoujikbn(C_DispKbn pKeisanhukahyoujikbn) {
        this.keisanhukahyoujikbn = pKeisanhukahyoujikbn;
    }

    public C_DispKbn getKeisanhukahyoujikbn() {
        return this.keisanhukahyoujikbn;
    }

    public void setKeisanhukariyuucd(String pKeisanhukariyuucd) {
        this.keisanhukariyuucd = pKeisanhukariyuucd;
    }

    public String getKeisanhukariyuucd() {
        return this.keisanhukariyuucd;
    }
}
