package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhTyousyo;
import yuyu.def.db.meta.QIT_KhTyousyo;
import yuyu.def.hozen.comparator.OrderIT_KhTyousyo;

public class SortIT_KhTyousyo {

    public List<IT_KhTyousyo> OrderIT_KhTyousyoByPkAsc(List<IT_KhTyousyo> pEntity) {
        List<SortCondition<IT_KhTyousyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTyousyo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTyousyo()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhTyousyo()).shrtysyrenno, SortOrder.ASC));
        List<IT_KhTyousyo> copyList = new ArrayList<IT_KhTyousyo>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTyousyo(orders));
        return copyList;
    }

    public List<IT_KhTyousyo> OrderIT_KhTyousyoByPkDesc(List<IT_KhTyousyo> pEntity) {
        List<SortCondition<IT_KhTyousyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhTyousyo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTyousyo()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhTyousyo()).shrtysyrenno, SortOrder.DESC));
        List<IT_KhTyousyo> copyList = new ArrayList<IT_KhTyousyo>(pEntity);
        Collections.sort(copyList, new OrderIT_KhTyousyo(orders));
        return copyList;
    }

}

