package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouBean;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouDetailBean;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
/**
 * 事務連絡票TBL編集クラスのメソッド {@link EditJimuRenrakuhyouTbl#editBean(C_SyoruiCdKbn, String, KhozenCommonParam, EditJimuRenrakuhyouParam, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditJimuRenrakuhyouTblTest_editBean extends AbstractTest{

    private final String syoNo = "01234567891";

    @Inject
    BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    private final static String fileName = "UT_SP_単体テスト仕様書_事務連絡票TBL編集";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditJimuRenrakuhyouTblTest_editBean.class, fileName, sheetName);
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
        baseDomManager.delete(baseDomManager.getAllSequences());
    }

    @Test
    @TestOrder(10)
    public void testEditBean_A1() {

        baseUserInfo.getUser().setUserId("cd");
        baseUserInfo.getUser().setUserNm("小野");

        kinou.setCategoryId("khcommon");
        kinou.setKinouNm("事務連絡票TBL編集");

        changeSystemDate(BizDate.valueOf(2015, 11, 2));
        List<String> msgLst = new ArrayList<>();
        EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);
        editJimuRenrakuhyouParam.setJimurenrakuMsgList(msgLst);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditJimuRenrakuhyouTbl");

        EditJimuRenrakuhyouTbl editJimuRenrakuhyouTbl = SWAKInjector.getInstance(EditJimuRenrakuhyouTbl.class);
        ReportServicesBean reportServicesBean = editJimuRenrakuhyouTbl.editBean(C_SyoruiCdKbn.KK_JIMURENRAKU, syoNo,
            khozenCommonParam, editJimuRenrakuhyouParam, BizDate.valueOf(20151002));

        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151002), "処理日付");
        exStringEquals(reportServicesBean.getKensakuKeys()[0], syoNo, "検索キー");
        exStringEquals(reportServicesBean.getCategoryId(),"khcommon" ,"カテゴリID");
        exStringEquals(reportServicesBean.getKinouId(),"EditJimuRenrakuhyouTbl" ,"機能ID");

        Object[] kSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_JIMURENRAKU.getValue());
        KhJimuRenrakuhyouBean khJimuRenrakuhyouBean = (KhJimuRenrakuhyouBean)kSBean[0];
        exStringEquals(khJimuRenrakuhyouBean.getIrSyoriymd(), "平成27年10月 2日", "（ＩＲ）処理年月日");
        exStringEquals(khJimuRenrakuhyouBean.getIrSyono(), "01234567891", "（ＩＲ）証券番号");
        exStringEquals(khJimuRenrakuhyouBean.getIrKinounm(), "事務連絡票TBL編集", "（ＩＲ）機能名");
        exStringEquals(khJimuRenrakuhyouBean.getIrTantcd(), "cd", "（ＩＲ）担当者コード");
        exStringEquals(khJimuRenrakuhyouBean.getIrTantnm(), "小野", "（ＩＲ）担当者名");
        exStringEquals(khJimuRenrakuhyouBean.getIrHozonkkn(), "", "（ＩＲ）保存期間");
        exStringEquals(khJimuRenrakuhyouBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJINoEx(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        List<IReportDataSouceBean> kSBeanLst = reportServicesBean.getBeanDataSouceData().get(C_SyoruiCdKbn.KK_JIMURENRAKU.getValue());
        exNumericEquals(kSBeanLst.size(), 0, "要素数");
    }

    @Test
    @TestOrder(20)
    public void testEditBean_A2() {

        baseUserInfo.getUser().setUserId("cd");
        baseUserInfo.getUser().setUserNm("小野");

        kinou.setCategoryId("khcommon");
        kinou.setKinouNm("事務連絡票TBL編集");

        changeSystemDate(BizDate.valueOf(2015, 11, 2));
        List<String> msgLst = new ArrayList<>();
        msgLst.add("事務連絡票メッセージ１");
        EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);
        editJimuRenrakuhyouParam.setJimurenrakuMsgList(msgLst);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditJimuRenrakuhyouTbl");

        EditJimuRenrakuhyouTbl editJimuRenrakuhyouTbl = SWAKInjector.getInstance(EditJimuRenrakuhyouTbl.class);
        ReportServicesBean reportServicesBean = editJimuRenrakuhyouTbl.editBean(C_SyoruiCdKbn.KK_JIMURENRAKU, syoNo,
            khozenCommonParam, editJimuRenrakuhyouParam, BizDate.valueOf(20151002));
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151002), "処理日付");
        exStringEquals(reportServicesBean.getKensakuKeys()[0], syoNo, "検索キー");
        exStringEquals(reportServicesBean.getCategoryId(),"khcommon" ,"カテゴリID");
        exStringEquals(reportServicesBean.getKinouId(),"EditJimuRenrakuhyouTbl" ,"機能ID");

        Object[] kSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_JIMURENRAKU.getValue());
        KhJimuRenrakuhyouBean khJimuRenrakuhyouBean = (KhJimuRenrakuhyouBean)kSBean[0];

        exStringEquals(khJimuRenrakuhyouBean.getIrSyoriymd(), "平成27年10月 2日", "（ＩＲ）処理年月日");
        exStringEquals(khJimuRenrakuhyouBean.getIrSyono(), "01234567891", "（ＩＲ）証券番号");
        exStringEquals(khJimuRenrakuhyouBean.getIrKinounm(), "事務連絡票TBL編集", "（ＩＲ）機能名");
        exStringEquals(khJimuRenrakuhyouBean.getIrTantcd(), "cd", "（ＩＲ）担当者コード");
        exStringEquals(khJimuRenrakuhyouBean.getIrTantnm(), "小野", "（ＩＲ）担当者名");
        exStringEquals(khJimuRenrakuhyouBean.getIrHozonkkn(), "", "（ＩＲ）保存期間");
        exStringEquals(khJimuRenrakuhyouBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJINoEx(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        List<IReportDataSouceBean> kSBeanLst = reportServicesBean.getBeanDataSouceData().get(C_SyoruiCdKbn.KK_JIMURENRAKU.getValue());
        exNumericEquals(kSBeanLst.size(), 1, "要素数");
        KhJimuRenrakuhyouDetailBean khSeikyuusyoBean = (KhJimuRenrakuhyouDetailBean)kSBeanLst.get(0);
        exStringEquals(khSeikyuusyoBean.getIrJmrnrkhyoumsg(), "事務連絡票メッセージ１", "事務連絡票メッセージ");
    }

    @Test
    @TestOrder(30)
    public void testEditBean_A3() {

        baseUserInfo.getUser().setUserId("cd");
        baseUserInfo.getUser().setUserNm("小野");

        kinou.setCategoryId("khcommon");
        kinou.setKinouNm("事務連絡票TBL編集");

        changeSystemDate(BizDate.valueOf(2015, 11, 2));
        List<String> msgLst = new ArrayList<>();
        msgLst.add("事務連絡票メッセージ１");
        msgLst.add("事務連絡票メッセージ２");
        msgLst.add("事務連絡票メッセージ３");
        EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);
        editJimuRenrakuhyouParam.setJimurenrakuMsgList(msgLst);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditJimuRenrakuhyouTbl");

        EditJimuRenrakuhyouTbl editJimuRenrakuhyouTbl = SWAKInjector.getInstance(EditJimuRenrakuhyouTbl.class);
        ReportServicesBean reportServicesBean = editJimuRenrakuhyouTbl.editBean(C_SyoruiCdKbn.KK_JIMURENRAKU, syoNo,
            khozenCommonParam, editJimuRenrakuhyouParam, BizDate.valueOf(20151002));
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20151002), "処理日付");
        exStringEquals(reportServicesBean.getKensakuKeys()[0], syoNo, "検索キー");
        exStringEquals(reportServicesBean.getCategoryId(),"khcommon" ,"カテゴリID");
        exStringEquals(reportServicesBean.getKinouId(),"EditJimuRenrakuhyouTbl" ,"機能ID");

        Object[] kSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.KK_JIMURENRAKU.getValue());
        KhJimuRenrakuhyouBean khJimuRenrakuhyouBean = (KhJimuRenrakuhyouBean)kSBean[0];

        exStringEquals(khJimuRenrakuhyouBean.getIrSyoriymd(), "平成27年10月 2日", "（ＩＲ）処理年月日");
        exStringEquals(khJimuRenrakuhyouBean.getIrSyono(), "01234567891", "（ＩＲ）証券番号");
        exStringEquals(khJimuRenrakuhyouBean.getIrKinounm(), "事務連絡票TBL編集", "（ＩＲ）機能名");
        exStringEquals(khJimuRenrakuhyouBean.getIrTantcd(), "cd", "（ＩＲ）担当者コード");
        exStringEquals(khJimuRenrakuhyouBean.getIrTantnm(), "小野", "（ＩＲ）担当者名");
        exStringEquals(khJimuRenrakuhyouBean.getIrHozonkkn(), "", "（ＩＲ）保存期間");
        exStringEquals(khJimuRenrakuhyouBean.getIrTyouhyousakuseiymd(), DateFormatUtil.dateKANJINoEx(BizDate.getSysDate()), "（ＩＲ）帳票作成日");
        List<IReportDataSouceBean> kSBeanLst = reportServicesBean.getBeanDataSouceData().get(C_SyoruiCdKbn.KK_JIMURENRAKU.getValue());
        exNumericEquals(kSBeanLst.size(), 3, "要素数");
        KhJimuRenrakuhyouDetailBean khSeikyuusyoBean1 = (KhJimuRenrakuhyouDetailBean)kSBeanLst.get(0);
        exStringEquals(khSeikyuusyoBean1.getIrJmrnrkhyoumsg(), "事務連絡票メッセージ１", "事務連絡票メッセージ");
        KhJimuRenrakuhyouDetailBean khSeikyuusyoBean2 = (KhJimuRenrakuhyouDetailBean)kSBeanLst.get(1);
        exStringEquals(khSeikyuusyoBean2.getIrJmrnrkhyoumsg(), "事務連絡票メッセージ２", "事務連絡票メッセージ");
        KhJimuRenrakuhyouDetailBean khSeikyuusyoBean3 = (KhJimuRenrakuhyouDetailBean)kSBeanLst.get(2);
        exStringEquals(khSeikyuusyoBean3.getIrJmrnrkhyoumsg(), "事務連絡票メッセージ３", "事務連絡票メッセージ");
    }
}
