package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IW_KhKzkPYokuJyuutouYoteiWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 継続Ｐ翌月充当予定ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhKzkPYokuJyuutouYoteiWk extends AbstractExDBTable<IW_KhKzkPYokuJyuutouYoteiWk> {

    public GenQIW_KhKzkPYokuJyuutouYoteiWk() {
        this("IW_KhKzkPYokuJyuutouYoteiWk");
    }

    public GenQIW_KhKzkPYokuJyuutouYoteiWk(String pAlias) {
        super("IW_KhKzkPYokuJyuutouYoteiWk", IW_KhKzkPYokuJyuutouYoteiWk.class, pAlias);
    }

    public String IW_KhKzkPYokuJyuutouYoteiWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhKzkPYokuJyuutouYoteiWk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IW_KhKzkPYokuJyuutouYoteiWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhKzkPYokuJyuutouYoteiWk, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<IW_KhKzkPYokuJyuutouYoteiWk, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IW_KhKzkPYokuJyuutouYoteiWk, BizDateYM> kykym = new ExDBFieldString<>("kykym", this, BizDateYMType.class);

    public final ExDBFieldString<IW_KhKzkPYokuJyuutouYoteiWk, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IW_KhKzkPYokuJyuutouYoteiWk, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldBizCurrency<IW_KhKzkPYokuJyuutouYoteiWk> hokenryou = new ExDBFieldBizCurrency<>("hokenryou", this);
}
