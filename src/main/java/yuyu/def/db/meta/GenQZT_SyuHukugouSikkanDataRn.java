package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyuHukugouSikkanDataRn extends AbstractExDBTable<ZT_SyuHukugouSikkanDataRn> {

    public GenQZT_SyuHukugouSikkanDataRn() {
        this("ZT_SyuHukugouSikkanDataRn");
    }

    public GenQZT_SyuHukugouSikkanDataRn(String pAlias) {
        super("ZT_SyuHukugouSikkanDataRn", ZT_SyuHukugouSikkanDataRn.class, pAlias);
    }

    public String ZT_SyuHukugouSikkanDataRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnijitoukeidaihyousyurui = new ExDBFieldString<>("zrnijitoukeidaihyousyurui", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnkeiyakunendo = new ExDBFieldString<>("zrnkeiyakunendo", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnhknnendo = new ExDBFieldString<>("zrnhknnendo", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnkykage = new ExDBFieldString<>("zrnkykage", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrntoutatunenrei = new ExDBFieldString<>("zrntoutatunenrei", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnatukaibetu = new ExDBFieldString<>("zrnatukaibetu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnsinsahouhou = new ExDBFieldString<>("zrnsinsahouhou", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnketteikekkakbn = new ExDBFieldString<>("zrnketteikekkakbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnsibousrank = new ExDBFieldString<>("zrnsibousrank", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnjissituhosyousrank = new ExDBFieldString<>("zrnjissituhosyousrank", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnsirajikykkbn = new ExDBFieldString<>("zrnsirajikykkbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnhrkhuhukbn = new ExDBFieldString<>("zrnhrkhuhukbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnhknsyurui2keta = new ExDBFieldString<>("zrnhknsyurui2keta", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrndaisiincd = new ExDBFieldString<>("zrndaisiincd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrntyuusiincd = new ExDBFieldString<>("zrntyuusiincd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnsyousiincd = new ExDBFieldString<>("zrnsyousiincd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnnenreihousikikbn = new ExDBFieldString<>("zrnnenreihousikikbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrntodouhukencd = new ExDBFieldString<>("zrntodouhukencd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnbotaisisyaeigyouhonbu = new ExDBFieldString<>("zrnbotaisisyaeigyouhonbu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnsisyaeigyoubu = new ExDBFieldString<>("zrnsisyaeigyoubu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnnensyuukbn = new ExDBFieldString<>("zrnnensyuukbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnhanbaikeirokbn = new ExDBFieldString<>("zrnhanbaikeirokbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnoyadairitencd = new ExDBFieldString<>("zrnoyadairitencd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrntratkidrtencd = new ExDBFieldString<>("zrntratkidrtencd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnbsudirtnatkikeitaikbn = new ExDBFieldString<>("zrnbsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnkyktuuka = new ExDBFieldString<>("zrnkyktuuka", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnhrktuuka = new ExDBFieldString<>("zrnhrktuuka", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnsyksbyensitihsyutyhkumu = new ExDBFieldString<>("zrnsyksbyensitihsyutyhkumu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnjyudkaigomehrtkhkumu = new ExDBFieldString<>("zrnjyudkaigomehrtkhkumu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnijitoukeizennoukbn = new ExDBFieldString<>("zrnijitoukeizennoukbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrndai1hknkkn = new ExDBFieldString<>("zrndai1hknkkn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnijitoukeitikshrtkykkbn = new ExDBFieldString<>("zrnijitoukeitikshrtkykkbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnyobiv31 = new ExDBFieldString<>("zrnyobiv31", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, BizNumber> zrnijitoukeikeikan = new ExDBFieldString<>("zrnijitoukeikeikan", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SyuHukugouSikkanDataRn, Integer> zrnijitoukeisiboun = new ExDBFieldNumber<>("zrnijitoukeisiboun", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, BizNumber> zrnijitoukeikeikas = new ExDBFieldString<>("zrnijitoukeikeikas", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SyuHukugouSikkanDataRn, Integer> zrnijitoukeisibous = new ExDBFieldNumber<>("zrnijitoukeisibous", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);
}
