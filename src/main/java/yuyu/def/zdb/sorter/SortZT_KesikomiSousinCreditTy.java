package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditTy;
import yuyu.def.db.meta.QZT_KesikomiSousinCreditTy;
import yuyu.def.zdb.comparator.OrderZT_KesikomiSousinCreditTy;

public class SortZT_KesikomiSousinCreditTy {

    
    public List<ZT_KesikomiSousinCreditTy> OrderZT_KesikomiSousinCreditTyByPkAsc(List<ZT_KesikomiSousinCreditTy> pEntity) {
        List<SortCondition<ZT_KesikomiSousinCreditTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinCreditTy()).ztykskmsousinrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinCreditTy()).ztykskmfsyoriymd, SortOrder.ASC));
        List<ZT_KesikomiSousinCreditTy> copyList = new ArrayList<ZT_KesikomiSousinCreditTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinCreditTy(orders));
        return copyList;
    }

    
    public List<ZT_KesikomiSousinCreditTy> OrderZT_KesikomiSousinCreditTyByPkDesc(List<ZT_KesikomiSousinCreditTy> pEntity) {
        List<SortCondition<ZT_KesikomiSousinCreditTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinCreditTy()).ztykskmsousinrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinCreditTy()).ztykskmfsyoriymd, SortOrder.DESC));
        List<ZT_KesikomiSousinCreditTy> copyList = new ArrayList<ZT_KesikomiSousinCreditTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinCreditTy(orders));
        return copyList;
    }
}
