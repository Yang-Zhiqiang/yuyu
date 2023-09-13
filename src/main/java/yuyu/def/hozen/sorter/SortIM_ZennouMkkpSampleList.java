package yuyu.def.hozen.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.IM_ZennouMkkpSampleList;
import yuyu.def.db.meta.QIM_ZennouMkkpSampleList;
import yuyu.def.hozen.comparator.OrderIM_ZennouMkkpSampleList;

public class SortIM_ZennouMkkpSampleList {

    public List<IM_ZennouMkkpSampleList> OrderIM_ZennouMkkpSampleListByPkAsc(List<IM_ZennouMkkpSampleList> pEntity) {
        List<SortCondition<IM_ZennouMkkpSampleList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_ZennouMkkpSampleList()).zennoutoukeilistkbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_ZennouMkkpSampleList()).zennoukbn, SortOrder.ASC));
        orders.add(new SortCondition<>((new QIM_ZennouMkkpSampleList()).kbnkeirisegcd, SortOrder.ASC));
        List<IM_ZennouMkkpSampleList> copyList = new ArrayList<IM_ZennouMkkpSampleList>(pEntity);
        Collections.sort(copyList, new OrderIM_ZennouMkkpSampleList(orders));
        return copyList;
    }

    public List<IM_ZennouMkkpSampleList> OrderIM_ZennouMkkpSampleListByPkDesc(List<IM_ZennouMkkpSampleList> pEntity) {
        List<SortCondition<IM_ZennouMkkpSampleList>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QIM_ZennouMkkpSampleList()).zennoutoukeilistkbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_ZennouMkkpSampleList()).zennoukbn, SortOrder.DESC));
        orders.add(new SortCondition<>((new QIM_ZennouMkkpSampleList()).kbnkeirisegcd, SortOrder.DESC));
        List<IM_ZennouMkkpSampleList> copyList = new ArrayList<IM_ZennouMkkpSampleList>(pEntity);
        Collections.sort(copyList, new OrderIM_ZennouMkkpSampleList(orders));
        return copyList;
    }
}
