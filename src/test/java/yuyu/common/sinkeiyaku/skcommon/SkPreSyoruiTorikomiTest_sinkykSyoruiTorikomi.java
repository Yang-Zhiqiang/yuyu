package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForSinkeiyaku;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 新契約書類取込前処理 {@link SkPreSyoruiTorikomi#sinkykSyoruiTorikomi(
 * String, C_SyoruiCdKbn[], C_SkeijimuKbn, C_HknsyuruiNo, C_MosUketukeKbn, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkPreSyoruiTorikomiTest_sinkykSyoruiTorikomi {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約書類取込前処理";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {
        BzGetProcessSummaryMockForSinkeiyaku.caller = SkPreSyoruiTorikomiTest_sinkykSyoruiTorikomi.class;
        IwfKouteiClientMockForSinkeiyaku.caller = "Test";
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        IwfKouteiClientMockForSinkeiyaku.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkPreSyoruiTorikomiTest_sinkykSyoruiTorikomi.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTorikomiSyoruiHukaInfo());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiSyorui());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testSinkykSyoruiTorikomi_A1() {

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        IwfKouteiClientMockForSinkeiyaku.mode="01-05";

        String pMosNo = "860000017";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011010";

        SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd);

        exNumericEquals(strs.length, 0, "QRコード値配列．Length");

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("860000017");
        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "860000017", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.BLNK, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.BLNK, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "9011010", "代理店コード１");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testSinkykSyoruiTorikomi_A2() {

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        IwfKouteiClientMockForSinkeiyaku.mode="01-05";

        String pMosNo = "860000025";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{C_SyoruiCdKbn.WF_HYOUSI};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011020";

        SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd);

        exNumericEquals(strs.length, 1, "QRコード値配列．Length");
        exStringEquals(strs[0].substring(0, 4), "YUYU", "QRコード値配列[0]");

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("860000025");
        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "860000025", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.BLNK, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.BLNK, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "9011020", "代理店コード１");

        sinkeiyakuDomManager.flush();

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruLst =  sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("860000025");
        exNumericEquals(mosMikakuteiSyoruLst.size(), 1, "件数");

        HT_MosMikakuteiSyorui mosMikakuteiSyorui = mosMikakuteiSyoruLst.get(0);
        exStringEquals(mosMikakuteiSyorui.getDocumentid().substring(0, 4), "YUYU", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyorui.getMosno(), "860000025", "申込番号");
        exClassificationEquals(mosMikakuteiSyorui.getSyoruiCd(), C_SyoruiCdKbn.WF_HYOUSI, "書類コード");

        deleteTestData1();
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testSinkykSyoruiTorikomi_A3() {
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        IwfKouteiClientMockForSinkeiyaku.mode="01-05";
        String pMosNo = "860000033";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{C_SyoruiCdKbn.USERITIRANHYOU, C_SyoruiCdKbn.WF_HYOUSI, C_SyoruiCdKbn.WF_QRSEAL};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011030";

        SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd);

        sinkeiyakuDomManager.flush();

        exNumericEquals(strs.length, 3, "QRコード値配列．Length");
        exStringEquals(strs[0].substring(0, 4), "YUYU", "QRコード値配列[0]");
        exStringEquals(strs[1].substring(0, 4), "YUYU", "QRコード値配列[1]");
        exStringEquals(strs[2].substring(0, 3), "MOS", "QRコード値配列[2]");

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("860000033");
        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "860000033", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.BLNK, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.BLNK, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "9011030", "代理店コード１");

        List<HT_MosMikakuteiSyorui> mosMikakuteiSyoruiLst = sinkeiyakuDomManager.getMosMikakuteiSyoruisByMosno("860000033");
        exNumericEquals(mosMikakuteiSyoruiLst.size(), 3, "件数");

        HT_MosMikakuteiSyorui mosMikakuteiSyorui1 = mosMikakuteiSyoruiLst.get(0);
        exStringEquals(mosMikakuteiSyorui1.getDocumentid().substring(0, 4), "YUYU", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyorui1.getMosno(), "860000033", "申込番号");
        exClassificationEquals(mosMikakuteiSyorui1.getSyoruiCd(), C_SyoruiCdKbn.USERITIRANHYOU, "書類コード");

        HT_MosMikakuteiSyorui mosMikakuteiSyorui2 = mosMikakuteiSyoruiLst.get(1);
        exStringEquals(mosMikakuteiSyorui2.getDocumentid().substring(0, 4), "YUYU", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyorui2.getMosno(), "860000033", "申込番号");
        exClassificationEquals(mosMikakuteiSyorui2.getSyoruiCd(), C_SyoruiCdKbn.WF_HYOUSI, "書類コード");

        HT_MosMikakuteiSyorui mosMikakuteiSyorui3 = mosMikakuteiSyoruiLst.get(2);
        exStringEquals(mosMikakuteiSyorui3.getDocumentid().substring(0, 3), "MOS", "ドキュメントＩＤ");
        exStringEquals(mosMikakuteiSyorui3.getMosno(), "860000033", "申込番号");
        exClassificationEquals(mosMikakuteiSyorui3.getSyoruiCd(), C_SyoruiCdKbn.WF_QRSEAL, "書類コード");

        deleteTestData1();
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testSinkykSyoruiTorikomi_A4() {
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        IwfKouteiClientMockForSinkeiyaku.mode="01-05";
        String pMosNo = "860000041";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011040";

        SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd);
        exNumericEquals(strs.length, 0, "QRコード値配列．Length");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testSinkykSyoruiTorikomi_A5() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        IwfKouteiClientMockForSinkeiyaku.mode="01-05";
        String pMosNo = "860000058";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{C_SyoruiCdKbn.WF_HYOUSI};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011050";

        SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd);

        exNumericEquals(strs.length, 1, "QRコード値配列．Length");
        exStringEquals(strs[0].substring(0, 4), "YUYU", "QRコード値配列[0]");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(
            BzGetProcessSummary.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
            " 事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            " (配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "860000058", " 申込番号");

        deleteTestData1();
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testSinkykSyoruiTorikomi_A6() {
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN2;
        IwfKouteiClientMockForSinkeiyaku.mode="01-05";
        String pMosNo = "860000066";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{C_SyoruiCdKbn.USERITIRANHYOU, C_SyoruiCdKbn.WF_HYOUSI, C_SyoruiCdKbn.WF_QRSEAL};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011060";

        SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd);

        exNumericEquals(strs.length, 3, "QRコード値配列．Length");
        exStringEquals(strs[0].substring(0, 4), "YUYU", "QRコード値配列[0]");
        exStringEquals(strs[1].substring(0, 4), "YUYU", "QRコード値配列[1]");
        exStringEquals(strs[2].substring(0, 3), "MOS", "QRコード値配列[2]");

        deleteTestData1();
    }

    @Transactional
    public static void deleteTestData1() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiSyorui());
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testSinkykSyoruiTorikomi_A7() {
        MockObjectManager.initialize();

        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        IwfKouteiClientMockForSinkeiyaku.mode="01-05";

        String pMosNo = "860000074";
        C_SyoruiCdKbn[] pSyoruiCds = new C_SyoruiCdKbn[]{};
        C_SkeijimuKbn pSkeijimuKbn = C_SkeijimuKbn.BLNK;
        C_HknsyuruiNo pHknsyuruiNo = C_HknsyuruiNo.BLNK;
        C_MosUketukeKbn pMosUketukeKbn = C_MosUketukeKbn.BLNK;
        String pDrtenCd = "9011010";

        SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);
        String[] strs = skPreSyoruiTorikomi.sinkykSyoruiTorikomi(pMosNo, pSyoruiCds, pSkeijimuKbn,
            pHknsyuruiNo, pMosUketukeKbn, pDrtenCd);

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean1 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzGetProcessSummaryInBean1.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(bzGetProcessSummaryInBean1.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU,
            "(配列)工程管理状況");
        exStringEquals(bzGetProcessSummaryInBean1.getMosNo(), "860000074", "申込番号");

        BzGetProcessSummaryInBean bzGetProcessSummaryInBean2 = (BzGetProcessSummaryInBean) MockObjectManager
            .getArgument(BzGetProcessSummaryMockForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzGetProcessSummaryInBean2.getJimuTetuzukiCd(), "skmaindairiten", "事務手続コード");
        exStringEquals(bzGetProcessSummaryInBean2.getSyoNo(), "10807100009", "証券番号");

        exNumericEquals(strs.length, 0, "QRコード値配列．Length");

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri("860000074");
        exStringEquals(mosMikakuteiJyouhouKanri.getMosno(), "860000074", "申込番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getJimutetuzukicd(), "skmaindairiten", "事務手続コード");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getSkeijimukbn(), C_SkeijimuKbn.BLNK, "新契約事務区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getMosuketukekbn(), C_MosUketukeKbn.BLNK, "申込受付区分");
        exClassificationEquals(mosMikakuteiJyouhouKanri.getHknsyuruino(), C_HknsyuruiNo.BLNK, "保険種類番号");
        exStringEquals(mosMikakuteiJyouhouKanri.getDairitencd1(), "9011010", "代理店コード１");
    }
}
