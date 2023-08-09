package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KessanYokukiPRn;
import yuyu.def.db.meta.QZT_KessanYokukiPRn;
import yuyu.def.zdb.comparator.OrderZT_KessanYokukiPRn;

public class SortZT_KessanYokukiPRn {

    
    public List<ZT_KessanYokukiPRn> OrderZT_KessanYokukiPRnByPkAsc(List<ZT_KessanYokukiPRn> pEntity) {
        List<SortCondition<ZT_KessanYokukiPRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KessanYokukiPRn()).zrnkeijyouym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KessanYokukiPRn()).zrnsyono, SortOrder.ASC));
        List<ZT_KessanYokukiPRn> copyList = new ArrayList<ZT_KessanYokukiPRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KessanYokukiPRn(orders));
        return copyList;
    }

    
    public List<ZT_KessanYokukiPRn> OrderZT_KessanYokukiPRnByPkDesc(List<ZT_KessanYokukiPRn> pEntity) {
        List<SortCondition<ZT_KessanYokukiPRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KessanYokukiPRn()).zrnkeijyouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KessanYokukiPRn()).zrnsyono, SortOrder.DESC));
        List<ZT_KessanYokukiPRn> copyList = new ArrayList<ZT_KessanYokukiPRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KessanYokukiPRn(orders));
        return copyList;
    }
}
