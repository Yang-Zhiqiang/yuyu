package yuyu.common.direct.dscommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkeiyakuenitijisyusin.DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikhijynnnkn.DwGetHozenKiykGikHijynNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkiykgikitijinnkn.DwGetHozenKiykGikItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkykenitijinnkn.DwGetHozenKykEnItijiNnknImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozenkyksntkhijynsysn.DwGetHozenKykSntkHijynSysnImplTest_execPostForm;
import yuyu.app.dsweb.dwhozeninfo.dwgethozentrkkzkinfo.DwGetHozenTrkkzkInfoTest_execPostForm;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GkdtKoktuutiUktKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;

/**
 * {@link DsGetKeiyakuCommon}のモッククラスです。<br />
 */
public class DsGetKeiyakuCommonMockForDirect extends DsGetKeiyakuCommon {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static final String TESTPATTERN6 = "6";

    public static final String TESTPATTERN7 = "7";

    public static final String TESTPATTERN8 = "8";

    public static final String TESTPATTERN9 = "9";

    @Override
    public TrkKazokuBean getTrkKazoku(String pSyoNo) {

        if (DwGetHozenTrkkzkInfoTest_execPostForm.class == caller) {

            TrkKazokuBean trkKazokuBean = new TrkKazokuBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {

                trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);

                trkKazokuBean.setTrkkzkumuKbn1(C_UmuKbn.NONE);
                trkKazokuBean.setTrkkzkKbn1(C_TrkKzkKbn.TRKKZK1);
                trkKazokuBean.setTrkkzksetteiYmd1(BizDate.valueOf("20200205"));
                trkKazokuBean.setTrkkzknmKn1("カナ１");
                trkKazokuBean.setTrkkzknmKj1("漢字１");
                trkKazokuBean.setTrkkzknmkjkhukaKbn1(C_KjkhukaKbn.BLNK);
                trkKazokuBean.setTrkkzkseiYmd1(BizDate.valueOf("20200206"));
                trkKazokuBean.setTrkkzkSei1(C_Seibetu.MALE);
                trkKazokuBean.setTrkkzkTdk1(C_Tdk.GIRIKO);
                trkKazokuBean.setTrkkzkYno1("1234567");
                trkKazokuBean.setTrkkzkadr1Kj1("住所１漢字１");
                trkKazokuBean.setTrkkzkadr2Kj1("住所２漢字１");
                trkKazokuBean.setTrkkzkadr3Kj1("住所３漢字１");
                trkKazokuBean.setTrkkzkTelno1("0123-2345-5678");
                trkKazokuBean.setGyoumuKousinTime1("20200205173204123");

                trkKazokuBean.setTrkkzkumuKbn2(C_UmuKbn.ARI);
                trkKazokuBean.setTrkkzkKbn2(C_TrkKzkKbn.TRKKZK2);
                trkKazokuBean.setTrkkzksetteiYmd2(BizDate.valueOf("20200207"));
                trkKazokuBean.setTrkkzknmKn2("カナ２");
                trkKazokuBean.setTrkkzknmKj2("漢字２");
                trkKazokuBean.setTrkkzknmkjkhukaKbn2(C_KjkhukaKbn.KJKHUKA);
                trkKazokuBean.setTrkkzkseiYmd2(BizDate.valueOf("20200208"));
                trkKazokuBean.setTrkkzkSei2(C_Seibetu.FEMALE);
                trkKazokuBean.setTrkkzkTdk2(C_Tdk.KYDSM);
                trkKazokuBean.setTrkkzkYno2("2345678");
                trkKazokuBean.setTrkkzkadr1Kj2("住所１漢字２");
                trkKazokuBean.setTrkkzkadr2Kj2("住所２漢字２");
                trkKazokuBean.setTrkkzkadr3Kj2("住所３漢字２");
                trkKazokuBean.setTrkkzkTelno2("1234-2345-6789");
                trkKazokuBean.setGyoumuKousinTime2("20200206173204999");

            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);

                trkKazokuBean.setTrkkzkumuKbn1(C_UmuKbn.NONE);
                trkKazokuBean.setTrkkzkKbn1(C_TrkKzkKbn.TRKKZK1);
                trkKazokuBean.setTrkkzksetteiYmd1(BizDate.valueOf("20200205"));
                trkKazokuBean.setTrkkzknmKn1("カナ１");
                trkKazokuBean.setTrkkzknmKj1("漢字１");
                trkKazokuBean.setTrkkzknmkjkhukaKbn1(C_KjkhukaKbn.BLNK);
                trkKazokuBean.setTrkkzkseiYmd1(null);
                trkKazokuBean.setTrkkzkSei1(C_Seibetu.MALE);
                trkKazokuBean.setTrkkzkTdk1(C_Tdk.HGU);
                trkKazokuBean.setTrkkzkYno1("1234567");
                trkKazokuBean.setTrkkzkadr1Kj1("住所１漢字１");
                trkKazokuBean.setTrkkzkadr2Kj1("住所２漢字１");
                trkKazokuBean.setTrkkzkadr3Kj1("住所３漢字１");
                trkKazokuBean.setTrkkzkTelno1("0123-2345-5678");
                trkKazokuBean.setGyoumuKousinTime1("20200205173204123");

                trkKazokuBean.setTrkkzkumuKbn2(C_UmuKbn.ARI);
                trkKazokuBean.setTrkkzkKbn2(C_TrkKzkKbn.TRKKZK2);
                trkKazokuBean.setTrkkzksetteiYmd2(BizDate.valueOf("20200207"));
                trkKazokuBean.setTrkkzknmKn2("カナ２");
                trkKazokuBean.setTrkkzknmKj2("漢字２");
                trkKazokuBean.setTrkkzknmkjkhukaKbn2(C_KjkhukaKbn.KJKHUKA);
                trkKazokuBean.setTrkkzkseiYmd2(null);
                trkKazokuBean.setTrkkzkSei2(C_Seibetu.FEMALE);
                trkKazokuBean.setTrkkzkTdk2(C_Tdk.MAGO);
                trkKazokuBean.setTrkkzkYno2("2345678");
                trkKazokuBean.setTrkkzkadr1Kj2("住所１漢字２");
                trkKazokuBean.setTrkkzkadr2Kj2("住所２漢字２");
                trkKazokuBean.setTrkkzkadr3Kj2("住所３漢字２");
                trkKazokuBean.setTrkkzkTelno2("1234-2345-6789");
                trkKazokuBean.setGyoumuKousinTime2("20200206173204999");

            }

            if (TESTPATTERN3.equals(SYORIPTN)) {

                trkKazokuBean.setTrkkzkumuKbn1(null);

            }

            return trkKazokuBean;
        }

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {

            TrkKazokuBean trkKazokuBean = new TrkKazokuBean();

            trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);
            trkKazokuBean.setTrkkzknmKn1("サシサシ");
            trkKazokuBean.setTrkkzknmKn2("サシサス");
            return trkKazokuBean;
        }

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {

            TrkKazokuBean trkKazokuBean = new TrkKazokuBean();

            if (TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN) ||
                TESTPATTERN8.equals(SYORIPTN) ||
                TESTPATTERN9.equals(SYORIPTN)) {

                trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);

                trkKazokuBean.setTrkkzknmKn1("登録家族名（カナ）１");
                trkKazokuBean.setTrkkzknmKn2("登録家族名（カナ）２");
                trkKazokuBean.setTrkkzkKbn1(C_TrkKzkKbn.TRKKZK1);
                trkKazokuBean.setTrkkzksetteiYmd1(BizDate.valueOf("20200205"));
                trkKazokuBean.setTrkkzknmKn1("カナ１");
                trkKazokuBean.setTrkkzknmKj1("漢字１");
                trkKazokuBean.setTrkkzknmkjkhukaKbn1(C_KjkhukaKbn.BLNK);
                trkKazokuBean.setTrkkzkseiYmd1(BizDate.valueOf("20200206"));
                trkKazokuBean.setTrkkzkSei1(C_Seibetu.MALE);
                trkKazokuBean.setTrkkzkTdk1(C_Tdk.GIRIKO);
                trkKazokuBean.setTrkkzkYno1("1234567");
                trkKazokuBean.setTrkkzkadr1Kj1("住所１漢字１");
                trkKazokuBean.setTrkkzkadr2Kj1("住所２漢字１");
                trkKazokuBean.setTrkkzkadr3Kj1("住所３漢字１");
                trkKazokuBean.setTrkkzkTelno1("0123-2345-5678");
                trkKazokuBean.setGyoumuKousinTime1("20200205173204123");

                trkKazokuBean.setTrkkzkumuKbn2(C_UmuKbn.ARI);
                trkKazokuBean.setTrkkzkKbn2(C_TrkKzkKbn.TRKKZK2);
                trkKazokuBean.setTrkkzksetteiYmd2(BizDate.valueOf("20200207"));
                trkKazokuBean.setTrkkzknmKn2("カナ２");
                trkKazokuBean.setTrkkzknmKj2("漢字２");
                trkKazokuBean.setTrkkzknmkjkhukaKbn2(C_KjkhukaKbn.KJKHUKA);
                trkKazokuBean.setTrkkzkseiYmd2(BizDate.valueOf("20200208"));
                trkKazokuBean.setTrkkzkSei2(C_Seibetu.FEMALE);
                trkKazokuBean.setTrkkzkTdk2(C_Tdk.KYDSM);
                trkKazokuBean.setTrkkzkYno2("2345678");
                trkKazokuBean.setTrkkzkadr1Kj2("住所１漢字２");
                trkKazokuBean.setTrkkzkadr2Kj2("住所２漢字２");
                trkKazokuBean.setTrkkzkadr3Kj2("住所３漢字２");
                trkKazokuBean.setTrkkzkTelno2("1234-2345-6789");
                trkKazokuBean.setGyoumuKousinTime2("20200206173204999");

            }
            return trkKazokuBean;
        }

        if (DwGetHozenKykEnItijiNnknImplTest_execPostForm.class == caller) {

            TrkKazokuBean trkKazokuBean = new TrkKazokuBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                trkKazokuBean.setErrorKbn(C_ErrorKbn.ERROR);
            }
            else if (TESTPATTERN5.equals(SYORIPTN) || TESTPATTERN6.equals(SYORIPTN)) {
                trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);
                trkKazokuBean.setTrkkzknmKn1("トウロクカゾク１");
                trkKazokuBean.setTrkkzknmKn2("トウロクカゾク２");
            }
            return trkKazokuBean;
        }

        if (DsGetKeiyakuSyousaiTest_exec.class == caller) {

            TrkKazokuBean trkKazokuBean = new TrkKazokuBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                trkKazokuBean.setTrkkzknmKn1("カナ１");
                trkKazokuBean.setTrkkzknmKn2("カナ２");
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                trkKazokuBean.setTrkkzknmKn1("");
                trkKazokuBean.setTrkkzknmKn2("");
            }
            return trkKazokuBean;
        }

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            TrkKazokuBean trkKazokuBean = new TrkKazokuBean();

            trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);
            trkKazokuBean.setTrkkzknmKn1("サシサシ");
            trkKazokuBean.setTrkkzknmKn2("サシサス");
            return trkKazokuBean;
        }

        if (DwGetHozenKeiyakuEnItijiSyusinImplTest_execPostForm.class == caller) {

            TrkKazokuBean trkKazokuBean = new TrkKazokuBean();

            trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);

            trkKazokuBean.setTrkkzknmKn1("登録家族名（カナ）１");

            trkKazokuBean.setTrkkzknmKn2("登録家族名（カナ）２");

            return trkKazokuBean;
        }

        return super.getTrkKazoku(pSyoNo);

    }

    @Override
    public KeiyakuKihonBean getKykKihon(String pSyoNo) {

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
                keiyakuKihonBean.setYakkanBunsyoNo("1234567890");
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(null);
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(null);
                keiyakuKihonBean.setYakkanBunsyoNo("");
            }
            return keiyakuKihonBean;
        }

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
                keiyakuKihonBean.setYakkanBunsyoNo("1234567890");
            }

            else if (TESTPATTERN6.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(null);
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(null);
                keiyakuKihonBean.setYakkanBunsyoNo("");
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
            else if (TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN) ||
                TESTPATTERN8.equals(SYORIPTN) ||
                TESTPATTERN9.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(BizDate.valueOf(20180404));
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(BizDate.valueOf(20180305));
                keiyakuKihonBean.setYakkanBunsyoNo("1234567890");
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
                keiyakuKihonBean.setYakkanBunsyoNo("1234567890");
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

        if (DsGetKeiyakuSyousaiTest_exec.class == caller) {

            KeiyakuKihonBean keiyakuKihonBean = new KeiyakuKihonBean();

            if (TESTPATTERN2.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setYakkanBunsyoNo("1234567890");
            }
            return keiyakuKihonBean;
        }

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

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
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKARIRITUHENDOUNK_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(BizDate.valueOf(20190301));
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.JPY);
                keiyakuKihonBean.setSakuseiKijyunYmd(BizDate.valueOf(20190325));
                keiyakuKihonBean.setYakkanBunsyoNo("1234567890");
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuKihonBean.setAisyoumeiKbn(C_AisyoumeiKbn.GAIKARIRITUHENDOUNK_MDHN);
                keiyakuKihonBean.setSyouhnNm("商品名商品名");
                keiyakuKihonBean.setKykYmd(BizDate.valueOf(20190301));
                keiyakuKihonBean.setKykTuukasyu(C_Tuukasyu.USD);
                keiyakuKihonBean.setSakuseiKijyunYmd(BizDate.valueOf(20190325));
                keiyakuKihonBean.setYakkanBunsyoNo("1234567890");
            }
            return keiyakuKihonBean;
        }

        return super.getKykKihon(pSyoNo);
    }

    @Override
    public KeiyakusyaBean getKykSya(String pSyoNo) {

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
            else if (TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN) ||
                TESTPATTERN8.equals(SYORIPTN) ||
                TESTPATTERN9.equals(SYORIPTN)) {
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

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

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
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(BizDate.valueOf(19990101));
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakusyaBean.setKykNmKn("カナカナ");
                keiyakusyaBean.setKykNmKj("林さん");
                keiyakusyaBean.setKykseiYmd(BizDate.valueOf(19990101));
                keiyakusyaBean.setKyksei(C_Kyksei.HJNKYK);
            }
            return keiyakusyaBean;
        }

        return super.getKykSya(pSyoNo);
    }

    @Override
    public HihokensyaBean getHhknSya(String pSyoNo) {

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
            else if (TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN) ||
                TESTPATTERN8.equals(SYORIPTN) ||
                TESTPATTERN9.equals(SYORIPTN)) {

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

        if (DwGetHozenKiykGikHijynNnknImplTest_execPostForm.class == caller) {

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
                hihokensyaBean.setHhknseiYmd(BizDate.valueOf(19990201));
            }
            else if (TESTPATTERN6.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
                hihokensyaBean.setHhknNmKn("サシサシ");
            }
            return hihokensyaBean;
        }

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

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
                hihokensyaBean.setHhknNmKn("サシサシ");
                hihokensyaBean.setHhknseiYmd(BizDate.valueOf(19990201));
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);
                hihokensyaBean.setHhknNmKn("サシサシ");
                hihokensyaBean.setHhknseiYmd(BizDate.valueOf(19990201));
            }
            return hihokensyaBean;
        }

        return super.getHhknSya(pSyoNo);
    }

    @Override
    public KeiyakuUketorininBean getKykUkt(String pSyoNo) {

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
            else if (TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN6.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN) ||
                TESTPATTERN8.equals(SYORIPTN) ||
                TESTPATTERN9.equals(SYORIPTN)) {
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

        if (DsGetKeiyakuSyousaiTest_exec.class == caller) {
            KeiyakuUketorininBean keiyakuUketorininBean = new KeiyakuUketorininBean();

            if (TESTPATTERN1.equals(SYORIPTN)) {
                keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);
                keiyakuUketorininBean.setSbuktnin(2);
                keiyakuUketorininBean.setUktsyuKbn1(C_UktsyuKbn.SBUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn1(C_GkdtKoktuutiUktKbn.KYK);
                keiyakuUketorininBean.setUktNm1("");
                keiyakuUketorininBean.setUktsyuKbn2(C_UktsyuKbn.SBUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn2(C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                keiyakuUketorininBean.setUktNm2("ウウ");
                keiyakuUketorininBean.setUktsyuKbn3(C_UktsyuKbn.SBUKT);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn3(C_GkdtKoktuutiUktKbn.BLNK);
                keiyakuUketorininBean.setUktNm3("");
                keiyakuUketorininBean.setUktsyuKbn4(C_UktsyuKbn.BLNK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn4(C_GkdtKoktuutiUktKbn.BLNK);
                keiyakuUketorininBean.setUktNm4("");
                keiyakuUketorininBean.setUktsyuKbn5(C_UktsyuKbn.BLNK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn5(C_GkdtKoktuutiUktKbn.BLNK);
                keiyakuUketorininBean.setUktNm5("");
                keiyakuUketorininBean.setUktsyuKbn6(C_UktsyuKbn.BLNK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn6(C_GkdtKoktuutiUktKbn.BLNK);
                keiyakuUketorininBean.setUktNm6("");
                keiyakuUketorininBean.setUktsyuKbn7(C_UktsyuKbn.BLNK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn7(C_GkdtKoktuutiUktKbn.BLNK);
                keiyakuUketorininBean.setUktNm7("");
                keiyakuUketorininBean.setUktsyuKbn8(C_UktsyuKbn.BLNK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn8(C_GkdtKoktuutiUktKbn.BLNK);
                keiyakuUketorininBean.setUktNm8("");
                keiyakuUketorininBean.setUktsyuKbn9(C_UktsyuKbn.BLNK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn9(C_GkdtKoktuutiUktKbn.BLNK);
                keiyakuUketorininBean.setUktNm9("");
                keiyakuUketorininBean.setUktsyuKbn10(C_UktsyuKbn.BLNK);
                keiyakuUketorininBean.setGkdtKoktuutiUktKbn10(C_GkdtKoktuutiUktKbn.BLNK);
                keiyakuUketorininBean.setUktNm10("");
            }
            return keiyakuUketorininBean;
        }

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            KeiyakuUketorininBean keiyakuUketorininBean = new KeiyakuUketorininBean();
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

            return keiyakuUketorininBean;
        }

        return super.getKykUkt(pSyoNo);
    }


    @Override
    public C_ErrorKbn getUketoriKouza(String pSyoNo) {

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {
            if (TESTPATTERN5.equals(SYORIPTN) ||
                TESTPATTERN7.equals(SYORIPTN) ||
                TESTPATTERN8.equals(SYORIPTN)) {

                return C_ErrorKbn.OK;
            }
            else if (TESTPATTERN9.equals(SYORIPTN) ) {

                return C_ErrorKbn.ERROR;
            }
        }

        return super.getUketoriKouza(pSyoNo);

    }

    @Override
    public List<UketoriKouzaBean> getUketoriKouzaBeanList() {
        List<UketoriKouzaBean> uketoriKouzaBeanList = new ArrayList<UketoriKouzaBean>();
        UketoriKouzaBean uketoriKouzaBean = new UketoriKouzaBean();

        if (DwGetHozenKiykGikItijiNnknImplTest_execPostForm.class == caller) {
            if (TESTPATTERN5.equals(SYORIPTN)) {

                uketoriKouzaBean.setUktsyuKbn(C_UktsyuKbn.KYKDRN);
                UketoriKouzaBean uketoriKouzaBean2 = new UketoriKouzaBean();

                uketoriKouzaBean2.setUktsyuKbn(C_UktsyuKbn.TKSHKUKT);
                uketoriKouzaBean2.setKzsyuruiKbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                uketoriKouzaBean2.setBankCd("0001");
                uketoriKouzaBean2.setSitenCd("001");
                uketoriKouzaBean2.setBankNmkj("受取人ユ受名　一えウ受取人ユ受名　一えウ受取人ユ受名　一えウ");
                uketoriKouzaBean2.setSitenNmkj("受取人ユ受名　一えウ受取人ユ受名　一えウ受取人ユ受名　一ウえ");
                uketoriKouzaBean2.setYokinKbn(C_YokinKbn.TTYOKIN);
                uketoriKouzaBean2.setKouzaNo("213456789012");
                uketoriKouzaBean2.setKzmeigiNmkn("ユ受名受取人　一えウ受取人ユ受名　一えウ受取人ユ受名　一ウえ");

                uketoriKouzaBeanList.add(uketoriKouzaBean);
                uketoriKouzaBeanList.add(uketoriKouzaBean2);

                return uketoriKouzaBeanList;
            }
            else if (TESTPATTERN7.equals(SYORIPTN) ) {
                uketoriKouzaBean.setUktsyuKbn(C_UktsyuKbn.KYKDRN);
                uketoriKouzaBean.setKzsyuruiKbn(C_KouzasyuruiKbn.GAIKAKOUZA);
                uketoriKouzaBean.setBankCd("0001");
                uketoriKouzaBean.setSitenCd("001");
                uketoriKouzaBean.setBankNmkj("受取人ユ受名　一え");
                uketoriKouzaBean.setSitenNmkj("受取人ユ受名　二え");
                uketoriKouzaBean.setYokinKbn(C_YokinKbn.TTYOKIN);
                uketoriKouzaBean.setKouzaNo("213456789012");
                uketoriKouzaBean.setKzmeigiNmkn("シウケメイ　イチエ");

                uketoriKouzaBeanList.add(uketoriKouzaBean);

                return uketoriKouzaBeanList;
            }
            else if (TESTPATTERN8.equals(SYORIPTN) ) {

                return uketoriKouzaBeanList;
            }
        }

        return super.getUketoriKouzaBeanList();
    }

    @Override
    public HokenKikanBean getHokenKikan(String pSyoNo) {

        if (DwGetHozenKykSntkHijynSysnImplTest_execPostForm.class == caller) {

            HokenKikanBean hokenKikanBean = SWAKInjector.getInstance(HokenKikanBean.class);
            hokenKikanBean.setHknkknkaisiymd1(BizDate.valueOf("20170424"));
            hokenKikanBean.setHknkknmanryouymd1(BizDate.valueOf("20200423"));
            hokenKikanBean.setDai1hknkkn(99);
            hokenKikanBean.setHknkknkaisiymd2(BizDate.valueOf("20200424"));
            return hokenKikanBean;
        }

        return super.getHokenKikan(pSyoNo);
    }
}
