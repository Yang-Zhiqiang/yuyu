package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 異動新契約募集代理店テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouSkBosyuudr extends AbstractExDBTable<BT_IdouSkBosyuudr> {

    public GenQBT_IdouSkBosyuudr() {
        this("BT_IdouSkBosyuudr");
    }

    public GenQBT_IdouSkBosyuudr(String pAlias) {
        super("BT_IdouSkBosyuudr", BT_IdouSkBosyuudr.class, pAlias);
    }

    public String BT_IdouSkBosyuudr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouSkBosyuudr, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<BT_IdouSkBosyuudr, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouSkBosyuudr, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<BT_IdouSkBosyuudr, BizNumber> bunwari1 = new ExDBFieldString<>("bunwari1", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouSkBosyuudr, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<BT_IdouSkBosyuudr, BizNumber> bunwari2 = new ExDBFieldString<>("bunwari2", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouSkBosyuudr, String> kanrisosikicd1 = new ExDBFieldString<>("kanrisosikicd1", this);

    public final ExDBFieldString<BT_IdouSkBosyuudr, String> kanrisosikicd2 = new ExDBFieldString<>("kanrisosikicd2", this);
}
