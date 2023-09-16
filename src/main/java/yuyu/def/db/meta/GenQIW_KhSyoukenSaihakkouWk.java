package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.db.entity.IW_KhSyoukenSaihakkouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InsizeiShryouhiKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_SyoukensaihkKbn;

/**
 * 証券再発行ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhSyoukenSaihakkouWk extends AbstractExDBTable<IW_KhSyoukenSaihakkouWk> {

    public GenQIW_KhSyoukenSaihakkouWk() {
        this("IW_KhSyoukenSaihakkouWk");
    }

    public GenQIW_KhSyoukenSaihakkouWk(String pAlias) {
        super("IW_KhSyoukenSaihakkouWk", IW_KhSyoukenSaihakkouWk.class, pAlias);
    }

    public String IW_KhSyoukenSaihakkouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, C_SyoukensaihkKbn> syoukensaihkkbn = new ExDBFieldString<>("syoukensaihkkbn", this, UserType_C_SyoukensaihkKbn.class);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, C_InsizeiShryouhiKbn> insizeishryouhikbn = new ExDBFieldString<>("insizeishryouhikbn", this, UserType_C_InsizeiShryouhiKbn.class);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhSyoukenSaihakkouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
