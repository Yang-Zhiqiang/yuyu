package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 株価指数連動保険Ｖ検証用Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SrKbkSsuRnduHknVKnsyuyuRn extends AbstractExDBTable<ZT_SrKbkSsuRnduHknVKnsyuyuRn> {

    public GenQZT_SrKbkSsuRnduHknVKnsyuyuRn() {
        this("ZT_SrKbkSsuRnduHknVKnsyuyuRn");
    }

    public GenQZT_SrKbkSsuRnduHknVKnsyuyuRn(String pAlias) {
        super("ZT_SrKbkSsuRnduHknVKnsyuyuRn", ZT_SrKbkSsuRnduHknVKnsyuyuRn.class, pAlias);
    }

    public String ZT_SrKbkSsuRnduHknVKnsyuyuRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsuuriyouyobin6 = new ExDBFieldString<>("zrnsuuriyouyobin6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv12 = new ExDBFieldString<>("zrnyobiv12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsuuriyouyobin6x2 = new ExDBFieldString<>("zrnsuuriyouyobin6x2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnkuriagekurisagekbn = new ExDBFieldString<>("zrnkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsuuriyouyobin6x3 = new ExDBFieldString<>("zrnsuuriyouyobin6x3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnsrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("zrnsrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnsrkyksjkkktyouseiriritu = new ExDBFieldString<>("zrnsrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnmvatyouseikou = new ExDBFieldString<>("zrnmvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuurendourate = new ExDBFieldString<>("zrnsisuurendourate", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuukbn = new ExDBFieldString<>("zrnsisuukbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnkimatukawaserate = new ExDBFieldString<>("zrnkimatukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnkaiyakukoujyoritu = new ExDBFieldString<>("zrnkaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsknnkaisiymd = new ExDBFieldString<>("zrnsknnkaisiymd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnrendouritu = new ExDBFieldString<>("zrnrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsuuriyouyobin3 = new ExDBFieldString<>("zrnsuuriyouyobin3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnmvatyouseigow = new ExDBFieldNumber<>("zrnmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnmvakeisanjisknnjynbkn = new ExDBFieldNumber<>("zrnmvakeisanjisknnjynbkn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnkmtsisuurentumitatekn = new ExDBFieldNumber<>("zrnkmtsisuurentumitatekn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnkmttirttmtttumitatekn = new ExDBFieldNumber<>("zrnkmttirttmtttumitatekn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnkmtsisuurentyokugotmttkn = new ExDBFieldNumber<>("zrnkmtsisuurentyokugotmttkn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymd = new ExDBFieldString<>("zrnsisuubbncalckijyunymd", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekin = new ExDBFieldNumber<>("zrnsisuubbntumitatekin", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuu = new ExDBFieldString<>("zrntoukisisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymd = new ExDBFieldString<>("zrntoukisisuukijyunymd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuu = new ExDBFieldString<>("zrnzenkisisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymd = new ExDBFieldString<>("zrnzenkisisuukijyunymd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritu = new ExDBFieldString<>("zrntmttknzoukaritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikin = new ExDBFieldNumber<>("zrntoukitumimasikin", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9 = new ExDBFieldString<>("zrnyobiv9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx2 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx2", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx2 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux2 = new ExDBFieldString<>("zrntoukisisuux2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx2 = new ExDBFieldString<>("zrntoukisisuukijyunymdx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux2 = new ExDBFieldString<>("zrnzenkisisuux2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx2 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux2 = new ExDBFieldString<>("zrntmttknzoukaritux2", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx2 = new ExDBFieldNumber<>("zrntoukitumimasikinx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x2 = new ExDBFieldString<>("zrnyobiv9x2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx3 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx3", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx3 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux3 = new ExDBFieldString<>("zrntoukisisuux3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx3 = new ExDBFieldString<>("zrntoukisisuukijyunymdx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux3 = new ExDBFieldString<>("zrnzenkisisuux3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx3 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux3 = new ExDBFieldString<>("zrntmttknzoukaritux3", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx3 = new ExDBFieldNumber<>("zrntoukitumimasikinx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x3 = new ExDBFieldString<>("zrnyobiv9x3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx4 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx4", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx4 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux4 = new ExDBFieldString<>("zrntoukisisuux4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx4 = new ExDBFieldString<>("zrntoukisisuukijyunymdx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux4 = new ExDBFieldString<>("zrnzenkisisuux4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx4 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux4 = new ExDBFieldString<>("zrntmttknzoukaritux4", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx4 = new ExDBFieldNumber<>("zrntoukitumimasikinx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x4 = new ExDBFieldString<>("zrnyobiv9x4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx5 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx5", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx5 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux5 = new ExDBFieldString<>("zrntoukisisuux5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx5 = new ExDBFieldString<>("zrntoukisisuukijyunymdx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux5 = new ExDBFieldString<>("zrnzenkisisuux5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx5 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux5 = new ExDBFieldString<>("zrntmttknzoukaritux5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx5 = new ExDBFieldNumber<>("zrntoukitumimasikinx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x5 = new ExDBFieldString<>("zrnyobiv9x5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx6 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx6", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx6 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux6 = new ExDBFieldString<>("zrntoukisisuux6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx6 = new ExDBFieldString<>("zrntoukisisuukijyunymdx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux6 = new ExDBFieldString<>("zrnzenkisisuux6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx6 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux6 = new ExDBFieldString<>("zrntmttknzoukaritux6", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx6 = new ExDBFieldNumber<>("zrntoukitumimasikinx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x6 = new ExDBFieldString<>("zrnyobiv9x6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx7 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx7", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx7 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux7 = new ExDBFieldString<>("zrntoukisisuux7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx7 = new ExDBFieldString<>("zrntoukisisuukijyunymdx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux7 = new ExDBFieldString<>("zrnzenkisisuux7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx7 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux7 = new ExDBFieldString<>("zrntmttknzoukaritux7", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx7 = new ExDBFieldNumber<>("zrntoukitumimasikinx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x7 = new ExDBFieldString<>("zrnyobiv9x7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx8 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx8", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx8 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux8 = new ExDBFieldString<>("zrntoukisisuux8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx8 = new ExDBFieldString<>("zrntoukisisuukijyunymdx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux8 = new ExDBFieldString<>("zrnzenkisisuux8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx8 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux8 = new ExDBFieldString<>("zrntmttknzoukaritux8", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx8 = new ExDBFieldNumber<>("zrntoukitumimasikinx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x8 = new ExDBFieldString<>("zrnyobiv9x8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx9 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx9", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx9 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux9 = new ExDBFieldString<>("zrntoukisisuux9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx9 = new ExDBFieldString<>("zrntoukisisuukijyunymdx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux9 = new ExDBFieldString<>("zrnzenkisisuux9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx9 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux9 = new ExDBFieldString<>("zrntmttknzoukaritux9", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx9 = new ExDBFieldNumber<>("zrntoukitumimasikinx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x9 = new ExDBFieldString<>("zrnyobiv9x9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx10 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx10", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx10 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux10 = new ExDBFieldString<>("zrntoukisisuux10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx10 = new ExDBFieldString<>("zrntoukisisuukijyunymdx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux10 = new ExDBFieldString<>("zrnzenkisisuux10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx10 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux10 = new ExDBFieldString<>("zrntmttknzoukaritux10", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx10 = new ExDBFieldNumber<>("zrntoukitumimasikinx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x10 = new ExDBFieldString<>("zrnyobiv9x10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx11 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx11", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx11 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux11 = new ExDBFieldString<>("zrntoukisisuux11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx11 = new ExDBFieldString<>("zrntoukisisuukijyunymdx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux11 = new ExDBFieldString<>("zrnzenkisisuux11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx11 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux11 = new ExDBFieldString<>("zrntmttknzoukaritux11", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx11 = new ExDBFieldNumber<>("zrntoukitumimasikinx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x11 = new ExDBFieldString<>("zrnyobiv9x11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx12 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx12", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx12 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux12 = new ExDBFieldString<>("zrntoukisisuux12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx12 = new ExDBFieldString<>("zrntoukisisuukijyunymdx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux12 = new ExDBFieldString<>("zrnzenkisisuux12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx12 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux12 = new ExDBFieldString<>("zrntmttknzoukaritux12", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx12 = new ExDBFieldNumber<>("zrntoukitumimasikinx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x12 = new ExDBFieldString<>("zrnyobiv9x12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx13 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx13", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx13 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux13 = new ExDBFieldString<>("zrntoukisisuux13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx13 = new ExDBFieldString<>("zrntoukisisuukijyunymdx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux13 = new ExDBFieldString<>("zrnzenkisisuux13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx13 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux13 = new ExDBFieldString<>("zrntmttknzoukaritux13", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx13 = new ExDBFieldNumber<>("zrntoukitumimasikinx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x13 = new ExDBFieldString<>("zrnyobiv9x13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx14 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx14", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx14 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux14 = new ExDBFieldString<>("zrntoukisisuux14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx14 = new ExDBFieldString<>("zrntoukisisuukijyunymdx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux14 = new ExDBFieldString<>("zrnzenkisisuux14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx14 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux14 = new ExDBFieldString<>("zrntmttknzoukaritux14", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx14 = new ExDBFieldNumber<>("zrntoukitumimasikinx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x14 = new ExDBFieldString<>("zrnyobiv9x14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx15 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx15", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnsisuubbntumitatekinx15 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntoukisisuux15 = new ExDBFieldString<>("zrntoukisisuux15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrntoukisisuukijyunymdx15 = new ExDBFieldString<>("zrntoukisisuukijyunymdx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrnzenkisisuux15 = new ExDBFieldString<>("zrnzenkisisuux15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnzenkisisuukijyunymdx15 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, BizNumber> zrntmttknzoukaritux15 = new ExDBFieldString<>("zrntmttknzoukaritux15", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrntoukitumimasikinx15 = new ExDBFieldNumber<>("zrntoukitumimasikinx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv9x15 = new ExDBFieldString<>("zrnyobiv9x15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymd = new ExDBFieldString<>("zrnteiritucalckijyunymd", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekin = new ExDBFieldNumber<>("zrnteiritutumitatekin", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16 = new ExDBFieldString<>("zrnyobiv16", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx2 = new ExDBFieldString<>("zrnteiritucalckijyunymdx2", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx2 = new ExDBFieldNumber<>("zrnteiritutumitatekinx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x2 = new ExDBFieldString<>("zrnyobiv16x2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx3 = new ExDBFieldString<>("zrnteiritucalckijyunymdx3", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx3 = new ExDBFieldNumber<>("zrnteiritutumitatekinx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x3 = new ExDBFieldString<>("zrnyobiv16x3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx4 = new ExDBFieldString<>("zrnteiritucalckijyunymdx4", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx4 = new ExDBFieldNumber<>("zrnteiritutumitatekinx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x4 = new ExDBFieldString<>("zrnyobiv16x4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx5 = new ExDBFieldString<>("zrnteiritucalckijyunymdx5", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx5 = new ExDBFieldNumber<>("zrnteiritutumitatekinx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x5 = new ExDBFieldString<>("zrnyobiv16x5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx6 = new ExDBFieldString<>("zrnteiritucalckijyunymdx6", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx6 = new ExDBFieldNumber<>("zrnteiritutumitatekinx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x6 = new ExDBFieldString<>("zrnyobiv16x6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx7 = new ExDBFieldString<>("zrnteiritucalckijyunymdx7", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx7 = new ExDBFieldNumber<>("zrnteiritutumitatekinx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x7 = new ExDBFieldString<>("zrnyobiv16x7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx8 = new ExDBFieldString<>("zrnteiritucalckijyunymdx8", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx8 = new ExDBFieldNumber<>("zrnteiritutumitatekinx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x8 = new ExDBFieldString<>("zrnyobiv16x8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx9 = new ExDBFieldString<>("zrnteiritucalckijyunymdx9", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx9 = new ExDBFieldNumber<>("zrnteiritutumitatekinx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x9 = new ExDBFieldString<>("zrnyobiv16x9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx10 = new ExDBFieldString<>("zrnteiritucalckijyunymdx10", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx10 = new ExDBFieldNumber<>("zrnteiritutumitatekinx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x10 = new ExDBFieldString<>("zrnyobiv16x10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx11 = new ExDBFieldString<>("zrnteiritucalckijyunymdx11", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx11 = new ExDBFieldNumber<>("zrnteiritutumitatekinx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x11 = new ExDBFieldString<>("zrnyobiv16x11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx12 = new ExDBFieldString<>("zrnteiritucalckijyunymdx12", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx12 = new ExDBFieldNumber<>("zrnteiritutumitatekinx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x12 = new ExDBFieldString<>("zrnyobiv16x12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx13 = new ExDBFieldString<>("zrnteiritucalckijyunymdx13", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx13 = new ExDBFieldNumber<>("zrnteiritutumitatekinx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x13 = new ExDBFieldString<>("zrnyobiv16x13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx14 = new ExDBFieldString<>("zrnteiritucalckijyunymdx14", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx14 = new ExDBFieldNumber<>("zrnteiritutumitatekinx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x14 = new ExDBFieldString<>("zrnyobiv16x14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnteiritucalckijyunymdx15 = new ExDBFieldString<>("zrnteiritucalckijyunymdx15", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnteiritutumitatekinx15 = new ExDBFieldNumber<>("zrnteiritutumitatekinx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv16x15 = new ExDBFieldString<>("zrnyobiv16x15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrngengakujicalckijyunymd = new ExDBFieldString<>("zrngengakujicalckijyunymd", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrngengakujisisuutmttkn = new ExDBFieldNumber<>("zrngengakujisisuutmttkn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrngengakujiteiritutmttkn = new ExDBFieldNumber<>("zrngengakujiteiritutmttkn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnsuuriyouyobin14 = new ExDBFieldString<>("zrnsuuriyouyobin14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);
}
