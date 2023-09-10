package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.db.entity.HT_HubiMsg;

import com.google.common.base.Predicate;

/**
 * 不備メッセージテーブル用 Predicate<br/>
 * 不備メッセージ（1桁目一致）
 */
public class FilterHubiMsgByHubimsg implements Predicate<HT_HubiMsg> {

    String hubiMsgs;

    public FilterHubiMsgByHubimsg(String pHubimsg) {
        super();
        hubiMsgs = pHubimsg;
    }

    @Override
    public boolean apply(HT_HubiMsg hubiMsg) {

        if (hubiMsgs.length() >= 1 && hubiMsg.getHubimsg() != null && hubiMsg.getHubimsg().length() >= 1
            && hubiMsgs.charAt(0) == hubiMsg.getHubimsg().charAt(0)) {
            return true;
        }
        return false;
    }

}
