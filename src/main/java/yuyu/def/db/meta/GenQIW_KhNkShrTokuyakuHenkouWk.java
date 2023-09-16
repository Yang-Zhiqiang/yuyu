package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_NstkhKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.IW_KhNkShrTokuyakuHenkouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_NstkhKbn;
import yuyu.def.db.type.UserType_C_Nstknsyu;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;

/**
 * 年金支払特約変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhNkShrTokuyakuHenkouWk extends AbstractExDBTable<IW_KhNkShrTokuyakuHenkouWk> {

    public GenQIW_KhNkShrTokuyakuHenkouWk() {
        this("IW_KhNkShrTokuyakuHenkouWk");
    }

    public GenQIW_KhNkShrTokuyakuHenkouWk(String pAlias) {
        super("IW_KhNkShrTokuyakuHenkouWk", IW_KhNkShrTokuyakuHenkouWk.class, pAlias);
    }

    public String IW_KhNkShrTokuyakuHenkouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, C_NstkhKbn> nkshrtkykhnkkbn = new ExDBFieldString<>("nkshrtkykhnkkbn", this, UserType_C_NstkhKbn.class);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, C_Nstknsyu> nkshrtkyknksyukbn = new ExDBFieldString<>("nkshrtkyknksyukbn", this, UserType_C_Nstknsyu.class);

    public final ExDBFieldNumber<IW_KhNkShrTokuyakuHenkouWk, Integer> nkshrtkyknksyukkn = new ExDBFieldNumber<>("nkshrtkyknksyukkn", this);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhNkShrTokuyakuHenkouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
