package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.hozen.bean.report.KhMisslistBean;
import yuyu.def.hozen.bean.report.KhMisslistDataSourceBean;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ミスリストTBL編集クラスのメソッド {@link EditKhMisslstTbl#editBean(C_SyoruiCdKbn, KhozenCommonParam, List<EditKhMisslstParam>, BizDate)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKhMisslstTblTest_editBean extends AbstractTest {

    @Inject
    private EditKhMisslstTbl editKhMisslstTbl;

    private final static String fileName = "UT_SP_単体テスト仕様書_ミスリストTBL編集";

    private final static String sheetName = "テストデータ";

    @Inject
    @Nullable
    private AS_Kinou kinou;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditKhMisslstTblTest_editBean.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
    }

    @Test
    @TestOrder(10)
    public void testEditBean_A1() {

        changeSystemDate(BizDate.valueOf(2015, 07, 30));

        KhozenCommonParam kCParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        kinou.setKinouId("EditKhMisslstTbl");
        kinou.setKinouNm("ミスリストTBL編集");

        List<EditKhMisslstParam> emParamLst = new ArrayList<>();

        ReportServicesBean rSBean = editKhMisslstTbl.editBean(C_SyoruiCdKbn.KK_KACHECK_YOHURI_MISSLIST, kCParam,
            emParamLst, BizDate.valueOf(20150728));

        exDateEquals(rSBean.getSyoriYmd(), BizDate.valueOf(20150728), "処理日付");

        KhMisslistBean kMLBean = (KhMisslistBean) rSBean.getParamObjectsData().get(
            C_SyoruiCdKbn.KK_KACHECK_YOHURI_MISSLIST.toString())[0];

        exStringEquals(kMLBean.getIrSyoriymd(), "平成27年 7月28日", "（ＩＲ）処理年月日");
        exNumericEquals(kMLBean.getIrKensuu(), 0, "（ＩＲ）件数");
        exStringEquals(kMLBean.getIrKinounm(), "預振口座ミスリストTBL編集", "（ＩＲ）機能名");
        exStringEquals(kMLBean.getIrHozonkkn(), "5 年", "（ＩＲ）保存期間");
        exStringEquals(kMLBean.getIrTyouhyousakuseiymd(), "平成27年 7月30日", "（ＩＲ）帳票作成日");

        List<IReportDataSouceBean> kSBeanLst = rSBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.KK_KACHECK_YOHURI_MISSLIST.getValue());

        exNumericEquals(kSBeanLst.size(), 0, "ミスリスト明細Beanリスト要素数");
    }

    @Test
    @TestOrder(20)
    public void testEditBean_A2() {

        changeSystemDate(BizDate.valueOf(2015, 07, 30));

        KhozenCommonParam kCParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        kinou.setKinouId("EditKhMisslstTbl");
        kinou.setKinouNm("ミスリストTBL編集");

        List<EditKhMisslstParam> emParamLst = new ArrayList<>();

        EditKhMisslstParam editKhMisslstParam = new EditKhMisslstParam();

        editKhMisslstParam.setDataNo(1);
        editKhMisslstParam.setSeqNo(10);
        editKhMisslstParam.setSyoNo("10000000000");
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.SUMI);
        editKhMisslstParam.setMisslistMsg("メッセージを設定します。");
        emParamLst.add(editKhMisslstParam);

        ReportServicesBean rSBean = editKhMisslstTbl.editBean(C_SyoruiCdKbn.KK_KACHECK_SHRKZ_MISSLIST, kCParam,
            emParamLst, BizDate.valueOf(20150728));

        exDateEquals(rSBean.getSyoriYmd(), BizDate.valueOf(20150728), "処理日付");

        KhMisslistBean kMLBean = (KhMisslistBean) rSBean.getParamObjectsData().get(
            C_SyoruiCdKbn.KK_KACHECK_SHRKZ_MISSLIST.toString())[0];

        exStringEquals(kMLBean.getIrSyoriymd(), "平成27年 7月28日", "（ＩＲ）処理年月日");
        exNumericEquals(kMLBean.getIrKensuu(), 1, "（ＩＲ）件数");
        exStringEquals(kMLBean.getIrKinounm(), "定期金支払口座ミスリストTBL編集", "（ＩＲ）機能名");
        exStringEquals(kMLBean.getIrHozonkkn(), "無し", "（ＩＲ）保存期間");
        exStringEquals(kMLBean.getIrTyouhyousakuseiymd(), "平成27年 7月30日", "（ＩＲ）帳票作成日");

        List<IReportDataSouceBean> kSBeanLst = rSBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.KK_KACHECK_SHRKZ_MISSLIST.getValue());

        exNumericEquals(kSBeanLst.size(), 1, "ミスリスト明細Beanリスト要素数");

        KhMisslistDataSourceBean khMisslistDataSourceBean1 = (KhMisslistDataSourceBean) kSBeanLst.get(0);

        exNumericEquals(khMisslistDataSourceBean1.getIrMisslistdatano(), 1, "（ＩＲ）データ番号");
        exBizCalcbleEquals(khMisslistDataSourceBean1.getIrSeqno(), BizNumber.valueOf(10), "（ＩＲ）SEQ-NO");
        exStringEquals(khMisslistDataSourceBean1.getIrSyono(), "10000000000", "（ＩＲ）証券番号");
        exClassificationEquals(khMisslistDataSourceBean1.getIrDbhanei(), C_Dbhanei.SUMI, "（ＩＲ）DB反映区分");
        exStringEquals(khMisslistDataSourceBean1.getIrMisslistmsg(), "メッセージを設定します。", "（ＩＲ）ミスリストメッセージ");
    }

    @Test
    @TestOrder(30)
    public void testEditBean_A3() {

        changeSystemDate(BizDate.valueOf(2015, 07, 30));

        KhozenCommonParam kCParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        kinou.setKinouId("EditKhMisslstTbl");
        kinou.setKinouNm("ミスリストTBL編集");

        List<EditKhMisslstParam> emParamLst = new ArrayList<>();
        EditKhMisslstParam editKhMisslstParam = new EditKhMisslstParam();
        editKhMisslstParam.setDataNo(1);
        editKhMisslstParam.setSeqNo(10);
        editKhMisslstParam.setSyoNo("10000000000");
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.SUMI);
        editKhMisslstParam.setMisslistMsg("あ：メッセージを設定します。");
        emParamLst.add(editKhMisslstParam);
        EditKhMisslstParam editKhMisslstParam1 = new EditKhMisslstParam();
        editKhMisslstParam1.setDataNo(2);
        editKhMisslstParam1.setSeqNo(20);
        editKhMisslstParam1.setSyoNo("10000000001");
        editKhMisslstParam1.setDBhaneikbn(C_Dbhanei.SUMI);
        editKhMisslstParam1.setMisslistMsg("い：メッセージを設定します。");
        emParamLst.add(editKhMisslstParam1);
        EditKhMisslstParam editKhMisslstParam2 = new EditKhMisslstParam();
        editKhMisslstParam2.setDataNo(3);
        editKhMisslstParam2.setSeqNo(30);
        editKhMisslstParam2.setSyoNo("10000000002");
        editKhMisslstParam2.setDBhaneikbn(C_Dbhanei.SUMI);
        editKhMisslstParam2.setMisslistMsg("う：メッセージを設定します。");
        emParamLst.add(editKhMisslstParam2);

        ReportServicesBean rSBean = editKhMisslstTbl.editBean(C_SyoruiCdKbn.KK_KYKINFOTORIKOMI_MISSLIST, kCParam,
            emParamLst, BizDate.valueOf(20150728));

        exDateEquals(rSBean.getSyoriYmd(), BizDate.valueOf(20150728), "処理日付");

        KhMisslistBean kMLBean = (KhMisslistBean) rSBean.getParamObjectsData().get(
            C_SyoruiCdKbn.KK_KYKINFOTORIKOMI_MISSLIST.toString())[0];

        exStringEquals(kMLBean.getIrSyoriymd(), "平成27年 7月28日", "（ＩＲ）処理年月日");
        exNumericEquals(kMLBean.getIrKensuu(), 3, "（ＩＲ）件数");
        exStringEquals(kMLBean.getIrKinounm(), "ミスリストTBL編集", "（ＩＲ）機能名");
        exStringEquals(kMLBean.getIrHozonkkn(), "3ヵ月", "（ＩＲ）保存期間");
        exStringEquals(kMLBean.getIrTyouhyousakuseiymd(), "平成27年 7月30日", "（ＩＲ）帳票作成日");

        List<IReportDataSouceBean> kSBeanLst = rSBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.KK_KYKINFOTORIKOMI_MISSLIST.getValue());

        exNumericEquals(kSBeanLst.size(), 3, "ミスリスト明細Beanリスト要素数");

        KhMisslistDataSourceBean khMisslistDataSourceBean1 = (KhMisslistDataSourceBean) kSBeanLst.get(0);
        exNumericEquals(khMisslistDataSourceBean1.getIrMisslistdatano(), 1, "（ＩＲ）データ番号");
        exBizCalcbleEquals(khMisslistDataSourceBean1.getIrSeqno(), BizNumber.valueOf(10), "（ＩＲ）SEQ-NO");
        exStringEquals(khMisslistDataSourceBean1.getIrSyono(), "10000000000", "（ＩＲ）証券番号");
        exClassificationEquals(khMisslistDataSourceBean1.getIrDbhanei(), C_Dbhanei.SUMI, "（ＩＲ）DB反映区分");
        exStringEquals(khMisslistDataSourceBean1.getIrMisslistmsg(), "あ：メッセージを設定します。", "（ＩＲ）ミスリストメッセージ");

        KhMisslistDataSourceBean khMisslistDataSourceBean2 = (KhMisslistDataSourceBean) kSBeanLst.get(1);
        exNumericEquals(khMisslistDataSourceBean2.getIrMisslistdatano(), 2, "（ＩＲ）データ番号");
        exBizCalcbleEquals(khMisslistDataSourceBean2.getIrSeqno(), BizNumber.valueOf(20), "（ＩＲ）SEQ-NO");
        exStringEquals(khMisslistDataSourceBean2.getIrSyono(), "10000000001", "（ＩＲ）証券番号");
        exClassificationEquals(khMisslistDataSourceBean2.getIrDbhanei(), C_Dbhanei.SUMI, "（ＩＲ）DB反映区分");
        exStringEquals(khMisslistDataSourceBean2.getIrMisslistmsg(), "い：メッセージを設定します。", "（ＩＲ）ミスリストメッセージ");

        KhMisslistDataSourceBean khMisslistDataSourceBean3 = (KhMisslistDataSourceBean) kSBeanLst.get(2);
        exNumericEquals(khMisslistDataSourceBean3.getIrMisslistdatano(), 3, "（ＩＲ）データ番号");
        exBizCalcbleEquals(khMisslistDataSourceBean3.getIrSeqno(), BizNumber.valueOf(30), "（ＩＲ）SEQ-NO");
        exStringEquals(khMisslistDataSourceBean3.getIrSyono(), "10000000002", "（ＩＲ）証券番号");
        exClassificationEquals(khMisslistDataSourceBean3.getIrDbhanei(), C_Dbhanei.SUMI, "（ＩＲ）DB反映区分");
        exStringEquals(khMisslistDataSourceBean3.getIrMisslistmsg(), "う：メッセージを設定します。", "（ＩＲ）ミスリストメッセージ");
    }
}
