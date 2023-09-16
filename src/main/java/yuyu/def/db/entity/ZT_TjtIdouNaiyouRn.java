package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_TjtIdouNaiyouRn;
import yuyu.def.db.mapping.GenZT_TjtIdouNaiyouRn;
import yuyu.def.db.meta.GenQZT_TjtIdouNaiyouRn;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouRn;

/**
 * 当日異動内容テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_TjtIdouNaiyouRn} の JavaDoc を参照してください。
 * @see     GenZT_TjtIdouNaiyouRn
 * @see     PKZT_TjtIdouNaiyouRn
 * @see     QZT_TjtIdouNaiyouRn
 * @see     GenQZT_TjtIdouNaiyouRn
 */
@Entity
public class ZT_TjtIdouNaiyouRn extends GenZT_TjtIdouNaiyouRn {

    private static final long serialVersionUID = 1L;

    public ZT_TjtIdouNaiyouRn() {
    }

    public ZT_TjtIdouNaiyouRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        super(pZrnhuho2kyknokbn, pZrnhuho2kykno);
    }

}
