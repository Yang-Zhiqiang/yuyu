package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSiharai;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 同時請求処理中チェックのメソッド {@link ChkSubDoujiSeikyuuSyori#exec(JT_SkKihon, JT_SiKykKihon, List<ChkKekkaBean>)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubDoujiSeikyuuSyoriTest_exec {

    @Inject
    private ChkSubDoujiSeikyuuSyori chkSubDoujiSeikyuuSyori;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_同時請求処理中チェック";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        BzGetProcessSummaryMockForSiharai.caller = ChkSubDoujiSeikyuuSyoriTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.caller = null;
        BzGetProcessSummaryMockForSiharai.SYORIPTN = null;
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiSKNaiyouChkkekkaSetteiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SN001011");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("SN001001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubDoujiSeikyuuSyori.exec(skKihon, siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 3, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.DOUJISKSYORITYUU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "SN002001", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.DOUJISKSYORITYUU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu1(), "SN002002", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = "2";

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SN001011");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("SN001001");

        chkSubDoujiSeikyuuSyori.exec(skKihon, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.DOUJISKSYORITYUU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "SN002001", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = "3";

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SN001011");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("SN001001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");

        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubDoujiSeikyuuSyori.exec(skKihon, siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.DOUJISKSYORITYUU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "SN002001", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = "4";

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SN001011");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("SN001001");

        chkSubDoujiSeikyuuSyori.exec(skKihon, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = "5";

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SN001011");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("SN001001");

        chkSubDoujiSeikyuuSyori.exec(skKihon, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(60)
    public void testExec_B1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SN001012");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("SN001001");

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubDoujiSeikyuuSyori.exec(skKihon, siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 3, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.DOUJISKSYORITYUU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "SN002001", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.DOUJISKSYORITYUU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu1(), "SN002002", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(70)
    public void testExec_B2() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        JT_SkKihon skKihon = new JT_SkKihon();
        skKihon.setSkno("SN001013");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("SN001001");

        chkSubDoujiSeikyuuSyori.exec(skKihon, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

}
