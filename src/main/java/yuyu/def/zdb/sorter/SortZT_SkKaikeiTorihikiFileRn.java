package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileRn;
import yuyu.def.db.meta.QZT_SkKaikeiTorihikiFileRn;
import yuyu.def.zdb.comparator.OrderZT_SkKaikeiTorihikiFileRn;

public class SortZT_SkKaikeiTorihikiFileRn {

    
    public List<ZT_SkKaikeiTorihikiFileRn> OrderZT_SkKaikeiTorihikiFileRnByPkAsc(List<ZT_SkKaikeiTorihikiFileRn> pEntity) {
        List<SortCondition<ZT_SkKaikeiTorihikiFileRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrntorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrntorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrntaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrnkanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrnsuitoubumon, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrntekiyoucd, SortOrder.ASC));
        List<ZT_SkKaikeiTorihikiFileRn> copyList = new ArrayList<ZT_SkKaikeiTorihikiFileRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKaikeiTorihikiFileRn(orders));
        return copyList;
    }

    
    public List<ZT_SkKaikeiTorihikiFileRn> OrderZT_SkKaikeiTorihikiFileRnByPkDesc(List<ZT_SkKaikeiTorihikiFileRn> pEntity) {
        List<SortCondition<ZT_SkKaikeiTorihikiFileRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrntorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrntorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrntaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrnkanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrnsuitoubumon, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SkKaikeiTorihikiFileRn()).zrntekiyoucd, SortOrder.DESC));
        List<ZT_SkKaikeiTorihikiFileRn> copyList = new ArrayList<ZT_SkKaikeiTorihikiFileRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SkKaikeiTorihikiFileRn(orders));
        return copyList;
    }
}
