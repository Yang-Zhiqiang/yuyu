package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.meta.QJT_SiKykSyouhn;
import yuyu.def.siharai.comparator.OrderJT_SiKykSyouhn;

public class SortJT_SiKykSyouhn {

    
    public List<JT_SiKykSyouhn> OrderJT_SiKykSyouhnByPkAsc(List<JT_SiKykSyouhn> pEntity) {
        List<SortCondition<JT_SiKykSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).kyhgndkatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).kyksyouhnrenno, SortOrder.ASC));
        List<JT_SiKykSyouhn> copyList = new ArrayList<JT_SiKykSyouhn>(pEntity);
        Collections.sort(copyList, new OrderJT_SiKykSyouhn(orders));
        return copyList;
    }

    
    public List<JT_SiKykSyouhn> OrderJT_SiKykSyouhnByPkDesc(List<JT_SiKykSyouhn> pEntity) {
        List<SortCondition<JT_SiKykSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).kyhgndkatakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKykSyouhn()).kyksyouhnrenno, SortOrder.DESC));
        List<JT_SiKykSyouhn> copyList = new ArrayList<JT_SiKykSyouhn>(pEntity);
        Collections.sort(copyList, new OrderJT_SiKykSyouhn(orders));
        return copyList;
    }

}

