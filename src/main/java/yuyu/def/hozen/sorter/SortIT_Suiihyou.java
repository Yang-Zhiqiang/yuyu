package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.db.meta.QIT_Suiihyou;
import yuyu.def.hozen.comparator.OrderIT_Suiihyou;

public class SortIT_Suiihyou {

    public List<IT_Suiihyou> OrderIT_SuiihyouByPkAsc(List<IT_Suiihyou> pEntity) {
        List<SortCondition<IT_Suiihyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Suiihyou()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Suiihyou()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Suiihyou()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_Suiihyou()).keikanensuu, SortOrder.ASC));
        List<IT_Suiihyou> copyList = new ArrayList<IT_Suiihyou>(pEntity);
        Collections.sort(copyList, new OrderIT_Suiihyou(orders));
        return copyList;
    }

    public List<IT_Suiihyou> OrderIT_SuiihyouByPkDesc(List<IT_Suiihyou> pEntity) {
        List<SortCondition<IT_Suiihyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_Suiihyou()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Suiihyou()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Suiihyou()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_Suiihyou()).keikanensuu, SortOrder.DESC));
        List<IT_Suiihyou> copyList = new ArrayList<IT_Suiihyou>(pEntity);
        Collections.sort(copyList, new OrderIT_Suiihyou(orders));
        return copyList;
    }

}

