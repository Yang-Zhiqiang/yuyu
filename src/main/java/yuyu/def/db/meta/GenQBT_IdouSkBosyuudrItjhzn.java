package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BT_IdouSkBosyuudrItjhzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 異動新契約募集代理店一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouSkBosyuudrItjhzn extends AbstractExDBTable<BT_IdouSkBosyuudrItjhzn> {

    public GenQBT_IdouSkBosyuudrItjhzn() {
        this("BT_IdouSkBosyuudrItjhzn");
    }

    public GenQBT_IdouSkBosyuudrItjhzn(String pAlias) {
        super("BT_IdouSkBosyuudrItjhzn", BT_IdouSkBosyuudrItjhzn.class, pAlias);
    }

    public String BT_IdouSkBosyuudrItjhzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouSkBosyuudrItjhzn, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<BT_IdouSkBosyuudrItjhzn, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouSkBosyuudrItjhzn, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<BT_IdouSkBosyuudrItjhzn, BizNumber> bunwari1 = new ExDBFieldString<>("bunwari1", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouSkBosyuudrItjhzn, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<BT_IdouSkBosyuudrItjhzn, BizNumber> bunwari2 = new ExDBFieldString<>("bunwari2", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouSkBosyuudrItjhzn, String> kanrisosikicd1 = new ExDBFieldString<>("kanrisosikicd1", this);

    public final ExDBFieldString<BT_IdouSkBosyuudrItjhzn, String> kanrisosikicd2 = new ExDBFieldString<>("kanrisosikicd2", this);
}
