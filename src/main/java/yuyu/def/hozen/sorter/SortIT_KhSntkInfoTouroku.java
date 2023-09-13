package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.def.db.meta.QIT_KhSntkInfoTouroku;
import yuyu.def.hozen.comparator.OrderIT_KhSntkInfoTouroku;

public class SortIT_KhSntkInfoTouroku {

    public List<IT_KhSntkInfoTouroku> OrderIT_KhSntkInfoTourokuByPkAsc(List<IT_KhSntkInfoTouroku> pEntity) {
        List<SortCondition<IT_KhSntkInfoTouroku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhSntkInfoTouroku()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhSntkInfoTouroku()).renno, SortOrder.ASC));
        List<IT_KhSntkInfoTouroku> copyList = new ArrayList<IT_KhSntkInfoTouroku>(pEntity);
        Collections.sort(copyList, new OrderIT_KhSntkInfoTouroku(orders));
        return copyList;
    }

    public List<IT_KhSntkInfoTouroku> OrderIT_KhSntkInfoTourokuByPkDesc(List<IT_KhSntkInfoTouroku> pEntity) {
        List<SortCondition<IT_KhSntkInfoTouroku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhSntkInfoTouroku()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhSntkInfoTouroku()).renno, SortOrder.DESC));
        List<IT_KhSntkInfoTouroku> copyList = new ArrayList<IT_KhSntkInfoTouroku>(pEntity);
        Collections.sort(copyList, new OrderIT_KhSntkInfoTouroku(orders));
        return copyList;
    }

}

