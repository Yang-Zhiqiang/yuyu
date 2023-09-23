package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 案内収納共通 一括入金額計算結果内訳Bean
 */
public class KeisanTukiIkkatuNyuukinGkUtiwakeBean {

    private C_NyknaiyouKbn nyknaiyouKbn;

    private BizDateYM jyutoustartYm;

    private Integer jyuutoutuKisuu;

    private BizCurrency rskingaku;

    private BizDate ryosyuKwsRateKjYmd;

    private BizNumber ryosyuKwsRate;

    private C_UmuKbn iktnyuukinnUmu;

    private BizCurrency iktwaribikikgk;

    public C_NyknaiyouKbn getNyknaiyouKbn() {
        return nyknaiyouKbn;
    }

    public void setNyknaiyouKbn(C_NyknaiyouKbn pNyknaiyouKbn) {
        this.nyknaiyouKbn = pNyknaiyouKbn;
    }

    public BizDateYM getJyutoustartYm() {
        return jyutoustartYm;
    }

    public void setJyutoustartYm(BizDateYM pJyutoustartYm) {
        this.jyutoustartYm = pJyutoustartYm;
    }

    public Integer getJyuutoutuKisuu() {
        return jyuutoutuKisuu;
    }

    public void setJyuutoutuKisuu(Integer pJyuutoutuKisuu) {
        this.jyuutoutuKisuu = pJyuutoutuKisuu;
    }

    public BizCurrency getRskingaku() {
        return rskingaku;
    }

    public void setRskingaku(BizCurrency pRskingaku) {
        this.rskingaku = pRskingaku;
    }

    public BizDate getRyosyuKwsRateKjYmd() {
        return ryosyuKwsRateKjYmd;
    }

    public void setRyosyuKwsRateKjYmd(BizDate pRyosyuKwsRateKjYmd) {
        this.ryosyuKwsRateKjYmd = pRyosyuKwsRateKjYmd;
    }

    public BizNumber getRyosyuKwsRate() {
        return ryosyuKwsRate;
    }

    public void setRyosyuKwsRate(BizNumber pRyosyuKwsRate) {
        this.ryosyuKwsRate = pRyosyuKwsRate;
    }

    public C_UmuKbn getIktnyuukinnUmu() {
        return iktnyuukinnUmu;
    }

    public void setIktnyuukinnUmu(C_UmuKbn pIktnyuukinnUmu) {
        this.iktnyuukinnUmu = pIktnyuukinnUmu;
    }

    public BizCurrency getIktwaribikikgk() {
        return iktwaribikikgk;
    }

    public void setIktwaribikikgk(BizCurrency pIktwaribikikgk) {
        this.iktwaribikikgk = pIktwaribikikgk;
    }
}
