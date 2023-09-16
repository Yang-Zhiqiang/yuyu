package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkToukeiKtyTy;

/**
 * 年金統計Ｆ期中報告用テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkToukeiKtyTy extends AbstractExDBTable<ZT_NkToukeiKtyTy> {

    public GenQZT_NkToukeiKtyTy() {
        this("ZT_NkToukeiKtyTy");
    }

    public GenQZT_NkToukeiKtyTy(String pAlias) {
        super("ZT_NkToukeiKtyTy", ZT_NkToukeiKtyTy.class, pAlias);
    }

    public String ZT_NkToukeiKtyTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysystemcd = new ExDBFieldString<>("ztysystemcd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyulfkbn = new ExDBFieldString<>("ztyulfkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyrecordkihonkbn = new ExDBFieldString<>("ztyrecordkihonkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyidouymd = new ExDBFieldString<>("ztyidouymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysyouin = new ExDBFieldString<>("ztysyouin", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikbn = new ExDBFieldString<>("ztynksyuruikbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynenkinkbn = new ExDBFieldString<>("ztynenkinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynenkinsyu = new ExDBFieldString<>("ztynenkinsyu", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynenkinkaisikbn = new ExDBFieldString<>("ztynenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysyokainenkinsiharaiymd = new ExDBFieldString<>("ztysyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynenkinhosyoukikan = new ExDBFieldString<>("ztynenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysaisyuukousinymd = new ExDBFieldString<>("ztysaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysaisyuukousinsyoricd = new ExDBFieldString<>("ztysaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztynenkinkihonctr = new ExDBFieldNumber<>("ztynenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztycurrentday = new ExDBFieldString<>("ztycurrentday", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztycurrenttime = new ExDBFieldString<>("ztycurrenttime", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykessanjibikinkbn = new ExDBFieldString<>("ztykessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyoumetucd = new ExDBFieldString<>("ztynksyoumetucd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyoumetuymd = new ExDBFieldString<>("ztynksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykouryokuhasseiymd = new ExDBFieldString<>("ztykouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykingakuzoukanaiyoukbn = new ExDBFieldString<>("ztykingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztymotokeiyakusyouhinkbn = new ExDBFieldString<>("ztymotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynenkinkigousedaikbn = new ExDBFieldString<>("ztynenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Double> ztyrrthendounkyoteirrt = new ExDBFieldNumber<>("ztyrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Double> ztyrrthendounksitihsyurrt = new ExDBFieldNumber<>("ztyrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("ztyhenkoumaekihonnenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztysyokainenkingaku = new ExDBFieldNumber<>("ztysyokainenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztysyokaisiharaijitokubetud = new ExDBFieldNumber<>("ztysyokaisiharaijitokubetud", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztysyokaisiharaijikaimasis = new ExDBFieldNumber<>("ztysyokaisiharaijikaimasis", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztysyokaisiharaijisonotad = new ExDBFieldNumber<>("ztysyokaisiharaijisonotad", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztysyokaisiharaijimisyuup = new ExDBFieldNumber<>("ztysyokaisiharaijimisyuup", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyidounenkinnengaku = new ExDBFieldNumber<>("ztyidounenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztysetteijikikinsougaku = new ExDBFieldNumber<>("ztysetteijikikinsougaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztytenkanitijibarainkgk = new ExDBFieldNumber<>("ztytenkanitijibarainkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztykasannkgk = new ExDBFieldNumber<>("ztykasannkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyuwanosenenkingaku = new ExDBFieldNumber<>("ztyuwanosenenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztysyukeiyakunenkingaku = new ExDBFieldNumber<>("ztysyukeiyakunenkingaku", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytokuyakuarihyouji = new ExDBFieldString<>("ztytokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynenkinsiharainaiyoukbn = new ExDBFieldString<>("ztynenkinsiharainaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyitijikinsiharaiymd = new ExDBFieldString<>("ztyitijikinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykknsetymd = new ExDBFieldString<>("ztykknsetymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynkkaisigoyoteiriritukbn = new ExDBFieldString<>("ztynkkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksgoyoteisibouritukbn = new ExDBFieldString<>("ztynksgoyoteisibouritukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynenkinjimutesuuryoukbn = new ExDBFieldString<>("ztynenkinjimutesuuryoukbn", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Double> ztyteizouritu = new ExDBFieldNumber<>("ztyteizouritu", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztymaeatuatoatukbn = new ExDBFieldString<>("ztymaeatuatoatukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytokusyunenkinnaiyoukbn = new ExDBFieldString<>("ztytokusyunenkinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysiharaikaisuukbn = new ExDBFieldString<>("ztysiharaikaisuukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykgyunkyusykishrtukisuu = new ExDBFieldString<>("ztykgyunkyusykishrtukisuu", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyteizounksiboujihknnendo = new ExDBFieldString<>("ztyteizounksiboujihknnendo", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztydkigetu = new ExDBFieldString<>("ztydkigetu", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztytounendod = new ExDBFieldNumber<>("ztytounendod", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztynenkinyousiharaid = new ExDBFieldNumber<>("ztynenkinyousiharaid", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztysiharainenkingaku = new ExDBFieldNumber<>("ztysiharainenkingaku", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysiharaisyoruiuketukeymd = new ExDBFieldString<>("ztysiharaisyoruiuketukeymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysiharaiuketukebasyo = new ExDBFieldString<>("ztysiharaiuketukebasyo", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyshiharaihasseiymd = new ExDBFieldString<>("ztyshiharaihasseiymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksjihihokensyaage = new ExDBFieldString<>("ztynksjihihokensyaage", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyhihokensyasibouymd = new ExDBFieldString<>("ztyhihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztydai2hihokensyaseibetukbn = new ExDBFieldString<>("ztydai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksjidai2hhknsyaage = new ExDBFieldString<>("ztynksjidai2hhknsyaage", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztydai2hihokensyasibouymd = new ExDBFieldString<>("ztydai2hihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztydai2hihokensyaseiymd = new ExDBFieldString<>("ztydai2hihokensyaseiymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynkhknhoutekiyouhyj = new ExDBFieldString<>("ztynkhknhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytuusinsakiyuubinno = new ExDBFieldString<>("ztytuusinsakiyuubinno", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytuusinsakitikucd = new ExDBFieldString<>("ztytuusinsakitikucd", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv1x3 = new ExDBFieldString<>("ztyyobiv1x3", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv1x4 = new ExDBFieldString<>("ztyyobiv1x4", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv8x3 = new ExDBFieldString<>("ztyyobiv8x3", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv8x4 = new ExDBFieldString<>("ztyyobiv8x4", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv59 = new ExDBFieldString<>("ztyyobiv59", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x1 = new ExDBFieldString<>("ztynksyuruikguyobi1x1", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x2 = new ExDBFieldString<>("ztynksyuruikguyobi1x2", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x3 = new ExDBFieldString<>("ztynksyuruikguyobi1x3", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x4 = new ExDBFieldString<>("ztynksyuruikguyobi1x4", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x5 = new ExDBFieldString<>("ztynksyuruikguyobi1x5", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x6 = new ExDBFieldString<>("ztynksyuruikguyobi1x6", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x7 = new ExDBFieldString<>("ztynksyuruikguyobi1x7", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x8 = new ExDBFieldString<>("ztynksyuruikguyobi1x8", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x9 = new ExDBFieldString<>("ztynksyuruikguyobi1x9", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x10 = new ExDBFieldString<>("ztynksyuruikguyobi1x10", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x11 = new ExDBFieldString<>("ztynksyuruikguyobi1x11", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x12 = new ExDBFieldString<>("ztynksyuruikguyobi1x12", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x13 = new ExDBFieldString<>("ztynksyuruikguyobi1x13", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x14 = new ExDBFieldString<>("ztynksyuruikguyobi1x14", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi1x15 = new ExDBFieldString<>("ztynksyuruikguyobi1x15", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x1 = new ExDBFieldString<>("ztynksyuruikguyobi2x1", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x2 = new ExDBFieldString<>("ztynksyuruikguyobi2x2", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x3 = new ExDBFieldString<>("ztynksyuruikguyobi2x3", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x4 = new ExDBFieldString<>("ztynksyuruikguyobi2x4", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x5 = new ExDBFieldString<>("ztynksyuruikguyobi2x5", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x6 = new ExDBFieldString<>("ztynksyuruikguyobi2x6", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x7 = new ExDBFieldString<>("ztynksyuruikguyobi2x7", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x8 = new ExDBFieldString<>("ztynksyuruikguyobi2x8", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x9 = new ExDBFieldString<>("ztynksyuruikguyobi2x9", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi2x10 = new ExDBFieldString<>("ztynksyuruikguyobi2x10", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x1 = new ExDBFieldString<>("ztynksyuruikguyobi3x1", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x2 = new ExDBFieldString<>("ztynksyuruikguyobi3x2", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x3 = new ExDBFieldString<>("ztynksyuruikguyobi3x3", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x4 = new ExDBFieldString<>("ztynksyuruikguyobi3x4", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x5 = new ExDBFieldString<>("ztynksyuruikguyobi3x5", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x6 = new ExDBFieldString<>("ztynksyuruikguyobi3x6", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x7 = new ExDBFieldString<>("ztynksyuruikguyobi3x7", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x8 = new ExDBFieldString<>("ztynksyuruikguyobi3x8", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x9 = new ExDBFieldString<>("ztynksyuruikguyobi3x9", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztynksyuruikguyobi3x10 = new ExDBFieldString<>("ztynksyuruikguyobi3x10", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytoukeisyuuseisyorikbn = new ExDBFieldString<>("ztytoukeisyuuseisyorikbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytoukeimodkurykhssiymd = new ExDBFieldString<>("ztytoukeimodkurykhssiymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytoukeimoddenpyouymd = new ExDBFieldString<>("ztytoukeimoddenpyouymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytoukeimodbikinmodkbn = new ExDBFieldString<>("ztytoukeimodbikinmodkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytoukeimodbikinshrymd = new ExDBFieldString<>("ztytoukeimodbikinshrymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztytoukeimodbikinkijyugk = new ExDBFieldNumber<>("ztytoukeimodbikinkijyugk", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztybikinnaiyoukbn = new ExDBFieldString<>("ztybikinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztybikinkeiyakujyoukyoukbn = new ExDBFieldString<>("ztybikinkeiyakujyoukyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasinenkinarihyouji = new ExDBFieldString<>("ztykaimasinenkinarihyouji", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztymaeatuatoatusegarihyj = new ExDBFieldString<>("ztymaeatuatoatusegarihyj", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyzaikeiyuatatkimsnkarihyj = new ExDBFieldString<>("ztyzaikeiyuatatkimsnkarihyj", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztytyouhyousakuseitanikbn = new ExDBFieldString<>("ztytyouhyousakuseitanikbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyshrnkgknaiyoukbn = new ExDBFieldString<>("ztyshrnkgknaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyutikaimasinenkingaku = new ExDBFieldNumber<>("ztyutikaimasinenkingaku", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztypitijibaraikbn = new ExDBFieldString<>("ztypitijibaraikbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyoukigsyayotisbourtkbn = new ExDBFieldString<>("ztyyoukigsyayotisbourtkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyukigsyayoteihasseirtkbn = new ExDBFieldString<>("ztyyukigsyayoteihasseirtkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyukigsyayoteisytgnrtkbn = new ExDBFieldString<>("ztyyukigsyayoteisytgnrtkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyyobiv17 = new ExDBFieldString<>("ztyyobiv17", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasinkkouryokusymd = new ExDBFieldString<>("ztykaimasinkkouryokusymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasinenkinkbn = new ExDBFieldString<>("ztykaimasinenkinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasinenkinsyuruikigou = new ExDBFieldString<>("ztykaimasinenkinsyuruikigou", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasinkshrkkn = new ExDBFieldString<>("ztykaimasinkshrkkn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasinenkinhosyoukikan = new ExDBFieldString<>("ztykaimasinenkinhosyoukikan", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasinkhhknsyaage = new ExDBFieldString<>("ztykaimasinkhhknsyaage", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykimsnkdai2hhknsyaage = new ExDBFieldString<>("ztykimsnkdai2hhknsyaage", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztysaisyuunenkinkaimasiymd = new ExDBFieldString<>("ztysaisyuunenkinkaimasiymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztykaimasinenkingaku = new ExDBFieldNumber<>("ztykaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyzennendokaimasinkgk = new ExDBFieldNumber<>("ztyzennendokaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyznznnndkaimasinkzougk = new ExDBFieldNumber<>("ztyznznnndkaimasinkzougk", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyznznznnndkaimasinkgk = new ExDBFieldNumber<>("ztyznznznnndkaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztytounendokaimasinenkind = new ExDBFieldNumber<>("ztytounendokaimasinenkind", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasityuusiymd = new ExDBFieldString<>("ztykaimasityuusiymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasihukkiymd = new ExDBFieldString<>("ztykaimasihukkiymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztykaimasinkkigousdkbn = new ExDBFieldString<>("ztykaimasinkkigousdkbn", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztymaeatuatoatukouryokusymd = new ExDBFieldString<>("ztymaeatuatoatukouryokusymd", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztymaeatuatoatukikan = new ExDBFieldString<>("ztymaeatuatoatukikan", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztymaeatuatoatuhendougonkgk = new ExDBFieldNumber<>("ztymaeatuatoatuhendougonkgk", this);

    public final ExDBFieldString<ZT_NkToukeiKtyTy, String> ztyatoatusaisyuukaimasiymd = new ExDBFieldString<>("ztyatoatusaisyuukaimasiymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyatoatukaimasinenkingaku = new ExDBFieldNumber<>("ztyatoatukaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyznnndatoatukaimasinkgk = new ExDBFieldNumber<>("ztyznnndatoatukaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyznznnndatoatukaimasinkgk = new ExDBFieldNumber<>("ztyznznnndatoatukaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyznznznnndatatkimsnkgk = new ExDBFieldNumber<>("ztyznznznnndatatkimsnkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztytounendatoatukaimasinkd = new ExDBFieldNumber<>("ztytounendatoatukaimasinkd", this);

    public final ExDBFieldNumber<ZT_NkToukeiKtyTy, Long> ztyuwanoseatoatukaimasinkgk = new ExDBFieldNumber<>("ztyuwanoseatoatukaimasinkgk", this);
}
