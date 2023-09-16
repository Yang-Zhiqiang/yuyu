package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JT_SiHubi;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 支払不備テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiHubi extends AbstractExDBTable<JT_SiHubi> {

    public GenQJT_SiHubi() {
        this("JT_SiHubi");
    }

    public GenQJT_SiHubi(String pAlias) {
        super("JT_SiHubi", JT_SiHubi.class, pAlias);
    }

    public String JT_SiHubi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiHubi, String> hubisikibetukey = new ExDBFieldString<>("hubisikibetukey", this);

    public final ExDBFieldString<JT_SiHubi, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiHubi, String> jimutetuzukinm = new ExDBFieldString<>("jimutetuzukinm", this);

    public final ExDBFieldString<JT_SiHubi, String> renrakusakinmkj = new ExDBFieldString<>("renrakusakinmkj", this);

    public final ExDBFieldString<JT_SiHubi, String> renrakuyno = new ExDBFieldString<>("renrakuyno", this);

    public final ExDBFieldString<JT_SiHubi, String> renrakusakiadr1kj = new ExDBFieldString<>("renrakusakiadr1kj", this);

    public final ExDBFieldString<JT_SiHubi, String> renrakusakiadr2kj = new ExDBFieldString<>("renrakusakiadr2kj", this);

    public final ExDBFieldString<JT_SiHubi, String> renrakusakiadr3kj = new ExDBFieldString<>("renrakusakiadr3kj", this);

    public final ExDBFieldString<JT_SiHubi, String> renrakusakitelno = new ExDBFieldString<>("renrakusakitelno", this);

    public final ExDBFieldString<JT_SiHubi, String> renrakuarea = new ExDBFieldString<>("renrakuarea", this);

    public final ExDBFieldString<JT_SiHubi, BizDate> hassinsakifsthubihasinymd1 = new ExDBFieldString<>("hassinsakifsthubihasinymd1", this, BizDateType.class);

    public final ExDBFieldString<JT_SiHubi, BizDate> hassinsakifsthubihasinymd2 = new ExDBFieldString<>("hassinsakifsthubihasinymd2", this, BizDateType.class);

    public final ExDBFieldString<JT_SiHubi, BizDate> hasinsakibetuhubihasinymd3 = new ExDBFieldString<>("hasinsakibetuhubihasinymd3", this, BizDateType.class);

    public final ExDBFieldNumber<JT_SiHubi, Integer> hassinsakikaisuu1 = new ExDBFieldNumber<>("hassinsakikaisuu1", this);

    public final ExDBFieldNumber<JT_SiHubi, Integer> hassinsakikaisuu2 = new ExDBFieldNumber<>("hassinsakikaisuu2", this);

    public final ExDBFieldNumber<JT_SiHubi, Integer> hasinsakibetuhasinkaisuu3 = new ExDBFieldNumber<>("hasinsakibetuhasinkaisuu3", this);

    public final ExDBFieldString<JT_SiHubi, String> sisyacd = new ExDBFieldString<>("sisyacd", this);

    public final ExDBFieldString<JT_SiHubi, String> sisyanm = new ExDBFieldString<>("sisyanm", this);

    public final ExDBFieldString<JT_SiHubi, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<JT_SiHubi, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<JT_SiHubi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiHubi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
