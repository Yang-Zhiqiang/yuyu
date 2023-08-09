package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileRn;
import yuyu.def.db.meta.QZT_KaikeiTorihikiFileRn;
import yuyu.def.zdb.comparator.OrderZT_KaikeiTorihikiFileRn;

public class SortZT_KaikeiTorihikiFileRn {

    
    public List<ZT_KaikeiTorihikiFileRn> OrderZT_KaikeiTorihikiFileRnByPkAsc(List<ZT_KaikeiTorihikiFileRn> pEntity) {
        List<SortCondition<ZT_KaikeiTorihikiFileRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrntorihikiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrntorihikinon7, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrntaisyakukbnn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrnkanjyoukamokucdn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrnsuitoubumon, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrntekiyoucd, SortOrder.ASC));
        List<ZT_KaikeiTorihikiFileRn> copyList = new ArrayList<ZT_KaikeiTorihikiFileRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KaikeiTorihikiFileRn(orders));
        return copyList;
    }

    
    public List<ZT_KaikeiTorihikiFileRn> OrderZT_KaikeiTorihikiFileRnByPkDesc(List<ZT_KaikeiTorihikiFileRn> pEntity) {
        List<SortCondition<ZT_KaikeiTorihikiFileRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrntorihikiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrntorihikinon7, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrntaisyakukbnn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrnkanjyoukamokucdn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrnsuitoubumon, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KaikeiTorihikiFileRn()).zrntekiyoucd, SortOrder.DESC));
        List<ZT_KaikeiTorihikiFileRn> copyList = new ArrayList<ZT_KaikeiTorihikiFileRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KaikeiTorihikiFileRn(orders));
        return copyList;
    }
}
