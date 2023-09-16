package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 株価指数連動保険Ｖ検証用Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SrKbkSsuRnduHknVKnsyuyuTy extends AbstractExDBTable<ZT_SrKbkSsuRnduHknVKnsyuyuTy> {

    public GenQZT_SrKbkSsuRnduHknVKnsyuyuTy() {
        this("ZT_SrKbkSsuRnduHknVKnsyuyuTy");
    }

    public GenQZT_SrKbkSsuRnduHknVKnsyuyuTy(String pAlias) {
        super("ZT_SrKbkSsuRnduHknVKnsyuyuTy", ZT_SrKbkSsuRnduHknVKnsyuyuTy.class, pAlias);
    }

    public String ZT_SrKbkSsuRnduHknVKnsyuyuTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Integer> ztyyuukourecordlength = new ExDBFieldNumber<>("ztyyuukourecordlength", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyrdwarea = new ExDBFieldString<>("ztyrdwarea", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztykeijyouym = new ExDBFieldString<>("ztykeijyouym", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyraysystemhyj = new ExDBFieldString<>("ztyraysystemhyj", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysotodasipmenkbn = new ExDBFieldString<>("ztysotodasipmenkbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysotodasimanagehyouji = new ExDBFieldString<>("ztysotodasimanagehyouji", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysuuriyouyobin6 = new ExDBFieldString<>("ztysuuriyouyobin6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv12 = new ExDBFieldString<>("ztyyobiv12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztykbnkeiriyousegmentkbn = new ExDBFieldString<>("ztykbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztykbnkeiriyourgnbnskkbn = new ExDBFieldString<>("ztykbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysuurisyuruicd = new ExDBFieldString<>("ztysuurisyuruicd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysuuriyouyobin6x2 = new ExDBFieldString<>("ztysuuriyouyobin6x2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv8 = new ExDBFieldString<>("ztyyobiv8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyhihokensyaagev2 = new ExDBFieldString<>("ztyhihokensyaagev2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztykuriagekurisagekbn = new ExDBFieldString<>("ztykuriagekurisagekbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysuuriyouyobin6x3 = new ExDBFieldString<>("ztysuuriyouyobin6x3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv8x2 = new ExDBFieldString<>("ztyyobiv8x2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztykeiyakujiyoteiriritu = new ExDBFieldString<>("ztykeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztysrkaiyakusjkkktyouseirrt = new ExDBFieldString<>("ztysrkaiyakusjkkktyouseirrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztysrkyksjkkktyouseiriritu = new ExDBFieldString<>("ztysrkyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztymvatyouseikou = new ExDBFieldString<>("ztymvatyouseikou", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuurendourate = new ExDBFieldString<>("ztysisuurendourate", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuukbn = new ExDBFieldString<>("ztysisuukbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztygaikakbn = new ExDBFieldString<>("ztygaikakbn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztykimatukawaserate = new ExDBFieldString<>("ztykimatukawaserate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztykaiyakukoujyoritu = new ExDBFieldString<>("ztykaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysknnkaisiymd = new ExDBFieldString<>("ztysknnkaisiymd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysuuriyouyobin3 = new ExDBFieldString<>("ztysuuriyouyobin3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztymvatyouseigow = new ExDBFieldNumber<>("ztymvatyouseigow", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztymvakeisanjisknnjynbkn = new ExDBFieldNumber<>("ztymvakeisanjisknnjynbkn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztykmtsisuurentumitatekn = new ExDBFieldNumber<>("ztykmtsisuurentumitatekn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztykmttirttmtttumitatekn = new ExDBFieldNumber<>("ztykmttirttmtttumitatekn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztykmtsisuurentyokugotmttkn = new ExDBFieldNumber<>("ztykmtsisuurentyokugotmttkn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymd = new ExDBFieldString<>("ztysisuubbncalckijyunymd", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekin = new ExDBFieldNumber<>("ztysisuubbntumitatekin", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuu = new ExDBFieldString<>("ztytoukisisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymd = new ExDBFieldString<>("ztytoukisisuukijyunymd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuu = new ExDBFieldString<>("ztyzenkisisuu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymd = new ExDBFieldString<>("ztyzenkisisuukijyunymd", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritu = new ExDBFieldString<>("ztytmttknzoukaritu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikin = new ExDBFieldNumber<>("ztytoukitumimasikin", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9 = new ExDBFieldString<>("ztyyobiv9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx2 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx2", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx2 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux2 = new ExDBFieldString<>("ztytoukisisuux2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx2 = new ExDBFieldString<>("ztytoukisisuukijyunymdx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux2 = new ExDBFieldString<>("ztyzenkisisuux2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx2 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux2 = new ExDBFieldString<>("ztytmttknzoukaritux2", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx2 = new ExDBFieldNumber<>("ztytoukitumimasikinx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x2 = new ExDBFieldString<>("ztyyobiv9x2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx3 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx3", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx3 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux3 = new ExDBFieldString<>("ztytoukisisuux3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx3 = new ExDBFieldString<>("ztytoukisisuukijyunymdx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux3 = new ExDBFieldString<>("ztyzenkisisuux3", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx3 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux3 = new ExDBFieldString<>("ztytmttknzoukaritux3", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx3 = new ExDBFieldNumber<>("ztytoukitumimasikinx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x3 = new ExDBFieldString<>("ztyyobiv9x3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx4 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx4", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx4 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux4 = new ExDBFieldString<>("ztytoukisisuux4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx4 = new ExDBFieldString<>("ztytoukisisuukijyunymdx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux4 = new ExDBFieldString<>("ztyzenkisisuux4", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx4 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux4 = new ExDBFieldString<>("ztytmttknzoukaritux4", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx4 = new ExDBFieldNumber<>("ztytoukitumimasikinx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x4 = new ExDBFieldString<>("ztyyobiv9x4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx5 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx5", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx5 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux5 = new ExDBFieldString<>("ztytoukisisuux5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx5 = new ExDBFieldString<>("ztytoukisisuukijyunymdx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux5 = new ExDBFieldString<>("ztyzenkisisuux5", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx5 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux5 = new ExDBFieldString<>("ztytmttknzoukaritux5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx5 = new ExDBFieldNumber<>("ztytoukitumimasikinx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x5 = new ExDBFieldString<>("ztyyobiv9x5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx6 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx6", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx6 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux6 = new ExDBFieldString<>("ztytoukisisuux6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx6 = new ExDBFieldString<>("ztytoukisisuukijyunymdx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux6 = new ExDBFieldString<>("ztyzenkisisuux6", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx6 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux6 = new ExDBFieldString<>("ztytmttknzoukaritux6", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx6 = new ExDBFieldNumber<>("ztytoukitumimasikinx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x6 = new ExDBFieldString<>("ztyyobiv9x6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx7 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx7", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx7 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux7 = new ExDBFieldString<>("ztytoukisisuux7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx7 = new ExDBFieldString<>("ztytoukisisuukijyunymdx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux7 = new ExDBFieldString<>("ztyzenkisisuux7", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx7 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux7 = new ExDBFieldString<>("ztytmttknzoukaritux7", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx7 = new ExDBFieldNumber<>("ztytoukitumimasikinx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x7 = new ExDBFieldString<>("ztyyobiv9x7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx8 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx8", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx8 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux8 = new ExDBFieldString<>("ztytoukisisuux8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx8 = new ExDBFieldString<>("ztytoukisisuukijyunymdx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux8 = new ExDBFieldString<>("ztyzenkisisuux8", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx8 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux8 = new ExDBFieldString<>("ztytmttknzoukaritux8", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx8 = new ExDBFieldNumber<>("ztytoukitumimasikinx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x8 = new ExDBFieldString<>("ztyyobiv9x8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx9 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx9", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx9 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux9 = new ExDBFieldString<>("ztytoukisisuux9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx9 = new ExDBFieldString<>("ztytoukisisuukijyunymdx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux9 = new ExDBFieldString<>("ztyzenkisisuux9", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx9 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux9 = new ExDBFieldString<>("ztytmttknzoukaritux9", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx9 = new ExDBFieldNumber<>("ztytoukitumimasikinx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x9 = new ExDBFieldString<>("ztyyobiv9x9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx10 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx10", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx10 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux10 = new ExDBFieldString<>("ztytoukisisuux10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx10 = new ExDBFieldString<>("ztytoukisisuukijyunymdx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux10 = new ExDBFieldString<>("ztyzenkisisuux10", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx10 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux10 = new ExDBFieldString<>("ztytmttknzoukaritux10", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx10 = new ExDBFieldNumber<>("ztytoukitumimasikinx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x10 = new ExDBFieldString<>("ztyyobiv9x10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx11 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx11", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx11 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux11 = new ExDBFieldString<>("ztytoukisisuux11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx11 = new ExDBFieldString<>("ztytoukisisuukijyunymdx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux11 = new ExDBFieldString<>("ztyzenkisisuux11", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx11 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux11 = new ExDBFieldString<>("ztytmttknzoukaritux11", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx11 = new ExDBFieldNumber<>("ztytoukitumimasikinx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x11 = new ExDBFieldString<>("ztyyobiv9x11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx12 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx12", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx12 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux12 = new ExDBFieldString<>("ztytoukisisuux12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx12 = new ExDBFieldString<>("ztytoukisisuukijyunymdx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux12 = new ExDBFieldString<>("ztyzenkisisuux12", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx12 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux12 = new ExDBFieldString<>("ztytmttknzoukaritux12", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx12 = new ExDBFieldNumber<>("ztytoukitumimasikinx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x12 = new ExDBFieldString<>("ztyyobiv9x12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx13 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx13", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx13 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux13 = new ExDBFieldString<>("ztytoukisisuux13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx13 = new ExDBFieldString<>("ztytoukisisuukijyunymdx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux13 = new ExDBFieldString<>("ztyzenkisisuux13", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx13 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux13 = new ExDBFieldString<>("ztytmttknzoukaritux13", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx13 = new ExDBFieldNumber<>("ztytoukitumimasikinx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x13 = new ExDBFieldString<>("ztyyobiv9x13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx14 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx14", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx14 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux14 = new ExDBFieldString<>("ztytoukisisuux14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx14 = new ExDBFieldString<>("ztytoukisisuukijyunymdx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux14 = new ExDBFieldString<>("ztyzenkisisuux14", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx14 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux14 = new ExDBFieldString<>("ztytmttknzoukaritux14", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx14 = new ExDBFieldNumber<>("ztytoukitumimasikinx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x14 = new ExDBFieldString<>("ztyyobiv9x14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysisuubbncalckijyunymdx15 = new ExDBFieldString<>("ztysisuubbncalckijyunymdx15", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztysisuubbntumitatekinx15 = new ExDBFieldNumber<>("ztysisuubbntumitatekinx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytoukisisuux15 = new ExDBFieldString<>("ztytoukisisuux15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztytoukisisuukijyunymdx15 = new ExDBFieldString<>("ztytoukisisuukijyunymdx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztyzenkisisuux15 = new ExDBFieldString<>("ztyzenkisisuux15", this, BizNumberType.class);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyzenkisisuukijyunymdx15 = new ExDBFieldString<>("ztyzenkisisuukijyunymdx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, BizNumber> ztytmttknzoukaritux15 = new ExDBFieldString<>("ztytmttknzoukaritux15", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztytoukitumimasikinx15 = new ExDBFieldNumber<>("ztytoukitumimasikinx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv9x15 = new ExDBFieldString<>("ztyyobiv9x15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymd = new ExDBFieldString<>("ztyteiritucalckijyunymd", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekin = new ExDBFieldNumber<>("ztyteiritutumitatekin", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16 = new ExDBFieldString<>("ztyyobiv16", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx2 = new ExDBFieldString<>("ztyteiritucalckijyunymdx2", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx2 = new ExDBFieldNumber<>("ztyteiritutumitatekinx2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x2 = new ExDBFieldString<>("ztyyobiv16x2", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx3 = new ExDBFieldString<>("ztyteiritucalckijyunymdx3", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx3 = new ExDBFieldNumber<>("ztyteiritutumitatekinx3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x3 = new ExDBFieldString<>("ztyyobiv16x3", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx4 = new ExDBFieldString<>("ztyteiritucalckijyunymdx4", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx4 = new ExDBFieldNumber<>("ztyteiritutumitatekinx4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x4 = new ExDBFieldString<>("ztyyobiv16x4", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx5 = new ExDBFieldString<>("ztyteiritucalckijyunymdx5", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx5 = new ExDBFieldNumber<>("ztyteiritutumitatekinx5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x5 = new ExDBFieldString<>("ztyyobiv16x5", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx6 = new ExDBFieldString<>("ztyteiritucalckijyunymdx6", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx6 = new ExDBFieldNumber<>("ztyteiritutumitatekinx6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x6 = new ExDBFieldString<>("ztyyobiv16x6", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx7 = new ExDBFieldString<>("ztyteiritucalckijyunymdx7", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx7 = new ExDBFieldNumber<>("ztyteiritutumitatekinx7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x7 = new ExDBFieldString<>("ztyyobiv16x7", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx8 = new ExDBFieldString<>("ztyteiritucalckijyunymdx8", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx8 = new ExDBFieldNumber<>("ztyteiritutumitatekinx8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x8 = new ExDBFieldString<>("ztyyobiv16x8", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx9 = new ExDBFieldString<>("ztyteiritucalckijyunymdx9", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx9 = new ExDBFieldNumber<>("ztyteiritutumitatekinx9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x9 = new ExDBFieldString<>("ztyyobiv16x9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx10 = new ExDBFieldString<>("ztyteiritucalckijyunymdx10", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx10 = new ExDBFieldNumber<>("ztyteiritutumitatekinx10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x10 = new ExDBFieldString<>("ztyyobiv16x10", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx11 = new ExDBFieldString<>("ztyteiritucalckijyunymdx11", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx11 = new ExDBFieldNumber<>("ztyteiritutumitatekinx11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x11 = new ExDBFieldString<>("ztyyobiv16x11", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx12 = new ExDBFieldString<>("ztyteiritucalckijyunymdx12", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx12 = new ExDBFieldNumber<>("ztyteiritutumitatekinx12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x12 = new ExDBFieldString<>("ztyyobiv16x12", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx13 = new ExDBFieldString<>("ztyteiritucalckijyunymdx13", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx13 = new ExDBFieldNumber<>("ztyteiritutumitatekinx13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x13 = new ExDBFieldString<>("ztyyobiv16x13", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx14 = new ExDBFieldString<>("ztyteiritucalckijyunymdx14", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx14 = new ExDBFieldNumber<>("ztyteiritutumitatekinx14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x14 = new ExDBFieldString<>("ztyyobiv16x14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyteiritucalckijyunymdx15 = new ExDBFieldString<>("ztyteiritucalckijyunymdx15", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyteiritutumitatekinx15 = new ExDBFieldNumber<>("ztyteiritutumitatekinx15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv16x15 = new ExDBFieldString<>("ztyyobiv16x15", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztygengakujicalckijyunymd = new ExDBFieldString<>("ztygengakujicalckijyunymd", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztygengakujisisuutmttkn = new ExDBFieldNumber<>("ztygengakujisisuutmttkn", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztygengakujiteiritutmttkn = new ExDBFieldNumber<>("ztygengakujiteiritutmttkn", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv10 = new ExDBFieldString<>("ztyyobiv10", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldNumber<ZT_SrKbkSsuRnduHknVKnsyuyuTy, Long> ztyyobin11x9 = new ExDBFieldNumber<>("ztyyobin11x9", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztysuuriyouyobin14 = new ExDBFieldString<>("ztysuuriyouyobin14", this);

    public final ExDBFieldString<ZT_SrKbkSsuRnduHknVKnsyuyuTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);
}
