package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 募集代理店保有契約Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_BosyuuDrtenHoyuuKykRn extends AbstractExDBTable<ZT_BosyuuDrtenHoyuuKykRn> {

    public GenQZT_BosyuuDrtenHoyuuKykRn() {
        this("ZT_BosyuuDrtenHoyuuKykRn");
    }

    public GenQZT_BosyuuDrtenHoyuuKykRn(String pAlias) {
        super("ZT_BosyuuDrtenHoyuuKykRn", ZT_BosyuuDrtenHoyuuKykRn.class, pAlias);
    }

    public String ZT_BosyuuDrtenHoyuuKykRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndatasyurui = new ExDBFieldString<>("zrndatasyurui", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhknsyumoku = new ExDBFieldString<>("zrnhknsyumoku", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntyoubokbn = new ExDBFieldString<>("zrntyoubokbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyonosyuban = new ExDBFieldString<>("zrnsyonosyuban", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhknsyurui2keta = new ExDBFieldString<>("zrnhknsyurui2keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhrkhuhukbn = new ExDBFieldString<>("zrnhrkhuhukbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyukinkbn = new ExDBFieldString<>("zrnsyukinkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnbnkaisuu = new ExDBFieldString<>("zrnbnkaisuu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkyouhocd = new ExDBFieldString<>("zrnkyouhocd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndaibuncd = new ExDBFieldString<>("zrndaibuncd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndaibunkanjishare = new ExDBFieldString<>("zrndaibunkanjishare", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndntcd7keta = new ExDBFieldString<>("zrndntcd7keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyumokugrpkbn = new ExDBFieldString<>("zrnsyumokugrpkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrngoukeipbsdirtnhykyk = new ExDBFieldString<>("zrngoukeipbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnyno7keta = new ExDBFieldString<>("zrnyno7keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsikiymd = new ExDBFieldString<>("zrnsikiymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnmankiymd = new ExDBFieldString<>("zrnmankiymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnidokaiyakuymd = new ExDBFieldString<>("zrnidokaiyakuymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnmusymd = new ExDBFieldString<>("zrnmusymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnjikokykhyj = new ExDBFieldString<>("zrnjikokykhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnmeisaioyakokbn = new ExDBFieldString<>("zrnmeisaioyakokbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkihontikucdkami3 = new ExDBFieldString<>("zrnkihontikucdkami3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnyobiv2 = new ExDBFieldString<>("zrnyobiv2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntelnobsdirtnhykyk = new ExDBFieldString<>("zrntelnobsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkyknmknbsdirtnhykyk = new ExDBFieldString<>("zrnkyknmknbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnbnkyk1kaipbsdirtnhykyk = new ExDBFieldString<>("zrnbnkyk1kaipbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnbnsyuruikbn = new ExDBFieldString<>("zrnbnsyuruikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhrkymd = new ExDBFieldString<>("zrnhrkymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndntfsthrkym = new ExDBFieldString<>("zrndntfsthrkym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnfstpkzhurikbn = new ExDBFieldString<>("zrnfstpkzhurikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkeijyouym4keta = new ExDBFieldString<>("zrnkeijyouym4keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhknkaisyacd = new ExDBFieldString<>("zrnhknkaisyacd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhhknnmknbsdirtnhykyk = new ExDBFieldString<>("zrnhhknnmknbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnknjhhknmei = new ExDBFieldString<>("zrnknjhhknmei", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhhknnenbsdirtnhykyk = new ExDBFieldString<>("zrnhhknnenbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhhkntdk = new ExDBFieldString<>("zrnhhkntdk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhhknynobsdirtnhykyk = new ExDBFieldString<>("zrnhhknynobsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhhknadrkj50 = new ExDBFieldString<>("zrnhhknadrkj50", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhrkkeiro = new ExDBFieldString<>("zrnhrkkeiro", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnitijibrpbsdirtnhykyk = new ExDBFieldString<>("zrnitijibrpbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnnkshrkknkbn = new ExDBFieldString<>("zrnnkshrkknkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnnkshrkknnen = new ExDBFieldString<>("zrnnkshrkknnen", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnnkshrstartymd = new ExDBFieldString<>("zrnnkshrstartymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntokutaiumu = new ExDBFieldString<>("zrntokutaiumu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntktyuutohuka = new ExDBFieldString<>("zrntktyuutohuka", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntksuu = new ExDBFieldString<>("zrntksuu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsinsakbn = new ExDBFieldString<>("zrnsinsakbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnzeiseitekikaku = new ExDBFieldString<>("zrnzeiseitekikaku", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnlivingneeds = new ExDBFieldString<>("zrnlivingneeds", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnknjsyuhsynm = new ExDBFieldString<>("zrnknjsyuhsynm", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyusbsdirtnhykyk = new ExDBFieldString<>("zrnsyusbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyuhknkknkbn = new ExDBFieldString<>("zrnsyuhknkknkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyuhknkkn = new ExDBFieldString<>("zrnsyuhknkkn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyuhrkkknkbn = new ExDBFieldString<>("zrnsyuhrkkknkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyuhrkkkn = new ExDBFieldString<>("zrnsyuhrkkkn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkjtkhosyunm1 = new ExDBFieldString<>("zrnkjtkhosyunm1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntks1bsdirtnhykyk = new ExDBFieldString<>("zrntks1bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkknkbn1 = new ExDBFieldString<>("zrntkhknkknkbn1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkkn1 = new ExDBFieldString<>("zrntkhknkkn1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkknkbn1 = new ExDBFieldString<>("zrntkhrkkknkbn1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkkn1 = new ExDBFieldString<>("zrntkhrkkkn1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkjtkhosyunm2 = new ExDBFieldString<>("zrnkjtkhosyunm2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntks2bsdirtnhykyk = new ExDBFieldString<>("zrntks2bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkknkbn2 = new ExDBFieldString<>("zrntkhknkknkbn2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkkn2 = new ExDBFieldString<>("zrntkhknkkn2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkknkbn2 = new ExDBFieldString<>("zrntkhrkkknkbn2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkkn2 = new ExDBFieldString<>("zrntkhrkkkn2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkjtkhosyunm3 = new ExDBFieldString<>("zrnkjtkhosyunm3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntks3bsdirtnhykyk = new ExDBFieldString<>("zrntks3bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkknkbn3 = new ExDBFieldString<>("zrntkhknkknkbn3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkkn3 = new ExDBFieldString<>("zrntkhknkkn3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkknkbn3 = new ExDBFieldString<>("zrntkhrkkknkbn3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkkn3 = new ExDBFieldString<>("zrntkhrkkkn3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkjtkhosyunm4 = new ExDBFieldString<>("zrnkjtkhosyunm4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntks4bsdirtnhykyk = new ExDBFieldString<>("zrntks4bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkknkbn4 = new ExDBFieldString<>("zrntkhknkknkbn4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkkn4 = new ExDBFieldString<>("zrntkhknkkn4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkknkbn4 = new ExDBFieldString<>("zrntkhrkkknkbn4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkkn4 = new ExDBFieldString<>("zrntkhrkkkn4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkjtkhosyunm5 = new ExDBFieldString<>("zrnkjtkhosyunm5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntks5bsdirtnhykyk = new ExDBFieldString<>("zrntks5bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkknkbn5 = new ExDBFieldString<>("zrntkhknkknkbn5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkkn5 = new ExDBFieldString<>("zrntkhknkkn5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkknkbn5 = new ExDBFieldString<>("zrntkhrkkknkbn5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkkn5 = new ExDBFieldString<>("zrntkhrkkkn5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkjtkhosyunm6 = new ExDBFieldString<>("zrnkjtkhosyunm6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntks6bsdirtnhykyk = new ExDBFieldString<>("zrntks6bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkknkbn6 = new ExDBFieldString<>("zrntkhknkknkbn6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhknkkn6 = new ExDBFieldString<>("zrntkhknkkn6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkknkbn6 = new ExDBFieldString<>("zrntkhrkkknkbn6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkhrkkkn6 = new ExDBFieldString<>("zrntkhrkkkn6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndatasyubetucd = new ExDBFieldString<>("zrndatasyubetucd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhjnkojinkbn = new ExDBFieldString<>("zrnhjnkojinkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkykadrkj50 = new ExDBFieldString<>("zrnkykadrkj50", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkyknmkjbsdirtnhykyk = new ExDBFieldString<>("zrnkyknmkjbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkyksyaseiymd = new ExDBFieldString<>("zrnkyksyaseiymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsakuseiym = new ExDBFieldString<>("zrnsakuseiym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndairitencd = new ExDBFieldString<>("zrndairitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndairitenkanrisskcd = new ExDBFieldString<>("zrndairitenkanrisskcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnbosyuunincd = new ExDBFieldString<>("zrnbosyuunincd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnbosyuunm = new ExDBFieldString<>("zrnbosyuunm", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnbosyuujtkbn = new ExDBFieldString<>("zrnbosyuujtkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndairitenkbtinfo1 = new ExDBFieldString<>("zrndairitenkbtinfo1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndairitenkbtinfo2 = new ExDBFieldString<>("zrndairitenkbtinfo2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndairitenkbtinfo3 = new ExDBFieldString<>("zrndairitenkbtinfo3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyouhinbunruikbn = new ExDBFieldString<>("zrnsyouhinbunruikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhknnmcd = new ExDBFieldString<>("zrnhknnmcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkykjyutikbn = new ExDBFieldString<>("zrnkykjyutikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntkbthsyukiknmanryouym = new ExDBFieldString<>("zrntkbthsyukiknmanryouym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnldownym = new ExDBFieldString<>("zrnldownym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhrkmanryouym = new ExDBFieldString<>("zrnhrkmanryouym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnmrtiksnym = new ExDBFieldString<>("zrnmrtiksnym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhaneikykhyj = new ExDBFieldString<>("zrnhaneikykhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnzenzeikyohyj = new ExDBFieldString<>("zrnzenzeikyohyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsikijikbn = new ExDBFieldString<>("zrnsikijikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsbuktdisphukusuhyj = new ExDBFieldString<>("zrnsbuktdisphukusuhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsbuktnmbsdirtnhykyk = new ExDBFieldString<>("zrnsbuktnmbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnmnkuktdisphukusuhyj = new ExDBFieldString<>("zrnmnkuktdisphukusuhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnmnkuktnmbsdirtnhykyk = new ExDBFieldString<>("zrnmnkuktnmbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntodouhukencd = new ExDBFieldString<>("zrntodouhukencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnbankcd = new ExDBFieldString<>("zrnbankcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnshitencd = new ExDBFieldString<>("zrnshitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnyokinkbn = new ExDBFieldString<>("zrnyokinkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkouzano7keta = new ExDBFieldString<>("zrnkouzano7keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnalcardkbn = new ExDBFieldString<>("zrnalcardkbn", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrnsgsbs = new ExDBFieldNumber<>("zrnsgsbs", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsgwrmstksbsdirtnhykyk = new ExDBFieldString<>("zrnsgwrmstksbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyougaitkkatakbn = new ExDBFieldString<>("zrnsyougaitkkatakbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyougaitksbsdirtnhykyk = new ExDBFieldString<>("zrnsyougaitksbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnreguardtksbsdirtnhykyk = new ExDBFieldString<>("zrnreguardtksbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnreguardtkkbn = new ExDBFieldString<>("zrnreguardtkkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnvreguardtksbsdirtnhykyk = new ExDBFieldString<>("zrnvreguardtksbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkzkmrthgukatakbn = new ExDBFieldString<>("zrnkzkmrthgukatakbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkzkmrthgusbsdirtnhykyk = new ExDBFieldString<>("zrnkzkmrthgusbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkzkmrtkosbsdirtnhykyk = new ExDBFieldString<>("zrnkzkmrtkosbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkaneeztkarihyj = new ExDBFieldString<>("zrnkaneeztkarihyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndrtenkinyuucd = new ExDBFieldString<>("zrndrtenkinyuucd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndrtensitencd = new ExDBFieldString<>("zrndrtensitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnstjmkbn = new ExDBFieldString<>("zrnstjmkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyokaiphrkkeiro = new ExDBFieldString<>("zrnsyokaiphrkkeiro", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkanjidairitennm = new ExDBFieldString<>("zrnkanjidairitennm", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrntsrybnwari = new ExDBFieldNumber<>("zrntsrybnwari", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrndrtenkeijyouym = new ExDBFieldString<>("zrndrtenkeijyouym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkydatkidairitencd = new ExDBFieldString<>("zrnkydatkidairitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnmdhnsyouhntsryshrkbn = new ExDBFieldString<>("zrnmdhnsyouhntsryshrkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkyksyanen = new ExDBFieldString<>("zrnkyksyanen", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnmdhnaisyoumeicd = new ExDBFieldString<>("zrnmdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsyokaipryosyuymd = new ExDBFieldString<>("zrnsyokaipryosyuymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsykgycd = new ExDBFieldString<>("zrnsykgycd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, BizNumber> zrnkaiyakuhrmkhritu = new ExDBFieldString<>("zrnkaiyakuhrmkhritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntoutatukaiyakuhrmkhritu = new ExDBFieldString<>("zrntoutatukaiyakuhrmkhritu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkaiyakuhrmkhtoutatuymd = new ExDBFieldString<>("zrnkaiyakuhrmkhtoutatuymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnlivguardtkyks = new ExDBFieldString<>("zrnlivguardtkyks", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrnsiteituukaitijibrp = new ExDBFieldNumber<>("zrnsiteituukaitijibrp", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrnsiteituukasyus = new ExDBFieldNumber<>("zrnsiteituukasyus", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrnsiteituukasbs = new ExDBFieldNumber<>("zrnsiteituukasbs", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrnsiteituukasaigaisbs = new ExDBFieldNumber<>("zrnsiteituukasaigaisbs", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnsiteituukacd = new ExDBFieldString<>("zrnsiteituukacd", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrnhrktuukaitijibrp = new ExDBFieldNumber<>("zrnhrktuukaitijibrp", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnhrktuukacd = new ExDBFieldString<>("zrnhrktuukacd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, BizNumber> zrntumitateriritu = new ExDBFieldString<>("zrntumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, BizNumber> zrntmttknzoukaritujygn = new ExDBFieldString<>("zrntmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, BizNumber> zrnsetteibairitu = new ExDBFieldString<>("zrnsetteibairitu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrntumitatekngk = new ExDBFieldNumber<>("zrntumitatekngk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkjsbuktnm30 = new ExDBFieldString<>("zrnkjsbuktnm30", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnmnkuktnm30 = new ExDBFieldString<>("zrnmnkuktnm30", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkjkykdairinm = new ExDBFieldString<>("zrnkjkykdairinm", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnkjsiteidairinm30 = new ExDBFieldString<>("zrnkjsiteidairinm30", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntrkkzknmkj1 = new ExDBFieldString<>("zrntrkkzknmkj1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntrkkzknmkj2 = new ExDBFieldString<>("zrntrkkzknmkj2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnikkatubaraikbn = new ExDBFieldString<>("zrnikkatubaraikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnikkatubaraikaisuu = new ExDBFieldString<>("zrnikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, BizNumber> zrnrendouritu = new ExDBFieldString<>("zrnrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, BizNumber> zrnteikishrritu = new ExDBFieldString<>("zrnteikishrritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntikskzuktnmkj = new ExDBFieldString<>("zrntikskzuktnmkj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntikskzbankcd = new ExDBFieldString<>("zrntikskzbankcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntikskzsitencd = new ExDBFieldString<>("zrntikskzsitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntikskzyokinkbn = new ExDBFieldString<>("zrntikskzyokinkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntikskzkouzano = new ExDBFieldString<>("zrntikskzkouzano", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrntikskzkzmeiginmkn = new ExDBFieldString<>("zrntikskzkzmeiginmkn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnteikishrkinshrtuukasyu = new ExDBFieldString<>("zrnteikishrkinshrtuukasyu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnnnknsnpssyhknsyukigou = new ExDBFieldString<>("zrnnnknsnpssyhknsyukigou", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnnnknsnpssyhknkkn = new ExDBFieldString<>("zrnnnknsnpssyhknkkn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnnnknsnpssyphrkkikn = new ExDBFieldString<>("zrnnnknsnpssyphrkkikn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnnnknsnpssysaimnkkykhyj = new ExDBFieldString<>("zrnnnknsnpssysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnnknsnpssyhrkkskbn = new ExDBFieldString<>("zrnnknsnpssyhrkkskbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnnnknsnpssyhhknnen = new ExDBFieldString<>("zrnnnknsnpssyhhknnen", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, BizNumber> zrnnnknsnpssyitijibrpkyktk = new ExDBFieldString<>("zrnnnknsnpssyitijibrpkyktk", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrnnnknsnpssysyup = new ExDBFieldNumber<>("zrnnnknsnpssysyup", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, BizNumber> zrnnnknsnpssykawaseraten5 = new ExDBFieldString<>("zrnnnknsnpssykawaseraten5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykRn, Long> zrnzennoup = new ExDBFieldNumber<>("zrnzennoup", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykRn, String> zrnyobiv25 = new ExDBFieldString<>("zrnyobiv25", this);
}
