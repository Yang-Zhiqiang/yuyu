package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SyuSibouToukeiRn;

/**
 * 主契約死亡統計データテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyuSibouToukeiRn extends AbstractExDBTable<ZT_SyuSibouToukeiRn> {

    public GenQZT_SyuSibouToukeiRn() {
        this("ZT_SyuSibouToukeiRn");
    }

    public GenQZT_SyuSibouToukeiRn(String pAlias) {
        super("ZT_SyuSibouToukeiRn", ZT_SyuSibouToukeiRn.class, pAlias);
    }

    public String ZT_SyuSibouToukeiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnhknsyurui2keta = new ExDBFieldString<>("zrnhknsyurui2keta", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnatukaibetu = new ExDBFieldString<>("zrnatukaibetu", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnhhknnen3 = new ExDBFieldString<>("zrnhhknnen3", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrntoutatunenrei = new ExDBFieldString<>("zrntoutatunenrei", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnkykym = new ExDBFieldString<>("zrnkykym", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsymtym = new ExDBFieldString<>("zrnsymtym", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsyoriymd = new ExDBFieldString<>("zrnsyoriymd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnkyktuuka = new ExDBFieldString<>("zrnkyktuuka", this);

    public final ExDBFieldNumber<ZT_SyuSibouToukeiRn, Integer> zrnimustiyusbus = new ExDBFieldNumber<>("zrnimustiyusbus", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnhrkhuhukbn = new ExDBFieldString<>("zrnhrkhuhukbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsirajikykkbn = new ExDBFieldString<>("zrnsirajikykkbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsinsahouhou = new ExDBFieldString<>("zrnsinsahouhou", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsinsasyacd = new ExDBFieldString<>("zrnsinsasyacd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnketteikekkakbn = new ExDBFieldString<>("zrnketteikekkakbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrndakuhikettisyacd = new ExDBFieldString<>("zrndakuhikettisyacd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsyoubyoutyuubunrui = new ExDBFieldString<>("zrnsyoubyoutyuubunrui", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsyoubyoucd1x5 = new ExDBFieldString<>("zrnsyoubyoucd1x5", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsyoubyoucd2x5 = new ExDBFieldString<>("zrnsyoubyoucd2x5", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrndaisiincd = new ExDBFieldString<>("zrndaisiincd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrntyuusiincd = new ExDBFieldString<>("zrntyuusiincd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsyousiincd = new ExDBFieldString<>("zrnsyousiincd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsoukisibouhyj = new ExDBFieldString<>("zrnsoukisibouhyj", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnkeikakikankbn = new ExDBFieldString<>("zrnkeikakikankbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnkoudosyougaiarihyj = new ExDBFieldString<>("zrnkoudosyougaiarihyj", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnkaijyokbn = new ExDBFieldString<>("zrnkaijyokbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnnensyuukbn = new ExDBFieldString<>("zrnnensyuukbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnhanbaikeirokbn = new ExDBFieldString<>("zrnhanbaikeirokbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnoyadairitencd = new ExDBFieldString<>("zrnoyadairitencd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnbyoumeicd = new ExDBFieldString<>("zrnbyoumeicd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnsyksbyensitihsyutyhkumu = new ExDBFieldString<>("zrnsyksbyensitihsyutyhkumu", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnjyudkaigomehrtkhkumu = new ExDBFieldString<>("zrnjyudkaigomehrtkhkumu", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnijitoukeizennoukbn = new ExDBFieldString<>("zrnijitoukeizennoukbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrndai1hknkkn = new ExDBFieldString<>("zrndai1hknkkn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnijitoukeitikshrtkykkbn = new ExDBFieldString<>("zrnijitoukeitikshrtkykkbn", this);

    public final ExDBFieldNumber<ZT_SyuSibouToukeiRn, Integer> zrnteikisiharaikinmanen = new ExDBFieldNumber<>("zrnteikisiharaikinmanen", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiRn, String> zrnyobiv78 = new ExDBFieldString<>("zrnyobiv78", this);
}
