package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BM_WariateHukaInfoKanri;

/**
 * 割当不可情報管理マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_WariateHukaInfoKanri extends AbstractExDBTable<BM_WariateHukaInfoKanri> {

    public GenQBM_WariateHukaInfoKanri() {
        this("BM_WariateHukaInfoKanri");
    }

    public GenQBM_WariateHukaInfoKanri(String pAlias) {
        super("BM_WariateHukaInfoKanri", BM_WariateHukaInfoKanri.class, pAlias);
    }

    public String BM_WariateHukaInfoKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_WariateHukaInfoKanri, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<BM_WariateHukaInfoKanri, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<BM_WariateHukaInfoKanri, String> currenttskid = new ExDBFieldString<>("currenttskid", this);

    public final ExDBFieldNumber<BM_WariateHukaInfoKanri, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<BM_WariateHukaInfoKanri, String> nexttskid = new ExDBFieldString<>("nexttskid", this);

    public final ExDBFieldString<BM_WariateHukaInfoKanri, String> wrthukatskid = new ExDBFieldString<>("wrthukatskid", this);

    public final ExDBFieldString<BM_WariateHukaInfoKanri, String> wrthukakaijyotskid = new ExDBFieldString<>("wrthukakaijyotskid", this);
}
