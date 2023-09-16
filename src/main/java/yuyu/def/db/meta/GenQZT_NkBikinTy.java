package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkBikinTy;

/**
 * 年金備金テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkBikinTy extends AbstractExDBTable<ZT_NkBikinTy> {

    public GenQZT_NkBikinTy() {
        this("ZT_NkBikinTy");
    }

    public GenQZT_NkBikinTy(String pAlias) {
        super("ZT_NkBikinTy", ZT_NkBikinTy.class, pAlias);
    }

    public String ZT_NkBikinTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyidouymd = new ExDBFieldString<>("ztyidouymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztysyouin = new ExDBFieldString<>("ztysyouin", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikbn = new ExDBFieldString<>("ztynksyuruikbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynenkinkbn = new ExDBFieldString<>("ztynenkinkbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynenkinsyu = new ExDBFieldString<>("ztynenkinsyu", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynenkinkaisikbn = new ExDBFieldString<>("ztynenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztysyokainenkinsiharaiymd = new ExDBFieldString<>("ztysyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynenkinhosyoukikan = new ExDBFieldString<>("ztynenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztysaisyuukousinymd = new ExDBFieldString<>("ztysaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztysaisyuukousinsyoricd = new ExDBFieldString<>("ztysaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztynenkinkihonctr = new ExDBFieldNumber<>("ztynenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztycurrentday = new ExDBFieldString<>("ztycurrentday", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztycurrenttime = new ExDBFieldString<>("ztycurrenttime", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztykessanjibikinkbn = new ExDBFieldString<>("ztykessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyoumetucd = new ExDBFieldString<>("ztynksyoumetucd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyoumetuymd = new ExDBFieldString<>("ztynksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztykouryokuhasseiymd = new ExDBFieldString<>("ztykouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztykingakuzoukanaiyoukbn = new ExDBFieldString<>("ztykingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztymotokeiyakusyouhinkbn = new ExDBFieldString<>("ztymotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynenkinkigousedaikbn = new ExDBFieldString<>("ztynenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Double> ztyrrthendounkyoteirrt = new ExDBFieldNumber<>("ztyrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Double> ztyrrthendounksitihsyurrt = new ExDBFieldNumber<>("ztyrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("ztyhenkoumaekihonnenkingaku", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztysyokainenkingaku = new ExDBFieldNumber<>("ztysyokainenkingaku", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztysyokaisiharaijitokubetud = new ExDBFieldNumber<>("ztysyokaisiharaijitokubetud", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztysyokaisiharaijikaimasis = new ExDBFieldNumber<>("ztysyokaisiharaijikaimasis", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztysyokaisiharaijisonotad = new ExDBFieldNumber<>("ztysyokaisiharaijisonotad", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztysyokaisiharaijimisyuup = new ExDBFieldNumber<>("ztysyokaisiharaijimisyuup", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyidounenkinnengaku = new ExDBFieldNumber<>("ztyidounenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztysetteijikikinsougaku = new ExDBFieldNumber<>("ztysetteijikikinsougaku", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztytenkanitijibarainkgk = new ExDBFieldNumber<>("ztytenkanitijibarainkgk", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztykasannkgk = new ExDBFieldNumber<>("ztykasannkgk", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyuwanosenenkingaku = new ExDBFieldNumber<>("ztyuwanosenenkingaku", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztysyukeiyakunenkingaku = new ExDBFieldNumber<>("ztysyukeiyakunenkingaku", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytokuyakuarihyouji = new ExDBFieldString<>("ztytokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynenkinsiharainaiyoukbn = new ExDBFieldString<>("ztynenkinsiharainaiyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyitijikinsiharaiymd = new ExDBFieldString<>("ztyitijikinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztykknsetymd = new ExDBFieldString<>("ztykknsetymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynkkaisigoyoteiriritukbn = new ExDBFieldString<>("ztynkkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksgoyoteisibouritukbn = new ExDBFieldString<>("ztynksgoyoteisibouritukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynenkinjimutesuuryoukbn = new ExDBFieldString<>("ztynenkinjimutesuuryoukbn", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Double> ztyteizouritu = new ExDBFieldNumber<>("ztyteizouritu", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztymaeatuatoatukbn = new ExDBFieldString<>("ztymaeatuatoatukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytokusyunenkinnaiyoukbn = new ExDBFieldString<>("ztytokusyunenkinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztysiharaikaisuukbn = new ExDBFieldString<>("ztysiharaikaisuukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztykgyunkyusykishrtukisuu = new ExDBFieldString<>("ztykgyunkyusykishrtukisuu", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyteizounksiboujihknnendo = new ExDBFieldString<>("ztyteizounksiboujihknnendo", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztydkigetu = new ExDBFieldString<>("ztydkigetu", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztytounendod = new ExDBFieldNumber<>("ztytounendod", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztynenkinyousiharaid = new ExDBFieldNumber<>("ztynenkinyousiharaid", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztysiharainenkingaku = new ExDBFieldNumber<>("ztysiharainenkingaku", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztysiharaisyoruiuketukeymd = new ExDBFieldString<>("ztysiharaisyoruiuketukeymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztysiharaiuketukebasyo = new ExDBFieldString<>("ztysiharaiuketukebasyo", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyshiharaihasseiymd = new ExDBFieldString<>("ztyshiharaihasseiymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksjihihokensyaage = new ExDBFieldString<>("ztynksjihihokensyaage", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyhihokensyasibouymd = new ExDBFieldString<>("ztyhihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztydai2hihokensyaseibetukbn = new ExDBFieldString<>("ztydai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksjidai2hhknsyaage = new ExDBFieldString<>("ztynksjidai2hhknsyaage", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztydai2hihokensyasibouymd = new ExDBFieldString<>("ztydai2hihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztydai2hihokensyaseiymd = new ExDBFieldString<>("ztydai2hihokensyaseiymd", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynkhknhoutekiyouhyj = new ExDBFieldString<>("ztynkhknhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytuusinsakiyuubinno = new ExDBFieldString<>("ztytuusinsakiyuubinno", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytuusinsakitikucd = new ExDBFieldString<>("ztytuusinsakitikucd", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv1x3 = new ExDBFieldString<>("ztyyobiv1x3", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv1x4 = new ExDBFieldString<>("ztyyobiv1x4", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv8x3 = new ExDBFieldString<>("ztyyobiv8x3", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv8x4 = new ExDBFieldString<>("ztyyobiv8x4", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv59 = new ExDBFieldString<>("ztyyobiv59", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x1 = new ExDBFieldString<>("ztynksyuruikguyobi1x1", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x2 = new ExDBFieldString<>("ztynksyuruikguyobi1x2", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x3 = new ExDBFieldString<>("ztynksyuruikguyobi1x3", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x4 = new ExDBFieldString<>("ztynksyuruikguyobi1x4", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x5 = new ExDBFieldString<>("ztynksyuruikguyobi1x5", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x6 = new ExDBFieldString<>("ztynksyuruikguyobi1x6", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x7 = new ExDBFieldString<>("ztynksyuruikguyobi1x7", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x8 = new ExDBFieldString<>("ztynksyuruikguyobi1x8", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x9 = new ExDBFieldString<>("ztynksyuruikguyobi1x9", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x10 = new ExDBFieldString<>("ztynksyuruikguyobi1x10", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x11 = new ExDBFieldString<>("ztynksyuruikguyobi1x11", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x12 = new ExDBFieldString<>("ztynksyuruikguyobi1x12", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x13 = new ExDBFieldString<>("ztynksyuruikguyobi1x13", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x14 = new ExDBFieldString<>("ztynksyuruikguyobi1x14", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi1x15 = new ExDBFieldString<>("ztynksyuruikguyobi1x15", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x1 = new ExDBFieldString<>("ztynksyuruikguyobi2x1", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x2 = new ExDBFieldString<>("ztynksyuruikguyobi2x2", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x3 = new ExDBFieldString<>("ztynksyuruikguyobi2x3", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x4 = new ExDBFieldString<>("ztynksyuruikguyobi2x4", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x5 = new ExDBFieldString<>("ztynksyuruikguyobi2x5", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x6 = new ExDBFieldString<>("ztynksyuruikguyobi2x6", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x7 = new ExDBFieldString<>("ztynksyuruikguyobi2x7", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x8 = new ExDBFieldString<>("ztynksyuruikguyobi2x8", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x9 = new ExDBFieldString<>("ztynksyuruikguyobi2x9", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi2x10 = new ExDBFieldString<>("ztynksyuruikguyobi2x10", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x1 = new ExDBFieldString<>("ztynksyuruikguyobi3x1", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x2 = new ExDBFieldString<>("ztynksyuruikguyobi3x2", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x3 = new ExDBFieldString<>("ztynksyuruikguyobi3x3", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x4 = new ExDBFieldString<>("ztynksyuruikguyobi3x4", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x5 = new ExDBFieldString<>("ztynksyuruikguyobi3x5", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x6 = new ExDBFieldString<>("ztynksyuruikguyobi3x6", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x7 = new ExDBFieldString<>("ztynksyuruikguyobi3x7", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x8 = new ExDBFieldString<>("ztynksyuruikguyobi3x8", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x9 = new ExDBFieldString<>("ztynksyuruikguyobi3x9", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztynksyuruikguyobi3x10 = new ExDBFieldString<>("ztynksyuruikguyobi3x10", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytoukeisyuuseisyorikbn = new ExDBFieldString<>("ztytoukeisyuuseisyorikbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytoukeimodkurykhssiymd = new ExDBFieldString<>("ztytoukeimodkurykhssiymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytoukeimoddenpyouymd = new ExDBFieldString<>("ztytoukeimoddenpyouymd", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytoukeimodbikinmodkbn = new ExDBFieldString<>("ztytoukeimodbikinmodkbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytoukeimodbikinshrymd = new ExDBFieldString<>("ztytoukeimodbikinshrymd", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztytoukeimodbikinkijyugk = new ExDBFieldNumber<>("ztytoukeimodbikinkijyugk", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztybikinnaiyoukbn = new ExDBFieldString<>("ztybikinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztybikinkeiyakujyoukyoukbn = new ExDBFieldString<>("ztybikinkeiyakujyoukyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztykaimasinenkinarihyouji = new ExDBFieldString<>("ztykaimasinenkinarihyouji", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztymaeatuatoatusegarihyj = new ExDBFieldString<>("ztymaeatuatoatusegarihyj", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyzaikeiyuatatkimsnkarihyj = new ExDBFieldString<>("ztyzaikeiyuatatkimsnkarihyj", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztytyouhyousakuseitanikbn = new ExDBFieldString<>("ztytyouhyousakuseitanikbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyshrnkgknaiyoukbn = new ExDBFieldString<>("ztyshrnkgknaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkBikinTy, Long> ztyutikaimasinenkingaku = new ExDBFieldNumber<>("ztyutikaimasinenkingaku", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztypitijibaraikbn = new ExDBFieldString<>("ztypitijibaraikbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyoukigsyayotisbourtkbn = new ExDBFieldString<>("ztyyoukigsyayotisbourtkbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyukigsyayoteihasseirtkbn = new ExDBFieldString<>("ztyyukigsyayoteihasseirtkbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyukigsyayoteisytgnrtkbn = new ExDBFieldString<>("ztyyukigsyayoteisytgnrtkbn", this);

    public final ExDBFieldString<ZT_NkBikinTy, String> ztyyobiv17 = new ExDBFieldString<>("ztyyobiv17", this);
}
