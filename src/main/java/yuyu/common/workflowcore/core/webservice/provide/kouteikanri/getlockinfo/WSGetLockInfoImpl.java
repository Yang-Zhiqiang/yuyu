package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getlockinfo.IWSGetLockInfoIOKey.MapKey;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KouteiLock;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;


/**
 * 工程ロック情報取得サービスメイン
 */
public class WSGetLockInfoImpl implements WSGetLockInfo {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSGetLockInfoImpl.class);


    public WSGetLockInfoImpl() {
        super();
    }

    public WSGetLockInfoResponse validate(WSGetLockInfoRequest request)
        throws Exception {

        WSGetLockInfoResponse oResponse = new WSGetLockInfoResponse();

        return oResponse;
    }

    public String getServiceName() {

        return WSGetLockInfoRequest.sSERVICE_NAME;
    }

    @Override
    public WSGetLockInfoResponse executeBizMain(WSGetLockInfoRequest request)
        throws Exception {

        WSGetLockInfoResponse oWSResponse = new WSGetLockInfoResponse();

        String[] sInGyoumukeys = request.getGyoumukey();
        String[] sInFlowids = request.getFlowid();

        try {

            List<WT_KouteiLock> kouteiLockInfos = iwfCoreDomManager.getKouteiLockByCond(sInGyoumukeys, sInFlowids);

            if (kouteiLockInfos.isEmpty()) {
                IwfEditMessageUtil.setMsgResultWARN(oWSResponse, IwfMessageCd.IWF4030);

                LOGGER.debug("指定された工程ロック情報は存在しません。");

                return oWSResponse;
            }

            List<Map<String, String>> oLockMaps = new ArrayList<Map<String, String>>();

            for (WT_KouteiLock lockInfo : kouteiLockInfos) {
                String gyoumuKey = lockInfo.getGyoumuKey();
                String flowId = lockInfo.getFlowId();
                String nodename = lockInfo.getNodeNm();
                String accountId = lockInfo.getUserId();
                String lockKey = lockInfo.getLockKey();
                String lockTime = lockInfo.getLockTime();

                Map<String, String> oLockInfoMap = new HashMap<String, String>();
                oLockInfoMap.put(MapKey.sS_GYOUMUKEY, gyoumuKey);
                oLockInfoMap.put(MapKey.sS_FLOW_ID, flowId);
                oLockInfoMap.put(MapKey.sS_NODE_NAME, nodename);
                oLockInfoMap.put(MapKey.sS_ACCOUNT_ID, accountId);
                oLockInfoMap.put(MapKey.sS_LOCKKEY, lockKey);
                oLockInfoMap.put(MapKey.sS_LOCKTiME, lockTime);

                oLockMaps.add(oLockInfoMap);
            }

            oWSResponse.setLockInfomaps(oLockMaps.toArray(new Map[] {}));

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "工程ロック情報取得");

        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "工程ロック情報取得");
        }

        return oWSResponse;
    }

    public WSGetLockInfoResponse getStubResult(WSGetLockInfoRequest request)
        throws Exception {
        return null;
    }

    public WSGetLockInfoResponse getBootErrResponse() {
        WSGetLockInfoResponse res = new WSGetLockInfoResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
