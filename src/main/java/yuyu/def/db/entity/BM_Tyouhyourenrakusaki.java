package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.mapping.GenBM_Tyouhyourenrakusaki;


/**
 * 帳票連絡先マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Tyouhyourenrakusaki} の JavaDoc を参照してください。<br />
 * @see     GenBM_Tyouhyourenrakusaki<br />
 * @see     PKBM_Tyouhyourenrakusaki<br />
 * @see     QBM_Tyouhyourenrakusaki<br />
 * @see     GenQBM_Tyouhyourenrakusaki<br />
 */
@Entity
public class BM_Tyouhyourenrakusaki extends GenBM_Tyouhyourenrakusaki {

    private static final long serialVersionUID = 1L;

    public BM_Tyouhyourenrakusaki() {
    }

    public BM_Tyouhyourenrakusaki(C_TyhyrenrakusikibetuKbn pTyhyrenrakusikibetukbn) {
        super(pTyhyrenrakusikibetukbn);
    }



}

