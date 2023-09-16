package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_SyuSibouToukeiRn;
import yuyu.def.db.mapping.GenZT_SyuSibouToukeiRn;
import yuyu.def.db.meta.GenQZT_SyuSibouToukeiRn;
import yuyu.def.db.meta.QZT_SyuSibouToukeiRn;

/**
 * 主契約死亡統計データテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyuSibouToukeiRn} の JavaDoc を参照してください。
 * @see     GenZT_SyuSibouToukeiRn
 * @see     PKZT_SyuSibouToukeiRn
 * @see     QZT_SyuSibouToukeiRn
 * @see     GenQZT_SyuSibouToukeiRn
 */
@Entity
public class ZT_SyuSibouToukeiRn extends GenZT_SyuSibouToukeiRn {

    private static final long serialVersionUID = 1L;

    public ZT_SyuSibouToukeiRn() {
    }

    public ZT_SyuSibouToukeiRn(String pZrnsyono) {
        super(pZrnsyono);
    }

}
