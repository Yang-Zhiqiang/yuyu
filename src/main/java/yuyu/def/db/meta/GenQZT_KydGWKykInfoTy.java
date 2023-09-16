package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_KydGWKykInfoTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 共同ＧＷ用契約情報Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_KydGWKykInfoTy extends AbstractExDBTable<ZT_KydGWKykInfoTy> {

    public GenQZT_KydGWKykInfoTy() {
        this("ZT_KydGWKykInfoTy");
    }

    public GenQZT_KydGWKykInfoTy(String pAlias) {
        super("ZT_KydGWKykInfoTy", ZT_KydGWKykInfoTy.class, pAlias);
    }

    public String ZT_KydGWKykInfoTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhknsyurui2keta = new ExDBFieldString<>("ztyhknsyurui2keta", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysinkeizkkbn = new ExDBFieldString<>("ztysinkeizkkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyuhosyucd = new ExDBFieldString<>("ztysyuhosyucd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymdhnaisyoumeicd = new ExDBFieldString<>("ztymdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyouhncd = new ExDBFieldString<>("ztysyouhncd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymusymd = new ExDBFieldString<>("ztymusymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykykseirituymd = new ExDBFieldString<>("ztykykseirituymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysekininkaisiymd = new ExDBFieldString<>("ztysekininkaisiymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyokaipymd = new ExDBFieldString<>("ztysyokaipymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhjnkojinkbn = new ExDBFieldString<>("ztyhjnkojinkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhrkhuhukbn = new ExDBFieldString<>("ztyhrkhuhukbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhrkymd = new ExDBFieldString<>("ztyhrkymd", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztygoukeip2 = new ExDBFieldNumber<>("ztygoukeip2", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztyitijibrp = new ExDBFieldNumber<>("ztyitijibrp", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztybnkaisuu = new ExDBFieldString<>("ztybnkaisuu", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztybnsyuruikbn = new ExDBFieldString<>("ztybnsyuruikbn", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztybnkyk1kaip = new ExDBFieldNumber<>("ztybnkyk1kaip", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyyobiv20 = new ExDBFieldString<>("ztyyobiv20", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyuhknkknkbn = new ExDBFieldString<>("ztysyuhknkknkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyuhknkkn = new ExDBFieldString<>("ztysyuhknkkn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyuhrkkknkbn = new ExDBFieldString<>("ztysyuhrkkknkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyuhrkkkn = new ExDBFieldString<>("ztysyuhrkkkn", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztysyus = new ExDBFieldNumber<>("ztysyus", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyunm = new ExDBFieldString<>("ztysyunm", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyidojiyukbn = new ExDBFieldString<>("ztyidojiyukbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyoumetucd = new ExDBFieldString<>("ztysyoumetucd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyidokaiyakuymd = new ExDBFieldString<>("ztyidokaiyakuymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymankiymd = new ExDBFieldString<>("ztymankiymd", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztyidoukaiyakup = new ExDBFieldNumber<>("ztyidoukaiyakup", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyukinkbn = new ExDBFieldString<>("ztysyukinkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhaitoukbn = new ExDBFieldString<>("ztyhaitoukbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztycreditcardhrkbn = new ExDBFieldString<>("ztycreditcardhrkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkjykbn = new ExDBFieldString<>("ztytkjykbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysinsakbn = new ExDBFieldString<>("ztysinsakbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyzeiseitekikakuhyj = new ExDBFieldString<>("ztyzeiseitekikakuhyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztylivhukauhyj = new ExDBFieldString<>("ztylivhukauhyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhrizmentyouhyj = new ExDBFieldString<>("ztyhrizmentyouhyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykisokyknkshrhsykn = new ExDBFieldString<>("ztykisokyknkshrhsykn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztynkshrkknkbn = new ExDBFieldString<>("ztynkshrkknkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztynkshrkknnen = new ExDBFieldString<>("ztynkshrkknnen", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztynksueokikn = new ExDBFieldString<>("ztynksueokikn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztynkshrstartymd = new ExDBFieldString<>("ztynkshrstartymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztynkuketorininkbn = new ExDBFieldString<>("ztynkuketorininkbn", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztyzennoup = new ExDBFieldNumber<>("ztyzennoup", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyzennouendym = new ExDBFieldString<>("ztyzennouendym", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyteikaiyakuhrkn = new ExDBFieldString<>("ztyteikaiyakuhrkn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymosno = new ExDBFieldString<>("ztymosno", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytratkisyacd1 = new ExDBFieldString<>("ztytratkisyacd1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytratkisyacd2 = new ExDBFieldString<>("ztytratkisyacd2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztydairiten1cd = new ExDBFieldString<>("ztydairiten1cd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztydairiten2cd = new ExDBFieldString<>("ztydairiten2cd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztybsudirtnatkikeitaikbn = new ExDBFieldString<>("ztybsudirtnatkikeitaikbn", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztybsyudiritnatkiwari1 = new ExDBFieldNumber<>("ztybsyudiritnatkiwari1", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztybsyudiritnatkiwari2 = new ExDBFieldNumber<>("ztybsyudiritnatkiwari2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyyobiv20x2 = new ExDBFieldString<>("ztyyobiv20x2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytktyuutohukahyj = new ExDBFieldString<>("ztytktyuutohukahyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytksuu = new ExDBFieldString<>("ztytksuu", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhosyucd1 = new ExDBFieldString<>("ztytkhosyucd1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytknm1 = new ExDBFieldString<>("ztytknm1", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztytks1 = new ExDBFieldNumber<>("ztytks1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkknkbn1 = new ExDBFieldString<>("ztytkhknkknkbn1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkkn1 = new ExDBFieldString<>("ztytkhknkkn1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkknkbn1 = new ExDBFieldString<>("ztytkhrkkknkbn1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkkn1 = new ExDBFieldString<>("ztytkhrkkkn1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhosyucd2 = new ExDBFieldString<>("ztytkhosyucd2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytknm2 = new ExDBFieldString<>("ztytknm2", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztytks2 = new ExDBFieldNumber<>("ztytks2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkknkbn2 = new ExDBFieldString<>("ztytkhknkknkbn2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkkn2 = new ExDBFieldString<>("ztytkhknkkn2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkknkbn2 = new ExDBFieldString<>("ztytkhrkkknkbn2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkkn2 = new ExDBFieldString<>("ztytkhrkkkn2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhosyucd3 = new ExDBFieldString<>("ztytkhosyucd3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytknm3 = new ExDBFieldString<>("ztytknm3", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztytks3 = new ExDBFieldNumber<>("ztytks3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkknkbn3 = new ExDBFieldString<>("ztytkhknkknkbn3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkkn3 = new ExDBFieldString<>("ztytkhknkkn3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkknkbn3 = new ExDBFieldString<>("ztytkhrkkknkbn3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkkn3 = new ExDBFieldString<>("ztytkhrkkkn3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhosyucd4 = new ExDBFieldString<>("ztytkhosyucd4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytknm4 = new ExDBFieldString<>("ztytknm4", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztytks4 = new ExDBFieldNumber<>("ztytks4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkknkbn4 = new ExDBFieldString<>("ztytkhknkknkbn4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkkn4 = new ExDBFieldString<>("ztytkhknkkn4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkknkbn4 = new ExDBFieldString<>("ztytkhrkkknkbn4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkkn4 = new ExDBFieldString<>("ztytkhrkkkn4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhosyucd5 = new ExDBFieldString<>("ztytkhosyucd5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytknm5 = new ExDBFieldString<>("ztytknm5", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztytks5 = new ExDBFieldNumber<>("ztytks5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkknkbn5 = new ExDBFieldString<>("ztytkhknkknkbn5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkkn5 = new ExDBFieldString<>("ztytkhknkkn5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkknkbn5 = new ExDBFieldString<>("ztytkhrkkknkbn5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkkn5 = new ExDBFieldString<>("ztytkhrkkkn5", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhosyucd6 = new ExDBFieldString<>("ztytkhosyucd6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytknm6 = new ExDBFieldString<>("ztytknm6", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztytks6 = new ExDBFieldNumber<>("ztytks6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkknkbn6 = new ExDBFieldString<>("ztytkhknkknkbn6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhknkkn6 = new ExDBFieldString<>("ztytkhknkkn6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkknkbn6 = new ExDBFieldString<>("ztytkhrkkknkbn6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytkhrkkkn6 = new ExDBFieldString<>("ztytkhrkkkn6", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysbuktnm = new ExDBFieldString<>("ztysbuktnm", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykjsbuktnm = new ExDBFieldString<>("ztykjsbuktnm", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysbukttdk = new ExDBFieldString<>("ztysbukttdk", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysbuktnin = new ExDBFieldString<>("ztysbuktnin", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyyobiv28 = new ExDBFieldString<>("ztyyobiv28", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyyno7keta = new ExDBFieldString<>("ztyyno7keta", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytelnokydgw = new ExDBFieldString<>("ztytelnokydgw", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykyknmknkydgw = new ExDBFieldString<>("ztykyknmknkydgw", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykyksyaseiymd = new ExDBFieldString<>("ztykyksyaseiymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykyksyaseikbn = new ExDBFieldString<>("ztykyksyaseikbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztytsinkihontikucd = new ExDBFieldString<>("ztytsinkihontikucd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykykadrkj50 = new ExDBFieldString<>("ztykykadrkj50", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykyknmkjkydgw = new ExDBFieldString<>("ztykyknmkjkydgw", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhhknmei = new ExDBFieldString<>("ztyhhknmei", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhhknnmkj = new ExDBFieldString<>("ztyhhknnmkj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhhknnen = new ExDBFieldString<>("ztyhhknnen", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyhhkntdk = new ExDBFieldString<>("ztyhhkntdk", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykzsyurui = new ExDBFieldString<>("ztykzsyurui", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykouzano7keta = new ExDBFieldString<>("ztykouzano7keta", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykzhurikaebankcd = new ExDBFieldString<>("ztykzhurikaebankcd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykzhurikaesitencd = new ExDBFieldString<>("ztykzhurikaesitencd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykanyuusyaknrno = new ExDBFieldString<>("ztykanyuusyaknrno", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykyksiboumeighnkhyj = new ExDBFieldString<>("ztykyksiboumeighnkhyj", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyyobiv11 = new ExDBFieldString<>("ztyyobiv11", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymnkuktkbn = new ExDBFieldString<>("ztymnkuktkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymnkuktnm1 = new ExDBFieldString<>("ztymnkuktnm1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymnkuktnm2 = new ExDBFieldString<>("ztymnkuktnm2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymnkuktnm3 = new ExDBFieldString<>("ztymnkuktnm3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymnkuktnm4 = new ExDBFieldString<>("ztymnkuktnm4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysbuktkbn = new ExDBFieldString<>("ztysbuktkbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysbuktnm1 = new ExDBFieldString<>("ztysbuktnm1", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysbuktnm2 = new ExDBFieldString<>("ztysbuktnm2", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysbuktnm3 = new ExDBFieldString<>("ztysbuktnm3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysbuktnm4 = new ExDBFieldString<>("ztysbuktnm4", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyyobiv20x3 = new ExDBFieldString<>("ztyyobiv20x3", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztysyoriymd = new ExDBFieldString<>("ztysyoriymd", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztykykmfksnctrlkh = new ExDBFieldNumber<>("ztykykmfksnctrlkh", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztymkhtoutatuymd = new ExDBFieldString<>("ztymkhtoutatuymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykykhrkmtuuka = new ExDBFieldString<>("ztykykhrkmtuuka", this);

    public final ExDBFieldNumber<ZT_KydGWKykInfoTy, Long> ztykykhrkmgk = new ExDBFieldNumber<>("ztykykhrkmgk", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyikkatubaraikbn = new ExDBFieldString<>("ztyikkatubaraikbn", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyikkatubaraikaisuu = new ExDBFieldString<>("ztyikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, BizNumber> ztytousyokykjiyennyknrate = new ExDBFieldString<>("ztytousyokykjiyennyknrate", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, BizNumber> ztyteikishrritu = new ExDBFieldString<>("ztyteikishrritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykosyasbskttdkstartflg = new ExDBFieldString<>("ztykosyasbskttdkstartflg", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykosyasbukthukusuflg = new ExDBFieldString<>("ztykosyasbukthukusuflg", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykosyahhknsbymd = new ExDBFieldString<>("ztykosyahhknsbymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykosyassksjyuriymd = new ExDBFieldString<>("ztykosyassksjyuriymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykosyasshrkanryoymd = new ExDBFieldString<>("ztykosyasshrkanryoymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykosyasbuktseiymd = new ExDBFieldString<>("ztykosyasbuktseiymd", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykosyasbuktkjadr = new ExDBFieldString<>("ztykosyasbuktkjadr", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztykosyasbukttelno = new ExDBFieldString<>("ztykosyasbukttelno", this);

    public final ExDBFieldString<ZT_KydGWKykInfoTy, String> ztyyobiv252 = new ExDBFieldString<>("ztyyobiv252", this);
}
