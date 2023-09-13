package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_ZennouTtdkKanryouTuuti;
import yuyu.def.db.meta.QIT_ZennouTtdkKanryouTuuti;
import yuyu.def.hozen.comparator.OrderIT_ZennouTtdkKanryouTuuti;

public class SortIT_ZennouTtdkKanryouTuuti {

    public List<IT_ZennouTtdkKanryouTuuti> OrderIT_ZennouTtdkKanryouTuutiByPkAsc(List<IT_ZennouTtdkKanryouTuuti> pEntity) {
        List<SortCondition<IT_ZennouTtdkKanryouTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ZennouTtdkKanryouTuuti()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouTtdkKanryouTuuti()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouTtdkKanryouTuuti()).tyouhyouymd, SortOrder.ASC));
        List<IT_ZennouTtdkKanryouTuuti> copyList = new ArrayList<IT_ZennouTtdkKanryouTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_ZennouTtdkKanryouTuuti(orders));
        return copyList;
    }

    public List<IT_ZennouTtdkKanryouTuuti> OrderIT_ZennouTtdkKanryouTuutiByPkDesc(List<IT_ZennouTtdkKanryouTuuti> pEntity) {
        List<SortCondition<IT_ZennouTtdkKanryouTuuti>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ZennouTtdkKanryouTuuti()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouTtdkKanryouTuuti()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouTtdkKanryouTuuti()).tyouhyouymd, SortOrder.DESC));
        List<IT_ZennouTtdkKanryouTuuti> copyList = new ArrayList<IT_ZennouTtdkKanryouTuuti>(pEntity);
        Collections.sort(copyList, new OrderIT_ZennouTtdkKanryouTuuti(orders));
        return copyList;
    }
}
