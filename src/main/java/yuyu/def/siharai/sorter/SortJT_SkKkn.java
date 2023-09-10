package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SkKkn;
import yuyu.def.db.meta.QJT_SkKkn;
import yuyu.def.siharai.comparator.OrderJT_SkKkn;

public class SortJT_SkKkn {

    
    public List<JT_SkKkn> OrderJT_SkKknByPkAsc(List<JT_SkKkn> pEntity) {
        List<SortCondition<JT_SkKkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkKkn()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).seikyuurirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).uketukeno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).kyuuhukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).renno, SortOrder.ASC));
        List<JT_SkKkn> copyList = new ArrayList<JT_SkKkn>(pEntity);
        Collections.sort(copyList, new OrderJT_SkKkn(orders));
        return copyList;
    }

    
    public List<JT_SkKkn> OrderJT_SkKknByPkDesc(List<JT_SkKkn> pEntity) {
        List<SortCondition<JT_SkKkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SkKkn()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).seikyuurirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).uketukeno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).kyuuhukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SkKkn()).renno, SortOrder.DESC));
        List<JT_SkKkn> copyList = new ArrayList<JT_SkKkn>(pEntity);
        Collections.sort(copyList, new OrderJT_SkKkn(orders));
        return copyList;
    }

}

