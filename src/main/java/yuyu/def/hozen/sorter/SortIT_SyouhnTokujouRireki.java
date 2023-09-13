package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SyouhnTokujouRireki;
import yuyu.def.db.meta.QIT_SyouhnTokujouRireki;
import yuyu.def.hozen.comparator.OrderIT_SyouhnTokujouRireki;

public class SortIT_SyouhnTokujouRireki {

    public List<IT_SyouhnTokujouRireki> OrderIT_SyouhnTokujouRirekiByPkAsc(List<IT_SyouhnTokujouRireki> pEntity) {
        List<SortCondition<IT_SyouhnTokujouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).kyksyouhnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_SyouhnTokujouRireki> copyList = new ArrayList<IT_SyouhnTokujouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_SyouhnTokujouRireki(orders));
        return copyList;
    }

    public List<IT_SyouhnTokujouRireki> OrderIT_SyouhnTokujouRirekiByPkDesc(List<IT_SyouhnTokujouRireki> pEntity) {
        List<SortCondition<IT_SyouhnTokujouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).kyksyouhnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujouRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_SyouhnTokujouRireki> copyList = new ArrayList<IT_SyouhnTokujouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_SyouhnTokujouRireki(orders));
        return copyList;
    }

}

