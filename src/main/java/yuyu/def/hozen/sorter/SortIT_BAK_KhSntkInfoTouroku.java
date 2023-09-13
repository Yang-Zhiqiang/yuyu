package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhSntkInfoTouroku;
import yuyu.def.db.meta.QIT_BAK_KhSntkInfoTouroku;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhSntkInfoTouroku;

public class SortIT_BAK_KhSntkInfoTouroku {

    public List<IT_BAK_KhSntkInfoTouroku> OrderIT_BAK_KhSntkInfoTourokuByPkAsc(List<IT_BAK_KhSntkInfoTouroku> pEntity) {
        List<SortCondition<IT_BAK_KhSntkInfoTouroku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhSntkInfoTouroku()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSntkInfoTouroku()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSntkInfoTouroku()).renno, SortOrder.ASC));
        List<IT_BAK_KhSntkInfoTouroku> copyList = new ArrayList<IT_BAK_KhSntkInfoTouroku>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhSntkInfoTouroku(orders));
        return copyList;
    }

    public List<IT_BAK_KhSntkInfoTouroku> OrderIT_BAK_KhSntkInfoTourokuByPkDesc(List<IT_BAK_KhSntkInfoTouroku> pEntity) {
        List<SortCondition<IT_BAK_KhSntkInfoTouroku>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhSntkInfoTouroku()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSntkInfoTouroku()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhSntkInfoTouroku()).renno, SortOrder.DESC));
        List<IT_BAK_KhSntkInfoTouroku> copyList = new ArrayList<IT_BAK_KhSntkInfoTouroku>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhSntkInfoTouroku(orders));
        return copyList;
    }

}

