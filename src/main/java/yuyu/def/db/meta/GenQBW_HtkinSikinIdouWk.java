package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BW_HtkinSikinIdouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 配当金資金移動ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBW_HtkinSikinIdouWk extends AbstractExDBTable<BW_HtkinSikinIdouWk> {

    public GenQBW_HtkinSikinIdouWk() {
        this("BW_HtkinSikinIdouWk");
    }

    public GenQBW_HtkinSikinIdouWk(String pAlias) {
        super("BW_HtkinSikinIdouWk", BW_HtkinSikinIdouWk.class, pAlias);
    }

    public String BW_HtkinSikinIdouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BW_HtkinSikinIdouWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BW_HtkinSikinIdouWk, BizDate> kijyunymd = new ExDBFieldString<>("kijyunymd", this, BizDateType.class);

    public final ExDBFieldString<BW_HtkinSikinIdouWk, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldString<BW_HtkinSikinIdouWk, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BW_HtkinSikinIdouWk> seisikiwariategaku = new ExDBFieldBizCurrency<>("seisikiwariategaku", this);

    public final ExDBFieldString<BW_HtkinSikinIdouWk, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BW_HtkinSikinIdouWk, BizNumber> sikinidoukawaserate = new ExDBFieldString<>("sikinidoukawaserate", this, BizNumberType.class);
}
