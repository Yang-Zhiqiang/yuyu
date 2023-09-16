package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KokyakuYuyuKykmeisaiFRn extends AbstractExDBTable<ZT_KokyakuYuyuKykmeisaiFRn> {

    public GenQZT_KokyakuYuyuKykmeisaiFRn() {
        this("ZT_KokyakuYuyuKykmeisaiFRn");
    }

    public GenQZT_KokyakuYuyuKykmeisaiFRn(String pAlias) {
        super("ZT_KokyakuYuyuKykmeisaiFRn", ZT_KokyakuYuyuKykmeisaiFRn.class, pAlias);
    }

    public String ZT_KokyakuYuyuKykmeisaiFRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnhrkmnenkansanp = new ExDBFieldNumber<>("zrnhrkmnenkansanp", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnyengyousekihosyous = new ExDBFieldNumber<>("zrnyengyousekihosyous", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsymtymd = new ExDBFieldString<>("zrnsymtymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsyukeiyakukigou = new ExDBFieldString<>("zrnsyukeiyakukigou", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsykykratesedaikbn = new ExDBFieldString<>("zrnsykykratesedaikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnjyudkaigomehrtkarihyj = new ExDBFieldString<>("zrnjyudkaigomehrtkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnpmentokuyakukbn = new ExDBFieldString<>("zrnpmentokuyakukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkykdrtkykarihyj = new ExDBFieldString<>("zrnkykdrtkykarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnyobiv158 = new ExDBFieldString<>("zrnyobiv158", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnknkyknm18 = new ExDBFieldString<>("zrnknkyknm18", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkjkyknm = new ExDBFieldString<>("zrnkjkyknm", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkyksyaseiymd = new ExDBFieldString<>("zrnkyksyaseiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkyksyanen3 = new ExDBFieldString<>("zrnkyksyanen3", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkykjikyksyanen = new ExDBFieldString<>("zrnkykjikyksyanen", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntuusinsakihumeihyj = new ExDBFieldString<>("zrntuusinsakihumeihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkihontikucd = new ExDBFieldString<>("zrnkihontikucd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntodouhukencd = new ExDBFieldString<>("zrntodouhukencd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsikutyousoncd5 = new ExDBFieldString<>("zrnsikutyousoncd5", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkjadr62 = new ExDBFieldString<>("zrnkjadr62", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntelno = new ExDBFieldString<>("zrntelno", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrndai2telno = new ExDBFieldString<>("zrndai2telno", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnknhhknmei = new ExDBFieldString<>("zrnknhhknmei", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnknjhhknmei = new ExDBFieldString<>("zrnknjhhknmei", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhhknnen = new ExDBFieldString<>("zrnhhknnen", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkykjihhknnen = new ExDBFieldString<>("zrnkykjihhknnen", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnmannenreikykhyj = new ExDBFieldString<>("zrnmannenreikykhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkyksyhhknsydouituhyouji = new ExDBFieldString<>("zrnkyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkykjyutikbn = new ExDBFieldString<>("zrnkykjyutikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsyoumetucd = new ExDBFieldString<>("zrnsyoumetucd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntorihikikaisiymd = new ExDBFieldString<>("zrntorihikikaisiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnpowerfulhyj = new ExDBFieldString<>("zrnpowerfulhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnlargehyj = new ExDBFieldString<>("zrnlargehyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsyouhinbunruikbn = new ExDBFieldString<>("zrnsyouhinbunruikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsyouhnnmkbn = new ExDBFieldString<>("zrnsyouhnnmkbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhknnmcd = new ExDBFieldString<>("zrnhknnmcd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntkbthsyukiknmanryouym = new ExDBFieldString<>("zrntkbthsyukiknmanryouym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnldownym = new ExDBFieldString<>("zrnldownym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhrkmanryouym = new ExDBFieldString<>("zrnhrkmanryouym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnmankiym = new ExDBFieldString<>("zrnmankiym", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, BizNumber> zrnsykykyoteiriritu = new ExDBFieldString<>("zrnsykykyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnrserieshyj = new ExDBFieldString<>("zrnrserieshyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnduketorihouhoukbn = new ExDBFieldString<>("zrnduketorihouhoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrninfoteikyoutsghyj = new ExDBFieldString<>("zrninfoteikyoutsghyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnnaimitukykhyj = new ExDBFieldString<>("zrnnaimitukykhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnmrarihyj = new ExDBFieldString<>("zrnmrarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnkasitukenaimituhyj = new ExDBFieldString<>("zrnkasitukenaimituhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnttdktyuuiarihyj = new ExDBFieldString<>("zrnttdktyuuiarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnttdktyuuisetkacd1 = new ExDBFieldString<>("zrnttdktyuuisetkacd1", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnttdktyuuisetymd1 = new ExDBFieldString<>("zrnttdktyuuisetymd1", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnttdktyuuisetkbn1 = new ExDBFieldString<>("zrnttdktyuuisetkbn1", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnttdktyuuisetkacd2 = new ExDBFieldString<>("zrnttdktyuuisetkacd2", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnttdktyuuisetymd2 = new ExDBFieldString<>("zrnttdktyuuisetymd2", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnttdktyuuisetkbn2 = new ExDBFieldString<>("zrnttdktyuuisetkbn2", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnttdktyuui3kenijyouhyj = new ExDBFieldString<>("zrnttdktyuui3kenijyouhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsentakujyouhouarihyouji = new ExDBFieldString<>("zrnsentakujyouhouarihyouji", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnstknsetkykhyj = new ExDBFieldString<>("zrnstknsetkykhyj", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnyenharaikomip = new ExDBFieldNumber<>("zrnyenharaikomip", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnyenkihons = new ExDBFieldNumber<>("zrnyenkihons", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnyensibous = new ExDBFieldNumber<>("zrnyensibous", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhrkhuhukbn = new ExDBFieldString<>("zrnhrkhuhukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsyuunoukeirokbn = new ExDBFieldString<>("zrnsyuunoukeirokbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrncalckijyunymd = new ExDBFieldString<>("zrncalckijyunymd", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrntumitatedzndk = new ExDBFieldNumber<>("zrntumitatedzndk", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntumitatedzndkhunouhyj = new ExDBFieldString<>("zrntumitatedzndkhunouhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrndairitenatkihyj = new ExDBFieldString<>("zrndairitenatkihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou1sisyacd = new ExDBFieldString<>("zrntantou1sisyacd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou1sibucd = new ExDBFieldString<>("zrntantou1sibucd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou1kojincd = new ExDBFieldString<>("zrntantou1kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou1tantoukaisiymd = new ExDBFieldString<>("zrntantou1tantoukaisiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou1tantousyakbn = new ExDBFieldString<>("zrntantou1tantousyakbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou2sisyacd = new ExDBFieldString<>("zrntantou2sisyacd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou2sibucd = new ExDBFieldString<>("zrntantou2sibucd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou2kojincd = new ExDBFieldString<>("zrntantou2kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou2tantoukaisiymd = new ExDBFieldString<>("zrntantou2tantoukaisiymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntantou2tantousyakbn = new ExDBFieldString<>("zrntantou2tantousyakbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsikijikbn = new ExDBFieldString<>("zrnsikijikbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnteikyou1sosikicd = new ExDBFieldString<>("zrnteikyou1sosikicd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnteikyou1kojincd = new ExDBFieldString<>("zrnteikyou1kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnteikyou1tantoukbn = new ExDBFieldString<>("zrnteikyou1tantoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnteikyou2sosikicd = new ExDBFieldString<>("zrnteikyou2sosikicd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnteikyou2kojincd = new ExDBFieldString<>("zrnteikyou2kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnteikyou2tantoukbn = new ExDBFieldString<>("zrnteikyou2tantoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnadrsyokansisyacd = new ExDBFieldString<>("zrnadrsyokansisyacd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhyukjsaki1sosikicd = new ExDBFieldString<>("zrnhyukjsaki1sosikicd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhyukjsaki1kojincd = new ExDBFieldString<>("zrnhyukjsaki1kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhyukjsaki1tantoukbn = new ExDBFieldString<>("zrnhyukjsaki1tantoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhyukjsaki2sosikicd = new ExDBFieldString<>("zrnhyukjsaki2sosikicd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhyukjsaki2kojincd = new ExDBFieldString<>("zrnhyukjsaki2kojincd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhyukjsaki2tantoukbn = new ExDBFieldString<>("zrnhyukjsaki2tantoukbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrninfotysytymd = new ExDBFieldString<>("zrninfotysytymd", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnstdairiseikyuutkykarihyj = new ExDBFieldString<>("zrnstdairiseikyuutkykarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhouteityotikuhknhyj = new ExDBFieldString<>("zrnhouteityotikuhknhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrndrctservicekbn = new ExDBFieldString<>("zrndrctservicekbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnhksuhngktkbtknjgnkbn = new ExDBFieldString<>("zrnhksuhngktkbtknjgnkbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnsiteituukakbn = new ExDBFieldString<>("zrnsiteituukakbn", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnmkhyouyenhknhentkarihyj = new ExDBFieldString<>("zrnmkhyouyenhknhentkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnyenkhrikmtkarihyj = new ExDBFieldString<>("zrnyenkhrikmtkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnstigihrikmtkarihyj = new ExDBFieldString<>("zrnstigihrikmtkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnyenshrgksitihsyutkhyj = new ExDBFieldString<>("zrnyenshrgksitihsyutkhyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, BizNumber> zrnsiteituukaharaikomip = new ExDBFieldString<>("zrnsiteituukaharaikomip", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnhrktuukaharaikomip = new ExDBFieldNumber<>("zrnhrktuukaharaikomip", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, BizNumber> zrnsiteituukakihonsx2 = new ExDBFieldString<>("zrnsiteituukakihonsx2", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, BizNumber> zrnsiteituukasibous = new ExDBFieldString<>("zrnsiteituukasibous", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnteikisiharaiarihyj = new ExDBFieldString<>("zrnteikisiharaiarihyj", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnyenteikishrkngk = new ExDBFieldNumber<>("zrnyenteikishrkngk", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, BizNumber> zrnsiteituukateikishrkngk = new ExDBFieldString<>("zrnsiteituukateikishrkngk", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnyobiv98 = new ExDBFieldString<>("zrnyobiv98", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnyenkihonhijynbris = new ExDBFieldNumber<>("zrnyenkihonhijynbris", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnyenkihonitijibarais = new ExDBFieldNumber<>("zrnyenkihonitijibarais", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnyenkihonhijynbrip = new ExDBFieldNumber<>("zrnyenkihonhijynbrip", this);

    public final ExDBFieldNumber<ZT_KokyakuYuyuKykmeisaiFRn, Long> zrnyenkihonitijibaraip = new ExDBFieldNumber<>("zrnyenkihonitijibaraip", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntrkkzk1trkarihyj = new ExDBFieldString<>("zrntrkkzk1trkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrntrkkzk2trkarihyj = new ExDBFieldString<>("zrntrkkzk2trkarihyj", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnyno7keta = new ExDBFieldString<>("zrnyno7keta", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnyobiv241 = new ExDBFieldString<>("zrnyobiv241", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnyobiv26 = new ExDBFieldString<>("zrnyobiv26", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnyobiv250x2 = new ExDBFieldString<>("zrnyobiv250x2", this);

    public final ExDBFieldString<ZT_KokyakuYuyuKykmeisaiFRn, String> zrnyobiv50 = new ExDBFieldString<>("zrnyobiv50", this);
}
