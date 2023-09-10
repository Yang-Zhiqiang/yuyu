package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_HubiMsg;

import com.google.common.base.Predicate;

/**
 * 不備メッセージテーブル用 Predicate<br/>
 * 不備メッセージ（1桁目一致）
 */
public class FilterHubiMsgByMessageId implements Predicate<HT_HubiMsg> {

    String messageId;

    public FilterHubiMsgByMessageId(String pMessageId) {
        super();
        messageId = pMessageId;
    }

    @Override
    public boolean apply(HT_HubiMsg pHubiMsg) {

        if (pHubiMsg.getMessageId() != null && pHubiMsg.getMessageId().length() >= 1
            && messageId.equals(pHubiMsg.getMessageId().substring(0, 1))) {
            return true;
        }
        return false;
    }

}
