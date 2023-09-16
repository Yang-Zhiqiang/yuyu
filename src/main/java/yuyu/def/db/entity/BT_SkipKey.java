package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import yuyu.def.db.mapping.GenBT_SkipKey;

/**
 * スキップキーテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBT_SkipKey} の JavaDoc を参照してください。<br />
 * @see     GenBT_SkipKey<br />
 * @see     PKBT_SkipKey<br />
 * @see     QBT_SkipKey<br />
 * @see     GenQBT_SkipKey<br />
 */
@Entity
public class BT_SkipKey extends GenBT_SkipKey {

    private static final long serialVersionUID = 1L;

    public BT_SkipKey() {
    }

    public BT_SkipKey(String pRecoverysikibetukey) {
        super(pRecoverysikibetukey);
    }



    private BM_RecoveryFilter bM_RecoveryFilter ;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name=BT_SkipKey.RECOVERYFILTERID  , referencedColumnName=BM_RecoveryFilter.RECOVERYFILTERID, insertable=false, updatable=false)
    })
    public  BM_RecoveryFilter getRecoveryFilter() {
        return bM_RecoveryFilter;
    }

    public void setRecoveryFilter(BM_RecoveryFilter pBM_RecoveryFilter) {
        this.bM_RecoveryFilter = pBM_RecoveryFilter;
    }

}

