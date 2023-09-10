package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.meta.QHT_RuleHanteiMsg;
import yuyu.def.sinkeiyaku.comparator.OrderHT_RuleHanteiMsg;

public class SortHT_RuleHanteiMsg {

    
    public List<HT_RuleHanteiMsg> OrderHT_RuleHanteiMsgByPkAsc(List<HT_RuleHanteiMsg> pEntity) {
        List<SortCondition<HT_RuleHanteiMsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_RuleHanteiMsg()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_RuleHanteiMsg()).rulehanteimsg, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_RuleHanteiMsg()).renno, SortOrder.ASC));
        List<HT_RuleHanteiMsg> copyList = new ArrayList<HT_RuleHanteiMsg>(pEntity);
        Collections.sort(copyList, new OrderHT_RuleHanteiMsg(orders));
        return copyList;
    }

    
    public List<HT_RuleHanteiMsg> OrderHT_RuleHanteiMsgByPkDesc(List<HT_RuleHanteiMsg> pEntity) {
        List<SortCondition<HT_RuleHanteiMsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_RuleHanteiMsg()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_RuleHanteiMsg()).rulehanteimsg, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_RuleHanteiMsg()).renno, SortOrder.DESC));
        List<HT_RuleHanteiMsg> copyList = new ArrayList<HT_RuleHanteiMsg>(pEntity);
        Collections.sort(copyList, new OrderHT_RuleHanteiMsg(orders));
        return copyList;
    }

}

