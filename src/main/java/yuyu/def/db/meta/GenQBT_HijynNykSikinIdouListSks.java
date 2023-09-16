package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_HijynNykSikinIdouListSks;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinidouJtKbn;
import yuyu.def.db.type.UserType_C_SikinidouPKbn;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;
import yuyu.def.db.type.UserType_C_SikinidoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 平準払入金用資金移動リスト作成用テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_HijynNykSikinIdouListSks extends AbstractExDBTable<BT_HijynNykSikinIdouListSks> {

    public GenQBT_HijynNykSikinIdouListSks() {
        this("BT_HijynNykSikinIdouListSks");
    }

    public GenQBT_HijynNykSikinIdouListSks(String pAlias) {
        super("BT_HijynNykSikinIdouListSks", BT_HijynNykSikinIdouListSks.class, pAlias);
    }

    public String BT_HijynNykSikinIdouListSks() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, BizDateYM> sikinidoupjytym = new ExDBFieldString<>("sikinidoupjytym", this, BizDateYMType.class);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, C_Tuukasyu> siteituuka = new ExDBFieldString<>("siteituuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_HijynNykSikinIdouListSks> siteituukagk = new ExDBFieldBizCurrency<>("siteituukagk", this);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, C_Tuukasyu> trhktuuka = new ExDBFieldString<>("trhktuuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_HijynNykSikinIdouListSks> trhktuukagk = new ExDBFieldBizCurrency<>("trhktuukagk", this);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, C_SikinidougroupKbn> sikinidougroupkbn = new ExDBFieldString<>("sikinidougroupkbn", this, UserType_C_SikinidougroupKbn.class);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, C_SikinidoumeisaiKbn> sikinidoumeisaikbn = new ExDBFieldString<>("sikinidoumeisaikbn", this, UserType_C_SikinidoumeisaiKbn.class);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, C_SikinidouJtKbn> sikinidoujtkbn = new ExDBFieldString<>("sikinidoujtkbn", this, UserType_C_SikinidouJtKbn.class);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, BizNumber> sikinidoukawaserate = new ExDBFieldString<>("sikinidoukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<BT_HijynNykSikinIdouListSks, C_SikinidouPKbn> sikinidoupkbn = new ExDBFieldString<>("sikinidoupkbn", this, UserType_C_SikinidouPKbn.class);
}
