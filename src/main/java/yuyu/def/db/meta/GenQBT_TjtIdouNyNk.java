package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_NkSyoumetuCd;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 当日異動内容年金支払テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_TjtIdouNyNk extends AbstractExDBTable<BT_TjtIdouNyNk> {

    public GenQBT_TjtIdouNyNk() {
        this("BT_TjtIdouNyNk");
    }

    public GenQBT_TjtIdouNyNk(String pAlias) {
        super("BT_TjtIdouNyNk", BT_TjtIdouNyNk.class, pAlias);
    }

    public String BT_TjtIdouNyNk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_TjtIdouNyNk, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldNumber<BT_TjtIdouNyNk, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldNumber<BT_TjtIdouNyNk, Integer> recordsakujyohyouji = new ExDBFieldNumber<>("recordsakujyohyouji", this);

    public final ExDBFieldString<BT_TjtIdouNyNk, String> youkyuuno = new ExDBFieldString<>("youkyuuno", this);

    public final ExDBFieldString<BT_TjtIdouNyNk, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BT_TjtIdouNyNk, BizDate> nkshrstartymd = new ExDBFieldString<>("nkshrstartymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyNk, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyNk, C_NkSyoumetuCd> nksyoumetucd = new ExDBFieldString<>("nksyoumetucd", this, UserType_C_NkSyoumetuCd.class);

    public final ExDBFieldString<BT_TjtIdouNyNk, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyNk, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_TjtIdouNyNk, String> teinksyu = new ExDBFieldString<>("teinksyu", this);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyNk> tsnyounkgns = new ExDBFieldBizCurrency<>("tsnyounkgns", this);

    public final ExDBFieldNumber<BT_TjtIdouNyNk, Integer> nkukthhkndouhyouji = new ExDBFieldNumber<>("nkukthhkndouhyouji", this);

    public final ExDBFieldNumber<BT_TjtIdouNyNk, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BT_TjtIdouNyNk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_TjtIdouNyNk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_TjtIdouNyNk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
