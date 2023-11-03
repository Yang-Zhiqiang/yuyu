package yuyu.common.suuri.srcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Test;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.testinfr.TestOrder;

/**
 * SrFindTekiyouCategoryクラスのメソッド {@link SrFindTekiyouCategory#getAppropriateTekiyouCom(C_Kanjyoukmkcd,C_TekiyouKbn,C_NaibuKeiyakuKbn)}テスト用クラスです<br />
 */
public class SrFindTekiyouCategoryTest_getAppropriateTekiyouCom {

    @Test
    @TestOrder(10)
    public void testGetAppropriateTekiyouCom_A1() {

        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_JPY;
        C_TekiyouKbn tekiyouKbn = C_TekiyouKbn.BLNK;
        C_NaibuKeiyakuKbn naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean bean = srFindTekiyouCategory.getAppropriateTekiyouCom(
            kanjyoukmkcd, tekiyouKbn, naibuKeiyakuKbn);

        exStringEquals(bean.getTekiyoucd(), "", "摘要コード");
        exStringEquals(bean.getTekiyounm(), "", "摘要名");

    }

    @Test
    @TestOrder(20)
    public void testGetAppropriateTekiyouCom_A2() {

        C_Kanjyoukmkcd kanjyoukmkcd = C_Kanjyoukmkcd.JIGYOUHI;
        C_TekiyouKbn tekiyouKbn = C_TekiyouKbn.BLNK;
        C_NaibuKeiyakuKbn naibuKeiyakuKbn = C_NaibuKeiyakuKbn.BLNK;

        SrFindTekiyouCategory srFindTekiyouCategory = SWAKInjector.getInstance(SrFindTekiyouCategory.class);
        SrFindTekiyouCategoryBean bean = srFindTekiyouCategory.getAppropriateTekiyouCom(
            kanjyoukmkcd, tekiyouKbn, naibuKeiyakuKbn);

        exStringEquals(bean.getTekiyoucd(), "", "摘要コード");
        exStringEquals(bean.getTekiyounm(), "", "摘要名");
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

}
