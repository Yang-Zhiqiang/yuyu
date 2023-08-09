package yuyu.def.zdb.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ZT_JigyounndsikiTkHoyuuRn;
import yuyu.def.db.meta.QZT_JigyounndsikiTkHoyuuRn;
import yuyu.def.zdb.comparator.OrderZT_JigyounndsikiTkHoyuuRn;

public class SortZT_JigyounndsikiTkHoyuuRn {

    
    public List<ZT_JigyounndsikiTkHoyuuRn> OrderZT_JigyounndsikiTkHoyuuRnByPkAsc(List<ZT_JigyounndsikiTkHoyuuRn> pEntity) {
        List<SortCondition<ZT_JigyounndsikiTkHoyuuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_JigyounndsikiTkHoyuuRn()).zrnsequenceno, SortOrder.ASC));
        List<ZT_JigyounndsikiTkHoyuuRn> copyList = new ArrayList<ZT_JigyounndsikiTkHoyuuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_JigyounndsikiTkHoyuuRn(orders));
        return copyList;
    }

    
    public List<ZT_JigyounndsikiTkHoyuuRn> OrderZT_JigyounndsikiTkHoyuuRnByPkDesc(List<ZT_JigyounndsikiTkHoyuuRn> pEntity) {
        List<SortCondition<ZT_JigyounndsikiTkHoyuuRn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QZT_JigyounndsikiTkHoyuuRn()).zrnsequenceno, SortOrder.DESC));
        List<ZT_JigyounndsikiTkHoyuuRn> copyList = new ArrayList<ZT_JigyounndsikiTkHoyuuRn>(pEntity);
        Collections.sort(copyList, new OrderZT_JigyounndsikiTkHoyuuRn(orders));
        return copyList;
    }
}
