package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BT_IdouSkMeigiItjhzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 異動新契約名義管理一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouSkMeigiItjhzn extends AbstractExDBTable<BT_IdouSkMeigiItjhzn> {

    public GenQBT_IdouSkMeigiItjhzn() {
        this("BT_IdouSkMeigiItjhzn");
    }

    public GenQBT_IdouSkMeigiItjhzn(String pAlias) {
        super("BT_IdouSkMeigiItjhzn", BT_IdouSkMeigiItjhzn.class, pAlias);
    }

    public String BT_IdouSkMeigiItjhzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<BT_IdouSkMeigiItjhzn, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> hhknadr1kj = new ExDBFieldString<>("hhknadr1kj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> hhknadr2kj = new ExDBFieldString<>("hhknadr2kj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> hhknadr3kj = new ExDBFieldString<>("hhknadr3kj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> hhkntelno = new ExDBFieldString<>("hhkntelno", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> nenkinuktnmkana = new ExDBFieldString<>("nenkinuktnmkana", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> nenkinuktnmkanji = new ExDBFieldString<>("nenkinuktnmkanji", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, BizDate> nenkinuktseiymd = new ExDBFieldString<>("nenkinuktseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> sbuktnmkn1 = new ExDBFieldString<>("sbuktnmkn1", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> sbuktnmkj1 = new ExDBFieldString<>("sbuktnmkj1", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> sbuktnmkn2 = new ExDBFieldString<>("sbuktnmkn2", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> sbuktnmkj2 = new ExDBFieldString<>("sbuktnmkj2", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> sbuktnmkn3 = new ExDBFieldString<>("sbuktnmkn3", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> sbuktnmkj3 = new ExDBFieldString<>("sbuktnmkj3", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> sbuktnmkn4 = new ExDBFieldString<>("sbuktnmkn4", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> sbuktnmkj4 = new ExDBFieldString<>("sbuktnmkj4", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> stdrsknmkn = new ExDBFieldString<>("stdrsknmkn", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> stdrsknmkj = new ExDBFieldString<>("stdrsknmkj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kykdairinmkn = new ExDBFieldString<>("kykdairinmkn", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kykdairinmkj = new ExDBFieldString<>("kykdairinmkj", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kzktourokunmkn1 = new ExDBFieldString<>("kzktourokunmkn1", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kzktourokunmkj1 = new ExDBFieldString<>("kzktourokunmkj1", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kzktourokunmkn2 = new ExDBFieldString<>("kzktourokunmkn2", this);

    public final ExDBFieldString<BT_IdouSkMeigiItjhzn, String> kzktourokunmkj2 = new ExDBFieldString<>("kzktourokunmkj2", this);
}
