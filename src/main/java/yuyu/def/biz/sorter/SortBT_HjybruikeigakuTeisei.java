package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_HjybruikeigakuTeisei;
import yuyu.def.db.entity.BT_HjybruikeigakuTeisei;
import yuyu.def.db.meta.QBT_HjybruikeigakuTeisei;

public class SortBT_HjybruikeigakuTeisei {

    public List<BT_HjybruikeigakuTeisei> OrderBT_HjybruikeigakuTeiseiByPkAsc(List<BT_HjybruikeigakuTeisei> pEntity) {
        List<SortCondition<BT_HjybruikeigakuTeisei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HjybruikeigakuTeisei()).hjybruigkteiseitantositucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_HjybruikeigakuTeisei()).kanjyoukmkcd, SortOrder.ASC));
        List<BT_HjybruikeigakuTeisei> copyList = new ArrayList<BT_HjybruikeigakuTeisei>(pEntity);
        Collections.sort(copyList, new OrderBT_HjybruikeigakuTeisei(orders));
        return copyList;
    }

    public List<BT_HjybruikeigakuTeisei> OrderBT_HjybruikeigakuTeiseiByPkDesc(List<BT_HjybruikeigakuTeisei> pEntity) {
        List<SortCondition<BT_HjybruikeigakuTeisei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_HjybruikeigakuTeisei()).hjybruigkteiseitantositucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_HjybruikeigakuTeisei()).kanjyoukmkcd, SortOrder.DESC));
        List<BT_HjybruikeigakuTeisei> copyList = new ArrayList<BT_HjybruikeigakuTeisei>(pEntity);
        Collections.sort(copyList, new OrderBT_HjybruikeigakuTeisei(orders));
        return copyList;
    }
}
