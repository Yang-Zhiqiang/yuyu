package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SiharaiTyousyoRn;
import yuyu.def.db.meta.QZT_SiharaiTyousyoRn;
import yuyu.def.zdb.comparator.OrderZT_SiharaiTyousyoRn;

public class SortZT_SiharaiTyousyoRn {

    
    public List<ZT_SiharaiTyousyoRn> OrderZT_SiharaiTyousyoRnByPkAsc(List<ZT_SiharaiTyousyoRn> pEntity) {
        List<SortCondition<ZT_SiharaiTyousyoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SiharaiTyousyoRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_SiharaiTyousyoRn> copyList = new ArrayList<ZT_SiharaiTyousyoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SiharaiTyousyoRn(orders));
        return copyList;
    }

    
    public List<ZT_SiharaiTyousyoRn> OrderZT_SiharaiTyousyoRnByPkDesc(List<ZT_SiharaiTyousyoRn> pEntity) {
        List<SortCondition<ZT_SiharaiTyousyoRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SiharaiTyousyoRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_SiharaiTyousyoRn> copyList = new ArrayList<ZT_SiharaiTyousyoRn>(pEntity);
        Collections.sort(copyList, new OrderZT_SiharaiTyousyoRn(orders));
        return copyList;
    }
}
