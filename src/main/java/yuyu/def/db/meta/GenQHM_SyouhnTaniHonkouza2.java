package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza2;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 商品単位本口座マスタ２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SyouhnTaniHonkouza2 extends AbstractExDBTable<HM_SyouhnTaniHonkouza2> {

    public GenQHM_SyouhnTaniHonkouza2() {
        this("HM_SyouhnTaniHonkouza2");
    }

    public GenQHM_SyouhnTaniHonkouza2(String pAlias) {
        super("HM_SyouhnTaniHonkouza2", HM_SyouhnTaniHonkouza2.class, pAlias);
    }

    public String HM_SyouhnTaniHonkouza2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SyouhnTaniHonkouza2, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<HM_SyouhnTaniHonkouza2, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HM_SyouhnTaniHonkouza2, String> honkouzacd = new ExDBFieldString<>("honkouzacd", this);
}
