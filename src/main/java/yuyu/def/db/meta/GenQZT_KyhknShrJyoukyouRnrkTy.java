package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KyhknShrJyoukyouRnrkTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 給付金支払状況連絡Fテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KyhknShrJyoukyouRnrkTy extends AbstractExDBTable<ZT_KyhknShrJyoukyouRnrkTy> {

    public GenQZT_KyhknShrJyoukyouRnrkTy() {
        this("ZT_KyhknShrJyoukyouRnrkTy");
    }

    public GenQZT_KyhknShrJyoukyouRnrkTy(String pAlias) {
        super("ZT_KyhknShrJyoukyouRnrkTy", ZT_KyhknShrJyoukyouRnrkTy.class, pAlias);
    }

    public String ZT_KyhknShrJyoukyouRnrkTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyobiv12 = new ExDBFieldString<>("ztyyobiv12", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytksyukgu = new ExDBFieldString<>("ztytksyukgu", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytokuyakugatakbn = new ExDBFieldString<>("ztytokuyakugatakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytokuyakukisi = new ExDBFieldString<>("ztytokuyakukisi", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytyuutohukakbn = new ExDBFieldString<>("ztytyuutohukakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyhyoukataikbn = new ExDBFieldString<>("ztyhyoukataikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyatukaisisyatodouhukencd = new ExDBFieldString<>("ztyatukaisisyatodouhukencd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytokuyakusinkyuukbn = new ExDBFieldString<>("ztytokuyakusinkyuukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytkykdai2hihokensyahyj = new ExDBFieldString<>("ztytkykdai2hihokensyahyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytokuteisippeisethyj = new ExDBFieldString<>("ztytokuteisippeisethyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyjyusyousyaseibetukbn = new ExDBFieldString<>("ztyjyusyousyaseibetukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykazokujyusyousyakbn = new ExDBFieldString<>("ztykazokujyusyousyakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykeiyakunen = new ExDBFieldString<>("ztykeiyakunen", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztymannenreihyj = new ExDBFieldString<>("ztymannenreihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykyuuhukbn = new ExDBFieldString<>("ztykyuuhukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysiharaijyoutaikbn = new ExDBFieldString<>("ztysiharaijyoutaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyouincd = new ExDBFieldString<>("ztysyouincd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyjikohasseiymd2 = new ExDBFieldString<>("ztyjikohasseiymd2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyougaikoteiymd = new ExDBFieldString<>("ztysyougaikoteiymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztynyuuinymd = new ExDBFieldString<>("ztynyuuinymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyshrymd = new ExDBFieldString<>("ztyshrymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykyuuhuwariai = new ExDBFieldString<>("ztykyuuhuwariai", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Integer> ztysiharaikingakun9 = new ExDBFieldNumber<>("ztysiharaikingakun9", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Integer> ztykyoukaihoukokuyoukingaku = new ExDBFieldNumber<>("ztykyoukaihoukokuyoukingaku", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytuuinkakujyuuhukakbn = new ExDBFieldString<>("ztytuuinkakujyuuhukakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykangohukahyj = new ExDBFieldString<>("ztykangohukahyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysonsyoukyuuhukinkbn = new ExDBFieldString<>("ztysonsyoukyuuhukinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysiboukoudosyougaicd = new ExDBFieldString<>("ztysiboukoudosyougaicd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyokikyuuhutandokushrhyj = new ExDBFieldString<>("ztysyokikyuuhutandokushrhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykakuseikyuuhukbn = new ExDBFieldString<>("ztykakuseikyuuhukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysoukikeakyuuhutuusankisu = new ExDBFieldString<>("ztysoukikeakyuuhutuusankisu", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyonendokyuuhuwariai = new ExDBFieldString<>("ztysyonendokyuuhuwariai", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyonendosiharaihyj = new ExDBFieldString<>("ztysyonendosiharaihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyobiv4x2 = new ExDBFieldString<>("ztyyobiv4x2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykousingohasseihyj = new ExDBFieldString<>("ztykousingohasseihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztybyoumeicd1 = new ExDBFieldString<>("ztybyoumeicd1", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztybyoumeicd2 = new ExDBFieldString<>("ztybyoumeicd2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysaigaigenincd = new ExDBFieldString<>("ztysaigaigenincd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyougaitoukyuugou = new ExDBFieldString<>("ztysyougaitoukyuugou", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyujyutucd = new ExDBFieldString<>("ztysyujyutucd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyujyutumeicd = new ExDBFieldString<>("ztysyujyutumeicd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytuuinkangogeninkbn = new ExDBFieldString<>("ztytuuinkangogeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyundoukisonsyoukbn = new ExDBFieldString<>("ztyundoukisonsyoukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyganmensonsyoukbn = new ExDBFieldString<>("ztyganmensonsyoukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysonsyougeninkbn = new ExDBFieldString<>("ztysonsyougeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykikensportskbn = new ExDBFieldString<>("ztykikensportskbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyobiv2x2 = new ExDBFieldString<>("ztyyobiv2x2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysiharainissuukbn = new ExDBFieldString<>("ztysiharainissuukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykakuseikatakbn = new ExDBFieldString<>("ztykakuseikatakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztybosyuukeirokbn = new ExDBFieldString<>("ztybosyuukeirokbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztypmenhutanpohyj = new ExDBFieldString<>("ztypmenhutanpohyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykousinkbn = new ExDBFieldString<>("ztykousinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykusnmetkyksykipjyutuym = new ExDBFieldString<>("ztykusnmetkyksykipjyutuym", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytoukeiyousinsakbn = new ExDBFieldString<>("ztytoukeiyousinsakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztypmenhukakbn = new ExDBFieldString<>("ztypmenhukakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztypmenkbnv2 = new ExDBFieldString<>("ztypmenkbnv2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyketteikijyunkanwakbn = new ExDBFieldString<>("ztyketteikijyunkanwakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytokuyakukigousedaikbn = new ExDBFieldString<>("ztytokuyakukigousedaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztystdssnskbn = new ExDBFieldString<>("ztystdssnskbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysotodasikousinkbn = new ExDBFieldString<>("ztysotodasikousinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyqpackhyj = new ExDBFieldString<>("ztyqpackhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztybunkatukbn = new ExDBFieldString<>("ztybunkatukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytenkanhosyouminaosikbn = new ExDBFieldString<>("ztytenkanhosyouminaosikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykousinmaesiharaihyj = new ExDBFieldString<>("ztykousinmaesiharaihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztydouitunyuuinno = new ExDBFieldString<>("ztydouitunyuuinno", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyujyutujinyuuinkbn = new ExDBFieldString<>("ztysyujyutujinyuuinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyujyutusyuruikbn = new ExDBFieldString<>("ztysyujyutusyuruikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztygannyuuinkbn = new ExDBFieldString<>("ztygannyuuinkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyhokenhoutekiyouhyouji = new ExDBFieldString<>("ztyhokenhoutekiyouhyouji", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztysotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysisyacd = new ExDBFieldString<>("ztysisyacd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysuuriyouyobiv11 = new ExDBFieldString<>("ztysuuriyouyobiv11", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyoukaigojyoutaikaisiymd = new ExDBFieldString<>("ztyyoukaigojyoutaikaisiymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyoukaigojyoutaiendymd = new ExDBFieldString<>("ztyyoukaigojyoutaiendymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyrendouyousntkjyubbnhyj = new ExDBFieldString<>("ztyrendouyousntkjyubbnhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztymusentakukeiyakukbn = new ExDBFieldString<>("ztymusentakukeiyakukbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztymaruteiskeijihukahyj = new ExDBFieldString<>("ztymaruteiskeijihukahyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytoliplhyj = new ExDBFieldString<>("ztytoliplhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztystdssytikbn = new ExDBFieldString<>("ztystdssytikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyhisei = new ExDBFieldString<>("ztyhisei", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Integer> ztysuuriyobin9 = new ExDBFieldNumber<>("ztysuuriyobin9", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Long> ztysaigaisibousiharaikngk = new ExDBFieldNumber<>("ztysaigaisibousiharaikngk", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytokuyakuhinen = new ExDBFieldString<>("ztytokuyakuhinen", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Integer> ztygnykbttryukyuhkntusnkisu = new ExDBFieldNumber<>("ztygnykbttryukyuhkntusnkisu", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztygansyuruikbn = new ExDBFieldString<>("ztygansyuruikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyganyakubutusyuruikbn = new ExDBFieldString<>("ztyganyakubutusyuruikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyuuroukigjyujtjyutikbn = new ExDBFieldString<>("ztysyuuroukigjyujtjyutikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyuuroukigjyujtgeninkbn = new ExDBFieldString<>("ztysyuuroukigjyujtgeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykigjyujtjyoutaigeninkbn = new ExDBFieldString<>("ztykigjyujtjyoutaigeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysykmtssyukahikbn = new ExDBFieldString<>("ztysykmtssyukahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyfktrsmtkahikbn = new ExDBFieldString<>("ztyfktrsmtkahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyhokoukahikbn = new ExDBFieldString<>("ztyhokoukahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztynyykkahikbn = new ExDBFieldString<>("ztynyykkahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyihukutyakudatukahikbn = new ExDBFieldString<>("ztyihukutyakudatukahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyngerkahikbn = new ExDBFieldString<>("ztyngerkahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyseiketuseiyoukahikbn = new ExDBFieldString<>("ztyseiketuseiyoukahikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztynintisyougeninkbn = new ExDBFieldString<>("ztynintisyougeninkbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysyuruhnujyujtjyutikbn = new ExDBFieldString<>("ztysyuruhnujyujtjyutikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztytokuteisyougaikbn = new ExDBFieldString<>("ztytokuteisyougaikbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztydatakanrino2 = new ExDBFieldString<>("ztydatakanrino2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztydatakanrino3 = new ExDBFieldString<>("ztydatakanrino3", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyknkuzusnzyrttekitkarihyj = new ExDBFieldString<>("ztyknkuzusnzyrttekitkarihyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztybluekeizokuhyouji = new ExDBFieldString<>("ztybluekeizokuhyouji", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyzyrthntiyustatuskbn = new ExDBFieldString<>("ztyzyrthntiyustatuskbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyzyrthntiyustatuskbnx2 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyzyrthntiyustatuskbnx3 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx3", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyzyrthntiyustatuskbnx4 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx4", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyzyrthntiyustatuskbnx5 = new ExDBFieldString<>("ztyzyrthntiyustatuskbnx5", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyknkuzusnzyrt = new ExDBFieldString<>("ztyknkuzusnzyrt", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyknkuzusnzyrtx2 = new ExDBFieldString<>("ztyknkuzusnzyrtx2", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysinkeiyakujivithkhyouji = new ExDBFieldString<>("ztysinkeiyakujivithkhyouji", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztypwrbksidhitekiyouhyj = new ExDBFieldString<>("ztypwrbksidhitekiyouhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysuuriyouyobin4 = new ExDBFieldString<>("ztysuuriyouyobin4", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, BizNumber> ztykawaserate = new ExDBFieldString<>("ztykawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztykawaseratetekiyouymd = new ExDBFieldString<>("ztykawaseratetekiyouymd", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Long> ztygaikadatesiharais = new ExDBFieldNumber<>("ztygaikadatesiharais", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Long> ztygaikadatesyukeiyakus = new ExDBFieldNumber<>("ztygaikadatesyukeiyakus", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Long> ztygaikadatesyukeiyakup = new ExDBFieldNumber<>("ztygaikadatesyukeiyakup", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Long> ztyenkdtsbujsitihsyukngk = new ExDBFieldNumber<>("ztyenkdtsbujsitihsyukngk", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztysuuriyouyobin10 = new ExDBFieldString<>("ztysuuriyouyobin10", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyobiv10x2 = new ExDBFieldString<>("ztyyobiv10x2", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Long> ztymvatyouseigow = new ExDBFieldNumber<>("ztymvatyouseigow", this);

    public final ExDBFieldNumber<ZT_KyhknShrJyoukyouRnrkTy, Long> ztymvakeisanjisknnjynbkn = new ExDBFieldNumber<>("ztymvakeisanjisknnjynbkn", this);

    public final ExDBFieldString<ZT_KyhknShrJyoukyouRnrkTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);
}
