package yuyu.common.workflowcore.core.webservice.provide.accountkanri.createtaskauthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef.TaskDefMapKey;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfCompressUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.AM_Role;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Objects;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * タスク権限追加サービスのプロバイダークラスです。<br />
 */
public class WSCreateTaskAuthorityImpl implements WSCreateTaskAuthority {

    private static Logger oLogger_ = LoggerFactory.getLogger(WSCreateTaskAuthorityImpl.class);
    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    public WSCreateTaskAuthorityResponse validate(
        WSCreateTaskAuthorityRequest poRequest) throws Exception {

        oLogger_.debug("│バリデーションチェック処理を開始します。");

        WSCreateTaskAuthorityResponse oResponse = new WSCreateTaskAuthorityResponse();

        String sAccountId   = poRequest.getAccountid();
        if (StringUtils.isEmpty(sAccountId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "アカウントＩＤ");
            return oResponse;
        }

        if (null == poRequest.getMaplistXml()) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "タスク権限Beanリスト");
            return oResponse;
        }

        @SuppressWarnings("unchecked")
        List<Map<String, String>> oInMapList = (List<Map<String, String>>) new XStream(new DomDriver()).fromXML(IwfCompressUtils.uncompress(IwfBase64Urls.decode(poRequest.getMaplistXml())));

        for (Map<String, String> oInMap : oInMapList) {
            oResponse = inMapValidate(oInMap);
            if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
                return oResponse;
            }
        }

        return oResponse;
    }

    public String getServiceName() {
        return WSCreateTaskAuthorityRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSCreateTaskAuthorityResponse executeBizMain(
        WSCreateTaskAuthorityRequest request) throws Exception {
        String sAccountId = request.getAccountid();
        String sRequestId = request.getRequestid();

        oLogger_.debug("[RequestId=" + sRequestId +  "]主処理を開始します。");
        oLogger_.debug("アカウントID : " + sAccountId);

        WSCreateTaskAuthorityResponse response = new WSCreateTaskAuthorityResponse();

        response = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
            return response;
        }

        @SuppressWarnings("unchecked")
        List<Map<String, String>> oInMapList = (List<Map<String, String>>) new XStream(new DomDriver()).fromXML(IwfCompressUtils.uncompress(IwfBase64Urls.decode(request.getMaplistXml())));

        IWorkflowContext oWfCtx = WorkflowContextFactory.newInstance();

        try {
            oWfCtx.open();

            oLogger_.debug("[RequestId=" + sRequestId +  "]トランザクション開始");

            List<String> oAllFlowIds = getAllFlowId(oWfCtx);
            List<String> oAllRoleCds = getAllRoleCd();

            for (Map<String, String> oInMap : oInMapList) {
                String sFlowId = oInMap.get(IWSCreateTaskAuthorityIOKey.MapKey.sS_FLOWID);
                String sNodeNm = oInMap.get(IWSCreateTaskAuthorityIOKey.MapKey.sS_NODENAME);
                String sRoleCd = oInMap.get(IWSCreateTaskAuthorityIOKey.MapKey.sS_ROLECD);

                oLogger_.debug(
                    Objects.toStringHelper(this)
                    .add("フローＩＤ"     , sFlowId)
                    .add("ノード名"     , sNodeNm)
                    .add("ロールコード"   , sRoleCd)
                    .toString()
                    );

                if(!oAllFlowIds.contains(sFlowId)) {
                    iwfCoreDomManager.clear();
                    if(oWfCtx.isOpen()){
                        oWfCtx.close();
                    }

                    IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2022, sFlowId);

                    return response;
                }

                if(!oAllRoleCds.contains(sRoleCd)) {
                    iwfCoreDomManager.clear();
                    if(oWfCtx.isOpen()){
                        oWfCtx.close();
                    }

                    IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF1122, sRoleCd);

                    return response;
                }

                List<String> oTaskNames = new ArrayList<String>();
                for (Map<String, String> taskdesMap : oWfCtx.getProcessDef(sFlowId).getTaskDefs()) {

                    oLogger_.debug(
                        Objects.toStringHelper(this)
                        .add("sTASKNAME"     , taskdesMap.get(TaskDefMapKey.sTASKNAME))
                        .add("sFLOWID"       , taskdesMap.get(TaskDefMapKey.sFLOWID))
                        .add("sFLOWLOCALNAME", taskdesMap.get(TaskDefMapKey.sFLOWLOCALNAME))
                        .add("sFLOWSORTORDER", taskdesMap.get(TaskDefMapKey.sFLOWSORTORDER))
                        .add("sTASKLOCALNAME", taskdesMap.get(TaskDefMapKey.sTASKLOCALNAME))
                        .add("sTASKSORTORDER", taskdesMap.get(TaskDefMapKey.sTASKSORTORDER))
                        .toString()
                        );

                    oTaskNames.add(taskdesMap.get(TaskDefMapKey.sTASKNAME));
                }
                if(!oTaskNames.contains(sNodeNm)) {
                    iwfCoreDomManager.clear();
                    if(oWfCtx.isOpen()){
                        oWfCtx.close();
                    }

                    IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF1121, sFlowId, sNodeNm);
                    oLogger_.debug("[ReqId="+ sRequestId + "]指定されたタスク名はフローに定義されていません。");
                    return response;
                }

                if(isDoubleRecord(sRoleCd, sFlowId, sNodeNm)) {
                    iwfCoreDomManager.clear();
                    if(oWfCtx.isOpen()){
                        oWfCtx.close();
                    }

                    IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF1123, sFlowId, sNodeNm, sRoleCd);
                    oLogger_.debug("[ReqId="+ sRequestId + "]割当情報が既に存在しています。");
                    return response;
                }

                oLogger_.debug("レコードを追加します。");
                oLogger_.debug("フローＩＤ = " + sFlowId);
                oLogger_.debug("ノード名 = " + sNodeNm);
                oLogger_.debug("ロールコード = " + sRoleCd);
                insertKengenKoutei(sRoleCd, sFlowId, sNodeNm);

            }


            oLogger_.debug("[" + sRequestId +  "]データベースコミット完了");

            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }

            IwfEditMessageUtil.setMsgResultOK(response, "タスク権限追加");
        }
        catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }
            oLogger_.error("ワークフロー想定外エラーが発生しました。", wre);
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "タスク権限追加");
        }

        catch (Exception e) {

            iwfCoreDomManager.clear();
            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            oLogger_.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "タスク権限追加");
        } finally {
            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }
        }


        return response;
    }

    public WSCreateTaskAuthorityResponse getBootErrResponse() {
        WSCreateTaskAuthorityResponse res = new WSCreateTaskAuthorityResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

    public WSCreateTaskAuthorityResponse getStubResult(
        WSCreateTaskAuthorityRequest poRequest) throws Exception {
        return null;
    }

    private WSCreateTaskAuthorityResponse inMapValidate(Map<String, String> poInMap) throws Exception {
        WSCreateTaskAuthorityResponse response = new WSCreateTaskAuthorityResponse();
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, poInMap.get(IWSCreateTaskAuthorityIOKey.MapKey.sS_FLOWID), "フローＩＤ", 19)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, poInMap.get(IWSCreateTaskAuthorityIOKey.MapKey.sS_NODENAME), "ノード名", 200)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, poInMap.get(IWSCreateTaskAuthorityIOKey.MapKey.sS_ROLECD), "権限ID", 30)) {
            return response;
        }

        return response;
    }

    private List<String> getAllFlowId(IWorkflowContext poWfCtx) {
        List<String> allFlowId = new ArrayList<String>();
        for(IWorkflowProcessDef processDef : poWfCtx.getAllProcessDefs()) {
            allFlowId.add(processDef.getProcessDefName());
        }
        return allFlowId;
    }

    private List<String> getAllRoleCd() {
        List<AM_Role> roles = baseDomManager.getAllRoles();
        List<String> allRoles = new ArrayList<String>();

        for (AM_Role amRole : roles) {
            allRoles.add(amRole.getRoleCd());
        }

        return allRoles;
    }

    private void insertKengenKoutei(String psRoleCd, String psFlowId, String psNodeId) {

        WT_KengenKoutei wtKengenkoutei = new WT_KengenKoutei();

        wtKengenkoutei.setRoleCd(psRoleCd);
        wtKengenkoutei.setFlowId(psFlowId);
        wtKengenkoutei.setNodeId(psNodeId);

        iwfCoreDomManager.insert(wtKengenkoutei);
    }

    private boolean isDoubleRecord(String psRoleCd, String psFlowId, String psNodeId) {

        WT_KengenKoutei wtKengenkoutei = iwfCoreDomManager.getKengenKoutei(psRoleCd, psFlowId, psNodeId);

        if(null != wtKengenkoutei) {
            return true;
        }

        return false;
    }

}
