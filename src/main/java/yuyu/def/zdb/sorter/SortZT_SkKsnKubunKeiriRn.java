package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKsnKubunKeiriRn;
import yuyu.def.db.meta.QZT_SkKsnKubunKeiriRn;
import yuyu.def.zdb.comparator.OrderZT_SkKsnKubunKeiriRn;

public class SortZT_SkKsnKubunKeiriRn {

    
    public List<ZT_SkKsnKubunKeiriRn> OrderZT_SkKsnKubunKeiriRnByPkAsc(List<ZT_SkKsnKubunKeiriRn> pEntity) {
        List<SortCondition<ZT_SkKsnKubunKeiriRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrntorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrntorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrntaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrnkanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrnsuitoubumoncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrnkizokusegment, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrnaitesegment, SortOrder.ASC));
        List<ZT_SkKsnKubunKeiriRn> copyList = new ArrayList<ZT_SkKsnKubunKeiriRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnKubunKeiriRn(orders));
        return copyList;
    }

    
    public List<ZT_SkKsnKubunKeiriRn> OrderZT_SkKsnKubunKeiriRnByPkDesc(List<ZT_SkKsnKubunKeiriRn> pEntity) {
        List<SortCondition<ZT_SkKsnKubunKeiriRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrntorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrntorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrntaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrnkanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrnsuitoubumoncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrnkizokusegment, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKubunKeiriRn()).zrnaitesegment, SortOrder.DESC));
        List<ZT_SkKsnKubunKeiriRn> copyList = new ArrayList<ZT_SkKsnKubunKeiriRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnKubunKeiriRn(orders));
        return copyList;
    }
}
