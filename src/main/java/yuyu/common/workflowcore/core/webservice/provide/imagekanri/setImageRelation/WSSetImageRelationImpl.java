package yuyu.common.workflowcore.core.webservice.provide.imagekanri.setImageRelation;

import static yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd.*;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.exception.CoreRuntimeException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfValidateUtil;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_IwfSyoriKbn;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_GyoumuKey;
import yuyu.def.db.entity.WT_TorikomiKanri;
import yuyu.def.db.entity.WT_TorikomiRelation;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 *イメージ関連設定サービスのプロバイダークラスです。
 */
public class WSSetImageRelationImpl implements WSSetImageRelation {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(WSSetImageRelationImpl.class);

    public WSSetImageRelationImpl() {
        super();
    }


    public void initialize(WSSetImageRelationRequest request) throws Exception {

        LOGGER.debug("│初期化処理開始・・・");
    }

    public WSSetImageRelationResponse validate(
        WSSetImageRelationRequest request) throws Exception {

        WSSetImageRelationResponse oResponse = new WSSetImageRelationResponse();

        String sImageid = request.getImageid();
        String[] sGyoumukeys = request.getGyoumukeys();
        String sSyorikbn = request.getSyorikbn();

        if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, sImageid, "イメージＩＤ", 20)) {
            return oResponse;
        }

        if (null == sGyoumukeys || sGyoumukeys.length == 0) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "業務キー配列");
            return oResponse;
        } else {
            for (String gyoumuKey : sGyoumukeys) {
                if (!IwfValidateUtil.isRequiredAndMaxLenChkOK(oResponse, gyoumuKey, "業務キー", 20)) {
                    return oResponse;
                }
            }
        }

        if (StringUtils.isEmpty(sSyorikbn)) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0002, "処理区分");
            return oResponse;
        } else {
            try {
                C_IwfSyoriKbn syorikbn = C_IwfSyoriKbn.valueOf(sSyorikbn);
                if (C_IwfSyoriKbn.SETRELATION != syorikbn && C_IwfSyoriKbn.RELEASERELATION != syorikbn) {
                    IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0006, "処理区分");
                }
            } catch (CoreRuntimeException e) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0006, "処理区分");
            }
        }

        return oResponse;
    }

    public String getServiceName() {

        return WSSetImageRelationRequest.sSERVICE_NAME;
    }

    @Override
    @Transactional
    public WSSetImageRelationResponse executeBizMain(
        WSSetImageRelationRequest request) throws Exception {

        WSSetImageRelationResponse oResponse = new WSSetImageRelationResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sImageid = request.getImageid();
        String[] sGyoumukeys = request.getGyoumukeys();
        String sSyorikbn = request.getSyorikbn();

        try {


            List<WT_TorikomiKanri> resultTorikomikanriCheck = iwfCoreDomManager.getTorikomiKanris(sImageid);

            Iterator<WT_TorikomiKanri> itrTorikomikanriCheck = resultTorikomikanriCheck.iterator();
            if (!itrTorikomikanriCheck.hasNext()) {
                iwfCoreDomManager.clear();
                IwfEditMessageUtil.setMsgResultNG(oResponse, IWF3073);
                return oResponse;
            }

            if (sSyorikbn.equals(C_IwfSyoriKbn.SETRELATION.toString())) {
                for (String gyoumukey : sGyoumukeys) {

                    if (C_ResultCdKbn.NG.toString().equals(
                        torikomiRelationChk(sSyorikbn, sImageid, gyoumukey, oResponse).getKekkastatus())) {
                        return oResponse;
                    }

                    WT_TorikomiRelation torikomiRelation = new WT_TorikomiRelation();
                    torikomiRelation.setIwfImageId(sImageid);
                    torikomiRelation.setGyoumuKey(gyoumukey);

                    iwfCoreDomManager.insert(torikomiRelation);
                }

            } else {
                for (String gyoumukey : sGyoumukeys) {

                    if (C_ResultCdKbn.NG.toString().equals(
                        torikomiRelationChk(sSyorikbn, sImageid, gyoumukey, oResponse).getKekkastatus())) {
                        return oResponse;
                    }

                    WT_TorikomiRelation torikomiRelation = iwfCoreDomManager.getTorikomiRelation(sImageid, gyoumukey);

                    iwfCoreDomManager.delete(torikomiRelation);
                }
            }

            IwfEditMessageUtil.setMsgResultOK(oResponse, "イメージ関連設定");

        } catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "イメージ関連設定");

            iwfCoreDomManager.clear();
            LOGGER.error("想定外のエラーが発生しました。", e);
        }

        return oResponse;
    }

    private WSSetImageRelationResponse torikomiRelationChk(String syorikbn, String imageid, String gyoumukey,
        WSSetImageRelationResponse response) {
        response = this.isExistGyoumukey(gyoumukey, response);

        if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
            iwfCoreDomManager.clear();
            return response;
        } else {
            response = this.isTorikomiRelationExist(syorikbn, imageid, gyoumukey, response);
            if (C_ResultCdKbn.NG.toString().equals(response.getKekkastatus())) {
                iwfCoreDomManager.clear();
            }
        }

        return response;
    }

    private WSSetImageRelationResponse isExistGyoumukey(String gyoumukey, WSSetImageRelationResponse response) {
        List<WT_GyoumuKey> resultGyoumuCheck = iwfCoreDomManager.getGyoumuKeys(gyoumukey);

        Iterator<WT_GyoumuKey> itrGyoumuCheck = resultGyoumuCheck.iterator();
        if (!itrGyoumuCheck.hasNext()) {
            iwfCoreDomManager.clear();
            IwfEditMessageUtil.setMsgResultNG(response, IWF3074, gyoumukey);
            return response;
        }

        return response;
    }


    private WSSetImageRelationResponse isTorikomiRelationExist(String syorikbn, String imageid, String gyoumukey,
        WSSetImageRelationResponse response) {
        WT_TorikomiRelation torikomiRelation = iwfCoreDomManager.getTorikomiRelation(imageid, gyoumukey);

        if (syorikbn.equals(C_IwfSyoriKbn.SETRELATION.toString())) {
            if (null != torikomiRelation) {
                IwfEditMessageUtil.setMsgResultNG(response, IWF3075, imageid, gyoumukey);
            }
        } else {
            if (null == torikomiRelation) {
                IwfEditMessageUtil.setMsgResultNG(response, IWF3076, imageid, gyoumukey);
            }
        }

        return response;
    }

    public WSSetImageRelationResponse getStubResult(
        WSSetImageRelationRequest request) throws Exception {

        return null;
    }

    public WSSetImageRelationResponse getBootErrResponse() {
        WSSetImageRelationResponse res = new WSSetImageRelationResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

}