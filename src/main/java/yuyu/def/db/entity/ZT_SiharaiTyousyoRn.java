package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SiharaiTyousyoRn;
import yuyu.def.db.mapping.GenZT_SiharaiTyousyoRn;
import yuyu.def.db.meta.GenQZT_SiharaiTyousyoRn;
import yuyu.def.db.meta.QZT_SiharaiTyousyoRn;

/**
 * 支払調書テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SiharaiTyousyoRn} の JavaDoc を参照してください。
 * @see     GenZT_SiharaiTyousyoRn
 * @see     PKZT_SiharaiTyousyoRn
 * @see     QZT_SiharaiTyousyoRn
 * @see     GenQZT_SiharaiTyousyoRn
 */
@Entity
public class ZT_SiharaiTyousyoRn extends GenZT_SiharaiTyousyoRn {

    private static final long serialVersionUID = 1L;

    public ZT_SiharaiTyousyoRn() {
    }

    public ZT_SiharaiTyousyoRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
