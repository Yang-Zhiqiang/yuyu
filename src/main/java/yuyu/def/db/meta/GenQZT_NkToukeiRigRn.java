package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkToukeiRigRn;

/**
 * 年金統計Ｆ例月用テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkToukeiRigRn extends AbstractExDBTable<ZT_NkToukeiRigRn> {

    public GenQZT_NkToukeiRigRn() {
        this("ZT_NkToukeiRigRn");
    }

    public GenQZT_NkToukeiRigRn(String pAlias) {
        super("ZT_NkToukeiRigRn", ZT_NkToukeiRigRn.class, pAlias);
    }

    public String ZT_NkToukeiRigRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsystemcd = new ExDBFieldString<>("zrnsystemcd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnulfkbn = new ExDBFieldString<>("zrnulfkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnrecordkihonkbn = new ExDBFieldString<>("zrnrecordkihonkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnidouymd = new ExDBFieldString<>("zrnidouymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsyouin = new ExDBFieldString<>("zrnsyouin", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikbn = new ExDBFieldString<>("zrnnksyuruikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnenkinkbn = new ExDBFieldString<>("zrnnenkinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnenkinsyu = new ExDBFieldString<>("zrnnenkinsyu", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnenkinkaisikbn = new ExDBFieldString<>("zrnnenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsyokainenkinsiharaiymd = new ExDBFieldString<>("zrnsyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnenkinhosyoukikan = new ExDBFieldString<>("zrnnenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsaisyuukousinymd = new ExDBFieldString<>("zrnsaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsaisyuukousinsyoricd = new ExDBFieldString<>("zrnsaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnnenkinkihonctr = new ExDBFieldNumber<>("zrnnenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrncurrentday = new ExDBFieldString<>("zrncurrentday", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrncurrenttime = new ExDBFieldString<>("zrncurrenttime", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkessanjibikinkbn = new ExDBFieldString<>("zrnkessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyoumetucd = new ExDBFieldString<>("zrnnksyoumetucd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyoumetuymd = new ExDBFieldString<>("zrnnksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkouryokuhasseiymd = new ExDBFieldString<>("zrnkouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkingakuzoukanaiyoukbn = new ExDBFieldString<>("zrnkingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnmotokeiyakusyouhinkbn = new ExDBFieldString<>("zrnmotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnenkinkigousedaikbn = new ExDBFieldString<>("zrnnenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Double> zrnrrthendounkyoteirrt = new ExDBFieldNumber<>("zrnrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Double> zrnrrthendounksitihsyurrt = new ExDBFieldNumber<>("zrnrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("zrnhenkoumaekihonnenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnsyokainenkingaku = new ExDBFieldNumber<>("zrnsyokainenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnsyokaisiharaijitokubetud = new ExDBFieldNumber<>("zrnsyokaisiharaijitokubetud", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnsyokaisiharaijikaimasis = new ExDBFieldNumber<>("zrnsyokaisiharaijikaimasis", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnsyokaisiharaijisonotad = new ExDBFieldNumber<>("zrnsyokaisiharaijisonotad", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnsyokaisiharaijimisyuup = new ExDBFieldNumber<>("zrnsyokaisiharaijimisyuup", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnidounenkinnengaku = new ExDBFieldNumber<>("zrnidounenkinnengaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnsetteijikikinsougaku = new ExDBFieldNumber<>("zrnsetteijikikinsougaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrntenkanitijibarainkgk = new ExDBFieldNumber<>("zrntenkanitijibarainkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnkasannkgk = new ExDBFieldNumber<>("zrnkasannkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnuwanosenenkingaku = new ExDBFieldNumber<>("zrnuwanosenenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnsyukeiyakunenkingaku = new ExDBFieldNumber<>("zrnsyukeiyakunenkingaku", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntokuyakuarihyouji = new ExDBFieldString<>("zrntokuyakuarihyouji", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnenkinsiharainaiyoukbn = new ExDBFieldString<>("zrnnenkinsiharainaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnitijikinsiharaiymd = new ExDBFieldString<>("zrnitijikinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkknsetymd = new ExDBFieldString<>("zrnkknsetymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnkkaisigoyoteiriritukbn = new ExDBFieldString<>("zrnnkkaisigoyoteiriritukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksgoyoteisibouritukbn = new ExDBFieldString<>("zrnnksgoyoteisibouritukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnenkinjimutesuuryoukbn = new ExDBFieldString<>("zrnnenkinjimutesuuryoukbn", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Double> zrnteizouritu = new ExDBFieldNumber<>("zrnteizouritu", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnmaeatuatoatukbn = new ExDBFieldString<>("zrnmaeatuatoatukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntokusyunenkinnaiyoukbn = new ExDBFieldString<>("zrntokusyunenkinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsiharaikaisuukbn = new ExDBFieldString<>("zrnsiharaikaisuukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkgyunkyusykishrtukisuu = new ExDBFieldString<>("zrnkgyunkyusykishrtukisuu", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnteizounksiboujihknnendo = new ExDBFieldString<>("zrnteizounksiboujihknnendo", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrndkigetu = new ExDBFieldString<>("zrndkigetu", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrntounendod = new ExDBFieldNumber<>("zrntounendod", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnnenkinyousiharaid = new ExDBFieldNumber<>("zrnnenkinyousiharaid", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnsiharainenkingaku = new ExDBFieldNumber<>("zrnsiharainenkingaku", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsiharaisyoruiuketukeymd = new ExDBFieldString<>("zrnsiharaisyoruiuketukeymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsiharaiuketukebasyo = new ExDBFieldString<>("zrnsiharaiuketukebasyo", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnshiharaihasseiymd = new ExDBFieldString<>("zrnshiharaihasseiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksjihihokensyaage = new ExDBFieldString<>("zrnnksjihihokensyaage", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnhihokensyasibouymd = new ExDBFieldString<>("zrnhihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrndai2hihokensyaseibetukbn = new ExDBFieldString<>("zrndai2hihokensyaseibetukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksjidai2hhknsyaage = new ExDBFieldString<>("zrnnksjidai2hhknsyaage", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrndai2hihokensyasibouymd = new ExDBFieldString<>("zrndai2hihokensyasibouymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrndai2hihokensyaseiymd = new ExDBFieldString<>("zrndai2hihokensyaseiymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnkhknhoutekiyouhyj = new ExDBFieldString<>("zrnnkhknhoutekiyouhyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv1x2 = new ExDBFieldString<>("zrnyobiv1x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntuusinsakiyuubinno = new ExDBFieldString<>("zrntuusinsakiyuubinno", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntuusinsakitikucd = new ExDBFieldString<>("zrntuusinsakitikucd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv1x3 = new ExDBFieldString<>("zrnyobiv1x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv1x4 = new ExDBFieldString<>("zrnyobiv1x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv8x3 = new ExDBFieldString<>("zrnyobiv8x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv8x4 = new ExDBFieldString<>("zrnyobiv8x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv59 = new ExDBFieldString<>("zrnyobiv59", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x1 = new ExDBFieldString<>("zrnnksyuruikguyobi1x1", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x2 = new ExDBFieldString<>("zrnnksyuruikguyobi1x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x3 = new ExDBFieldString<>("zrnnksyuruikguyobi1x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x4 = new ExDBFieldString<>("zrnnksyuruikguyobi1x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x5 = new ExDBFieldString<>("zrnnksyuruikguyobi1x5", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x6 = new ExDBFieldString<>("zrnnksyuruikguyobi1x6", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x7 = new ExDBFieldString<>("zrnnksyuruikguyobi1x7", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x8 = new ExDBFieldString<>("zrnnksyuruikguyobi1x8", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x9 = new ExDBFieldString<>("zrnnksyuruikguyobi1x9", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x10 = new ExDBFieldString<>("zrnnksyuruikguyobi1x10", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x11 = new ExDBFieldString<>("zrnnksyuruikguyobi1x11", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x12 = new ExDBFieldString<>("zrnnksyuruikguyobi1x12", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x13 = new ExDBFieldString<>("zrnnksyuruikguyobi1x13", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x14 = new ExDBFieldString<>("zrnnksyuruikguyobi1x14", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi1x15 = new ExDBFieldString<>("zrnnksyuruikguyobi1x15", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x1 = new ExDBFieldString<>("zrnnksyuruikguyobi2x1", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x2 = new ExDBFieldString<>("zrnnksyuruikguyobi2x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x3 = new ExDBFieldString<>("zrnnksyuruikguyobi2x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x4 = new ExDBFieldString<>("zrnnksyuruikguyobi2x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x5 = new ExDBFieldString<>("zrnnksyuruikguyobi2x5", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x6 = new ExDBFieldString<>("zrnnksyuruikguyobi2x6", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x7 = new ExDBFieldString<>("zrnnksyuruikguyobi2x7", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x8 = new ExDBFieldString<>("zrnnksyuruikguyobi2x8", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x9 = new ExDBFieldString<>("zrnnksyuruikguyobi2x9", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi2x10 = new ExDBFieldString<>("zrnnksyuruikguyobi2x10", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x1 = new ExDBFieldString<>("zrnnksyuruikguyobi3x1", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x2 = new ExDBFieldString<>("zrnnksyuruikguyobi3x2", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x3 = new ExDBFieldString<>("zrnnksyuruikguyobi3x3", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x4 = new ExDBFieldString<>("zrnnksyuruikguyobi3x4", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x5 = new ExDBFieldString<>("zrnnksyuruikguyobi3x5", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x6 = new ExDBFieldString<>("zrnnksyuruikguyobi3x6", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x7 = new ExDBFieldString<>("zrnnksyuruikguyobi3x7", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x8 = new ExDBFieldString<>("zrnnksyuruikguyobi3x8", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x9 = new ExDBFieldString<>("zrnnksyuruikguyobi3x9", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnnksyuruikguyobi3x10 = new ExDBFieldString<>("zrnnksyuruikguyobi3x10", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntoukeisyuuseisyorikbn = new ExDBFieldString<>("zrntoukeisyuuseisyorikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntoukeimodkurykhssiymd = new ExDBFieldString<>("zrntoukeimodkurykhssiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntoukeimoddenpyouymd = new ExDBFieldString<>("zrntoukeimoddenpyouymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntoukeimodbikinmodkbn = new ExDBFieldString<>("zrntoukeimodbikinmodkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntoukeimodbikinshrymd = new ExDBFieldString<>("zrntoukeimodbikinshrymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrntoukeimodbikinkijyugk = new ExDBFieldNumber<>("zrntoukeimodbikinkijyugk", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnbikinnaiyoukbn = new ExDBFieldString<>("zrnbikinnaiyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnbikinkeiyakujyoukyoukbn = new ExDBFieldString<>("zrnbikinkeiyakujyoukyoukbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasinenkinarihyouji = new ExDBFieldString<>("zrnkaimasinenkinarihyouji", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnmaeatuatoatusegarihyj = new ExDBFieldString<>("zrnmaeatuatoatusegarihyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnzaikeiyuatatkimsnkarihyj = new ExDBFieldString<>("zrnzaikeiyuatatkimsnkarihyj", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrntyouhyousakuseitanikbn = new ExDBFieldString<>("zrntyouhyousakuseitanikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnshrnkgknaiyoukbn = new ExDBFieldString<>("zrnshrnkgknaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnutikaimasinenkingaku = new ExDBFieldNumber<>("zrnutikaimasinenkingaku", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnpitijibaraikbn = new ExDBFieldString<>("zrnpitijibaraikbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyoukigsyayotisbourtkbn = new ExDBFieldString<>("zrnyoukigsyayotisbourtkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyukigsyayoteihasseirtkbn = new ExDBFieldString<>("zrnyukigsyayoteihasseirtkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyukigsyayoteisytgnrtkbn = new ExDBFieldString<>("zrnyukigsyayoteisytgnrtkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasinkkouryokusymd = new ExDBFieldString<>("zrnkaimasinkkouryokusymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasinenkinkbn = new ExDBFieldString<>("zrnkaimasinenkinkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasinenkinsyuruikigou = new ExDBFieldString<>("zrnkaimasinenkinsyuruikigou", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasinkshrkkn = new ExDBFieldString<>("zrnkaimasinkshrkkn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasinenkinhosyoukikan = new ExDBFieldString<>("zrnkaimasinenkinhosyoukikan", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasinkhhknsyaage = new ExDBFieldString<>("zrnkaimasinkhhknsyaage", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkimsnkdai2hhknsyaage = new ExDBFieldString<>("zrnkimsnkdai2hhknsyaage", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnsaisyuunenkinkaimasiymd = new ExDBFieldString<>("zrnsaisyuunenkinkaimasiymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnkaimasinenkingaku = new ExDBFieldNumber<>("zrnkaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnzennendokaimasinkgk = new ExDBFieldNumber<>("zrnzennendokaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnznznnndkaimasinkzougk = new ExDBFieldNumber<>("zrnznznnndkaimasinkzougk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnznznznnndkaimasinkgk = new ExDBFieldNumber<>("zrnznznznnndkaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrntounendokaimasinenkind = new ExDBFieldNumber<>("zrntounendokaimasinenkind", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasityuusiymd = new ExDBFieldString<>("zrnkaimasityuusiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasihukkiymd = new ExDBFieldString<>("zrnkaimasihukkiymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnkaimasinkkigousdkbn = new ExDBFieldString<>("zrnkaimasinkkigousdkbn", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnmaeatuatoatukouryokusymd = new ExDBFieldString<>("zrnmaeatuatoatukouryokusymd", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnmaeatuatoatukikan = new ExDBFieldString<>("zrnmaeatuatoatukikan", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnmaeatuatoatuhendougonkgk = new ExDBFieldNumber<>("zrnmaeatuatoatuhendougonkgk", this);

    public final ExDBFieldString<ZT_NkToukeiRigRn, String> zrnatoatusaisyuukaimasiymd = new ExDBFieldString<>("zrnatoatusaisyuukaimasiymd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnatoatukaimasinenkingaku = new ExDBFieldNumber<>("zrnatoatukaimasinenkingaku", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnznnndatoatukaimasinkgk = new ExDBFieldNumber<>("zrnznnndatoatukaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnznznnndatoatukaimasinkgk = new ExDBFieldNumber<>("zrnznznnndatoatukaimasinkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnznznznnndatatkimsnkgk = new ExDBFieldNumber<>("zrnznznznnndatatkimsnkgk", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrntounendatoatukaimasinkd = new ExDBFieldNumber<>("zrntounendatoatukaimasinkd", this);

    public final ExDBFieldNumber<ZT_NkToukeiRigRn, Long> zrnuwanoseatoatukaimasinkgk = new ExDBFieldNumber<>("zrnuwanoseatoatukaimasinkgk", this);
}
