package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.meta.QIT_KrkknSeibiTokusokuInfo;
import yuyu.def.hozen.comparator.OrderIT_KrkknSeibiTokusokuInfo;

public class SortIT_KrkknSeibiTokusokuInfo {

    public List<IT_KrkknSeibiTokusokuInfo> OrderIT_KrkknSeibiTokusokuInfoByPkAsc(List<IT_KrkknSeibiTokusokuInfo> pEntity) {
        List<SortCondition<IT_KrkknSeibiTokusokuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KrkknSeibiTokusokuInfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KrkknSeibiTokusokuInfo()).krkno, SortOrder.ASC));
        List<IT_KrkknSeibiTokusokuInfo> copyList = new ArrayList<IT_KrkknSeibiTokusokuInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_KrkknSeibiTokusokuInfo(orders));
        return copyList;
    }

    public List<IT_KrkknSeibiTokusokuInfo> OrderIT_KrkknSeibiTokusokuInfoByPkDesc(List<IT_KrkknSeibiTokusokuInfo> pEntity) {
        List<SortCondition<IT_KrkknSeibiTokusokuInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KrkknSeibiTokusokuInfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KrkknSeibiTokusokuInfo()).krkno, SortOrder.DESC));
        List<IT_KrkknSeibiTokusokuInfo> copyList = new ArrayList<IT_KrkknSeibiTokusokuInfo>(pEntity);
        Collections.sort(copyList, new OrderIT_KrkknSeibiTokusokuInfo(orders));
        return copyList;
    }
}
