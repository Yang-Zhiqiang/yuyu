package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.IW_KhJyudKigmaebriTkykHnkWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_JyudkaigomaebaraiTkykhnkKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;

/**
 * 重度介護前払特約変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhJyudKigmaebriTkykHnkWk extends AbstractExDBTable<IW_KhJyudKigmaebriTkykHnkWk> {

    public GenQIW_KhJyudKigmaebriTkykHnkWk() {
        this("IW_KhJyudKigmaebriTkykHnkWk");
    }

    public GenQIW_KhJyudKigmaebriTkykHnkWk(String pAlias) {
        super("IW_KhJyudKigmaebriTkykHnkWk", IW_KhJyudKigmaebriTkykHnkWk.class, pAlias);
    }

    public String IW_KhJyudKigmaebriTkykHnkWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, C_JyudkaigomaebaraiTkykhnkKbn> jyudkaigomaebaraitkykhnkkbn = new ExDBFieldString<>("jyudkaigomaebaraitkykhnkkbn", this, UserType_C_JyudkaigomaebaraiTkykhnkKbn.class);

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhJyudKigmaebriTkykHnkWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
