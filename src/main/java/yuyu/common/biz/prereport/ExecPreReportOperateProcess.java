package yuyu.common.biz.prereport;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.workflow.workflowutility.GetTorikomiSyoruiMstBySyoruiCdResultBean;
import yuyu.common.workflow.workflowutility.WorkFlowUtility;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KouteiSakuseiKeikiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 帳票作成前工程操作呼出し処理クラスです。
 */
public class ExecPreReportOperateProcess {

    public static String execPreReportOperateProcess(String syoruiCd, ReportServicesBean rsBean) {
        String wkKouteiKnrId = null;

        GetTorikomiSyoruiMstBySyoruiCdResultBean torikomiSyoruiBean = WorkFlowUtility.getTorikomiSyoruiMstBySyoruiCd(syoruiCd);

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo =  bizDomManager.getTorikomiSyoruiHukaInfo(C_SyoruiCdKbn.valueOf(syoruiCd));

        if (torikomiSyoruiHukaInfo == null || !C_KouteiSakuseiKeikiKbn.SYORUI_SAKUSEIJI.eq(torikomiSyoruiHukaInfo.getKouteisakuseikeiki())) {
            return null;
        }

        PreReportOperateProcessFactory preReportOperateProcessFactory = new PreReportOperateProcessFactory();
        PreReportOperateProcess preReportOperateProcess = preReportOperateProcessFactory.getOperator(torikomiSyoruiHukaInfo.getSubSystemId());

        if (preReportOperateProcess == null) {
            return null;
        }

        wkKouteiKnrId = preReportOperateProcess.operateProcess(torikomiSyoruiBean.getTorikomiSyoruiBeanList().get(0), torikomiSyoruiHukaInfo, rsBean);

        return wkKouteiKnrId;
    }
}