package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsHanyouKokTuutiError;
import yuyu.def.db.meta.QMT_DsHanyouKokTuutiError;
import yuyu.def.direct.comparator.OrderMT_DsHanyouKokTuutiError;

public class SortMT_DsHanyouKokTuutiError {

    public List<MT_DsHanyouKokTuutiError> OrderMT_DsHanyouKokTuutiErrorByPkAsc(List<MT_DsHanyouKokTuutiError> pEntity) {
        List<SortCondition<MT_DsHanyouKokTuutiError>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHanyouKokTuutiError()).dsdatasakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokTuutiError()).dskoktuutirenno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokTuutiError()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokTuutiError()).dshanyoukokyakuatetuutikbn, SortOrder.ASC));
        List<MT_DsHanyouKokTuutiError> copyList = new ArrayList<MT_DsHanyouKokTuutiError>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHanyouKokTuutiError(orders));
        return copyList;
    }

    public List<MT_DsHanyouKokTuutiError> OrderMT_DsHanyouKokTuutiErrorByPkDesc(List<MT_DsHanyouKokTuutiError> pEntity) {
        List<SortCondition<MT_DsHanyouKokTuutiError>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsHanyouKokTuutiError()).dsdatasakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokTuutiError()).dskoktuutirenno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokTuutiError()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsHanyouKokTuutiError()).dshanyoukokyakuatetuutikbn, SortOrder.DESC));
        List<MT_DsHanyouKokTuutiError> copyList = new ArrayList<MT_DsHanyouKokTuutiError>(pEntity);
        Collections.sort(copyList, new OrderMT_DsHanyouKokTuutiError(orders));
        return copyList;
    }
}
