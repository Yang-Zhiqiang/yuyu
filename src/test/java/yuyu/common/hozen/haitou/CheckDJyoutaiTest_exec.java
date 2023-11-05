package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 配当状態判定クラスのメソッド {@link CheckDJyoutai#execForHaitouJyoutaiHantei(BizDate, BizDate, BizDate,BizDateY)}、<br />
 * {@link CheckDJyoutai#execForMibaraiHaitouHantei(BizDate, BizDate, BizDate,BizDateY)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDJyoutaiTest_exec {

    @Inject
    CheckDJyoutai checkDJyoutai;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetHokenNnd.class).to(SetHokenNndMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        SetHokenNndMockForHozen.caller = CheckDJyoutaiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        SetHokenNndMockForHozen.caller = null;
        SetHokenNndMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate hanteiKijyunymd = BizDate.valueOf(20170921);
        BizDate keiyakuymd = BizDate.valueOf(20170922);
        BizDate endataihenkoymd = BizDate.valueOf(20170920);
        BizDateY haitouNendo = null;

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);
        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI, "配当状態判定区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;
        BizDate hanteiKijyunymd = BizDate.valueOf(20180227);
        BizDate keiyakuymd = BizDate.valueOf(20180227);
        BizDate endataihenkoymd = null;
        BizDateY haitouNendo = null;

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);
        exClassificationEquals(haitoujyoutaiHanteiKbn, null, "配当状態判定区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        BizDate hanteiKijyunymd = BizDate.valueOf(20150228);
        BizDate keiyakuymd = BizDate.valueOf(20150228);
        BizDate endataihenkoymd = null;
        BizDateY haitouNendo = null;

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI, "配当状態判定区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN3;

        BizDate hanteiKijyunymd = BizDate.valueOf(20150402);
        BizDate keiyakuymd = BizDate.valueOf(20150402);
        BizDate endataihenkoymd = null;
        BizDateY haitouNendo = null;

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI, "配当状態判定区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN3;
        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = null;
        BizDateY haitouNendo = BizDateY.valueOf(2015);

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_MITOURAI, "配当状態判定区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN4;
        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = null;
        BizDateY haitouNendo = BizDateY.valueOf(2015);

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_TIENNASI, "配当状態判定区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN3;
        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = BizDate.valueOf(20160103);
        BizDateY haitouNendo = null;

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_SUMI, "配当状態判定区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN4;
        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = BizDate.valueOf(20160103);
        BizDateY haitouNendo = null;

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_TIENNASI, "配当状態判定区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN5;
        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = BizDate.valueOf(20160103);
        BizDateY haitouNendo = null;

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_TIEN1, "配当状態判定区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN6;
        BizDate hanteiKijyunymd = BizDate.valueOf(20161029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = BizDate.valueOf(20180103);
        BizDateY haitouNendo = BizDateY.valueOf(2012);

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_TIEN2, "配当状態判定区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN7;
        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = BizDate.valueOf(20110103);
        BizDateY haitouNendo = BizDateY.valueOf(2011);

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_TIEN2, "配当状態判定区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;
        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = BizDate.valueOf(20151020);
        BizDateY haitouNendo = BizDateY.valueOf(2016);

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(haitoujyoutaiHanteiKbn, C_HaitoujyoutaiHanteiKbn.DHANEI_SUMI, "配当状態判定区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BizDate hanteiKijyunymd = null;
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = BizDate.valueOf(20151020);
        BizDateY haitouNendo = BizDateY.valueOf(2016);

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDJyoutai.getErrorInfo();
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDJyoutai.getClass().getSimpleName(), "エラーコード");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");

        exClassificationEquals(haitoujyoutaiHanteiKbn, null, "配当状態判定区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = null;
        BizDate endataihenkoymd = BizDate.valueOf(20151020);
        BizDateY haitouNendo = BizDateY.valueOf(2016);

        C_HaitoujyoutaiHanteiKbn haitoujyoutaiHanteiKbn =checkDJyoutai.execForHaitouJyoutaiHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDJyoutai.getErrorInfo();
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDJyoutai.getClass().getSimpleName(), "エラーコード");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");

        exClassificationEquals(haitoujyoutaiHanteiKbn, null, "配当状態判定区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_B1() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN3;
        BizDate hanteiKijyunymd = BizDate.valueOf(20160228);
        BizDate keiyakuymd = BizDate.valueOf(20160228);
        BizDate endataihenkoymd = null;
        BizDateY haitouNendo = null;

        C_UmuKbn c_UmuKbn =checkDJyoutai.execForMibaraiHaitouHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(c_UmuKbn, C_UmuKbn.NONE, "未払配当金有無");
    }

    @Test
    @TestOrder(160)
    public void testExec_B2() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN3;
        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = BizDate.valueOf(20160103);
        BizDateY haitouNendo = null;

        C_UmuKbn c_UmuKbn =checkDJyoutai.execForMibaraiHaitouHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(c_UmuKbn, C_UmuKbn.NONE, "未払配当金有無");
    }

    @Test
    @TestOrder(170)
    public void testExec_B3() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN6;
        BizDate hanteiKijyunymd = BizDate.valueOf(20151029);
        BizDate keiyakuymd = BizDate.valueOf(20150929);
        BizDate endataihenkoymd = BizDate.valueOf(20170103);
        BizDateY haitouNendo = BizDateY.valueOf(2015);

        C_UmuKbn c_UmuKbn =checkDJyoutai.execForMibaraiHaitouHantei(hanteiKijyunymd,keiyakuymd, endataihenkoymd,
            haitouNendo);

        exClassificationEquals(c_UmuKbn, C_UmuKbn.ARI, "未払配当金有無");
    }
}