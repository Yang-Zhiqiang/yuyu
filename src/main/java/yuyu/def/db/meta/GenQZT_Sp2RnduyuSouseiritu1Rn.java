package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu1Rn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＳＰ２連動用総成立Fテーブル１（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Sp2RnduyuSouseiritu1Rn extends AbstractExDBTable<ZT_Sp2RnduyuSouseiritu1Rn> {

    public GenQZT_Sp2RnduyuSouseiritu1Rn() {
        this("ZT_Sp2RnduyuSouseiritu1Rn");
    }

    public GenQZT_Sp2RnduyuSouseiritu1Rn(String pAlias) {
        super("ZT_Sp2RnduyuSouseiritu1Rn", ZT_Sp2RnduyuSouseiritu1Rn.class, pAlias);
    }

    public String ZT_Sp2RnduyuSouseiritu1Rn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnktgysyrymd = new ExDBFieldString<>("zrnktgysyrymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnktgysyono = new ExDBFieldString<>("zrnktgysyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnktgyfilerenno = new ExDBFieldString<>("zrnktgyfilerenno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnaatukaisyasisyacd = new ExDBFieldString<>("zrnaatukaisyasisyacd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmosno = new ExDBFieldString<>("zrnmosno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkihons = new ExDBFieldNumber<>("zrnkihons", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngyousekihyoukayouhosyous = new ExDBFieldNumber<>("zrngyousekihyoukayouhosyous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnknitjbrkhns = new ExDBFieldNumber<>("zrngukitnknitjbrkhns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnknitjbrsbus = new ExDBFieldNumber<>("zrngukitnknitjbrsbus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkktijgukitnknitjbrkhns = new ExDBFieldNumber<>("zrnkktijgukitnknitjbrkhns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkktijgukitnknitjbrsbus = new ExDBFieldNumber<>("zrnkktijgukitnknitjbrsbus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsyokaiharaikomip = new ExDBFieldNumber<>("zrnsyokaiharaikomip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnryouritukbn = new ExDBFieldString<>("zrnryouritukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntksyuannaikykkbn = new ExDBFieldString<>("zrntksyuannaikykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsdpdkbn = new ExDBFieldString<>("zrnsdpdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnduketorihouhoukbn = new ExDBFieldString<>("zrnduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkyksyhhknsydouituhyouji = new ExDBFieldString<>("zrnkyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkyksyakikykarihyj = new ExDBFieldString<>("zrnkyksyakikykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntenkankeiyakuhyouji = new ExDBFieldString<>("zrntenkankeiyakuhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnjigyoukeiyakuhyouji = new ExDBFieldString<>("zrnjigyoukeiyakuhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnenkinzeiseitokuyakukbn = new ExDBFieldString<>("zrnnenkinzeiseitokuyakukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyusseimaekanyuukykkbn = new ExDBFieldString<>("zrnsyusseimaekanyuukykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokukeiyakuhyouji = new ExDBFieldString<>("zrnkazokukeiyakuhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnjikokykhyj = new ExDBFieldString<>("zrnjikokykhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntuusyoumeisiyouhyouji = new ExDBFieldString<>("zrntuusyoumeisiyouhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsethokenkbn = new ExDBFieldString<>("zrnsethokenkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteikeisyouhinkbn = new ExDBFieldString<>("zrnteikeisyouhinkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrntokuninbosyuuteate = new ExDBFieldNumber<>("zrntokuninbosyuuteate", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseisekiym = new ExDBFieldString<>("zrnseisekiym", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnseisekikeijyousyuuseis = new ExDBFieldNumber<>("zrnseisekikeijyousyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyuuseissakugenhyouji = new ExDBFieldString<>("zrnsyuuseissakugenhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnaatukaisisyatodouhukencd = new ExDBFieldString<>("zrnaatukaisisyatodouhukencd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnaatukaisosikicd = new ExDBFieldString<>("zrnaatukaisosikicd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnaatukaikojincd = new ExDBFieldString<>("zrnaatukaikojincd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnbatukaisosikicd = new ExDBFieldString<>("zrnbatukaisosikicd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnbatukaisyakojincd = new ExDBFieldString<>("zrnbatukaisyakojincd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmarutokukbn = new ExDBFieldString<>("zrnmarutokukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrngyoumujyouhyouji = new ExDBFieldString<>("zrngyoumujyouhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntuikakeijyoukbn = new ExDBFieldString<>("zrntuikakeijyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseisekinomikeijyoukbn = new ExDBFieldString<>("zrnseisekinomikeijyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteikikeijyoukbn = new ExDBFieldString<>("zrnteikikeijyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhngkmskkatkisykbn = new ExDBFieldString<>("zrnhngkmskkatkisykbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntnknkyuuyosakugenhyj = new ExDBFieldString<>("zrntnknkyuuyosakugenhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntenkankaisuu = new ExDBFieldString<>("zrntenkankaisuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhiyubrigssnsikkijyunkbn = new ExDBFieldString<>("zrnhiyubrigssnsikkijyunkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsekininkaisiymd = new ExDBFieldString<>("zrnsekininkaisiymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkigetusmkrgkykhyj = new ExDBFieldString<>("zrnkigetusmkrgkykhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhensyuusyoriymd = new ExDBFieldString<>("zrnhensyuusyoriymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnjisisyaatukaihyouji = new ExDBFieldString<>("zrnjisisyaatukaihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnaatkisytktntusy1atkihyj = new ExDBFieldString<>("zrnaatkisytktntusy1atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnaatkisytktntusy2atkihyj = new ExDBFieldString<>("zrnaatkisytktntusy2atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnaatkisyasyokan1atkihyj = new ExDBFieldString<>("zrnaatkisyasyokan1atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnaatkisyasyokan2atkihyj = new ExDBFieldString<>("zrnaatkisyasyokan2atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnbatkisytktntusy1atkihyj = new ExDBFieldString<>("zrnbatkisytktntusy1atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnbatkisytktntusy2atkihyj = new ExDBFieldString<>("zrnbatkisytktntusy2atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnbatkisyasyokan1atkihyj = new ExDBFieldString<>("zrnbatkisyasyokan1atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnbatkisyasyokan2atkihyj = new ExDBFieldString<>("zrnbatkisyasyokan2atkihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkeizokutyuuihyouji = new ExDBFieldString<>("zrnkeizokutyuuihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkeiyakubisiteihyouji = new ExDBFieldString<>("zrnkeiyakubisiteihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnjyoukentukihyouji = new ExDBFieldString<>("zrnjyoukentukihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntokuninhyouji = new ExDBFieldString<>("zrntokuninhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkessantyouseikbn = new ExDBFieldString<>("zrnkessantyouseikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhaneihyouji = new ExDBFieldString<>("zrnhaneihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyukinkbn = new ExDBFieldString<>("zrnsyukinkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkeiyakusyasyokugyoucd = new ExDBFieldString<>("zrnkeiyakusyasyokugyoucd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseikeikeirokbn = new ExDBFieldString<>("zrnseikeikeirokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2seikeikeirokbn = new ExDBFieldString<>("zrndai2seikeikeirokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteigentokuteisyuruikigou = new ExDBFieldString<>("zrnteigentokuteisyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteigentokuteikikan = new ExDBFieldString<>("zrnteigentokuteikikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnteigentokuteis = new ExDBFieldNumber<>("zrnteigentokuteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnteigentokuteip = new ExDBFieldNumber<>("zrnteigentokuteip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntigntktisdtpdtkbn = new ExDBFieldString<>("zrntigntktisdtpdtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnteigentokuteisyuuseis = new ExDBFieldNumber<>("zrnteigentokuteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteigentktimodssakugenhyj = new ExDBFieldString<>("zrnteigentktimodssakugenhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteigentktikgusdkbn = new ExDBFieldString<>("zrnteigentktikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv9 = new ExDBFieldString<>("zrnyobiv9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntokuteibuicdx1 = new ExDBFieldString<>("zrntokuteibuicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnpkknx1 = new ExDBFieldString<>("zrnhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntokuteibuicdx2 = new ExDBFieldString<>("zrntokuteibuicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnpkknx2 = new ExDBFieldString<>("zrnhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhhknmei = new ExDBFieldString<>("zrnhhknmei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnknjhhknmei = new ExDBFieldString<>("zrnknjhhknmei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhhknhnsktodouhukencd = new ExDBFieldString<>("zrnhhknhnsktodouhukencd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhihokensyakikykarihyj = new ExDBFieldString<>("zrnhihokensyakikykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnobikkosaimankikbn = new ExDBFieldString<>("zrnnobikkosaimankikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhhknsysysnhonninkknnkbn = new ExDBFieldString<>("zrnhhknsysysnhonninkknnkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhhknsysisnhonninkknnkbn = new ExDBFieldString<>("zrnhhknsysisnhonninkknnkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzktourokuservicearihyj = new ExDBFieldString<>("zrnkzktourokuservicearihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x12 = new ExDBFieldString<>("zrnyobiv4x12", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhensyuukeiyakusyamei = new ExDBFieldString<>("zrnhensyuukeiyakusyamei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhnsyuknjkyksynm = new ExDBFieldString<>("zrnhnsyuknjkyksynm", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkyksyaseiymd = new ExDBFieldString<>("zrnkyksyaseiymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkyksyaseikbn = new ExDBFieldString<>("zrnkyksyaseikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnvitdoujimos2kenmeikouhyj = new ExDBFieldString<>("zrnvitdoujimos2kenmeikouhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkikykvitarituikamoshyj = new ExDBFieldString<>("zrnkikykvitarituikamoshyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykvithokenkbn = new ExDBFieldString<>("zrnhtnknkykvithokenkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkikykvithokenhoyuujkkbn = new ExDBFieldString<>("zrnkikykvithokenhoyuujkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv2x2 = new ExDBFieldString<>("zrnyobiv2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntsnsknewyno = new ExDBFieldString<>("zrntsnsknewyno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntsnsknewtikucd = new ExDBFieldString<>("zrntsnsknewtikucd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmossyumtkktymd = new ExDBFieldString<>("zrnmossyumtkktymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkituenkbn = new ExDBFieldString<>("zrnkituenkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntuusinsakijyuusyokbn = new ExDBFieldString<>("zrntuusinsakijyuusyokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruteisyuruikigou = new ExDBFieldString<>("zrnmaruteisyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruteikikan = new ExDBFieldString<>("zrnmaruteikikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruteiphrkkkn = new ExDBFieldString<>("zrnmaruteiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmaruteis = new ExDBFieldNumber<>("zrnmaruteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmaruteip = new ExDBFieldNumber<>("zrnmaruteip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmaruteisyuuseis = new ExDBFieldNumber<>("zrnmaruteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruteisyuuseisskgnhyj = new ExDBFieldString<>("zrnmaruteisyuuseisskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruteitokujyoukbn = new ExDBFieldString<>("zrnmaruteitokujyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmrtitkjyuskgnkkn = new ExDBFieldString<>("zrnmrtitkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnmrtitkjyuryumshyutn = new ExDBFieldNumber<>("zrnmrtitkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmaruteitokujyoup = new ExDBFieldNumber<>("zrnmaruteitokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsuryumrtipwrbkkbn = new ExDBFieldString<>("zrnsuryumrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruteipwaribikikbn = new ExDBFieldString<>("zrnmaruteipwaribikikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmrtitnknyugukbn = new ExDBFieldString<>("zrnmrtitnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruteikigousedaikbn = new ExDBFieldString<>("zrnmaruteikigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruteikikousnmnryoage = new ExDBFieldString<>("zrnmaruteikikousnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruyousyuruikigou = new ExDBFieldString<>("zrnmaruyousyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruyoukikan = new ExDBFieldString<>("zrnmaruyoukikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmaruyous = new ExDBFieldNumber<>("zrnmaruyous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmaruyoup = new ExDBFieldNumber<>("zrnmaruyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruyousdatepdatekbn = new ExDBFieldString<>("zrnmaruyousdatepdatekbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmaruyousyuuseis = new ExDBFieldNumber<>("zrnmaruyousyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruyousyuuseisskgnhyj = new ExDBFieldString<>("zrnmaruyousyuuseisskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmaruyoukigousedaikbn = new ExDBFieldString<>("zrnmaruyoukigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv9x3 = new ExDBFieldString<>("zrnyobiv9x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmarusyuusyuruikigou = new ExDBFieldString<>("zrnmarusyuusyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmarusyuukikan = new ExDBFieldString<>("zrnmarusyuukikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmarusyuus = new ExDBFieldNumber<>("zrnmarusyuus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmarusyuup = new ExDBFieldNumber<>("zrnmarusyuup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmarusyuusdatepdatekbn = new ExDBFieldString<>("zrnmarusyuusdatepdatekbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnmarusyuusyuuseis = new ExDBFieldNumber<>("zrnmarusyuusyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmarusyuusyuuseisskgnhyj = new ExDBFieldString<>("zrnmarusyuusyuuseisskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmarusyuukigousedaikbn = new ExDBFieldString<>("zrnmarusyuukigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv9x4 = new ExDBFieldString<>("zrnyobiv9x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntokuteisyuruikigou = new ExDBFieldString<>("zrntokuteisyuruikigou", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntokuteikikan = new ExDBFieldString<>("zrntokuteikikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrntokuteis = new ExDBFieldNumber<>("zrntokuteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrntokuteip = new ExDBFieldNumber<>("zrntokuteip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntokuteisdatepdatekbn = new ExDBFieldString<>("zrntokuteisdatepdatekbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrntokuteisyuuseis = new ExDBFieldNumber<>("zrntokuteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntokuteisyuuseisskgnhyj = new ExDBFieldString<>("zrntokuteisyuuseisskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntokuteikigousedaikbn = new ExDBFieldString<>("zrntokuteikigousedaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv9x5 = new ExDBFieldString<>("zrnyobiv9x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox1 = new ExDBFieldString<>("zrnkzkmrtitkyknox1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux1 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx1 = new ExDBFieldString<>("zrnkazokumaruteikikanx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx1 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx1 = new ExDBFieldNumber<>("zrnkazokumaruteisx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx1 = new ExDBFieldNumber<>("zrnkazokumaruteipx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx1 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx1 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx1 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex1 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx1 = new ExDBFieldNumber<>("zrnkzkmrtimodsx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx1 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx1 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx1 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx1 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex1 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox2 = new ExDBFieldString<>("zrnkzkmrtitkyknox2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux2 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx2 = new ExDBFieldString<>("zrnkazokumaruteikikanx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx2 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx2 = new ExDBFieldNumber<>("zrnkazokumaruteisx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx2 = new ExDBFieldNumber<>("zrnkazokumaruteipx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx2 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx2 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx2 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex2 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx2 = new ExDBFieldNumber<>("zrnkzkmrtimodsx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx2 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx2 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx2 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx2 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex2 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x2 = new ExDBFieldString<>("zrnyobiv4x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox3 = new ExDBFieldString<>("zrnkzkmrtitkyknox3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux3 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx3 = new ExDBFieldString<>("zrnkazokumaruteikikanx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx3 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx3 = new ExDBFieldNumber<>("zrnkazokumaruteisx3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx3 = new ExDBFieldNumber<>("zrnkazokumaruteipx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx3 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx3 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx3 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex3 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx3 = new ExDBFieldNumber<>("zrnkzkmrtimodsx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx3 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx3 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx3 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx3 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex3 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x3 = new ExDBFieldString<>("zrnyobiv4x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox4 = new ExDBFieldString<>("zrnkzkmrtitkyknox4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux4 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx4 = new ExDBFieldString<>("zrnkazokumaruteikikanx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx4 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx4 = new ExDBFieldNumber<>("zrnkazokumaruteisx4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx4 = new ExDBFieldNumber<>("zrnkazokumaruteipx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx4 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx4 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx4 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex4 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex4", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx4 = new ExDBFieldNumber<>("zrnkzkmrtimodsx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx4 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx4 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx4 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx4 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex4 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x4 = new ExDBFieldString<>("zrnyobiv4x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox5 = new ExDBFieldString<>("zrnkzkmrtitkyknox5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux5 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx5 = new ExDBFieldString<>("zrnkazokumaruteikikanx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx5 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx5 = new ExDBFieldNumber<>("zrnkazokumaruteisx5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx5 = new ExDBFieldNumber<>("zrnkazokumaruteipx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx5 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx5 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx5 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex5 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex5", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx5 = new ExDBFieldNumber<>("zrnkzkmrtimodsx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx5 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx5 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx5 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx5 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex5 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x5 = new ExDBFieldString<>("zrnyobiv4x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox6 = new ExDBFieldString<>("zrnkzkmrtitkyknox6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux6 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx6 = new ExDBFieldString<>("zrnkazokumaruteikikanx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx6 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx6 = new ExDBFieldNumber<>("zrnkazokumaruteisx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx6 = new ExDBFieldNumber<>("zrnkazokumaruteipx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx6 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx6 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx6 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex6 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx6 = new ExDBFieldNumber<>("zrnkzkmrtimodsx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx6 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx6 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx6 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx6 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex6 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x6 = new ExDBFieldString<>("zrnyobiv4x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox7 = new ExDBFieldString<>("zrnkzkmrtitkyknox7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux7 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx7 = new ExDBFieldString<>("zrnkazokumaruteikikanx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx7 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx7", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx7 = new ExDBFieldNumber<>("zrnkazokumaruteisx7", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx7 = new ExDBFieldNumber<>("zrnkazokumaruteipx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx7 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx7 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx7 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex7 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex7", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx7 = new ExDBFieldNumber<>("zrnkzkmrtimodsx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx7 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx7 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx7 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx7 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex7 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x7 = new ExDBFieldString<>("zrnyobiv4x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox8 = new ExDBFieldString<>("zrnkzkmrtitkyknox8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux8 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx8 = new ExDBFieldString<>("zrnkazokumaruteikikanx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx8 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx8", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx8 = new ExDBFieldNumber<>("zrnkazokumaruteisx8", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx8 = new ExDBFieldNumber<>("zrnkazokumaruteipx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx8 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx8 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx8 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex8 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex8", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx8 = new ExDBFieldNumber<>("zrnkzkmrtimodsx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx8 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx8 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx8 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx8 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex8 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x8 = new ExDBFieldString<>("zrnyobiv4x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox9 = new ExDBFieldString<>("zrnkzkmrtitkyknox9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux9 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx9 = new ExDBFieldString<>("zrnkazokumaruteikikanx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx9 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx9", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx9 = new ExDBFieldNumber<>("zrnkazokumaruteisx9", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx9 = new ExDBFieldNumber<>("zrnkazokumaruteipx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx9 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx9 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx9 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex9 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex9", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx9 = new ExDBFieldNumber<>("zrnkzkmrtimodsx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx9 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx9 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx9 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx9 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex9 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x9 = new ExDBFieldString<>("zrnyobiv4x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitkyknox10 = new ExDBFieldString<>("zrnkzkmrtitkyknox10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtisyuruikgux10 = new ExDBFieldString<>("zrnkazokumrtisyuruikgux10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumaruteikikanx10 = new ExDBFieldString<>("zrnkazokumaruteikikanx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiphrkkknx10 = new ExDBFieldString<>("zrnkazokumrtiphrkkknx10", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteisx10 = new ExDBFieldNumber<>("zrnkazokumaruteisx10", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkazokumaruteipx10 = new ExDBFieldNumber<>("zrnkazokumaruteipx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyanmx10 = new ExDBFieldString<>("zrnkzkmrtihihknsyanmx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsyseiymdx10 = new ExDBFieldString<>("zrnkzkmrtihihknsyseiymdx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtihihknsysibtkbnx10 = new ExDBFieldString<>("zrnkzkmrtihihknsysibtkbnx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtihihknsyaagex10 = new ExDBFieldString<>("zrnkazokumrtihihknsyaagex10", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkzkmrtimodsx10 = new ExDBFieldNumber<>("zrnkzkmrtimodsx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtimodsskgnhyjx10 = new ExDBFieldString<>("zrnkazokumrtimodsskgnhyjx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtitnknyugukbnx10 = new ExDBFieldString<>("zrnkzkmrtitnknyugukbnx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtikgusdkbnx10 = new ExDBFieldString<>("zrnkazokumrtikgusdkbnx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkazokumrtiagetyusihyjx10 = new ExDBFieldString<>("zrnkazokumrtiagetyusihyjx10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkzkmrtikusnmnryoagex10 = new ExDBFieldString<>("zrnkzkmrtikusnmnryoagex10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x10 = new ExDBFieldString<>("zrnyobiv4x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnkshrtkykhuhokbnx1 = new ExDBFieldString<>("zrnnkshrtkykhuhokbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnkshrtkyknksyuruikbnx1 = new ExDBFieldString<>("zrnnkshrtkyknksyuruikbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnkshrtkyknkkknx1 = new ExDBFieldString<>("zrnnkshrtkyknkkknx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnnkshrtkyknknengkx1 = new ExDBFieldNumber<>("zrnnkshrtkyknknengkx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnkshrtkykduketorihhkbnx1 = new ExDBFieldString<>("zrnnkshrtkykduketorihhkbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnkshrtkykhuhokbnx2 = new ExDBFieldString<>("zrnnkshrtkykhuhokbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnkshrtkyknksyuruikbnx2 = new ExDBFieldString<>("zrnnkshrtkyknksyuruikbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnkshrtkyknkkknx2 = new ExDBFieldString<>("zrnnkshrtkyknkkknx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnnkshrtkyknknengkx2 = new ExDBFieldNumber<>("zrnnkshrtkyknknengkx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnnkshrtkykduketorihhkbnx2 = new ExDBFieldString<>("zrnnkshrtkykduketorihhkbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv10x2 = new ExDBFieldString<>("zrnyobiv10x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyougaitkyksyuruikgu = new ExDBFieldString<>("zrnsyougaitkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyougaitokuyakukikan = new ExDBFieldString<>("zrnsyougaitokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyougaitkykphrkkkn = new ExDBFieldString<>("zrnsyougaitkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsyougaitokuyakus = new ExDBFieldNumber<>("zrnsyougaitokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsyougaitokuyakup = new ExDBFieldNumber<>("zrnsyougaitokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyougaitkkatakbn = new ExDBFieldString<>("zrnsyougaitkkatakbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyougaitkykkgusdkbn = new ExDBFieldString<>("zrnsyougaitkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyugitkykpwrbkkbn = new ExDBFieldString<>("zrnsyugitkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyougaitkykkusnmnryoage = new ExDBFieldString<>("zrnsyougaitkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv5x2 = new ExDBFieldString<>("zrnyobiv5x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsigiwrmstkyksyuruikgu = new ExDBFieldString<>("zrnsigiwrmstkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsigiwrmstkykkkn = new ExDBFieldString<>("zrnsigiwrmstkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsaigaiwrmstkykphrkkkn = new ExDBFieldString<>("zrnsaigaiwrmstkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsaigaiwarimasitokuyakus = new ExDBFieldNumber<>("zrnsaigaiwarimasitokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsaigaiwarimasitokuyakup = new ExDBFieldNumber<>("zrnsaigaiwarimasitokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsaigaiwrmstkykkgusdkbn = new ExDBFieldString<>("zrnsaigaiwrmstkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsigiwrmstkykpwrbkkbn = new ExDBFieldString<>("zrnsigiwrmstkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsigiwrmstkykkusnmnryoage = new ExDBFieldString<>("zrnsigiwrmstkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv5x3 = new ExDBFieldString<>("zrnyobiv5x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsiginyuintkyksyuruikgu = new ExDBFieldString<>("zrnsiginyuintkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsiginyuintkykkkn = new ExDBFieldString<>("zrnsiginyuintkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsaigainyuintkykphrkkkn = new ExDBFieldString<>("zrnsaigainyuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnsiginyuintkykntgk = new ExDBFieldNumber<>("zrnsiginyuintkykntgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsiginyuintkykgtkbn = new ExDBFieldString<>("zrnsiginyuintkykgtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsaigainyuuintokuyakup = new ExDBFieldNumber<>("zrnsaigainyuuintokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsaigainyuintkykkgusdkbn = new ExDBFieldString<>("zrnsaigainyuintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsiginyuintkykpwrbkkbn = new ExDBFieldString<>("zrnsiginyuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv7 = new ExDBFieldString<>("zrnyobiv7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuintkyksyuruikgu = new ExDBFieldString<>("zrnsppinyuintkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuintkykkkn = new ExDBFieldString<>("zrnsppinyuintkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuuintkykphrkkkn = new ExDBFieldString<>("zrnsppinyuuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnsppinyuintkykntgk = new ExDBFieldNumber<>("zrnsppinyuintkykntgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuintkykgtkbn = new ExDBFieldString<>("zrnsppinyuintkykgtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsippeinyuuintokuyakup = new ExDBFieldNumber<>("zrnsippeinyuuintokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnsppinyuintkjyuryumshyutn = new ExDBFieldNumber<>("zrnsppinyuintkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsippeinyuuintokujyoup = new ExDBFieldNumber<>("zrnsippeinyuuintokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuintktbicdx1 = new ExDBFieldString<>("zrnsppinyuintktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuinhtnpkknx1 = new ExDBFieldString<>("zrnsppinyuinhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuintktbicdx2 = new ExDBFieldString<>("zrnsppinyuintktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuinhtnpkknx2 = new ExDBFieldString<>("zrnsppinyuinhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuuintkykkgusdkbn = new ExDBFieldString<>("zrnsppinyuuintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsppinyuintkykpwrbkkbn = new ExDBFieldString<>("zrnsppinyuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv7x2 = new ExDBFieldString<>("zrnyobiv7x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsijnbyutkyksyuruikgu = new ExDBFieldString<>("zrnsijnbyutkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseijinbyoutokuyakukikan = new ExDBFieldString<>("zrnseijinbyoutokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseijinbyoutkykphrkkkn = new ExDBFieldString<>("zrnseijinbyoutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnseijinbyoutokuyakuntgk = new ExDBFieldNumber<>("zrnseijinbyoutokuyakuntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnseijinbyoutokuyakup = new ExDBFieldNumber<>("zrnseijinbyoutokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnsijnbyutkjyuryumshyutn = new ExDBFieldNumber<>("zrnsijnbyutkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnseijinbyoutokujyoup = new ExDBFieldNumber<>("zrnseijinbyoutokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseijinbyoutokuteibuicdx1 = new ExDBFieldString<>("zrnseijinbyoutokuteibuicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseijinbyouhutanpokikanx1 = new ExDBFieldString<>("zrnseijinbyouhutanpokikanx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseijinbyoutokuteibuicdx2 = new ExDBFieldString<>("zrnseijinbyoutokuteibuicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseijinbyouhutanpokikanx2 = new ExDBFieldString<>("zrnseijinbyouhutanpokikanx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseijinbyoutkykkgusdkbn = new ExDBFieldString<>("zrnseijinbyoutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsijnbyutkykgankyuhgtkbn = new ExDBFieldString<>("zrnsijnbyutkykgankyuhgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsijnbyutkykpwrbkkbn = new ExDBFieldString<>("zrnsijnbyutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsijnbyutkykkusnmnryoage = new ExDBFieldString<>("zrnsijnbyutkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv4x11 = new ExDBFieldString<>("zrnyobiv4x11", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnheiyoubaraikbn = new ExDBFieldString<>("zrnheiyoubaraikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhiyubriaitsyono = new ExDBFieldString<>("zrnhiyubriaitsyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhiyubriaithrkkeirokbn = new ExDBFieldString<>("zrnhiyubriaithrkkeirokbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnheiyoubaraiaitekihons = new ExDBFieldNumber<>("zrnheiyoubaraiaitekihons", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnhiyubrigukitnknitjbrkhns = new ExDBFieldNumber<>("zrnhiyubrigukitnknitjbrkhns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnheiyoubaraiaitesibous = new ExDBFieldNumber<>("zrnheiyoubaraiaitesibous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnhiyubrigukitnknitjbrsbus = new ExDBFieldNumber<>("zrnhiyubrigukitnknitjbrsbus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnheiyoubaraiaitesyuuseis = new ExDBFieldNumber<>("zrnheiyoubaraiaitesyuuseis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnheiyoubaraiaitehrkp = new ExDBFieldNumber<>("zrnheiyoubaraiaitehrkp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnhiyubriaitsykykp = new ExDBFieldNumber<>("zrnhiyubriaitsykykp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnheiyoubaraiaitemrtis = new ExDBFieldNumber<>("zrnheiyoubaraiaitemrtis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnhiyubrigukiaitkzkmrtis = new ExDBFieldNumber<>("zrnhiyubrigukiaitkzkmrtis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntukibaraikyktenkanhyj = new ExDBFieldString<>("zrntukibaraikyktenkanhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnbonusharaihrkkigetu1 = new ExDBFieldString<>("zrnbonusharaihrkkigetu1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnbonusharaihrkkigetu2 = new ExDBFieldString<>("zrnbonusharaihrkkigetu2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnhiyubriaitsiznmrtis = new ExDBFieldNumber<>("zrnhiyubriaitsiznmrtis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnhiyubriaittignmrtis = new ExDBFieldNumber<>("zrnhiyubriaittignmrtis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntkjykbn = new ExDBFieldString<>("zrntkjykbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsakugenkikan = new ExDBFieldString<>("zrnsakugenkikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnryoumasihyouten = new ExDBFieldNumber<>("zrnryoumasihyouten", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrntokujyoup = new ExDBFieldNumber<>("zrntokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhjncd = new ExDBFieldString<>("zrnhjncd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhjnjigyosyocd = new ExDBFieldString<>("zrnhjnjigyosyocd", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnjyuugyouinsuu = new ExDBFieldNumber<>("zrnjyuugyouinsuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrniktkaisuu = new ExDBFieldString<>("zrniktkaisuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnznnkai = new ExDBFieldString<>("zrnznnkai", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkyktsnatkitkykkbn = new ExDBFieldString<>("zrnkyktsnatkitkykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkyktsnatkitkykstagekbn = new ExDBFieldString<>("zrnkyktsnatkitkykstagekbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnpmentokuyakukbn = new ExDBFieldString<>("zrnpmentokuyakukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv3 = new ExDBFieldString<>("zrnyobiv3", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrntkykznnunyukngk = new ExDBFieldNumber<>("zrntkykznnunyukngk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyokaipnyuukinhouhoukbn = new ExDBFieldString<>("zrnsyokaipnyuukinhouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksyonox1 = new ExDBFieldString<>("zrnhtnknkyksyonox1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknsyuruikgux1 = new ExDBFieldString<>("zrnhtnknkykhknsyuruikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntenkanuketukeymdx1 = new ExDBFieldString<>("zrntenkanuketukeymdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykkykymdx1 = new ExDBFieldString<>("zrnhtnknkykkykymdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknkknx1 = new ExDBFieldString<>("zrnhtnknkykhknkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykphrkkknx1 = new ExDBFieldString<>("zrnhtnknkykphrkkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkaisuukbnx1 = new ExDBFieldString<>("zrnhtnknkykhrkkaisuukbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkeirokbnx1 = new ExDBFieldString<>("zrnhtnknkykhrkkeirokbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntnknuktkzngtkijyuhyjx1 = new ExDBFieldString<>("zrntnknuktkzngtkijyuhyjx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykmrtisyuruikgux1 = new ExDBFieldString<>("zrnhtnknkykmrtisyuruikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksyonox2 = new ExDBFieldString<>("zrnhtnknkyksyonox2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknsyuruikgux2 = new ExDBFieldString<>("zrnhtnknkykhknsyuruikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntenkanuketukeymdx2 = new ExDBFieldString<>("zrntenkanuketukeymdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykkykymdx2 = new ExDBFieldString<>("zrnhtnknkykkykymdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknkknx2 = new ExDBFieldString<>("zrnhtnknkykhknkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykphrkkknx2 = new ExDBFieldString<>("zrnhtnknkykphrkkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkaisuukbnx2 = new ExDBFieldString<>("zrnhtnknkykhrkkaisuukbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkeirokbnx2 = new ExDBFieldString<>("zrnhtnknkykhrkkeirokbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntnknuktkzngtkijyuhyjx2 = new ExDBFieldString<>("zrntnknuktkzngtkijyuhyjx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykmrtisyuruikgux2 = new ExDBFieldString<>("zrnhtnknkykmrtisyuruikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksyonox3 = new ExDBFieldString<>("zrnhtnknkyksyonox3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknsyuruikgux3 = new ExDBFieldString<>("zrnhtnknkykhknsyuruikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntenkanuketukeymdx3 = new ExDBFieldString<>("zrntenkanuketukeymdx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykkykymdx3 = new ExDBFieldString<>("zrnhtnknkykkykymdx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknkknx3 = new ExDBFieldString<>("zrnhtnknkykhknkknx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykphrkkknx3 = new ExDBFieldString<>("zrnhtnknkykphrkkknx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkaisuukbnx3 = new ExDBFieldString<>("zrnhtnknkykhrkkaisuukbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkeirokbnx3 = new ExDBFieldString<>("zrnhtnknkykhrkkeirokbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntnknuktkzngtkijyuhyjx3 = new ExDBFieldString<>("zrntnknuktkzngtkijyuhyjx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykmrtisyuruikgux3 = new ExDBFieldString<>("zrnhtnknkykmrtisyuruikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksyonox4 = new ExDBFieldString<>("zrnhtnknkyksyonox4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknsyuruikgux4 = new ExDBFieldString<>("zrnhtnknkykhknsyuruikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntenkanuketukeymdx4 = new ExDBFieldString<>("zrntenkanuketukeymdx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykkykymdx4 = new ExDBFieldString<>("zrnhtnknkykkykymdx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknkknx4 = new ExDBFieldString<>("zrnhtnknkykhknkknx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykphrkkknx4 = new ExDBFieldString<>("zrnhtnknkykphrkkknx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkaisuukbnx4 = new ExDBFieldString<>("zrnhtnknkykhrkkaisuukbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkeirokbnx4 = new ExDBFieldString<>("zrnhtnknkykhrkkeirokbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntnknuktkzngtkijyuhyjx4 = new ExDBFieldString<>("zrntnknuktkzngtkijyuhyjx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykmrtisyuruikgux4 = new ExDBFieldString<>("zrnhtnknkykmrtisyuruikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksyonox5 = new ExDBFieldString<>("zrnhtnknkyksyonox5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknsyuruikgux5 = new ExDBFieldString<>("zrnhtnknkykhknsyuruikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntenkanuketukeymdx5 = new ExDBFieldString<>("zrntenkanuketukeymdx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykkykymdx5 = new ExDBFieldString<>("zrnhtnknkykkykymdx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknkknx5 = new ExDBFieldString<>("zrnhtnknkykhknkknx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykphrkkknx5 = new ExDBFieldString<>("zrnhtnknkykphrkkknx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkaisuukbnx5 = new ExDBFieldString<>("zrnhtnknkykhrkkaisuukbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkeirokbnx5 = new ExDBFieldString<>("zrnhtnknkykhrkkeirokbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntnknuktkzngtkijyuhyjx5 = new ExDBFieldString<>("zrntnknuktkzngtkijyuhyjx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykmrtisyuruikgux5 = new ExDBFieldString<>("zrnhtnknkykmrtisyuruikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksyonox6 = new ExDBFieldString<>("zrnhtnknkyksyonox6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknsyuruikgux6 = new ExDBFieldString<>("zrnhtnknkykhknsyuruikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntenkanuketukeymdx6 = new ExDBFieldString<>("zrntenkanuketukeymdx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykkykymdx6 = new ExDBFieldString<>("zrnhtnknkykkykymdx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhknkknx6 = new ExDBFieldString<>("zrnhtnknkykhknkknx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykphrkkknx6 = new ExDBFieldString<>("zrnhtnknkykphrkkknx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkaisuukbnx6 = new ExDBFieldString<>("zrnhtnknkykhrkkaisuukbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhrkkeirokbnx6 = new ExDBFieldString<>("zrnhtnknkykhrkkeirokbnx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntnknuktkzngtkijyuhyjx6 = new ExDBFieldString<>("zrntnknuktkzngtkijyuhyjx6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykmrtisyuruikgux6 = new ExDBFieldString<>("zrnhtnknkykmrtisyuruikgux6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukihtnknkykkhns = new ExDBFieldNumber<>("zrngukihtnknkykkhns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukihtnknkyksbus = new ExDBFieldNumber<>("zrngukihtnknkyksbus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukihtnknkykhntiyup = new ExDBFieldNumber<>("zrngukihtnknkykhntiyup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukihtnknkyksigwrmstkyks = new ExDBFieldNumber<>("zrngukihtnknkyksigwrmstkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukihtnknkyksyugitkyks = new ExDBFieldNumber<>("zrngukihtnknkyksyugitkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrngukihtnknsignyintkykntgk = new ExDBFieldNumber<>("zrngukihtnknsignyintkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrngukihtnknknkutkykntgk = new ExDBFieldNumber<>("zrngukihtnknknkutkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukihtnknkykmods = new ExDBFieldNumber<>("zrngukihtnknkykmods", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngoukeitenkankakaku = new ExDBFieldNumber<>("zrngoukeitenkankakaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnknjsknnjynbkn = new ExDBFieldNumber<>("zrngukitnknjsknnjynbkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnknsisnkstkkngk = new ExDBFieldNumber<>("zrngukitnknsisnkstkkngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnknsisnttkekngk = new ExDBFieldNumber<>("zrngukitnknsisnttkekngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngoukeitenkanseisand = new ExDBFieldNumber<>("zrngoukeitenkanseisand", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnknsisnmkikp = new ExDBFieldNumber<>("zrngukitnknsisnmkikp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnknsisnsntkngk = new ExDBFieldNumber<>("zrngukitnknsisnsntkngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnknkhnbbnkiykkujygk = new ExDBFieldNumber<>("zrngukitnknkhnbbnkiykkujygk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnkntikbbnkiykkujygk = new ExDBFieldNumber<>("zrngukitnkntikbbnkiykkujygk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrngukitnknitjbrtiks = new ExDBFieldNumber<>("zrngukitnknitjbrtiks", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsethokenno = new ExDBFieldString<>("zrnsethokenno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsckbn = new ExDBFieldString<>("zrnsckbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnenjyosyacd = new ExDBFieldString<>("zrnenjyosyacd", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnnaibuwarimodosigaku = new ExDBFieldNumber<>("zrnnaibuwarimodosigaku", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkeiyakukakuninsyuruikbn = new ExDBFieldString<>("zrnkeiyakukakuninsyuruikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsoujikeitenkanhyouji = new ExDBFieldString<>("zrnsoujikeitenkanhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntenkanjisketteihouhoukbn = new ExDBFieldString<>("zrntenkanjisketteihouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkeikanensuukbn = new ExDBFieldString<>("zrnkeikanensuukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhhknsytisyukbnx1 = new ExDBFieldString<>("zrnhtnknkykhhknsytisyukbnx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhhknsytisyukbnx2 = new ExDBFieldString<>("zrnhtnknkykhhknsytisyukbnx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhhknsytisyukbnx3 = new ExDBFieldString<>("zrnhtnknkykhhknsytisyukbnx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhhknsytisyukbnx4 = new ExDBFieldString<>("zrnhtnknkykhhknsytisyukbnx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhhknsytisyukbnx5 = new ExDBFieldString<>("zrnhtnknkykhhknsytisyukbnx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkykhhknsytisyukbnx6 = new ExDBFieldString<>("zrnhtnknkykhhknsytisyukbnx6", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnkktijgukipbbntnkns = new ExDBFieldNumber<>("zrnkktijgukipbbntnkns", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsyonendosyokaip = new ExDBFieldNumber<>("zrnsyonendosyokaip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsyonendo2kaimeikoup = new ExDBFieldNumber<>("zrnsyonendo2kaimeikoup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnjinendoikoup = new ExDBFieldNumber<>("zrnjinendoikoup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnsyukeiyakusikyuukisogaku = new ExDBFieldNumber<>("zrnsyukeiyakusikyuukisogaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnsykyknenhantatskyuksgk = new ExDBFieldNumber<>("zrnsykyknenhantatskyuksgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnmaruteisikyuukisogaku = new ExDBFieldNumber<>("zrnmaruteisikyuukisogaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnitjbrzugkskyuksgkx1 = new ExDBFieldNumber<>("zrnitjbrzugkskyuksgkx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnitjbrzugkskyuksgkx2 = new ExDBFieldNumber<>("zrnitjbrzugkskyuksgkx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnitjbrzgknnhntatskyksgkx1 = new ExDBFieldNumber<>("zrnitjbrzgknnhntatskyksgkx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnitjbrzgknnhntatskyksgkx2 = new ExDBFieldNumber<>("zrnitjbrzgknnhntatskyksgkx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnkzkmrtiskyuksgk = new ExDBFieldNumber<>("zrnkzkmrtiskyuksgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnitibitjbrskyuksgk = new ExDBFieldNumber<>("zrnitibitjbrskyuksgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnitbitjbrnnhntatskyuksgk = new ExDBFieldNumber<>("zrnitbitjbrnnhntatskyuksgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnsykykksnbsyutat = new ExDBFieldNumber<>("zrnsykykksnbsyutat", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnitjbrzugkksnbsyutatx1 = new ExDBFieldNumber<>("zrnitjbrzugkksnbsyutatx1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnitjbrzugkksnbsyutatx2 = new ExDBFieldNumber<>("zrnitjbrzugkksnbsyutatx2", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnitibitjbrksnbsyutat = new ExDBFieldNumber<>("zrnitibitjbrksnbsyutat", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, BizNumber> zrnjyunkensuu = new ExDBFieldString<>("zrnjyunkensuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, BizNumber> zrnkansankensuu = new ExDBFieldString<>("zrnkansankensuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnitibuitijibaraikikan = new ExDBFieldString<>("zrnitibuitijibaraikikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnitibuitijibarais = new ExDBFieldNumber<>("zrnitibuitijibarais", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnitibuitijibaraip = new ExDBFieldNumber<>("zrnitibuitijibaraip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnitibitjbrsdtpdtkbn = new ExDBFieldString<>("zrnitibitjbrsdtpdtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnitibuitijibaraisyuuseis = new ExDBFieldNumber<>("zrnitibuitijibaraisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnitibitjbrmodsskgnhyj = new ExDBFieldString<>("zrnitibitjbrmodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsuuriyousyoriym = new ExDBFieldString<>("zrnsuuriyousyoriym", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsyosinsinsahouhoukbn = new ExDBFieldString<>("zrnsyosinsinsahouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsaisinsinsahouhoukbn = new ExDBFieldString<>("zrnsaisinsinsahouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseizonmrtisyuruikgu = new ExDBFieldString<>("zrnseizonmrtisyuruikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseizonmaruteikikan = new ExDBFieldString<>("zrnseizonmaruteikikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseizonmrtiphrkkkn = new ExDBFieldString<>("zrnseizonmrtiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnseizonmaruteis = new ExDBFieldNumber<>("zrnseizonmaruteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnseizonmaruteip = new ExDBFieldNumber<>("zrnseizonmaruteip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnseizonmaruteisyuuseis = new ExDBFieldNumber<>("zrnseizonmaruteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseizonmrtimodsskgnhyj = new ExDBFieldString<>("zrnseizonmrtimodsskgnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsiznmrtitkjyukbn = new ExDBFieldString<>("zrnsiznmrtitkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsiznmrtitkjyuskgnkkn = new ExDBFieldString<>("zrnsiznmrtitkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnsiznmrtitkjyuryumshyutn = new ExDBFieldNumber<>("zrnsiznmrtitkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsiznmrtitkjyup = new ExDBFieldNumber<>("zrnsiznmrtitkjyup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnsiznmrtiskyuksgk = new ExDBFieldNumber<>("zrnsiznmrtiskyuksgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksiznmrtsyrikgux1 = new ExDBFieldString<>("zrnhtnknkyksiznmrtsyrikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksiznmrtsyrikgux2 = new ExDBFieldString<>("zrnhtnknkyksiznmrtsyrikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksiznmrtsyrikgux3 = new ExDBFieldString<>("zrnhtnknkyksiznmrtsyrikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksiznmrtsyrikgux4 = new ExDBFieldString<>("zrnhtnknkyksiznmrtsyrikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksiznmrtsyrikgux5 = new ExDBFieldString<>("zrnhtnknkyksiznmrtsyrikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyksiznmrtsyrikgux6 = new ExDBFieldString<>("zrnhtnknkyksiznmrtsyrikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsuryusiznmrtipwrbkkbn = new ExDBFieldString<>("zrnsuryusiznmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsiznmrtipwrbkkbn = new ExDBFieldString<>("zrnsiznmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsiznmrtitnknyugukbn = new ExDBFieldString<>("zrnsiznmrtitnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnseizonmrtikgusdkbn = new ExDBFieldString<>("zrnseizonmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2hihokensyamei = new ExDBFieldString<>("zrndai2hihokensyamei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2kanjihihokensyamei = new ExDBFieldString<>("zrndai2kanjihihokensyamei", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2hihokensyaseiymd = new ExDBFieldString<>("zrndai2hihokensyaseiymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2hihokensyaseibetukbn = new ExDBFieldString<>("zrndai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2hihknsyahnskhkncd = new ExDBFieldString<>("zrndai2hihknsyahnskhkncd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2hhknnen = new ExDBFieldString<>("zrndai2hhknnen", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2hihknsyakikykarihyj = new ExDBFieldString<>("zrndai2hihknsyakikykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnkyksydi2hihknsyaduithyj = new ExDBFieldString<>("zrnkyksydi2hihknsyaduithyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2syosinsinsahouhoukbn = new ExDBFieldString<>("zrndai2syosinsinsahouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2saisinsinsahouhoukbn = new ExDBFieldString<>("zrndai2saisinsinsahouhoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2syokugyoucd = new ExDBFieldString<>("zrndai2syokugyoucd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2sakugenkikan = new ExDBFieldString<>("zrndai2sakugenkikan", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrndai2ryoumasihyouten = new ExDBFieldNumber<>("zrndai2ryoumasihyouten", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnmrtidi2skgnkkn = new ExDBFieldString<>("zrnmrtidi2skgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrnmrtidi2ryumshyutn = new ExDBFieldNumber<>("zrnmrtidi2ryumshyutn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2kykkknnsyrikbn = new ExDBFieldString<>("zrndi2kykkknnsyrikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntignmrtidi2skgnkkn = new ExDBFieldString<>("zrntignmrtidi2skgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrntignmrtidi2ryumshyutn = new ExDBFieldNumber<>("zrntignmrtidi2ryumshyutn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2syosinhonninkknnkbn = new ExDBFieldString<>("zrndai2syosinhonninkknnkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sisnhonninkknnkbn = new ExDBFieldString<>("zrndi2sisnhonninkknnkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv9x6 = new ExDBFieldString<>("zrnyobiv9x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2syugitkyksyrikgu = new ExDBFieldString<>("zrndi2syugitkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2syougaitokuyakukikan = new ExDBFieldString<>("zrndai2syougaitokuyakukikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2syugitkykphrkkkn = new ExDBFieldString<>("zrndi2syugitkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrndai2syougaitokuyakus = new ExDBFieldNumber<>("zrndai2syougaitokuyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrndai2syougaitokuyakup = new ExDBFieldNumber<>("zrndai2syougaitokuyakup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2syugitkykgtkbn = new ExDBFieldString<>("zrndi2syugitkykgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2syugitkykkgusdkbn = new ExDBFieldString<>("zrndi2syugitkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2syugitkykpwrbkkbn = new ExDBFieldString<>("zrndi2syugitkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sigiwrmstkyksyrikgu = new ExDBFieldString<>("zrndi2sigiwrmstkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sigiwrmstkykkkn = new ExDBFieldString<>("zrndi2sigiwrmstkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sigiwrmstkykphrkkkn = new ExDBFieldString<>("zrndi2sigiwrmstkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrndi2sigiwrmstkyks = new ExDBFieldNumber<>("zrndi2sigiwrmstkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrndi2sigiwrmstkykp = new ExDBFieldNumber<>("zrndi2sigiwrmstkykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sigiwrmstkykkgusdkbn = new ExDBFieldString<>("zrndi2sigiwrmstkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sigiwrmstkykpwrbkkbn = new ExDBFieldString<>("zrndi2sigiwrmstkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv9x7 = new ExDBFieldString<>("zrnyobiv9x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2siginyuintkyksyrikgu = new ExDBFieldString<>("zrndi2siginyuintkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2siginyuintkykkkn = new ExDBFieldString<>("zrndi2siginyuintkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2siginyuintkykphrkkkn = new ExDBFieldString<>("zrndi2siginyuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrndi2siginyuintkykntgk = new ExDBFieldNumber<>("zrndi2siginyuintkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrndi2siginyuintkykp = new ExDBFieldNumber<>("zrndi2siginyuintkykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2siginyuintkykgtkbn = new ExDBFieldString<>("zrndi2siginyuintkykgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2siginyintkykkgusdkbn = new ExDBFieldString<>("zrndi2siginyintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2siginyuintkykpwrbkkbn = new ExDBFieldString<>("zrndi2siginyuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv10x3 = new ExDBFieldString<>("zrnyobiv10x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyuintkyksyrikgu = new ExDBFieldString<>("zrndi2sppinyuintkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyuintkykkkn = new ExDBFieldString<>("zrndi2sppinyuintkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyuintkykphrkkkn = new ExDBFieldString<>("zrndi2sppinyuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrndi2sppinyuintkykntgk = new ExDBFieldNumber<>("zrndi2sppinyuintkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrndi2sppinyuintkykp = new ExDBFieldNumber<>("zrndi2sppinyuintkykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyuintkykgtkbn = new ExDBFieldString<>("zrndi2sppinyuintkykgtkbn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrndi2sppinyintkjyryumshytn = new ExDBFieldNumber<>("zrndi2sppinyintkjyryumshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrndi2sppinyuintkjyup = new ExDBFieldNumber<>("zrndi2sppinyuintkjyup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyuintktbicdx1 = new ExDBFieldString<>("zrndi2sppinyuintktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyuinhtnpkknx1 = new ExDBFieldString<>("zrndi2sppinyuinhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyuintktbicdx2 = new ExDBFieldString<>("zrndi2sppinyuintktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyuinhtnpkknx2 = new ExDBFieldString<>("zrndi2sppinyuinhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyintkykkgusdkbn = new ExDBFieldString<>("zrndi2sppinyintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sppinyuintkykpwrbkkbn = new ExDBFieldString<>("zrndi2sppinyuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv3x2 = new ExDBFieldString<>("zrnyobiv3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbyutkyksyrikgu = new ExDBFieldString<>("zrndi2sijnbyutkyksyrikgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbyutkykkkn = new ExDBFieldString<>("zrndi2sijnbyutkykkkn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbyutkykphrkkkn = new ExDBFieldString<>("zrndi2sijnbyutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrndi2sijnbyutkykntgk = new ExDBFieldNumber<>("zrndi2sijnbyutkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrndai2seijinbyoutokuyakup = new ExDBFieldNumber<>("zrndai2seijinbyoutokuyakup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrndi2sijnbyutkjyurymshytn = new ExDBFieldNumber<>("zrndi2sijnbyutkjyurymshytn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrndai2seijinbyoutokujyoup = new ExDBFieldNumber<>("zrndai2seijinbyoutokujyoup", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbyutktbicdx1 = new ExDBFieldString<>("zrndi2sijnbyutktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbyuhtnpkknx1 = new ExDBFieldString<>("zrndi2sijnbyuhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbyutktbicdx2 = new ExDBFieldString<>("zrndi2sijnbyutktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbyuhtnpkknx2 = new ExDBFieldString<>("zrndi2sijnbyuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbyutkykkgusdkbn = new ExDBFieldString<>("zrndi2sijnbyutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbytkykgankyhgtkbn = new ExDBFieldString<>("zrndi2sijnbytkykgankyhgtkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndi2sijnbyutkykpwrbkkbn = new ExDBFieldString<>("zrndi2sijnbyutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv3x3 = new ExDBFieldString<>("zrnyobiv3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrndai2jyoukentukihyouji = new ExDBFieldString<>("zrndai2jyoukentukihyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntignmrtisyukgu = new ExDBFieldString<>("zrntignmrtisyukgu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteigenmaruteikikan = new ExDBFieldString<>("zrnteigenmaruteikikan", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteigenmrtiphrkkkn = new ExDBFieldString<>("zrnteigenmrtiphrkkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnteigenmaruteis = new ExDBFieldNumber<>("zrnteigenmaruteis", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnteigenmaruteip = new ExDBFieldNumber<>("zrnteigenmaruteip", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnteigenmaruteisyuuseis = new ExDBFieldNumber<>("zrnteigenmaruteisyuuseis", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteigenmrtimodssakugenhyj = new ExDBFieldString<>("zrnteigenmrtimodssakugenhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntignmrtitkjyukbn = new ExDBFieldString<>("zrntignmrtitkjyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntignmrtitkjyuskgnkkn = new ExDBFieldString<>("zrntignmrtitkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrntignmrtitkjyuryumshyutn = new ExDBFieldNumber<>("zrntignmrtitkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrntignmrtitkjyup = new ExDBFieldNumber<>("zrntignmrtitkjyup", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Integer> zrntignmrtiskyuksgk = new ExDBFieldNumber<>("zrntignmrtiskyuksgk", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyktignmrtsyrikgux1 = new ExDBFieldString<>("zrnhtnknkyktignmrtsyrikgux1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyktignmrtsyrikgux2 = new ExDBFieldString<>("zrnhtnknkyktignmrtsyrikgux2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyktignmrtsyrikgux3 = new ExDBFieldString<>("zrnhtnknkyktignmrtsyrikgux3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyktignmrtsyrikgux4 = new ExDBFieldString<>("zrnhtnknkyktignmrtsyrikgux4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyktignmrtsyrikgux5 = new ExDBFieldString<>("zrnhtnknkyktignmrtsyrikgux5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnhtnknkyktignmrtsyrikgux6 = new ExDBFieldString<>("zrnhtnknkyktignmrtsyrikgux6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsuryutignmrtipwrbkkbn = new ExDBFieldString<>("zrnsuryutignmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntignmrtipwrbkkbn = new ExDBFieldString<>("zrntignmrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntignmrtitnknyugukbn = new ExDBFieldString<>("zrntignmrtitnknyugukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnteigenmrtikgusdkbn = new ExDBFieldString<>("zrnteigenmrtikgusdkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv1x2 = new ExDBFieldString<>("zrnyobiv1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrntktsppisetkykkbn = new ExDBFieldString<>("zrntktsppisetkykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnjyudmnsiskknsetkykkbn = new ExDBFieldString<>("zrnjyudmnsiskknsetkykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsetaitesyono1 = new ExDBFieldString<>("zrnsetaitesyono1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsetaitehokensyuruikigou1 = new ExDBFieldString<>("zrnsetaitehokensyuruikigou1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsetaitemrtisyuruikgu1 = new ExDBFieldString<>("zrnsetaitemrtisyuruikgu1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsetaitesiznmrtisyurui1 = new ExDBFieldString<>("zrnsetaitesiznmrtisyurui1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsetaitetignmrtisyurui1 = new ExDBFieldString<>("zrnsetaitetignmrtisyurui1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetaitekihonbubuns1 = new ExDBFieldNumber<>("zrnsetaitekihonbubuns1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetgukitnknitjbrkhns1 = new ExDBFieldNumber<>("zrnsetgukitnknitjbrkhns1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetaitesibous1 = new ExDBFieldNumber<>("zrnsetaitesibous1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetgukitnknitjbrsbus1 = new ExDBFieldNumber<>("zrnsetgukitnknitjbrsbus1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetaitesyuuseis1 = new ExDBFieldNumber<>("zrnsetaitesyuuseis1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetaiteharaikomip1 = new ExDBFieldNumber<>("zrnsetaiteharaikomip1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetaitesyukeiyakububunp1 = new ExDBFieldNumber<>("zrnsetaitesyukeiyakububunp1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetaitgukikzkmrtis1 = new ExDBFieldNumber<>("zrnsetaitgukikzkmrtis1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsetaitetenkankykhyj1 = new ExDBFieldString<>("zrnsetaitetenkankykhyj1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetaitesiteimhrkp1 = new ExDBFieldNumber<>("zrnsetaitesiteimhrkp1", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu1Rn, Long> zrnsetaitesiteimsykykp1 = new ExDBFieldNumber<>("zrnsetaitesiteimsykykp1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnsetaitenkmrtisyurui1 = new ExDBFieldString<>("zrnsetaitenkmrtisyurui1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu1Rn, String> zrnyobiv18 = new ExDBFieldString<>("zrnyobiv18", this);
}
