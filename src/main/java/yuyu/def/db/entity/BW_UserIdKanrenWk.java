package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBW_UserIdKanrenWk;
import yuyu.def.db.mapping.GenBW_UserIdKanrenWk;
import yuyu.def.db.meta.GenQBW_UserIdKanrenWk;
import yuyu.def.db.meta.QBW_UserIdKanrenWk;

/**
 * ユーザーＩＤ関連ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBW_UserIdKanrenWk} の JavaDoc を参照してください。
 * @see     GenBW_UserIdKanrenWk
 * @see     PKBW_UserIdKanrenWk
 * @see     QBW_UserIdKanrenWk
 * @see     GenQBW_UserIdKanrenWk
 */
@Entity
public class BW_UserIdKanrenWk extends GenBW_UserIdKanrenWk {

    private static final long serialVersionUID = 1L;

    public BW_UserIdKanrenWk() {
    }

    public BW_UserIdKanrenWk(String pIdkbn, String pIdcd) {
        super(pIdkbn, pIdcd);
    }

}
