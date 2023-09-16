package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_RoleSiyouKanouSosiki;

/**
 * ロール使用可能組織テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_RoleSiyouKanouSosiki extends AbstractExDBTable<AT_RoleSiyouKanouSosiki> {

    public GenQAT_RoleSiyouKanouSosiki() {
        this("AT_RoleSiyouKanouSosiki");
    }

    public GenQAT_RoleSiyouKanouSosiki(String pAlias) {
        super("AT_RoleSiyouKanouSosiki", AT_RoleSiyouKanouSosiki.class, pAlias);
    }

    public String AT_RoleSiyouKanouSosiki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_RoleSiyouKanouSosiki, String> syozokusosikicd = new ExDBFieldString<>("syozokusosikicd", this);

    public final ExDBFieldString<AT_RoleSiyouKanouSosiki, String> roleCd = new ExDBFieldString<>("roleCd", this);
}
