package yuyu.common.workflowcore.core.webservice.provide.accountkanri.updimageauthority;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfStringArrayUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KengenSyorui;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Objects;

/**
 * イメージ権限更新サービスのプロバイダークラスです。<br/>
 *
 * 権限ＩＤが存在する場合は、該当権限ＩＤの情報を更新<br/>
 * 権限ＩＤが存在しない場合は、権限情報を追加<br/>
 *
 */
public class WSUpdImageAuthorityImpl implements WSUpdImageAuthority{

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSUpdImageAuthorityImpl.class);

    private static final int iUPD_OK = 0;
    private static final int iUPD_NG = 1;

    public WSUpdImageAuthorityResponse validate(WSUpdImageAuthorityRequest request)
        throws Exception {
        LOGGER.debug("│バリデーションチェック処理・・・");

        WSUpdImageAuthorityResponse oResponse = new WSUpdImageAuthorityResponse();
        String   sImageAuthId = request.getImageauthid();
        String[] sTorikomiSyoruiCds = request.getTorikomisyoruicds();
        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sImageAuthId, "イメージ権限ＩＤ", 30)) {
            return oResponse;
        }
        if (IwfStringArrayUtils.containsEmpty(sTorikomiSyoruiCds)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "取込書類コード配列");
            return oResponse;
        } else {
            for (String torikomiSyoruiCd : sTorikomiSyoruiCds) {
                if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, torikomiSyoruiCd, "取込書類コード", 30)) {
                    return oResponse;
                }
            }
        }

        return oResponse;
    }


    public String getServiceName() {

        return WSUpdImageAuthorityRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSUpdImageAuthorityResponse executeBizMain(WSUpdImageAuthorityRequest request)
        throws Exception {
        LOGGER.debug("│主処理・・・");

        WSUpdImageAuthorityResponse oResponse = new WSUpdImageAuthorityResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String   sImageAuthId = request.getImageauthid();
        String[] sTorikomiSyoruiCds = request.getTorikomisyoruicds();

        try {

            int iResMeisai = _setAuthSyorui(sImageAuthId, sTorikomiSyoruiCds);

            if (iResMeisai == iUPD_OK) {
                IwfEditMessageUtil.setMsgResultOK(oResponse, "イメージ権限更新");
            }
            else {
                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "イメージ権限更新");
            }
        } catch (Exception e) {

            iwfCoreDomManager.clear();

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "イメージ権限更新");
        }
        return oResponse;
    }

    private int _setAuthSyorui(final String psImageAuthId, final String[] psTorikomiSyoruiCds)
        throws Exception {

        List<WT_KengenSyorui> oAuthList = iwfCoreDomManager.getKengenSyoruisByRoleCd(psImageAuthId);

        WT_KengenSyorui oRecord = new WT_KengenSyorui();

        iwfCoreDomManager.delete(oAuthList);

        String sTorikomiSyoruiCd = null;

        for (int iCnt = 0; iCnt < psTorikomiSyoruiCds.length; iCnt++) {

            sTorikomiSyoruiCd = psTorikomiSyoruiCds[iCnt];

            if (StringUtils.isNotEmpty(sTorikomiSyoruiCd)) {

                oRecord = new WT_KengenSyorui();
                oRecord.setRoleCd(psImageAuthId);
                oRecord.setTorikomiSyoruiCd(sTorikomiSyoruiCd);
                oRecord.setKousinTime(IwfDateUtils.getSysDate());

                iwfCoreDomManager.insert(oRecord);

            }
            else {
                return iUPD_NG;
            }
        }

        if(LOGGER.isDebugEnabled()){
            List<WT_KengenSyorui> oList = iwfCoreDomManager.getAllKengenSyorui();
            for (WT_KengenSyorui oAuth : oList) {
                LOGGER.debug(Objects.toStringHelper(this)
                    .add("AuthId"   , oAuth.getRoleCd())
                    .add("SyoruiCd" , oAuth.getTorikomiSyoruiCd())
                    .add("Time"     , oAuth.getKousinTime())
                    .toString());
            }
        }

        return iUPD_OK;
    }


    public WSUpdImageAuthorityResponse getBootErrResponse() {
        WSUpdImageAuthorityResponse res = new WSUpdImageAuthorityResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}
