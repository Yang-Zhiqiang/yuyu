package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;

/**
 * {@link GetKhTuusanyouKngk}のモッククラスです。<br />
 */
public class GetKhTuusanyouKngkMockForHozen extends GetKhTuusanyouKngk {

    public static final String TESTPATTERN1 = "1";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public GetKhTuusanyouKngkBean getAlltsnkngk(
        BM_SyouhnZokusei pSyouhnZokusei,
        IT_KykSyouhn pKykSyouhn,
        IT_NyknJissekiRireki pNyknJissekiRireki,
        IT_KykSonotaTkyk pKykSonotaTkyk) {

        if (caller == PALKykNaiyouSakuseiTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                GetKhTuusanyouKngkBean getKhTuusanyouKngkBean = SWAKInjector.getInstance(GetKhTuusanyouKngkBean.class);
                getKhTuusanyouKngkBean.setTsnyouSibous(BizCurrency.valueOf(1000));
                getKhTuusanyouKngkBean.setTsnyouItijip(BizCurrency.valueOf(2000));
                getKhTuusanyouKngkBean.setTsnyouNkgns(BizCurrency.valueOf(3000));
                getKhTuusanyouKngkBean.setTsnyouYennyknkgk(BizCurrency.valueOf(4000));
                getKhTuusanyouKngkBean.setTsnyouTuukasyu(C_Tuukasyu.JPY);
                return getKhTuusanyouKngkBean;
            }
        }

        if (caller == PALKykNaiyouKousinTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                GetKhTuusanyouKngkBean getKhTuusanyouKngkBean = SWAKInjector.getInstance(GetKhTuusanyouKngkBean.class);
                getKhTuusanyouKngkBean.setTsnyouNkgns(BizCurrency.valueOf(100000));
                getKhTuusanyouKngkBean.setTsnyouSibous(BizCurrency.valueOf(200000));
                getKhTuusanyouKngkBean.setTsnyouItijip(BizCurrency.valueOf(300000));
                getKhTuusanyouKngkBean.setTsnyouTuukasyu(C_Tuukasyu.JPY);
                getKhTuusanyouKngkBean.setTsnyouYennyknkgk(BizCurrency.valueOf(400000));
                return getKhTuusanyouKngkBean;
            }
        }

        return super.getAlltsnkngk(pSyouhnZokusei, pKykSyouhn, pNyknJissekiRireki, pKykSonotaTkyk);
    }
}
