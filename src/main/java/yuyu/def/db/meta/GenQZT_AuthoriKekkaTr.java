package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_AuthoriKekkaTr;

/**
 * オーソリ結果Ｆテーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_AuthoriKekkaTr extends AbstractExDBTable<ZT_AuthoriKekkaTr> {

    public GenQZT_AuthoriKekkaTr() {
        this("ZT_AuthoriKekkaTr");
    }

    public GenQZT_AuthoriKekkaTr(String pAlias) {
        super("ZT_AuthoriKekkaTr", ZT_AuthoriKekkaTr.class, pAlias);
    }

    public String ZT_AuthoriKekkaTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrrecordkbn = new ExDBFieldString<>("ztrrecordkbn", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrkaiintourokukbn = new ExDBFieldString<>("ztrkaiintourokukbn", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrcreditkessaiyouno = new ExDBFieldString<>("ztrcreditkessaiyouno", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztryobiv34 = new ExDBFieldString<>("ztryobiv34", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrcardno = new ExDBFieldString<>("ztrcardno", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrcardyuukoukigen = new ExDBFieldString<>("ztrcardyuukoukigen", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrauthorigkjyusin = new ExDBFieldString<>("ztrauthorigkjyusin", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrauthorikekkaerrorcd = new ExDBFieldString<>("ztrauthorikekkaerrorcd", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrbluegateerrorcd = new ExDBFieldString<>("ztrbluegateerrorcd", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztryobiv25 = new ExDBFieldString<>("ztryobiv25", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrhisimukekaisyacd = new ExDBFieldString<>("ztrhisimukekaisyacd", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztryobiv5 = new ExDBFieldString<>("ztryobiv5", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrwentryuserid = new ExDBFieldString<>("ztrwentryuserid", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrerrorcomment = new ExDBFieldString<>("ztrerrorcomment", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrniniinfo = new ExDBFieldString<>("ztrniniinfo", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrskjkssityuumonno = new ExDBFieldString<>("ztrskjkssityuumonno", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrskjkssiauthorigk = new ExDBFieldString<>("ztrskjkssiauthorigk", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrskjkssiyosinkekka = new ExDBFieldString<>("ztrskjkssiyosinkekka", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrskjkssibunruikbn = new ExDBFieldString<>("ztrskjkssibunruikbn", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrdatasyorijyoukyou = new ExDBFieldString<>("ztrdatasyorijyoukyou", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrdatajyusinymd = new ExDBFieldString<>("ztrdatajyusinymd", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztryobiv25x2 = new ExDBFieldString<>("ztryobiv25x2", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztrrenno7 = new ExDBFieldString<>("ztrrenno7", this);

    public final ExDBFieldString<ZT_AuthoriKekkaTr, String> ztryobiv33 = new ExDBFieldString<>("ztryobiv33", this);
}
