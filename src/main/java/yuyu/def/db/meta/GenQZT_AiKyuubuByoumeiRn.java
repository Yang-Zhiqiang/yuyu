package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_AiKyuubuByoumeiRn;

/**
 * あいキューブ病名マスタ送信データテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_AiKyuubuByoumeiRn extends AbstractExDBTable<ZT_AiKyuubuByoumeiRn> {

    public GenQZT_AiKyuubuByoumeiRn() {
        this("ZT_AiKyuubuByoumeiRn");
    }

    public GenQZT_AiKyuubuByoumeiRn(String pAlias) {
        super("ZT_AiKyuubuByoumeiRn", ZT_AiKyuubuByoumeiRn.class, pAlias);
    }

    public String ZT_AiKyuubuByoumeiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrnbyoumeitourokuno = new ExDBFieldString<>("zrnbyoumeitourokuno", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrnbyoumei = new ExDBFieldString<>("zrnbyoumei", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrnbyoumeizenkaku = new ExDBFieldString<>("zrnbyoumeizenkaku", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrnbyoumeihurigana = new ExDBFieldString<>("zrnbyoumeihurigana", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrnbyoumeihuriganakensaku = new ExDBFieldString<>("zrnbyoumeihuriganakensaku", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrnbyoumeicd = new ExDBFieldString<>("zrnbyoumeicd", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrnbyoumeibuicd = new ExDBFieldString<>("zrnbyoumeibuicd", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrngaitoukbn1 = new ExDBFieldString<>("zrngaitoukbn1", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrngaitoukbn2 = new ExDBFieldString<>("zrngaitoukbn2", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrngaitoukbn3 = new ExDBFieldString<>("zrngaitoukbn3", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrngaitoukbn4 = new ExDBFieldString<>("zrngaitoukbn4", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrngaitoukbn5 = new ExDBFieldString<>("zrngaitoukbn5", this);

    public final ExDBFieldString<ZT_AiKyuubuByoumeiRn, String> zrntyuuimongon = new ExDBFieldString<>("zrntyuuimongon", this);
}
