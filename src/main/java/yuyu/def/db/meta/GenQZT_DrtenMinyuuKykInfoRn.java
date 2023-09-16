package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoRn;

/**
 * 代理店未入契約情報Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenMinyuuKykInfoRn extends AbstractExDBTable<ZT_DrtenMinyuuKykInfoRn> {

    public GenQZT_DrtenMinyuuKykInfoRn() {
        this("ZT_DrtenMinyuuKykInfoRn");
    }

    public GenQZT_DrtenMinyuuKykInfoRn(String pAlias) {
        super("ZT_DrtenMinyuuKykInfoRn", ZT_DrtenMinyuuKykInfoRn.class, pAlias);
    }

    public String ZT_DrtenMinyuuKykInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnsyuukeikbn = new ExDBFieldString<>("zrnsyuukeikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnminyukaisuu = new ExDBFieldString<>("zrnminyukaisuu", this);

    public final ExDBFieldNumber<ZT_DrtenMinyuuKykInfoRn, Long> zrnmisyuup = new ExDBFieldNumber<>("zrnmisyuup", this);

    public final ExDBFieldNumber<ZT_DrtenMinyuuKykInfoRn, Long> zrnhsys = new ExDBFieldNumber<>("zrnhsys", this);

    public final ExDBFieldNumber<ZT_DrtenMinyuuKykInfoRn, Long> zrnsyuuseis = new ExDBFieldNumber<>("zrnsyuuseis", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnfukkatutyuuikbn = new ExDBFieldString<>("zrnfukkatutyuuikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnmrarihyj = new ExDBFieldString<>("zrnmrarihyj", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnfsttatekaekykhyj = new ExDBFieldString<>("zrnfsttatekaekykhyj", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrntatekaekjrenzokukaisu = new ExDBFieldString<>("zrntatekaekjrenzokukaisu", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnkeizokutyuuihyouji = new ExDBFieldString<>("zrnkeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnsyouhinbunruikbn = new ExDBFieldString<>("zrnsyouhinbunruikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnsyouhnnmkbn = new ExDBFieldString<>("zrnsyouhnnmkbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnjikaipjyuutouym = new ExDBFieldString<>("zrnjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnkzhurikaehurihunokbn = new ExDBFieldString<>("zrnkzhurikaehurihunokbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnautocalltaisyoukykhyj = new ExDBFieldString<>("zrnautocalltaisyoukykhyj", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnbsudirtnatkikeitaikbn = new ExDBFieldString<>("zrnbsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnbsydrtencdx1 = new ExDBFieldString<>("zrnbsydrtencdx1", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnbsydrtencdx2 = new ExDBFieldString<>("zrnbsydrtencdx2", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnikkatubaraikbn = new ExDBFieldString<>("zrnikkatubaraikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnikkatubaraikaisuu = new ExDBFieldString<>("zrnikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoRn, String> zrnyobiv34 = new ExDBFieldString<>("zrnyobiv34", this);
}
