package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyoukenTkListShRn;
import yuyu.def.db.meta.QZT_SyoukenTkListShRn;
import yuyu.def.zdb.comparator.OrderZT_SyoukenTkListShRn;

public class SortZT_SyoukenTkListShRn {

    
    public List<ZT_SyoukenTkListShRn> OrderZT_SyoukenTkListShRnByPkAsc(List<ZT_SyoukenTkListShRn> pEntity) {
        List<SortCondition<ZT_SyoukenTkListShRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoukenTkListShRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyoukenTkListShRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SyoukenTkListShRn> copyList = new ArrayList<ZT_SyoukenTkListShRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoukenTkListShRn(orders));
        return copyList;
    }

    
    public List<ZT_SyoukenTkListShRn> OrderZT_SyoukenTkListShRnByPkDesc(List<ZT_SyoukenTkListShRn> pEntity) {
        List<SortCondition<ZT_SyoukenTkListShRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoukenTkListShRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyoukenTkListShRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SyoukenTkListShRn> copyList = new ArrayList<ZT_SyoukenTkListShRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoukenTkListShRn(orders));
        return copyList;
    }
}
