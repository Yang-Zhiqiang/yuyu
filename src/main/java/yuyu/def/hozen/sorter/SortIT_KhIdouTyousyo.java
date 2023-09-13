package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhIdouTyousyo;
import yuyu.def.db.meta.QIT_KhIdouTyousyo;
import yuyu.def.hozen.comparator.OrderIT_KhIdouTyousyo;

public class SortIT_KhIdouTyousyo {

    public List<IT_KhIdouTyousyo> OrderIT_KhIdouTyousyoByPkAsc(List<IT_KhIdouTyousyo> pEntity) {
        List<SortCondition<IT_KhIdouTyousyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhIdouTyousyo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhIdouTyousyo()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhIdouTyousyo()).shrtysyrenno, SortOrder.ASC));
        List<IT_KhIdouTyousyo> copyList = new ArrayList<IT_KhIdouTyousyo>(pEntity);
        Collections.sort(copyList, new OrderIT_KhIdouTyousyo(orders));
        return copyList;
    }

    public List<IT_KhIdouTyousyo> OrderIT_KhIdouTyousyoByPkDesc(List<IT_KhIdouTyousyo> pEntity) {
        List<SortCondition<IT_KhIdouTyousyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhIdouTyousyo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhIdouTyousyo()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhIdouTyousyo()).shrtysyrenno, SortOrder.DESC));
        List<IT_KhIdouTyousyo> copyList = new ArrayList<IT_KhIdouTyousyo>(pEntity);
        Collections.sort(copyList, new OrderIT_KhIdouTyousyo(orders));
        return copyList;
    }
}
