package yuyu.batch.hozen.khinterf.khseisandhaneituutisks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;

/**
 * 精算Ｄ反映通知作成Beanクラス<br />
 */
public class KhSeisanDhaneiTuutiSksBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey ;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDateY haitounendo;

    @Getter @Setter
    private BizCurrency kakuteitounendod;

    @Getter @Setter
    private BizCurrency naiteitounendod;

    @Getter @Setter
    private BizCurrency seisandkgk;

    @Getter @Setter
    private C_Hrkkeiro hrkkeiro;

    @Getter @Setter
    private C_HaitoukinuketorihouKbn haitoukinuketorihoukbn;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private String syouhnnmsyouken;

    @Getter @Setter
    private String tsinyno;

    @Getter @Setter
    private String tsinadr1kj;

    @Getter @Setter
    private String tsinadr2kj;

    @Getter @Setter
    private String tsinadr3kj;

    @Getter @Setter
    private String kyknmkj;

    @Getter @Setter
    private String hhknnmkj;

    @Getter @Setter
    private C_KktyuitaKbn kktyuitakbn;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn1;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn2;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn3;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn4;

    @Getter @Setter
    private C_TtdktyuuiKbn ttdktyuuikbn5;

    public KhSeisanDhaneiTuutiSksBean( String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo,
        String pKakuteitounendodType,
        BigDecimal pKakuteitounendodValue,
        String pNaiteitounendodType,
        BigDecimal pNaiteitounendodValue,
        String pSeisandkgkType,
        BigDecimal pSeisandkgkValue,
        C_Hrkkeiro pHrkkeiro,
        C_HaitoukinuketorihouKbn pHaitoukinuketorihoukbn,
        BizDate pKykymd,
        String pSyouhnnmsyouken,
        String pTsinyno,
        String pTsinadr1kj,
        String pTsinadr2kj,
        String pTsinadr3kj,
        String pKyknmkj,
        String pHhknnmkj,
        C_KktyuitaKbn pKktyuitakbn,
        C_TtdktyuuiKbn pTtdktyuuikbn1,
        C_TtdktyuuiKbn pTtdktyuuikbn2,
        C_TtdktyuuiKbn pTtdktyuuikbn3,
        C_TtdktyuuiKbn pTtdktyuuikbn4,
        C_TtdktyuuiKbn pTtdktyuuikbn5 ) {

        kbnkey = pKbnkey;
        syono = pSyono;
        haitounendo =pHaitounendo;
        kakuteitounendod = new BizCurrencySum(pKakuteitounendodType, pKakuteitounendodValue).toBizCurrency();
        naiteitounendod = new BizCurrencySum(pNaiteitounendodType, pNaiteitounendodValue).toBizCurrency();
        seisandkgk = new BizCurrencySum(pSeisandkgkType, pSeisandkgkValue).toBizCurrency();
        hrkkeiro = pHrkkeiro;
        haitoukinuketorihoukbn = pHaitoukinuketorihoukbn;
        kykymd = pKykymd;
        syouhnnmsyouken = pSyouhnnmsyouken;
        tsinyno = pTsinyno;
        tsinadr1kj = pTsinadr1kj;
        tsinadr2kj = pTsinadr2kj;
        tsinadr3kj = pTsinadr3kj;
        kyknmkj = pKyknmkj;
        hhknnmkj = pHhknnmkj;
        kktyuitakbn = pKktyuitakbn;
        ttdktyuuikbn1 = pTtdktyuuikbn1;
        ttdktyuuikbn2 = pTtdktyuuikbn2;
        ttdktyuuikbn3 = pTtdktyuuikbn3;
        ttdktyuuikbn4 = pTtdktyuuikbn4;
        ttdktyuuikbn5 = pTtdktyuuikbn5;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
