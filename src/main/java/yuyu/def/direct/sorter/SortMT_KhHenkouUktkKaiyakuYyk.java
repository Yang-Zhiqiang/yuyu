package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.db.meta.QMT_KhHenkouUktkKaiyakuYyk;
import yuyu.def.direct.comparator.OrderMT_KhHenkouUktkKaiyakuYyk;

public class SortMT_KhHenkouUktkKaiyakuYyk {

    public List<MT_KhHenkouUktkKaiyakuYyk> OrderMT_KhHenkouUktkKaiyakuYykByPkAsc(List<MT_KhHenkouUktkKaiyakuYyk> pEntity) {
        List<SortCondition<MT_KhHenkouUktkKaiyakuYyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkKaiyakuYyk()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkKaiyakuYyk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkKaiyakuYyk()).hozenhenkouuktkrenno, SortOrder.ASC));
        List<MT_KhHenkouUktkKaiyakuYyk> copyList = new ArrayList<MT_KhHenkouUktkKaiyakuYyk>(pEntity);
        Collections.sort(copyList, new OrderMT_KhHenkouUktkKaiyakuYyk(orders));
        return copyList;
    }

    public List<MT_KhHenkouUktkKaiyakuYyk> OrderMT_KhHenkouUktkKaiyakuYykByPkDesc(List<MT_KhHenkouUktkKaiyakuYyk> pEntity) {
        List<SortCondition<MT_KhHenkouUktkKaiyakuYyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkKaiyakuYyk()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkKaiyakuYyk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_KhHenkouUktkKaiyakuYyk()).hozenhenkouuktkrenno, SortOrder.DESC));
        List<MT_KhHenkouUktkKaiyakuYyk> copyList = new ArrayList<MT_KhHenkouUktkKaiyakuYyk>(pEntity);
        Collections.sort(copyList, new OrderMT_KhHenkouUktkKaiyakuYyk(orders));
        return copyList;
    }
}
