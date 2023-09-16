package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JT_SinsaTyuui;

/**
 * 審査注意テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SinsaTyuui extends AbstractExDBTable<JT_SinsaTyuui> {

    public GenQJT_SinsaTyuui() {
        this("JT_SinsaTyuui");
    }

    public GenQJT_SinsaTyuui(String pAlias) {
        super("JT_SinsaTyuui", JT_SinsaTyuui.class, pAlias);
    }

    public String JT_SinsaTyuui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SinsaTyuui, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SinsaTyuui, String> sinsatyuui = new ExDBFieldString<>("sinsatyuui", this);

    public final ExDBFieldString<JT_SinsaTyuui, String> sosikinm = new ExDBFieldString<>("sosikinm", this);

    public final ExDBFieldString<JT_SinsaTyuui, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SinsaTyuui, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SinsaTyuui, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SinsaTyuui, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
