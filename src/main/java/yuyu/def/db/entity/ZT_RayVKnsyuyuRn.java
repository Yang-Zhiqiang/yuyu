package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_RayVKnsyuyuRn;
import yuyu.def.db.mapping.GenZT_RayVKnsyuyuRn;
import yuyu.def.db.meta.GenQZT_RayVKnsyuyuRn;
import yuyu.def.db.meta.QZT_RayVKnsyuyuRn;

/**
 * ＲＡＹＶ検証用Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_RayVKnsyuyuRn} の JavaDoc を参照してください。
 * @see     GenZT_RayVKnsyuyuRn
 * @see     PKZT_RayVKnsyuyuRn
 * @see     QZT_RayVKnsyuyuRn
 * @see     GenQZT_RayVKnsyuyuRn
 */
@Entity
public class ZT_RayVKnsyuyuRn extends GenZT_RayVKnsyuyuRn {

    private static final long serialVersionUID = 1L;

    public ZT_RayVKnsyuyuRn() {
    }

    public ZT_RayVKnsyuyuRn(Integer pZrnsequenceno) {
        super(pZrnsequenceno);
    }

}
