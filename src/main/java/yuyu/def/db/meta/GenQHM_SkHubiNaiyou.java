package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.HM_SkHubiNaiyou;
import yuyu.def.db.type.UserType_C_KahiKbn;

/**
 * 新契約不備内容マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SkHubiNaiyou extends AbstractExDBTable<HM_SkHubiNaiyou> {

    public GenQHM_SkHubiNaiyou() {
        this("HM_SkHubiNaiyou");
    }

    public GenQHM_SkHubiNaiyou(String pAlias) {
        super("HM_SkHubiNaiyou", HM_SkHubiNaiyou.class, pAlias);
    }

    public String HM_SkHubiNaiyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SkHubiNaiyou, String> skhubikoumokucd = new ExDBFieldString<>("skhubikoumokucd", this);

    public final ExDBFieldString<HM_SkHubiNaiyou, String> skhubinaiyoucd = new ExDBFieldString<>("skhubinaiyoucd", this);

    public final ExDBFieldString<HM_SkHubiNaiyou, String> skhubinaiyou = new ExDBFieldString<>("skhubinaiyou", this);

    public final ExDBFieldString<HM_SkHubiNaiyou, String> skhubinaiyousentakumongon = new ExDBFieldString<>("skhubinaiyousentakumongon", this);

    public final ExDBFieldString<HM_SkHubiNaiyou, String> skseibisijinaiyoucd = new ExDBFieldString<>("skseibisijinaiyoucd", this);

    public final ExDBFieldString<HM_SkHubiNaiyou, String> skhubirenrakunaiyoucd = new ExDBFieldString<>("skhubirenrakunaiyoucd", this);

    public final ExDBFieldNumber<HM_SkHubiNaiyou, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldString<HM_SkHubiNaiyou, C_KahiKbn> hyoujikahikbn = new ExDBFieldString<>("hyoujikahikbn", this, UserType_C_KahiKbn.class);
}
