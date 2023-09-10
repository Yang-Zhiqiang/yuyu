package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.meta.QJM_Kyuuhu;
import yuyu.def.siharai.comparator.OrderJM_Kyuuhu;

public class SortJM_Kyuuhu {

    
    public List<JM_Kyuuhu> OrderJM_KyuuhuByPkAsc(List<JM_Kyuuhu> pEntity) {
        List<SortCondition<JM_Kyuuhu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_Kyuuhu()).kyuuhucd, SortOrder.ASC));
        List<JM_Kyuuhu> copyList = new ArrayList<JM_Kyuuhu>(pEntity);
        Collections.sort(copyList, new OrderJM_Kyuuhu(orders));
        return copyList;
    }

    
    public List<JM_Kyuuhu> OrderJM_KyuuhuByPkDesc(List<JM_Kyuuhu> pEntity) {
        List<SortCondition<JM_Kyuuhu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_Kyuuhu()).kyuuhucd, SortOrder.DESC));
        List<JM_Kyuuhu> copyList = new ArrayList<JM_Kyuuhu>(pEntity);
        Collections.sort(copyList, new OrderJM_Kyuuhu(orders));
        return copyList;
    }

}

