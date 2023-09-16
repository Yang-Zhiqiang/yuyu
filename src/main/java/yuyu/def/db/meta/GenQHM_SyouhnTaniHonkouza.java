package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.HM_SyouhnTaniHonkouza;

/**
 * 商品単位本口座マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SyouhnTaniHonkouza extends AbstractExDBTable<HM_SyouhnTaniHonkouza> {

    public GenQHM_SyouhnTaniHonkouza() {
        this("HM_SyouhnTaniHonkouza");
    }

    public GenQHM_SyouhnTaniHonkouza(String pAlias) {
        super("HM_SyouhnTaniHonkouza", HM_SyouhnTaniHonkouza.class, pAlias);
    }

    public String HM_SyouhnTaniHonkouza() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SyouhnTaniHonkouza, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<HM_SyouhnTaniHonkouza, String> honkouzacd = new ExDBFieldString<>("honkouzacd", this);
}
