package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_KesikomiSousinHurikaeRn;
import yuyu.def.db.meta.QZT_KesikomiSousinHurikaeRn;
import yuyu.def.zdb.comparator.OrderZT_KesikomiSousinHurikaeRn;

public class SortZT_KesikomiSousinHurikaeRn {

    
    public List<ZT_KesikomiSousinHurikaeRn> OrderZT_KesikomiSousinHurikaeRnByPkAsc(List<ZT_KesikomiSousinHurikaeRn> pEntity) {
        List<SortCondition<ZT_KesikomiSousinHurikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinHurikaeRn()).zrnkskmsousinrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinHurikaeRn()).zrnkskmfsyoriymd, SortOrder.ASC));
        List<ZT_KesikomiSousinHurikaeRn> copyList = new ArrayList<ZT_KesikomiSousinHurikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinHurikaeRn(orders));
        return copyList;
    }

    
    public List<ZT_KesikomiSousinHurikaeRn> OrderZT_KesikomiSousinHurikaeRnByPkDesc(List<ZT_KesikomiSousinHurikaeRn> pEntity) {
        List<SortCondition<ZT_KesikomiSousinHurikaeRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_KesikomiSousinHurikaeRn()).zrnkskmsousinrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QZT_KesikomiSousinHurikaeRn()).zrnkskmfsyoriymd, SortOrder.DESC));
        List<ZT_KesikomiSousinHurikaeRn> copyList = new ArrayList<ZT_KesikomiSousinHurikaeRn>(pEntity);
        Collections.sort(copyList, new OrderZT_KesikomiSousinHurikaeRn(orders));
        return copyList;
    }
}
