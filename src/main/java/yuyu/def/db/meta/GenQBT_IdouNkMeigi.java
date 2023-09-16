package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.db.entity.BT_IdouNkMeigi;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;

/**
 * 異動年金支払名義管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouNkMeigi extends AbstractExDBTable<BT_IdouNkMeigi> {

    public GenQBT_IdouNkMeigi() {
        this("BT_IdouNkMeigi");
    }

    public GenQBT_IdouNkMeigi(String pAlias) {
        super("BT_IdouNkMeigi", BT_IdouNkMeigi.class, pAlias);
    }

    public String BT_IdouNkMeigi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouNkMeigi, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldNumber<BT_IdouNkMeigi, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<BT_IdouNkMeigi, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouNkMeigi, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<BT_IdouNkMeigi, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> hhknadr1kj = new ExDBFieldString<>("hhknadr1kj", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> hhknadr2kj = new ExDBFieldString<>("hhknadr2kj", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> hhknadr3kj = new ExDBFieldString<>("hhknadr3kj", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> hhkntelno = new ExDBFieldString<>("hhkntelno", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> nenkinuktnmkana = new ExDBFieldString<>("nenkinuktnmkana", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> nenkinuktnmkanji = new ExDBFieldString<>("nenkinuktnmkanji", this);

    public final ExDBFieldString<BT_IdouNkMeigi, BizDate> nenkinuktseiymd = new ExDBFieldString<>("nenkinuktseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouNkMeigi, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> stdrsknmkn = new ExDBFieldString<>("stdrsknmkn", this);

    public final ExDBFieldString<BT_IdouNkMeigi, String> stdrsknmkj = new ExDBFieldString<>("stdrsknmkj", this);
}
