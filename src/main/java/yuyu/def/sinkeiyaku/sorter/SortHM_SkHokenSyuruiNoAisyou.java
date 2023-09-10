package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.meta.QHM_SkHokenSyuruiNoAisyou;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SkHokenSyuruiNoAisyou;

public class SortHM_SkHokenSyuruiNoAisyou {

    
    public List<HM_SkHokenSyuruiNoAisyou> OrderHM_SkHokenSyuruiNoAisyouByPkAsc(List<HM_SkHokenSyuruiNoAisyou> pEntity) {
        List<SortCondition<HM_SkHokenSyuruiNoAisyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).hknsyuruino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).hknsyuruinosdfrom, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).hknsyuruinosdto, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).hknsyuruinobetukey1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).aisyoumeichannelkbn, SortOrder.ASC));
        List<HM_SkHokenSyuruiNoAisyou> copyList = new ArrayList<HM_SkHokenSyuruiNoAisyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHokenSyuruiNoAisyou(orders));
        return copyList;
    }

    
    public List<HM_SkHokenSyuruiNoAisyou> OrderHM_SkHokenSyuruiNoAisyouByPkDesc(List<HM_SkHokenSyuruiNoAisyou> pEntity) {
        List<SortCondition<HM_SkHokenSyuruiNoAisyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).hknsyuruino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).hknsyuruinosdfrom, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).hknsyuruinosdto, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).hknsyuruinobetukey1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNoAisyou()).aisyoumeichannelkbn, SortOrder.DESC));
        List<HM_SkHokenSyuruiNoAisyou> copyList = new ArrayList<HM_SkHokenSyuruiNoAisyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHokenSyuruiNoAisyou(orders));
        return copyList;
    }
}
