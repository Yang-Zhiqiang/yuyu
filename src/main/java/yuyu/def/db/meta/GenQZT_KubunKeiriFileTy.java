package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KubunKeiriFileTy;

/**
 * 区分経理ファイルテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KubunKeiriFileTy extends AbstractExDBTable<ZT_KubunKeiriFileTy> {

    public GenQZT_KubunKeiriFileTy() {
        this("ZT_KubunKeiriFileTy");
    }

    public GenQZT_KubunKeiriFileTy(String pAlias) {
        super("ZT_KubunKeiriFileTy", ZT_KubunKeiriFileTy.class, pAlias);
    }

    public String ZT_KubunKeiriFileTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztykaikeitani = new ExDBFieldString<>("ztykaikeitani", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztysystemkbnnum = new ExDBFieldString<>("ztysystemkbnnum", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztytorihikiymd = new ExDBFieldString<>("ztytorihikiymd", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztytorihikinon7 = new ExDBFieldString<>("ztytorihikinon7", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztynyuuryokubasyo = new ExDBFieldString<>("ztynyuuryokubasyo", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztynyuuryokusyacd = new ExDBFieldString<>("ztynyuuryokusyacd", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztysyoriymdn = new ExDBFieldString<>("ztysyoriymdn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztykessankbn = new ExDBFieldString<>("ztykessankbn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztyonlinesyorikbn = new ExDBFieldString<>("ztyonlinesyorikbn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztyyobiv28 = new ExDBFieldString<>("ztyyobiv28", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztykanjyoukbnn = new ExDBFieldString<>("ztykanjyoukbnn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztytaisyakukbnn = new ExDBFieldString<>("ztytaisyakukbnn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztykanjyoukamokucdn = new ExDBFieldString<>("ztykanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztysuitoubumoncd = new ExDBFieldString<>("ztysuitoubumoncd", this);

    public final ExDBFieldNumber<ZT_KubunKeiriFileTy, Long> ztykingaku = new ExDBFieldNumber<>("ztykingaku", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztykizokusegment = new ExDBFieldString<>("ztykizokusegment", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztyaitesegment = new ExDBFieldString<>("ztyaitesegment", this);

    public final ExDBFieldString<ZT_KubunKeiriFileTy, String> ztyyobiv23 = new ExDBFieldString<>("ztyyobiv23", this);
}
