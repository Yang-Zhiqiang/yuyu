package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_KinouKengen;

/**
 * 機能権限テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_KinouKengen extends AbstractExDBTable<AT_KinouKengen> {

    public GenQAT_KinouKengen() {
        this("AT_KinouKengen");
    }

    public GenQAT_KinouKengen(String pAlias) {
        super("AT_KinouKengen", AT_KinouKengen.class, pAlias);
    }

    public String AT_KinouKengen() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_KinouKengen, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<AT_KinouKengen, String> kinouModeId = new ExDBFieldString<>("kinouModeId", this);

    public final ExDBFieldString<AT_KinouKengen, String> roleCd = new ExDBFieldString<>("roleCd", this);

    public final ExDBFieldString<AT_KinouKengen, String> siborikomiId = new ExDBFieldString<>("siborikomiId", this);
}
