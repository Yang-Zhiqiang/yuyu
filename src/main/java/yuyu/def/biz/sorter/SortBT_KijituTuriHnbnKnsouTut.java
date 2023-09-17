package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTut;
import yuyu.def.db.meta.QBT_KijituTuriHnbnKnsouTut;

public class SortBT_KijituTuriHnbnKnsouTut {

    public List<BT_KijituTuriHnbnKnsouTut> OrderBT_KijituTuriHnbnKnsouTutByPkAsc(List<BT_KijituTuriHnbnKnsouTut> pEntity) {
        List<SortCondition<BT_KijituTuriHnbnKnsouTut>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTut()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTut()).subSystemId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTut()).tysytno, SortOrder.ASC));
        List<BT_KijituTuriHnbnKnsouTut> copyList = new ArrayList<BT_KijituTuriHnbnKnsouTut>(pEntity);
        Collections.sort(copyList, new OrderBT_KijituTuriHnbnKnsouTut(orders));
        return copyList;
    }

    public List<BT_KijituTuriHnbnKnsouTut> OrderBT_KijituTuriHnbnKnsouTutByPkDesc(List<BT_KijituTuriHnbnKnsouTut> pEntity) {
        List<SortCondition<BT_KijituTuriHnbnKnsouTut>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTut()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTut()).subSystemId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTut()).tysytno, SortOrder.DESC));
        List<BT_KijituTuriHnbnKnsouTut> copyList = new ArrayList<BT_KijituTuriHnbnKnsouTut>(pEntity);
        Collections.sort(copyList, new OrderBT_KijituTuriHnbnKnsouTut(orders));
        return copyList;
    }
}
