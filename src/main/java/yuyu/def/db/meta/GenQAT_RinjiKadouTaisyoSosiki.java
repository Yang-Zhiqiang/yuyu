package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;

/**
 * 臨時稼働対象組織テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_RinjiKadouTaisyoSosiki extends AbstractExDBTable<AT_RinjiKadouTaisyoSosiki> {

    public GenQAT_RinjiKadouTaisyoSosiki() {
        this("AT_RinjiKadouTaisyoSosiki");
    }

    public GenQAT_RinjiKadouTaisyoSosiki(String pAlias) {
        super("AT_RinjiKadouTaisyoSosiki", AT_RinjiKadouTaisyoSosiki.class, pAlias);
    }

    public String AT_RinjiKadouTaisyoSosiki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_RinjiKadouTaisyoSosiki, String> kadouSosikiCd = new ExDBFieldString<>("kadouSosikiCd", this);
}
