package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkToukeiRigTy;

/**
 * 年金統計Ｆ例月用テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkToukeiRigTy extends AbstractExDBTable<ZT_NkToukeiRigTy> {

    public GenQZT_NkToukeiRigTy() {
        this("ZT_NkToukeiRigTy");
    }

    public GenQZT_NkToukeiRigTy(String pAlias) {
        super("ZT_NkToukeiRigTy", ZT_NkToukeiRigTy.class, pAlias);
    }

    public String ZT_NkToukeiRigTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysystemcd = new ExDBFieldString<>("ztysystemcd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyulfkbn = new ExDBFieldString<>("ztyulfkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyrecordkihonkbn = new ExDBFieldString<>("ztyrecordkihonkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyidouymd = new ExDBFieldString<>("ztyidouymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysyouin = new ExDBFieldString<>("ztysyouin", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikbn = new ExDBFieldString<>("ztynksyuruikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynenkinkbn = new ExDBFieldString<>("ztynenkinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynenkinsyu = new ExDBFieldString<>("ztynenkinsyu", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynenkinkaisikbn = new ExDBFieldString<>("ztynenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysyokainenkinsiharaiymd = new ExDBFieldString<>("ztysyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynenkinhosyoukikan = new ExDBFieldString<>("ztynenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysaisyuukousinymd = new ExDBFieldString<>("ztysaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysaisyuukousinsyoricd = new ExDBFieldString<>("ztysaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztynenkinkihonctr = new ExDBFieldNumber<>("ztynenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztycurrentday = new ExDBFieldString<>("ztycurrentday", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztycurrenttime = new ExDBFieldString<>("ztycurrenttime", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykessanjibikinkbn = new ExDBFieldString<>("ztykessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyoumetucd = new ExDBFieldString<>("ztynksyoumetucd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyoumetuymd = new ExDBFieldString<>("ztynksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykouryokuhasseiymd = new ExDBFieldString<>("ztykouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykingakuzoukanaiyoukbn = new ExDBFieldString<>("ztykingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztymotokeiyakusyouhinkbn = new ExDBFieldString<>("ztymotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynenkinkigousedaikbn = new ExDBFieldString<>("ztynenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Double> ztyrrthendounkyoteirrt = new ExDBFieldNumber<>("ztyrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Double> ztyrrthendounksitihsyurrt = new ExDBFieldNumber<>("ztyrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("ztyhenkoumaekihonnenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztysyokainenkingaku = new ExDBFieldNumber<>("ztysyokainenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztysyokaisiharaijitokubetud = new ExDBFieldNumber<>("ztysyokaisiharaijitokubetud", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztysyokaisiharaijikaimasis = new ExDBFieldNumber<>("ztysyokaisiharaijikaimasis", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztysyokaisiharaijisonotad = new ExDBFieldNumber<>("ztysyokaisiharaijisonotad", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztysyokaisiharaijimisyuup = new ExDBFieldNumber<>("ztysyokaisiharaijimisyuup", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyidounenkinnengaku = new ExDBFieldNumber<>("ztyidounenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztysetteijikikinsougaku = new ExDBFieldNumber<>("ztysetteijikikinsougaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztytenkanitijibarainkgk = new ExDBFieldNumber<>("ztytenkanitijibarainkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztykasannkgk = new ExDBFieldNumber<>("ztykasannkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyuwanosenenkingaku = new ExDBFieldNumber<>("ztyuwanosenenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztysyukeiyakunenkingaku = new ExDBFieldNumber<>("ztysyukeiyakunenkingaku", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytokuyakuarihyouji = new ExDBFieldString<>("ztytokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynenkinsiharainaiyoukbn = new ExDBFieldString<>("ztynenkinsiharainaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyitijikinsiharaiymd = new ExDBFieldString<>("ztyitijikinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykknsetymd = new ExDBFieldString<>("ztykknsetymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynkkaisigoyoteiriritukbn = new ExDBFieldString<>("ztynkkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksgoyoteisibouritukbn = new ExDBFieldString<>("ztynksgoyoteisibouritukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynenkinjimutesuuryoukbn = new ExDBFieldString<>("ztynenkinjimutesuuryoukbn", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Double> ztyteizouritu = new ExDBFieldNumber<>("ztyteizouritu", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztymaeatuatoatukbn = new ExDBFieldString<>("ztymaeatuatoatukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytokusyunenkinnaiyoukbn = new ExDBFieldString<>("ztytokusyunenkinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysiharaikaisuukbn = new ExDBFieldString<>("ztysiharaikaisuukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykgyunkyusykishrtukisuu = new ExDBFieldString<>("ztykgyunkyusykishrtukisuu", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyteizounksiboujihknnendo = new ExDBFieldString<>("ztyteizounksiboujihknnendo", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztydkigetu = new ExDBFieldString<>("ztydkigetu", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztytounendod = new ExDBFieldNumber<>("ztytounendod", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztynenkinyousiharaid = new ExDBFieldNumber<>("ztynenkinyousiharaid", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztysiharainenkingaku = new ExDBFieldNumber<>("ztysiharainenkingaku", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysiharaisyoruiuketukeymd = new ExDBFieldString<>("ztysiharaisyoruiuketukeymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysiharaiuketukebasyo = new ExDBFieldString<>("ztysiharaiuketukebasyo", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyshiharaihasseiymd = new ExDBFieldString<>("ztyshiharaihasseiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksjihihokensyaage = new ExDBFieldString<>("ztynksjihihokensyaage", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyhihokensyasibouymd = new ExDBFieldString<>("ztyhihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztydai2hihokensyaseibetukbn = new ExDBFieldString<>("ztydai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksjidai2hhknsyaage = new ExDBFieldString<>("ztynksjidai2hhknsyaage", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztydai2hihokensyasibouymd = new ExDBFieldString<>("ztydai2hihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztydai2hihokensyaseiymd = new ExDBFieldString<>("ztydai2hihokensyaseiymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynkhknhoutekiyouhyj = new ExDBFieldString<>("ztynkhknhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytuusinsakiyuubinno = new ExDBFieldString<>("ztytuusinsakiyuubinno", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytuusinsakitikucd = new ExDBFieldString<>("ztytuusinsakitikucd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv1x3 = new ExDBFieldString<>("ztyyobiv1x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv1x4 = new ExDBFieldString<>("ztyyobiv1x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv8x3 = new ExDBFieldString<>("ztyyobiv8x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv8x4 = new ExDBFieldString<>("ztyyobiv8x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv59 = new ExDBFieldString<>("ztyyobiv59", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x1 = new ExDBFieldString<>("ztynksyuruikguyobi1x1", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x2 = new ExDBFieldString<>("ztynksyuruikguyobi1x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x3 = new ExDBFieldString<>("ztynksyuruikguyobi1x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x4 = new ExDBFieldString<>("ztynksyuruikguyobi1x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x5 = new ExDBFieldString<>("ztynksyuruikguyobi1x5", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x6 = new ExDBFieldString<>("ztynksyuruikguyobi1x6", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x7 = new ExDBFieldString<>("ztynksyuruikguyobi1x7", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x8 = new ExDBFieldString<>("ztynksyuruikguyobi1x8", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x9 = new ExDBFieldString<>("ztynksyuruikguyobi1x9", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x10 = new ExDBFieldString<>("ztynksyuruikguyobi1x10", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x11 = new ExDBFieldString<>("ztynksyuruikguyobi1x11", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x12 = new ExDBFieldString<>("ztynksyuruikguyobi1x12", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x13 = new ExDBFieldString<>("ztynksyuruikguyobi1x13", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x14 = new ExDBFieldString<>("ztynksyuruikguyobi1x14", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi1x15 = new ExDBFieldString<>("ztynksyuruikguyobi1x15", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x1 = new ExDBFieldString<>("ztynksyuruikguyobi2x1", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x2 = new ExDBFieldString<>("ztynksyuruikguyobi2x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x3 = new ExDBFieldString<>("ztynksyuruikguyobi2x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x4 = new ExDBFieldString<>("ztynksyuruikguyobi2x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x5 = new ExDBFieldString<>("ztynksyuruikguyobi2x5", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x6 = new ExDBFieldString<>("ztynksyuruikguyobi2x6", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x7 = new ExDBFieldString<>("ztynksyuruikguyobi2x7", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x8 = new ExDBFieldString<>("ztynksyuruikguyobi2x8", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x9 = new ExDBFieldString<>("ztynksyuruikguyobi2x9", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi2x10 = new ExDBFieldString<>("ztynksyuruikguyobi2x10", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x1 = new ExDBFieldString<>("ztynksyuruikguyobi3x1", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x2 = new ExDBFieldString<>("ztynksyuruikguyobi3x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x3 = new ExDBFieldString<>("ztynksyuruikguyobi3x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x4 = new ExDBFieldString<>("ztynksyuruikguyobi3x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x5 = new ExDBFieldString<>("ztynksyuruikguyobi3x5", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x6 = new ExDBFieldString<>("ztynksyuruikguyobi3x6", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x7 = new ExDBFieldString<>("ztynksyuruikguyobi3x7", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x8 = new ExDBFieldString<>("ztynksyuruikguyobi3x8", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x9 = new ExDBFieldString<>("ztynksyuruikguyobi3x9", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztynksyuruikguyobi3x10 = new ExDBFieldString<>("ztynksyuruikguyobi3x10", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytoukeisyuuseisyorikbn = new ExDBFieldString<>("ztytoukeisyuuseisyorikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytoukeimodkurykhssiymd = new ExDBFieldString<>("ztytoukeimodkurykhssiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytoukeimoddenpyouymd = new ExDBFieldString<>("ztytoukeimoddenpyouymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytoukeimodbikinmodkbn = new ExDBFieldString<>("ztytoukeimodbikinmodkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytoukeimodbikinshrymd = new ExDBFieldString<>("ztytoukeimodbikinshrymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztytoukeimodbikinkijyugk = new ExDBFieldNumber<>("ztytoukeimodbikinkijyugk", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztybikinnaiyoukbn = new ExDBFieldString<>("ztybikinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztybikinkeiyakujyoukyoukbn = new ExDBFieldString<>("ztybikinkeiyakujyoukyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasinenkinarihyouji = new ExDBFieldString<>("ztykaimasinenkinarihyouji", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztymaeatuatoatusegarihyj = new ExDBFieldString<>("ztymaeatuatoatusegarihyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyzaikeiyuatatkimsnkarihyj = new ExDBFieldString<>("ztyzaikeiyuatatkimsnkarihyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztytyouhyousakuseitanikbn = new ExDBFieldString<>("ztytyouhyousakuseitanikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyshrnkgknaiyoukbn = new ExDBFieldString<>("ztyshrnkgknaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyutikaimasinenkingaku = new ExDBFieldNumber<>("ztyutikaimasinenkingaku", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztypitijibaraikbn = new ExDBFieldString<>("ztypitijibaraikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyoukigsyayotisbourtkbn = new ExDBFieldString<>("ztyyoukigsyayotisbourtkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyukigsyayoteihasseirtkbn = new ExDBFieldString<>("ztyyukigsyayoteihasseirtkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyukigsyayoteisytgnrtkbn = new ExDBFieldString<>("ztyyukigsyayoteisytgnrtkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyyobiv17 = new ExDBFieldString<>("ztyyobiv17", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasinkkouryokusymd = new ExDBFieldString<>("ztykaimasinkkouryokusymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasinenkinkbn = new ExDBFieldString<>("ztykaimasinenkinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasinenkinsyuruikigou = new ExDBFieldString<>("ztykaimasinenkinsyuruikigou", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasinkshrkkn = new ExDBFieldString<>("ztykaimasinkshrkkn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasinenkinhosyoukikan = new ExDBFieldString<>("ztykaimasinenkinhosyoukikan", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasinkhhknsyaage = new ExDBFieldString<>("ztykaimasinkhhknsyaage", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykimsnkdai2hhknsyaage = new ExDBFieldString<>("ztykimsnkdai2hhknsyaage", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztysaisyuunenkinkaimasiymd = new ExDBFieldString<>("ztysaisyuunenkinkaimasiymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztykaimasinenkingaku = new ExDBFieldNumber<>("ztykaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyzennendokaimasinkgk = new ExDBFieldNumber<>("ztyzennendokaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyznznnndkaimasinkzougk = new ExDBFieldNumber<>("ztyznznnndkaimasinkzougk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyznznznnndkaimasinkgk = new ExDBFieldNumber<>("ztyznznznnndkaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztytounendokaimasinenkind = new ExDBFieldNumber<>("ztytounendokaimasinenkind", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasityuusiymd = new ExDBFieldString<>("ztykaimasityuusiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasihukkiymd = new ExDBFieldString<>("ztykaimasihukkiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztykaimasinkkigousdkbn = new ExDBFieldString<>("ztykaimasinkkigousdkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztymaeatuatoatukouryokusymd = new ExDBFieldString<>("ztymaeatuatoatukouryokusymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztymaeatuatoatukikan = new ExDBFieldString<>("ztymaeatuatoatukikan", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztymaeatuatoatuhendougonkgk = new ExDBFieldNumber<>("ztymaeatuatoatuhendougonkgk", this);

    public final ExDBFieldString<ZT_NkToukeiRigTy, String> ztyatoatusaisyuukaimasiymd = new ExDBFieldString<>("ztyatoatusaisyuukaimasiymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyatoatukaimasinenkingaku = new ExDBFieldNumber<>("ztyatoatukaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyznnndatoatukaimasinkgk = new ExDBFieldNumber<>("ztyznnndatoatukaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyznznnndatoatukaimasinkgk = new ExDBFieldNumber<>("ztyznznnndatoatukaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyznznznnndatatkimsnkgk = new ExDBFieldNumber<>("ztyznznznnndatatkimsnkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztytounendatoatukaimasinkd = new ExDBFieldNumber<>("ztytounendatoatukaimasinkd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigTy, Long> ztyuwanoseatoatukaimasinkgk = new ExDBFieldNumber<>("ztyuwanoseatoatukaimasinkgk", this);
}
