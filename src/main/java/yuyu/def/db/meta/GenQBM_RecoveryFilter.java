package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_RecoveryFilter;

/**
 * リカバリフィルタマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_RecoveryFilter extends AbstractExDBTable<BM_RecoveryFilter> {

    public GenQBM_RecoveryFilter() {
        this("BM_RecoveryFilter");
    }

    public GenQBM_RecoveryFilter(String pAlias) {
        super("BM_RecoveryFilter", BM_RecoveryFilter.class, pAlias);
    }

    public String BM_RecoveryFilter() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_RecoveryFilter, String> recoveryfilterid = new ExDBFieldString<>("recoveryfilterid", this);

    public final ExDBFieldString<BM_RecoveryFilter, String> recoveryfilternm = new ExDBFieldString<>("recoveryfilternm", this);

    public final ExDBFieldString<BM_RecoveryFilter, String> recoveryfilterkeykmid1 = new ExDBFieldString<>("recoveryfilterkeykmid1", this);

    public final ExDBFieldString<BM_RecoveryFilter, String> recoveryfilterkeykmid2 = new ExDBFieldString<>("recoveryfilterkeykmid2", this);

    public final ExDBFieldString<BM_RecoveryFilter, String> recoveryfilterkeykmid3 = new ExDBFieldString<>("recoveryfilterkeykmid3", this);

    public final ExDBFieldString<BM_RecoveryFilter, String> recoveryfilterkeykmid4 = new ExDBFieldString<>("recoveryfilterkeykmid4", this);

    public final ExDBFieldString<BM_RecoveryFilter, String> recoveryfilterkeykmid5 = new ExDBFieldString<>("recoveryfilterkeykmid5", this);
}
