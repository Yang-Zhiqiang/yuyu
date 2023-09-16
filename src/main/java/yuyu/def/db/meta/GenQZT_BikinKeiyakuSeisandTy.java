package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_BikinKeiyakuSeisandTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 備金契約精算ＤＦテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_BikinKeiyakuSeisandTy extends AbstractExDBTable<ZT_BikinKeiyakuSeisandTy> {

    public GenQZT_BikinKeiyakuSeisandTy() {
        this("ZT_BikinKeiyakuSeisandTy");
    }

    public GenQZT_BikinKeiyakuSeisandTy(String pAlias) {
        super("ZT_BikinKeiyakuSeisandTy", ZT_BikinKeiyakuSeisandTy.class, pAlias);
    }

    public String ZT_BikinKeiyakuSeisandTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztybikinkbn = new ExDBFieldString<>("ztybikinkbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztybikinnendokbn = new ExDBFieldString<>("ztybikinnendokbn", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandTy, Long> ztyseisand = new ExDBFieldNumber<>("ztyseisand", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandTy, Long> ztytumitaterisoku = new ExDBFieldNumber<>("ztytumitaterisoku", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztysyuruicd1 = new ExDBFieldString<>("ztysyuruicd1", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztysyuruicd3 = new ExDBFieldString<>("ztysyuruicd3", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztysrkijyunym = new ExDBFieldString<>("ztysrkijyunym", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztysyuruicd2 = new ExDBFieldString<>("ztysyuruicd2", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandTy, Long> ztykariwariatedganrikin = new ExDBFieldNumber<>("ztykariwariatedganrikin", this);

    public final ExDBFieldNumber<ZT_BikinKeiyakuSeisandTy, Long> ztykariwariatedrisoku = new ExDBFieldNumber<>("ztykariwariatedrisoku", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, BizNumber> ztydaihyouyoteiriritu = new ExDBFieldString<>("ztydaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_BikinKeiyakuSeisandTy, String> ztyyobiv32 = new ExDBFieldString<>("ztyyobiv32", this);
}
