package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;
import yuyu.def.db.meta.QBM_KinyuuKikanHuhoyofuriInfo;

public class SortBM_KinyuuKikanHuhoyofuriInfo {

    public List<BM_KinyuuKikanHuhoyofuriInfo> OrderBM_KinyuuKikanHuhoyofuriInfoByPkAsc(List<BM_KinyuuKikanHuhoyofuriInfo> pEntity) {
        List<SortCondition<BM_KinyuuKikanHuhoyofuriInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KinyuuKikanHuhoyofuriInfo()).bankcd, SortOrder.ASC));
        List<BM_KinyuuKikanHuhoyofuriInfo> copyList = new ArrayList<BM_KinyuuKikanHuhoyofuriInfo>(pEntity);
        Collections.sort(copyList, new OrderBM_KinyuuKikanHuhoyofuriInfo(orders));
        return copyList;
    }

    public List<BM_KinyuuKikanHuhoyofuriInfo> OrderBM_KinyuuKikanHuhoyofuriInfoByPkDesc(List<BM_KinyuuKikanHuhoyofuriInfo> pEntity) {
        List<SortCondition<BM_KinyuuKikanHuhoyofuriInfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_KinyuuKikanHuhoyofuriInfo()).bankcd, SortOrder.DESC));
        List<BM_KinyuuKikanHuhoyofuriInfo> copyList = new ArrayList<BM_KinyuuKikanHuhoyofuriInfo>(pEntity);
        Collections.sort(copyList, new OrderBM_KinyuuKikanHuhoyofuriInfo(orders));
        return copyList;
    }
}
