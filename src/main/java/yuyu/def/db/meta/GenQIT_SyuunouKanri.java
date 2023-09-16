package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.db.entity.IT_SyuunouKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Syuudaikocd;

/**
 * 収納管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_SyuunouKanri extends AbstractExDBTable<IT_SyuunouKanri> {

    public GenQIT_SyuunouKanri() {
        this("IT_SyuunouKanri");
    }

    public GenQIT_SyuunouKanri(String pAlias) {
        super("IT_SyuunouKanri", IT_SyuunouKanri.class, pAlias);
    }

    public String IT_SyuunouKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_SyuunouKanri, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<IT_SyuunouKanri, BizDate> hurikaeymd = new ExDBFieldString<>("hurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SyuunouKanri, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldNumber<IT_SyuunouKanri, Integer> annaikensuu = new ExDBFieldNumber<>("annaikensuu", this);

    public final ExDBFieldBizCurrency<IT_SyuunouKanri> annaigk = new ExDBFieldBizCurrency<>("annaigk", this);

    public final ExDBFieldNumber<IT_SyuunouKanri, Integer> hurizumikensuu = new ExDBFieldNumber<>("hurizumikensuu", this);

    public final ExDBFieldBizCurrency<IT_SyuunouKanri> hurizumigk = new ExDBFieldBizCurrency<>("hurizumigk", this);

    public final ExDBFieldNumber<IT_SyuunouKanri, Integer> hurihunokensuu = new ExDBFieldNumber<>("hurihunokensuu", this);

    public final ExDBFieldBizCurrency<IT_SyuunouKanri> hurihunogk = new ExDBFieldBizCurrency<>("hurihunogk", this);

    public final ExDBFieldString<IT_SyuunouKanri, BizDate> syuunousyoriymd = new ExDBFieldString<>("syuunousyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_SyuunouKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_SyuunouKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_SyuunouKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
