package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.def.db.meta.QMT_DsMailHaisinYoyaku;
import yuyu.def.direct.comparator.OrderMT_DsMailHaisinYoyaku;

public class SortMT_DsMailHaisinYoyaku {

    public List<MT_DsMailHaisinYoyaku> OrderMT_DsMailHaisinYoyakuByPkAsc(List<MT_DsMailHaisinYoyaku> pEntity) {
        List<SortCondition<MT_DsMailHaisinYoyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailHaisinYoyaku()).dsmailhaisinyoyakuskbtkey, SortOrder.ASC));
        List<MT_DsMailHaisinYoyaku> copyList = new ArrayList<MT_DsMailHaisinYoyaku>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailHaisinYoyaku(orders));
        return copyList;
    }

    public List<MT_DsMailHaisinYoyaku> OrderMT_DsMailHaisinYoyakuByPkDesc(List<MT_DsMailHaisinYoyaku> pEntity) {
        List<SortCondition<MT_DsMailHaisinYoyaku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailHaisinYoyaku()).dsmailhaisinyoyakuskbtkey, SortOrder.DESC));
        List<MT_DsMailHaisinYoyaku> copyList = new ArrayList<MT_DsMailHaisinYoyaku>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailHaisinYoyaku(orders));
        return copyList;
    }
}
