package yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.configuration.SwakDbConfig;

import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.execprocessupdateforbatch.WSExecProcessUpdateForBatchImpl;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

public class WSDeleteProcessAndJBPMRecordImpl implements WSDeleteProcessAndJBPMRecord {

    private final static Logger LOGGER = LoggerFactory.getLogger(WSExecProcessUpdateForBatchImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public WSDeleteProcessAndJBPMRecordImpl() {
        super();
    }

    public String getServiceName() {
        return WSDeleteProcessAndJBPMRecordRequest.sSERVICE_NAME;
    }

    public WSDeleteProcessAndJBPMRecordResponse validate(WSDeleteProcessAndJBPMRecordRequest request) {
        WSDeleteProcessAndJBPMRecordResponse response = new WSDeleteProcessAndJBPMRecordResponse();

        for (DeleteProcessAndJBPMRecordBean deleteBean : request.getDeleteProcessAndJBPMRecordBeanList()) {

            if (!(IwfValidateUtil.isRequiredAndMaxLenChkOK(response, deleteBean.getFlowid(), "フローID", 19))) {
                return response;
            }

            if (!(IwfValidateUtil.isRequiredAndMaxLenChkOK(response, deleteBean.getGyoumukey(), "業務キー", 20))) {
                return response;
            }
        }

        return response;
    }

    @Override
    @Transactional
    public WSDeleteProcessAndJBPMRecordResponse executeBizMain(WSDeleteProcessAndJBPMRecordRequest request) throws Exception {
        WSDeleteProcessAndJBPMRecordResponse response = new WSDeleteProcessAndJBPMRecordResponse();

        response = validate(request);
        if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
            return response;
        }

        deleteRecords(request.getDeleteProcessAndJBPMRecordBeanList());

        IwfEditMessageUtil.setMsgResultOK(response, "工程履歴・JBPMデータ削除");

        return response;
    }

    private void deleteRecords(List<DeleteProcessAndJBPMRecordBean> beanList) {
        IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();
        oWfContext.setConnection(SWAKInjector.getInstance(ExDBEntityManager.class).getJDBCConnection());
        oWfContext.open();

        final int flushCount = SwakDbConfig.getInstance().getUpdateBatchSize();
        int deleteCountJBPM = 0;
        boolean deleteFlag = false;
        int deleteCountKouteiRireki = 0;
        try (EntityDeleter<WT_KouteiRireki> kouteirirekiDeleter = new EntityDeleter<> ();) {
            for (DeleteProcessAndJBPMRecordBean bean : beanList) {
                IWorkflowToken token = Tokens.getToken(iwfCoreDomManager, oWfContext, bean.getGyoumukey(), bean.getFlowid());
                if (token != null) {
                    oWfContext.deleteProcessInstance(token.getProcessInstanceId());
                    deleteFlag = true;
                    deleteCountJBPM++;
                } else {
                    LOGGER.warn("データが存在しませんでした。[業務キー=" + bean.getGyoumukey() + ", フローID="+ bean.getFlowid() + "]");
                }

                List<WT_KouteiRireki> kouteiRirekis =
                    iwfCoreDomManager.getKouteiRirekis(bean.getGyoumukey(), bean.getFlowid(), C_RirekiKbn.SYSTEM);

                for (WT_KouteiRireki entity : kouteiRirekis) {
                    kouteirirekiDeleter.add(entity);
                    deleteCountKouteiRireki++;
                }

                if (deleteCountKouteiRireki >= flushCount) {
                    oWfContext.flushAndClear();
                    deleteCountKouteiRireki = 0;
                    deleteFlag = false;
                    LOGGER.debug(deleteCountJBPM + "件目でflushを実行しました。");
                }
            }
        }

        if (deleteFlag) {
            oWfContext.flushAndClear();
        }

        LOGGER.info("削除件数：" + beanList.size() + "件中" + deleteCountJBPM + "件");

        oWfContext.close();
    }
}
