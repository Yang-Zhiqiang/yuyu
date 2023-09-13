package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhUriageKekkaData;
import yuyu.def.db.meta.QIT_KhUriageKekkaData;
import yuyu.def.hozen.comparator.OrderIT_KhUriageKekkaData;

public class SortIT_KhUriageKekkaData {

    public List<IT_KhUriageKekkaData> OrderIT_KhUriageKekkaDataByPkAsc(List<IT_KhUriageKekkaData> pEntity) {
        List<SortCondition<IT_KhUriageKekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhUriageKekkaData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhUriageKekkaData()).uriagekekkadatarenno, SortOrder.ASC));
        List<IT_KhUriageKekkaData> copyList = new ArrayList<IT_KhUriageKekkaData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhUriageKekkaData(orders));
        return copyList;
    }

    public List<IT_KhUriageKekkaData> OrderIT_KhUriageKekkaDataByPkDesc(List<IT_KhUriageKekkaData> pEntity) {
        List<SortCondition<IT_KhUriageKekkaData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhUriageKekkaData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhUriageKekkaData()).uriagekekkadatarenno, SortOrder.DESC));
        List<IT_KhUriageKekkaData> copyList = new ArrayList<IT_KhUriageKekkaData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhUriageKekkaData(orders));
        return copyList;
    }

}

