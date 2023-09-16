package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoRn;

/**
 * 医事統計異動情報テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_IjiToukeiIdouInfoRn extends AbstractExDBTable<ZT_IjiToukeiIdouInfoRn> {

    public GenQZT_IjiToukeiIdouInfoRn() {
        this("ZT_IjiToukeiIdouInfoRn");
    }

    public GenQZT_IjiToukeiIdouInfoRn(String pAlias) {
        super("ZT_IjiToukeiIdouInfoRn", ZT_IjiToukeiIdouInfoRn.class, pAlias);
    }

    public String ZT_IjiToukeiIdouInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyoriymd = new ExDBFieldString<>("zrnsyoriymd", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoRn, Integer> zrnkykmfksnctr = new ExDBFieldNumber<>("zrnkykmfksnctr", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyukgu = new ExDBFieldString<>("zrnsyukgu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnkykym = new ExDBFieldString<>("zrnkykym", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoRn, Integer> zrnkisnkihons = new ExDBFieldNumber<>("zrnkisnkihons", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoRn, Integer> zrnimustiyusbus = new ExDBFieldNumber<>("zrnimustiyusbus", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoRn, Integer> zrnshrs = new ExDBFieldNumber<>("zrnshrs", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnshrymd = new ExDBFieldString<>("zrnshrymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsymtgenincd = new ExDBFieldString<>("zrnsymtgenincd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnkeikaym = new ExDBFieldString<>("zrnkeikaym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsbugenincd = new ExDBFieldString<>("zrnsbugenincd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrndai2hhknnen = new ExDBFieldString<>("zrndai2hhknnen", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnmannenreihyj = new ExDBFieldString<>("zrnmannenreihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrntignmrtisyukgu = new ExDBFieldString<>("zrntignmrtisyukgu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnhhknnentysihyj = new ExDBFieldString<>("zrnhhknnentysihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrndai2hhknnentysihyj = new ExDBFieldString<>("zrndai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnrenseimrtisyukgu = new ExDBFieldString<>("zrnrenseimrtisyukgu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnbnktjitiktkarihyj = new ExDBFieldString<>("zrnbnktjitiktkarihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnlivingneedsshrarihyj = new ExDBFieldString<>("zrnlivingneedsshrarihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnlnkeikaym = new ExDBFieldString<>("zrnlnkeikaym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnlnshrgenincd = new ExDBFieldString<>("zrnlnshrgenincd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnkituenkbn = new ExDBFieldString<>("zrnkituenkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnkituenhonsuu = new ExDBFieldString<>("zrnkituenhonsuu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrngnspshrhyj = new ExDBFieldString<>("zrngnspshrhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrngnspshrkeikaym = new ExDBFieldString<>("zrngnspshrkeikaym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrngnspshrgenincd = new ExDBFieldString<>("zrngnspshrgenincd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyunyumrtisyukgu = new ExDBFieldString<>("zrnsyunyumrtisyukgu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsysnymd = new ExDBFieldString<>("zrnsysnymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsindanymd = new ExDBFieldString<>("zrnsindanymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnbyoumeicd1 = new ExDBFieldString<>("zrnbyoumeicd1", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnbyoumeicd2 = new ExDBFieldString<>("zrnbyoumeicd2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnshrnaiyoukbn = new ExDBFieldString<>("zrnshrnaiyoukbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrngituyuknkbn1 = new ExDBFieldString<>("zrngituyuknkbn1", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrngituyuknkbn2 = new ExDBFieldString<>("zrngituyuknkbn2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyeiebnri1 = new ExDBFieldString<>("zrnsyeiebnri1", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyeiebnri2 = new ExDBFieldString<>("zrnsyeiebnri2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnminnesotacd1 = new ExDBFieldString<>("zrnminnesotacd1", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnminnesotacd2 = new ExDBFieldString<>("zrnminnesotacd2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnminnesotacd3 = new ExDBFieldString<>("zrnminnesotacd3", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnminnesotacd4 = new ExDBFieldString<>("zrnminnesotacd4", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnminnesotacd5 = new ExDBFieldString<>("zrnminnesotacd5", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnmnsisiensindanjiyuu = new ExDBFieldString<>("zrnmnsisiensindanjiyuu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnknkuhnsindanjiyuu = new ExDBFieldString<>("zrnknkuhnsindanjiyuu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnhushrkbn = new ExDBFieldString<>("zrnhushrkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnhushrym = new ExDBFieldString<>("zrnhushrym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyuurouhunoukghasseiymd = new ExDBFieldString<>("zrnsyuurouhunoukghasseiymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyuurouhunoukgjyoutaikbn = new ExDBFieldString<>("zrnsyuurouhunoukgjyoutaikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnhokoukahikbn = new ExDBFieldString<>("zrnhokoukahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnngerkahikbn = new ExDBFieldString<>("zrnngerkahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnihukutyakudatukahikbn = new ExDBFieldString<>("zrnihukutyakudatukahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnnyykkahikbn = new ExDBFieldString<>("zrnnyykkahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsykmtssyukahikbn = new ExDBFieldString<>("zrnsykmtssyukahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnfktrsmtkahikbn = new ExDBFieldString<>("zrnfktrsmtkahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnseiketuseiyoukahikbn = new ExDBFieldString<>("zrnseiketuseiyoukahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyuurouhunoujyoutaikbn = new ExDBFieldString<>("zrnsyuurouhunoujyoutaikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnkyuuseisinkinkousokukbn = new ExDBFieldString<>("zrnkyuuseisinkinkousokukbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnnousottyuukbn = new ExDBFieldString<>("zrnnousottyuukbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnjinhuzenkbn = new ExDBFieldString<>("zrnjinhuzenkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnhukasyuksyu = new ExDBFieldString<>("zrnhukasyuksyu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrntkkbn2 = new ExDBFieldString<>("zrntkkbn2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrndoumyakusikkankbn = new ExDBFieldString<>("zrndoumyakusikkankbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsykikjgykbn = new ExDBFieldString<>("zrnsykikjgykbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnkaijyokbn = new ExDBFieldString<>("zrnkaijyokbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsymtymd = new ExDBFieldString<>("zrnsymtymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrntyuutohukatkhyj = new ExDBFieldString<>("zrntyuutohukatkhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnyoukigjyutigituymd = new ExDBFieldString<>("zrnyoukigjyutigituymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnyoukigjyutigeninkbn = new ExDBFieldString<>("zrnyoukigjyutigeninkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrntihougeninkbn = new ExDBFieldString<>("zrntihougeninkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyukgusdkbn = new ExDBFieldString<>("zrnsyukgusdkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrntignmrtisyukgusdkbn = new ExDBFieldString<>("zrntignmrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnrenseimrtisyukgusdkbn = new ExDBFieldString<>("zrnrenseimrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyunyumrtisyukgusdkbn = new ExDBFieldString<>("zrnsyunyumrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsbtoukeiidouinfopmenkbn = new ExDBFieldString<>("zrnsbtoukeiidouinfopmenkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnpmenjikohasseiymd = new ExDBFieldString<>("zrnpmenjikohasseiymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsyorino2moji = new ExDBFieldString<>("zrnsyorino2moji", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnksnym = new ExDBFieldString<>("zrnksnym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnikoujisnskbn = new ExDBFieldString<>("zrnikoujisnskbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsysnikoujiym = new ExDBFieldString<>("zrnsysnikoujiym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnijitoukeiyuksnhyj = new ExDBFieldString<>("zrnijitoukeiyuksnhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsotodasiphkbnmnoshyouji = new ExDBFieldString<>("zrnsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnstdsstkjytkyuhyj = new ExDBFieldString<>("zrnstdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnstdssytikbn = new ExDBFieldString<>("zrnstdssytikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnbnktgosnzkkyksyono = new ExDBFieldString<>("zrnbnktgosnzkkyksyono", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnbnkttnknkbn = new ExDBFieldString<>("zrnbnkttnknkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnkykjiqpackhyj = new ExDBFieldString<>("zrnkykjiqpackhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnbnktjisisttkarihyj = new ExDBFieldString<>("zrnbnktjisisttkarihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnsotodasipmenkbn = new ExDBFieldString<>("zrnsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnstdssnskbn = new ExDBFieldString<>("zrnstdssnskbn", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoRn, Integer> zrnyobisuuti7x1 = new ExDBFieldNumber<>("zrnyobisuuti7x1", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoRn, Integer> zrnyobisuuti7x2 = new ExDBFieldNumber<>("zrnyobisuuti7x2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnyobimojihan15 = new ExDBFieldString<>("zrnyobimojihan15", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoRn, String> zrnyobimojihan51 = new ExDBFieldString<>("zrnyobimojihan51", this);
}
