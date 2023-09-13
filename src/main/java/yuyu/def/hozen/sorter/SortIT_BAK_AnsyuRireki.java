package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_AnsyuRireki;
import yuyu.def.db.meta.QIT_BAK_AnsyuRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_AnsyuRireki;

public class SortIT_BAK_AnsyuRireki {

    public List<IT_BAK_AnsyuRireki> OrderIT_BAK_AnsyuRirekiByPkAsc(List<IT_BAK_AnsyuRireki> pEntity) {
        List<SortCondition<IT_BAK_AnsyuRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).nyknaiyoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).jyuutouym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).annaino, SortOrder.ASC));
        List<IT_BAK_AnsyuRireki> copyList = new ArrayList<IT_BAK_AnsyuRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_AnsyuRireki(orders));
        return copyList;
    }

    public List<IT_BAK_AnsyuRireki> OrderIT_BAK_AnsyuRirekiByPkDesc(List<IT_BAK_AnsyuRireki> pEntity) {
        List<SortCondition<IT_BAK_AnsyuRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).nyknaiyoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).jyuutouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_AnsyuRireki()).annaino, SortOrder.DESC));
        List<IT_BAK_AnsyuRireki> copyList = new ArrayList<IT_BAK_AnsyuRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_AnsyuRireki(orders));
        return copyList;
    }

}

