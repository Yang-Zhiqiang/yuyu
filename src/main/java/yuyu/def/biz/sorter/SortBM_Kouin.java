package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Kouin;
import yuyu.def.db.entity.BM_Kouin;
import yuyu.def.db.meta.QBM_Kouin;

public class SortBM_Kouin {

    public List<BM_Kouin> OrderBM_KouinByPkAsc(List<BM_Kouin> pEntity) {
        List<SortCondition<BM_Kouin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Kouin()).kinyuucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_Kouin()).kouincd, SortOrder.ASC));
        List<BM_Kouin> copyList = new ArrayList<BM_Kouin>(pEntity);
        Collections.sort(copyList, new OrderBM_Kouin(orders));
        return copyList;
    }

    public List<BM_Kouin> OrderBM_KouinByPkDesc(List<BM_Kouin> pEntity) {
        List<SortCondition<BM_Kouin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Kouin()).kinyuucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_Kouin()).kouincd, SortOrder.DESC));
        List<BM_Kouin> copyList = new ArrayList<BM_Kouin>(pEntity);
        Collections.sort(copyList, new OrderBM_Kouin(orders));
        return copyList;
    }

}

