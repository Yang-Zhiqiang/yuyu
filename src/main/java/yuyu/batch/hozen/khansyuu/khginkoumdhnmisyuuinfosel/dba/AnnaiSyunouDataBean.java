package yuyu.batch.hozen.khansyuu.khginkoumdhnmisyuuinfosel.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;

/**
 * 契約保全 案内収納 案内収納基本情報を保持するBeanクラス
 */
public class AnnaiSyunouDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private BizCurrency hrkp;

    @Getter @Setter
    private C_Hrkkeiro hrkkeiro;

    @Getter @Setter
    private String syouhncd;

    @Getter @Setter
    private Integer syouhnsdno;

    @Getter
    @Setter
    private BizDateYM jkipjytym;

    @Getter
    @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Getter
    @Setter
    private String ryouritusdno;

    @Getter
    @Setter
    private BizCurrency hokenryou;

    public AnnaiSyunouDataBean(String pSyono, String pKbnkey, C_Hrkkaisuu pHrkkaisuu, String pHrkpType,
        BigDecimal pHrkpValue, C_Hrkkeiro pHrkkeiro, String pSyouhncd, Integer pSyouhnsdno, BizDateYM pJkipjytym,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn, String pRyouritusdno, String pHokenryouType, BigDecimal pHokenryouValue) {
        this.syono = pSyono;
        this.kbnkey = pKbnkey;
        this.hrkkaisuu = pHrkkaisuu;
        this.hrkp = new BizCurrencySum(pHrkpType, pHrkpValue).toBizCurrency();
        this.hrkkeiro = pHrkkeiro;
        this.syouhncd = pSyouhncd;
        this.syouhnsdno = pSyouhnsdno;
        this.jkipjytym = pJkipjytym;
        this.tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        this.ryouritusdno = pRyouritusdno;
        this.hokenryou = new BizCurrencySum(pHokenryouType, pHokenryouValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
