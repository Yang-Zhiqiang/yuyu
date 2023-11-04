package yuyu.common.sinkeiyaku.syoruitoutyaku;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.prereport.SyoruiToutyakuYoteiTouroku;
import yuyu.common.biz.syoruitoutyaku.ToutyakuInfoBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreate;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.workflowcore.ScanReceiveInfoBeanMockForSinkeiyaku;
import yuyu.common.workflowcore.scan.impl.ScanReceiveInfoBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 新契約書類到着時管理情報取得処理呼出しクラスのメソッド {@link SinkeiyakuGetSyoruitoutyakuInfo#getToutyakuYoteiInfo(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo {

    @Inject
    private SinkeiyakuGetSyoruitoutyakuInfo sinkeiyakuGetSyoruitoutyakuInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約書類到着時管理情報取得処理";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {

                bind(SkProcessCreate.class).to(SkProcessCreateMockForSinkeiyaku.class);
                bind(ScanReceiveInfoBean.class).to(ScanReceiveInfoBeanMockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        SkProcessCreateMockForSinkeiyaku.caller = SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo.class;
        ScanReceiveInfoBeanMockForSinkeiyaku.caller = SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo.class;
    }

    @AfterClass
    public static void testClear() {

        SkProcessCreateMockForSinkeiyaku.caller = null;
        SkProcessCreateMockForSinkeiyaku.SYORIPTN = null;
        ScanReceiveInfoBeanMockForSinkeiyaku.caller = null;
        ScanReceiveInfoBeanMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();

    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager  = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiJyouhouKanri());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosMikakuteiSyorui());
        bizDomManager.delete(bizDomManager.getAllTorikomiSyoruiHukaInfo());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testGetToutyakuYoteiInfo_A1() {
        ToutyakuInfoBean toutyakuYoteiInfo = (ToutyakuInfoBean)sinkeiyakuGetSyoruitoutyakuInfo.getToutyakuYoteiInfo("YUYU79111222010001");

        exStringEquals(toutyakuYoteiInfo.getToutyakuKey(), null, "QRコード値");
        exStringEquals(toutyakuYoteiInfo.getAppKey(), null, "工程管理ID");
        exStringEquals(toutyakuYoteiInfo.getSyoruiCd(), null, "書類コード区分");
        exStringEquals(toutyakuYoteiInfo.getFlowId(), null, "事務手続コード");
        exStringEquals(toutyakuYoteiInfo.getSubSystemId(), null, "サブシステムID");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testGetToutyakuYoteiInfo_A2() {
        try {

            sinkeiyakuGetSyoruitoutyakuInfo.getToutyakuYoteiInfo("MOS0062dqitbkzivq3ric");

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "文書IDが不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testGetToutyakuYoteiInfo_A3() {
        try {

            sinkeiyakuGetSyoruitoutyakuInfo.getToutyakuYoteiInfo("MOS07K2GJ0BEMVXKDIYVS");

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。申込番号：791112246 書類コード：sk001", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testGetToutyakuYoteiInfo_A4() {
        MockObjectManager.initialize();
        SkProcessCreateMockForSinkeiyaku.SYORIPTN = SkProcessCreateMockForSinkeiyaku.TESTPATTERN1;
        ScanReceiveInfoBeanMockForSinkeiyaku.SYORIPTN = ScanReceiveInfoBeanMockForSinkeiyaku.TESTPATTERN1;
        ToutyakuInfoBean toutyakuYoteiInfo = (ToutyakuInfoBean)sinkeiyakuGetSyoruitoutyakuInfo.getToutyakuYoteiInfo("MOS07K2GJ0BEMVXKDIYVT");

        exStringEquals(toutyakuYoteiInfo.getToutyakuKey(), "MOS07K2GJ0BEMVXKDIYVT", "QRコード値");
        exStringEquals(toutyakuYoteiInfo.getAppKey(), "2001", "工程管理ID");
        exStringEquals(toutyakuYoteiInfo.getSyoruiCd(), "sk002", "書類コード区分");
        exStringEquals(toutyakuYoteiInfo.getFlowId(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(toutyakuYoteiInfo.getSubSystemId(), ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, "サブシステムID");






        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreateMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "5101001", "代理店コード１");
        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "5102001", "代理店コード２");
        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "101", "事務用コード");
        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(),C_UmuKbn.ARI, "同時申込有無");
        exDateEquals(skProcessCreateInBean.getMosYmd(),null, "申込日");
        exStringEquals(skProcessCreateInBean.getSyoNo(), "", "証券番号");
        exStringEquals(skProcessCreateInBean.getMosNo(), "791112261", "申込番号");
        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");

        MockObjectManager.assertCalled(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 0), "sk002", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 2), "MOS07K2GJ0BEMVXKDIYVT", "ドキュメントＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testGetToutyakuYoteiInfo_A5() {
        MockObjectManager.initialize();
        SkProcessCreateMockForSinkeiyaku.SYORIPTN = SkProcessCreateMockForSinkeiyaku.TESTPATTERN1;
        ScanReceiveInfoBeanMockForSinkeiyaku.SYORIPTN = ScanReceiveInfoBeanMockForSinkeiyaku.TESTPATTERN2;

        ToutyakuInfoBean toutyakuYoteiInfo = (ToutyakuInfoBean)sinkeiyakuGetSyoruitoutyakuInfo.getToutyakuYoteiInfo("MOS07K2GJ0BEMVXKDIYVU");

        exStringEquals(toutyakuYoteiInfo.getToutyakuKey(), "MOS07K2GJ0BEMVXKDIYVU", "QRコード値");
        exStringEquals(toutyakuYoteiInfo.getAppKey(), "2001", "工程管理ID");
        exStringEquals(toutyakuYoteiInfo.getSyoruiCd(), "sk007", "書類コード区分");
        exStringEquals(toutyakuYoteiInfo.getFlowId(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(toutyakuYoteiInfo.getSubSystemId(), ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, "サブシステムID");

        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreateMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMTB, "新契約事務区分");
        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.SEIHOWEB, "申込受付区分");
        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, "保険種類番号");
        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "5101002", "代理店コード１");
        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "5102002", "代理店コード２");
        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "102", "事務用コード");
        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(),C_UmuKbn.NONE, "同時申込有無");
        exDateEquals(skProcessCreateInBean.getMosYmd(),null, "申込日");
        exStringEquals(skProcessCreateInBean.getSyoNo(), "", "証券番号");
        exStringEquals(skProcessCreateInBean.getMosNo(), "791112253", "申込番号");
        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");

        MockObjectManager.assertCalled(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 0), "sk007", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 2), "MOS07K2GJ0BEMVXKDIYVU", "ドキュメントＩＤ");

        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 0), "sk008", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 2), "MOS07K2GJ0BEMVXKDIYVV", "ドキュメントＩＤ");

        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 0), "sk009", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 2), "MOS07K2GJ0BEMVXKDIYVW", "ドキュメントＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testGetToutyakuYoteiInfo_A6() {
        MockObjectManager.initialize();
        SkProcessCreateMockForSinkeiyaku.SYORIPTN = SkProcessCreateMockForSinkeiyaku.TESTPATTERN1;
        ScanReceiveInfoBeanMockForSinkeiyaku.SYORIPTN = ScanReceiveInfoBeanMockForSinkeiyaku.TESTPATTERN3;
        ToutyakuInfoBean toutyakuYoteiInfo = (ToutyakuInfoBean)sinkeiyakuGetSyoruitoutyakuInfo.getToutyakuYoteiInfo("MOS07K2GJ0BEMVXKDIYVX");

        exStringEquals(toutyakuYoteiInfo.getToutyakuKey(), "MOS07K2GJ0BEMVXKDIYVX", "QRコード値");
        exStringEquals(toutyakuYoteiInfo.getAppKey(), "2001", "工程管理ID");
        exStringEquals(toutyakuYoteiInfo.getSyoruiCd(), "sk007", "書類コード区分");
        exStringEquals(toutyakuYoteiInfo.getFlowId(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(toutyakuYoteiInfo.getSubSystemId(), ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, "サブシステムID");

        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreateMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, "保険種類番号");
        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "5101003", "代理店コード１");
        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "5102003", "代理店コード２");
        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "103", "事務用コード");
        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(), C_UmuKbn.NONE, "同時申込有無");
        exDateEquals(skProcessCreateInBean.getMosYmd(),null, "申込日");
        exStringEquals(skProcessCreateInBean.getSyoNo(), "", "証券番号");
        exStringEquals(skProcessCreateInBean.getMosNo(), "970000014", "申込番号");
        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");

        MockObjectManager.assertCalled(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 0), "sk007", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 2), "MOS07K2GJ0BEMVXKDIYVX", "ドキュメントＩＤ");

        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 0), "sk008", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 2), "MOS07K2GJ0BEMW25R9O9Q", "ドキュメントＩＤ");

        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 0), "sk009", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 2), "MOS07K2GJ0BEMW25R9O9R", "ドキュメントＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testGetToutyakuYoteiInfo_A7() {
        MockObjectManager.initialize();
        SkProcessCreateMockForSinkeiyaku.SYORIPTN = SkProcessCreateMockForSinkeiyaku.TESTPATTERN1;
        ScanReceiveInfoBeanMockForSinkeiyaku.SYORIPTN = ScanReceiveInfoBeanMockForSinkeiyaku.TESTPATTERN4;
        ToutyakuInfoBean toutyakuYoteiInfo = (ToutyakuInfoBean)sinkeiyakuGetSyoruitoutyakuInfo.getToutyakuYoteiInfo("MOS07K2GJ0BEMW25R9O9S");

        exStringEquals(toutyakuYoteiInfo.getToutyakuKey(), "MOS07K2GJ0BEMW25R9O9S", "QRコード値");
        exStringEquals(toutyakuYoteiInfo.getAppKey(), "2001", "工程管理ID");
        exStringEquals(toutyakuYoteiInfo.getSyoruiCd(), "sk007", "書類コード区分");
        exStringEquals(toutyakuYoteiInfo.getFlowId(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(toutyakuYoteiInfo.getSubSystemId(), ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, "サブシステムID");

        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreateMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, "保険種類番号");
        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "5101004", "代理店コード１");
        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "5102004", "代理店コード２");
        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "123", "事務用コード");
        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(), C_UmuKbn.NONE, "同時申込有無");
        exDateEquals(skProcessCreateInBean.getMosYmd(),null, "申込日");
        exStringEquals(skProcessCreateInBean.getSyoNo(), "", "証券番号");
        exStringEquals(skProcessCreateInBean.getMosNo(), "970000022", "申込番号");
        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");

        MockObjectManager.assertCalled(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 0), "sk007", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 2), "MOS07K2GJ0BEMW25R9O9S", "ドキュメントＩＤ");

        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 0), "sk008", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 2), "MOS07K2GJ0BEMW25R9O9T", "ドキュメントＩＤ");

        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 0), "sk009", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 2), "MOS07K2GJ0BEMW25R9O9U", "ドキュメントＩＤ");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testGetToutyakuYoteiInfo_A8() {
        MockObjectManager.initialize();
        SkProcessCreateMockForSinkeiyaku.SYORIPTN = SkProcessCreateMockForSinkeiyaku.TESTPATTERN1;
        ScanReceiveInfoBeanMockForSinkeiyaku.SYORIPTN = ScanReceiveInfoBeanMockForSinkeiyaku.TESTPATTERN5;
        ToutyakuInfoBean toutyakuYoteiInfo = (ToutyakuInfoBean)sinkeiyakuGetSyoruitoutyakuInfo.getToutyakuYoteiInfo("MOS07K2GJ0BEMW25R9O9V");

        exStringEquals(toutyakuYoteiInfo.getToutyakuKey(), "MOS07K2GJ0BEMW25R9O9V", "QRコード値");
        exStringEquals(toutyakuYoteiInfo.getAppKey(), "2001", "工程管理ID");
        exStringEquals(toutyakuYoteiInfo.getSyoruiCd(), "sk007", "書類コード区分");
        exStringEquals(toutyakuYoteiInfo.getFlowId(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
        exStringEquals(toutyakuYoteiInfo.getSubSystemId(), ISkCommonKoumoku.SUBSYSTEMID_SINKEIYAKU, "サブシステムID");

        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreateMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, "保険種類番号");
        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "5101005", "代理店コード１");
        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "5102005", "代理店コード２");
        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "234", "事務用コード");
        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(), C_UmuKbn.NONE, "同時申込有無");
        exDateEquals(skProcessCreateInBean.getMosYmd(),null, "申込日");
        exStringEquals(skProcessCreateInBean.getSyoNo(), "", "証券番号");
        exStringEquals(skProcessCreateInBean.getMosNo(), "970000030", "申込番号");
        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");

        MockObjectManager.assertCalled(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 0), "sk007", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 0, 2), "MOS07K2GJ0BEMW25R9O9V", "ドキュメントＩＤ");

        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 0), "sk008", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 1, 2), "MOS07K2GJ0BEMW25R9O9W", "ドキュメントＩＤ");

        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 0), "sk009", "書類コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 1), "2001", "事務手続コード");
        exStringEquals((String)MockObjectManager.getArgument(SyoruiToutyakuYoteiTouroku.class, "execSyoruiToutyakuYoteiTouroku", 2, 2), "MOS07K2GJ0BEMW25R9O9X", "ドキュメントＩＤ");
    }
}
