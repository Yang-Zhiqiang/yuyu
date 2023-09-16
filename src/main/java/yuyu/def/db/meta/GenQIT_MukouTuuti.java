package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.IT_MukouTuuti;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_TyhyrenrakusikibetuKbn;

/**
 * 無効通知テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_MukouTuuti extends AbstractExDBTable<IT_MukouTuuti> {

    public GenQIT_MukouTuuti() {
        this("IT_MukouTuuti");
    }

    public GenQIT_MukouTuuti(String pAlias) {
        super("IT_MukouTuuti", IT_MukouTuuti.class, pAlias);
    }

    public String IT_MukouTuuti() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_MukouTuuti, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_MukouTuuti, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_MukouTuuti, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_MukouTuuti, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<IT_MukouTuuti, String> oyadrtennmkj = new ExDBFieldString<>("oyadrtennmkj", this);

    public final ExDBFieldString<IT_MukouTuuti, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_MukouTuuti, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_MukouTuuti, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_MukouTuuti, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_MukouTuuti, String> tsinadr4kj = new ExDBFieldString<>("tsinadr4kj", this);

    public final ExDBFieldString<IT_MukouTuuti, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_MukouTuuti, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_MukouTuuti, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_MukouTuuti, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldBizCurrency<IT_MukouTuuti> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_MukouTuuti, BizDate> yykknmnryymd = new ExDBFieldString<>("yykknmnryymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_MukouTuuti, Integer> rtratkicd = new ExDBFieldNumber<>("rtratkicd", this);

    public final ExDBFieldString<IT_MukouTuuti, String> rtyouhyoucd = new ExDBFieldString<>("rtyouhyoucd", this);

    public final ExDBFieldString<IT_MukouTuuti, C_TyhyrenrakusikibetuKbn> tyhyrenrakusikibetukbn = new ExDBFieldString<>("tyhyrenrakusikibetukbn", this, UserType_C_TyhyrenrakusikibetuKbn.class);

    public final ExDBFieldString<IT_MukouTuuti, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_MukouTuuti, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_MukouTuuti, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
