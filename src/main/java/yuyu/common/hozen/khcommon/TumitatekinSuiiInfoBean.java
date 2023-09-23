package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

/**
 * 契約保全 契約保全共通 積立金推移情報Beanクラス
 * 仮ソース
 */
public class TumitatekinSuiiInfoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDateYM kijyunym;

    private BizDate calckijyunymd;

    private BizNumber kawaserate;

    private BizCurrency ptumitatekngkgaika;

    private BizCurrency ptumitatekngkyen;

    private BizCurrency kaiyakuhrgaika;

    private BizCurrency kaiyakuhryen;

    public BizDateYM getKijyunym() {
        return this.kijyunym;
    }

    public void setKijyunym(BizDateYM pKijyunym) {
        this.kijyunym = pKijyunym;
    }

    public BizDate getCalckijyunymd() {
        return this.calckijyunymd;
    }

    public void setCalckijyunymd(BizDate pCalckijyunymd) {
        this.calckijyunymd = pCalckijyunymd;
    }

    public BizNumber getKawaserate() {
        return this.kawaserate;
    }

    public void setKawaserate(BizNumber pKawaserate) {
        this.kawaserate = pKawaserate;
    }

    public BizCurrency getPtumitatekngkgaika() {
        return this.ptumitatekngkgaika;
    }

    public void setPtumitatekngkgaika(BizCurrency pPtumitatekngkgaika) {
        this.ptumitatekngkgaika = pPtumitatekngkgaika;
    }

    public BizCurrency getPtumitatekngkyen() {
        return this.ptumitatekngkyen;
    }

    public void setPtumitatekngkyen(BizCurrency pPtumitatekngkyen) {
        this.ptumitatekngkyen = pPtumitatekngkyen;
    }

    public BizCurrency getKaiyakuhrgaika() {
        return this.kaiyakuhrgaika;
    }

    public void setKaiyakuhrgaika(BizCurrency pKaiyakuhrgaika) {
        this.kaiyakuhrgaika = pKaiyakuhrgaika;
    }

    public BizCurrency getKaiyakuhryen() {
        return this.kaiyakuhryen;
    }

    public void setKaiyakuhryen(BizCurrency pKaiyakuhryen) {
        this.kaiyakuhryen = pKaiyakuhryen;
    }
}
