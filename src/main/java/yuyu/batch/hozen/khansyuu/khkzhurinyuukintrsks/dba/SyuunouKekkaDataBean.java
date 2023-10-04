package yuyu.batch.hozen.khansyuu.khkzhurinyuukintrsks.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;

/**
 * 収納結果データBeanクラスです。
 */
public class SyuunouKekkaDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private C_AnsyuusysKbn ansyuusyskbn;

    @Getter
    @Setter
    private BizDate syoriymd;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private String bankcd;

    @Getter
    @Setter
    private String sitencd;

    @Getter
    @Setter
    private C_YokinKbn yokinkbn;

    @Getter
    @Setter
    private String kouzano;

    @Getter
    @Setter
    private BizDate hurikaeymd;

    @Getter
    @Setter
    private BizDateYM jyuutouym;

    @Getter
    @Setter
    private BizCurrency ryosyugk;

    @Getter
    @Setter
    private Integer jyutoukaisuuy;

    @Getter
    @Setter
    private Integer jyutoukaisuum;

    @Getter
    @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter
    @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter
    @Setter
    private C_HurihunoKbn hurihunokbn;

    @Getter
    @Setter
    private C_Syuudaikocd syuudaikocd;


    public SyuunouKekkaDataBean(C_AnsyuusysKbn pAnsyuusyskbn,
        BizDate pSyoriymd,
        String pSyono,
        String pBankcd,
        String pSitencd,
        C_YokinKbn pYokinkbn,
        String pKouzano,
        BizDate pHurikaeymd,
        BizDateYM pJyuutouym,
        String pRsgakuType,
        BigDecimal pRsgakuValue,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        C_NyknaiyouKbn pNyknaiyoukbn,
        C_Hrkkaisuu pHrkkaisuu,
        C_HurihunoKbn pHurihunokbn,
        C_Syuudaikocd pSyuudaikocd) {

        ansyuusyskbn = pAnsyuusyskbn;
        syoriymd = pSyoriymd;
        syono = pSyono;
        bankcd = pBankcd;
        sitencd = pSitencd;
        yokinkbn = pYokinkbn;
        kouzano = pKouzano;
        hurikaeymd = pHurikaeymd;
        jyuutouym = pJyuutouym;
        ryosyugk = new BizCurrencySum(pRsgakuType, pRsgakuValue).toBizCurrency();
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        nyknaiyoukbn = pNyknaiyoukbn;
        hrkkaisuu = pHrkkaisuu;
        hurihunokbn = pHurihunokbn;
        syuudaikocd = pSyuudaikocd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
