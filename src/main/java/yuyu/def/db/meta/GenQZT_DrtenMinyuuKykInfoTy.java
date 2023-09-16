package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DrtenMinyuuKykInfoTy;

/**
 * 代理店未入契約情報Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenMinyuuKykInfoTy extends AbstractExDBTable<ZT_DrtenMinyuuKykInfoTy> {

    public GenQZT_DrtenMinyuuKykInfoTy() {
        this("ZT_DrtenMinyuuKykInfoTy");
    }

    public GenQZT_DrtenMinyuuKykInfoTy(String pAlias) {
        super("ZT_DrtenMinyuuKykInfoTy", ZT_DrtenMinyuuKykInfoTy.class, pAlias);
    }

    public String ZT_DrtenMinyuuKykInfoTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztysyuukeikbn = new ExDBFieldString<>("ztysyuukeikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyminyukaisuu = new ExDBFieldString<>("ztyminyukaisuu", this);

    public final ExDBFieldNumber<ZT_DrtenMinyuuKykInfoTy, Long> ztymisyuup = new ExDBFieldNumber<>("ztymisyuup", this);

    public final ExDBFieldNumber<ZT_DrtenMinyuuKykInfoTy, Long> ztyhsys = new ExDBFieldNumber<>("ztyhsys", this);

    public final ExDBFieldNumber<ZT_DrtenMinyuuKykInfoTy, Long> ztysyuuseis = new ExDBFieldNumber<>("ztysyuuseis", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyfukkatutyuuikbn = new ExDBFieldString<>("ztyfukkatutyuuikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztymrarihyj = new ExDBFieldString<>("ztymrarihyj", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyfsttatekaekykhyj = new ExDBFieldString<>("ztyfsttatekaekykhyj", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztytatekaekjrenzokukaisu = new ExDBFieldString<>("ztytatekaekjrenzokukaisu", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztykeizokutyuuihyouji = new ExDBFieldString<>("ztykeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztysyouhinbunruikbn = new ExDBFieldString<>("ztysyouhinbunruikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztysyouhnnmkbn = new ExDBFieldString<>("ztysyouhnnmkbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyjikaipjyuutouym = new ExDBFieldString<>("ztyjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztykzhurikaehurihunokbn = new ExDBFieldString<>("ztykzhurikaehurihunokbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyautocalltaisyoukykhyj = new ExDBFieldString<>("ztyautocalltaisyoukykhyj", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztybsudirtnatkikeitaikbn = new ExDBFieldString<>("ztybsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztybsydrtencdx1 = new ExDBFieldString<>("ztybsydrtencdx1", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztybsydrtencdx2 = new ExDBFieldString<>("ztybsydrtencdx2", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyikkatubaraikbn = new ExDBFieldString<>("ztyikkatubaraikbn", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyikkatubaraikaisuu = new ExDBFieldString<>("ztyikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_DrtenMinyuuKykInfoTy, String> ztyyobiv34 = new ExDBFieldString<>("ztyyobiv34", this);
}
