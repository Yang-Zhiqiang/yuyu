package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKBT_SystemRenkei;
import yuyu.def.db.mapping.GenBT_SystemRenkei;
import yuyu.def.db.meta.GenQBT_SystemRenkei;
import yuyu.def.db.meta.QBT_SystemRenkei;

/**
 * システム間連携制御テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_SystemRenkei} の JavaDoc を参照してください。
 * @see     GenBT_SystemRenkei
 * @see     PKBT_SystemRenkei
 * @see     QBT_SystemRenkei
 * @see     GenQBT_SystemRenkei
 */
@Entity
public class BT_SystemRenkei extends GenBT_SystemRenkei {

    private static final long serialVersionUID = 1L;

    public BT_SystemRenkei() {
    }

    public BT_SystemRenkei(String pInterfaceid) {
        super(pInterfaceid);
    }

}
