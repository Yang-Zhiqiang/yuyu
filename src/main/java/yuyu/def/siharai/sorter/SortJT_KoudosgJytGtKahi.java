package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_KoudosgJytGtKahi;
import yuyu.def.db.meta.QJT_KoudosgJytGtKahi;
import yuyu.def.siharai.comparator.OrderJT_KoudosgJytGtKahi;

public class SortJT_KoudosgJytGtKahi {

    
    public List<JT_KoudosgJytGtKahi> OrderJT_KoudosgJytGtKahiByPkAsc(List<JT_KoudosgJytGtKahi> pEntity) {
        List<SortCondition<JT_KoudosgJytGtKahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_KoudosgJytGtKahi()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_KoudosgJytGtKahi()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_KoudosgJytGtKahi()).seikyuurirekino, SortOrder.ASC));
        List<JT_KoudosgJytGtKahi> copyList = new ArrayList<JT_KoudosgJytGtKahi>(pEntity);
        Collections.sort(copyList, new OrderJT_KoudosgJytGtKahi(orders));
        return copyList;
    }

    
    public List<JT_KoudosgJytGtKahi> OrderJT_KoudosgJytGtKahiByPkDesc(List<JT_KoudosgJytGtKahi> pEntity) {
        List<SortCondition<JT_KoudosgJytGtKahi>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_KoudosgJytGtKahi()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_KoudosgJytGtKahi()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_KoudosgJytGtKahi()).seikyuurirekino, SortOrder.DESC));
        List<JT_KoudosgJytGtKahi> copyList = new ArrayList<JT_KoudosgJytGtKahi>(pEntity);
        Collections.sort(copyList, new OrderJT_KoudosgJytGtKahi(orders));
        return copyList;
    }

}

