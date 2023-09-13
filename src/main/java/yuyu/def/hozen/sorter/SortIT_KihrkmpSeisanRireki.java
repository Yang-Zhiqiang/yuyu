package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_KihrkmpSeisanRireki;
import yuyu.def.hozen.comparator.OrderIT_KihrkmpSeisanRireki;

public class SortIT_KihrkmpSeisanRireki {

    public List<IT_KihrkmpSeisanRireki> OrderIT_KihrkmpSeisanRirekiByPkAsc(List<IT_KihrkmpSeisanRireki> pEntity) {
        List<SortCondition<IT_KihrkmpSeisanRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KihrkmpSeisanRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KihrkmpSeisanRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KihrkmpSeisanRireki()).renno, SortOrder.ASC));
        List<IT_KihrkmpSeisanRireki> copyList = new ArrayList<IT_KihrkmpSeisanRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KihrkmpSeisanRireki(orders));
        return copyList;
    }

    public List<IT_KihrkmpSeisanRireki> OrderIT_KihrkmpSeisanRirekiByPkDesc(List<IT_KihrkmpSeisanRireki> pEntity) {
        List<SortCondition<IT_KihrkmpSeisanRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KihrkmpSeisanRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KihrkmpSeisanRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KihrkmpSeisanRireki()).renno, SortOrder.DESC));
        List<IT_KihrkmpSeisanRireki> copyList = new ArrayList<IT_KihrkmpSeisanRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KihrkmpSeisanRireki(orders));
        return copyList;
    }

}

