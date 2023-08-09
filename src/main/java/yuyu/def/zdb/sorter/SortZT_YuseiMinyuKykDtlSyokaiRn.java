package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.db.meta.QZT_YuseiMinyuKykDtlSyokaiRn;
import yuyu.def.zdb.comparator.OrderZT_YuseiMinyuKykDtlSyokaiRn;

public class SortZT_YuseiMinyuKykDtlSyokaiRn {

    
    public List<ZT_YuseiMinyuKykDtlSyokaiRn> OrderZT_YuseiMinyuKykDtlSyokaiRnByPkAsc(List<ZT_YuseiMinyuKykDtlSyokaiRn> pEntity) {
        List<SortCondition<ZT_YuseiMinyuKykDtlSyokaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiRn()).zrnsakuseiym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiRn()).zrnbsydrtencd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiRn()).zrntntusycd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_YuseiMinyuKykDtlSyokaiRn> copyList = new ArrayList<ZT_YuseiMinyuKykDtlSyokaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_YuseiMinyuKykDtlSyokaiRn(orders));
        return copyList;
    }

    
    public List<ZT_YuseiMinyuKykDtlSyokaiRn> OrderZT_YuseiMinyuKykDtlSyokaiRnByPkDesc(List<ZT_YuseiMinyuKykDtlSyokaiRn> pEntity) {
        List<SortCondition<ZT_YuseiMinyuKykDtlSyokaiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiRn()).zrnsakuseiym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiRn()).zrnbsydrtencd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiRn()).zrntntusycd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_YuseiMinyuKykDtlSyokaiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_YuseiMinyuKykDtlSyokaiRn> copyList = new ArrayList<ZT_YuseiMinyuKykDtlSyokaiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_YuseiMinyuKykDtlSyokaiRn(orders));
        return copyList;
    }
}
