package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.def.db.entity.BM_PalSyoumetujiyuu;
import yuyu.def.db.type.UserType_C_BetukutiKeiyakuKbn;

/**
 * ＰＡＬ消滅事由マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_PalSyoumetujiyuu extends AbstractExDBTable<BM_PalSyoumetujiyuu> {

    public GenQBM_PalSyoumetujiyuu() {
        this("BM_PalSyoumetujiyuu");
    }

    public GenQBM_PalSyoumetujiyuu(String pAlias) {
        super("BM_PalSyoumetujiyuu", BM_PalSyoumetujiyuu.class, pAlias);
    }

    public String BM_PalSyoumetujiyuu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_PalSyoumetujiyuu, String> palsyoumetucd = new ExDBFieldString<>("palsyoumetucd", this);

    public final ExDBFieldString<BM_PalSyoumetujiyuu, C_BetukutiKeiyakuKbn> betukutikeiyakukbn = new ExDBFieldString<>("betukutikeiyakukbn", this, UserType_C_BetukutiKeiyakuKbn.class);

    public final ExDBFieldString<BM_PalSyoumetujiyuu, String> syoumetujiyuuname = new ExDBFieldString<>("syoumetujiyuuname", this);
}
