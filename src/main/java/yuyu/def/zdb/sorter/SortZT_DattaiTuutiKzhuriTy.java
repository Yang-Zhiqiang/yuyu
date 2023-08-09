package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_DattaiTuutiKzhuriTy;
import yuyu.def.db.meta.QZT_DattaiTuutiKzhuriTy;
import yuyu.def.zdb.comparator.OrderZT_DattaiTuutiKzhuriTy;

public class SortZT_DattaiTuutiKzhuriTy {

    
    public List<ZT_DattaiTuutiKzhuriTy> OrderZT_DattaiTuutiKzhuriTyByPkAsc(List<ZT_DattaiTuutiKzhuriTy> pEntity) {
        List<SortCondition<ZT_DattaiTuutiKzhuriTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DattaiTuutiKzhuriTy()).ztytyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_DattaiTuutiKzhuriTy()).ztysyono, SortOrder.ASC));
        List<ZT_DattaiTuutiKzhuriTy> copyList = new ArrayList<ZT_DattaiTuutiKzhuriTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DattaiTuutiKzhuriTy(orders));
        return copyList;
    }

    
    public List<ZT_DattaiTuutiKzhuriTy> OrderZT_DattaiTuutiKzhuriTyByPkDesc(List<ZT_DattaiTuutiKzhuriTy> pEntity) {
        List<SortCondition<ZT_DattaiTuutiKzhuriTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_DattaiTuutiKzhuriTy()).ztytyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_DattaiTuutiKzhuriTy()).ztysyono, SortOrder.DESC));
        List<ZT_DattaiTuutiKzhuriTy> copyList = new ArrayList<ZT_DattaiTuutiKzhuriTy>(pEntity);
        Collections.sort(copyList, new OrderZT_DattaiTuutiKzhuriTy(orders));
        return copyList;
    }
}
