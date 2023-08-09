package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiTy;
import yuyu.def.zdb.comparator.OrderZT_KouzahuriMinyuTuutiTy;

public class SortZT_KouzahuriMinyuTuutiTy {

    
    public List<ZT_KouzahuriMinyuTuutiTy> OrderZT_KouzahuriMinyuTuutiTyByPkAsc(List<ZT_KouzahuriMinyuTuutiTy> pEntity) {
        List<SortCondition<ZT_KouzahuriMinyuTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzahuriMinyuTuutiTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KouzahuriMinyuTuutiTy()).ztysyono, SortOrder.ASC));
        List<ZT_KouzahuriMinyuTuutiTy> copyList = new ArrayList<ZT_KouzahuriMinyuTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzahuriMinyuTuutiTy(orders));
        return copyList;
    }

    
    public List<ZT_KouzahuriMinyuTuutiTy> OrderZT_KouzahuriMinyuTuutiTyByPkDesc(List<ZT_KouzahuriMinyuTuutiTy> pEntity) {
        List<SortCondition<ZT_KouzahuriMinyuTuutiTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KouzahuriMinyuTuutiTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KouzahuriMinyuTuutiTy()).ztysyono, SortOrder.DESC));
        List<ZT_KouzahuriMinyuTuutiTy> copyList = new ArrayList<ZT_KouzahuriMinyuTuutiTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KouzahuriMinyuTuutiTy(orders));
        return copyList;
    }
}
