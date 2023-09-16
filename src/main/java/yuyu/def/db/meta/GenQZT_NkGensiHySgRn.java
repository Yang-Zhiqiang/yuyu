package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkGensiHySgRn;

/**
 * 年金原資Ｆ保有照合用テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkGensiHySgRn extends AbstractExDBTable<ZT_NkGensiHySgRn> {

    public GenQZT_NkGensiHySgRn() {
        this("ZT_NkGensiHySgRn");
    }

    public GenQZT_NkGensiHySgRn(String pAlias) {
        super("ZT_NkGensiHySgRn", ZT_NkGensiHySgRn.class, pAlias);
    }

    public String ZT_NkGensiHySgRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnsystemcd = new ExDBFieldString<>("zrnsystemcd", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnulfkbn = new ExDBFieldString<>("zrnulfkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnrecordkihonkbn = new ExDBFieldString<>("zrnrecordkihonkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnidouymd = new ExDBFieldString<>("zrnidouymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnsyouin = new ExDBFieldString<>("zrnsyouin", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnksyuruikbn = new ExDBFieldString<>("zrnnksyuruikbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnenkinkbn = new ExDBFieldString<>("zrnnenkinkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnenkinsyu = new ExDBFieldString<>("zrnnenkinsyu", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnenkinkaisikbn = new ExDBFieldString<>("zrnnenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnsyokainenkinsiharaiymd = new ExDBFieldString<>("zrnsyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnenkinhosyoukikan = new ExDBFieldString<>("zrnnenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnsaisyuukousinymd = new ExDBFieldString<>("zrnsaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnsaisyuukousinsyoricd = new ExDBFieldString<>("zrnsaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Long> zrnnenkinkihonctr = new ExDBFieldNumber<>("zrnnenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrncurrentday = new ExDBFieldString<>("zrncurrentday", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrncurrenttime = new ExDBFieldString<>("zrncurrenttime", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnkessanjibikinkbn = new ExDBFieldString<>("zrnkessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnksyoumetucd = new ExDBFieldString<>("zrnnksyoumetucd", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnksyoumetuymd = new ExDBFieldString<>("zrnnksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnkouryokuhasseiymd = new ExDBFieldString<>("zrnkouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnkingakuzoukanaiyoukbn = new ExDBFieldString<>("zrnkingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnmotokeiyakusyouhinkbn = new ExDBFieldString<>("zrnmotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnenkinkigousedaikbn = new ExDBFieldString<>("zrnnenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Double> zrnrrthendounkyoteirrt = new ExDBFieldNumber<>("zrnrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Double> zrnrrthendounksitihsyurrt = new ExDBFieldNumber<>("zrnrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Long> zrnhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("zrnhenkoumaekihonnenkingaku", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnenkingensino = new ExDBFieldString<>("zrnnenkingensino", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnenkingensinaiyoukbn = new ExDBFieldString<>("zrnnenkingensinaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Long> zrnnkkikingk = new ExDBFieldNumber<>("zrnnkkikingk", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Long> zrngensinaiyoukihonnkgk = new ExDBFieldNumber<>("zrngensinaiyoukihonnkgk", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Long> zrnnewmoneygaku = new ExDBFieldNumber<>("zrnnewmoneygaku", this);

    public final ExDBFieldString<ZT_NkGensiHySgRn, String> zrnnenkingensihasseiymd = new ExDBFieldString<>("zrnnenkingensihasseiymd", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Long> zrndkeisanyounenkingaku = new ExDBFieldNumber<>("zrndkeisanyounenkingaku", this);

    public final ExDBFieldNumber<ZT_NkGensiHySgRn, Long> zrnkgynkyouzeiseitkkaksjgns = new ExDBFieldNumber<>("zrnkgynkyouzeiseitkkaksjgns", this);
}
