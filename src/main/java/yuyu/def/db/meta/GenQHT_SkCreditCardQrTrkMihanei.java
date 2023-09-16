package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.HT_SkCreditCardQrTrkMihanei;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Syorizumiflg;

/**
 * 新契約クレジットカードＱＲ登録結果未反映テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkCreditCardQrTrkMihanei extends AbstractExDBTable<HT_SkCreditCardQrTrkMihanei> {

    public GenQHT_SkCreditCardQrTrkMihanei() {
        this("HT_SkCreditCardQrTrkMihanei");
    }

    public GenQHT_SkCreditCardQrTrkMihanei(String pAlias) {
        super("HT_SkCreditCardQrTrkMihanei", HT_SkCreditCardQrTrkMihanei.class, pAlias);
    }

    public String HT_SkCreditCardQrTrkMihanei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, BizDate> systemjyusinymd = new ExDBFieldString<>("systemjyusinymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> systemjyusintime = new ExDBFieldString<>("systemjyusintime", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> creditqrtrkkbn = new ExDBFieldString<>("creditqrtrkkbn", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> creditqrsousinkbn = new ExDBFieldString<>("creditqrsousinkbn", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, C_Syorizumiflg> syorizumiflg = new ExDBFieldString<>("syorizumiflg", this, UserType_C_Syorizumiflg.class);

    public final ExDBFieldBizCurrency<HT_SkCreditCardQrTrkMihanei> creditauthorigk = new ExDBFieldBizCurrency<>("creditauthorigk", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> tyuumonno = new ExDBFieldString<>("tyuumonno", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> bluegateshopid = new ExDBFieldString<>("bluegateshopid", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, BizDate> kessaisyoriymd = new ExDBFieldString<>("kessaisyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> creditqrerrorcd = new ExDBFieldString<>("creditqrerrorcd", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> syouninnoseven = new ExDBFieldString<>("syouninnoseven", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> bluegateerrorcd = new ExDBFieldString<>("bluegateerrorcd", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> hisimukekaisyacd = new ExDBFieldString<>("hisimukekaisyacd", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> bluegatejyusinymdtime = new ExDBFieldString<>("bluegatejyusinymdtime", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkCreditCardQrTrkMihanei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
