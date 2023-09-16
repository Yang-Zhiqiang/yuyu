package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_TjtIdouNyNkItjhzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_NkSyoumetuCd;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 当日異動内容年金支払一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_TjtIdouNyNkItjhzn extends AbstractExDBTable<BT_TjtIdouNyNkItjhzn> {

    public GenQBT_TjtIdouNyNkItjhzn() {
        this("BT_TjtIdouNyNkItjhzn");
    }

    public GenQBT_TjtIdouNyNkItjhzn(String pAlias) {
        super("BT_TjtIdouNyNkItjhzn", BT_TjtIdouNyNkItjhzn.class, pAlias);
    }

    public String BT_TjtIdouNyNkItjhzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldNumber<BT_TjtIdouNyNkItjhzn, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldNumber<BT_TjtIdouNyNkItjhzn, Integer> recordsakujyohyouji = new ExDBFieldNumber<>("recordsakujyohyouji", this);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, String> youkyuuno = new ExDBFieldString<>("youkyuuno", this);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, BizDate> nkshrstartymd = new ExDBFieldString<>("nkshrstartymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, C_NkSyoumetuCd> nksyoumetucd = new ExDBFieldString<>("nksyoumetucd", this, UserType_C_NkSyoumetuCd.class);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, String> teinksyu = new ExDBFieldString<>("teinksyu", this);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyNkItjhzn> tsnyounkgns = new ExDBFieldBizCurrency<>("tsnyounkgns", this);

    public final ExDBFieldNumber<BT_TjtIdouNyNkItjhzn, Integer> nkukthhkndouhyouji = new ExDBFieldNumber<>("nkukthhkndouhyouji", this);

    public final ExDBFieldNumber<BT_TjtIdouNyNkItjhzn, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_TjtIdouNyNkItjhzn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
