package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenSkKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_DrtenSkKykDtlSyokaiRn;
import yuyu.def.zdb.comparator.OrderZT_DrtenSkKykDtlSyokaiRn;

public class SortZT_DrtenSkKykDtlSyokaiRn {

    
    public List<ZT_DrtenSkKykDtlSyokaiRn> OrderZT_DrtenSkKykDtlSyokaiRnByPkAsc(List<ZT_DrtenSkKykDtlSyokaiRn> pEntity) {
        List<SortCondition<ZT_DrtenSkKykDtlSyokaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiRn()).zrnsakuseiym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiRn()).zrnbsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiRn()).zrntntusycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_DrtenSkKykDtlSyokaiRn> copyList = new ArrayList<ZT_DrtenSkKykDtlSyokaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenSkKykDtlSyokaiRn(orders));
        return copyList;
    }

    
    public List<ZT_DrtenSkKykDtlSyokaiRn> OrderZT_DrtenSkKykDtlSyokaiRnByPkDesc(List<ZT_DrtenSkKykDtlSyokaiRn> pEntity) {
        List<SortCondition<ZT_DrtenSkKykDtlSyokaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiRn()).zrnsakuseiym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiRn()).zrnbsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiRn()).zrntntusycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenSkKykDtlSyokaiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_DrtenSkKykDtlSyokaiRn> copyList = new ArrayList<ZT_DrtenSkKykDtlSyokaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenSkKykDtlSyokaiRn(orders));
        return copyList;
    }
}
