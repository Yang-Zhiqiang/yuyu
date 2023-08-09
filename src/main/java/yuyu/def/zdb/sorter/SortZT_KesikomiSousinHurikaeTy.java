package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KesikomiSousinHurikaeTy;
import yuyu.def.db.meta.QZT_KesikomiSousinHurikaeTy;
import yuyu.def.zdb.comparator.OrderZT_KesikomiSousinHurikaeTy;

public class SortZT_KesikomiSousinHurikaeTy {

    
    public List<ZT_KesikomiSousinHurikaeTy> OrderZT_KesikomiSousinHurikaeTyByPkAsc(List<ZT_KesikomiSousinHurikaeTy> pEntity) {
        List<SortCondition<ZT_KesikomiSousinHurikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinHurikaeTy()).ztykskmsousinrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinHurikaeTy()).ztykskmfsyoriymd, SortOrder.ASC));
        List<ZT_KesikomiSousinHurikaeTy> copyList = new ArrayList<ZT_KesikomiSousinHurikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinHurikaeTy(orders));
        return copyList;
    }

    
    public List<ZT_KesikomiSousinHurikaeTy> OrderZT_KesikomiSousinHurikaeTyByPkDesc(List<ZT_KesikomiSousinHurikaeTy> pEntity) {
        List<SortCondition<ZT_KesikomiSousinHurikaeTy>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinHurikaeTy()).ztykskmsousinrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinHurikaeTy()).ztykskmfsyoriymd, SortOrder.DESC));
        List<ZT_KesikomiSousinHurikaeTy> copyList = new ArrayList<ZT_KesikomiSousinHurikaeTy>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinHurikaeTy(orders));
        return copyList;
    }
}
