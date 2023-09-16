package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkGensiKtyTy;

/**
 * 年金原資Ｆ期中報告用テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkGensiKtyTy extends AbstractExDBTable<ZT_NkGensiKtyTy> {

    public GenQZT_NkGensiKtyTy() {
        this("ZT_NkGensiKtyTy");
    }

    public GenQZT_NkGensiKtyTy(String pAlias) {
        super("ZT_NkGensiKtyTy", ZT_NkGensiKtyTy.class, pAlias);
    }

    public String ZT_NkGensiKtyTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztysystemcd = new ExDBFieldString<>("ztysystemcd", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztyulfkbn = new ExDBFieldString<>("ztyulfkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztyrecordkihonkbn = new ExDBFieldString<>("ztyrecordkihonkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztyidouymd = new ExDBFieldString<>("ztyidouymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztysyouin = new ExDBFieldString<>("ztysyouin", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynksyuruikbn = new ExDBFieldString<>("ztynksyuruikbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynenkinkbn = new ExDBFieldString<>("ztynenkinkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynenkinsyu = new ExDBFieldString<>("ztynenkinsyu", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynenkinkaisikbn = new ExDBFieldString<>("ztynenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztysyokainenkinsiharaiymd = new ExDBFieldString<>("ztysyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynenkinhosyoukikan = new ExDBFieldString<>("ztynenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztysaisyuukousinymd = new ExDBFieldString<>("ztysaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztysaisyuukousinsyoricd = new ExDBFieldString<>("ztysaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Long> ztynenkinkihonctr = new ExDBFieldNumber<>("ztynenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztycurrentday = new ExDBFieldString<>("ztycurrentday", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztycurrenttime = new ExDBFieldString<>("ztycurrenttime", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztykessanjibikinkbn = new ExDBFieldString<>("ztykessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynksyoumetucd = new ExDBFieldString<>("ztynksyoumetucd", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynksyoumetuymd = new ExDBFieldString<>("ztynksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztykouryokuhasseiymd = new ExDBFieldString<>("ztykouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztykingakuzoukanaiyoukbn = new ExDBFieldString<>("ztykingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztymotokeiyakusyouhinkbn = new ExDBFieldString<>("ztymotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynenkinkigousedaikbn = new ExDBFieldString<>("ztynenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Double> ztyrrthendounkyoteirrt = new ExDBFieldNumber<>("ztyrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Double> ztyrrthendounksitihsyurrt = new ExDBFieldNumber<>("ztyrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Long> ztyhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("ztyhenkoumaekihonnenkingaku", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynenkingensino = new ExDBFieldString<>("ztynenkingensino", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynenkingensinaiyoukbn = new ExDBFieldString<>("ztynenkingensinaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Long> ztynkkikingk = new ExDBFieldNumber<>("ztynkkikingk", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Long> ztygensinaiyoukihonnkgk = new ExDBFieldNumber<>("ztygensinaiyoukihonnkgk", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Long> ztynewmoneygaku = new ExDBFieldNumber<>("ztynewmoneygaku", this);

    public final ExDBFieldString<ZT_NkGensiKtyTy, String> ztynenkingensihasseiymd = new ExDBFieldString<>("ztynenkingensihasseiymd", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Long> ztydkeisanyounenkingaku = new ExDBFieldNumber<>("ztydkeisanyounenkingaku", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyTy, Long> ztykgynkyouzeiseitkkaksjgns = new ExDBFieldNumber<>("ztykgynkyouzeiseitkkaksjgns", this);
}
