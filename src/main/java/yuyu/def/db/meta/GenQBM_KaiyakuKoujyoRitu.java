package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_KaiyakuKoujyoRitu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 解約控除率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_KaiyakuKoujyoRitu extends AbstractExDBTable<BM_KaiyakuKoujyoRitu> {

    public GenQBM_KaiyakuKoujyoRitu() {
        this("BM_KaiyakuKoujyoRitu");
    }

    public GenQBM_KaiyakuKoujyoRitu(String pAlias) {
        super("BM_KaiyakuKoujyoRitu", BM_KaiyakuKoujyoRitu.class, pAlias);
    }

    public String BM_KaiyakuKoujyoRitu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_KaiyakuKoujyoRitu, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_KaiyakuKoujyoRitu, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<BM_KaiyakuKoujyoRitu, String> kaiyakukjtkybr1 = new ExDBFieldString<>("kaiyakukjtkybr1", this);

    public final ExDBFieldString<BM_KaiyakuKoujyoRitu, String> kaiyakukjtkybr2 = new ExDBFieldString<>("kaiyakukjtkybr2", this);

    public final ExDBFieldNumber<BM_KaiyakuKoujyoRitu, Integer> keikanensuu = new ExDBFieldNumber<>("keikanensuu", this);

    public final ExDBFieldString<BM_KaiyakuKoujyoRitu, BizNumber> kaiyakukoujyoritu = new ExDBFieldString<>("kaiyakukoujyoritu", this, BizNumberType.class);
}
