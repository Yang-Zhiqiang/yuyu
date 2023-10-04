package yuyu.batch.hozen.khinterf.khoudrtenminyuukykdtlfsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_IkkatubaraiKbn;

/**
 * 契約保全 インターフェイス 代理店未入契約明細内容Bean
 */
public class DrtenMinyuKykNaiyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate keiyakuYmd;

    @Getter @Setter
    private BizDateYM bosyuuYM;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaiSuu;

    @Getter @Setter
    private C_Hrkkeiro hrkKeiro;

    @Getter @Setter
    private String mrariHyj;

    @Getter @Setter
    private String keizokuTyuuihyj;

    @Getter @Setter
    private String syouhnnMkbn;

    @Getter @Setter
    private BizDateYM jkipjytYM;

    @Getter @Setter
    private C_BosyuuDairitenAtkiKeitaiKbn bosyuudairiTenatkikeitaiKbn;

    @Getter @Setter
    private String syuuKeikbn;

    @Getter @Setter
    private Integer minyuKaisuu;

    @Getter @Setter
    private BizCurrency misyuUp;

    @Getter @Setter
    private BizCurrency hsyS;

    @Getter @Setter
    private BizCurrency syuuseiS;

    @Getter @Setter
    private String hukkatuTyuuiKbn;

    @Getter @Setter
    private String fstttKekykhyj;

    @Getter @Setter
    private Integer ttkernzkKaisuu;

    @Getter @Setter
    private String syouhinBunruiKbn;

    @Getter @Setter
    private String hknsyuKigou;

    @Getter @Setter
    private C_HurihunoKbn huriHunoKbn;

    @Getter @Setter
    private String autocallKykhyj;

    @Getter @Setter
    private String dairiTencd1;

    @Getter @Setter
    private String dairiTencd2;

    @Getter @Setter
    private C_IkkatubaraiKbn ikkaTubaraiKbn;

    @Getter @Setter
    private C_IkkatubaraiKaisuuKbn ikkatubaraiKaiSuu;

    public DrtenMinyuKykNaiyouBean(
        String pKbnkey,
        String pSyono,
        BizDate pSyoriYM,
        BizDateYM pBosyuuYM,
        C_Hrkkaisuu pHrkkaiSuu,
        C_Hrkkeiro pHrkKeiro,
        String pMrariHyj,
        String pKeizokuTyuuihyj,
        String pSyouhnnMkbn,
        BizDateYM pJkipjytym,
        C_BosyuuDairitenAtkiKeitaiKbn pBosyuudairiTenatkikeitaiKbn,
        String pSyuuKeikbn,
        Integer pMinyuKaisuu,
        String pMisyuUpType,
        BigDecimal pMisyuUpValue,
        String pHsySType,
        BigDecimal pHsySValue,
        String pSyuuseiSType,
        BigDecimal pSyuuseiSValue,
        String pHukkatuTyuuiKbn,
        String pFstttKekykhyj,
        Integer pTtkernzkKaisuu,
        String pSyouhinBunruiKbn,
        String pHknsyuKigou,
        C_HurihunoKbn pHuriHunoKbn,
        String pAutocallKykhyj,
        String pDairiTencd1,
        String pDairiTencd2,
        C_IkkatubaraiKbn pIkkaTubaraiKbn,
        C_IkkatubaraiKaisuuKbn pIkkatubaraiKaiSuu) {

        kbnkey = pKbnkey;

        syono = pSyono;

        keiyakuYmd = pSyoriYM;

        bosyuuYM = pBosyuuYM;

        hrkkaiSuu = pHrkkaiSuu;

        hrkKeiro = pHrkKeiro;

        mrariHyj = pMrariHyj;

        keizokuTyuuihyj = pKeizokuTyuuihyj;

        syouhnnMkbn = pSyouhnnMkbn;

        jkipjytYM = pJkipjytym;

        bosyuudairiTenatkikeitaiKbn = pBosyuudairiTenatkikeitaiKbn;

        syuuKeikbn = pSyuuKeikbn;

        minyuKaisuu = pMinyuKaisuu;

        misyuUp = new BizCurrencySum(pMisyuUpType, pMisyuUpValue).toBizCurrency();

        hsyS = new BizCurrencySum(pHsySType, pHsySValue).toBizCurrency();

        syuuseiS = new BizCurrencySum(pSyuuseiSType, pSyuuseiSValue).toBizCurrency();

        hukkatuTyuuiKbn = pHukkatuTyuuiKbn;

        fstttKekykhyj = pFstttKekykhyj;

        ttkernzkKaisuu = pTtkernzkKaisuu;

        syouhinBunruiKbn = pSyouhinBunruiKbn;

        hknsyuKigou = pHknsyuKigou;

        huriHunoKbn = pHuriHunoKbn;

        autocallKykhyj = pAutocallKykhyj;

        dairiTencd1 = pDairiTencd1;

        dairiTencd2 = pDairiTencd2;

        ikkaTubaraiKbn = pIkkaTubaraiKbn;

        ikkatubaraiKaiSuu = pIkkatubaraiKaiSuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}