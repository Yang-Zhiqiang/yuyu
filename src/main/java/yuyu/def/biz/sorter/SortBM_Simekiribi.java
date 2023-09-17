package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Simekiribi;
import yuyu.def.db.entity.BM_Simekiribi;
import yuyu.def.db.meta.QBM_Simekiribi;

public class SortBM_Simekiribi {

    public List<BM_Simekiribi> OrderBM_SimekiribiByPkAsc(List<BM_Simekiribi> pEntity) {
        List<SortCondition<BM_Simekiribi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Simekiribi()).bosyuuym, SortOrder.ASC));
        List<BM_Simekiribi> copyList = new ArrayList<BM_Simekiribi>(pEntity);
        Collections.sort(copyList, new OrderBM_Simekiribi(orders));
        return copyList;
    }

    public List<BM_Simekiribi> OrderBM_SimekiribiByPkDesc(List<BM_Simekiribi> pEntity) {
        List<SortCondition<BM_Simekiribi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Simekiribi()).bosyuuym, SortOrder.DESC));
        List<BM_Simekiribi> copyList = new ArrayList<BM_Simekiribi>(pEntity);
        Collections.sort(copyList, new OrderBM_Simekiribi(orders));
        return copyList;
    }

}

