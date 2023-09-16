package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.mapping.GenZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.meta.GenQZT_KykIdouHaneiKekkaRn;
import yuyu.def.db.meta.QZT_KykIdouHaneiKekkaRn;

/**
 * 普保Ⅱ契約異動反映結果テーブル（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_KykIdouHaneiKekkaRn} の JavaDoc を参照してください。
 * @see     GenZT_KykIdouHaneiKekkaRn
 * @see     PKZT_KykIdouHaneiKekkaRn
 * @see     QZT_KykIdouHaneiKekkaRn
 * @see     GenQZT_KykIdouHaneiKekkaRn
 */
@Entity
public class ZT_KykIdouHaneiKekkaRn extends GenZT_KykIdouHaneiKekkaRn {

    private static final long serialVersionUID = 1L;

    public ZT_KykIdouHaneiKekkaRn() {
    }

    public ZT_KykIdouHaneiKekkaRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        super(pZrnhuho2kyknokbn, pZrnhuho2kykno);
    }

}
