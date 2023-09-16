package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkGensiHySgTy;

/**
 * 年金原資Ｆ保有照合用テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkGensiHySgTy extends AbstractExDBTable<ZT_NkGensiHySgTy> {

    public GenQZT_NkGensiHySgTy() {
        this("ZT_NkGensiHySgTy");
    }

    public GenQZT_NkGensiHySgTy(String pAlias) {
        super("ZT_NkGensiHySgTy", ZT_NkGensiHySgTy.class, pAlias);
    }

    public String ZT_NkGensiHySgTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztysystemcd = new ExDBFieldString<>("ztysystemcd", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztyulfkbn = new ExDBFieldString<>("ztyulfkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztyrecordkihonkbn = new ExDBFieldString<>("ztyrecordkihonkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztyidouymd = new ExDBFieldString<>("ztyidouymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztysyouin = new ExDBFieldString<>("ztysyouin", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynksyuruikbn = new ExDBFieldString<>("ztynksyuruikbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynenkinkbn = new ExDBFieldString<>("ztynenkinkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynenkinsyu = new ExDBFieldString<>("ztynenkinsyu", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynenkinkaisikbn = new ExDBFieldString<>("ztynenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztysyokainenkinsiharaiymd = new ExDBFieldString<>("ztysyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynenkinhosyoukikan = new ExDBFieldString<>("ztynenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztysaisyuukousinymd = new ExDBFieldString<>("ztysaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztysaisyuukousinsyoricd = new ExDBFieldString<>("ztysaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Long> ztynenkinkihonctr = new ExDBFieldNumber<>("ztynenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztycurrentday = new ExDBFieldString<>("ztycurrentday", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztycurrenttime = new ExDBFieldString<>("ztycurrenttime", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztykessanjibikinkbn = new ExDBFieldString<>("ztykessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynksyoumetucd = new ExDBFieldString<>("ztynksyoumetucd", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynksyoumetuymd = new ExDBFieldString<>("ztynksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztykouryokuhasseiymd = new ExDBFieldString<>("ztykouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztykingakuzoukanaiyoukbn = new ExDBFieldString<>("ztykingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztymotokeiyakusyouhinkbn = new ExDBFieldString<>("ztymotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynenkinkigousedaikbn = new ExDBFieldString<>("ztynenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Double> ztyrrthendounkyoteirrt = new ExDBFieldNumber<>("ztyrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Double> ztyrrthendounksitihsyurrt = new ExDBFieldNumber<>("ztyrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Long> ztyhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("ztyhenkoumaekihonnenkingaku", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynenkingensino = new ExDBFieldString<>("ztynenkingensino", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynenkingensinaiyoukbn = new ExDBFieldString<>("ztynenkingensinaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Long> ztynkkikingk = new ExDBFieldNumber<>("ztynkkikingk", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Long> ztygensinaiyoukihonnkgk = new ExDBFieldNumber<>("ztygensinaiyoukihonnkgk", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Long> ztynewmoneygaku = new ExDBFieldNumber<>("ztynewmoneygaku", this);

    public final ExDBFieldString<ZT_NkGensiHySgTy, String> ztynenkingensihasseiymd = new ExDBFieldString<>("ztynenkingensihasseiymd", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Long> ztydkeisanyounenkingaku = new ExDBFieldNumber<>("ztydkeisanyounenkingaku", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgTy, Long> ztykgynkyouzeiseitkkaksjgns = new ExDBFieldNumber<>("ztykgynkyouzeiseitkkaksjgns", this);
}
