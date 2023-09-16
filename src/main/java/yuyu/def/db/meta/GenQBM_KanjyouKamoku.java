package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KanjyoukmkgroupKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 勘定科目マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_KanjyouKamoku extends AbstractExDBTable<BM_KanjyouKamoku> {

    public GenQBM_KanjyouKamoku() {
        this("BM_KanjyouKamoku");
    }

    public GenQBM_KanjyouKamoku(String pAlias) {
        super("BM_KanjyouKamoku", BM_KanjyouKamoku.class, pAlias);
    }

    public String BM_KanjyouKamoku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_KanjyouKamoku, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<BM_KanjyouKamoku, String> denkanjokamokucd = new ExDBFieldString<>("denkanjokamokucd", this);

    public final ExDBFieldString<BM_KanjyouKamoku, String> kanjyoukmknm = new ExDBFieldString<>("kanjyoukmknm", this);

    public final ExDBFieldString<BM_KanjyouKamoku, String> jigyouhiutiwakecd = new ExDBFieldString<>("jigyouhiutiwakecd", this);

    public final ExDBFieldString<BM_KanjyouKamoku, String> jigyouhiutiwakenm = new ExDBFieldString<>("jigyouhiutiwakenm", this);

    public final ExDBFieldString<BM_KanjyouKamoku, C_YouhiKbn> hjybyouhyj = new ExDBFieldString<>("hjybyouhyj", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<BM_KanjyouKamoku, String> hjybtantositucd = new ExDBFieldString<>("hjybtantositucd", this);

    public final ExDBFieldString<BM_KanjyouKamoku, C_UmuKbn> hjybruigkteiseiumukbn = new ExDBFieldString<>("hjybruigkteiseiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_KanjyouKamoku, C_KanjyoukmkgroupKbn> kanjyoukmkgroupkbn = new ExDBFieldString<>("kanjyoukmkgroupkbn", this, UserType_C_KanjyoukmkgroupKbn.class);

    public final ExDBFieldString<BM_KanjyouKamoku, C_YouhiKbn> kbnkeiriyouhi = new ExDBFieldString<>("kbnkeiriyouhi", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<BM_KanjyouKamoku, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_KanjyouKamoku, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
