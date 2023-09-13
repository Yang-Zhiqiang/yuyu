package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KykSyouhnRireki;
import yuyu.def.db.meta.QIT_BAK_KykSyouhnRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_KykSyouhnRireki;

public class SortIT_BAK_KykSyouhnRireki {

    public List<IT_BAK_KykSyouhnRireki> OrderIT_BAK_KykSyouhnRirekiByPkAsc(List<IT_BAK_KykSyouhnRireki> pEntity) {
        List<SortCondition<IT_BAK_KykSyouhnRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).kyksyouhnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_KykSyouhnRireki> copyList = new ArrayList<IT_BAK_KykSyouhnRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSyouhnRireki(orders));
        return copyList;
    }

    public List<IT_BAK_KykSyouhnRireki> OrderIT_BAK_KykSyouhnRirekiByPkDesc(List<IT_BAK_KykSyouhnRireki> pEntity) {
        List<SortCondition<IT_BAK_KykSyouhnRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).kyksyouhnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhnRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_KykSyouhnRireki> copyList = new ArrayList<IT_BAK_KykSyouhnRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSyouhnRireki(orders));
        return copyList;
    }

}

