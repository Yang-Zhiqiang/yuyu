package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SkDairitenKobetuJyouhou;
import yuyu.def.db.meta.QHM_SkDairitenKobetuJyouhou;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SkDairitenKobetuJyouhou;

public class SortHM_SkDairitenKobetuJyouhou {

    
    public List<HM_SkDairitenKobetuJyouhou> OrderHM_SkDairitenKobetuJyouhouByPkAsc(List<HM_SkDairitenKobetuJyouhou> pEntity) {
        List<SortCondition<HM_SkDairitenKobetuJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkDairitenKobetuJyouhou()).oyadrtencd, SortOrder.ASC));
        List<HM_SkDairitenKobetuJyouhou> copyList = new ArrayList<HM_SkDairitenKobetuJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkDairitenKobetuJyouhou(orders));
        return copyList;
    }

    
    public List<HM_SkDairitenKobetuJyouhou> OrderHM_SkDairitenKobetuJyouhouByPkDesc(List<HM_SkDairitenKobetuJyouhou> pEntity) {
        List<SortCondition<HM_SkDairitenKobetuJyouhou>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SkDairitenKobetuJyouhou()).oyadrtencd, SortOrder.DESC));
        List<HM_SkDairitenKobetuJyouhou> copyList = new ArrayList<HM_SkDairitenKobetuJyouhou>(pEntity);
        Collections.sort(copyList, new OrderHM_SkDairitenKobetuJyouhou(orders));
        return copyList;
    }

}

