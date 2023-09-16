package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SyainMeiboTy;
import yuyu.def.db.mapping.GenZT_SyainMeiboTy;
import yuyu.def.db.meta.GenQZT_SyainMeiboTy;
import yuyu.def.db.meta.QZT_SyainMeiboTy;

/**
 * 社員名簿Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyainMeiboTy} の JavaDoc を参照してください。
 * @see     GenZT_SyainMeiboTy
 * @see     PKZT_SyainMeiboTy
 * @see     QZT_SyainMeiboTy
 * @see     GenQZT_SyainMeiboTy
 */
@Entity
public class ZT_SyainMeiboTy extends GenZT_SyainMeiboTy {

    private static final long serialVersionUID = 1L;

    public ZT_SyainMeiboTy() {
    }

    public ZT_SyainMeiboTy(String pZtysyono) {
        super(pZtysyono);
    }

}
