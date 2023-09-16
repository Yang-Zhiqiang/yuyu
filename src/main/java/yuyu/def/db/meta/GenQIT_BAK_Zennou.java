package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.IT_BAK_Zennou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_ZennouSeisanKbn;

/**
 * 前納バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_Zennou extends AbstractExDBTable<IT_BAK_Zennou> {

    public GenQIT_BAK_Zennou() {
        this("IT_BAK_Zennou");
    }

    public GenQIT_BAK_Zennou(String pAlias) {
        super("IT_BAK_Zennou", IT_BAK_Zennou.class, pAlias);
    }

    public String IT_BAK_Zennou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_Zennou, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_Zennou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_Zennou, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> zennoukaisiymd = new ExDBFieldString<>("zennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_Zennou, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> zennounyuukinsyoriymd = new ExDBFieldString<>("zennounyuukinsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, String> zennounyuukindenno = new ExDBFieldString<>("zennounyuukindenno", this);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> zennounyuukindenymd = new ExDBFieldString<>("zennounyuukindenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, String> zennoukikan = new ExDBFieldString<>("zennoukikan", this);

    public final ExDBFieldBizCurrency<IT_BAK_Zennou> zennounyuukinkgk = new ExDBFieldBizCurrency<>("zennounyuukinkgk", this);

    public final ExDBFieldBizCurrency<IT_BAK_Zennou> zennounyuukinkgkrstk = new ExDBFieldBizCurrency<>("zennounyuukinkgkrstk", this);

    public final ExDBFieldBizCurrency<IT_BAK_Zennou> zennoujihrkp = new ExDBFieldBizCurrency<>("zennoujihrkp", this);

    public final ExDBFieldString<IT_BAK_Zennou, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> ryosyukwsratekjymd = new ExDBFieldString<>("ryosyukwsratekjymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizNumber> ryosyukwsrate = new ExDBFieldString<>("ryosyukwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Zennou, C_ZennouSeisanKbn> zennouseisankbn = new ExDBFieldString<>("zennouseisankbn", this, UserType_C_ZennouSeisanKbn.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> zennouseisansyoriymd = new ExDBFieldString<>("zennouseisansyoriymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_Zennou> zennouseisankgk = new ExDBFieldBizCurrency<>("zennouseisankgk", this);

    public final ExDBFieldBizCurrency<IT_BAK_Zennou> zennouseisankgkshrtk = new ExDBFieldBizCurrency<>("zennouseisankgkshrtk", this);

    public final ExDBFieldString<IT_BAK_Zennou, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> shrkwsratekjnymd = new ExDBFieldString<>("shrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> zennouseisankijyunymd = new ExDBFieldString<>("zennouseisankijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> zennouseisandenymd = new ExDBFieldString<>("zennouseisandenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizDateYM> annaisaikaiym = new ExDBFieldString<>("annaisaikaiym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<IT_BAK_Zennou> yenkansannyknkingk = new ExDBFieldBizCurrency<>("yenkansannyknkingk", this);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> yenkansantkykwsrateymd = new ExDBFieldString<>("yenkansantkykwsrateymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizNumber> yenkansantkykwsrate = new ExDBFieldString<>("yenkansantkykwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> kjsmyouzennoukaisiymd = new ExDBFieldString<>("kjsmyouzennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, String> kjsmyouzennoukikanm = new ExDBFieldString<>("kjsmyouzennoukikanm", this);

    public final ExDBFieldBizCurrency<IT_BAK_Zennou> kjsmyouzennounyuukinkgk = new ExDBFieldBizCurrency<>("kjsmyouzennounyuukinkgk", this);

    public final ExDBFieldString<IT_BAK_Zennou, BizDate> kjsmyouyenkansanrateymd = new ExDBFieldString<>("kjsmyouyenkansanrateymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Zennou, BizNumber> kjsmyouyenkansankwsrate = new ExDBFieldString<>("kjsmyouyenkansankwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_Zennou, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_Zennou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_Zennou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
