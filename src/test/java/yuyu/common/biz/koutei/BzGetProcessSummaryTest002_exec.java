package yuyu.common.biz.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.workflow.IwfKouteiClientMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.DM_Jimutetuzuki;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflow.manager.WorkflowDomManager;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通工程サマリ取得クラスのメソッド<br />
 * {@link BzGetProcessSummary#exec(BzGetProcessSummaryInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetProcessSummaryTest002_exec extends AbstractTest{

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);
        WorkflowDomManager workflowDomManager = SWAKInjector.getInstance(WorkflowDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        iwfCoreDomManager.delete(iwfCoreDomManager.getAllKouteiSummary());
        workflowDomManager.delete(workflowDomManager.getAllJimutetuzuki());

        DM_Jimutetuzuki jimu = new DM_Jimutetuzuki();
        jimu.setJimutetuzukicd("test");
        jimu.setSubSystemId("nenkin");
        iwfCoreDomManager.insert(jimu);

    }

    @Transactional
    public void insertTestData1() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        iwfCoreDomManager.delete(iwfCoreDomManager.getAllKouteiSummary());

        BT_GyoumuKouteiInfo gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0101");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0101");
        bizDomManager.insert(gyoumukouteiinfo);

        gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0102");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0102");
        bizDomManager.insert(gyoumukouteiinfo);

        WT_KouteiSummary summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0101");
        summary.setSyoriStatus("0");
        summary.setExtParam11("20161101111500000");
        iwfCoreDomManager.insert(summary);

        summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0102");
        summary.setSyoriStatus("0");
        summary.setExtParam11("20161103001500000");
        iwfCoreDomManager.insert(summary);

    }

    @Transactional
    public void insertTestData2() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        iwfCoreDomManager.delete(iwfCoreDomManager.getAllKouteiSummary());

        BT_GyoumuKouteiInfo gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0201");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0201");
        bizDomManager.insert(gyoumukouteiinfo);

        gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0202");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0202");
        bizDomManager.insert(gyoumukouteiinfo);

        gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0203");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0203");
        bizDomManager.insert(gyoumukouteiinfo);

        WT_KouteiSummary summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0201");
        summary.setSyoriStatus("0");
        summary.setExtParam15("0");
        iwfCoreDomManager.insert(summary);

        summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0202");
        summary.setSyoriStatus("0");
        summary.setExtParam15("1");
        iwfCoreDomManager.insert(summary);

        summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0203");
        summary.setSyoriStatus("0");
        summary.setExtParam15("2");
        iwfCoreDomManager.insert(summary);

    }


    @Transactional
    public void insertTestData3() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        iwfCoreDomManager.delete(iwfCoreDomManager.getAllKouteiSummary());

        BT_GyoumuKouteiInfo gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0301");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0301");
        bizDomManager.insert(gyoumukouteiinfo);

        gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0302");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0302");
        bizDomManager.insert(gyoumukouteiinfo);

        gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0303");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0303");
        bizDomManager.insert(gyoumukouteiinfo);

        WT_KouteiSummary summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0301");
        summary.setSyoriStatus("0");
        summary.setExtParam16("0");
        iwfCoreDomManager.insert(summary);

        summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0302");
        summary.setSyoriStatus("0");
        summary.setExtParam16("1");
        iwfCoreDomManager.insert(summary);

        summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0303");
        summary.setSyoriStatus("0");
        summary.setExtParam16("2");
        iwfCoreDomManager.insert(summary);

    }


    @Transactional
    public void insertTestData4() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        IwfCoreDomManager iwfCoreDomManager = SWAKInjector.getInstance(IwfCoreDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
        iwfCoreDomManager.delete(iwfCoreDomManager.getAllKouteiSummary());

        BT_GyoumuKouteiInfo gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0401");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0401");
        bizDomManager.insert(gyoumukouteiinfo);

        gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0402");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0402");
        bizDomManager.insert(gyoumukouteiinfo);

        gyoumukouteiinfo = new BT_GyoumuKouteiInfo();
        gyoumukouteiinfo.setKouteikanriid("0403");
        gyoumukouteiinfo.setSubSystemId("nenkin");
        gyoumukouteiinfo.setJimutetuzukicd("test");
        gyoumukouteiinfo.setSyukouteikanriid("0403");
        bizDomManager.insert(gyoumukouteiinfo);

        WT_KouteiSummary summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0401");
        summary.setSyoriStatus("0");
        summary.setExtParam17("0");
        iwfCoreDomManager.insert(summary);

        summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0402");
        summary.setSyoriStatus("0");
        summary.setExtParam17("1");
        iwfCoreDomManager.insert(summary);

        summary = new WT_KouteiSummary();
        summary.setGyoumuKey("0403");
        summary.setSyoriStatus("0");
        summary.setExtParam17("2");
        iwfCoreDomManager.insert(summary);

    }


    @Test
    @TestOrder(10)
    public void test_A1() {

        insertTestData1();

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        input.setJimuKaisiYmdFrom("20161101");
        input.setJimuKaisiYmdTo("20161101");

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 1, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0101", "工程管理ＩＤ");
        exDateEquals(result.get(0).getJimuStartYmd(), BizDate.valueOf("20161101"), "事務開始年月日");
        exStringEquals(result.get(0).getJimuStartYmdTime(), "20161101111500000", "事務開始日");

    }
    @Test
    @TestOrder(20)
    public void test_A2() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        input.setJimuKaisiYmdFrom("20161102");
        input.setJimuKaisiYmdTo("20161102");

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 0, "業務共通工程サマリ取得出力Beanリストのサイズ");

    }
    @Test
    @TestOrder(30)
    public void test_A3() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        input.setJimuKaisiYmdFrom("20161101100000000");
        input.setJimuKaisiYmdTo("20161101120000000");

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 1, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0101", "工程管理ＩＤ");
        exDateEquals(result.get(0).getJimuStartYmd(), BizDate.valueOf("20161101"), "事務開始年月日");
        exStringEquals(result.get(0).getJimuStartYmdTime(), "20161101111500000", "事務開始日");

    }
    @Test
    @TestOrder(40)
    public void test_A4() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        input.setJimuKaisiYmdFrom("20161101100000000");
        input.setJimuKaisiYmdTo("20161101110000000");

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 0, "業務共通工程サマリ取得出力Beanリストのサイズ");

    }
    @Test
    @TestOrder(50)
    public void test_A5() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        input.setJimuKaisiYmdFrom(null);
        input.setJimuKaisiYmdTo(null);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 2, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0101", "工程管理ＩＤ");
        exDateEquals(result.get(0).getJimuStartYmd(), BizDate.valueOf("20161101"), "事務開始年月日");
        exStringEquals(result.get(0).getJimuStartYmdTime(), "20161101111500000", "事務開始日");
        exStringEquals(result.get(1).getKouteiKanriId(), "0102", "工程管理ＩＤ");
        exDateEquals(result.get(1).getJimuStartYmd(), BizDate.valueOf("20161103"), "事務開始年月日");
        exStringEquals(result.get(1).getJimuStartYmdTime(), "20161103001500000", "事務開始日");

    }

    @Test
    @TestOrder(60)
    public void test_B1() {
        insertTestData2();
        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_KetteiKbn[] ketteiKbn = {C_KetteiKbn.NONE};
        input.setKetteiKbn(ketteiKbn);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 1, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0201", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getKetteiKbn(), C_KetteiKbn.NONE, "決定状態区分");

    }


    @Test
    @TestOrder(70)
    public void test_B2() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_KetteiKbn[] ketteiKbn = {C_KetteiKbn.NONE,C_KetteiKbn.KETTEI_SUMI};
        input.setKetteiKbn(ketteiKbn);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 2, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0201", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getKetteiKbn(), C_KetteiKbn.NONE, "決定状態区分");
        exStringEquals(result.get(1).getKouteiKanriId(), "0202", "工程管理ＩＤ");
        exClassificationEquals(result.get(1).getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");

    }

    @Test
    @TestOrder(80)
    public void test_B3() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_KetteiKbn[] ketteiKbn = null;
        input.setKetteiKbn(ketteiKbn);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 3, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0201", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getKetteiKbn(), C_KetteiKbn.NONE, "決定状態区分");
        exStringEquals(result.get(1).getKouteiKanriId(), "0202", "工程管理ＩＤ");
        exClassificationEquals(result.get(1).getKetteiKbn(), C_KetteiKbn.KETTEI_SUMI, "決定状態区分");
        exStringEquals(result.get(2).getKouteiKanriId(), "0203", "工程管理ＩＤ");
        exClassificationEquals(result.get(2).getKetteiKbn(), C_KetteiKbn.KETTEI_MATI, "決定状態区分");

    }

    @Test
    @TestOrder(90)
    public void test_C1() {
        insertTestData3();
        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_SeirituKbn[] seirituKbn = {C_SeirituKbn.NONE};
        input.setSeirituKbn(seirituKbn);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 1, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0301", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getSeirituKbn(), C_SeirituKbn.NONE, "成立区分");

    }


    @Test
    @TestOrder(100)
    public void test_C2() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_SeirituKbn[] seirituKbn = {C_SeirituKbn.NONE, C_SeirituKbn.SEIRITU};
        input.setSeirituKbn(seirituKbn);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 2, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0301", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getSeirituKbn(), C_SeirituKbn.NONE, "成立区分");
        exStringEquals(result.get(1).getKouteiKanriId(), "0302", "工程管理ＩＤ");
        exClassificationEquals(result.get(1).getSeirituKbn(), C_SeirituKbn.SEIRITU, "成立区分");

    }

    @Test
    @TestOrder(110)
    public void test_C3() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_SeirituKbn[] seirituKbn = null;
        input.setSeirituKbn(seirituKbn);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 3, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0301", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getSeirituKbn(), C_SeirituKbn.NONE, "成立区分");
        exStringEquals(result.get(1).getKouteiKanriId(), "0302", "工程管理ＩＤ");
        exClassificationEquals(result.get(1).getSeirituKbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exStringEquals(result.get(2).getKouteiKanriId(), "0303", "工程管理ＩＤ");
        exClassificationEquals(result.get(2).getSeirituKbn(), C_SeirituKbn.ITIPMATI, "成立区分");

    }

    @Test
    @TestOrder(120)
    public void test_D1() {
        insertTestData4();
        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_LincjkKbn[] lincjkKbn = {C_LincjkKbn.MIHANTEI};
        input.setLincjkKbn(lincjkKbn);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 1, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0401", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getLincjkKbn(), C_LincjkKbn.MIHANTEI, "ＬＩＮＣ状況区分");

    }


    @Test
    @TestOrder(130)
    public void test_D2() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_LincjkKbn[] lincjkKbn = { C_LincjkKbn.MIHANTEI, C_LincjkKbn.SYOUKAITAISYOUGAI};
        input.setLincjkKbn(lincjkKbn);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 2, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0401", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getLincjkKbn(), C_LincjkKbn.MIHANTEI, "ＬＩＮＣ状況区分");
        exStringEquals(result.get(1).getKouteiKanriId(), "0402", "工程管理ＩＤ");
        exClassificationEquals(result.get(1).getLincjkKbn(),  C_LincjkKbn.SYOUKAITAISYOUGAI, "ＬＩＮＣ状況区分");

    }

    @Test
    @TestOrder(140)
    public void test_D3() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_LincjkKbn[] lincjkKbn = null;
        input.setLincjkKbn(lincjkKbn);

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 3, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0401", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getLincjkKbn(), C_LincjkKbn.MIHANTEI, "ＬＩＮＣ状況区分");
        exStringEquals(result.get(1).getKouteiKanriId(), "0402", "工程管理ＩＤ");
        exClassificationEquals(result.get(1).getLincjkKbn(), C_LincjkKbn.SYOUKAITAISYOUGAI, "ＬＩＮＣ状況区分");
        exStringEquals(result.get(2).getKouteiKanriId(), "0403", "工程管理ＩＤ");
        exClassificationEquals(result.get(2).getLincjkKbn(), C_LincjkKbn.SYOUKAIMATI, "ＬＩＮＣ状況区分");

    }

    @Test
    @TestOrder(150)
    public void test_E1() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_LincjkKbn[] lincjkKbn = { C_LincjkKbn.MIHANTEI, C_LincjkKbn.SYOUKAITAISYOUGAI};
        input.setLincjkKbn(lincjkKbn);
        input.setKekkajyougenkensu("2");

        List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);

        exNumericEquals(result.size(), 2, "業務共通工程サマリ取得出力Beanリストのサイズ");
        exStringEquals(result.get(0).getKouteiKanriId(), "0401", "工程管理ＩＤ");
        exClassificationEquals(result.get(0).getLincjkKbn(), C_LincjkKbn.MIHANTEI, "ＬＩＮＣ状況区分");
        exStringEquals(result.get(1).getKouteiKanriId(), "0402", "工程管理ＩＤ");
        exClassificationEquals(result.get(1).getLincjkKbn(),  C_LincjkKbn.SYOUKAITAISYOUGAI, "ＬＩＮＣ状況区分");

    }

    @Test
    @TestOrder(160)
    public void test_E2() {

        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_LincjkKbn[] lincjkKbn = { C_LincjkKbn.MIHANTEI, C_LincjkKbn.SYOUKAITAISYOUGAI};
        input.setLincjkKbn(lincjkKbn);
        input.setKekkajyougenkensu("1");

        try{
            List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);
        }catch (Exception e){
            exStringEquals(e.getMessage(), "取得数が、上限件数を超えています。","エラーメッセージ");
        }

    }

    @Test
    @TestOrder(170)
    public void test_E3() {

        IwfKouteiClientMock.caller = "Test";
        IwfKouteiClientMock.mode = "90-00";
        BzGetProcessSummaryInBean input = new BzGetProcessSummaryInBean();

        C_LincjkKbn[] lincjkKbn = { C_LincjkKbn.MIHANTEI, C_LincjkKbn.SYOUKAITAISYOUGAI};
        input.setLincjkKbn(lincjkKbn);


        try{
            List<BzGetProcessSummaryOutBean> result = bzGetProcessSummary.exec(input);
        }catch (Exception e){
            exStringEquals(e.getMessage(), "IWFエラーです。機能＝業務共通工程サマリ取得、API＝工程サマリ取得、エラーコード＝IWF2160","エラーメッセージ");
        }

    }
}
