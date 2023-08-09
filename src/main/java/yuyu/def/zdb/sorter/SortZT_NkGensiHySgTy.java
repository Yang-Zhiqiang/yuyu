package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_NkGensiHySgTy;
import yuyu.def.db.meta.QZT_NkGensiHySgTy;
import yuyu.def.zdb.comparator.OrderZT_NkGensiHySgTy;

public class SortZT_NkGensiHySgTy {

    
    public List<ZT_NkGensiHySgTy> OrderZT_NkGensiHySgTyByPkAsc(List<ZT_NkGensiHySgTy> pEntity) {
        List<SortCondition<ZT_NkGensiHySgTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiHySgTy()).ztysequenceno, SortOrder.ASC));
        List<ZT_NkGensiHySgTy> copyList = new ArrayList<ZT_NkGensiHySgTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiHySgTy(orders));
        return copyList;
    }

    
    public List<ZT_NkGensiHySgTy> OrderZT_NkGensiHySgTyByPkDesc(List<ZT_NkGensiHySgTy> pEntity) {
        List<SortCondition<ZT_NkGensiHySgTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_NkGensiHySgTy()).ztysequenceno, SortOrder.DESC));
        List<ZT_NkGensiHySgTy> copyList = new ArrayList<ZT_NkGensiHySgTy>(pEntity);
        Collections.sort(copyList, new OrderZT_NkGensiHySgTy(orders));
        return copyList;
    }
}
