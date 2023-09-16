package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_KouteiLock;
import yuyu.def.db.mapping.GenWT_KouteiLock;
import yuyu.def.db.meta.GenQWT_KouteiLock;
import yuyu.def.db.meta.QWT_KouteiLock;

/**
 * 工程ロック情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_KouteiLock} の JavaDoc を参照してください。
 * @see     GenWT_KouteiLock
 * @see     PKWT_KouteiLock
 * @see     QWT_KouteiLock
 * @see     GenQWT_KouteiLock
 */
@Entity
public class WT_KouteiLock extends GenWT_KouteiLock {

    private static final long serialVersionUID = 1L;

    public WT_KouteiLock() {
    }

    public WT_KouteiLock(String pFlowId, String pGyoumuKey) {
        super(pFlowId, pGyoumuKey);
    }

}
