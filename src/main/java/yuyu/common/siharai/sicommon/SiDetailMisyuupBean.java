package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 保険金給付金支払共通 明細未収保険料Bean
 */
public class SiDetailMisyuupBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency dtlmisyuup;

    private BizCurrency dtlmisyuupgaika;

    private BizCurrency dtlmisyuupgaikayenkingk;

    private C_UmuKbn dtlmisyuupiktnyuukinnumu;

    private C_Hrkkaisuu dtlmisyuuphrkkaisuu;

    private Integer dtlmisyuupjyutoukaisuuy;

    private Integer dtlmisyuupjyutoukaisuum;

    private BizDateYM dtlmisyuupjyuutouym;

    public SiDetailMisyuupBean() {
        dtlmisyuup = BizCurrency.valueOf(0);
        dtlmisyuupgaika = BizCurrency.valueOf(0);
        dtlmisyuupgaikayenkingk = BizCurrency.valueOf(0);
        dtlmisyuupiktnyuukinnumu = C_UmuKbn.NONE;
        dtlmisyuuphrkkaisuu = C_Hrkkaisuu.BLNK;
        dtlmisyuupjyutoukaisuuy = 0;
        dtlmisyuupjyutoukaisuum = 0;
        dtlmisyuupjyuutouym = null;
    }

    public BizCurrency getDtlmisyuup() {
        return dtlmisyuup;
    }

    public void setDtlmisyuup(BizCurrency pDtlmisyuup) {
        dtlmisyuup = pDtlmisyuup;
    }

    public BizCurrency getDtlmisyuupgaika() {
        return dtlmisyuupgaika;
    }

    public void setDtlmisyuupgaika(BizCurrency pDtlmisyuupgaika) {
        dtlmisyuupgaika = pDtlmisyuupgaika;
    }

    public BizCurrency getDtlmisyuupgaikayenkingk() {
        return dtlmisyuupgaikayenkingk;
    }

    public void setDtlmisyuupgaikayenkingk(BizCurrency pDtlmisyuupgaikayenkingk) {
        dtlmisyuupgaikayenkingk = pDtlmisyuupgaikayenkingk;
    }

    public C_UmuKbn getDtlmisyuupiktnyuukinnumu() {
        return dtlmisyuupiktnyuukinnumu;
    }

    public void setDtlmisyuupiktnyuukinnumu(C_UmuKbn pDtlmisyuupiktnyuukinnumu) {
        dtlmisyuupiktnyuukinnumu = pDtlmisyuupiktnyuukinnumu;
    }

    public C_Hrkkaisuu getDtlmisyuuphrkkaisuu() {
        return dtlmisyuuphrkkaisuu;
    }

    public void setDtlmisyuuphrkkaisuu(C_Hrkkaisuu pDtlmisyuuphrkkaisuu) {
        dtlmisyuuphrkkaisuu = pDtlmisyuuphrkkaisuu;
    }

    public Integer getDtlmisyuupjyutoukaisuuy() {
        return dtlmisyuupjyutoukaisuuy;
    }

    public void setDtlmisyuupjyutoukaisuuy(Integer pDtlmisyuupjyutoukaisuuy) {
        dtlmisyuupjyutoukaisuuy = pDtlmisyuupjyutoukaisuuy;
    }

    public Integer getDtlmisyuupjyutoukaisuum() {
        return dtlmisyuupjyutoukaisuum;
    }

    public void setDtlmisyuupjyutoukaisuum(Integer pDtlmisyuupjyutoukaisuum) {
        dtlmisyuupjyutoukaisuum = pDtlmisyuupjyutoukaisuum;
    }

    public BizDateYM getDtlmisyuupjyuutouym() {
        return dtlmisyuupjyuutouym;
    }

    public void setDtlmisyuupjyuutouym(BizDateYM pDtlmisyuupjyuutouym) {
        dtlmisyuupjyuutouym = pDtlmisyuupjyuutouym;
    }

}
