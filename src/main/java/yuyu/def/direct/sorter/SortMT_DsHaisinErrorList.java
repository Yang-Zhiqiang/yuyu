package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsHaisinErrorList;
import yuyu.def.db.meta.QMT_DsHaisinErrorList;
import yuyu.def.direct.comparator.OrderMT_DsHaisinErrorList;

public class SortMT_DsHaisinErrorList {

    public List<MT_DsHaisinErrorList> OrderMT_DsHaisinErrorListByPkAsc(List<MT_DsHaisinErrorList> pEntity) {
        List<SortCondition<MT_DsHaisinErrorList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList()).dsmailaddressrenban, SortOrder.ASC));
        List<MT_DsHaisinErrorList> copyList = new ArrayList<MT_DsHaisinErrorList>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHaisinErrorList(orders));
        return copyList;
    }

    public List<MT_DsHaisinErrorList> OrderMT_DsHaisinErrorListByPkDesc(List<MT_DsHaisinErrorList> pEntity) {
        List<SortCondition<MT_DsHaisinErrorList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList()).dsmailaddressrenban, SortOrder.DESC));
        List<MT_DsHaisinErrorList> copyList = new ArrayList<MT_DsHaisinErrorList>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHaisinErrorList(orders));
        return copyList;
    }
}
