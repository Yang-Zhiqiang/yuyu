package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SibouRitu;
import yuyu.def.db.mapping.GenBM_SibouRitu;
import yuyu.def.db.meta.GenQBM_SibouRitu;
import yuyu.def.db.meta.QBM_SibouRitu;
import yuyu.def.classification.C_Seibetu;

/**
 * 死亡率マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SibouRitu} の JavaDoc を参照してください。
 * @see     GenBM_SibouRitu
 * @see     PKBM_SibouRitu
 * @see     QBM_SibouRitu
 * @see     GenQBM_SibouRitu
 */
@Entity
public class BM_SibouRitu extends GenBM_SibouRitu {

    private static final long serialVersionUID = 1L;

    public BM_SibouRitu() {
    }

    public BM_SibouRitu(
        String pRyouritusdno,
        C_Seibetu pSeibetu,
        Integer pNenrei
    ) {
        super(
            pRyouritusdno,
            pSeibetu,
            pNenrei
        );
    }

}
