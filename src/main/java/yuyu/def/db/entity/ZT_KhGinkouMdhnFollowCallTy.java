package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.mapping.GenZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.meta.GenQZT_KhGinkouMdhnFollowCallTy;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallTy;

/**
 * 銀行窓販フォローコール対象テーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KhGinkouMdhnFollowCallTy} の JavaDoc を参照してください。
 * @see     GenZT_KhGinkouMdhnFollowCallTy
 * @see     PKZT_KhGinkouMdhnFollowCallTy
 * @see     QZT_KhGinkouMdhnFollowCallTy
 * @see     GenQZT_KhGinkouMdhnFollowCallTy
 */
@Entity
public class ZT_KhGinkouMdhnFollowCallTy extends GenZT_KhGinkouMdhnFollowCallTy {

    private static final long serialVersionUID = 1L;

    public ZT_KhGinkouMdhnFollowCallTy() {
    }

    public ZT_KhGinkouMdhnFollowCallTy(String pZtysyono, String pZtyminyuuym) {
        super(pZtysyono, pZtyminyuuym);
    }

}
