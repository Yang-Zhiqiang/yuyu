package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BT_IdouKhMeigiItjhzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 異動契約保全名義管理一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouKhMeigiItjhzn extends AbstractExDBTable<BT_IdouKhMeigiItjhzn> {

    public GenQBT_IdouKhMeigiItjhzn() {
        this("BT_IdouKhMeigiItjhzn");
    }

    public GenQBT_IdouKhMeigiItjhzn(String pAlias) {
        super("BT_IdouKhMeigiItjhzn", BT_IdouKhMeigiItjhzn.class, pAlias);
    }

    public String BT_IdouKhMeigiItjhzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<BT_IdouKhMeigiItjhzn, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> hhknadr1kj = new ExDBFieldString<>("hhknadr1kj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> hhknadr2kj = new ExDBFieldString<>("hhknadr2kj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> hhknadr3kj = new ExDBFieldString<>("hhknadr3kj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> hhkntelno = new ExDBFieldString<>("hhkntelno", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> nenkinuktnmkana = new ExDBFieldString<>("nenkinuktnmkana", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> nenkinuktnmkanji = new ExDBFieldString<>("nenkinuktnmkanji", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, BizDate> nenkinuktseiymd = new ExDBFieldString<>("nenkinuktseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> sbuktnmkn1 = new ExDBFieldString<>("sbuktnmkn1", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> sbuktnmkj1 = new ExDBFieldString<>("sbuktnmkj1", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> sbuktnmkn2 = new ExDBFieldString<>("sbuktnmkn2", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> sbuktnmkj2 = new ExDBFieldString<>("sbuktnmkj2", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> sbuktnmkn3 = new ExDBFieldString<>("sbuktnmkn3", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> sbuktnmkj3 = new ExDBFieldString<>("sbuktnmkj3", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> sbuktnmkn4 = new ExDBFieldString<>("sbuktnmkn4", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> sbuktnmkj4 = new ExDBFieldString<>("sbuktnmkj4", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> stdrsknmkn = new ExDBFieldString<>("stdrsknmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> stdrsknmkj = new ExDBFieldString<>("stdrsknmkj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kykdairinmkn = new ExDBFieldString<>("kykdairinmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kykdairinmkj = new ExDBFieldString<>("kykdairinmkj", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kzktourokunmkn1 = new ExDBFieldString<>("kzktourokunmkn1", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kzktourokunmkj1 = new ExDBFieldString<>("kzktourokunmkj1", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kzktourokunmkn2 = new ExDBFieldString<>("kzktourokunmkn2", this);

    public final ExDBFieldString<BT_IdouKhMeigiItjhzn, String> kzktourokunmkj2 = new ExDBFieldString<>("kzktourokunmkj2", this);
}
