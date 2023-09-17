package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBV_HjybruikeigakuData;
import yuyu.def.db.entity.BV_HjybruikeigakuData;
import yuyu.def.db.meta.QBV_HjybruikeigakuData;

public class SortBV_HjybruikeigakuData {

    public List<BV_HjybruikeigakuData> OrderBV_HjybruikeigakuDataByPkAsc(List<BV_HjybruikeigakuData> pEntity) {
        List<SortCondition<BV_HjybruikeigakuData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBV_HjybruikeigakuData()).hjybtantositucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBV_HjybruikeigakuData()).kanjyoukmkcd, SortOrder.ASC));
        List<BV_HjybruikeigakuData> copyList = new ArrayList<BV_HjybruikeigakuData>(pEntity);
        Collections.sort(copyList, new OrderBV_HjybruikeigakuData(orders));
        return copyList;
    }

    public List<BV_HjybruikeigakuData> OrderBV_HjybruikeigakuDataByPkDesc(List<BV_HjybruikeigakuData> pEntity) {
        List<SortCondition<BV_HjybruikeigakuData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBV_HjybruikeigakuData()).hjybtantositucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBV_HjybruikeigakuData()).kanjyoukmkcd, SortOrder.DESC));
        List<BV_HjybruikeigakuData> copyList = new ArrayList<BV_HjybruikeigakuData>(pEntity);
        Collections.sort(copyList, new OrderBV_HjybruikeigakuData(orders));
        return copyList;
    }
}
