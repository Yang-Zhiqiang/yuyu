package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IW_KhSiteidairiTokuyakuWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_UktKbn;

/**
 * 指定代理請求特約中途付加ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhSiteidairiTokuyakuWk extends AbstractExDBTable<IW_KhSiteidairiTokuyakuWk> {

    public GenQIW_KhSiteidairiTokuyakuWk() {
        this("IW_KhSiteidairiTokuyakuWk");
    }

    public GenQIW_KhSiteidairiTokuyakuWk(String pAlias) {
        super("IW_KhSiteidairiTokuyakuWk", IW_KhSiteidairiTokuyakuWk.class, pAlias);
    }

    public String IW_KhSiteidairiTokuyakuWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, C_UktKbn> stdruktkbn = new ExDBFieldString<>("stdruktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> stdrsknmkn = new ExDBFieldString<>("stdrsknmkn", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> stdrsknmkj = new ExDBFieldString<>("stdrsknmkj", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, C_KjkhukaKbn> stdrsknmkjhukakbn = new ExDBFieldString<>("stdrsknmkjhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhSiteidairiTokuyakuWk, BizDate> stdrskseiymd = new ExDBFieldString<>("stdrskseiymd", this, BizDateType.class);
}
