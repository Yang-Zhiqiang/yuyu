package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.meta.QJM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.siharai.comparator.OrderJM_JyudkaigomebrtkWrbkkkn;

public class SortJM_JyudkaigomebrtkWrbkkkn {

    
    public List<JM_JyudkaigomebrtkWrbkkkn> OrderJM_JyudkaigomebrtkWrbkkknByPkAsc(List<JM_JyudkaigomebrtkWrbkkkn> pEntity) {
        List<SortCondition<JM_JyudkaigomebrtkWrbkkkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_JyudkaigomebrtkWrbkkkn()).hhknnen, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJM_JyudkaigomebrtkWrbkkkn()).seibetu, SortOrder.ASC));
        List<JM_JyudkaigomebrtkWrbkkkn> copyList = new ArrayList<JM_JyudkaigomebrtkWrbkkkn>(pEntity);
        Collections.sort(copyList, new OrderJM_JyudkaigomebrtkWrbkkkn(orders));
        return copyList;
    }

    
    public List<JM_JyudkaigomebrtkWrbkkkn> OrderJM_JyudkaigomebrtkWrbkkknByPkDesc(List<JM_JyudkaigomebrtkWrbkkkn> pEntity) {
        List<SortCondition<JM_JyudkaigomebrtkWrbkkkn>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJM_JyudkaigomebrtkWrbkkkn()).hhknnen, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJM_JyudkaigomebrtkWrbkkkn()).seibetu, SortOrder.DESC));
        List<JM_JyudkaigomebrtkWrbkkkn> copyList = new ArrayList<JM_JyudkaigomebrtkWrbkkkn>(pEntity);
        Collections.sort(copyList, new OrderJM_JyudkaigomebrtkWrbkkkn(orders));
        return copyList;
    }
}
