package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_BAK_DsMailAddress;
import yuyu.def.db.meta.QMT_BAK_DsMailAddress;
import yuyu.def.direct.comparator.OrderMT_BAK_DsMailAddress;

public class SortMT_BAK_DsMailAddress {

    public List<MT_BAK_DsMailAddress> OrderMT_BAK_DsMailAddressByPkAsc(List<MT_BAK_DsMailAddress> pEntity) {
        List<SortCondition<MT_BAK_DsMailAddress>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsMailAddress()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsMailAddress()).dsmailaddressrenban, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsMailAddress()).trkssikibetukey, SortOrder.ASC));
        List<MT_BAK_DsMailAddress> copyList = new ArrayList<MT_BAK_DsMailAddress>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsMailAddress(orders));
        return copyList;
    }

    public List<MT_BAK_DsMailAddress> OrderMT_BAK_DsMailAddressByPkDesc(List<MT_BAK_DsMailAddress> pEntity) {
        List<SortCondition<MT_BAK_DsMailAddress>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsMailAddress()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsMailAddress()).dsmailaddressrenban, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsMailAddress()).trkssikibetukey, SortOrder.DESC));
        List<MT_BAK_DsMailAddress> copyList = new ArrayList<MT_BAK_DsMailAddress>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsMailAddress(orders));
        return copyList;
    }
}
