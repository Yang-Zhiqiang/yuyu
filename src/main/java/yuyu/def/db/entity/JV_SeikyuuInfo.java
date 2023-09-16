package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJV_SeikyuuInfo;
import yuyu.def.db.mapping.GenJV_SeikyuuInfo;
import yuyu.def.db.meta.GenQJV_SeikyuuInfo;
import yuyu.def.db.meta.QJV_SeikyuuInfo;

/**
 * 請求情報ビュー エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJV_SeikyuuInfo} の JavaDoc を参照してください。
 * @see     GenJV_SeikyuuInfo
 * @see     PKJV_SeikyuuInfo
 * @see     QJV_SeikyuuInfo
 * @see     GenQJV_SeikyuuInfo
 */
@Entity
public class JV_SeikyuuInfo extends GenJV_SeikyuuInfo {

    private static final long serialVersionUID = 1L;

    public JV_SeikyuuInfo() {
    }

    public JV_SeikyuuInfo(String pSyono, String pSkno) {
        super(pSyono, pSkno);
    }

}
