package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SmbcGetujiKykMeisaiTy extends AbstractExDBTable<ZT_SmbcGetujiKykMeisaiTy> {

    public GenQZT_SmbcGetujiKykMeisaiTy() {
        this("ZT_SmbcGetujiKykMeisaiTy");
    }

    public GenQZT_SmbcGetujiKykMeisaiTy(String pAlias) {
        super("ZT_SmbcGetujiKykMeisaiTy", ZT_SmbcGetujiKykMeisaiTy.class, pAlias);
    }

    public String ZT_SmbcGetujiKykMeisaiTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztydatakijyunymd = new ExDBFieldString<>("ztydatakijyunymd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztydatakijyunym = new ExDBFieldString<>("ztydatakijyunym", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyaatukaidirtncd = new ExDBFieldString<>("ztyaatukaidirtncd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztybatukaidirtncd = new ExDBFieldString<>("ztybatukaidirtncd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyaatukaibosyuunincd = new ExDBFieldString<>("ztyaatukaibosyuunincd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztybatukaibosyuunincd = new ExDBFieldString<>("ztybatukaibosyuunincd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztymdhnaisyoumeicd = new ExDBFieldString<>("ztymdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztytuukacdsmbcgetuji = new ExDBFieldString<>("ztytuukacdsmbcgetuji", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyhrkhuhukbn = new ExDBFieldString<>("ztyhrkhuhukbn", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztykyknmknsmbcgetuji = new ExDBFieldString<>("ztykyknmknsmbcgetuji", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztykyknmkjsmbcgetuji = new ExDBFieldString<>("ztykyknmkjsmbcgetuji", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyhhknnmkjsmbcgetuji = new ExDBFieldString<>("ztyhhknnmkjsmbcgetuji", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztyitijibrp = new ExDBFieldNumber<>("ztyitijibrp", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztygoukeip2 = new ExDBFieldNumber<>("ztygoukeip2", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztyzenkizennoup = new ExDBFieldNumber<>("ztyzenkizennoup", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztytumitatekngk = new ExDBFieldNumber<>("ztytumitatekngk", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztytargettktoutatubi = new ExDBFieldString<>("ztytargettktoutatubi", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztymokuhyouti = new ExDBFieldNumber<>("ztymokuhyouti", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztymokuhyoukngk = new ExDBFieldNumber<>("ztymokuhyoukngk", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztykaiyakuhr = new ExDBFieldNumber<>("ztykaiyakuhr", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyhrkpjyuutouym = new ExDBFieldString<>("ztyhrkpjyuutouym", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztykihrpruikeigk = new ExDBFieldNumber<>("ztykihrpruikeigk", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, BizNumber> ztytousyokykjikawaserate = new ExDBFieldString<>("ztytousyokykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztymankiymd = new ExDBFieldString<>("ztymankiymd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyikkatubaraikbn = new ExDBFieldString<>("ztyikkatubaraikbn", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyikkatubaraikaisuu = new ExDBFieldString<>("ztyikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyyobiv56 = new ExDBFieldString<>("ztyyobiv56", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, BizNumber> ztygmeigyoubijikawaserate = new ExDBFieldString<>("ztygmeigyoubijikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyyobiv16 = new ExDBFieldString<>("ztyyobiv16", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztysymtymd = new ExDBFieldString<>("ztysymtymd", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztygetumatuymdidouw = new ExDBFieldNumber<>("ztygetumatuymdidouw", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiTy, Long> ztygetumatuymdsibous = new ExDBFieldNumber<>("ztygetumatuymdsibous", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiTy, String> ztyyobiv53 = new ExDBFieldString<>("ztyyobiv53", this);
}
