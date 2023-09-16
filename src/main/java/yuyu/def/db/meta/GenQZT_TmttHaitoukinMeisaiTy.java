package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 積立配当金明細Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TmttHaitoukinMeisaiTy extends AbstractExDBTable<ZT_TmttHaitoukinMeisaiTy> {

    public GenQZT_TmttHaitoukinMeisaiTy() {
        this("ZT_TmttHaitoukinMeisaiTy");
    }

    public GenQZT_TmttHaitoukinMeisaiTy(String pAlias) {
        super("ZT_TmttHaitoukinMeisaiTy", ZT_TmttHaitoukinMeisaiTy.class, pAlias);
    }

    public String ZT_TmttHaitoukinMeisaiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiTy, Long> ztyzennendokurikosid = new ExDBFieldNumber<>("ztyzennendokurikosid", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiTy, Long> ztytounendod = new ExDBFieldNumber<>("ztytounendod", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiTy, Long> ztytounendomatutumitated = new ExDBFieldNumber<>("ztytounendomatutumitated", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiTy, Long> ztytumitaterisoku = new ExDBFieldNumber<>("ztytumitaterisoku", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiTy, Long> ztyhsys = new ExDBFieldNumber<>("ztyhsys", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztysyuruicd1 = new ExDBFieldString<>("ztysyuruicd1", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztysyuruicd3 = new ExDBFieldString<>("ztysyuruicd3", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztysrutiwake = new ExDBFieldString<>("ztysrutiwake", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztysrkijyunym = new ExDBFieldString<>("ztysrkijyunym", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztysyuruicd2 = new ExDBFieldString<>("ztysyuruicd2", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztymankitouraiym = new ExDBFieldString<>("ztymankitouraiym", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztysyukeiyakusyuruicdv2 = new ExDBFieldString<>("ztysyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, BizNumber> ztydaihyouyoteiriritu = new ExDBFieldString<>("ztydaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztyharaikatakbn = new ExDBFieldString<>("ztyharaikatakbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);
}
