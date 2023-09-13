package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_KhLincSousinInfo;
import yuyu.def.db.meta.QIT_BAK_KhLincSousinInfo;
import yuyu.def.hozen.comparator.OrderIT_BAK_KhLincSousinInfo;

public class SortIT_BAK_KhLincSousinInfo {

    public List<IT_BAK_KhLincSousinInfo> OrderIT_BAK_KhLincSousinInfoByPkAsc(List<IT_BAK_KhLincSousinInfo> pEntity) {
        List<SortCondition<IT_BAK_KhLincSousinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).lincsoujyusinsyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).renno, SortOrder.ASC));
        List<IT_BAK_KhLincSousinInfo> copyList = new ArrayList<IT_BAK_KhLincSousinInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhLincSousinInfo(orders));
        return copyList;
    }

    public List<IT_BAK_KhLincSousinInfo> OrderIT_BAK_KhLincSousinInfoByPkDesc(List<IT_BAK_KhLincSousinInfo> pEntity) {
        List<SortCondition<IT_BAK_KhLincSousinInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).lincsoujyusinsyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_KhLincSousinInfo()).renno, SortOrder.DESC));
        List<IT_BAK_KhLincSousinInfo> copyList = new ArrayList<IT_BAK_KhLincSousinInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_KhLincSousinInfo(orders));
        return copyList;
    }

}

