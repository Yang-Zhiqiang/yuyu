package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKsnKubunKeiriTy;

/**
 * 新契約決算用区分経理Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKsnKubunKeiriTy extends AbstractExDBTable<ZT_SkKsnKubunKeiriTy> {

    public GenQZT_SkKsnKubunKeiriTy() {
        this("ZT_SkKsnKubunKeiriTy");
    }

    public GenQZT_SkKsnKubunKeiriTy(String pAlias) {
        super("ZT_SkKsnKubunKeiriTy", ZT_SkKsnKubunKeiriTy.class, pAlias);
    }

    public String ZT_SkKsnKubunKeiriTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztykaikeitani = new ExDBFieldString<>("ztykaikeitani", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztysystemkbnnum = new ExDBFieldString<>("ztysystemkbnnum", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztytorihikiymd = new ExDBFieldString<>("ztytorihikiymd", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztytorihikinon7 = new ExDBFieldString<>("ztytorihikinon7", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztynyuuryokubasyo = new ExDBFieldString<>("ztynyuuryokubasyo", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztynyuuryokusyacd = new ExDBFieldString<>("ztynyuuryokusyacd", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztysyoriymdn = new ExDBFieldString<>("ztysyoriymdn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztykessankbn = new ExDBFieldString<>("ztykessankbn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztyonlinesyorikbn = new ExDBFieldString<>("ztyonlinesyorikbn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztyyobiv28 = new ExDBFieldString<>("ztyyobiv28", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztykanjyoukbnn = new ExDBFieldString<>("ztykanjyoukbnn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztytaisyakukbnn = new ExDBFieldString<>("ztytaisyakukbnn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztykanjyoukamokucdn = new ExDBFieldString<>("ztykanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztysuitoubumoncd = new ExDBFieldString<>("ztysuitoubumoncd", this);

    public final ExDBFieldNumber<ZT_SkKsnKubunKeiriTy, Long> ztykingaku = new ExDBFieldNumber<>("ztykingaku", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztykizokusegment = new ExDBFieldString<>("ztykizokusegment", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztyaitesegment = new ExDBFieldString<>("ztyaitesegment", this);

    public final ExDBFieldString<ZT_SkKsnKubunKeiriTy, String> ztyyobiv23 = new ExDBFieldString<>("ztyyobiv23", this);
}
