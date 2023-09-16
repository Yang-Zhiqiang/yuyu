package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 異動契約保全名義管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_IdouKhMeigi extends AbstractExDBTable<BT_IdouKhMeigi> {

    public GenQBT_IdouKhMeigi() {
        this("BT_IdouKhMeigi");
    }

    public GenQBT_IdouKhMeigi(String pAlias) {
        super("BT_IdouKhMeigi", BT_IdouKhMeigi.class, pAlias);
    }

    public String BT_IdouKhMeigi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_IdouKhMeigi, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<BT_IdouKhMeigi, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouKhMeigi, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<BT_IdouKhMeigi, String> hhknyno = new ExDBFieldString<>("hhknyno", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> hhknadr1kj = new ExDBFieldString<>("hhknadr1kj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> hhknadr2kj = new ExDBFieldString<>("hhknadr2kj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> hhknadr3kj = new ExDBFieldString<>("hhknadr3kj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> hhkntelno = new ExDBFieldString<>("hhkntelno", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouKhMeigi, String> nenkinuktnmkana = new ExDBFieldString<>("nenkinuktnmkana", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> nenkinuktnmkanji = new ExDBFieldString<>("nenkinuktnmkanji", this);

    public final ExDBFieldString<BT_IdouKhMeigi, BizDate> nenkinuktseiymd = new ExDBFieldString<>("nenkinuktseiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_IdouKhMeigi, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> sbuktnmkn1 = new ExDBFieldString<>("sbuktnmkn1", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> sbuktnmkj1 = new ExDBFieldString<>("sbuktnmkj1", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> sbuktnmkn2 = new ExDBFieldString<>("sbuktnmkn2", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> sbuktnmkj2 = new ExDBFieldString<>("sbuktnmkj2", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> sbuktnmkn3 = new ExDBFieldString<>("sbuktnmkn3", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> sbuktnmkj3 = new ExDBFieldString<>("sbuktnmkj3", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> sbuktnmkn4 = new ExDBFieldString<>("sbuktnmkn4", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> sbuktnmkj4 = new ExDBFieldString<>("sbuktnmkj4", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> stdrsknmkn = new ExDBFieldString<>("stdrsknmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> stdrsknmkj = new ExDBFieldString<>("stdrsknmkj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kykdairinmkn = new ExDBFieldString<>("kykdairinmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kykdairinmkj = new ExDBFieldString<>("kykdairinmkj", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<BT_IdouKhMeigi, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<BT_IdouKhMeigi, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kzktourokunmkn1 = new ExDBFieldString<>("kzktourokunmkn1", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kzktourokunmkj1 = new ExDBFieldString<>("kzktourokunmkj1", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kzktourokunmkn2 = new ExDBFieldString<>("kzktourokunmkn2", this);

    public final ExDBFieldString<BT_IdouKhMeigi, String> kzktourokunmkj2 = new ExDBFieldString<>("kzktourokunmkj2", this);
}
