package yuyu.common.direct.dscommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin.DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GkdtKoktuutiUktKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;

/**
 * {@link DsGetKeiyakuCommon}のモッククラスです。<br />
 */
public class DsGetKeiyakuCommonMock extends DsGetKeiyakuCommon {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    @Override
    public KeiyakuKihonBean getKykKihon(String pSyoNo) {

        if (DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class == caller) {

            KeiyakuKihonBean keiyakuKihonBean = new KeiyakuKihonBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(BizDate.valueOf(20180226));
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(BizDate.valueOf(20180305));
            }

            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(null);
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(null);
            }
            return keiyakuKihonBean;
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {

            KeiyakuKihonBean keiyakuKihonBean = new KeiyakuKihonBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(BizDate.valueOf(20180404));
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(BizDate.valueOf(20180305));
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(null);
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(null);
            }

            return keiyakuKihonBean;
        }

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {

            KeiyakuKihonBean keiyakuKihonBean = new KeiyakuKihonBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKARIRITUHENDOUNK_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(BizDate.valueOf(20190301));
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.USD);
                keiyakuKihonBean.setSakuseiKijyunYmd(BizDate.valueOf(20190325));
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKARIRITUHENDOUNK_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(null);
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.USD);
                keiyakuKihonBean.setSakuseiKijyunYmd(null);
            }
            return keiyakuKihonBean;
        }

        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {

            KeiyakuKihonBean keiyakuKihonBean = new KeiyakuKihonBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(BizDate.valueOf(20180404));
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(BizDate.valueOf(20180305));
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(null);
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(null);
            }
            return keiyakuKihonBean;
        }

        return super.getKykKihon(pSyoNo);
    }

    @Override
    public KeiyakusyaBean getKykSya(String pSyoNo) {

        if (DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class == caller) {

            KeiyakusyaBean keiyakusyaBean = new KeiyakusyaBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(BizDate.valueOf(20170405));
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(null);
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }
            return keiyakusyaBean;
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {

            KeiyakusyaBean keiyakusyaBean = new KeiyakusyaBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(BizDate.valueOf(20170305));
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(null);
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }

            return keiyakusyaBean;
        }

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {

            KeiyakusyaBean keiyakusyaBean = new KeiyakusyaBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(BizDate.valueOf(19990101));
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(null);
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }
            return keiyakusyaBean;
        }

        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {

            KeiyakusyaBean keiyakusyaBean = new KeiyakusyaBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(BizDate.valueOf(20170305));
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(null);
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }
            return keiyakusyaBean;
        }

        return super.getKykSya(pSyoNo);
    }

    @Override
    public HihokensyaBean getHhknSya(String pSyoNo) {

        if (DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class == caller) {

            HihokensyaBean hihokensyaBean = new HihokensyaBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
                hihokensyaBean.setHhknNmKn("サシサシ");
                hihokensyaBean.setHhknseiYmd(BizDate.valueOf(20170525));
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
                hihokensyaBean.setHhknNmKn("サシサシ");
                hihokensyaBean.setHhknseiYmd(null);
            }
            return hihokensyaBean;
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {
            HihokensyaBean hihokensyaBean = new HihokensyaBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
                hihokensyaBean.setHhknNmKn("サシサシ");
                hihokensyaBean.setHhknseiYmd(BizDate.valueOf(20170525));
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
                hihokensyaBean.setHhknNmKn("サシサシ");
                hihokensyaBean.setHhknseiYmd(null);
            }
            return hihokensyaBean;
        }
        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {
            HihokensyaBean hihokensyaBean = new HihokensyaBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
                hihokensyaBean.setHhknNmKn("サシサシ");
                hihokensyaBean.setHhknseiYmd(BizDate.valueOf(20170525));
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
                hihokensyaBean.setHhknNmKn("サシサシ");
                hihokensyaBean.setHhknseiYmd(null);
            }
            return hihokensyaBean;
        }
        return super.getHhknSya(pSyoNo);
    }

    @Override
    public KeiyakuUketorininBean getKykUkt(String pSyoNo) {

        if (DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class == caller) {

            KeiyakuUketorininBean keiyakuUketorininBean = new KeiyakuUketorininBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuUketorininBean.setSbuktnin(11);
                keiyakuUketorininBean.setUktsyuKbn1(C_UktsyuKbn.SBUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn1(C_GkdtKoktuutiUktKbn.NONE);
                keiyakuUketorininBean.setUktNm1("王１");
                keiyakuUketorininBean.setUktsyuKbn2(C_UktsyuKbn.STDRSK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn2(C_GkdtKoktuutiUktKbn.HHKN);
                keiyakuUketorininBean.setUktNm2("王２");
                keiyakuUketorininBean.setUktsyuKbn3(C_UktsyuKbn.NKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn3(C_GkdtKoktuutiUktKbn.KYK);
                keiyakuUketorininBean.setUktNm3("王３");
                keiyakuUketorininBean.setUktsyuKbn4(C_UktsyuKbn.KEIZKNKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn4(C_GkdtKoktuutiUktKbn.SOUZOKU);
                keiyakuUketorininBean.setUktNm4("王４");
                keiyakuUketorininBean.setUktsyuKbn5(C_UktsyuKbn.SBHENKANUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn5(C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
                keiyakuUketorininBean.setUktNm5("王５");
                keiyakuUketorininBean.setUktsyuKbn6(C_UktsyuKbn.SONOTA);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn6(C_GkdtKoktuutiUktKbn.NASI);
                keiyakuUketorininBean.setUktNm6("王６");
                keiyakuUketorininBean.setUktsyuKbn7(C_UktsyuKbn.SBHENKANUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn7(C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                keiyakuUketorininBean.setUktNm7("王７");
                keiyakuUketorininBean.setUktsyuKbn8(C_UktsyuKbn.KEIZKNKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn8(C_GkdtKoktuutiUktKbn.NASI);
                keiyakuUketorininBean.setUktNm8("王８");
                keiyakuUketorininBean.setUktsyuKbn9(C_UktsyuKbn.NKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn9(C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
                keiyakuUketorininBean.setUktNm9("王９");
                keiyakuUketorininBean.setUktsyuKbn10(C_UktsyuKbn.STDRSK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn10(C_GkdtKoktuutiUktKbn.SOUZOKU);
                keiyakuUketorininBean.setUktNm10("王１０");
            }
            return keiyakuUketorininBean;
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {
            KeiyakuUketorininBean keiyakuUketorininBean = new KeiyakuUketorininBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuUketorininBean.setSbuktnin(11);
                keiyakuUketorininBean.setUktsyuKbn1(C_UktsyuKbn.SBUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn1(C_GkdtKoktuutiUktKbn.NONE);
                keiyakuUketorininBean.setUktNm1("王１");
                keiyakuUketorininBean.setUktsyuKbn2(C_UktsyuKbn.STDRSK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn2(C_GkdtKoktuutiUktKbn.HHKN);
                keiyakuUketorininBean.setUktNm2("王２");
                keiyakuUketorininBean.setUktsyuKbn3(C_UktsyuKbn.NKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn3(C_GkdtKoktuutiUktKbn.KYK);
                keiyakuUketorininBean.setUktNm3("王３");
                keiyakuUketorininBean.setUktsyuKbn4(C_UktsyuKbn.KEIZKNKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn4(C_GkdtKoktuutiUktKbn.SOUZOKU);
                keiyakuUketorininBean.setUktNm4("王４");
                keiyakuUketorininBean.setUktsyuKbn5(C_UktsyuKbn.SBHENKANUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn5(C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
                keiyakuUketorininBean.setUktNm5("王５");
                keiyakuUketorininBean.setUktsyuKbn6(C_UktsyuKbn.SONOTA);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn6(C_GkdtKoktuutiUktKbn.NASI);
                keiyakuUketorininBean.setUktNm6("王６");
                keiyakuUketorininBean.setUktsyuKbn7(C_UktsyuKbn.SBHENKANUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn7(C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                keiyakuUketorininBean.setUktNm7("王７");
                keiyakuUketorininBean.setUktsyuKbn8(C_UktsyuKbn.KEIZKNKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn8(C_GkdtKoktuutiUktKbn.NASI);
                keiyakuUketorininBean.setUktNm8("王８");
                keiyakuUketorininBean.setUktsyuKbn9(C_UktsyuKbn.NKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn9(C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
                keiyakuUketorininBean.setUktNm9("王９");
                keiyakuUketorininBean.setUktsyuKbn10(C_UktsyuKbn.STDRSK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn10(C_GkdtKoktuutiUktKbn.SOUZOKU);
                keiyakuUketorininBean.setUktNm10("王１０");
            }
            return keiyakuUketorininBean;
        }

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {
            KeiyakuUketorininBean keiyakuUketorininBean = new KeiyakuUketorininBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuUketorininBean.setSbuktnin(11);
                keiyakuUketorininBean.setUktsyuKbn1(C_UktsyuKbn.SBUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn1(C_GkdtKoktuutiUktKbn.NONE);
                keiyakuUketorininBean.setUktNm1("王１");
                keiyakuUketorininBean.setUktsyuKbn2(C_UktsyuKbn.STDRSK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn2(C_GkdtKoktuutiUktKbn.HHKN);
                keiyakuUketorininBean.setUktNm2("王２");
                keiyakuUketorininBean.setUktsyuKbn3(C_UktsyuKbn.NKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn3(C_GkdtKoktuutiUktKbn.KYK);
                keiyakuUketorininBean.setUktNm3("王３");
                keiyakuUketorininBean.setUktsyuKbn4(C_UktsyuKbn.KEIZKNKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn4(C_GkdtKoktuutiUktKbn.SOUZOKU);
                keiyakuUketorininBean.setUktNm4("王４");
                keiyakuUketorininBean.setUktsyuKbn5(C_UktsyuKbn.SBHENKANUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn5(C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
                keiyakuUketorininBean.setUktNm5("王５");
                keiyakuUketorininBean.setUktsyuKbn6(C_UktsyuKbn.SONOTA);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn6(C_GkdtKoktuutiUktKbn.NASI);
                keiyakuUketorininBean.setUktNm6("王６");
                keiyakuUketorininBean.setUktsyuKbn7(C_UktsyuKbn.SBHENKANUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn7(C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                keiyakuUketorininBean.setUktNm7("王７");
                keiyakuUketorininBean.setUktsyuKbn8(C_UktsyuKbn.KEIZKNKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn8(C_GkdtKoktuutiUktKbn.NASI);
                keiyakuUketorininBean.setUktNm8("王８");
                keiyakuUketorininBean.setUktsyuKbn9(C_UktsyuKbn.NKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn9(C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
                keiyakuUketorininBean.setUktNm9("王９");
                keiyakuUketorininBean.setUktsyuKbn10(C_UktsyuKbn.STDRSK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn10(C_GkdtKoktuutiUktKbn.SOUZOKU);
                keiyakuUketorininBean.setUktNm10("王１０");
            }
            return keiyakuUketorininBean;
        }

        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {
            KeiyakuUketorininBean keiyakuUketorininBean = new KeiyakuUketorininBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuUketorininBean.setSbuktnin(11);
                keiyakuUketorininBean.setUktsyuKbn1(C_UktsyuKbn.SBUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn1(C_GkdtKoktuutiUktKbn.NONE);
                keiyakuUketorininBean.setUktNm1("王１");
                keiyakuUketorininBean.setUktsyuKbn2(C_UktsyuKbn.STDRSK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn2(C_GkdtKoktuutiUktKbn.HHKN);
                keiyakuUketorininBean.setUktNm2("王２");
                keiyakuUketorininBean.setUktsyuKbn3(C_UktsyuKbn.NKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn3(C_GkdtKoktuutiUktKbn.KYK);
                keiyakuUketorininBean.setUktNm3("王３");
                keiyakuUketorininBean.setUktsyuKbn4(C_UktsyuKbn.KEIZKNKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn4(C_GkdtKoktuutiUktKbn.SOUZOKU);
                keiyakuUketorininBean.setUktNm4("王４");
                keiyakuUketorininBean.setUktsyuKbn5(C_UktsyuKbn.SBHENKANUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn5(C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
                keiyakuUketorininBean.setUktNm5("王５");
                keiyakuUketorininBean.setUktsyuKbn6(C_UktsyuKbn.SONOTA);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn6(C_GkdtKoktuutiUktKbn.NASI);
                keiyakuUketorininBean.setUktNm6("王６");
                keiyakuUketorininBean.setUktsyuKbn7(C_UktsyuKbn.SBHENKANUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn7(C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                keiyakuUketorininBean.setUktNm7("王７");
                keiyakuUketorininBean.setUktsyuKbn8(C_UktsyuKbn.KEIZKNKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn8(C_GkdtKoktuutiUktKbn.NASI);
                keiyakuUketorininBean.setUktNm8("王８");
                keiyakuUketorininBean.setUktsyuKbn9(C_UktsyuKbn.NKUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn9(C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
                keiyakuUketorininBean.setUktNm9("王９");
                keiyakuUketorininBean.setUktsyuKbn10(C_UktsyuKbn.STDRSK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn10(C_GkdtKoktuutiUktKbn.SOUZOKU);
                keiyakuUketorininBean.setUktNm10("王１０");
            }
            return keiyakuUketorininBean;
        }

        return super.getKykUkt(pSyoNo);
    }

}
