package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.meta.QJT_SkJiyuu;
import yuyu.def.siharai.comparator.OrderJT_SkJiyuu;

public class SortJT_SkJiyuu {

    
    public List<JT_SkJiyuu> OrderJT_SkJiyuuByPkAsc(List<JT_SkJiyuu> pEntity) {
        List<SortCondition<JT_SkJiyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkJiyuu()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkJiyuu()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkJiyuu()).seikyuurirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkJiyuu()).uketukeno, SortOrder.ASC));
        List<JT_SkJiyuu> copyList = new ArrayList<JT_SkJiyuu>(pEntity);
        Collections.sort(copyList, new OrderJT_SkJiyuu(orders));
        return copyList;
    }

    
    public List<JT_SkJiyuu> OrderJT_SkJiyuuByPkDesc(List<JT_SkJiyuu> pEntity) {
        List<SortCondition<JT_SkJiyuu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkJiyuu()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkJiyuu()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkJiyuu()).seikyuurirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkJiyuu()).uketukeno, SortOrder.DESC));
        List<JT_SkJiyuu> copyList = new ArrayList<JT_SkJiyuu>(pEntity);
        Collections.sort(copyList, new OrderJT_SkJiyuu(orders));
        return copyList;
    }

}

