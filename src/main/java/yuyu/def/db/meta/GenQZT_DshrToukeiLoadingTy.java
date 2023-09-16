package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DshrToukeiLoadingTy;

/**
 * Ｄ支払統計ローディングＦテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DshrToukeiLoadingTy extends AbstractExDBTable<ZT_DshrToukeiLoadingTy> {

    public GenQZT_DshrToukeiLoadingTy() {
        this("ZT_DshrToukeiLoadingTy");
    }

    public GenQZT_DshrToukeiLoadingTy(String pAlias) {
        super("ZT_DshrToukeiLoadingTy", ZT_DshrToukeiLoadingTy.class, pAlias);
    }

    public String ZT_DshrToukeiLoadingTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztydshrym = new ExDBFieldString<>("ztydshrym", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztyannaikigetu = new ExDBFieldString<>("ztyannaikigetu", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztyhknsyruikbn = new ExDBFieldString<>("ztyhknsyruikbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztysegcd = new ExDBFieldString<>("ztysegcd", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztyshrriyuukbn = new ExDBFieldString<>("ztyshrriyuukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztyannaikbn = new ExDBFieldString<>("ztyannaikbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztyduketorihouhoukbn = new ExDBFieldString<>("ztyduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztysyoumetukbn = new ExDBFieldString<>("ztysyoumetukbn", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztybikinhyj = new ExDBFieldString<>("ztybikinhyj", this);

    public final ExDBFieldString<ZT_DshrToukeiLoadingTy, String> ztyskskbn = new ExDBFieldString<>("ztyskskbn", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingTy, Integer> ztysrkensuu = new ExDBFieldNumber<>("ztysrkensuu", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingTy, Long> ztysrhsys = new ExDBFieldNumber<>("ztysrhsys", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingTy, Long> ztytoujigyounendod = new ExDBFieldNumber<>("ztytoujigyounendod", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingTy, Long> ztytoujigyounendohasseidrsk = new ExDBFieldNumber<>("ztytoujigyounendohasseidrsk", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingTy, Long> ztyzenjigyounendomatudzndk = new ExDBFieldNumber<>("ztyzenjigyounendomatudzndk", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingTy, Long> ztyyokujigyounendod = new ExDBFieldNumber<>("ztyyokujigyounendod", this);

    public final ExDBFieldNumber<ZT_DshrToukeiLoadingTy, Long> ztyhushrtoujigyounendod = new ExDBFieldNumber<>("ztyhushrtoujigyounendod", this);
}
