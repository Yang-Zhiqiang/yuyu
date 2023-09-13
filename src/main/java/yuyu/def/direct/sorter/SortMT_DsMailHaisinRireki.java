package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import yuyu.def.db.meta.QMT_DsMailHaisinRireki;
import yuyu.def.direct.comparator.OrderMT_DsMailHaisinRireki;

public class SortMT_DsMailHaisinRireki {

    public List<MT_DsMailHaisinRireki> OrderMT_DsMailHaisinRirekiByPkAsc(List<MT_DsMailHaisinRireki> pEntity) {
        List<SortCondition<MT_DsMailHaisinRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailHaisinRireki()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisinRireki()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisinRireki()).dsmailhaisinrenban, SortOrder.ASC));
        List<MT_DsMailHaisinRireki> copyList = new ArrayList<MT_DsMailHaisinRireki>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailHaisinRireki(orders));
        return copyList;
    }

    public List<MT_DsMailHaisinRireki> OrderMT_DsMailHaisinRirekiByPkDesc(List<MT_DsMailHaisinRireki> pEntity) {
        List<SortCondition<MT_DsMailHaisinRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsMailHaisinRireki()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisinRireki()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsMailHaisinRireki()).dsmailhaisinrenban, SortOrder.DESC));
        List<MT_DsMailHaisinRireki> copyList = new ArrayList<MT_DsMailHaisinRireki>(pEntity);
        Collections.sort(copyList, new OrderMT_DsMailHaisinRireki(orders));
        return copyList;
    }
}
