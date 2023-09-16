package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HM_SkHubiKoumoku;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 新契約不備項目マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SkHubiKoumoku extends AbstractExDBTable<HM_SkHubiKoumoku> {

    public GenQHM_SkHubiKoumoku() {
        this("HM_SkHubiKoumoku");
    }

    public GenQHM_SkHubiKoumoku(String pAlias) {
        super("HM_SkHubiKoumoku", HM_SkHubiKoumoku.class, pAlias);
    }

    public String HM_SkHubiKoumoku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SkHubiKoumoku, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<HM_SkHubiKoumoku, String> skhubikoumokucd = new ExDBFieldString<>("skhubikoumokucd", this);

    public final ExDBFieldString<HM_SkHubiKoumoku, String> skhubikoumoku = new ExDBFieldString<>("skhubikoumoku", this);

    public final ExDBFieldNumber<HM_SkHubiKoumoku, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldString<HM_SkHubiKoumoku, C_KahiKbn> hyoujikahikbn = new ExDBFieldString<>("hyoujikahikbn", this, UserType_C_KahiKbn.class);
}
