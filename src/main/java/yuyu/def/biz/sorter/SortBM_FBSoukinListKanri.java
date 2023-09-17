package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_FBSoukinListKanri;
import yuyu.def.db.entity.BM_FBSoukinListKanri;
import yuyu.def.db.meta.QBM_FBSoukinListKanri;

public class SortBM_FBSoukinListKanri {

    public List<BM_FBSoukinListKanri> OrderBM_FBSoukinListKanriByPkAsc(List<BM_FBSoukinListKanri> pEntity) {
        List<SortCondition<BM_FBSoukinListKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FBSoukinListKanri()).syoricd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QBM_FBSoukinListKanri()).syorisosikicd, SortOrder.ASC));
        List<BM_FBSoukinListKanri> copyList = new ArrayList<BM_FBSoukinListKanri>(pEntity);
        Collections.sort(copyList, new OrderBM_FBSoukinListKanri(orders));
        return copyList;
    }

    public List<BM_FBSoukinListKanri> OrderBM_FBSoukinListKanriByPkDesc(List<BM_FBSoukinListKanri> pEntity) {
        List<SortCondition<BM_FBSoukinListKanri>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_FBSoukinListKanri()).syoricd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QBM_FBSoukinListKanri()).syorisosikicd, SortOrder.DESC));
        List<BM_FBSoukinListKanri> copyList = new ArrayList<BM_FBSoukinListKanri>(pEntity);
        Collections.sort(copyList, new OrderBM_FBSoukinListKanri(orders));
        return copyList;
    }
}
