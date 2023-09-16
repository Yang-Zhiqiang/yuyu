package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_TuutirirekiMeisaiHokan;
import yuyu.def.db.mapping.GenBT_TuutirirekiMeisaiHokan;
import yuyu.def.db.meta.GenQBT_TuutirirekiMeisaiHokan;
import yuyu.def.db.meta.QBT_TuutirirekiMeisaiHokan;

/**
 * 通知履歴明細保管テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_TuutirirekiMeisaiHokan} の JavaDoc を参照してください。
 * @see     GenBT_TuutirirekiMeisaiHokan
 * @see     PKBT_TuutirirekiMeisaiHokan
 * @see     QBT_TuutirirekiMeisaiHokan
 * @see     GenQBT_TuutirirekiMeisaiHokan
 */
@Entity
public class BT_TuutirirekiMeisaiHokan extends GenBT_TuutirirekiMeisaiHokan {

    private static final long serialVersionUID = 1L;

    public BT_TuutirirekiMeisaiHokan() {
    }

    public BT_TuutirirekiMeisaiHokan(String pTuutirirekirenno) {
        super(pTuutirirekirenno);
    }

}
