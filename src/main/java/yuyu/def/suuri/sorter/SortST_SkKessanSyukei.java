package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.db.meta.QST_SkKessanSyukei;
import yuyu.def.suuri.comparator.OrderST_SkKessanSyukei;

public class SortST_SkKessanSyukei {

    
    public List<ST_SkKessanSyukei> OrderST_SkKessanSyukeiByPkAsc(List<ST_SkKessanSyukei> pEntity) {
        List<SortCondition<ST_SkKessanSyukei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).mosno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).denymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).kanjyoukmkcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).taisyakukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).naibukeiyakukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).tekiyoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).seg1cd, SortOrder.ASC));
        List<ST_SkKessanSyukei> copyList = new ArrayList<ST_SkKessanSyukei>(pEntity);
        Collections.sort(copyList, new OrderST_SkKessanSyukei(orders));
        return copyList;
    }

    
    public List<ST_SkKessanSyukei> OrderST_SkKessanSyukeiByPkDesc(List<ST_SkKessanSyukei> pEntity) {
        List<SortCondition<ST_SkKessanSyukei>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).mosno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).denymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).kanjyoukmkcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).taisyakukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).naibukeiyakukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).tekiyoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkKessanSyukei()).seg1cd, SortOrder.DESC));
        List<ST_SkKessanSyukei> copyList = new ArrayList<ST_SkKessanSyukei>(pEntity);
        Collections.sort(copyList, new OrderST_SkKessanSyukei(orders));
        return copyList;
    }

}

