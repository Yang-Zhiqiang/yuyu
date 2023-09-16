package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_AuthoriKekkaRn;

/**
 * オーソリ結果Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_AuthoriKekkaRn extends AbstractExDBTable<ZT_AuthoriKekkaRn> {

    public GenQZT_AuthoriKekkaRn() {
        this("ZT_AuthoriKekkaRn");
    }

    public GenQZT_AuthoriKekkaRn(String pAlias) {
        super("ZT_AuthoriKekkaRn", ZT_AuthoriKekkaRn.class, pAlias);
    }

    public String ZT_AuthoriKekkaRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnrecordkbn = new ExDBFieldString<>("zrnrecordkbn", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnkaiintourokukbn = new ExDBFieldString<>("zrnkaiintourokukbn", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrncreditkessaiyouno = new ExDBFieldString<>("zrncreditkessaiyouno", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnyobiv34 = new ExDBFieldString<>("zrnyobiv34", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrncardno = new ExDBFieldString<>("zrncardno", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrncardyuukoukigen = new ExDBFieldString<>("zrncardyuukoukigen", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnauthorigkjyusin = new ExDBFieldString<>("zrnauthorigkjyusin", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnauthorikekkaerrorcd = new ExDBFieldString<>("zrnauthorikekkaerrorcd", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnbluegateerrorcd = new ExDBFieldString<>("zrnbluegateerrorcd", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnyobiv25 = new ExDBFieldString<>("zrnyobiv25", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnhisimukekaisyacd = new ExDBFieldString<>("zrnhisimukekaisyacd", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnwentryuserid = new ExDBFieldString<>("zrnwentryuserid", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnerrorcomment = new ExDBFieldString<>("zrnerrorcomment", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnniniinfo = new ExDBFieldString<>("zrnniniinfo", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnskjkssityuumonno = new ExDBFieldString<>("zrnskjkssityuumonno", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnskjkssiauthorigk = new ExDBFieldString<>("zrnskjkssiauthorigk", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnskjkssiyosinkekka = new ExDBFieldString<>("zrnskjkssiyosinkekka", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnskjkssibunruikbn = new ExDBFieldString<>("zrnskjkssibunruikbn", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrndatasyorijyoukyou = new ExDBFieldString<>("zrndatasyorijyoukyou", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrndatajyusinymd = new ExDBFieldString<>("zrndatajyusinymd", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnyobiv25x2 = new ExDBFieldString<>("zrnyobiv25x2", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnrenno7 = new ExDBFieldString<>("zrnrenno7", this);

    public final ExDBFieldString<ZT_AuthoriKekkaRn, String> zrnyobiv33 = new ExDBFieldString<>("zrnyobiv33", this);
}
