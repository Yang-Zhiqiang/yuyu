package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_KbtKarikanjyou;
import yuyu.def.db.entity.BT_KbtKarikanjyou;
import yuyu.def.db.meta.QBT_KbtKarikanjyou;

public class SortBT_KbtKarikanjyou {

    public List<BT_KbtKarikanjyou> OrderBT_KbtKarikanjyouByPkAsc(List<BT_KbtKarikanjyou> pEntity) {
        List<SortCondition<BT_KbtKarikanjyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KbtKarikanjyou()).kbtkarikanjyouskbtkey, SortOrder.ASC));
        List<BT_KbtKarikanjyou> copyList = new ArrayList<BT_KbtKarikanjyou>(pEntity);
        Collections.sort(copyList, new OrderBT_KbtKarikanjyou(orders));
        return copyList;
    }

    public List<BT_KbtKarikanjyou> OrderBT_KbtKarikanjyouByPkDesc(List<BT_KbtKarikanjyou> pEntity) {
        List<SortCondition<BT_KbtKarikanjyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KbtKarikanjyou()).kbtkarikanjyouskbtkey, SortOrder.DESC));
        List<BT_KbtKarikanjyou> copyList = new ArrayList<BT_KbtKarikanjyou>(pEntity);
        Collections.sort(copyList, new OrderBT_KbtKarikanjyou(orders));
        return copyList;
    }
}
