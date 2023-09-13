package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.db.meta.QMT_KhHenkouUktkYyk;
import yuyu.def.direct.comparator.OrderMT_KhHenkouUktkYyk;

public class SortMT_KhHenkouUktkYyk {

    public List<MT_KhHenkouUktkYyk> OrderMT_KhHenkouUktkYykByPkAsc(List<MT_KhHenkouUktkYyk> pEntity) {
        List<SortCondition<MT_KhHenkouUktkYyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkYyk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkYyk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkYyk()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<MT_KhHenkouUktkYyk> copyList = new ArrayList<MT_KhHenkouUktkYyk>(pEntity);
        Collections.sort(copyList, new OrderMT_KhHenkouUktkYyk(orders));
        return copyList;
    }

    public List<MT_KhHenkouUktkYyk> OrderMT_KhHenkouUktkYykByPkDesc(List<MT_KhHenkouUktkYyk> pEntity) {
        List<SortCondition<MT_KhHenkouUktkYyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkYyk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkYyk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkYyk()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<MT_KhHenkouUktkYyk> copyList = new ArrayList<MT_KhHenkouUktkYyk>(pEntity);
        Collections.sort(copyList, new OrderMT_KhHenkouUktkYyk(orders));
        return copyList;
    }
}
