package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiDetailKkn;
import yuyu.def.db.meta.QJT_SiDetailKkn;
import yuyu.def.siharai.comparator.OrderJT_SiDetailKkn;

public class SortJT_SiDetailKkn {

    
    public List<JT_SiDetailKkn> OrderJT_SiDetailKknByPkAsc(List<JT_SiDetailKkn> pEntity) {
        List<SortCondition<JT_SiDetailKkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).seikyuurirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).uketukeno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).kyuuhucd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).renno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).renno2keta2, SortOrder.ASC));
        List<JT_SiDetailKkn> copyList = new ArrayList<JT_SiDetailKkn>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDetailKkn(orders));
        return copyList;
    }

    
    public List<JT_SiDetailKkn> OrderJT_SiDetailKknByPkDesc(List<JT_SiDetailKkn> pEntity) {
        List<SortCondition<JT_SiDetailKkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).seikyuurirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).uketukeno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).kyuuhucd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).renno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiDetailKkn()).renno2keta2, SortOrder.DESC));
        List<JT_SiDetailKkn> copyList = new ArrayList<JT_SiDetailKkn>(pEntity);
        Collections.sort(copyList, new OrderJT_SiDetailKkn(orders));
        return copyList;
    }

}

