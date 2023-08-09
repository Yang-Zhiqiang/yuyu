package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_HnsyScrMeigiRn;
import yuyu.def.db.meta.QZT_HnsyScrMeigiRn;
import yuyu.def.zdb.comparator.OrderZT_HnsyScrMeigiRn;

public class SortZT_HnsyScrMeigiRn {

    
    public List<ZT_HnsyScrMeigiRn> OrderZT_HnsyScrMeigiRnByPkAsc(List<ZT_HnsyScrMeigiRn> pEntity) {
        List<SortCondition<ZT_HnsyScrMeigiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrntaisyounmkn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrntaisyounmkj, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrntaisyouseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrnnayosetaisyousegkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrnsyono, SortOrder.ASC));
        List<ZT_HnsyScrMeigiRn> copyList = new ArrayList<ZT_HnsyScrMeigiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HnsyScrMeigiRn(orders));
        return copyList;
    }

    
    public List<ZT_HnsyScrMeigiRn> OrderZT_HnsyScrMeigiRnByPkDesc(List<ZT_HnsyScrMeigiRn> pEntity) {
        List<SortCondition<ZT_HnsyScrMeigiRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrntaisyounmkn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrntaisyounmkj, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrntaisyouseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrnnayosetaisyousegkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_HnsyScrMeigiRn()).zrnsyono, SortOrder.DESC));
        List<ZT_HnsyScrMeigiRn> copyList = new ArrayList<ZT_HnsyScrMeigiRn>(pEntity);
        Collections.sort(copyList, new OrderZT_HnsyScrMeigiRn(orders));
        return copyList;
    }
}
