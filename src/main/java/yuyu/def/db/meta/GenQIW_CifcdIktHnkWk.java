package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IW_CifcdIktHnkWk;

/**
 * ＣＩＦコード一括変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_CifcdIktHnkWk extends AbstractExDBTable<IW_CifcdIktHnkWk> {

    public GenQIW_CifcdIktHnkWk() {
        this("IW_CifcdIktHnkWk");
    }

    public GenQIW_CifcdIktHnkWk(String pAlias) {
        super("IW_CifcdIktHnkWk", IW_CifcdIktHnkWk.class, pAlias);
    }

    public String IW_CifcdIktHnkWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_CifcdIktHnkWk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IW_CifcdIktHnkWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_CifcdIktHnkWk, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<IW_CifcdIktHnkWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_CifcdIktHnkWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_CifcdIktHnkWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
