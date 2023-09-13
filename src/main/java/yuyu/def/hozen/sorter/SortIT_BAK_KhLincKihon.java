package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhLincKihon;
import yuyu.def.db.meta.QIT_BAK_KhLincKihon;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhLincKihon;

public class SortIT_BAK_KhLincKihon {

    public List<IT_BAK_KhLincKihon> OrderIT_BAK_KhLincKihonByPkAsc(List<IT_BAK_KhLincKihon> pEntity) {
        List<SortCondition<IT_BAK_KhLincKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhLincKihon()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincKihon()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincKihon()).trkssikibetukey, SortOrder.ASC));
        List<IT_BAK_KhLincKihon> copyList = new ArrayList<IT_BAK_KhLincKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhLincKihon(orders));
        return copyList;
    }

    public List<IT_BAK_KhLincKihon> OrderIT_BAK_KhLincKihonByPkDesc(List<IT_BAK_KhLincKihon> pEntity) {
        List<SortCondition<IT_BAK_KhLincKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhLincKihon()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincKihon()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincKihon()).trkssikibetukey, SortOrder.DESC));
        List<IT_BAK_KhLincKihon> copyList = new ArrayList<IT_BAK_KhLincKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhLincKihon(orders));
        return copyList;
    }
}
