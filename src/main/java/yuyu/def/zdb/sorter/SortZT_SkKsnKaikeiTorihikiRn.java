package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKsnKaikeiTorihikiRn;
import yuyu.def.db.meta.QZT_SkKsnKaikeiTorihikiRn;
import yuyu.def.zdb.comparator.OrderZT_SkKsnKaikeiTorihikiRn;

public class SortZT_SkKsnKaikeiTorihikiRn {

    
    public List<ZT_SkKsnKaikeiTorihikiRn> OrderZT_SkKsnKaikeiTorihikiRnByPkAsc(List<ZT_SkKsnKaikeiTorihikiRn> pEntity) {
        List<SortCondition<ZT_SkKsnKaikeiTorihikiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrntorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrntorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrntaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrnkanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrnsuitoubumon, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrntekiyoucd, SortOrder.ASC));
        List<ZT_SkKsnKaikeiTorihikiRn> copyList = new ArrayList<ZT_SkKsnKaikeiTorihikiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnKaikeiTorihikiRn(orders));
        return copyList;
    }

    
    public List<ZT_SkKsnKaikeiTorihikiRn> OrderZT_SkKsnKaikeiTorihikiRnByPkDesc(List<ZT_SkKsnKaikeiTorihikiRn> pEntity) {
        List<SortCondition<ZT_SkKsnKaikeiTorihikiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrntorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrntorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrntaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrnkanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrnsuitoubumon, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKsnKaikeiTorihikiRn()).zrntekiyoucd, SortOrder.DESC));
        List<ZT_SkKsnKaikeiTorihikiRn> copyList = new ArrayList<ZT_SkKsnKaikeiTorihikiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKsnKaikeiTorihikiRn(orders));
        return copyList;
    }
}
