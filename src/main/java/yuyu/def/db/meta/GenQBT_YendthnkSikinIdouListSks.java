package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_YendthnkSikinIdouListSks;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KeiriyendthnkKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 円建変更資金移動リスト作成用テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_YendthnkSikinIdouListSks extends AbstractExDBTable<BT_YendthnkSikinIdouListSks> {

    public GenQBT_YendthnkSikinIdouListSks() {
        this("BT_YendthnkSikinIdouListSks");
    }

    public GenQBT_YendthnkSikinIdouListSks(String pAlias) {
        super("BT_YendthnkSikinIdouListSks", BT_YendthnkSikinIdouListSks.class, pAlias);
    }

    public String BT_YendthnkSikinIdouListSks() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_YendthnkSikinIdouListSks, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BT_YendthnkSikinIdouListSks, C_KeiriyendthnkKbn> keiriyendthnkkbn = new ExDBFieldString<>("keiriyendthnkkbn", this, UserType_C_KeiriyendthnkKbn.class);

    public final ExDBFieldString<BT_YendthnkSikinIdouListSks, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_YendthnkSikinIdouListSks, C_Tuukasyu> siteituuka = new ExDBFieldString<>("siteituuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_YendthnkSikinIdouListSks> siteituukagk = new ExDBFieldBizCurrency<>("siteituukagk", this);

    public final ExDBFieldString<BT_YendthnkSikinIdouListSks, C_Tuukasyu> trhktuuka = new ExDBFieldString<>("trhktuuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_YendthnkSikinIdouListSks> trhktuukagk = new ExDBFieldBizCurrency<>("trhktuukagk", this);

    public final ExDBFieldString<BT_YendthnkSikinIdouListSks, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BT_YendthnkSikinIdouListSks, C_SikinidougroupKbn> sikinidougroupkbn = new ExDBFieldString<>("sikinidougroupkbn", this, UserType_C_SikinidougroupKbn.class);
}
