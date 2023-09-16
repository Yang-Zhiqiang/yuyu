package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_Syokugyou;


/**
 * 職業マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_Syokugyou} の JavaDoc を参照してください。<br />
 * @see     GenBM_Syokugyou<br />
 * @see     PKBM_Syokugyou<br />
 * @see     QBM_Syokugyou<br />
 * @see     GenQBM_Syokugyou<br />
 */
@Entity
public class BM_Syokugyou extends GenBM_Syokugyou {

    private static final long serialVersionUID = 1L;

    public BM_Syokugyou() {
    }

    public BM_Syokugyou(String pSyokugyoucd) {
        super(pSyokugyoucd);
    }



}

