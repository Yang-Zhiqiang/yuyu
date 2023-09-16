package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKsnKaikeiTorihikiTy;

/**
 * 新契約決算用会計取引Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKsnKaikeiTorihikiTy extends AbstractExDBTable<ZT_SkKsnKaikeiTorihikiTy> {

    public GenQZT_SkKsnKaikeiTorihikiTy() {
        this("ZT_SkKsnKaikeiTorihikiTy");
    }

    public GenQZT_SkKsnKaikeiTorihikiTy(String pAlias) {
        super("ZT_SkKsnKaikeiTorihikiTy", ZT_SkKsnKaikeiTorihikiTy.class, pAlias);
    }

    public String ZT_SkKsnKaikeiTorihikiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztylen = new ExDBFieldString<>("ztylen", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztykaikeitani = new ExDBFieldString<>("ztykaikeitani", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztysystemkbnnum = new ExDBFieldString<>("ztysystemkbnnum", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztytorihikiymd = new ExDBFieldString<>("ztytorihikiymd", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztytorihikinon7 = new ExDBFieldString<>("ztytorihikinon7", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztynyuuryokubasyo = new ExDBFieldString<>("ztynyuuryokubasyo", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztynyuuryokusyacd = new ExDBFieldString<>("ztynyuuryokusyacd", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztysyoriymdn = new ExDBFieldString<>("ztysyoriymdn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztysimekirikbn = new ExDBFieldString<>("ztysimekirikbn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztykessankbn = new ExDBFieldString<>("ztykessankbn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztykaisyakantorihikikbn = new ExDBFieldString<>("ztykaisyakantorihikikbn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztytukekaekbn = new ExDBFieldString<>("ztytukekaekbn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztytablekosuu = new ExDBFieldString<>("ztytablekosuu", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztykanjyoukbnn = new ExDBFieldString<>("ztykanjyoukbnn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztytaisyakukbnn = new ExDBFieldString<>("ztytaisyakukbnn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztykanjyoukamokucdn = new ExDBFieldString<>("ztykanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztysuitoubumon = new ExDBFieldString<>("ztysuitoubumon", this);

    public final ExDBFieldNumber<ZT_SkKsnKaikeiTorihikiTy, Long> ztykingaku = new ExDBFieldNumber<>("ztykingaku", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztytekiyoucd = new ExDBFieldString<>("ztytekiyoucd", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ZT_SkKsnKaikeiTorihikiTy, String> ztymeisaikanryoukbn = new ExDBFieldString<>("ztymeisaikanryoukbn", this);
}
