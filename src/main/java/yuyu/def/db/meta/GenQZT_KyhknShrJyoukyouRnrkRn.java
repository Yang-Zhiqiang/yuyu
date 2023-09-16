package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 給付金支払状況連絡Fテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KyhknShrJyoukyouRnrkRn extends AbstractExDBTable<ZT_KyhknShrJyoukyouRnrkRn> {

    public GenQZT_KyhknShrJyoukyouRnrkRn() {
        this("ZT_KyhknShrJyoukyouRnrkRn");
    }

    public GenQZT_KyhknShrJyoukyouRnrkRn(String pAlias) {
        super("ZT_KyhknShrJyoukyouRnrkRn", ZT_KyhknShrJyoukyouRnrkRn.class, pAlias);
    }

    public String ZT_KyhknShrJyoukyouRnrkRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyobiv12 = new ExDBFieldString<>("zrnyobiv12", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntksyukgu = new ExDBFieldString<>("zrntksyukgu", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntokuyakugatakbn = new ExDBFieldString<>("zrntokuyakugatakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntokuyakukisi = new ExDBFieldString<>("zrntokuyakukisi", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntyuutohukakbn = new ExDBFieldString<>("zrntyuutohukakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnhyoukataikbn = new ExDBFieldString<>("zrnhyoukataikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnatukaisisyatodouhukencd = new ExDBFieldString<>("zrnatukaisisyatodouhukencd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntokuyakusinkyuukbn = new ExDBFieldString<>("zrntokuyakusinkyuukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntkykdai2hihokensyahyj = new ExDBFieldString<>("zrntkykdai2hihokensyahyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntokuteisippeisethyj = new ExDBFieldString<>("zrntokuteisippeisethyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnjyusyousyaseibetukbn = new ExDBFieldString<>("zrnjyusyousyaseibetukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkazokujyusyousyakbn = new ExDBFieldString<>("zrnkazokujyusyousyakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkeiyakunen = new ExDBFieldString<>("zrnkeiyakunen", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnmannenreihyj = new ExDBFieldString<>("zrnmannenreihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkyuuhukbn = new ExDBFieldString<>("zrnkyuuhukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsiharaijyoutaikbn = new ExDBFieldString<>("zrnsiharaijyoutaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyouincd = new ExDBFieldString<>("zrnsyouincd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnjikohasseiymd2 = new ExDBFieldString<>("zrnjikohasseiymd2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyougaikoteiymd = new ExDBFieldString<>("zrnsyougaikoteiymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnnyuuinymd = new ExDBFieldString<>("zrnnyuuinymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnshrymd = new ExDBFieldString<>("zrnshrymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkyuuhuwariai = new ExDBFieldString<>("zrnkyuuhuwariai", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Integer> zrnsiharaikingakun9 = new ExDBFieldNumber<>("zrnsiharaikingakun9", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Integer> zrnkyoukaihoukokuyoukingaku = new ExDBFieldNumber<>("zrnkyoukaihoukokuyoukingaku", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntuuinkakujyuuhukakbn = new ExDBFieldString<>("zrntuuinkakujyuuhukakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkangohukahyj = new ExDBFieldString<>("zrnkangohukahyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsonsyoukyuuhukinkbn = new ExDBFieldString<>("zrnsonsyoukyuuhukinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsiboukoudosyougaicd = new ExDBFieldString<>("zrnsiboukoudosyougaicd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyokikyuuhutandokushrhyj = new ExDBFieldString<>("zrnsyokikyuuhutandokushrhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkakuseikyuuhukbn = new ExDBFieldString<>("zrnkakuseikyuuhukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsoukikeakyuuhutuusankisu = new ExDBFieldString<>("zrnsoukikeakyuuhutuusankisu", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyonendokyuuhuwariai = new ExDBFieldString<>("zrnsyonendokyuuhuwariai", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyonendosiharaihyj = new ExDBFieldString<>("zrnsyonendosiharaihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyobiv4x2 = new ExDBFieldString<>("zrnyobiv4x2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkousingohasseihyj = new ExDBFieldString<>("zrnkousingohasseihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnbyoumeicd1 = new ExDBFieldString<>("zrnbyoumeicd1", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnbyoumeicd2 = new ExDBFieldString<>("zrnbyoumeicd2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsaigaigenincd = new ExDBFieldString<>("zrnsaigaigenincd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyougaitoukyuugou = new ExDBFieldString<>("zrnsyougaitoukyuugou", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyujyutucd = new ExDBFieldString<>("zrnsyujyutucd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyujyutumeicd = new ExDBFieldString<>("zrnsyujyutumeicd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntuuinkangogeninkbn = new ExDBFieldString<>("zrntuuinkangogeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnundoukisonsyoukbn = new ExDBFieldString<>("zrnundoukisonsyoukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnganmensonsyoukbn = new ExDBFieldString<>("zrnganmensonsyoukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsonsyougeninkbn = new ExDBFieldString<>("zrnsonsyougeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkikensportskbn = new ExDBFieldString<>("zrnkikensportskbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyobiv2x2 = new ExDBFieldString<>("zrnyobiv2x2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsiharainissuukbn = new ExDBFieldString<>("zrnsiharainissuukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkakuseikatakbn = new ExDBFieldString<>("zrnkakuseikatakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnbosyuukeirokbn = new ExDBFieldString<>("zrnbosyuukeirokbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnpmenhutanpohyj = new ExDBFieldString<>("zrnpmenhutanpohyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkousinkbn = new ExDBFieldString<>("zrnkousinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkusnmetkyksykipjyutuym = new ExDBFieldString<>("zrnkusnmetkyksykipjyutuym", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntoukeiyousinsakbn = new ExDBFieldString<>("zrntoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnpmenhukakbn = new ExDBFieldString<>("zrnpmenhukakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnpmenkbnv2 = new ExDBFieldString<>("zrnpmenkbnv2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnketteikijyunkanwakbn = new ExDBFieldString<>("zrnketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntokuyakukigousedaikbn = new ExDBFieldString<>("zrntokuyakukigousedaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnstdssnskbn = new ExDBFieldString<>("zrnstdssnskbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsotodasikousinkbn = new ExDBFieldString<>("zrnsotodasikousinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnbosyuukeitaikbn = new ExDBFieldString<>("zrnbosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnqpackhyj = new ExDBFieldString<>("zrnqpackhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnbunkatukbn = new ExDBFieldString<>("zrnbunkatukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntenkanhosyouminaosikbn = new ExDBFieldString<>("zrntenkanhosyouminaosikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkousinmaesiharaihyj = new ExDBFieldString<>("zrnkousinmaesiharaihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrndouitunyuuinno = new ExDBFieldString<>("zrndouitunyuuinno", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyujyutujinyuuinkbn = new ExDBFieldString<>("zrnsyujyutujinyuuinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyujyutusyuruikbn = new ExDBFieldString<>("zrnsyujyutusyuruikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrngannyuuinkbn = new ExDBFieldString<>("zrngannyuuinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnhokenhoutekiyouhyouji = new ExDBFieldString<>("zrnhokenhoutekiyouhyouji", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntokuteijyoutaihushrhyj = new ExDBFieldString<>("zrntokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsisyacd = new ExDBFieldString<>("zrnsisyacd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsuuriyouyobiv11 = new ExDBFieldString<>("zrnsuuriyouyobiv11", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyoukaigojyoutaikaisiymd = new ExDBFieldString<>("zrnyoukaigojyoutaikaisiymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyoukaigojyoutaiendymd = new ExDBFieldString<>("zrnyoukaigojyoutaiendymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnrendouyousntkjyubbnhyj = new ExDBFieldString<>("zrnrendouyousntkjyubbnhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnmusentakukeiyakukbn = new ExDBFieldString<>("zrnmusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnmaruteiskeijihukahyj = new ExDBFieldString<>("zrnmaruteiskeijihukahyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntoliplhyj = new ExDBFieldString<>("zrntoliplhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnhisei = new ExDBFieldString<>("zrnhisei", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Integer> zrnsuuriyobin9 = new ExDBFieldNumber<>("zrnsuuriyobin9", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Long> zrnsaigaisibousiharaikngk = new ExDBFieldNumber<>("zrnsaigaisibousiharaikngk", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntokuyakuhinen = new ExDBFieldString<>("zrntokuyakuhinen", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Integer> zrngnykbttryukyuhkntusnkisu = new ExDBFieldNumber<>("zrngnykbttryukyuhkntusnkisu", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrngansyuruikbn = new ExDBFieldString<>("zrngansyuruikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnganyakubutusyuruikbn = new ExDBFieldString<>("zrnganyakubutusyuruikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyuuroukigjyujtjyutikbn = new ExDBFieldString<>("zrnsyuuroukigjyujtjyutikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyuuroukigjyujtgeninkbn = new ExDBFieldString<>("zrnsyuuroukigjyujtgeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkigjyujtjyoutaigeninkbn = new ExDBFieldString<>("zrnkigjyujtjyoutaigeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsykmtssyukahikbn = new ExDBFieldString<>("zrnsykmtssyukahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnfktrsmtkahikbn = new ExDBFieldString<>("zrnfktrsmtkahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnhokoukahikbn = new ExDBFieldString<>("zrnhokoukahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnnyykkahikbn = new ExDBFieldString<>("zrnnyykkahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnihukutyakudatukahikbn = new ExDBFieldString<>("zrnihukutyakudatukahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnngerkahikbn = new ExDBFieldString<>("zrnngerkahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnseiketuseiyoukahikbn = new ExDBFieldString<>("zrnseiketuseiyoukahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnnintisyougeninkbn = new ExDBFieldString<>("zrnnintisyougeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsyuruhnujyujtjyutikbn = new ExDBFieldString<>("zrnsyuruhnujyujtjyutikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrntokuteisyougaikbn = new ExDBFieldString<>("zrntokuteisyougaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrndatakanrino2 = new ExDBFieldString<>("zrndatakanrino2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrndatakanrino3 = new ExDBFieldString<>("zrndatakanrino3", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("zrnknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnbluekeizokuhyouji = new ExDBFieldString<>("zrnbluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnzyrthntiyustatuskbn = new ExDBFieldString<>("zrnzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnzyrthntiyustatuskbnx2 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnzyrthntiyustatuskbnx3 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnzyrthntiyustatuskbnx4 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnzyrthntiyustatuskbnx5 = new ExDBFieldString<>("zrnzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnknkuzusnzyrt = new ExDBFieldString<>("zrnknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnknkuzusnzyrtx2 = new ExDBFieldString<>("zrnknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsinkeiyakujivithkhyouji = new ExDBFieldString<>("zrnsinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnpwrbksidhitekiyouhyj = new ExDBFieldString<>("zrnpwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsuuriyouyobin4 = new ExDBFieldString<>("zrnsuuriyouyobin4", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, BizNumber> zrnkawaserate = new ExDBFieldString<>("zrnkawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnkawaseratetekiyouymd = new ExDBFieldString<>("zrnkawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Long> zrngaikadatesiharais = new ExDBFieldNumber<>("zrngaikadatesiharais", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Long> zrngaikadatesyukeiyakus = new ExDBFieldNumber<>("zrngaikadatesyukeiyakus", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Long> zrngaikadatesyukeiyakup = new ExDBFieldNumber<>("zrngaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Long> zrnenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("zrnenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnsuuriyouyobin10 = new ExDBFieldString<>("zrnsuuriyouyobin10", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyobiv10x2 = new ExDBFieldString<>("zrnyobiv10x2", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Long> zrnmvatyouseigow = new ExDBFieldNumber<>("zrnmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkRn, Long> zrnmvakeisanjisknnjynbkn = new ExDBFieldNumber<>("zrnmvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);
}
