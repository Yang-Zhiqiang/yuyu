package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_BosyuuDrtenHoyuuKykTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 募集代理店保有契約Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_BosyuuDrtenHoyuuKykTy extends AbstractExDBTable<ZT_BosyuuDrtenHoyuuKykTy> {

    public GenQZT_BosyuuDrtenHoyuuKykTy() {
        this("ZT_BosyuuDrtenHoyuuKykTy");
    }

    public GenQZT_BosyuuDrtenHoyuuKykTy(String pAlias) {
        super("ZT_BosyuuDrtenHoyuuKykTy", ZT_BosyuuDrtenHoyuuKykTy.class, pAlias);
    }

    public String ZT_BosyuuDrtenHoyuuKykTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydatasyurui = new ExDBFieldString<>("ztydatasyurui", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhknsyumoku = new ExDBFieldString<>("ztyhknsyumoku", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytyoubokbn = new ExDBFieldString<>("ztytyoubokbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyonosyuban = new ExDBFieldString<>("ztysyonosyuban", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhknsyurui2keta = new ExDBFieldString<>("ztyhknsyurui2keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhrkhuhukbn = new ExDBFieldString<>("ztyhrkhuhukbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyukinkbn = new ExDBFieldString<>("ztysyukinkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztybnkaisuu = new ExDBFieldString<>("ztybnkaisuu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykyouhocd = new ExDBFieldString<>("ztykyouhocd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydaibuncd = new ExDBFieldString<>("ztydaibuncd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydaibunkanjishare = new ExDBFieldString<>("ztydaibunkanjishare", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydntcd7keta = new ExDBFieldString<>("ztydntcd7keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyumokugrpkbn = new ExDBFieldString<>("ztysyumokugrpkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztygoukeipbsdirtnhykyk = new ExDBFieldString<>("ztygoukeipbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyyno7keta = new ExDBFieldString<>("ztyyno7keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysikiymd = new ExDBFieldString<>("ztysikiymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztymankiymd = new ExDBFieldString<>("ztymankiymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyidokaiyakuymd = new ExDBFieldString<>("ztyidokaiyakuymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztymusymd = new ExDBFieldString<>("ztymusymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyjikokykhyj = new ExDBFieldString<>("ztyjikokykhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztymeisaioyakokbn = new ExDBFieldString<>("ztymeisaioyakokbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykihontikucdkami3 = new ExDBFieldString<>("ztykihontikucdkami3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytelnobsdirtnhykyk = new ExDBFieldString<>("ztytelnobsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykyknmknbsdirtnhykyk = new ExDBFieldString<>("ztykyknmknbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztybnkyk1kaipbsdirtnhykyk = new ExDBFieldString<>("ztybnkyk1kaipbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztybnsyuruikbn = new ExDBFieldString<>("ztybnsyuruikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhrkymd = new ExDBFieldString<>("ztyhrkymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydntfsthrkym = new ExDBFieldString<>("ztydntfsthrkym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyfstpkzhurikbn = new ExDBFieldString<>("ztyfstpkzhurikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykeijyouym4keta = new ExDBFieldString<>("ztykeijyouym4keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhknkaisyacd = new ExDBFieldString<>("ztyhknkaisyacd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhhknnmknbsdirtnhykyk = new ExDBFieldString<>("ztyhhknnmknbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyknjhhknmei = new ExDBFieldString<>("ztyknjhhknmei", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhhknseiymd = new ExDBFieldString<>("ztyhhknseiymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhhknnenbsdirtnhykyk = new ExDBFieldString<>("ztyhhknnenbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhhknseikbn = new ExDBFieldString<>("ztyhhknseikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhhkntdk = new ExDBFieldString<>("ztyhhkntdk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhhknynobsdirtnhykyk = new ExDBFieldString<>("ztyhhknynobsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhhknadrkj50 = new ExDBFieldString<>("ztyhhknadrkj50", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhrkkeiro = new ExDBFieldString<>("ztyhrkkeiro", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyitijibrpbsdirtnhykyk = new ExDBFieldString<>("ztyitijibrpbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztynkshrkknkbn = new ExDBFieldString<>("ztynkshrkknkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztynkshrkknnen = new ExDBFieldString<>("ztynkshrkknnen", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztynkshrstartymd = new ExDBFieldString<>("ztynkshrstartymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytokutaiumu = new ExDBFieldString<>("ztytokutaiumu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytktyuutohuka = new ExDBFieldString<>("ztytktyuutohuka", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytksuu = new ExDBFieldString<>("ztytksuu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysinsakbn = new ExDBFieldString<>("ztysinsakbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyzeiseitekikaku = new ExDBFieldString<>("ztyzeiseitekikaku", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztylivingneeds = new ExDBFieldString<>("ztylivingneeds", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyknjsyuhsynm = new ExDBFieldString<>("ztyknjsyuhsynm", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyusbsdirtnhykyk = new ExDBFieldString<>("ztysyusbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyuhknkknkbn = new ExDBFieldString<>("ztysyuhknkknkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyuhknkkn = new ExDBFieldString<>("ztysyuhknkkn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyuhrkkknkbn = new ExDBFieldString<>("ztysyuhrkkknkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyuhrkkkn = new ExDBFieldString<>("ztysyuhrkkkn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykjtkhosyunm1 = new ExDBFieldString<>("ztykjtkhosyunm1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytks1bsdirtnhykyk = new ExDBFieldString<>("ztytks1bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkknkbn1 = new ExDBFieldString<>("ztytkhknkknkbn1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkkn1 = new ExDBFieldString<>("ztytkhknkkn1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkknkbn1 = new ExDBFieldString<>("ztytkhrkkknkbn1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkkn1 = new ExDBFieldString<>("ztytkhrkkkn1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykjtkhosyunm2 = new ExDBFieldString<>("ztykjtkhosyunm2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytks2bsdirtnhykyk = new ExDBFieldString<>("ztytks2bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkknkbn2 = new ExDBFieldString<>("ztytkhknkknkbn2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkkn2 = new ExDBFieldString<>("ztytkhknkkn2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkknkbn2 = new ExDBFieldString<>("ztytkhrkkknkbn2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkkn2 = new ExDBFieldString<>("ztytkhrkkkn2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykjtkhosyunm3 = new ExDBFieldString<>("ztykjtkhosyunm3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytks3bsdirtnhykyk = new ExDBFieldString<>("ztytks3bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkknkbn3 = new ExDBFieldString<>("ztytkhknkknkbn3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkkn3 = new ExDBFieldString<>("ztytkhknkkn3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkknkbn3 = new ExDBFieldString<>("ztytkhrkkknkbn3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkkn3 = new ExDBFieldString<>("ztytkhrkkkn3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykjtkhosyunm4 = new ExDBFieldString<>("ztykjtkhosyunm4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytks4bsdirtnhykyk = new ExDBFieldString<>("ztytks4bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkknkbn4 = new ExDBFieldString<>("ztytkhknkknkbn4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkkn4 = new ExDBFieldString<>("ztytkhknkkn4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkknkbn4 = new ExDBFieldString<>("ztytkhrkkknkbn4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkkn4 = new ExDBFieldString<>("ztytkhrkkkn4", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykjtkhosyunm5 = new ExDBFieldString<>("ztykjtkhosyunm5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytks5bsdirtnhykyk = new ExDBFieldString<>("ztytks5bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkknkbn5 = new ExDBFieldString<>("ztytkhknkknkbn5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkkn5 = new ExDBFieldString<>("ztytkhknkkn5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkknkbn5 = new ExDBFieldString<>("ztytkhrkkknkbn5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkkn5 = new ExDBFieldString<>("ztytkhrkkkn5", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykjtkhosyunm6 = new ExDBFieldString<>("ztykjtkhosyunm6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytks6bsdirtnhykyk = new ExDBFieldString<>("ztytks6bsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkknkbn6 = new ExDBFieldString<>("ztytkhknkknkbn6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhknkkn6 = new ExDBFieldString<>("ztytkhknkkn6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkknkbn6 = new ExDBFieldString<>("ztytkhrkkknkbn6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkhrkkkn6 = new ExDBFieldString<>("ztytkhrkkkn6", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydatasyubetucd = new ExDBFieldString<>("ztydatasyubetucd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhjnkojinkbn = new ExDBFieldString<>("ztyhjnkojinkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykykadrkj50 = new ExDBFieldString<>("ztykykadrkj50", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykyknmkjbsdirtnhykyk = new ExDBFieldString<>("ztykyknmkjbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykyksyaseiymd = new ExDBFieldString<>("ztykyksyaseiymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysakuseiym = new ExDBFieldString<>("ztysakuseiym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydairitencd = new ExDBFieldString<>("ztydairitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydairitenkanrisskcd = new ExDBFieldString<>("ztydairitenkanrisskcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztybosyuunincd = new ExDBFieldString<>("ztybosyuunincd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztybosyuunm = new ExDBFieldString<>("ztybosyuunm", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztybosyuujtkbn = new ExDBFieldString<>("ztybosyuujtkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydairitenkbtinfo1 = new ExDBFieldString<>("ztydairitenkbtinfo1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydairitenkbtinfo2 = new ExDBFieldString<>("ztydairitenkbtinfo2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydairitenkbtinfo3 = new ExDBFieldString<>("ztydairitenkbtinfo3", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyouhinbunruikbn = new ExDBFieldString<>("ztysyouhinbunruikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhknnmcd = new ExDBFieldString<>("ztyhknnmcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykykjyutikbn = new ExDBFieldString<>("ztykykjyutikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytkbthsyukiknmanryouym = new ExDBFieldString<>("ztytkbthsyukiknmanryouym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyldownym = new ExDBFieldString<>("ztyldownym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhrkmanryouym = new ExDBFieldString<>("ztyhrkmanryouym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztymrtiksnym = new ExDBFieldString<>("ztymrtiksnym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhaneikykhyj = new ExDBFieldString<>("ztyhaneikykhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyzenzeikyohyj = new ExDBFieldString<>("ztyzenzeikyohyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysikijikbn = new ExDBFieldString<>("ztysikijikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysbuktdisphukusuhyj = new ExDBFieldString<>("ztysbuktdisphukusuhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysbuktnmbsdirtnhykyk = new ExDBFieldString<>("ztysbuktnmbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztymnkuktdisphukusuhyj = new ExDBFieldString<>("ztymnkuktdisphukusuhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztymnkuktnmbsdirtnhykyk = new ExDBFieldString<>("ztymnkuktnmbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytodouhukencd = new ExDBFieldString<>("ztytodouhukencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztybankcd = new ExDBFieldString<>("ztybankcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyshitencd = new ExDBFieldString<>("ztyshitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyyokinkbn = new ExDBFieldString<>("ztyyokinkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykouzano7keta = new ExDBFieldString<>("ztykouzano7keta", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyalcardkbn = new ExDBFieldString<>("ztyalcardkbn", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztysibous = new ExDBFieldNumber<>("ztysibous", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztysgsbs = new ExDBFieldNumber<>("ztysgsbs", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysgwrmstksbsdirtnhykyk = new ExDBFieldString<>("ztysgwrmstksbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyougaitkkatakbn = new ExDBFieldString<>("ztysyougaitkkatakbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyougaitksbsdirtnhykyk = new ExDBFieldString<>("ztysyougaitksbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyreguardtksbsdirtnhykyk = new ExDBFieldString<>("ztyreguardtksbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyreguardtkkbn = new ExDBFieldString<>("ztyreguardtkkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyvreguardtksbsdirtnhykyk = new ExDBFieldString<>("ztyvreguardtksbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykzkmrthgukatakbn = new ExDBFieldString<>("ztykzkmrthgukatakbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykzkmrthgusbsdirtnhykyk = new ExDBFieldString<>("ztykzkmrthgusbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykzkmrtkosbsdirtnhykyk = new ExDBFieldString<>("ztykzkmrtkosbsdirtnhykyk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykaneeztkarihyj = new ExDBFieldString<>("ztykaneeztkarihyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydrtenkinyuucd = new ExDBFieldString<>("ztydrtenkinyuucd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydrtensitencd = new ExDBFieldString<>("ztydrtensitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztystjmkbn = new ExDBFieldString<>("ztystjmkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyokaiphrkkeiro = new ExDBFieldString<>("ztysyokaiphrkkeiro", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykanjidairitennm = new ExDBFieldString<>("ztykanjidairitennm", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztytsrybnwari = new ExDBFieldNumber<>("ztytsrybnwari", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztydrtenkeijyouym = new ExDBFieldString<>("ztydrtenkeijyouym", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykydatkidairitencd = new ExDBFieldString<>("ztykydatkidairitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztymdhnsyouhntsryshrkbn = new ExDBFieldString<>("ztymdhnsyouhntsryshrkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykyksyanen = new ExDBFieldString<>("ztykyksyanen", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztymdhnaisyoumeicd = new ExDBFieldString<>("ztymdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysyokaipryosyuymd = new ExDBFieldString<>("ztysyokaipryosyuymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysykgycd = new ExDBFieldString<>("ztysykgycd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, BizNumber> ztykaiyakuhrmkhritu = new ExDBFieldString<>("ztykaiyakuhrmkhritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytoutatukaiyakuhrmkhritu = new ExDBFieldString<>("ztytoutatukaiyakuhrmkhritu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykaiyakuhrmkhtoutatuymd = new ExDBFieldString<>("ztykaiyakuhrmkhtoutatuymd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztylivguardtkyks = new ExDBFieldString<>("ztylivguardtkyks", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztysiteituukaitijibrp = new ExDBFieldNumber<>("ztysiteituukaitijibrp", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztysiteituukasyus = new ExDBFieldNumber<>("ztysiteituukasyus", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztysiteituukasbs = new ExDBFieldNumber<>("ztysiteituukasbs", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztysiteituukasaigaisbs = new ExDBFieldNumber<>("ztysiteituukasaigaisbs", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztysiteituukacd = new ExDBFieldString<>("ztysiteituukacd", this);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztyhrktuukaitijibrp = new ExDBFieldNumber<>("ztyhrktuukaitijibrp", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyhrktuukacd = new ExDBFieldString<>("ztyhrktuukacd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, BizNumber> ztytumitateriritu = new ExDBFieldString<>("ztytumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, BizNumber> ztytmttknzoukaritujygn = new ExDBFieldString<>("ztytmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, BizNumber> ztysetteibairitu = new ExDBFieldString<>("ztysetteibairitu", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztytumitatekngk = new ExDBFieldNumber<>("ztytumitatekngk", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykjsbuktnm30 = new ExDBFieldString<>("ztykjsbuktnm30", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztymnkuktnm30 = new ExDBFieldString<>("ztymnkuktnm30", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykjkykdairinm = new ExDBFieldString<>("ztykjkykdairinm", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztykjsiteidairinm30 = new ExDBFieldString<>("ztykjsiteidairinm30", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytrkkzknmkj1 = new ExDBFieldString<>("ztytrkkzknmkj1", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytrkkzknmkj2 = new ExDBFieldString<>("ztytrkkzknmkj2", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyikkatubaraikbn = new ExDBFieldString<>("ztyikkatubaraikbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyikkatubaraikaisuu = new ExDBFieldString<>("ztyikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, BizNumber> ztyrendouritu = new ExDBFieldString<>("ztyrendouritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, BizNumber> ztyteikishrritu = new ExDBFieldString<>("ztyteikishrritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytikskzuktnmkj = new ExDBFieldString<>("ztytikskzuktnmkj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytikskzbankcd = new ExDBFieldString<>("ztytikskzbankcd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytikskzsitencd = new ExDBFieldString<>("ztytikskzsitencd", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytikskzyokinkbn = new ExDBFieldString<>("ztytikskzyokinkbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytikskzkouzano = new ExDBFieldString<>("ztytikskzkouzano", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztytikskzkzmeiginmkn = new ExDBFieldString<>("ztytikskzkzmeiginmkn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyteikishrkinshrtuukasyu = new ExDBFieldString<>("ztyteikishrkinshrtuukasyu", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztynnknsnpssyhknsyukigou = new ExDBFieldString<>("ztynnknsnpssyhknsyukigou", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztynnknsnpssyhknkkn = new ExDBFieldString<>("ztynnknsnpssyhknkkn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztynnknsnpssyphrkkikn = new ExDBFieldString<>("ztynnknsnpssyphrkkikn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztynnknsnpssysaimnkkykhyj = new ExDBFieldString<>("ztynnknsnpssysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztynknsnpssyhrkkskbn = new ExDBFieldString<>("ztynknsnpssyhrkkskbn", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztynnknsnpssyhhknnen = new ExDBFieldString<>("ztynnknsnpssyhhknnen", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, BizNumber> ztynnknsnpssyitijibrpkyktk = new ExDBFieldString<>("ztynnknsnpssyitijibrpkyktk", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztynnknsnpssysyup = new ExDBFieldNumber<>("ztynnknsnpssysyup", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, BizNumber> ztynnknsnpssykawaseraten5 = new ExDBFieldString<>("ztynnknsnpssykawaseraten5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_BosyuuDrtenHoyuuKykTy, Long> ztyzennoup = new ExDBFieldNumber<>("ztyzennoup", this);

    public final ExDBFieldString<ZT_BosyuuDrtenHoyuuKykTy, String> ztyyobiv25 = new ExDBFieldString<>("ztyyobiv25", this);
}
