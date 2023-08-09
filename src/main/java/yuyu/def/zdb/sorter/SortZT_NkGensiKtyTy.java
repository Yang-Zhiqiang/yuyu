package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkGensiKtyTy;
import yuyu.def.db.meta.QZT_NkGensiKtyTy;
import yuyu.def.zdb.comparator.OrderZT_NkGensiKtyTy;

public class SortZT_NkGensiKtyTy {

    
    public List<ZT_NkGensiKtyTy> OrderZT_NkGensiKtyTyByPkAsc(List<ZT_NkGensiKtyTy> pEntity) {
        List<SortCondition<ZT_NkGensiKtyTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiKtyTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_NkGensiKtyTy> copyList = new ArrayList<ZT_NkGensiKtyTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiKtyTy(orders));
        return copyList;
    }

    
    public List<ZT_NkGensiKtyTy> OrderZT_NkGensiKtyTyByPkDesc(List<ZT_NkGensiKtyTy> pEntity) {
        List<SortCondition<ZT_NkGensiKtyTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiKtyTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_NkGensiKtyTy> copyList = new ArrayList<ZT_NkGensiKtyTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiKtyTy(orders));
        return copyList;
    }
}
