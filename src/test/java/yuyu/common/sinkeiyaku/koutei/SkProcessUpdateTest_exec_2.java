package yuyu.common.sinkeiyaku.koutei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzProcessUpdateForBatch;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchInputBean;
import yuyu.common.biz.bzcommon.BzProcessUpdateForBatchMockForSinkeiyaku;
import yuyu.common.biz.bzcommon.TuikaParamForBatchInputBean;
import yuyu.common.biz.bzcommon.TuikaParamInputBean;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryMockForSinkeiyaku;
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
 * SkProcessUpdateクラスのメソッド {@link SkProcessUpdate#exec(TuikaParamInputBean, String, String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SkProcessUpdateTest_exec_2 {

    @Inject
    private SkProcessUpdate skProcessUpdate;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(BzGetProcessSummary.class).to(BzGetProcessSummaryMockForSinkeiyaku.class);
                bind(BzProcessUpdateForBatch.class).to(BzProcessUpdateForBatchMockForSinkeiyaku.class);

            }
        });
    }
    @BeforeClass
    public static void testInit() {
        BzGetProcessSummaryMockForSinkeiyaku.caller = SkProcessUpdateTest_exec_2.class;
        BzProcessUpdateForBatchMockForSinkeiyaku.caller = SkProcessUpdateTest_exec_2.class;
    }

    @AfterClass
    public static void testClear() {

        BzGetProcessSummaryMockForSinkeiyaku.caller = null;
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = null;
        BzProcessUpdateForBatchMockForSinkeiyaku.caller = null;
        BzProcessUpdateForBatchMockForSinkeiyaku.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_B1() {
        MockObjectManager.initialize();
        BzGetProcessSummaryMockForSinkeiyaku.SYORIPTN = BzGetProcessSummaryMockForSinkeiyaku.TESTPATTERN1;
        BzProcessUpdateForBatchMockForSinkeiyaku.SYORIPTN = BzProcessUpdateForBatchMockForSinkeiyaku.TESTPATTERN1;

        TuikaParamInputBean tuikaParamInputBean = new TuikaParamInputBean();

        tuikaParamInputBean.setSkeijimukbn(C_SkeijimuKbn.MIZUHO);
        tuikaParamInputBean.setMosuketukekbn(C_MosUketukeKbn.SEIHOWEB);
        tuikaParamInputBean.setHknsyuruiNo(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI);
        tuikaParamInputBean.setDairitencd1("1000001");
        tuikaParamInputBean.setDairitencd2("1000002");
        tuikaParamInputBean.setJimuyoucd("101");
        tuikaParamInputBean.setDoujimosumu(C_UmuKbn.ARI);
        tuikaParamInputBean.setMosymd(BizDate.valueOf("20160812"));
        tuikaParamInputBean.setJimustartymd("20170818");
        tuikaParamInputBean.setSyono("17810000050");
        tuikaParamInputBean.setNksysyno("17807000016");
        tuikaParamInputBean.setMosno("791112261");
        tuikaParamInputBean.setKetteiKbn(C_KetteiKbn.NONE);
        tuikaParamInputBean.setSeirituKbn(C_SeirituKbn.NONE);
        tuikaParamInputBean.setLincjkKbn(C_LincjkKbn.KAITOARI_TASYAARI);

        String skDrtenKouteiLockKey = "1234567";

        String skHenkinKouteiLockKey = "123456789";

        skProcessUpdate.exec(tuikaParamInputBean, skDrtenKouteiLockKey, skHenkinKouteiLockKey);

        MockObjectManager.assertCalled(SkProcessUpdate.class, "editProcessUpdateForBatchInfo");
        MockObjectManager.assertCalled(SkProcessUpdate.class, "execForBatch");

        List<BzProcessUpdateForBatchInputBean> bzProcessUpdateForBatchInputBeanList =
            (List<BzProcessUpdateForBatchInputBean>)MockObjectManager.getArgument(SkProcessUpdate.class, "execForBatch", 0, 0);

        exNumericEquals(bzProcessUpdateForBatchInputBeanList.size(), 1, "件数");

        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(0).getJimuTetuzukiCd(), "skhenkin", "事務手続コード");
        exStringEquals(bzProcessUpdateForBatchInputBeanList.get(0).getKouteiKanriId(), "5302", "工程管理ID");
        exClassificationEquals(bzProcessUpdateForBatchInputBeanList.get(0).getKokouteiUpdumu(), C_UmuKbn.ARI, "子工程更新有無区分");

        TuikaParamForBatchInputBean TuikaParamForBatchInputBean = bzProcessUpdateForBatchInputBeanList.get(0).getTuikaParamForBatchInputBean();

        exClassificationEquals(TuikaParamForBatchInputBean.getSkeijimukbn(), C_SkeijimuKbn.MIZUHO, "新契約事務区分");
        exClassificationEquals(TuikaParamForBatchInputBean.getMosuketukekbn(), C_MosUketukeKbn.SEIHOWEB, "申込受付区分");
        exClassificationEquals(TuikaParamForBatchInputBean.getHknsyuruiNo(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_YOKUSEI, "保険種類番号");
        exStringEquals(TuikaParamForBatchInputBean.getDairitencd1(), "1000001", "代理店コード１");
        exStringEquals(TuikaParamForBatchInputBean.getDairitencd2(), "1000002", "代理店コード２");
        exStringEquals(TuikaParamForBatchInputBean.getJimuyoucd(), "101", "事務用コード");
        exClassificationEquals(TuikaParamForBatchInputBean.getDoujimosumu(), C_UmuKbn.ARI, "同時申込有無");
        exDateEquals(TuikaParamForBatchInputBean.getMosymd(), BizDate.valueOf(20160812), "申込日");
        exStringEquals(TuikaParamForBatchInputBean.getJimustartymd(), "20170818", "事務開始日");
        exStringEquals(TuikaParamForBatchInputBean.getSyono(), "17810000050", "証券番号");
        exStringEquals(TuikaParamForBatchInputBean.getNksysyno(), "17807000016", "年金証書番号");
        exStringEquals(TuikaParamForBatchInputBean.getMosno(), "791112261", "申込番号");
        exClassificationEquals(TuikaParamForBatchInputBean.getKetteiKbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(TuikaParamForBatchInputBean.getSeirituKbn(), C_SeirituKbn.NONE, "成立区分");
        exClassificationEquals(TuikaParamForBatchInputBean.getLincjkKbn(), C_LincjkKbn.KAITOARI_TASYAARI, "ＬＩＮＣ状況区分");

    }
}
