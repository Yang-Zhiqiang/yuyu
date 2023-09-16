package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IW_KhHubiKaisyouDetailWk;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全不備解消詳細ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhHubiKaisyouDetailWk extends AbstractExDBTable<IW_KhHubiKaisyouDetailWk> {

    public GenQIW_KhHubiKaisyouDetailWk() {
        this("IW_KhHubiKaisyouDetailWk");
    }

    public GenQIW_KhHubiKaisyouDetailWk(String pAlias) {
        super("IW_KhHubiKaisyouDetailWk", IW_KhHubiKaisyouDetailWk.class, pAlias);
    }

    public String IW_KhHubiKaisyouDetailWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhHubiKaisyouDetailWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldNumber<IW_KhHubiKaisyouDetailWk, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IW_KhHubiKaisyouDetailWk, C_UmuKbn> hubikaisyouumukbn = new ExDBFieldString<>("hubikaisyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IW_KhHubiKaisyouDetailWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhHubiKaisyouDetailWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhHubiKaisyouDetailWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
