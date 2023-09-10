package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_SateiSyouninRireki;

import com.google.common.base.Predicate;
/**
 * 査定承認履歴テーブル用 Predicate<br/>
 * 請求履歴番号（一致）
 */
public class FilterSateiSyouninRirekiBySeikyuurirekino implements Predicate<JT_SateiSyouninRireki> {

    Integer seikyuurirekino;

    public FilterSateiSyouninRirekiBySeikyuurirekino(Integer pSeikyuurirekino) {
        super();
        seikyuurirekino = pSeikyuurirekino;
    }

    @Override
    public boolean apply(JT_SateiSyouninRireki sateiSyouninRireki) {
        if (seikyuurirekino.equals(sateiSyouninRireki.getSeikyuurirekino())) {
            return true;
        }
        return false;
    }
}
