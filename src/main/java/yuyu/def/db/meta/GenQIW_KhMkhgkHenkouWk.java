package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.db.entity.IW_KhMkhgkHenkouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TargetTkMokuhyoutiKbn;

/**
 * 目標額変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhMkhgkHenkouWk extends AbstractExDBTable<IW_KhMkhgkHenkouWk> {

    public GenQIW_KhMkhgkHenkouWk() {
        this("IW_KhMkhgkHenkouWk");
    }

    public GenQIW_KhMkhgkHenkouWk(String pAlias) {
        super("IW_KhMkhgkHenkouWk", IW_KhMkhgkHenkouWk.class, pAlias);
    }

    public String IW_KhMkhgkHenkouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, C_TargetTkMokuhyoutiKbn> targettkmkhtkbn = new ExDBFieldString<>("targettkmkhtkbn", this, UserType_C_TargetTkMokuhyoutiKbn.class);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhMkhgkHenkouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
