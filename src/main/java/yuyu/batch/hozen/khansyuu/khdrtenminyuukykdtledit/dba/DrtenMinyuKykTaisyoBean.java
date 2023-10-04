package yuyu.batch.hozen.khansyuu.khdrtenminyuukykdtledit.dba;

import java.io.Serializable;
import java.math.BigDecimal;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.BizCurrencySum;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納 代理店未入契約明細対象Beanクラス
 */
public class DrtenMinyuKykTaisyoBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kbnkey;

    @Getter @Setter
    private String syono;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private BizDateYM jyuutouym;

    @Getter @Setter
    private BizDate ryousyuuymd;

    @Getter @Setter
    private C_HurihunoKbn hurihunoKbn;

    @Getter @Setter
    private C_Hrkkaisuu hrkkaisuu;

    @Getter @Setter
    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbn;

    @Getter @Setter
    private BizDateYM jkipjytym;

    @Getter @Setter
    private BizCurrency jkiannaikg;

    @Getter @Setter
    private C_Nykkeiro nykkeiro;

    @Getter @Setter
    private C_NyknaiyouKbn nyknaiyouKbn;

    @Getter @Setter
    private BizCurrency rsgakuYen;

    public DrtenMinyuKykTaisyoBean (String pKbnkey,
        String pSyono,
        BizDate pSyoriymd,
        BizDateYM pJyuutouym,
        BizDate pRyousyuuymd,
        C_HurihunoKbn pHurihunoKbn,
        C_Hrkkaisuu pHrkkaisuu,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn,
        BizDateYM pJkipjytym,
        String pTypefieldname,
        BigDecimal pValuefieldname,
        C_Nykkeiro pNykkeiro,
        C_NyknaiyouKbn pNyknaiyouKbn,
        String pRsgakuType,
        BigDecimal pRsgakuValue) {

        kbnkey = pKbnkey;
        syono = pSyono;
        syoriYmd = pSyoriymd;
        jyuutouym = pJyuutouym;
        ryousyuuymd = pRyousyuuymd;
        hurihunoKbn = pHurihunoKbn;
        hrkkaisuu = pHrkkaisuu;
        tikiktbrisyuruikbn = pTikiktbrisyuruikbn;
        jkipjytym = pJkipjytym;
        jkiannaikg = new BizCurrencySum(pTypefieldname, pValuefieldname).toBizCurrency();
        nykkeiro = pNykkeiro;
        nyknaiyouKbn = pNyknaiyouKbn;
        rsgakuYen = new BizCurrencySum(pRsgakuType, pRsgakuValue).toBizCurrency();
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
