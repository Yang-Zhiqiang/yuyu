package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.entity.BT_KijituTuriHnbnKnsouTutJk;
import yuyu.def.db.meta.QBT_KijituTuriHnbnKnsouTutJk;

public class SortBT_KijituTuriHnbnKnsouTutJk {

    public List<BT_KijituTuriHnbnKnsouTutJk> OrderBT_KijituTuriHnbnKnsouTutJkByPkAsc(List<BT_KijituTuriHnbnKnsouTutJk> pEntity) {
        List<SortCondition<BT_KijituTuriHnbnKnsouTutJk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTutJk()).subSystemId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTutJk()).tysytno, SortOrder.ASC));
        List<BT_KijituTuriHnbnKnsouTutJk> copyList = new ArrayList<BT_KijituTuriHnbnKnsouTutJk>(pEntity);
        Collections.sort(copyList, new OrderBT_KijituTuriHnbnKnsouTutJk(orders));
        return copyList;
    }

    public List<BT_KijituTuriHnbnKnsouTutJk> OrderBT_KijituTuriHnbnKnsouTutJkByPkDesc(List<BT_KijituTuriHnbnKnsouTutJk> pEntity) {
        List<SortCondition<BT_KijituTuriHnbnKnsouTutJk>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTutJk()).subSystemId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBT_KijituTuriHnbnKnsouTutJk()).tysytno, SortOrder.DESC));
        List<BT_KijituTuriHnbnKnsouTutJk> copyList = new ArrayList<BT_KijituTuriHnbnKnsouTutJk>(pEntity);
        Collections.sort(copyList, new OrderBT_KijituTuriHnbnKnsouTutJk(orders));
        return copyList;
    }
}
