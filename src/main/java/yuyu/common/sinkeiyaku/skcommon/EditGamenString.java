package yuyu.common.sinkeiyaku.skcommon;
import java.util.List;

import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.db.entity.HT_RuleHanteiMsg;

/**
 * 新契約 新契約共通  画面用文字列編集
 */
public class EditGamenString {
    private static final String KAIGYOUCCODE_JAVA    = "\n";

    private static final String KIGOU_3TEN           = "…";

    private static final String SPACE_HANKAKU        = " ";

    public EditGamenString() {
        super();
    }

    public static String editStringSbstr(String pObject, int pMaxKeta) {

        String  wkMojiretu      = "";
        int     wkLength        = 0;
        if (BizUtil.isBlank(pObject)) {
            return wkMojiretu;
        }

        if (0 >= pMaxKeta) {
            return wkMojiretu;
        }
        else if ((pMaxKeta - 1) > 0) {
            wkLength = pMaxKeta - 1;
        }

        wkMojiretu = pObject;
        wkMojiretu = wkMojiretu.replaceAll(KAIGYOUCCODE_JAVA, SPACE_HANKAKU);

        if (wkMojiretu.length() > pMaxKeta) {
            wkMojiretu = wkMojiretu.substring(0, wkLength);

            wkMojiretu = wkMojiretu.concat(KIGOU_3TEN);
        }
        return wkMojiretu;
    }

    public static String editMessegeStringRule(List<HT_RuleHanteiMsg> pRuleHanteiMsgLst) {

        StringBuffer value = new StringBuffer();
        if (pRuleHanteiMsgLst == null) {
            return "";
        }

        long maxCount = 0;
        long kaigyouCount = 0;

        maxCount = pRuleHanteiMsgLst.size();
        if (maxCount > 0) {
            for (HT_RuleHanteiMsg ruleHanteiMsg : pRuleHanteiMsgLst) {
                value.append(MessageUtil.getMessage(ruleHanteiMsg.getRulehanteimsgid()));
                kaigyouCount++;
                if (kaigyouCount < maxCount) {
                    value = new StringBuffer(addKaigyouCode(value.toString()));
                }
            }
        }
        return value.toString();
    }

    public static String addKaigyouCode(String pObject) {

        StringBuffer  wkMojiretu  = new StringBuffer();
        if (BizUtil.isBlank(pObject)) {
            return "";
        }
        wkMojiretu.append(pObject);
        wkMojiretu.append(KAIGYOUCCODE_JAVA);

        return wkMojiretu.toString();
    }

}
