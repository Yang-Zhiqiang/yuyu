package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * 新契約整備指示内容マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SkSeibiSijiNaiyou extends AbstractExDBTable<HM_SkSeibiSijiNaiyou> {

    public GenQHM_SkSeibiSijiNaiyou() {
        this("HM_SkSeibiSijiNaiyou");
    }

    public GenQHM_SkSeibiSijiNaiyou(String pAlias) {
        super("HM_SkSeibiSijiNaiyou", HM_SkSeibiSijiNaiyou.class, pAlias);
    }

    public String HM_SkSeibiSijiNaiyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SkSeibiSijiNaiyou, String> skseibisijinaiyoucd = new ExDBFieldString<>("skseibisijinaiyoucd", this);

    public final ExDBFieldString<HM_SkSeibiSijiNaiyou, String> skseibisijinaiyou = new ExDBFieldString<>("skseibisijinaiyou", this);

    public final ExDBFieldNumber<HM_SkSeibiSijiNaiyou, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldString<HM_SkSeibiSijiNaiyou, C_KahiKbn> hyoujikahikbn = new ExDBFieldString<>("hyoujikahikbn", this, UserType_C_KahiKbn.class);
}
