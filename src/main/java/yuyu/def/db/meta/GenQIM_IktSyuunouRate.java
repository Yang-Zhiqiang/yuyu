package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.IM_IktSyuunouRate;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 一括収納率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_IktSyuunouRate extends AbstractExDBTable<IM_IktSyuunouRate> {

    public GenQIM_IktSyuunouRate() {
        this("IM_IktSyuunouRate");
    }

    public GenQIM_IktSyuunouRate(String pAlias) {
        super("IM_IktSyuunouRate", IM_IktSyuunouRate.class, pAlias);
    }

    public String IM_IktSyuunouRate() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_IktSyuunouRate, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IM_IktSyuunouRate, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<IM_IktSyuunouRate, Integer> iktkaisuu = new ExDBFieldNumber<>("iktkaisuu", this);

    public final ExDBFieldString<IM_IktSyuunouRate, BizNumber> iktsyunoritu = new ExDBFieldString<>("iktsyunoritu", this, BizNumberType.class);

    public final ExDBFieldString<IM_IktSyuunouRate, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_IktSyuunouRate, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_IktSyuunouRate, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
