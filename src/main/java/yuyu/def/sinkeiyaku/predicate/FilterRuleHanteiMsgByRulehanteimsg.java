package yuyu.def.sinkeiyaku.predicate;

import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.db.entity.HT_RuleHanteiMsg;

import com.google.common.base.Predicate;

/**
 * ルール判定結果メッセージテーブル用 Predicate<br/>
 * ルール判定結果メッセージ区分（一致）
 */
public class FilterRuleHanteiMsgByRulehanteimsg implements Predicate<HT_RuleHanteiMsg> {

    C_Rulehanteimsg rulehanteimsg;

    public FilterRuleHanteiMsgByRulehanteimsg(C_Rulehanteimsg pRulehanteimsg) {
        super();
        rulehanteimsg = pRulehanteimsg;
    }

    @Override
    public boolean apply(HT_RuleHanteiMsg ruleHanteiMsg) {
        if (rulehanteimsg.eq(ruleHanteiMsg.getRulehanteimsg())) {
            return true;
        }
        return false;
    }

}
