package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import yuyu.def.db.meta.QMW_DsMailHaisinRirekiWk;
import yuyu.def.direct.comparator.OrderMW_DsMailHaisinRirekiWk;

public class SortMW_DsMailHaisinRirekiWk {

    public List<MW_DsMailHaisinRirekiWk> OrderMW_DsMailHaisinRirekiWkByPkAsc(List<MW_DsMailHaisinRirekiWk> pEntity) {
        List<SortCondition<MW_DsMailHaisinRirekiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMW_DsMailHaisinRirekiWk()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMW_DsMailHaisinRirekiWk()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMW_DsMailHaisinRirekiWk()).dsmailhaisinrenban, SortOrder.ASC));
        List<MW_DsMailHaisinRirekiWk> copyList = new ArrayList<MW_DsMailHaisinRirekiWk>(pEntity);
        Collections.sort(copyList, new OrderMW_DsMailHaisinRirekiWk(orders));
        return copyList;
    }

    public List<MW_DsMailHaisinRirekiWk> OrderMW_DsMailHaisinRirekiWkByPkDesc(List<MW_DsMailHaisinRirekiWk> pEntity) {
        List<SortCondition<MW_DsMailHaisinRirekiWk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMW_DsMailHaisinRirekiWk()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMW_DsMailHaisinRirekiWk()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMW_DsMailHaisinRirekiWk()).dsmailhaisinrenban, SortOrder.DESC));
        List<MW_DsMailHaisinRirekiWk> copyList = new ArrayList<MW_DsMailHaisinRirekiWk>(pEntity);
        Collections.sort(copyList, new OrderMW_DsMailHaisinRirekiWk(orders));
        return copyList;
    }
}
