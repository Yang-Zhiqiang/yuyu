package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhLincKihon;
import yuyu.def.db.meta.QIT_KhLincKihon;
import yuyu.def.hozen.comparator.OrderIT_KhLincKihon;

public class SortIT_KhLincKihon {

    public List<IT_KhLincKihon> OrderIT_KhLincKihonByPkAsc(List<IT_KhLincKihon> pEntity) {
        List<SortCondition<IT_KhLincKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhLincKihon()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhLincKihon()).syono, SortOrder.ASC));
        List<IT_KhLincKihon> copyList = new ArrayList<IT_KhLincKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_KhLincKihon(orders));
        return copyList;
    }

    public List<IT_KhLincKihon> OrderIT_KhLincKihonByPkDesc(List<IT_KhLincKihon> pEntity) {
        List<SortCondition<IT_KhLincKihon>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhLincKihon()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhLincKihon()).syono, SortOrder.DESC));
        List<IT_KhLincKihon> copyList = new ArrayList<IT_KhLincKihon>(pEntity);
        Collections.sort(copyList, new OrderIT_KhLincKihon(orders));
        return copyList;
    }
}
