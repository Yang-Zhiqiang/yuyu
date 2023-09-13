package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;
import yuyu.def.hozen.comparator.OrderIT_KykSyouhnRireki;

public class SortIT_KykSyouhnRireki {

    public List<IT_KykSyouhnRireki> OrderIT_KykSyouhnRirekiByPkAsc(List<IT_KykSyouhnRireki> pEntity) {
        List<SortCondition<IT_KykSyouhnRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).kyksyouhnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_KykSyouhnRireki> copyList = new ArrayList<IT_KykSyouhnRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyouhnRireki(orders));
        return copyList;
    }

    public List<IT_KykSyouhnRireki> OrderIT_KykSyouhnRirekiByPkDesc(List<IT_KykSyouhnRireki> pEntity) {
        List<SortCondition<IT_KykSyouhnRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).kyksyouhnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KykSyouhnRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_KykSyouhnRireki> copyList = new ArrayList<IT_KykSyouhnRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_KykSyouhnRireki(orders));
        return copyList;
    }

}

