package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkNensyuuBairitu;
import yuyu.def.db.mapping.GenBM_ChkNensyuuBairitu;
import yuyu.def.db.meta.GenQBM_ChkNensyuuBairitu;
import yuyu.def.db.meta.QBM_ChkNensyuuBairitu;
import yuyu.def.classification.C_NensyuuKbn;

/**
 * 年収倍率チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkNensyuuBairitu} の JavaDoc を参照してください。
 * @see     GenBM_ChkNensyuuBairitu
 * @see     PKBM_ChkNensyuuBairitu
 * @see     QBM_ChkNensyuuBairitu
 * @see     GenQBM_ChkNensyuuBairitu
 */
@Entity
public class BM_ChkNensyuuBairitu extends GenBM_ChkNensyuuBairitu {

    private static final long serialVersionUID = 1L;

    public BM_ChkNensyuuBairitu() {
    }

    public BM_ChkNensyuuBairitu(C_NensyuuKbn pNensyuukbn) {
        super(pNensyuukbn);
    }

}
