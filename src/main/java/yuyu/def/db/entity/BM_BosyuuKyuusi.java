package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_BosyuuKyuusi;
import yuyu.def.db.mapping.GenBM_BosyuuKyuusi;
import yuyu.def.db.meta.GenQBM_BosyuuKyuusi;
import yuyu.def.db.meta.QBM_BosyuuKyuusi;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * 募集休止マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_BosyuuKyuusi} の JavaDoc を参照してください。
 * @see     GenBM_BosyuuKyuusi
 * @see     PKBM_BosyuuKyuusi
 * @see     QBM_BosyuuKyuusi
 * @see     GenQBM_BosyuuKyuusi
 */
@Entity
public class BM_BosyuuKyuusi extends GenBM_BosyuuKyuusi {

    private static final long serialVersionUID = 1L;

    public BM_BosyuuKyuusi() {
    }

    public BM_BosyuuKyuusi(
        C_SysKbn pSksyskbn,
        String pSyouhncd,
        String pYoteiriritutkybr1,
        String pYoteiriritutkybr2,
        C_SkeijimuKbn pSkeijimukbn,
        Integer pHanteiyuusendo
    ) {
        super(
            pSksyskbn,
            pSyouhncd,
            pYoteiriritutkybr1,
            pYoteiriritutkybr2,
            pSkeijimukbn,
            pHanteiyuusendo
        );
    }

}
