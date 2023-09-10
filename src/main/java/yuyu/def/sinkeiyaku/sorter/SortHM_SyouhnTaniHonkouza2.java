package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza2;
import yuyu.def.db.meta.QHM_SyouhnTaniHonkouza2;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SyouhnTaniHonkouza2;

public class SortHM_SyouhnTaniHonkouza2 {

    
    public List<HM_SyouhnTaniHonkouza2> OrderHM_SyouhnTaniHonkouza2ByPkAsc(List<HM_SyouhnTaniHonkouza2> pEntity) {
        List<SortCondition<HM_SyouhnTaniHonkouza2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SyouhnTaniHonkouza2()).syouhncd, SortOrder.ASC));
        orders.add(new SortCondition<>((new QHM_SyouhnTaniHonkouza2()).kyktuukasyu, SortOrder.ASC));
        List<HM_SyouhnTaniHonkouza2> copyList = new ArrayList<HM_SyouhnTaniHonkouza2>(pEntity);
        Collections.sort(copyList, new OrderHM_SyouhnTaniHonkouza2(orders));
        return copyList;
    }

    
    public List<HM_SyouhnTaniHonkouza2> OrderHM_SyouhnTaniHonkouza2ByPkDesc(List<HM_SyouhnTaniHonkouza2> pEntity) {
        List<SortCondition<HM_SyouhnTaniHonkouza2>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SyouhnTaniHonkouza2()).syouhncd, SortOrder.DESC));
        orders.add(new SortCondition<>((new QHM_SyouhnTaniHonkouza2()).kyktuukasyu, SortOrder.DESC));
        List<HM_SyouhnTaniHonkouza2> copyList = new ArrayList<HM_SyouhnTaniHonkouza2>(pEntity);
        Collections.sort(copyList, new OrderHM_SyouhnTaniHonkouza2(orders));
        return copyList;
    }
}
