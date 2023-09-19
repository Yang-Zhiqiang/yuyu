package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskstart;

import static java.lang.Long.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef.TaskDefMapKey;
import yuyu.common.workflowcore.api.api.IWorkflowTask;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfLockUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * タスク開始のWebサービスのメインクラスです。
 */
public class WSExecTaskStartImpl implements WSExecTaskStart {

    private static Logger oLogger_ = LoggerFactory.getLogger(WSExecTaskStartImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public WSExecTaskStartImpl() {
        super();
    }

    @Override
    @Transactional
    public WSExecTaskStartResponse executeBizMain(WSExecTaskStartRequest request) throws Exception {

        oLogger_.debug("│主処理開始・・・");

        WSExecTaskStartResponse response = new WSExecTaskStartResponse();

        response = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
            return response;
        }

        String sGyoumuKey = request.getGyoumukey();
        String sFlowId = request.getFlowid();
        String sAccountId = request.getAccountid();
        String sLockKey = request.getLockkey();
        String sTaskname = request.getTaskname();
        byte[] oExtinfo     = null;
        if (request.getExtinfo() != null) {
            oExtinfo = IwfBase64Urls.decodeToString(request.getExtinfo()).getBytes("UTF-8");
        }
        String sRequestId = request.getRequestid();

        IWorkflowContext wfContext = WorkflowContextFactory.newInstance();

        boolean bWFProgress = false;

        try {

            wfContext.open();
            bWFProgress = true;

            oLogger_.debug("[ReqId="+ sRequestId + "]業務キーテーブルから取得します。");
            oLogger_.debug("[ReqId="+ sRequestId + "]取得条件:");
            oLogger_.debug("[ReqId="+ sRequestId + "][" + WT_GyoumuKey.FLOWID + "=" + sFlowId + "]");
            oLogger_.debug("[ReqId="+ sRequestId + "][" + WT_GyoumuKey.GYOUMUKEY + "=" + sGyoumuKey + "]");

            WT_GyoumuKey gyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowId, sGyoumuKey);

            String sTokenId = null;

            if(gyoumuKey != null){
                sTokenId = gyoumuKey.getTokenId();
                oLogger_.debug("[ReqId="+ sRequestId + "]TOKENID     : " + sTokenId);
            }
            else {
                oLogger_.debug("[ReqId="+ sRequestId + "]業務キーテーブルからの取得に失敗しました");
                iwfCoreDomManager.clear();
                if(wfContext.isOpen()){
                    wfContext.close();
                }
                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2010);

                return response;
            }

            oLogger_.debug("[ReqId="+ sRequestId + "]トークンを取得します。");
            oLogger_.debug("[ReqId="+ sRequestId + "]取得条件:");
            oLogger_.debug("[ReqId="+ sRequestId + "][FLOWID="+ sFlowId + "]");
            oLogger_.debug("[ReqId="+ sRequestId + "][TOKENID=" + sTokenId + "]");
            IWorkflowToken token = wfContext.getProcessDef(sFlowId).getToken(sTokenId);

            if(token == null) {
                iwfCoreDomManager.clear();

                if(wfContext.isOpen()){
                    wfContext.close();
                }
                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "タスク開始");
                oLogger_.debug("[ReqId="+ sRequestId + "]異常終了しました。");
                return response;
            }
            String sNodeName = token.getNodeName();
            if(!IwfLockUtils.isValidLockKey(token, sLockKey)){
                iwfCoreDomManager.clear();
                if(wfContext.isOpen()){
                    wfContext.close();
                }
                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2011);
                oLogger_.debug("[ReqId="+ sRequestId + "]ロックキーが無効です。他の作業者がロック中、またはロックが既に解除されています。");
                return response;
            }
            if(IwfCommonLogic.isNotExistKengen(iwfCoreDomManager, response, sFlowId, sAccountId, sNodeName)){
                iwfCoreDomManager.clear();
                if(wfContext.isOpen()){
                    wfContext.close();
                }
                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2014);
                oLogger_.debug("[ReqId="+ sRequestId + "]タスクの実行権限がありません。");
                return response;
            }
            List<String> taskNames = new ArrayList<String>();
            for (Map<String, String> taskdesMap : wfContext.getProcessDef(sFlowId).getTaskDefs()) {
                taskNames.add(taskdesMap.get(TaskDefMapKey.sTASKNAME));
            }

            if(!taskNames.contains(sTaskname)) {
                iwfCoreDomManager.clear();
                if(wfContext.isOpen()){
                    wfContext.close();
                }

                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2015);
                oLogger_.debug("[ReqId="+ sRequestId + "]指定されたタスク名はフローに定義されていません。");
                return response;
            }

            List<IWorkflowTask> iTasks = token.getTasks();
            if(iTasks.size() == 0) {
                oLogger_.debug("[ReqId="+ sRequestId + "]ワークフローコンテキスト、データベースコンテキストをクローズします。");

                iwfCoreDomManager.clear();
                if(wfContext.isOpen()){
                    wfContext.close();
                }

                IwfEditMessageUtil.setMsgResultWARN(response, IwfMessageCd.IWF2013);
                oLogger_.debug("[ReqId=" + sRequestId + "]タスクが存在しません。");

                return response;
            }

            Iterator<IWorkflowTask> itrTask = iTasks.iterator();
            IWorkflowTask oTask = itrTask.next();

            if(!oTask.getTaskNodeName().equals(sTaskname)) {
                iwfCoreDomManager.clear();
                if(wfContext.isOpen()){
                    wfContext.close();
                }

                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2016);
                oLogger_.debug("[ReqId="+ sRequestId + "]指定されたタスクはトークンに存在しません。");

                return response;
            }

            if(oTask.getUserId() != null){
                iwfCoreDomManager.clear();
                if(wfContext.isOpen()){
                    wfContext.close();
                }

                IwfEditMessageUtil.setMsgResultWARN(response, IwfMessageCd.IWF2012);
                oLogger_.debug("[ReqId=" + sRequestId + "]既に担当者が割り当てられています。");

                return response;
            }


            oTask.start(sAccountId);
            oLogger_.debug("[ReqId="+ sRequestId + "]アカウントＩＤを担当者に割り当てます。");
            oLogger_.debug("[ReqId="+ sRequestId + "]設定内容:");
            oLogger_.debug("[ReqId="+ sRequestId + "][ACCOUNTID="+ sAccountId + "]");

            oLogger_.debug("[ReqId="+ sRequestId + "]工程履歴テーブルに登録します。");
            oLogger_.debug("[ReqId="+ sRequestId + "]登録内容:");
            oLogger_.debug("[ReqId="+ sRequestId + "]["+ WT_KouteiRireki.TOKENID + "="   + sTokenId   + "]");
            oLogger_.debug("[ReqId="+ sRequestId + "]["+ WT_KouteiRireki.FLOWID + "="    + sFlowId    + "]");
            oLogger_.debug("[ReqId="+ sRequestId + "]["+ WT_KouteiRireki.GYOUMUKEY + "=" + sGyoumuKey + "]");
            oLogger_.debug("[ReqId="+ sRequestId + "]["+ WT_KouteiRireki.NODENM + "="    + sNodeName    + "]");
            oLogger_.debug("[ReqId="+ sRequestId + "]["+ WT_KouteiRireki.NODENM + "="    + token.getNodeName()    + "]");
            oLogger_.debug("[ReqId="+ sRequestId + "]["+ WT_KouteiRireki.USERID + "=" + sAccountId + "]");
            oLogger_.debug("[ReqId="+ sRequestId + "]["+ WT_KouteiRireki.IWFSYORIKBN + "="  + parseLong(C_IwfSyoriKbn.ASSIGN.getValue())  + "]");
            oLogger_.debug("[ReqId="+ sRequestId + "]["+ WT_KouteiRireki.RRKMSG + "=" + C_IwfSyoriKbn.ASSIGN.getContent() + "]");

            StringBuilder sb = new StringBuilder();
            sb.append(C_IwfSyoriKbn.ASSIGN.getContent());
            sb.append(" [");
            sb.append(sAccountId);
            sb.append("]");
            String sRirekimsg = sb.toString();

            IwfCommonLogic.createKouteiRireki(sFlowId,
                sTokenId,
                sGyoumuKey,
                token.getNodeId(),
                token.getNodeName(),
                C_IwfSyoriKbn.ASSIGN,
                sAccountId,
                C_RirekiKbn.SYSTEM,
                sRirekimsg,
                oExtinfo,
                iwfCoreDomManager);

            IwfCommonLogic.updateKouteiSummary(sGyoumuKey,
                null,
                null,
                null,
                null,
                null,
                sAccountId,
                null,
                null,
                null,
                null,
                null,
                null,
                iwfCoreDomManager);

            oLogger_.debug("[ReqId="+ sRequestId + "]コンテキストをクローズします。");

            bWFProgress = false;
            wfContext.saveAndClose();

            IwfEditMessageUtil.setMsgResultOK(response, "タスク開始");

        } catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            if( !bWFProgress && !wfContext.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0005);
            } else {
                if(wfContext.isOpen()){
                    wfContext.close();
                }
                oLogger_.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "タスク開始");
            }
        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(wfContext.isOpen()){
                wfContext.close();
            }

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            oLogger_.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "タスク開始");
        } finally {
            if(wfContext.isOpen()){
                wfContext.close();
            }
        }
        return response;
    }

    public WSExecTaskStartResponse validate(WSExecTaskStartRequest request) throws Exception {
        oLogger_.debug("│バリデーションチェック処理・・・");

        WSExecTaskStartResponse response = new WSExecTaskStartResponse();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, request.getGyoumukey(), "業務キー", 20)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, request.getFlowid(), "フローＩＤ", 19)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, request.getTaskname(), "タスク名", 25)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, request.getAccountid(), "アカウントＩＤ", 30)) {
            return response;
        }
        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        if (bLockYouhi) {
            if (StringUtils.isEmpty(request.getLockkey())) {
                IwfEditMessageUtil.setMsgResultNG(response,
                    IwfMessageCd.IWF0002, "ロックキー");
            }
        }
        return response;

    }

    public String getServiceName() {
        return WSExecTaskStartRequest.sSERVICE_NAME;
    }

    public WSExecTaskStartResponse getBootErrResponse() {
        WSExecTaskStartResponse res = new WSExecTaskStartResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}
