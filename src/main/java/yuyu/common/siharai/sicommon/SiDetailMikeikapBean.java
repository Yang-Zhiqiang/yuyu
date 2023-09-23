package yuyu.common.siharai.sicommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 保険金給付金支払 保険金給付金支払共通 明細未経過保険料Bean
 */
public class SiDetailMikeikapBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency dtlmikeikap;

    private BizCurrency dtlmikeikapgaika;

    private BizDate dtlmikeikapnykdenymd;

    private C_Hrkkaisuu dtlmikeikaphrkkaisuu;

    private Integer dtlmikeikapjyutoukaisuuy;

    private Integer dtlmikeikapjyutoukaisuum;

    private BizDateYM dtlmikeikapjyuutouym;

    public SiDetailMikeikapBean() {
        dtlmikeikap = BizCurrency.valueOf(0);
        dtlmikeikapgaika = BizCurrency.valueOf(0);
        dtlmikeikapnykdenymd = null;
        dtlmikeikaphrkkaisuu = C_Hrkkaisuu.BLNK;
        dtlmikeikapjyutoukaisuuy = 0;
        dtlmikeikapjyutoukaisuum = 0;
        dtlmikeikapjyuutouym = null;
    }

    public BizCurrency getDtlmikeikap() {
        return dtlmikeikap;
    }

    public void setDtlmikeikap(BizCurrency pDtlmikeikap) {
        this.dtlmikeikap = pDtlmikeikap;
    }

    public BizCurrency getDtlmikeikapgaika() {
        return dtlmikeikapgaika;
    }

    public void setDtlmikeikapgaika(BizCurrency pDtlmikeikapgaika) {
        this.dtlmikeikapgaika = pDtlmikeikapgaika;
    }

    public BizDate getDtlmikeikapnykdenymd() {
        return dtlmikeikapnykdenymd;
    }

    public void setDtlmikeikapnykdenymd(BizDate pDtlmikeikapnykdenymd) {
        this.dtlmikeikapnykdenymd = pDtlmikeikapnykdenymd;
    }

    public C_Hrkkaisuu getDtlmikeikaphrkkaisuu() {
        return dtlmikeikaphrkkaisuu;
    }

    public void setDtlmikeikaphrkkaisuu(C_Hrkkaisuu pDtlmikeikaphrkkaisuu) {
        this.dtlmikeikaphrkkaisuu = pDtlmikeikaphrkkaisuu;
    }

    public Integer getDtlmikeikapjyutoukaisuuy() {
        return dtlmikeikapjyutoukaisuuy;
    }

    public void setDtlmikeikapjyutoukaisuuy(Integer pDtlmikeikapjyutoukaisuuy) {
        this.dtlmikeikapjyutoukaisuuy = pDtlmikeikapjyutoukaisuuy;
    }

    public Integer getDtlmikeikapjyutoukaisuum() {
        return dtlmikeikapjyutoukaisuum;
    }

    public void setDtlmikeikapjyutoukaisuum(Integer pDtlmikeikapjyutoukaisuum) {
        this.dtlmikeikapjyutoukaisuum = pDtlmikeikapjyutoukaisuum;
    }

    public BizDateYM getDtlmikeikapjyuutouym() {
        return dtlmikeikapjyuutouym;
    }

    public void setDtlmikeikapjyuutouym(BizDateYM pDtlmikeikapjyuutouym) {
        this.dtlmikeikapjyuutouym = pDtlmikeikapjyuutouym;
    }

}
