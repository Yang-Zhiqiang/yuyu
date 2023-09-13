package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_KhKouzahuriAnnaiData;
import yuyu.def.db.meta.QIT_KhKouzahuriAnnaiData;
import yuyu.def.hozen.comparator.OrderIT_KhKouzahuriAnnaiData;

public class SortIT_KhKouzahuriAnnaiData {

    public List<IT_KhKouzahuriAnnaiData> OrderIT_KhKouzahuriAnnaiDataByPkAsc(List<IT_KhKouzahuriAnnaiData> pEntity) {
        List<SortCondition<IT_KhKouzahuriAnnaiData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).ansyuusyskbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).syoriYmd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).nyknaiyoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).jyuutouym, SortOrder.ASC));
        List<IT_KhKouzahuriAnnaiData> copyList = new ArrayList<IT_KhKouzahuriAnnaiData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhKouzahuriAnnaiData(orders));
        return copyList;
    }

    public List<IT_KhKouzahuriAnnaiData> OrderIT_KhKouzahuriAnnaiDataByPkDesc(List<IT_KhKouzahuriAnnaiData> pEntity) {
        List<SortCondition<IT_KhKouzahuriAnnaiData>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).ansyuusyskbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).syoriYmd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).nyknaiyoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_KhKouzahuriAnnaiData()).jyuutouym, SortOrder.DESC));
        List<IT_KhKouzahuriAnnaiData> copyList = new ArrayList<IT_KhKouzahuriAnnaiData>(pEntity);
        Collections.sort(copyList, new OrderIT_KhKouzahuriAnnaiData(orders));
        return copyList;
    }
}
