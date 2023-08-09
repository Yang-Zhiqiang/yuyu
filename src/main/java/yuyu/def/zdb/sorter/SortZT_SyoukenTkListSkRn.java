package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyoukenTkListSkRn;
import yuyu.def.db.meta.QZT_SyoukenTkListSkRn;
import yuyu.def.zdb.comparator.OrderZT_SyoukenTkListSkRn;

public class SortZT_SyoukenTkListSkRn {

    
    public List<ZT_SyoukenTkListSkRn> OrderZT_SyoukenTkListSkRnByPkAsc(List<ZT_SyoukenTkListSkRn> pEntity) {
        List<SortCondition<ZT_SyoukenTkListSkRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoukenTkListSkRn()).zrntyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyoukenTkListSkRn()).zrnsyono, SortOrder.ASC));
        List<ZT_SyoukenTkListSkRn> copyList = new ArrayList<ZT_SyoukenTkListSkRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoukenTkListSkRn(orders));
        return copyList;
    }

    
    public List<ZT_SyoukenTkListSkRn> OrderZT_SyoukenTkListSkRnByPkDesc(List<ZT_SyoukenTkListSkRn> pEntity) {
        List<SortCondition<ZT_SyoukenTkListSkRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoukenTkListSkRn()).zrntyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyoukenTkListSkRn()).zrnsyono, SortOrder.DESC));
        List<ZT_SyoukenTkListSkRn> copyList = new ArrayList<ZT_SyoukenTkListSkRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoukenTkListSkRn(orders));
        return copyList;
    }
}
