package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKaikeiTorihikiFileTy;

/**
 * 新契約会計取引ファイルテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKaikeiTorihikiFileTy extends AbstractExDBTable<ZT_SkKaikeiTorihikiFileTy> {

    public GenQZT_SkKaikeiTorihikiFileTy() {
        this("ZT_SkKaikeiTorihikiFileTy");
    }

    public GenQZT_SkKaikeiTorihikiFileTy(String pAlias) {
        super("ZT_SkKaikeiTorihikiFileTy", ZT_SkKaikeiTorihikiFileTy.class, pAlias);
    }

    public String ZT_SkKaikeiTorihikiFileTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztylen = new ExDBFieldString<>("ztylen", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztykaikeitani = new ExDBFieldString<>("ztykaikeitani", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztysystemkbnnum = new ExDBFieldString<>("ztysystemkbnnum", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztytorihikiymd = new ExDBFieldString<>("ztytorihikiymd", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztytorihikinon7 = new ExDBFieldString<>("ztytorihikinon7", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztynyuuryokubasyo = new ExDBFieldString<>("ztynyuuryokubasyo", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztynyuuryokusyacd = new ExDBFieldString<>("ztynyuuryokusyacd", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztysyoriymdn = new ExDBFieldString<>("ztysyoriymdn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztysimekirikbn = new ExDBFieldString<>("ztysimekirikbn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztykessankbn = new ExDBFieldString<>("ztykessankbn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztykaisyakantorihikikbn = new ExDBFieldString<>("ztykaisyakantorihikikbn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztytukekaekbn = new ExDBFieldString<>("ztytukekaekbn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztytablekosuu = new ExDBFieldString<>("ztytablekosuu", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztykanjyoukbnn = new ExDBFieldString<>("ztykanjyoukbnn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztytaisyakukbnn = new ExDBFieldString<>("ztytaisyakukbnn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztykanjyoukamokucdn = new ExDBFieldString<>("ztykanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztysuitoubumon = new ExDBFieldString<>("ztysuitoubumon", this);

    public final ExDBFieldNumber<ZT_SkKaikeiTorihikiFileTy, Long> ztykingaku = new ExDBFieldNumber<>("ztykingaku", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztytekiyoucd = new ExDBFieldString<>("ztytekiyoucd", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ZT_SkKaikeiTorihikiFileTy, String> ztymeisaikanryoukbn = new ExDBFieldString<>("ztymeisaikanryoukbn", this);
}
