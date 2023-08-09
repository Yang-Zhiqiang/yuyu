package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KijituTouraiAnnaiTy;
import yuyu.def.db.meta.QZT_KijituTouraiAnnaiTy;
import yuyu.def.zdb.comparator.OrderZT_KijituTouraiAnnaiTy;

public class SortZT_KijituTouraiAnnaiTy {

    
    public List<ZT_KijituTouraiAnnaiTy> OrderZT_KijituTouraiAnnaiTyByPkAsc(List<ZT_KijituTouraiAnnaiTy> pEntity) {
        List<SortCondition<ZT_KijituTouraiAnnaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KijituTouraiAnnaiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KijituTouraiAnnaiTy()).ztysyono, SortOrder.ASC));
        List<ZT_KijituTouraiAnnaiTy> copyList = new ArrayList<ZT_KijituTouraiAnnaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KijituTouraiAnnaiTy(orders));
        return copyList;
    }

    
    public List<ZT_KijituTouraiAnnaiTy> OrderZT_KijituTouraiAnnaiTyByPkDesc(List<ZT_KijituTouraiAnnaiTy> pEntity) {
        List<SortCondition<ZT_KijituTouraiAnnaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KijituTouraiAnnaiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KijituTouraiAnnaiTy()).ztysyono, SortOrder.DESC));
        List<ZT_KijituTouraiAnnaiTy> copyList = new ArrayList<ZT_KijituTouraiAnnaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KijituTouraiAnnaiTy(orders));
        return copyList;
    }
}
