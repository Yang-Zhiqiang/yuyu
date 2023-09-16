package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_EgsyokuinSysRendouTy;
import yuyu.def.db.mapping.GenZT_EgsyokuinSysRendouTy;
import yuyu.def.db.meta.GenQZT_EgsyokuinSysRendouTy;
import yuyu.def.db.meta.QZT_EgsyokuinSysRendouTy;

/**
 * 営業職員システム連動Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_EgsyokuinSysRendouTy} の JavaDoc を参照してください。
 * @see     GenZT_EgsyokuinSysRendouTy
 * @see     PKZT_EgsyokuinSysRendouTy
 * @see     QZT_EgsyokuinSysRendouTy
 * @see     GenQZT_EgsyokuinSysRendouTy
 */
@Entity
public class ZT_EgsyokuinSysRendouTy extends GenZT_EgsyokuinSysRendouTy {

    private static final long serialVersionUID = 1L;

    public ZT_EgsyokuinSysRendouTy() {
    }

    public ZT_EgsyokuinSysRendouTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
