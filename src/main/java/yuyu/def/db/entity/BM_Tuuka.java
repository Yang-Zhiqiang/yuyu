package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.mapping.GenBM_Tuuka;


/**
 * 通貨マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Tuuka} の JavaDoc を参照してください。<br />
 * @see     GenBM_Tuuka<br />
 * @see     PKBM_Tuuka<br />
 * @see     QBM_Tuuka<br />
 * @see     GenQBM_Tuuka<br />
 */
@Entity
public class BM_Tuuka extends GenBM_Tuuka {

    private static final long serialVersionUID = 1L;

    public BM_Tuuka() {
    }

    public BM_Tuuka(C_Tuukasyu pTuukasyu) {
        super(pTuukasyu);
    }



}

