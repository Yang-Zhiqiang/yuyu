package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_HijynNykSiknIdouLstSksGk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinidouJtKbn;
import yuyu.def.db.type.UserType_C_SikinidouPKbn;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;
import yuyu.def.db.type.UserType_C_SikinidoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 平準払入金用資金移動リスト作成用テーブル（外貨） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_HijynNykSiknIdouLstSksGk extends AbstractExDBTable<BT_HijynNykSiknIdouLstSksGk> {

    public GenQBT_HijynNykSiknIdouLstSksGk() {
        this("BT_HijynNykSiknIdouLstSksGk");
    }

    public GenQBT_HijynNykSiknIdouLstSksGk(String pAlias) {
        super("BT_HijynNykSiknIdouLstSksGk", BT_HijynNykSiknIdouLstSksGk.class, pAlias);
    }

    public String BT_HijynNykSiknIdouLstSksGk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, C_SikinidouPKbn> sikinidoupkbn = new ExDBFieldString<>("sikinidoupkbn", this, UserType_C_SikinidouPKbn.class);

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<BT_HijynNykSiknIdouLstSksGk, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, C_Tuukasyu> siteituuka = new ExDBFieldString<>("siteituuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_HijynNykSiknIdouLstSksGk> siteituukagk = new ExDBFieldBizCurrency<>("siteituukagk", this);

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, C_Tuukasyu> trhktuuka = new ExDBFieldString<>("trhktuuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_HijynNykSiknIdouLstSksGk> trhktuukagk = new ExDBFieldBizCurrency<>("trhktuukagk", this);

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, C_SikinidougroupKbn> sikinidougroupkbn = new ExDBFieldString<>("sikinidougroupkbn", this, UserType_C_SikinidougroupKbn.class);

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, C_SikinidoumeisaiKbn> sikinidoumeisaikbn = new ExDBFieldString<>("sikinidoumeisaikbn", this, UserType_C_SikinidoumeisaiKbn.class);

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, C_SikinidouJtKbn> sikinidoujtkbn = new ExDBFieldString<>("sikinidoujtkbn", this, UserType_C_SikinidouJtKbn.class);

    public final ExDBFieldString<BT_HijynNykSiknIdouLstSksGk, BizNumber> sikinidoukawaserate = new ExDBFieldString<>("sikinidoukawaserate", this, BizNumberType.class);
}
