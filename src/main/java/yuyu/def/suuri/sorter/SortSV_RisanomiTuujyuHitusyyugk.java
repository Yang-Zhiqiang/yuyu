package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
import yuyu.def.db.meta.QSV_RisanomiTuujyuHitusyyugk;
import yuyu.def.suuri.comparator.OrderSV_RisanomiTuujyuHitusyyugk;

public class SortSV_RisanomiTuujyuHitusyyugk {

    
    public List<SV_RisanomiTuujyuHitusyyugk> OrderSV_RisanomiTuujyuHitusyyugkByPkAsc(List<SV_RisanomiTuujyuHitusyyugk> pEntity) {
        List<SortCondition<SV_RisanomiTuujyuHitusyyugk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).kyksyouhnrenno, SortOrder.ASC));
        List<SV_RisanomiTuujyuHitusyyugk> copyList = new ArrayList<SV_RisanomiTuujyuHitusyyugk>(pEntity);
        Collections.sort(copyList, new OrderSV_RisanomiTuujyuHitusyyugk(orders));
        return copyList;
    }

    
    public List<SV_RisanomiTuujyuHitusyyugk> OrderSV_RisanomiTuujyuHitusyyugkByPkDesc(List<SV_RisanomiTuujyuHitusyyugk> pEntity) {
        List<SortCondition<SV_RisanomiTuujyuHitusyyugk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_RisanomiTuujyuHitusyyugk()).kyksyouhnrenno, SortOrder.DESC));
        List<SV_RisanomiTuujyuHitusyyugk> copyList = new ArrayList<SV_RisanomiTuujyuHitusyyugk>(pEntity);
        Collections.sort(copyList, new OrderSV_RisanomiTuujyuHitusyyugk(orders));
        return copyList;
    }
}
