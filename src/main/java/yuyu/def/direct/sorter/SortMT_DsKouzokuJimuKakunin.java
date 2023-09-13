package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.def.db.meta.QMT_DsKouzokuJimuKakunin;
import yuyu.def.direct.comparator.OrderMT_DsKouzokuJimuKakunin;

public class SortMT_DsKouzokuJimuKakunin {

    public List<MT_DsKouzokuJimuKakunin> OrderMT_DsKouzokuJimuKakuninByPkAsc(List<MT_DsKouzokuJimuKakunin> pEntity) {
        List<SortCondition<MT_DsKouzokuJimuKakunin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsKouzokuJimuKakunin()).hasseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsKouzokuJimuKakunin()).dskzkjmkknhsjykbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsKouzokuJimuKakunin()).syono, SortOrder.ASC));
        List<MT_DsKouzokuJimuKakunin> copyList = new ArrayList<MT_DsKouzokuJimuKakunin>(pEntity);
        Collections.sort(copyList, new OrderMT_DsKouzokuJimuKakunin(orders));
        return copyList;
    }

    public List<MT_DsKouzokuJimuKakunin> OrderMT_DsKouzokuJimuKakuninByPkDesc(List<MT_DsKouzokuJimuKakunin> pEntity) {
        List<SortCondition<MT_DsKouzokuJimuKakunin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsKouzokuJimuKakunin()).hasseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsKouzokuJimuKakunin()).dskzkjmkknhsjykbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsKouzokuJimuKakunin()).syono, SortOrder.DESC));
        List<MT_DsKouzokuJimuKakunin> copyList = new ArrayList<MT_DsKouzokuJimuKakunin>(pEntity);
        Collections.sort(copyList, new OrderMT_DsKouzokuJimuKakunin(orders));
        return copyList;
    }
}
