package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_FileServerInfo;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_FileServerInfo;
import yuyu.def.db.meta.QAS_FileServerInfo;

public class SortAS_FileServerInfo {

    public List<AS_FileServerInfo> OrderAS_FileServerInfoByPkAsc(List<AS_FileServerInfo> pEntity) {
        List<SortCondition<AS_FileServerInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_FileServerInfo()).setteiNo, SortOrder.ASC));
        orders.add(new SortCondition<>((new QAS_FileServerInfo()).tekiyouYmdFrom, SortOrder.ASC));
        List<AS_FileServerInfo> copyList = new ArrayList<AS_FileServerInfo>(pEntity);
        Collections.sort(copyList, new OrderAS_FileServerInfo(orders));
        return copyList;
    }

    public List<AS_FileServerInfo> OrderAS_FileServerInfoByPkDesc(List<AS_FileServerInfo> pEntity) {
        List<SortCondition<AS_FileServerInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_FileServerInfo()).setteiNo, SortOrder.DESC));
        orders.add(new SortCondition<>((new QAS_FileServerInfo()).tekiyouYmdFrom, SortOrder.DESC));
        List<AS_FileServerInfo> copyList = new ArrayList<AS_FileServerInfo>(pEntity);
        Collections.sort(copyList, new OrderAS_FileServerInfo(orders));
        return copyList;
    }
}
