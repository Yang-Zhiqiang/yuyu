package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_IkkatuKeisuu;
import yuyu.def.db.entity.BM_IkkatuKeisuu;
import yuyu.def.db.meta.QBM_IkkatuKeisuu;

public class SortBM_IkkatuKeisuu {

    public List<BM_IkkatuKeisuu> OrderBM_IkkatuKeisuuByPkAsc(List<BM_IkkatuKeisuu> pEntity) {
        List<SortCondition<BM_IkkatuKeisuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_IkkatuKeisuu()).ikttekiyouno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_IkkatuKeisuu()).nen1nen2baraihyouji, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_IkkatuKeisuu()).keikatukisuu, SortOrder.ASC));
        List<BM_IkkatuKeisuu> copyList = new ArrayList<BM_IkkatuKeisuu>(pEntity);
        Collections.sort(copyList, new OrderBM_IkkatuKeisuu(orders));
        return copyList;
    }

    public List<BM_IkkatuKeisuu> OrderBM_IkkatuKeisuuByPkDesc(List<BM_IkkatuKeisuu> pEntity) {
        List<SortCondition<BM_IkkatuKeisuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_IkkatuKeisuu()).ikttekiyouno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_IkkatuKeisuu()).nen1nen2baraihyouji, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_IkkatuKeisuu()).keikatukisuu, SortOrder.DESC));
        List<BM_IkkatuKeisuu> copyList = new ArrayList<BM_IkkatuKeisuu>(pEntity);
        Collections.sort(copyList, new OrderBM_IkkatuKeisuu(orders));
        return copyList;
    }
}
