package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.db.meta.QMT_DsTorihikiyouAnsyono;
import yuyu.def.direct.comparator.OrderMT_DsTorihikiyouAnsyono;

public class SortMT_DsTorihikiyouAnsyono {

    public List<MT_DsTorihikiyouAnsyono> OrderMT_DsTorihikiyouAnsyonoByPkAsc(List<MT_DsTorihikiyouAnsyono> pEntity) {
        List<SortCondition<MT_DsTorihikiyouAnsyono>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTorihikiyouAnsyono()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_DsTorihikiyouAnsyono()).syono, SortOrder.ASC));
        List<MT_DsTorihikiyouAnsyono> copyList = new ArrayList<MT_DsTorihikiyouAnsyono>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTorihikiyouAnsyono(orders));
        return copyList;
    }

    public List<MT_DsTorihikiyouAnsyono> OrderMT_DsTorihikiyouAnsyonoByPkDesc(List<MT_DsTorihikiyouAnsyono> pEntity) {
        List<SortCondition<MT_DsTorihikiyouAnsyono>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_DsTorihikiyouAnsyono()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_DsTorihikiyouAnsyono()).syono, SortOrder.DESC));
        List<MT_DsTorihikiyouAnsyono> copyList = new ArrayList<MT_DsTorihikiyouAnsyono>(pEntity);
        Collections.sort(copyList, new OrderMT_DsTorihikiyouAnsyono(orders));
        return copyList;
    }
}
