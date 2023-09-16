package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_HaitaSeigyo;

/**
 * 排他制御テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_HaitaSeigyo extends AbstractExDBTable<AT_HaitaSeigyo> {

    public GenQAT_HaitaSeigyo() {
        this("AT_HaitaSeigyo");
    }

    public GenQAT_HaitaSeigyo(String pAlias) {
        super("AT_HaitaSeigyo", AT_HaitaSeigyo.class, pAlias);
    }

    public String AT_HaitaSeigyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_HaitaSeigyo, String> haitaSyuruiCd = new ExDBFieldString<>("haitaSyuruiCd", this);

    public final ExDBFieldString<AT_HaitaSeigyo, String> haitaKey = new ExDBFieldString<>("haitaKey", this);

    public final ExDBFieldString<AT_HaitaSeigyo, String> haitamotoKinouId = new ExDBFieldString<>("haitamotoKinouId", this);

    public final ExDBFieldString<AT_HaitaSeigyo, String> haitaUserId = new ExDBFieldString<>("haitaUserId", this);

    public final ExDBFieldString<AT_HaitaSeigyo, String> haitaKaisiTime = new ExDBFieldString<>("haitaKaisiTime", this);

    public final ExDBFieldString<AT_HaitaSeigyo, String> haitaUniqueKey = new ExDBFieldString<>("haitaUniqueKey", this);
}
