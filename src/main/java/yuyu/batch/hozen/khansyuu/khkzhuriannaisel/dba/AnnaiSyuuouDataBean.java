package yuyu.batch.hozen.khansyuu.khkzhuriannaisel.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * 案内収納基本情報Beanクラスです。<br />
 */
public class AnnaiSyuuouDataBean implements Serializable {

    public AnnaiSyuuouDataBean(){
    }

    public AnnaiSyuuouDataBean(String pSyono,
        String pKbnkey,
        BizDateYM pJkipjytym,
        BizDate pSyuharaimanymd,
        C_Hrkkaisuu pHrkkaisuu,
        String pHrkpType,
        BigDecimal pHrkpValue,
        C_Hrkkeiro pHrkkeiro,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        BizDate pKykymd,
        String pSyouhncd,
        Integer pSyouhnsdno,
        String pRyouritusdno,
        String pHokenryouType,
        BigDecimal pHokenryouValue,
        C_Syuudaikocd pSyuudaikocd,
        String pBankcd,
        String pSitencd,
        C_YokinKbn pYokinkbn,
        String pKouzano,
        String pKzmeiginmkn,
        C_SinkeizkKbn pSinkeizkkbn,
        String pKyknmkn) {

        syono = pSyono;
        kbnkey = pKbnkey;
        jkipjytym = pJkipjytym;
        syuharaimanymd = pSyuharaimanymd;
        hrkkaisuu = pHrkkaisuu;
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        hrkkeiro = pHrkkeiro;
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        kykymd = pKykymd;
        syouhncd = pSyouhncd;
        syouhnsdno = pSyouhnsdno;
        ryouritusdno = pRyouritusdno;
        hokenryou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
        syuudaikocd = pSyuudaikocd;
        bankcd = pBankcd;
        sitencd = pSitencd;
        yokinkbn = pYokinkbn;
        kouzano = pKouzano;
        kzmeiginmkn = pKzmeiginmkn;
        sinkeizkkbn = pSinkeizkkbn;
        kyknmkn = pKyknmkn;

    }

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private BizDateYM jkipjytym;

    @Getter @Setter
    private BizDate syuharaimanymd;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private C_Hrkkeiro hrkkeiro;

    @Getter @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Getter @Setter
    private BizDate kykymd;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer syouhnsdno;

    @Getter @Setter
    private String ryouritusdno;

    @Getter @Setter
    private BizCurrency hokenryou;

    @Getter @Setter
    private C_Syuudaikocd syuudaikocd;

    @Getter @Setter
    private String bankcd;

    @Getter @Setter
    private String sitencd;

    @Getter @Setter
    private C_YokinKbn yokinkbn;

    @Getter @Setter
    private String kouzano;

    @Getter @Setter
    private String kzmeiginmkn;

    @Getter @Setter
    private C_SinkeizkKbn sinkeizkkbn;

    @Getter @Setter
    private String kyknmkn;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
