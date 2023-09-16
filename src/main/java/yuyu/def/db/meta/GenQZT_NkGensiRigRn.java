package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_NkGensiRigRn;

/**
 * 年金原資Ｆ例月用テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_NkGensiRigRn extends AbstractExDBTable<ZT_NkGensiRigRn> {

    public GenQZT_NkGensiRigRn() {
        this("ZT_NkGensiRigRn");
    }

    public GenQZT_NkGensiRigRn(String pAlias) {
        super("ZT_NkGensiRigRn", ZT_NkGensiRigRn.class, pAlias);
    }

    public String ZT_NkGensiRigRn() {
        return getAliasExpression();
    }

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Integer> zrnsequenceno = new ExDBFieldNumber<>("zrnsequenceno", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnsystemcd = new ExDBFieldString<>("zrnsystemcd", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnulfkbn = new ExDBFieldString<>("zrnulfkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnrecordkihonkbn = new ExDBFieldString<>("zrnrecordkihonkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnyobiv6 = new ExDBFieldString<>("zrnyobiv6", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnksyousyono = new ExDBFieldString<>("zrnnksyousyono", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnidouymd = new ExDBFieldString<>("zrnidouymd", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnsyouin = new ExDBFieldString<>("zrnsyouin", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnksyuruikbn = new ExDBFieldString<>("zrnnksyuruikbn", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnenkinkbn = new ExDBFieldString<>("zrnnenkinkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnenkinsyu = new ExDBFieldString<>("zrnnenkinsyu", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnenkinkaisikbn = new ExDBFieldString<>("zrnnenkinkaisikbn", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnkeiyakuymd = new ExDBFieldString<>("zrnkeiyakuymd", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnsyokainenkinsiharaiymd = new ExDBFieldString<>("zrnsyokainenkinsiharaiymd", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnknshry = new ExDBFieldString<>("zrnnknshry", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnenkinhosyoukikan = new ExDBFieldString<>("zrnnenkinhosyoukikan", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Long> zrnkhnnkgk = new ExDBFieldNumber<>("zrnkhnnkgk", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnsaisyuukousinymd = new ExDBFieldString<>("zrnsaisyuukousinymd", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnsaisyuukousinsyoricd = new ExDBFieldString<>("zrnsaisyuukousinsyoricd", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Long> zrnnenkinkihonctr = new ExDBFieldNumber<>("zrnnenkinkihonctr", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrncurrentday = new ExDBFieldString<>("zrncurrentday", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrncurrenttime = new ExDBFieldString<>("zrncurrenttime", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnkessanjibikinkbn = new ExDBFieldString<>("zrnkessanjibikinkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnksyoumetucd = new ExDBFieldString<>("zrnnksyoumetucd", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnksyoumetuymd = new ExDBFieldString<>("zrnnksyoumetuymd", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnkouryokuhasseiymd = new ExDBFieldString<>("zrnkouryokuhasseiymd", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnkingakuzoukanaiyoukbn = new ExDBFieldString<>("zrnkingakuzoukanaiyoukbn", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnmotokeiyakusyouhinkbn = new ExDBFieldString<>("zrnmotokeiyakusyouhinkbn", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnenkinkigousedaikbn = new ExDBFieldString<>("zrnnenkinkigousedaikbn", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Double> zrnrrthendounkyoteirrt = new ExDBFieldNumber<>("zrnrrthendounkyoteirrt", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Double> zrnrrthendounksitihsyurrt = new ExDBFieldNumber<>("zrnrrthendounksitihsyurrt", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Long> zrnhenkoumaekihonnenkingaku = new ExDBFieldNumber<>("zrnhenkoumaekihonnenkingaku", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnenkingensino = new ExDBFieldString<>("zrnnenkingensino", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnenkingensinaiyoukbn = new ExDBFieldString<>("zrnnenkingensinaiyoukbn", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Long> zrnnkkikingk = new ExDBFieldNumber<>("zrnnkkikingk", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Long> zrngensinaiyoukihonnkgk = new ExDBFieldNumber<>("zrngensinaiyoukihonnkgk", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Long> zrnnewmoneygaku = new ExDBFieldNumber<>("zrnnewmoneygaku", this);

    public final ExDBFieldString<ZT_NkGensiRigRn, String> zrnnenkingensihasseiymd = new ExDBFieldString<>("zrnnenkingensihasseiymd", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Long> zrndkeisanyounenkingaku = new ExDBFieldNumber<>("zrndkeisanyounenkingaku", this);

    public final ExDBFieldNumber<ZT_NkGensiRigRn, Long> zrnkgynkyouzeiseitkkaksjgns = new ExDBFieldNumber<>("zrnkgynkyouzeiseitkkaksjgns", this);
}
