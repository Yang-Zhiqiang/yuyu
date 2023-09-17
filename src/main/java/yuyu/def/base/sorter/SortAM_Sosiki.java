package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAM_Sosiki;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AM_Sosiki;
import yuyu.def.db.meta.QAM_Sosiki;

public class SortAM_Sosiki {

    public List<AM_Sosiki> OrderAM_SosikiByPkAsc(List<AM_Sosiki> pEntity) {
        List<SortCondition<AM_Sosiki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_Sosiki()).sosikicd, SortOrder.ASC));
        List<AM_Sosiki> copyList = new ArrayList<AM_Sosiki>(pEntity);
        Collections.sort(copyList, new OrderAM_Sosiki(orders));
        return copyList;
    }

    public List<AM_Sosiki> OrderAM_SosikiByPkDesc(List<AM_Sosiki> pEntity) {
        List<SortCondition<AM_Sosiki>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAM_Sosiki()).sosikicd, SortOrder.DESC));
        List<AM_Sosiki> copyList = new ArrayList<AM_Sosiki>(pEntity);
        Collections.sort(copyList, new OrderAM_Sosiki(orders));
        return copyList;
    }
}
