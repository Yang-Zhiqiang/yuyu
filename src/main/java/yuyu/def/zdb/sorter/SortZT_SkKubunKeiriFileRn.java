package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKubunKeiriFileRn;
import yuyu.def.db.meta.QZT_SkKubunKeiriFileRn;
import yuyu.def.zdb.comparator.OrderZT_SkKubunKeiriFileRn;

public class SortZT_SkKubunKeiriFileRn {

    
    public List<ZT_SkKubunKeiriFileRn> OrderZT_SkKubunKeiriFileRnByPkAsc(List<ZT_SkKubunKeiriFileRn> pEntity) {
        List<SortCondition<ZT_SkKubunKeiriFileRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrntorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrntorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrntaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrnkanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrnsuitoubumoncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrnkizokusegment, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrnaitesegment, SortOrder.ASC));
        List<ZT_SkKubunKeiriFileRn> copyList = new ArrayList<ZT_SkKubunKeiriFileRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKubunKeiriFileRn(orders));
        return copyList;
    }

    
    public List<ZT_SkKubunKeiriFileRn> OrderZT_SkKubunKeiriFileRnByPkDesc(List<ZT_SkKubunKeiriFileRn> pEntity) {
        List<SortCondition<ZT_SkKubunKeiriFileRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrntorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrntorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrntaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrnkanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrnsuitoubumoncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrnkizokusegment, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKubunKeiriFileRn()).zrnaitesegment, SortOrder.DESC));
        List<ZT_SkKubunKeiriFileRn> copyList = new ArrayList<ZT_SkKubunKeiriFileRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKubunKeiriFileRn(orders));
        return copyList;
    }
}
