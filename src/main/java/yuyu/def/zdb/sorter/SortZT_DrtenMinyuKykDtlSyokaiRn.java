package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DrtenMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_DrtenMinyuKykDtlSyokaiRn;
import yuyu.def.zdb.comparator.OrderZT_DrtenMinyuKykDtlSyokaiRn;

public class SortZT_DrtenMinyuKykDtlSyokaiRn {

    
    public List<ZT_DrtenMinyuKykDtlSyokaiRn> OrderZT_DrtenMinyuKykDtlSyokaiRnByPkAsc(List<ZT_DrtenMinyuKykDtlSyokaiRn> pEntity) {
        List<SortCondition<ZT_DrtenMinyuKykDtlSyokaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiRn()).zrnsakuseiym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiRn()).zrnbsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiRn()).zrntntusycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_DrtenMinyuKykDtlSyokaiRn> copyList = new ArrayList<ZT_DrtenMinyuKykDtlSyokaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMinyuKykDtlSyokaiRn(orders));
        return copyList;
    }

    
    public List<ZT_DrtenMinyuKykDtlSyokaiRn> OrderZT_DrtenMinyuKykDtlSyokaiRnByPkDesc(List<ZT_DrtenMinyuKykDtlSyokaiRn> pEntity) {
        List<SortCondition<ZT_DrtenMinyuKykDtlSyokaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiRn()).zrnsakuseiym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiRn()).zrnbsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiRn()).zrntntusycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DrtenMinyuKykDtlSyokaiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_DrtenMinyuKykDtlSyokaiRn> copyList = new ArrayList<ZT_DrtenMinyuKykDtlSyokaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_DrtenMinyuKykDtlSyokaiRn(orders));
        return copyList;
    }
}
