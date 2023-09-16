package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKMW_DsMailHaisinRirekiWk;
import yuyu.def.db.mapping.GenMW_DsMailHaisinRirekiWk;
import yuyu.def.db.meta.GenQMW_DsMailHaisinRirekiWk;
import yuyu.def.db.meta.QMW_DsMailHaisinRirekiWk;
import jp.co.slcs.swak.date.BizDate;

/**
 * ＤＳメール配信履歴ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMW_DsMailHaisinRirekiWk} の JavaDoc を参照してください。
 * @see     GenMW_DsMailHaisinRirekiWk
 * @see     PKMW_DsMailHaisinRirekiWk
 * @see     QMW_DsMailHaisinRirekiWk
 * @see     GenQMW_DsMailHaisinRirekiWk
 */
@Entity
public class MW_DsMailHaisinRirekiWk extends GenMW_DsMailHaisinRirekiWk {

    private static final long serialVersionUID = 1L;

    public MW_DsMailHaisinRirekiWk() {
    }

    public MW_DsMailHaisinRirekiWk(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        Integer pDsmailhaisinrenban
    ) {
        super(
            pDsdatasakuseiymd,
            pDskokno,
            pDsmailhaisinrenban
        );
    }

}
