package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_Kyksei;

/**
 * 新契約ＬＩＮＣ登録情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkLincTourokuInfo extends AbstractExDBTable<HT_SkLincTourokuInfo> {

    public GenQHT_SkLincTourokuInfo() {
        this("HT_SkLincTourokuInfo");
    }

    public GenQHT_SkLincTourokuInfo(String pAlias) {
        super("HT_SkLincTourokuInfo", HT_SkLincTourokuInfo.class, pAlias);
    }

    public String HT_SkLincTourokuInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkLincTourokuInfo, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_SkLincTourokuInfo, Long> kanyuusyano = new ExDBFieldNumber<>("kanyuusyano", this);

    public final ExDBFieldString<HT_SkLincTourokuInfo, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<HT_SkLincTourokuInfo, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<HT_SkLincTourokuInfo, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<HT_SkLincTourokuInfo, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincTourokuInfo, String> hhknadrlinckn30 = new ExDBFieldString<>("hhknadrlinckn30", this);

    public final ExDBFieldString<HT_SkLincTourokuInfo, C_KykKbn> kykkbn = new ExDBFieldString<>("kykkbn", this, UserType_C_KykKbn.class);

    public final ExDBFieldString<HT_SkLincTourokuInfo, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<HT_SkLincTourokuInfo, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<HT_SkLincTourokuInfo, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<HT_SkLincTourokuInfo, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincTourokuInfo, String> kykadrlinckn30 = new ExDBFieldString<>("kykadrlinckn30", this);

    public final ExDBFieldString<HT_SkLincTourokuInfo, BizDate> trkmousideymd = new ExDBFieldString<>("trkmousideymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincTourokuInfo, BizDate> kykytymd = new ExDBFieldString<>("kykytymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<HT_SkLincTourokuInfo> sgnyung = new ExDBFieldBizCurrency<>("sgnyung", this);

    public final ExDBFieldBizCurrency<HT_SkLincTourokuInfo> sipnyung = new ExDBFieldBizCurrency<>("sipnyung", this);

    public final ExDBFieldBizCurrency<HT_SkLincTourokuInfo> sjnyung = new ExDBFieldBizCurrency<>("sjnyung", this);

    public final ExDBFieldBizCurrency<HT_SkLincTourokuInfo> sonotanyuinng = new ExDBFieldBizCurrency<>("sonotanyuinng", this);

    public final ExDBFieldBizCurrency<HT_SkLincTourokuInfo> hutuusb = new ExDBFieldBizCurrency<>("hutuusb", this);

    public final ExDBFieldBizCurrency<HT_SkLincTourokuInfo> sgsbksns = new ExDBFieldBizCurrency<>("sgsbksns", this);

    public final ExDBFieldString<HT_SkLincTourokuInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkLincTourokuInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
