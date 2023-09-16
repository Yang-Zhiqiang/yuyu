package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全手続履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhTtdkRireki extends AbstractExDBTable<IT_KhTtdkRireki> {

    public GenQIT_KhTtdkRireki() {
        this("IT_KhTtdkRireki");
    }

    public GenQIT_KhTtdkRireki(String pAlias) {
        super("IT_KhTtdkRireki", IT_KhTtdkRireki.class, pAlias);
    }

    public String IT_KhTtdkRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhTtdkRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhTtdkRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhTtdkRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_KhTtdkRireki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhTtdkRireki, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<IT_KhTtdkRireki, C_UmuKbn> shrsyousaiumu = new ExDBFieldString<>("shrsyousaiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhTtdkRireki, C_SyoriKbn> syorikbn = new ExDBFieldString<>("syorikbn", this, UserType_C_SyoriKbn.class);

    public final ExDBFieldString<IT_KhTtdkRireki, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IT_KhTtdkRireki, C_UmuKbn> henkourrkumu = new ExDBFieldString<>("henkourrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhTtdkRireki, String> smbckanriid = new ExDBFieldString<>("smbckanriid", this);

    public final ExDBFieldString<IT_KhTtdkRireki, String> nayosekihontblskbtkey = new ExDBFieldString<>("nayosekihontblskbtkey", this);

    public final ExDBFieldString<IT_KhTtdkRireki, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IT_KhTtdkRireki, String> youkyuuno = new ExDBFieldString<>("youkyuuno", this);

    public final ExDBFieldString<IT_KhTtdkRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhTtdkRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhTtdkRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
