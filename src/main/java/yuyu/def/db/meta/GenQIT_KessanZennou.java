package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.IT_KessanZennou;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Segcd;

/**
 * 決算用前納テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KessanZennou extends AbstractExDBTable<IT_KessanZennou> {

    public GenQIT_KessanZennou() {
        this("IT_KessanZennou");
    }

    public GenQIT_KessanZennou(String pAlias) {
        super("IT_KessanZennou", IT_KessanZennou.class, pAlias);
    }

    public String IT_KessanZennou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KessanZennou, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KessanZennou, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KessanZennou, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_KessanZennou, String> zennoukbn = new ExDBFieldString<>("zennoukbn", this);

    public final ExDBFieldString<IT_KessanZennou, String> zennoutoukeilistkbn = new ExDBFieldString<>("zennoutoukeilistkbn", this);

    public final ExDBFieldString<IT_KessanZennou, BizDateYM> zennoustartym = new ExDBFieldString<>("zennoustartym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KessanZennou, BizDate> zennoukaisiymd = new ExDBFieldString<>("zennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KessanZennou> zennoukaisijizndk = new ExDBFieldBizCurrency<>("zennoukaisijizndk", this);

    public final ExDBFieldString<IT_KessanZennou, BizDate> keiyakuymd = new ExDBFieldString<>("keiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KessanZennou, BizNumber> zennouwrbkrt = new ExDBFieldString<>("zennouwrbkrt", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_KessanZennou> rthndzndk1 = new ExDBFieldBizCurrency<>("rthndzndk1", this);

    public final ExDBFieldString<IT_KessanZennou, BizNumber> tkyrt1 = new ExDBFieldString<>("tkyrt1", this, BizNumberType.class);

    public final ExDBFieldString<IT_KessanZennou, BizDate> rthndymd1 = new ExDBFieldString<>("rthndymd1", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KessanZennou> rthndzndk2 = new ExDBFieldBizCurrency<>("rthndzndk2", this);

    public final ExDBFieldString<IT_KessanZennou, BizNumber> tkyrt2 = new ExDBFieldString<>("tkyrt2", this, BizNumberType.class);

    public final ExDBFieldString<IT_KessanZennou, BizDate> rthndymd2 = new ExDBFieldString<>("rthndymd2", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KessanZennou> rthndzndk3 = new ExDBFieldBizCurrency<>("rthndzndk3", this);

    public final ExDBFieldString<IT_KessanZennou, BizNumber> tkyrt3 = new ExDBFieldString<>("tkyrt3", this, BizNumberType.class);

    public final ExDBFieldString<IT_KessanZennou, BizDate> rthndymd3 = new ExDBFieldString<>("rthndymd3", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KessanZennou> rthndzndk4 = new ExDBFieldBizCurrency<>("rthndzndk4", this);

    public final ExDBFieldString<IT_KessanZennou, BizNumber> tkyrt4 = new ExDBFieldString<>("tkyrt4", this, BizNumberType.class);

    public final ExDBFieldString<IT_KessanZennou, BizDate> rthndymd4 = new ExDBFieldString<>("rthndymd4", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KessanZennou> tndmatuzndk = new ExDBFieldBizCurrency<>("tndmatuzndk", this);

    public final ExDBFieldString<IT_KessanZennou, BizNumber> tndmatutkyrt = new ExDBFieldString<>("tndmatutkyrt", this, BizNumberType.class);

    public final ExDBFieldString<IT_KessanZennou, BizDate> zennounyuukinymd = new ExDBFieldString<>("zennounyuukinymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KessanZennou, String> tndzndkhikakukbn = new ExDBFieldString<>("tndzndkhikakukbn", this);

    public final ExDBFieldString<IT_KessanZennou, String> zennoukikan = new ExDBFieldString<>("zennoukikan", this);

    public final ExDBFieldString<IT_KessanZennou, String> yobi01xv1 = new ExDBFieldString<>("yobi01xv1", this);

    public final ExDBFieldString<IT_KessanZennou, String> bosyuukeitaikbn = new ExDBFieldString<>("bosyuukeitaikbn", this);

    public final ExDBFieldString<IT_KessanZennou, String> yobi02xv11 = new ExDBFieldString<>("yobi02xv11", this);
}
