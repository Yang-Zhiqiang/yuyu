package yuyu.common.suuri.srcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Test;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.testinfr.TestOrder;

/**
 * SrFindTekiyouCategoryクラスのメソッド {@link SrFindTekiyouCategory#getAppropriateTekiyou(C_Kanjyoukmkcd,C_TekiyouKbn,C_NaibuKeiyakuKbn,C_Segcd,String)}テスト用クラスです<br />
 */
public class SrFindTekiyouCategoryTest_getAppropriateTekiyou {

    @Test
    @TestOrder(10)
    public void testGetAppropriateTekiyou_A1() {

        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_JPY;
        C_TekiyouKbn tekiyouKbn = C_TekiyouKbn.BLNK;
        C_NaibuKeiyakuKbn naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;
        C_Segcd segcd = null;
        String str = "ケース１セグメント名";

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean bean = srFindTekiyouCategory.getAppropriateTekiyou(
            kanjyoukmkcd, tekiyouKbn, naibuKeiyakuKbn, segcd, str);

        exStringEquals(bean.getTekiyoucd(), "", "摘要コード");
        exStringEquals(bean.getTekiyounm(), "", "摘要名");
    }


    @Test
    @TestOrder(20)
    public void testGetAppropriateTekiyou_A2() {

        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_JPY;
        C_TekiyouKbn tekiyouKbn = C_TekiyouKbn.BLNK;
        C_NaibuKeiyakuKbn naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;
        C_Segcd segcd = C_Segcd.BLNK;
        String str = "ケース２セグメント名";

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean bean = srFindTekiyouCategory.getAppropriateTekiyou(
            kanjyoukmkcd, tekiyouKbn, naibuKeiyakuKbn, segcd, str);

        exStringEquals(bean.getTekiyoucd(), "", "摘要コード");
        exStringEquals(bean.getTekiyounm(), "", "摘要名");
    }


    @Test
    @TestOrder(30)
    public void testGetAppropriateTekiyou_A3() {

        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_JPY;
        C_TekiyouKbn tekiyouKbn = C_TekiyouKbn.BLNK;
        C_NaibuKeiyakuKbn naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;
        C_Segcd segcd = C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI;
        String str = "ケース４セグメント名";

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean bean = srFindTekiyouCategory.getAppropriateTekiyou(
            kanjyoukmkcd, tekiyouKbn, naibuKeiyakuKbn, segcd, str);

        exStringEquals(bean.getTekiyoucd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI.getValue(), "摘要コード");
        exStringEquals(bean.getTekiyounm(), "ケース４セグメント名", "摘要名");
    }

    @Test
    @TestOrder(40)
    public void testGetAppropriateTekiyou_A4() {

        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.JIGYOUHI;
        C_TekiyouKbn tekiyouKbn = C_TekiyouKbn.BLNK;
        C_NaibuKeiyakuKbn naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;
        C_Segcd segcd = null;
        String str = "ケース５セグメント名";

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean bean = srFindTekiyouCategory.getAppropriateTekiyou(
            kanjyoukmkcd, tekiyouKbn, naibuKeiyakuKbn, segcd, str);

        exStringEquals(bean.getTekiyoucd(), "", "摘要コード");
        exStringEquals(bean.getTekiyounm(), "", "摘要名");
    }


    @Test
    @TestOrder(50)
    public void testGetAppropriateTekiyou_A5() {

        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.JIGYOUHI;
        C_TekiyouKbn tekiyouKbn = C_TekiyouKbn.BLNK;
        C_NaibuKeiyakuKbn naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;
        C_Segcd segcd = C_Segcd.BLNK;
        String str = "ケース７セグメント名";

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean bean = srFindTekiyouCategory.getAppropriateTekiyou(
            kanjyoukmkcd, tekiyouKbn, naibuKeiyakuKbn, segcd, str);

        exStringEquals(bean.getTekiyoucd(), "", "摘要コード");
        exStringEquals(bean.getTekiyounm(), "", "摘要名");
    }

    @Test
    @TestOrder(60)
    public void testGetAppropriateTekiyou_A6() {

        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.JIGYOUHI;
        C_TekiyouKbn tekiyouKbn = C_TekiyouKbn.BLNK;
        C_NaibuKeiyakuKbn naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;
        C_Segcd segcd = C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI;
        String str = "ケース８セグメント名";

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean bean = srFindTekiyouCategory.getAppropriateTekiyou(
            kanjyoukmkcd, tekiyouKbn, naibuKeiyakuKbn, segcd, str);

        exStringEquals(bean.getTekiyoucd(), "", "摘要コード");
        exStringEquals(bean.getTekiyounm(), "", "摘要名");
        MockObjectManager.initialize();
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

}
