package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBM_SikinIdouListCsvFLayout;
import yuyu.def.db.mapping.GenBM_SikinIdouListCsvFLayout;
import yuyu.def.db.meta.GenQBM_SikinIdouListCsvFLayout;
import yuyu.def.db.meta.QBM_SikinIdouListCsvFLayout;

/**
 * 資金移動リストＣＳＶファイルレイアウトマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_SikinIdouListCsvFLayout} の JavaDoc を参照してください。
 * @see     GenBM_SikinIdouListCsvFLayout
 * @see     PKBM_SikinIdouListCsvFLayout
 * @see     QBM_SikinIdouListCsvFLayout
 * @see     GenQBM_SikinIdouListCsvFLayout
 */
@Entity
public class BM_SikinIdouListCsvFLayout extends GenBM_SikinIdouListCsvFLayout {

    private static final long serialVersionUID = 1L;

    public BM_SikinIdouListCsvFLayout() {
    }

    public BM_SikinIdouListCsvFLayout(Integer pHyoujijyun) {
        super(pHyoujijyun);
    }

}
