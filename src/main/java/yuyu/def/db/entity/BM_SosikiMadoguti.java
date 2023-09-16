package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_SosikiMadoguti;

/**
 * 組織窓口情報マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SosikiMadoguti} の JavaDoc を参照してください。<br />
 * @see     GenBM_SosikiMadoguti<br />
 * @see     PKBM_SosikiMadoguti<br />
 * @see     QBM_SosikiMadoguti<br />
 * @see     GenQBM_SosikiMadoguti<br />
 */
@Entity
public class BM_SosikiMadoguti extends GenBM_SosikiMadoguti {

    private static final long serialVersionUID = 1L;

    public BM_SosikiMadoguti() {
    }

    public BM_SosikiMadoguti(String pSskmdsosikicd) {
        super(pSskmdsosikicd);
    }



}

