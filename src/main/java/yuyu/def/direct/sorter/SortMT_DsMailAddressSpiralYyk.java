package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.meta.QMT_DsMailAddressSpiralYyk;
import yuyu.def.direct.comparator.OrderMT_DsMailAddressSpiralYyk;

public class SortMT_DsMailAddressSpiralYyk {

    public List<MT_DsMailAddressSpiralYyk> OrderMT_DsMailAddressSpiralYykByPkAsc(List<MT_DsMailAddressSpiralYyk> pEntity) {
        List<SortCondition<MT_DsMailAddressSpiralYyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailAddressSpiralYyk()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsMailAddressSpiralYyk()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsMailAddressSpiralYyk()).dsmailaddressrenban, SortOrder.ASC));
        List<MT_DsMailAddressSpiralYyk> copyList = new ArrayList<MT_DsMailAddressSpiralYyk>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailAddressSpiralYyk(orders));
        return copyList;
    }

    public List<MT_DsMailAddressSpiralYyk> OrderMT_DsMailAddressSpiralYykByPkDesc(List<MT_DsMailAddressSpiralYyk> pEntity) {
        List<SortCondition<MT_DsMailAddressSpiralYyk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailAddressSpiralYyk()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsMailAddressSpiralYyk()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsMailAddressSpiralYyk()).dsmailaddressrenban, SortOrder.DESC));
        List<MT_DsMailAddressSpiralYyk> copyList = new ArrayList<MT_DsMailAddressSpiralYyk>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailAddressSpiralYyk(orders));
        return copyList;
    }
}
