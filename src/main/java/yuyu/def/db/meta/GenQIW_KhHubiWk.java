package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IW_KhHubiWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 契約保全不備ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhHubiWk extends AbstractExDBTable<IW_KhHubiWk> {

    public GenQIW_KhHubiWk() {
        this("IW_KhHubiWk");
    }

    public GenQIW_KhHubiWk(String pAlias) {
        super("IW_KhHubiWk", IW_KhHubiWk.class, pAlias);
    }

    public String IW_KhHubiWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhHubiWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhHubiWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhHubiWk, String> renrakusakinmkj = new ExDBFieldString<>("renrakusakinmkj", this);

    public final ExDBFieldString<IW_KhHubiWk, String> renrakuyno = new ExDBFieldString<>("renrakuyno", this);

    public final ExDBFieldString<IW_KhHubiWk, String> renrakusakiadr1kj = new ExDBFieldString<>("renrakusakiadr1kj", this);

    public final ExDBFieldString<IW_KhHubiWk, String> renrakusakiadr2kj = new ExDBFieldString<>("renrakusakiadr2kj", this);

    public final ExDBFieldString<IW_KhHubiWk, String> renrakusakiadr3kj = new ExDBFieldString<>("renrakusakiadr3kj", this);

    public final ExDBFieldString<IW_KhHubiWk, String> renrakusakitelno = new ExDBFieldString<>("renrakusakitelno", this);

    public final ExDBFieldString<IW_KhHubiWk, String> renrakuarea = new ExDBFieldString<>("renrakuarea", this);

    public final ExDBFieldString<IW_KhHubiWk, BizDate> hubianswerkjt = new ExDBFieldString<>("hubianswerkjt", this, BizDateType.class);

    public final ExDBFieldString<IW_KhHubiWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhHubiWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhHubiWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
