package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.HT_BosKoumokuCheckError;

/**
 * 募集項目チェックエラーテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_BosKoumokuCheckError extends AbstractExDBTable<HT_BosKoumokuCheckError> {

    public GenQHT_BosKoumokuCheckError() {
        this("HT_BosKoumokuCheckError");
    }

    public GenQHT_BosKoumokuCheckError(String pAlias) {
        super("HT_BosKoumokuCheckError", HT_BosKoumokuCheckError.class, pAlias);
    }

    public String HT_BosKoumokuCheckError() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_BosKoumokuCheckError, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_BosKoumokuCheckError, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<HT_BosKoumokuCheckError, String> errorkm = new ExDBFieldString<>("errorkm", this);

    public final ExDBFieldString<HT_BosKoumokuCheckError, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
