package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBW_UserWk;
import yuyu.def.db.mapping.GenBW_UserWk;
import yuyu.def.db.meta.GenQBW_UserWk;
import yuyu.def.db.meta.QBW_UserWk;

/**
 * ユーザーマスタワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBW_UserWk} の JavaDoc を参照してください。
 * @see     GenBW_UserWk
 * @see     PKBW_UserWk
 * @see     QBW_UserWk
 * @see     GenQBW_UserWk
 */
@Entity
public class BW_UserWk extends GenBW_UserWk {

    private static final long serialVersionUID = 1L;

    public BW_UserWk() {
    }

    public BW_UserWk(String pUserId) {
        super(pUserId);
    }

}
