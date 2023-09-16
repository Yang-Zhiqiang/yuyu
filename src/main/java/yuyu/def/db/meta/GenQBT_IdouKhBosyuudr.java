package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 異動契約保全募集代理店テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouKhBosyuudr extends AbstractExDBTable<BT_IdouKhBosyuudr> {

    public GenQBT_IdouKhBosyuudr() {
        this("BT_IdouKhBosyuudr");
    }

    public GenQBT_IdouKhBosyuudr(String pAlias) {
        super("BT_IdouKhBosyuudr", BT_IdouKhBosyuudr.class, pAlias);
    }

    public String BT_IdouKhBosyuudr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouKhBosyuudr, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<BT_IdouKhBosyuudr, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouKhBosyuudr, String> dairitencd1 = new ExDBFieldString<>("dairitencd1", this);

    public final ExDBFieldString<BT_IdouKhBosyuudr, BizNumber> bunwari1 = new ExDBFieldString<>("bunwari1", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouKhBosyuudr, String> dairitencd2 = new ExDBFieldString<>("dairitencd2", this);

    public final ExDBFieldString<BT_IdouKhBosyuudr, BizNumber> bunwari2 = new ExDBFieldString<>("bunwari2", this, BizNumberType.class);

    public final ExDBFieldString<BT_IdouKhBosyuudr, String> kanrisosikicd1 = new ExDBFieldString<>("kanrisosikicd1", this);

    public final ExDBFieldString<BT_IdouKhBosyuudr, String> kanrisosikicd2 = new ExDBFieldString<>("kanrisosikicd2", this);
}
