package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import yuyu.def.db.meta.QMT_DsTtdkRireki;
import yuyu.def.direct.comparator.OrderMT_DsTtdkRireki;

public class SortMT_DsTtdkRireki {

    public List<MT_DsTtdkRireki> OrderMT_DsTtdkRirekiByPkAsc(List<MT_DsTtdkRireki> pEntity) {
        List<SortCondition<MT_DsTtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTtdkRireki()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsTtdkRireki()).henkousikibetukey, SortOrder.ASC));
        List<MT_DsTtdkRireki> copyList = new ArrayList<MT_DsTtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTtdkRireki(orders));
        return copyList;
    }

    public List<MT_DsTtdkRireki> OrderMT_DsTtdkRirekiByPkDesc(List<MT_DsTtdkRireki> pEntity) {
        List<SortCondition<MT_DsTtdkRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTtdkRireki()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsTtdkRireki()).henkousikibetukey, SortOrder.DESC));
        List<MT_DsTtdkRireki> copyList = new ArrayList<MT_DsTtdkRireki>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTtdkRireki(orders));
        return copyList;
    }
}
