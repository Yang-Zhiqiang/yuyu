package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BT_IdouKhBosyuudrItjhzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 異動契約保全募集代理店一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouKhBosyuudrItjhzn extends AbstractExDBTable<BT_IdouKhBosyuudrItjhzn> {

    public GenQBT_IdouKhBosyuudrItjhzn() {
        this("BT_IdouKhBosyuudrItjhzn");
    }

    public GenQBT_IdouKhBosyuudrItjhzn(String pAlias) {
        super("BT_IdouKhBosyuudrItjhzn", BT_IdouKhBosyuudrItjhzn.class, pAlias);
    }

    public String BT_IdouKhBosyuudrItjhzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouKhBosyuudrItjhzn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<BT_IdouKhBosyuudrItjhzn, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouKhBosyuudrItjhzn, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<BT_IdouKhBosyuudrItjhzn, BizNumber> bunwari1 = new ExDBFieldString<>("bunwari1", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouKhBosyuudrItjhzn, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<BT_IdouKhBosyuudrItjhzn, BizNumber> bunwari2 = new ExDBFieldString<>("bunwari2", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouKhBosyuudrItjhzn, String> kanrisosikicd1 = new ExDBFieldString<>("kanrisosikicd1", this);

    public final ExDBFieldString<BT_IdouKhBosyuudrItjhzn, String> kanrisosikicd2 = new ExDBFieldString<>("kanrisosikicd2", this);
}
