package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.meta.QST_SynypTukiYkgtIkouHozon;
import yuyu.def.suuri.comparator.OrderST_SynypTukiYkgtIkouHozon;

public class SortST_SynypTukiYkgtIkouHozon {

    
    public List<ST_SynypTukiYkgtIkouHozon> OrderST_SynypTukiYkgtIkouHozonByPkAsc(List<ST_SynypTukiYkgtIkouHozon> pEntity) {
        List<SortCondition<ST_SynypTukiYkgtIkouHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).srkijyunym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).sequenceno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).jyutoustartym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).jyutouendym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).taisyakukbn, SortOrder.ASC));
        List<ST_SynypTukiYkgtIkouHozon> copyList = new ArrayList<ST_SynypTukiYkgtIkouHozon>(pEntity);
        Collections.sort(copyList, new OrderST_SynypTukiYkgtIkouHozon(orders));
        return copyList;
    }

    
    public List<ST_SynypTukiYkgtIkouHozon> OrderST_SynypTukiYkgtIkouHozonByPkDesc(List<ST_SynypTukiYkgtIkouHozon> pEntity) {
        List<SortCondition<ST_SynypTukiYkgtIkouHozon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).srkijyunym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).sequenceno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).jyutoustartym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).jyutouendym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SynypTukiYkgtIkouHozon()).taisyakukbn, SortOrder.DESC));
        List<ST_SynypTukiYkgtIkouHozon> copyList = new ArrayList<ST_SynypTukiYkgtIkouHozon>(pEntity);
        Collections.sort(copyList, new OrderST_SynypTukiYkgtIkouHozon(orders));
        return copyList;
    }
}
