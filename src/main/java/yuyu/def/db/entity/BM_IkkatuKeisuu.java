package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_IkkatuKeisuu;
import yuyu.def.db.mapping.GenBM_IkkatuKeisuu;
import yuyu.def.db.meta.GenQBM_IkkatuKeisuu;
import yuyu.def.db.meta.QBM_IkkatuKeisuu;

/**
 * 一括払係数マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_IkkatuKeisuu} の JavaDoc を参照してください。
 * @see     GenBM_IkkatuKeisuu
 * @see     PKBM_IkkatuKeisuu
 * @see     QBM_IkkatuKeisuu
 * @see     GenQBM_IkkatuKeisuu
 */
@Entity
public class BM_IkkatuKeisuu extends GenBM_IkkatuKeisuu {

    private static final long serialVersionUID = 1L;

    public BM_IkkatuKeisuu() {
    }

    public BM_IkkatuKeisuu(
        Integer pIkttekiyouno,
        Integer pNen1nen2baraihyouji,
        Integer pKeikatukisuu
    ) {
        super(
            pIkttekiyouno,
            pNen1nen2baraihyouji,
            pKeikatukisuu
        );
    }

}
