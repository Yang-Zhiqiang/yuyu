package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_SyouhnTokujouRireki;
import yuyu.def.db.meta.QIT_BAK_SyouhnTokujouRireki;
import yuyu.def.hozen.comparator.OrderIT_BAK_SyouhnTokujouRireki;

public class SortIT_BAK_SyouhnTokujouRireki {

    public List<IT_BAK_SyouhnTokujouRireki> OrderIT_BAK_SyouhnTokujouRirekiByPkAsc(List<IT_BAK_SyouhnTokujouRireki> pEntity) {
        List<SortCondition<IT_BAK_SyouhnTokujouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).kyksyouhnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).henkousikibetukey, SortOrder.ASC));
        List<IT_BAK_SyouhnTokujouRireki> copyList = new ArrayList<IT_BAK_SyouhnTokujouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_SyouhnTokujouRireki(orders));
        return copyList;
    }

    public List<IT_BAK_SyouhnTokujouRireki> OrderIT_BAK_SyouhnTokujouRirekiByPkDesc(List<IT_BAK_SyouhnTokujouRireki> pEntity) {
        List<SortCondition<IT_BAK_SyouhnTokujouRireki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).kyksyouhnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujouRireki()).henkousikibetukey, SortOrder.DESC));
        List<IT_BAK_SyouhnTokujouRireki> copyList = new ArrayList<IT_BAK_SyouhnTokujouRireki>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_SyouhnTokujouRireki(orders));
        return copyList;
    }

}

