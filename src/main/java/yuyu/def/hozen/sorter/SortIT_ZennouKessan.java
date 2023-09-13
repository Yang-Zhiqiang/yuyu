package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IT_ZennouKessan;
import yuyu.def.db.meta.QIT_ZennouKessan;
import yuyu.def.hozen.comparator.OrderIT_ZennouKessan;

public class SortIT_ZennouKessan {

    public List<IT_ZennouKessan> OrderIT_ZennouKessanByPkAsc(List<IT_ZennouKessan> pEntity) {
        List<SortCondition<IT_ZennouKessan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).kbnkey, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).sakuseiymd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).kbnkeirisegcd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).zennoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).zennoutoukeilistkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).zennoustartym, SortOrder.ASC));
        List<IT_ZennouKessan> copyList = new ArrayList<IT_ZennouKessan>(pEntity);
        Collections.sort(copyList, new OrderIT_ZennouKessan(orders));
        return copyList;
    }

    public List<IT_ZennouKessan> OrderIT_ZennouKessanByPkDesc(List<IT_ZennouKessan> pEntity) {
        List<SortCondition<IT_ZennouKessan>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).kbnkey, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).sakuseiymd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).kbnkeirisegcd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).zennoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).zennoutoukeilistkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIT_ZennouKessan()).zennoustartym, SortOrder.DESC));
        List<IT_ZennouKessan> copyList = new ArrayList<IT_ZennouKessan>(pEntity);
        Collections.sort(copyList, new OrderIT_ZennouKessan(orders));
        return copyList;
    }
}
