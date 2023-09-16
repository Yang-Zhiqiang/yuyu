package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkGensiRigTy;

/**
 * 年金原資Ｆ例月用テーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkGensiRigTy extends AbstractExDBTable<ZT_NkGensiRigTy> {

    public GenQZT_NkGensiRigTy() {
        this("ZT_NkGensiRigTy");
    }

    public GenQZT_NkGensiRigTy(String pAlias) {
        super("ZT_NkGensiRigTy", ZT_NkGensiRigTy.class, pAlias);
    }

    public String ZT_NkGensiRigTy() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztysystemcd = new ExDBFieldString<>("ztysystemcd", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztyulfkbn = new ExDBFieldString<>("ztyulfkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztyrecordkihonkbn = new ExDBFieldString<>("ztyrecordkihonkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynksyousyono = new ExDBFieldString<>("ztynksyousyono", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztyidouymd = new ExDBFieldString<>("ztyidouymd", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztysyouin = new ExDBFieldString<>("ztysyouin", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynksyuruikbn = new ExDBFieldString<>("ztynksyuruikbn", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynenkinkbn = new ExDBFieldString<>("ztynenkinkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynenkinsyu = new ExDBFieldString<>("ztynenkinsyu", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynenkinkaisikbn = new ExDBFieldString<>("ztynenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztykeiyakuymd = new ExDBFieldString<>("ztykeiyakuymd", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztysyokainenkinsiharaiymd = new ExDBFieldString<>("ztysyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynknshry = new ExDBFieldString<>("ztynknshry", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynenkinhosyoukikan = new ExDBFieldString<>("ztynenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Long> ztykhnnkgk = new ExDBFieldNumber<>("ztykhnnkgk", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztysaisyuukousinymd = new ExDBFieldString<>("ztysaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztysaisyuukousinsyoricd = new ExDBFieldString<>("ztysaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Long> ztynenkinkihonctr = new ExDBFieldNumber<>("ztynenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztycurrentday = new ExDBFieldString<>("ztycurrentday", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztycurrenttime = new ExDBFieldString<>("ztycurrenttime", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztykessanjibikinkbn = new ExDBFieldString<>("ztykessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynksyoumetucd = new ExDBFieldString<>("ztynksyoumetucd", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynksyoumetuymd = new ExDBFieldString<>("ztynksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztykouryokuhasseiymd = new ExDBFieldString<>("ztykouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztykingakuzoukanaiyoukbn = new ExDBFieldString<>("ztykingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztymotokeiyakusyouhinkbn = new ExDBFieldString<>("ztymotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynenkinkigousedaikbn = new ExDBFieldString<>("ztynenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Double> ztyrrthendounkyoteirrt = new ExDBFieldNumber<>("ztyrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Double> ztyrrthendounksitihsyurrt = new ExDBFieldNumber<>("ztyrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Long> ztyhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("ztyhenkoumaekihonnenkingaku", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynenkingensino = new ExDBFieldString<>("ztynenkingensino", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynenkingensinaiyoukbn = new ExDBFieldString<>("ztynenkingensinaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Long> ztynkkikingk = new ExDBFieldNumber<>("ztynkkikingk", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Long> ztygensinaiyoukihonnkgk = new ExDBFieldNumber<>("ztygensinaiyoukihonnkgk", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Long> ztynewmoneygaku = new ExDBFieldNumber<>("ztynewmoneygaku", this);

    public final ExDBFieldString<ZT_NkGensiRigTy, String> ztynenkingensihasseiymd = new ExDBFieldString<>("ztynenkingensihasseiymd", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Long> ztydkeisanyounenkingaku = new ExDBFieldNumber<>("ztydkeisanyounenkingaku", this);

    public final ExDBFieldNumber<ZT_NkGensiRigTy, Long> ztykgynkyouzeiseitkkaksjgns = new ExDBFieldNumber<>("ztykgynkyouzeiseitkkaksjgns", this);
}
