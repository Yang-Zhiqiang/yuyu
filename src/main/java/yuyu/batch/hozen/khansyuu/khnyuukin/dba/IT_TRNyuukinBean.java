package yuyu.batch.hozen.khansyuu.khnyuukin.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 入金TRデータを保持するBeanクラスです。<br />
 */
public class IT_TRNyuukinBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private BizDate syoriYmd;

    @Getter
    @Setter
    private String nyktrrenno;

    @Getter
    @Setter
    private Integer datarenno;

    @Getter
    @Setter
    private C_Nykkeiro nykkeiro;

    @Getter
    @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter
    @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter
    @Setter
    private BizDateYM jyuutouym;

    @Getter
    @Setter
    private Integer jyutoukaisuuy;

    @Getter
    @Setter
    private Integer jyutoukaisuum;

    @Getter
    @Setter
    private BizCurrency rsgaku;

    @Getter
    @Setter
    private BizDate ryosyuymd;

    @Getter
    @Setter
    private C_UmuKbn iktnyuukinnumu;

    @Getter
    @Setter
    private String kzhurikaebankcd;

    @Getter
    @Setter
    private String kzhurikaesitencd;


    @Getter
    @Setter
    private BizDate nykdenymd ;

    @Getter
    @Setter
    private C_TkiktbrisyuruiKbn tkiktbrisyuruiKbn ;

    @Getter
    @Setter
    private BizDate nyknkwsratekijyunymd ;

    @Getter
    @Setter
    private String creditkessaiyouno ;

    @Getter
    @Setter
    private C_Syuudaikocd syuudaikocd ;

    @Getter
    @Setter
    private C_CreditUriageSeikyuuKbn credituriageseikyuukbn ;

    public IT_TRNyuukinBean(String pSyono,
        String pKkbnkey,
        BizDate pSyoriYmd,
        String pNyktrrenno,
        Integer pDatarenno,
        C_Nykkeiro pNykkeiro,
        C_Hrkkaisuu pHrkkaisuu,
        C_NyknaiyouKbn pNyknaiyouKbn,
        BizDateYM pJyuutouym,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        String pTypefieldname,
        BigDecimal pValuefieldname,
        BizDate pRyosyuymd,
        C_UmuKbn pIktnyuukinnumu,
        String pKzhurikaebankcd,
        String pKzhurikaesitencd,
        BizDate pNykdenymd,
        C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn,
        BizDate pNyknkwsratekijyunymd,
        String pCreditkessaiyouno,
        C_Syuudaikocd pSyuudaikocd,
        C_CreditUriageSeikyuuKbn pCredituriageseikyuukbn){
        syono = pSyono;
        kbnkey = pKkbnkey;
        syoriYmd = pSyoriYmd;
        nyktrrenno = pNyktrrenno;
        datarenno = pDatarenno;
        nykkeiro = pNykkeiro;
        hrkkaisuu = pHrkkaisuu;
        nyknaiyoukbn = pNyknaiyouKbn;
        jyuutouym = pJyuutouym;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        rsgaku = new BizCurrencySum(pTypefieldname,pValuefieldname).toBizCurrency();
        ryosyuymd = pRyosyuymd;
        iktnyuukinnumu = pIktnyuukinnumu;
        kzhurikaebankcd = pKzhurikaebankcd;
        kzhurikaesitencd = pKzhurikaesitencd;
        nykdenymd = pNykdenymd;
        tkiktbrisyuruiKbn = pTkiktbrisyuruiKbn;
        nyknkwsratekijyunymd = pNyknkwsratekijyunymd;
        creditkessaiyouno = pCreditkessaiyouno;
        syuudaikocd = pSyuudaikocd;
        credituriageseikyuukbn = pCredituriageseikyuukbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
