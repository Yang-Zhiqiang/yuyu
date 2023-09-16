package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.mapping.GenZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.meta.GenQZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFTy;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KokyakuYuyuKykmeisaiFTy} の JavaDoc を参照してください。
 * @see     GenZT_KokyakuYuyuKykmeisaiFTy
 * @see     PKZT_KokyakuYuyuKykmeisaiFTy
 * @see     QZT_KokyakuYuyuKykmeisaiFTy
 * @see     GenQZT_KokyakuYuyuKykmeisaiFTy
 */
@Entity
public class ZT_KokyakuYuyuKykmeisaiFTy extends GenZT_KokyakuYuyuKykmeisaiFTy {

    private static final long serialVersionUID = 1L;

    public ZT_KokyakuYuyuKykmeisaiFTy() {
    }

    public ZT_KokyakuYuyuKykmeisaiFTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
