package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_Nyknmeisai;
import yuyu.def.db.entity.BT_Nyknmeisai;
import yuyu.def.db.meta.QBT_Nyknmeisai;

public class SortBT_Nyknmeisai {

    public List<BT_Nyknmeisai> OrderBT_NyknmeisaiByPkAsc(List<BT_Nyknmeisai> pEntity) {
        List<SortCondition<BT_Nyknmeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmsakuseiymd6keta, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmbankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmshitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmyokinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmkouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmsyoukaino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmrenno8, SortOrder.ASC));
        List<BT_Nyknmeisai> copyList = new ArrayList<BT_Nyknmeisai>(pEntity);
        Collections.sort(copyList, new OrderBT_Nyknmeisai(orders));
        return copyList;
    }

    public List<BT_Nyknmeisai> OrderBT_NyknmeisaiByPkDesc(List<BT_Nyknmeisai> pEntity) {
        List<SortCondition<BT_Nyknmeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmsakuseiymd6keta, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmbankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmshitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmyokinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmkouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmsyoukaino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Nyknmeisai()).hrkmrenno8, SortOrder.DESC));
        List<BT_Nyknmeisai> copyList = new ArrayList<BT_Nyknmeisai>(pEntity);
        Collections.sort(copyList, new OrderBT_Nyknmeisai(orders));
        return copyList;
    }
}
