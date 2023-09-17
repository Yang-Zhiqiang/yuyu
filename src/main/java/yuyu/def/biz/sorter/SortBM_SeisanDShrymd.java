package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SeisanDShrymd;
import yuyu.def.db.entity.BM_SeisanDShrymd;
import yuyu.def.db.meta.QBM_SeisanDShrymd;

public class SortBM_SeisanDShrymd {

    public List<BM_SeisanDShrymd> OrderBM_SeisanDShrymdByPkAsc(List<BM_SeisanDShrymd> pEntity) {
        List<SortCondition<BM_SeisanDShrymd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SeisanDShrymd()).syorinendo, SortOrder.ASC));
        List<BM_SeisanDShrymd> copyList = new ArrayList<BM_SeisanDShrymd>(pEntity);
        Collections.sort(copyList, new OrderBM_SeisanDShrymd(orders));
        return copyList;
    }

    public List<BM_SeisanDShrymd> OrderBM_SeisanDShrymdByPkDesc(List<BM_SeisanDShrymd> pEntity) {
        List<SortCondition<BM_SeisanDShrymd>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SeisanDShrymd()).syorinendo, SortOrder.DESC));
        List<BM_SeisanDShrymd> copyList = new ArrayList<BM_SeisanDShrymd>(pEntity);
        Collections.sort(copyList, new OrderBM_SeisanDShrymd(orders));
        return copyList;
    }
}
