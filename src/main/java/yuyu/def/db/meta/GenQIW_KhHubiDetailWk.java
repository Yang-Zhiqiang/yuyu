package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IW_KhHubiDetailWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全不備詳細ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhHubiDetailWk extends AbstractExDBTable<IW_KhHubiDetailWk> {

    public GenQIW_KhHubiDetailWk() {
        this("IW_KhHubiDetailWk");
    }

    public GenQIW_KhHubiDetailWk(String pAlias) {
        super("IW_KhHubiDetailWk", IW_KhHubiDetailWk.class, pAlias);
    }

    public String IW_KhHubiDetailWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhHubiDetailWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldNumber<IW_KhHubiDetailWk, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IW_KhHubiDetailWk, C_SyoruiCdKbn> hubisyoruicd = new ExDBFieldString<>("hubisyoruicd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IW_KhHubiDetailWk, String> hubisyoruinm = new ExDBFieldString<>("hubisyoruinm", this);

    public final ExDBFieldString<IW_KhHubiDetailWk, String> hubinaiyoucd = new ExDBFieldString<>("hubinaiyoucd", this);

    public final ExDBFieldString<IW_KhHubiDetailWk, String> hubinaiyoumsg = new ExDBFieldString<>("hubinaiyoumsg", this);

    public final ExDBFieldString<IW_KhHubiDetailWk, C_UmuKbn> genponhnkykumu = new ExDBFieldString<>("genponhnkykumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IW_KhHubiDetailWk, C_HassinsakiKbn> hassinsakikbn = new ExDBFieldString<>("hassinsakikbn", this, UserType_C_HassinsakiKbn.class);

    public final ExDBFieldString<IW_KhHubiDetailWk, String> hubitourokuktntid = new ExDBFieldString<>("hubitourokuktntid", this);

    public final ExDBFieldString<IW_KhHubiDetailWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhHubiDetailWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhHubiDetailWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhHubiDetailWk, BizDate> trkymd = new ExDBFieldString<>("trkymd", this, BizDateType.class);
}
