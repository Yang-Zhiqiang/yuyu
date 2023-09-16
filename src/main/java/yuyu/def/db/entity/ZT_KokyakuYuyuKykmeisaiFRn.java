package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.mapping.GenZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.meta.GenQZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFRn;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KokyakuYuyuKykmeisaiFRn} の JavaDoc を参照してください。
 * @see     GenZT_KokyakuYuyuKykmeisaiFRn
 * @see     PKZT_KokyakuYuyuKykmeisaiFRn
 * @see     QZT_KokyakuYuyuKykmeisaiFRn
 * @see     GenQZT_KokyakuYuyuKykmeisaiFRn
 */
@Entity
public class ZT_KokyakuYuyuKykmeisaiFRn extends GenZT_KokyakuYuyuKykmeisaiFRn {

    private static final long serialVersionUID = 1L;

    public ZT_KokyakuYuyuKykmeisaiFRn() {
    }

    public ZT_KokyakuYuyuKykmeisaiFRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
