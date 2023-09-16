package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_ItekiToukeiInfo;
import yuyu.def.db.mapping.GenIT_ItekiToukeiInfo;
import yuyu.def.db.meta.GenQIT_ItekiToukeiInfo;
import yuyu.def.db.meta.QIT_ItekiToukeiInfo;

/**
 * 医的統計用情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_ItekiToukeiInfo} の JavaDoc を参照してください。
 * @see     GenIT_ItekiToukeiInfo
 * @see     PKIT_ItekiToukeiInfo
 * @see     QIT_ItekiToukeiInfo
 * @see     GenQIT_ItekiToukeiInfo
 */
@Entity
public class IT_ItekiToukeiInfo extends GenIT_ItekiToukeiInfo {

    private static final long serialVersionUID = 1L;

    public IT_ItekiToukeiInfo() {
    }

    public IT_ItekiToukeiInfo(String pSyono) {
        super(pSyono);
    }

}
