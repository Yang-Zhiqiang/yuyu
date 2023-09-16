package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_IsaToukeiDataTy;

/**
 * 医査統計データテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_IsaToukeiDataTy extends AbstractExDBTable<ZT_IsaToukeiDataTy> {

    public GenQZT_IsaToukeiDataTy() {
        this("ZT_IsaToukeiDataTy");
    }

    public GenQZT_IsaToukeiDataTy(String pAlias) {
        super("ZT_IsaToukeiDataTy", ZT_IsaToukeiDataTy.class, pAlias);
    }

    public String ZT_IsaToukeiDataTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztymosno = new ExDBFieldString<>("ztymosno", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyhjykktkbn = new ExDBFieldString<>("ztyhjykktkbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyhknsyuruicd = new ExDBFieldString<>("ztyhknsyuruicd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyhrkhuhukbn = new ExDBFieldString<>("ztyhrkhuhukbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztymossyoumetukbn = new ExDBFieldString<>("ztymossyoumetukbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztymusymd = new ExDBFieldString<>("ztymusymd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztymosym = new ExDBFieldString<>("ztymosym", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyhhknnen3 = new ExDBFieldString<>("ztyhhknnen3", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztykyktuuka = new ExDBFieldString<>("ztykyktuuka", this);

    public final ExDBFieldNumber<ZT_IsaToukeiDataTy, Integer> ztysibous7 = new ExDBFieldNumber<>("ztysibous7", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztydakuhikettisyacd = new ExDBFieldString<>("ztydakuhikettisyacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztydkhktiymd = new ExDBFieldString<>("ztydkhktiymd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztydakuhikettikekkacd = new ExDBFieldString<>("ztydakuhikettikekkacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztydakuhiketteiriyuucdx1 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx1", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztydakuhiketteiriyuucdx2 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx2", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztydakuhiketteiriyuucdx3 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx3", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztydakuhiketteiriyuucdx4 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx4", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysyukykktkekkacd = new ExDBFieldString<>("ztysyukykktkekkacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysntyo3 = new ExDBFieldString<>("ztysntyo3", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztytijyuu3 = new ExDBFieldString<>("ztytijyuu3", this);

    public final ExDBFieldNumber<ZT_IsaToukeiDataTy, Integer> ztybmi = new ExDBFieldNumber<>("ztybmi", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysinsahouhou = new ExDBFieldString<>("ztysinsahouhou", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysyoubyoucd1 = new ExDBFieldString<>("ztysyoubyoucd1", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztykeikanensuux1 = new ExDBFieldString<>("ztykeikanensuux1", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysyoubyoucd2 = new ExDBFieldString<>("ztysyoubyoucd2", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztykeikanensuux2 = new ExDBFieldString<>("ztykeikanensuux2", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysyokaiktisinsahouhou = new ExDBFieldString<>("ztysyokaiktisinsahouhou", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysyokaiktidkhktikekkacd = new ExDBFieldString<>("ztysyokaiktidkhktikekkacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysyokaiktsyukykktkekkacd = new ExDBFieldString<>("ztysyokaiktsyukykktkekkacd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyhanbaikeirokbn = new ExDBFieldString<>("ztyhanbaikeirokbn", this);

    public final ExDBFieldNumber<ZT_IsaToukeiDataTy, Integer> ztyjissituhosyous = new ExDBFieldNumber<>("ztyjissituhosyous", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyoyadairitencd = new ExDBFieldString<>("ztyoyadairitencd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztynensyuukbn = new ExDBFieldString<>("ztynensyuukbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztysyksbyensitihsyutyhkumu = new ExDBFieldString<>("ztysyksbyensitihsyutyhkumu", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyjyudkaigomehrtkhkumu = new ExDBFieldString<>("ztyjyudkaigomehrtkhkumu", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyijitoukeizennoukbn = new ExDBFieldString<>("ztyijitoukeizennoukbn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztydai1hknkkn = new ExDBFieldString<>("ztydai1hknkkn", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyijitoukeitikshrtkykkbn = new ExDBFieldString<>("ztyijitoukeitikshrtkykkbn", this);

    public final ExDBFieldNumber<ZT_IsaToukeiDataTy, Integer> ztyteikisiharaikinmanen = new ExDBFieldNumber<>("ztyteikisiharaikinmanen", this);

    public final ExDBFieldString<ZT_IsaToukeiDataTy, String> ztyyobiv45 = new ExDBFieldString<>("ztyyobiv45", this);
}
