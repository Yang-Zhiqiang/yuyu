package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.IT_ZennouKessan;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ZennouKbn;
import yuyu.def.db.type.UserType_C_ZennouToukeiListKbn;

/**
 * 前納決算テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_ZennouKessan extends AbstractExDBTable<IT_ZennouKessan> {

    public GenQIT_ZennouKessan() {
        this("IT_ZennouKessan");
    }

    public GenQIT_ZennouKessan(String pAlias) {
        super("IT_ZennouKessan", IT_ZennouKessan.class, pAlias);
    }

    public String IT_ZennouKessan() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_ZennouKessan, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_ZennouKessan, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_ZennouKessan, BizDate> sakuseiymd = new ExDBFieldString<>("sakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouKessan, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_ZennouKessan, C_ZennouKbn> zennoukbn = new ExDBFieldString<>("zennoukbn", this, UserType_C_ZennouKbn.class);

    public final ExDBFieldString<IT_ZennouKessan, C_ZennouToukeiListKbn> zennoutoukeilistkbn = new ExDBFieldString<>("zennoutoukeilistkbn", this, UserType_C_ZennouToukeiListKbn.class);

    public final ExDBFieldString<IT_ZennouKessan, BizDateYM> zennoustartym = new ExDBFieldString<>("zennoustartym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizDate> zennoukaisiymd = new ExDBFieldString<>("zennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> zennoukaisijizndk = new ExDBFieldBizCurrency<>("zennoukaisijizndk", this);

    public final ExDBFieldString<IT_ZennouKessan, BizDate> keiyakuymd = new ExDBFieldString<>("keiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizNumber> zennouwrbkrt = new ExDBFieldString<>("zennouwrbkrt", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> rthndzndk1 = new ExDBFieldBizCurrency<>("rthndzndk1", this);

    public final ExDBFieldString<IT_ZennouKessan, BizNumber> tkyrt1 = new ExDBFieldString<>("tkyrt1", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizDate> rthndymd1 = new ExDBFieldString<>("rthndymd1", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> rthndzndk2 = new ExDBFieldBizCurrency<>("rthndzndk2", this);

    public final ExDBFieldString<IT_ZennouKessan, BizNumber> tkyrt2 = new ExDBFieldString<>("tkyrt2", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizDate> rthndymd2 = new ExDBFieldString<>("rthndymd2", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> rthndzndk3 = new ExDBFieldBizCurrency<>("rthndzndk3", this);

    public final ExDBFieldString<IT_ZennouKessan, BizNumber> tkyrt3 = new ExDBFieldString<>("tkyrt3", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizDate> rthndymd3 = new ExDBFieldString<>("rthndymd3", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> rthndzndk4 = new ExDBFieldBizCurrency<>("rthndzndk4", this);

    public final ExDBFieldString<IT_ZennouKessan, BizNumber> tkyrt4 = new ExDBFieldString<>("tkyrt4", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizDate> rthndymd4 = new ExDBFieldString<>("rthndymd4", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> tndmatuzndk = new ExDBFieldBizCurrency<>("tndmatuzndk", this);

    public final ExDBFieldString<IT_ZennouKessan, BizNumber> tndmatutkyrt = new ExDBFieldString<>("tndmatutkyrt", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizDate> zennounyuukinymd = new ExDBFieldString<>("zennounyuukinymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouKessan, String> tndzndkhikakukbn = new ExDBFieldString<>("tndzndkhikakukbn", this);

    public final ExDBFieldString<IT_ZennouKessan, String> zennoukikan = new ExDBFieldString<>("zennoukikan", this);

    public final ExDBFieldString<IT_ZennouKessan, String> yobi01xv1 = new ExDBFieldString<>("yobi01xv1", this);

    public final ExDBFieldString<IT_ZennouKessan, String> bosyuukeitaikbn = new ExDBFieldString<>("bosyuukeitaikbn", this);

    public final ExDBFieldString<IT_ZennouKessan, String> yobi02xv11 = new ExDBFieldString<>("yobi02xv11", this);

    public final ExDBFieldString<IT_ZennouKessan, String> gkdtznnhyj = new ExDBFieldString<>("gkdtznnhyj", this);

    public final ExDBFieldString<IT_ZennouKessan, String> znngaikakbn = new ExDBFieldString<>("znngaikakbn", this);

    public final ExDBFieldString<IT_ZennouKessan, String> yenkanyknhyj = new ExDBFieldString<>("yenkanyknhyj", this);

    public final ExDBFieldString<IT_ZennouKessan, BizNumber> znnnyknjikawaserate = new ExDBFieldString<>("znnnyknjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizDate> znnnyknjikawaseratetkyuymd = new ExDBFieldString<>("znnnyknjikawaseratetkyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizNumber> ksnkisikawaserate = new ExDBFieldString<>("ksnkisikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouKessan, BizNumber> tndmatuzndkksnjkwsrate = new ExDBFieldString<>("tndmatuzndkksnjkwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> zennounyuukinkgkgaika = new ExDBFieldBizCurrency<>("zennounyuukinkgkgaika", this);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> zennounyuukinkgktkmatu = new ExDBFieldBizCurrency<>("zennounyuukinkgktkmatu", this);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> zennoukaisijizndktkmatu = new ExDBFieldBizCurrency<>("zennoukaisijizndktkmatu", this);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> rthndzndk1tkmatu = new ExDBFieldBizCurrency<>("rthndzndk1tkmatu", this);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> rthndzndk2tkmatu = new ExDBFieldBizCurrency<>("rthndzndk2tkmatu", this);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> rthndzndk3tkmatu = new ExDBFieldBizCurrency<>("rthndzndk3tkmatu", this);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> rthndzndk4tkmatu = new ExDBFieldBizCurrency<>("rthndzndk4tkmatu", this);

    public final ExDBFieldBizCurrency<IT_ZennouKessan> tndmatuzndktkmatu = new ExDBFieldBizCurrency<>("tndmatuzndktkmatu", this);

    public final ExDBFieldString<IT_ZennouKessan, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_ZennouKessan, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_ZennouKessan, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
