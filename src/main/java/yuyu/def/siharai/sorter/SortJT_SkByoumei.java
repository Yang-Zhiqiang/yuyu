package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.meta.QJT_SkByoumei;
import yuyu.def.siharai.comparator.OrderJT_SkByoumei;

public class SortJT_SkByoumei {

    
    public List<JT_SkByoumei> OrderJT_SkByoumeiByPkAsc(List<JT_SkByoumei> pEntity) {
        List<SortCondition<JT_SkByoumei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkByoumei()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkByoumei()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkByoumei()).seikyuurirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkByoumei()).uketukeno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkByoumei()).renno, SortOrder.ASC));
        List<JT_SkByoumei> copyList = new ArrayList<JT_SkByoumei>(pEntity);
        Collections.sort(copyList, new OrderJT_SkByoumei(orders));
        return copyList;
    }

    
    public List<JT_SkByoumei> OrderJT_SkByoumeiByPkDesc(List<JT_SkByoumei> pEntity) {
        List<SortCondition<JT_SkByoumei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkByoumei()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkByoumei()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkByoumei()).seikyuurirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkByoumei()).uketukeno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkByoumei()).renno, SortOrder.DESC));
        List<JT_SkByoumei> copyList = new ArrayList<JT_SkByoumei>(pEntity);
        Collections.sort(copyList, new OrderJT_SkByoumei(orders));
        return copyList;
    }

}

