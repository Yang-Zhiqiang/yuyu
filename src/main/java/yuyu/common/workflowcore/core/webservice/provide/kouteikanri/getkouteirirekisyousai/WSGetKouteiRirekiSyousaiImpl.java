package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.exception.CoreRuntimeException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import net.arnx.jsonic.JSON;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.api.api.impl.WorkflowContextFactory;
import yuyu.common.workflowcore.api.exception.WorkflowRuntimeException;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisyousai.IWSGetKouteiRirekiSyousaiIOKey.MapKey;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.classification.C_RirekiKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_KouteiRireki;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Strings;

/**
 * 工程履歴詳細取得サービスのプロバイダークラスです。
 * <p>
 * 業務キーを配列を受け取ります。
 * 受け取った業務キーに紐づく工程情報を返却します。
 * </p>
 */
public class WSGetKouteiRirekiSyousaiImpl implements WSGetKouteiRirekiSyousai{

    final static Logger LOGGER = LoggerFactory.getLogger(WSGetKouteiRirekiSyousaiImpl.class);
    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static String TASK_NAME = "taskname";

    public WSGetKouteiRirekiSyousaiImpl () {
        super();
    }


    public WSGetKouteiRirekiSyousaiResponse validate(
        WSGetKouteiRirekiSyousaiRequest poRequest) throws Exception {

        LOGGER.debug("│バリデーションチェック処理・・・");

        WSGetKouteiRirekiSyousaiResponse oResponse = new WSGetKouteiRirekiSyousaiResponse();

        String sGyoumuKey   = poRequest.getGyoumukey();
        String sFlowId      = poRequest.getFlowid();
        String sRirekikbn   = poRequest.getRirekikbn();

        if (StringUtils.isEmpty(sGyoumuKey) && StringUtils.isEmpty(sFlowId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "業務キーまたはフローＩＤ");
            return oResponse;
        }
        if (!IwfValidateUtil.isMaxLenChkOK(oResponse, sGyoumuKey, "業務キー", 20)) {
            return oResponse;
        }
        if (!IwfValidateUtil.isMaxLenChkOK(oResponse, sFlowId, "フローＩＤ", 19)) {
            return oResponse;
        }
        if (!StringUtils.isEmpty(sRirekikbn)) {
            try {
                C_RirekiKbn.valueOf(sRirekikbn);
            } catch (CoreRuntimeException e) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0006, "履歴区分");
            }
        }

        return oResponse;
    }


    public String getServiceName() {
        return WSGetKouteiRirekiSyousaiRequest.sSERVICE_NAME;
    }

    @Override
    @SuppressWarnings("unchecked")
    public WSGetKouteiRirekiSyousaiResponse executeBizMain(
        WSGetKouteiRirekiSyousaiRequest request) throws Exception {

        LOGGER.debug("|主処理開始・・・");
        WSGetKouteiRirekiSyousaiResponse oResponse = new WSGetKouteiRirekiSyousaiResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sInRequestId    = request.getRequestid();
        String sInGyoumukey    = request.getGyoumukey();
        String sInRirekiKbn    = request.getRirekikbn();
        String sInFlowId       = request.getFlowid();

        IWorkflowContext oWfCtx = WorkflowContextFactory.newInstance();

        try {
            oWfCtx.open();

            List<Map<String, String>> oRirekimaps = new ArrayList<Map<String,String>>();

            if (!StringUtils.isEmpty(sInFlowId)) {
                try {
                    oWfCtx.getProcessDef(sInFlowId);
                } catch (WorkflowRuntimeException e) {
                    iwfCoreDomManager.clear();
                    if (oWfCtx.isOpen()) {
                        oWfCtx.close();
                    }

                    IwfEditMessageUtil.setMsgResultNG(oResponse,
                        IwfMessageCd.IWF2131);

                    return oResponse;
                }
            }

            if (!StringUtils.isEmpty(sInGyoumukey)) {
                List<WT_GyoumuKey> resultGyoumuCheck = iwfCoreDomManager.getGyoumuKeys(sInGyoumukey);

                Iterator<WT_GyoumuKey> wtrGyoumuCheck = resultGyoumuCheck
                    .iterator();
                if (!wtrGyoumuCheck.hasNext()) {
                    iwfCoreDomManager.clear();
                    if (oWfCtx.isOpen()) {
                        oWfCtx.close();
                    }

                    IwfEditMessageUtil.setMsgResultNG(oResponse,
                        IwfMessageCd.IWF2132);

                    return oResponse;
                }
            }

            C_RirekiKbn rirekiKbn = null;
            if (!Strings.isNullOrEmpty(sInRirekiKbn)) {
                rirekiKbn = C_RirekiKbn.valueOf(sInRirekiKbn);
            }

            Long iCount = iwfCoreDomManager.getCountKouteiRirekiByGyoumukeyFlowidRirekiKbn(sInGyoumukey, sInFlowId, rirekiKbn);

            Integer iLimitCount = getLimitCountConfig();

            if(iCount > iLimitCount){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2130, String.valueOf(iLimitCount), String.valueOf(iCount));
                LOGGER.debug("[ReqId="+ sInRequestId + "]このサービスの最大取得件数を超えました。（最大取得件数={0}, 取得件数={1}）");

                if(oWfCtx.isOpen()){
                    oWfCtx.close();
                }

                iwfCoreDomManager.clear();

                return oResponse;
            }

            List<WT_KouteiRireki> kouteirirekis = iwfCoreDomManager.getKouteiRirekis(sInGyoumukey, sInFlowId, rirekiKbn);
            for(WT_KouteiRireki kouteiRirekiBean : kouteirirekis){
                String sGyoumukey     = kouteiRirekiBean.getGyoumuKey();
                String sFlowId        = kouteiRirekiBean.getFlowId();
                String sFlowLocalname = oWfCtx.getProcessDef(sFlowId).getLocalName();
                String sNodeName      = kouteiRirekiBean.getNodeNm();
                String sNodeLocalname = oWfCtx.getProcessDef(sFlowId).getTasknodeLocalName(sNodeName);
                String sAccountId     = kouteiRirekiBean.getUserId();
                String sSyoriTime     = kouteiRirekiBean.getSyoriTime();
                String sRrkMessage    = kouteiRirekiBean.getRrkMsg();
                C_IwfSyoriKbn   lSyoriKbn      = kouteiRirekiBean.getIwfSyoriKbn();
                C_RirekiKbn   lRrkKbn        = kouteiRirekiBean.getRirekiKbn();

                String sExtInfo = null;
                if (null != kouteiRirekiBean.getExtInfo()) {
                    sExtInfo = IwfBase64Urls.encodeFromString(new String(kouteiRirekiBean.getExtInfo(), "UTF-8"));
                }

                if (!StringUtils.isEmpty(sExtInfo)) {
                    List<Map<String, String>> extInfoList = (List<Map<String, String>>) JSON.decode(IwfBase64Urls
                        .decodeToString(sExtInfo));
                    for (Map<String, String> extMap : extInfoList) {
                        if (extMap.containsKey(TASK_NAME)) {
                            sNodeLocalname = extMap.get(TASK_NAME);
                            break;
                        }
                    }
                }

                Map<String, String> oRirekimap = new HashMap<String, String>();
                oRirekimap.put(MapKey.sS_GYOUMUKEY      , sGyoumukey);
                oRirekimap.put(MapKey.sS_FLOW_ID        , sFlowId);
                oRirekimap.put(MapKey.sS_FLOW_LOCALNAME , sFlowLocalname);
                oRirekimap.put(MapKey.sS_ACCOUNT_ID     , sAccountId);
                oRirekimap.put(MapKey.sS_SYORITiME      , sSyoriTime);
                oRirekimap.put(MapKey.sS_NODE_NAME      , sNodeName);
                oRirekimap.put(MapKey.sS_NODE_LOCALNAME , sNodeLocalname);
                oRirekimap.put(MapKey.sS_RIREKI_MESSAGE , sRrkMessage);
                oRirekimap.put(MapKey.sS_SYORI_KBN      , lSyoriKbn.toString());
                oRirekimap.put(MapKey.sS_RIREKI_KBN     , lRrkKbn.toString());
                oRirekimap.put(MapKey.sS_EXT_INFO       , sExtInfo);
                if(LOGGER.isDebugEnabled()){
                    LOGGER.debug("▼ 工程履歴詳細マップ");
                    LOGGER.debug("│ 業務キー                 : " + oRirekimap.get(MapKey.sS_GYOUMUKEY));
                    LOGGER.debug("│ フローID                 : " + oRirekimap.get(MapKey.sS_FLOW_ID));
                    LOGGER.debug("│ フローローカル名         : " + oRirekimap.get(MapKey.sS_FLOW_LOCALNAME));
                    LOGGER.debug("│ アカウントID             : " + oRirekimap.get(MapKey.sS_ACCOUNT_ID));
                    LOGGER.debug("│ 処理時間                 : " + oRirekimap.get(MapKey.sS_SYORITiME));
                    LOGGER.debug("│ ノード名                 : " + oRirekimap.get(MapKey.sS_NODE_NAME));
                    LOGGER.debug("│ ノード名(ローカル名)     : " + oRirekimap.get(MapKey.sS_NODE_LOCALNAME));
                    LOGGER.debug("│ 履歴メッセージ           : " + oRirekimap.get(MapKey.sS_RIREKI_MESSAGE));
                    LOGGER.debug("│ 処理区分                 : " + oRirekimap.get(MapKey.sS_SYORI_KBN));
                    LOGGER.debug("│ 履歴区分                 : " + oRirekimap.get(MapKey.sS_RIREKI_KBN));
                    LOGGER.debug("└ 付加情報                 : " + oRirekimap.get(MapKey.sS_EXT_INFO));
                }

                oRirekimaps.add(oRirekimap);
            }
            oResponse.setRirekimaps(oRirekimaps.toArray(new Map[]{}));
            IwfEditMessageUtil.setMsgResultOK(oResponse, "工程履歴詳細取得");

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程履歴詳細取得");
        }finally{

            if(oWfCtx.isOpen()){
                oWfCtx.close();
            }

        }
        return oResponse;
    }


    public WSGetKouteiRirekiSyousaiResponse getStubResult(
        WSGetKouteiRirekiSyousaiRequest request) throws Exception {
        return null;
    }


    public WSGetKouteiRirekiSyousaiResponse getBootErrResponse() {
        WSGetKouteiRirekiSyousaiResponse res = new WSGetKouteiRirekiSyousaiResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
    public Integer getLimitCountConfig(){
        return IwfCoreConfig.getInstance().getMaxKouteiRirekiKensu();
    }
}
