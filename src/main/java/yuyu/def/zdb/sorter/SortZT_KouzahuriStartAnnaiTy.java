package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiTy;
import yuyu.def.zdb.comparator.OrderZT_KouzahuriStartAnnaiTy;

public class SortZT_KouzahuriStartAnnaiTy {

    
    public List<ZT_KouzahuriStartAnnaiTy> OrderZT_KouzahuriStartAnnaiTyByPkAsc(List<ZT_KouzahuriStartAnnaiTy> pEntity) {
        List<SortCondition<ZT_KouzahuriStartAnnaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzahuriStartAnnaiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzahuriStartAnnaiTy()).ztysyono, SortOrder.ASC));
        List<ZT_KouzahuriStartAnnaiTy> copyList = new ArrayList<ZT_KouzahuriStartAnnaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzahuriStartAnnaiTy(orders));
        return copyList;
    }

    
    public List<ZT_KouzahuriStartAnnaiTy> OrderZT_KouzahuriStartAnnaiTyByPkDesc(List<ZT_KouzahuriStartAnnaiTy> pEntity) {
        List<SortCondition<ZT_KouzahuriStartAnnaiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzahuriStartAnnaiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzahuriStartAnnaiTy()).ztysyono, SortOrder.DESC));
        List<ZT_KouzahuriStartAnnaiTy> copyList = new ArrayList<ZT_KouzahuriStartAnnaiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzahuriStartAnnaiTy(orders));
        return copyList;
    }
}
