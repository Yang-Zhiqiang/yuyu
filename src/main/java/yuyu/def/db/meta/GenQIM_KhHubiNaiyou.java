package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhHubiNaiyou;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全不備内容マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_KhHubiNaiyou extends AbstractExDBTable<IM_KhHubiNaiyou> {

    public GenQIM_KhHubiNaiyou() {
        this("IM_KhHubiNaiyou");
    }

    public GenQIM_KhHubiNaiyou(String pAlias) {
        super("IM_KhHubiNaiyou", IM_KhHubiNaiyou.class, pAlias);
    }

    public String IM_KhHubiNaiyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_KhHubiNaiyou, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<IM_KhHubiNaiyou, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IM_KhHubiNaiyou, C_HassinsakiKbn> hassinsakikbn = new ExDBFieldString<>("hassinsakikbn", this, UserType_C_HassinsakiKbn.class);

    public final ExDBFieldString<IM_KhHubiNaiyou, C_UmuKbn> genponhnkykumu = new ExDBFieldString<>("genponhnkykumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<IM_KhHubiNaiyou, Integer> hubinaiyouhyoujijyun = new ExDBFieldNumber<>("hubinaiyouhyoujijyun", this);

    public final ExDBFieldString<IM_KhHubiNaiyou, String> hubinaiyoucd = new ExDBFieldString<>("hubinaiyoucd", this);

    public final ExDBFieldString<IM_KhHubiNaiyou, String> hubinaiyou = new ExDBFieldString<>("hubinaiyou", this);

    public final ExDBFieldString<IM_KhHubiNaiyou, String> hubisyoruimsg = new ExDBFieldString<>("hubisyoruimsg", this);
}
