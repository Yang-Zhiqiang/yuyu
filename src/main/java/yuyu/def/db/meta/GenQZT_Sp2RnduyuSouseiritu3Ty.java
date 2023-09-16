package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu3Ty;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＳＰ２連動用総成立Fテーブル３（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Sp2RnduyuSouseiritu3Ty extends AbstractExDBTable<ZT_Sp2RnduyuSouseiritu3Ty> {

    public GenQZT_Sp2RnduyuSouseiritu3Ty() {
        this("ZT_Sp2RnduyuSouseiritu3Ty");
    }

    public GenQZT_Sp2RnduyuSouseiritu3Ty(String pAlias) {
        super("ZT_Sp2RnduyuSouseiritu3Ty", ZT_Sp2RnduyuSouseiritu3Ty.class, pAlias);
    }

    public String ZT_Sp2RnduyuSouseiritu3Ty() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyktgysyrymd = new ExDBFieldString<>("ztyktgysyrymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyktgysyono = new ExDBFieldString<>("ztyktgysyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyktgyfilerenno = new ExDBFieldString<>("ztyktgyfilerenno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztybosyuukeirokbn = new ExDBFieldString<>("ztybosyuukeirokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysyokaipcashlessnyukinhyj = new ExDBFieldString<>("ztysyokaipcashlessnyukinhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigkyhsitihsyutkykarihyj = new ExDBFieldString<>("ztykigkyhsitihsyutkykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysyokaipswingriyoukbn = new ExDBFieldString<>("ztysyokaipswingriyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysknjyututkykkykkbn = new ExDBFieldString<>("ztysknjyututkykkykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztybosyuudairitengyousyukbn = new ExDBFieldString<>("ztybosyuudairitengyousyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytokusyujimutoriatukaikbn = new ExDBFieldString<>("ztytokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztypmentkykyutktbicdx1 = new ExDBFieldString<>("ztypmentkykyutktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztypmentkykyuhtnpkknx1 = new ExDBFieldString<>("ztypmentkykyuhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztypmentkykyutktbicdx2 = new ExDBFieldString<>("ztypmentkykyutktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztypmentkykyuhtnpkknx2 = new ExDBFieldString<>("ztypmentkykyuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhosyouikkatumnoshyouji = new ExDBFieldString<>("ztyhosyouikkatumnoshyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhsyuikktminaosikaisu = new ExDBFieldString<>("ztyhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhsyuikktmnosdfnyuknhyj = new ExDBFieldString<>("ztyhsyuikktmnosdfnyuknhyj", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztyikktmnoskikiyutkykp = new ExDBFieldNumber<>("ztyikktmnoskikiyutkykp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztyikktmnoskikiyufndsistp = new ExDBFieldNumber<>("ztyikktmnoskikiyufndsistp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, BizNumber> ztysknnjynbknsisnrt = new ExDBFieldString<>("ztysknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykanyujisyono = new ExDBFieldString<>("ztykanyujisyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykanyujikykymd = new ExDBFieldString<>("ztykanyujikykymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykanyuujihihokensyaage = new ExDBFieldString<>("ztykanyuujihihokensyaage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykanyuujitenkanhyouji = new ExDBFieldString<>("ztykanyuujitenkanhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyksnyuhsyuikktminosnnskbn = new ExDBFieldString<>("ztyksnyuhsyuikktminosnnskbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyaatukaisyadirtnbsynnhyj = new ExDBFieldString<>("ztyaatukaisyadirtnbsynnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztybatkisyadirtnbosyuninhyj = new ExDBFieldString<>("ztybatkisyadirtnbosyuninhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydirtnaatukaisyakojincd = new ExDBFieldString<>("ztydirtnaatukaisyakojincd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydirtnbatukaisyakojincd = new ExDBFieldString<>("ztydirtnbatukaisyakojincd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysyuuseisyoukeikanensuu = new ExDBFieldString<>("ztysyuuseisyoukeikanensuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysyuruihnkutkbttrtkhyj = new ExDBFieldString<>("ztysyuruihnkutkbttrtkhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztybnktmekyktkykhkjyutikbn = new ExDBFieldString<>("ztybnktmekyktkykhkjyutikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykykjiqpackhyj = new ExDBFieldString<>("ztykykjiqpackhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytnknsyokaipclessriyouhyj = new ExDBFieldString<>("ztytnknsyokaipclessriyouhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhrkteisikibouhyouji = new ExDBFieldString<>("ztyhrkteisikibouhyouji", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztybunkatugosonzokukeiyakus = new ExDBFieldNumber<>("ztybunkatugosonzokukeiyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztymoskizkphrkekngk = new ExDBFieldNumber<>("ztymoskizkphrkekngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztykeizokuphurikaejijikaip = new ExDBFieldNumber<>("ztykeizokuphurikaejijikaip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztybnktmekyksyono = new ExDBFieldString<>("ztybnktmekyksyono", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztybunkatumaekeiyakukihons = new ExDBFieldNumber<>("ztybunkatumaekeiyakukihons", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztybunkatumaekeiyakusibous = new ExDBFieldNumber<>("ztybunkatumaekeiyakusibous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztybnktmekykmods = new ExDBFieldNumber<>("ztybnktmekykmods", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztybnktmekyksigiwrmstkyks = new ExDBFieldNumber<>("ztybnktmekyksigiwrmstkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztybnktmekyksyugitkyks = new ExDBFieldNumber<>("ztybnktmekyksyugitkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Integer> ztybnktmkyksiginyintkykntgk = new ExDBFieldNumber<>("ztybnktmkyksiginyintkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Integer> ztybnktmekykknkutkykntgk = new ExDBFieldNumber<>("ztybnktmekykknkutkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztybnktmekykhntiyunbriknsnp = new ExDBFieldNumber<>("ztybnktmekykhntiyunbriknsnp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztydai2naibuwarimodosigaku = new ExDBFieldNumber<>("ztydai2naibuwarimodosigaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztytnkngkykkstkgk = new ExDBFieldNumber<>("ztytnkngkykkstkgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztybnktmekykkstkgk = new ExDBFieldNumber<>("ztybnktmekykkstkgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztysonzokukykkasitukegk = new ExDBFieldNumber<>("ztysonzokukykkasitukegk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztyhngkmnryoujsitihsyukngk = new ExDBFieldNumber<>("ztyhngkmnryoujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Ty, Long> ztyhngksitihsyuyusykykp = new ExDBFieldNumber<>("ztyhngksitihsyuyusykykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx1x1 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx1x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx2x1 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx3x1 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx3x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx4x1 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx4x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx5x1 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx5x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx1x2 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx2x2 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx3x2 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx4x2 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx4x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx5x2 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx5x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx1x3 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx2x3 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx3x3 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx4x3 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx4x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx5x3 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx5x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx1x4 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx1x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx2x4 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx3x4 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx3x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx4x4 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx4x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx5x4 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx5x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx1x5 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx1x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx2x5 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx3x5 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx3x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx4x5 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx4x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx5x5 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx5x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx1x6 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx1x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx2x6 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx2x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx3x6 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx3x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx4x6 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx4x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhtnknkigmrsyukguybx5x6 = new ExDBFieldString<>("ztyhtnknkigmrsyukguybx5x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyyobiv1x3 = new ExDBFieldString<>("ztyyobiv1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x11 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x12 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x13 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x14 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi1x15 = new ExDBFieldString<>("ztyhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi2x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x1 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x2 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x3 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x4 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x5 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x6 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x7 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x8 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x9 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyhokensyuruikigouyobi3x10 = new ExDBFieldString<>("ztyhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruteikigouyobix1 = new ExDBFieldString<>("ztymaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruteikigouyobix2 = new ExDBFieldString<>("ztymaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruteikigouyobix3 = new ExDBFieldString<>("ztymaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruteikigouyobix4 = new ExDBFieldString<>("ztymaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruteikigouyobix5 = new ExDBFieldString<>("ztymaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruyoukigouyobix1 = new ExDBFieldString<>("ztymaruyoukigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruyoukigouyobix2 = new ExDBFieldString<>("ztymaruyoukigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruyoukigouyobix3 = new ExDBFieldString<>("ztymaruyoukigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruyoukigouyobix4 = new ExDBFieldString<>("ztymaruyoukigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymaruyoukigouyobix5 = new ExDBFieldString<>("ztymaruyoukigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymarusyuukigouyobix1 = new ExDBFieldString<>("ztymarusyuukigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymarusyuukigouyobix2 = new ExDBFieldString<>("ztymarusyuukigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymarusyuukigouyobix3 = new ExDBFieldString<>("ztymarusyuukigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymarusyuukigouyobix4 = new ExDBFieldString<>("ztymarusyuukigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymarusyuukigouyobix5 = new ExDBFieldString<>("ztymarusyuukigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytokuteikigouyobix1 = new ExDBFieldString<>("ztytokuteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytokuteikigouyobix2 = new ExDBFieldString<>("ztytokuteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytokuteikigouyobix3 = new ExDBFieldString<>("ztytokuteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytokuteikigouyobix4 = new ExDBFieldString<>("ztytokuteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytokuteikigouyobix5 = new ExDBFieldString<>("ztytokuteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x1 = new ExDBFieldString<>("ztykzkmrtikguybx1x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x1 = new ExDBFieldString<>("ztykzkmrtikguybx2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x1 = new ExDBFieldString<>("ztykzkmrtikguybx3x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x1 = new ExDBFieldString<>("ztykzkmrtikguybx4x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x1 = new ExDBFieldString<>("ztykzkmrtikguybx5x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x2 = new ExDBFieldString<>("ztykzkmrtikguybx1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x2 = new ExDBFieldString<>("ztykzkmrtikguybx2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x2 = new ExDBFieldString<>("ztykzkmrtikguybx3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x2 = new ExDBFieldString<>("ztykzkmrtikguybx4x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x2 = new ExDBFieldString<>("ztykzkmrtikguybx5x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x3 = new ExDBFieldString<>("ztykzkmrtikguybx1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x3 = new ExDBFieldString<>("ztykzkmrtikguybx2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x3 = new ExDBFieldString<>("ztykzkmrtikguybx3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x3 = new ExDBFieldString<>("ztykzkmrtikguybx4x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x3 = new ExDBFieldString<>("ztykzkmrtikguybx5x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x4 = new ExDBFieldString<>("ztykzkmrtikguybx1x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x4 = new ExDBFieldString<>("ztykzkmrtikguybx2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x4 = new ExDBFieldString<>("ztykzkmrtikguybx3x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x4 = new ExDBFieldString<>("ztykzkmrtikguybx4x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x4 = new ExDBFieldString<>("ztykzkmrtikguybx5x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x5 = new ExDBFieldString<>("ztykzkmrtikguybx1x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x5 = new ExDBFieldString<>("ztykzkmrtikguybx2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x5 = new ExDBFieldString<>("ztykzkmrtikguybx3x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x5 = new ExDBFieldString<>("ztykzkmrtikguybx4x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x5 = new ExDBFieldString<>("ztykzkmrtikguybx5x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x6 = new ExDBFieldString<>("ztykzkmrtikguybx1x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x6 = new ExDBFieldString<>("ztykzkmrtikguybx2x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x6 = new ExDBFieldString<>("ztykzkmrtikguybx3x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x6 = new ExDBFieldString<>("ztykzkmrtikguybx4x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x6 = new ExDBFieldString<>("ztykzkmrtikguybx5x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x7 = new ExDBFieldString<>("ztykzkmrtikguybx1x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x7 = new ExDBFieldString<>("ztykzkmrtikguybx2x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x7 = new ExDBFieldString<>("ztykzkmrtikguybx3x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x7 = new ExDBFieldString<>("ztykzkmrtikguybx4x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x7 = new ExDBFieldString<>("ztykzkmrtikguybx5x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x8 = new ExDBFieldString<>("ztykzkmrtikguybx1x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x8 = new ExDBFieldString<>("ztykzkmrtikguybx2x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x8 = new ExDBFieldString<>("ztykzkmrtikguybx3x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x8 = new ExDBFieldString<>("ztykzkmrtikguybx4x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x8 = new ExDBFieldString<>("ztykzkmrtikguybx5x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x9 = new ExDBFieldString<>("ztykzkmrtikguybx1x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x9 = new ExDBFieldString<>("ztykzkmrtikguybx2x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x9 = new ExDBFieldString<>("ztykzkmrtikguybx3x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x9 = new ExDBFieldString<>("ztykzkmrtikguybx4x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x9 = new ExDBFieldString<>("ztykzkmrtikguybx5x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx1x10 = new ExDBFieldString<>("ztykzkmrtikguybx1x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx2x10 = new ExDBFieldString<>("ztykzkmrtikguybx2x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx3x10 = new ExDBFieldString<>("ztykzkmrtikguybx3x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx4x10 = new ExDBFieldString<>("ztykzkmrtikguybx4x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkmrtikguybx5x10 = new ExDBFieldString<>("ztykzkmrtikguybx5x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysyugittkykkguybx1 = new ExDBFieldString<>("ztysyugittkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysyugittkykkguybx2 = new ExDBFieldString<>("ztysyugittkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysyugittkykkguybx3 = new ExDBFieldString<>("ztysyugittkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysyugittkykkguybx4 = new ExDBFieldString<>("ztysyugittkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysyugittkykkguybx5 = new ExDBFieldString<>("ztysyugittkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysigiwrmstkykkguybx1 = new ExDBFieldString<>("ztysigiwrmstkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysigiwrmstkykkguybx2 = new ExDBFieldString<>("ztysigiwrmstkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysigiwrmstkykkguybx3 = new ExDBFieldString<>("ztysigiwrmstkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysigiwrmstkykkguybx4 = new ExDBFieldString<>("ztysigiwrmstkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysigiwrmstkykkguybx5 = new ExDBFieldString<>("ztysigiwrmstkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiginyuintkykkguybx1 = new ExDBFieldString<>("ztysiginyuintkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiginyuintkykkguybx2 = new ExDBFieldString<>("ztysiginyuintkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiginyuintkykkguybx3 = new ExDBFieldString<>("ztysiginyuintkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiginyuintkykkguybx4 = new ExDBFieldString<>("ztysiginyuintkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiginyuintkykkguybx5 = new ExDBFieldString<>("ztysiginyuintkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysppinyuintkykkguybx1 = new ExDBFieldString<>("ztysppinyuintkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysppinyuintkykkguybx2 = new ExDBFieldString<>("ztysppinyuintkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysppinyuintkykkguybx3 = new ExDBFieldString<>("ztysppinyuintkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysppinyuintkykkguybx4 = new ExDBFieldString<>("ztysppinyuintkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysppinyuintkykkguybx5 = new ExDBFieldString<>("ztysppinyuintkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysijnbyutkykkguybx1 = new ExDBFieldString<>("ztysijnbyutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysijnbyutkykkguybx2 = new ExDBFieldString<>("ztysijnbyutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysijnbyutkykkguybx3 = new ExDBFieldString<>("ztysijnbyutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysijnbyutkykkguybx4 = new ExDBFieldString<>("ztysijnbyutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysijnbyutkykkguybx5 = new ExDBFieldString<>("ztysijnbyutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkiryoutkykkguybx1 = new ExDBFieldString<>("ztykzkiryoutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkiryoutkykkguybx2 = new ExDBFieldString<>("ztykzkiryoutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkiryoutkykkguybx3 = new ExDBFieldString<>("ztykzkiryoutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkiryoutkykkguybx4 = new ExDBFieldString<>("ztykzkiryoutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykzkiryoutkykkguybx5 = new ExDBFieldString<>("ztykzkiryoutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysykkyuhtkykkguybx1 = new ExDBFieldString<>("ztysykkyuhtkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysykkyuhtkykkguybx2 = new ExDBFieldString<>("ztysykkyuhtkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysykkyuhtkykkguybx3 = new ExDBFieldString<>("ztysykkyuhtkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysykkyuhtkykkguybx4 = new ExDBFieldString<>("ztysykkyuhtkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysykkyuhtkykkguybx5 = new ExDBFieldString<>("ztysykkyuhtkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdtmrtikguyobix1 = new ExDBFieldString<>("ztynkdtmrtikguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdtmrtikguyobix2 = new ExDBFieldString<>("ztynkdtmrtikguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdtmrtikguyobix3 = new ExDBFieldString<>("ztynkdtmrtikguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdtmrtikguyobix4 = new ExDBFieldString<>("ztynkdtmrtikguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdtmrtikguyobix5 = new ExDBFieldString<>("ztynkdtmrtikguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdatetokuteikguyobix1 = new ExDBFieldString<>("ztynkdatetokuteikguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdatetokuteikguyobix2 = new ExDBFieldString<>("ztynkdatetokuteikguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdatetokuteikguyobix3 = new ExDBFieldString<>("ztynkdatetokuteikguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdatetokuteikguyobix4 = new ExDBFieldString<>("ztynkdatetokuteikguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztynkdatetokuteikguyobix5 = new ExDBFieldString<>("ztynkdatetokuteikguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdtmrtikguyobix1 = new ExDBFieldString<>("ztykaigonkdtmrtikguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdtmrtikguyobix2 = new ExDBFieldString<>("ztykaigonkdtmrtikguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdtmrtikguyobix3 = new ExDBFieldString<>("ztykaigonkdtmrtikguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdtmrtikguyobix4 = new ExDBFieldString<>("ztykaigonkdtmrtikguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdtmrtikguyobix5 = new ExDBFieldString<>("ztykaigonkdtmrtikguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdttktikguyobix1 = new ExDBFieldString<>("ztykaigonkdttktikguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdttktikguyobix2 = new ExDBFieldString<>("ztykaigonkdttktikguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdttktikguyobix3 = new ExDBFieldString<>("ztykaigonkdttktikguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdttktikguyobix4 = new ExDBFieldString<>("ztykaigonkdttktikguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonkdttktikguyobix5 = new ExDBFieldString<>("ztykaigonkdttktikguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigomaruteikigouyobix1 = new ExDBFieldString<>("ztykaigomaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigomaruteikigouyobix2 = new ExDBFieldString<>("ztykaigomaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigomaruteikigouyobix3 = new ExDBFieldString<>("ztykaigomaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigomaruteikigouyobix4 = new ExDBFieldString<>("ztykaigomaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigomaruteikigouyobix5 = new ExDBFieldString<>("ztykaigomaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigotokuteikigouyobix1 = new ExDBFieldString<>("ztykaigotokuteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigotokuteikigouyobix2 = new ExDBFieldString<>("ztykaigotokuteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigotokuteikigouyobix3 = new ExDBFieldString<>("ztykaigotokuteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigotokuteikigouyobix4 = new ExDBFieldString<>("ztykaigotokuteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigotokuteikigouyobix5 = new ExDBFieldString<>("ztykaigotokuteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiznmrtikguybx1 = new ExDBFieldString<>("ztysiznmrtikguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiznmrtikguybx2 = new ExDBFieldString<>("ztysiznmrtikguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiznmrtikguybx3 = new ExDBFieldString<>("ztysiznmrtikguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiznmrtikguybx4 = new ExDBFieldString<>("ztysiznmrtikguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysiznmrtikguybx5 = new ExDBFieldString<>("ztysiznmrtikguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigenmaruteikigouyobix1 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigenmaruteikigouyobix2 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigenmaruteikigouyobix3 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigenmaruteikigouyobix4 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigenmaruteikigouyobix5 = new ExDBFieldString<>("ztyteigenmaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigentokuteikigouyobix1 = new ExDBFieldString<>("ztyteigentokuteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigentokuteikigouyobix2 = new ExDBFieldString<>("ztyteigentokuteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigentokuteikigouyobix3 = new ExDBFieldString<>("ztyteigentokuteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigentokuteikigouyobix4 = new ExDBFieldString<>("ztyteigentokuteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyteigentokuteikigouyobix5 = new ExDBFieldString<>("ztyteigentokuteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtignmrtikguybx1 = new ExDBFieldString<>("ztykigtignmrtikguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtignmrtikguybx2 = new ExDBFieldString<>("ztykigtignmrtikguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtignmrtikguybx3 = new ExDBFieldString<>("ztykigtignmrtikguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtignmrtikguybx4 = new ExDBFieldString<>("ztykigtignmrtikguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtignmrtikguybx5 = new ExDBFieldString<>("ztykigtignmrtikguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtigntktikguybx1 = new ExDBFieldString<>("ztykigtigntktikguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtigntktikguybx2 = new ExDBFieldString<>("ztykigtigntktikguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtigntktikguybx3 = new ExDBFieldString<>("ztykigtigntktikguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtigntktikguybx4 = new ExDBFieldString<>("ztykigtigntktikguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykigtigntktikguybx5 = new ExDBFieldString<>("ztykigtigntktikguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytuuintokuyakukigouyobix1 = new ExDBFieldString<>("ztytuuintokuyakukigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytuuintokuyakukigouyobix2 = new ExDBFieldString<>("ztytuuintokuyakukigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytuuintokuyakukigouyobix3 = new ExDBFieldString<>("ztytuuintokuyakukigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytuuintokuyakukigouyobix4 = new ExDBFieldString<>("ztytuuintokuyakukigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytuuintokuyakukigouyobix5 = new ExDBFieldString<>("ztytuuintokuyakukigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyjysisppitkykkguyobix1 = new ExDBFieldString<>("ztyjysisppitkykkguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyjysisppitkykkguyobix2 = new ExDBFieldString<>("ztyjysisppitkykkguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyjysisppitkykkguyobix3 = new ExDBFieldString<>("ztyjysisppitkykkguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyjysisppitkykkguyobix4 = new ExDBFieldString<>("ztyjysisppitkykkguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyjysisppitkykkguyobix5 = new ExDBFieldString<>("ztyjysisppitkykkguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytksttkykkguybx1 = new ExDBFieldString<>("ztytksttkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytksttkykkguybx2 = new ExDBFieldString<>("ztytksttkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytksttkykkguybx3 = new ExDBFieldString<>("ztytksttkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytksttkykkguybx4 = new ExDBFieldString<>("ztytksttkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztytksttkykkguybx5 = new ExDBFieldString<>("ztytksttkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2tksttkykkguybx1 = new ExDBFieldString<>("ztydi2tksttkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2tksttkykkguybx2 = new ExDBFieldString<>("ztydi2tksttkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2tksttkykkguybx3 = new ExDBFieldString<>("ztydi2tksttkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2tksttkykkguybx4 = new ExDBFieldString<>("ztydi2tksttkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2tksttkykkguybx5 = new ExDBFieldString<>("ztydi2tksttkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymnsttkykkguybx1 = new ExDBFieldString<>("ztymnsttkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymnsttkykkguybx2 = new ExDBFieldString<>("ztymnsttkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymnsttkykkguybx3 = new ExDBFieldString<>("ztymnsttkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymnsttkykkguybx4 = new ExDBFieldString<>("ztymnsttkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztymnsttkykkguybx5 = new ExDBFieldString<>("ztymnsttkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2mnsttkykkguybx1 = new ExDBFieldString<>("ztydi2mnsttkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2mnsttkykkguybx2 = new ExDBFieldString<>("ztydi2mnsttkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2mnsttkykkguybx3 = new ExDBFieldString<>("ztydi2mnsttkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2mnsttkykkguybx4 = new ExDBFieldString<>("ztydi2mnsttkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2mnsttkykkguybx5 = new ExDBFieldString<>("ztydi2mnsttkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysugusnsyutkykkguybx1 = new ExDBFieldString<>("ztysugusnsyutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysugusnsyutkykkguybx2 = new ExDBFieldString<>("ztysugusnsyutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysugusnsyutkykkguybx3 = new ExDBFieldString<>("ztysugusnsyutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysugusnsyutkykkguybx4 = new ExDBFieldString<>("ztysugusnsyutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysugusnsyutkykkguybx5 = new ExDBFieldString<>("ztysugusnsyutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonktkykkguyobix1 = new ExDBFieldString<>("ztykaigonktkykkguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonktkykkguyobix2 = new ExDBFieldString<>("ztykaigonktkykkguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonktkykkguyobix3 = new ExDBFieldString<>("ztykaigonktkykkguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonktkykkguyobix4 = new ExDBFieldString<>("ztykaigonktkykkguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztykaigonktkykkguyobix5 = new ExDBFieldString<>("ztykaigonktkykkguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyitjbrkignktkykkguybx1 = new ExDBFieldString<>("ztyitjbrkignktkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyitjbrkignktkykkguybx2 = new ExDBFieldString<>("ztyitjbrkignktkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyitjbrkignktkykkguybx3 = new ExDBFieldString<>("ztyitjbrkignktkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyitjbrkignktkykkguybx4 = new ExDBFieldString<>("ztyitjbrkignktkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztyitjbrkignktkykkguybx5 = new ExDBFieldString<>("ztyitjbrkignktkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2syugitkykkguybx1 = new ExDBFieldString<>("ztydi2syugitkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2syugitkykkguybx2 = new ExDBFieldString<>("ztydi2syugitkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2syugitkykkguybx3 = new ExDBFieldString<>("ztydi2syugitkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2syugitkykkguybx4 = new ExDBFieldString<>("ztydi2syugitkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2syugitkykkguybx5 = new ExDBFieldString<>("ztydi2syugitkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sigiwrmstkykkguybx1 = new ExDBFieldString<>("ztydi2sigiwrmstkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sigiwrmstkykkguybx2 = new ExDBFieldString<>("ztydi2sigiwrmstkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sigiwrmstkykkguybx3 = new ExDBFieldString<>("ztydi2sigiwrmstkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sigiwrmstkykkguybx4 = new ExDBFieldString<>("ztydi2sigiwrmstkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sigiwrmstkykkguybx5 = new ExDBFieldString<>("ztydi2sigiwrmstkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2siginyuintkykkguybx1 = new ExDBFieldString<>("ztydi2siginyuintkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2siginyuintkykkguybx2 = new ExDBFieldString<>("ztydi2siginyuintkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2siginyuintkykkguybx3 = new ExDBFieldString<>("ztydi2siginyuintkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2siginyuintkykkguybx4 = new ExDBFieldString<>("ztydi2siginyuintkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2siginyuintkykkguybx5 = new ExDBFieldString<>("ztydi2siginyuintkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sppinyuintkykkguybx1 = new ExDBFieldString<>("ztydi2sppinyuintkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sppinyuintkykkguybx2 = new ExDBFieldString<>("ztydi2sppinyuintkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sppinyuintkykkguybx3 = new ExDBFieldString<>("ztydi2sppinyuintkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sppinyuintkykkguybx4 = new ExDBFieldString<>("ztydi2sppinyuintkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sppinyuintkykkguybx5 = new ExDBFieldString<>("ztydi2sppinyuintkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sijnbyutkykkguybx1 = new ExDBFieldString<>("ztydi2sijnbyutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sijnbyutkykkguybx2 = new ExDBFieldString<>("ztydi2sijnbyutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sijnbyutkykkguybx3 = new ExDBFieldString<>("ztydi2sijnbyutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sijnbyutkykkguybx4 = new ExDBFieldString<>("ztydi2sijnbyutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sijnbyutkykkguybx5 = new ExDBFieldString<>("ztydi2sijnbyutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydai2tuintkykkguyobix1 = new ExDBFieldString<>("ztydai2tuintkykkguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydai2tuintkykkguyobix2 = new ExDBFieldString<>("ztydai2tuintkykkguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydai2tuintkykkguyobix3 = new ExDBFieldString<>("ztydai2tuintkykkguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydai2tuintkykkguyobix4 = new ExDBFieldString<>("ztydai2tuintkykkguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydai2tuintkykkguyobix5 = new ExDBFieldString<>("ztydai2tuintkykkguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2jysisppitkykkguybx1 = new ExDBFieldString<>("ztydi2jysisppitkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2jysisppitkykkguybx2 = new ExDBFieldString<>("ztydi2jysisppitkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2jysisppitkykkguybx3 = new ExDBFieldString<>("ztydi2jysisppitkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2jysisppitkykkguybx4 = new ExDBFieldString<>("ztydi2jysisppitkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2jysisppitkykkguybx5 = new ExDBFieldString<>("ztydi2jysisppitkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sugusnsyutkykkguybx1 = new ExDBFieldString<>("ztydi2sugusnsyutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sugusnsyutkykkguybx2 = new ExDBFieldString<>("ztydi2sugusnsyutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sugusnsyutkykkguybx3 = new ExDBFieldString<>("ztydi2sugusnsyutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sugusnsyutkykkguybx4 = new ExDBFieldString<>("ztydi2sugusnsyutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sugusnsyutkykkguybx5 = new ExDBFieldString<>("ztydi2sugusnsyutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sykkyuhtkykkguybx1 = new ExDBFieldString<>("ztydi2sykkyuhtkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sykkyuhtkykkguybx2 = new ExDBFieldString<>("ztydi2sykkyuhtkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sykkyuhtkykkguybx3 = new ExDBFieldString<>("ztydi2sykkyuhtkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sykkyuhtkykkguybx4 = new ExDBFieldString<>("ztydi2sykkyuhtkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztydi2sykkyuhtkykkguybx5 = new ExDBFieldString<>("ztydi2sykkyuhtkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x1 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x2 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x3 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x4 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x5 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x6 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x7 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x8 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x9 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x10 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x11 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x11", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x12 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x12", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x13 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x13", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x14 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x14", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi1x15 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi1x15", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x1 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x2 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x3 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x4 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x5 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x6 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x7 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x8 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x9 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi2x10 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi2x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x1 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x2 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x3 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x4 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x5 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x6 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x7 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x8 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x9 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Ty, String> ztysetaitehknsyuruiyobi3x10 = new ExDBFieldString<>("ztysetaitehknsyuruiyobi3x10", this);
}
