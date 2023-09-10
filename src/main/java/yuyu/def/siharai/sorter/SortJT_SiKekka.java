package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.meta.QJT_SiKekka;
import yuyu.def.siharai.comparator.OrderJT_SiKekka;

public class SortJT_SiKekka {

    
    public List<JT_SiKekka> OrderJT_SiKekkaByPkAsc(List<JT_SiKekka> pEntity) {
        List<SortCondition<JT_SiKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiKekka()).shiharaikekkadatakbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).kyksyouhnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).syutkkbn, SortOrder.ASC));
        List<JT_SiKekka> copyList = new ArrayList<JT_SiKekka>(pEntity);
        Collections.sort(copyList, new OrderJT_SiKekka(orders));
        return copyList;
    }

    
    public List<JT_SiKekka> OrderJT_SiKekkaByPkDesc(List<JT_SiKekka> pEntity) {
        List<SortCondition<JT_SiKekka>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_SiKekka()).shiharaikekkadatakbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).kyksyouhnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_SiKekka()).syutkkbn, SortOrder.DESC));
        List<JT_SiKekka> copyList = new ArrayList<JT_SiKekka>(pEntity);
        Collections.sort(copyList, new OrderJT_SiKekka(orders));
        return copyList;
    }

}

