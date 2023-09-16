package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_KzkkijiKbn;
import yuyu.def.db.entity.HT_KokutisyoVrf;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KijiKbn;
import yuyu.def.db.type.UserType_C_KituenKbn;
import yuyu.def.db.type.UserType_C_KzkkijiKbn;

/**
 * 告知書ベリファイテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_KokutisyoVrf extends AbstractExDBTable<HT_KokutisyoVrf> {

    public GenQHT_KokutisyoVrf() {
        this("HT_KokutisyoVrf");
    }

    public GenQHT_KokutisyoVrf(String pAlias) {
        super("HT_KokutisyoVrf", HT_KokutisyoVrf.class, pAlias);
    }

    public String HT_KokutisyoVrf() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_KokutisyoVrf, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_KokutisyoVrf, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_KokutisyoVrf, Integer> sintyou = new ExDBFieldNumber<>("sintyou", this);

    public final ExDBFieldNumber<HT_KokutisyoVrf, Integer> taijyuu = new ExDBFieldNumber<>("taijyuu", this);

    public final ExDBFieldString<HT_KokutisyoVrf, C_KituenKbn> kituenkbn = new ExDBFieldString<>("kituenkbn", this, UserType_C_KituenKbn.class);

    public final ExDBFieldNumber<HT_KokutisyoVrf, Integer> kituenhon = new ExDBFieldNumber<>("kituenhon", this);

    public final ExDBFieldString<HT_KokutisyoVrf, C_KijiKbn> kijikbn = new ExDBFieldString<>("kijikbn", this, UserType_C_KijiKbn.class);

    public final ExDBFieldString<HT_KokutisyoVrf, C_KzkkijiKbn> kzkkijikbn = new ExDBFieldString<>("kzkkijikbn", this, UserType_C_KzkkijiKbn.class);

    public final ExDBFieldString<HT_KokutisyoVrf, String> hbcmnt = new ExDBFieldString<>("hbcmnt", this);

    public final ExDBFieldString<HT_KokutisyoVrf, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_KokutisyoVrf, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
