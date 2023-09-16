package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SbRituRendouTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 死亡率用連動Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SbRituRendouTy extends AbstractExDBTable<ZT_SbRituRendouTy> {

    public GenQZT_SbRituRendouTy() {
        this("ZT_SbRituRendouTy");
    }

    public GenQZT_SbRituRendouTy(String pAlias) {
        super("ZT_SbRituRendouTy", ZT_SbRituRendouTy.class, pAlias);
    }

    public String ZT_SbRituRendouTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv12x7 = new ExDBFieldString<>("ztyyobiv12x7", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrendouyoukikan = new ExDBFieldString<>("ztyrendouyoukikan", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrendouyoukeiyakunengetu = new ExDBFieldString<>("ztyrendouyoukeiyakunengetu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyrendouyoukihons = new ExDBFieldNumber<>("ztyrendouyoukihons", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyrendouyousibous = new ExDBFieldNumber<>("ztyrendouyousibous", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztytnknitjbrigisbus = new ExDBFieldNumber<>("ztytnknitjbrigisbus", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytenkanminaosikbn = new ExDBFieldString<>("ztytenkanminaosikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrendouyouhrkhouhoukbn = new ExDBFieldString<>("ztyrendouyouhrkhouhoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrendouyoujyuusyokbn = new ExDBFieldString<>("ztyrendouyoujyuusyokbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrendouyousakugenkikan = new ExDBFieldString<>("ztyrendouyousakugenkikan", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrnduyuryumshyutn = new ExDBFieldString<>("ztyrnduyuryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrendouyoubosyuuym = new ExDBFieldString<>("ztyrendouyoubosyuuym", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1 = new ExDBFieldString<>("ztysuuriyouyobin1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhikettisyacd = new ExDBFieldString<>("ztydakuhikettisyacd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydai2hihokensyahyouji = new ExDBFieldString<>("ztydai2hihokensyahyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrenseimusntkknyuhyj = new ExDBFieldString<>("ztyrenseimusntkknyuhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokubetumaruteiarihyj = new ExDBFieldString<>("ztytokubetumaruteiarihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydougakutenkanhyouji = new ExDBFieldString<>("ztydougakutenkanhyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytenkansentakuhouhoukbn = new ExDBFieldString<>("ztytenkansentakuhouhoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokubetusentakuarikbn = new ExDBFieldString<>("ztytokubetusentakuarikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketteikekkakbn = new ExDBFieldString<>("ztyketteikekkakbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykeiyakukakuninsyuruikbn = new ExDBFieldString<>("ztykeiyakukakuninsyuruikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykeiyakukakuninriyuukbn = new ExDBFieldString<>("ztykeiyakukakuninriyuukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrendouyoukekkancdx1 = new ExDBFieldString<>("ztyrendouyoukekkancdx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykeikanensuux1 = new ExDBFieldString<>("ztykeikanensuux1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyujyutuarihyoujix1 = new ExDBFieldString<>("ztysyujyutuarihyoujix1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrendouyoukekkancdx2 = new ExDBFieldString<>("ztyrendouyoukekkancdx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykeikanensuux2 = new ExDBFieldString<>("ztykeikanensuux2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyujyutuarihyoujix2 = new ExDBFieldString<>("ztysyujyutuarihyoujix2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysaihokenhyouji = new ExDBFieldString<>("ztysaihokenhyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrnduyusysnhujyusnssyacd = new ExDBFieldString<>("ztyrnduyusysnhujyusnssyacd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrndyusysnhujyusnshuhukbn = new ExDBFieldString<>("ztyrndyusysnhujyusnshuhukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysaisinriyuukbn = new ExDBFieldString<>("ztysaisinriyuukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztynyoutousaisinarihyouji = new ExDBFieldString<>("ztynyoutousaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztynyoutanpakusaisinarihyj = new ExDBFieldString<>("ztynyoutanpakusaisinarihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhemasaisinarihyouji = new ExDBFieldString<>("ztyhemasaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykettousaisinarihyouji = new ExDBFieldString<>("ztykettousaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysintyousaisinarihyouji = new ExDBFieldString<>("ztysintyousaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykyouisaisinarihyouji = new ExDBFieldString<>("ztykyouisaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhukuisaisinarihyouji = new ExDBFieldString<>("ztyhukuisaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytaijyuusaisinarihyouji = new ExDBFieldString<>("ztytaijyuusaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuatusaisinarihyouji = new ExDBFieldString<>("ztyketuatusaisinarihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrndyusisnhujyusnssyacd = new ExDBFieldString<>("ztyrndyusisnhujyusnssyacd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrndyusisnhujyusnshuhukbn = new ExDBFieldString<>("ztyrndyusisnhujyusnshuhukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztynyoutoukbn = new ExDBFieldString<>("ztynyoutoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztynyoutanpakukbn = new ExDBFieldString<>("ztynyoutanpakukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhemakbn = new ExDBFieldString<>("ztyhemakbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykettoutikeikajikan = new ExDBFieldString<>("ztykettoutikeikajikan", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztykettouti = new ExDBFieldNumber<>("ztykettouti", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysintyou = new ExDBFieldNumber<>("ztysintyou", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztykyoui = new ExDBFieldNumber<>("ztykyoui", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyhukui = new ExDBFieldNumber<>("ztyhukui", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztytaijyuu = new ExDBFieldNumber<>("ztytaijyuu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysaikouketuatu = new ExDBFieldNumber<>("ztysaikouketuatu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysaiteiketuatu = new ExDBFieldNumber<>("ztysaiteiketuatu", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyxsensyokencd = new ExDBFieldString<>("ztyxsensyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysindenzusyokencd = new ExDBFieldString<>("ztysindenzusyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrnduyuganteisysnsyokencd = new ExDBFieldString<>("ztyrnduyuganteisysnsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysinsahouhousiyoukbn = new ExDBFieldString<>("ztysinsahouhousiyoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyvipteikihyouji = new ExDBFieldString<>("ztyvipteikihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhoujyounomihyouji = new ExDBFieldString<>("ztyhoujyounomihyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensajissikbn = new ExDBFieldString<>("ztyketuekikensajissikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymaruteisyuruikigou = new ExDBFieldString<>("ztymaruteisyuruikigou", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyseizonmrtisyuruikgu = new ExDBFieldString<>("ztyseizonmrtisyuruikgu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyketusikisoryou = new ExDBFieldNumber<>("ztyketusikisoryou", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztygot = new ExDBFieldNumber<>("ztygot", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztygpt = new ExDBFieldNumber<>("ztygpt", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyganmagtp = new ExDBFieldNumber<>("ztyganmagtp", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyumisyatkisindenzukbn = new ExDBFieldString<>("ztysyumisyatkisindenzukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykituenkbn = new ExDBFieldString<>("ztykituenkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytignmrtisyukgu = new ExDBFieldString<>("ztytignmrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyteigenmaruteikikan = new ExDBFieldString<>("ztyteigenmaruteikikan", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykituenhonsuu = new ExDBFieldString<>("ztykituenhonsuu", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x2 = new ExDBFieldString<>("ztysuuriyouyobin1x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyrnduyusppinyuintkykntgk = new ExDBFieldNumber<>("ztyrnduyusppinyuintkykntgk", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin12 = new ExDBFieldString<>("ztysuuriyouyobin12", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv2x2 = new ExDBFieldString<>("ztyyobiv2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x3 = new ExDBFieldString<>("ztysuuriyouyobin1x3", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin3 = new ExDBFieldNumber<>("ztyyobin3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin12x2 = new ExDBFieldString<>("ztysuuriyouyobin12x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztygoukeiteigenteikitkyks = new ExDBFieldNumber<>("ztygoukeiteigenteikitkyks", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztytigntikbbntnknitjbrs = new ExDBFieldNumber<>("ztytigntikbbntnknitjbrs", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokuteisippeisetkbn = new ExDBFieldString<>("ztytokuteisippeisetkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin2 = new ExDBFieldString<>("ztysuuriyouyobin2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytaikakukijyunkanwahyouji = new ExDBFieldString<>("ztytaikakukijyunkanwahyouji", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysnsykrketkbtsntkarihyj = new ExDBFieldString<>("ztysnsykrketkbtsntkarihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv1x5 = new ExDBFieldString<>("ztyyobiv1x5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymanseisikkansetkbn = new ExDBFieldString<>("ztymanseisikkansetkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztygengakutenkankykhyj = new ExDBFieldString<>("ztygengakutenkankykhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv2x4 = new ExDBFieldString<>("ztyyobiv2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyfilekbn = new ExDBFieldString<>("ztyfilekbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv2x5 = new ExDBFieldString<>("ztyyobiv2x5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x4 = new ExDBFieldString<>("ztysuuriyouyobin1x4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin3x2 = new ExDBFieldNumber<>("ztyyobin3x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin12x3 = new ExDBFieldString<>("ztysuuriyouyobin12x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv2x6 = new ExDBFieldString<>("ztyyobiv2x6", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x5 = new ExDBFieldString<>("ztysuuriyouyobin1x5", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin3x3 = new ExDBFieldNumber<>("ztyyobin3x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin12x4 = new ExDBFieldString<>("ztysuuriyouyobin12x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv2x7 = new ExDBFieldString<>("ztyyobiv2x7", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x6 = new ExDBFieldString<>("ztysuuriyouyobin1x6", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin3x4 = new ExDBFieldNumber<>("ztyyobin3x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin12x5 = new ExDBFieldString<>("ztysuuriyouyobin12x5", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztytaikakuhyouten = new ExDBFieldNumber<>("ztytaikakuhyouten", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztynyoutousykykhyutn = new ExDBFieldNumber<>("ztynyoutousykykhyutn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztynyoutanpakusykykhyutn = new ExDBFieldNumber<>("ztynyoutanpakusykykhyutn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyketuatutandokuhyouten = new ExDBFieldNumber<>("ztyketuatutandokuhyouten", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin5 = new ExDBFieldNumber<>("ztyyobin5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin9 = new ExDBFieldString<>("ztysuuriyouyobin9", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin5x2 = new ExDBFieldNumber<>("ztyyobin5x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin9x2 = new ExDBFieldString<>("ztysuuriyouyobin9x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin5x3 = new ExDBFieldNumber<>("ztyyobin5x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin9x3 = new ExDBFieldString<>("ztysuuriyouyobin9x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyunyumrtisyukgu = new ExDBFieldString<>("ztysyunyumrtisyukgu", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyuunyuumaruteikikan = new ExDBFieldString<>("ztysyuunyuumaruteikikan", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysyuunyuumrtinknengkn5 = new ExDBFieldNumber<>("ztysyuunyuumrtinknengkn5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyuunyuumrtinkshrkkn = new ExDBFieldString<>("ztysyuunyuumrtinkshrkkn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin12x6 = new ExDBFieldString<>("ztysuuriyouyobin12x6", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhutanpobui1 = new ExDBFieldString<>("ztyhutanpobui1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhtnpkkn1 = new ExDBFieldString<>("ztyhtnpkkn1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhutanpobui2 = new ExDBFieldString<>("ztyhutanpobui2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhtnpkkn2 = new ExDBFieldString<>("ztyhtnpkkn2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyosinnyoutou = new ExDBFieldString<>("ztysyosinnyoutou", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyosinnyoutanpaku = new ExDBFieldString<>("ztysyosinnyoutanpaku", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyosinnyousenketu = new ExDBFieldString<>("ztysyosinnyousenketu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysyosinsaikouketuatu = new ExDBFieldNumber<>("ztysyosinsaikouketuatu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysyosinsaiteiketuatu = new ExDBFieldNumber<>("ztysyosinsaiteiketuatu", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysaisinnyoutou = new ExDBFieldString<>("ztysaisinnyoutou", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysaisinnyoutanpaku = new ExDBFieldString<>("ztysaisinnyoutanpaku", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysaisinnyousenketu = new ExDBFieldString<>("ztysaisinnyousenketu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysaisinsaikouketuatu = new ExDBFieldNumber<>("ztysaisinsaikouketuatu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysaisinsaiteiketuatu = new ExDBFieldNumber<>("ztysaisinsaiteiketuatu", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensaijyou1 = new ExDBFieldString<>("ztyketuekikensaijyou1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensaijyou2 = new ExDBFieldString<>("ztyketuekikensaijyou2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensaijyou3 = new ExDBFieldString<>("ztyketuekikensaijyou3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensaijyou4 = new ExDBFieldString<>("ztyketuekikensaijyou4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensaijyou5 = new ExDBFieldString<>("ztyketuekikensaijyou5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhukasyukeiyakukigou = new ExDBFieldString<>("ztyhukasyukeiyakukigou", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysekininkaisiymd = new ExDBFieldString<>("ztysekininkaisiymd", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysyosinmyakuhakusuu = new ExDBFieldNumber<>("ztysyosinmyakuhakusuu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysyosinhuseimyakusuu = new ExDBFieldNumber<>("ztysyosinhuseimyakusuu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysaisinmyakuhakusuu = new ExDBFieldNumber<>("ztysaisinmyakuhakusuu", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysaisinhuseimyakusuu = new ExDBFieldNumber<>("ztysaisinhuseimyakusuu", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin2x2 = new ExDBFieldString<>("ztysuuriyouyobin2x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysouhyouten = new ExDBFieldNumber<>("ztysouhyouten", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytoukeiyukykymd = new ExDBFieldString<>("ztytoukeiyukykymd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhiketteiriyuucdx1 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhiketteiriyuucdx2 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhiketteiriyuucdx3 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhiketteiriyuucdx4 = new ExDBFieldString<>("ztydakuhiketteiriyuucdx4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykanwamaeryouzouhyouten = new ExDBFieldString<>("ztykanwamaeryouzouhyouten", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyryoumasitokujyoukanwahyj = new ExDBFieldString<>("ztyryoumasitokujyoukanwahyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhtnptokujyoukanwahyj = new ExDBFieldString<>("ztyhtnptokujyoukanwahyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymaruteikigousedaikbn = new ExDBFieldString<>("ztymaruteikigousedaikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyseizonmrtikgusdkbn = new ExDBFieldString<>("ztyseizonmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyteigenmrtikgusdkbn = new ExDBFieldString<>("ztyteigenmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyuunyuumrtikgusdkbn = new ExDBFieldString<>("ztysyuunyuumrtikgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhksykykkgusdkbn = new ExDBFieldString<>("ztyhksykykkgusdkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhhknsynensyuukbn = new ExDBFieldString<>("ztyhhknsynensyuukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztypmentokuyakukbn = new ExDBFieldString<>("ztypmentokuyakukbn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztypmennenkansanp = new ExDBFieldNumber<>("ztypmennenkansanp", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv1x9 = new ExDBFieldString<>("ztyyobiv1x9", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyosinsouchol = new ExDBFieldString<>("ztysyosinsouchol", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyosinhdlchol = new ExDBFieldString<>("ztysyosinhdlchol", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyosintyuuseisibou = new ExDBFieldString<>("ztysyosintyuuseisibou", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysysnsyumisyatkikettouti = new ExDBFieldString<>("ztysysnsyumisyatkikettouti", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztysyosintoukahemogurobin = new ExDBFieldString<>("ztysyosintoukahemogurobin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztysyosinnyousan = new ExDBFieldString<>("ztysyosinnyousan", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztysyosinkureatinin = new ExDBFieldString<>("ztysyosinkureatinin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztybosyuukeirokbn = new ExDBFieldString<>("ztybosyuukeirokbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztybsudirtnatkikeitaikbn = new ExDBFieldString<>("ztybsudirtnatkikeitaikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykigkyhsitihsyutkykarihyj = new ExDBFieldString<>("ztykigkyhsitihsyutkykarihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztypmenhutanpobui1 = new ExDBFieldString<>("ztypmenhutanpobui1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztypmenhutanpokikan1 = new ExDBFieldString<>("ztypmenhutanpokikan1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztypmenhutanpobui2 = new ExDBFieldString<>("ztypmenhutanpobui2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztypmenhutanpokikan2 = new ExDBFieldString<>("ztypmenhutanpokikan2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykanyujidatakanrino = new ExDBFieldString<>("ztykanyujidatakanrino", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztybnktgsnzkkykdatakanrino = new ExDBFieldString<>("ztybnktgsnzkkykdatakanrino", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykykjiqpackhyj = new ExDBFieldString<>("ztykykjiqpackhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x11 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x12 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x13 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x14 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi1x15 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi2x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhokensyuruikigouyobi3x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokuyakukigouyobix1 = new ExDBFieldString<>("ztytokuyakukigouyobix1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokuyakukigouyobix2 = new ExDBFieldString<>("ztytokuyakukigouyobix2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokuyakukigouyobix3 = new ExDBFieldString<>("ztytokuyakukigouyobix3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokuyakukigouyobix4 = new ExDBFieldString<>("ztytokuyakukigouyobix4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokuyakukigouyobix5 = new ExDBFieldString<>("ztytokuyakukigouyobix5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymaruteikigouyobix1 = new ExDBFieldString<>("ztymaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymaruteikigouyobix2 = new ExDBFieldString<>("ztymaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymaruteikigouyobix3 = new ExDBFieldString<>("ztymaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymaruteikigouyobix4 = new ExDBFieldString<>("ztymaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymaruteikigouyobix5 = new ExDBFieldString<>("ztymaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysiznmrtikguybx1 = new ExDBFieldString<>("ztysiznmrtikguybx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysiznmrtikguybx2 = new ExDBFieldString<>("ztysiznmrtikguybx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysiznmrtikguybx3 = new ExDBFieldString<>("ztysiznmrtikguybx3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysiznmrtikguybx4 = new ExDBFieldString<>("ztysiznmrtikguybx4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysiznmrtikguybx5 = new ExDBFieldString<>("ztysiznmrtikguybx5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyteigenmaruteikigouyobix1 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyteigenmaruteikigouyobix2 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyteigenmaruteikigouyobix3 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyteigenmaruteikigouyobix4 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyteigenmaruteikigouyobix5 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyuunyuumrtikguybx1 = new ExDBFieldString<>("ztysyuunyuumrtikguybx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyuunyuumrtikguybx2 = new ExDBFieldString<>("ztysyuunyuumrtikguybx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyuunyuumrtikguybx3 = new ExDBFieldString<>("ztysyuunyuumrtikguybx3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyuunyuumrtikguybx4 = new ExDBFieldString<>("ztysyuunyuumrtikguybx4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyuunyuumrtikguybx5 = new ExDBFieldString<>("ztysyuunyuumrtikguybx5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin5 = new ExDBFieldString<>("ztysuuriyouyobin5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin5x2 = new ExDBFieldString<>("ztysuuriyouyobin5x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin5x3 = new ExDBFieldString<>("ztysuuriyouyobin5x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin5x4 = new ExDBFieldString<>("ztysuuriyouyobin5x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin5x5 = new ExDBFieldString<>("ztysuuriyouyobin5x5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv2x9 = new ExDBFieldString<>("ztyyobiv2x9", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin3x5 = new ExDBFieldNumber<>("ztyyobin3x5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x7 = new ExDBFieldString<>("ztysuuriyouyobin1x7", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv1x11 = new ExDBFieldString<>("ztyyobiv1x11", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin5x6 = new ExDBFieldString<>("ztysuuriyouyobin5x6", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhikettikjynsyrikbnx1 = new ExDBFieldString<>("ztydakuhikettikjynsyrikbnx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhikettikjynsyrikbnx2 = new ExDBFieldString<>("ztydakuhikettikjynsyrikbnx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhikettikjynsyrikbnx3 = new ExDBFieldString<>("ztydakuhikettikjynsyrikbnx3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhikettikjynsyrikbnx4 = new ExDBFieldString<>("ztydakuhikettikjynsyrikbnx4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztydakuhikettikjynsyrikbnx5 = new ExDBFieldString<>("ztydakuhikettikjynsyrikbnx5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhtnknkykdatakanrinox1 = new ExDBFieldString<>("ztyhtnknkykdatakanrinox1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhtnknkykdatakanrinox2 = new ExDBFieldString<>("ztyhtnknkykdatakanrinox2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhtnknkykdatakanrinox3 = new ExDBFieldString<>("ztyhtnknkykdatakanrinox3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhtnknkykdatakanrinox4 = new ExDBFieldString<>("ztyhtnknkykdatakanrinox4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhtnknkykdatakanrinox5 = new ExDBFieldString<>("ztyhtnknkykdatakanrinox5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhtnknkykdatakanrinox6 = new ExDBFieldString<>("ztyhtnknkykdatakanrinox6", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykeiyakusyahoujinkbn = new ExDBFieldString<>("ztykeiyakusyahoujinkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin2x3 = new ExDBFieldString<>("ztysuuriyouyobin2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttidkhkttikekkacd = new ExDBFieldString<>("ztyhyujynkttidkhkttikekkacd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttidkhkttiryucdx1 = new ExDBFieldString<>("ztyhyujynkttidkhkttiryucdx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttidkhkttiryucdx2 = new ExDBFieldString<>("ztyhyujynkttidkhkttiryucdx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttidkhkttiryucdx3 = new ExDBFieldString<>("ztyhyujynkttidkhkttiryucdx3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttidkhkttiryucdx4 = new ExDBFieldString<>("ztyhyujynkttidkhkttiryucdx4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyhyujynkttiryumshyutn = new ExDBFieldNumber<>("ztyhyujynkttiryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttisakugenkkn = new ExDBFieldString<>("ztyhyujynkttisakugenkkn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztysppitkykryumshyutn = new ExDBFieldNumber<>("ztysppitkykryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttitktbuicdx1 = new ExDBFieldString<>("ztyhyujynkttitktbuicdx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttihutanpokknx1 = new ExDBFieldString<>("ztyhyujynkttihutanpokknx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttitktbuicdx2 = new ExDBFieldString<>("ztyhyujynkttitktbuicdx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhyujynkttihutanpokknx2 = new ExDBFieldString<>("ztyhyujynkttihutanpokknx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyoukentukitaisyoukbnx1 = new ExDBFieldString<>("ztyjyoukentukitaisyoukbnx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntksseigenhyjx1 = new ExDBFieldString<>("ztyjyukntksseigenhyjx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntktkyknozokihyjx1 = new ExDBFieldString<>("ztyjyukntktkyknozokihyjx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x8 = new ExDBFieldString<>("ztysuuriyouyobin1x8", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyjyoukentukiseigensx1 = new ExDBFieldNumber<>("ztyjyoukentukiseigensx1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyoukentukitaisyoukbnx2 = new ExDBFieldString<>("ztyjyoukentukitaisyoukbnx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntksseigenhyjx2 = new ExDBFieldString<>("ztyjyukntksseigenhyjx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntktkyknozokihyjx2 = new ExDBFieldString<>("ztyjyukntktkyknozokihyjx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x9 = new ExDBFieldString<>("ztysuuriyouyobin1x9", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyjyoukentukiseigensx2 = new ExDBFieldNumber<>("ztyjyoukentukiseigensx2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyoukentukitaisyoukbnx3 = new ExDBFieldString<>("ztyjyoukentukitaisyoukbnx3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntksseigenhyjx3 = new ExDBFieldString<>("ztyjyukntksseigenhyjx3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntktkyknozokihyjx3 = new ExDBFieldString<>("ztyjyukntktkyknozokihyjx3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x10 = new ExDBFieldString<>("ztysuuriyouyobin1x10", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyjyoukentukiseigensx3 = new ExDBFieldNumber<>("ztyjyoukentukiseigensx3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyoukentukitaisyoukbnx4 = new ExDBFieldString<>("ztyjyoukentukitaisyoukbnx4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntksseigenhyjx4 = new ExDBFieldString<>("ztyjyukntksseigenhyjx4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntktkyknozokihyjx4 = new ExDBFieldString<>("ztyjyukntktkyknozokihyjx4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x11 = new ExDBFieldString<>("ztysuuriyouyobin1x11", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyjyoukentukiseigensx4 = new ExDBFieldNumber<>("ztyjyoukentukiseigensx4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntkkigtiksyrihnkuhyj = new ExDBFieldString<>("ztyjyukntkkigtiksyrihnkuhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztypmensyuruihenkoukbn = new ExDBFieldString<>("ztypmensyuruihenkoukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyoukentukitaisyoukbn2x1 = new ExDBFieldString<>("ztyjyoukentukitaisyoukbn2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntksseigenhyj2x1 = new ExDBFieldString<>("ztyjyukntksseigenhyj2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntktkyknozokihyj2x1 = new ExDBFieldString<>("ztyjyukntktkyknozokihyj2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x12 = new ExDBFieldString<>("ztysuuriyouyobin1x12", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyjyoukentukiseigens2x1 = new ExDBFieldNumber<>("ztyjyoukentukiseigens2x1", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyoukentukitaisyoukbn2x2 = new ExDBFieldString<>("ztyjyoukentukitaisyoukbn2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntksseigenhyj2x2 = new ExDBFieldString<>("ztyjyukntksseigenhyj2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntktkyknozokihyj2x2 = new ExDBFieldString<>("ztyjyukntktkyknozokihyj2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x13 = new ExDBFieldString<>("ztysuuriyouyobin1x13", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyjyoukentukiseigens2x2 = new ExDBFieldNumber<>("ztyjyoukentukiseigens2x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyoukentukitaisyoukbn2x3 = new ExDBFieldString<>("ztyjyoukentukitaisyoukbn2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntksseigenhyj2x3 = new ExDBFieldString<>("ztyjyukntksseigenhyj2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntktkyknozokihyj2x3 = new ExDBFieldString<>("ztyjyukntktkyknozokihyj2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x14 = new ExDBFieldString<>("ztysuuriyouyobin1x14", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyjyoukentukiseigens2x3 = new ExDBFieldNumber<>("ztyjyoukentukiseigens2x3", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyoukentukitaisyoukbn2x4 = new ExDBFieldString<>("ztyjyoukentukitaisyoukbn2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntksseigenhyj2x4 = new ExDBFieldString<>("ztyjyukntksseigenhyj2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyjyukntktkyknozokihyj2x4 = new ExDBFieldString<>("ztyjyukntktkyknozokihyj2x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin1x15 = new ExDBFieldString<>("ztysuuriyouyobin1x15", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyjyoukentukiseigens2x4 = new ExDBFieldNumber<>("ztyjyoukentukiseigens2x4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztytktsppiryumshyutn = new ExDBFieldNumber<>("ztytktsppiryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytktsppiskgnkkn = new ExDBFieldString<>("ztytktsppiskgnkkn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztymnsiskknryumshyutn = new ExDBFieldNumber<>("ztymnsiskknryumshyutn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymanseisikkansakugenkikan = new ExDBFieldString<>("ztymanseisikkansakugenkikan", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymanseisikkantokuteibuicd = new ExDBFieldString<>("ztymanseisikkantokuteibuicd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztymanseisikkanhutanpokikan = new ExDBFieldString<>("ztymanseisikkanhutanpokikan", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysaihokenkbn = new ExDBFieldString<>("ztysaihokenkbn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyimustiyusbus = new ExDBFieldNumber<>("ztyimustiyusbus", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyimusateiyoujissituhsyus = new ExDBFieldNumber<>("ztyimusateiyoujissituhsyus", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyisahtnkngukijissituhsyus = new ExDBFieldNumber<>("ztyisahtnkngukijissituhsyus", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyimusateiyoutenkansagakus = new ExDBFieldNumber<>("ztyimusateiyoutenkansagakus", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyimusateiyouhanbaikirkbn = new ExDBFieldString<>("ztyimusateiyouhanbaikirkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyoyabosyuudairitencd = new ExDBFieldString<>("ztyoyabosyuudairitencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyoubosyuukeitaikbn = new ExDBFieldString<>("ztysuuriyoubosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhihokensyahokenage = new ExDBFieldString<>("ztyhihokensyahokenage", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyrendouyoumusntkkykhyj = new ExDBFieldString<>("ztyrendouyoumusntkkykhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv2x11 = new ExDBFieldString<>("ztyyobiv2x11", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin3x6 = new ExDBFieldNumber<>("ztyyobin3x6", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin9x4 = new ExDBFieldString<>("ztysuuriyouyobin9x4", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv1x20 = new ExDBFieldString<>("ztyyobiv1x20", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin5x7 = new ExDBFieldString<>("ztysuuriyouyobin5x7", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysindenzusyokensyousaicd = new ExDBFieldString<>("ztysindenzusyokensyousaicd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyimstiyuktekknsjsshyj = new ExDBFieldString<>("ztyimstiyuktekknsjsshyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensasekkekkyuusu = new ExDBFieldString<>("ztyketuekikensasekkekkyuusu", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyktekknsskkkkyususykncd = new ExDBFieldString<>("ztyktekknsskkkkyususykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensahakkekkyuusu = new ExDBFieldString<>("ztyketuekikensahakkekkyuusu", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyktekknshkkkkyususykncd = new ExDBFieldString<>("ztyktekknshkkkkyususykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyktekknsketusikisoryou = new ExDBFieldString<>("ztyktekknsketusikisoryou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyktekknsktsksryusyokencd = new ExDBFieldString<>("ztyktekknsktsksryusyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyktekknshematokuritto = new ExDBFieldString<>("ztyktekknshematokuritto", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyktekhmtkrttsykncd = new ExDBFieldString<>("ztyktekhmtkrttsykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyketuekikensakessyoubansu = new ExDBFieldString<>("ztyketuekikensakessyoubansu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyktekknskssyubnsusyokencd = new ExDBFieldString<>("ztyktekknskssyubnsusyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyktekknskssisutnpkryu = new ExDBFieldString<>("ztyktekknskssisutnpkryu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyktekkssisutnpkryusykncd = new ExDBFieldString<>("ztyktekkssisutnpkryusykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyketuekikensaarubumin = new ExDBFieldString<>("ztyketuekikensaarubumin", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyktekknsarubuminsyokencd = new ExDBFieldString<>("ztyktekknsarubuminsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyketuekikensaztt = new ExDBFieldString<>("ztyketuekikensaztt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensazttsyokencd = new ExDBFieldString<>("ztyketuekikensazttsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensagot = new ExDBFieldString<>("ztyketuekikensagot", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensagotsyokencd = new ExDBFieldString<>("ztyketuekikensagotsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensagpt = new ExDBFieldString<>("ztyketuekikensagpt", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensagptsyokencd = new ExDBFieldString<>("ztyketuekikensagptsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensaganmagtp = new ExDBFieldString<>("ztyketuekikensaganmagtp", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekiganmagtpsyokencd = new ExDBFieldString<>("ztyketuekiganmagtpsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensasouchol = new ExDBFieldString<>("ztyketuekikensasouchol", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekicholsyokencd = new ExDBFieldString<>("ztyketuekicholsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensahdlchol = new ExDBFieldString<>("ztyketuekikensahdlchol", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensahdlsyokencd = new ExDBFieldString<>("ztyketuekikensahdlsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyktekknstukhmgrbn = new ExDBFieldString<>("ztyktekknstukhmgrbn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyktekhmgrbnsykncd = new ExDBFieldString<>("ztyktekhmgrbnsykncd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyktekknskorinesuterrze = new ExDBFieldString<>("ztyktekknskorinesuterrze", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykorinesuterrzesyokencd = new ExDBFieldString<>("ztykorinesuterrzesyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyketuekikensamcv = new ExDBFieldString<>("ztyketuekikensamcv", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensamcvsyokencd = new ExDBFieldString<>("ztyketuekikensamcvsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyketuekikensamch = new ExDBFieldString<>("ztyketuekikensamch", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensamchsyokencd = new ExDBFieldString<>("ztyketuekikensamchsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyketuekikensamchc = new ExDBFieldString<>("ztyketuekikensamchc", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensamchcsyokencd = new ExDBFieldString<>("ztyketuekikensamchcsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyketuekikensacea = new ExDBFieldString<>("ztyketuekikensacea", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensaceasyokencd = new ExDBFieldString<>("ztyketuekikensaceasyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyketuekikensaafp = new ExDBFieldString<>("ztyketuekikensaafp", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensaafpsyokencd = new ExDBFieldString<>("ztyketuekikensaafpsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensahbskbn = new ExDBFieldString<>("ztyketuekikensahbskbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensahbssyokencd = new ExDBFieldString<>("ztyketuekikensahbssyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensahcvkbn = new ExDBFieldString<>("ztyketuekikensahcvkbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyketuekikensahcvsyokencd = new ExDBFieldString<>("ztyketuekikensahcvsyokencd", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyimusateiyouknsnsytryskbn = new ExDBFieldString<>("ztyimusateiyouknsnsytryskbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysyosinldlchol = new ExDBFieldString<>("ztysyosinldlchol", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyrendouyouosyukeiyakup = new ExDBFieldNumber<>("ztyrendouyouosyukeiyakup", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyrendouyougoukeitenkans = new ExDBFieldNumber<>("ztyrendouyougoukeitenkans", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyrnduyugukitnknkakaku = new ExDBFieldNumber<>("ztyrnduyugukitnknkakaku", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyrnduyuwnsgukitnknkakaku = new ExDBFieldNumber<>("ztyrnduyuwnsgukitnknkakaku", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztymostnknkhnbbnjyuturt = new ExDBFieldString<>("ztymostnknkhnbbnjyuturt", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyrnduyusykykbbnkhns = new ExDBFieldNumber<>("ztyrnduyusykykbbnkhns", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztyrendouyouyoteiriritu = new ExDBFieldString<>("ztyrendouyouyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv121 = new ExDBFieldString<>("ztyyobiv121", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztygaikadatekihons = new ExDBFieldNumber<>("ztygaikadatekihons", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztygaikadatesibous = new ExDBFieldNumber<>("ztygaikadatesibous", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, BizNumber> ztykawaserate = new ExDBFieldString<>("ztykawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin8 = new ExDBFieldString<>("ztysuuriyouyobin8", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztysuuriyouyobin10x2 = new ExDBFieldString<>("ztysuuriyouyobin10x2", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv10x4 = new ExDBFieldString<>("ztyyobiv10x4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin7 = new ExDBFieldNumber<>("ztyyobin7", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin7x2 = new ExDBFieldNumber<>("ztyyobin7x2", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin7x3 = new ExDBFieldNumber<>("ztyyobin7x3", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin7x4 = new ExDBFieldNumber<>("ztyyobin7x4", this);

    public final ExDBFieldNumber<ZT_SbRituRendouTy, Integer> ztyyobin7x5 = new ExDBFieldNumber<>("ztyyobin7x5", this);

    public final ExDBFieldString<ZT_SbRituRendouTy, String> ztyyobiv4x2 = new ExDBFieldString<>("ztyyobiv4x2", this);
}
