package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KariwariateHtkinMeisaiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 仮割当配当金明細Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KariwariateHtkinMeisaiRn extends AbstractExDBTable<ZT_KariwariateHtkinMeisaiRn> {

    public GenQZT_KariwariateHtkinMeisaiRn() {
        this("ZT_KariwariateHtkinMeisaiRn");
    }

    public GenQZT_KariwariateHtkinMeisaiRn(String pAlias) {
        super("ZT_KariwariateHtkinMeisaiRn", ZT_KariwariateHtkinMeisaiRn.class, pAlias);
    }

    public String ZT_KariwariateHtkinMeisaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiRn, Long> zrnznnndkrkskrwratdruigk = new ExDBFieldNumber<>("zrnznnndkrkskrwratdruigk", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiRn, Long> zrntounendokariwariated = new ExDBFieldNumber<>("zrntounendokariwariated", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiRn, Long> zrntndmatukrkskrwratdruigk = new ExDBFieldNumber<>("zrntndmatukrkskrwratdruigk", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiRn, Long> zrnkariwariatedrisoku = new ExDBFieldNumber<>("zrnkariwariatedrisoku", this);

    public final ExDBFieldNumber<ZT_KariwariateHtkinMeisaiRn, Long> zrnhsys = new ExDBFieldNumber<>("zrnhsys", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnsrutiwake = new ExDBFieldString<>("zrnsrutiwake", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnsrkijyunym = new ExDBFieldString<>("zrnsrkijyunym", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnseisikiwariatenendohyj = new ExDBFieldString<>("zrnseisikiwariatenendohyj", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnmankitouraiym = new ExDBFieldString<>("zrnmankitouraiym", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnsyukeiyakusyuruicdv2 = new ExDBFieldString<>("zrnsyukeiyakusyuruicdv2", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, BizNumber> zrndaihyouyoteiriritu = new ExDBFieldString<>("zrndaihyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnharaikatakbn = new ExDBFieldString<>("zrnharaikatakbn", this);

    public final ExDBFieldString<ZT_KariwariateHtkinMeisaiRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);
}
