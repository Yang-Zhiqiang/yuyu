package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.meta.QIT_Kariukekin;
import yuyu.def.hozen.comparator.OrderIT_Kariukekin;

public class SortIT_Kariukekin {

    public List<IT_Kariukekin> OrderIT_KariukekinByPkAsc(List<IT_Kariukekin> pEntity) {
        List<SortCondition<IT_Kariukekin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Kariukekin()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Kariukekin()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Kariukekin()).krkno, SortOrder.ASC));
        List<IT_Kariukekin> copyList = new ArrayList<IT_Kariukekin>(pEntity);
        Collections.sort(copyList, new OrderIT_Kariukekin(orders));
        return copyList;
    }

    public List<IT_Kariukekin> OrderIT_KariukekinByPkDesc(List<IT_Kariukekin> pEntity) {
        List<SortCondition<IT_Kariukekin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Kariukekin()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Kariukekin()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Kariukekin()).krkno, SortOrder.DESC));
        List<IT_Kariukekin> copyList = new ArrayList<IT_Kariukekin>(pEntity);
        Collections.sort(copyList, new OrderIT_Kariukekin(orders));
        return copyList;
    }

}

