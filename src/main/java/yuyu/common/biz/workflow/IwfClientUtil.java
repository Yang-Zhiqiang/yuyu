package yuyu.common.biz.workflow;

import java.security.InvalidParameterException;
import java.util.List;

import jp.co.slcs.swak.core.exception.ExNullArgumentException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.uniquekey.UniqueKeyGenerator;
import jp.co.slcs.swak.util.bean.BeanUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.webservice.common.WSCommonRequest;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;

import com.google.common.base.Strings;

/**
 * イメージワークフロークライアントのユーティリティクラスです。</ br>
 */
public class IwfClientUtil {

    static UniqueKeyGenerator uniqueKey = SWAKInjector.getInstance(UniqueKeyGenerator.class);

    private static Logger oLogger = LoggerFactory.getLogger(IwfClientUtil.class);

    public static  void validateInBean(WSCommonRequest wrapperRequest, String className) {
        if(null == wrapperRequest){
            throw new ExNullArgumentException(className);
        }
    }

    public static void setCommonRequestParams(WSCommonRequest wrapperRequest, WSCommonRequest serviceRequest) {

        outputIwfBeginLog(wrapperRequest);
        convertRequestParams(wrapperRequest, serviceRequest);

    }

    @SuppressWarnings("deprecation")
    public static void convertRequestParams(WSCommonRequest wrapperRequest, WSCommonRequest serviceRequest) {

        serviceRequest.setExtParam1(wrapperRequest.getExtParam1());
        serviceRequest.setExtParam2(wrapperRequest.getExtParam2());
        serviceRequest.setExtParam3(wrapperRequest.getExtParam3());
        serviceRequest.setExtParam4(wrapperRequest.getExtParam4());
        serviceRequest.setExtParam5(wrapperRequest.getExtParam5());
        serviceRequest.setExtParam6(wrapperRequest.getExtParam6());
        serviceRequest.setExtParam7(wrapperRequest.getExtParam7());
        serviceRequest.setExtParam8(wrapperRequest.getExtParam8());
        serviceRequest.setExtParam9(wrapperRequest.getExtParam9());
        serviceRequest.setExtParam10(wrapperRequest.getExtParam10());
        serviceRequest.setExtParam11(wrapperRequest.getExtParam11());
        serviceRequest.setExtParam12(wrapperRequest.getExtParam12());
        serviceRequest.setExtParam13(wrapperRequest.getExtParam13());
        serviceRequest.setExtParam14(wrapperRequest.getExtParam14());
        serviceRequest.setExtParam15(wrapperRequest.getExtParam15());
        serviceRequest.setExtParam16(wrapperRequest.getExtParam16());
        serviceRequest.setExtParam17(wrapperRequest.getExtParam17());
        serviceRequest.setExtParam18(wrapperRequest.getExtParam18());
        serviceRequest.setExtParam19(wrapperRequest.getExtParam19());
        serviceRequest.setExtParam20(wrapperRequest.getExtParam20());
        serviceRequest.setExtParam21(wrapperRequest.getExtParam21());
        serviceRequest.setExtParam22(wrapperRequest.getExtParam22());
        serviceRequest.setExtParam23(wrapperRequest.getExtParam23());
        serviceRequest.setExtParam24(wrapperRequest.getExtParam24());
        serviceRequest.setExtParam25(wrapperRequest.getExtParam25());
        serviceRequest.setExtParam26(wrapperRequest.getExtParam26());
        serviceRequest.setExtParam27(wrapperRequest.getExtParam27());
        serviceRequest.setExtParam28(wrapperRequest.getExtParam28());
        serviceRequest.setExtParam29(wrapperRequest.getExtParam29());
        serviceRequest.setExtParam30(wrapperRequest.getExtParam30());

        serviceRequest.setRequestid(uniqueKey.generateUniqueKey());
    }

    public static void setCommonResponseParams(WSCommonResponse serviceResponse, WSCommonResponse wrapperResponse) {

        outputIwfEndLog(serviceResponse);

        wrapperResponse.setKekkastatus(serviceResponse.getKekkastatus());
        wrapperResponse.setSyousaimsgcd(serviceResponse.getSyousaimsgcd());
        wrapperResponse.setSyousaimsg(serviceResponse.getSyousaimsg());
    }

    public static String createAuthid(String...sKengenKeys){

        return StringUtils.join(sKengenKeys, ".");
    }

    public static String getTaskName(String pKinouId, String pKinouMode) {
        if(StringUtils.isEmpty(pKinouId)){
            throw new InvalidParameterException("機能IDがnullもしくは空文字です。");
        }
        if(StringUtils.isEmpty(pKinouMode)){
            return pKinouId;
        }

        return pKinouId + "-" + pKinouMode;
    }

    public static String getKinouId(String pTaskName) {
        if(StringUtils.isEmpty(pTaskName)){
            throw new InvalidParameterException("タスク名がnullもしくは空文字です。");
        }
        return pTaskName.split("-")[0];
    }

    public static String getKinouMode(String pTaskName) {
        if(StringUtils.isEmpty(pTaskName)){
            throw new InvalidParameterException("タスク名がnullもしくは空文字です。");
        }
        if(!pTaskName.contains("-")){
            return null;
        }
        String[] splitTaskName = pTaskName.split("-");
        if(splitTaskName.length > 1) {
            return splitTaskName[1];
        }
        return null;
    }

    public static void outputIwfBeginLog(WSCommonRequest pRequest){
        oLogger.debug("▼▼ IWFAPIを実行します。" + pRequest.getClass().getSimpleName() + BeanUtil.toString(pRequest));
    }

    public static void outputIwfEndLog(WSCommonResponse pResponse){
        oLogger.debug("▲▲ IWFAPIを終了します。" + pResponse.getClass().getSimpleName() + BeanUtil.toString(pResponse));
    }

    public static void outputIwfBeginLogList(List<? extends WSCommonRequest> pRequest){
        int index = 1;
        int length = 0;
        oLogger.debug("▼▼ IWFAPIを実行します。");
        if (pRequest != null) {
            length = String.valueOf(pRequest.size()).length();
            for (WSCommonRequest request : pRequest) {
                oLogger.debug("|   実行パラメータ[" + Strings.padStart(String.valueOf(index++), length, '0') + "]" + request.getClass().getSimpleName() + BeanUtil.toString(request));
            }
        } else {
            oLogger.debug("|   実行パラメータ: null");
        }

    }

}

