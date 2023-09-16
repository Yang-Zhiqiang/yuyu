package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyuSibouToukeiTy;
import yuyu.def.db.mapping.GenZT_SyuSibouToukeiTy;
import yuyu.def.db.meta.GenQZT_SyuSibouToukeiTy;
import yuyu.def.db.meta.QZT_SyuSibouToukeiTy;

/**
 * 主契約死亡統計データテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyuSibouToukeiTy} の JavaDoc を参照してください。
 * @see     GenZT_SyuSibouToukeiTy
 * @see     PKZT_SyuSibouToukeiTy
 * @see     QZT_SyuSibouToukeiTy
 * @see     GenQZT_SyuSibouToukeiTy
 */
@Entity
public class ZT_SyuSibouToukeiTy extends GenZT_SyuSibouToukeiTy {

    private static final long serialVersionUID = 1L;

    public ZT_SyuSibouToukeiTy() {
    }

    public ZT_SyuSibouToukeiTy(String pZtysyono) {
        super(pZtysyono);
    }

}
