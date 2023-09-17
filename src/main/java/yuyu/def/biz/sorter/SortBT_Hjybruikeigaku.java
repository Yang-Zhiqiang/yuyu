package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_Hjybruikeigaku;
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import yuyu.def.db.meta.QBT_Hjybruikeigaku;

public class SortBT_Hjybruikeigaku {

    public List<BT_Hjybruikeigaku> OrderBT_HjybruikeigakuByPkAsc(List<BT_Hjybruikeigaku> pEntity) {
        List<SortCondition<BT_Hjybruikeigaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_Hjybruikeigaku()).hjybtantositucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Hjybruikeigaku()).kanjyoukmkcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_Hjybruikeigaku()).denym, SortOrder.ASC));
        List<BT_Hjybruikeigaku> copyList = new ArrayList<BT_Hjybruikeigaku>(pEntity);
        Collections.sort(copyList, new OrderBT_Hjybruikeigaku(orders));
        return copyList;
    }

    public List<BT_Hjybruikeigaku> OrderBT_HjybruikeigakuByPkDesc(List<BT_Hjybruikeigaku> pEntity) {
        List<SortCondition<BT_Hjybruikeigaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_Hjybruikeigaku()).hjybtantositucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Hjybruikeigaku()).kanjyoukmkcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_Hjybruikeigaku()).denym, SortOrder.DESC));
        List<BT_Hjybruikeigaku> copyList = new ArrayList<BT_Hjybruikeigaku>(pEntity);
        Collections.sort(copyList, new OrderBT_Hjybruikeigaku(orders));
        return copyList;
    }

}

