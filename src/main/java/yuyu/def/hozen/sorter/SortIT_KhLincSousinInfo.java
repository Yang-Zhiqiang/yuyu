package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhLincSousinInfo;
import yuyu.def.db.meta.QIT_KhLincSousinInfo;
import yuyu.def.hozen.comparator.OrderIT_KhLincSousinInfo;

public class SortIT_KhLincSousinInfo {

    public List<IT_KhLincSousinInfo> OrderIT_KhLincSousinInfoByPkAsc(List<IT_KhLincSousinInfo> pEntity) {
        List<SortCondition<IT_KhLincSousinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhLincSousinInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinInfo()).lincsoujyusinsyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinInfo()).renno, SortOrder.ASC));
        List<IT_KhLincSousinInfo> copyList = new ArrayList<IT_KhLincSousinInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_KhLincSousinInfo(orders));
        return copyList;
    }

    public List<IT_KhLincSousinInfo> OrderIT_KhLincSousinInfoByPkDesc(List<IT_KhLincSousinInfo> pEntity) {
        List<SortCondition<IT_KhLincSousinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhLincSousinInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinInfo()).lincsoujyusinsyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhLincSousinInfo()).renno, SortOrder.DESC));
        List<IT_KhLincSousinInfo> copyList = new ArrayList<IT_KhLincSousinInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_KhLincSousinInfo(orders));
        return copyList;
    }

}

