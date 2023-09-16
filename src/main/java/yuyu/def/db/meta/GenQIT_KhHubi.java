package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_KhHubi;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 契約保全不備テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhHubi extends AbstractExDBTable<IT_KhHubi> {

    public GenQIT_KhHubi() {
        this("IT_KhHubi");
    }

    public GenQIT_KhHubi(String pAlias) {
        super("IT_KhHubi", IT_KhHubi.class, pAlias);
    }

    public String IT_KhHubi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhHubi, String> hubisikibetukey = new ExDBFieldString<>("hubisikibetukey", this);

    public final ExDBFieldString<IT_KhHubi, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhHubi, String> jimuttdknm = new ExDBFieldString<>("jimuttdknm", this);

    public final ExDBFieldString<IT_KhHubi, String> renrakusakinmkj = new ExDBFieldString<>("renrakusakinmkj", this);

    public final ExDBFieldString<IT_KhHubi, String> renrakuyno = new ExDBFieldString<>("renrakuyno", this);

    public final ExDBFieldString<IT_KhHubi, String> renrakusakiadr1kj = new ExDBFieldString<>("renrakusakiadr1kj", this);

    public final ExDBFieldString<IT_KhHubi, String> renrakusakiadr2kj = new ExDBFieldString<>("renrakusakiadr2kj", this);

    public final ExDBFieldString<IT_KhHubi, String> renrakusakiadr3kj = new ExDBFieldString<>("renrakusakiadr3kj", this);

    public final ExDBFieldString<IT_KhHubi, String> renrakusakitelno = new ExDBFieldString<>("renrakusakitelno", this);

    public final ExDBFieldString<IT_KhHubi, String> renrakuarea = new ExDBFieldString<>("renrakuarea", this);

    public final ExDBFieldString<IT_KhHubi, BizDate> hubianswerkjt = new ExDBFieldString<>("hubianswerkjt", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHubi, BizDate> sksreadymd = new ExDBFieldString<>("sksreadymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHubi, BizDate> hassinsakifsthubihasinymd1 = new ExDBFieldString<>("hassinsakifsthubihasinymd1", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHubi, BizDate> hassinsakifsthubihasinymd2 = new ExDBFieldString<>("hassinsakifsthubihasinymd2", this, BizDateType.class);

    public final ExDBFieldNumber<IT_KhHubi, Integer> hassinsakikaisuu1 = new ExDBFieldNumber<>("hassinsakikaisuu1", this);

    public final ExDBFieldNumber<IT_KhHubi, Integer> hassinsakikaisuu2 = new ExDBFieldNumber<>("hassinsakikaisuu2", this);

    public final ExDBFieldString<IT_KhHubi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhHubi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
