package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_AlmNnknHyuRn;

/**
 * ＡＬＭ用年金保有明細テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_AlmNnknHyuRn extends AbstractExDBTable<ZT_AlmNnknHyuRn> {

    public GenQZT_AlmNnknHyuRn() {
        this("ZT_AlmNnknHyuRn");
    }

    public GenQZT_AlmNnknHyuRn(String pAlias) {
        super("ZT_AlmNnknHyuRn", ZT_AlmNnknHyuRn.class, pAlias);
    }

    public String ZT_AlmNnknHyuRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnksyuruikbn = new ExDBFieldString<>("zrnnksyuruikbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnenkinkbn = new ExDBFieldString<>("zrnnenkinkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnenkinsyu = new ExDBFieldString<>("zrnnenkinsyu", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkknsetymd = new ExDBFieldString<>("zrnkknsetymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnsyokainenkinsiharaiymd = new ExDBFieldString<>("zrnsyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnenkinhosyoukikan = new ExDBFieldString<>("zrnnenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnkeiyakujikihonnenkingaku = new ExDBFieldNumber<>("zrnkeiyakujikihonnenkingaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnkasannkgk = new ExDBFieldNumber<>("zrnkasannkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnnewmoneynenkingaku = new ExDBFieldNumber<>("zrnnewmoneynenkingaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrntenkanitijibarainkgk = new ExDBFieldNumber<>("zrntenkanitijibarainkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnitibitjbratamakinnkgk = new ExDBFieldNumber<>("zrnitibitjbratamakinnkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnitibitjbrtyuutohknkgk = new ExDBFieldNumber<>("zrnitibitjbrtyuutohknkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnnenkinkaisijigensi = new ExDBFieldNumber<>("zrnnenkinkaisijigensi", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnnewmoneygaku = new ExDBFieldNumber<>("zrnnewmoneygaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnnewmoneybubunnenkingensi = new ExDBFieldNumber<>("zrnnewmoneybubunnenkingensi", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnhitenkankeiyakukykymd = new ExDBFieldString<>("zrnhitenkankeiyakukykymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnitibitjbrtyuutohkymd = new ExDBFieldString<>("zrnitibitjbrtyuutohkymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnpitijibaraihyouji = new ExDBFieldString<>("zrnpitijibaraihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrntokuyakuarihyouji = new ExDBFieldString<>("zrntokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnkkaisigoyoteiriritukbn = new ExDBFieldString<>("zrnnkkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnksgoyoteisibouritukbn = new ExDBFieldString<>("zrnnksgoyoteisibouritukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnenkinjimutesuuryoukbn = new ExDBFieldString<>("zrnnenkinjimutesuuryoukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnmaeatuatoatukbn = new ExDBFieldString<>("zrnmaeatuatoatukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnteizounksiboujihknnendo = new ExDBFieldString<>("zrnteizounksiboujihknnendo", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnksjihihokensyaage = new ExDBFieldString<>("zrnnksjihihokensyaage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrndai2hihokensyaseibetukbn = new ExDBFieldString<>("zrndai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnksjidai2hhknsyaage = new ExDBFieldString<>("zrnnksjidai2hhknsyaage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnjgyunendosikitoutatuage = new ExDBFieldString<>("zrnjgyunendosikitoutatuage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnitijikinsiharaiymd = new ExDBFieldString<>("zrnitijikinsiharaiymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnhihokensyasibouymd = new ExDBFieldString<>("zrnhihokensyasibouymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrndai2hihokensyasibouymd = new ExDBFieldString<>("zrndai2hihokensyasibouymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnyoteii = new ExDBFieldString<>("zrnyoteii", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnsibouhyoukbn = new ExDBFieldString<>("zrnsibouhyoukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrndnendo = new ExDBFieldString<>("zrndnendo", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrntounendod = new ExDBFieldNumber<>("zrntounendod", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnktouduketorihouhoukbn = new ExDBFieldString<>("zrnnktouduketorihouhoukbn", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrntumitated = new ExDBFieldNumber<>("zrntumitated", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnyouikunenkinarihyouji = new ExDBFieldString<>("zrnyouikunenkinarihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnalmnenkinsyoumetucd = new ExDBFieldString<>("zrnalmnenkinsyoumetucd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkaimasinenkinarihyouji = new ExDBFieldString<>("zrnkaimasinenkinarihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkaimasinkkouryokusymd = new ExDBFieldString<>("zrnkaimasinkkouryokusymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkaimasinenkinkbn = new ExDBFieldString<>("zrnkaimasinenkinkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkaimasinenkinsyuruikigou = new ExDBFieldString<>("zrnkaimasinenkinsyuruikigou", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkaimasinkshrkkn = new ExDBFieldString<>("zrnkaimasinkshrkkn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkaimasinenkinhosyoukikan = new ExDBFieldString<>("zrnkaimasinenkinhosyoukikan", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkaimasinkhhknsyaage = new ExDBFieldString<>("zrnkaimasinkhhknsyaage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkimsnkdai2hhknsyaage = new ExDBFieldString<>("zrnkimsnkdai2hhknsyaage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnsaisyuukousinymd = new ExDBFieldString<>("zrnsaisyuukousinymd", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnkaimasinenkingaku = new ExDBFieldNumber<>("zrnkaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnzennendokaimasinkgk = new ExDBFieldNumber<>("zrnzennendokaimasinkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrntounendokaimasinenkind = new ExDBFieldNumber<>("zrntounendokaimasinenkind", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnmaeatuatoatukouryokusymd = new ExDBFieldString<>("zrnmaeatuatoatukouryokusymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnmaeatuatoatukikan = new ExDBFieldString<>("zrnmaeatuatoatukikan", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnmaeatuatoatuhendougonkgk = new ExDBFieldNumber<>("zrnmaeatuatoatuhendougonkgk", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnatoatusaisyuukaimasiymd = new ExDBFieldString<>("zrnatoatusaisyuukaimasiymd", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnatoatukaimasinenkingaku = new ExDBFieldNumber<>("zrnatoatukaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnznnndatoatukaimasinkgk = new ExDBFieldNumber<>("zrnznnndatoatukaimasinkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrntounendatoatukaimasinkd = new ExDBFieldNumber<>("zrntounendatoatukaimasinkd", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnuwanoseatoatukaimasinkgk = new ExDBFieldNumber<>("zrnuwanoseatoatukaimasinkgk", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnkuktorininhhknsyadouhyj = new ExDBFieldString<>("zrnnkuktorininhhknsyadouhyj", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnkuktrnndi2hhknsyadouhyj = new ExDBFieldString<>("zrnnkuktrnndi2hhknsyadouhyj", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnkuketorininsakuinnmno = new ExDBFieldString<>("zrnnkuketorininsakuinnmno", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrndrtenkanritodoufukencd = new ExDBFieldString<>("zrndrtenkanritodoufukencd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrndairiten1sosikicd = new ExDBFieldString<>("zrndairiten1sosikicd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnbosyuunin1cd = new ExDBFieldString<>("zrnbosyuunin1cd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnbosyuunin1keisyousisyacd = new ExDBFieldString<>("zrnbosyuunin1keisyousisyacd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnbosyuunin1zaisekihyouji = new ExDBFieldString<>("zrnbosyuunin1zaisekihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnbosyuunin1bosyuujiage = new ExDBFieldString<>("zrnbosyuunin1bosyuujiage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnbosyunin1bosyujisikakucd = new ExDBFieldString<>("zrnbosyunin1bosyujisikakucd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnbosyuunin1sikakucd = new ExDBFieldString<>("zrnbosyuunin1sikakucd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnkkknmanryouymd = new ExDBFieldString<>("zrnnkkknmanryouymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkijyunym = new ExDBFieldString<>("zrnkijyunym", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnnenkinkigousedaikbn = new ExDBFieldString<>("zrnnenkinkigousedaikbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnkaimasinkkigousdkbn = new ExDBFieldString<>("zrnkaimasinkkigousdkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnalmrrthendounkyoteirrt = new ExDBFieldString<>("zrnalmrrthendounkyoteirrt", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnalmrrthendounksitihsyrrt = new ExDBFieldString<>("zrnalmrrthendounksitihsyrrt", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnnenkansanp = new ExDBFieldNumber<>("zrnnenkansanp", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnyobiv30 = new ExDBFieldString<>("zrnyobiv30", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnyobiv8x3 = new ExDBFieldString<>("zrnyobiv8x3", this);

    public final ExDBFieldString<ZT_AlmNnknHyuRn, String> zrnyobiv8x4 = new ExDBFieldString<>("zrnyobiv8x4", this);
}
