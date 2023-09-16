package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_DairitenSyougouRn;
import yuyu.def.db.mapping.GenZT_DairitenSyougouRn;
import yuyu.def.db.meta.GenQZT_DairitenSyougouRn;
import yuyu.def.db.meta.QZT_DairitenSyougouRn;

/**
 * 代理店法人商号連動ＵＬＦテーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_DairitenSyougouRn} の JavaDoc を参照してください。
 * @see     GenZT_DairitenSyougouRn
 * @see     PKZT_DairitenSyougouRn
 * @see     QZT_DairitenSyougouRn
 * @see     GenQZT_DairitenSyougouRn
 */
@Entity
public class ZT_DairitenSyougouRn extends GenZT_DairitenSyougouRn {

    private static final long serialVersionUID = 1L;

    public ZT_DairitenSyougouRn() {
    }

    public ZT_DairitenSyougouRn(String pZrndairitencd) {
        super(pZrndairitencd);
    }

}
