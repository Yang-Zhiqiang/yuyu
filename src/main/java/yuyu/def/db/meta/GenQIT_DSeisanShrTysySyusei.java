package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.IT_DSeisanShrTysySyusei;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * Ｄ精算支払調書修正テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_DSeisanShrTysySyusei extends AbstractExDBTable<IT_DSeisanShrTysySyusei> {

    public GenQIT_DSeisanShrTysySyusei() {
        this("IT_DSeisanShrTysySyusei");
    }

    public GenQIT_DSeisanShrTysySyusei(String pAlias) {
        super("IT_DSeisanShrTysySyusei", IT_DSeisanShrTysySyusei.class, pAlias);
    }

    public String IT_DSeisanShrTysySyusei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_DSeisanShrTysySyusei, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_DSeisanShrTysySyusei, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_DSeisanShrTysySyusei, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_DSeisanShrTysySyusei, BizDate> seisandshrymd = new ExDBFieldString<>("seisandshrymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_DSeisanShrTysySyusei> seisand = new ExDBFieldBizCurrency<>("seisand", this);

    public final ExDBFieldBizCurrency<IT_DSeisanShrTysySyusei> tyouseid = new ExDBFieldBizCurrency<>("tyouseid", this);

    public final ExDBFieldString<IT_DSeisanShrTysySyusei, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_DSeisanShrTysySyusei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_DSeisanShrTysySyusei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
