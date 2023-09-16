package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_KrDenpyoSelectJk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;

/**
 * 経理伝票データ抽出条件テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_KrDenpyoSelectJk extends AbstractExDBTable<BT_KrDenpyoSelectJk> {

    public GenQBT_KrDenpyoSelectJk() {
        this("BT_KrDenpyoSelectJk");
    }

    public GenQBT_KrDenpyoSelectJk(String pAlias) {
        super("BT_KrDenpyoSelectJk", BT_KrDenpyoSelectJk.class, pAlias);
    }

    public String BT_KrDenpyoSelectJk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_KrDenpyoSelectJk, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, BizNumber> syoriymdrenno = new ExDBFieldString<>("syoriymdrenno", this, BizNumberType.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, BizDate> taisyoukknfrom = new ExDBFieldString<>("taisyoukknfrom", this, BizDateType.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, BizDate> taisyoukknto = new ExDBFieldString<>("taisyoukknto", this, BizDateType.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd1 = new ExDBFieldString<>("kanjyoukmkcd1", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd2 = new ExDBFieldString<>("kanjyoukmkcd2", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd3 = new ExDBFieldString<>("kanjyoukmkcd3", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd4 = new ExDBFieldString<>("kanjyoukmkcd4", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd5 = new ExDBFieldString<>("kanjyoukmkcd5", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd6 = new ExDBFieldString<>("kanjyoukmkcd6", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd7 = new ExDBFieldString<>("kanjyoukmkcd7", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd8 = new ExDBFieldString<>("kanjyoukmkcd8", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd9 = new ExDBFieldString<>("kanjyoukmkcd9", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd10 = new ExDBFieldString<>("kanjyoukmkcd10", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd11 = new ExDBFieldString<>("kanjyoukmkcd11", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd12 = new ExDBFieldString<>("kanjyoukmkcd12", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd13 = new ExDBFieldString<>("kanjyoukmkcd13", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd14 = new ExDBFieldString<>("kanjyoukmkcd14", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd15 = new ExDBFieldString<>("kanjyoukmkcd15", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd16 = new ExDBFieldString<>("kanjyoukmkcd16", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd17 = new ExDBFieldString<>("kanjyoukmkcd17", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd18 = new ExDBFieldString<>("kanjyoukmkcd18", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd19 = new ExDBFieldString<>("kanjyoukmkcd19", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd20 = new ExDBFieldString<>("kanjyoukmkcd20", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd21 = new ExDBFieldString<>("kanjyoukmkcd21", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd22 = new ExDBFieldString<>("kanjyoukmkcd22", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd23 = new ExDBFieldString<>("kanjyoukmkcd23", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd24 = new ExDBFieldString<>("kanjyoukmkcd24", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd25 = new ExDBFieldString<>("kanjyoukmkcd25", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd26 = new ExDBFieldString<>("kanjyoukmkcd26", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd27 = new ExDBFieldString<>("kanjyoukmkcd27", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd28 = new ExDBFieldString<>("kanjyoukmkcd28", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd29 = new ExDBFieldString<>("kanjyoukmkcd29", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd30 = new ExDBFieldString<>("kanjyoukmkcd30", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd31 = new ExDBFieldString<>("kanjyoukmkcd31", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd32 = new ExDBFieldString<>("kanjyoukmkcd32", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd33 = new ExDBFieldString<>("kanjyoukmkcd33", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd34 = new ExDBFieldString<>("kanjyoukmkcd34", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd35 = new ExDBFieldString<>("kanjyoukmkcd35", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd36 = new ExDBFieldString<>("kanjyoukmkcd36", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd37 = new ExDBFieldString<>("kanjyoukmkcd37", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd38 = new ExDBFieldString<>("kanjyoukmkcd38", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd39 = new ExDBFieldString<>("kanjyoukmkcd39", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd40 = new ExDBFieldString<>("kanjyoukmkcd40", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd41 = new ExDBFieldString<>("kanjyoukmkcd41", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd42 = new ExDBFieldString<>("kanjyoukmkcd42", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd43 = new ExDBFieldString<>("kanjyoukmkcd43", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd44 = new ExDBFieldString<>("kanjyoukmkcd44", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd45 = new ExDBFieldString<>("kanjyoukmkcd45", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd46 = new ExDBFieldString<>("kanjyoukmkcd46", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd47 = new ExDBFieldString<>("kanjyoukmkcd47", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd48 = new ExDBFieldString<>("kanjyoukmkcd48", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd49 = new ExDBFieldString<>("kanjyoukmkcd49", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BT_KrDenpyoSelectJk, C_Kanjyoukmkcd> kanjyoukmkcd50 = new ExDBFieldString<>("kanjyoukmkcd50", this, UserType_C_Kanjyoukmkcd.class);
}
