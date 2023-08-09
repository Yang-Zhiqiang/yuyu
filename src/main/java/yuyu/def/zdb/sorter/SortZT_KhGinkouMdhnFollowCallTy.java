package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.zdb.comparator.OrderZT_KhGinkouMdhnFollowCallTy;

public class SortZT_KhGinkouMdhnFollowCallTy {

    
    public List<ZT_KhGinkouMdhnFollowCallTy> OrderZT_KhGinkouMdhnFollowCallTyByPkAsc(List<ZT_KhGinkouMdhnFollowCallTy> pEntity) {
        List<SortCondition<ZT_KhGinkouMdhnFollowCallTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KhGinkouMdhnFollowCallTy()).ztysyono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KhGinkouMdhnFollowCallTy()).ztyminyuuym, SortOrder.ASC));
        List<ZT_KhGinkouMdhnFollowCallTy> copyList = new ArrayList<ZT_KhGinkouMdhnFollowCallTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KhGinkouMdhnFollowCallTy(orders));
        return copyList;
    }

    
    public List<ZT_KhGinkouMdhnFollowCallTy> OrderZT_KhGinkouMdhnFollowCallTyByPkDesc(List<ZT_KhGinkouMdhnFollowCallTy> pEntity) {
        List<SortCondition<ZT_KhGinkouMdhnFollowCallTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KhGinkouMdhnFollowCallTy()).ztysyono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KhGinkouMdhnFollowCallTy()).ztyminyuuym, SortOrder.DESC));
        List<ZT_KhGinkouMdhnFollowCallTy> copyList = new ArrayList<ZT_KhGinkouMdhnFollowCallTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KhGinkouMdhnFollowCallTy(orders));
        return copyList;
    }
}
