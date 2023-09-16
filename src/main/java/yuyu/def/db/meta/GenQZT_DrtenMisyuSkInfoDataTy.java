package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_DrtenMisyuSkInfoDataTy;

/**
 * 代理店未収・失効情報連動データＦテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenMisyuSkInfoDataTy extends AbstractExDBTable<ZT_DrtenMisyuSkInfoDataTy> {

    public GenQZT_DrtenMisyuSkInfoDataTy() {
        this("ZT_DrtenMisyuSkInfoDataTy");
    }

    public GenQZT_DrtenMisyuSkInfoDataTy(String pAlias) {
        super("ZT_DrtenMisyuSkInfoDataTy", ZT_DrtenMisyuSkInfoDataTy.class, pAlias);
    }

    public String ZT_DrtenMisyuSkInfoDataTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztybsydrtencd = new ExDBFieldString<>("ztybsydrtencd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyhnsyugknjkyksynm = new ExDBFieldString<>("ztyhnsyugknjkyksynm", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyknjhhknmei = new ExDBFieldString<>("ztyknjhhknmei", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztykykjyutikbn = new ExDBFieldString<>("ztykykjyutikbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztytsinkihontikucd = new ExDBFieldString<>("ztytsinkihontikucd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztykanjitsinkaiadr = new ExDBFieldString<>("ztykanjitsinkaiadr", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztytsintelno = new ExDBFieldString<>("ztytsintelno", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztydai2tsintelno = new ExDBFieldString<>("ztydai2tsintelno", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztykzhurikaebankcd = new ExDBFieldString<>("ztykzhurikaebankcd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztykzhurikaesitencd = new ExDBFieldString<>("ztykzhurikaesitencd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztykzhurikaeyokinkbn = new ExDBFieldString<>("ztykzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztykzhurikaekouzano = new ExDBFieldString<>("ztykzhurikaekouzano", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztykzhurikaemeiginm = new ExDBFieldString<>("ztykzhurikaemeiginm", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyyobiv6x5 = new ExDBFieldString<>("ztyyobiv6x5", this);

    public final ExDBFieldNumber<ZT_DrtenMisyuSkInfoDataTy, Long> zty1kaip = new ExDBFieldNumber<>("zty1kaip", this);

    public final ExDBFieldNumber<ZT_DrtenMisyuSkInfoDataTy, Long> ztynexthurikaeyoteigk = new ExDBFieldNumber<>("ztynexthurikaeyoteigk", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyhrkyykknmnryymd = new ExDBFieldString<>("ztyhrkyykknmnryymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyskymd = new ExDBFieldString<>("ztyskymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyjhurikstkkahikbn = new ExDBFieldString<>("ztyjhurikstkkahikbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyhukkatumoskahikbn = new ExDBFieldString<>("ztyhukkatumoskahikbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyttdkkigenymd = new ExDBFieldString<>("ztyttdkkigenymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyhukkatukanoukknmnryymd = new ExDBFieldString<>("ztyhukkatukanoukknmnryymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztykeikatukisuu3keta = new ExDBFieldString<>("ztykeikatukisuu3keta", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztymisyuuhasseiym = new ExDBFieldString<>("ztymisyuuhasseiym", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztymisyuujiyuu = new ExDBFieldString<>("ztymisyuujiyuu", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyhanteiymd = new ExDBFieldString<>("ztyhanteiymd", this);

    public final ExDBFieldNumber<ZT_DrtenMisyuSkInfoDataTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_DrtenMisyuSkInfoDataTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztynexthurikaeymd = new ExDBFieldString<>("ztynexthurikaeymd", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyyobiv8x3 = new ExDBFieldString<>("ztyyobiv8x3", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyikkatubaraikbn = new ExDBFieldString<>("ztyikkatubaraikbn", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyikkatubaraikaisuu = new ExDBFieldString<>("ztyikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_DrtenMisyuSkInfoDataTy, String> ztyyobiv55 = new ExDBFieldString<>("ztyyobiv55", this);
}
