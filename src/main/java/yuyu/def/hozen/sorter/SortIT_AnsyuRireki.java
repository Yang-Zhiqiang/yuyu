package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.meta.QIT_AnsyuRireki;
import yuyu.def.hozen.comparator.OrderIT_AnsyuRireki;

public class SortIT_AnsyuRireki {

    public List<IT_AnsyuRireki> OrderIT_AnsyuRirekiByPkAsc(List<IT_AnsyuRireki> pEntity) {
        List<SortCondition<IT_AnsyuRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).nyknaiyoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).jyuutouym, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).annaino, SortOrder.ASC));
        List<IT_AnsyuRireki> copyList = new ArrayList<IT_AnsyuRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuRireki(orders));
        return copyList;
    }

    public List<IT_AnsyuRireki> OrderIT_AnsyuRirekiByPkDesc(List<IT_AnsyuRireki> pEntity) {
        List<SortCondition<IT_AnsyuRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).nyknaiyoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).jyuutouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).annaino, SortOrder.DESC));
        List<IT_AnsyuRireki> copyList = new ArrayList<IT_AnsyuRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuRireki(orders));
        return copyList;
    }

    public List<IT_AnsyuRireki> OrderIT_AnsyuRirekiByAnnaisakuseiymdJyuutouymAnnainoDesc(List<IT_AnsyuRireki> pEntity) {
        List<SortCondition<IT_AnsyuRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).annaisakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).jyuutouym, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).annaino, SortOrder.DESC));
        List<IT_AnsyuRireki> copyList = new ArrayList<IT_AnsyuRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuRireki(orders));
        return copyList;
    }
    public List<IT_AnsyuRireki> OrderIT_AnsyuRirekiByJyuutouymDesc(List<IT_AnsyuRireki> pEntity) {
        List<SortCondition<IT_AnsyuRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_AnsyuRireki()).jyuutouym, SortOrder.DESC));
        List<IT_AnsyuRireki> copyList = new ArrayList<IT_AnsyuRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_AnsyuRireki(orders));
        return copyList;
    }

}

