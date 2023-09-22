package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_KetsrhkosKbn;

/**
 * 新契約 申込内容チェック 氏名カナ入力チェック
 */
public class CheckSimeiKana {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckSimeiKana() {
        super();
    }

    public void exec(MosnaiCheckParam pMP, String pKanaNm, String pMessage) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 氏名カナ入力チェック 開始");
        }

        if (BizUtil.isBlank(pKanaNm)) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 氏名カナ入力チェック 終了（カナ氏名：ブランク）");
            }
            return;
        }

        int kanaNmKyoyou = YuyuBizConfig.getInstance().getKanaNmKyoyou();

        if (!CheckKana.isKyokaMoji(pKanaNm)) {
            setHubiMsg.exec(C_KetsrhkosKbn.KOS_NONE,
                    makeMsg(MessageId.EBC0046, MessageId.EBC0046, pMessage), pMP);
        }
        else if(!CheckKana.isKyoyouKetaHankaku(pKanaNm, kanaNmKyoyou)) {

            setHubiMsg.exec(C_KetsrhkosKbn.KOS_NONE, makeMsg(MessageId.EBC0004,
                    MessageId.EBC0004, pMessage, String.valueOf(kanaNmKyoyou)), pMP);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 氏名カナ入力チェック 終了");
        }
    }

    private String makeMsg(String pInMessageID, String pMsgID, String pReplaceMsg) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg));

        return ret.toString();
    }

    private String makeMsg(String pInMessageID, String pMsgID,
            String pReplaceMsg1, String pReplaceMsg2) {
        StringBuffer ret = new StringBuffer();
        ret.append(pInMessageID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg1, pReplaceMsg2));
        return ret.toString();
    }

}