package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.report.ViewReport;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhMisslistBean;
import yuyu.def.hozen.bean.report.KhMisslistDataSourceBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 ミスリストTBL編集
 */
public class EditKhMisslstTbl {

    @Inject
    private CreateReport createReport;

    public EditKhMisslstTbl() {
        super();
    }

    public ReportServicesBean editBean(C_SyoruiCdKbn pSyoruiCd, KhozenCommonParam pKcp,
        List<EditKhMisslstParam> pParamLst, BizDate pSyoriYmd) {

        String subSysId = IKhozenCommonConstants.SUBSYSTEMID_HOZEN;
        String categoryId = pKcp.getCategoryId();
        String kinouId = pKcp.getFunctionId();

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            subSysId, categoryId, kinouId, pSyoruiCd);

        String hozonKkn = ViewReport.getHozonKknTani(pSyoruiCd);

        if (BizUtil.isBlank(hozonKkn)) {

            hozonKkn = "無し";
        }

        KhMisslistBean khMisslistBean = new KhMisslistBean();

        String kinouNm = "";

        if (C_SyoruiCdKbn.KK_KACHECK_YOHURI_MISSLIST.eq(pSyoruiCd)) {

            kinouNm = "預振口座" + pKcp.getKinouNm();
        }
        else if (C_SyoruiCdKbn.KK_KACHECK_SHRKZ_MISSLIST.eq(pSyoruiCd)) {

            kinouNm = "定期金支払口座" + pKcp.getKinouNm();
        }
        else {

            kinouNm = pKcp.getKinouNm();
        }

        khMisslistBean.setIrSyoriymd(DateFormatUtil.dateKANJINoEx(pSyoriYmd));
        khMisslistBean.setIrKensuu(pParamLst.size());
        khMisslistBean.setIrKinounm(kinouNm);
        khMisslistBean.setIrHozonkkn(hozonKkn);
        khMisslistBean.setIrTyouhyousakuseiymd(DateFormatUtil.dateKANJINoEx(BizDate.getSysDate()));

        List<IReportDataSouceBean> khMisslistDataSourceBeanList = new ArrayList<>();

        for (EditKhMisslstParam edKkmMisslistPrm : pParamLst) {

            KhMisslistDataSourceBean khMisslistDataSourceBean = new KhMisslistDataSourceBean();

            khMisslistDataSourceBean.setIrMisslistdatano(edKkmMisslistPrm.getDataNo());
            khMisslistDataSourceBean.setIrSeqno(BizNumber.valueOf(edKkmMisslistPrm.getSeqNo()));
            khMisslistDataSourceBean.setIrSyono(edKkmMisslistPrm.getSyoNo());
            khMisslistDataSourceBean.setIrDbhanei(edKkmMisslistPrm.getDBhaneikbn());
            khMisslistDataSourceBean.setIrMisslistmsg(edKkmMisslistPrm.getMisslistMsg());

            khMisslistDataSourceBeanList.add(khMisslistDataSourceBean);
        }

        reportServicesBean.setSyoriYmd(pSyoriYmd);
        reportServicesBean.addParamObjects(khMisslistDataSourceBeanList, khMisslistBean);

        return reportServicesBean;
    }
}
