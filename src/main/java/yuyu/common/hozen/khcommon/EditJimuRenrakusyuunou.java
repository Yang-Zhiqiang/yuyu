package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouSyuunouBean;
import yuyu.def.hozen.bean.report.KhJimuRenrakuhyouSyuunouDetailBean;
import yuyu.infr.report.CreateReport;
import yuyu.infr.report.swakreport.IReportDataSouceBean;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 事務連絡票(収納)編集
 */
public class EditJimuRenrakusyuunou {

    @Inject
    private static Logger logger;

    public EditJimuRenrakusyuunou() {
        super();
    }

    public ReportServicesBean exec(KhozenCommonParam pKhcParam,
        String pSyoNo,
        C_SyoruiCdKbn pSyoruiCd,
        EditJimuRenrakusyuunouParam pJimuParam,
        BizDate pSyoriYmd) {

        logger.debug("▽ 事務連絡票(収納)編集 開始");

        KhJimuRenrakuhyouSyuunouBean khJimuRenrakuhyouSyuunouBean = new KhJimuRenrakuhyouSyuunouBean();
        List<IReportDataSouceBean> khJimuRenrakuhyouSyuunouDetailBeanLst =new ArrayList<>();
        CreateReport createReport = SWAKInjector.getInstance(CreateReport.class);

        khJimuRenrakuhyouSyuunouBean.setIrSyoriymd(DefaultDateFormatter.formatYMDKanji(pSyoriYmd));
        khJimuRenrakuhyouSyuunouBean.setIrSyono(pSyoNo);
        khJimuRenrakuhyouSyuunouBean.setIrKinounm(pKhcParam.getKinouNm());
        khJimuRenrakuhyouSyuunouBean.setIrTantcd(pKhcParam.getUserID());
        khJimuRenrakuhyouSyuunouBean.setIrTantnm(pKhcParam.getUserNm());

        List<String> jimuMsgLst = pJimuParam.getJimurenrakuMsgList();

        for (String jimuMsg : jimuMsgLst) {

            KhJimuRenrakuhyouSyuunouDetailBean khJimuRenrakuhyouSyuunouDetailBean = new KhJimuRenrakuhyouSyuunouDetailBean();

            khJimuRenrakuhyouSyuunouDetailBean.setIrJmrnrkhyousyuunoumsg(jimuMsg);

            khJimuRenrakuhyouSyuunouDetailBeanLst.add(khJimuRenrakuhyouSyuunouDetailBean);
        }

        ReportServicesBean reportServicesBean = createReport.createNewReportServiceBean(
            IKhozenCommonConstants.SUBSYSTEMID_HOZEN,
            pKhcParam.getCategoryId(),
            pKhcParam.getFunctionId(),
            pSyoruiCd);

        reportServicesBean.setKensakuKeys(pSyoNo);
        reportServicesBean.setSyoriYmd(pSyoriYmd);

        reportServicesBean.addParamObjects(khJimuRenrakuhyouSyuunouDetailBeanLst, khJimuRenrakuhyouSyuunouBean);

        logger.debug("△ 事務連絡票(収納)編集 終了");

        return reportServicesBean;
    }
}
