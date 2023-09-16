package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JW_HubiKaisyouDetailWk;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 支払不備解消詳細ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJW_HubiKaisyouDetailWk extends AbstractExDBTable<JW_HubiKaisyouDetailWk> {

    public GenQJW_HubiKaisyouDetailWk() {
        this("JW_HubiKaisyouDetailWk");
    }

    public GenQJW_HubiKaisyouDetailWk(String pAlias) {
        super("JW_HubiKaisyouDetailWk", JW_HubiKaisyouDetailWk.class, pAlias);
    }

    public String JW_HubiKaisyouDetailWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JW_HubiKaisyouDetailWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldNumber<JW_HubiKaisyouDetailWk, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<JW_HubiKaisyouDetailWk, C_UmuKbn> hubikaisyouumukbn = new ExDBFieldString<>("hubikaisyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JW_HubiKaisyouDetailWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JW_HubiKaisyouDetailWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
