package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_Kariukekin;
import yuyu.def.db.meta.QIT_BAK_Kariukekin;
import yuyu.def.hozen.comparator.OrderIT_BAK_Kariukekin;

public class SortIT_BAK_Kariukekin {

    public List<IT_BAK_Kariukekin> OrderIT_BAK_KariukekinByPkAsc(List<IT_BAK_Kariukekin> pEntity) {
        List<SortCondition<IT_BAK_Kariukekin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Kariukekin()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Kariukekin()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Kariukekin()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Kariukekin()).krkno, SortOrder.ASC));
        List<IT_BAK_Kariukekin> copyList = new ArrayList<IT_BAK_Kariukekin>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Kariukekin(orders));
        return copyList;
    }

    public List<IT_BAK_Kariukekin> OrderIT_BAK_KariukekinByPkDesc(List<IT_BAK_Kariukekin> pEntity) {
        List<SortCondition<IT_BAK_Kariukekin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Kariukekin()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Kariukekin()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Kariukekin()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Kariukekin()).krkno, SortOrder.DESC));
        List<IT_BAK_Kariukekin> copyList = new ArrayList<IT_BAK_Kariukekin>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Kariukekin(orders));
        return copyList;
    }

}

