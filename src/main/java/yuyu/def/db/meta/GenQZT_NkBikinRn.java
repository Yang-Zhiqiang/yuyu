package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkBikinRn;

/**
 * 年金備金テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkBikinRn extends AbstractExDBTable<ZT_NkBikinRn> {

    public GenQZT_NkBikinRn() {
        this("ZT_NkBikinRn");
    }

    public GenQZT_NkBikinRn(String pAlias) {
        super("ZT_NkBikinRn", ZT_NkBikinRn.class, pAlias);
    }

    public String ZT_NkBikinRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnidouymd = new ExDBFieldString<>("zrnidouymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnsyouin = new ExDBFieldString<>("zrnsyouin", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikbn = new ExDBFieldString<>("zrnnksyuruikbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnenkinkbn = new ExDBFieldString<>("zrnnenkinkbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnenkinsyu = new ExDBFieldString<>("zrnnenkinsyu", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnenkinkaisikbn = new ExDBFieldString<>("zrnnenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnsyokainenkinsiharaiymd = new ExDBFieldString<>("zrnsyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnenkinhosyoukikan = new ExDBFieldString<>("zrnnenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnsaisyuukousinymd = new ExDBFieldString<>("zrnsaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnsaisyuukousinsyoricd = new ExDBFieldString<>("zrnsaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnnenkinkihonctr = new ExDBFieldNumber<>("zrnnenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrncurrentday = new ExDBFieldString<>("zrncurrentday", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrncurrenttime = new ExDBFieldString<>("zrncurrenttime", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnkessanjibikinkbn = new ExDBFieldString<>("zrnkessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyoumetucd = new ExDBFieldString<>("zrnnksyoumetucd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyoumetuymd = new ExDBFieldString<>("zrnnksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnkouryokuhasseiymd = new ExDBFieldString<>("zrnkouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnkingakuzoukanaiyoukbn = new ExDBFieldString<>("zrnkingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnmotokeiyakusyouhinkbn = new ExDBFieldString<>("zrnmotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnenkinkigousedaikbn = new ExDBFieldString<>("zrnnenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Double> zrnrrthendounkyoteirrt = new ExDBFieldNumber<>("zrnrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Double> zrnrrthendounksitihsyurrt = new ExDBFieldNumber<>("zrnrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("zrnhenkoumaekihonnenkingaku", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnsyokainenkingaku = new ExDBFieldNumber<>("zrnsyokainenkingaku", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnsyokaisiharaijitokubetud = new ExDBFieldNumber<>("zrnsyokaisiharaijitokubetud", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnsyokaisiharaijikaimasis = new ExDBFieldNumber<>("zrnsyokaisiharaijikaimasis", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnsyokaisiharaijisonotad = new ExDBFieldNumber<>("zrnsyokaisiharaijisonotad", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnsyokaisiharaijimisyuup = new ExDBFieldNumber<>("zrnsyokaisiharaijimisyuup", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnidounenkinnengaku = new ExDBFieldNumber<>("zrnidounenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnsetteijikikinsougaku = new ExDBFieldNumber<>("zrnsetteijikikinsougaku", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrntenkanitijibarainkgk = new ExDBFieldNumber<>("zrntenkanitijibarainkgk", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnkasannkgk = new ExDBFieldNumber<>("zrnkasannkgk", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnuwanosenenkingaku = new ExDBFieldNumber<>("zrnuwanosenenkingaku", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnsyukeiyakunenkingaku = new ExDBFieldNumber<>("zrnsyukeiyakunenkingaku", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntokuyakuarihyouji = new ExDBFieldString<>("zrntokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnenkinsiharainaiyoukbn = new ExDBFieldString<>("zrnnenkinsiharainaiyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnitijikinsiharaiymd = new ExDBFieldString<>("zrnitijikinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnkknsetymd = new ExDBFieldString<>("zrnkknsetymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnkkaisigoyoteiriritukbn = new ExDBFieldString<>("zrnnkkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksgoyoteisibouritukbn = new ExDBFieldString<>("zrnnksgoyoteisibouritukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnenkinjimutesuuryoukbn = new ExDBFieldString<>("zrnnenkinjimutesuuryoukbn", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Double> zrnteizouritu = new ExDBFieldNumber<>("zrnteizouritu", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnmaeatuatoatukbn = new ExDBFieldString<>("zrnmaeatuatoatukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntokusyunenkinnaiyoukbn = new ExDBFieldString<>("zrntokusyunenkinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnsiharaikaisuukbn = new ExDBFieldString<>("zrnsiharaikaisuukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnkgyunkyusykishrtukisuu = new ExDBFieldString<>("zrnkgyunkyusykishrtukisuu", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnteizounksiboujihknnendo = new ExDBFieldString<>("zrnteizounksiboujihknnendo", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrndkigetu = new ExDBFieldString<>("zrndkigetu", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrntounendod = new ExDBFieldNumber<>("zrntounendod", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnnenkinyousiharaid = new ExDBFieldNumber<>("zrnnenkinyousiharaid", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnsiharainenkingaku = new ExDBFieldNumber<>("zrnsiharainenkingaku", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnsiharaisyoruiuketukeymd = new ExDBFieldString<>("zrnsiharaisyoruiuketukeymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnsiharaiuketukebasyo = new ExDBFieldString<>("zrnsiharaiuketukebasyo", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnshiharaihasseiymd = new ExDBFieldString<>("zrnshiharaihasseiymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksjihihokensyaage = new ExDBFieldString<>("zrnnksjihihokensyaage", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnhihokensyasibouymd = new ExDBFieldString<>("zrnhihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrndai2hihokensyaseibetukbn = new ExDBFieldString<>("zrndai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksjidai2hhknsyaage = new ExDBFieldString<>("zrnnksjidai2hhknsyaage", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrndai2hihokensyasibouymd = new ExDBFieldString<>("zrndai2hihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrndai2hihokensyaseiymd = new ExDBFieldString<>("zrndai2hihokensyaseiymd", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnkhknhoutekiyouhyj = new ExDBFieldString<>("zrnnkhknhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv1x2 = new ExDBFieldString<>("zrnyobiv1x2", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntuusinsakiyuubinno = new ExDBFieldString<>("zrntuusinsakiyuubinno", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntuusinsakitikucd = new ExDBFieldString<>("zrntuusinsakitikucd", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv1x3 = new ExDBFieldString<>("zrnyobiv1x3", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv1x4 = new ExDBFieldString<>("zrnyobiv1x4", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv8x3 = new ExDBFieldString<>("zrnyobiv8x3", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv8x4 = new ExDBFieldString<>("zrnyobiv8x4", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv59 = new ExDBFieldString<>("zrnyobiv59", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x1 = new ExDBFieldString<>("zrnnksyuruikguyobi1x1", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x2 = new ExDBFieldString<>("zrnnksyuruikguyobi1x2", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x3 = new ExDBFieldString<>("zrnnksyuruikguyobi1x3", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x4 = new ExDBFieldString<>("zrnnksyuruikguyobi1x4", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x5 = new ExDBFieldString<>("zrnnksyuruikguyobi1x5", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x6 = new ExDBFieldString<>("zrnnksyuruikguyobi1x6", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x7 = new ExDBFieldString<>("zrnnksyuruikguyobi1x7", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x8 = new ExDBFieldString<>("zrnnksyuruikguyobi1x8", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x9 = new ExDBFieldString<>("zrnnksyuruikguyobi1x9", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x10 = new ExDBFieldString<>("zrnnksyuruikguyobi1x10", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x11 = new ExDBFieldString<>("zrnnksyuruikguyobi1x11", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x12 = new ExDBFieldString<>("zrnnksyuruikguyobi1x12", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x13 = new ExDBFieldString<>("zrnnksyuruikguyobi1x13", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x14 = new ExDBFieldString<>("zrnnksyuruikguyobi1x14", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi1x15 = new ExDBFieldString<>("zrnnksyuruikguyobi1x15", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x1 = new ExDBFieldString<>("zrnnksyuruikguyobi2x1", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x2 = new ExDBFieldString<>("zrnnksyuruikguyobi2x2", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x3 = new ExDBFieldString<>("zrnnksyuruikguyobi2x3", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x4 = new ExDBFieldString<>("zrnnksyuruikguyobi2x4", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x5 = new ExDBFieldString<>("zrnnksyuruikguyobi2x5", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x6 = new ExDBFieldString<>("zrnnksyuruikguyobi2x6", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x7 = new ExDBFieldString<>("zrnnksyuruikguyobi2x7", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x8 = new ExDBFieldString<>("zrnnksyuruikguyobi2x8", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x9 = new ExDBFieldString<>("zrnnksyuruikguyobi2x9", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi2x10 = new ExDBFieldString<>("zrnnksyuruikguyobi2x10", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x1 = new ExDBFieldString<>("zrnnksyuruikguyobi3x1", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x2 = new ExDBFieldString<>("zrnnksyuruikguyobi3x2", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x3 = new ExDBFieldString<>("zrnnksyuruikguyobi3x3", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x4 = new ExDBFieldString<>("zrnnksyuruikguyobi3x4", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x5 = new ExDBFieldString<>("zrnnksyuruikguyobi3x5", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x6 = new ExDBFieldString<>("zrnnksyuruikguyobi3x6", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x7 = new ExDBFieldString<>("zrnnksyuruikguyobi3x7", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x8 = new ExDBFieldString<>("zrnnksyuruikguyobi3x8", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x9 = new ExDBFieldString<>("zrnnksyuruikguyobi3x9", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnnksyuruikguyobi3x10 = new ExDBFieldString<>("zrnnksyuruikguyobi3x10", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntoukeisyuuseisyorikbn = new ExDBFieldString<>("zrntoukeisyuuseisyorikbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntoukeimodkurykhssiymd = new ExDBFieldString<>("zrntoukeimodkurykhssiymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntoukeimoddenpyouymd = new ExDBFieldString<>("zrntoukeimoddenpyouymd", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntoukeimodbikinmodkbn = new ExDBFieldString<>("zrntoukeimodbikinmodkbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntoukeimodbikinshrymd = new ExDBFieldString<>("zrntoukeimodbikinshrymd", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrntoukeimodbikinkijyugk = new ExDBFieldNumber<>("zrntoukeimodbikinkijyugk", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnbikinnaiyoukbn = new ExDBFieldString<>("zrnbikinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnbikinkeiyakujyoukyoukbn = new ExDBFieldString<>("zrnbikinkeiyakujyoukyoukbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnkaimasinenkinarihyouji = new ExDBFieldString<>("zrnkaimasinenkinarihyouji", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnmaeatuatoatusegarihyj = new ExDBFieldString<>("zrnmaeatuatoatusegarihyj", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnzaikeiyuatatkimsnkarihyj = new ExDBFieldString<>("zrnzaikeiyuatatkimsnkarihyj", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrntyouhyousakuseitanikbn = new ExDBFieldString<>("zrntyouhyousakuseitanikbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnshrnkgknaiyoukbn = new ExDBFieldString<>("zrnshrnkgknaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkBikinRn, Long> zrnutikaimasinenkingaku = new ExDBFieldNumber<>("zrnutikaimasinenkingaku", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnpitijibaraikbn = new ExDBFieldString<>("zrnpitijibaraikbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyoukigsyayotisbourtkbn = new ExDBFieldString<>("zrnyoukigsyayotisbourtkbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyukigsyayoteihasseirtkbn = new ExDBFieldString<>("zrnyukigsyayoteihasseirtkbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyukigsyayoteisytgnrtkbn = new ExDBFieldString<>("zrnyukigsyayoteisytgnrtkbn", this);

    public final ExDBFieldString<ZT_NkBikinRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);
}
