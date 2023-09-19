package yuyu.common.workflowcore.core.webservice.provide.accountkanri.delimageauthority;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Objects;

/**
 * イメージ権限削除サービスのメインクラス<br/>
 *
 * イメージ権限ＩＤが存在する場合は、該当権限ＩＤ情報を削除<Br/>
 * イメージ権限ＩＤが存在しない場合は、エラーを返す
 *
 */
public class WSDelImageAuthorityImpl implements WSDelImageAuthority {
    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    static class ResultCd{
        static final int iDEL_OK = 0;
        static final int iDEL_NG = 1;
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(WSDelImageAuthorityImpl.class);

    public WSDelImageAuthorityResponse validate(WSDelImageAuthorityRequest request) throws Exception {

        LOGGER.debug("[RequestId=" + request.getRequestid() + "]バリデーションチェックを開始します。");

        WSDelImageAuthorityResponse oResponse = new WSDelImageAuthorityResponse();

        String[] sImageAuthIds = request.getImageauthids();
        if (null == sImageAuthIds || 0 == sImageAuthIds.length) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "イメージ権限ＩＤ");
        }

        return oResponse;
    }

    @Override
    @Transactional
    public WSDelImageAuthorityResponse executeBizMain(WSDelImageAuthorityRequest request) throws Exception {

        WSDelImageAuthorityResponse oResponse = new WSDelImageAuthorityResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String[] sImageAuthIds = request.getImageauthids();
        String sRequestId = request.getRequestid();

        LOGGER.debug("[RequestId=" + sRequestId + "] 主処理を開始します。");

        try {
            int iResKoutei = deleteKengenSyorui(sImageAuthIds);

            LOGGER.debug("[RequestId=" + sRequestId + "] 削除結果 権限詳細(書類)TBL : " + iResKoutei);

            if (iResKoutei == ResultCd.iDEL_OK ) {
                IwfEditMessageUtil.setMsgResultOK(oResponse, "イメージ権限削除");

            } else {
                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "イメージ権限削除");
            }
        }
        catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "イメージ権限削除");

        }finally{

        }
        return oResponse;
    }

    private int deleteKengenSyorui(final String[] psImageAuthIds) throws Exception {

        List<WT_KengenSyorui> oAuthList = iwfCoreDomManager.getKengenSyoruisByRoleCds(psImageAuthIds);

        if (oAuthList.isEmpty()) {
            LOGGER.debug("Auth      :"+ psImageAuthIds);
            LOGGER.debug("対象 0 件");
            return ResultCd.iDEL_NG;
        }

        iwfCoreDomManager.delete(oAuthList);
        if(LOGGER.isDebugEnabled()){
            List<WT_KengenSyorui> oList = iwfCoreDomManager.getAllKengenSyorui();
            for(WT_KengenSyorui oAuth: oList) {
                LOGGER.debug(Objects.toStringHelper(this)
                    .add("Auth"    , oAuth.getRoleCd())
                    .add("Syorui"  , oAuth.getTorikomiSyoruiCd())
                    .add("Time"    , oAuth.getKousinTime())
                    .toString());
            }
        }
        return ResultCd.iDEL_OK;
    }

    public WSDelImageAuthorityResponse getBootErrResponse() {
        WSDelImageAuthorityResponse res = new WSDelImageAuthorityResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }


}
