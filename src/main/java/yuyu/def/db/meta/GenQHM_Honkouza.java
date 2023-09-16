package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_Honkouza;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 本口座マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_Honkouza extends AbstractExDBTable<HM_Honkouza> {

    public GenQHM_Honkouza() {
        this("HM_Honkouza");
    }

    public GenQHM_Honkouza(String pAlias) {
        super("HM_Honkouza", HM_Honkouza.class, pAlias);
    }

    public String HM_Honkouza() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_Honkouza, String> honkouzacd = new ExDBFieldString<>("honkouzacd", this);

    public final ExDBFieldString<HM_Honkouza, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HM_Honkouza, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HM_Honkouza, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HM_Honkouza, String> sikinidousakibankcd = new ExDBFieldString<>("sikinidousakibankcd", this);

    public final ExDBFieldString<HM_Honkouza, String> sikinidousakisitencd = new ExDBFieldString<>("sikinidousakisitencd", this);

    public final ExDBFieldString<HM_Honkouza, String> sikinidousakikouzano = new ExDBFieldString<>("sikinidousakikouzano", this);

    public final ExDBFieldString<HM_Honkouza, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldNumber<HM_Honkouza, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);
}
