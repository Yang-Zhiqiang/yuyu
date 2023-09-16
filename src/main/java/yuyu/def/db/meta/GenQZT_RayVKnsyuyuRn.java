package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_RayVKnsyuyuRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＲＡＹＶ検証用Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RayVKnsyuyuRn extends AbstractExDBTable<ZT_RayVKnsyuyuRn> {

    public GenQZT_RayVKnsyuyuRn() {
        this("ZT_RayVKnsyuyuRn");
    }

    public GenQZT_RayVKnsyuyuRn(String pAlias) {
        super("ZT_RayVKnsyuyuRn", ZT_RayVKnsyuyuRn.class, pAlias);
    }

    public String ZT_RayVKnsyuyuRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Integer> zrnyuukourecordlength = new ExDBFieldNumber<>("zrnyuukourecordlength", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnrdwarea = new ExDBFieldString<>("zrnrdwarea", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnkeijyouym = new ExDBFieldString<>("zrnkeijyouym", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnraysystemhyj = new ExDBFieldString<>("zrnraysystemhyj", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrndatakanrino = new ExDBFieldString<>("zrndatakanrino", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsotodasimanagehyouji = new ExDBFieldString<>("zrnsotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsrdai1hknkkn = new ExDBFieldString<>("zrnsrdai1hknkkn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsuuriyouyobin4 = new ExDBFieldString<>("zrnsuuriyouyobin4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntuukasyukbn = new ExDBFieldString<>("zrntuukasyukbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv11 = new ExDBFieldString<>("zrnyobiv11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnkbnkeiriyousegmentkbn = new ExDBFieldString<>("zrnkbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnkbnkeiriyourgnbnskkbn = new ExDBFieldString<>("zrnkbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsuurisyuruicd = new ExDBFieldString<>("zrnsuurisyuruicd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsuuriyouyobin6x2 = new ExDBFieldString<>("zrnsuuriyouyobin6x2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv8 = new ExDBFieldString<>("zrnyobiv8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnhihokensyaagev2 = new ExDBFieldString<>("zrnhihokensyaagev2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnkuriagekurisagekbn = new ExDBFieldString<>("zrnkuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsuuriyouyobin6x3 = new ExDBFieldString<>("zrnsuuriyouyobin6x3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv8x2 = new ExDBFieldString<>("zrnyobiv8x2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnkeiyakujiyoteiriritu = new ExDBFieldString<>("zrnkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnsrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("zrnsrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnsrkyksjkkktyouseiriritu = new ExDBFieldString<>("zrnsrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnmvatyouseikou = new ExDBFieldString<>("zrnmvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuurendourate = new ExDBFieldString<>("zrnsisuurendourate", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuukbn = new ExDBFieldString<>("zrnsisuukbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrngaikakbn = new ExDBFieldString<>("zrngaikakbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnkimatukawaserate = new ExDBFieldString<>("zrnkimatukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnkaiyakukoujyoritu = new ExDBFieldString<>("zrnkaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsknnkaisiymd = new ExDBFieldString<>("zrnsknnkaisiymd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnrendouritu = new ExDBFieldString<>("zrnrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsuuriyouyobin3 = new ExDBFieldString<>("zrnsuuriyouyobin3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnmvatyouseigow = new ExDBFieldNumber<>("zrnmvatyouseigow", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnmvakeisanjisknnjynbkn = new ExDBFieldNumber<>("zrnmvakeisanjisknnjynbkn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnkmtsisuurentumitatekn = new ExDBFieldNumber<>("zrnkmtsisuurentumitatekn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnkmttirttmtttumitatekn = new ExDBFieldNumber<>("zrnkmttirttmtttumitatekn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnkmtsisuurentyokugotmttkn = new ExDBFieldNumber<>("zrnkmtsisuurentyokugotmttkn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymd = new ExDBFieldString<>("zrnsisuubbncalckijyunymd", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekin = new ExDBFieldNumber<>("zrnsisuubbntumitatekin", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuu = new ExDBFieldString<>("zrntoukisisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymd = new ExDBFieldString<>("zrntoukisisuukijyunymd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuu = new ExDBFieldString<>("zrnzenkisisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymd = new ExDBFieldString<>("zrnzenkisisuukijyunymd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritu = new ExDBFieldString<>("zrntmttknzoukaritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikin = new ExDBFieldNumber<>("zrntoukitumimasikin", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9 = new ExDBFieldString<>("zrnyobiv9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx2 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx2", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx2 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux2 = new ExDBFieldString<>("zrntoukisisuux2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx2 = new ExDBFieldString<>("zrntoukisisuukijyunymdx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux2 = new ExDBFieldString<>("zrnzenkisisuux2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx2 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux2 = new ExDBFieldString<>("zrntmttknzoukaritux2", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx2 = new ExDBFieldNumber<>("zrntoukitumimasikinx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x2 = new ExDBFieldString<>("zrnyobiv9x2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx3 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx3", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx3 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux3 = new ExDBFieldString<>("zrntoukisisuux3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx3 = new ExDBFieldString<>("zrntoukisisuukijyunymdx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux3 = new ExDBFieldString<>("zrnzenkisisuux3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx3 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux3 = new ExDBFieldString<>("zrntmttknzoukaritux3", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx3 = new ExDBFieldNumber<>("zrntoukitumimasikinx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x3 = new ExDBFieldString<>("zrnyobiv9x3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx4 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx4", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx4 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux4 = new ExDBFieldString<>("zrntoukisisuux4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx4 = new ExDBFieldString<>("zrntoukisisuukijyunymdx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux4 = new ExDBFieldString<>("zrnzenkisisuux4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx4 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux4 = new ExDBFieldString<>("zrntmttknzoukaritux4", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx4 = new ExDBFieldNumber<>("zrntoukitumimasikinx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x4 = new ExDBFieldString<>("zrnyobiv9x4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx5 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx5", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx5 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux5 = new ExDBFieldString<>("zrntoukisisuux5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx5 = new ExDBFieldString<>("zrntoukisisuukijyunymdx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux5 = new ExDBFieldString<>("zrnzenkisisuux5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx5 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux5 = new ExDBFieldString<>("zrntmttknzoukaritux5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx5 = new ExDBFieldNumber<>("zrntoukitumimasikinx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x5 = new ExDBFieldString<>("zrnyobiv9x5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx6 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx6", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx6 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux6 = new ExDBFieldString<>("zrntoukisisuux6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx6 = new ExDBFieldString<>("zrntoukisisuukijyunymdx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux6 = new ExDBFieldString<>("zrnzenkisisuux6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx6 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux6 = new ExDBFieldString<>("zrntmttknzoukaritux6", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx6 = new ExDBFieldNumber<>("zrntoukitumimasikinx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x6 = new ExDBFieldString<>("zrnyobiv9x6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx7 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx7", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx7 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux7 = new ExDBFieldString<>("zrntoukisisuux7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx7 = new ExDBFieldString<>("zrntoukisisuukijyunymdx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux7 = new ExDBFieldString<>("zrnzenkisisuux7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx7 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux7 = new ExDBFieldString<>("zrntmttknzoukaritux7", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx7 = new ExDBFieldNumber<>("zrntoukitumimasikinx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x7 = new ExDBFieldString<>("zrnyobiv9x7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx8 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx8", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx8 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux8 = new ExDBFieldString<>("zrntoukisisuux8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx8 = new ExDBFieldString<>("zrntoukisisuukijyunymdx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux8 = new ExDBFieldString<>("zrnzenkisisuux8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx8 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux8 = new ExDBFieldString<>("zrntmttknzoukaritux8", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx8 = new ExDBFieldNumber<>("zrntoukitumimasikinx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x8 = new ExDBFieldString<>("zrnyobiv9x8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx9 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx9", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx9 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux9 = new ExDBFieldString<>("zrntoukisisuux9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx9 = new ExDBFieldString<>("zrntoukisisuukijyunymdx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux9 = new ExDBFieldString<>("zrnzenkisisuux9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx9 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux9 = new ExDBFieldString<>("zrntmttknzoukaritux9", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx9 = new ExDBFieldNumber<>("zrntoukitumimasikinx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x9 = new ExDBFieldString<>("zrnyobiv9x9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx10 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx10", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx10 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux10 = new ExDBFieldString<>("zrntoukisisuux10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx10 = new ExDBFieldString<>("zrntoukisisuukijyunymdx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux10 = new ExDBFieldString<>("zrnzenkisisuux10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx10 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux10 = new ExDBFieldString<>("zrntmttknzoukaritux10", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx10 = new ExDBFieldNumber<>("zrntoukitumimasikinx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x10 = new ExDBFieldString<>("zrnyobiv9x10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx11 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx11", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx11 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux11 = new ExDBFieldString<>("zrntoukisisuux11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx11 = new ExDBFieldString<>("zrntoukisisuukijyunymdx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux11 = new ExDBFieldString<>("zrnzenkisisuux11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx11 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux11 = new ExDBFieldString<>("zrntmttknzoukaritux11", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx11 = new ExDBFieldNumber<>("zrntoukitumimasikinx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x11 = new ExDBFieldString<>("zrnyobiv9x11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx12 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx12", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx12 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux12 = new ExDBFieldString<>("zrntoukisisuux12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx12 = new ExDBFieldString<>("zrntoukisisuukijyunymdx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux12 = new ExDBFieldString<>("zrnzenkisisuux12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx12 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux12 = new ExDBFieldString<>("zrntmttknzoukaritux12", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx12 = new ExDBFieldNumber<>("zrntoukitumimasikinx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x12 = new ExDBFieldString<>("zrnyobiv9x12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx13 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx13", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx13 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux13 = new ExDBFieldString<>("zrntoukisisuux13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx13 = new ExDBFieldString<>("zrntoukisisuukijyunymdx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux13 = new ExDBFieldString<>("zrnzenkisisuux13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx13 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux13 = new ExDBFieldString<>("zrntmttknzoukaritux13", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx13 = new ExDBFieldNumber<>("zrntoukitumimasikinx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x13 = new ExDBFieldString<>("zrnyobiv9x13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx14 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx14", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx14 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux14 = new ExDBFieldString<>("zrntoukisisuux14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx14 = new ExDBFieldString<>("zrntoukisisuukijyunymdx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux14 = new ExDBFieldString<>("zrnzenkisisuux14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx14 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux14 = new ExDBFieldString<>("zrntmttknzoukaritux14", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx14 = new ExDBFieldNumber<>("zrntoukitumimasikinx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x14 = new ExDBFieldString<>("zrnyobiv9x14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsisuubbncalckijyunymdx15 = new ExDBFieldString<>("zrnsisuubbncalckijyunymdx15", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnsisuubbntumitatekinx15 = new ExDBFieldNumber<>("zrnsisuubbntumitatekinx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntoukisisuux15 = new ExDBFieldString<>("zrntoukisisuux15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrntoukisisuukijyunymdx15 = new ExDBFieldString<>("zrntoukisisuukijyunymdx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrnzenkisisuux15 = new ExDBFieldString<>("zrnzenkisisuux15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnzenkisisuukijyunymdx15 = new ExDBFieldString<>("zrnzenkisisuukijyunymdx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, BizNumber> zrntmttknzoukaritux15 = new ExDBFieldString<>("zrntmttknzoukaritux15", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrntoukitumimasikinx15 = new ExDBFieldNumber<>("zrntoukitumimasikinx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv9x15 = new ExDBFieldString<>("zrnyobiv9x15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymd = new ExDBFieldString<>("zrnteiritucalckijyunymd", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekin = new ExDBFieldNumber<>("zrnteiritutumitatekin", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16 = new ExDBFieldString<>("zrnyobiv16", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx2 = new ExDBFieldString<>("zrnteiritucalckijyunymdx2", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx2 = new ExDBFieldNumber<>("zrnteiritutumitatekinx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x2 = new ExDBFieldString<>("zrnyobiv16x2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx3 = new ExDBFieldString<>("zrnteiritucalckijyunymdx3", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx3 = new ExDBFieldNumber<>("zrnteiritutumitatekinx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x3 = new ExDBFieldString<>("zrnyobiv16x3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx4 = new ExDBFieldString<>("zrnteiritucalckijyunymdx4", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx4 = new ExDBFieldNumber<>("zrnteiritutumitatekinx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x4 = new ExDBFieldString<>("zrnyobiv16x4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx5 = new ExDBFieldString<>("zrnteiritucalckijyunymdx5", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx5 = new ExDBFieldNumber<>("zrnteiritutumitatekinx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x5 = new ExDBFieldString<>("zrnyobiv16x5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx6 = new ExDBFieldString<>("zrnteiritucalckijyunymdx6", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx6 = new ExDBFieldNumber<>("zrnteiritutumitatekinx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x6 = new ExDBFieldString<>("zrnyobiv16x6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx7 = new ExDBFieldString<>("zrnteiritucalckijyunymdx7", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx7 = new ExDBFieldNumber<>("zrnteiritutumitatekinx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x7 = new ExDBFieldString<>("zrnyobiv16x7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx8 = new ExDBFieldString<>("zrnteiritucalckijyunymdx8", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx8 = new ExDBFieldNumber<>("zrnteiritutumitatekinx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x8 = new ExDBFieldString<>("zrnyobiv16x8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx9 = new ExDBFieldString<>("zrnteiritucalckijyunymdx9", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx9 = new ExDBFieldNumber<>("zrnteiritutumitatekinx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x9 = new ExDBFieldString<>("zrnyobiv16x9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx10 = new ExDBFieldString<>("zrnteiritucalckijyunymdx10", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx10 = new ExDBFieldNumber<>("zrnteiritutumitatekinx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x10 = new ExDBFieldString<>("zrnyobiv16x10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx11 = new ExDBFieldString<>("zrnteiritucalckijyunymdx11", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx11 = new ExDBFieldNumber<>("zrnteiritutumitatekinx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x11 = new ExDBFieldString<>("zrnyobiv16x11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx12 = new ExDBFieldString<>("zrnteiritucalckijyunymdx12", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx12 = new ExDBFieldNumber<>("zrnteiritutumitatekinx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x12 = new ExDBFieldString<>("zrnyobiv16x12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx13 = new ExDBFieldString<>("zrnteiritucalckijyunymdx13", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx13 = new ExDBFieldNumber<>("zrnteiritutumitatekinx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x13 = new ExDBFieldString<>("zrnyobiv16x13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx14 = new ExDBFieldString<>("zrnteiritucalckijyunymdx14", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx14 = new ExDBFieldNumber<>("zrnteiritutumitatekinx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x14 = new ExDBFieldString<>("zrnyobiv16x14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnteiritucalckijyunymdx15 = new ExDBFieldString<>("zrnteiritucalckijyunymdx15", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnteiritutumitatekinx15 = new ExDBFieldNumber<>("zrnteiritutumitatekinx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv16x15 = new ExDBFieldString<>("zrnyobiv16x15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrngengakujicalckijyunymd = new ExDBFieldString<>("zrngengakujicalckijyunymd", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrngengakujisisuutmttkn = new ExDBFieldNumber<>("zrngengakujisisuutmttkn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrngengakujiteiritutmttkn = new ExDBFieldNumber<>("zrngengakujiteiritutmttkn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv10 = new ExDBFieldString<>("zrnyobiv10", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuRn, Long> zrnyobin11x9 = new ExDBFieldNumber<>("zrnyobin11x9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnsuuriyouyobin14 = new ExDBFieldString<>("zrnsuuriyouyobin14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);
}
