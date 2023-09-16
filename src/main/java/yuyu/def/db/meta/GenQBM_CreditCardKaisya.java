package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.db.entity.BM_CreditCardKaisya;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HasuusyoriKbn;

/**
 * クレジットカード会社マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_CreditCardKaisya extends AbstractExDBTable<BM_CreditCardKaisya> {

    public GenQBM_CreditCardKaisya() {
        this("BM_CreditCardKaisya");
    }

    public GenQBM_CreditCardKaisya(String pAlias) {
        super("BM_CreditCardKaisya", BM_CreditCardKaisya.class, pAlias);
    }

    public String BM_CreditCardKaisya() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_CreditCardKaisya, String> cardkaisyacd = new ExDBFieldString<>("cardkaisyacd", this);

    public final ExDBFieldNumber<BM_CreditCardKaisya, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldString<BM_CreditCardKaisya, String> prefixstart = new ExDBFieldString<>("prefixstart", this);

    public final ExDBFieldString<BM_CreditCardKaisya, String> prefixend = new ExDBFieldString<>("prefixend", this);

    public final ExDBFieldNumber<BM_CreditCardKaisya, Integer> cardnolength = new ExDBFieldNumber<>("cardnolength", this);

    public final ExDBFieldString<BM_CreditCardKaisya, String> cardkaisyanm = new ExDBFieldString<>("cardkaisyanm", this);

    public final ExDBFieldString<BM_CreditCardKaisya, String> cardkaisyanmryk = new ExDBFieldString<>("cardkaisyanmryk", this);

    public final ExDBFieldString<BM_CreditCardKaisya, String> creditsyuudaikocd = new ExDBFieldString<>("creditsyuudaikocd", this);

    public final ExDBFieldString<BM_CreditCardKaisya, String> torihikisakicd = new ExDBFieldString<>("torihikisakicd", this);

    public final ExDBFieldNumber<BM_CreditCardKaisya, Integer> authoriyuukoukikannissuu = new ExDBFieldNumber<>("authoriyuukoukikannissuu", this);

    public final ExDBFieldString<BM_CreditCardKaisya, BizNumber> tesuuryouryouritu = new ExDBFieldString<>("tesuuryouryouritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_CreditCardKaisya, C_HasuusyoriKbn> tesuuryouhasuusyorikbn = new ExDBFieldString<>("tesuuryouhasuusyorikbn", this, UserType_C_HasuusyoriKbn.class);

    public final ExDBFieldString<BM_CreditCardKaisya, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_CreditCardKaisya, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
