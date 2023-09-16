package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_KariwariateHtkinMeisaiTy;
import yuyu.def.db.mapping.GenZT_KariwariateHtkinMeisaiTy;
import yuyu.def.db.meta.GenQZT_KariwariateHtkinMeisaiTy;
import yuyu.def.db.meta.QZT_KariwariateHtkinMeisaiTy;

/**
 * 仮割当配当金明細Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KariwariateHtkinMeisaiTy} の JavaDoc を参照してください。
 * @see     GenZT_KariwariateHtkinMeisaiTy
 * @see     PKZT_KariwariateHtkinMeisaiTy
 * @see     QZT_KariwariateHtkinMeisaiTy
 * @see     GenQZT_KariwariateHtkinMeisaiTy
 */
@Entity
public class ZT_KariwariateHtkinMeisaiTy extends GenZT_KariwariateHtkinMeisaiTy {

    private static final long serialVersionUID = 1L;

    public ZT_KariwariateHtkinMeisaiTy() {
    }

    public ZT_KariwariateHtkinMeisaiTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
