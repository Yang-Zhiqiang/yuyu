package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_TuutirirekiMeisaiFTy;

/**
 * 通知履歴明細ファイルテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_TuutirirekiMeisaiFTy extends AbstractExDBTable<ZT_TuutirirekiMeisaiFTy> {

    public GenQZT_TuutirirekiMeisaiFTy() {
        this("ZT_TuutirirekiMeisaiFTy");
    }

    public GenQZT_TuutirirekiMeisaiFTy(String pAlias) {
        super("ZT_TuutirirekiMeisaiFTy", ZT_TuutirirekiMeisaiFTy.class, pAlias);
    }

    public String ZT_TuutirirekiMeisaiFTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFTy, String> ztytuutirirekino = new ExDBFieldString<>("ztytuutirirekino", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFTy, String> ztytuutisakuseiymd = new ExDBFieldString<>("ztytuutisakuseiymd", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFTy, String> ztytuutisakuseino = new ExDBFieldString<>("ztytuutisakuseino", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFTy, String> ztytuutisyuruicd = new ExDBFieldString<>("ztytuutisyuruicd", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFTy, String> ztyhyoujiyoutuutisksymd = new ExDBFieldString<>("ztyhyoujiyoutuutisksymd", this);

    public final ExDBFieldString<ZT_TuutirirekiMeisaiFTy, String> ztyyobiv11 = new ExDBFieldString<>("ztyyobiv11", this);
}
