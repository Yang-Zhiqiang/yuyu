package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.ST_SkOikmSyukeiPDenpyou;
import yuyu.def.db.meta.QST_SkOikmSyukeiPDenpyou;
import yuyu.def.suuri.comparator.OrderST_SkOikmSyukeiPDenpyou;

public class SortST_SkOikmSyukeiPDenpyou {

    
    public List<ST_SkOikmSyukeiPDenpyou> OrderST_SkOikmSyukeiPDenpyouByPkAsc(List<ST_SkOikmSyukeiPDenpyou> pEntity) {
        List<SortCondition<ST_SkOikmSyukeiPDenpyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SkOikmSyukeiPDenpyou()).densyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkOikmSyukeiPDenpyou()).denrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QST_SkOikmSyukeiPDenpyou()).edano, SortOrder.ASC));
        List<ST_SkOikmSyukeiPDenpyou> copyList = new ArrayList<ST_SkOikmSyukeiPDenpyou>(pEntity);
        Collections.sort(copyList, new OrderST_SkOikmSyukeiPDenpyou(orders));
        return copyList;
    }

    
    public List<ST_SkOikmSyukeiPDenpyou> OrderST_SkOikmSyukeiPDenpyouByPkDesc(List<ST_SkOikmSyukeiPDenpyou> pEntity) {
        List<SortCondition<ST_SkOikmSyukeiPDenpyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QST_SkOikmSyukeiPDenpyou()).densyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkOikmSyukeiPDenpyou()).denrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QST_SkOikmSyukeiPDenpyou()).edano, SortOrder.DESC));
        List<ST_SkOikmSyukeiPDenpyou> copyList = new ArrayList<ST_SkOikmSyukeiPDenpyou>(pEntity);
        Collections.sort(copyList, new OrderST_SkOikmSyukeiPDenpyou(orders));
        return copyList;
    }

}

