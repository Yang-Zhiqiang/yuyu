package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyoukenTkListSkTy;
import yuyu.def.db.meta.QZT_SyoukenTkListSkTy;
import yuyu.def.zdb.comparator.OrderZT_SyoukenTkListSkTy;

public class SortZT_SyoukenTkListSkTy {

    
    public List<ZT_SyoukenTkListSkTy> OrderZT_SyoukenTkListSkTyByPkAsc(List<ZT_SyoukenTkListSkTy> pEntity) {
        List<SortCondition<ZT_SyoukenTkListSkTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoukenTkListSkTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyoukenTkListSkTy()).ztysyono, SortOrder.ASC));
        List<ZT_SyoukenTkListSkTy> copyList = new ArrayList<ZT_SyoukenTkListSkTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoukenTkListSkTy(orders));
        return copyList;
    }

    
    public List<ZT_SyoukenTkListSkTy> OrderZT_SyoukenTkListSkTyByPkDesc(List<ZT_SyoukenTkListSkTy> pEntity) {
        List<SortCondition<ZT_SyoukenTkListSkTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoukenTkListSkTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyoukenTkListSkTy()).ztysyono, SortOrder.DESC));
        List<ZT_SyoukenTkListSkTy> copyList = new ArrayList<ZT_SyoukenTkListSkTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoukenTkListSkTy(orders));
        return copyList;
    }
}
