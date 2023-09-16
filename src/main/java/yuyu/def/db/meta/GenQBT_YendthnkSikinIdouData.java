package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KeiriyendthnkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_YendthnkSikinIdouData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KeiriyendthnkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 円建変更資金移動データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_YendthnkSikinIdouData extends AbstractExDBTable<BT_YendthnkSikinIdouData> {

    public GenQBT_YendthnkSikinIdouData() {
        this("BT_YendthnkSikinIdouData");
    }

    public GenQBT_YendthnkSikinIdouData(String pAlias) {
        super("BT_YendthnkSikinIdouData", BT_YendthnkSikinIdouData.class, pAlias);
    }

    public String BT_YendthnkSikinIdouData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_YendthnkSikinIdouData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BT_YendthnkSikinIdouData, C_KeiriyendthnkKbn> keiriyendthnkkbn = new ExDBFieldString<>("keiriyendthnkkbn", this, UserType_C_KeiriyendthnkKbn.class);

    public final ExDBFieldString<BT_YendthnkSikinIdouData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_YendthnkSikinIdouData, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BT_YendthnkSikinIdouData, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BT_YendthnkSikinIdouData, C_Tuukasyu> siteituuka = new ExDBFieldString<>("siteituuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_YendthnkSikinIdouData> siteituukagk = new ExDBFieldBizCurrency<>("siteituukagk", this);

    public final ExDBFieldString<BT_YendthnkSikinIdouData, C_Tuukasyu> trhktuuka = new ExDBFieldString<>("trhktuuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_YendthnkSikinIdouData> trhktuukagk = new ExDBFieldBizCurrency<>("trhktuukagk", this);
}
