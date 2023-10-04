package yuyu.batch.hozen.khansyuu.khuriageseikyuusel.dba;

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
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Yuukoukakkekka;

/**
 * 案内収納情報Beanクラス<br />
 */
public class AnnaiSyuunouDataBean implements Serializable {

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
    private String syouhncd;

    @Getter @Setter
    private String creditkessaiyouno;

    @Getter @Setter
    private BizDateYM credityuukoukakym;

    @Getter @Setter
    private C_Yuukoukakkekka credityuukoukakkekka;

    public AnnaiSyuunouDataBean(String pSyono,
        String pKbnkey,
        BizDateYM pJkipjytym,
        BizDate pSyuharaimanymd,
        C_Hrkkaisuu pHrkkaisuu,
        String pHrkpType,
        BigDecimal pHrkpValue,
        C_Hrkkeiro pHrkkeiro,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        String pSyouhncd,
        String pCreditkessaiyouno,
        BizDateYM pCredityuukoukakym,
        C_Yuukoukakkekka pCredityuukoukakkekka) {

        syono = pSyono;
        kbnkey = pKbnkey;
        jkipjytym = pJkipjytym;
        syuharaimanymd = pSyuharaimanymd;
        hrkkaisuu = pHrkkaisuu;
        hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        hrkkeiro = pHrkkeiro;
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        syouhncd = pSyouhncd;
        creditkessaiyouno = pCreditkessaiyouno;
        credityuukoukakym = pCredityuukoukakym;
        credityuukoukakkekka = pCredityuukoukakkekka;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}