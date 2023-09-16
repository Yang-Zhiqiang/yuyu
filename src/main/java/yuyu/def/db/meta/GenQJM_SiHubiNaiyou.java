package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.JM_SiHubiNaiyou;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 支払不備内容マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_SiHubiNaiyou extends AbstractExDBTable<JM_SiHubiNaiyou> {

    public GenQJM_SiHubiNaiyou() {
        this("JM_SiHubiNaiyou");
    }

    public GenQJM_SiHubiNaiyou(String pAlias) {
        super("JM_SiHubiNaiyou", JM_SiHubiNaiyou.class, pAlias);
    }

    public String JM_SiHubiNaiyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_SiHubiNaiyou, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<JM_SiHubiNaiyou, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<JM_SiHubiNaiyou, String> hubinaiyoucd = new ExDBFieldString<>("hubinaiyoucd", this);

    public final ExDBFieldString<JM_SiHubiNaiyou, String> hubinaiyou = new ExDBFieldString<>("hubinaiyou", this);

    public final ExDBFieldString<JM_SiHubiNaiyou, String> hubisyoruimsg = new ExDBFieldString<>("hubisyoruimsg", this);
}
