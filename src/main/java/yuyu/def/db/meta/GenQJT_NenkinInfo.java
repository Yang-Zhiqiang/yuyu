package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.db.entity.JT_NenkinInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Bnshrkaisuu;
import yuyu.def.db.type.UserType_C_NkHaitoukinuketorihouKbn;
import yuyu.def.db.type.UserType_C_Nstknsyu;

/**
 * 年金情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_NenkinInfo extends AbstractExDBTable<JT_NenkinInfo> {

    public GenQJT_NenkinInfo() {
        this("JT_NenkinInfo");
    }

    public GenQJT_NenkinInfo(String pAlias) {
        super("JT_NenkinInfo", JT_NenkinInfo.class, pAlias);
    }

    public String JT_NenkinInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_NenkinInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_NenkinInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_NenkinInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_NenkinInfo, BizDate> nkkknsetymd = new ExDBFieldString<>("nkkknsetymd", this, BizDateType.class);

    public final ExDBFieldString<JT_NenkinInfo, BizDate> nkshrstartymd = new ExDBFieldString<>("nkshrstartymd", this, BizDateType.class);

    public final ExDBFieldString<JT_NenkinInfo, C_Nstknsyu> nkshrtkyknksyukbn = new ExDBFieldString<>("nkshrtkyknksyukbn", this, UserType_C_Nstknsyu.class);

    public final ExDBFieldNumber<JT_NenkinInfo, Integer> nkshrtkyknksyukkn = new ExDBFieldNumber<>("nkshrtkyknksyukkn", this);

    public final ExDBFieldString<JT_NenkinInfo, C_Bnshrkaisuu> bnshrkaisuu = new ExDBFieldString<>("bnshrkaisuu", this, UserType_C_Bnshrkaisuu.class);

    public final ExDBFieldString<JT_NenkinInfo, C_NkHaitoukinuketorihouKbn> nkhaitoukinuketorihoukbn = new ExDBFieldString<>("nkhaitoukinuketorihoukbn", this, UserType_C_NkHaitoukinuketorihouKbn.class);

    public final ExDBFieldBizCurrency<JT_NenkinInfo> teinkkikingkgaika = new ExDBFieldBizCurrency<>("teinkkikingkgaika", this);

    public final ExDBFieldBizCurrency<JT_NenkinInfo> teinkkikingken = new ExDBFieldBizCurrency<>("teinkkikingken", this);

    public final ExDBFieldBizCurrency<JT_NenkinInfo> htykeihi = new ExDBFieldBizCurrency<>("htykeihi", this);

    public final ExDBFieldBizCurrency<JT_NenkinInfo> yenhtykeihi = new ExDBFieldBizCurrency<>("yenhtykeihi", this);

    public final ExDBFieldBizCurrency<JT_NenkinInfo> nknengk = new ExDBFieldBizCurrency<>("nknengk", this);

    public final ExDBFieldBizCurrency<JT_NenkinInfo> bnktnkgk = new ExDBFieldBizCurrency<>("bnktnkgk", this);

    public final ExDBFieldString<JT_NenkinInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_NenkinInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_NenkinInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_NenkinInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
