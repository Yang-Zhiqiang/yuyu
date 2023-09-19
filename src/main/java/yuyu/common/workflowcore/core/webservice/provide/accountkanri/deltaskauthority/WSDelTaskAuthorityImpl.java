package yuyu.common.workflowcore.core.webservice.provide.accountkanri.deltaskauthority;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import net.arnx.jsonic.JSON;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfBase64Urls;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfCompressUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Objects;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * タスク権限削除サービスのプロバイダークラスです。<br/>
 *
 * 操作者を指定してタスク権限の削除が行います。<Br/>
 *
 */
public class WSDelTaskAuthorityImpl  implements WSDelTaskAuthority{
    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSDelTaskAuthorityImpl.class);


    public WSDelTaskAuthorityResponse validate(WSDelTaskAuthorityRequest poRequest) throws Exception {

        LOGGER.debug("[RequestId=" + poRequest.getRequestid() + "]バリデーションチェックを開始します。");

        WSDelTaskAuthorityResponse oResponse = new WSDelTaskAuthorityResponse();

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
        return WSDelTaskAuthorityRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSDelTaskAuthorityResponse executeBizMain(WSDelTaskAuthorityRequest request) throws Exception {

        String sAccountId = request.getAccountid();
        String sRequestId = request.getRequestid();

        LOGGER.debug("[" + sRequestId +  "]主処理を開始します。　アカウントID : " + sAccountId);

        WSDelTaskAuthorityResponse response = new WSDelTaskAuthorityResponse();

        response = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
            return response;
        }

        @SuppressWarnings("unchecked")
        List<Map<String, String>> oInMapList = (List<Map<String, String>>) new XStream(new DomDriver()).fromXML(IwfCompressUtils.uncompress(IwfBase64Urls.decode(request.getMaplistXml())));


        LOGGER.debug(Objects.toStringHelper(this)
            .add("request.accountid" , request.getAccountid())
            .add("request.maplistXml", request.getMaplistXml())
            .add("request.requestid" , request.getRequestid())
            .toString());


        LOGGER.debug(JSON.encode(oInMapList, true));

        try {

            LOGGER.debug("[" + sRequestId +  "]トランザクション開始");

            for (Map<String, String> oInMap : oInMapList) {
                String sFlowId = oInMap.get(IWSDelTaskAuthorityIOKey.MapKey.sS_FLOWID);
                String sNodeNm = oInMap.get(IWSDelTaskAuthorityIOKey.MapKey.sS_NODENAME);
                String sRoleCd = oInMap.get(IWSDelTaskAuthorityIOKey.MapKey.sS_ROLECD);

                LOGGER.debug(Objects.toStringHelper(this)
                    .add("FlowId"     , sFlowId)
                    .add("NodeName"   , sNodeNm)
                    .add("RoleCd"     , sRoleCd)
                    .toString());

                WT_KengenKoutei oBean = iwfCoreDomManager.getKengenKoutei(sRoleCd, sFlowId, sNodeNm);
                if(oBean == null) {
                    iwfCoreDomManager.clear();

                    IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF1130, sFlowId, sNodeNm, sRoleCd);
                    LOGGER.debug("[RequestId="+ sRequestId + "]削除対象レコードが存在しません。");
                    return response;
                }

                iwfCoreDomManager.delete(oBean);
            }

            LOGGER.debug("[RequestId=" + sRequestId +  "]データベースコミット完了");

            IwfEditMessageUtil.setMsgResultOK(response, "タスク権限削除");
        }
        catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0001, "タスク権限削除");
        }finally{

        }
        return response;
    }


    public WSDelTaskAuthorityResponse getBootErrResponse() {
        WSDelTaskAuthorityResponse res = new WSDelTaskAuthorityResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }


    public WSDelTaskAuthorityResponse getStubResult(WSDelTaskAuthorityRequest request) throws Exception {
        return null;
    }

    private WSDelTaskAuthorityResponse inMapValidate(Map<String, String> poInMap) throws Exception {
        WSDelTaskAuthorityResponse response = new WSDelTaskAuthorityResponse();

        if(StringUtils.isEmpty(poInMap.get(IWSDelTaskAuthorityIOKey.MapKey.sS_FLOWID))){
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0002, "フローＩＤ");
            return response;
        }
        if(StringUtils.isEmpty(poInMap.get(IWSDelTaskAuthorityIOKey.MapKey.sS_NODENAME))){
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0002, "ノード名");
            return response;
        }
        if(StringUtils.isEmpty(poInMap.get(IWSDelTaskAuthorityIOKey.MapKey.sS_ROLECD))){
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0002, "権限ID");
            return response;
        }

        return response;
    }

}
