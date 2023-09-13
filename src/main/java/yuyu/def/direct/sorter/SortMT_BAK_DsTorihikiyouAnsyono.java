package yuyu.def.direct.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.MT_BAK_DsTorihikiyouAnsyono;
import yuyu.def.db.meta.QMT_BAK_DsTorihikiyouAnsyono;
import yuyu.def.direct.comparator.OrderMT_BAK_DsTorihikiyouAnsyono;

public class SortMT_BAK_DsTorihikiyouAnsyono {

    public List<MT_BAK_DsTorihikiyouAnsyono> OrderMT_BAK_DsTorihikiyouAnsyonoByPkAsc(List<MT_BAK_DsTorihikiyouAnsyono> pEntity) {
        List<SortCondition<MT_BAK_DsTorihikiyouAnsyono>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiyouAnsyono()).dskokno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiyouAnsyono()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiyouAnsyono()).trkssikibetukey, SortOrder.ASC));
        List<MT_BAK_DsTorihikiyouAnsyono> copyList = new ArrayList<MT_BAK_DsTorihikiyouAnsyono>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsTorihikiyouAnsyono(orders));
        return copyList;
    }

    public List<MT_BAK_DsTorihikiyouAnsyono> OrderMT_BAK_DsTorihikiyouAnsyonoByPkDesc(List<MT_BAK_DsTorihikiyouAnsyono> pEntity) {
        List<SortCondition<MT_BAK_DsTorihikiyouAnsyono>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiyouAnsyono()).dskokno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiyouAnsyono()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QMT_BAK_DsTorihikiyouAnsyono()).trkssikibetukey, SortOrder.DESC));
        List<MT_BAK_DsTorihikiyouAnsyono> copyList = new ArrayList<MT_BAK_DsTorihikiyouAnsyono>(pEntity);
        Collections.sort(copyList, new OrderMT_BAK_DsTorihikiyouAnsyono(orders));
        return copyList;
    }
}
