package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkGensiKtyRn;

/**
 * 年金原資Ｆ期中報告用テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkGensiKtyRn extends AbstractExDBTable<ZT_NkGensiKtyRn> {

    public GenQZT_NkGensiKtyRn() {
        this("ZT_NkGensiKtyRn");
    }

    public GenQZT_NkGensiKtyRn(String pAlias) {
        super("ZT_NkGensiKtyRn", ZT_NkGensiKtyRn.class, pAlias);
    }

    public String ZT_NkGensiKtyRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnsystemcd = new ExDBFieldString<>("zrnsystemcd", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnulfkbn = new ExDBFieldString<>("zrnulfkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnrecordkihonkbn = new ExDBFieldString<>("zrnrecordkihonkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnidouymd = new ExDBFieldString<>("zrnidouymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnsyouin = new ExDBFieldString<>("zrnsyouin", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnksyuruikbn = new ExDBFieldString<>("zrnnksyuruikbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnenkinkbn = new ExDBFieldString<>("zrnnenkinkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnenkinsyu = new ExDBFieldString<>("zrnnenkinsyu", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnenkinkaisikbn = new ExDBFieldString<>("zrnnenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnsyokainenkinsiharaiymd = new ExDBFieldString<>("zrnsyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnenkinhosyoukikan = new ExDBFieldString<>("zrnnenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnsaisyuukousinymd = new ExDBFieldString<>("zrnsaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnsaisyuukousinsyoricd = new ExDBFieldString<>("zrnsaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Long> zrnnenkinkihonctr = new ExDBFieldNumber<>("zrnnenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrncurrentday = new ExDBFieldString<>("zrncurrentday", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrncurrenttime = new ExDBFieldString<>("zrncurrenttime", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnkessanjibikinkbn = new ExDBFieldString<>("zrnkessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnksyoumetucd = new ExDBFieldString<>("zrnnksyoumetucd", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnksyoumetuymd = new ExDBFieldString<>("zrnnksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnkouryokuhasseiymd = new ExDBFieldString<>("zrnkouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnkingakuzoukanaiyoukbn = new ExDBFieldString<>("zrnkingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnmotokeiyakusyouhinkbn = new ExDBFieldString<>("zrnmotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnenkinkigousedaikbn = new ExDBFieldString<>("zrnnenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Double> zrnrrthendounkyoteirrt = new ExDBFieldNumber<>("zrnrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Double> zrnrrthendounksitihsyurrt = new ExDBFieldNumber<>("zrnrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Long> zrnhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("zrnhenkoumaekihonnenkingaku", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnenkingensino = new ExDBFieldString<>("zrnnenkingensino", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnenkingensinaiyoukbn = new ExDBFieldString<>("zrnnenkingensinaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Long> zrnnkkikingk = new ExDBFieldNumber<>("zrnnkkikingk", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Long> zrngensinaiyoukihonnkgk = new ExDBFieldNumber<>("zrngensinaiyoukihonnkgk", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Long> zrnnewmoneygaku = new ExDBFieldNumber<>("zrnnewmoneygaku", this);

    public final ExDBFieldString<ZT_NkGensiKtyRn, String> zrnnenkingensihasseiymd = new ExDBFieldString<>("zrnnenkingensihasseiymd", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Long> zrndkeisanyounenkingaku = new ExDBFieldNumber<>("zrndkeisanyounenkingaku", this);

    public final ExDBFieldNumber<ZT_NkGensiKtyRn, Long> zrnkgynkyouzeiseitkkaksjgns = new ExDBFieldNumber<>("zrnkgynkyouzeiseitkkaksjgns", this);
}
