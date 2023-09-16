package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenBM_RecoveryFilter;

/**
 * リカバリフィルタマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenBM_RecoveryFilter} の JavaDoc を参照してください。<br />
 * @see     GenBM_RecoveryFilter<br />
 * @see     PKBM_RecoveryFilter<br />
 * @see     QBM_RecoveryFilter<br />
 * @see     GenQBM_RecoveryFilter<br />
 */
@Entity
public class BM_RecoveryFilter extends GenBM_RecoveryFilter {

    private static final long serialVersionUID = 1L;

    public BM_RecoveryFilter() {
    }

    public BM_RecoveryFilter(String pRecoveryfilterid) {
        super(pRecoveryfilterid);
    }



}

