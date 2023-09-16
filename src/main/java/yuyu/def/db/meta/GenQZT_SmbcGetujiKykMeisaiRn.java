package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SmbcGetujiKykMeisaiRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＳＭＢＣ月次契約明細Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SmbcGetujiKykMeisaiRn extends AbstractExDBTable<ZT_SmbcGetujiKykMeisaiRn> {

    public GenQZT_SmbcGetujiKykMeisaiRn() {
        this("ZT_SmbcGetujiKykMeisaiRn");
    }

    public GenQZT_SmbcGetujiKykMeisaiRn(String pAlias) {
        super("ZT_SmbcGetujiKykMeisaiRn", ZT_SmbcGetujiKykMeisaiRn.class, pAlias);
    }

    public String ZT_SmbcGetujiKykMeisaiRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrndatakijyunymd = new ExDBFieldString<>("zrndatakijyunymd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrndatakijyunym = new ExDBFieldString<>("zrndatakijyunym", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnaatukaidirtncd = new ExDBFieldString<>("zrnaatukaidirtncd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnbatukaidirtncd = new ExDBFieldString<>("zrnbatukaidirtncd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnaatukaibosyuunincd = new ExDBFieldString<>("zrnaatukaibosyuunincd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnbatukaibosyuunincd = new ExDBFieldString<>("zrnbatukaibosyuunincd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnmdhnaisyoumeicd = new ExDBFieldString<>("zrnmdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrntuukacdsmbcgetuji = new ExDBFieldString<>("zrntuukacdsmbcgetuji", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnhrkhuhukbn = new ExDBFieldString<>("zrnhrkhuhukbn", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnkyknmknsmbcgetuji = new ExDBFieldString<>("zrnkyknmknsmbcgetuji", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnkyknmkjsmbcgetuji = new ExDBFieldString<>("zrnkyknmkjsmbcgetuji", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnhhknnmkjsmbcgetuji = new ExDBFieldString<>("zrnhhknnmkjsmbcgetuji", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrnitijibrp = new ExDBFieldNumber<>("zrnitijibrp", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrngoukeip2 = new ExDBFieldNumber<>("zrngoukeip2", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrnzenkizennoup = new ExDBFieldNumber<>("zrnzenkizennoup", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrntumitatekngk = new ExDBFieldNumber<>("zrntumitatekngk", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrntargettktoutatubi = new ExDBFieldString<>("zrntargettktoutatubi", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrnmokuhyouti = new ExDBFieldNumber<>("zrnmokuhyouti", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrnmokuhyoukngk = new ExDBFieldNumber<>("zrnmokuhyoukngk", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrnkaiyakuhr = new ExDBFieldNumber<>("zrnkaiyakuhr", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnhrkpjyuutouym = new ExDBFieldString<>("zrnhrkpjyuutouym", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrnkihrpruikeigk = new ExDBFieldNumber<>("zrnkihrpruikeigk", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, BizNumber> zrntousyokykjikawaserate = new ExDBFieldString<>("zrntousyokykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnmankiymd = new ExDBFieldString<>("zrnmankiymd", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnikkatubaraikbn = new ExDBFieldString<>("zrnikkatubaraikbn", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnikkatubaraikaisuu = new ExDBFieldString<>("zrnikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnyobiv56 = new ExDBFieldString<>("zrnyobiv56", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, BizNumber> zrngmeigyoubijikawaserate = new ExDBFieldString<>("zrngmeigyoubijikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnyobiv16 = new ExDBFieldString<>("zrnyobiv16", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnsymtymd = new ExDBFieldString<>("zrnsymtymd", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrngetumatuymdidouw = new ExDBFieldNumber<>("zrngetumatuymdidouw", this);

    public final ExDBFieldNumber<ZT_SmbcGetujiKykMeisaiRn, Long> zrngetumatuymdsibous = new ExDBFieldNumber<>("zrngetumatuymdsibous", this);

    public final ExDBFieldString<ZT_SmbcGetujiKykMeisaiRn, String> zrnyobiv53 = new ExDBFieldString<>("zrnyobiv53", this);
}
