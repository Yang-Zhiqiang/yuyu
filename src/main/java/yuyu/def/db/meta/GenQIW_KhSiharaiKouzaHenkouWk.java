package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhSiharaiKouzaHenkouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 支払口座情報変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhSiharaiKouzaHenkouWk extends AbstractExDBTable<IW_KhSiharaiKouzaHenkouWk> {

    public GenQIW_KhSiharaiKouzaHenkouWk() {
        this("IW_KhSiharaiKouzaHenkouWk");
    }

    public GenQIW_KhSiharaiKouzaHenkouWk(String pAlias) {
        super("IW_KhSiharaiKouzaHenkouWk", IW_KhSiharaiKouzaHenkouWk.class, pAlias);
    }

    public String IW_KhSiharaiKouzaHenkouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, C_KouzasyuruiKbn> kzsyuruikbn = new ExDBFieldString<>("kzsyuruikbn", this, UserType_C_KouzasyuruiKbn.class);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhSiharaiKouzaHenkouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
