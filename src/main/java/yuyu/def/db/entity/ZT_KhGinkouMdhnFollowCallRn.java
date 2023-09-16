package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.mapping.GenZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.meta.GenQZT_KhGinkouMdhnFollowCallRn;
import yuyu.def.db.meta.QZT_KhGinkouMdhnFollowCallRn;

/**
 * 銀行窓販フォローコール対象テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KhGinkouMdhnFollowCallRn} の JavaDoc を参照してください。
 * @see     GenZT_KhGinkouMdhnFollowCallRn
 * @see     PKZT_KhGinkouMdhnFollowCallRn
 * @see     QZT_KhGinkouMdhnFollowCallRn
 * @see     GenQZT_KhGinkouMdhnFollowCallRn
 */
@Entity
public class ZT_KhGinkouMdhnFollowCallRn extends GenZT_KhGinkouMdhnFollowCallRn {

    private static final long serialVersionUID = 1L;

    public ZT_KhGinkouMdhnFollowCallRn() {
    }

    public ZT_KhGinkouMdhnFollowCallRn(String pZrnsyono, String pZrnminyuuym) {
        super(pZrnsyono, pZrnminyuuym);
    }

}
