package yuyu.common.biz.prereport;

import yuyu.common.workflowcore.core.webservice.provide.imagekanri.gettorikomisyoruimst.WSGetTorikomiSyoruiMstResponse.TorikomiSyoruiBean;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 帳票作成前工程操作処理クラスです。
 */
public abstract class PreReportOperateProcess {
    public abstract String operateProcess(TorikomiSyoruiBean torikomiSyoruiMstBean, BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfoBean, ReportServicesBean rsBean);
}
