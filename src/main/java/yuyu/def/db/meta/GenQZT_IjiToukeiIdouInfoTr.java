package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;

/**
 * 医事統計異動情報テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_IjiToukeiIdouInfoTr extends AbstractExDBTable<ZT_IjiToukeiIdouInfoTr> {

    public GenQZT_IjiToukeiIdouInfoTr() {
        this("ZT_IjiToukeiIdouInfoTr");
    }

    public GenQZT_IjiToukeiIdouInfoTr(String pAlias) {
        super("ZT_IjiToukeiIdouInfoTr", ZT_IjiToukeiIdouInfoTr.class, pAlias);
    }

    public String ZT_IjiToukeiIdouInfoTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyono = new ExDBFieldString<>("ztrsyono", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyoriymd = new ExDBFieldString<>("ztrsyoriymd", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoTr, Integer> ztrkykmfksnctr = new ExDBFieldNumber<>("ztrkykmfksnctr", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyukgu = new ExDBFieldString<>("ztrsyukgu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrhhknnen2keta = new ExDBFieldString<>("ztrhhknnen2keta", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrhhknseikbn = new ExDBFieldString<>("ztrhhknseikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrkykym = new ExDBFieldString<>("ztrkykym", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoTr, Integer> ztrkisnkihons = new ExDBFieldNumber<>("ztrkisnkihons", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoTr, Integer> ztrimustiyusbus = new ExDBFieldNumber<>("ztrimustiyusbus", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoTr, Integer> ztrshrs = new ExDBFieldNumber<>("ztrshrs", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrshrymd = new ExDBFieldString<>("ztrshrymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsymtgenincd = new ExDBFieldString<>("ztrsymtgenincd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrkeikaym = new ExDBFieldString<>("ztrkeikaym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsbugenincd = new ExDBFieldString<>("ztrsbugenincd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrbsyym = new ExDBFieldString<>("ztrbsyym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrdai2hhknnen = new ExDBFieldString<>("ztrdai2hhknnen", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrmannenreihyj = new ExDBFieldString<>("ztrmannenreihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrtignmrtisyukgu = new ExDBFieldString<>("ztrtignmrtisyukgu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrhhknnentysihyj = new ExDBFieldString<>("ztrhhknnentysihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrdai2hhknnentysihyj = new ExDBFieldString<>("ztrdai2hhknnentysihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrrenseimrtisyukgu = new ExDBFieldString<>("ztrrenseimrtisyukgu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrbnktjitiktkarihyj = new ExDBFieldString<>("ztrbnktjitiktkarihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrlivingneedsshrarihyj = new ExDBFieldString<>("ztrlivingneedsshrarihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrlnkeikaym = new ExDBFieldString<>("ztrlnkeikaym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrlnshrgenincd = new ExDBFieldString<>("ztrlnshrgenincd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrkituenkbn = new ExDBFieldString<>("ztrkituenkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrkituenhonsuu = new ExDBFieldString<>("ztrkituenhonsuu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrgnspshrhyj = new ExDBFieldString<>("ztrgnspshrhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrgnspshrkeikaym = new ExDBFieldString<>("ztrgnspshrkeikaym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrgnspshrgenincd = new ExDBFieldString<>("ztrgnspshrgenincd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyunyumrtisyukgu = new ExDBFieldString<>("ztrsyunyumrtisyukgu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsysnymd = new ExDBFieldString<>("ztrsysnymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsindanymd = new ExDBFieldString<>("ztrsindanymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrbyoumeicd1 = new ExDBFieldString<>("ztrbyoumeicd1", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrbyoumeicd2 = new ExDBFieldString<>("ztrbyoumeicd2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrshrnaiyoukbn = new ExDBFieldString<>("ztrshrnaiyoukbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrgituyuknkbn1 = new ExDBFieldString<>("ztrgituyuknkbn1", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrgituyuknkbn2 = new ExDBFieldString<>("ztrgituyuknkbn2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyeiebnri1 = new ExDBFieldString<>("ztrsyeiebnri1", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyeiebnri2 = new ExDBFieldString<>("ztrsyeiebnri2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrminnesotacd1 = new ExDBFieldString<>("ztrminnesotacd1", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrminnesotacd2 = new ExDBFieldString<>("ztrminnesotacd2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrminnesotacd3 = new ExDBFieldString<>("ztrminnesotacd3", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrminnesotacd4 = new ExDBFieldString<>("ztrminnesotacd4", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrminnesotacd5 = new ExDBFieldString<>("ztrminnesotacd5", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrmnsisiensindanjiyuu = new ExDBFieldString<>("ztrmnsisiensindanjiyuu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrknkuhnsindanjiyuu = new ExDBFieldString<>("ztrknkuhnsindanjiyuu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrhushrkbn = new ExDBFieldString<>("ztrhushrkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrhushrym = new ExDBFieldString<>("ztrhushrym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyuurouhunoukghasseiymd = new ExDBFieldString<>("ztrsyuurouhunoukghasseiymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyuurouhunoukgjyoutaikbn = new ExDBFieldString<>("ztrsyuurouhunoukgjyoutaikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrhokoukahikbn = new ExDBFieldString<>("ztrhokoukahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrngerkahikbn = new ExDBFieldString<>("ztrngerkahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrihukutyakudatukahikbn = new ExDBFieldString<>("ztrihukutyakudatukahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrnyykkahikbn = new ExDBFieldString<>("ztrnyykkahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsykmtssyukahikbn = new ExDBFieldString<>("ztrsykmtssyukahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrfktrsmtkahikbn = new ExDBFieldString<>("ztrfktrsmtkahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrseiketuseiyoukahikbn = new ExDBFieldString<>("ztrseiketuseiyoukahikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyuurouhunoujyoutaikbn = new ExDBFieldString<>("ztrsyuurouhunoujyoutaikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrkyuuseisinkinkousokukbn = new ExDBFieldString<>("ztrkyuuseisinkinkousokukbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrnousottyuukbn = new ExDBFieldString<>("ztrnousottyuukbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrjinhuzenkbn = new ExDBFieldString<>("ztrjinhuzenkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrhukasyuksyu = new ExDBFieldString<>("ztrhukasyuksyu", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrtkkbn2 = new ExDBFieldString<>("ztrtkkbn2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrdoumyakusikkankbn = new ExDBFieldString<>("ztrdoumyakusikkankbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsykikjgykbn = new ExDBFieldString<>("ztrsykikjgykbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrkaijyokbn = new ExDBFieldString<>("ztrkaijyokbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsymtymd = new ExDBFieldString<>("ztrsymtymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrtyuutohukatkhyj = new ExDBFieldString<>("ztrtyuutohukatkhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztryoukigjyutigituymd = new ExDBFieldString<>("ztryoukigjyutigituymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztryoukigjyutigeninkbn = new ExDBFieldString<>("ztryoukigjyutigeninkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrtihougeninkbn = new ExDBFieldString<>("ztrtihougeninkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyukgusdkbn = new ExDBFieldString<>("ztrsyukgusdkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrtignmrtisyukgusdkbn = new ExDBFieldString<>("ztrtignmrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrrenseimrtisyukgusdkbn = new ExDBFieldString<>("ztrrenseimrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyunyumrtisyukgusdkbn = new ExDBFieldString<>("ztrsyunyumrtisyukgusdkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsbtoukeiidouinfopmenkbn = new ExDBFieldString<>("ztrsbtoukeiidouinfopmenkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrpmenjikohasseiymd = new ExDBFieldString<>("ztrpmenjikohasseiymd", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsyorino2moji = new ExDBFieldString<>("ztrsyorino2moji", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrksnym = new ExDBFieldString<>("ztrksnym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrikoujisnskbn = new ExDBFieldString<>("ztrikoujisnskbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsysnikoujiym = new ExDBFieldString<>("ztrsysnikoujiym", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrijitoukeiyuksnhyj = new ExDBFieldString<>("ztrijitoukeiyuksnhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsotodasiphkbnmnoshyouji = new ExDBFieldString<>("ztrsotodasiphkbnmnoshyouji", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrstdsstkjytkyuhyj = new ExDBFieldString<>("ztrstdsstkjytkyuhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrstdssytikbn = new ExDBFieldString<>("ztrstdssytikbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrbnktgosnzkkyksyono = new ExDBFieldString<>("ztrbnktgosnzkkyksyono", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrbnkttnknkbn = new ExDBFieldString<>("ztrbnkttnknkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrkykjiqpackhyj = new ExDBFieldString<>("ztrkykjiqpackhyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrbnktjisisttkarihyj = new ExDBFieldString<>("ztrbnktjisisttkarihyj", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrsotodasipmenkbn = new ExDBFieldString<>("ztrsotodasipmenkbn", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztrstdssnskbn = new ExDBFieldString<>("ztrstdssnskbn", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoTr, Integer> ztryobisuuti7x1 = new ExDBFieldNumber<>("ztryobisuuti7x1", this);

    public final ExDBFieldNumber<ZT_IjiToukeiIdouInfoTr, Integer> ztryobisuuti7x2 = new ExDBFieldNumber<>("ztryobisuuti7x2", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztryobimojihan15 = new ExDBFieldString<>("ztryobimojihan15", this);

    public final ExDBFieldString<ZT_IjiToukeiIdouInfoTr, String> ztryobimojihan51 = new ExDBFieldString<>("ztryobimojihan51", this);
}
