package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKHM_SyouhnTaniHonkouza2;
import yuyu.def.db.mapping.GenHM_SyouhnTaniHonkouza2;
import yuyu.def.db.meta.GenQHM_SyouhnTaniHonkouza2;
import yuyu.def.db.meta.QHM_SyouhnTaniHonkouza2;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 商品単位本口座マスタ２ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHM_SyouhnTaniHonkouza2} の JavaDoc を参照してください。
 * @see     GenHM_SyouhnTaniHonkouza2
 * @see     PKHM_SyouhnTaniHonkouza2
 * @see     QHM_SyouhnTaniHonkouza2
 * @see     GenQHM_SyouhnTaniHonkouza2
 */
@Entity
public class HM_SyouhnTaniHonkouza2 extends GenHM_SyouhnTaniHonkouza2 {

    private static final long serialVersionUID = 1L;

    public HM_SyouhnTaniHonkouza2() {
    }

    public HM_SyouhnTaniHonkouza2(String pSyouhncd, C_Tuukasyu pKyktuukasyu) {
        super(pSyouhncd, pKyktuukasyu);
    }

}
