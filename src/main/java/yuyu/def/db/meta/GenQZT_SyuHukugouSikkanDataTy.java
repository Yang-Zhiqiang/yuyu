package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 普保Ⅱ主契約複合疾患データテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SyuHukugouSikkanDataTy extends AbstractExDBTable<ZT_SyuHukugouSikkanDataTy> {

    public GenQZT_SyuHukugouSikkanDataTy() {
        this("ZT_SyuHukugouSikkanDataTy");
    }

    public GenQZT_SyuHukugouSikkanDataTy(String pAlias) {
        super("ZT_SyuHukugouSikkanDataTy", ZT_SyuHukugouSikkanDataTy.class, pAlias);
    }

    public String ZT_SyuHukugouSikkanDataTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyijitoukeidaihyousyurui = new ExDBFieldString<>("ztyijitoukeidaihyousyurui", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztykeiyakunendo = new ExDBFieldString<>("ztykeiyakunendo", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyhknnendo = new ExDBFieldString<>("ztyhknnendo", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztykykage = new ExDBFieldString<>("ztykykage", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztytoutatunenrei = new ExDBFieldString<>("ztytoutatunenrei", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyatukaibetu = new ExDBFieldString<>("ztyatukaibetu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztysinsahouhou = new ExDBFieldString<>("ztysinsahouhou", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyketteikekkakbn = new ExDBFieldString<>("ztyketteikekkakbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztysibousrank = new ExDBFieldString<>("ztysibousrank", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyjissituhosyousrank = new ExDBFieldString<>("ztyjissituhosyousrank", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztysirajikykkbn = new ExDBFieldString<>("ztysirajikykkbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyhrkhuhukbn = new ExDBFieldString<>("ztyhrkhuhukbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyhknsyurui2keta = new ExDBFieldString<>("ztyhknsyurui2keta", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztydaisiincd = new ExDBFieldString<>("ztydaisiincd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztytyuusiincd = new ExDBFieldString<>("ztytyuusiincd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztysyousiincd = new ExDBFieldString<>("ztysyousiincd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztynenreihousikikbn = new ExDBFieldString<>("ztynenreihousikikbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztytodouhukencd = new ExDBFieldString<>("ztytodouhukencd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztybotaisisyaeigyouhonbu = new ExDBFieldString<>("ztybotaisisyaeigyouhonbu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztysisyaeigyoubu = new ExDBFieldString<>("ztysisyaeigyoubu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztynensyuukbn = new ExDBFieldString<>("ztynensyuukbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyhanbaikeirokbn = new ExDBFieldString<>("ztyhanbaikeirokbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyoyadairitencd = new ExDBFieldString<>("ztyoyadairitencd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztytratkidrtencd = new ExDBFieldString<>("ztytratkidrtencd", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztybsudirtnatkikeitaikbn = new ExDBFieldString<>("ztybsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztykyktuuka = new ExDBFieldString<>("ztykyktuuka", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyhrktuuka = new ExDBFieldString<>("ztyhrktuuka", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztysyksbyensitihsyutyhkumu = new ExDBFieldString<>("ztysyksbyensitihsyutyhkumu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyjyudkaigomehrtkhkumu = new ExDBFieldString<>("ztyjyudkaigomehrtkhkumu", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyijitoukeizennoukbn = new ExDBFieldString<>("ztyijitoukeizennoukbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztydai1hknkkn = new ExDBFieldString<>("ztydai1hknkkn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyijitoukeitikshrtkykkbn = new ExDBFieldString<>("ztyijitoukeitikshrtkykkbn", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyyobiv31 = new ExDBFieldString<>("ztyyobiv31", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, BizNumber> ztyijitoukeikeikan = new ExDBFieldString<>("ztyijitoukeikeikan", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SyuHukugouSikkanDataTy, Integer> ztyijitoukeisiboun = new ExDBFieldNumber<>("ztyijitoukeisiboun", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, BizNumber> ztyijitoukeikeikas = new ExDBFieldString<>("ztyijitoukeikeikas", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SyuHukugouSikkanDataTy, Integer> ztyijitoukeisibous = new ExDBFieldNumber<>("ztyijitoukeisibous", this);

    public final ExDBFieldString<ZT_SyuHukugouSikkanDataTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);
}
