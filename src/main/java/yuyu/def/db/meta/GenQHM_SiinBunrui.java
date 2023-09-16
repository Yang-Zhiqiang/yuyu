package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.HM_SiinBunrui;

/**
 * 死因分類マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SiinBunrui extends AbstractExDBTable<HM_SiinBunrui> {

    public GenQHM_SiinBunrui() {
        this("HM_SiinBunrui");
    }

    public GenQHM_SiinBunrui(String pAlias) {
        super("HM_SiinBunrui", HM_SiinBunrui.class, pAlias);
    }

    public String HM_SiinBunrui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SiinBunrui, String> siincd = new ExDBFieldString<>("siincd", this);

    public final ExDBFieldString<HM_SiinBunrui, String> siintyuubunnruicd = new ExDBFieldString<>("siintyuubunnruicd", this);

    public final ExDBFieldString<HM_SiinBunrui, String> tyuusiincd = new ExDBFieldString<>("tyuusiincd", this);

    public final ExDBFieldString<HM_SiinBunrui, String> daisiincd = new ExDBFieldString<>("daisiincd", this);
}
