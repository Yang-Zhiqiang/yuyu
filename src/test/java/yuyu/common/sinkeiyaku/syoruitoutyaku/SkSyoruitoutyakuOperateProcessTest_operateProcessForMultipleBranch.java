package yuyu.common.sinkeiyaku.syoruitoutyaku;

import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.testinfr.OrderedRunner;

/**
 * 新契約書類到着時工程操作処理チェック呼出しクラスのメソッド {@link SkSyoruitoutyakuOperateProcess#operateProcessForMultipleBranch(String,String,C_SyoruiCdKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch {
    //
    //    @Inject
    //    private SkSyoruitoutyakuOperateProcess skSyoruitoutyakuOperateProcess;
    //
    //    @BeforeClass
    //    public static void testInit(){
    //        BzGetProcessSummaryMock.caller = SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class;
    //        IwfKouteiClientMock.caller2 = SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class;
    //        BzLockProcessMock.caller = SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class;
    //        BzProcessForwardMock.caller = SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class;
    //        BzUnlockProcessMock.caller = SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class;
    //        UpdateJimustartymdMock.caller = SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class;
    //        BzOutputProcessRecordMock.caller = SkSyoruitoutyakuOperateProcessTest_operateProcessForMultipleBranch.class;
    //    }
    //
    //    @BeforeClass
    //    @Transactional
    //    public static void insertTestData() {
    //        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
    //        HT_SyoriCTL syoriCTL5 = sinkeiyakuDomManager.getSyoriCTL("791112261");
    //        if (syoriCTL5 == null) {
    //            syoriCTL5 = new HT_SyoriCTL("791112261");
    //            syoriCTL5.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
    //            syoriCTL5.setMosnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
    //
    //            sinkeiyakuDomManager.insert(syoriCTL5);
    //        }
    //        HT_SyoriCTL syoriCTL7 = sinkeiyakuDomManager.getSyoriCTL("791112287");
    //        if (syoriCTL7 == null) {
    //            syoriCTL7 = new HT_SyoriCTL("791112287");
    //            syoriCTL7.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
    //            syoriCTL7.setMosnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
    //            syoriCTL7.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
    //            syoriCTL7.setMosnrkumu(C_UmuKbn.ARI);
    //            syoriCTL7.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
    //            syoriCTL7.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
    //
    //            sinkeiyakuDomManager.insert(syoriCTL7);
    //        }
    //        HT_SyoriCTL syoriCTL8 = sinkeiyakuDomManager.getSyoriCTL("791112295");
    //        if (syoriCTL8 == null) {
    //            syoriCTL8 = new HT_SyoriCTL("791112295");
    //            syoriCTL8.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
    //            syoriCTL8.setMosnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
    //            syoriCTL8.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
    //            syoriCTL8.setMosnrkumu(C_UmuKbn.ARI);
    //            syoriCTL8.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
    //            syoriCTL8.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
    //
    //            HT_MosKihon mosKihon = syoriCTL8.createMosKihon();
    //            mosKihon.setSntkhoukbn(C_SntkhouKbn.HJY);
    //
    //            sinkeiyakuDomManager.insert(syoriCTL8);
    //        }
    //        HT_SyoriCTL syoriCTL9 = sinkeiyakuDomManager.getSyoriCTL("791112303");
    //        if (syoriCTL9 == null) {
    //            syoriCTL9 = new HT_SyoriCTL("791112303");
    //            syoriCTL9.setMosuketukekbn(C_MosUketukeKbn.DIRECT);
    //            syoriCTL9.setMosnrkvrfjkkbn(C_VrfjkKbn.KANRYOU);
    //            syoriCTL9.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
    //            syoriCTL9.setMosnrkumu(C_UmuKbn.ARI);
    //            syoriCTL9.setMosuketukekbn(C_MosUketukeKbn.MOSKIT);
    //            syoriCTL9.setKktnrkvrfjkkbn(C_VrfjkKbn.NIJINRKMATI);
    //
    //            sinkeiyakuDomManager.insert(syoriCTL9);
    //        }
    //        HT_SyoriCTL syoriCTL10 = sinkeiyakuDomManager.getSyoriCTL("791112311");
    //        if (syoriCTL10 == null) {
    //            syoriCTL10 = new HT_SyoriCTL("791112311");
    //            syoriCTL10.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
    //            syoriCTL10.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
    //            syoriCTL10.setKykkakjkkbn(C_KykkakjkKbn.KAKUNIN_SUMI);
    //
    //            sinkeiyakuDomManager.insert(syoriCTL10);
    //        }
    //        HT_SyoriCTL syoriCTL12 = sinkeiyakuDomManager.getSyoriCTL("791112337");
    //        if (syoriCTL12 == null) {
    //            syoriCTL12 = new HT_SyoriCTL("791112337");
    //            syoriCTL12.setSeiritukbn(C_SeirituKbn.HUSEIRITU);
    //            syoriCTL12.setKetteikbn(C_KetteiKbn.KETTEI_MATI);
    //            syoriCTL12.setKykkakjkkbn(C_KykkakjkKbn.KAKUNIN_SUMI);
    //
    //            sinkeiyakuDomManager.insert(syoriCTL12);
    //        }
    //        HT_SyoriCTL syoriCTL14 = sinkeiyakuDomManager.getSyoriCTL("791112352");
    //        if (syoriCTL14 == null) {
    //            syoriCTL14 = new HT_SyoriCTL("791112352");
    //            syoriCTL14.setNyknnrkumu(C_UmuKbn.ARI);
    //
    //            HT_Henkin henkin = syoriCTL14.createHenkin();
    //            henkin.setHnknsyoriymd(BizDate.valueOf("20160420"));
    //            henkin.setRenno(1);
    //
    //            sinkeiyakuDomManager.insert(syoriCTL14);
    //        }
    //        HT_SyoriCTL syoriCTL15 = sinkeiyakuDomManager.getSyoriCTL("791112360");
    //        if (syoriCTL15 == null) {
    //            syoriCTL15 = new HT_SyoriCTL("791112360");
    //            syoriCTL15.setNyknnrkumu(C_UmuKbn.ARI);
    //
    //            sinkeiyakuDomManager.insert(syoriCTL15);
    //        }
    //
    //
    //
    //    }
    //
    //    @AfterClass
    //    @Transactional
    //    public static void deleteTestData() {
    //        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
    //        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    //    }
    //
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(10)
    //    public void testOperateProcessForMultipleBranch_A1() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN1;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","001",C_SyoruiCdKbn.BLNK);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 0, 0);
    //
    //        exStringEquals(bzGetProcessSummaryInBean.getKouteiKanriId(), "001", "工程管理ID");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(20)
    //    public void testOperateProcessForMultipleBranch_A2() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN2;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","002",C_SyoruiCdKbn.BLNK);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112238", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //
    //    }
    //
    //    @Test(expected = BizAppException.class)
    //    @Transactional
    //    @TestOrder(30)
    //    public void testOperateProcessForMultipleBranch_A3() {
    //        try{
    //            BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN3;
    //            BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN3;
    //            skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","003",C_SyoruiCdKbn.BLNK);
    //        } catch(BizAppException e) {
    //            exStringEquals(e.getMessage(), "他ユーザが処理中のため処理できません。", "エラーメッセージ");
    //            throw e;
    //
    //        }
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(40)
    //    public void testOperateProcessForMultipleBranch_A4() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN4;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","004",C_SyoruiCdKbn.SK_MOSSYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112253", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkInputMosRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU, "新契約工程完了区分");
    //        exClassificationEquals(((SkInputMosRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosuketukeKbn(), C_MosUketukeKbn.SEIHOWEB, "申込受付区分");
    //        exClassificationEquals(((SkInputMosRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosnrkvrfjkKbn(), C_VrfjkKbn.TSHN_MIJISSI, "ベリファイ状況区分");
    //
    //        MockObjectManager.assertArgumentPassed(BzLockProcess.class, "exec", 0, "1004");
    //        MockObjectManager.assertArgumentPassed(BzLockProcess.class, "exec", 1, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
    //
    //        MockObjectManager.assertArgumentPassed(BzUnlockProcess.class, "exec", 0, "1004");
    //        MockObjectManager.assertArgumentPassed(BzUnlockProcess.class, "exec", 1, ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
    //        MockObjectManager.assertArgumentPassed(BzUnlockProcess.class, "exec", 2, "testKouteiLockKey");
    //
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(50)
    //    public void testOperateProcessForMultipleBranch_A5() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN5;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","005",C_SyoruiCdKbn.SK_MOSSYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112261", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTMOS, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkInputMosRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU, "新契約工程完了区分");
    //        exClassificationEquals(((SkInputMosRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosuketukeKbn(), C_MosUketukeKbn.DIRECT, "申込受付区分");
    //        exClassificationEquals(((SkInputMosRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosnrkvrfjkKbn(), C_VrfjkKbn.KANRYOU, "ベリファイ状況区分");
    //
    //        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1005", "工程管理ID");
    //        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
    //        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(60)
    //    public void testOperateProcessForMultipleBranch_A6() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN6;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","006",C_SyoruiCdKbn.SK_KOKUSYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112279", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU, "新契約工程完了区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSeirituKbn(), C_SeirituKbn.NONE, "成立区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosnrkUmu(), C_UmuKbn.NONE, "申込書入力有無");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosuketukeKbn(), C_MosUketukeKbn.SEIHOWEB, "申込受付区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSntkhouKbn(), C_SntkhouKbn.KKT, "選択方法区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getKktnrkvrfjkKbn(), C_VrfjkKbn.TSHN_MIJISSI, "告知書入力ベリファイ状況区分");
    //
    //        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1006", "工程管理ID");
    //        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
    //        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(70)
    //    public void testOperateProcessForMultipleBranch_A7() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN7;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","007",C_SyoruiCdKbn.SK_KOKUSYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112287", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU, "新契約工程完了区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSeirituKbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosnrkUmu(), C_UmuKbn.ARI, "申込書入力有無");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosuketukeKbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSntkhouKbn(), C_SntkhouKbn.KKT, "選択方法区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI, "告知書入力ベリファイ状況区分");
    //
    //        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1007", "工程管理ID");
    //        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
    //        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(80)
    //    public void testOperateProcessForMultipleBranch_A8() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN8;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","008",C_SyoruiCdKbn.SK_KOKUSYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112295", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKINPUTKOKUTI, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSkkouteikanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU, "新契約工程完了区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSeirituKbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosnrkUmu(), C_UmuKbn.ARI, "申込書入力有無");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getMosuketukeKbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSntkhouKbn(), C_SntkhouKbn.HJY, "選択方法区分");
    //        exClassificationEquals(((SkInputKokutiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getKktnrkvrfjkKbn(), C_VrfjkKbn.NIJINRKMATI, "告知書入力ベリファイ状況区分");
    //
    //        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1008", "工程管理ID");
    //        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
    //        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(90)
    //    public void testOperateProcessForMultipleBranch_A9() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN9;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","009",C_SyoruiCdKbn.SK_HUBITUUTI);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112303", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHUBIKAISYOU, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkHubiKaisyouRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSkkouteiKanryouKbn(), C_SkkouteikanryouKbn.SYORITYUU, "新契約工程完了区分");
    //        exClassificationEquals(((SkHubiKaisyouRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSeirituKbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
    //        exClassificationEquals(((SkHubiKaisyouRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getHubikaisyoujoutaiKbn(), C_HubikaisyoujoutaiKbn.HUBIKAISYOUMATI, "不備解消状態区分");
    //
    //        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1009", "工程管理ID");
    //        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
    //        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(100)
    //    public void testOperateProcessForMultipleBranch_A10() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN10;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","010",C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112311", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkKeiyakukakuninRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSeirituKbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
    //        exClassificationEquals(((SkKeiyakukakuninRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getKetteiKbn(), C_KetteiKbn.KETTEI_MATI, "決定状態区分");
    //        exClassificationEquals(((SkKeiyakukakuninRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getKykkakjkKbn(), C_KykkakjkKbn.KAKUNIN_SUMI, "契約確認状況区分");
    //
    //        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1010", "工程管理ID");
    //        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
    //        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(110)
    //    public void testOperateProcessForMultipleBranch_A11() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN11;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","011",C_SyoruiCdKbn.SK_KYKKAKUNINKAITOUSYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112329", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKKEIYAKUKAKUNIN, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        assertNull(bzProcessForwardInBean);
    //
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(120)
    //    public void testOperateProcessForMultipleBranch_A12() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN12;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","012",C_SyoruiCdKbn.SK_TRKSSEIKYU);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112337", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkTorikesiRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getSeirituKbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
    //
    //        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1012", "工程管理ID");
    //        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
    //        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    //
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(130)
    //    public void testOperateProcessForMultipleBranch_A13() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN13;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","013",C_SyoruiCdKbn.SK_TRKSSEIKYU);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112345", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKTORIKESI, "事務手続コード");
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        assertNull(bzProcessForwardInBean);
    //
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(140)
    //    public void testOperateProcessForMultipleBranch_A14() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN14;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","014",C_SyoruiCdKbn.SK_HENKINIRAISYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112352", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkHenkinRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getNyknnrkUmu(), C_UmuKbn.ARI, "入金入力有無");
    //        exClassificationEquals(((SkHenkinRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getPkakinUmu(), C_UmuKbn.ARI, "P過金有無");
    //
    //        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1014", "工程管理ID");
    //        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
    //        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    //
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(150)
    //    public void testOperateProcessForMultipleBranch_A15() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN15;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","015",C_SyoruiCdKbn.SK_HENKINIRAISYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112360", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, "事務手続コード");
    //
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        exClassificationEquals(((SkHenkinRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getNyknnrkUmu(), C_UmuKbn.ARI, "入金入力有無");
    //        exClassificationEquals(((SkHenkinRuleBean)bzProcessForwardInBean.getIwfApiRuleBean()).getPkakinUmu(), C_UmuKbn.NONE, "P過金有無");
    //
    //        exStringEquals(bzProcessForwardInBean.getKouteiKanriId(), "1015", "工程管理ID");
    //        exStringEquals(bzProcessForwardInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN, "事務手続コード");
    //        exStringEquals(bzProcessForwardInBean.getKouteiLockKey(), "testKouteiLockKey", "工程ロックキー");
    //        exClassificationEquals(bzProcessForwardInBean.getSyorikekkaKbn(), C_SyorikekkaKbn.KANRYOU, "処理結果区分");
    //
    //
    //    }
    //
    //    @Test
    //    @Transactional
    //    @TestOrder(160)
    //    public void testOperateProcessForMultipleBranch_A16() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN16;
    //        BzLockProcessMock.SYORIPTN = BzLockProcessMock.TESTPATTERN4;
    //        skSyoruitoutyakuOperateProcess.operateProcessForMultipleBranch("","016",C_SyoruiCdKbn.SK_HENKINIRAISYO);
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 1, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112378", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0], C_Kouteikanristatus.SYORITYUU, "工程管理状況");
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), ISkCommonKoumoku.JIMUTETUZUKICD_SKHENKIN, "事務手続コード");
    //
    //        BzProcessForwardInBean bzProcessForwardInBean = (BzProcessForwardInBean)MockObjectManager.getArgument(BzProcessForward.class, "exec", 0, 0);
    //        assertNull(bzProcessForwardInBean);
    //
    //
    //    }
    //
    //
}
