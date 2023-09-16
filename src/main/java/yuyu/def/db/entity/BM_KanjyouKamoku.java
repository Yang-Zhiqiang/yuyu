package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.mapping.GenBM_KanjyouKamoku;


/**
 * 勘定科目マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_KanjyouKamoku} の JavaDoc を参照してください。<br />
 * @see     GenBM_KanjyouKamoku<br />
 * @see     PKBM_KanjyouKamoku<br />
 * @see     QBM_KanjyouKamoku<br />
 * @see     GenQBM_KanjyouKamoku<br />
 */
@Entity
public class BM_KanjyouKamoku extends GenBM_KanjyouKamoku {

    private static final long serialVersionUID = 1L;

    public BM_KanjyouKamoku() {
    }

    public BM_KanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd) {
        super(pKanjyoukmkcd);
    }



}

