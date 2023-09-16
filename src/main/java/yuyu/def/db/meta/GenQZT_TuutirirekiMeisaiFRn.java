package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFRn;

/**
 * 通知履歴明細ファイルテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TuutirirekiMeisaiFRn extends AbstractExDBTable<ZT_TuutirirekiMeisaiFRn> {

    public GenQZT_TuutirirekiMeisaiFRn() {
        this("ZT_TuutirirekiMeisaiFRn");
    }

    public GenQZT_TuutirirekiMeisaiFRn(String pAlias) {
        super("ZT_TuutirirekiMeisaiFRn", ZT_TuutirirekiMeisaiFRn.class, pAlias);
    }

    public String ZT_TuutirirekiMeisaiFRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFRn, String> zrntuutirirekino = new ExDBFieldString<>("zrntuutirirekino", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFRn, String> zrntuutisakuseiymd = new ExDBFieldString<>("zrntuutisakuseiymd", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFRn, String> zrntuutisakuseino = new ExDBFieldString<>("zrntuutisakuseino", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFRn, String> zrntuutisyuruicd = new ExDBFieldString<>("zrntuutisyuruicd", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFRn, String> zrnhyoujiyoutuutisksymd = new ExDBFieldString<>("zrnhyoujiyoutuutisksymd", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFRn, String> zrnyobiv11 = new ExDBFieldString<>("zrnyobiv11", this);
}
