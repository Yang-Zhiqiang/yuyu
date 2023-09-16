package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_AlmNnknHyuTy;

/**
 * ＡＬＭ用年金保有明細テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_AlmNnknHyuTy extends AbstractExDBTable<ZT_AlmNnknHyuTy> {

    public GenQZT_AlmNnknHyuTy() {
        this("ZT_AlmNnknHyuTy");
    }

    public GenQZT_AlmNnknHyuTy(String pAlias) {
        super("ZT_AlmNnknHyuTy", ZT_AlmNnknHyuTy.class, pAlias);
    }

    public String ZT_AlmNnknHyuTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynksyuruikbn = new ExDBFieldString<>("ztynksyuruikbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynenkinkbn = new ExDBFieldString<>("ztynenkinkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynenkinsyu = new ExDBFieldString<>("ztynenkinsyu", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykknsetymd = new ExDBFieldString<>("ztykknsetymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztysyokainenkinsiharaiymd = new ExDBFieldString<>("ztysyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynenkinhosyoukikan = new ExDBFieldString<>("ztynenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztykeiyakujikihonnenkingaku = new ExDBFieldNumber<>("ztykeiyakujikihonnenkingaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztykasannkgk = new ExDBFieldNumber<>("ztykasannkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztynewmoneynenkingaku = new ExDBFieldNumber<>("ztynewmoneynenkingaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztytenkanitijibarainkgk = new ExDBFieldNumber<>("ztytenkanitijibarainkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyitibitjbratamakinnkgk = new ExDBFieldNumber<>("ztyitibitjbratamakinnkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyitibitjbrtyuutohknkgk = new ExDBFieldNumber<>("ztyitibitjbrtyuutohknkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztynenkinkaisijigensi = new ExDBFieldNumber<>("ztynenkinkaisijigensi", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztynewmoneygaku = new ExDBFieldNumber<>("ztynewmoneygaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztynewmoneybubunnenkingensi = new ExDBFieldNumber<>("ztynewmoneybubunnenkingensi", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyhitenkankeiyakukykymd = new ExDBFieldString<>("ztyhitenkankeiyakukykymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyitibitjbrtyuutohkymd = new ExDBFieldString<>("ztyitibitjbrtyuutohkymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztypitijibaraihyouji = new ExDBFieldString<>("ztypitijibaraihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztytokuyakuarihyouji = new ExDBFieldString<>("ztytokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynkkaisigoyoteiriritukbn = new ExDBFieldString<>("ztynkkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynksgoyoteisibouritukbn = new ExDBFieldString<>("ztynksgoyoteisibouritukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynenkinjimutesuuryoukbn = new ExDBFieldString<>("ztynenkinjimutesuuryoukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztymaeatuatoatukbn = new ExDBFieldString<>("ztymaeatuatoatukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyteizounksiboujihknnendo = new ExDBFieldString<>("ztyteizounksiboujihknnendo", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynksjihihokensyaage = new ExDBFieldString<>("ztynksjihihokensyaage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztydai2hihokensyaseibetukbn = new ExDBFieldString<>("ztydai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynksjidai2hhknsyaage = new ExDBFieldString<>("ztynksjidai2hhknsyaage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyjgyunendosikitoutatuage = new ExDBFieldString<>("ztyjgyunendosikitoutatuage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyitijikinsiharaiymd = new ExDBFieldString<>("ztyitijikinsiharaiymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyhihokensyasibouymd = new ExDBFieldString<>("ztyhihokensyasibouymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztydai2hihokensyasibouymd = new ExDBFieldString<>("ztydai2hihokensyasibouymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyyoteii = new ExDBFieldString<>("ztyyoteii", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztysibouhyoukbn = new ExDBFieldString<>("ztysibouhyoukbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztydnendo = new ExDBFieldString<>("ztydnendo", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztytounendod = new ExDBFieldNumber<>("ztytounendod", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynktouduketorihouhoukbn = new ExDBFieldString<>("ztynktouduketorihouhoukbn", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztytumitated = new ExDBFieldNumber<>("ztytumitated", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyyouikunenkinarihyouji = new ExDBFieldString<>("ztyyouikunenkinarihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyalmnenkinsyoumetucd = new ExDBFieldString<>("ztyalmnenkinsyoumetucd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykaimasinenkinarihyouji = new ExDBFieldString<>("ztykaimasinenkinarihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykaimasinkkouryokusymd = new ExDBFieldString<>("ztykaimasinkkouryokusymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykaimasinenkinkbn = new ExDBFieldString<>("ztykaimasinenkinkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykaimasinenkinsyuruikigou = new ExDBFieldString<>("ztykaimasinenkinsyuruikigou", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykaimasinkshrkkn = new ExDBFieldString<>("ztykaimasinkshrkkn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykaimasinenkinhosyoukikan = new ExDBFieldString<>("ztykaimasinenkinhosyoukikan", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykaimasinkhhknsyaage = new ExDBFieldString<>("ztykaimasinkhhknsyaage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykimsnkdai2hhknsyaage = new ExDBFieldString<>("ztykimsnkdai2hhknsyaage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztysaisyuukousinymd = new ExDBFieldString<>("ztysaisyuukousinymd", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztykaimasinenkingaku = new ExDBFieldNumber<>("ztykaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyzennendokaimasinkgk = new ExDBFieldNumber<>("ztyzennendokaimasinkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztytounendokaimasinenkind = new ExDBFieldNumber<>("ztytounendokaimasinenkind", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztymaeatuatoatukouryokusymd = new ExDBFieldString<>("ztymaeatuatoatukouryokusymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztymaeatuatoatukikan = new ExDBFieldString<>("ztymaeatuatoatukikan", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztymaeatuatoatuhendougonkgk = new ExDBFieldNumber<>("ztymaeatuatoatuhendougonkgk", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyatoatusaisyuukaimasiymd = new ExDBFieldString<>("ztyatoatusaisyuukaimasiymd", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyatoatukaimasinenkingaku = new ExDBFieldNumber<>("ztyatoatukaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyznnndatoatukaimasinkgk = new ExDBFieldNumber<>("ztyznnndatoatukaimasinkgk", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztytounendatoatukaimasinkd = new ExDBFieldNumber<>("ztytounendatoatukaimasinkd", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyuwanoseatoatukaimasinkgk = new ExDBFieldNumber<>("ztyuwanoseatoatukaimasinkgk", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynkuktorininhhknsyadouhyj = new ExDBFieldString<>("ztynkuktorininhhknsyadouhyj", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynkuktrnndi2hhknsyadouhyj = new ExDBFieldString<>("ztynkuktrnndi2hhknsyadouhyj", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynkuketorininsakuinnmno = new ExDBFieldString<>("ztynkuketorininsakuinnmno", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztydrtenkanritodoufukencd = new ExDBFieldString<>("ztydrtenkanritodoufukencd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztydairiten1sosikicd = new ExDBFieldString<>("ztydairiten1sosikicd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztybosyuunin1cd = new ExDBFieldString<>("ztybosyuunin1cd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztybosyuunin1keisyousisyacd = new ExDBFieldString<>("ztybosyuunin1keisyousisyacd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztybosyuunin1zaisekihyouji = new ExDBFieldString<>("ztybosyuunin1zaisekihyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztybosyuunin1bosyuujiage = new ExDBFieldString<>("ztybosyuunin1bosyuujiage", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztybosyunin1bosyujisikakucd = new ExDBFieldString<>("ztybosyunin1bosyujisikakucd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztybosyuunin1sikakucd = new ExDBFieldString<>("ztybosyuunin1sikakucd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynkkknmanryouymd = new ExDBFieldString<>("ztynkkknmanryouymd", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykijyunym = new ExDBFieldString<>("ztykijyunym", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztynenkinkigousedaikbn = new ExDBFieldString<>("ztynenkinkigousedaikbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztykaimasinkkigousdkbn = new ExDBFieldString<>("ztykaimasinkkigousdkbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyalmrrthendounkyoteirrt = new ExDBFieldString<>("ztyalmrrthendounkyoteirrt", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyalmrrthendounksitihsyrrt = new ExDBFieldString<>("ztyalmrrthendounksitihsyrrt", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztynenkansanp = new ExDBFieldNumber<>("ztynenkansanp", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyyobiv30 = new ExDBFieldString<>("ztyyobiv30", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_AlmNnknHyuTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyyobiv8x3 = new ExDBFieldString<>("ztyyobiv8x3", this);

    public final ExDBFieldString<ZT_AlmNnknHyuTy, String> ztyyobiv8x4 = new ExDBFieldString<>("ztyyobiv8x4", this);
}
