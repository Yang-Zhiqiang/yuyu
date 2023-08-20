package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_TuujyuHitusyyugk;
import yuyu.def.db.meta.QSV_TuujyuHitusyyugk;
import yuyu.def.suuri.comparator.OrderSV_TuujyuHitusyyugk;

public class SortSV_TuujyuHitusyyugk {

    
    public List<SV_TuujyuHitusyyugk> OrderSV_TuujyuHitusyyugkByPkAsc(List<SV_TuujyuHitusyyugk> pEntity) {
        List<SortCondition<SV_TuujyuHitusyyugk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).kyksyouhnrenno, SortOrder.ASC));
        List<SV_TuujyuHitusyyugk> copyList = new ArrayList<SV_TuujyuHitusyyugk>(pEntity);
        Collections.sort(copyList, new OrderSV_TuujyuHitusyyugk(orders));
        return copyList;
    }

    
    public List<SV_TuujyuHitusyyugk> OrderSV_TuujyuHitusyyugkByPkDesc(List<SV_TuujyuHitusyyugk> pEntity) {
        List<SortCondition<SV_TuujyuHitusyyugk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_TuujyuHitusyyugk()).kyksyouhnrenno, SortOrder.DESC));
        List<SV_TuujyuHitusyyugk> copyList = new ArrayList<SV_TuujyuHitusyyugk>(pEntity);
        Collections.sort(copyList, new OrderSV_TuujyuHitusyyugk(orders));
        return copyList;
    }
}
