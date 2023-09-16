package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SikinIdouKbn;
import yuyu.def.classification.C_SikinidougroupKbn;
import yuyu.def.classification.C_SikinidoumeisaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SikinIdouListSks;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DensysKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SikinIdouKbn;
import yuyu.def.db.type.UserType_C_SikinidougroupKbn;
import yuyu.def.db.type.UserType_C_SikinidoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 資金移動リスト作成用テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_SikinIdouListSks extends AbstractExDBTable<BT_SikinIdouListSks> {

    public GenQBT_SikinIdouListSks() {
        this("BT_SikinIdouListSks");
    }

    public GenQBT_SikinIdouListSks(String pAlias) {
        super("BT_SikinIdouListSks", BT_SikinIdouListSks.class, pAlias);
    }

    public String BT_SikinIdouListSks() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_SikinIdouListSks, C_DensysKbn> densyskbn = new ExDBFieldString<>("densyskbn", this, UserType_C_DensysKbn.class);

    public final ExDBFieldString<BT_SikinIdouListSks, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<BT_SikinIdouListSks, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<BT_SikinIdouListSks, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<BT_SikinIdouListSks, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldString<BT_SikinIdouListSks, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BT_SikinIdouListSks, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_SikinIdouListSks> keiyakutuukagk = new ExDBFieldBizCurrency<>("keiyakutuukagk", this);

    public final ExDBFieldString<BT_SikinIdouListSks, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_SikinIdouListSks> siharaituukagk = new ExDBFieldBizCurrency<>("siharaituukagk", this);

    public final ExDBFieldString<BT_SikinIdouListSks, C_SikinIdouKbn> sikinidoukbn = new ExDBFieldString<>("sikinidoukbn", this, UserType_C_SikinIdouKbn.class);

    public final ExDBFieldString<BT_SikinIdouListSks, C_SikinidougroupKbn> sikinidougroupkbn = new ExDBFieldString<>("sikinidougroupkbn", this, UserType_C_SikinidougroupKbn.class);

    public final ExDBFieldString<BT_SikinIdouListSks, C_SikinidoumeisaiKbn> sikinidoumeisaikbn = new ExDBFieldString<>("sikinidoumeisaikbn", this, UserType_C_SikinidoumeisaiKbn.class);
}
