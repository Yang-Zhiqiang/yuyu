package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.db.entity.BT_IdouNkMeigiItjhzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;

/**
 * 異動年金支払名義管理一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouNkMeigiItjhzn extends AbstractExDBTable<BT_IdouNkMeigiItjhzn> {

    public GenQBT_IdouNkMeigiItjhzn() {
        this("BT_IdouNkMeigiItjhzn");
    }

    public GenQBT_IdouNkMeigiItjhzn(String pAlias) {
        super("BT_IdouNkMeigiItjhzn", BT_IdouNkMeigiItjhzn.class, pAlias);
    }

    public String BT_IdouNkMeigiItjhzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> nksysyno = new ExDBFieldString<>("nksysyno", this);

    public final ExDBFieldNumber<BT_IdouNkMeigiItjhzn, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> hhknadr1kj = new ExDBFieldString<>("hhknadr1kj", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> hhknadr2kj = new ExDBFieldString<>("hhknadr2kj", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> hhknadr3kj = new ExDBFieldString<>("hhknadr3kj", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> hhkntelno = new ExDBFieldString<>("hhkntelno", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> nenkinuktnmkana = new ExDBFieldString<>("nenkinuktnmkana", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> nenkinuktnmkanji = new ExDBFieldString<>("nenkinuktnmkanji", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, BizDate> nenkinuktseiymd = new ExDBFieldString<>("nenkinuktseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> stdrsknmkn = new ExDBFieldString<>("stdrsknmkn", this);

    public final ExDBFieldString<BT_IdouNkMeigiItjhzn, String> stdrsknmkj = new ExDBFieldString<>("stdrsknmkj", this);
}
