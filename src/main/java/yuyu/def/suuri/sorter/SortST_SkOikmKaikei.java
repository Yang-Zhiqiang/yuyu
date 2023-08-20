package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_SkOikmKaikei;
import yuyu.def.db.meta.QST_SkOikmKaikei;
import yuyu.def.suuri.comparator.OrderST_SkOikmKaikei;

public class SortST_SkOikmKaikei {

    
    public List<ST_SkOikmKaikei> OrderST_SkOikmKaikeiByPkAsc(List<ST_SkOikmKaikei> pEntity) {
        List<SortCondition<ST_SkOikmKaikei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SkOikmKaikei()).densyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkOikmKaikei()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkOikmKaikei()).edano, SortOrder.ASC));
        List<ST_SkOikmKaikei> copyList = new ArrayList<ST_SkOikmKaikei>(pEntity);
        Collections.sort(copyList, new OrderST_SkOikmKaikei(orders));
        return copyList;
    }

    
    public List<ST_SkOikmKaikei> OrderST_SkOikmKaikeiByPkDesc(List<ST_SkOikmKaikei> pEntity) {
        List<SortCondition<ST_SkOikmKaikei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SkOikmKaikei()).densyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkOikmKaikei()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkOikmKaikei()).edano, SortOrder.DESC));
        List<ST_SkOikmKaikei> copyList = new ArrayList<ST_SkOikmKaikei>(pEntity);
        Collections.sort(copyList, new OrderST_SkOikmKaikei(orders));
        return copyList;
    }

}

