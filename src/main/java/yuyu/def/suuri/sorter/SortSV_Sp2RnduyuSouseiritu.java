package yuyu.def.suuri.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.SV_Sp2RnduyuSouseiritu;
import yuyu.def.db.meta.QSV_Sp2RnduyuSouseiritu;
import yuyu.def.suuri.comparator.OrderSV_Sp2RnduyuSouseiritu;

public class SortSV_Sp2RnduyuSouseiritu {

    
    public List<SV_Sp2RnduyuSouseiritu> OrderSV_Sp2RnduyuSouseirituByPkAsc(List<SV_Sp2RnduyuSouseiritu> pEntity) {
        List<SortCondition<SV_Sp2RnduyuSouseiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_Sp2RnduyuSouseiritu()).mosno, SortOrder.ASC));
        List<SV_Sp2RnduyuSouseiritu> copyList = new ArrayList<SV_Sp2RnduyuSouseiritu>(pEntity);
        Collections.sort(copyList, new OrderSV_Sp2RnduyuSouseiritu(orders));
        return copyList;
    }

    
    public List<SV_Sp2RnduyuSouseiritu> OrderSV_Sp2RnduyuSouseirituByPkDesc(List<SV_Sp2RnduyuSouseiritu> pEntity) {
        List<SortCondition<SV_Sp2RnduyuSouseiritu>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QSV_Sp2RnduyuSouseiritu()).mosno, SortOrder.DESC));
        List<SV_Sp2RnduyuSouseiritu> copyList = new ArrayList<SV_Sp2RnduyuSouseiritu>(pEntity);
        Collections.sort(copyList, new OrderSV_Sp2RnduyuSouseiritu(orders));
        return copyList;
    }
}
