package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_KijyungkHanteiKawaseRate;
import yuyu.def.db.mapping.GenBM_KijyungkHanteiKawaseRate;
import yuyu.def.db.meta.GenQBM_KijyungkHanteiKawaseRate;
import yuyu.def.db.meta.QBM_KijyungkHanteiKawaseRate;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 基準額判定用為替レートマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_KijyungkHanteiKawaseRate} の JavaDoc を参照してください。
 * @see     GenBM_KijyungkHanteiKawaseRate
 * @see     PKBM_KijyungkHanteiKawaseRate
 * @see     QBM_KijyungkHanteiKawaseRate
 * @see     GenQBM_KijyungkHanteiKawaseRate
 */
@Entity
public class BM_KijyungkHanteiKawaseRate extends GenBM_KijyungkHanteiKawaseRate {

    private static final long serialVersionUID = 1L;

    public BM_KijyungkHanteiKawaseRate() {
    }

    public BM_KijyungkHanteiKawaseRate(String pKijunnendo, C_Tuukasyu pKyktuukasyu) {
        super(pKijunnendo, pKyktuukasyu);
    }

}
