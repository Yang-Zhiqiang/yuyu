package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KzhuriSyuunouKekkaTr;
import yuyu.def.db.meta.QZT_KzhuriSyuunouKekkaTr;
import yuyu.def.zdb.comparator.OrderZT_KzhuriSyuunouKekkaTr;

public class SortZT_KzhuriSyuunouKekkaTr {

    
    public List<ZT_KzhuriSyuunouKekkaTr> OrderZT_KzhuriSyuunouKekkaTrByPkAsc(List<ZT_KzhuriSyuunouKekkaTr> pEntity) {
        List<SortCondition<ZT_KzhuriSyuunouKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KzhuriSyuunouKekkaTr()).ztrsyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KzhuriSyuunouKekkaTr()).ztrjyuutouym, SortOrder.ASC));
        List<ZT_KzhuriSyuunouKekkaTr> copyList = new ArrayList<ZT_KzhuriSyuunouKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_KzhuriSyuunouKekkaTr(orders));
        return copyList;
    }

    
    public List<ZT_KzhuriSyuunouKekkaTr> OrderZT_KzhuriSyuunouKekkaTrByPkDesc(List<ZT_KzhuriSyuunouKekkaTr> pEntity) {
        List<SortCondition<ZT_KzhuriSyuunouKekkaTr>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KzhuriSyuunouKekkaTr()).ztrsyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KzhuriSyuunouKekkaTr()).ztrjyuutouym, SortOrder.DESC));
        List<ZT_KzhuriSyuunouKekkaTr> copyList = new ArrayList<ZT_KzhuriSyuunouKekkaTr>(pEntity);
        Collections.sort(copyList, new OrderZT_KzhuriSyuunouKekkaTr(orders));
        return copyList;
    }
}
