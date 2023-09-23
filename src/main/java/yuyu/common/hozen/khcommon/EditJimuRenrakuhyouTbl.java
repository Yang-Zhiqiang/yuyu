package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouBean;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouDetailBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 事務連絡票TBL編集
 */
public class EditJimuRenrakuhyouTbl {

    @Inject
    private CreateReport createReport;

    public EditJimuRenrakuhyouTbl() {
        super();
    }

    public ReportServicesBean editBean(C_SyoruiCdKbn pSyoruiCd,
        String pSyoNo,
        KhozenCommonParam pKhcParam,
        EditJimuRenrakuhyouParam pJimuParam,
        BizDate pSyoriYmd) {

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
            pKhcParam.getCategoryId(),
            pKhcParam.getFunctionId(),
            pSyoruiCd);

        reportServicesBean.setKensakuKeys(pSyoNo);
        reportServicesBean.setSyoriYmd(pSyoriYmd);

        String syoriYmd = DateFormatUtil.dateKANJINoEx(pSyoriYmd);
        String hznKkn = ViewReport.getHozonKknTani(pSyoruiCd);
        String tyouhyouYmd = DateFormatUtil.dateKANJINoEx(BizDate.getSysDate());

        List<String> jimuMsgLst = pJimuParam.getJimurenrakuMsgList();

        KhJimuRenrakuhyouBean khJimuRenrakuhyouBean = new KhJimuRenrakuhyouBean();
        khJimuRenrakuhyouBean.setIrSyoriymd(syoriYmd);
        khJimuRenrakuhyouBean.setIrSyono(pSyoNo);
        khJimuRenrakuhyouBean.setIrKinounm(pKhcParam.getKinouNm());
        khJimuRenrakuhyouBean.setIrTantcd(pKhcParam.getUserID());
        khJimuRenrakuhyouBean.setIrTantnm(pKhcParam.getUserNm());
        khJimuRenrakuhyouBean.setIrHozonkkn(hznKkn);
        khJimuRenrakuhyouBean.setIrTyouhyousakuseiymd(tyouhyouYmd);

        List<IReportDataSouceBean> khJimuRenrakuhyouDetailBeanLst = new ArrayList<>();

        for (String jimurenrakumsg : jimuMsgLst) {
            KhJimuRenrakuhyouDetailBean khJimuRenrakuhyouDetailBean = new KhJimuRenrakuhyouDetailBean();

            khJimuRenrakuhyouDetailBean.setIrJmrnrkhyoumsg(jimurenrakumsg);
            khJimuRenrakuhyouDetailBeanLst.add(khJimuRenrakuhyouDetailBean);
        }
        reportServicesBean.addParamObjects(khJimuRenrakuhyouDetailBeanLst, khJimuRenrakuhyouBean);

        return reportServicesBean;
    }
}
