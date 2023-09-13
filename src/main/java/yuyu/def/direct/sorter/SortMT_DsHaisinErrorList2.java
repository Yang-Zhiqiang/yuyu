package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsHaisinErrorList2;
import yuyu.def.db.meta.QMT_DsHaisinErrorList2;
import yuyu.def.direct.comparator.OrderMT_DsHaisinErrorList2;

public class SortMT_DsHaisinErrorList2 {

    public List<MT_DsHaisinErrorList2> OrderMT_DsHaisinErrorList2ByPkAsc(List<MT_DsHaisinErrorList2> pEntity) {
        List<SortCondition<MT_DsHaisinErrorList2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList2()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList2()).dsmailhaisinrenban, SortOrder.ASC));
        List<MT_DsHaisinErrorList2> copyList = new ArrayList<MT_DsHaisinErrorList2>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHaisinErrorList2(orders));
        return copyList;
    }

    public List<MT_DsHaisinErrorList2> OrderMT_DsHaisinErrorList2ByPkDesc(List<MT_DsHaisinErrorList2> pEntity) {
        List<SortCondition<MT_DsHaisinErrorList2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList2()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHaisinErrorList2()).dsmailhaisinrenban, SortOrder.DESC));
        List<MT_DsHaisinErrorList2> copyList = new ArrayList<MT_DsHaisinErrorList2>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHaisinErrorList2(orders));
        return copyList;
    }
}
