package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_TRNyuukin;
import yuyu.def.db.meta.QIT_TRNyuukin;
import yuyu.def.hozen.comparator.OrderIT_TRNyuukin;

public class SortIT_TRNyuukin {

    public List<IT_TRNyuukin> OrderIT_TRNyuukinByPkAsc(List<IT_TRNyuukin> pEntity) {
        List<SortCondition<IT_TRNyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).nyktrrenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).datarenno, SortOrder.ASC));
        List<IT_TRNyuukin> copyList = new ArrayList<IT_TRNyuukin>(pEntity);
        Collections.sort(copyList, new OrderIT_TRNyuukin(orders));
        return copyList;
    }

    public List<IT_TRNyuukin> OrderIT_TRNyuukinByPkDesc(List<IT_TRNyuukin> pEntity) {
        List<SortCondition<IT_TRNyuukin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).nyktrrenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_TRNyuukin()).datarenno, SortOrder.DESC));
        List<IT_TRNyuukin> copyList = new ArrayList<IT_TRNyuukin>(pEntity);
        Collections.sort(copyList, new OrderIT_TRNyuukin(orders));
        return copyList;
    }
}
