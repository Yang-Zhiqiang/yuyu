package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KubunKeiriFileRn;
import yuyu.def.db.meta.QZT_KubunKeiriFileRn;
import yuyu.def.zdb.comparator.OrderZT_KubunKeiriFileRn;

public class SortZT_KubunKeiriFileRn {

    
    public List<ZT_KubunKeiriFileRn> OrderZT_KubunKeiriFileRnByPkAsc(List<ZT_KubunKeiriFileRn> pEntity) {
        List<SortCondition<ZT_KubunKeiriFileRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrntorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrntorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrntaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrnkanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrnsuitoubumoncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrnkizokusegment, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrnaitesegment, SortOrder.ASC));
        List<ZT_KubunKeiriFileRn> copyList = new ArrayList<ZT_KubunKeiriFileRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KubunKeiriFileRn(orders));
        return copyList;
    }

    
    public List<ZT_KubunKeiriFileRn> OrderZT_KubunKeiriFileRnByPkDesc(List<ZT_KubunKeiriFileRn> pEntity) {
        List<SortCondition<ZT_KubunKeiriFileRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrntorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrntorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrntaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrnkanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrnsuitoubumoncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrnkizokusegment, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KubunKeiriFileRn()).zrnaitesegment, SortOrder.DESC));
        List<ZT_KubunKeiriFileRn> copyList = new ArrayList<ZT_KubunKeiriFileRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KubunKeiriFileRn(orders));
        return copyList;
    }
}
