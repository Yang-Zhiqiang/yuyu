package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KawaseRateTuutiData;
import yuyu.def.db.meta.QIT_KawaseRateTuutiData;
import yuyu.def.hozen.comparator.OrderIT_KawaseRateTuutiData;

public class SortIT_KawaseRateTuutiData {

    public List<IT_KawaseRateTuutiData> OrderIT_KawaseRateTuutiDataByPkAsc(List<IT_KawaseRateTuutiData> pEntity) {
        List<SortCondition<IT_KawaseRateTuutiData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KawaseRateTuutiData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KawaseRateTuutiData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KawaseRateTuutiData()).tyouhyouymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KawaseRateTuutiData()).renno, SortOrder.ASC));
        List<IT_KawaseRateTuutiData> copyList = new ArrayList<IT_KawaseRateTuutiData>(pEntity);
        Collections.sort(copyList, new OrderIT_KawaseRateTuutiData(orders));
        return copyList;
    }

    public List<IT_KawaseRateTuutiData> OrderIT_KawaseRateTuutiDataByPkDesc(List<IT_KawaseRateTuutiData> pEntity) {
        List<SortCondition<IT_KawaseRateTuutiData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KawaseRateTuutiData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KawaseRateTuutiData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KawaseRateTuutiData()).tyouhyouymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KawaseRateTuutiData()).renno, SortOrder.DESC));
        List<IT_KawaseRateTuutiData> copyList = new ArrayList<IT_KawaseRateTuutiData>(pEntity);
        Collections.sort(copyList, new OrderIT_KawaseRateTuutiData(orders));
        return copyList;
    }
}
