package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SyoukenTkListShTy;
import yuyu.def.db.meta.QZT_SyoukenTkListShTy;
import yuyu.def.zdb.comparator.OrderZT_SyoukenTkListShTy;

public class SortZT_SyoukenTkListShTy {

    
    public List<ZT_SyoukenTkListShTy> OrderZT_SyoukenTkListShTyByPkAsc(List<ZT_SyoukenTkListShTy> pEntity) {
        List<SortCondition<ZT_SyoukenTkListShTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoukenTkListShTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_SyoukenTkListShTy()).ztysyono, SortOrder.ASC));
        List<ZT_SyoukenTkListShTy> copyList = new ArrayList<ZT_SyoukenTkListShTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoukenTkListShTy(orders));
        return copyList;
    }

    
    public List<ZT_SyoukenTkListShTy> OrderZT_SyoukenTkListShTyByPkDesc(List<ZT_SyoukenTkListShTy> pEntity) {
        List<SortCondition<ZT_SyoukenTkListShTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SyoukenTkListShTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_SyoukenTkListShTy()).ztysyono, SortOrder.DESC));
        List<ZT_SyoukenTkListShTy> copyList = new ArrayList<ZT_SyoukenTkListShTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SyoukenTkListShTy(orders));
        return copyList;
    }
}
