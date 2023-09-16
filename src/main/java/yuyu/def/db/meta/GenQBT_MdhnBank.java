package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KydsskkinyuukntkyKbn;
import yuyu.def.classification.C_MdhncifcdknrKbn;
import yuyu.def.classification.C_MdhnhontensitenKbn;
import yuyu.def.classification.C_MdhntyhyhrtkKbn;
import yuyu.def.classification.C_TkrtkkinyuukntkyKbn;
import yuyu.def.db.entity.BT_MdhnBank;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KydsskkinyuukntkyKbn;
import yuyu.def.db.type.UserType_C_MdhncifcdknrKbn;
import yuyu.def.db.type.UserType_C_MdhnhontensitenKbn;
import yuyu.def.db.type.UserType_C_MdhntyhyhrtkKbn;
import yuyu.def.db.type.UserType_C_TkrtkkinyuukntkyKbn;

/**
 * 窓販銀行テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_MdhnBank extends AbstractExDBTable<BT_MdhnBank> {

    public GenQBT_MdhnBank() {
        this("BT_MdhnBank");
    }

    public GenQBT_MdhnBank(String pAlias) {
        super("BT_MdhnBank", BT_MdhnBank.class, pAlias);
    }

    public String BT_MdhnBank() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_MdhnBank, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<BT_MdhnBank, String> mdhnbankcd = new ExDBFieldString<>("mdhnbankcd", this);

    public final ExDBFieldString<BT_MdhnBank, C_MdhnhontensitenKbn> mdhnhontensitenkbn = new ExDBFieldString<>("mdhnhontensitenkbn", this, UserType_C_MdhnhontensitenKbn.class);

    public final ExDBFieldString<BT_MdhnBank, String> mdhnsitencd = new ExDBFieldString<>("mdhnsitencd", this);

    public final ExDBFieldString<BT_MdhnBank, C_MdhncifcdknrKbn> mdhncifcdknrkbn = new ExDBFieldString<>("mdhncifcdknrkbn", this, UserType_C_MdhncifcdknrKbn.class);

    public final ExDBFieldString<BT_MdhnBank, C_TkrtkkinyuukntkyKbn> tkrtkkinyuukntkykbn = new ExDBFieldString<>("tkrtkkinyuukntkykbn", this, UserType_C_TkrtkkinyuukntkyKbn.class);

    public final ExDBFieldString<BT_MdhnBank, BizDate> tkrtkkinyuukntkyymd = new ExDBFieldString<>("tkrtkkinyuukntkyymd", this, BizDateType.class);

    public final ExDBFieldString<BT_MdhnBank, C_KydsskkinyuukntkyKbn> kydsskkinyuukntkykbn = new ExDBFieldString<>("kydsskkinyuukntkykbn", this, UserType_C_KydsskkinyuukntkyKbn.class);

    public final ExDBFieldString<BT_MdhnBank, BizDate> kydsskkinyuukntkyymd = new ExDBFieldString<>("kydsskkinyuukntkyymd", this, BizDateType.class);

    public final ExDBFieldString<BT_MdhnBank, C_MdhntyhyhrtkKbn> mdhntyhyhrtkkbn = new ExDBFieldString<>("mdhntyhyhrtkkbn", this, UserType_C_MdhntyhyhrtkKbn.class);

    public final ExDBFieldString<BT_MdhnBank, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_MdhnBank, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_MdhnBank, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
