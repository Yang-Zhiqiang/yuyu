package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.meta.QIT_KhTyouhyouHonbanKakunin;
import yuyu.def.hozen.comparator.OrderIT_KhTyouhyouHonbanKakunin;

public class SortIT_KhTyouhyouHonbanKakunin {

    public List<IT_KhTyouhyouHonbanKakunin> OrderIT_KhTyouhyouHonbanKakuninByPkAsc(List<IT_KhTyouhyouHonbanKakunin> pEntity) {
        List<SortCondition<IT_KhTyouhyouHonbanKakunin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).tyouhyoubunrui, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).syoruiCd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).jyoukenbunrui1, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).jyoukenbunrui2, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).jyoukenbunrui3, SortOrder.ASC));
        List<IT_KhTyouhyouHonbanKakunin> copyList = new ArrayList<IT_KhTyouhyouHonbanKakunin>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTyouhyouHonbanKakunin(orders));
        return copyList;
    }

    public List<IT_KhTyouhyouHonbanKakunin> OrderIT_KhTyouhyouHonbanKakuninByPkDesc(List<IT_KhTyouhyouHonbanKakunin> pEntity) {
        List<SortCondition<IT_KhTyouhyouHonbanKakunin>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).tyouhyoubunrui, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).syoruiCd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).jyoukenbunrui1, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).jyoukenbunrui2, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTyouhyouHonbanKakunin()).jyoukenbunrui3, SortOrder.DESC));
        List<IT_KhTyouhyouHonbanKakunin> copyList = new ArrayList<IT_KhTyouhyouHonbanKakunin>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTyouhyouHonbanKakunin(orders));
        return copyList;
    }
}
