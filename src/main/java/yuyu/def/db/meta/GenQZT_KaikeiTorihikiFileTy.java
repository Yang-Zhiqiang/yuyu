package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KaikeiTorihikiFileTy;

/**
 * 会計取引ファイルテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KaikeiTorihikiFileTy extends AbstractExDBTable<ZT_KaikeiTorihikiFileTy> {

    public GenQZT_KaikeiTorihikiFileTy() {
        this("ZT_KaikeiTorihikiFileTy");
    }

    public GenQZT_KaikeiTorihikiFileTy(String pAlias) {
        super("ZT_KaikeiTorihikiFileTy", ZT_KaikeiTorihikiFileTy.class, pAlias);
    }

    public String ZT_KaikeiTorihikiFileTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztylen = new ExDBFieldString<>("ztylen", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztykaikeitani = new ExDBFieldString<>("ztykaikeitani", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztysystemkbnnum = new ExDBFieldString<>("ztysystemkbnnum", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztytorihikiymd = new ExDBFieldString<>("ztytorihikiymd", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztytorihikinon7 = new ExDBFieldString<>("ztytorihikinon7", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztynyuuryokubasyo = new ExDBFieldString<>("ztynyuuryokubasyo", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztynyuuryokusyacd = new ExDBFieldString<>("ztynyuuryokusyacd", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztysyoriymdn = new ExDBFieldString<>("ztysyoriymdn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztysimekirikbn = new ExDBFieldString<>("ztysimekirikbn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztykessankbn = new ExDBFieldString<>("ztykessankbn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztykaisyakantorihikikbn = new ExDBFieldString<>("ztykaisyakantorihikikbn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztytukekaekbn = new ExDBFieldString<>("ztytukekaekbn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztytablekosuu = new ExDBFieldString<>("ztytablekosuu", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztykanjyoukbnn = new ExDBFieldString<>("ztykanjyoukbnn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztytaisyakukbnn = new ExDBFieldString<>("ztytaisyakukbnn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztykanjyoukamokucdn = new ExDBFieldString<>("ztykanjyoukamokucdn", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztysuitoubumon = new ExDBFieldString<>("ztysuitoubumon", this);

    public final ExDBFieldNumber<ZT_KaikeiTorihikiFileTy, Long> ztykingaku = new ExDBFieldNumber<>("ztykingaku", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztytekiyoucd = new ExDBFieldString<>("ztytekiyoucd", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ZT_KaikeiTorihikiFileTy, String> ztymeisaikanryoukbn = new ExDBFieldString<>("ztymeisaikanryoukbn", this);
}
