package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouSyuunouBean;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouSyuunouDetailBean;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明ユーティリティクラスのメソッド {@link KoujyoSyoumeiUtil#createKsnHkJmrnTyhyBean(KhozenCommonParam, String, String, String, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KoujyoSyoumeiUtilTest_createKsnHkJmrnTyhyBean {

    @Inject
    private KoujyoSyoumeiUtil koujyoSyoumeiUtil;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testCreateKsnHkJmrnTyhyBean_A1(){

        MockObjectManager.initialize();

        String syono = "17806000013";
        String nedo = "2018";
        String message = "計算不可理由メッセージ";
        BizDate syoriymd = BizDate.valueOf(20181201);

        ReportServicesBean reportServicesBean = koujyoSyoumeiUtil.createKsnHkJmrnTyhyBean(khozenCommonParam, syono,
            nedo, message, syoriymd);

        exStringEquals(reportServicesBean.getCategoryId(), "khcommon", "カテゴリID");
        exStringEquals(reportServicesBean.getKinouId(), "KoujyoSyoumeiUtilTest_createKsnHkJmrnTyhyBean", "機能ＩＤ");
        exDateEquals(reportServicesBean.getSyoriYmd(), BizDate.valueOf(20181201), "処理日付");

        Object[] kSBean = reportServicesBean.getParamObjectsData().get(C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU.getValue());
        KhJimuRenrakuhyouSyuunouBean khJimuRenrakuhyouBean = (KhJimuRenrakuhyouSyuunouBean)kSBean[0];
        exStringEquals(khJimuRenrakuhyouBean.getIrSyoriymd(), "2018年12月 1日", "（ＩＲ）処理年月日");
        exStringEquals(khJimuRenrakuhyouBean.getIrSyono(), "17806000013", "（ＩＲ）証券番号");
        exStringEquals(khJimuRenrakuhyouBean.getIrKinounm(), "JUnitテスト - KoujyoSyoumeiUtilTest_createKsnHkJmrnTyhyBean", "（ＩＲ）機能名");
        exStringEquals(khJimuRenrakuhyouBean.getIrTantcd(), "JUnit", "（ＩＲ）担当者コード");
        exStringEquals(khJimuRenrakuhyouBean.getIrTantnm(), "JUnit", "（ＩＲ）担当者名");

        List<IReportDataSouceBean> kSBeanLst = reportServicesBean.getBeanDataSouceData().get(
            C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU.getValue());
        exNumericEquals(kSBeanLst.size(), 6, "要素数");
        KhJimuRenrakuhyouSyuunouDetailBean khSeikyuusyoBean = (KhJimuRenrakuhyouSyuunouDetailBean) kSBeanLst.get(0);
        exStringEquals(khSeikyuusyoBean.getIrJmrnrkhyousyuunoumsg(), "控除証明額計算不能", "事務連絡票メッセージ");
        KhJimuRenrakuhyouSyuunouDetailBean khSeikyuusyoBean1 = (KhJimuRenrakuhyouSyuunouDetailBean) kSBeanLst.get(1);
        exStringEquals(khSeikyuusyoBean1.getIrJmrnrkhyousyuunoumsg(), "以下の情報を添えてＳＥ作業依頼してください。", "事務連絡票メッセージ");
        KhJimuRenrakuhyouSyuunouDetailBean khSeikyuusyoBean2 = (KhJimuRenrakuhyouSyuunouDetailBean) kSBeanLst.get(2);
        exStringEquals(khSeikyuusyoBean2.getIrJmrnrkhyousyuunoumsg(), "", "事務連絡票メッセージ");
        KhJimuRenrakuhyouSyuunouDetailBean khSeikyuusyoBean3 = (KhJimuRenrakuhyouSyuunouDetailBean) kSBeanLst.get(3);
        exStringEquals(khSeikyuusyoBean3.getIrJmrnrkhyousyuunoumsg(), "証券番号／17806000013", "事務連絡票メッセージ");
        KhJimuRenrakuhyouSyuunouDetailBean khSeikyuusyoBean4 = (KhJimuRenrakuhyouSyuunouDetailBean) kSBeanLst.get(4);
        exStringEquals(khSeikyuusyoBean4.getIrJmrnrkhyousyuunoumsg(), "証明年度／2018年", "事務連絡票メッセージ");
        KhJimuRenrakuhyouSyuunouDetailBean khSeikyuusyoBean5 = (KhJimuRenrakuhyouSyuunouDetailBean) kSBeanLst.get(5);
        exStringEquals(khSeikyuusyoBean5.getIrJmrnrkhyousyuunoumsg(), "計算不可理由／計算不可理由メッセージ", "事務連絡票メッセージ");
    }

}
