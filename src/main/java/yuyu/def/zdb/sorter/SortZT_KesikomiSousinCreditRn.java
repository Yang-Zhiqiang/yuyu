package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditRn;
import yuyu.def.db.meta.QZT_KesikomiSousinCreditRn;
import yuyu.def.zdb.comparator.OrderZT_KesikomiSousinCreditRn;

public class SortZT_KesikomiSousinCreditRn {

    
    public List<ZT_KesikomiSousinCreditRn> OrderZT_KesikomiSousinCreditRnByPkAsc(List<ZT_KesikomiSousinCreditRn> pEntity) {
        List<SortCondition<ZT_KesikomiSousinCreditRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinCreditRn()).zrnkskmsousinrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinCreditRn()).zrnkskmfsyoriymd, SortOrder.ASC));
        List<ZT_KesikomiSousinCreditRn> copyList = new ArrayList<ZT_KesikomiSousinCreditRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinCreditRn(orders));
        return copyList;
    }

    
    public List<ZT_KesikomiSousinCreditRn> OrderZT_KesikomiSousinCreditRnByPkDesc(List<ZT_KesikomiSousinCreditRn> pEntity) {
        List<SortCondition<ZT_KesikomiSousinCreditRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinCreditRn()).zrnkskmsousinrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinCreditRn()).zrnkskmfsyoriymd, SortOrder.DESC));
        List<ZT_KesikomiSousinCreditRn> copyList = new ArrayList<ZT_KesikomiSousinCreditRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinCreditRn(orders));
        return copyList;
    }
}
