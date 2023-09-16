package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.mapping.GenIT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.meta.GenQIT_KrkknSeibiTokusokuInfo;
import yuyu.def.db.meta.QIT_KrkknSeibiTokusokuInfo;

/**
 * 仮受金整備督促情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KrkknSeibiTokusokuInfo} の JavaDoc を参照してください。
 * @see     GenIT_KrkknSeibiTokusokuInfo
 * @see     PKIT_KrkknSeibiTokusokuInfo
 * @see     QIT_KrkknSeibiTokusokuInfo
 * @see     GenQIT_KrkknSeibiTokusokuInfo
 */
@Entity
public class IT_KrkknSeibiTokusokuInfo extends GenIT_KrkknSeibiTokusokuInfo {

    private static final long serialVersionUID = 1L;

    public IT_KrkknSeibiTokusokuInfo() {
    }

    public IT_KrkknSeibiTokusokuInfo(String pSyono, Integer pKrkno) {
        super(pSyono, pKrkno);
    }

}
