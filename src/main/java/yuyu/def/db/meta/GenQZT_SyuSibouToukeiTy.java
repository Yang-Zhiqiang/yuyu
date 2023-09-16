package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SyuSibouToukeiTy;

/**
 * 主契約死亡統計データテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyuSibouToukeiTy extends AbstractExDBTable<ZT_SyuSibouToukeiTy> {

    public GenQZT_SyuSibouToukeiTy() {
        this("ZT_SyuSibouToukeiTy");
    }

    public GenQZT_SyuSibouToukeiTy(String pAlias) {
        super("ZT_SyuSibouToukeiTy", ZT_SyuSibouToukeiTy.class, pAlias);
    }

    public String ZT_SyuSibouToukeiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyhknsyurui2keta = new ExDBFieldString<>("ztyhknsyurui2keta", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyatukaibetu = new ExDBFieldString<>("ztyatukaibetu", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyhhknnen3 = new ExDBFieldString<>("ztyhhknnen3", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztytoutatunenrei = new ExDBFieldString<>("ztytoutatunenrei", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztykykym = new ExDBFieldString<>("ztykykym", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysymtym = new ExDBFieldString<>("ztysymtym", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysyoriymd = new ExDBFieldString<>("ztysyoriymd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztykyktuuka = new ExDBFieldString<>("ztykyktuuka", this);

    public final ExDBFieldNumber<ZT_SyuSibouToukeiTy, Integer> ztyimustiyusbus = new ExDBFieldNumber<>("ztyimustiyusbus", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyhrkhuhukbn = new ExDBFieldString<>("ztyhrkhuhukbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysirajikykkbn = new ExDBFieldString<>("ztysirajikykkbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysinsahouhou = new ExDBFieldString<>("ztysinsahouhou", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysinsasyacd = new ExDBFieldString<>("ztysinsasyacd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyketteikekkakbn = new ExDBFieldString<>("ztyketteikekkakbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztydakuhikettisyacd = new ExDBFieldString<>("ztydakuhikettisyacd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysyoubyoutyuubunrui = new ExDBFieldString<>("ztysyoubyoutyuubunrui", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysyoubyoucd1x5 = new ExDBFieldString<>("ztysyoubyoucd1x5", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysyoubyoucd2x5 = new ExDBFieldString<>("ztysyoubyoucd2x5", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztydaisiincd = new ExDBFieldString<>("ztydaisiincd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztytyuusiincd = new ExDBFieldString<>("ztytyuusiincd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysyousiincd = new ExDBFieldString<>("ztysyousiincd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysoukisibouhyj = new ExDBFieldString<>("ztysoukisibouhyj", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztykeikakikankbn = new ExDBFieldString<>("ztykeikakikankbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztykoudosyougaiarihyj = new ExDBFieldString<>("ztykoudosyougaiarihyj", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztykaijyokbn = new ExDBFieldString<>("ztykaijyokbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztynensyuukbn = new ExDBFieldString<>("ztynensyuukbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyhanbaikeirokbn = new ExDBFieldString<>("ztyhanbaikeirokbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyoyadairitencd = new ExDBFieldString<>("ztyoyadairitencd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztybyoumeicd = new ExDBFieldString<>("ztybyoumeicd", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztysyksbyensitihsyutyhkumu = new ExDBFieldString<>("ztysyksbyensitihsyutyhkumu", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyjyudkaigomehrtkhkumu = new ExDBFieldString<>("ztyjyudkaigomehrtkhkumu", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyijitoukeizennoukbn = new ExDBFieldString<>("ztyijitoukeizennoukbn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztydai1hknkkn = new ExDBFieldString<>("ztydai1hknkkn", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyijitoukeitikshrtkykkbn = new ExDBFieldString<>("ztyijitoukeitikshrtkykkbn", this);

    public final ExDBFieldNumber<ZT_SyuSibouToukeiTy, Integer> ztyteikisiharaikinmanen = new ExDBFieldNumber<>("ztyteikisiharaikinmanen", this);

    public final ExDBFieldString<ZT_SyuSibouToukeiTy, String> ztyyobiv78 = new ExDBFieldString<>("ztyyobiv78", this);
}
