package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkGensiRigTy;
import yuyu.def.db.meta.QZT_NkGensiRigTy;
import yuyu.def.zdb.comparator.OrderZT_NkGensiRigTy;

public class SortZT_NkGensiRigTy {

    
    public List<ZT_NkGensiRigTy> OrderZT_NkGensiRigTyByPkAsc(List<ZT_NkGensiRigTy> pEntity) {
        List<SortCondition<ZT_NkGensiRigTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiRigTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_NkGensiRigTy> copyList = new ArrayList<ZT_NkGensiRigTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiRigTy(orders));
        return copyList;
    }

    
    public List<ZT_NkGensiRigTy> OrderZT_NkGensiRigTyByPkDesc(List<ZT_NkGensiRigTy> pEntity) {
        List<SortCondition<ZT_NkGensiRigTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiRigTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_NkGensiRigTy> copyList = new ArrayList<ZT_NkGensiRigTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiRigTy(orders));
        return copyList;
    }
}
