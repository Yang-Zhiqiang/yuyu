package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_SateiSyouninRireki;

import com.google.common.base.Predicate;

/**
 * 査定承認履歴テーブル用 Predicate<br/>
 * 査定承認識別キー（一致）
 */
public class FilterSateiSyouninRirekiBySateisyouninskbtkey implements Predicate<JT_SateiSyouninRireki> {

    String sateisyouninskbtkey;

    public FilterSateiSyouninRirekiBySateisyouninskbtkey(String pSateisyouninskbtkey) {
        super();
        sateisyouninskbtkey = pSateisyouninskbtkey;
    }

    @Override
    public boolean apply(JT_SateiSyouninRireki sateiSyouninRireki) {
        if(sateisyouninskbtkey.equals(sateiSyouninRireki.getSateisyouninskbtkey())){
            return true;
        }
        return false;
    }

}
