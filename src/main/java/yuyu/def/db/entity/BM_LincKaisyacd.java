package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_LincKaisyacd;
import yuyu.def.db.mapping.GenBM_LincKaisyacd;
import yuyu.def.db.meta.GenQBM_LincKaisyacd;
import yuyu.def.db.meta.QBM_LincKaisyacd;

/**
 * ＬＩＮＣ会社コードマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_LincKaisyacd} の JavaDoc を参照してください。
 * @see     GenBM_LincKaisyacd
 * @see     PKBM_LincKaisyacd
 * @see     QBM_LincKaisyacd
 * @see     GenQBM_LincKaisyacd
 */
@Entity
public class BM_LincKaisyacd extends GenBM_LincKaisyacd {

    private static final long serialVersionUID = 1L;

    public BM_LincKaisyacd() {
    }

    public BM_LincKaisyacd(String pLinckaisyacdnum) {
        super(pLinckaisyacdnum);
    }

}
