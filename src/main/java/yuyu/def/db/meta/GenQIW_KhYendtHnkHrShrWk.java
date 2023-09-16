package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Khhrshrjiyuu;
import yuyu.def.classification.C_Khskssakuseijiyuu;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IW_KhYendtHnkHrShrWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_InputShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_Khhrshrjiyuu;
import yuyu.def.db.type.UserType_C_Khskssakuseijiyuu;
import yuyu.def.db.type.UserType_C_Kzdou;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 円建変更時返戻金支払ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhYendtHnkHrShrWk extends AbstractExDBTable<IW_KhYendtHnkHrShrWk> {

    public GenQIW_KhYendtHnkHrShrWk() {
        this("IW_KhYendtHnkHrShrWk");
    }

    public GenQIW_KhYendtHnkHrShrWk(String pAlias) {
        super("IW_KhYendtHnkHrShrWk", IW_KhYendtHnkHrShrWk.class, pAlias);
    }

    public String IW_KhYendtHnkHrShrWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, C_Khhrshrjiyuu> khhrshrjiyuu = new ExDBFieldString<>("khhrshrjiyuu", this, UserType_C_Khhrshrjiyuu.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> shnmkj = new ExDBFieldString<>("shnmkj", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, C_Khskssakuseijiyuu> khskssakuseijiyuu = new ExDBFieldString<>("khskssakuseijiyuu", this, UserType_C_Khskssakuseijiyuu.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kyksyaszknmkn = new ExDBFieldString<>("kyksyaszknmkn", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kyksyaszknmkj = new ExDBFieldString<>("kyksyaszknmkj", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kyksyaszkyno = new ExDBFieldString<>("kyksyaszkyno", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kyksyaszkadr1kj = new ExDBFieldString<>("kyksyaszkadr1kj", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kyksyaszkadr2kj = new ExDBFieldString<>("kyksyaszkadr2kj", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kyksyaszkadr3kj = new ExDBFieldString<>("kyksyaszkadr3kj", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, C_InputShrhousiteiKbn> inputshrhousiteikbn = new ExDBFieldString<>("inputshrhousiteikbn", this, UserType_C_InputShrhousiteiKbn.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, C_Kzdou> kzdoukbn = new ExDBFieldString<>("kzdoukbn", this, UserType_C_Kzdou.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> uktmnmeigibangou = new ExDBFieldString<>("uktmnmeigibangou", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhYendtHnkHrShrWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
