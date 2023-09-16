package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAS_SubSystem;
import yuyu.def.db.mapping.GenAS_SubSystem;
import yuyu.def.db.meta.GenQAS_SubSystem;
import yuyu.def.db.meta.QAS_SubSystem;
import yuyu.infr.auth.SubSystem;

/**
 * サブシステム基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_SubSystem} の JavaDoc を参照してください。
 * @see     GenAS_SubSystem
 * @see     PKAS_SubSystem
 * @see     QAS_SubSystem
 * @see     GenQAS_SubSystem
 */
@Entity
public class AS_SubSystem extends GenAS_SubSystem implements SubSystem{

    private static final long serialVersionUID = 2L;

    public AS_SubSystem() {
    }

    public AS_SubSystem(String pSubSystemId) {
        super(pSubSystemId);
    }
}
