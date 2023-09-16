package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_ChkSyokugyou;
import yuyu.def.db.mapping.GenBM_ChkSyokugyou;
import yuyu.def.db.meta.GenQBM_ChkSyokugyou;
import yuyu.def.db.meta.QBM_ChkSyokugyou;

/**
 * 職業制限チェックマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_ChkSyokugyou} の JavaDoc を参照してください。
 * @see     GenBM_ChkSyokugyou
 * @see     PKBM_ChkSyokugyou
 * @see     QBM_ChkSyokugyou
 * @see     GenQBM_ChkSyokugyou
 */
@Entity
public class BM_ChkSyokugyou extends GenBM_ChkSyokugyou {

    private static final long serialVersionUID = 1L;

    public BM_ChkSyokugyou() {
    }

    public BM_ChkSyokugyou(String pSyokugyoucd) {
        super(pSyokugyoucd);
    }

}
