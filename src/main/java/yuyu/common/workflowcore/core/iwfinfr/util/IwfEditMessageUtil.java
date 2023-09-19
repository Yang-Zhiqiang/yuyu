package yuyu.common.workflowcore.core.iwfinfr.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;
import yuyu.def.classification.C_ResultCdKbn;

/**
 * メッセージ編集クラス<br />
 * ※ワークフローで使用するメッセージ編集機能を提供する<br />
 */
public class IwfEditMessageUtil {

    private static final String sResultCd_OK_ = C_ResultCdKbn.OK.toString();
    private static final String sResultCd_WARN_  = C_ResultCdKbn.WARN.toString();
    private static final String sResultCd_NG_ = C_ResultCdKbn.NG.toString();


    public static void setMsgResultOK(WSCommonResponse poWSResponse, String ... poIwfMsgParam){
        setMsgResult(sResultCd_OK_, poWSResponse, IwfMessageCd.IWF0000, poIwfMsgParam);
    }

    public static void setMsgResultWARN(WSCommonResponse poWSResponse, IwfMessageCd poIwfMsgCd, String ... poIwfMsgParam){
        setMsgResult(sResultCd_WARN_, poWSResponse, poIwfMsgCd, poIwfMsgParam);
    }

    public static void setMsgResultNG(WSCommonResponse poWSResponse, IwfMessageCd poIwfMsgCd, String ... poIwfMsgParam){
        setMsgResult(sResultCd_NG_, poWSResponse, poIwfMsgCd, poIwfMsgParam);
    }

    public static void setMultiValidationMsgResultNG(WSCommonResponse poWSResponse, IwfMessageCd poIwfMsgCd, String... poIwfMsgParam) {
        setValidationMsgsResult(sResultCd_NG_, poWSResponse, poIwfMsgCd, poIwfMsgParam);
    }

    public static void setMsgResultNG_RecordNotFound(WSCommonResponse poWSResponse, String psTableName){
        setMsgResult(sResultCd_NG_, poWSResponse, IwfMessageCd.IWF9004, psTableName);
    }

    public static void setMsgResultNG_ItemNoValue(WSCommonResponse poWSResponse, String psTableName, String psItemName){
        setMsgResult(sResultCd_NG_, poWSResponse, IwfMessageCd.IWF9005, psTableName, psItemName);
    }

    public static void setMsgResult(C_ResultCdKbn poC_ResultCd, WSCommonResponse poWSResponse, IwfMessageCd poIwfMsgCd, String ... poIwfMsgParam){
        setMsgResult(poC_ResultCd.toString(), poWSResponse, poIwfMsgCd, poIwfMsgParam);
    }


    private static void setMsgResult(String psC_ResultCd, WSCommonResponse poWSResponse, IwfMessageCd poIwfMsgCd, String ... poIwfMsgParam){
        poWSResponse.setKekkastatus(psC_ResultCd);
        poWSResponse.setSyousaimsgcd(poIwfMsgCd.toString());
        poWSResponse.setSyousaimsg(IwfMessageUtil.getMessage(poIwfMsgCd, poIwfMsgParam));
    }

    @SuppressWarnings("unchecked")
    private static void setValidationMsgsResult(String psC_ResultCd, WSCommonResponse poWSResponse, IwfMessageCd poIwfMsgCd, String... poIwfMsgParam) {

        List<Map<String, String>> msgMapList = (null == poWSResponse.getValidationErrMsgs()) ? new ArrayList<Map<String, String>>()
                : new ArrayList<>(Arrays.asList(poWSResponse.getValidationErrMsgs()));


        Map<String, String> msgMap = new HashMap<String, String>();

        String msgCd = poIwfMsgCd.toString();

        String msgNaiyo = IwfMessageUtil.getMessage(poIwfMsgCd, poIwfMsgParam);


        boolean isHasAdded = false;
        String message = "";

        List<Map<String, String>> tmpMapList = msgMapList;
        for (Map<String, String> tmpMap : tmpMapList) {
            if (StringUtils.isNotEmpty(tmpMap.get(msgCd))) {
                isHasAdded = true;
                message = tmpMap.get(msgCd);
                msgMapList.remove(tmpMap);
                break;
            }
        }

        if (isHasAdded) {
            msgMap.put(msgCd, message + "|" + msgNaiyo);
        } else {
            msgMap.put(msgCd, msgNaiyo);
        }


        msgMapList.add(msgMap);

        poWSResponse.setKekkastatus(psC_ResultCd);
        poWSResponse.setValidationErrMsgs(msgMapList.toArray(new Map[] {}));
    }
}
