package yuyu.common.suuri.srcommon;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.SV_KiykSyuhnData;

/**
 * {@link SrGetTokutejitenSyohnInfo}のモッククラスです。<br />
 */
public class SrGetTokutejitenSyohnInfoMockForSuuri extends SrGetTokutejitenSyohnInfo {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public TkJitenKeiyakuSyouhinBean exec(C_TokutejitenSyoriKbn pTokutejitenSyoriKbn, String pTokutejitenSyono,
        BizDate pTokutejitenKijyunYmd, String pTokutejitenKey, List<SV_KiykSyuhnData> pKiykSyuhnDataLst) {

        if ((caller == SrSuuriKeisanVHeijyunTest_exec.class)) {
            if (TESTPATTERN1.equals(SYORIPTN)) {

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = new TkJitenKeiyakuSyouhinBean();

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto = new TkJitenKeiyakuSyouhinKijyunBean();

                tkJitenKeiyakuSyouhinKijyunBeanAto.setSyouhncd("M210");
                tkJitenKeiyakuSyouhinKijyunBeanAto.setRyouritusdno("1");
                tkJitenKeiyakuSyouhinKijyunBeanAto.setKykymd(BizDate.valueOf(20160302));
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHknkknmanryouymd(BizDate.valueOf(20160322));
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHokenryou(BizCurrency.valueOf(1000));
                tkJitenKeiyakuSyouhinKijyunBeanAto.setKyktuukasyu(C_Tuukasyu.JPY);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHhknsei(C_Hhknsei.MALE);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHhknnen(22);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHknkkn(11);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHknkknsmnKbn(C_HknkknsmnKbn.SAIMANKI);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHrkkkn(10);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setYoteirrthendohosyurrt(BizNumber.valueOf(100));
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHhknsei(C_Hhknsei.MALE);

                tkJitenKeiyakuSyouhinBean.setTkJitenKeiyakuSyouhinKijyunBeanAto(tkJitenKeiyakuSyouhinKijyunBeanAto);

                return tkJitenKeiyakuSyouhinBean;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = new TkJitenKeiyakuSyouhinBean();

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto = new TkJitenKeiyakuSyouhinKijyunBean();

                tkJitenKeiyakuSyouhinKijyunBeanAto.setSyouhncd("M210");
                tkJitenKeiyakuSyouhinKijyunBeanAto.setRyouritusdno("1");
                tkJitenKeiyakuSyouhinKijyunBeanAto.setKykymd(BizDate.valueOf(20160302));
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHknkknmanryouymd(BizDate.valueOf(20160322));
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHokenryou(BizCurrency.valueOf(1000));
                tkJitenKeiyakuSyouhinKijyunBeanAto.setKyktuukasyu(C_Tuukasyu.JPY);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHhknsei(C_Hhknsei.MALE);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHhknnen(22);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHknkkn(11);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHknkknsmnKbn(C_HknkknsmnKbn.SAIMANKI);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHrkkkn(10);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHrkkknsmnKbn(C_HrkkknsmnKbn.SAIMANKI);
                tkJitenKeiyakuSyouhinKijyunBeanAto.setYoteirrthendohosyurrt(BizNumber.valueOf(100));
                tkJitenKeiyakuSyouhinKijyunBeanAto.setHhknsei(null);

                tkJitenKeiyakuSyouhinBean.setTkJitenKeiyakuSyouhinKijyunBeanAto(tkJitenKeiyakuSyouhinKijyunBeanAto);

                return tkJitenKeiyakuSyouhinBean;
            }
        }
        return super.exec(pTokutejitenSyoriKbn, pTokutejitenSyono, pTokutejitenKijyunYmd, pTokutejitenKey,
            pKiykSyuhnDataLst);
    }
}
