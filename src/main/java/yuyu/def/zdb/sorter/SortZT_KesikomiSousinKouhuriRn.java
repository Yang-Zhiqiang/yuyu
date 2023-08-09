package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KesikomiSousinKouhuriRn;
import yuyu.def.db.meta.QZT_KesikomiSousinKouhuriRn;
import yuyu.def.zdb.comparator.OrderZT_KesikomiSousinKouhuriRn;

public class SortZT_KesikomiSousinKouhuriRn {

    
    public List<ZT_KesikomiSousinKouhuriRn> OrderZT_KesikomiSousinKouhuriRnByPkAsc(List<ZT_KesikomiSousinKouhuriRn> pEntity) {
        List<SortCondition<ZT_KesikomiSousinKouhuriRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinKouhuriRn()).zrnkskmsousinrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinKouhuriRn()).zrnkskmfsyoriymd, SortOrder.ASC));
        List<ZT_KesikomiSousinKouhuriRn> copyList = new ArrayList<ZT_KesikomiSousinKouhuriRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinKouhuriRn(orders));
        return copyList;
    }

    
    public List<ZT_KesikomiSousinKouhuriRn> OrderZT_KesikomiSousinKouhuriRnByPkDesc(List<ZT_KesikomiSousinKouhuriRn> pEntity) {
        List<SortCondition<ZT_KesikomiSousinKouhuriRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinKouhuriRn()).zrnkskmsousinrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinKouhuriRn()).zrnkskmfsyoriymd, SortOrder.DESC));
        List<ZT_KesikomiSousinKouhuriRn> copyList = new ArrayList<ZT_KesikomiSousinKouhuriRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinKouhuriRn(orders));
        return copyList;
    }
}
