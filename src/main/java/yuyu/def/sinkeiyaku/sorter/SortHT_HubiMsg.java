package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.meta.QHT_HubiMsg;
import yuyu.def.sinkeiyaku.comparator.OrderHT_HubiMsg;

public class SortHT_HubiMsg {

    
    public List<HT_HubiMsg> OrderHT_HubiMsgByPkAsc(List<HT_HubiMsg> pEntity) {
        List<SortCondition<HT_HubiMsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_HubiMsg()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHT_HubiMsg()).renno, SortOrder.ASC));
        List<HT_HubiMsg> copyList = new ArrayList<HT_HubiMsg>(pEntity);
        Collections.sort(copyList, new OrderHT_HubiMsg(orders));
        return copyList;
    }

    
    public List<HT_HubiMsg> OrderHT_HubiMsgByPkDesc(List<HT_HubiMsg> pEntity) {
        List<SortCondition<HT_HubiMsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHT_HubiMsg()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHT_HubiMsg()).renno, SortOrder.DESC));
        List<HT_HubiMsg> copyList = new ArrayList<HT_HubiMsg>(pEntity);
        Collections.sort(copyList, new OrderHT_HubiMsg(orders));
        return copyList;
    }

}

