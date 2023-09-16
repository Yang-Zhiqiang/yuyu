package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HrkmnykndatarenmotoKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_HrkmNyknSakujyo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HrkmnykndatarenmotoKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 振込入金削除テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_HrkmNyknSakujyo extends AbstractExDBTable<HT_HrkmNyknSakujyo> {

    public GenQHT_HrkmNyknSakujyo() {
        this("HT_HrkmNyknSakujyo");
    }

    public GenQHT_HrkmNyknSakujyo(String pAlias) {
        super("HT_HrkmNyknSakujyo", HT_HrkmNyknSakujyo.class, pAlias);
    }

    public String HT_HrkmNyknSakujyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_HrkmNyknSakujyo, String> hrkmdeldataskbtkey = new ExDBFieldString<>("hrkmdeldataskbtkey", this);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, BizDate> trkymd = new ExDBFieldString<>("trkymd", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, String> itirenno = new ExDBFieldString<>("itirenno", this);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, String> hrkmirninnm = new ExDBFieldString<>("hrkmirninnm", this);

    public final ExDBFieldBizCurrency<HT_HrkmNyknSakujyo> trhkkgk = new ExDBFieldBizCurrency<>("trhkkgk", this);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, BizDate> knjyymd = new ExDBFieldString<>("knjyymd", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, String> hrkmirnincd = new ExDBFieldString<>("hrkmirnincd", this);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, C_HrkmnykndatarenmotoKbn> hrkmnykndatarenmotoKbn = new ExDBFieldString<>("hrkmnykndatarenmotoKbn", this, UserType_C_HrkmnykndatarenmotoKbn.class);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, C_NyktyhyoutKbn> nyktyhyoutkbn = new ExDBFieldString<>("nyktyhyoutkbn", this, UserType_C_NyktyhyoutKbn.class);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_HrkmNyknSakujyo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
