package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.meta.QHM_SkSeibiSijiNaiyou;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SkSeibiSijiNaiyou;

public class SortHM_SkSeibiSijiNaiyou {

    
    public List<HM_SkSeibiSijiNaiyou> OrderHM_SkSeibiSijiNaiyouByPkAsc(List<HM_SkSeibiSijiNaiyou> pEntity) {
        List<SortCondition<HM_SkSeibiSijiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkSeibiSijiNaiyou()).skseibisijinaiyoucd, SortOrder.ASC));
        List<HM_SkSeibiSijiNaiyou> copyList = new ArrayList<HM_SkSeibiSijiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkSeibiSijiNaiyou(orders));
        return copyList;
    }

    
    public List<HM_SkSeibiSijiNaiyou> OrderHM_SkSeibiSijiNaiyouByHyoujijyunAsc(List<HM_SkSeibiSijiNaiyou> pEntity) {
        List<SortCondition<HM_SkSeibiSijiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkSeibiSijiNaiyou()).hyoujijyun, SortOrder.ASC));
        List<HM_SkSeibiSijiNaiyou> copyList = new ArrayList<HM_SkSeibiSijiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkSeibiSijiNaiyou(orders));
        return copyList;
    }

    
    public List<HM_SkSeibiSijiNaiyou> OrderHM_SkSeibiSijiNaiyouByPkDesc(List<HM_SkSeibiSijiNaiyou> pEntity) {
        List<SortCondition<HM_SkSeibiSijiNaiyou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkSeibiSijiNaiyou()).skseibisijinaiyoucd, SortOrder.DESC));
        List<HM_SkSeibiSijiNaiyou> copyList = new ArrayList<HM_SkSeibiSijiNaiyou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkSeibiSijiNaiyou(orders));
        return copyList;
    }

}

