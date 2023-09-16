package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu3Rn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * ＳＰ２連動用総成立Fテーブル３（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Sp2RnduyuSouseiritu3Rn extends AbstractExDBTable<ZT_Sp2RnduyuSouseiritu3Rn> {

    public GenQZT_Sp2RnduyuSouseiritu3Rn() {
        this("ZT_Sp2RnduyuSouseiritu3Rn");
    }

    public GenQZT_Sp2RnduyuSouseiritu3Rn(String pAlias) {
        super("ZT_Sp2RnduyuSouseiritu3Rn", ZT_Sp2RnduyuSouseiritu3Rn.class, pAlias);
    }

    public String ZT_Sp2RnduyuSouseiritu3Rn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnktgysyrymd = new ExDBFieldString<>("zrnktgysyrymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnktgysyono = new ExDBFieldString<>("zrnktgysyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnktgyfilerenno = new ExDBFieldString<>("zrnktgyfilerenno", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnbosyuukeirokbn = new ExDBFieldString<>("zrnbosyuukeirokbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsyokaipcashlessnyukinhyj = new ExDBFieldString<>("zrnsyokaipcashlessnyukinhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigkyhsitihsyutkykarihyj = new ExDBFieldString<>("zrnkigkyhsitihsyutkykarihyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsyokaipswingriyoukbn = new ExDBFieldString<>("zrnsyokaipswingriyoukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsknjyututkykkykkbn = new ExDBFieldString<>("zrnsknjyututkykkykkbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnbosyuudairitengyousyukbn = new ExDBFieldString<>("zrnbosyuudairitengyousyukbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntokusyujimutoriatukaikbn = new ExDBFieldString<>("zrntokusyujimutoriatukaikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnpmentkykyutktbicdx1 = new ExDBFieldString<>("zrnpmentkykyutktbicdx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnpmentkykyuhtnpkknx1 = new ExDBFieldString<>("zrnpmentkykyuhtnpkknx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnpmentkykyutktbicdx2 = new ExDBFieldString<>("zrnpmentkykyutktbicdx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnpmentkykyuhtnpkknx2 = new ExDBFieldString<>("zrnpmentkykyuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhosyouikkatumnoshyouji = new ExDBFieldString<>("zrnhosyouikkatumnoshyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhsyuikktminaosikaisu = new ExDBFieldString<>("zrnhsyuikktminaosikaisu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhsyuikktmnosdfnyuknhyj = new ExDBFieldString<>("zrnhsyuikktmnosdfnyuknhyj", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnikktmnoskikiyutkykp = new ExDBFieldNumber<>("zrnikktmnoskikiyutkykp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnikktmnoskikiyufndsistp = new ExDBFieldNumber<>("zrnikktmnoskikiyufndsistp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, BizNumber> zrnsknnjynbknsisnrt = new ExDBFieldString<>("zrnsknnjynbknsisnrt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkanyujisyono = new ExDBFieldString<>("zrnkanyujisyono", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkanyujikykymd = new ExDBFieldString<>("zrnkanyujikykymd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkanyuujihihokensyaage = new ExDBFieldString<>("zrnkanyuujihihokensyaage", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkanyuujitenkanhyouji = new ExDBFieldString<>("zrnkanyuujitenkanhyouji", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnksnyuhsyuikktminosnnskbn = new ExDBFieldString<>("zrnksnyuhsyuikktminosnnskbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnaatukaisyadirtnbsynnhyj = new ExDBFieldString<>("zrnaatukaisyadirtnbsynnhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnbatkisyadirtnbosyuninhyj = new ExDBFieldString<>("zrnbatkisyadirtnbosyuninhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndirtnaatukaisyakojincd = new ExDBFieldString<>("zrndirtnaatukaisyakojincd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndirtnbatukaisyakojincd = new ExDBFieldString<>("zrndirtnbatukaisyakojincd", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsyuuseisyoukeikanensuu = new ExDBFieldString<>("zrnsyuuseisyoukeikanensuu", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsyuruihnkutkbttrtkhyj = new ExDBFieldString<>("zrnsyuruihnkutkbttrtkhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnbnktmekyktkykhkjyutikbn = new ExDBFieldString<>("zrnbnktmekyktkykhkjyutikbn", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkykjiqpackhyj = new ExDBFieldString<>("zrnkykjiqpackhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntnknsyokaipclessriyouhyj = new ExDBFieldString<>("zrntnknsyokaipclessriyouhyj", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhrkteisikibouhyouji = new ExDBFieldString<>("zrnhrkteisikibouhyouji", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnbunkatugosonzokukeiyakus = new ExDBFieldNumber<>("zrnbunkatugosonzokukeiyakus", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnmoskizkphrkekngk = new ExDBFieldNumber<>("zrnmoskizkphrkekngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnkeizokuphurikaejijikaip = new ExDBFieldNumber<>("zrnkeizokuphurikaejijikaip", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnbnktmekyksyono = new ExDBFieldString<>("zrnbnktmekyksyono", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnbunkatumaekeiyakukihons = new ExDBFieldNumber<>("zrnbunkatumaekeiyakukihons", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnbunkatumaekeiyakusibous = new ExDBFieldNumber<>("zrnbunkatumaekeiyakusibous", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnbnktmekykmods = new ExDBFieldNumber<>("zrnbnktmekykmods", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnbnktmekyksigiwrmstkyks = new ExDBFieldNumber<>("zrnbnktmekyksigiwrmstkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnbnktmekyksyugitkyks = new ExDBFieldNumber<>("zrnbnktmekyksyugitkyks", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Integer> zrnbnktmkyksiginyintkykntgk = new ExDBFieldNumber<>("zrnbnktmkyksiginyintkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Integer> zrnbnktmekykknkutkykntgk = new ExDBFieldNumber<>("zrnbnktmekykknkutkykntgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnbnktmekykhntiyunbriknsnp = new ExDBFieldNumber<>("zrnbnktmekykhntiyunbriknsnp", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrndai2naibuwarimodosigaku = new ExDBFieldNumber<>("zrndai2naibuwarimodosigaku", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrntnkngkykkstkgk = new ExDBFieldNumber<>("zrntnkngkykkstkgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnbnktmekykkstkgk = new ExDBFieldNumber<>("zrnbnktmekykkstkgk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnsonzokukykkasitukegk = new ExDBFieldNumber<>("zrnsonzokukykkasitukegk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnhngkmnryoujsitihsyukngk = new ExDBFieldNumber<>("zrnhngkmnryoujsitihsyukngk", this);

    public final ExDBFieldNumber<ZT_Sp2RnduyuSouseiritu3Rn, Long> zrnhngksitihsyuyusykykp = new ExDBFieldNumber<>("zrnhngksitihsyuyusykykp", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx1x1 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx1x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx2x1 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx3x1 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx3x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx4x1 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx4x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx5x1 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx5x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx1x2 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx2x2 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx3x2 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx4x2 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx4x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx5x2 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx5x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx1x3 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx2x3 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx3x3 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx4x3 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx4x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx5x3 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx5x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx1x4 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx1x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx2x4 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx3x4 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx3x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx4x4 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx4x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx5x4 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx5x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx1x5 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx1x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx2x5 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx3x5 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx3x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx4x5 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx4x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx5x5 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx5x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx1x6 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx1x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx2x6 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx2x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx3x6 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx3x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx4x6 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx4x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhtnknkigmrsyukguybx5x6 = new ExDBFieldString<>("zrnhtnknkigmrsyukguybx5x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnyobiv1x3 = new ExDBFieldString<>("zrnyobiv1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x11 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x12 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x13 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x14 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi1x15 = new ExDBFieldString<>("zrnhokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi2x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x1 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x2 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x3 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x4 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x5 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x6 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x7 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x8 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x9 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnhokensyuruikigouyobi3x10 = new ExDBFieldString<>("zrnhokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruteikigouyobix1 = new ExDBFieldString<>("zrnmaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruteikigouyobix2 = new ExDBFieldString<>("zrnmaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruteikigouyobix3 = new ExDBFieldString<>("zrnmaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruteikigouyobix4 = new ExDBFieldString<>("zrnmaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruteikigouyobix5 = new ExDBFieldString<>("zrnmaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruyoukigouyobix1 = new ExDBFieldString<>("zrnmaruyoukigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruyoukigouyobix2 = new ExDBFieldString<>("zrnmaruyoukigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruyoukigouyobix3 = new ExDBFieldString<>("zrnmaruyoukigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruyoukigouyobix4 = new ExDBFieldString<>("zrnmaruyoukigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmaruyoukigouyobix5 = new ExDBFieldString<>("zrnmaruyoukigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmarusyuukigouyobix1 = new ExDBFieldString<>("zrnmarusyuukigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmarusyuukigouyobix2 = new ExDBFieldString<>("zrnmarusyuukigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmarusyuukigouyobix3 = new ExDBFieldString<>("zrnmarusyuukigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmarusyuukigouyobix4 = new ExDBFieldString<>("zrnmarusyuukigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmarusyuukigouyobix5 = new ExDBFieldString<>("zrnmarusyuukigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntokuteikigouyobix1 = new ExDBFieldString<>("zrntokuteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntokuteikigouyobix2 = new ExDBFieldString<>("zrntokuteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntokuteikigouyobix3 = new ExDBFieldString<>("zrntokuteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntokuteikigouyobix4 = new ExDBFieldString<>("zrntokuteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntokuteikigouyobix5 = new ExDBFieldString<>("zrntokuteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x1 = new ExDBFieldString<>("zrnkzkmrtikguybx1x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x1 = new ExDBFieldString<>("zrnkzkmrtikguybx2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x1 = new ExDBFieldString<>("zrnkzkmrtikguybx3x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x1 = new ExDBFieldString<>("zrnkzkmrtikguybx4x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x1 = new ExDBFieldString<>("zrnkzkmrtikguybx5x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x2 = new ExDBFieldString<>("zrnkzkmrtikguybx1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x2 = new ExDBFieldString<>("zrnkzkmrtikguybx2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x2 = new ExDBFieldString<>("zrnkzkmrtikguybx3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x2 = new ExDBFieldString<>("zrnkzkmrtikguybx4x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x2 = new ExDBFieldString<>("zrnkzkmrtikguybx5x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x3 = new ExDBFieldString<>("zrnkzkmrtikguybx1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x3 = new ExDBFieldString<>("zrnkzkmrtikguybx2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x3 = new ExDBFieldString<>("zrnkzkmrtikguybx3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x3 = new ExDBFieldString<>("zrnkzkmrtikguybx4x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x3 = new ExDBFieldString<>("zrnkzkmrtikguybx5x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x4 = new ExDBFieldString<>("zrnkzkmrtikguybx1x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x4 = new ExDBFieldString<>("zrnkzkmrtikguybx2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x4 = new ExDBFieldString<>("zrnkzkmrtikguybx3x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x4 = new ExDBFieldString<>("zrnkzkmrtikguybx4x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x4 = new ExDBFieldString<>("zrnkzkmrtikguybx5x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x5 = new ExDBFieldString<>("zrnkzkmrtikguybx1x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x5 = new ExDBFieldString<>("zrnkzkmrtikguybx2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x5 = new ExDBFieldString<>("zrnkzkmrtikguybx3x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x5 = new ExDBFieldString<>("zrnkzkmrtikguybx4x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x5 = new ExDBFieldString<>("zrnkzkmrtikguybx5x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x6 = new ExDBFieldString<>("zrnkzkmrtikguybx1x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x6 = new ExDBFieldString<>("zrnkzkmrtikguybx2x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x6 = new ExDBFieldString<>("zrnkzkmrtikguybx3x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x6 = new ExDBFieldString<>("zrnkzkmrtikguybx4x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x6 = new ExDBFieldString<>("zrnkzkmrtikguybx5x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x7 = new ExDBFieldString<>("zrnkzkmrtikguybx1x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x7 = new ExDBFieldString<>("zrnkzkmrtikguybx2x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x7 = new ExDBFieldString<>("zrnkzkmrtikguybx3x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x7 = new ExDBFieldString<>("zrnkzkmrtikguybx4x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x7 = new ExDBFieldString<>("zrnkzkmrtikguybx5x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x8 = new ExDBFieldString<>("zrnkzkmrtikguybx1x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x8 = new ExDBFieldString<>("zrnkzkmrtikguybx2x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x8 = new ExDBFieldString<>("zrnkzkmrtikguybx3x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x8 = new ExDBFieldString<>("zrnkzkmrtikguybx4x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x8 = new ExDBFieldString<>("zrnkzkmrtikguybx5x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x9 = new ExDBFieldString<>("zrnkzkmrtikguybx1x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x9 = new ExDBFieldString<>("zrnkzkmrtikguybx2x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x9 = new ExDBFieldString<>("zrnkzkmrtikguybx3x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x9 = new ExDBFieldString<>("zrnkzkmrtikguybx4x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x9 = new ExDBFieldString<>("zrnkzkmrtikguybx5x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx1x10 = new ExDBFieldString<>("zrnkzkmrtikguybx1x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx2x10 = new ExDBFieldString<>("zrnkzkmrtikguybx2x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx3x10 = new ExDBFieldString<>("zrnkzkmrtikguybx3x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx4x10 = new ExDBFieldString<>("zrnkzkmrtikguybx4x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkmrtikguybx5x10 = new ExDBFieldString<>("zrnkzkmrtikguybx5x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsyugittkykkguybx1 = new ExDBFieldString<>("zrnsyugittkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsyugittkykkguybx2 = new ExDBFieldString<>("zrnsyugittkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsyugittkykkguybx3 = new ExDBFieldString<>("zrnsyugittkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsyugittkykkguybx4 = new ExDBFieldString<>("zrnsyugittkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsyugittkykkguybx5 = new ExDBFieldString<>("zrnsyugittkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsigiwrmstkykkguybx1 = new ExDBFieldString<>("zrnsigiwrmstkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsigiwrmstkykkguybx2 = new ExDBFieldString<>("zrnsigiwrmstkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsigiwrmstkykkguybx3 = new ExDBFieldString<>("zrnsigiwrmstkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsigiwrmstkykkguybx4 = new ExDBFieldString<>("zrnsigiwrmstkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsigiwrmstkykkguybx5 = new ExDBFieldString<>("zrnsigiwrmstkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiginyuintkykkguybx1 = new ExDBFieldString<>("zrnsiginyuintkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiginyuintkykkguybx2 = new ExDBFieldString<>("zrnsiginyuintkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiginyuintkykkguybx3 = new ExDBFieldString<>("zrnsiginyuintkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiginyuintkykkguybx4 = new ExDBFieldString<>("zrnsiginyuintkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiginyuintkykkguybx5 = new ExDBFieldString<>("zrnsiginyuintkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsppinyuintkykkguybx1 = new ExDBFieldString<>("zrnsppinyuintkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsppinyuintkykkguybx2 = new ExDBFieldString<>("zrnsppinyuintkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsppinyuintkykkguybx3 = new ExDBFieldString<>("zrnsppinyuintkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsppinyuintkykkguybx4 = new ExDBFieldString<>("zrnsppinyuintkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsppinyuintkykkguybx5 = new ExDBFieldString<>("zrnsppinyuintkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsijnbyutkykkguybx1 = new ExDBFieldString<>("zrnsijnbyutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsijnbyutkykkguybx2 = new ExDBFieldString<>("zrnsijnbyutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsijnbyutkykkguybx3 = new ExDBFieldString<>("zrnsijnbyutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsijnbyutkykkguybx4 = new ExDBFieldString<>("zrnsijnbyutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsijnbyutkykkguybx5 = new ExDBFieldString<>("zrnsijnbyutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkiryoutkykkguybx1 = new ExDBFieldString<>("zrnkzkiryoutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkiryoutkykkguybx2 = new ExDBFieldString<>("zrnkzkiryoutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkiryoutkykkguybx3 = new ExDBFieldString<>("zrnkzkiryoutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkiryoutkykkguybx4 = new ExDBFieldString<>("zrnkzkiryoutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkzkiryoutkykkguybx5 = new ExDBFieldString<>("zrnkzkiryoutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsykkyuhtkykkguybx1 = new ExDBFieldString<>("zrnsykkyuhtkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsykkyuhtkykkguybx2 = new ExDBFieldString<>("zrnsykkyuhtkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsykkyuhtkykkguybx3 = new ExDBFieldString<>("zrnsykkyuhtkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsykkyuhtkykkguybx4 = new ExDBFieldString<>("zrnsykkyuhtkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsykkyuhtkykkguybx5 = new ExDBFieldString<>("zrnsykkyuhtkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdtmrtikguyobix1 = new ExDBFieldString<>("zrnnkdtmrtikguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdtmrtikguyobix2 = new ExDBFieldString<>("zrnnkdtmrtikguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdtmrtikguyobix3 = new ExDBFieldString<>("zrnnkdtmrtikguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdtmrtikguyobix4 = new ExDBFieldString<>("zrnnkdtmrtikguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdtmrtikguyobix5 = new ExDBFieldString<>("zrnnkdtmrtikguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdatetokuteikguyobix1 = new ExDBFieldString<>("zrnnkdatetokuteikguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdatetokuteikguyobix2 = new ExDBFieldString<>("zrnnkdatetokuteikguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdatetokuteikguyobix3 = new ExDBFieldString<>("zrnnkdatetokuteikguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdatetokuteikguyobix4 = new ExDBFieldString<>("zrnnkdatetokuteikguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnnkdatetokuteikguyobix5 = new ExDBFieldString<>("zrnnkdatetokuteikguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdtmrtikguyobix1 = new ExDBFieldString<>("zrnkaigonkdtmrtikguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdtmrtikguyobix2 = new ExDBFieldString<>("zrnkaigonkdtmrtikguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdtmrtikguyobix3 = new ExDBFieldString<>("zrnkaigonkdtmrtikguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdtmrtikguyobix4 = new ExDBFieldString<>("zrnkaigonkdtmrtikguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdtmrtikguyobix5 = new ExDBFieldString<>("zrnkaigonkdtmrtikguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdttktikguyobix1 = new ExDBFieldString<>("zrnkaigonkdttktikguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdttktikguyobix2 = new ExDBFieldString<>("zrnkaigonkdttktikguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdttktikguyobix3 = new ExDBFieldString<>("zrnkaigonkdttktikguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdttktikguyobix4 = new ExDBFieldString<>("zrnkaigonkdttktikguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonkdttktikguyobix5 = new ExDBFieldString<>("zrnkaigonkdttktikguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigomaruteikigouyobix1 = new ExDBFieldString<>("zrnkaigomaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigomaruteikigouyobix2 = new ExDBFieldString<>("zrnkaigomaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigomaruteikigouyobix3 = new ExDBFieldString<>("zrnkaigomaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigomaruteikigouyobix4 = new ExDBFieldString<>("zrnkaigomaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigomaruteikigouyobix5 = new ExDBFieldString<>("zrnkaigomaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigotokuteikigouyobix1 = new ExDBFieldString<>("zrnkaigotokuteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigotokuteikigouyobix2 = new ExDBFieldString<>("zrnkaigotokuteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigotokuteikigouyobix3 = new ExDBFieldString<>("zrnkaigotokuteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigotokuteikigouyobix4 = new ExDBFieldString<>("zrnkaigotokuteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigotokuteikigouyobix5 = new ExDBFieldString<>("zrnkaigotokuteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiznmrtikguybx1 = new ExDBFieldString<>("zrnsiznmrtikguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiznmrtikguybx2 = new ExDBFieldString<>("zrnsiznmrtikguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiznmrtikguybx3 = new ExDBFieldString<>("zrnsiznmrtikguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiznmrtikguybx4 = new ExDBFieldString<>("zrnsiznmrtikguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsiznmrtikguybx5 = new ExDBFieldString<>("zrnsiznmrtikguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigenmaruteikigouyobix1 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigenmaruteikigouyobix2 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigenmaruteikigouyobix3 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigenmaruteikigouyobix4 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigenmaruteikigouyobix5 = new ExDBFieldString<>("zrnteigenmaruteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigentokuteikigouyobix1 = new ExDBFieldString<>("zrnteigentokuteikigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigentokuteikigouyobix2 = new ExDBFieldString<>("zrnteigentokuteikigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigentokuteikigouyobix3 = new ExDBFieldString<>("zrnteigentokuteikigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigentokuteikigouyobix4 = new ExDBFieldString<>("zrnteigentokuteikigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnteigentokuteikigouyobix5 = new ExDBFieldString<>("zrnteigentokuteikigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtignmrtikguybx1 = new ExDBFieldString<>("zrnkigtignmrtikguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtignmrtikguybx2 = new ExDBFieldString<>("zrnkigtignmrtikguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtignmrtikguybx3 = new ExDBFieldString<>("zrnkigtignmrtikguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtignmrtikguybx4 = new ExDBFieldString<>("zrnkigtignmrtikguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtignmrtikguybx5 = new ExDBFieldString<>("zrnkigtignmrtikguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtigntktikguybx1 = new ExDBFieldString<>("zrnkigtigntktikguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtigntktikguybx2 = new ExDBFieldString<>("zrnkigtigntktikguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtigntktikguybx3 = new ExDBFieldString<>("zrnkigtigntktikguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtigntktikguybx4 = new ExDBFieldString<>("zrnkigtigntktikguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkigtigntktikguybx5 = new ExDBFieldString<>("zrnkigtigntktikguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntuuintokuyakukigouyobix1 = new ExDBFieldString<>("zrntuuintokuyakukigouyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntuuintokuyakukigouyobix2 = new ExDBFieldString<>("zrntuuintokuyakukigouyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntuuintokuyakukigouyobix3 = new ExDBFieldString<>("zrntuuintokuyakukigouyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntuuintokuyakukigouyobix4 = new ExDBFieldString<>("zrntuuintokuyakukigouyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntuuintokuyakukigouyobix5 = new ExDBFieldString<>("zrntuuintokuyakukigouyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnjysisppitkykkguyobix1 = new ExDBFieldString<>("zrnjysisppitkykkguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnjysisppitkykkguyobix2 = new ExDBFieldString<>("zrnjysisppitkykkguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnjysisppitkykkguyobix3 = new ExDBFieldString<>("zrnjysisppitkykkguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnjysisppitkykkguyobix4 = new ExDBFieldString<>("zrnjysisppitkykkguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnjysisppitkykkguyobix5 = new ExDBFieldString<>("zrnjysisppitkykkguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntksttkykkguybx1 = new ExDBFieldString<>("zrntksttkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntksttkykkguybx2 = new ExDBFieldString<>("zrntksttkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntksttkykkguybx3 = new ExDBFieldString<>("zrntksttkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntksttkykkguybx4 = new ExDBFieldString<>("zrntksttkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrntksttkykkguybx5 = new ExDBFieldString<>("zrntksttkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2tksttkykkguybx1 = new ExDBFieldString<>("zrndi2tksttkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2tksttkykkguybx2 = new ExDBFieldString<>("zrndi2tksttkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2tksttkykkguybx3 = new ExDBFieldString<>("zrndi2tksttkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2tksttkykkguybx4 = new ExDBFieldString<>("zrndi2tksttkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2tksttkykkguybx5 = new ExDBFieldString<>("zrndi2tksttkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmnsttkykkguybx1 = new ExDBFieldString<>("zrnmnsttkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmnsttkykkguybx2 = new ExDBFieldString<>("zrnmnsttkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmnsttkykkguybx3 = new ExDBFieldString<>("zrnmnsttkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmnsttkykkguybx4 = new ExDBFieldString<>("zrnmnsttkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnmnsttkykkguybx5 = new ExDBFieldString<>("zrnmnsttkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2mnsttkykkguybx1 = new ExDBFieldString<>("zrndi2mnsttkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2mnsttkykkguybx2 = new ExDBFieldString<>("zrndi2mnsttkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2mnsttkykkguybx3 = new ExDBFieldString<>("zrndi2mnsttkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2mnsttkykkguybx4 = new ExDBFieldString<>("zrndi2mnsttkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2mnsttkykkguybx5 = new ExDBFieldString<>("zrndi2mnsttkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsugusnsyutkykkguybx1 = new ExDBFieldString<>("zrnsugusnsyutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsugusnsyutkykkguybx2 = new ExDBFieldString<>("zrnsugusnsyutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsugusnsyutkykkguybx3 = new ExDBFieldString<>("zrnsugusnsyutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsugusnsyutkykkguybx4 = new ExDBFieldString<>("zrnsugusnsyutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsugusnsyutkykkguybx5 = new ExDBFieldString<>("zrnsugusnsyutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonktkykkguyobix1 = new ExDBFieldString<>("zrnkaigonktkykkguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonktkykkguyobix2 = new ExDBFieldString<>("zrnkaigonktkykkguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonktkykkguyobix3 = new ExDBFieldString<>("zrnkaigonktkykkguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonktkykkguyobix4 = new ExDBFieldString<>("zrnkaigonktkykkguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnkaigonktkykkguyobix5 = new ExDBFieldString<>("zrnkaigonktkykkguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnitjbrkignktkykkguybx1 = new ExDBFieldString<>("zrnitjbrkignktkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnitjbrkignktkykkguybx2 = new ExDBFieldString<>("zrnitjbrkignktkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnitjbrkignktkykkguybx3 = new ExDBFieldString<>("zrnitjbrkignktkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnitjbrkignktkykkguybx4 = new ExDBFieldString<>("zrnitjbrkignktkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnitjbrkignktkykkguybx5 = new ExDBFieldString<>("zrnitjbrkignktkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2syugitkykkguybx1 = new ExDBFieldString<>("zrndi2syugitkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2syugitkykkguybx2 = new ExDBFieldString<>("zrndi2syugitkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2syugitkykkguybx3 = new ExDBFieldString<>("zrndi2syugitkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2syugitkykkguybx4 = new ExDBFieldString<>("zrndi2syugitkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2syugitkykkguybx5 = new ExDBFieldString<>("zrndi2syugitkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sigiwrmstkykkguybx1 = new ExDBFieldString<>("zrndi2sigiwrmstkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sigiwrmstkykkguybx2 = new ExDBFieldString<>("zrndi2sigiwrmstkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sigiwrmstkykkguybx3 = new ExDBFieldString<>("zrndi2sigiwrmstkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sigiwrmstkykkguybx4 = new ExDBFieldString<>("zrndi2sigiwrmstkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sigiwrmstkykkguybx5 = new ExDBFieldString<>("zrndi2sigiwrmstkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2siginyuintkykkguybx1 = new ExDBFieldString<>("zrndi2siginyuintkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2siginyuintkykkguybx2 = new ExDBFieldString<>("zrndi2siginyuintkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2siginyuintkykkguybx3 = new ExDBFieldString<>("zrndi2siginyuintkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2siginyuintkykkguybx4 = new ExDBFieldString<>("zrndi2siginyuintkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2siginyuintkykkguybx5 = new ExDBFieldString<>("zrndi2siginyuintkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sppinyuintkykkguybx1 = new ExDBFieldString<>("zrndi2sppinyuintkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sppinyuintkykkguybx2 = new ExDBFieldString<>("zrndi2sppinyuintkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sppinyuintkykkguybx3 = new ExDBFieldString<>("zrndi2sppinyuintkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sppinyuintkykkguybx4 = new ExDBFieldString<>("zrndi2sppinyuintkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sppinyuintkykkguybx5 = new ExDBFieldString<>("zrndi2sppinyuintkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sijnbyutkykkguybx1 = new ExDBFieldString<>("zrndi2sijnbyutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sijnbyutkykkguybx2 = new ExDBFieldString<>("zrndi2sijnbyutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sijnbyutkykkguybx3 = new ExDBFieldString<>("zrndi2sijnbyutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sijnbyutkykkguybx4 = new ExDBFieldString<>("zrndi2sijnbyutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sijnbyutkykkguybx5 = new ExDBFieldString<>("zrndi2sijnbyutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndai2tuintkykkguyobix1 = new ExDBFieldString<>("zrndai2tuintkykkguyobix1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndai2tuintkykkguyobix2 = new ExDBFieldString<>("zrndai2tuintkykkguyobix2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndai2tuintkykkguyobix3 = new ExDBFieldString<>("zrndai2tuintkykkguyobix3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndai2tuintkykkguyobix4 = new ExDBFieldString<>("zrndai2tuintkykkguyobix4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndai2tuintkykkguyobix5 = new ExDBFieldString<>("zrndai2tuintkykkguyobix5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2jysisppitkykkguybx1 = new ExDBFieldString<>("zrndi2jysisppitkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2jysisppitkykkguybx2 = new ExDBFieldString<>("zrndi2jysisppitkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2jysisppitkykkguybx3 = new ExDBFieldString<>("zrndi2jysisppitkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2jysisppitkykkguybx4 = new ExDBFieldString<>("zrndi2jysisppitkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2jysisppitkykkguybx5 = new ExDBFieldString<>("zrndi2jysisppitkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sugusnsyutkykkguybx1 = new ExDBFieldString<>("zrndi2sugusnsyutkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sugusnsyutkykkguybx2 = new ExDBFieldString<>("zrndi2sugusnsyutkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sugusnsyutkykkguybx3 = new ExDBFieldString<>("zrndi2sugusnsyutkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sugusnsyutkykkguybx4 = new ExDBFieldString<>("zrndi2sugusnsyutkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sugusnsyutkykkguybx5 = new ExDBFieldString<>("zrndi2sugusnsyutkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sykkyuhtkykkguybx1 = new ExDBFieldString<>("zrndi2sykkyuhtkykkguybx1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sykkyuhtkykkguybx2 = new ExDBFieldString<>("zrndi2sykkyuhtkykkguybx2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sykkyuhtkykkguybx3 = new ExDBFieldString<>("zrndi2sykkyuhtkykkguybx3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sykkyuhtkykkguybx4 = new ExDBFieldString<>("zrndi2sykkyuhtkykkguybx4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrndi2sykkyuhtkykkguybx5 = new ExDBFieldString<>("zrndi2sykkyuhtkykkguybx5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x1 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x2 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x3 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x4 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x5 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x6 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x7 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x8 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x9 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x10 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x11 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x11", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x12 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x12", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x13 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x13", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x14 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x14", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi1x15 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi1x15", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x1 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x2 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x3 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x4 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x5 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x6 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x7 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x8 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x9 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi2x10 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi2x10", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x1 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x1", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x2 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x2", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x3 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x3", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x4 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x4", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x5 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x5", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x6 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x6", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x7 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x7", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x8 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x8", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x9 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x9", this);

    public final ExDBFieldString<ZT_Sp2RnduyuSouseiritu3Rn, String> zrnsetaitehknsyuruiyobi3x10 = new ExDBFieldString<>("zrnsetaitehknsyuruiyobi3x10", this);
}
