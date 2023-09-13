package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_SyouhnTokujou;
import yuyu.def.db.meta.QIT_BAK_SyouhnTokujou;
import yuyu.def.hozen.comparator.OrderIT_BAK_SyouhnTokujou;

public class SortIT_BAK_SyouhnTokujou {

    public List<IT_BAK_SyouhnTokujou> OrderIT_BAK_SyouhnTokujouByPkAsc(List<IT_BAK_SyouhnTokujou> pEntity) {
        List<SortCondition<IT_BAK_SyouhnTokujou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_BAK_SyouhnTokujou> copyList = new ArrayList<IT_BAK_SyouhnTokujou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_SyouhnTokujou(orders));
        return copyList;
    }

    public List<IT_BAK_SyouhnTokujou> OrderIT_BAK_SyouhnTokujouByPkDesc(List<IT_BAK_SyouhnTokujou> pEntity) {
        List<SortCondition<IT_BAK_SyouhnTokujou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_SyouhnTokujou()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_BAK_SyouhnTokujou> copyList = new ArrayList<IT_BAK_SyouhnTokujou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_SyouhnTokujou(orders));
        return copyList;
    }

}

