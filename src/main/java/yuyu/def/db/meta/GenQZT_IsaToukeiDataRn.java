package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_IsaToukeiDataRn;

/**
 * 医査統計データテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_IsaToukeiDataRn extends AbstractExDBTable<ZT_IsaToukeiDataRn> {

    public GenQZT_IsaToukeiDataRn() {
        this("ZT_IsaToukeiDataRn");
    }

    public GenQZT_IsaToukeiDataRn(String pAlias) {
        super("ZT_IsaToukeiDataRn", ZT_IsaToukeiDataRn.class, pAlias);
    }

    public String ZT_IsaToukeiDataRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnmosno = new ExDBFieldString<>("zrnmosno", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnhjykktkbn = new ExDBFieldString<>("zrnhjykktkbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnhknsyuruicd = new ExDBFieldString<>("zrnhknsyuruicd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnhrkhuhukbn = new ExDBFieldString<>("zrnhrkhuhukbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnmossyoumetukbn = new ExDBFieldString<>("zrnmossyoumetukbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnmusymd = new ExDBFieldString<>("zrnmusymd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnmosym = new ExDBFieldString<>("zrnmosym", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnhhknnen3 = new ExDBFieldString<>("zrnhhknnen3", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnkyktuuka = new ExDBFieldString<>("zrnkyktuuka", this);

    public final ExDBFieldNumber<ZT_IsaToukeiDataRn, Integer> zrnsibous7 = new ExDBFieldNumber<>("zrnsibous7", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrndakuhikettisyacd = new ExDBFieldString<>("zrndakuhikettisyacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrndkhktiymd = new ExDBFieldString<>("zrndkhktiymd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrndakuhikettikekkacd = new ExDBFieldString<>("zrndakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrndakuhiketteiriyuucdx1 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx1", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrndakuhiketteiriyuucdx2 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx2", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrndakuhiketteiriyuucdx3 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx3", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrndakuhiketteiriyuucdx4 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx4", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsyukykktkekkacd = new ExDBFieldString<>("zrnsyukykktkekkacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsntyo3 = new ExDBFieldString<>("zrnsntyo3", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrntijyuu3 = new ExDBFieldString<>("zrntijyuu3", this);

    public final ExDBFieldNumber<ZT_IsaToukeiDataRn, Integer> zrnbmi = new ExDBFieldNumber<>("zrnbmi", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsinsahouhou = new ExDBFieldString<>("zrnsinsahouhou", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsyoubyoucd1 = new ExDBFieldString<>("zrnsyoubyoucd1", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnkeikanensuux1 = new ExDBFieldString<>("zrnkeikanensuux1", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsyoubyoucd2 = new ExDBFieldString<>("zrnsyoubyoucd2", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnkeikanensuux2 = new ExDBFieldString<>("zrnkeikanensuux2", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsyokaiktisinsahouhou = new ExDBFieldString<>("zrnsyokaiktisinsahouhou", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsyokaiktidkhktikekkacd = new ExDBFieldString<>("zrnsyokaiktidkhktikekkacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsyokaiktsyukykktkekkacd = new ExDBFieldString<>("zrnsyokaiktsyukykktkekkacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnhanbaikeirokbn = new ExDBFieldString<>("zrnhanbaikeirokbn", this);

    public final ExDBFieldNumber<ZT_IsaToukeiDataRn, Integer> zrnjissituhosyous = new ExDBFieldNumber<>("zrnjissituhosyous", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnoyadairitencd = new ExDBFieldString<>("zrnoyadairitencd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnnensyuukbn = new ExDBFieldString<>("zrnnensyuukbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnsyksbyensitihsyutyhkumu = new ExDBFieldString<>("zrnsyksbyensitihsyutyhkumu", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnjyudkaigomehrtkhkumu = new ExDBFieldString<>("zrnjyudkaigomehrtkhkumu", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnijitoukeizennoukbn = new ExDBFieldString<>("zrnijitoukeizennoukbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrndai1hknkkn = new ExDBFieldString<>("zrndai1hknkkn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnijitoukeitikshrtkykkbn = new ExDBFieldString<>("zrnijitoukeitikshrtkykkbn", this);

    public final ExDBFieldNumber<ZT_IsaToukeiDataRn, Integer> zrnteikisiharaikinmanen = new ExDBFieldNumber<>("zrnteikisiharaikinmanen", this);

    public final ExDBFieldString<ZT_IsaToukeiDataRn, String> zrnyobiv45 = new ExDBFieldString<>("zrnyobiv45", this);
}
