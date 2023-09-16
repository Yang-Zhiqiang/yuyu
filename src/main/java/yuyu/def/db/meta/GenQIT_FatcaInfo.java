package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.IT_FatcaInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BikkjnssinfoKbn;
import yuyu.def.db.type.UserType_C_FatcahankeiiKbn;
import yuyu.def.db.type.UserType_C_FatcakekKbn;
import yuyu.def.db.type.UserType_C_FatcasnsiKbn;
import yuyu.def.db.type.UserType_C_FatcatgKbn;
import yuyu.def.db.type.UserType_C_Seibetu;

/**
 * ＦＡＴＣＡ情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_FatcaInfo extends AbstractExDBTable<IT_FatcaInfo> {

    public GenQIT_FatcaInfo() {
        this("IT_FatcaInfo");
    }

    public GenQIT_FatcaInfo(String pAlias) {
        super("IT_FatcaInfo", IT_FatcaInfo.class, pAlias);
    }

    public String IT_FatcaInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_FatcaInfo, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_FatcaInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_FatcaInfo, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_FatcaInfo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_FatcaInfo, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<IT_FatcaInfo, C_FatcasnsiKbn> fatcasnsikbn = new ExDBFieldString<>("fatcasnsikbn", this, UserType_C_FatcasnsiKbn.class);

    public final ExDBFieldString<IT_FatcaInfo, C_BikkjnssinfoKbn> bikkjnssinfokbn = new ExDBFieldString<>("bikkjnssinfokbn", this, UserType_C_BikkjnssinfoKbn.class);

    public final ExDBFieldString<IT_FatcaInfo, C_FatcakekKbn> fatcakekkbn = new ExDBFieldString<>("fatcakekkbn", this, UserType_C_FatcakekKbn.class);

    public final ExDBFieldString<IT_FatcaInfo, C_FatcahankeiiKbn> fatcahankeiikbn = new ExDBFieldString<>("fatcahankeiikbn", this, UserType_C_FatcahankeiiKbn.class);

    public final ExDBFieldString<IT_FatcaInfo, String> bikknzsyno = new ExDBFieldString<>("bikknzsyno", this);

    public final ExDBFieldString<IT_FatcaInfo, BizDate> syomeiymd = new ExDBFieldString<>("syomeiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_FatcaInfo, String> kokno = new ExDBFieldString<>("kokno", this);

    public final ExDBFieldString<IT_FatcaInfo, C_FatcatgKbn> fatcatgkbn = new ExDBFieldString<>("fatcatgkbn", this, UserType_C_FatcatgKbn.class);

    public final ExDBFieldString<IT_FatcaInfo, String> seionnmkn = new ExDBFieldString<>("seionnmkn", this);

    public final ExDBFieldString<IT_FatcaInfo, String> nmkn = new ExDBFieldString<>("nmkn", this);

    public final ExDBFieldString<IT_FatcaInfo, String> nmkj = new ExDBFieldString<>("nmkj", this);

    public final ExDBFieldString<IT_FatcaInfo, BizDate> seiymd = new ExDBFieldString<>("seiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_FatcaInfo, C_Seibetu> seibetu = new ExDBFieldString<>("seibetu", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<IT_FatcaInfo, BizDate> kouryokuendymd = new ExDBFieldString<>("kouryokuendymd", this, BizDateType.class);

    public final ExDBFieldString<IT_FatcaInfo, BizDate> trkymd = new ExDBFieldString<>("trkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_FatcaInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_FatcaInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_FatcaInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
