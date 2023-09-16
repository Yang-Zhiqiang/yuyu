package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SkKubunKeiriFileTy;

/**
 * 新契約区分経理ファイルテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SkKubunKeiriFileTy extends AbstractExDBTable<ZT_SkKubunKeiriFileTy> {

    public GenQZT_SkKubunKeiriFileTy() {
        this("ZT_SkKubunKeiriFileTy");
    }

    public GenQZT_SkKubunKeiriFileTy(String pAlias) {
        super("ZT_SkKubunKeiriFileTy", ZT_SkKubunKeiriFileTy.class, pAlias);
    }

    public String ZT_SkKubunKeiriFileTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztykaikeitani = new ExDBFieldString<>("ztykaikeitani", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztysystemkbnnum = new ExDBFieldString<>("ztysystemkbnnum", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztytorihikiymd = new ExDBFieldString<>("ztytorihikiymd", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztytorihikinon7 = new ExDBFieldString<>("ztytorihikinon7", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztynyuuryokubasyo = new ExDBFieldString<>("ztynyuuryokubasyo", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztynyuuryokusyacd = new ExDBFieldString<>("ztynyuuryokusyacd", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztysyoriymdn = new ExDBFieldString<>("ztysyoriymdn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztykessankbn = new ExDBFieldString<>("ztykessankbn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztyonlinesyorikbn = new ExDBFieldString<>("ztyonlinesyorikbn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztyyobiv28 = new ExDBFieldString<>("ztyyobiv28", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztykanjyoukbnn = new ExDBFieldString<>("ztykanjyoukbnn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztytaisyakukbnn = new ExDBFieldString<>("ztytaisyakukbnn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztykanjyoukamokucdn = new ExDBFieldString<>("ztykanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztysuitoubumoncd = new ExDBFieldString<>("ztysuitoubumoncd", this);

    public final ExDBFieldNumber<ZT_SkKubunKeiriFileTy, Long> ztykingaku = new ExDBFieldNumber<>("ztykingaku", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztykizokusegment = new ExDBFieldString<>("ztykizokusegment", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztyaitesegment = new ExDBFieldString<>("ztyaitesegment", this);

    public final ExDBFieldString<ZT_SkKubunKeiriFileTy, String> ztyyobiv23 = new ExDBFieldString<>("ztyyobiv23", this);
}
