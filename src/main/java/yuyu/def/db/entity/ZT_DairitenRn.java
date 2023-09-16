package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_DairitenRn;
import yuyu.def.db.mapping.GenZT_DairitenRn;
import yuyu.def.db.meta.GenQZT_DairitenRn;
import yuyu.def.db.meta.QZT_DairitenRn;

/**
 * 代理店ＰＲＴ用連動Ｆテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DairitenRn} の JavaDoc を参照してください。
 * @see     GenZT_DairitenRn
 * @see     PKZT_DairitenRn
 * @see     QZT_DairitenRn
 * @see     GenQZT_DairitenRn
 */
@Entity
public class ZT_DairitenRn extends GenZT_DairitenRn {

    private static final long serialVersionUID = 1L;

    public ZT_DairitenRn() {
    }

    public ZT_DairitenRn(String pZrndairitencd) {
        super(pZrndairitencd);
    }

}
