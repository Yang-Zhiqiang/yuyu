package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHM_Honkouza;
import yuyu.def.db.mapping.GenHM_Honkouza;
import yuyu.def.db.meta.GenQHM_Honkouza;
import yuyu.def.db.meta.QHM_Honkouza;

/**
 * 本口座マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_Honkouza} の JavaDoc を参照してください。
 * @see     GenHM_Honkouza
 * @see     PKHM_Honkouza
 * @see     QHM_Honkouza
 * @see     GenQHM_Honkouza
 */
@Entity
public class HM_Honkouza extends GenHM_Honkouza {

    private static final long serialVersionUID = 1L;

    public HM_Honkouza() {
    }

    public HM_Honkouza(String pHonkouzacd) {
        super(pHonkouzacd);
    }

}
