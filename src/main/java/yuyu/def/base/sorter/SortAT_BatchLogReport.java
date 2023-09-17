package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_BatchLogReport;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_BatchLogReport;
import yuyu.def.db.meta.QAT_BatchLogReport;

public class SortAT_BatchLogReport {

    public List<AT_BatchLogReport> OrderAT_BatchLogReportByPkAsc(List<AT_BatchLogReport> pEntity) {
        List<SortCondition<AT_BatchLogReport>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchLogReport()).batchJobId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_BatchLogReport()).reportKey, SortOrder.ASC));
        List<AT_BatchLogReport> copyList = new ArrayList<AT_BatchLogReport>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchLogReport(orders));
        return copyList;
    }

    public List<AT_BatchLogReport> OrderAT_BatchLogReportByPkDesc(List<AT_BatchLogReport> pEntity) {
        List<SortCondition<AT_BatchLogReport>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchLogReport()).batchJobId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_BatchLogReport()).reportKey, SortOrder.DESC));
        List<AT_BatchLogReport> copyList = new ArrayList<AT_BatchLogReport>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchLogReport(orders));
        return copyList;
    }
}
