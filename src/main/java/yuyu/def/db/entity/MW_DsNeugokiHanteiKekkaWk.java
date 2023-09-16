package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKMW_DsNeugokiHanteiKekkaWk;
import yuyu.def.db.mapping.GenMW_DsNeugokiHanteiKekkaWk;
import yuyu.def.db.meta.GenQMW_DsNeugokiHanteiKekkaWk;
import yuyu.def.db.meta.QMW_DsNeugokiHanteiKekkaWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * ＤＳ値動き判定結果ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMW_DsNeugokiHanteiKekkaWk} の JavaDoc を参照してください。
 * @see     GenMW_DsNeugokiHanteiKekkaWk
 * @see     PKMW_DsNeugokiHanteiKekkaWk
 * @see     QMW_DsNeugokiHanteiKekkaWk
 * @see     GenQMW_DsNeugokiHanteiKekkaWk
 */
@Entity
public class MW_DsNeugokiHanteiKekkaWk extends GenMW_DsNeugokiHanteiKekkaWk {

    private static final long serialVersionUID = 1L;

    public MW_DsNeugokiHanteiKekkaWk() {
    }

    public MW_DsNeugokiHanteiKekkaWk(BizDate pDsdatasakuseiymd, String pSyono) {
        super(pDsdatasakuseiymd, pSyono);
    }

}
