package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 仮割当配当金明細Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KariwariateHtkinMeisaiTy extends AbstractExDBTable<ZT_KariwariateHtkinMeisaiTy> {

    public GenQZT_KariwariateHtkinMeisaiTy() {
        this("ZT_KariwariateHtkinMeisaiTy");
    }

    public GenQZT_KariwariateHtkinMeisaiTy(String pAlias) {
        super("ZT_KariwariateHtkinMeisaiTy", ZT_KariwariateHtkinMeisaiTy.class, pAlias);
    }

    public String ZT_KariwariateHtkinMeisaiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiTy, Long> ztyznnndkrkskrwratdruigk = new ExDBFieldNumber<>("ztyznnndkrkskrwratdruigk", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiTy, Long> ztytounendokariwariated = new ExDBFieldNumber<>("ztytounendokariwariated", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiTy, Long> ztytndmatukrkskrwratdruigk = new ExDBFieldNumber<>("ztytndmatukrkskrwratdruigk", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiTy, Long> ztykariwariatedrisoku = new ExDBFieldNumber<>("ztykariwariatedrisoku", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiTy, Long> ztyhsys = new ExDBFieldNumber<>("ztyhsys", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztysrutiwake = new ExDBFieldString<>("ztysrutiwake", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztysrkijyunym = new ExDBFieldString<>("ztysrkijyunym", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztyseisikiwariatenendohyj = new ExDBFieldString<>("ztyseisikiwariatenendohyj", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztymankitouraiym = new ExDBFieldString<>("ztymankitouraiym", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, BizNumber> ztydaihyouyoteiriritu = new ExDBFieldString<>("ztydaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);
}
