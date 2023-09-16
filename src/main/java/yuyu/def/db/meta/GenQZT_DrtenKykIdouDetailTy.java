package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailTy;

/**
 * 代理店契約異動明細テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenKykIdouDetailTy extends AbstractExDBTable<ZT_DrtenKykIdouDetailTy> {

    public GenQZT_DrtenKykIdouDetailTy() {
        this("ZT_DrtenKykIdouDetailTy");
    }

    public GenQZT_DrtenKykIdouDetailTy(String pAlias) {
        super("ZT_DrtenKykIdouDetailTy", ZT_DrtenKykIdouDetailTy.class, pAlias);
    }

    public String ZT_DrtenKykIdouDetailTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykinyuukikancd = new ExDBFieldString<>("ztykinyuukikancd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykinyuukikansitencd = new ExDBFieldString<>("ztykinyuukikansitencd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztybosyuunincd = new ExDBFieldString<>("ztybosyuunincd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyidouhasseiymd = new ExDBFieldString<>("ztyidouhasseiymd", this);

    public final ExDBFieldNumber<ZT_DrtenKykIdouDetailTy, Long> ztykykmfksnctrlkh = new ExDBFieldNumber<>("ztykykmfksnctrlkh", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyidoukbn = new ExDBFieldString<>("ztyidoukbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykydatkikbn = new ExDBFieldString<>("ztykydatkikbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyjikaipjyuutouym = new ExDBFieldString<>("ztyjikaipjyuutouym", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztydntcd = new ExDBFieldString<>("ztydntcd", this);

    public final ExDBFieldNumber<ZT_DrtenKykIdouDetailTy, Long> ztyharaikomip = new ExDBFieldNumber<>("ztyharaikomip", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykjsyagaihknnm = new ExDBFieldString<>("ztykjsyagaihknnm", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztytelno = new ExDBFieldString<>("ztytelno", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyhensyuubosyuudrtennm = new ExDBFieldString<>("ztyhensyuubosyuudrtennm", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykyknmkjdirtnkykido = new ExDBFieldString<>("ztykyknmkjdirtnkykido", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykjdntnm = new ExDBFieldString<>("ztykjdntnm", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykzhurikaebankcd = new ExDBFieldString<>("ztykzhurikaebankcd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykzhurikaesitencd = new ExDBFieldString<>("ztykzhurikaesitencd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykzhurikaeyokinkbn = new ExDBFieldString<>("ztykzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztykzhurikaekouzano = new ExDBFieldString<>("ztykzhurikaekouzano", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyoyabosyuudairitencd = new ExDBFieldString<>("ztyoyabosyuudairitencd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztybsydrtenkanrisosikicd = new ExDBFieldString<>("ztybsydrtenkanrisosikicd", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztybosyuudairitengyousyukbn = new ExDBFieldString<>("ztybosyuudairitengyousyukbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztybosyuudrtennmkj = new ExDBFieldString<>("ztybosyuudrtennmkj", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztydoujitusyoricount = new ExDBFieldString<>("ztydoujitusyoricount", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyhjnnmkj = new ExDBFieldString<>("ztyhjnnmkj", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztysyuhrkkaisuukbn = new ExDBFieldString<>("ztysyuhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyikkatubaraikbn = new ExDBFieldString<>("ztyikkatubaraikbn", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyikkatubaraikaisuu = new ExDBFieldString<>("ztyikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_DrtenKykIdouDetailTy, String> ztyyobiv103 = new ExDBFieldString<>("ztyyobiv103", this);
}
