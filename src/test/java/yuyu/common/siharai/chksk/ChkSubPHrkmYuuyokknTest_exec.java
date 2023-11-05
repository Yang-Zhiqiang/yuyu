package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngaiMockForSiharai;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険料払込猶予期間チェックのメソッド{@link ChkSubPHrkmYuuyokkn#exec(BizDate, String, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubPHrkmYuuyokknTest_exec {

    @Inject
    private ChkSubPHrkmYuuyokkn chkSubPHrkmYuuyokkn;


    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckYuuyokkngai.class).to(CheckYuuyokkngaiMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CheckYuuyokkngaiMockForSiharai.caller = ChkSubPHrkmYuuyokknTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        CheckYuuyokkngaiMockForSiharai.caller = null;
        CheckYuuyokkngaiMockForSiharai.SYORIPTN = null;
    }


    @Test
    @TestOrder(10)
    public void testExec_A1() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        BizDate hanteiKijyunYmd = null;
        String syono = "17806000013";

        chkSubPHrkmYuuyokkn.exec(hanteiKijyunYmd, syono, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");
    }


    @Test
    @TestOrder(20)
    public void testExec_A2() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        BizDate hanteiKijyunYmd = BizDate.valueOf("20181108");
        String syono = null;

        chkSubPHrkmYuuyokkn.exec(hanteiKijyunYmd, syono, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");
    }


    @Test
    @TestOrder(30)
    public void testExec_A3() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        BizDate hanteiKijyunYmd = BizDate.valueOf("20181108");
        String syono = "";

        chkSubPHrkmYuuyokkn.exec(hanteiKijyunYmd, syono, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");
    }


    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        CheckYuuyokkngaiMockForSiharai.SYORIPTN = CheckYuuyokkngaiMockForSiharai.TESTPATTERN1;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        BizDate hanteiKijyunYmd = BizDate.valueOf("20181108");
        String syono = "17806000013";

        chkSubPHrkmYuuyokkn.exec(hanteiKijyunYmd, syono, chkKekkaBeanLst);

        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.PHRKYUYOKKN_CHK, "請求内容チェック区分");

        MockObjectManager.assertArgumentPassed(CheckYuuyokkngaiMockForSiharai.class, "exec", 0, "17806000013");
        MockObjectManager.assertArgumentPassed(CheckYuuyokkngaiMockForSiharai.class, "exec", 1, BizDate.valueOf("20181108"));
    }


    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        CheckYuuyokkngaiMockForSiharai.SYORIPTN = CheckYuuyokkngaiMockForSiharai.TESTPATTERN2;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        BizDate hanteiKijyunYmd = BizDate.valueOf("20181108");
        String syono = "17806000013";

        chkSubPHrkmYuuyokkn.exec(hanteiKijyunYmd, syono, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "チェック結果Beanリストの件数");
    }
}
