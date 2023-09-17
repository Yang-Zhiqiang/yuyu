package yuyu.def.base.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.OrderAS_Sakujyotaisyo;
import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.AS_Sakujyotaisyo;
import yuyu.def.db.meta.QAS_Sakujyotaisyo;

public class SortAS_Sakujyotaisyo {

    public List<AS_Sakujyotaisyo> OrderAS_SakujyotaisyoByPkAsc(List<AS_Sakujyotaisyo> pEntity) {
        List<SortCondition<AS_Sakujyotaisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_Sakujyotaisyo()).sakujyoTableId, SortOrder.ASC));
        List<AS_Sakujyotaisyo> copyList = new ArrayList<AS_Sakujyotaisyo>(pEntity);
        Collections.sort(copyList, new OrderAS_Sakujyotaisyo(orders));
        return copyList;
    }

    public List<AS_Sakujyotaisyo> OrderAS_SakujyotaisyoByPkDesc(List<AS_Sakujyotaisyo> pEntity) {
        List<SortCondition<AS_Sakujyotaisyo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QAS_Sakujyotaisyo()).sakujyoTableId, SortOrder.DESC));
        List<AS_Sakujyotaisyo> copyList = new ArrayList<AS_Sakujyotaisyo>(pEntity);
        Collections.sort(copyList, new OrderAS_Sakujyotaisyo(orders));
        return copyList;
    }
}
