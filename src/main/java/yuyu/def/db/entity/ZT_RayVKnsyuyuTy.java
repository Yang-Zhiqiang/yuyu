package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RayVKnsyuyuTy;
import yuyu.def.db.mapping.GenZT_RayVKnsyuyuTy;
import yuyu.def.db.meta.GenQZT_RayVKnsyuyuTy;
import yuyu.def.db.meta.QZT_RayVKnsyuyuTy;

/**
 * ＲＡＹＶ検証用Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RayVKnsyuyuTy} の JavaDoc を参照してください。
 * @see     GenZT_RayVKnsyuyuTy
 * @see     PKZT_RayVKnsyuyuTy
 * @see     QZT_RayVKnsyuyuTy
 * @see     GenQZT_RayVKnsyuyuTy
 */
@Entity
public class ZT_RayVKnsyuyuTy extends GenZT_RayVKnsyuyuTy {

    private static final long serialVersionUID = 1L;

    public ZT_RayVKnsyuyuTy() {
    }

    public ZT_RayVKnsyuyuTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
