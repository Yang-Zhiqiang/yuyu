package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_Gknyknmeisai;
import yuyu.def.db.entity.BT_Gknyknmeisai;
import yuyu.def.db.meta.QBT_Gknyknmeisai;

public class SortBT_Gknyknmeisai {

    public List<BT_Gknyknmeisai> OrderBT_GknyknmeisaiByPkAsc(List<BT_Gknyknmeisai> pEntity) {
        List<SortCondition<BT_Gknyknmeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmsakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmrenrakuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmrenrakukaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmbankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmshitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmyokinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmkouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmzndktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmsyorino1, SortOrder.ASC));
        List<BT_Gknyknmeisai> copyList = new ArrayList<BT_Gknyknmeisai>(pEntity);
        Collections.sort(copyList, new OrderBT_Gknyknmeisai(orders));
        return copyList;
    }

    public List<BT_Gknyknmeisai> OrderBT_GknyknmeisaiByPkDesc(List<BT_Gknyknmeisai> pEntity) {
        List<SortCondition<BT_Gknyknmeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmsakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmrenrakuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmrenrakukaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmbankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmshitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmyokinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmkouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmzndktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Gknyknmeisai()).hrkmsyorino1, SortOrder.DESC));
        List<BT_Gknyknmeisai> copyList = new ArrayList<BT_Gknyknmeisai>(pEntity);
        Collections.sort(copyList, new OrderBT_Gknyknmeisai(orders));
        return copyList;
    }
}
