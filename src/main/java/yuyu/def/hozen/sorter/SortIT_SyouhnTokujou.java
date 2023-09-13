package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.meta.QIT_SyouhnTokujou;
import yuyu.def.hozen.comparator.OrderIT_SyouhnTokujou;

public class SortIT_SyouhnTokujou {

    public List<IT_SyouhnTokujou> OrderIT_SyouhnTokujouByPkAsc(List<IT_SyouhnTokujou> pEntity) {
        List<SortCondition<IT_SyouhnTokujou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).kyksyouhnrenno, SortOrder.ASC));
        List<IT_SyouhnTokujou> copyList = new ArrayList<IT_SyouhnTokujou>(pEntity);
        Collections.sort(copyList, new OrderIT_SyouhnTokujou(orders));
        return copyList;
    }

    public List<IT_SyouhnTokujou> OrderIT_SyouhnTokujouByPkDesc(List<IT_SyouhnTokujou> pEntity) {
        List<SortCondition<IT_SyouhnTokujou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_SyouhnTokujou()).kyksyouhnrenno, SortOrder.DESC));
        List<IT_SyouhnTokujou> copyList = new ArrayList<IT_SyouhnTokujou>(pEntity);
        Collections.sort(copyList, new OrderIT_SyouhnTokujou(orders));
        return copyList;
    }

}

