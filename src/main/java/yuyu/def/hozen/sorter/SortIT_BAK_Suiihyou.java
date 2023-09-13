package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_BAK_Suiihyou;
import yuyu.def.db.meta.QIT_BAK_Suiihyou;
import yuyu.def.hozen.comparator.OrderIT_BAK_Suiihyou;

public class SortIT_BAK_Suiihyou {

    public List<IT_BAK_Suiihyou> OrderIT_BAK_SuiihyouByPkAsc(List<IT_BAK_Suiihyou> pEntity) {
        List<SortCondition<IT_BAK_Suiihyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).trkssikibetukey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).keikanensuu, SortOrder.ASC));
        List<IT_BAK_Suiihyou> copyList = new ArrayList<IT_BAK_Suiihyou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Suiihyou(orders));
        return copyList;
    }

    public List<IT_BAK_Suiihyou> OrderIT_BAK_SuiihyouByPkDesc(List<IT_BAK_Suiihyou> pEntity) {
        List<SortCondition<IT_BAK_Suiihyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).trkssikibetukey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_BAK_Suiihyou()).keikanensuu, SortOrder.DESC));
        List<IT_BAK_Suiihyou> copyList = new ArrayList<IT_BAK_Suiihyou>(pEntity);
        Collections.sort(copyList, new OrderIT_BAK_Suiihyou(orders));
        return copyList;
    }

}

