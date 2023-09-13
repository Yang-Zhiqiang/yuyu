package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KihrkmpSeisanRireki;
import yuyu.def.db.meta.QIT_BAK_KihrkmpSeisanRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_KihrkmpSeisanRireki;

public class SortIT_BAK_KihrkmpSeisanRireki {

    public List<IT_BAK_KihrkmpSeisanRireki> OrderIT_BAK_KihrkmpSeisanRirekiByPkAsc(List<IT_BAK_KihrkmpSeisanRireki> pEntity) {
        List<SortCondition<IT_BAK_KihrkmpSeisanRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KihrkmpSeisanRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KihrkmpSeisanRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KihrkmpSeisanRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KihrkmpSeisanRireki()).renno, SortOrder.ASC));
        List<IT_BAK_KihrkmpSeisanRireki> copyList = new ArrayList<IT_BAK_KihrkmpSeisanRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KihrkmpSeisanRireki(orders));
        return copyList;
    }

    public List<IT_BAK_KihrkmpSeisanRireki> OrderIT_BAK_KihrkmpSeisanRirekiByPkDesc(List<IT_BAK_KihrkmpSeisanRireki> pEntity) {
        List<SortCondition<IT_BAK_KihrkmpSeisanRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KihrkmpSeisanRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KihrkmpSeisanRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KihrkmpSeisanRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KihrkmpSeisanRireki()).renno, SortOrder.DESC));
        List<IT_BAK_KihrkmpSeisanRireki> copyList = new ArrayList<IT_BAK_KihrkmpSeisanRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KihrkmpSeisanRireki(orders));
        return copyList;
    }

}

