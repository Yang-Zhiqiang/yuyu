package yuyu.def.siharai.predicate;

import yuyu.def.db.entity.JT_SiRireki;

import com.google.common.base.Predicate;

/**
 * 支払履歴テーブルエンティティ用 Predicate<br/>
 * 請求履歴番号（一致）<br/>
 */
public class FilterSiRirekiBySeikyuurirekino implements Predicate<JT_SiRireki> {

    Integer seikyuurirekino;

    public FilterSiRirekiBySeikyuurirekino(Integer pSeikyuurirekino) {
        super();
        seikyuurirekino = pSeikyuurirekino;
    }

    @Override
    public boolean apply(JT_SiRireki pSiRireki) {
        if (seikyuurirekino.equals(pSiRireki.getSeikyuurirekino())){
            return true;
        }
        return false;
    }
}

