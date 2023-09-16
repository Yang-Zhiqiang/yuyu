package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TyhysakuseiyhKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktkaijyoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IW_KhMeigiHenkouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Meigihnkjiyuu;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_TyhysakuseiyhKbn;
import yuyu.def.db.type.UserType_C_UktKbn;
import yuyu.def.db.type.UserType_C_UktkaijyoKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 名義変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhMeigiHenkouWk extends AbstractExDBTable<IW_KhMeigiHenkouWk> {

    public GenQIW_KhMeigiHenkouWk() {
        this("IW_KhMeigiHenkouWk");
    }

    public GenQIW_KhMeigiHenkouWk(String pAlias) {
        super("IW_KhMeigiHenkouWk", IW_KhMeigiHenkouWk.class, pAlias);
    }

    public String IW_KhMeigiHenkouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_Meigihnkjiyuu> meigihnkjiyuu = new ExDBFieldString<>("meigihnkjiyuu", this, UserType_C_Meigihnkjiyuu.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_KjkhukaKbn> kyknmkjkhukakbn = new ExDBFieldString<>("kyknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_Tdk> kkkyktdk = new ExDBFieldString<>("kkkyktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_KjkhukaKbn> hhknnmkjkhukakbn = new ExDBFieldString<>("hhknnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktKbn> nenkinuktkbn = new ExDBFieldString<>("nenkinuktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldNumber<IW_KhMeigiHenkouWk, Integer> sbuktnin = new ExDBFieldNumber<>("sbuktnin", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktkaijyoKbn> sbuktkaijyokbn1 = new ExDBFieldString<>("sbuktkaijyokbn1", this, UserType_C_UktkaijyoKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktKbn> sbuktkbn1 = new ExDBFieldString<>("sbuktkbn1", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> sbuktnmkn1 = new ExDBFieldString<>("sbuktnmkn1", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> sbuktnmkj1 = new ExDBFieldString<>("sbuktnmkj1", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_KjkhukaKbn> sbuktnmkjhukakbn1 = new ExDBFieldString<>("sbuktnmkjhukakbn1", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizDate> sbuktseiymd1 = new ExDBFieldString<>("sbuktseiymd1", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizNumber> sbuktbnwari1 = new ExDBFieldString<>("sbuktbnwari1", this, BizNumberType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktkaijyoKbn> sbuktkaijyokbn2 = new ExDBFieldString<>("sbuktkaijyokbn2", this, UserType_C_UktkaijyoKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktKbn> sbuktkbn2 = new ExDBFieldString<>("sbuktkbn2", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> sbuktnmkn2 = new ExDBFieldString<>("sbuktnmkn2", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> sbuktnmkj2 = new ExDBFieldString<>("sbuktnmkj2", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_KjkhukaKbn> sbuktnmkjhukakbn2 = new ExDBFieldString<>("sbuktnmkjhukakbn2", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizDate> sbuktseiymd2 = new ExDBFieldString<>("sbuktseiymd2", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizNumber> sbuktbnwari2 = new ExDBFieldString<>("sbuktbnwari2", this, BizNumberType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktkaijyoKbn> sbuktkaijyokbn3 = new ExDBFieldString<>("sbuktkaijyokbn3", this, UserType_C_UktkaijyoKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktKbn> sbuktkbn3 = new ExDBFieldString<>("sbuktkbn3", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> sbuktnmkn3 = new ExDBFieldString<>("sbuktnmkn3", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> sbuktnmkj3 = new ExDBFieldString<>("sbuktnmkj3", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_KjkhukaKbn> sbuktnmkjhukakbn3 = new ExDBFieldString<>("sbuktnmkjhukakbn3", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizDate> sbuktseiymd3 = new ExDBFieldString<>("sbuktseiymd3", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizNumber> sbuktbnwari3 = new ExDBFieldString<>("sbuktbnwari3", this, BizNumberType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktkaijyoKbn> sbuktkaijyokbn4 = new ExDBFieldString<>("sbuktkaijyokbn4", this, UserType_C_UktkaijyoKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktKbn> sbuktkbn4 = new ExDBFieldString<>("sbuktkbn4", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> sbuktnmkn4 = new ExDBFieldString<>("sbuktnmkn4", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> sbuktnmkj4 = new ExDBFieldString<>("sbuktnmkj4", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_KjkhukaKbn> sbuktnmkjhukakbn4 = new ExDBFieldString<>("sbuktnmkjhukakbn4", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizDate> sbuktseiymd4 = new ExDBFieldString<>("sbuktseiymd4", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizNumber> sbuktbnwari4 = new ExDBFieldString<>("sbuktbnwari4", this, BizNumberType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktkaijyoKbn> stdrskkaijyokbn = new ExDBFieldString<>("stdrskkaijyokbn", this, UserType_C_UktkaijyoKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UktKbn> stdruktkbn = new ExDBFieldString<>("stdruktkbn", this, UserType_C_UktKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> stdrsknmkn = new ExDBFieldString<>("stdrsknmkn", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> stdrsknmkj = new ExDBFieldString<>("stdrsknmkj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_KjkhukaKbn> stdrsknmkjhukakbn = new ExDBFieldString<>("stdrsknmkjhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_TyhysakuseiyhKbn> tyhysakuseiyhkbn = new ExDBFieldString<>("tyhysakuseiyhkbn", this, UserType_C_TyhysakuseiyhKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, C_UmuKbn> adrhenkouumu = new ExDBFieldString<>("adrhenkouumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizDate> oldkyksibouymd = new ExDBFieldString<>("oldkyksibouymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhMeigiHenkouWk, BizDate> stdrskseiymd = new ExDBFieldString<>("stdrskseiymd", this, BizDateType.class);
}
