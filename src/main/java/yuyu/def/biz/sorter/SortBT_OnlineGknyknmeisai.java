package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_OnlineGknyknmeisai;
import yuyu.def.db.entity.BT_OnlineGknyknmeisai;
import yuyu.def.db.meta.QBT_OnlineGknyknmeisai;

public class SortBT_OnlineGknyknmeisai {

    public List<BT_OnlineGknyknmeisai> OrderBT_OnlineGknyknmeisaiByPkAsc(List<BT_OnlineGknyknmeisai> pEntity) {
        List<SortCondition<BT_OnlineGknyknmeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmsakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmrenrakuymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmrenrakukaisuu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmbankcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmshitencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmyokinkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmkouzano, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmzndktuukasyu, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmsyorino1, SortOrder.ASC));
        List<BT_OnlineGknyknmeisai> copyList = new ArrayList<BT_OnlineGknyknmeisai>(pEntity);
        Collections.sort(copyList, new OrderBT_OnlineGknyknmeisai(orders));
        return copyList;
    }

    public List<BT_OnlineGknyknmeisai> OrderBT_OnlineGknyknmeisaiByPkDesc(List<BT_OnlineGknyknmeisai> pEntity) {
        List<SortCondition<BT_OnlineGknyknmeisai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmsakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmrenrakuymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmrenrakukaisuu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmbankcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmshitencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmyokinkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmkouzano, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmzndktuukasyu, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_OnlineGknyknmeisai()).hrkmsyorino1, SortOrder.DESC));
        List<BT_OnlineGknyknmeisai> copyList = new ArrayList<BT_OnlineGknyknmeisai>(pEntity);
        Collections.sort(copyList, new OrderBT_OnlineGknyknmeisai(orders));
        return copyList;
    }
}
