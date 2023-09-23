package yuyu.common.hozen.khcommon.dba4commonnyuukin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.db.meta.QIT_Kariukekin;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.db.meta.QIT_Zennou;
import yuyu.def.hozen.comparator.OrderIT_Kariukekin;
import yuyu.def.hozen.comparator.OrderIT_NyknJissekiRireki;
import yuyu.def.hozen.comparator.OrderIT_Zennou;

/**
 * Sorterクラス
 */
public class SortCommonNyuukin {

    public List<IT_Kariukekin> OrderIT_Kariukekin1(List<IT_Kariukekin> pEntity) {
        List<SortCondition<IT_Kariukekin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Kariukekin()).krkno, SortOrder.DESC));
        List<IT_Kariukekin> copyList = new ArrayList<IT_Kariukekin>(pEntity);
        Collections.sort(copyList, new OrderIT_Kariukekin(orders));
        return copyList;
    }

    public List<IT_NyknJissekiRireki> OrderIT_NyknJissekiRireki1(List<IT_NyknJissekiRireki> pEntity) {
        List<SortCondition<IT_NyknJissekiRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_NyknJissekiRireki()).renno, SortOrder.DESC));
        List<IT_NyknJissekiRireki> copyList = new ArrayList<IT_NyknJissekiRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_NyknJissekiRireki(orders));
        return copyList;
    }

    public List<IT_Zennou> OrderIT_Zennou1(List<IT_Zennou> pEntity) {
        List<SortCondition<IT_Zennou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Zennou()).renno, SortOrder.DESC));
        List<IT_Zennou> copyList = new ArrayList<IT_Zennou>(pEntity);
        Collections.sort(copyList, new OrderIT_Zennou(orders));
        return copyList;
    }

}

