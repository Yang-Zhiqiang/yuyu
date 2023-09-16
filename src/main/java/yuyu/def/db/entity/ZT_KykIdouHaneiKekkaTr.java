package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.mapping.GenZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.meta.GenQZT_KykIdouHaneiKekkaTr;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaTr;

/**
 * 普保Ⅱ契約異動反映結果テーブル（取） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KykIdouHaneiKekkaTr} の JavaDoc を参照してください。
 * @see     GenZT_KykIdouHaneiKekkaTr
 * @see     PKZT_KykIdouHaneiKekkaTr
 * @see     QZT_KykIdouHaneiKekkaTr
 * @see     GenQZT_KykIdouHaneiKekkaTr
 */
@Entity
public class ZT_KykIdouHaneiKekkaTr extends GenZT_KykIdouHaneiKekkaTr {

    private static final long serialVersionUID = 1L;

    public ZT_KykIdouHaneiKekkaTr() {
    }

    public ZT_KykIdouHaneiKekkaTr(String pZtrhuho2kyknokbn, String pZtrhuho2kykno) {
        super(pZtrhuho2kyknokbn, pZtrhuho2kykno);
    }

}
