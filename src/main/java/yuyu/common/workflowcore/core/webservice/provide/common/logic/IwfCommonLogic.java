package yuyu.common.workflowcore.core.webservice.provide.common.logic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.WorkflowAuthInfo;
import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.IWorkflowProcessDef;
import yuyu.common.workflowcore.api.api.IWorkflowToken;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.enumerate.E_TokenVarKey;
import yuyu.common.workflowcore.core.webservice.common.WSCommonIOKey;
import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.iwfcommon.check.Checks;
import yuyu.common.workflowcore.iwfcommon.check.impl.CanCreateNewTokenCheckerInBean;
import yuyu.common.workflowcore.iwfcommon.pga.CommonMethodResult;
import yuyu.common.workflowcore.iwfcommon.pga.ICommonMethodResult;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_KengenUmuKbn;
import yuyu.def.classification.C_ProcessStatusKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_UserRole;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 共通ロジッククラス<br />
 * ※ワークフローで扱う共通処理をロジックとして提供することを目的に作成したクラス<br />
 */
public class IwfCommonLogic {

    private static Logger LOGGER = jp.co.slcs.swak.core.logger.LoggerFactory.getLogger(IwfCommonLogic.class);

    public static String token2Gyoumukey(String tokenid, IwfCoreDomManager iwfCoreDomManager){
        List<WT_GyoumuKey> itGyoumukeys = iwfCoreDomManager.getGyoumuKeysByTokenId(tokenid);
        return itGyoumukeys.get(0).getGyoumuKey();
    }
    public static List<String> gyoumukey2Tokens(String gyoumukey, IwfCoreDomManager iwfCoreDomManager){
        List<WT_GyoumuKey> wtGyoumukeys = iwfCoreDomManager.getGyoumuKeys(gyoumukey);

        List<String> tokenIds = new ArrayList<String>();
        for(WT_GyoumuKey wtGyoumukey : wtGyoumukeys){
            tokenIds.add(wtGyoumukey.getTokenId());
        }
        return tokenIds;
    }
    public static String gyoumukey2Token( String flowId, String gyoumukey,IwfCoreDomManager iwfCoreDomManager){
        WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(flowId, gyoumukey);

        if(null == wT_GyoumuKey){

            LOGGER.warn("該当の業務キーとフローIDの組み合わせは存在しません。[gyoumukey = " + gyoumukey + " flowId = " + flowId + "]");
            return "";
        }

        return wT_GyoumuKey.getTokenId();
    }

    @Deprecated
    public static IWorkflowToken getToken(IwfCoreDomManager iwfCoreDomManager, IWorkflowContext poWfContext, WSCommonResponse poWSResponse, String psGyoumukey, String psFlowid){

        String sTokenId = null;

        WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(psFlowid, psGyoumukey);

        if(null == wT_GyoumuKey){

            IwfEditMessageUtil.setMsgResultNG_RecordNotFound(poWSResponse, WT_GyoumuKey.TABLE_NAME);
            return null;
        }

        sTokenId = wT_GyoumuKey.getTokenId();

        if(StringUtils.isBlank(sTokenId)){

            IwfEditMessageUtil.setMsgResultNG_ItemNoValue(poWSResponse,
                WT_GyoumuKey.TABLE_NAME, WT_GyoumuKey.TOKENID);
            return null;
        }

        IWorkflowToken oToken = null;
        try{
            oToken = poWfContext.getProcessDef(psFlowid).getToken(sTokenId);
        }catch(NullPointerException ne){

            IwfEditMessageUtil.setMsgResultNG(poWSResponse, IwfMessageCd.IWF9000);
        }

        if(oToken == null){

            IwfEditMessageUtil.setMsgResultNG(poWSResponse, IwfMessageCd.IWF9000);
            return null;
        }


        return oToken;

    }


    public static class Tokens{

        private static Logger LOGGER = jp.co.slcs.swak.core.logger.LoggerFactory.getLogger(Tokens.class);

        public static boolean exists(IwfCoreDomManager iwfCoreDomManager, IWorkflowContext poWfContext, String psGyoumukey, String psFlowid){

            IWorkflowToken token = getToken(iwfCoreDomManager, poWfContext, psGyoumukey, psFlowid);

            return token != null;
        }
        public static boolean isActive(IwfCoreDomManager iwfCoreDomManager, IWorkflowContext poWfContext, String psGyoumukey, String psFlowid){

            IWorkflowToken token = getToken(iwfCoreDomManager, poWfContext, psGyoumukey, psFlowid);
            if(token == null || token.hasEnded()){
                return false;
            }
            return true;
        }

        public static IWorkflowToken createNewToken(String sFlowId, IWorkflowContext oWfCtx) {
            return createNewToken(sFlowId, null, oWfCtx);
        }

        public static IWorkflowToken createNewToken(String sFlowId, String sKouteiKaisiday, IWorkflowContext oWfCtx) {
            IWorkflowToken token = oWfCtx.getProcessDef(sFlowId).newToken();

            if (token == null || token.hasEnded()) {
                return token;
            }

            Properties prop = System.getProperties();
            System.out.println("classpath = " + prop.getProperty("java.class.path", null));

            token.setStringVariable(E_TokenVarKey.SYORI_STATUS.key, C_ProcessStatusKbn.PROCESSING.getValue());

            if(StringUtils.isNotEmpty(sKouteiKaisiday)) {
                token.setStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key, sKouteiKaisiday);
            }
            else {
                token.setStringVariable(E_TokenVarKey.KOUTEI_KAISIDAY.key, IwfDateUtils.getYYYYMMDD());
            }

            return token;
        }

        public static IWorkflowToken getActiveToken(IwfCoreDomManager iwfCoreDomManager, IWorkflowContext poWfContext, String psGyoumukey, String psFlowid){

            LOGGER.trace("有効なトークンを取得します。");

            IWorkflowToken token = getToken(iwfCoreDomManager, poWfContext, psGyoumukey, psFlowid);
            if(token == null || token.hasEnded()){
                return null;
            }
            return token;
        }
        public static IWorkflowToken getToken(IwfCoreDomManager iwfCoreDomManager, IWorkflowContext poWfContext, String psGyoumukey, String psFlowid){

            LOGGER.trace("トークンを取得します。[ Flowid, Gyoumukey = " + psGyoumukey + ", " + psFlowid + " ]");

            String sTokenId = null;

            LOGGER.debug("業務キーテーブル取得");
            WT_GyoumuKey wT_GyoumuKey = iwfCoreDomManager.getGyoumuKey(psFlowid, psGyoumukey);

            if(null == wT_GyoumuKey){
                LOGGER.debug("指定の条件のトークンは、業務キーテーブルに存在しません。nullを返却します。");

                return null;
            }
            sTokenId = wT_GyoumuKey.getTokenId();

            if(StringUtils.isBlank(sTokenId)){
                LOGGER.debug("トークンなし");
                return null;
            }

            LOGGER.debug("トークンを取得して返却します。");
            try {

                IWorkflowProcessDef processDef = poWfContext.getProcessDef(psFlowid);
                LOGGER.debug("対象プロセス定義 = " + processDef.getLocalName());
                IWorkflowToken token = processDef.getToken(sTokenId);
                if (token != null) {
                    LOGGER.debug("トークンID       = " + token.getId());
                    LOGGER.debug("ノードID         = " + token.getNodeId());
                    LOGGER.debug("ノード名         = " + token.getNodeName());
                }
                return token;

            } catch (WorkflowRuntimeException e1) {
                LOGGER.warn("トークンの取得に失敗しました。", e1);
                return null;
            }

        }
    }


    public static boolean isNotExistKengen(IwfCoreDomManager iwfCoreDomManager,
        WSCommonResponse poWSResponse, String psFlowid, String psAccountid,
        String psNodeId) {


        AM_User user = SWAKInjector.getInstance(BaseDomManager.class).getUser(psAccountid);

        if (null == user) {
            return true;
        }


        Set<List<String>> auth = SWAKInjector.getInstance(WorkflowAuthInfo.class).getProcessAuthByUserId(psAccountid);


        if(auth.isEmpty()){
            IwfEditMessageUtil.setMsgResultNG_RecordNotFound(poWSResponse, AT_UserRole.TABLE_NAME);
            return true;
        }


        for(List<String> flowNodeId : auth ){
            if(flowNodeId.get(0).equals(psFlowid) && flowNodeId.get(1).equals(psNodeId) ) {
                return false;
            }
        }

        IwfEditMessageUtil.setMsgResultNG_RecordNotFound(poWSResponse,WT_KengenKoutei.TABLE_NAME);
        return true;

    }

    public static  void createKouteiRireki(String psFlowId, String psTokenId, String psGyoumuKey, String psNodeId, String psNodeNm, C_IwfSyoriKbn poSyoriKbn, String psAccountId, C_RirekiKbn poRirekiKbn, byte[] pbExtInfo, IwfCoreDomManager iwfCoreDomManager)
        throws Exception {


        WT_KouteiRireki itKouteirireki = new WT_KouteiRireki();


        String sSysDate = IwfDateUtils.getSysDate();


        itKouteirireki.setTokenId(psTokenId);
        itKouteirireki.setSyoriTime(sSysDate);
        itKouteirireki.setFlowId(psFlowId);
        itKouteirireki.setGyoumuKey(psGyoumuKey);
        itKouteirireki.setNodeId(psNodeId);
        itKouteirireki.setNodeNm(psNodeNm);
        itKouteirireki.setUserId(psAccountId);
        itKouteirireki.setIwfSyoriKbn(poSyoriKbn);
        itKouteirireki.setRrkMsg(poSyoriKbn.getContent());
        itKouteirireki.setRirekiKbn(poRirekiKbn);
        itKouteirireki.setExtInfo(pbExtInfo);
        itKouteirireki.setKousinTime(sSysDate);


        iwfCoreDomManager.insert(itKouteirireki);
    }

    public static  void createKouteiRireki(String psFlowId, String psTokenId, String psGyoumuKey, String psNodeId, String psNodeNm, C_IwfSyoriKbn poSyoriKbn, String psAccountId, C_RirekiKbn poRirekiKbn, String psRrkimsg, byte[] pbExtInfo, IwfCoreDomManager iwfCoreDomManager)
        throws Exception {

        WT_KouteiRireki itKouteirireki = new WT_KouteiRireki();

        String sSysDate = IwfDateUtils.getSysDate();

        itKouteirireki.setTokenId(psTokenId);
        itKouteirireki.setSyoriTime(sSysDate);
        itKouteirireki.setFlowId(psFlowId);
        itKouteirireki.setGyoumuKey(psGyoumuKey);
        itKouteirireki.setNodeId(psNodeId);
        itKouteirireki.setNodeNm(psNodeNm);
        itKouteirireki.setUserId(psAccountId);
        itKouteirireki.setIwfSyoriKbn(poSyoriKbn);
        itKouteirireki.setRrkMsg(psRrkimsg);
        itKouteirireki.setRirekiKbn(poRirekiKbn);
        itKouteirireki.setExtInfo(pbExtInfo);
        itKouteirireki.setKousinTime(sSysDate);

        iwfCoreDomManager.insert(itKouteirireki);
    }

    public static IWorkflowToken createNewTokenAuto(String sFlowId, String sGyoumukey, String sKouteiKaisiDay, IWorkflowContext oWfCtx, IwfCoreDomManager iwfCoreDomManager)
        throws Exception {
        try {

            try {

                oWfCtx.getProcessDef(sFlowId);

            } catch (WorkflowRuntimeException e) {
                throw new Exception("プロセス定義が取得できませんでした。", e);
            }

            CanCreateNewTokenCheckerInBean inBean = new CanCreateNewTokenCheckerInBean(
                iwfCoreDomManager,
                oWfCtx,
                sGyoumukey,
                sFlowId,
                null
                );
            if(!Checks.checkCanCreateNewToken(inBean)){
                throw new Exception("指定された業務キー、フローIDに紐付くトークンは、既に存在しています。");
            }
            LOGGER.debug("トークン作成可否チェックが完了しました。");

            IWorkflowToken oNewToken = Tokens.createNewToken(sFlowId, sKouteiKaisiDay, oWfCtx);

            if(oNewToken == null) {
                throw new Exception("トークンが作成できませんでした。");
            }
            LOGGER.debug("トークンの作成が完了しました。フローID : " + sFlowId + " 業務キー : " + sGyoumukey);

            oNewToken.next();
            LOGGER.debug("最初のタスクノードへ遷移しました。");

            IwfCommonLogic.modifyGyoumukeyTokenRelation(sGyoumukey, sFlowId, oNewToken.getId(), iwfCoreDomManager, "");
            LOGGER.debug("業務テーブルを更新しました。");

            return oNewToken;

        } catch (WorkflowRuntimeException e) {
            throw new Exception("ワークフロー例外が発生しました。", e);

        } catch (Exception e) {
            throw new Exception("想定外の例外が発生しました。", e);
        }

    }


    public static void modifyGyoumukeyTokenRelation(String sGyoumuKey, String sFlowId, String sTokenId, IwfCoreDomManager iwfCoreDomManager, String...sRequestId) throws Exception {

        WT_GyoumuKey wtGyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowId, sGyoumuKey);

        if(wtGyoumuKey != null){
            wtGyoumuKey = iwfCoreDomManager.getGyoumuKey(sFlowId, sGyoumuKey);

            wtGyoumuKey.setTokenId(sTokenId);
            iwfCoreDomManager.update(wtGyoumuKey);

            if(sRequestId == null || sRequestId[0] == null){
                LOGGER.debug("業務キーテーブルのフローID、業務キー、トークンIDを更新");
            }else{
                LOGGER.debug("[" + sRequestId[0] +  "]業務キーテーブルのフローID、業務キー、トークンIDを更新");
            }
        }else{

            wtGyoumuKey   = new WT_GyoumuKey();


            wtGyoumuKey.setFlowId(sFlowId);
            wtGyoumuKey.setGyoumuKey(sGyoumuKey);
            wtGyoumuKey.setTokenId(sTokenId);
            wtGyoumuKey.setCreateTime(IwfDateUtils.getSysDate());


            iwfCoreDomManager.insert(wtGyoumuKey);
            if(sRequestId == null || sRequestId[0] == null){
                LOGGER.debug("業務キーテーブルにフローID、業務キー、トークンIDを登録");
            }else{
                LOGGER.debug("[" + sRequestId[0] +  "]業務キーテーブルにフローID、業務キー、トークンIDを登録");
            }
        }
    }

    public static ICommonMethodResult createProcess(String sFlowId, String sGyoumukey, String sAccountId, IWorkflowContext oWfCtx, IwfCoreDomManager iwfCoreDomManager){

        IWorkflowToken token = Tokens.createNewToken(sFlowId, oWfCtx);

        if(token == null) {
            LOGGER.debug("トークンの作成に失敗しました。");

            return new CommonMethodResult(C_ResultCdKbn.NG, IwfMessageCd.IWF9002);
        }

        String sTokenId = token.getId();

        try {

            IwfCommonLogic.modifyGyoumukeyTokenRelation(sGyoumukey, sFlowId, sTokenId, iwfCoreDomManager);

            IwfCommonLogic.createKouteiRireki(sFlowId,
                sTokenId,
                sGyoumukey,
                token.getNodeId(),
                token.getNodeName(),
                C_IwfSyoriKbn.PROCESSSTART,
                sAccountId,
                C_RirekiKbn.SYSTEM,
                null,
                iwfCoreDomManager);
            LOGGER.debug("工程履歴を登録しました。");

        } catch (Exception e) {
            LOGGER.warn("工程の作成中にエラーが発生しました。", e);
        }

        return new CommonMethodResult(C_ResultCdKbn.OK, IwfMessageCd.IWF0000);
    }

    public static void createKouteiSummary(String psGyoumuKey, String psFlowid, String psSyokaiAccountId, String psZenkaiAccountId, String psZenkaiNodeNm, String psZenkaiTaskLocalNm, String psGenzaiAccountid, String psGenzaiNodeNm, String psGenzaiTaskLocalNm, String psKouteikaisiYmd, String psKouteikanryouYmd, String psSyoriStatus, Map<String, WSExtParam> pExtParam, IwfCoreDomManager iwfCoreDomManager) {

        LOGGER.trace("工程サマリテーブルを作成します。");
        LOGGER.trace("｜業務キー : " + psGyoumuKey);
        LOGGER.trace("｜フローID : " + psFlowid);
        LOGGER.trace("｜初回担当者ID : " + psSyokaiAccountId);
        LOGGER.trace("｜前回担当者ID : " + psZenkaiAccountId);
        LOGGER.trace("｜前回ノード名 : " + psZenkaiNodeNm);
        LOGGER.trace("｜前回タスクローカル名 : " + psZenkaiTaskLocalNm);
        LOGGER.trace("｜現在担当者ID : " + psGenzaiAccountid);
        LOGGER.trace("｜現在ノード名 : " + psGenzaiNodeNm);
        LOGGER.trace("｜現在タスクローカル名 : " + psGenzaiTaskLocalNm);
        LOGGER.trace("｜工程開始日 : " + psKouteikaisiYmd);
        LOGGER.trace("｜工程完了日 : " + psKouteikanryouYmd);
        LOGGER.trace("｜処理状態 : " + psSyoriStatus);
        LOGGER.trace("｜拡張パラメータ : " + pExtParam);


        WT_KouteiSummary wtKouteisummary = new WT_KouteiSummary();


        String sSysDate = IwfDateUtils.getSysDate();


        wtKouteisummary.setGyoumuKey(psGyoumuKey);
        wtKouteisummary.setFlowId(psFlowid);
        wtKouteisummary.setLastSyoriTime(sSysDate);
        wtKouteisummary.setSyokaiAccountId(psSyokaiAccountId);
        wtKouteisummary.setZenkaiAccountId(psZenkaiAccountId);
        wtKouteisummary.setZenkaiNodeNm(psZenkaiNodeNm);
        wtKouteisummary.setZenkaiTaskLocalNm(psZenkaiTaskLocalNm);
        wtKouteisummary.setNodeNm(psGenzaiNodeNm);
        wtKouteisummary.setGenzaiAccountId(psGenzaiAccountid);
        wtKouteisummary.setGenzaiTaskLocalNm(psGenzaiTaskLocalNm);
        wtKouteisummary.setIwfKouteiKaisiYmd(psKouteikaisiYmd);
        wtKouteisummary.setKouteiKanryouYmd(psKouteikanryouYmd);
        wtKouteisummary.setSyoriStatus(psSyoriStatus);
        wtKouteisummary.setKousinTime(sSysDate);


        IwfCommonLogic.setExtParams(wtKouteisummary, pExtParam);


        iwfCoreDomManager.insert(wtKouteisummary);
    }

    public static WT_KouteiSummary updateKouteiSummary(String psGyoumuKey, String psFlowid, String psSyokaiAccountId, String psZenkaiAccountId, String psZenkaiNodeNm, String psZenkaiTaskLocalNm, String psGenzaiAccountid, String psGenzaiNodeNm, String psGenzaiTaskLocalNm,  String psKouteikaisiYmd, String psKouteikanryouYmd, String psSyoriStatus,  Map<String, WSExtParam> pExtParam, IwfCoreDomManager iwfCoreDomManager) {

        LOGGER.trace("工程サマリテーブルを更新します。");
        LOGGER.trace("｜業務キー : " + psGyoumuKey);
        LOGGER.trace("｜フローID : " + psFlowid);
        LOGGER.trace("｜初回担当者ID : " + psSyokaiAccountId);
        LOGGER.trace("｜前回担当者ID : " + psZenkaiAccountId);
        LOGGER.trace("｜前回ノード名 : " + psZenkaiNodeNm);
        LOGGER.trace("｜前回タスクローカル名 : " + psZenkaiTaskLocalNm);
        LOGGER.trace("｜現在担当者ID : " + psGenzaiAccountid);
        LOGGER.trace("｜現在ノード名 : " + psGenzaiNodeNm);
        LOGGER.trace("｜現在タスクローカル名 : " + psGenzaiTaskLocalNm);
        LOGGER.trace("｜工程開始日 : " + psKouteikaisiYmd);
        LOGGER.trace("｜工程完了日 : " + psKouteikanryouYmd);
        LOGGER.trace("｜処理状態 : " + psSyoriStatus);
        LOGGER.trace("｜拡張パラメータ : " + pExtParam);

        WT_KouteiSummary wtKouteisummary = iwfCoreDomManager.getKouteiSummary(psGyoumuKey);


        String sSysDate = IwfDateUtils.getSysDate();


        wtKouteisummary.setLastSyoriTime(sSysDate);
        if (psFlowid != null) {
            wtKouteisummary.setFlowId(psFlowid);
        }
        if (psSyokaiAccountId != null) {
            wtKouteisummary.setSyokaiAccountId(psSyokaiAccountId);
        }
        if (psZenkaiAccountId != null) {
            wtKouteisummary.setZenkaiAccountId(psZenkaiAccountId);
        }
        if (psZenkaiNodeNm != null) {
            wtKouteisummary.setZenkaiNodeNm(psZenkaiNodeNm);
        }
        if (psZenkaiTaskLocalNm != null) {
            wtKouteisummary.setZenkaiTaskLocalNm(psZenkaiTaskLocalNm);
        }
        if (psGenzaiAccountid != null) {
            wtKouteisummary.setGenzaiAccountId(psGenzaiAccountid);
        }
        if (psGenzaiNodeNm != null) {
            wtKouteisummary.setNodeNm(psGenzaiNodeNm);
        }
        if (psGenzaiTaskLocalNm != null) {
            wtKouteisummary.setGenzaiTaskLocalNm(psGenzaiTaskLocalNm);
        }
        if (psKouteikaisiYmd != null) {
            wtKouteisummary.setIwfKouteiKaisiYmd(psKouteikaisiYmd);
        }
        if (psKouteikanryouYmd != null) {
            wtKouteisummary.setKouteiKanryouYmd(psKouteikanryouYmd);
        }
        if (psSyoriStatus != null) {
            wtKouteisummary.setSyoriStatus(psSyoriStatus);
        }


        IwfCommonLogic.setExtParams(wtKouteisummary, pExtParam);

        wtKouteisummary.setKousinTime(sSysDate);


        iwfCoreDomManager.update(wtKouteisummary);


        return wtKouteisummary;
    }

    public static WT_KouteiSummary updateKouteiSummaryTime(String psGyoumuKey, IwfCoreDomManager iwfCoreDomManager) {

        return updateKouteiSummary(psGyoumuKey, null, null, null, null, null, null, null, null, null, null,  null, null, iwfCoreDomManager);
    }

    public static WT_KouteiSummary selKouteiSummry(String psGyoumuKey, IwfCoreDomManager iwfCoreDomManager) {
        return iwfCoreDomManager.getKouteiSummary(psGyoumuKey);

    }

    public static Map<String, WSExtParam> getExtParams(WSCommonRequest request) {

        Map<String, WSExtParam> extParamMap = new HashMap<String, WSExtParam>();

        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM1, request.getExtParam1());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM2, request.getExtParam2());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM3, request.getExtParam3());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM4, request.getExtParam4());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM5, request.getExtParam5());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM6, request.getExtParam6());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM7, request.getExtParam7());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM8, request.getExtParam8());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM9, request.getExtParam9());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM10, request.getExtParam10());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM11, request.getExtParam11());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM12, request.getExtParam12());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM13, request.getExtParam13());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM14, request.getExtParam14());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM15, request.getExtParam15());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM16, request.getExtParam16());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM17, request.getExtParam17());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM18, request.getExtParam18());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM19, request.getExtParam19());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM20, request.getExtParam20());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM21, request.getExtParam21());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM22, request.getExtParam22());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM23, request.getExtParam23());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM24, request.getExtParam24());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM25, request.getExtParam25());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM26, request.getExtParam26());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM27, request.getExtParam27());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM28, request.getExtParam28());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM29, request.getExtParam29());
        extParamMap.put(WSCommonIOKey.IN.sS_EXTPARAM30, request.getExtParam30());

        return extParamMap;

    }

    public static void setExtParams(WT_KouteiSummary entity, Map<String, WSExtParam> extParamMap) {

        if (null == extParamMap) {
            return;
        }

        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM1)){
            entity.setExtParam1(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM1).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM2)){
            entity.setExtParam2(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM2).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM3)){
            entity.setExtParam3(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM3).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM4)){
            entity.setExtParam4(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM4).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM5)){
            entity.setExtParam5(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM5).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM6)){
            entity.setExtParam6(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM6).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM7)){
            entity.setExtParam7(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM7).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM8)){
            entity.setExtParam8(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM8).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM9)){
            entity.setExtParam9(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM9).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM10)){
            entity.setExtParam10(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM10).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM11)){
            entity.setExtParam11(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM11).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM12)){
            entity.setExtParam12(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM12).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM13)){
            entity.setExtParam13(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM13).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM14)){
            entity.setExtParam14(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM14).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM15)){
            entity.setExtParam15(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM15).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM16)){
            entity.setExtParam16(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM16).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM17)){
            entity.setExtParam17(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM17).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM18)){
            entity.setExtParam18(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM18).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM19)){
            entity.setExtParam19(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM19).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM20)){
            entity.setExtParam20(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM20).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM21)){
            entity.setExtParam21(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM21).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM22)){
            entity.setExtParam22(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM22).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM23)){
            entity.setExtParam23(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM23).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM24)){
            entity.setExtParam24(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM24).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM25)){
            entity.setExtParam25(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM25).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM26)){
            entity.setExtParam26(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM26).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM27)){
            entity.setExtParam27(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM27).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM28)){
            entity.setExtParam28(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM28).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM29)){
            entity.setExtParam29(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM29).getValue());
        }
        if(null != extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM30)){
            entity.setExtParam30(extParamMap.get(WSCommonIOKey.IN.sS_EXTPARAM30).getValue());
        }
    }

    public static void clearGenzaiAccountid(String psGyoumuKey, IwfCoreDomManager iwfCoreDomManager) {

        WT_KouteiSummary wtKouteisummary = iwfCoreDomManager.getKouteiSummary(psGyoumuKey);

        wtKouteisummary.setGenzaiAccountId(null);

        iwfCoreDomManager.update(wtKouteisummary);
    }

    public static C_KengenUmuKbn getKengenUmu(IwfCoreDomManager iwfCoreDomManager,String sAccountId, String sTorikomiSyoruiCd_syorui) {

        C_KengenUmuKbn kengenUmu = C_KengenUmuKbn.NONE;

        Set<String> syoruiKengens = SWAKInjector.getInstance(WorkflowAuthInfo.class).getImageAuthByUserId(sAccountId);

        if (syoruiKengens.contains(sTorikomiSyoruiCd_syorui)){

            kengenUmu = C_KengenUmuKbn.ARI;
        }
        return kengenUmu;
    }

    public static String parseJBPMDateTime(String psTime) {
        String fString = new String();
        try{
            Date d = new SimpleDateFormat("yyyyMMddHHmmss").parse(psTime.substring(0,14));
            fString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        } catch (Exception e){
        }
        return fString;
    }
}
