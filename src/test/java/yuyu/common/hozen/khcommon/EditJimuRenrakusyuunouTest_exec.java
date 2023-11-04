package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouSyuunouBean;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouSyuunouDetailBean;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

import com.google.common.collect.Lists;

/**
 * 事務連絡票(収納)編集クラスのメソッド {@link EditJimuRenrakusyuunou#exec()}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditJimuRenrakusyuunouTest_exec {

    private final static String syono1 = "11807000010";

    private final static String syono2 = "11807000021";

    private final static String syono3 = "11807000032";

    private final static BizDate syoriYmd1 = BizDate.valueOf("20171115");

    private final static BizDate syoriYmd2 = BizDate.valueOf("20171116");

    private final static BizDate syoriYmd3 = BizDate.valueOf("20171117");

    @Inject
    private AS_Kinou kinouInfo;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private EditJimuRenrakusyuunou editJimuRenrakusyuunou;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        baseUserInfo.getUser().setUserId("JUnit");
        baseUserInfo.getUser().setUserNm("Test");
        kinouInfo.setKinouId("editjimurenrakusyuunou");
        kinouInfo.setKinouNm("事務連絡票(収納)編集");
        kinouInfo.setCategoryId("khcommon");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam =
            SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
        List<String> jimuMsgLst = Lists.newArrayList();
        editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuMsgLst);

        ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(khozenCommonParam, syono1,
            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU, editJimuRenrakusyuunouParam, syoriYmd1);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono1, "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), syoriYmd1, "処理日付");
        Map<String, List<IReportDataSouceBean>> map1 = reportServicesBean.getBeanDataSouceData();
        List<IReportDataSouceBean> lst = map1.get(C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU.getValue());
        exNumericEquals(lst.size(), 0, "事務連絡票(収納)明細帳票Beanリストの要素数");
        Map<String, Object[]> map2 = reportServicesBean.getParamObjectsData();
        KhJimuRenrakuhyouSyuunouBean bean = (KhJimuRenrakuhyouSyuunouBean)map2.get(
            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU.getValue())[0];
        exStringEquals(bean.getIrSyoriymd(), "2017年11月15日", "（ＩＲ）処理年月日");
        exStringEquals(bean.getIrSyono(), syono1, "（ＩＲ）証券番号");
        exStringEquals(bean.getIrKinounm(), "事務連絡票(収納)編集", "（ＩＲ）機能名");
        exStringEquals(bean.getIrTantcd(), "JUnit", "（ＩＲ）担当者コード");
        exStringEquals(bean.getIrTantnm(), "Test", "（ＩＲ）担当者名");

        //        exStringEquals((String)MockObjectManager.getArgument(CreateReport.class, "createNewReportServiceBean", 0, 0),
        //            IKhozenCommonConstants.SUBSYSTEMID_HOZEN, "サブシステムID");
        //        exStringEquals((String)MockObjectManager.getArgument(CreateReport.class, "createNewReportServiceBean", 0, 1),
        //            "khcommon", "カテゴリID");
        //        exStringEquals((String)MockObjectManager.getArgument(CreateReport.class, "createNewReportServiceBean", 0, 2),
        //            "editjimurenrakusyuunou", "機能ID");
        //        C_SyoruiCdKbn[] syoruiCdKbns = (C_SyoruiCdKbn[])MockObjectManager.getArgument(CreateReport.class,
        //            "createNewReportServiceBean", 0, 3);
        //        exClassificationEquals(syoruiCdKbns[0], C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU, "書類コード区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        baseUserInfo.getUser().setUserId("JUnit");
        baseUserInfo.getUser().setUserNm("Test");
        kinouInfo.setKinouId("editjimurenrakusyuunou");
        kinouInfo.setKinouNm("事務連絡票(収納)編集");
        kinouInfo.setCategoryId("khcommon");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);


        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam =
            SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
        List<String> jimuMsgLst = Lists.newArrayList();
        jimuMsgLst.add("メッセージ０１");
        editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuMsgLst);

        ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(khozenCommonParam, syono2,
            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU, editJimuRenrakusyuunouParam, syoriYmd2);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono2, "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), syoriYmd2, "処理日付");
        Map<String, List<IReportDataSouceBean>> map1 = reportServicesBean.getBeanDataSouceData();
        List<IReportDataSouceBean> lst = map1.get(C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU.getValue());
        KhJimuRenrakuhyouSyuunouDetailBean bean1 = (KhJimuRenrakuhyouSyuunouDetailBean)lst.get(0);
        exStringEquals(bean1.getIrJmrnrkhyousyuunoumsg(), "メッセージ０１",
            "事務連絡票(収納)明細帳票Beanリストの要素１");
        Map<String, Object[]> map2 = reportServicesBean.getParamObjectsData();
        KhJimuRenrakuhyouSyuunouBean bean = (KhJimuRenrakuhyouSyuunouBean)map2.get(
            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU.getValue())[0];
        exStringEquals(bean.getIrSyoriymd(), "2017年11月16日", "（ＩＲ）処理年月日");
        exStringEquals(bean.getIrSyono(), syono2, "（ＩＲ）証券番号");
        exStringEquals(bean.getIrKinounm(), "事務連絡票(収納)編集", "（ＩＲ）機能名");
        exStringEquals(bean.getIrTantcd(), "JUnit", "（ＩＲ）担当者コード");
        exStringEquals(bean.getIrTantnm(), "Test", "（ＩＲ）担当者名");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        baseUserInfo.getUser().setUserId("JUnit");
        baseUserInfo.getUser().setUserNm("Test");
        kinouInfo.setKinouId("editjimurenrakusyuunou");
        kinouInfo.setKinouNm("事務連絡票(収納)編集");
        kinouInfo.setCategoryId("khcommon");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam =
            SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
        List<String> jimuMsgLst = Lists.newArrayList();
        jimuMsgLst.add("メッセージ０１");
        jimuMsgLst.add("メッセージ０２");
        jimuMsgLst.add("メッセージ０３");
        editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuMsgLst);

        ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(khozenCommonParam, syono3,
            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU, editJimuRenrakusyuunouParam, syoriYmd3);

        exStringEquals(reportServicesBean.getKensakuKeys()[0], syono3, "検索キー");
        exDateEquals(reportServicesBean.getSyoriYmd(), syoriYmd3, "処理日付");
        Map<String, List<IReportDataSouceBean>> map1 = reportServicesBean.getBeanDataSouceData();
        List<IReportDataSouceBean> lst = map1.get(C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU.getValue());
        KhJimuRenrakuhyouSyuunouDetailBean bean1 = (KhJimuRenrakuhyouSyuunouDetailBean)lst.get(0);
        KhJimuRenrakuhyouSyuunouDetailBean bean2 = (KhJimuRenrakuhyouSyuunouDetailBean)lst.get(1);
        KhJimuRenrakuhyouSyuunouDetailBean bean3 = (KhJimuRenrakuhyouSyuunouDetailBean)lst.get(2);
        exStringEquals(bean1.getIrJmrnrkhyousyuunoumsg(), "メッセージ０１",
            "事務連絡票(収納)明細帳票Beanリストの要素１");
        exStringEquals(bean2.getIrJmrnrkhyousyuunoumsg(), "メッセージ０２",
            "事務連絡票(収納)明細帳票Beanリストの要素２");
        exStringEquals(bean3.getIrJmrnrkhyousyuunoumsg(), "メッセージ０３",
            "事務連絡票(収納)明細帳票Beanリストの要素３");
        Map<String, Object[]> map2 = reportServicesBean.getParamObjectsData();
        KhJimuRenrakuhyouSyuunouBean bean = (KhJimuRenrakuhyouSyuunouBean)map2.get(
            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU.getValue())[0];
        exStringEquals(bean.getIrSyoriymd(), "2017年11月17日", "（ＩＲ）処理年月日");
        exStringEquals(bean.getIrSyono(), syono3, "（ＩＲ）証券番号");
        exStringEquals(bean.getIrKinounm(), "事務連絡票(収納)編集", "（ＩＲ）機能名");
        exStringEquals(bean.getIrTantcd(), "JUnit", "（ＩＲ）担当者コード");
        exStringEquals(bean.getIrTantnm(), "Test", "（ＩＲ）担当者名");
    }
}
