package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu1Ty;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＳＰ２連動用総成立Fテーブル１（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Sp2RnduyuSouseiritu1Ty extends AbstractExDBTable<ZT_Sp2RnduyuSouseiritu1Ty> {

    public GenQZT_Sp2RnduyuSouseiritu1Ty() {
        this("ZT_Sp2RnduyuSouseiritu1Ty");
    }

    public GenQZT_Sp2RnduyuSouseiritu1Ty(String pAlias) {
        super("ZT_Sp2RnduyuSouseiritu1Ty", ZT_Sp2RnduyuSouseiritu1Ty.class, pAlias);
    }

    public String ZT_Sp2RnduyuSouseiritu1Ty() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyktgysyrymd = new ExDBFieldString<>("ztyktgysyrymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyktgysyono = new ExDBFieldString<>("ztyktgysyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyktgyfilerenno = new ExDBFieldString<>("ztyktgyfilerenno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyaatukaisyasisyacd = new ExDBFieldString<>("ztyaatukaisyasisyacd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymosno = new ExDBFieldString<>("ztymosno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykihons = new ExDBFieldNumber<>("ztykihons", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygyousekihyoukayouhosyous = new ExDBFieldNumber<>("ztygyousekihyoukayouhosyous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnknitjbrkhns = new ExDBFieldNumber<>("ztygukitnknitjbrkhns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnknitjbrsbus = new ExDBFieldNumber<>("ztygukitnknitjbrsbus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykktijgukitnknitjbrkhns = new ExDBFieldNumber<>("ztykktijgukitnknitjbrkhns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykktijgukitnknitjbrsbus = new ExDBFieldNumber<>("ztykktijgukitnknitjbrsbus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysyokaiharaikomip = new ExDBFieldNumber<>("ztysyokaiharaikomip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyryouritukbn = new ExDBFieldString<>("ztyryouritukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytksyuannaikykkbn = new ExDBFieldString<>("ztytksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysdpdkbn = new ExDBFieldString<>("ztysdpdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyduketorihouhoukbn = new ExDBFieldString<>("ztyduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykyksyhhknsydouituhyouji = new ExDBFieldString<>("ztykyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykyksyakikykarihyj = new ExDBFieldString<>("ztykyksyakikykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytenkankeiyakuhyouji = new ExDBFieldString<>("ztytenkankeiyakuhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyjigyoukeiyakuhyouji = new ExDBFieldString<>("ztyjigyoukeiyakuhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynenkinzeiseitokuyakukbn = new ExDBFieldString<>("ztynenkinzeiseitokuyakukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyusseimaekanyuukykkbn = new ExDBFieldString<>("ztysyusseimaekanyuukykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokukeiyakuhyouji = new ExDBFieldString<>("ztykazokukeiyakuhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyjikokykhyj = new ExDBFieldString<>("ztyjikokykhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytuusyoumeisiyouhyouji = new ExDBFieldString<>("ztytuusyoumeisiyouhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysethokenkbn = new ExDBFieldString<>("ztysethokenkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteikeisyouhinkbn = new ExDBFieldString<>("ztyteikeisyouhinkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztytokuninbosyuuteate = new ExDBFieldNumber<>("ztytokuninbosyuuteate", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseisekiym = new ExDBFieldString<>("ztyseisekiym", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyseisekikeijyousyuuseis = new ExDBFieldNumber<>("ztyseisekikeijyousyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyuuseissakugenhyouji = new ExDBFieldString<>("ztysyuuseissakugenhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyaatukaisisyatodouhukencd = new ExDBFieldString<>("ztyaatukaisisyatodouhukencd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyaatukaisosikicd = new ExDBFieldString<>("ztyaatukaisosikicd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyaatukaikojincd = new ExDBFieldString<>("ztyaatukaikojincd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztybatukaisosikicd = new ExDBFieldString<>("ztybatukaisosikicd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztybatukaisyakojincd = new ExDBFieldString<>("ztybatukaisyakojincd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymarutokukbn = new ExDBFieldString<>("ztymarutokukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztygyoumujyouhyouji = new ExDBFieldString<>("ztygyoumujyouhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytuikakeijyoukbn = new ExDBFieldString<>("ztytuikakeijyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseisekinomikeijyoukbn = new ExDBFieldString<>("ztyseisekinomikeijyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteikikeijyoukbn = new ExDBFieldString<>("ztyteikikeijyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhngkmskkatkisykbn = new ExDBFieldString<>("ztyhngkmskkatkisykbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytnknkyuuyosakugenhyj = new ExDBFieldString<>("ztytnknkyuuyosakugenhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytenkankaisuu = new ExDBFieldString<>("ztytenkankaisuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhiyubrigssnsikkijyunkbn = new ExDBFieldString<>("ztyhiyubrigssnsikkijyunkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysekininkaisiymd = new ExDBFieldString<>("ztysekininkaisiymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykigetusmkrgkykhyj = new ExDBFieldString<>("ztykigetusmkrgkykhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhensyuusyoriymd = new ExDBFieldString<>("ztyhensyuusyoriymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyjisisyaatukaihyouji = new ExDBFieldString<>("ztyjisisyaatukaihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyaatkisytktntusy1atkihyj = new ExDBFieldString<>("ztyaatkisytktntusy1atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyaatkisytktntusy2atkihyj = new ExDBFieldString<>("ztyaatkisytktntusy2atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyaatkisyasyokan1atkihyj = new ExDBFieldString<>("ztyaatkisyasyokan1atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyaatkisyasyokan2atkihyj = new ExDBFieldString<>("ztyaatkisyasyokan2atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztybatkisytktntusy1atkihyj = new ExDBFieldString<>("ztybatkisytktntusy1atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztybatkisytktntusy2atkihyj = new ExDBFieldString<>("ztybatkisytktntusy2atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztybatkisyasyokan1atkihyj = new ExDBFieldString<>("ztybatkisyasyokan1atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztybatkisyasyokan2atkihyj = new ExDBFieldString<>("ztybatkisyasyokan2atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykeizokutyuuihyouji = new ExDBFieldString<>("ztykeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykeiyakubisiteihyouji = new ExDBFieldString<>("ztykeiyakubisiteihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyjyoukentukihyouji = new ExDBFieldString<>("ztyjyoukentukihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytokuninhyouji = new ExDBFieldString<>("ztytokuninhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykessantyouseikbn = new ExDBFieldString<>("ztykessantyouseikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhaneihyouji = new ExDBFieldString<>("ztyhaneihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyukinkbn = new ExDBFieldString<>("ztysyukinkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykeiyakusyasyokugyoucd = new ExDBFieldString<>("ztykeiyakusyasyokugyoucd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseikeikeirokbn = new ExDBFieldString<>("ztyseikeikeirokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2seikeikeirokbn = new ExDBFieldString<>("ztydai2seikeikeirokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteigentokuteisyuruikigou = new ExDBFieldString<>("ztyteigentokuteisyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteigentokuteikikan = new ExDBFieldString<>("ztyteigentokuteikikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyteigentokuteis = new ExDBFieldNumber<>("ztyteigentokuteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyteigentokuteip = new ExDBFieldNumber<>("ztyteigentokuteip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytigntktisdtpdtkbn = new ExDBFieldString<>("ztytigntktisdtpdtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyteigentokuteisyuuseis = new ExDBFieldNumber<>("ztyteigentokuteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteigentktimodssakugenhyj = new ExDBFieldString<>("ztyteigentktimodssakugenhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteigentktikgusdkbn = new ExDBFieldString<>("ztyteigentktikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytokuteibuicdx1 = new ExDBFieldString<>("ztytokuteibuicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnpkknx1 = new ExDBFieldString<>("ztyhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytokuteibuicdx2 = new ExDBFieldString<>("ztytokuteibuicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnpkknx2 = new ExDBFieldString<>("ztyhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhhknmei = new ExDBFieldString<>("ztyhhknmei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyknjhhknmei = new ExDBFieldString<>("ztyknjhhknmei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhhknhnsktodouhukencd = new ExDBFieldString<>("ztyhhknhnsktodouhukencd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhihokensyakikykarihyj = new ExDBFieldString<>("ztyhihokensyakikykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynobikkosaimankikbn = new ExDBFieldString<>("ztynobikkosaimankikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhhknsysysnhonninkknnkbn = new ExDBFieldString<>("ztyhhknsysysnhonninkknnkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhhknsysisnhonninkknnkbn = new ExDBFieldString<>("ztyhhknsysisnhonninkknnkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzktourokuservicearihyj = new ExDBFieldString<>("ztykzktourokuservicearihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x12 = new ExDBFieldString<>("ztyyobiv4x12", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhensyuukeiyakusyamei = new ExDBFieldString<>("ztyhensyuukeiyakusyamei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhnsyuknjkyksynm = new ExDBFieldString<>("ztyhnsyuknjkyksynm", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykyksyaseiymd = new ExDBFieldString<>("ztykyksyaseiymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykyksyaseikbn = new ExDBFieldString<>("ztykyksyaseikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyvitdoujimos2kenmeikouhyj = new ExDBFieldString<>("ztyvitdoujimos2kenmeikouhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykikykvitarituikamoshyj = new ExDBFieldString<>("ztykikykvitarituikamoshyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykvithokenkbn = new ExDBFieldString<>("ztyhtnknkykvithokenkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykikykvithokenhoyuujkkbn = new ExDBFieldString<>("ztykikykvithokenhoyuujkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv2x2 = new ExDBFieldString<>("ztyyobiv2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytsnsknewyno = new ExDBFieldString<>("ztytsnsknewyno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytsnsknewtikucd = new ExDBFieldString<>("ztytsnsknewtikucd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymossyumtkktymd = new ExDBFieldString<>("ztymossyumtkktymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykituenkbn = new ExDBFieldString<>("ztykituenkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytuusinsakijyuusyokbn = new ExDBFieldString<>("ztytuusinsakijyuusyokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruteisyuruikigou = new ExDBFieldString<>("ztymaruteisyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruteikikan = new ExDBFieldString<>("ztymaruteikikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruteiphrkkkn = new ExDBFieldString<>("ztymaruteiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymaruteis = new ExDBFieldNumber<>("ztymaruteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymaruteip = new ExDBFieldNumber<>("ztymaruteip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymaruteisyuuseis = new ExDBFieldNumber<>("ztymaruteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruteisyuuseisskgnhyj = new ExDBFieldString<>("ztymaruteisyuuseisskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruteitokujyoukbn = new ExDBFieldString<>("ztymaruteitokujyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymrtitkjyuskgnkkn = new ExDBFieldString<>("ztymrtitkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztymrtitkjyuryumshyutn = new ExDBFieldNumber<>("ztymrtitkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymaruteitokujyoup = new ExDBFieldNumber<>("ztymaruteitokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysuryumrtipwrbkkbn = new ExDBFieldString<>("ztysuryumrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruteipwaribikikbn = new ExDBFieldString<>("ztymaruteipwaribikikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymrtitnknyugukbn = new ExDBFieldString<>("ztymrtitnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruteikigousedaikbn = new ExDBFieldString<>("ztymaruteikigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruteikikousnmnryoage = new ExDBFieldString<>("ztymaruteikikousnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruyousyuruikigou = new ExDBFieldString<>("ztymaruyousyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruyoukikan = new ExDBFieldString<>("ztymaruyoukikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymaruyous = new ExDBFieldNumber<>("ztymaruyous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymaruyoup = new ExDBFieldNumber<>("ztymaruyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruyousdatepdatekbn = new ExDBFieldString<>("ztymaruyousdatepdatekbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymaruyousyuuseis = new ExDBFieldNumber<>("ztymaruyousyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruyousyuuseisskgnhyj = new ExDBFieldString<>("ztymaruyousyuuseisskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymaruyoukigousedaikbn = new ExDBFieldString<>("ztymaruyoukigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv9x3 = new ExDBFieldString<>("ztyyobiv9x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymarusyuusyuruikigou = new ExDBFieldString<>("ztymarusyuusyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymarusyuukikan = new ExDBFieldString<>("ztymarusyuukikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymarusyuus = new ExDBFieldNumber<>("ztymarusyuus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymarusyuup = new ExDBFieldNumber<>("ztymarusyuup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymarusyuusdatepdatekbn = new ExDBFieldString<>("ztymarusyuusdatepdatekbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztymarusyuusyuuseis = new ExDBFieldNumber<>("ztymarusyuusyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymarusyuusyuuseisskgnhyj = new ExDBFieldString<>("ztymarusyuusyuuseisskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymarusyuukigousedaikbn = new ExDBFieldString<>("ztymarusyuukigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv9x4 = new ExDBFieldString<>("ztyyobiv9x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytokuteisyuruikigou = new ExDBFieldString<>("ztytokuteisyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytokuteikikan = new ExDBFieldString<>("ztytokuteikikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztytokuteis = new ExDBFieldNumber<>("ztytokuteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztytokuteip = new ExDBFieldNumber<>("ztytokuteip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytokuteisdatepdatekbn = new ExDBFieldString<>("ztytokuteisdatepdatekbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztytokuteisyuuseis = new ExDBFieldNumber<>("ztytokuteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytokuteisyuuseisskgnhyj = new ExDBFieldString<>("ztytokuteisyuuseisskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytokuteikigousedaikbn = new ExDBFieldString<>("ztytokuteikigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv9x5 = new ExDBFieldString<>("ztyyobiv9x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox1 = new ExDBFieldString<>("ztykzkmrtitkyknox1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux1 = new ExDBFieldString<>("ztykazokumrtisyuruikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx1 = new ExDBFieldString<>("ztykazokumaruteikikanx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx1 = new ExDBFieldString<>("ztykazokumrtiphrkkknx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx1 = new ExDBFieldNumber<>("ztykazokumaruteisx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx1 = new ExDBFieldNumber<>("ztykazokumaruteipx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx1 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx1 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx1 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex1 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx1 = new ExDBFieldNumber<>("ztykzkmrtimodsx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx1 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx1 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx1 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx1 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex1 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox2 = new ExDBFieldString<>("ztykzkmrtitkyknox2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux2 = new ExDBFieldString<>("ztykazokumrtisyuruikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx2 = new ExDBFieldString<>("ztykazokumaruteikikanx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx2 = new ExDBFieldString<>("ztykazokumrtiphrkkknx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx2 = new ExDBFieldNumber<>("ztykazokumaruteisx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx2 = new ExDBFieldNumber<>("ztykazokumaruteipx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx2 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx2 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx2 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex2 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx2 = new ExDBFieldNumber<>("ztykzkmrtimodsx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx2 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx2 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx2 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx2 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex2 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x2 = new ExDBFieldString<>("ztyyobiv4x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox3 = new ExDBFieldString<>("ztykzkmrtitkyknox3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux3 = new ExDBFieldString<>("ztykazokumrtisyuruikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx3 = new ExDBFieldString<>("ztykazokumaruteikikanx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx3 = new ExDBFieldString<>("ztykazokumrtiphrkkknx3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx3 = new ExDBFieldNumber<>("ztykazokumaruteisx3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx3 = new ExDBFieldNumber<>("ztykazokumaruteipx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx3 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx3 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx3 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex3 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx3 = new ExDBFieldNumber<>("ztykzkmrtimodsx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx3 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx3 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx3 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx3 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex3 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x3 = new ExDBFieldString<>("ztyyobiv4x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox4 = new ExDBFieldString<>("ztykzkmrtitkyknox4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux4 = new ExDBFieldString<>("ztykazokumrtisyuruikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx4 = new ExDBFieldString<>("ztykazokumaruteikikanx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx4 = new ExDBFieldString<>("ztykazokumrtiphrkkknx4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx4 = new ExDBFieldNumber<>("ztykazokumaruteisx4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx4 = new ExDBFieldNumber<>("ztykazokumaruteipx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx4 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx4 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx4 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex4 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx4 = new ExDBFieldNumber<>("ztykzkmrtimodsx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx4 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx4 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx4 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx4 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex4 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x4 = new ExDBFieldString<>("ztyyobiv4x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox5 = new ExDBFieldString<>("ztykzkmrtitkyknox5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux5 = new ExDBFieldString<>("ztykazokumrtisyuruikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx5 = new ExDBFieldString<>("ztykazokumaruteikikanx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx5 = new ExDBFieldString<>("ztykazokumrtiphrkkknx5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx5 = new ExDBFieldNumber<>("ztykazokumaruteisx5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx5 = new ExDBFieldNumber<>("ztykazokumaruteipx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx5 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx5 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx5 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex5 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx5 = new ExDBFieldNumber<>("ztykzkmrtimodsx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx5 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx5 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx5 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx5 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex5 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x5 = new ExDBFieldString<>("ztyyobiv4x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox6 = new ExDBFieldString<>("ztykzkmrtitkyknox6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux6 = new ExDBFieldString<>("ztykazokumrtisyuruikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx6 = new ExDBFieldString<>("ztykazokumaruteikikanx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx6 = new ExDBFieldString<>("ztykazokumrtiphrkkknx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx6 = new ExDBFieldNumber<>("ztykazokumaruteisx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx6 = new ExDBFieldNumber<>("ztykazokumaruteipx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx6 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx6 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx6 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex6 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx6 = new ExDBFieldNumber<>("ztykzkmrtimodsx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx6 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx6 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx6 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx6 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex6 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x6 = new ExDBFieldString<>("ztyyobiv4x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox7 = new ExDBFieldString<>("ztykzkmrtitkyknox7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux7 = new ExDBFieldString<>("ztykazokumrtisyuruikgux7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx7 = new ExDBFieldString<>("ztykazokumaruteikikanx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx7 = new ExDBFieldString<>("ztykazokumrtiphrkkknx7", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx7 = new ExDBFieldNumber<>("ztykazokumaruteisx7", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx7 = new ExDBFieldNumber<>("ztykazokumaruteipx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx7 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx7 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx7 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex7 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex7", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx7 = new ExDBFieldNumber<>("ztykzkmrtimodsx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx7 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx7 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx7 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx7 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex7 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x7 = new ExDBFieldString<>("ztyyobiv4x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox8 = new ExDBFieldString<>("ztykzkmrtitkyknox8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux8 = new ExDBFieldString<>("ztykazokumrtisyuruikgux8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx8 = new ExDBFieldString<>("ztykazokumaruteikikanx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx8 = new ExDBFieldString<>("ztykazokumrtiphrkkknx8", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx8 = new ExDBFieldNumber<>("ztykazokumaruteisx8", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx8 = new ExDBFieldNumber<>("ztykazokumaruteipx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx8 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx8 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx8 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex8 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex8", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx8 = new ExDBFieldNumber<>("ztykzkmrtimodsx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx8 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx8 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx8 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx8 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex8 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x8 = new ExDBFieldString<>("ztyyobiv4x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox9 = new ExDBFieldString<>("ztykzkmrtitkyknox9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux9 = new ExDBFieldString<>("ztykazokumrtisyuruikgux9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx9 = new ExDBFieldString<>("ztykazokumaruteikikanx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx9 = new ExDBFieldString<>("ztykazokumrtiphrkkknx9", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx9 = new ExDBFieldNumber<>("ztykazokumaruteisx9", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx9 = new ExDBFieldNumber<>("ztykazokumaruteipx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx9 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx9 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx9 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex9 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex9", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx9 = new ExDBFieldNumber<>("ztykzkmrtimodsx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx9 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx9 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx9 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx9 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex9 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x9 = new ExDBFieldString<>("ztyyobiv4x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitkyknox10 = new ExDBFieldString<>("ztykzkmrtitkyknox10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtisyuruikgux10 = new ExDBFieldString<>("ztykazokumrtisyuruikgux10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumaruteikikanx10 = new ExDBFieldString<>("ztykazokumaruteikikanx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiphrkkknx10 = new ExDBFieldString<>("ztykazokumrtiphrkkknx10", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteisx10 = new ExDBFieldNumber<>("ztykazokumaruteisx10", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykazokumaruteipx10 = new ExDBFieldNumber<>("ztykazokumaruteipx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyanmx10 = new ExDBFieldString<>("ztykzkmrtihihknsyanmx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsyseiymdx10 = new ExDBFieldString<>("ztykzkmrtihihknsyseiymdx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtihihknsysibtkbnx10 = new ExDBFieldString<>("ztykzkmrtihihknsysibtkbnx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtihihknsyaagex10 = new ExDBFieldString<>("ztykazokumrtihihknsyaagex10", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykzkmrtimodsx10 = new ExDBFieldNumber<>("ztykzkmrtimodsx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtimodsskgnhyjx10 = new ExDBFieldString<>("ztykazokumrtimodsskgnhyjx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtitnknyugukbnx10 = new ExDBFieldString<>("ztykzkmrtitnknyugukbnx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtikgusdkbnx10 = new ExDBFieldString<>("ztykazokumrtikgusdkbnx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykazokumrtiagetyusihyjx10 = new ExDBFieldString<>("ztykazokumrtiagetyusihyjx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykzkmrtikusnmnryoagex10 = new ExDBFieldString<>("ztykzkmrtikusnmnryoagex10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x10 = new ExDBFieldString<>("ztyyobiv4x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynkshrtkykhuhokbnx1 = new ExDBFieldString<>("ztynkshrtkykhuhokbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynkshrtkyknksyuruikbnx1 = new ExDBFieldString<>("ztynkshrtkyknksyuruikbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynkshrtkyknkkknx1 = new ExDBFieldString<>("ztynkshrtkyknkkknx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztynkshrtkyknknengkx1 = new ExDBFieldNumber<>("ztynkshrtkyknknengkx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynkshrtkykduketorihhkbnx1 = new ExDBFieldString<>("ztynkshrtkykduketorihhkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynkshrtkykhuhokbnx2 = new ExDBFieldString<>("ztynkshrtkykhuhokbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynkshrtkyknksyuruikbnx2 = new ExDBFieldString<>("ztynkshrtkyknksyuruikbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynkshrtkyknkkknx2 = new ExDBFieldString<>("ztynkshrtkyknkkknx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztynkshrtkyknknengkx2 = new ExDBFieldNumber<>("ztynkshrtkyknknengkx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztynkshrtkykduketorihhkbnx2 = new ExDBFieldString<>("ztynkshrtkykduketorihhkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv10x2 = new ExDBFieldString<>("ztyyobiv10x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyougaitkyksyuruikgu = new ExDBFieldString<>("ztysyougaitkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyougaitokuyakukikan = new ExDBFieldString<>("ztysyougaitokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyougaitkykphrkkkn = new ExDBFieldString<>("ztysyougaitkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysyougaitokuyakus = new ExDBFieldNumber<>("ztysyougaitokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysyougaitokuyakup = new ExDBFieldNumber<>("ztysyougaitokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyougaitkkatakbn = new ExDBFieldString<>("ztysyougaitkkatakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyougaitkykkgusdkbn = new ExDBFieldString<>("ztysyougaitkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyugitkykpwrbkkbn = new ExDBFieldString<>("ztysyugitkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyougaitkykkusnmnryoage = new ExDBFieldString<>("ztysyougaitkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv5x2 = new ExDBFieldString<>("ztyyobiv5x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysigiwrmstkyksyuruikgu = new ExDBFieldString<>("ztysigiwrmstkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysigiwrmstkykkkn = new ExDBFieldString<>("ztysigiwrmstkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysaigaiwrmstkykphrkkkn = new ExDBFieldString<>("ztysaigaiwrmstkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysaigaiwarimasitokuyakus = new ExDBFieldNumber<>("ztysaigaiwarimasitokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysaigaiwarimasitokuyakup = new ExDBFieldNumber<>("ztysaigaiwarimasitokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysaigaiwrmstkykkgusdkbn = new ExDBFieldString<>("ztysaigaiwrmstkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysigiwrmstkykpwrbkkbn = new ExDBFieldString<>("ztysigiwrmstkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysigiwrmstkykkusnmnryoage = new ExDBFieldString<>("ztysigiwrmstkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv5x3 = new ExDBFieldString<>("ztyyobiv5x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysiginyuintkyksyuruikgu = new ExDBFieldString<>("ztysiginyuintkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysiginyuintkykkkn = new ExDBFieldString<>("ztysiginyuintkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysaigainyuintkykphrkkkn = new ExDBFieldString<>("ztysaigainyuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztysiginyuintkykntgk = new ExDBFieldNumber<>("ztysiginyuintkykntgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysiginyuintkykgtkbn = new ExDBFieldString<>("ztysiginyuintkykgtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysaigainyuuintokuyakup = new ExDBFieldNumber<>("ztysaigainyuuintokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysaigainyuintkykkgusdkbn = new ExDBFieldString<>("ztysaigainyuintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysiginyuintkykpwrbkkbn = new ExDBFieldString<>("ztysiginyuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv7 = new ExDBFieldString<>("ztyyobiv7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuintkyksyuruikgu = new ExDBFieldString<>("ztysppinyuintkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuintkykkkn = new ExDBFieldString<>("ztysppinyuintkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuuintkykphrkkkn = new ExDBFieldString<>("ztysppinyuuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztysppinyuintkykntgk = new ExDBFieldNumber<>("ztysppinyuintkykntgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuintkykgtkbn = new ExDBFieldString<>("ztysppinyuintkykgtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysippeinyuuintokuyakup = new ExDBFieldNumber<>("ztysippeinyuuintokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztysppinyuintkjyuryumshyutn = new ExDBFieldNumber<>("ztysppinyuintkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysippeinyuuintokujyoup = new ExDBFieldNumber<>("ztysippeinyuuintokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuintktbicdx1 = new ExDBFieldString<>("ztysppinyuintktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuinhtnpkknx1 = new ExDBFieldString<>("ztysppinyuinhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuintktbicdx2 = new ExDBFieldString<>("ztysppinyuintktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuinhtnpkknx2 = new ExDBFieldString<>("ztysppinyuinhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuuintkykkgusdkbn = new ExDBFieldString<>("ztysppinyuuintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysppinyuintkykpwrbkkbn = new ExDBFieldString<>("ztysppinyuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv7x2 = new ExDBFieldString<>("ztyyobiv7x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysijnbyutkyksyuruikgu = new ExDBFieldString<>("ztysijnbyutkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseijinbyoutokuyakukikan = new ExDBFieldString<>("ztyseijinbyoutokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseijinbyoutkykphrkkkn = new ExDBFieldString<>("ztyseijinbyoutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyseijinbyoutokuyakuntgk = new ExDBFieldNumber<>("ztyseijinbyoutokuyakuntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyseijinbyoutokuyakup = new ExDBFieldNumber<>("ztyseijinbyoutokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztysijnbyutkjyuryumshyutn = new ExDBFieldNumber<>("ztysijnbyutkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyseijinbyoutokujyoup = new ExDBFieldNumber<>("ztyseijinbyoutokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseijinbyoutokuteibuicdx1 = new ExDBFieldString<>("ztyseijinbyoutokuteibuicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseijinbyouhutanpokikanx1 = new ExDBFieldString<>("ztyseijinbyouhutanpokikanx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseijinbyoutokuteibuicdx2 = new ExDBFieldString<>("ztyseijinbyoutokuteibuicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseijinbyouhutanpokikanx2 = new ExDBFieldString<>("ztyseijinbyouhutanpokikanx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseijinbyoutkykkgusdkbn = new ExDBFieldString<>("ztyseijinbyoutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysijnbyutkykgankyuhgtkbn = new ExDBFieldString<>("ztysijnbyutkykgankyuhgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysijnbyutkykpwrbkkbn = new ExDBFieldString<>("ztysijnbyutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysijnbyutkykkusnmnryoage = new ExDBFieldString<>("ztysijnbyutkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv4x11 = new ExDBFieldString<>("ztyyobiv4x11", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyheiyoubaraikbn = new ExDBFieldString<>("ztyheiyoubaraikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhiyubriaitsyono = new ExDBFieldString<>("ztyhiyubriaitsyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhiyubriaithrkkeirokbn = new ExDBFieldString<>("ztyhiyubriaithrkkeirokbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyheiyoubaraiaitekihons = new ExDBFieldNumber<>("ztyheiyoubaraiaitekihons", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyhiyubrigukitnknitjbrkhns = new ExDBFieldNumber<>("ztyhiyubrigukitnknitjbrkhns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyheiyoubaraiaitesibous = new ExDBFieldNumber<>("ztyheiyoubaraiaitesibous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyhiyubrigukitnknitjbrsbus = new ExDBFieldNumber<>("ztyhiyubrigukitnknitjbrsbus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyheiyoubaraiaitesyuuseis = new ExDBFieldNumber<>("ztyheiyoubaraiaitesyuuseis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyheiyoubaraiaitehrkp = new ExDBFieldNumber<>("ztyheiyoubaraiaitehrkp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyhiyubriaitsykykp = new ExDBFieldNumber<>("ztyhiyubriaitsykykp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyheiyoubaraiaitemrtis = new ExDBFieldNumber<>("ztyheiyoubaraiaitemrtis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyhiyubrigukiaitkzkmrtis = new ExDBFieldNumber<>("ztyhiyubrigukiaitkzkmrtis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytukibaraikyktenkanhyj = new ExDBFieldString<>("ztytukibaraikyktenkanhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztybonusharaihrkkigetu1 = new ExDBFieldString<>("ztybonusharaihrkkigetu1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztybonusharaihrkkigetu2 = new ExDBFieldString<>("ztybonusharaihrkkigetu2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyhiyubriaitsiznmrtis = new ExDBFieldNumber<>("ztyhiyubriaitsiznmrtis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyhiyubriaittignmrtis = new ExDBFieldNumber<>("ztyhiyubriaittignmrtis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysakugenkikan = new ExDBFieldString<>("ztysakugenkikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyryoumasihyouten = new ExDBFieldNumber<>("ztyryoumasihyouten", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztytokujyoup = new ExDBFieldNumber<>("ztytokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhjncd = new ExDBFieldString<>("ztyhjncd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhjnjigyosyocd = new ExDBFieldString<>("ztyhjnjigyosyocd", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyjyuugyouinsuu = new ExDBFieldNumber<>("ztyjyuugyouinsuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyiktkaisuu = new ExDBFieldString<>("ztyiktkaisuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyznnkai = new ExDBFieldString<>("ztyznnkai", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykyktsnatkitkykkbn = new ExDBFieldString<>("ztykyktsnatkitkykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykyktsnatkitkykstagekbn = new ExDBFieldString<>("ztykyktsnatkitkykstagekbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztypmentokuyakukbn = new ExDBFieldString<>("ztypmentokuyakukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztytkykznnunyukngk = new ExDBFieldNumber<>("ztytkykznnunyukngk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyokaipnyuukinhouhoukbn = new ExDBFieldString<>("ztysyokaipnyuukinhouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksyonox1 = new ExDBFieldString<>("ztyhtnknkyksyonox1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknsyuruikgux1 = new ExDBFieldString<>("ztyhtnknkykhknsyuruikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytenkanuketukeymdx1 = new ExDBFieldString<>("ztytenkanuketukeymdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykkykymdx1 = new ExDBFieldString<>("ztyhtnknkykkykymdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknkknx1 = new ExDBFieldString<>("ztyhtnknkykhknkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykphrkkknx1 = new ExDBFieldString<>("ztyhtnknkykphrkkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkaisuukbnx1 = new ExDBFieldString<>("ztyhtnknkykhrkkaisuukbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkeirokbnx1 = new ExDBFieldString<>("ztyhtnknkykhrkkeirokbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytnknuktkzngtkijyuhyjx1 = new ExDBFieldString<>("ztytnknuktkzngtkijyuhyjx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykmrtisyuruikgux1 = new ExDBFieldString<>("ztyhtnknkykmrtisyuruikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksyonox2 = new ExDBFieldString<>("ztyhtnknkyksyonox2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknsyuruikgux2 = new ExDBFieldString<>("ztyhtnknkykhknsyuruikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytenkanuketukeymdx2 = new ExDBFieldString<>("ztytenkanuketukeymdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykkykymdx2 = new ExDBFieldString<>("ztyhtnknkykkykymdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknkknx2 = new ExDBFieldString<>("ztyhtnknkykhknkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykphrkkknx2 = new ExDBFieldString<>("ztyhtnknkykphrkkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkaisuukbnx2 = new ExDBFieldString<>("ztyhtnknkykhrkkaisuukbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkeirokbnx2 = new ExDBFieldString<>("ztyhtnknkykhrkkeirokbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytnknuktkzngtkijyuhyjx2 = new ExDBFieldString<>("ztytnknuktkzngtkijyuhyjx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykmrtisyuruikgux2 = new ExDBFieldString<>("ztyhtnknkykmrtisyuruikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksyonox3 = new ExDBFieldString<>("ztyhtnknkyksyonox3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknsyuruikgux3 = new ExDBFieldString<>("ztyhtnknkykhknsyuruikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytenkanuketukeymdx3 = new ExDBFieldString<>("ztytenkanuketukeymdx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykkykymdx3 = new ExDBFieldString<>("ztyhtnknkykkykymdx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknkknx3 = new ExDBFieldString<>("ztyhtnknkykhknkknx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykphrkkknx3 = new ExDBFieldString<>("ztyhtnknkykphrkkknx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkaisuukbnx3 = new ExDBFieldString<>("ztyhtnknkykhrkkaisuukbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkeirokbnx3 = new ExDBFieldString<>("ztyhtnknkykhrkkeirokbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytnknuktkzngtkijyuhyjx3 = new ExDBFieldString<>("ztytnknuktkzngtkijyuhyjx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykmrtisyuruikgux3 = new ExDBFieldString<>("ztyhtnknkykmrtisyuruikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksyonox4 = new ExDBFieldString<>("ztyhtnknkyksyonox4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknsyuruikgux4 = new ExDBFieldString<>("ztyhtnknkykhknsyuruikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytenkanuketukeymdx4 = new ExDBFieldString<>("ztytenkanuketukeymdx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykkykymdx4 = new ExDBFieldString<>("ztyhtnknkykkykymdx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknkknx4 = new ExDBFieldString<>("ztyhtnknkykhknkknx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykphrkkknx4 = new ExDBFieldString<>("ztyhtnknkykphrkkknx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkaisuukbnx4 = new ExDBFieldString<>("ztyhtnknkykhrkkaisuukbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkeirokbnx4 = new ExDBFieldString<>("ztyhtnknkykhrkkeirokbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytnknuktkzngtkijyuhyjx4 = new ExDBFieldString<>("ztytnknuktkzngtkijyuhyjx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykmrtisyuruikgux4 = new ExDBFieldString<>("ztyhtnknkykmrtisyuruikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksyonox5 = new ExDBFieldString<>("ztyhtnknkyksyonox5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknsyuruikgux5 = new ExDBFieldString<>("ztyhtnknkykhknsyuruikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytenkanuketukeymdx5 = new ExDBFieldString<>("ztytenkanuketukeymdx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykkykymdx5 = new ExDBFieldString<>("ztyhtnknkykkykymdx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknkknx5 = new ExDBFieldString<>("ztyhtnknkykhknkknx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykphrkkknx5 = new ExDBFieldString<>("ztyhtnknkykphrkkknx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkaisuukbnx5 = new ExDBFieldString<>("ztyhtnknkykhrkkaisuukbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkeirokbnx5 = new ExDBFieldString<>("ztyhtnknkykhrkkeirokbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytnknuktkzngtkijyuhyjx5 = new ExDBFieldString<>("ztytnknuktkzngtkijyuhyjx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykmrtisyuruikgux5 = new ExDBFieldString<>("ztyhtnknkykmrtisyuruikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksyonox6 = new ExDBFieldString<>("ztyhtnknkyksyonox6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknsyuruikgux6 = new ExDBFieldString<>("ztyhtnknkykhknsyuruikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytenkanuketukeymdx6 = new ExDBFieldString<>("ztytenkanuketukeymdx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykkykymdx6 = new ExDBFieldString<>("ztyhtnknkykkykymdx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhknkknx6 = new ExDBFieldString<>("ztyhtnknkykhknkknx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykphrkkknx6 = new ExDBFieldString<>("ztyhtnknkykphrkkknx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkaisuukbnx6 = new ExDBFieldString<>("ztyhtnknkykhrkkaisuukbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhrkkeirokbnx6 = new ExDBFieldString<>("ztyhtnknkykhrkkeirokbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytnknuktkzngtkijyuhyjx6 = new ExDBFieldString<>("ztytnknuktkzngtkijyuhyjx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykmrtisyuruikgux6 = new ExDBFieldString<>("ztyhtnknkykmrtisyuruikgux6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukihtnknkykkhns = new ExDBFieldNumber<>("ztygukihtnknkykkhns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukihtnknkyksbus = new ExDBFieldNumber<>("ztygukihtnknkyksbus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukihtnknkykhntiyup = new ExDBFieldNumber<>("ztygukihtnknkykhntiyup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukihtnknkyksigwrmstkyks = new ExDBFieldNumber<>("ztygukihtnknkyksigwrmstkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukihtnknkyksyugitkyks = new ExDBFieldNumber<>("ztygukihtnknkyksyugitkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztygukihtnknsignyintkykntgk = new ExDBFieldNumber<>("ztygukihtnknsignyintkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztygukihtnknknkutkykntgk = new ExDBFieldNumber<>("ztygukihtnknknkutkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukihtnknkykmods = new ExDBFieldNumber<>("ztygukihtnknkykmods", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygoukeitenkankakaku = new ExDBFieldNumber<>("ztygoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnknjsknnjynbkn = new ExDBFieldNumber<>("ztygukitnknjsknnjynbkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnknsisnkstkkngk = new ExDBFieldNumber<>("ztygukitnknsisnkstkkngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnknsisnttkekngk = new ExDBFieldNumber<>("ztygukitnknsisnttkekngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygoukeitenkanseisand = new ExDBFieldNumber<>("ztygoukeitenkanseisand", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnknsisnmkikp = new ExDBFieldNumber<>("ztygukitnknsisnmkikp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnknsisnsntkngk = new ExDBFieldNumber<>("ztygukitnknsisnsntkngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnknkhnbbnkiykkujygk = new ExDBFieldNumber<>("ztygukitnknkhnbbnkiykkujygk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnkntikbbnkiykkujygk = new ExDBFieldNumber<>("ztygukitnkntikbbnkiykkujygk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztygukitnknitjbrtiks = new ExDBFieldNumber<>("ztygukitnknitjbrtiks", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysethokenno = new ExDBFieldString<>("ztysethokenno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysckbn = new ExDBFieldString<>("ztysckbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyenjyosyacd = new ExDBFieldString<>("ztyenjyosyacd", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztynaibuwarimodosigaku = new ExDBFieldNumber<>("ztynaibuwarimodosigaku", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykeiyakukakuninsyuruikbn = new ExDBFieldString<>("ztykeiyakukakuninsyuruikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysoujikeitenkanhyouji = new ExDBFieldString<>("ztysoujikeitenkanhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytenkanjisketteihouhoukbn = new ExDBFieldString<>("ztytenkanjisketteihouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykeikanensuukbn = new ExDBFieldString<>("ztykeikanensuukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhhknsytisyukbnx1 = new ExDBFieldString<>("ztyhtnknkykhhknsytisyukbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhhknsytisyukbnx2 = new ExDBFieldString<>("ztyhtnknkykhhknsytisyukbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhhknsytisyukbnx3 = new ExDBFieldString<>("ztyhtnknkykhhknsytisyukbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhhknsytisyukbnx4 = new ExDBFieldString<>("ztyhtnknkykhhknsytisyukbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhhknsytisyukbnx5 = new ExDBFieldString<>("ztyhtnknkykhhknsytisyukbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkykhhknsytisyukbnx6 = new ExDBFieldString<>("ztyhtnknkykhhknsytisyukbnx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztykktijgukipbbntnkns = new ExDBFieldNumber<>("ztykktijgukipbbntnkns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysyonendosyokaip = new ExDBFieldNumber<>("ztysyonendosyokaip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysyonendo2kaimeikoup = new ExDBFieldNumber<>("ztysyonendo2kaimeikoup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyjinendoikoup = new ExDBFieldNumber<>("ztyjinendoikoup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztysyukeiyakusikyuukisogaku = new ExDBFieldNumber<>("ztysyukeiyakusikyuukisogaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztysykyknenhantatskyuksgk = new ExDBFieldNumber<>("ztysykyknenhantatskyuksgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztymaruteisikyuukisogaku = new ExDBFieldNumber<>("ztymaruteisikyuukisogaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyitjbrzugkskyuksgkx1 = new ExDBFieldNumber<>("ztyitjbrzugkskyuksgkx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyitjbrzugkskyuksgkx2 = new ExDBFieldNumber<>("ztyitjbrzugkskyuksgkx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyitjbrzgknnhntatskyksgkx1 = new ExDBFieldNumber<>("ztyitjbrzgknnhntatskyksgkx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyitjbrzgknnhntatskyksgkx2 = new ExDBFieldNumber<>("ztyitjbrzgknnhntatskyksgkx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztykzkmrtiskyuksgk = new ExDBFieldNumber<>("ztykzkmrtiskyuksgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyitibitjbrskyuksgk = new ExDBFieldNumber<>("ztyitibitjbrskyuksgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyitbitjbrnnhntatskyuksgk = new ExDBFieldNumber<>("ztyitbitjbrnnhntatskyuksgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztysykykksnbsyutat = new ExDBFieldNumber<>("ztysykykksnbsyutat", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyitjbrzugkksnbsyutatx1 = new ExDBFieldNumber<>("ztyitjbrzugkksnbsyutatx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyitjbrzugkksnbsyutatx2 = new ExDBFieldNumber<>("ztyitjbrzugkksnbsyutatx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztyitibitjbrksnbsyutat = new ExDBFieldNumber<>("ztyitibitjbrksnbsyutat", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, BizNumber> ztyjyunkensuu = new ExDBFieldString<>("ztyjyunkensuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, BizNumber> ztykansankensuu = new ExDBFieldString<>("ztykansankensuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyitibuitijibaraikikan = new ExDBFieldString<>("ztyitibuitijibaraikikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyitibuitijibarais = new ExDBFieldNumber<>("ztyitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyitibuitijibaraip = new ExDBFieldNumber<>("ztyitibuitijibaraip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyitibitjbrsdtpdtkbn = new ExDBFieldString<>("ztyitibitjbrsdtpdtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyitibuitijibaraisyuuseis = new ExDBFieldNumber<>("ztyitibuitijibaraisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyitibitjbrmodsskgnhyj = new ExDBFieldString<>("ztyitibitjbrmodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysuuriyousyoriym = new ExDBFieldString<>("ztysuuriyousyoriym", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysyosinsinsahouhoukbn = new ExDBFieldString<>("ztysyosinsinsahouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysaisinsinsahouhoukbn = new ExDBFieldString<>("ztysaisinsinsahouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseizonmrtisyuruikgu = new ExDBFieldString<>("ztyseizonmrtisyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseizonmaruteikikan = new ExDBFieldString<>("ztyseizonmaruteikikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseizonmrtiphrkkkn = new ExDBFieldString<>("ztyseizonmrtiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyseizonmaruteis = new ExDBFieldNumber<>("ztyseizonmaruteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyseizonmaruteip = new ExDBFieldNumber<>("ztyseizonmaruteip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyseizonmaruteisyuuseis = new ExDBFieldNumber<>("ztyseizonmaruteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseizonmrtimodsskgnhyj = new ExDBFieldString<>("ztyseizonmrtimodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysiznmrtitkjyukbn = new ExDBFieldString<>("ztysiznmrtitkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysiznmrtitkjyuskgnkkn = new ExDBFieldString<>("ztysiznmrtitkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztysiznmrtitkjyuryumshyutn = new ExDBFieldNumber<>("ztysiznmrtitkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysiznmrtitkjyup = new ExDBFieldNumber<>("ztysiznmrtitkjyup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztysiznmrtiskyuksgk = new ExDBFieldNumber<>("ztysiznmrtiskyuksgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksiznmrtsyrikgux1 = new ExDBFieldString<>("ztyhtnknkyksiznmrtsyrikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksiznmrtsyrikgux2 = new ExDBFieldString<>("ztyhtnknkyksiznmrtsyrikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksiznmrtsyrikgux3 = new ExDBFieldString<>("ztyhtnknkyksiznmrtsyrikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksiznmrtsyrikgux4 = new ExDBFieldString<>("ztyhtnknkyksiznmrtsyrikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksiznmrtsyrikgux5 = new ExDBFieldString<>("ztyhtnknkyksiznmrtsyrikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyksiznmrtsyrikgux6 = new ExDBFieldString<>("ztyhtnknkyksiznmrtsyrikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysuryusiznmrtipwrbkkbn = new ExDBFieldString<>("ztysuryusiznmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysiznmrtipwrbkkbn = new ExDBFieldString<>("ztysiznmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysiznmrtitnknyugukbn = new ExDBFieldString<>("ztysiznmrtitnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyseizonmrtikgusdkbn = new ExDBFieldString<>("ztyseizonmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2hihokensyamei = new ExDBFieldString<>("ztydai2hihokensyamei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2kanjihihokensyamei = new ExDBFieldString<>("ztydai2kanjihihokensyamei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2hihokensyaseiymd = new ExDBFieldString<>("ztydai2hihokensyaseiymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2hihokensyaseibetukbn = new ExDBFieldString<>("ztydai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2hihknsyahnskhkncd = new ExDBFieldString<>("ztydai2hihknsyahnskhkncd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2hhknnen = new ExDBFieldString<>("ztydai2hhknnen", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2hihknsyakikykarihyj = new ExDBFieldString<>("ztydai2hihknsyakikykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztykyksydi2hihknsyaduithyj = new ExDBFieldString<>("ztykyksydi2hihknsyaduithyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2syosinsinsahouhoukbn = new ExDBFieldString<>("ztydai2syosinsinsahouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2saisinsinsahouhoukbn = new ExDBFieldString<>("ztydai2saisinsinsahouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2syokugyoucd = new ExDBFieldString<>("ztydai2syokugyoucd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2sakugenkikan = new ExDBFieldString<>("ztydai2sakugenkikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztydai2ryoumasihyouten = new ExDBFieldNumber<>("ztydai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztymrtidi2skgnkkn = new ExDBFieldString<>("ztymrtidi2skgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztymrtidi2ryumshyutn = new ExDBFieldNumber<>("ztymrtidi2ryumshyutn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2kykkknnsyrikbn = new ExDBFieldString<>("ztydi2kykkknnsyrikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytignmrtidi2skgnkkn = new ExDBFieldString<>("ztytignmrtidi2skgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztytignmrtidi2ryumshyutn = new ExDBFieldNumber<>("ztytignmrtidi2ryumshyutn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2syosinhonninkknnkbn = new ExDBFieldString<>("ztydai2syosinhonninkknnkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sisnhonninkknnkbn = new ExDBFieldString<>("ztydi2sisnhonninkknnkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv9x6 = new ExDBFieldString<>("ztyyobiv9x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2syugitkyksyrikgu = new ExDBFieldString<>("ztydi2syugitkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2syougaitokuyakukikan = new ExDBFieldString<>("ztydai2syougaitokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2syugitkykphrkkkn = new ExDBFieldString<>("ztydi2syugitkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztydai2syougaitokuyakus = new ExDBFieldNumber<>("ztydai2syougaitokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztydai2syougaitokuyakup = new ExDBFieldNumber<>("ztydai2syougaitokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2syugitkykgtkbn = new ExDBFieldString<>("ztydi2syugitkykgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2syugitkykkgusdkbn = new ExDBFieldString<>("ztydi2syugitkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2syugitkykpwrbkkbn = new ExDBFieldString<>("ztydi2syugitkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sigiwrmstkyksyrikgu = new ExDBFieldString<>("ztydi2sigiwrmstkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sigiwrmstkykkkn = new ExDBFieldString<>("ztydi2sigiwrmstkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sigiwrmstkykphrkkkn = new ExDBFieldString<>("ztydi2sigiwrmstkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztydi2sigiwrmstkyks = new ExDBFieldNumber<>("ztydi2sigiwrmstkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztydi2sigiwrmstkykp = new ExDBFieldNumber<>("ztydi2sigiwrmstkykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sigiwrmstkykkgusdkbn = new ExDBFieldString<>("ztydi2sigiwrmstkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sigiwrmstkykpwrbkkbn = new ExDBFieldString<>("ztydi2sigiwrmstkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv9x7 = new ExDBFieldString<>("ztyyobiv9x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2siginyuintkyksyrikgu = new ExDBFieldString<>("ztydi2siginyuintkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2siginyuintkykkkn = new ExDBFieldString<>("ztydi2siginyuintkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2siginyuintkykphrkkkn = new ExDBFieldString<>("ztydi2siginyuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztydi2siginyuintkykntgk = new ExDBFieldNumber<>("ztydi2siginyuintkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztydi2siginyuintkykp = new ExDBFieldNumber<>("ztydi2siginyuintkykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2siginyuintkykgtkbn = new ExDBFieldString<>("ztydi2siginyuintkykgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2siginyintkykkgusdkbn = new ExDBFieldString<>("ztydi2siginyintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2siginyuintkykpwrbkkbn = new ExDBFieldString<>("ztydi2siginyuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv10x3 = new ExDBFieldString<>("ztyyobiv10x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyuintkyksyrikgu = new ExDBFieldString<>("ztydi2sppinyuintkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyuintkykkkn = new ExDBFieldString<>("ztydi2sppinyuintkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyuintkykphrkkkn = new ExDBFieldString<>("ztydi2sppinyuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztydi2sppinyuintkykntgk = new ExDBFieldNumber<>("ztydi2sppinyuintkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztydi2sppinyuintkykp = new ExDBFieldNumber<>("ztydi2sppinyuintkykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyuintkykgtkbn = new ExDBFieldString<>("ztydi2sppinyuintkykgtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztydi2sppinyintkjyryumshytn = new ExDBFieldNumber<>("ztydi2sppinyintkjyryumshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztydi2sppinyuintkjyup = new ExDBFieldNumber<>("ztydi2sppinyuintkjyup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyuintktbicdx1 = new ExDBFieldString<>("ztydi2sppinyuintktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyuinhtnpkknx1 = new ExDBFieldString<>("ztydi2sppinyuinhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyuintktbicdx2 = new ExDBFieldString<>("ztydi2sppinyuintktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyuinhtnpkknx2 = new ExDBFieldString<>("ztydi2sppinyuinhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyintkykkgusdkbn = new ExDBFieldString<>("ztydi2sppinyintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sppinyuintkykpwrbkkbn = new ExDBFieldString<>("ztydi2sppinyuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv3x2 = new ExDBFieldString<>("ztyyobiv3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbyutkyksyrikgu = new ExDBFieldString<>("ztydi2sijnbyutkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbyutkykkkn = new ExDBFieldString<>("ztydi2sijnbyutkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbyutkykphrkkkn = new ExDBFieldString<>("ztydi2sijnbyutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztydi2sijnbyutkykntgk = new ExDBFieldNumber<>("ztydi2sijnbyutkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztydai2seijinbyoutokuyakup = new ExDBFieldNumber<>("ztydai2seijinbyoutokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztydi2sijnbyutkjyurymshytn = new ExDBFieldNumber<>("ztydi2sijnbyutkjyurymshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztydai2seijinbyoutokujyoup = new ExDBFieldNumber<>("ztydai2seijinbyoutokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbyutktbicdx1 = new ExDBFieldString<>("ztydi2sijnbyutktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbyuhtnpkknx1 = new ExDBFieldString<>("ztydi2sijnbyuhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbyutktbicdx2 = new ExDBFieldString<>("ztydi2sijnbyutktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbyuhtnpkknx2 = new ExDBFieldString<>("ztydi2sijnbyuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbyutkykkgusdkbn = new ExDBFieldString<>("ztydi2sijnbyutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbytkykgankyhgtkbn = new ExDBFieldString<>("ztydi2sijnbytkykgankyhgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydi2sijnbyutkykpwrbkkbn = new ExDBFieldString<>("ztydi2sijnbyutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv3x3 = new ExDBFieldString<>("ztyyobiv3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztydai2jyoukentukihyouji = new ExDBFieldString<>("ztydai2jyoukentukihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytignmrtisyukgu = new ExDBFieldString<>("ztytignmrtisyukgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteigenmaruteikikan = new ExDBFieldString<>("ztyteigenmaruteikikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteigenmrtiphrkkkn = new ExDBFieldString<>("ztyteigenmrtiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyteigenmaruteis = new ExDBFieldNumber<>("ztyteigenmaruteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyteigenmaruteip = new ExDBFieldNumber<>("ztyteigenmaruteip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztyteigenmaruteisyuuseis = new ExDBFieldNumber<>("ztyteigenmaruteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteigenmrtimodssakugenhyj = new ExDBFieldString<>("ztyteigenmrtimodssakugenhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytignmrtitkjyukbn = new ExDBFieldString<>("ztytignmrtitkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytignmrtitkjyuskgnkkn = new ExDBFieldString<>("ztytignmrtitkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztytignmrtitkjyuryumshyutn = new ExDBFieldNumber<>("ztytignmrtitkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztytignmrtitkjyup = new ExDBFieldNumber<>("ztytignmrtitkjyup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Integer> ztytignmrtiskyuksgk = new ExDBFieldNumber<>("ztytignmrtiskyuksgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyktignmrtsyrikgux1 = new ExDBFieldString<>("ztyhtnknkyktignmrtsyrikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyktignmrtsyrikgux2 = new ExDBFieldString<>("ztyhtnknkyktignmrtsyrikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyktignmrtsyrikgux3 = new ExDBFieldString<>("ztyhtnknkyktignmrtsyrikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyktignmrtsyrikgux4 = new ExDBFieldString<>("ztyhtnknkyktignmrtsyrikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyktignmrtsyrikgux5 = new ExDBFieldString<>("ztyhtnknkyktignmrtsyrikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyhtnknkyktignmrtsyrikgux6 = new ExDBFieldString<>("ztyhtnknkyktignmrtsyrikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysuryutignmrtipwrbkkbn = new ExDBFieldString<>("ztysuryutignmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytignmrtipwrbkkbn = new ExDBFieldString<>("ztytignmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytignmrtitnknyugukbn = new ExDBFieldString<>("ztytignmrtitnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyteigenmrtikgusdkbn = new ExDBFieldString<>("ztyteigenmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztytktsppisetkykkbn = new ExDBFieldString<>("ztytktsppisetkykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyjyudmnsiskknsetkykkbn = new ExDBFieldString<>("ztyjyudmnsiskknsetkykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysetaitesyono1 = new ExDBFieldString<>("ztysetaitesyono1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysetaitehokensyuruikigou1 = new ExDBFieldString<>("ztysetaitehokensyuruikigou1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysetaitemrtisyuruikgu1 = new ExDBFieldString<>("ztysetaitemrtisyuruikgu1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysetaitesiznmrtisyurui1 = new ExDBFieldString<>("ztysetaitesiznmrtisyurui1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysetaitetignmrtisyurui1 = new ExDBFieldString<>("ztysetaitetignmrtisyurui1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetaitekihonbubuns1 = new ExDBFieldNumber<>("ztysetaitekihonbubuns1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetgukitnknitjbrkhns1 = new ExDBFieldNumber<>("ztysetgukitnknitjbrkhns1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetaitesibous1 = new ExDBFieldNumber<>("ztysetaitesibous1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetgukitnknitjbrsbus1 = new ExDBFieldNumber<>("ztysetgukitnknitjbrsbus1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetaitesyuuseis1 = new ExDBFieldNumber<>("ztysetaitesyuuseis1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetaiteharaikomip1 = new ExDBFieldNumber<>("ztysetaiteharaikomip1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetaitesyukeiyakububunp1 = new ExDBFieldNumber<>("ztysetaitesyukeiyakububunp1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetaitgukikzkmrtis1 = new ExDBFieldNumber<>("ztysetaitgukikzkmrtis1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysetaitetenkankykhyj1 = new ExDBFieldString<>("ztysetaitetenkankykhyj1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetaitesiteimhrkp1 = new ExDBFieldNumber<>("ztysetaitesiteimhrkp1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Ty, Long> ztysetaitesiteimsykykp1 = new ExDBFieldNumber<>("ztysetaitesiteimsykykp1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztysetaitenkmrtisyurui1 = new ExDBFieldString<>("ztysetaitenkmrtisyurui1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Ty, String> ztyyobiv18 = new ExDBFieldString<>("ztyyobiv18", this);
}
