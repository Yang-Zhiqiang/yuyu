package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_SegmentSikinidou;
import yuyu.def.db.entity.BM_SegmentSikinidou;
import yuyu.def.db.meta.QBM_SegmentSikinidou;

public class SortBM_SegmentSikinidou {

    public List<BM_SegmentSikinidou> OrderBM_SegmentSikinidouByPkAsc(List<BM_SegmentSikinidou> pEntity) {
        List<SortCondition<BM_SegmentSikinidou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SegmentSikinidou()).segcd, SortOrder.ASC));
        List<BM_SegmentSikinidou> copyList = new ArrayList<BM_SegmentSikinidou>(pEntity);
        Collections.sort(copyList, new OrderBM_SegmentSikinidou(orders));
        return copyList;
    }

    public List<BM_SegmentSikinidou> OrderBM_SegmentSikinidouByPkDesc(List<BM_SegmentSikinidou> pEntity) {
        List<SortCondition<BM_SegmentSikinidou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_SegmentSikinidou()).segcd, SortOrder.DESC));
        List<BM_SegmentSikinidou> copyList = new ArrayList<BM_SegmentSikinidou>(pEntity);
        Collections.sort(copyList, new OrderBM_SegmentSikinidou(orders));
        return copyList;
    }
}
