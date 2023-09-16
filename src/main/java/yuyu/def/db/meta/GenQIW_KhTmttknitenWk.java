package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tmttknitenkbn;
import yuyu.def.db.entity.IW_KhTmttknitenWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_Tmttknitenkbn;

/**
 * 積立金移転ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhTmttknitenWk extends AbstractExDBTable<IW_KhTmttknitenWk> {

    public GenQIW_KhTmttknitenWk() {
        this("IW_KhTmttknitenWk");
    }

    public GenQIW_KhTmttknitenWk(String pAlias) {
        super("IW_KhTmttknitenWk", IW_KhTmttknitenWk.class, pAlias);
    }

    public String IW_KhTmttknitenWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhTmttknitenWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhTmttknitenWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhTmttknitenWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhTmttknitenWk, C_Tmttknitenkbn> tmttknitenkbn = new ExDBFieldString<>("tmttknitenkbn", this, UserType_C_Tmttknitenkbn.class);

    public final ExDBFieldString<IW_KhTmttknitenWk, BizDate> uktkkigenymd = new ExDBFieldString<>("uktkkigenymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhTmttknitenWk, BizDate> tmttknitenymd = new ExDBFieldString<>("tmttknitenymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhTmttknitenWk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhTmttknitenWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhTmttknitenWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhTmttknitenWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhTmttknitenWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhTmttknitenWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhTmttknitenWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
