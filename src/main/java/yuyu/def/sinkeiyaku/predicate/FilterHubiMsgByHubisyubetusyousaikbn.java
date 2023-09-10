package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.db.entity.HT_HubiMsg;

import com.google.common.base.Predicate;

/**
 * 不備メッセージテーブル用 Predicate<br/>
 * 不備種別詳細区分（一致）
 */
public class FilterHubiMsgByHubisyubetusyousaikbn implements Predicate<HT_HubiMsg> {

    C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn;

    public FilterHubiMsgByHubisyubetusyousaikbn(C_HubisyubetusyousaiKbn pHubisyubetusyousaikbn) {
        super();
        hubisyubetusyousaiKbn = pHubisyubetusyousaikbn;
    }

    @Override
    public boolean apply(HT_HubiMsg pHubiMsg) {

        if(hubisyubetusyousaiKbn.eq(pHubiMsg.getHubisyubetusyousaikbn())){

            return true;
        }

        return false;
    }

}

