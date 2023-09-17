package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_Hjyblist;
import yuyu.def.db.entity.BT_Hjyblist;
import yuyu.def.db.meta.QBT_Hjyblist;

public class SortBT_Hjyblist {

    public List<BT_Hjyblist> OrderBT_HjyblistByPkAsc(List<BT_Hjyblist> pEntity) {
        List<SortCondition<BT_Hjyblist>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_Hjyblist()).hjybtantositucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Hjyblist()).kanjyoukmkcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Hjyblist()).syorisyokantantcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Hjyblist()).denymd, SortOrder.ASC));
        List<BT_Hjyblist> copyList = new ArrayList<BT_Hjyblist>(pEntity);
        Collections.sort(copyList, new OrderBT_Hjyblist(orders));
        return copyList;
    }

    public List<BT_Hjyblist> OrderBT_HjyblistByPkDesc(List<BT_Hjyblist> pEntity) {
        List<SortCondition<BT_Hjyblist>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_Hjyblist()).hjybtantositucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Hjyblist()).kanjyoukmkcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Hjyblist()).syorisyokantantcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Hjyblist()).denymd, SortOrder.DESC));
        List<BT_Hjyblist> copyList = new ArrayList<BT_Hjyblist>(pEntity);
        Collections.sort(copyList, new OrderBT_Hjyblist(orders));
        return copyList;
    }

}

