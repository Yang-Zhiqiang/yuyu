package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_RayVKnsyuyuTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＲＡＹＶ検証用Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_RayVKnsyuyuTy extends AbstractExDBTable<ZT_RayVKnsyuyuTy> {

    public GenQZT_RayVKnsyuyuTy() {
        this("ZT_RayVKnsyuyuTy");
    }

    public GenQZT_RayVKnsyuyuTy(String pAlias) {
        super("ZT_RayVKnsyuyuTy", ZT_RayVKnsyuyuTy.class, pAlias);
    }

    public String ZT_RayVKnsyuyuTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysrdai1hknkkn = new ExDBFieldString<>("ztysrdai1hknkkn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysuuriyouyobin4 = new ExDBFieldString<>("ztysuuriyouyobin4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytuukasyukbn = new ExDBFieldString<>("ztytuukasyukbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv11 = new ExDBFieldString<>("ztyyobiv11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysuuriyouyobin6x2 = new ExDBFieldString<>("ztysuuriyouyobin6x2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztykuriagekurisagekbn = new ExDBFieldString<>("ztykuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysuuriyouyobin6x3 = new ExDBFieldString<>("ztysuuriyouyobin6x3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztysrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("ztysrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztykimatukawaserate = new ExDBFieldString<>("ztykimatukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztykaiyakukoujyoritu = new ExDBFieldString<>("ztykaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysknnkaisiymd = new ExDBFieldString<>("ztysknnkaisiymd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysuuriyouyobin3 = new ExDBFieldString<>("ztysuuriyouyobin3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztymvatyouseigow = new ExDBFieldNumber<>("ztymvatyouseigow", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztymvakeisanjisknnjynbkn = new ExDBFieldNumber<>("ztymvakeisanjisknnjynbkn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztykmtsisuurentumitatekn = new ExDBFieldNumber<>("ztykmtsisuurentumitatekn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztykmttirttmtttumitatekn = new ExDBFieldNumber<>("ztykmttirttmtttumitatekn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztykmtsisuurentyokugotmttkn = new ExDBFieldNumber<>("ztykmtsisuurentyokugotmttkn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymd = new ExDBFieldString<>("ztysisuubbncalckijyunymd", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekin = new ExDBFieldNumber<>("ztysisuubbntumitatekin", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuu = new ExDBFieldString<>("ztytoukisisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymd = new ExDBFieldString<>("ztytoukisisuukijyunymd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuu = new ExDBFieldString<>("ztyzenkisisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymd = new ExDBFieldString<>("ztyzenkisisuukijyunymd", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritu = new ExDBFieldString<>("ztytmttknzoukaritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikin = new ExDBFieldNumber<>("ztytoukitumimasikin", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx2 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx2", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx2 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux2 = new ExDBFieldString<>("ztytoukisisuux2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx2 = new ExDBFieldString<>("ztytoukisisuukijyunymdx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux2 = new ExDBFieldString<>("ztyzenkisisuux2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx2 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux2 = new ExDBFieldString<>("ztytmttknzoukaritux2", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx2 = new ExDBFieldNumber<>("ztytoukitumimasikinx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x2 = new ExDBFieldString<>("ztyyobiv9x2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx3 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx3", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx3 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux3 = new ExDBFieldString<>("ztytoukisisuux3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx3 = new ExDBFieldString<>("ztytoukisisuukijyunymdx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux3 = new ExDBFieldString<>("ztyzenkisisuux3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx3 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux3 = new ExDBFieldString<>("ztytmttknzoukaritux3", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx3 = new ExDBFieldNumber<>("ztytoukitumimasikinx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x3 = new ExDBFieldString<>("ztyyobiv9x3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx4 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx4", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx4 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux4 = new ExDBFieldString<>("ztytoukisisuux4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx4 = new ExDBFieldString<>("ztytoukisisuukijyunymdx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux4 = new ExDBFieldString<>("ztyzenkisisuux4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx4 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux4 = new ExDBFieldString<>("ztytmttknzoukaritux4", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx4 = new ExDBFieldNumber<>("ztytoukitumimasikinx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x4 = new ExDBFieldString<>("ztyyobiv9x4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx5 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx5", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx5 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux5 = new ExDBFieldString<>("ztytoukisisuux5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx5 = new ExDBFieldString<>("ztytoukisisuukijyunymdx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux5 = new ExDBFieldString<>("ztyzenkisisuux5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx5 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux5 = new ExDBFieldString<>("ztytmttknzoukaritux5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx5 = new ExDBFieldNumber<>("ztytoukitumimasikinx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x5 = new ExDBFieldString<>("ztyyobiv9x5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx6 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx6", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx6 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux6 = new ExDBFieldString<>("ztytoukisisuux6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx6 = new ExDBFieldString<>("ztytoukisisuukijyunymdx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux6 = new ExDBFieldString<>("ztyzenkisisuux6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx6 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux6 = new ExDBFieldString<>("ztytmttknzoukaritux6", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx6 = new ExDBFieldNumber<>("ztytoukitumimasikinx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x6 = new ExDBFieldString<>("ztyyobiv9x6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx7 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx7", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx7 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux7 = new ExDBFieldString<>("ztytoukisisuux7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx7 = new ExDBFieldString<>("ztytoukisisuukijyunymdx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux7 = new ExDBFieldString<>("ztyzenkisisuux7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx7 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux7 = new ExDBFieldString<>("ztytmttknzoukaritux7", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx7 = new ExDBFieldNumber<>("ztytoukitumimasikinx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x7 = new ExDBFieldString<>("ztyyobiv9x7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx8 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx8", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx8 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux8 = new ExDBFieldString<>("ztytoukisisuux8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx8 = new ExDBFieldString<>("ztytoukisisuukijyunymdx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux8 = new ExDBFieldString<>("ztyzenkisisuux8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx8 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux8 = new ExDBFieldString<>("ztytmttknzoukaritux8", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx8 = new ExDBFieldNumber<>("ztytoukitumimasikinx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x8 = new ExDBFieldString<>("ztyyobiv9x8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx9 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx9", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx9 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux9 = new ExDBFieldString<>("ztytoukisisuux9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx9 = new ExDBFieldString<>("ztytoukisisuukijyunymdx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux9 = new ExDBFieldString<>("ztyzenkisisuux9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx9 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux9 = new ExDBFieldString<>("ztytmttknzoukaritux9", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx9 = new ExDBFieldNumber<>("ztytoukitumimasikinx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x9 = new ExDBFieldString<>("ztyyobiv9x9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx10 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx10", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx10 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux10 = new ExDBFieldString<>("ztytoukisisuux10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx10 = new ExDBFieldString<>("ztytoukisisuukijyunymdx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux10 = new ExDBFieldString<>("ztyzenkisisuux10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx10 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux10 = new ExDBFieldString<>("ztytmttknzoukaritux10", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx10 = new ExDBFieldNumber<>("ztytoukitumimasikinx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x10 = new ExDBFieldString<>("ztyyobiv9x10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx11 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx11", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx11 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux11 = new ExDBFieldString<>("ztytoukisisuux11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx11 = new ExDBFieldString<>("ztytoukisisuukijyunymdx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux11 = new ExDBFieldString<>("ztyzenkisisuux11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx11 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux11 = new ExDBFieldString<>("ztytmttknzoukaritux11", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx11 = new ExDBFieldNumber<>("ztytoukitumimasikinx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x11 = new ExDBFieldString<>("ztyyobiv9x11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx12 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx12", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx12 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux12 = new ExDBFieldString<>("ztytoukisisuux12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx12 = new ExDBFieldString<>("ztytoukisisuukijyunymdx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux12 = new ExDBFieldString<>("ztyzenkisisuux12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx12 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux12 = new ExDBFieldString<>("ztytmttknzoukaritux12", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx12 = new ExDBFieldNumber<>("ztytoukitumimasikinx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x12 = new ExDBFieldString<>("ztyyobiv9x12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx13 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx13", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx13 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux13 = new ExDBFieldString<>("ztytoukisisuux13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx13 = new ExDBFieldString<>("ztytoukisisuukijyunymdx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux13 = new ExDBFieldString<>("ztyzenkisisuux13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx13 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux13 = new ExDBFieldString<>("ztytmttknzoukaritux13", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx13 = new ExDBFieldNumber<>("ztytoukitumimasikinx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x13 = new ExDBFieldString<>("ztyyobiv9x13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx14 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx14", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx14 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux14 = new ExDBFieldString<>("ztytoukisisuux14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx14 = new ExDBFieldString<>("ztytoukisisuukijyunymdx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux14 = new ExDBFieldString<>("ztyzenkisisuux14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx14 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux14 = new ExDBFieldString<>("ztytmttknzoukaritux14", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx14 = new ExDBFieldNumber<>("ztytoukitumimasikinx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x14 = new ExDBFieldString<>("ztyyobiv9x14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysisuubbncalckijyunymdx15 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx15", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztysisuubbntumitatekinx15 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytoukisisuux15 = new ExDBFieldString<>("ztytoukisisuux15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztytoukisisuukijyunymdx15 = new ExDBFieldString<>("ztytoukisisuukijyunymdx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztyzenkisisuux15 = new ExDBFieldString<>("ztyzenkisisuux15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyzenkisisuukijyunymdx15 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, BizNumber> ztytmttknzoukaritux15 = new ExDBFieldString<>("ztytmttknzoukaritux15", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztytoukitumimasikinx15 = new ExDBFieldNumber<>("ztytoukitumimasikinx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv9x15 = new ExDBFieldString<>("ztyyobiv9x15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymd = new ExDBFieldString<>("ztyteiritucalckijyunymd", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekin = new ExDBFieldNumber<>("ztyteiritutumitatekin", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16 = new ExDBFieldString<>("ztyyobiv16", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx2 = new ExDBFieldString<>("ztyteiritucalckijyunymdx2", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx2 = new ExDBFieldNumber<>("ztyteiritutumitatekinx2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x2 = new ExDBFieldString<>("ztyyobiv16x2", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx3 = new ExDBFieldString<>("ztyteiritucalckijyunymdx3", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx3 = new ExDBFieldNumber<>("ztyteiritutumitatekinx3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x3 = new ExDBFieldString<>("ztyyobiv16x3", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx4 = new ExDBFieldString<>("ztyteiritucalckijyunymdx4", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx4 = new ExDBFieldNumber<>("ztyteiritutumitatekinx4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x4 = new ExDBFieldString<>("ztyyobiv16x4", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx5 = new ExDBFieldString<>("ztyteiritucalckijyunymdx5", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx5 = new ExDBFieldNumber<>("ztyteiritutumitatekinx5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x5 = new ExDBFieldString<>("ztyyobiv16x5", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx6 = new ExDBFieldString<>("ztyteiritucalckijyunymdx6", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx6 = new ExDBFieldNumber<>("ztyteiritutumitatekinx6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x6 = new ExDBFieldString<>("ztyyobiv16x6", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx7 = new ExDBFieldString<>("ztyteiritucalckijyunymdx7", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx7 = new ExDBFieldNumber<>("ztyteiritutumitatekinx7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x7 = new ExDBFieldString<>("ztyyobiv16x7", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx8 = new ExDBFieldString<>("ztyteiritucalckijyunymdx8", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx8 = new ExDBFieldNumber<>("ztyteiritutumitatekinx8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x8 = new ExDBFieldString<>("ztyyobiv16x8", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx9 = new ExDBFieldString<>("ztyteiritucalckijyunymdx9", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx9 = new ExDBFieldNumber<>("ztyteiritutumitatekinx9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x9 = new ExDBFieldString<>("ztyyobiv16x9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx10 = new ExDBFieldString<>("ztyteiritucalckijyunymdx10", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx10 = new ExDBFieldNumber<>("ztyteiritutumitatekinx10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x10 = new ExDBFieldString<>("ztyyobiv16x10", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx11 = new ExDBFieldString<>("ztyteiritucalckijyunymdx11", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx11 = new ExDBFieldNumber<>("ztyteiritutumitatekinx11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x11 = new ExDBFieldString<>("ztyyobiv16x11", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx12 = new ExDBFieldString<>("ztyteiritucalckijyunymdx12", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx12 = new ExDBFieldNumber<>("ztyteiritutumitatekinx12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x12 = new ExDBFieldString<>("ztyyobiv16x12", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx13 = new ExDBFieldString<>("ztyteiritucalckijyunymdx13", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx13 = new ExDBFieldNumber<>("ztyteiritutumitatekinx13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x13 = new ExDBFieldString<>("ztyyobiv16x13", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx14 = new ExDBFieldString<>("ztyteiritucalckijyunymdx14", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx14 = new ExDBFieldNumber<>("ztyteiritutumitatekinx14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x14 = new ExDBFieldString<>("ztyyobiv16x14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyteiritucalckijyunymdx15 = new ExDBFieldString<>("ztyteiritucalckijyunymdx15", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyteiritutumitatekinx15 = new ExDBFieldNumber<>("ztyteiritutumitatekinx15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv16x15 = new ExDBFieldString<>("ztyyobiv16x15", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztygengakujicalckijyunymd = new ExDBFieldString<>("ztygengakujicalckijyunymd", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztygengakujisisuutmttkn = new ExDBFieldNumber<>("ztygengakujisisuutmttkn", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztygengakujiteiritutmttkn = new ExDBFieldNumber<>("ztygengakujiteiritutmttkn", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_RayVKnsyuyuTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztysuuriyouyobin14 = new ExDBFieldString<>("ztysuuriyouyobin14", this);

    public final ExDBFieldString<ZT_RayVKnsyuyuTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);
}
