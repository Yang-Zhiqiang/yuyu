package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_TuusanToutatu;
import yuyu.def.db.meta.QJT_TuusanToutatu;
import yuyu.def.siharai.comparator.OrderJT_TuusanToutatu;

public class SortJT_TuusanToutatu {

    
    public List<JT_TuusanToutatu> OrderJT_TuusanToutatuByPkAsc(List<JT_TuusanToutatu> pEntity) {
        List<SortCondition<JT_TuusanToutatu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_TuusanToutatu()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_TuusanToutatu()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_TuusanToutatu()).seikyuurirekino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_TuusanToutatu()).kyuuhucd, SortOrder.ASC));
        List<JT_TuusanToutatu> copyList = new ArrayList<JT_TuusanToutatu>(pEntity);
        Collections.sort(copyList, new OrderJT_TuusanToutatu(orders));
        return copyList;
    }

    
    public List<JT_TuusanToutatu> OrderJT_TuusanToutatuByPkDesc(List<JT_TuusanToutatu> pEntity) {
        List<SortCondition<JT_TuusanToutatu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_TuusanToutatu()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_TuusanToutatu()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_TuusanToutatu()).seikyuurirekino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_TuusanToutatu()).kyuuhucd, SortOrder.DESC));
        List<JT_TuusanToutatu> copyList = new ArrayList<JT_TuusanToutatu>(pEntity);
        Collections.sort(copyList, new OrderJT_TuusanToutatu(orders));
        return copyList;
    }

}

