package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.ikkatuprocesscreate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.hibernate.HibernateException;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfCompressUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.common.workflowcore.iwfcommon.check.Checks;
import yuyu.common.workflowcore.iwfcommon.check.impl.CanCreateNewTokenCheckerInBean;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ProcessStatusKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * 一括工程開始のWebサービスのメインクラスです。
 */
public class WSIkkatuProcessCreateImpl implements WSIkkatuProcessCreate {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;
    final static Logger LOGGER = LoggerFactory.getLogger(WSIkkatuProcessCreateImpl.class);
    public WSIkkatuProcessCreateImpl() {
        super();
    }

    @Override
    @Transactional
    public WSIkkatuProcessCreateResponse executeBizMain(WSIkkatuProcessCreateRequest request) throws Exception {
        String sRequestId = request.getRequestid();

        LOGGER.debug("[" + sRequestId +  "]主処理を開始します。");

        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(request);

        WSIkkatuProcessCreateResponse response = new WSIkkatuProcessCreateResponse();

        response = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
            return response;
        }

        List<Map<String, String>> oInMapList = (List<Map<String, String>>) new XStream(new DomDriver()).fromXML(IwfCompressUtils.uncompress(IwfBase64Urls.decode(request.getMaplistXml())));

        IWorkflowContext oWfCtx = WorkflowContextFactory.newInstance();

        boolean bWfCtxMustClose = false;

        try {
            long startTime = new Date().getTime();

            oWfCtx.open();
            bWfCtxMustClose = true;

            int createNm = 1;

            List<String> oAllFlowIds = getAllFlowId(oWfCtx);

            for (Map<String, String> oInMap : oInMapList) {

                String sGyoumuKey = oInMap.get(IWSIkkatuProcessCreateIOKey.MapKey.sS_GYOUMUKEY);
                String sFlowId = oInMap.get(IWSIkkatuProcessCreateIOKey.MapKey.sS_FLOWID);
                String sAccountId = oInMap.get(IWSIkkatuProcessCreateIOKey.MapKey.sS_ACCOUNTID);
                String sProcessGroup = oInMap.get(IWSIkkatuProcessCreateIOKey.MapKey.sS_PROCESSGROUP);
                byte[] oExtinfo = oInMap.get(IWSIkkatuProcessCreateIOKey.MapKey.sS_EXTINFO).getBytes("UTF-8");

                LOGGER.debug(createNm + "件目の工程開始処理を開始します。");
                LOGGER.debug("業務キー = " + sGyoumuKey);
                LOGGER.debug("フローＩＤ = " + sFlowId);
                LOGGER.debug("アカウントＩＤ = " + sAccountId);
                LOGGER.debug("プロセスグループ = " + sProcessGroup);

                if(!oAllFlowIds.contains(sFlowId)) {
                    iwfCoreDomManager.clear();
                    if(oWfCtx.isOpen()){
                        oWfCtx.close();
                    }

                    IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2233, sFlowId);

                    return response;
                }

                if(!canCreateNewToken(sGyoumuKey, sFlowId, sRequestId, oWfCtx)){
                    iwfCoreDomManager.clear();
                    if(oWfCtx.isOpen()){
                        oWfCtx.close();
                    }

                    IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2231, sGyoumuKey, sFlowId);
                    return response;
                }

                IWorkflowToken token = Tokens.createNewToken(sFlowId, oWfCtx);

                if(token == null) {
                    LOGGER.debug("[" + sRequestId +  "]トークンの作成に失敗しました。");
                    iwfCoreDomManager.clear();
                    if(oWfCtx.isOpen()){
                        oWfCtx.close();
                    }

                    IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF2050);
                    return response;
                }

                token.next();

                String sTokenId = token.getId();

                IwfCommonLogic.modifyGyoumukeyTokenRelation(sGyoumuKey, sFlowId, sTokenId, iwfCoreDomManager, sRequestId);

                token.setStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key, IwfDateUtils.getYYYYMMDD());
                token.setStringVariable(E_TokenVarKey.SYORI_STATUS.key,      C_ProcessStatusKbn.PROCESSING.getValue());

                IwfCommonLogic.createKouteiRireki(sFlowId,
                    sTokenId,
                    sGyoumuKey,
                    token.getNodeId(),
                    token.getNodeName(),
                    C_IwfSyoriKbn.PROCESSSTART,
                    sAccountId,
                    C_RirekiKbn.SYSTEM,
                    oExtinfo,
                    iwfCoreDomManager);

                IwfCommonLogic.createKouteiRireki(sFlowId,
                    sTokenId,
                    sGyoumuKey,
                    token.getNodeId(),
                    token.getNodeName(),
                    C_IwfSyoriKbn.PROCESSSTART,
                    sAccountId,
                    C_RirekiKbn.GYOUMU,
                    "工程を開始しました。",
                    oExtinfo,
                    iwfCoreDomManager);

                LOGGER.debug("[" + sRequestId +  "]工程履歴を登録しました。");

                String taskNodeLocalName = null;
                if ( token.getTasks() != null &&  token.getTasks().size() > 0) {
                    taskNodeLocalName = oWfCtx.getProcessDef(sFlowId).getTasknodeLocalName(token.getNodeName());
                }

                if (IwfCommonLogic.selKouteiSummry(sGyoumuKey, iwfCoreDomManager) == null) {
                    IwfCommonLogic.createKouteiSummary(
                        sGyoumuKey,
                        sFlowId,
                        sAccountId,
                        sAccountId,
                        token.getNodeName(),
                        taskNodeLocalName,
                        null,
                        token.getNodeName(),
                        taskNodeLocalName,
                        token.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key),
                        null,
                        token.getStringVariable(E_TokenVarKey.SYORI_STATUS.key),
                        extParamMap,
                        iwfCoreDomManager);
                }
                else {
                    IwfCommonLogic.updateKouteiSummary(
                        sGyoumuKey,
                        sFlowId,
                        sAccountId,
                        sAccountId,
                        token.getNodeName(),
                        taskNodeLocalName,
                        null,
                        token.getNodeName(),
                        taskNodeLocalName,
                        token.getStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key),
                        null,
                        token.getStringVariable(E_TokenVarKey.SYORI_STATUS.key),
                        extParamMap,
                        iwfCoreDomManager);
                }
                LOGGER.debug("[" + sRequestId +  "]工程サマリを登録しました。");

                if((createNm % 100) == 0) {
                    LOGGER.debug(createNm +  "件の処理を終了しました。経過時間 ：  " + (new Date().getTime() - startTime) / 1000 + "秒");
                }

                createNm ++ ;

            }

            LOGGER.debug("[" + sRequestId +  "]データベースコミット完了");

            bWfCtxMustClose = false;
            oWfCtx.saveAndClose();

            IwfEditMessageUtil.setMsgResultOK(response, "一括工程開始");

            LOGGER.debug(createNm - 1 + "件の工程開始処理を完了しました。");
            long endTime = new Date().getTime();

            long diffSecond = (endTime - startTime) / 1000;
            LOGGER.debug("実行時間 ： " + diffSecond + "秒");

        } catch (HibernateException he) {

            LOGGER.error("データベース例外エラーが発生しました。",he);

            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }

            iwfCoreDomManager.clear();
        } catch (WorkflowRuntimeException wre) {

            iwfCoreDomManager.clear();

            if( !bWfCtxMustClose && !oWfCtx.isOpen()){

                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0005);
            } else {
                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }
                LOGGER.error("ワークフロー想定外エラーが発生しました。", wre);
                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "工程開始");
            }
        } catch (Exception e) {

            iwfCoreDomManager.clear();
            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }
            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "工程開始");
        }

        return response;
    }

    public WSIkkatuProcessCreateResponse validate(WSIkkatuProcessCreateRequest request) throws Exception {

        LOGGER.debug("│バリデーションチェック処理・・・");

        WSIkkatuProcessCreateResponse response = new WSIkkatuProcessCreateResponse();

        List<Map<String, String>> oInMapList = (List<Map<String, String>>) new XStream(new DomDriver()).fromXML(IwfCompressUtils.uncompress(IwfBase64Urls.decode(request.getMaplistXml())));

        for (Map<String, String> oInMap : oInMapList) {
            response = inMapValidate(oInMap);
            if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
                return response;
            }
        }

        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(request);

        if (!IwfValidateUtil.isExtParamsChkOk(response, extParamMap, 50)) {
            return response;
        }

        return response;

    }

    public String getServiceName() {
        return WSIkkatuProcessCreateRequest.sSERVICE_NAME;
    }

    public WSIkkatuProcessCreateResponse getStubResult(WSIkkatuProcessCreateRequest request) throws Exception {

        return null;
    }

    public WSIkkatuProcessCreateResponse getBootErrResponse() {
        WSIkkatuProcessCreateResponse res = new WSIkkatuProcessCreateResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }


    private WSIkkatuProcessCreateResponse inMapValidate(Map<String, String> poInMap) throws Exception {
        WSIkkatuProcessCreateResponse response = new WSIkkatuProcessCreateResponse();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, poInMap.get(IWSIkkatuProcessCreateIOKey.MapKey.sS_GYOUMUKEY), "業務キー", 20)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, poInMap.get(IWSIkkatuProcessCreateIOKey.MapKey.sS_FLOWID), "フローＩＤ", 19)) {
            return response;
        }
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(response, poInMap.get(IWSIkkatuProcessCreateIOKey.MapKey.sS_ACCOUNTID), "アカウントＩＤ", 30)) {
            return response;
        }

        return response;
    }

    private boolean canCreateNewToken(String psGyoumuKey, String psFlowId, String psRequestId, IWorkflowContext poWfCtx) {
        CanCreateNewTokenCheckerInBean inBean = new CanCreateNewTokenCheckerInBean(
            iwfCoreDomManager,
            poWfCtx,
            psGyoumuKey,
            psFlowId,
            psRequestId
            );

        return Checks.checkCanCreateNewToken(inBean);
    }

    private List<String> getAllFlowId(IWorkflowContext poWfCtx) {
        List<String> allFlowId = new ArrayList<String>();
        for(IWorkflowProcessDef processDef : poWfCtx.getAllProcessDefs()) {
            allFlowId.add(processDef.getProcessDefName());
        }
        return allFlowId;
    }

}
