package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_HtkinSikinIdouListSksRk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 配当金資金移動リスト作成用履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_HtkinSikinIdouListSksRk extends AbstractExDBTable<BT_HtkinSikinIdouListSksRk> {

    public GenQBT_HtkinSikinIdouListSksRk() {
        this("BT_HtkinSikinIdouListSksRk");
    }

    public GenQBT_HtkinSikinIdouListSksRk(String pAlias) {
        super("BT_HtkinSikinIdouListSksRk", BT_HtkinSikinIdouListSksRk.class, pAlias);
    }

    public String BT_HtkinSikinIdouListSksRk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_HtkinSikinIdouListSksRk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BT_HtkinSikinIdouListSksRk, BizDate> kijyunymd = new ExDBFieldString<>("kijyunymd", this, BizDateType.class);

    public final ExDBFieldString<BT_HtkinSikinIdouListSksRk, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldString<BT_HtkinSikinIdouListSksRk, C_Tuukasyu> siteituuka = new ExDBFieldString<>("siteituuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_HtkinSikinIdouListSksRk> siteituukagk = new ExDBFieldBizCurrency<>("siteituukagk", this);

    public final ExDBFieldString<BT_HtkinSikinIdouListSksRk, C_Tuukasyu> trhktuuka = new ExDBFieldString<>("trhktuuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_HtkinSikinIdouListSksRk> trhktuukagk = new ExDBFieldBizCurrency<>("trhktuukagk", this);

    public final ExDBFieldString<BT_HtkinSikinIdouListSksRk, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BT_HtkinSikinIdouListSksRk, C_SikinidougroupKbn> sikinidougroupkbn = new ExDBFieldString<>("sikinidougroupkbn", this, UserType_C_SikinidougroupKbn.class);

    public final ExDBFieldString<BT_HtkinSikinIdouListSksRk, BizNumber> sikinidoukawaserate = new ExDBFieldString<>("sikinidoukawaserate", this, BizNumberType.class);
}
