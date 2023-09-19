package yuyu.common.workflowcore.core.iwfinfr.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import yuyu.common.workflowcore.core.iwfinfr.util.item.EIwfItemInfo;
import yuyu.common.workflowcore.core.webservice.common.WSCommonResponse;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.def.classification.C_TeisiKbn;


/**
 * バリデーションユーティリティ<br />
 * ※ワークフローで扱うバリデーションチェック処理を共通化することを目的に作成したクラス<br />
 */
public class IwfValidateUtil {

    private IwfValidateUtil() {
    }

    private static final String sSystemEncode_ = System.getProperty("file.encoding");
    private static final int EXT_PARAM_MAX = 30;

    public static boolean isErrorRequire(EIwfItemInfo poChkId,
        String psChkValue, WSCommonResponse poWSResponse) {

        if(isErrorRequire(poChkId, psChkValue)){

            IwfEditMessageUtil.setMsgResultNG(poWSResponse,
                IwfMessageCd.IWF0002, poChkId.getItemName());
            return true;
        }

        return false;
    }

    public static boolean isErrorMaxByteLength(EIwfItemInfo poChkId,
        String psChkValue, WSCommonResponse poWSResponse) {

        try {
            if (isErrorMaxByteLength(poChkId, psChkValue)) {

                IwfEditMessageUtil
                .setMsgResultNG(poWSResponse, IwfMessageCd.IWF9003,
                    poChkId.getItemName(), String.valueOf(poChkId
                        .getMaxByteLength()),
                        String.valueOf(psChkValue
                            .getBytes(sSystemEncode_).length));
                return true;
            }
        } catch (UnsupportedEncodingException e) {

            IwfEditMessageUtil
            .setMsgResultNG(poWSResponse, IwfMessageCd.IWF9006,
                poChkId.getItemName(), sSystemEncode_);
            return true;
        }

        return false;
    }

    public static boolean isErrorInt(EIwfItemInfo poChkId,
        String psChkValue, WSCommonResponse poWSResponse) {

        try {

            Integer.parseInt(psChkValue);


        } catch (NumberFormatException e) {


            IwfEditMessageUtil.setMsgResultNG(poWSResponse,
                IwfMessageCd.IWF9007, poChkId.getItemName());
            return true;
        }

        return false;
    }

    public static boolean isErrorLong(EIwfItemInfo poChkId,
        String psChkValue, WSCommonResponse poWSResponse) {

        try {

            Long.parseLong(psChkValue);


        } catch (NumberFormatException e) {


            IwfEditMessageUtil.setMsgResultNG(poWSResponse,
                IwfMessageCd.IWF9007, poChkId.getItemName());
            return true;
        }

        return false;
    }

    public static boolean isErrorC_Teisi(EIwfItemInfo poChkId,
        String psChkValue, WSCommonResponse poWSResponse) {


        if (psChkValue.equals(C_TeisiKbn.NORMAL.toString())) {
            return false;
        } else if (psChkValue.equals(C_TeisiKbn.TEISI.toString())) {
            return false;
        }


        IwfEditMessageUtil.setMsgResultNG(poWSResponse,
            IwfMessageCd.IWF0006, poChkId.getItemName());
        return true;
    }


    private static boolean isErrorRequire(EIwfItemInfo poChkId, String  psChkValue){


        if(StringUtils.isBlank(psChkValue)){

            return true;
        }

        return false;
    }

    private static boolean isErrorMaxByteLength(EIwfItemInfo poChkId, String psChkValue
        ) throws UnsupportedEncodingException {

        try {
            if (poChkId.getMaxByteLength() < psChkValue.getBytes(sSystemEncode_).length) {

                return true;
            }
        } catch (UnsupportedEncodingException e) {

            throw e;
        }

        return false;
    }

    public static boolean isRequiredAndMaxLenChkOK(WSCommonResponse response, String item, String errTitle, int maxLen) {

        boolean chkResult = true;

        if (StringUtils.isEmpty(item)) {
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0002, errTitle);
            chkResult = false;
        } else if (item.length() > maxLen) {
            IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0008, errTitle, String.valueOf(maxLen));
            chkResult = false;
        }


        return chkResult;
    }

    public static boolean isMaxLenChkOK(WSCommonResponse response, String item, String errTitle, int maxLen) {

        boolean chkResult = true;

        if (StringUtils.isNotEmpty(item)) {
            if (item.length() > maxLen) {
                IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0008, errTitle, String.valueOf(maxLen));
                chkResult = false;
            }
        }


        return chkResult;
    }

    @SuppressWarnings("deprecation")
    public static boolean isExtParamsChkOk(WSCommonResponse response, Map<String, WSExtParam> extParams, int maxLen) {

        boolean chkResult = true;

        if (null == extParams) {
            return chkResult;
        }


        for (int i = 1; i <= EXT_PARAM_MAX; i++) {
            String paramNm = "extparam" + String.valueOf(i);
            if (null != extParams.get(paramNm) && null != extParams.get(paramNm).getValue()) {
                if (extParams.get(paramNm).getValue().length() > maxLen) {
                    IwfEditMessageUtil.setMsgResultNG(response, IwfMessageCd.IWF0008, "拡張パラメータ " + String.valueOf(i),
                        String.valueOf(maxLen));
                    return false;
                }
            }
        }


        return chkResult;
    }
}
