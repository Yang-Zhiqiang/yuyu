package yuyu.def.siharai.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.def.db.meta.QJT_Toriatukaifuryouinfo;
import yuyu.def.siharai.comparator.OrderJT_Toriatukaifuryouinfo;

public class SortJT_Toriatukaifuryouinfo {

    
    public List<JT_Toriatukaifuryouinfo> OrderJT_ToriatukaifuryouinfoByPkAsc(List<JT_Toriatukaifuryouinfo> pEntity) {
        List<SortCondition<JT_Toriatukaifuryouinfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_Toriatukaifuryouinfo()).skno, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_Toriatukaifuryouinfo()).syono, SortOrder.ASC));
        orders.add(new SortCondition<>((new QJT_Toriatukaifuryouinfo()).seikyuurirekino, SortOrder.ASC));
        List<JT_Toriatukaifuryouinfo> copyList = new ArrayList<JT_Toriatukaifuryouinfo>(pEntity);
        Collections.sort(copyList, new OrderJT_Toriatukaifuryouinfo(orders));
        return copyList;
    }

    
    public List<JT_Toriatukaifuryouinfo> OrderJT_ToriatukaifuryouinfoByPkDesc(List<JT_Toriatukaifuryouinfo> pEntity) {
        List<SortCondition<JT_Toriatukaifuryouinfo>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QJT_Toriatukaifuryouinfo()).skno, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_Toriatukaifuryouinfo()).syono, SortOrder.DESC));
        orders.add(new SortCondition<>((new QJT_Toriatukaifuryouinfo()).seikyuurirekino, SortOrder.DESC));
        List<JT_Toriatukaifuryouinfo> copyList = new ArrayList<JT_Toriatukaifuryouinfo>(pEntity);
        Collections.sort(copyList, new OrderJT_Toriatukaifuryouinfo(orders));
        return copyList;
    }

}

