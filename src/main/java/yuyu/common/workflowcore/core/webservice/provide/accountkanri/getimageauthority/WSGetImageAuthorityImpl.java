package yuyu.common.workflowcore.core.webservice.provide.accountkanri.getimageauthority;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * 書類権限情報取得サービスのメインクラス<br/>
 *
 * イメージ権限ＩＤが存在する場合は、該当取込書類コードを取得する<Br/>
 * イメージ権限ＩＤが存在しない場合は、エラーを返す
 *
 */
public class WSGetImageAuthorityImpl implements WSGetImageAuthority {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private final static Logger LOGGER = LoggerFactory.getLogger(WSGetImageAuthorityImpl.class);

    public WSGetImageAuthorityResponse validate(WSGetImageAuthorityRequest request) throws Exception {

        WSGetImageAuthorityResponse oResponse = new WSGetImageAuthorityResponse();

        String sImageAuthId = request.getImageauthid();
        if (StringUtils.isEmpty(sImageAuthId)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "イメージ権限ＩＤ");
        }

        return oResponse;
    }

    @Override
    public WSGetImageAuthorityResponse executeBizMain(WSGetImageAuthorityRequest request) throws Exception {

        WSGetImageAuthorityResponse oWSResponse = new WSGetImageAuthorityResponse();

        oWSResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oWSResponse.getKekkastatus())) {
            return oWSResponse;
        }

        String sImageAuthId = request.getImageauthid();

        try {

            List<WT_KengenSyorui> kengenSyoruiInfos = iwfCoreDomManager.getKengenSyoruisByRoleCd(sImageAuthId);

            if (kengenSyoruiInfos.isEmpty()) {
                IwfEditMessageUtil.setMsgResultWARN(oWSResponse, IwfMessageCd.IWF4040);

                LOGGER.debug("指定された書類権限情報は存在しません。");

                return oWSResponse;
            }

            List<String> torikomiSyoruiCds = new ArrayList<String>();

            for (WT_KengenSyorui syorui : kengenSyoruiInfos) {
                torikomiSyoruiCds.add(syorui.getTorikomiSyoruiCd());
            }

            oWSResponse.setTorikomiSyoruiCds(torikomiSyoruiCds.toArray(new String[] {}));

            IwfEditMessageUtil.setMsgResultOK(oWSResponse, "書類権限情報取得");

        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oWSResponse, IwfMessageCd.IWF0001, "書類権限情報取得");
        }

        return oWSResponse;
    }

    public WSGetImageAuthorityResponse getBootErrResponse() {
        WSGetImageAuthorityResponse res = new WSGetImageAuthorityResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }
}
