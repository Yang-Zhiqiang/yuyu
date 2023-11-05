package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.koutei.GetSyoriKokouteiInfo;
import yuyu.common.biz.koutei.GetSyoriKokouteiInfoMockForBiz;
import yuyu.common.biz.workflow.IwfKouteiClient;
import yuyu.common.biz.workflow.IwfKouteiClientMockForBiz;
import yuyu.common.biz.workflow.io.koutei.ProcessUpdateInBean;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 業務共通工程情報更新のメイン処理{@link BzProcessUpdate#exec(BzProcessUpdateInputBean pBzProcessUpdateInputBean)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzProcessUpdateTest_exec {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GetSyoriKokouteiInfo.class).to(GetSyoriKokouteiInfoMockForBiz.class);
                bind(IwfKouteiClient.class).to(IwfKouteiClientMockForBiz.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        GetSyoriKokouteiInfoMockForBiz.caller = "Test";
        IwfKouteiClientMockForBiz.caller2 = BzProcessUpdateTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.caller2 = null;
        GetSyoriKokouteiInfoMockForBiz.caller = null;

        IwfKouteiClientMockForBiz.mode = null;
        GetSyoriKokouteiInfoMockForBiz.mode = null;
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(null);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータが不正です。パラメータ名=業務共通工程情報更新入力Bean",
                "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_B1() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "1";

        baseUserInfo.getUser().setUserId("JUnit");

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");
        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1("001");
        tuikaParamInputBean.setDairitencd2("002");
        tuikaParamInputBean.setJimuyoucd("003");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(20160511));
        tuikaParamInputBean.setJimustartymd("2016042912034512");
        tuikaParamInputBean.setSyono("17806000013");
        tuikaParamInputBean.setNksysyno("17806000013");
        tuikaParamInputBean.setMosno("860000017");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
        bzProcessUpdate.exec(bzProcessUpdateInputBean);

        ProcessUpdateInBean processUpdateInBean = (ProcessUpdateInBean) MockObjectManager.getArgument(
            IwfKouteiClientMockForBiz.class, "execProcessUpdate", 0, 0);

        exStringEquals(processUpdateInBean.getGyoumukey(), "0001", "業務キー");

        exStringEquals(processUpdateInBean.getFlowid(), "0000001", "フローID");

        exStringEquals(processUpdateInBean.getAccountid(), "JUnit", "アカウントID");

        exStringEquals(processUpdateInBean.getLockkey(), "001", "ロックキー");

        exStringEquals(processUpdateInBean.getExtParam1().getValue(), "01", "追加パラメータ１");

        exStringEquals(processUpdateInBean.getExtParam2().getValue(), "1", "追加パラメータ２");

        exStringEquals(processUpdateInBean.getExtParam3().getValue(), "441", "追加パラメータ３");

        exStringEquals(processUpdateInBean.getExtParam4().getValue(), "001", "追加パラメータ４");

        exStringEquals(processUpdateInBean.getExtParam5().getValue(), "002", "追加パラメータ５");

        exStringEquals(processUpdateInBean.getExtParam7().getValue(), "003", "追加パラメータ７");

        exStringEquals(processUpdateInBean.getExtParam8().getValue(), "0", "追加パラメータ８");

        exStringEquals(processUpdateInBean.getExtParam9().getValue(), "1", "追加パラメータ９");

        exStringEquals(processUpdateInBean.getExtParam10().getValue(), "20160511", "追加パラメータ１０");

        exStringEquals(processUpdateInBean.getExtParam11().getValue(), "2016042912034512", "追加パラメータ１１");

        exStringEquals(processUpdateInBean.getExtParam12().getValue(), "17806000013", "追加パラメータ１２");

        exStringEquals(processUpdateInBean.getExtParam13().getValue(), "17806000013", "追加パラメータ１３");

        exStringEquals(processUpdateInBean.getExtParam14().getValue(), "860000017", "追加パラメータ１４");

        exStringEquals(processUpdateInBean.getExtParam15().getValue(), "2", "追加パラメータ１５");

        exStringEquals(processUpdateInBean.getExtParam16().getValue(), "3", "追加パラメータ１６");

        exStringEquals(processUpdateInBean.getExtParam17().getValue(), "5", "追加パラメータ１７");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_B2() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "2";

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");
        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(null);
        tuikaParamInputBean.setMosuketukekbn(null);
        tuikaParamInputBean.setHknsyuruiNo(null);
        tuikaParamInputBean.setDairitencd1("");
        tuikaParamInputBean.setDairitencd2("");
        tuikaParamInputBean.setJimuyoucd("");
        tuikaParamInputBean.setDoujimosumu(null);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(00000000));
        tuikaParamInputBean.setJimustartymd("");
        tuikaParamInputBean.setSyono("");
        tuikaParamInputBean.setNksysyno("");
        tuikaParamInputBean.setMosno("");
        tuikaParamInputBean.setKetteiKbn(null);
        tuikaParamInputBean.setSeirituKbn(null);
        tuikaParamInputBean.setLincjkKbn(null);

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(bzProcessUpdateInputBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程情報更新、API＝工程情報更新、エラーコード＝IWF0001",
                "エラーメッセージ");

            ProcessUpdateInBean processUpdateInBean = (ProcessUpdateInBean) MockObjectManager.getArgument(
                IwfKouteiClientMockForBiz.class, "execProcessUpdate", 0, 0);

            assertNull("追加パラメータ１", processUpdateInBean.getExtParam1());

            assertNull("追加パラメータ２", processUpdateInBean.getExtParam2());

            assertNull("追加パラメータ３", processUpdateInBean.getExtParam3());

            assertNull("追加パラメータ４", processUpdateInBean.getExtParam4().getValue());

            assertNull("追加パラメータ５", processUpdateInBean.getExtParam5().getValue());

            assertNull("追加パラメータ７", processUpdateInBean.getExtParam7().getValue());

            exStringEquals(processUpdateInBean.getExtParam8().getValue(), "1", "追加パラメータ８");

            assertNull("追加パラメータ９", processUpdateInBean.getExtParam9());

            assertNull("追加パラメータ１０", processUpdateInBean.getExtParam10().getValue());

            assertNull("追加パラメータ１１", processUpdateInBean.getExtParam11().getValue());

            assertNull("追加パラメータ１２", processUpdateInBean.getExtParam12().getValue());

            assertNull("追加パラメータ１３", processUpdateInBean.getExtParam13().getValue());

            assertNull("追加パラメータ１４", processUpdateInBean.getExtParam14().getValue());

            assertNull("追加パラメータ１５", processUpdateInBean.getExtParam15());

            assertNull("追加パラメータ１６", processUpdateInBean.getExtParam16());

            assertNull("追加パラメータ１７", processUpdateInBean.getExtParam17());

            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_B3() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "3";

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");
        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1(null);
        tuikaParamInputBean.setDairitencd2(null);
        tuikaParamInputBean.setJimuyoucd(null);
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(null);
        tuikaParamInputBean.setJimustartymd(null);
        tuikaParamInputBean.setSyono(null);
        tuikaParamInputBean.setNksysyno(null);
        tuikaParamInputBean.setMosno(null);
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(bzProcessUpdateInputBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程情報更新、API＝工程情報更新、エラーコード＝IWF0002",
                "エラーメッセージ");

            ProcessUpdateInBean processUpdateInBean = (ProcessUpdateInBean) MockObjectManager.getArgument(
                IwfKouteiClientMockForBiz.class, "execProcessUpdate", 0, 0);

            assertNull("追加パラメータ４", processUpdateInBean.getExtParam4());

            assertNull("追加パラメータ５", processUpdateInBean.getExtParam5());

            assertNull("追加パラメータ７", processUpdateInBean.getExtParam7());

            assertNull("追加パラメータ８", processUpdateInBean.getExtParam8());

            assertNull("追加パラメータ１０", processUpdateInBean.getExtParam10());

            assertNull("追加パラメータ１１", processUpdateInBean.getExtParam11());

            assertNull("追加パラメータ１２", processUpdateInBean.getExtParam12());

            assertNull("追加パラメータ１３", processUpdateInBean.getExtParam13());

            assertNull("追加パラメータ１４", processUpdateInBean.getExtParam14());

            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExec_B4() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "4";

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");
        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1("001");
        tuikaParamInputBean.setDairitencd2("002");
        tuikaParamInputBean.setJimuyoucd("003");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(20160511));
        tuikaParamInputBean.setJimustartymd("2016042912034512");
        tuikaParamInputBean.setSyono("17806000013");
        tuikaParamInputBean.setNksysyno("17806000013");
        tuikaParamInputBean.setMosno("860000017");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(bzProcessUpdateInputBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程情報更新、API＝工程情報更新、エラーコード＝IWF0003",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(60)
    public void testExec_B5() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "5";

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");
        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1("001");
        tuikaParamInputBean.setDairitencd2("002");
        tuikaParamInputBean.setJimuyoucd("003");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(20160511));
        tuikaParamInputBean.setJimustartymd("2016042912034512");
        tuikaParamInputBean.setSyono("17806000013");
        tuikaParamInputBean.setNksysyno("17806000013");
        tuikaParamInputBean.setMosno("860000017");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(bzProcessUpdateInputBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程情報更新、API＝工程情報更新、エラーコード＝IWF2021",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(70)
    public void testExec_B6() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "6";

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");
        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1("001");
        tuikaParamInputBean.setDairitencd2("002");
        tuikaParamInputBean.setJimuyoucd("003");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(20160511));
        tuikaParamInputBean.setJimustartymd("2016042912034512");
        tuikaParamInputBean.setSyono("17806000013");
        tuikaParamInputBean.setNksysyno("17806000013");
        tuikaParamInputBean.setMosno("860000017");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(bzProcessUpdateInputBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程情報更新、API＝工程情報更新、エラーコード＝IWF2022",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(80)
    public void testExec_B7() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "7";

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");
        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1("001");
        tuikaParamInputBean.setDairitencd2("002");
        tuikaParamInputBean.setJimuyoucd("003");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(20160511));
        tuikaParamInputBean.setJimustartymd("2016042912034512");
        tuikaParamInputBean.setSyono("17806000013");
        tuikaParamInputBean.setNksysyno("17806000013");
        tuikaParamInputBean.setMosno("860000017");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(bzProcessUpdateInputBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程情報更新、API＝工程情報更新、エラーコード＝IWF2023",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(90)
    public void testExec_B8() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "8";

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");
        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1("001");
        tuikaParamInputBean.setDairitencd2("002");
        tuikaParamInputBean.setJimuyoucd("003");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(20160511));
        tuikaParamInputBean.setJimustartymd("2016042912034512");
        tuikaParamInputBean.setSyono("17806000013");
        tuikaParamInputBean.setNksysyno("17806000013");
        tuikaParamInputBean.setMosno("860000017");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(bzProcessUpdateInputBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程情報更新、API＝工程情報更新、エラーコード＝IWF2024",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(100)
    public void testExec_B9() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "9";

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");
        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1("001");
        tuikaParamInputBean.setDairitencd2("002");
        tuikaParamInputBean.setJimuyoucd("003");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(20160511));
        tuikaParamInputBean.setJimustartymd("2016042912034512");
        tuikaParamInputBean.setSyono("17806000013");
        tuikaParamInputBean.setNksysyno("17806000013");
        tuikaParamInputBean.setMosno("860000017");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(bzProcessUpdateInputBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程情報更新、API＝工程情報更新、エラーコード＝IWF2025",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_C1() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "1";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN1;
        baseUserInfo.getUser().setUserId("JUnit");

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");

        bzProcessUpdateInputBean.setKokouteiUpdumu(C_UmuKbn.ARI);

        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1("001");
        tuikaParamInputBean.setDairitencd2("002");
        tuikaParamInputBean.setJimuyoucd("003");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(20160511));
        tuikaParamInputBean.setJimustartymd("2016042912034512");
        tuikaParamInputBean.setSyono("17806000013");
        tuikaParamInputBean.setNksysyno("17806000013");
        tuikaParamInputBean.setMosno("860000017");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
        bzProcessUpdate.exec(bzProcessUpdateInputBean);

        ProcessUpdateInBean processUpdateInBean = (ProcessUpdateInBean) MockObjectManager.getArgument(
            IwfKouteiClientMockForBiz.class, "execProcessUpdate", 1, 0);

        exStringEquals(processUpdateInBean.getGyoumukey(), "hijklmn", "業務キー");

        exStringEquals(processUpdateInBean.getFlowid(), "hzn", "フローID");

        exStringEquals(processUpdateInBean.getAccountid(), "JUnit", "アカウントID");

        exStringEquals(processUpdateInBean.getLockkey(), "001", "ロックキー");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(120)
    public void testExec_C2() {

        MockObjectManager.initialize();
        IwfKouteiClientMockForBiz.mode = "10";
        GetSyoriKokouteiInfoMockForBiz.mode  = GetSyoriKokouteiInfoMockForBiz.TESTPATTERN1;
        baseUserInfo.getUser().setUserId("JUnit");

        BzProcessUpdateInputBean bzProcessUpdateInputBean = SWAKInjector.getInstance(BzProcessUpdateInputBean.class);
        bzProcessUpdateInputBean.setJimuTetuzukiCd("0000001");
        bzProcessUpdateInputBean.setKouteiKanriId("0001");
        bzProcessUpdateInputBean.setKouteiLockKey("001");

        bzProcessUpdateInputBean.setKokouteiUpdumu(C_UmuKbn.ARI);

        TuikaParamInputBean tuikaParamInputBean = SWAKInjector.getInstance(TuikaParamInputBean.class);
        bzProcessUpdateInputBean.setTuikaParamInputBean(tuikaParamInputBean);
        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU);
        tuikaParamInputBean.setDairitencd1("001");
        tuikaParamInputBean.setDairitencd2("002");
        tuikaParamInputBean.setJimuyoucd("003");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf(20160511));
        tuikaParamInputBean.setJimustartymd("2016042912034512");
        tuikaParamInputBean.setSyono("17806000013");
        tuikaParamInputBean.setNksysyno("17806000013");
        tuikaParamInputBean.setMosno("860000017");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.KETTEI_MATI);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.HUSEIRITU);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        try {
            BzProcessUpdate bzProcessUpdate = SWAKInjector.getInstance(BzProcessUpdate.class);
            bzProcessUpdate.exec(bzProcessUpdateInputBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程情報更新、API＝工程情報更新、エラーコード＝IWF2025",
                "エラーメッセージ");
            throw e;
        }
    }
}
