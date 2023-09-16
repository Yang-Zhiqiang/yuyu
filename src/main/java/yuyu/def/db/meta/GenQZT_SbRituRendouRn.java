package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SbRituRendouRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 死亡率用連動Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SbRituRendouRn extends AbstractExDBTable<ZT_SbRituRendouRn> {

    public GenQZT_SbRituRendouRn() {
        this("ZT_SbRituRendouRn");
    }

    public GenQZT_SbRituRendouRn(String pAlias) {
        super("ZT_SbRituRendouRn", ZT_SbRituRendouRn.class, pAlias);
    }

    public String ZT_SbRituRendouRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv12x7 = new ExDBFieldString<>("zrnyobiv12x7", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrendouyoukikan = new ExDBFieldString<>("zrnrendouyoukikan", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrendouyoukeiyakunengetu = new ExDBFieldString<>("zrnrendouyoukeiyakunengetu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnrendouyoukihons = new ExDBFieldNumber<>("zrnrendouyoukihons", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnrendouyousibous = new ExDBFieldNumber<>("zrnrendouyousibous", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrntnknitjbrigisbus = new ExDBFieldNumber<>("zrntnknitjbrigisbus", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntenkanminaosikbn = new ExDBFieldString<>("zrntenkanminaosikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrendouyouhrkhouhoukbn = new ExDBFieldString<>("zrnrendouyouhrkhouhoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrendouyoujyuusyokbn = new ExDBFieldString<>("zrnrendouyoujyuusyokbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrendouyousakugenkikan = new ExDBFieldString<>("zrnrendouyousakugenkikan", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrnduyuryumshyutn = new ExDBFieldString<>("zrnrnduyuryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrendouyoubosyuuym = new ExDBFieldString<>("zrnrendouyoubosyuuym", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1 = new ExDBFieldString<>("zrnsuuriyouyobin1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhikettisyacd = new ExDBFieldString<>("zrndakuhikettisyacd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndai2hihokensyahyouji = new ExDBFieldString<>("zrndai2hihokensyahyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrenseimusntkknyuhyj = new ExDBFieldString<>("zrnrenseimusntkknyuhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokubetumaruteiarihyj = new ExDBFieldString<>("zrntokubetumaruteiarihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndougakutenkanhyouji = new ExDBFieldString<>("zrndougakutenkanhyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntenkansentakuhouhoukbn = new ExDBFieldString<>("zrntenkansentakuhouhoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokubetusentakuarikbn = new ExDBFieldString<>("zrntokubetusentakuarikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketteikekkakbn = new ExDBFieldString<>("zrnketteikekkakbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkeiyakukakuninsyuruikbn = new ExDBFieldString<>("zrnkeiyakukakuninsyuruikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkeiyakukakuninriyuukbn = new ExDBFieldString<>("zrnkeiyakukakuninriyuukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrendouyoukekkancdx1 = new ExDBFieldString<>("zrnrendouyoukekkancdx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkeikanensuux1 = new ExDBFieldString<>("zrnkeikanensuux1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyujyutuarihyoujix1 = new ExDBFieldString<>("zrnsyujyutuarihyoujix1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrendouyoukekkancdx2 = new ExDBFieldString<>("zrnrendouyoukekkancdx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkeikanensuux2 = new ExDBFieldString<>("zrnkeikanensuux2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyujyutuarihyoujix2 = new ExDBFieldString<>("zrnsyujyutuarihyoujix2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsaihokenhyouji = new ExDBFieldString<>("zrnsaihokenhyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrnduyusysnhujyusnssyacd = new ExDBFieldString<>("zrnrnduyusysnhujyusnssyacd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrndyusysnhujyusnshuhukbn = new ExDBFieldString<>("zrnrndyusysnhujyusnshuhukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsaisinriyuukbn = new ExDBFieldString<>("zrnsaisinriyuukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnnyoutousaisinarihyouji = new ExDBFieldString<>("zrnnyoutousaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnnyoutanpakusaisinarihyj = new ExDBFieldString<>("zrnnyoutanpakusaisinarihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhemasaisinarihyouji = new ExDBFieldString<>("zrnhemasaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkettousaisinarihyouji = new ExDBFieldString<>("zrnkettousaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsintyousaisinarihyouji = new ExDBFieldString<>("zrnsintyousaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkyouisaisinarihyouji = new ExDBFieldString<>("zrnkyouisaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhukuisaisinarihyouji = new ExDBFieldString<>("zrnhukuisaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntaijyuusaisinarihyouji = new ExDBFieldString<>("zrntaijyuusaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuatusaisinarihyouji = new ExDBFieldString<>("zrnketuatusaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrndyusisnhujyusnssyacd = new ExDBFieldString<>("zrnrndyusisnhujyusnssyacd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrndyusisnhujyusnshuhukbn = new ExDBFieldString<>("zrnrndyusisnhujyusnshuhukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnnyoutoukbn = new ExDBFieldString<>("zrnnyoutoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv1x2 = new ExDBFieldString<>("zrnyobiv1x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnnyoutanpakukbn = new ExDBFieldString<>("zrnnyoutanpakukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhemakbn = new ExDBFieldString<>("zrnhemakbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkettoutikeikajikan = new ExDBFieldString<>("zrnkettoutikeikajikan", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnkettouti = new ExDBFieldNumber<>("zrnkettouti", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsintyou = new ExDBFieldNumber<>("zrnsintyou", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnkyoui = new ExDBFieldNumber<>("zrnkyoui", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnhukui = new ExDBFieldNumber<>("zrnhukui", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrntaijyuu = new ExDBFieldNumber<>("zrntaijyuu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsaikouketuatu = new ExDBFieldNumber<>("zrnsaikouketuatu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsaiteiketuatu = new ExDBFieldNumber<>("zrnsaiteiketuatu", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnxsensyokencd = new ExDBFieldString<>("zrnxsensyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsindenzusyokencd = new ExDBFieldString<>("zrnsindenzusyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrnduyuganteisysnsyokencd = new ExDBFieldString<>("zrnrnduyuganteisysnsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsinsahouhousiyoukbn = new ExDBFieldString<>("zrnsinsahouhousiyoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnvipteikihyouji = new ExDBFieldString<>("zrnvipteikihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhoujyounomihyouji = new ExDBFieldString<>("zrnhoujyounomihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensajissikbn = new ExDBFieldString<>("zrnketuekikensajissikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmaruteisyuruikigou = new ExDBFieldString<>("zrnmaruteisyuruikigou", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnseizonmrtisyuruikgu = new ExDBFieldString<>("zrnseizonmrtisyuruikgu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnketusikisoryou = new ExDBFieldNumber<>("zrnketusikisoryou", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrngot = new ExDBFieldNumber<>("zrngot", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrngpt = new ExDBFieldNumber<>("zrngpt", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnganmagtp = new ExDBFieldNumber<>("zrnganmagtp", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyumisyatkisindenzukbn = new ExDBFieldString<>("zrnsyumisyatkisindenzukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkituenkbn = new ExDBFieldString<>("zrnkituenkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntignmrtisyukgu = new ExDBFieldString<>("zrntignmrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnteigenmaruteikikan = new ExDBFieldString<>("zrnteigenmaruteikikan", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkituenhonsuu = new ExDBFieldString<>("zrnkituenhonsuu", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x2 = new ExDBFieldString<>("zrnsuuriyouyobin1x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnrnduyusppinyuintkykntgk = new ExDBFieldNumber<>("zrnrnduyusppinyuintkykntgk", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin12 = new ExDBFieldString<>("zrnsuuriyouyobin12", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv2x2 = new ExDBFieldString<>("zrnyobiv2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x3 = new ExDBFieldString<>("zrnsuuriyouyobin1x3", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin3 = new ExDBFieldNumber<>("zrnyobin3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin12x2 = new ExDBFieldString<>("zrnsuuriyouyobin12x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrngoukeiteigenteikitkyks = new ExDBFieldNumber<>("zrngoukeiteigenteikitkyks", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrntigntikbbntnknitjbrs = new ExDBFieldNumber<>("zrntigntikbbntnknitjbrs", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokuteisippeisetkbn = new ExDBFieldString<>("zrntokuteisippeisetkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin2 = new ExDBFieldString<>("zrnsuuriyouyobin2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntaikakukijyunkanwahyouji = new ExDBFieldString<>("zrntaikakukijyunkanwahyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhaitoukbn = new ExDBFieldString<>("zrnhaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsnsykrketkbtsntkarihyj = new ExDBFieldString<>("zrnsnsykrketkbtsntkarihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv1x5 = new ExDBFieldString<>("zrnyobiv1x5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmanseisikkansetkbn = new ExDBFieldString<>("zrnmanseisikkansetkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrngengakutenkankykhyj = new ExDBFieldString<>("zrngengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv2x4 = new ExDBFieldString<>("zrnyobiv2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnfilekbn = new ExDBFieldString<>("zrnfilekbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv2x5 = new ExDBFieldString<>("zrnyobiv2x5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x4 = new ExDBFieldString<>("zrnsuuriyouyobin1x4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin3x2 = new ExDBFieldNumber<>("zrnyobin3x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin12x3 = new ExDBFieldString<>("zrnsuuriyouyobin12x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv2x6 = new ExDBFieldString<>("zrnyobiv2x6", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x5 = new ExDBFieldString<>("zrnsuuriyouyobin1x5", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin3x3 = new ExDBFieldNumber<>("zrnyobin3x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin12x4 = new ExDBFieldString<>("zrnsuuriyouyobin12x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv2x7 = new ExDBFieldString<>("zrnyobiv2x7", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x6 = new ExDBFieldString<>("zrnsuuriyouyobin1x6", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin3x4 = new ExDBFieldNumber<>("zrnyobin3x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin12x5 = new ExDBFieldString<>("zrnsuuriyouyobin12x5", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrntaikakuhyouten = new ExDBFieldNumber<>("zrntaikakuhyouten", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnnyoutousykykhyutn = new ExDBFieldNumber<>("zrnnyoutousykykhyutn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnnyoutanpakusykykhyutn = new ExDBFieldNumber<>("zrnnyoutanpakusykykhyutn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnketuatutandokuhyouten = new ExDBFieldNumber<>("zrnketuatutandokuhyouten", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin5 = new ExDBFieldNumber<>("zrnyobin5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin9 = new ExDBFieldString<>("zrnsuuriyouyobin9", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin5x2 = new ExDBFieldNumber<>("zrnyobin5x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin9x2 = new ExDBFieldString<>("zrnsuuriyouyobin9x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin5x3 = new ExDBFieldNumber<>("zrnyobin5x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin9x3 = new ExDBFieldString<>("zrnsuuriyouyobin9x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyunyumrtisyukgu = new ExDBFieldString<>("zrnsyunyumrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyuunyuumaruteikikan = new ExDBFieldString<>("zrnsyuunyuumaruteikikan", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsyuunyuumrtinknengkn5 = new ExDBFieldNumber<>("zrnsyuunyuumrtinknengkn5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyuunyuumrtinkshrkkn = new ExDBFieldString<>("zrnsyuunyuumrtinkshrkkn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin12x6 = new ExDBFieldString<>("zrnsuuriyouyobin12x6", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhutanpobui1 = new ExDBFieldString<>("zrnhutanpobui1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhtnpkkn1 = new ExDBFieldString<>("zrnhtnpkkn1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhutanpobui2 = new ExDBFieldString<>("zrnhutanpobui2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhtnpkkn2 = new ExDBFieldString<>("zrnhtnpkkn2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyosinnyoutou = new ExDBFieldString<>("zrnsyosinnyoutou", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyosinnyoutanpaku = new ExDBFieldString<>("zrnsyosinnyoutanpaku", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyosinnyousenketu = new ExDBFieldString<>("zrnsyosinnyousenketu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsyosinsaikouketuatu = new ExDBFieldNumber<>("zrnsyosinsaikouketuatu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsyosinsaiteiketuatu = new ExDBFieldNumber<>("zrnsyosinsaiteiketuatu", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsaisinnyoutou = new ExDBFieldString<>("zrnsaisinnyoutou", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsaisinnyoutanpaku = new ExDBFieldString<>("zrnsaisinnyoutanpaku", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsaisinnyousenketu = new ExDBFieldString<>("zrnsaisinnyousenketu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsaisinsaikouketuatu = new ExDBFieldNumber<>("zrnsaisinsaikouketuatu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsaisinsaiteiketuatu = new ExDBFieldNumber<>("zrnsaisinsaiteiketuatu", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensaijyou1 = new ExDBFieldString<>("zrnketuekikensaijyou1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensaijyou2 = new ExDBFieldString<>("zrnketuekikensaijyou2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensaijyou3 = new ExDBFieldString<>("zrnketuekikensaijyou3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensaijyou4 = new ExDBFieldString<>("zrnketuekikensaijyou4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensaijyou5 = new ExDBFieldString<>("zrnketuekikensaijyou5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhukasyukeiyakukigou = new ExDBFieldString<>("zrnhukasyukeiyakukigou", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsekininkaisiymd = new ExDBFieldString<>("zrnsekininkaisiymd", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsyosinmyakuhakusuu = new ExDBFieldNumber<>("zrnsyosinmyakuhakusuu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsyosinhuseimyakusuu = new ExDBFieldNumber<>("zrnsyosinhuseimyakusuu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsaisinmyakuhakusuu = new ExDBFieldNumber<>("zrnsaisinmyakuhakusuu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsaisinhuseimyakusuu = new ExDBFieldNumber<>("zrnsaisinhuseimyakusuu", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin2x2 = new ExDBFieldString<>("zrnsuuriyouyobin2x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsouhyouten = new ExDBFieldNumber<>("zrnsouhyouten", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntoukeiyukykymd = new ExDBFieldString<>("zrntoukeiyukykymd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhiketteiriyuucdx1 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhiketteiriyuucdx2 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhiketteiriyuucdx3 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhiketteiriyuucdx4 = new ExDBFieldString<>("zrndakuhiketteiriyuucdx4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkanwamaeryouzouhyouten = new ExDBFieldString<>("zrnkanwamaeryouzouhyouten", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnryoumasitokujyoukanwahyj = new ExDBFieldString<>("zrnryoumasitokujyoukanwahyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhtnptokujyoukanwahyj = new ExDBFieldString<>("zrnhtnptokujyoukanwahyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmaruteikigousedaikbn = new ExDBFieldString<>("zrnmaruteikigousedaikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnseizonmrtikgusdkbn = new ExDBFieldString<>("zrnseizonmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnteigenmrtikgusdkbn = new ExDBFieldString<>("zrnteigenmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyuunyuumrtikgusdkbn = new ExDBFieldString<>("zrnsyuunyuumrtikgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhksykykkgusdkbn = new ExDBFieldString<>("zrnhksykykkgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhhknsynensyuukbn = new ExDBFieldString<>("zrnhhknsynensyuukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnpmentokuyakukbn = new ExDBFieldString<>("zrnpmentokuyakukbn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnpmennenkansanp = new ExDBFieldNumber<>("zrnpmennenkansanp", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv1x9 = new ExDBFieldString<>("zrnyobiv1x9", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyosinsouchol = new ExDBFieldString<>("zrnsyosinsouchol", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyosinhdlchol = new ExDBFieldString<>("zrnsyosinhdlchol", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyosintyuuseisibou = new ExDBFieldString<>("zrnsyosintyuuseisibou", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsysnsyumisyatkikettouti = new ExDBFieldString<>("zrnsysnsyumisyatkikettouti", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnsyosintoukahemogurobin = new ExDBFieldString<>("zrnsyosintoukahemogurobin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnsyosinnyousan = new ExDBFieldString<>("zrnsyosinnyousan", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnsyosinkureatinin = new ExDBFieldString<>("zrnsyosinkureatinin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnbosyuukeirokbn = new ExDBFieldString<>("zrnbosyuukeirokbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnbsudirtnatkikeitaikbn = new ExDBFieldString<>("zrnbsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkigkyhsitihsyutkykarihyj = new ExDBFieldString<>("zrnkigkyhsitihsyutkykarihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnpmenhutanpobui1 = new ExDBFieldString<>("zrnpmenhutanpobui1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnpmenhutanpokikan1 = new ExDBFieldString<>("zrnpmenhutanpokikan1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnpmenhutanpobui2 = new ExDBFieldString<>("zrnpmenhutanpobui2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnpmenhutanpokikan2 = new ExDBFieldString<>("zrnpmenhutanpokikan2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkanyujidatakanrino = new ExDBFieldString<>("zrnkanyujidatakanrino", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnbnktgsnzkkykdatakanrino = new ExDBFieldString<>("zrnbnktgsnzkkykdatakanrino", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkykjiqpackhyj = new ExDBFieldString<>("zrnkykjiqpackhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x11 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x12 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x13 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x14 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi1x15 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi2x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhokensyuruikigouyobi3x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokuyakukigouyobix1 = new ExDBFieldString<>("zrntokuyakukigouyobix1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokuyakukigouyobix2 = new ExDBFieldString<>("zrntokuyakukigouyobix2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokuyakukigouyobix3 = new ExDBFieldString<>("zrntokuyakukigouyobix3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokuyakukigouyobix4 = new ExDBFieldString<>("zrntokuyakukigouyobix4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokuyakukigouyobix5 = new ExDBFieldString<>("zrntokuyakukigouyobix5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmaruteikigouyobix1 = new ExDBFieldString<>("zrnmaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmaruteikigouyobix2 = new ExDBFieldString<>("zrnmaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmaruteikigouyobix3 = new ExDBFieldString<>("zrnmaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmaruteikigouyobix4 = new ExDBFieldString<>("zrnmaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmaruteikigouyobix5 = new ExDBFieldString<>("zrnmaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsiznmrtikguybx1 = new ExDBFieldString<>("zrnsiznmrtikguybx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsiznmrtikguybx2 = new ExDBFieldString<>("zrnsiznmrtikguybx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsiznmrtikguybx3 = new ExDBFieldString<>("zrnsiznmrtikguybx3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsiznmrtikguybx4 = new ExDBFieldString<>("zrnsiznmrtikguybx4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsiznmrtikguybx5 = new ExDBFieldString<>("zrnsiznmrtikguybx5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnteigenmaruteikigouyobix1 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnteigenmaruteikigouyobix2 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnteigenmaruteikigouyobix3 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnteigenmaruteikigouyobix4 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnteigenmaruteikigouyobix5 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyuunyuumrtikguybx1 = new ExDBFieldString<>("zrnsyuunyuumrtikguybx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyuunyuumrtikguybx2 = new ExDBFieldString<>("zrnsyuunyuumrtikguybx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyuunyuumrtikguybx3 = new ExDBFieldString<>("zrnsyuunyuumrtikguybx3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyuunyuumrtikguybx4 = new ExDBFieldString<>("zrnsyuunyuumrtikguybx4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyuunyuumrtikguybx5 = new ExDBFieldString<>("zrnsyuunyuumrtikguybx5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin5 = new ExDBFieldString<>("zrnsuuriyouyobin5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin5x2 = new ExDBFieldString<>("zrnsuuriyouyobin5x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin5x3 = new ExDBFieldString<>("zrnsuuriyouyobin5x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin5x4 = new ExDBFieldString<>("zrnsuuriyouyobin5x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin5x5 = new ExDBFieldString<>("zrnsuuriyouyobin5x5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv2x9 = new ExDBFieldString<>("zrnyobiv2x9", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin3x5 = new ExDBFieldNumber<>("zrnyobin3x5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x7 = new ExDBFieldString<>("zrnsuuriyouyobin1x7", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv1x11 = new ExDBFieldString<>("zrnyobiv1x11", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin5x6 = new ExDBFieldString<>("zrnsuuriyouyobin5x6", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhikettikjynsyrikbnx1 = new ExDBFieldString<>("zrndakuhikettikjynsyrikbnx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhikettikjynsyrikbnx2 = new ExDBFieldString<>("zrndakuhikettikjynsyrikbnx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhikettikjynsyrikbnx3 = new ExDBFieldString<>("zrndakuhikettikjynsyrikbnx3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhikettikjynsyrikbnx4 = new ExDBFieldString<>("zrndakuhikettikjynsyrikbnx4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrndakuhikettikjynsyrikbnx5 = new ExDBFieldString<>("zrndakuhikettikjynsyrikbnx5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhtnknkykdatakanrinox1 = new ExDBFieldString<>("zrnhtnknkykdatakanrinox1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhtnknkykdatakanrinox2 = new ExDBFieldString<>("zrnhtnknkykdatakanrinox2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhtnknkykdatakanrinox3 = new ExDBFieldString<>("zrnhtnknkykdatakanrinox3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhtnknkykdatakanrinox4 = new ExDBFieldString<>("zrnhtnknkykdatakanrinox4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhtnknkykdatakanrinox5 = new ExDBFieldString<>("zrnhtnknkykdatakanrinox5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhtnknkykdatakanrinox6 = new ExDBFieldString<>("zrnhtnknkykdatakanrinox6", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkeiyakusyahoujinkbn = new ExDBFieldString<>("zrnkeiyakusyahoujinkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin2x3 = new ExDBFieldString<>("zrnsuuriyouyobin2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttidkhkttikekkacd = new ExDBFieldString<>("zrnhyujynkttidkhkttikekkacd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttidkhkttiryucdx1 = new ExDBFieldString<>("zrnhyujynkttidkhkttiryucdx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttidkhkttiryucdx2 = new ExDBFieldString<>("zrnhyujynkttidkhkttiryucdx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttidkhkttiryucdx3 = new ExDBFieldString<>("zrnhyujynkttidkhkttiryucdx3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttidkhkttiryucdx4 = new ExDBFieldString<>("zrnhyujynkttidkhkttiryucdx4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnhyujynkttiryumshyutn = new ExDBFieldNumber<>("zrnhyujynkttiryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttisakugenkkn = new ExDBFieldString<>("zrnhyujynkttisakugenkkn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnsppitkykryumshyutn = new ExDBFieldNumber<>("zrnsppitkykryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttitktbuicdx1 = new ExDBFieldString<>("zrnhyujynkttitktbuicdx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttihutanpokknx1 = new ExDBFieldString<>("zrnhyujynkttihutanpokknx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttitktbuicdx2 = new ExDBFieldString<>("zrnhyujynkttitktbuicdx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhyujynkttihutanpokknx2 = new ExDBFieldString<>("zrnhyujynkttihutanpokknx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyoukentukitaisyoukbnx1 = new ExDBFieldString<>("zrnjyoukentukitaisyoukbnx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntksseigenhyjx1 = new ExDBFieldString<>("zrnjyukntksseigenhyjx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntktkyknozokihyjx1 = new ExDBFieldString<>("zrnjyukntktkyknozokihyjx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x8 = new ExDBFieldString<>("zrnsuuriyouyobin1x8", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnjyoukentukiseigensx1 = new ExDBFieldNumber<>("zrnjyoukentukiseigensx1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyoukentukitaisyoukbnx2 = new ExDBFieldString<>("zrnjyoukentukitaisyoukbnx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntksseigenhyjx2 = new ExDBFieldString<>("zrnjyukntksseigenhyjx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntktkyknozokihyjx2 = new ExDBFieldString<>("zrnjyukntktkyknozokihyjx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x9 = new ExDBFieldString<>("zrnsuuriyouyobin1x9", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnjyoukentukiseigensx2 = new ExDBFieldNumber<>("zrnjyoukentukiseigensx2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyoukentukitaisyoukbnx3 = new ExDBFieldString<>("zrnjyoukentukitaisyoukbnx3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntksseigenhyjx3 = new ExDBFieldString<>("zrnjyukntksseigenhyjx3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntktkyknozokihyjx3 = new ExDBFieldString<>("zrnjyukntktkyknozokihyjx3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x10 = new ExDBFieldString<>("zrnsuuriyouyobin1x10", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnjyoukentukiseigensx3 = new ExDBFieldNumber<>("zrnjyoukentukiseigensx3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyoukentukitaisyoukbnx4 = new ExDBFieldString<>("zrnjyoukentukitaisyoukbnx4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntksseigenhyjx4 = new ExDBFieldString<>("zrnjyukntksseigenhyjx4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntktkyknozokihyjx4 = new ExDBFieldString<>("zrnjyukntktkyknozokihyjx4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x11 = new ExDBFieldString<>("zrnsuuriyouyobin1x11", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnjyoukentukiseigensx4 = new ExDBFieldNumber<>("zrnjyoukentukiseigensx4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntkkigtiksyrihnkuhyj = new ExDBFieldString<>("zrnjyukntkkigtiksyrihnkuhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnpmensyuruihenkoukbn = new ExDBFieldString<>("zrnpmensyuruihenkoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyoukentukitaisyoukbn2x1 = new ExDBFieldString<>("zrnjyoukentukitaisyoukbn2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntksseigenhyj2x1 = new ExDBFieldString<>("zrnjyukntksseigenhyj2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntktkyknozokihyj2x1 = new ExDBFieldString<>("zrnjyukntktkyknozokihyj2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x12 = new ExDBFieldString<>("zrnsuuriyouyobin1x12", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnjyoukentukiseigens2x1 = new ExDBFieldNumber<>("zrnjyoukentukiseigens2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyoukentukitaisyoukbn2x2 = new ExDBFieldString<>("zrnjyoukentukitaisyoukbn2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntksseigenhyj2x2 = new ExDBFieldString<>("zrnjyukntksseigenhyj2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntktkyknozokihyj2x2 = new ExDBFieldString<>("zrnjyukntktkyknozokihyj2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x13 = new ExDBFieldString<>("zrnsuuriyouyobin1x13", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnjyoukentukiseigens2x2 = new ExDBFieldNumber<>("zrnjyoukentukiseigens2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyoukentukitaisyoukbn2x3 = new ExDBFieldString<>("zrnjyoukentukitaisyoukbn2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntksseigenhyj2x3 = new ExDBFieldString<>("zrnjyukntksseigenhyj2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntktkyknozokihyj2x3 = new ExDBFieldString<>("zrnjyukntktkyknozokihyj2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x14 = new ExDBFieldString<>("zrnsuuriyouyobin1x14", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnjyoukentukiseigens2x3 = new ExDBFieldNumber<>("zrnjyoukentukiseigens2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyoukentukitaisyoukbn2x4 = new ExDBFieldString<>("zrnjyoukentukitaisyoukbn2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntksseigenhyj2x4 = new ExDBFieldString<>("zrnjyukntksseigenhyj2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnjyukntktkyknozokihyj2x4 = new ExDBFieldString<>("zrnjyukntktkyknozokihyj2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin1x15 = new ExDBFieldString<>("zrnsuuriyouyobin1x15", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnjyoukentukiseigens2x4 = new ExDBFieldNumber<>("zrnjyoukentukiseigens2x4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrntktsppiryumshyutn = new ExDBFieldNumber<>("zrntktsppiryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntktsppiskgnkkn = new ExDBFieldString<>("zrntktsppiskgnkkn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnmnsiskknryumshyutn = new ExDBFieldNumber<>("zrnmnsiskknryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmanseisikkansakugenkikan = new ExDBFieldString<>("zrnmanseisikkansakugenkikan", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmanseisikkantokuteibuicd = new ExDBFieldString<>("zrnmanseisikkantokuteibuicd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnmanseisikkanhutanpokikan = new ExDBFieldString<>("zrnmanseisikkanhutanpokikan", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsaihokenkbn = new ExDBFieldString<>("zrnsaihokenkbn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnimustiyusbus = new ExDBFieldNumber<>("zrnimustiyusbus", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnimusateiyoujissituhsyus = new ExDBFieldNumber<>("zrnimusateiyoujissituhsyus", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnisahtnkngukijissituhsyus = new ExDBFieldNumber<>("zrnisahtnkngukijissituhsyus", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnimusateiyoutenkansagakus = new ExDBFieldNumber<>("zrnimusateiyoutenkansagakus", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnimusateiyouhanbaikirkbn = new ExDBFieldString<>("zrnimusateiyouhanbaikirkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnoyabosyuudairitencd = new ExDBFieldString<>("zrnoyabosyuudairitencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyoubosyuukeitaikbn = new ExDBFieldString<>("zrnsuuriyoubosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhihokensyahokenage = new ExDBFieldString<>("zrnhihokensyahokenage", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnrendouyoumusntkkykhyj = new ExDBFieldString<>("zrnrendouyoumusntkkykhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv2x11 = new ExDBFieldString<>("zrnyobiv2x11", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin3x6 = new ExDBFieldNumber<>("zrnyobin3x6", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin9x4 = new ExDBFieldString<>("zrnsuuriyouyobin9x4", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv1x20 = new ExDBFieldString<>("zrnyobiv1x20", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin5x7 = new ExDBFieldString<>("zrnsuuriyouyobin5x7", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsindenzusyokensyousaicd = new ExDBFieldString<>("zrnsindenzusyokensyousaicd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnimstiyuktekknsjsshyj = new ExDBFieldString<>("zrnimstiyuktekknsjsshyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensasekkekkyuusu = new ExDBFieldString<>("zrnketuekikensasekkekkyuusu", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnktekknsskkkkyususykncd = new ExDBFieldString<>("zrnktekknsskkkkyususykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensahakkekkyuusu = new ExDBFieldString<>("zrnketuekikensahakkekkyuusu", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnktekknshkkkkyususykncd = new ExDBFieldString<>("zrnktekknshkkkkyususykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnktekknsketusikisoryou = new ExDBFieldString<>("zrnktekknsketusikisoryou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnktekknsktsksryusyokencd = new ExDBFieldString<>("zrnktekknsktsksryusyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnktekknshematokuritto = new ExDBFieldString<>("zrnktekknshematokuritto", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnktekhmtkrttsykncd = new ExDBFieldString<>("zrnktekhmtkrttsykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnketuekikensakessyoubansu = new ExDBFieldString<>("zrnketuekikensakessyoubansu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnktekknskssyubnsusyokencd = new ExDBFieldString<>("zrnktekknskssyubnsusyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnktekknskssisutnpkryu = new ExDBFieldString<>("zrnktekknskssisutnpkryu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnktekkssisutnpkryusykncd = new ExDBFieldString<>("zrnktekkssisutnpkryusykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnketuekikensaarubumin = new ExDBFieldString<>("zrnketuekikensaarubumin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnktekknsarubuminsyokencd = new ExDBFieldString<>("zrnktekknsarubuminsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnketuekikensaztt = new ExDBFieldString<>("zrnketuekikensaztt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensazttsyokencd = new ExDBFieldString<>("zrnketuekikensazttsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensagot = new ExDBFieldString<>("zrnketuekikensagot", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensagotsyokencd = new ExDBFieldString<>("zrnketuekikensagotsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensagpt = new ExDBFieldString<>("zrnketuekikensagpt", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensagptsyokencd = new ExDBFieldString<>("zrnketuekikensagptsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensaganmagtp = new ExDBFieldString<>("zrnketuekikensaganmagtp", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekiganmagtpsyokencd = new ExDBFieldString<>("zrnketuekiganmagtpsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensasouchol = new ExDBFieldString<>("zrnketuekikensasouchol", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekicholsyokencd = new ExDBFieldString<>("zrnketuekicholsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensahdlchol = new ExDBFieldString<>("zrnketuekikensahdlchol", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensahdlsyokencd = new ExDBFieldString<>("zrnketuekikensahdlsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnktekknstukhmgrbn = new ExDBFieldString<>("zrnktekknstukhmgrbn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnktekhmgrbnsykncd = new ExDBFieldString<>("zrnktekhmgrbnsykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnktekknskorinesuterrze = new ExDBFieldString<>("zrnktekknskorinesuterrze", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkorinesuterrzesyokencd = new ExDBFieldString<>("zrnkorinesuterrzesyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnketuekikensamcv = new ExDBFieldString<>("zrnketuekikensamcv", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensamcvsyokencd = new ExDBFieldString<>("zrnketuekikensamcvsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnketuekikensamch = new ExDBFieldString<>("zrnketuekikensamch", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensamchsyokencd = new ExDBFieldString<>("zrnketuekikensamchsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnketuekikensamchc = new ExDBFieldString<>("zrnketuekikensamchc", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensamchcsyokencd = new ExDBFieldString<>("zrnketuekikensamchcsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnketuekikensacea = new ExDBFieldString<>("zrnketuekikensacea", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensaceasyokencd = new ExDBFieldString<>("zrnketuekikensaceasyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnketuekikensaafp = new ExDBFieldString<>("zrnketuekikensaafp", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensaafpsyokencd = new ExDBFieldString<>("zrnketuekikensaafpsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensahbskbn = new ExDBFieldString<>("zrnketuekikensahbskbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensahbssyokencd = new ExDBFieldString<>("zrnketuekikensahbssyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensahcvkbn = new ExDBFieldString<>("zrnketuekikensahcvkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnketuekikensahcvsyokencd = new ExDBFieldString<>("zrnketuekikensahcvsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnimusateiyouknsnsytryskbn = new ExDBFieldString<>("zrnimusateiyouknsnsytryskbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsyosinldlchol = new ExDBFieldString<>("zrnsyosinldlchol", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokuteijyoutaihushrhyj = new ExDBFieldString<>("zrntokuteijyoutaihushrhyj", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnrendouyouosyukeiyakup = new ExDBFieldNumber<>("zrnrendouyouosyukeiyakup", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntokubetuhosyoukikan = new ExDBFieldString<>("zrntokubetuhosyoukikan", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnrendouyougoukeitenkans = new ExDBFieldNumber<>("zrnrendouyougoukeitenkans", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnrnduyugukitnknkakaku = new ExDBFieldNumber<>("zrnrnduyugukitnknkakaku", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnrnduyuwnsgukitnknkakaku = new ExDBFieldNumber<>("zrnrnduyuwnsgukitnknkakaku", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnmostnknkhnbbnjyuturt = new ExDBFieldString<>("zrnmostnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnrnduyusykykbbnkhns = new ExDBFieldNumber<>("zrnrnduyusykykbbnkhns", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnrendouyouyoteiriritu = new ExDBFieldString<>("zrnrendouyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv121 = new ExDBFieldString<>("zrnyobiv121", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrngaikadatekihons = new ExDBFieldNumber<>("zrngaikadatekihons", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrngaikadatesibous = new ExDBFieldNumber<>("zrngaikadatesibous", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, BizNumber> zrnkawaserate = new ExDBFieldString<>("zrnkawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin8 = new ExDBFieldString<>("zrnsuuriyouyobin8", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnsuuriyouyobin10x2 = new ExDBFieldString<>("zrnsuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv9 = new ExDBFieldString<>("zrnyobiv9", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv10x4 = new ExDBFieldString<>("zrnyobiv10x4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin7 = new ExDBFieldNumber<>("zrnyobin7", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin7x2 = new ExDBFieldNumber<>("zrnyobin7x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin7x3 = new ExDBFieldNumber<>("zrnyobin7x3", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin7x4 = new ExDBFieldNumber<>("zrnyobin7x4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouRn, Integer> zrnyobin7x5 = new ExDBFieldNumber<>("zrnyobin7x5", this);

    public final ExDBFieldString<ZT_SbRituRendouRn, String> zrnyobiv4x2 = new ExDBFieldString<>("zrnyobiv4x2", this);
}
