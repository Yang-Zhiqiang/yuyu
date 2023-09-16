package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKJT_AksrendouzumiSkKykInfo;
import yuyu.def.db.mapping.GenJT_AksrendouzumiSkKykInfo;
import yuyu.def.db.meta.GenQJT_AksrendouzumiSkKykInfo;
import yuyu.def.db.meta.QJT_AksrendouzumiSkKykInfo;

/**
 * ＡＫＳ連動済請求契約情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_AksrendouzumiSkKykInfo} の JavaDoc を参照してください。
 * @see     GenJT_AksrendouzumiSkKykInfo
 * @see     PKJT_AksrendouzumiSkKykInfo
 * @see     QJT_AksrendouzumiSkKykInfo
 * @see     GenQJT_AksrendouzumiSkKykInfo
 */
@Entity
public class JT_AksrendouzumiSkKykInfo extends GenJT_AksrendouzumiSkKykInfo {

    private static final long serialVersionUID = 1L;

    public JT_AksrendouzumiSkKykInfo() {
    }

    public JT_AksrendouzumiSkKykInfo(String pSkno, String pSyono) {
        super(pSkno, pSyono);
    }

}
