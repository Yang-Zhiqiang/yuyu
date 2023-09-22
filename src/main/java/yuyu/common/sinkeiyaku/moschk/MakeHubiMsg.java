package yuyu.common.sinkeiyaku.moschk;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.report.ViewReport;

/**
 * 新契約 申込内容チェック 不備メッセージ文言作成
 *
 */
public class MakeHubiMsg {

    public static String exec(String pInMessageID, String pMsgID, String... pReplaceMsg) {

        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg));

        return ret.toString();
    }

    public static String execParam2CommaTuuka(String pInMessageId, String pMsgId, String pReplaceMsg1, BizCurrency pReplaceMsg2) {

        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageId);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgId, pReplaceMsg1, ViewReport.editCommaTuukaNoSpace(pReplaceMsg2, BizUtil.ZERO_FILL)));

        return ret.toString();
    }

    public static String execParam1CommaTuuka(String pInMessageId, String pMsgId, BizCurrency pReplaceMsg1, String pReplaceMsg2) {

        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageId);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgId, ViewReport.editCommaTuukaNoSpace(pReplaceMsg1, BizUtil.ZERO_FILL), pReplaceMsg2));
        return ret.toString();
    }

}
