package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_AcsAdrNmRn;

/**
 * ＡＣＳ住所名ＤＢ用Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_AcsAdrNmRn extends AbstractExDBTable<ZT_AcsAdrNmRn> {

    public GenQZT_AcsAdrNmRn() {
        this("ZT_AcsAdrNmRn");
    }

    public GenQZT_AcsAdrNmRn(String pAlias) {
        super("ZT_AcsAdrNmRn", ZT_AcsAdrNmRn.class, pAlias);
    }

    public String ZT_AcsAdrNmRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkihontikucd = new ExDBFieldString<>("zrnkihontikucd", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkihontikucdsyoumetukbn = new ExDBFieldString<>("zrnkihontikucdsyoumetukbn", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkjadr = new ExDBFieldString<>("zrnkjadr", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkjtodouhukennmketasuu = new ExDBFieldString<>("zrnkjtodouhukennmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkjsikugunnmketasuu = new ExDBFieldString<>("zrnkjsikugunnmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkjsikutyousonnmketasuu = new ExDBFieldString<>("zrnkjsikutyousonnmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkjtyousonnmketasuu = new ExDBFieldString<>("zrnkjtyousonnmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkjkyoutotuusyounmketasuu = new ExDBFieldString<>("zrnkjkyoutotuusyounmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkjadrketasuu = new ExDBFieldString<>("zrnkjadrketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnknadr = new ExDBFieldString<>("zrnknadr", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkntodouhukennmketasuu = new ExDBFieldString<>("zrnkntodouhukennmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnknsikugunnmketasuu = new ExDBFieldString<>("zrnknsikugunnmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnknsikutyousonnmketasuu = new ExDBFieldString<>("zrnknsikutyousonnmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnkntyousonnmketasuu = new ExDBFieldString<>("zrnkntyousonnmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnknkyoutotuusyounmketasuu = new ExDBFieldString<>("zrnknkyoutotuusyounmketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnknadrketasuu = new ExDBFieldString<>("zrnknadrketasuu", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrntodouhukencd = new ExDBFieldString<>("zrntodouhukencd", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrngyouseikukakucd = new ExDBFieldString<>("zrngyouseikukakucd", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnikoumaekihontikucd = new ExDBFieldString<>("zrnikoumaekihontikucd", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnnewynohyouji = new ExDBFieldString<>("zrnnewynohyouji", this);

    public final ExDBFieldString<ZT_AcsAdrNmRn, String> zrnyobiv14 = new ExDBFieldString<>("zrnyobiv14", this);
}
