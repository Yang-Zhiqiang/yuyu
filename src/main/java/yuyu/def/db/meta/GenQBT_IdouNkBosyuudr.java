package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BT_IdouNkBosyuudr;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 異動年金支払募集代理店テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouNkBosyuudr extends AbstractExDBTable<BT_IdouNkBosyuudr> {

    public GenQBT_IdouNkBosyuudr() {
        this("BT_IdouNkBosyuudr");
    }

    public GenQBT_IdouNkBosyuudr(String pAlias) {
        super("BT_IdouNkBosyuudr", BT_IdouNkBosyuudr.class, pAlias);
    }

    public String BT_IdouNkBosyuudr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouNkBosyuudr, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldNumber<BT_IdouNkBosyuudr, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouNkBosyuudr, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<BT_IdouNkBosyuudr, BizNumber> bunwari1 = new ExDBFieldString<>("bunwari1", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouNkBosyuudr, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<BT_IdouNkBosyuudr, BizNumber> bunwari2 = new ExDBFieldString<>("bunwari2", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouNkBosyuudr, String> kanrisosikicd1 = new ExDBFieldString<>("kanrisosikicd1", this);

    public final ExDBFieldString<BT_IdouNkBosyuudr, String> kanrisosikicd2 = new ExDBFieldString<>("kanrisosikicd2", this);
}
