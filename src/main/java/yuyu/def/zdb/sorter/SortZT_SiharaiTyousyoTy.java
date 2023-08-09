package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_SiharaiTyousyoTy;
import yuyu.def.db.meta.QZT_SiharaiTyousyoTy;
import yuyu.def.zdb.comparator.OrderZT_SiharaiTyousyoTy;

public class SortZT_SiharaiTyousyoTy {

    
    public List<ZT_SiharaiTyousyoTy> OrderZT_SiharaiTyousyoTyByPkAsc(List<ZT_SiharaiTyousyoTy> pEntity) {
        List<SortCondition<ZT_SiharaiTyousyoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SiharaiTyousyoTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_SiharaiTyousyoTy> copyList = new ArrayList<ZT_SiharaiTyousyoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SiharaiTyousyoTy(orders));
        return copyList;
    }

    
    public List<ZT_SiharaiTyousyoTy> OrderZT_SiharaiTyousyoTyByPkDesc(List<ZT_SiharaiTyousyoTy> pEntity) {
        List<SortCondition<ZT_SiharaiTyousyoTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_SiharaiTyousyoTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_SiharaiTyousyoTy> copyList = new ArrayList<ZT_SiharaiTyousyoTy>(pEntity);
        Collections.sort(copyList, new OrderZT_SiharaiTyousyoTy(orders));
        return copyList;
    }
}
