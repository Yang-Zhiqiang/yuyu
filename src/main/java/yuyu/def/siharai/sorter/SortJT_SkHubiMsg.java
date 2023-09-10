package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SkHubiMsg;
import yuyu.def.db.meta.QJT_SkHubiMsg;
import yuyu.def.siharai.comparator.OrderJT_SkHubiMsg;

public class SortJT_SkHubiMsg {

    
    public List<JT_SkHubiMsg> OrderJT_SkHubiMsgByPkAsc(List<JT_SkHubiMsg> pEntity) {
        List<SortCondition<JT_SkHubiMsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkHubiMsg()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkHubiMsg()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkHubiMsg()).seikyuurirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkHubiMsg()).renno3keta, SortOrder.ASC));
        List<JT_SkHubiMsg> copyList = new ArrayList<JT_SkHubiMsg>(pEntity);
        Collections.sort(copyList, new OrderJT_SkHubiMsg(orders));
        return copyList;
    }

    
    public List<JT_SkHubiMsg> OrderJT_SkHubiMsgByPkDesc(List<JT_SkHubiMsg> pEntity) {
        List<SortCondition<JT_SkHubiMsg>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkHubiMsg()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkHubiMsg()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkHubiMsg()).seikyuurirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkHubiMsg()).renno3keta, SortOrder.DESC));
        List<JT_SkHubiMsg> copyList = new ArrayList<JT_SkHubiMsg>(pEntity);
        Collections.sort(copyList, new OrderJT_SkHubiMsg(orders));
        return copyList;
    }

}

