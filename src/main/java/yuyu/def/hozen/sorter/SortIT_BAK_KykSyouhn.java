package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KykSyouhn;
import yuyu.def.db.meta.QIT_BAK_KykSyouhn;
import yuyu.def.hozen.comparator.OrderIT_BAK_KykSyouhn;

public class SortIT_BAK_KykSyouhn {

    public List<IT_BAK_KykSyouhn> OrderIT_BAK_KykSyouhnByPkAsc(List<IT_BAK_KykSyouhn> pEntity) {
        List<SortCondition<IT_BAK_KykSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_BAK_KykSyouhn> copyList = new ArrayList<IT_BAK_KykSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSyouhn(orders));
        return copyList;
    }

    public List<IT_BAK_KykSyouhn> OrderIT_BAK_KykSyouhnByPkDesc(List<IT_BAK_KykSyouhn> pEntity) {
        List<SortCondition<IT_BAK_KykSyouhn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KykSyouhn()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_BAK_KykSyouhn> copyList = new ArrayList<IT_BAK_KykSyouhn>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KykSyouhn(orders));
        return copyList;
    }

}

