package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_HokenKykIdouRireki;
import yuyu.def.db.meta.QIT_BAK_HokenKykIdouRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_HokenKykIdouRireki;

public class SortIT_BAK_HokenKykIdouRireki {

    public List<IT_BAK_HokenKykIdouRireki> OrderIT_BAK_HokenKykIdouRirekiByPkAsc(List<IT_BAK_HokenKykIdouRireki> pEntity) {
        List<SortCondition<IT_BAK_HokenKykIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).zougenkbn, SortOrder.ASC));
        List<IT_BAK_HokenKykIdouRireki> copyList = new ArrayList<IT_BAK_HokenKykIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HokenKykIdouRireki(orders));
        return copyList;
    }

    public List<IT_BAK_HokenKykIdouRireki> OrderIT_BAK_HokenKykIdouRirekiByPkDesc(List<IT_BAK_HokenKykIdouRireki> pEntity) {
        List<SortCondition<IT_BAK_HokenKykIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_HokenKykIdouRireki()).zougenkbn, SortOrder.DESC));
        List<IT_BAK_HokenKykIdouRireki> copyList = new ArrayList<IT_BAK_HokenKykIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_HokenKykIdouRireki(orders));
        return copyList;
    }
}
