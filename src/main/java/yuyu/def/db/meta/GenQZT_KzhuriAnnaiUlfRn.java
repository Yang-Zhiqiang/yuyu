package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_KzhuriAnnaiUlfRn;

/**
 * 口座振替案内ＵＬＦテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KzhuriAnnaiUlfRn extends AbstractExDBTable<ZT_KzhuriAnnaiUlfRn> {

    public GenQZT_KzhuriAnnaiUlfRn() {
        this("ZT_KzhuriAnnaiUlfRn");
    }

    public GenQZT_KzhuriAnnaiUlfRn(String pAlias) {
        super("ZT_KzhuriAnnaiUlfRn", ZT_KzhuriAnnaiUlfRn.class, pAlias);
    }

    public String ZT_KzhuriAnnaiUlfRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrndantaicd = new ExDBFieldString<>("zrndantaicd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkzhurikaebankcd = new ExDBFieldString<>("zrnkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkzhurikaesitencd = new ExDBFieldString<>("zrnkzhurikaesitencd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkzhurikaeyokinkbn = new ExDBFieldString<>("zrnkzhurikaeyokinkbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkzhurikaekouzano = new ExDBFieldString<>("zrnkzhurikaekouzano", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkzhurikaeannaikbn = new ExDBFieldString<>("zrnkzhurikaeannaikbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnhurikaeymd = new ExDBFieldString<>("zrnhurikaeymd", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfRn, Long> zrnrsgaku = new ExDBFieldNumber<>("zrnrsgaku", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnjyuutouym = new ExDBFieldString<>("zrnjyuutouym", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnjyuutounensuu = new ExDBFieldString<>("zrnjyuutounensuu", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnjyuutoutukisuu = new ExDBFieldString<>("zrnjyuutoutukisuu", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrndantaikobetukbn = new ExDBFieldString<>("zrndantaikobetukbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnnyknaiyou = new ExDBFieldString<>("zrnnyknaiyou", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkzhurikaetkbtannaihyj = new ExDBFieldString<>("zrnkzhurikaetkbtannaihyj", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfRn, Long> zrnhrkgk = new ExDBFieldNumber<>("zrnhrkgk", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrntsnsknewyno = new ExDBFieldString<>("zrntsnsknewyno", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrntsnsknewtikucd = new ExDBFieldString<>("zrntsnsknewtikucd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnteikeisyouhinhyj = new ExDBFieldString<>("zrnteikeisyouhinhyj", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkzmeiginmei = new ExDBFieldString<>("zrnkzmeiginmei", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfRn, Long> zrnkeizokup = new ExDBFieldNumber<>("zrnkeizokup", this);

    public final ExDBFieldNumber<ZT_KzhuriAnnaiUlfRn, Long> zrniktwaribikikgk = new ExDBFieldNumber<>("zrniktwaribikikgk", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkeizokupnaiyoukbn = new ExDBFieldString<>("zrnkeizokupnaiyoukbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnhisaijiannaitsghyj = new ExDBFieldString<>("zrnhisaijiannaitsghyj", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrndaisyono = new ExDBFieldString<>("zrndaisyono", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnkzhurisyuudaikokbn = new ExDBFieldString<>("zrnkzhurisyuudaikokbn", this);

    public final ExDBFieldString<ZT_KzhuriAnnaiUlfRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);
}
