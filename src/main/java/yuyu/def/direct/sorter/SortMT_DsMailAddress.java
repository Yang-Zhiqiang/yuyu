package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.meta.QMT_DsMailAddress;
import yuyu.def.direct.comparator.OrderMT_DsMailAddress;

public class SortMT_DsMailAddress {

    public List<MT_DsMailAddress> OrderMT_DsMailAddressByPkAsc(List<MT_DsMailAddress> pEntity) {
        List<SortCondition<MT_DsMailAddress>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailAddress()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsMailAddress()).dsmailaddressrenban, SortOrder.ASC));
        List<MT_DsMailAddress> copyList = new ArrayList<MT_DsMailAddress>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailAddress(orders));
        return copyList;
    }

    public List<MT_DsMailAddress> OrderMT_DsMailAddressByPkDesc(List<MT_DsMailAddress> pEntity) {
        List<SortCondition<MT_DsMailAddress>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailAddress()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsMailAddress()).dsmailaddressrenban, SortOrder.DESC));
        List<MT_DsMailAddress> copyList = new ArrayList<MT_DsMailAddress>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailAddress(orders));
        return copyList;
    }
}
