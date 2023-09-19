package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekiandsummarybyuser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.biz.workflow.io.koutei.sub.ProcessRecordAndSummaryByUserBean;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

public class WSGetKouteiRirekiAndSummaryByUserImpl implements WSGetKouteiRirekiAndSummaryByUser {

    final static Logger LOGGER = LoggerFactory.getLogger(WSGetKouteiRirekiAndSummaryByUserImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public WSGetKouteiRirekiAndSummaryByUserImpl() {
        super();
    }

    public String getServiceName() {
        return WSGetKouteiRirekiAndSummaryByUserRequest.sSERVICE_NAME;
    }

    public WSGetKouteiRirekiAndSummaryByUserResponse validate(WSGetKouteiRirekiAndSummaryByUserRequest request) {
        WSGetKouteiRirekiAndSummaryByUserResponse response = new WSGetKouteiRirekiAndSummaryByUserResponse();

        if ((request.getListFlowId() == null) || (request.getListFlowId().size() == 0)) {
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0002, "フローID");
            return response;
        }
        for (String flowId : request.getListFlowId()) {
            if (!(IwfValidateUtil.isRequiredAndMaxLenChkOK(response, flowId, "フローID", 19))) {
                return response;
            }
        }

        if (!(IwfValidateUtil.isRequiredAndMaxLenChkOK(response, request.getUserId(), "ユーザーID", 30))) {
            return response;
        }

        if (!(IwfValidateUtil.isRequiredAndMaxLenChkOK(response, request.getSyoriTimeFrom(), "処理日時（自）", 17))) {
            return response;
        }

        if (!(IwfValidateUtil.isRequiredAndMaxLenChkOK(response, request.getSyoriTimeTo(), "処理日時（至）", 17))) {
            return response;
        }

        return response;
    }

    @Override
    @SuppressWarnings("unchecked")
    public WSGetKouteiRirekiAndSummaryByUserResponse executeBizMain(WSGetKouteiRirekiAndSummaryByUserRequest request) throws Exception {
        WSGetKouteiRirekiAndSummaryByUserResponse response = new WSGetKouteiRirekiAndSummaryByUserResponse();

        response = validate(request);
        if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
            return response;
        }

        List<ProcessRecordAndSummaryByUserBean> listProcessRecordAndSummaryByUserBean = getKouteiRirekiAndSummaryByUser(request);
        response.setKouteiRirekiAndSummary(listProcessRecordAndSummaryByUserBean);

        IwfEditMessageUtil.setMsgResultOK(response, "ユーザ別工程履歴取得");

        return response;
    }

    private List<ProcessRecordAndSummaryByUserBean> getKouteiRirekiAndSummaryByUser(WSGetKouteiRirekiAndSummaryByUserRequest request) {
        List<ProcessRecordAndSummaryByUserBean> listProcessRecordAndSummaryByUserBean = new ArrayList<>();
        List<WT_KouteiRireki> listKouteiRireki = iwfCoreDomManager.getKouteiRirekis(request.getUserId(),
            request.getListFlowId(), C_RirekiKbn.GYOUMU, request.getSyoriTimeFrom(), request.getSyoriTimeTo());

        for (WT_KouteiRireki kouteiRireki : listKouteiRireki) {
            ProcessRecordAndSummaryByUserBean bean = new ProcessRecordAndSummaryByUserBean();
            WT_KouteiSummary kouteiSummary = iwfCoreDomManager.getKouteiSummary(kouteiRireki.getGyoumuKey());
            kouteiRireki.detach();
            kouteiSummary.detach();
            bean.setKouteiRireki(kouteiRireki);
            bean.setKouteiSummary(kouteiSummary);
            listProcessRecordAndSummaryByUserBean.add(bean);
        }

        return listProcessRecordAndSummaryByUserBean;
    }

}
