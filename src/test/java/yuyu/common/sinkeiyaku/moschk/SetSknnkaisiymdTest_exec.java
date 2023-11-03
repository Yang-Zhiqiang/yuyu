package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 責任開始日設定クラスのメソッド {@link SetSknnkaisiymd#exec(C_SntkhouKbn, BizDate, BizDate, BizDate, C_SknnkaisikitkhukaKbn, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSknnkaisiymdTest_exec {

    @Inject
    private SetSknnkaisiymd setSknnkaisiymd;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        try{
            setSknnkaisiymd.exec(C_SntkhouKbn.BLNK, null, null, null, C_SknnkaisikitkhukaKbn.BLNK, null);
        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "責任開始日設定 必須エラー", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_B1() {

        BizDate pMosYmd = BizDate.valueOf("20150603");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, null, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, null);
        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();
        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150603"), "仮責任開始日");
    }

    @Test
    @TestOrder(30)
    public void testExec_B2() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pMosUkeYmd = BizDate.valueOf("20150605");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, null, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, pMosUkeYmd);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150605"), "仮責任開始日");
    }

    @Test
    @TestOrder(40)
    public void testExec_B3() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pMosUkeYmd = BizDate.valueOf("20150602");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, null, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, pMosUkeYmd);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150603"), "仮責任開始日");
    }

    @Test
    @TestOrder(50)
    public void testExec_B4() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pMosUkeYmd = BizDate.valueOf("20150603");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, null, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, pMosUkeYmd);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150603"), "仮責任開始日");
    }

    @Test
    @TestOrder(60)
    public void testExec_B5() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pKktYmd = BizDate.valueOf("20150604");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150604"), "仮責任開始日");
    }

    @Test
    @TestOrder(70)
    public void testExec_B6() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pKktYmd = BizDate.valueOf("20150601");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150603"), "仮責任開始日");
    }

    @Test
    @TestOrder(80)
    public void testExec_B7() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pKktYmd = BizDate.valueOf("20150603");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150603"), "仮責任開始日");

    }

    @Test
    @TestOrder(90)
    public void testExec_B8() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pKktYmd = BizDate.valueOf("20150605");
        BizDate pMosUkeYmd = BizDate.valueOf("20150604");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, pMosUkeYmd);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, BizDate.valueOf("20150605"), "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150605"), "仮責任開始日");
    }

    @Test
    @TestOrder(100)
    public void testExec_B9() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pKktYmd = BizDate.valueOf("20150601");
        BizDate pMosUkeYmd = BizDate.valueOf("20150602");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, pMosUkeYmd);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, BizDate.valueOf("20150603"), "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150603"), "仮責任開始日");
    }

    @Test
    @TestOrder(110)
    public void testExec_B10() {

        BizDate pMosYmd = BizDate.valueOf("20150604");
        BizDate pKktYmd = BizDate.valueOf("20150604");
        BizDate pMosUkeYmd = BizDate.valueOf("20150604");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, pMosUkeYmd);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, BizDate.valueOf("20150604"), "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150604"), "仮責任開始日");
    }

    @Test
    @TestOrder(120)
    public void testExec_B11() {

        BizDate pMosYmd = BizDate.valueOf("20150604");
        BizDate pMosUkeYmd = BizDate.valueOf("20150604");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, null, pMosYmd, null, C_SknnkaisikitkhukaKbn.NONE, pMosUkeYmd);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150604"), "仮責任開始日");
    }

    @Test
    @TestOrder(130)
    public void testExec_B12() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pKktYmd = BizDate.valueOf("20150604");
        BizDate pRsYmd = BizDate.valueOf("20150606");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, pRsYmd, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, BizDate.valueOf("20150606"), "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150606"), "仮責任開始日");
    }

    @Test
    @TestOrder(140)
    public void testExec_B13() {

        BizDate pMosYmd = BizDate.valueOf("20150605");
        BizDate pKktYmd = BizDate.valueOf("20150605");
        BizDate pRsYmd = BizDate.valueOf("20150605");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, pRsYmd, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, BizDate.valueOf("20150605"), "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150605"), "仮責任開始日");
    }

    @Test
    @TestOrder(150)
    public void testExec_B14() {

        BizDate pMosYmd = BizDate.valueOf("20150605");
        BizDate pKktYmd = BizDate.valueOf("20150604");
        BizDate pRsYmd = BizDate.valueOf("20150603");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, pRsYmd, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, BizDate.valueOf("20150605"), "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150605"), "仮責任開始日");
    }

    @Test
    @TestOrder(160)
    public void testExec_B15() {

        BizDate pMosYmd = BizDate.valueOf("20150604");
        BizDate pKktYmd = BizDate.valueOf("20150605");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150605"), "仮責任開始日");
    }


    @Test
    @TestOrder(170)
    public void testExec_B16() {

        BizDate pMosYmd = BizDate.valueOf("20150605");
        BizDate pKktYmd = BizDate.valueOf("20150605");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150605"), "仮責任開始日");
    }

    @Test
    @TestOrder(180)
    public void testExec_B17() {

        BizDate pMosYmd = BizDate.valueOf("20150606");
        BizDate pKktYmd = BizDate.valueOf("20150605");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150606"), "仮責任開始日");
    }

    @Test
    @TestOrder(190)
    public void testExec_B18() {

        BizDate pMosYmd = BizDate.valueOf("20150604");
        BizDate pRsYmd = BizDate.valueOf("20150605");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, null, pMosYmd, pRsYmd, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150605"), "仮責任開始日");
    }

    @Test
    @TestOrder(200)
    public void testExec_B19() {

        BizDate pMosYmd = BizDate.valueOf("20150605");
        BizDate pRsYmd = BizDate.valueOf("20150605");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, null, pMosYmd, pRsYmd, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150605"), "仮責任開始日");
    }


    @Test
    @TestOrder(210)
    public void testExec_B20() {

        BizDate pMosYmd = BizDate.valueOf("20150606");
        BizDate pRsYmd = BizDate.valueOf("20150605");
        setSknnkaisiymd.setSknnkaisiymd(BizDate.valueOf("20160823"));
        setSknnkaisiymd.setKariSknnkaisiymd(BizDate.valueOf("20160823"));

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, null, pMosYmd, pRsYmd, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, null, "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150606"), "仮責任開始日");
    }

    @Test
    @TestOrder(220)
    public void testExec_B21() {

        BizDate pMosYmd = BizDate.valueOf("20150606");
        BizDate pRsYmd = BizDate.valueOf("20150605");
        BizDate pKktYmd = BizDate.valueOf("20150604");

        setSknnkaisiymd.exec(C_SntkhouKbn.NONE, pKktYmd, pMosYmd, pRsYmd, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, BizDate.valueOf("20150606"), "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150606"), "仮責任開始日");
    }

    @Test
    @TestOrder(230)
    public void testExec_B22() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pKktYmd = BizDate.valueOf("20150603");
        BizDate pMosUkeYmd = BizDate.valueOf("20150604");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, null, C_SknnkaisikitkhukaKbn.HUKA, pMosUkeYmd);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, BizDate.valueOf("20150604"), "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150604"), "仮責任開始日");
    }

    @Test
    @TestOrder(240)
    public void testExec_B23() {

        BizDate pMosYmd = BizDate.valueOf("20150603");
        BizDate pRsYmd = BizDate.valueOf("20150604");
        BizDate pKktYmd = BizDate.valueOf("20150605");

        setSknnkaisiymd.exec(C_SntkhouKbn.KKT, pKktYmd, pMosYmd, pRsYmd, C_SknnkaisikitkhukaKbn.NONE, null);

        BizDate sknnKaisiYmd = setSknnkaisiymd.getSknnkaisiymd();
        BizDate kariSknnKaisiYmd = setSknnkaisiymd.getKariSknnkaisiymd();

        exDateEquals(sknnKaisiYmd, BizDate.valueOf("20150605"), "責任開始日");
        exDateEquals(kariSknnKaisiYmd, BizDate.valueOf("20150605"), "仮責任開始日");
    }
}

