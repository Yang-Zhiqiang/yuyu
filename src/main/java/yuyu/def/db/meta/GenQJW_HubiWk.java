package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JW_HubiWk;

/**
 * 支払不備ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJW_HubiWk extends AbstractExDBTable<JW_HubiWk> {

    public GenQJW_HubiWk() {
        this("JW_HubiWk");
    }

    public GenQJW_HubiWk(String pAlias) {
        super("JW_HubiWk", JW_HubiWk.class, pAlias);
    }

    public String JW_HubiWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JW_HubiWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<JW_HubiWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JW_HubiWk, String> renrakusakinmkj = new ExDBFieldString<>("renrakusakinmkj", this);

    public final ExDBFieldString<JW_HubiWk, String> renrakuyno = new ExDBFieldString<>("renrakuyno", this);

    public final ExDBFieldString<JW_HubiWk, String> renrakusakiadr1kj = new ExDBFieldString<>("renrakusakiadr1kj", this);

    public final ExDBFieldString<JW_HubiWk, String> renrakusakiadr2kj = new ExDBFieldString<>("renrakusakiadr2kj", this);

    public final ExDBFieldString<JW_HubiWk, String> renrakusakiadr3kj = new ExDBFieldString<>("renrakusakiadr3kj", this);

    public final ExDBFieldString<JW_HubiWk, String> renrakusakitelno = new ExDBFieldString<>("renrakusakitelno", this);

    public final ExDBFieldString<JW_HubiWk, String> renrakuarea = new ExDBFieldString<>("renrakuarea", this);

    public final ExDBFieldString<JW_HubiWk, String> sisyacd = new ExDBFieldString<>("sisyacd", this);

    public final ExDBFieldString<JW_HubiWk, String> sisyanm = new ExDBFieldString<>("sisyanm", this);

    public final ExDBFieldString<JW_HubiWk, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<JW_HubiWk, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<JW_HubiWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JW_HubiWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
