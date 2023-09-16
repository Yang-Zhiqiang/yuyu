package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BT_IdouNkBosyuudrItjhzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 異動年金支払募集代理店一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouNkBosyuudrItjhzn extends AbstractExDBTable<BT_IdouNkBosyuudrItjhzn> {

    public GenQBT_IdouNkBosyuudrItjhzn() {
        this("BT_IdouNkBosyuudrItjhzn");
    }

    public GenQBT_IdouNkBosyuudrItjhzn(String pAlias) {
        super("BT_IdouNkBosyuudrItjhzn", BT_IdouNkBosyuudrItjhzn.class, pAlias);
    }

    public String BT_IdouNkBosyuudrItjhzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouNkBosyuudrItjhzn, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldNumber<BT_IdouNkBosyuudrItjhzn, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouNkBosyuudrItjhzn, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<BT_IdouNkBosyuudrItjhzn, BizNumber> bunwari1 = new ExDBFieldString<>("bunwari1", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouNkBosyuudrItjhzn, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<BT_IdouNkBosyuudrItjhzn, BizNumber> bunwari2 = new ExDBFieldString<>("bunwari2", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouNkBosyuudrItjhzn, String> kanrisosikicd1 = new ExDBFieldString<>("kanrisosikicd1", this);

    public final ExDBFieldString<BT_IdouNkBosyuudrItjhzn, String> kanrisosikicd2 = new ExDBFieldString<>("kanrisosikicd2", this);
}
