package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.meta.QSV_KiykSyuhnData;
import yuyu.def.suuri.comparator.OrderSV_KiykSyuhnData;

public class SortSV_KiykSyuhnData {

    
    public List<SV_KiykSyuhnData> OrderSV_KiykSyuhnDataByPkAsc(List<SV_KiykSyuhnData> pEntity) {
        List<SortCondition<SV_KiykSyuhnData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).syutkkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).syouhnsdno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).kyksyouhnrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).henkousikibetukey, SortOrder.ASC));
        List<SV_KiykSyuhnData> copyList = new ArrayList<SV_KiykSyuhnData>(pEntity);
        Collections.sort(copyList, new OrderSV_KiykSyuhnData(orders));
        return copyList;
    }

    
    public List<SV_KiykSyuhnData> OrderSV_KiykSyuhnDataByPkDesc(List<SV_KiykSyuhnData> pEntity) {
        List<SortCondition<SV_KiykSyuhnData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).syutkkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).syouhnsdno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).kyksyouhnrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).henkousikibetukey, SortOrder.DESC));
        List<SV_KiykSyuhnData> copyList = new ArrayList<SV_KiykSyuhnData>(pEntity);
        Collections.sort(copyList, new OrderSV_KiykSyuhnData(orders));
        return copyList;
    }
    
    public List<SV_KiykSyuhnData> OrderSV_KiykSyuhnDataByHenkousikibetukeyDesc(List<SV_KiykSyuhnData> pEntity) {
        List<SortCondition<SV_KiykSyuhnData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_KiykSyuhnData()).henkousikibetukey, SortOrder.DESC));
        List<SV_KiykSyuhnData> copyList = new ArrayList<SV_KiykSyuhnData>(pEntity);
        Collections.sort(copyList, new OrderSV_KiykSyuhnData(orders));
        return copyList;
    }

}
