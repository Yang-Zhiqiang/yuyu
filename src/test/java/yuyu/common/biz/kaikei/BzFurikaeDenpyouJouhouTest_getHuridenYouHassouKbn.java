package yuyu.common.biz.kaikei;


import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HuridenYouHassouKbn;
import yuyu.def.classification.C_KeirisysKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 振替伝票情報クラスのメソッド {@link BzFurikaeDenpyouJouhouTest#getHuridenYouHassouKbn()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFurikaeDenpyouJouhouTest_getHuridenYouHassouKbn {

    @Inject
    private BzFurikaeDenpyouJouhou bzFurikaeDenpyouJouhou;

    @Inject
    private YuyuBizConfig yuyuBizConfig;

    @Test
    @TestOrder(10)
    public void testGetHuridenYouHassouKbn_A1() {
        yuyuBizConfig = YuyuBizConfig.getInstance();
        yuyuBizConfig.setHuridenyouhassoukbn1tantousitucd("516");
        String tantouBusitucd = "516";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI1, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(20)
    public void testGetHuridenYouHassouKbn_A2() {
        yuyuBizConfig = YuyuBizConfig.getInstance();
        yuyuBizConfig.setHuridenyouhassoukbn2tantousitucd("564");
        String tantouBusitucd = "564";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI2, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(30)
    public void testGetHuridenYouHassouKbn_A3() {
        yuyuBizConfig = YuyuBizConfig.getInstance();
        yuyuBizConfig.setHuridenyouhassoukbn3tantousitucd("565");
        String tantouBusitucd = "565";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI3, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(40)
    public void testGetHuridenYouHassouKbn_A4() {
        yuyuBizConfig = YuyuBizConfig.getInstance();
        yuyuBizConfig.setHuridenyouhassoukbn4tantousitucd("727");
        String tantouBusitucd = "727";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI4, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(50)
    public void testGetHuridenYouHassouKbn_A5() {
        yuyuBizConfig = YuyuBizConfig.getInstance();
        yuyuBizConfig.setHuridenyouhassoukbn5tantousitucd("750");
        String tantouBusitucd = "750";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI5, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(60)
    public void testGetHuridenYouHassouKbn_A6() {
        yuyuBizConfig = YuyuBizConfig.getInstance();
        yuyuBizConfig.setHuridenyouhassoukbn6tantousitucd("590");
        String tantouBusitucd = "590";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI6, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(70)
    public void testGetHuridenYouHassouKbn_A7() {
        yuyuBizConfig = YuyuBizConfig.getInstance();
        yuyuBizConfig.setHuridenyouhassoukbn7tantousitucd("551");
        String tantouBusitucd = "551";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI7, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(80)
    public void testGetHuridenYouHassouKbn_A8() {
        yuyuBizConfig = YuyuBizConfig.getInstance();
        yuyuBizConfig.setHuridenyouhassoukbn8tantousitucd("888");
        String tantouBusitucd = "888";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI8, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(90)
    public void testGetHuridenYouHassouKbn_A9() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        String tantouBusitucd = "999";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI3, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(100)
    public void testGetHuridenYouHassouKbn_A10() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.KESSANSINKEIYAKU);
        String tantouBusitucd = "999";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI3, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(110)
    public void testGetHuridenYouHassouKbn_A11() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.FUHO);
        String tantouBusitucd = "999";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI1, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(120)
    public void testGetHuridenYouHassouKbn_A12() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.SINKEIYAKU);
        String tantouBusitucd = "000";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI3, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(130)
    public void testGetHuridenYouHassouKbn_A13() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.KESSANSINKEIYAKU);
        String tantouBusitucd = "000";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI3, "振替伝票用発送区分");
    }

    @Test
    @TestOrder(140)
    public void testGetHuridenYouHassouKbn_A14() {
        bzFurikaeDenpyouJouhou.setKeiriSysKbn(C_KeirisysKbn.FUHO);
        String tantouBusitucd = "000";

        C_HuridenYouHassouKbn huridenYouHassouKbn = bzFurikaeDenpyouJouhou.getHuridenYouHassouKbn(tantouBusitucd);

        exClassificationEquals(huridenYouHassouKbn, C_HuridenYouHassouKbn.HASSOUSAKI1, "振替伝票用発送区分");
    }

    @AfterClass
    public static void testClear(){

        YuyuBizConfig.getInstance().setHuridenyouhassoukbn7tantousitucd("000");
        YuyuBizConfig.getInstance().setHuridenyouhassoukbn8tantousitucd("000");
    }
}
