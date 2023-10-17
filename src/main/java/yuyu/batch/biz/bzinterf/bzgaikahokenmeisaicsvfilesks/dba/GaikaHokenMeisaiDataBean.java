package yuyu.batch.biz.bzinterf.bzgaikahokenmeisaicsvfilesks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 業務共通 インターフェース 外貨建保険明細データBeanクラス
 */
public class GaikaHokenMeisaiDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private C_DensysKbn densyskbn;

    @Getter
    @Setter
    private String denrenno;

    @Getter
    @Setter
    private Integer edano;

    @Getter
    @Setter
    private String keirisyono;

    @Getter
    @Setter
    private BizDate denymd;

    @Getter
    @Setter
    private C_TaisyakuKbn taisyakukbn;

    @Getter
    @Setter
    private C_Kanjyoukmkcd kanjyoukmkcd;

    @Getter
    @Setter
    private String suitoubumoncd;

    @Getter
    @Setter
    private C_Tuukasyu tuukasyu;

    @Getter
    @Setter
    private BizCurrency dengaikagk;

    @Getter
    @Setter
    private BizNumber denkawaserate;

    @Getter
    @Setter
    private BizCurrency denyenkagk;

    @Getter
    @Setter
    private BizDate syoriYmd;

    @Getter
    @Setter
    private String syoricd;

    @Getter
    @Setter
    private C_KessantyouseiKbn kessantyouseikbn;

    @Getter
    @Setter
    private C_DensyoriKbn densyorikbn;

    @Getter
    @Setter
    private BizDate kykymd;

    @Getter
    @Setter
    private Integer syouhnsdno;

    @Getter
    @Setter
    private BizDate sknnkaisiymd;

    @Getter
    @Setter
    private BizDate mosymd;

    @Getter
    @Setter
    private BizDate fstpryosyuymd;

    @Getter
    @Setter
    private C_Tuukasyu kyktuukasyu;

    @Getter
    @Setter
    private BizCurrency keiyakutuukagk;

    public GaikaHokenMeisaiDataBean() {
    }
    public GaikaHokenMeisaiDataBean(C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano,
        String pKeirisyono,
        BizDate pDenymd,
        C_TaisyakuKbn pTaisyakukbn,
        C_Kanjyoukmkcd pKanjyoukmkcd,
        String pSuitoubumoncd,
        C_Tuukasyu pTuukasyu,
        String pDengaikagkType,
        BigDecimal pDengaikagkValue,
        BizNumber pDenkawaserate,
        String pDenyenkagkType,
        BigDecimal pDenyenkagkValue,
        BizDate pSyoriYmd,
        String pSyoricd,
        C_KessantyouseiKbn pKessantyouseikbn,
        C_DensyoriKbn pDensyorikbn,
        BizDate pKykymd,
        Integer pSyouhnsdno,
        BizDate pSknnkaisiymd,
        BizDate pMosymd,
        BizDate pFstpryosyuymd,
        C_Tuukasyu pKyktuukasyu,
        String pKeiyakutuukagkType,
        BigDecimal pKeiyakutuukagkValue) {
        densyskbn = pDensyskbn;
        denrenno = pDenrenno;
        edano = pEdano;
        keirisyono = pKeirisyono;
        denymd = pDenymd;
        taisyakukbn = pTaisyakukbn;
        kanjyoukmkcd = pKanjyoukmkcd;
        suitoubumoncd = pSuitoubumoncd;
        tuukasyu = pTuukasyu;
        dengaikagk = new BizCurrencySum(pDengaikagkType, pDengaikagkValue).toBizCurrency();
        denkawaserate = pDenkawaserate;
        denyenkagk = new BizCurrencySum(pDenyenkagkType, pDenyenkagkValue).toBizCurrency();
        syoriYmd = pSyoriYmd;
        syoricd = pSyoricd;
        kessantyouseikbn = pKessantyouseikbn;
        densyorikbn = pDensyorikbn;
        kykymd = pKykymd;
        syouhnsdno = pSyouhnsdno;
        sknnkaisiymd = pSknnkaisiymd;
        mosymd = pMosymd;
        fstpryosyuymd = pFstpryosyuymd;
        kyktuukasyu = pKyktuukasyu;
        keiyakutuukagk = new BizCurrencySum(pKeiyakutuukagkType, pKeiyakutuukagkValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
