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
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約保全処理中チェックのメソッド{@link ChkSubKhSyorityuu#exec(JT_SiKykKihon, List<ChkKekkaBean>)}テスト用クラスです。<br/>
 */
@RunWith(OrderedRunner.class)
public class ChkSubKhSyorityuuTest_exec {

    @Inject
    private ChkSubKhSyorityuu chkSubKhSyorityuu;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約保全処理中チェック";

    private final static String sheetName = "テストデータ";


    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckSbSkNaiyouTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllChkSiJimuttdk());

    }

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
    public static void testInit() {
        BzGetProcessSummaryMockForSiharai.caller = ChkSubKhSyorityuuTest_exec.class;

    }


    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.caller = null;
        BzGetProcessSummaryMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN1;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setSyono("SN001231");
        chkSubKhSyorityuu.exec(jTSiKykKihon, "siseikyuuuketukesb", chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN2;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setSyono("SN001232");
        chkSubKhSyorityuu.exec(jTSiKykKihon, "siseikyuuuketukesb", chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KHSYORITYUU_KAIYK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "解約", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN3;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setSyono("SN001233");
        chkSubKhSyorityuu.exec(jTSiKykKihon, "siseikyuuuketukesb", chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 5, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KHSYORITYUU_GENGAKU,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "減額", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KHSYORITYUU_STDRSKTKYTTHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "指定代理請求特約中途付加", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KHSYORITYUU_JDKIGMBRTKYKHNK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu1(), "重度介護前払特約変更", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(3).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KHSYORITYUU_MKHGKHNK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu1(), "目標額変更", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(4).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KHSYORITYUU_TMTTKINITEN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu1(), "積立金移転", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN4;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setSyono("SN001234");
        chkSubKhSyorityuu.exec(jTSiKykKihon, "siseikyuuuketukesb", chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSiharai.SYORIPTN = BzGetProcessSummaryMockForSiharai.TESTPATTERN5;

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setSyono("SN001234");
        chkSubKhSyorityuu.exec(jTSiKykKihon, "siseikyuuuketukesb", chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }
}
