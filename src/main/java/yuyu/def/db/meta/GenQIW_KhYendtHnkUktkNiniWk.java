package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.IW_KhYendtHnkUktkNiniWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;

/**
 * 円建変更受付（任意請求）ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhYendtHnkUktkNiniWk extends AbstractExDBTable<IW_KhYendtHnkUktkNiniWk> {

    public GenQIW_KhYendtHnkUktkNiniWk() {
        this("IW_KhYendtHnkUktkNiniWk");
    }

    public GenQIW_KhYendtHnkUktkNiniWk(String pAlias) {
        super("IW_KhYendtHnkUktkNiniWk", IW_KhYendtHnkUktkNiniWk.class, pAlias);
    }

    public String IW_KhYendtHnkUktkNiniWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhYendtHnkUktkNiniWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
