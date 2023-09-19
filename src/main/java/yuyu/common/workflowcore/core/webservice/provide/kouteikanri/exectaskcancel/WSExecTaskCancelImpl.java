package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.exectaskcancel;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
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
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.JBPM_TASKINSTANCE;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * タスク取消のWebサービスのメインクラスです。<br />
 * タスク取消処理では、指定されたアカウントIDが保有する業務キーに紐づくタスクが個人タスクの場合に、共有タスクに戻します。<br />
 * <br />
 *
 * <table border="1" cellspacing="0" cellpadding="1">
 *   <tr bgcolor="whitesmoke">
 *     <td colspan=3>
 *       入力パラメータ（{@link WSExecTaskCancelRequest}）
 *     </td>
 *   </tr>
 *   <tr bgcolor="whitesmoke">
 *     <td>No</td><td>項目名</td><td>備考</td>
 *   </tr>
 *   <tr>
 *     <td>1</td><td>業務キー</td><td>&nbsp;</td>
 *   </tr>
 *   <tr>
 *     <td>2</td><td>フローID</td><td>&nbsp;</td>
 *   </tr>
 *   <tr>
 *     <td>3</td><td>アカウントID</td><td>タスクを保有中のアカウント</td>
 *   </tr>
 *   <tr>
 *     <td>4</td><td>ロックキー</td><td>&nbsp;</td>
 *   </tr>
 *   <tr>
 *     <td>5</td><td>付加情報</td><td>&nbsp;</td>
 *   </tr>
 *   <tr>
 *     <td>6</td><td>リクエストID</td><td>&nbsp;</td>
 *   </tr>
 *   <tr bgcolor="whitesmoke">
 *     <td colspan=3>
 *       出力パラメータ（{@link WSExecTaskCancelResponse}）
 *     </td>
 *   </tr>
 *   <tr bgcolor="whitesmoke">
 *     <td>No</td><td>項目名</td><td>備考</td>
 *   </tr>
 *   <tr>
 *     <td>1</td><td>結果ステータス</td><td>正常終了:0/警告終了:1/異常終了:9</td>
 *   </tr>
 *   <tr>
 *     <td>2</td><td>詳細メッセージコード</td><td>&nbsp;</td>
 *   </tr>
 *   <tr>
 *     <td>3</td><td>詳細メッセージ</td><td>&nbsp;</td>
 *   </tr>
 * </table>
 * <br />
 * <table border="1" cellspacing="0" cellpadding="1"><tr bgcolor="whitesmoke"><td>
 * ロック要否モードについて
 * </td></tr>
 * <tr><td>
 * ロック要否モードが、「要」の場合は、ロックキーが必要。<br />
 * ロック要否モードが、「否」の場合は、ロックキーが不要。<br />
 * </td></tr></table>
 * <br />
 * ※ロック要否モードは、IwfProviderConfig.propertiesに定義されています。<br />
 * ※１ノードに１タスクが前提です。1ノードに複数のタスクを定義する場合は動作を保証できません。<br />
 */
public class WSExecTaskCancelImpl implements WSExecTaskCancel {


    private static Logger oLogger_ = LoggerFactory.getLogger(WSExecTaskCancelImpl.class);

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    public WSExecTaskCancelImpl() {
        super();
    }

    public String getServiceName() {
        return WSExecTaskCancelRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSExecTaskCancelResponse executeBizMain(WSExecTaskCancelRequest poRequest) throws Exception {

        oLogger_.debug("│主処理開始・・・");

        WSExecTaskCancelResponse oResponse = new WSExecTaskCancelResponse();

        oResponse = validate(poRequest);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sGyoumuKey = poRequest.getGyoumukey();
        String sFlowId    = poRequest.getFlowid();
        String sAccountId = poRequest.getAccountid();
        String sLockKey   = poRequest.getLockkey();
        byte[] oExtinfo     = null;
        if (poRequest.getExtinfo() != null) {
            oExtinfo = IwfBase64Urls.decodeToString(poRequest.getExtinfo()).getBytes("UTF-8");
        }

        IWorkflowContext oWfContext = WorkflowContextFactory.newInstance();

        boolean bWFProgress = false;

        try {
            oWfContext.open();
            bWFProgress = true;

            WT_GyoumuKey gyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowId, sGyoumuKey);

            String sTokenId = null;

            if(gyoumuKey != null ){
                sTokenId = gyoumuKey.getTokenId();
                oLogger_.debug("TOKENID     : " + sTokenId);
            }
            else {
                iwfCoreDomManager.clear();
                if(oWfContext.isOpen()){
                    oWfContext.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2040);

                return oResponse;
            }

            IWorkflowToken oToken = Tokens.getActiveToken(iwfCoreDomManager, oWfContext, sGyoumuKey, sFlowId);
            if(oToken == null) {
                iwfCoreDomManager.clear();
                if(oWfContext.isOpen()){
                    oWfContext.close();
                }

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2043);

                return oResponse;
            }

            if(!IwfLockUtils.isValidLockKey(oToken, sLockKey)){
                iwfCoreDomManager.clear();
                if(oWfContext.isOpen()){
                    oWfContext.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2041);
                return oResponse;
            }


            JBPM_TASKINSTANCE taskInstance = iwfCoreDomManager.getActiveTaskInstanceWithTokenId(Long.parseLong(gyoumuKey.getTokenId()));

            if(taskInstance == null || !sAccountId.equals(taskInstance.getActorId_())){

                iwfCoreDomManager.clear();
                if(oWfContext.isOpen()){
                    oWfContext.close();
                }
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2042);
                return oResponse;
            }


            taskInstance.setActorId_(null);
            taskInstance.setStart_(null);
            iwfCoreDomManager.update(taskInstance);

            StringBuilder sb = new StringBuilder();
            sb.append(C_IwfSyoriKbn.RELEASE.getContent());
            sb.append(" [");
            sb.append(sAccountId);
            sb.append("]");
            String sRirekimsg = sb.toString();

            IwfCommonLogic.createKouteiRireki(sFlowId,
                sTokenId,
                sGyoumuKey,
                oToken.getNodeId(),
                oToken.getNodeName(),
                C_IwfSyoriKbn.RELEASE,
                poRequest.getRirekiaccountid(),
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
                "",
                null,
                null,
                null,
                null,
                null,
                null,
                iwfCoreDomManager);

            IwfCommonLogic.clearGenzaiAccountid(sGyoumuKey, iwfCoreDomManager);

            bWFProgress = false;
            oWfContext.saveAndClose();

            IwfEditMessageUtil.setMsgResultOK(oResponse, "タスク取消");
        } catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            if( !bWFProgress && !oWfContext.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0005);
            } else {
                oLogger_.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "タスク取消");
            }
        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            oLogger_.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "タスク取消");

        } finally {
            if(oWfContext.isOpen()){
                oWfContext.close();
            }
        }

        return oResponse;
    }


    public WSExecTaskCancelResponse validate(WSExecTaskCancelRequest poRequest) throws Exception {
        oLogger_.debug("│バリデーションチェック処理・・・");

        WSExecTaskCancelResponse response = new WSExecTaskCancelResponse();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, poRequest.getGyoumukey(), "業務キー", 20)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, poRequest.getFlowid(), "フローＩＤ", 19)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, poRequest.getAccountid(), "アカウントＩＤ", 30)) {
            return response;
        }
        if (!IwfValidateUtil.isMaxLenChkOK(response, poRequest.getRirekiaccountid(), "履歴用アカウントID", 30)) {
            return response;
        }

        boolean bLockYouhi = IwfCoreConfig.getInstance().isLockYouhi();
        if (bLockYouhi) {
            if (StringUtils.isEmpty(poRequest.getLockkey())) {
                IwfEditMessageUtil.setMsgResultNG(response,
                    IwfMessageCd.IWF0002, "ロックキー");
            }
        }
        return response;
    }

    public WSExecTaskCancelResponse getBootErrResponse() {
        WSExecTaskCancelResponse res = new WSExecTaskCancelResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
