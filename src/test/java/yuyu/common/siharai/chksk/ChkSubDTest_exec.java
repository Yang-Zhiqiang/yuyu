package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.haitou.CheckDShrSibou;
import yuyu.common.hozen.haitou.CheckDShrSibouMockForSiharai;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 配当金チェッククラスのメソッド {@link ChkSubD#exec(BizDate, String, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubDTest_exec {

    @Inject
    private ChkSubD chkSubD;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckDShrSibou.class).to(CheckDShrSibouMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        CheckDShrSibouMockForSiharai.caller = ChkSubDTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        CheckDShrSibouMockForSiharai.caller = null;
        CheckDShrSibouMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubD.exec(null, "11810111118", chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubD.exec(BizDate.valueOf(20181107), null, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubD.exec(BizDate.valueOf(20181107), "", chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");

    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();
        CheckDShrSibouMockForSiharai.SYORIPTN = CheckDShrSibouMockForSiharai.TESTPATTERN1;
        try {

            List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

            chkSubD.exec(BizDate.valueOf(20181107), "11810111141", chkKekkaBeanLst);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();
        CheckDShrSibouMockForSiharai.SYORIPTN = CheckDShrSibouMockForSiharai.TESTPATTERN2;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubD.exec(BizDate.valueOf(20181107), "11810111141", chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 3, "チェック結果Beanリストの件数");
        ChkKekkaBean chkKekkaBean0 = chkKekkaBeanLst.get(0);
        ChkKekkaBean chkKekkaBean1 = chkKekkaBeanLst.get(1);
        ChkKekkaBean chkKekkaBean2 = chkKekkaBeanLst.get(2);
        exStringEquals(chkKekkaBean0.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean0.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean0.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean0.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean0.getMsgHikisuu5(), "", "メッセージ引数5");

        exStringEquals(chkKekkaBean1.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean1.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean1.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean1.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean1.getMsgHikisuu5(), "", "メッセージ引数5");

        exStringEquals(chkKekkaBean2.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBean2.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBean2.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBean2.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBean2.getMsgHikisuu5(), "", "メッセージ引数5");

        exClassificationEquals(chkKekkaBean0.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.D_SEIGOUSEI_CHK,
            "請求内容チェック区分");

        exClassificationEquals(chkKekkaBean1.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.D_MIHANEI_CHK,
            "請求内容チェック区分");

        exClassificationEquals(chkKekkaBean2.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.D_SHRYMDUMU_CHK,
            "請求内容チェック区分");


        MockObjectManager.assertArgumentPassed(CheckDShrSibouMockForSiharai.class, "checkDShr", 0, "11810111141");
        MockObjectManager.assertArgumentPassed(CheckDShrSibouMockForSiharai.class, "checkDShr", 1, BizDate.valueOf(20181107));
        MockObjectManager.assertArgumentPassed(CheckDShrSibouMockForSiharai.class, "checkDShr", 2, BizDate.getSysDate());
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();
        CheckDShrSibouMockForSiharai.SYORIPTN = CheckDShrSibouMockForSiharai.TESTPATTERN3;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubD.exec(BizDate.valueOf(20181107), "11810111141", chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");
    }

}
