package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_SyainMeiboRn;
import yuyu.def.db.mapping.GenZT_SyainMeiboRn;
import yuyu.def.db.meta.GenQZT_SyainMeiboRn;
import yuyu.def.db.meta.QZT_SyainMeiboRn;

/**
 * 社員名簿Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_SyainMeiboRn} の JavaDoc を参照してください。
 * @see     GenZT_SyainMeiboRn
 * @see     PKZT_SyainMeiboRn
 * @see     QZT_SyainMeiboRn
 * @see     GenQZT_SyainMeiboRn
 */
@Entity
public class ZT_SyainMeiboRn extends GenZT_SyainMeiboRn {

    private static final long serialVersionUID = 1L;

    public ZT_SyainMeiboRn() {
    }

    public ZT_SyainMeiboRn(String pZrnsyono) {
        super(pZrnsyono);
    }

}
