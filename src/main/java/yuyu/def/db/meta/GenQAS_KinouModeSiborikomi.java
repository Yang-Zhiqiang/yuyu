package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;

/**
 * 機能モード絞込み基幹テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAS_KinouModeSiborikomi extends AbstractExDBTable<AS_KinouModeSiborikomi> {

    public GenQAS_KinouModeSiborikomi() {
        this("AS_KinouModeSiborikomi");
    }

    public GenQAS_KinouModeSiborikomi(String pAlias) {
        super("AS_KinouModeSiborikomi", AS_KinouModeSiborikomi.class, pAlias);
    }

    public String AS_KinouModeSiborikomi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AS_KinouModeSiborikomi, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<AS_KinouModeSiborikomi, String> kinouModeId = new ExDBFieldString<>("kinouModeId", this);

    public final ExDBFieldString<AS_KinouModeSiborikomi, String> siborikomiId = new ExDBFieldString<>("siborikomiId", this);

    public final ExDBFieldString<AS_KinouModeSiborikomi, String> siborikomiNm = new ExDBFieldString<>("siborikomiNm", this);
}
