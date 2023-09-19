package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.createtasksummary;


import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;

import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.common.exdao.CreateTaskSummaryBean;
import yuyu.common.workflowcore.core.webservice.provide.common.exdao.CreateTaskSummaryDao;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_TaskSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 件数サマリ作成のWebサービスのメインクラスです。<br />
 */
public class WSCreateTaskSummaryImpl  implements WSCreateTaskSummary {

    final static Logger LOGGER = LoggerFactory.getLogger(WSCreateTaskSummary.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private CreateTaskSummaryDao createTaskSummaryDao;

    public WSCreateTaskSummaryImpl() {
        super();
    }

    @Override
    @Transactional
    public WSCreateTaskSummaryResponse executeBizMain(WSCreateTaskSummaryRequest poRequest) throws Exception {

        WSCreateTaskSummaryResponse oWSResponse = new WSCreateTaskSummaryResponse();

        String[] sFlowids = poRequest.getSFlowids();

        boolean hasSpecifiedFlow = (null == sFlowids || 0 == sFlowids.length) ? false : true;

        try {
            if (!hasSpecifiedFlow) {
                iwfCoreDomManager.deleteAllTaskSummary();
            } else {
                iwfCoreDomManager.deleteTaskSummaryWithFlowIds(sFlowids);
            }

            try (ExDBResults<CreateTaskSummaryBean> taskIns = createTaskSummaryDao.getTaskInstances(sFlowids);
                EntityInserter<WT_TaskSummary> inserter = new EntityInserter<>()) {

                int insert_taskSummary_Cnt = 0;

                for(CreateTaskSummaryBean taskBean : taskIns){
                    WT_TaskSummary taskSummary = new WT_TaskSummary();
                    taskSummary.setIwfTskId(taskBean.getTaskName_());
                    taskSummary.setIwfTskNm(taskBean.getTaskDescription_());
                    taskSummary.setTaskCreateTime(taskBean.getCreate_());
                    taskSummary.setTaskStartTime(taskBean.getStart_());
                    taskSummary.setTaskEndTime(taskBean.getEnd_());
                    taskSummary.setTokenId(String.valueOf(taskBean.getToken_()));
                    taskSummary.setActorId(taskBean.getActorId_());
                    taskSummary.setFlowId(taskBean.getProcessName_());
                    taskSummary.setFlowName(taskBean.getProcessDescription_());
                    inserter.add(taskSummary);
                    insert_taskSummary_Cnt++;
                }

                if (0 == insert_taskSummary_Cnt) {
                    IwfEditMessageUtil.setMsgResultWARN(oWSResponse, IwfMessageCd.IWF4010);
                    return oWSResponse;
                }
                IwfEditMessageUtil.setMsgResultOK(oWSResponse, "件数サマリ作成");
                LOGGER.debug("件数サマリ作成件数：　" + insert_taskSummary_Cnt + "件");
            }
        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "件数サマリ作成");
        }
        return oWSResponse;
    }

    public WSCreateTaskSummaryResponse getBootErrResponse() {
        WSCreateTaskSummaryResponse res = new WSCreateTaskSummaryResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}