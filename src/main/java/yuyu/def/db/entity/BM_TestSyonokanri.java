package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_TestSyonokanri;
import yuyu.def.db.mapping.GenBM_TestSyonokanri;
import yuyu.def.db.meta.GenQBM_TestSyonokanri;
import yuyu.def.db.meta.QBM_TestSyonokanri;

/**
 * テスト用証券番号管理マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_TestSyonokanri} の JavaDoc を参照してください。
 * @see     GenBM_TestSyonokanri
 * @see     PKBM_TestSyonokanri
 * @see     QBM_TestSyonokanri
 * @see     GenQBM_TestSyonokanri
 */
@Entity
public class BM_TestSyonokanri extends GenBM_TestSyonokanri {

    private static final long serialVersionUID = 1L;

    public BM_TestSyonokanri() {
    }

    public BM_TestSyonokanri(
        String pSeirekinen2keta,
        String pBosyuusosikicd,
        Integer pSyonorenno
    ) {
        super(
            pSeirekinen2keta,
            pBosyuusosikicd,
            pSyonorenno
        );
    }

}
