package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.meta.QIT_HokenKykIdouRireki;
import yuyu.def.hozen.comparator.OrderIT_HokenKykIdouRireki;

public class SortIT_HokenKykIdouRireki {

    public List<IT_HokenKykIdouRireki> OrderIT_HokenKykIdouRirekiByPkAsc(List<IT_HokenKykIdouRireki> pEntity) {
        List<SortCondition<IT_HokenKykIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HokenKykIdouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenKykIdouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenKykIdouRireki()).henkousikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_HokenKykIdouRireki()).zougenkbn, SortOrder.ASC));
        List<IT_HokenKykIdouRireki> copyList = new ArrayList<IT_HokenKykIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_HokenKykIdouRireki(orders));
        return copyList;
    }

    public List<IT_HokenKykIdouRireki> OrderIT_HokenKykIdouRirekiByPkDesc(List<IT_HokenKykIdouRireki> pEntity) {
        List<SortCondition<IT_HokenKykIdouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_HokenKykIdouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenKykIdouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenKykIdouRireki()).henkousikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_HokenKykIdouRireki()).zougenkbn, SortOrder.DESC));
        List<IT_HokenKykIdouRireki> copyList = new ArrayList<IT_HokenKykIdouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_HokenKykIdouRireki(orders));
        return copyList;
    }
}
