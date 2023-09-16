package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_KzkkijiKbn;
import yuyu.def.db.entity.HT_BosKokutisyo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KijiKbn;
import yuyu.def.db.type.UserType_C_KituenKbn;
import yuyu.def.db.type.UserType_C_KzkkijiKbn;

/**
 * 募集告知書テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_BosKokutisyo extends AbstractExDBTable<HT_BosKokutisyo> {

    public GenQHT_BosKokutisyo() {
        this("HT_BosKokutisyo");
    }

    public GenQHT_BosKokutisyo(String pAlias) {
        super("HT_BosKokutisyo", HT_BosKokutisyo.class, pAlias);
    }

    public String HT_BosKokutisyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_BosKokutisyo, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_BosKokutisyo, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_BosKokutisyo, Integer> sintyou = new ExDBFieldNumber<>("sintyou", this);

    public final ExDBFieldNumber<HT_BosKokutisyo, Integer> taijyuu = new ExDBFieldNumber<>("taijyuu", this);

    public final ExDBFieldString<HT_BosKokutisyo, C_KituenKbn> kituenkbn = new ExDBFieldString<>("kituenkbn", this, UserType_C_KituenKbn.class);

    public final ExDBFieldNumber<HT_BosKokutisyo, Integer> kituenhon = new ExDBFieldNumber<>("kituenhon", this);

    public final ExDBFieldString<HT_BosKokutisyo, C_KijiKbn> kijikbn = new ExDBFieldString<>("kijikbn", this, UserType_C_KijiKbn.class);

    public final ExDBFieldString<HT_BosKokutisyo, C_KzkkijiKbn> kzkkijikbn = new ExDBFieldString<>("kzkkijikbn", this, UserType_C_KzkkijiKbn.class);

    public final ExDBFieldString<HT_BosKokutisyo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_BosKokutisyo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
