package yuyu.batch.hozen.khansyuu.khkariukekinseibitokusoku.dba;

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
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;

/**
 * 仮受金整備督促対象Beanクラスです。<br />
 */
public class KariukeTokusokuTaisyouBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String syono;

    @Getter
    @Setter
    private String kbnkey;

    @Getter
    @Setter
    private Integer krkno;

    @Getter
    @Setter
    private BizDate krkkeijyoymd;

    @Getter
    @Setter
    private BizCurrency krkgk;

    @Getter
    @Setter
    private BizDate hasseidenymd;

    @Getter
    @Setter
    private BizDate seisandenymd;

    @Getter
    @Setter
    private C_Krkseisanzumiflg krkseisanzumiflg;

    @Getter
    @Setter
    private C_KrkriyuuKbn krkriyuukbn;

    @Getter
    @Setter
    private C_NyknaiyouKbn nyknaiyoukbn;

    @Getter
    @Setter
    private C_Nykkeiro nykkeiro;

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
    private BizDate ryosyuymd;

    @Getter
    @Setter
    private C_Hrkkaisuu hrkkaisuu;

    public KariukeTokusokuTaisyouBean(String pSyono,
        String pKbnkey,
        Integer pKrkno,
        BizDate pKrkkeijyoymd,
        String pTypefieldname,
        BigDecimal pValuefieldname,
        BizDate pHasseidenymd,
        BizDate pSeisandenymd,
        C_Krkseisanzumiflg pKrkseisanzumiflg,
        C_KrkriyuuKbn pKrkriyuukbn,
        C_NyknaiyouKbn pNyknaiyoukbn,
        C_Nykkeiro pNykkeiro,
        BizDateYM pJyuutouym,
        Integer pJyutoukaisuuy,
        Integer pJyutoukaisuum,
        BizDate pRyosyuymd,
        C_Hrkkaisuu pHrkkaisuu) {

        syono = pSyono;
        kbnkey = pKbnkey;
        krkno = pKrkno;
        krkkeijyoymd = pKrkkeijyoymd;
        krkgk = new BizCurrencySum(pTypefieldname, pValuefieldname).toBizCurrency();
        hasseidenymd = pHasseidenymd;
        seisandenymd = pSeisandenymd;
        krkseisanzumiflg = pKrkseisanzumiflg;
        krkriyuukbn = pKrkriyuukbn;
        nyknaiyoukbn = pNyknaiyoukbn;
        nykkeiro = pNykkeiro;
        jyuutouym = pJyuutouym;
        jyutoukaisuuy = pJyutoukaisuuy;
        jyutoukaisuum = pJyutoukaisuum;
        ryosyuymd = pRyosyuymd;
        hrkkaisuu = pHrkkaisuu;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
