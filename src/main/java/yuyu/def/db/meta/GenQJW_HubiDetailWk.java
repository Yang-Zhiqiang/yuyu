package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JW_HubiDetailWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 支払不備詳細ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJW_HubiDetailWk extends AbstractExDBTable<JW_HubiDetailWk> {

    public GenQJW_HubiDetailWk() {
        this("JW_HubiDetailWk");
    }

    public GenQJW_HubiDetailWk(String pAlias) {
        super("JW_HubiDetailWk", JW_HubiDetailWk.class, pAlias);
    }

    public String JW_HubiDetailWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JW_HubiDetailWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldNumber<JW_HubiDetailWk, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<JW_HubiDetailWk, C_SyoruiCdKbn> hubisyoruicd = new ExDBFieldString<>("hubisyoruicd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<JW_HubiDetailWk, String> hubisyoruinm = new ExDBFieldString<>("hubisyoruinm", this);

    public final ExDBFieldString<JW_HubiDetailWk, String> hubinaiyoucd = new ExDBFieldString<>("hubinaiyoucd", this);

    public final ExDBFieldString<JW_HubiDetailWk, String> hubinaiyoumsg = new ExDBFieldString<>("hubinaiyoumsg", this);

    public final ExDBFieldString<JW_HubiDetailWk, BizDate> trkymd = new ExDBFieldString<>("trkymd", this, BizDateType.class);

    public final ExDBFieldString<JW_HubiDetailWk, C_UmuKbn> genponhnkykumu = new ExDBFieldString<>("genponhnkykumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JW_HubiDetailWk, C_HassinsakiKbn> hassinsakikbn = new ExDBFieldString<>("hassinsakikbn", this, UserType_C_HassinsakiKbn.class);

    public final ExDBFieldString<JW_HubiDetailWk, String> hubitourokuktntid = new ExDBFieldString<>("hubitourokuktntid", this);

    public final ExDBFieldString<JW_HubiDetailWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JW_HubiDetailWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
