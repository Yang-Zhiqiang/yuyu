package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.meta.QHM_SkHokenSyuruiNo;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SkHokenSyuruiNo;

public class SortHM_SkHokenSyuruiNo {

    
    public List<HM_SkHokenSyuruiNo> OrderHM_SkHokenSyuruiNoByPkAsc(List<HM_SkHokenSyuruiNo> pEntity) {
        List<SortCondition<HM_SkHokenSyuruiNo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNo()).hknsyuruino, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNo()).hknsyuruinosd, SortOrder.ASC));
        List<HM_SkHokenSyuruiNo> copyList = new ArrayList<HM_SkHokenSyuruiNo>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHokenSyuruiNo(orders));
        return copyList;
    }

    
    public List<HM_SkHokenSyuruiNo> OrderHM_SkHokenSyuruiNoByPkDesc(List<HM_SkHokenSyuruiNo> pEntity) {
        List<SortCondition<HM_SkHokenSyuruiNo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNo()).hknsyuruino, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_SkHokenSyuruiNo()).hknsyuruinosd, SortOrder.DESC));
        List<HM_SkHokenSyuruiNo> copyList = new ArrayList<HM_SkHokenSyuruiNo>(pEntity);
        Collections.sort(copyList, new OrderHM_SkHokenSyuruiNo(orders));
        return copyList;
    }

}

