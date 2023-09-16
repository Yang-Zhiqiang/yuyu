package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_NyuukinjyoutaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 未整理事由別明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MiseirijiyuuMeisai extends AbstractExDBTable<HT_MiseirijiyuuMeisai> {

    public GenQHT_MiseirijiyuuMeisai() {
        this("HT_MiseirijiyuuMeisai");
    }

    public GenQHT_MiseirijiyuuMeisai(String pAlias) {
        super("HT_MiseirijiyuuMeisai", HT_MiseirijiyuuMeisai.class, pAlias);
    }

    public String HT_MiseirijiyuuMeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> miseirijiyuukbn = new ExDBFieldString<>("miseirijiyuukbn", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> miseirijiyuudetailkbn = new ExDBFieldString<>("miseirijiyuudetailkbn", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, C_NyuukinjyoutaiKbn> nyuukinjoutaikbn = new ExDBFieldString<>("nyuukinjoutaikbn", this, UserType_C_NyuukinjyoutaiKbn.class);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn1 = new ExDBFieldString<>("syoruikbn1", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn2 = new ExDBFieldString<>("syoruikbn2", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn3 = new ExDBFieldString<>("syoruikbn3", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn4 = new ExDBFieldString<>("syoruikbn4", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn5 = new ExDBFieldString<>("syoruikbn5", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn6 = new ExDBFieldString<>("syoruikbn6", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn7 = new ExDBFieldString<>("syoruikbn7", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn8 = new ExDBFieldString<>("syoruikbn8", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn9 = new ExDBFieldString<>("syoruikbn9", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> syoruikbn10 = new ExDBFieldString<>("syoruikbn10", this);

    public final ExDBFieldNumber<HT_MiseirijiyuuMeisai, Integer> syoruihubikensuu = new ExDBFieldNumber<>("syoruihubikensuu", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, BizDate> syokaidenymd = new ExDBFieldString<>("syokaidenymd", this, BizDateType.class);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, BizDate> syokairsymd = new ExDBFieldString<>("syokairsymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<HT_MiseirijiyuuMeisai> rsgakuen = new ExDBFieldBizCurrency<>("rsgakuen", this);

    public final ExDBFieldBizCurrency<HT_MiseirijiyuuMeisai> rsgakugaika = new ExDBFieldBizCurrency<>("rsgakugaika", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<HT_MiseirijiyuuMeisai> krkhuho2syoukai = new ExDBFieldBizCurrency<>("krkhuho2syoukai", this);

    public final ExDBFieldBizCurrency<HT_MiseirijiyuuMeisai> krkhuho2kobetu = new ExDBFieldBizCurrency<>("krkhuho2kobetu", this);

    public final ExDBFieldBizCurrency<HT_MiseirijiyuuMeisai> krkdai1kaikeijyougkyen = new ExDBFieldBizCurrency<>("krkdai1kaikeijyougkyen", this);

    public final ExDBFieldBizCurrency<HT_MiseirijiyuuMeisai> krkdai1kaikeijyougkgaika = new ExDBFieldBizCurrency<>("krkdai1kaikeijyougkgaika", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, C_Tuukasyu> krkdai1kaituukasyu = new ExDBFieldString<>("krkdai1kaituukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MiseirijiyuuMeisai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
