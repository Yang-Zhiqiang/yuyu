package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KydGWKykInfoRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 共同ＧＷ用契約情報Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KydGWKykInfoRn extends AbstractExDBTable<ZT_KydGWKykInfoRn> {

    public GenQZT_KydGWKykInfoRn() {
        this("ZT_KydGWKykInfoRn");
    }

    public GenQZT_KydGWKykInfoRn(String pAlias) {
        super("ZT_KydGWKykInfoRn", ZT_KydGWKykInfoRn.class, pAlias);
    }

    public String ZT_KydGWKykInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhknsyurui2keta = new ExDBFieldString<>("zrnhknsyurui2keta", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsinkeizkkbn = new ExDBFieldString<>("zrnsinkeizkkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyuhosyucd = new ExDBFieldString<>("zrnsyuhosyucd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmdhnaisyoumeicd = new ExDBFieldString<>("zrnmdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyouhncd = new ExDBFieldString<>("zrnsyouhncd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmusymd = new ExDBFieldString<>("zrnmusymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkykseirituymd = new ExDBFieldString<>("zrnkykseirituymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsekininkaisiymd = new ExDBFieldString<>("zrnsekininkaisiymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyokaipymd = new ExDBFieldString<>("zrnsyokaipymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhjnkojinkbn = new ExDBFieldString<>("zrnhjnkojinkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhrkhuhukbn = new ExDBFieldString<>("zrnhrkhuhukbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhrkymd = new ExDBFieldString<>("zrnhrkymd", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrngoukeip2 = new ExDBFieldNumber<>("zrngoukeip2", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnitijibrp = new ExDBFieldNumber<>("zrnitijibrp", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnbnkaisuu = new ExDBFieldString<>("zrnbnkaisuu", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnbnsyuruikbn = new ExDBFieldString<>("zrnbnsyuruikbn", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnbnkyk1kaip = new ExDBFieldNumber<>("zrnbnkyk1kaip", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnyobiv20 = new ExDBFieldString<>("zrnyobiv20", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyuhknkknkbn = new ExDBFieldString<>("zrnsyuhknkknkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyuhknkkn = new ExDBFieldString<>("zrnsyuhknkkn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyuhrkkknkbn = new ExDBFieldString<>("zrnsyuhrkkknkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyuhrkkkn = new ExDBFieldString<>("zrnsyuhrkkkn", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnsyus = new ExDBFieldNumber<>("zrnsyus", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyunm = new ExDBFieldString<>("zrnsyunm", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnidojiyukbn = new ExDBFieldString<>("zrnidojiyukbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyoumetucd = new ExDBFieldString<>("zrnsyoumetucd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnidokaiyakuymd = new ExDBFieldString<>("zrnidokaiyakuymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmankiymd = new ExDBFieldString<>("zrnmankiymd", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnsibous = new ExDBFieldNumber<>("zrnsibous", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnidoukaiyakup = new ExDBFieldNumber<>("zrnidoukaiyakup", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyukinkbn = new ExDBFieldString<>("zrnsyukinkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhaitoukbn = new ExDBFieldString<>("zrnhaitoukbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrncreditcardhrkbn = new ExDBFieldString<>("zrncreditcardhrkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkjykbn = new ExDBFieldString<>("zrntkjykbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsinsakbn = new ExDBFieldString<>("zrnsinsakbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnzeiseitekikakuhyj = new ExDBFieldString<>("zrnzeiseitekikakuhyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnlivhukauhyj = new ExDBFieldString<>("zrnlivhukauhyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhrizmentyouhyj = new ExDBFieldString<>("zrnhrizmentyouhyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkisokyknkshrhsykn = new ExDBFieldString<>("zrnkisokyknkshrhsykn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnnkshrkknkbn = new ExDBFieldString<>("zrnnkshrkknkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnnkshrkknnen = new ExDBFieldString<>("zrnnkshrkknnen", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnnksueokikn = new ExDBFieldString<>("zrnnksueokikn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnnkshrstartymd = new ExDBFieldString<>("zrnnkshrstartymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnnkuketorininkbn = new ExDBFieldString<>("zrnnkuketorininkbn", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnzennoup = new ExDBFieldNumber<>("zrnzennoup", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnzennouendym = new ExDBFieldString<>("zrnzennouendym", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnteikaiyakuhrkn = new ExDBFieldString<>("zrnteikaiyakuhrkn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmosno = new ExDBFieldString<>("zrnmosno", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntratkisyacd1 = new ExDBFieldString<>("zrntratkisyacd1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntratkisyacd2 = new ExDBFieldString<>("zrntratkisyacd2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrndairiten1cd = new ExDBFieldString<>("zrndairiten1cd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrndairiten2cd = new ExDBFieldString<>("zrndairiten2cd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnbsudirtnatkikeitaikbn = new ExDBFieldString<>("zrnbsudirtnatkikeitaikbn", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnbsyudiritnatkiwari1 = new ExDBFieldNumber<>("zrnbsyudiritnatkiwari1", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnbsyudiritnatkiwari2 = new ExDBFieldNumber<>("zrnbsyudiritnatkiwari2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnyobiv20x2 = new ExDBFieldString<>("zrnyobiv20x2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntktyuutohukahyj = new ExDBFieldString<>("zrntktyuutohukahyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntksuu = new ExDBFieldString<>("zrntksuu", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhosyucd1 = new ExDBFieldString<>("zrntkhosyucd1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntknm1 = new ExDBFieldString<>("zrntknm1", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrntks1 = new ExDBFieldNumber<>("zrntks1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkknkbn1 = new ExDBFieldString<>("zrntkhknkknkbn1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkkn1 = new ExDBFieldString<>("zrntkhknkkn1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkknkbn1 = new ExDBFieldString<>("zrntkhrkkknkbn1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkkn1 = new ExDBFieldString<>("zrntkhrkkkn1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhosyucd2 = new ExDBFieldString<>("zrntkhosyucd2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntknm2 = new ExDBFieldString<>("zrntknm2", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrntks2 = new ExDBFieldNumber<>("zrntks2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkknkbn2 = new ExDBFieldString<>("zrntkhknkknkbn2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkkn2 = new ExDBFieldString<>("zrntkhknkkn2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkknkbn2 = new ExDBFieldString<>("zrntkhrkkknkbn2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkkn2 = new ExDBFieldString<>("zrntkhrkkkn2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhosyucd3 = new ExDBFieldString<>("zrntkhosyucd3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntknm3 = new ExDBFieldString<>("zrntknm3", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrntks3 = new ExDBFieldNumber<>("zrntks3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkknkbn3 = new ExDBFieldString<>("zrntkhknkknkbn3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkkn3 = new ExDBFieldString<>("zrntkhknkkn3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkknkbn3 = new ExDBFieldString<>("zrntkhrkkknkbn3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkkn3 = new ExDBFieldString<>("zrntkhrkkkn3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhosyucd4 = new ExDBFieldString<>("zrntkhosyucd4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntknm4 = new ExDBFieldString<>("zrntknm4", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrntks4 = new ExDBFieldNumber<>("zrntks4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkknkbn4 = new ExDBFieldString<>("zrntkhknkknkbn4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkkn4 = new ExDBFieldString<>("zrntkhknkkn4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkknkbn4 = new ExDBFieldString<>("zrntkhrkkknkbn4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkkn4 = new ExDBFieldString<>("zrntkhrkkkn4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhosyucd5 = new ExDBFieldString<>("zrntkhosyucd5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntknm5 = new ExDBFieldString<>("zrntknm5", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrntks5 = new ExDBFieldNumber<>("zrntks5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkknkbn5 = new ExDBFieldString<>("zrntkhknkknkbn5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkkn5 = new ExDBFieldString<>("zrntkhknkkn5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkknkbn5 = new ExDBFieldString<>("zrntkhrkkknkbn5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkkn5 = new ExDBFieldString<>("zrntkhrkkkn5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhosyucd6 = new ExDBFieldString<>("zrntkhosyucd6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntknm6 = new ExDBFieldString<>("zrntknm6", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrntks6 = new ExDBFieldNumber<>("zrntks6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkknkbn6 = new ExDBFieldString<>("zrntkhknkknkbn6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhknkkn6 = new ExDBFieldString<>("zrntkhknkkn6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkknkbn6 = new ExDBFieldString<>("zrntkhrkkknkbn6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntkhrkkkn6 = new ExDBFieldString<>("zrntkhrkkkn6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsbuktnm = new ExDBFieldString<>("zrnsbuktnm", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkjsbuktnm = new ExDBFieldString<>("zrnkjsbuktnm", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsbukttdk = new ExDBFieldString<>("zrnsbukttdk", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsbuktnin = new ExDBFieldString<>("zrnsbuktnin", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnyobiv28 = new ExDBFieldString<>("zrnyobiv28", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnyno7keta = new ExDBFieldString<>("zrnyno7keta", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntelnokydgw = new ExDBFieldString<>("zrntelnokydgw", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkyknmknkydgw = new ExDBFieldString<>("zrnkyknmknkydgw", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkyksyaseiymd = new ExDBFieldString<>("zrnkyksyaseiymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkyksyaseikbn = new ExDBFieldString<>("zrnkyksyaseikbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrntsinkihontikucd = new ExDBFieldString<>("zrntsinkihontikucd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkykadrkj50 = new ExDBFieldString<>("zrnkykadrkj50", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkyknmkjkydgw = new ExDBFieldString<>("zrnkyknmkjkydgw", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhhknmei = new ExDBFieldString<>("zrnhhknmei", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhhknnmkj = new ExDBFieldString<>("zrnhhknnmkj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhhknnen = new ExDBFieldString<>("zrnhhknnen", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnhhkntdk = new ExDBFieldString<>("zrnhhkntdk", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkzsyurui = new ExDBFieldString<>("zrnkzsyurui", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkouzano7keta = new ExDBFieldString<>("zrnkouzano7keta", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkzhurikaebankcd = new ExDBFieldString<>("zrnkzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkzhurikaesitencd = new ExDBFieldString<>("zrnkzhurikaesitencd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkanyuusyaknrno = new ExDBFieldString<>("zrnkanyuusyaknrno", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkyksiboumeighnkhyj = new ExDBFieldString<>("zrnkyksiboumeighnkhyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnyobiv11 = new ExDBFieldString<>("zrnyobiv11", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmnkuktkbn = new ExDBFieldString<>("zrnmnkuktkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmnkuktnm1 = new ExDBFieldString<>("zrnmnkuktnm1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmnkuktnm2 = new ExDBFieldString<>("zrnmnkuktnm2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmnkuktnm3 = new ExDBFieldString<>("zrnmnkuktnm3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmnkuktnm4 = new ExDBFieldString<>("zrnmnkuktnm4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsbuktkbn = new ExDBFieldString<>("zrnsbuktkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsbuktnm1 = new ExDBFieldString<>("zrnsbuktnm1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsbuktnm2 = new ExDBFieldString<>("zrnsbuktnm2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsbuktnm3 = new ExDBFieldString<>("zrnsbuktnm3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsbuktnm4 = new ExDBFieldString<>("zrnsbuktnm4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnyobiv20x3 = new ExDBFieldString<>("zrnyobiv20x3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnsyoriymd = new ExDBFieldString<>("zrnsyoriymd", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnkykmfksnctrlkh = new ExDBFieldNumber<>("zrnkykmfksnctrlkh", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnmkhtoutatuymd = new ExDBFieldString<>("zrnmkhtoutatuymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkykhrkmtuuka = new ExDBFieldString<>("zrnkykhrkmtuuka", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoRn, Long> zrnkykhrkmgk = new ExDBFieldNumber<>("zrnkykhrkmgk", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnikkatubaraikbn = new ExDBFieldString<>("zrnikkatubaraikbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnikkatubaraikaisuu = new ExDBFieldString<>("zrnikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, BizNumber> zrntousyokykjiyennyknrate = new ExDBFieldString<>("zrntousyokykjiyennyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, BizNumber> zrnrendouritu = new ExDBFieldString<>("zrnrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, BizNumber> zrnteikishrritu = new ExDBFieldString<>("zrnteikishrritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkosyasbskttdkstartflg = new ExDBFieldString<>("zrnkosyasbskttdkstartflg", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkosyasbukthukusuflg = new ExDBFieldString<>("zrnkosyasbukthukusuflg", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkosyahhknsbymd = new ExDBFieldString<>("zrnkosyahhknsbymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkosyassksjyuriymd = new ExDBFieldString<>("zrnkosyassksjyuriymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkosyasshrkanryoymd = new ExDBFieldString<>("zrnkosyasshrkanryoymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkosyasbuktseiymd = new ExDBFieldString<>("zrnkosyasbuktseiymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkosyasbuktkjadr = new ExDBFieldString<>("zrnkosyasbuktkjadr", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnkosyasbukttelno = new ExDBFieldString<>("zrnkosyasbukttelno", this);

    public final ExDBFieldString<ZT_KydGWKykInfoRn, String> zrnyobiv252 = new ExDBFieldString<>("zrnyobiv252", this);
}
