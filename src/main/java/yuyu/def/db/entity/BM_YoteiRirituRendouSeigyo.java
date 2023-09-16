package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_YoteiRirituRendouSeigyo;
import yuyu.def.db.mapping.GenBM_YoteiRirituRendouSeigyo;
import yuyu.def.db.meta.GenQBM_YoteiRirituRendouSeigyo;
import yuyu.def.db.meta.QBM_YoteiRirituRendouSeigyo;

/**
 * 予定利率連動制御マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_YoteiRirituRendouSeigyo} の JavaDoc を参照してください。
 * @see     GenBM_YoteiRirituRendouSeigyo
 * @see     PKBM_YoteiRirituRendouSeigyo
 * @see     QBM_YoteiRirituRendouSeigyo
 * @see     GenQBM_YoteiRirituRendouSeigyo
 */
@Entity
public class BM_YoteiRirituRendouSeigyo extends GenBM_YoteiRirituRendouSeigyo {

    private static final long serialVersionUID = 1L;

    public BM_YoteiRirituRendouSeigyo() {
    }

    public BM_YoteiRirituRendouSeigyo(
        String pYoteirirituhanteidfrom,
        String pYoteirirituhanteidto,
        String pSyouhncd
    ) {
        super(
            pYoteirirituhanteidfrom,
            pYoteirirituhanteidto,
            pSyouhncd
        );
    }

}
