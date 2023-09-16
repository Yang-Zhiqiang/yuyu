package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfTy;

/**
 * 口座振替案内ＵＬＦテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KzhuriAnnaiUlfTy extends AbstractExDBTable<ZT_KzhuriAnnaiUlfTy> {

    public GenQZT_KzhuriAnnaiUlfTy() {
        this("ZT_KzhuriAnnaiUlfTy");
    }

    public GenQZT_KzhuriAnnaiUlfTy(String pAlias) {
        super("ZT_KzhuriAnnaiUlfTy", ZT_KzhuriAnnaiUlfTy.class, pAlias);
    }

    public String ZT_KzhuriAnnaiUlfTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztydantaicd = new ExDBFieldString<>("ztydantaicd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykzhurikaebankcd = new ExDBFieldString<>("ztykzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykzhurikaesitencd = new ExDBFieldString<>("ztykzhurikaesitencd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykzhurikaeyokinkbn = new ExDBFieldString<>("ztykzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykzhurikaekouzano = new ExDBFieldString<>("ztykzhurikaekouzano", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykzhurikaeannaikbn = new ExDBFieldString<>("ztykzhurikaeannaikbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyhurikaeymd = new ExDBFieldString<>("ztyhurikaeymd", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfTy, Long> ztyrsgaku = new ExDBFieldNumber<>("ztyrsgaku", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyjyuutouym = new ExDBFieldString<>("ztyjyuutouym", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyjyuutounensuu = new ExDBFieldString<>("ztyjyuutounensuu", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyjyuutoutukisuu = new ExDBFieldString<>("ztyjyuutoutukisuu", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztydantaikobetukbn = new ExDBFieldString<>("ztydantaikobetukbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztynyknaiyou = new ExDBFieldString<>("ztynyknaiyou", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykzhurikaetkbtannaihyj = new ExDBFieldString<>("ztykzhurikaetkbtannaihyj", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfTy, Long> ztyhrkgk = new ExDBFieldNumber<>("ztyhrkgk", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztytsnsknewyno = new ExDBFieldString<>("ztytsnsknewyno", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztytsnsknewtikucd = new ExDBFieldString<>("ztytsnsknewtikucd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyteikeisyouhinhyj = new ExDBFieldString<>("ztyteikeisyouhinhyj", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykzmeiginmei = new ExDBFieldString<>("ztykzmeiginmei", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfTy, Long> ztykeizokup = new ExDBFieldNumber<>("ztykeizokup", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfTy, Long> ztyiktwaribikikgk = new ExDBFieldNumber<>("ztyiktwaribikikgk", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykeizokupnaiyoukbn = new ExDBFieldString<>("ztykeizokupnaiyoukbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyhisaijiannaitsghyj = new ExDBFieldString<>("ztyhisaijiannaitsghyj", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztydaisyono = new ExDBFieldString<>("ztydaisyono", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztykzhurisyuudaikokbn = new ExDBFieldString<>("ztykzhurisyuudaikokbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfTy, String> ztyyobiv17 = new ExDBFieldString<>("ztyyobiv17", this);
}
