package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAT_BatchLogFile;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AT_BatchLogFile;
import yuyu.def.db.meta.QAT_BatchLogFile;

public class SortAT_BatchLogFile {

    public List<AT_BatchLogFile> OrderAT_BatchLogFileByPkAsc(List<AT_BatchLogFile> pEntity) {
        List<SortCondition<AT_BatchLogFile>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchLogFile()).batchJobId, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAT_BatchLogFile()).uniqueId, SortOrder.ASC));
        List<AT_BatchLogFile> copyList = new ArrayList<AT_BatchLogFile>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchLogFile(orders));
        return copyList;
    }

    public List<AT_BatchLogFile> OrderAT_BatchLogFileByPkDesc(List<AT_BatchLogFile> pEntity) {
        List<SortCondition<AT_BatchLogFile>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAT_BatchLogFile()).batchJobId, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAT_BatchLogFile()).uniqueId, SortOrder.DESC));
        List<AT_BatchLogFile> copyList = new ArrayList<AT_BatchLogFile>(pEntity);
        Collections.sort(copyList, new OrderAT_BatchLogFile(orders));
        return copyList;
    }
}
