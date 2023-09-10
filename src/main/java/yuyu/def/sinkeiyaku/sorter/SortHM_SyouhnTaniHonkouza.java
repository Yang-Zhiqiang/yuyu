package yuyu.def.sinkeiyaku.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yuyu.def.base.comparator.SortCondition;
import yuyu.def.base.comparator.SortCondition.SortOrder;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza;
import yuyu.def.db.meta.QHM_SyouhnTaniHonkouza;
import yuyu.def.sinkeiyaku.comparator.OrderHM_SyouhnTaniHonkouza;

public class SortHM_SyouhnTaniHonkouza {

    
    public List<HM_SyouhnTaniHonkouza> OrderHM_SyouhnTaniHonkouzaByPkAsc(List<HM_SyouhnTaniHonkouza> pEntity) {
        List<SortCondition<HM_SyouhnTaniHonkouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SyouhnTaniHonkouza()).syouhncd, SortOrder.ASC));
        List<HM_SyouhnTaniHonkouza> copyList = new ArrayList<HM_SyouhnTaniHonkouza>(pEntity);
        Collections.sort(copyList, new OrderHM_SyouhnTaniHonkouza(orders));
        return copyList;
    }

    
    public List<HM_SyouhnTaniHonkouza> OrderHM_SyouhnTaniHonkouzaByPkDesc(List<HM_SyouhnTaniHonkouza> pEntity) {
        List<SortCondition<HM_SyouhnTaniHonkouza>> orders = new ArrayList<>();
        orders.add(new SortCondition<>((new QHM_SyouhnTaniHonkouza()).syouhncd, SortOrder.DESC));
        List<HM_SyouhnTaniHonkouza> copyList = new ArrayList<HM_SyouhnTaniHonkouza>(pEntity);
        Collections.sort(copyList, new OrderHM_SyouhnTaniHonkouza(orders));
        return copyList;
    }
}
