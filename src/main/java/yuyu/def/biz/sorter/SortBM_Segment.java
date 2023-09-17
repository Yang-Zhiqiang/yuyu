package yuyu.def.biz.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.biz.comparator.OrderBM_Segment;
import yuyu.def.db.entity.BM_Segment;
import yuyu.def.db.meta.QBM_Segment;

public class SortBM_Segment {

    public List<BM_Segment> OrderBM_SegmentByPkAsc(List<BM_Segment> pEntity) {
        List<SortCondition<BM_Segment>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Segment()).segcd, SortOrder.ASC));
        List<BM_Segment> copyList = new ArrayList<BM_Segment>(pEntity);
        Collections.sort(copyList, new OrderBM_Segment(orders));
        return copyList;
    }

    public List<BM_Segment> OrderBM_SegmentByPkDesc(List<BM_Segment> pEntity) {
        List<SortCondition<BM_Segment>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QBM_Segment()).segcd, SortOrder.DESC));
        List<BM_Segment> copyList = new ArrayList<BM_Segment>(pEntity);
        Collections.sort(copyList, new OrderBM_Segment(orders));
        return copyList;
    }

}

