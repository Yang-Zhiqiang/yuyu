package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KykdrtkykttdkKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TeiseiKbn;
import yuyu.def.classification.C_TrkkzkttdkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IW_KhKzktrkKykDrHnkWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_KykdrtkykttdkKbn;
import yuyu.def.db.type.UserType_C_MousideninKbn;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TeiseiKbn;
import yuyu.def.db.type.UserType_C_TrkkzkttdkKbn;
import yuyu.def.db.type.UserType_C_TsindousiteiKbn;
import yuyu.def.db.type.UserType_C_TyhysakuseiyhKbn;
import yuyu.def.db.type.UserType_C_UktKbn;

/**
 * 家族登録契約者代理特約変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhKzktrkKykDrHnkWk extends AbstractExDBTable<IW_KhKzktrkKykDrHnkWk> {

    public GenQIW_KhKzktrkKykDrHnkWk() {
        this("IW_KhKzktrkKykDrHnkWk");
    }

    public GenQIW_KhKzktrkKykDrHnkWk(String pAlias) {
        super("IW_KhKzktrkKykDrHnkWk", IW_KhKzktrkKykDrHnkWk.class, pAlias);
    }

    public String IW_KhKzktrkKykDrHnkWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_MousideninKbn> mousideninkbn = new ExDBFieldString<>("mousideninkbn", this, UserType_C_MousideninKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_TeiseiKbn> teiseikbn = new ExDBFieldString<>("teiseikbn", this, UserType_C_TeiseiKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_TrkkzkttdkKbn> trkkzkttdkkbn1 = new ExDBFieldString<>("trkkzkttdkkbn1", this, UserType_C_TrkkzkttdkKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzknmkn1 = new ExDBFieldString<>("trkkzknmkn1", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzknmkj1 = new ExDBFieldString<>("trkkzknmkj1", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_KjkhukaKbn> trkkzknmkjkhukakbn1 = new ExDBFieldString<>("trkkzknmkjkhukakbn1", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, BizDate> trkkzkseiymd1 = new ExDBFieldString<>("trkkzkseiymd1", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_Seibetu> trkkzksei1 = new ExDBFieldString<>("trkkzksei1", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzkyno1 = new ExDBFieldString<>("trkkzkyno1", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzkadr1kj1 = new ExDBFieldString<>("trkkzkadr1kj1", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzkadr2kj1 = new ExDBFieldString<>("trkkzkadr2kj1", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzkadr3kj1 = new ExDBFieldString<>("trkkzkadr3kj1", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzktelno1 = new ExDBFieldString<>("trkkzktelno1", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_Tdk> trkkzktdk1 = new ExDBFieldString<>("trkkzktdk1", this, UserType_C_Tdk.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_TrkkzkttdkKbn> trkkzkttdkkbn2 = new ExDBFieldString<>("trkkzkttdkkbn2", this, UserType_C_TrkkzkttdkKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzknmkn2 = new ExDBFieldString<>("trkkzknmkn2", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzknmkj2 = new ExDBFieldString<>("trkkzknmkj2", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_KjkhukaKbn> trkkzknmkjkhukakbn2 = new ExDBFieldString<>("trkkzknmkjkhukakbn2", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, BizDate> trkkzkseiymd2 = new ExDBFieldString<>("trkkzkseiymd2", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_Seibetu> trkkzksei2 = new ExDBFieldString<>("trkkzksei2", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_Tdk> trkkzktdk2 = new ExDBFieldString<>("trkkzktdk2", this, UserType_C_Tdk.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzkyno2 = new ExDBFieldString<>("trkkzkyno2", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzkadr1kj2 = new ExDBFieldString<>("trkkzkadr1kj2", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzkadr2kj2 = new ExDBFieldString<>("trkkzkadr2kj2", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzkadr3kj2 = new ExDBFieldString<>("trkkzkadr3kj2", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> trkkzktelno2 = new ExDBFieldString<>("trkkzktelno2", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_KykdrtkykttdkKbn> kykdrtkykttdkkbn = new ExDBFieldString<>("kykdrtkykttdkkbn", this, UserType_C_KykdrtkykttdkKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_UktKbn> kykdrkbn = new ExDBFieldString<>("kykdrkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> kykdairinmkn = new ExDBFieldString<>("kykdairinmkn", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> kykdairinmkj = new ExDBFieldString<>("kykdairinmkj", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_KjkhukaKbn> kykdrnmkjkhukakbn = new ExDBFieldString<>("kykdrnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, BizDate> kykdrseiymd = new ExDBFieldString<>("kykdrseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> kykdryno = new ExDBFieldString<>("kykdryno", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> kykdradr1kj = new ExDBFieldString<>("kykdradr1kj", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> kykdradr2kj = new ExDBFieldString<>("kykdradr2kj", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> kykdradr3kj = new ExDBFieldString<>("kykdradr3kj", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_TyhysakuseiyhKbn> tyhysakuseiyhkbn = new ExDBFieldString<>("tyhysakuseiyhkbn", this, UserType_C_TyhysakuseiyhKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_TsindousiteiKbn> trkkzktsindousiteikbn1 = new ExDBFieldString<>("trkkzktsindousiteikbn1", this, UserType_C_TsindousiteiKbn.class);

    public final ExDBFieldString<IW_KhKzktrkKykDrHnkWk, C_TsindousiteiKbn> trkkzktsindousiteikbn2 = new ExDBFieldString<>("trkkzktsindousiteikbn2", this, UserType_C_TsindousiteiKbn.class);
}
