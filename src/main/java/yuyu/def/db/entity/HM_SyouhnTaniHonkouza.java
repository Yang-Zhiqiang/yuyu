package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHM_SyouhnTaniHonkouza;
import yuyu.def.db.mapping.GenHM_SyouhnTaniHonkouza;
import yuyu.def.db.meta.GenQHM_SyouhnTaniHonkouza;
import yuyu.def.db.meta.QHM_SyouhnTaniHonkouza;

/**
 * 商品単位本口座マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SyouhnTaniHonkouza} の JavaDoc を参照してください。
 * @see     GenHM_SyouhnTaniHonkouza
 * @see     PKHM_SyouhnTaniHonkouza
 * @see     QHM_SyouhnTaniHonkouza
 * @see     GenQHM_SyouhnTaniHonkouza
 */
@Entity
public class HM_SyouhnTaniHonkouza extends GenHM_SyouhnTaniHonkouza {

    private static final long serialVersionUID = 1L;

    public HM_SyouhnTaniHonkouza() {
    }

    public HM_SyouhnTaniHonkouza(String pSyouhncd) {
        super(pSyouhncd);
    }

}
