package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.def.db.meta.QST_SkOikmTyouseiDenpyou;
import yuyu.def.suuri.comparator.OrderST_SkOikmTyouseiDenpyou;

public class SortST_SkOikmTyouseiDenpyou {

    
    public List<ST_SkOikmTyouseiDenpyou> OrderST_SkOikmTyouseiDenpyouByPkAsc(List<ST_SkOikmTyouseiDenpyou> pEntity) {
        List<SortCondition<ST_SkOikmTyouseiDenpyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).kanjyoukmkcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).taisyakukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).naibukeiyakukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).tekiyoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).seg1cd, SortOrder.ASC));
        List<ST_SkOikmTyouseiDenpyou> copyList = new ArrayList<ST_SkOikmTyouseiDenpyou>(pEntity);
        Collections.sort(copyList, new OrderST_SkOikmTyouseiDenpyou(orders));
        return copyList;
    }

    
    public List<ST_SkOikmTyouseiDenpyou> OrderST_SkOikmTyouseiDenpyouByPkDesc(List<ST_SkOikmTyouseiDenpyou> pEntity) {
        List<SortCondition<ST_SkOikmTyouseiDenpyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).kanjyoukmkcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).taisyakukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).naibukeiyakukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).tekiyoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkOikmTyouseiDenpyou()).seg1cd, SortOrder.DESC));
        List<ST_SkOikmTyouseiDenpyou> copyList = new ArrayList<ST_SkOikmTyouseiDenpyou>(pEntity);
        Collections.sort(copyList, new OrderST_SkOikmTyouseiDenpyou(orders));
        return copyList;
    }

}

