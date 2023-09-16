package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_KhLincKihon;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 契約保全ＬＩＮＣ基本テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhLincKihon extends AbstractExDBTable<IT_KhLincKihon> {

    public GenQIT_KhLincKihon() {
        this("IT_KhLincKihon");
    }

    public GenQIT_KhLincKihon(String pAlias) {
        super("IT_KhLincKihon", IT_KhLincKihon.class, pAlias);
    }

    public String IT_KhLincKihon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhLincKihon, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhLincKihon, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhLincKihon, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_KhLincKihon, Long> linckanyuusyano = new ExDBFieldNumber<>("linckanyuusyano", this);

    public final ExDBFieldString<IT_KhLincKihon, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhLincKihon, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhLincKihon, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
