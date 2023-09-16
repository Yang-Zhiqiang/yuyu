package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HM_SkHubiRenrakuNaiyou;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 新契約不備連絡内容マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SkHubiRenrakuNaiyou extends AbstractExDBTable<HM_SkHubiRenrakuNaiyou> {

    public GenQHM_SkHubiRenrakuNaiyou() {
        this("HM_SkHubiRenrakuNaiyou");
    }

    public GenQHM_SkHubiRenrakuNaiyou(String pAlias) {
        super("HM_SkHubiRenrakuNaiyou", HM_SkHubiRenrakuNaiyou.class, pAlias);
    }

    public String HM_SkHubiRenrakuNaiyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SkHubiRenrakuNaiyou, String> skhubirenrakunaiyoucd = new ExDBFieldString<>("skhubirenrakunaiyoucd", this);

    public final ExDBFieldString<HM_SkHubiRenrakuNaiyou, String> skhubirenrakunaiyou = new ExDBFieldString<>("skhubirenrakunaiyou", this);

    public final ExDBFieldString<HM_SkHubiRenrakuNaiyou, C_UmuKbn> tyoubunflg = new ExDBFieldString<>("tyoubunflg", this, UserType_C_UmuKbn.class);
}
