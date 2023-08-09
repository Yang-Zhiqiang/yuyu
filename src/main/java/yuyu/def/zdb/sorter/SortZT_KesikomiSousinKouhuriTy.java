package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KesikomiSousinKouhuriTy;
import yuyu.def.db.meta.QZT_KesikomiSousinKouhuriTy;
import yuyu.def.zdb.comparator.OrderZT_KesikomiSousinKouhuriTy;

public class SortZT_KesikomiSousinKouhuriTy {

    
    public List<ZT_KesikomiSousinKouhuriTy> OrderZT_KesikomiSousinKouhuriTyByPkAsc(List<ZT_KesikomiSousinKouhuriTy> pEntity) {
        List<SortCondition<ZT_KesikomiSousinKouhuriTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinKouhuriTy()).ztykskmsousinrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinKouhuriTy()).ztykskmfsyoriymd, SortOrder.ASC));
        List<ZT_KesikomiSousinKouhuriTy> copyList = new ArrayList<ZT_KesikomiSousinKouhuriTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinKouhuriTy(orders));
        return copyList;
    }

    
    public List<ZT_KesikomiSousinKouhuriTy> OrderZT_KesikomiSousinKouhuriTyByPkDesc(List<ZT_KesikomiSousinKouhuriTy> pEntity) {
        List<SortCondition<ZT_KesikomiSousinKouhuriTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinKouhuriTy()).ztykskmsousinrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinKouhuriTy()).ztykskmfsyoriymd, SortOrder.DESC));
        List<ZT_KesikomiSousinKouhuriTy> copyList = new ArrayList<ZT_KesikomiSousinKouhuriTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinKouhuriTy(orders));
        return copyList;
    }
}
