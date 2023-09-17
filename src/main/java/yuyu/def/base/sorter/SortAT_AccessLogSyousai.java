package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_AccessLogSyousai;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.def.db.meta.QAT_AccessLogSyousai;

public class SortAT_AccessLogSyousai {

    public List<AT_AccessLogSyousai> OrderAT_AccessLogSyousaiByPkAsc(List<AT_AccessLogSyousai> pEntity) {
        List<SortCondition<AT_AccessLogSyousai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_AccessLogSyousai()).logId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_AccessLogSyousai()).syousaiEdaNo, SortOrder.ASC));
        List<AT_AccessLogSyousai> copyList = new ArrayList<AT_AccessLogSyousai>(pEntity);
        Collections.sort(copyList, new OrderAT_AccessLogSyousai(orders));
        return copyList;
    }

    public List<AT_AccessLogSyousai> OrderAT_AccessLogSyousaiByPkDesc(List<AT_AccessLogSyousai> pEntity) {
        List<SortCondition<AT_AccessLogSyousai>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_AccessLogSyousai()).logId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_AccessLogSyousai()).syousaiEdaNo, SortOrder.DESC));
        List<AT_AccessLogSyousai> copyList = new ArrayList<AT_AccessLogSyousai>(pEntity);
        Collections.sort(copyList, new OrderAT_AccessLogSyousai(orders));
        return copyList;
    }
}
