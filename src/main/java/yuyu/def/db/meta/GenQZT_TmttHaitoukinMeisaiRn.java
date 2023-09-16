package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_TmttHaitoukinMeisaiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 積立配当金明細Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TmttHaitoukinMeisaiRn extends AbstractExDBTable<ZT_TmttHaitoukinMeisaiRn> {

    public GenQZT_TmttHaitoukinMeisaiRn() {
        this("ZT_TmttHaitoukinMeisaiRn");
    }

    public GenQZT_TmttHaitoukinMeisaiRn(String pAlias) {
        super("ZT_TmttHaitoukinMeisaiRn", ZT_TmttHaitoukinMeisaiRn.class, pAlias);
    }

    public String ZT_TmttHaitoukinMeisaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiRn, Long> zrnzennendokurikosid = new ExDBFieldNumber<>("zrnzennendokurikosid", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiRn, Long> zrntounendod = new ExDBFieldNumber<>("zrntounendod", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiRn, Long> zrntounendomatutumitated = new ExDBFieldNumber<>("zrntounendomatutumitated", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiRn, Long> zrntumitaterisoku = new ExDBFieldNumber<>("zrntumitaterisoku", this);

    public final ExDBFieldNumber<ZT_TmttHaitoukinMeisaiRn, Long> zrnhsys = new ExDBFieldNumber<>("zrnhsys", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnsyuruicd1 = new ExDBFieldString<>("zrnsyuruicd1", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnsyuruicd3 = new ExDBFieldString<>("zrnsyuruicd3", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnsrutiwake = new ExDBFieldString<>("zrnsrutiwake", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnsrkijyunym = new ExDBFieldString<>("zrnsrkijyunym", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnsyuruicd2 = new ExDBFieldString<>("zrnsyuruicd2", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnmankitouraiym = new ExDBFieldString<>("zrnmankitouraiym", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, BizNumber> zrndaihyouyoteiriritu = new ExDBFieldString<>("zrndaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_TmttHaitoukinMeisaiRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);
}
