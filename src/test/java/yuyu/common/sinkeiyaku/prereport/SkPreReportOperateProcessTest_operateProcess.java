package yuyu.common.sinkeiyaku.prereport;

import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;

/**
 * 新契約帳票作成前工程操作処理クラスのメソッド {@link SkPreReportOperateProcess(TorikomiSyoruiBean,BM_TorikomiSyoruiHukaInfo,ReportServicesBean) } テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkPreReportOperateProcessTest_operateProcess {
    //
    //    @Inject
    //    private SkPreReportOperateProcess skPreReportOperateProcess;
    //
    //    @Inject
    //    private SkPreReportRenkeiBean skPreReportRenkeiBean;
    //
    //    @BeforeClass
    //    @Transactional
    //    public static void testInit() {
    //        BzGetProcessSummaryMock.caller = SkPreReportOperateProcessTest_operateProcess.class;
    //        SkProcessCreateMock.caller = SkPreReportOperateProcessTest_operateProcess.class;
    //        BzOutputProcessRecordMock.caller = SkPreReportOperateProcessTest_operateProcess.class;
    //        BzProcessCreateMock.caller = SkPreReportOperateProcessTest_operateProcess.class;
    //        IwfKouteiClientMock.caller = "Test";
    //    }
    //
    //    @Test
    //    @TestOrder(10)
    //    public void testOperateProcess_A1() {
    //        TorikomiSyoruiBean torikomiSyoruiMstBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
    //        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfoBean = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
    //        torikomiSyoruiHukaInfoBean.setKouteisakuseikeiki(C_KouteiSakuseiKeikiKbn.SYORUI_TORIKOMIJI);
    //        ReportServicesBean rsBean = null;
    //        String kouteiKanriId = skPreReportOperateProcess.operateProcess(torikomiSyoruiMstBean, torikomiSyoruiHukaInfoBean, rsBean);
    //        exStringEquals(kouteiKanriId, "", "工程管理ID");
    //
    //    }
    //
    //    @Test
    //    @TestOrder(20)
    //    public void testOperateProcess_A2() {
    //        TorikomiSyoruiBean torikomiSyoruiMstBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
    //        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfoBean = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
    //        torikomiSyoruiHukaInfoBean.setKouteisakuseikeiki(C_KouteiSakuseiKeikiKbn.SYORUI_SAKUSEIJI);
    //        ReportServicesBean rsBean = null;
    //        skPreReportRenkeiBean.setSakuseizumiKouteikanriId("sinkeiyaku");
    //        String kouteiKanriId = skPreReportOperateProcess.operateProcess(torikomiSyoruiMstBean, torikomiSyoruiHukaInfoBean, rsBean);
    //        exStringEquals(kouteiKanriId, "sinkeiyaku", "工程管理ID");
    //
    //    }
    //
    //    @Test
    //    @TestOrder(30)
    //    public void testOperateProcess_A3() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN1;
    //        SkProcessCreateMock.SYORIPTN = SkProcessCreateMock.TESTPATTERN1;
    //        BzOutputProcessRecordMock.SYORIPTN = BzOutputProcessRecordMock.TESTPATTERN1;
    //        IwfKouteiClientMock.mode="01-05";
    //        TorikomiSyoruiBean torikomiSyoruiMstBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
    //        torikomiSyoruiMstBean.setTorikomisyoruinm("不備通知書");
    //        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfoBean = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
    //        torikomiSyoruiHukaInfoBean.setKouteisakuseikeiki(C_KouteiSakuseiKeikiKbn.SYORUI_SAKUSEIJI);
    //        torikomiSyoruiHukaInfoBean.setSyoruiCd(C_SyoruiCdKbn.SK_HUBITUUTI);
    //        ReportServicesBean rsBean = null;
    //        skPreReportRenkeiBean.setMosNo("791112220");
    //        skPreReportRenkeiBean.setSyoriComment("処理コメント");
    //        skPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
    //        String kouteiKanriId = skPreReportOperateProcess.operateProcess(torikomiSyoruiMstBean, torikomiSyoruiHukaInfoBean, rsBean);
    //        exStringEquals(kouteiKanriId, "SkMainDairiten", "工程管理ID");
    //        exStringEquals(skPreReportRenkeiBean.getSakuseizumiKouteikanriId(), "SkMainDairiten", "作成済工程管理ID");
    //
    //        BzGetProcessSummaryInBean bzGetProcessSummaryInBean = (BzGetProcessSummaryInBean)MockObjectManager.getArgument(BzGetProcessSummary.class, "exec", 0, 0);
    //        exStringEquals(bzGetProcessSummaryInBean.getJimuTetuzukiCd(), "SkMainDairiten", "事務手続コード");
    //        exStringEquals(bzGetProcessSummaryInBean.getMosNo(), "791112220", "申込番号");
    //        exClassificationEquals(bzGetProcessSummaryInBean.getKouteiKanriStatuss()[0],C_Kouteikanristatus.SYORITYUU," (配列)工程管理状況");
    //
    //        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreate.class, "exec", 0, 0);
    //        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
    //        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
    //        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "001", "代理店コード１");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "002", "代理店コード２");
    //        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "003", "事務用コード");
    //        exClassificationEquals(skProcessCreateInBean.getJmycdMisetteiKbn(),C_UmuKbn.ARI, "事務用コード未設定区分");
    //        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(),C_UmuKbn.ARI, "同時申込有無");
    //        exDateEquals(skProcessCreateInBean.getMosYmd(),BizDate.valueOf(20160229), "申込日");
    //        exStringEquals(skProcessCreateInBean.getJimuStartYmd(), "20160310143050123", "事務開始日");
    //        exStringEquals(skProcessCreateInBean.getSyoNo(), "11807111118", "証券番号");
    //        exStringEquals(skProcessCreateInBean.getMosNo(), "791112238", "申込番号");
    //        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), "SkHubiKaisyou", "事務手続コード");
    //
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 0, "SkMainDairiten");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 1, "SkHubiKaisyou");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 2, "処理コメント");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 3, "不備通知書作成");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);
    //    }
    //
    //    @Test
    //    @TestOrder(40)
    //    public void testOperateProcess_A4() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN1;
    //        SkProcessCreateMock.SYORIPTN = SkProcessCreateMock.TESTPATTERN1;
    //        BzOutputProcessRecordMock.SYORIPTN = BzOutputProcessRecordMock.TESTPATTERN1;
    //        IwfKouteiClientMock.mode="01-05";
    //        TorikomiSyoruiBean torikomiSyoruiMstBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
    //        torikomiSyoruiMstBean.setTorikomisyoruinm("契約確認依頼書");
    //        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfoBean = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
    //        torikomiSyoruiHukaInfoBean.setKouteisakuseikeiki(C_KouteiSakuseiKeikiKbn.SYORUI_SAKUSEIJI);
    //        torikomiSyoruiHukaInfoBean.setSyoruiCd(C_SyoruiCdKbn.SK_KYKKAKUNINIRAISYO);
    //        ReportServicesBean rsBean = null;
    //        skPreReportRenkeiBean.setMosNo("791112220");
    //        skPreReportRenkeiBean.setSyoriComment("処理コメント");
    //        skPreReportRenkeiBean.setSakuseizumiKouteikanriId(null);
    //        String kouteiKanriId = skPreReportOperateProcess.operateProcess(torikomiSyoruiMstBean, torikomiSyoruiHukaInfoBean, rsBean);
    //        exStringEquals(kouteiKanriId, "SkMainDairiten", "工程管理ID");
    //        exStringEquals(skPreReportRenkeiBean.getSakuseizumiKouteikanriId(), "SkMainDairiten", "作成済工程管理ID");
    //
    //        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreate.class, "exec", 0, 0);
    //        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
    //        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
    //        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "001", "代理店コード１");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "002", "代理店コード２");
    //        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "003", "事務用コード");
    //        exClassificationEquals(skProcessCreateInBean.getJmycdMisetteiKbn(),C_UmuKbn.ARI, "事務用コード未設定区分");
    //        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(),C_UmuKbn.ARI, "同時申込有無");
    //        exDateEquals(skProcessCreateInBean.getMosYmd(),BizDate.valueOf(20160229), "申込日");
    //        exStringEquals(skProcessCreateInBean.getJimuStartYmd(), "20160310143050123", "事務開始日");
    //        exStringEquals(skProcessCreateInBean.getSyoNo(), "11807111118", "証券番号");
    //        exStringEquals(skProcessCreateInBean.getMosNo(), "791112238", "申込番号");
    //        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), "SkKeiyakukakunin", "事務手続コード");
    //
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 0, "SkMainDairiten");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 1, "SkHubiKaisyou");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 2, "処理コメント");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 3, "契約確認依頼書作成");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);
    //    }
    //
    //    @Test
    //    @TestOrder(50)
    //    public void testOperateProcess_A5() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN1;
    //        SkProcessCreateMock.SYORIPTN = SkProcessCreateMock.TESTPATTERN1;
    //        BzOutputProcessRecordMock.SYORIPTN = BzOutputProcessRecordMock.TESTPATTERN1;
    //        IwfKouteiClientMock.mode="01-05";
    //        TorikomiSyoruiBean torikomiSyoruiMstBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
    //        torikomiSyoruiMstBean.setTorikomisyoruinm("取消請求書");
    //        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfoBean = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
    //        torikomiSyoruiHukaInfoBean.setKouteisakuseikeiki(C_KouteiSakuseiKeikiKbn.SYORUI_SAKUSEIJI);
    //        torikomiSyoruiHukaInfoBean.setSyoruiCd(C_SyoruiCdKbn.SK_TRKSSEIKYU);
    //        ReportServicesBean rsBean = null;
    //        skPreReportRenkeiBean.setMosNo("791112220");
    //        skPreReportRenkeiBean.setSyoriComment("処理コメント");
    //        skPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
    //        String kouteiKanriId = skPreReportOperateProcess.operateProcess(torikomiSyoruiMstBean, torikomiSyoruiHukaInfoBean, rsBean);
    //        exStringEquals(kouteiKanriId, "SkMainDairiten", "工程管理ID");
    //        exStringEquals(skPreReportRenkeiBean.getSakuseizumiKouteikanriId(), "SkMainDairiten", "作成済工程管理ID");
    //
    //        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreate.class, "exec", 0, 0);
    //        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
    //        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
    //        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "001", "代理店コード１");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "002", "代理店コード２");
    //        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "003", "事務用コード");
    //        exClassificationEquals(skProcessCreateInBean.getJmycdMisetteiKbn(),C_UmuKbn.ARI, "事務用コード未設定区分");
    //        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(),C_UmuKbn.ARI, "同時申込有無");
    //        exDateEquals(skProcessCreateInBean.getMosYmd(),BizDate.valueOf(20160229), "申込日");
    //        exStringEquals(skProcessCreateInBean.getJimuStartYmd(), "20160310143050123", "事務開始日");
    //        exStringEquals(skProcessCreateInBean.getSyoNo(), "11807111118", "証券番号");
    //        exStringEquals(skProcessCreateInBean.getMosNo(), "791112238", "申込番号");
    //        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), "SkTorikesi", "事務手続コード");
    //
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 0, "SkMainDairiten");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 1, "SkHubiKaisyou");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 2, "処理コメント");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 3, "取消請求書作成");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);
    //    }
    //
    //    @Test
    //    @TestOrder(60)
    //    public void testOperateProcess_A6() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN1;
    //        SkProcessCreateMock.SYORIPTN = SkProcessCreateMock.TESTPATTERN1;
    //        BzOutputProcessRecordMock.SYORIPTN = BzOutputProcessRecordMock.TESTPATTERN1;
    //        IwfKouteiClientMock.mode="01-05";
    //        TorikomiSyoruiBean torikomiSyoruiMstBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
    //        torikomiSyoruiMstBean.setTorikomisyoruinm("返金依頼書");
    //        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfoBean = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
    //        torikomiSyoruiHukaInfoBean.setKouteisakuseikeiki(C_KouteiSakuseiKeikiKbn.SYORUI_SAKUSEIJI);
    //        torikomiSyoruiHukaInfoBean.setSyoruiCd(C_SyoruiCdKbn.SK_HENKINIRAISYO);
    //        ReportServicesBean rsBean = null;
    //        skPreReportRenkeiBean.setMosNo("791112220");
    //        skPreReportRenkeiBean.setSyoriComment("処理コメント");
    //        skPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
    //        String kouteiKanriId = skPreReportOperateProcess.operateProcess(torikomiSyoruiMstBean, torikomiSyoruiHukaInfoBean, rsBean);
    //        exStringEquals(kouteiKanriId, "SkMainDairiten", "工程管理ID");
    //        exStringEquals(skPreReportRenkeiBean.getSakuseizumiKouteikanriId(), "SkMainDairiten", "作成済工程管理ID");
    //
    //        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreate.class, "exec", 0, 0);
    //        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
    //        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
    //        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "001", "代理店コード１");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "002", "代理店コード２");
    //        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "003", "事務用コード");
    //        exClassificationEquals(skProcessCreateInBean.getJmycdMisetteiKbn(),C_UmuKbn.ARI, "事務用コード未設定区分");
    //        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(),C_UmuKbn.ARI, "同時申込有無");
    //        exDateEquals(skProcessCreateInBean.getMosYmd(),BizDate.valueOf(20160229), "申込日");
    //        exStringEquals(skProcessCreateInBean.getJimuStartYmd(), "20160310143050123", "事務開始日");
    //        exStringEquals(skProcessCreateInBean.getSyoNo(), "11807111118", "証券番号");
    //        exStringEquals(skProcessCreateInBean.getMosNo(), "791112238", "申込番号");
    //        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), "SkHenkin", "事務手続コード");
    //
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 0, "SkMainDairiten");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 1, "SkHubiKaisyou");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 2, "処理コメント");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 3, "返金依頼書作成");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);
    //    }
    //
    //    @Test
    //    @TestOrder(70)
    //    public void testOperateProcess_A7() {
    //        MockObjectManager.initialize();
    //        BzGetProcessSummaryMock.SYORIPTN = BzGetProcessSummaryMock.TESTPATTERN1;
    //        SkProcessCreateMock.SYORIPTN = null;
    //        BzOutputProcessRecordMock.SYORIPTN = BzOutputProcessRecordMock.TESTPATTERN1;
    //        IwfKouteiClientMock.mode="01-05";
    //        TorikomiSyoruiBean torikomiSyoruiMstBean = SWAKInjector.getInstance(TorikomiSyoruiBean.class);
    //        torikomiSyoruiMstBean.setTorikomisyoruinm("QRシール");
    //        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfoBean = SWAKInjector.getInstance(BM_TorikomiSyoruiHukaInfo.class);
    //        torikomiSyoruiHukaInfoBean.setKouteisakuseikeiki(C_KouteiSakuseiKeikiKbn.SYORUI_SAKUSEIJI);
    //        torikomiSyoruiHukaInfoBean.setSyoruiCd(C_SyoruiCdKbn.WF_QRSEAL);
    //        ReportServicesBean rsBean = null;
    //        skPreReportRenkeiBean.setMosNo("791112220");
    //        skPreReportRenkeiBean.setSyoriComment("処理コメント");
    //        skPreReportRenkeiBean.setSakuseizumiKouteikanriId("");
    //        String kouteiKanriId = skPreReportOperateProcess.operateProcess(torikomiSyoruiMstBean, torikomiSyoruiHukaInfoBean, rsBean);
    //        exStringEquals(kouteiKanriId, "", "工程管理ID");
    //        exStringEquals(skPreReportRenkeiBean.getSakuseizumiKouteikanriId(), "", "作成済工程管理ID");
    //
    //        SkProcessCreateInBean skProcessCreateInBean = (SkProcessCreateInBean)MockObjectManager.getArgument(SkProcessCreate.class, "exec", 0, 0);
    //        exClassificationEquals(skProcessCreateInBean.getSkeiJimuKbn(),C_SkeijimuKbn.SMBC, "新契約事務区分");
    //        exClassificationEquals(skProcessCreateInBean.getMosUketukeKbn(),C_MosUketukeKbn.MOSKIT, "申込受付区分");
    //        exClassificationEquals(skProcessCreateInBean.getHknSyuruiNo(),C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "保険種類番号");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd1(), "001", "代理店コード１");
    //        exStringEquals(skProcessCreateInBean.getDairitenCd2(), "002", "代理店コード２");
    //        exStringEquals(skProcessCreateInBean.getJimuyouCd(), "003", "事務用コード");
    //        exClassificationEquals(skProcessCreateInBean.getJmycdMisetteiKbn(),C_UmuKbn.ARI, "事務用コード未設定区分");
    //        exClassificationEquals(skProcessCreateInBean.getDoujimosUmu(),C_UmuKbn.ARI, "同時申込有無");
    //        exDateEquals(skProcessCreateInBean.getMosYmd(),BizDate.valueOf(20160229), "申込日");
    //        exStringEquals(skProcessCreateInBean.getJimuStartYmd(), "20160310143050123", "事務開始日");
    //        exStringEquals(skProcessCreateInBean.getSyoNo(), "11807111118", "証券番号");
    //        exStringEquals(skProcessCreateInBean.getMosNo(), "791112238", "申込番号");
    //        exStringEquals(skProcessCreateInBean.getJimuTetuzukiCd(), "", "事務手続コード");
    //
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 0, "SkMainDairiten");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 1, "SkHubiKaisyou");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 2, "処理コメント");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 3, "");
    //        MockObjectManager.assertArgumentPassed(BzOutputProcessRecord.class, "exec", 4, C_SyorikekkaKbn.KANRYOU);
    //    }
}
