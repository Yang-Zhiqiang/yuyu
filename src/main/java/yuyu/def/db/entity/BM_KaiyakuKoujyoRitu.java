package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_KaiyakuKoujyoRitu;
import yuyu.def.db.mapping.GenBM_KaiyakuKoujyoRitu;
import yuyu.def.db.meta.GenQBM_KaiyakuKoujyoRitu;
import yuyu.def.db.meta.QBM_KaiyakuKoujyoRitu;

/**
 * 解約控除率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_KaiyakuKoujyoRitu} の JavaDoc を参照してください。
 * @see     GenBM_KaiyakuKoujyoRitu
 * @see     PKBM_KaiyakuKoujyoRitu
 * @see     QBM_KaiyakuKoujyoRitu
 * @see     GenQBM_KaiyakuKoujyoRitu
 */
@Entity
public class BM_KaiyakuKoujyoRitu extends GenBM_KaiyakuKoujyoRitu {

    private static final long serialVersionUID = 1L;

    public BM_KaiyakuKoujyoRitu() {
    }

    public BM_KaiyakuKoujyoRitu(
        String pSyouhncd,
        String pRyouritusdno,
        String pKaiyakukjtkybr1,
        String pKaiyakukjtkybr2,
        Integer pKeikanensuu
    ) {
        super(
            pSyouhncd,
            pRyouritusdno,
            pKaiyakukjtkybr1,
            pKaiyakukjtkybr2,
            pKeikanensuu
        );
    }

}
