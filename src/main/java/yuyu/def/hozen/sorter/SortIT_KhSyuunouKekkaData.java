package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhSyuunouKekkaData;
import yuyu.def.db.meta.QIT_KhSyuunouKekkaData;
import yuyu.def.hozen.comparator.OrderIT_KhSyuunouKekkaData;

public class SortIT_KhSyuunouKekkaData {

    public List<IT_KhSyuunouKekkaData> OrderIT_KhSyuunouKekkaDataByPkAsc(List<IT_KhSyuunouKekkaData> pEntity) {
        List<SortCondition<IT_KhSyuunouKekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).jyuutouym, SortOrder.ASC));
        List<IT_KhSyuunouKekkaData> copyList = new ArrayList<IT_KhSyuunouKekkaData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhSyuunouKekkaData(orders));
        return copyList;
    }

    public List<IT_KhSyuunouKekkaData> OrderIT_KhSyuunouKekkaDataByPkDesc(List<IT_KhSyuunouKekkaData> pEntity) {
        List<SortCondition<IT_KhSyuunouKekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhSyuunouKekkaData()).jyuutouym, SortOrder.DESC));
        List<IT_KhSyuunouKekkaData> copyList = new ArrayList<IT_KhSyuunouKekkaData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhSyuunouKekkaData(orders));
        return copyList;
    }
}
