package yuyu.common.workflowcore.core.webservice.provide.accountkanri.delauthority;

import static com.google.common.base.Objects.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KengenKoutei;
import yuyu.def.workflowcore.configration.IwfCoreConfig;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Objects;

/**
 * 権限削除サービスのプロバイダークラスです。<br/>
 *
 * 権限ＩＤが存在する場合は、該当権限ＩＤ情報を削除<Br/>
 * 権限ＩＤが存在しない場合は、エラーを返す
 *
 */
public class WSDelAuthorityImpl implements WSDelAuthority {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    static class ResultCd{
        static final int iDEL_OK = 0;
        static final int iDEL_NG = 1;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(WSDelAuthorityImpl.class);

    public WSDelAuthorityResponse validate(WSDelAuthorityRequest request) throws Exception {

        LOGGER.debug("[RequestId=" + request.getRequestid() + "]バリデーションチェックを開始します。");

        WSDelAuthorityResponse oResponse = new WSDelAuthorityResponse();

        String sAuthId  = request.getAuthid();
        IwfCoreConfig iwfCoreConfig = IwfCoreConfig.getInstance();
        String accountKanriMode = String.valueOf(iwfCoreConfig.getAccountKanriMode());

        if (StringUtils.isEmpty(sAuthId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "権限ＩＤ");
            return oResponse;
        }
        if ("1".equals(accountKanriMode)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0010);
            return oResponse;
        }


        return oResponse;
    }

    @Override
    @Transactional
    public WSDelAuthorityResponse executeBizMain(WSDelAuthorityRequest request) throws Exception {

        WSDelAuthorityResponse oResponse = new WSDelAuthorityResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sAuthId = request.getAuthid();
        String sRequestId = request.getRequestid();

        LOGGER.debug("[RequestId=" + sRequestId + "] 主処理を開始します。");


        try {

            int iResKoutei = deleteKengenKoutei(sAuthId);


            LOGGER.debug(Objects.toStringHelper(this)
                .add("RequestId"              , sRequestId)
                .add("削除結果 権限詳細(工程)TBL", iResKoutei)
                .toString());

            if (iResKoutei == ResultCd.iDEL_OK) {

                IwfEditMessageUtil.setMsgResultOK(oResponse, "権限削除");
            }
            else {
                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "権限削除");
            }
        }

        catch (HibernateException he) {

            LOGGER.error("データベースアクセス中に例外が発生しました。", he);

            iwfCoreDomManager.clear();
        }
        catch (Exception e) {

            LOGGER.error("想定外のエラーが発生しました。", e);

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "権限削除");
        } finally{
        }
        return oResponse;
    }



    private int deleteKengenKoutei(final String psAuthId) throws Exception {

        List<WT_KengenKoutei> oAuthList = iwfCoreDomManager.getKengenKouteisByRoleCd(psAuthId);

        if (oAuthList.isEmpty()) {
            LOGGER.debug(toStringHelper(this).add("Auth", psAuthId).toString());
            LOGGER.debug("対象 0 件");

            return ResultCd.iDEL_OK;
        }

        iwfCoreDomManager.delete(oAuthList);

        if(LOGGER.isDebugEnabled()){
            List<WT_KengenKoutei> oList = iwfCoreDomManager.getAllKengenKoutei();
            for(WT_KengenKoutei oAuth: oList) {
                LOGGER.debug(Objects.toStringHelper(this)
                    .add("Auth"     , oAuth.getRoleCd())
                    .add("Flow"     , oAuth.getFlowId())
                    .add("Node"     , oAuth.getNodeId())
                    .add("Time"     , oAuth.getKousinTime())
                    .toString());
            }
        }
        return ResultCd.iDEL_OK;
    }


    public WSDelAuthorityResponse getBootErrResponse() {
        WSDelAuthorityResponse res = new WSDelAuthorityResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
