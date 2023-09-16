package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_ImageArriveNotice;
import yuyu.def.db.mapping.GenWT_ImageArriveNotice;
import yuyu.def.db.meta.GenQWT_ImageArriveNotice;
import yuyu.def.db.meta.QWT_ImageArriveNotice;

/**
 * 到着予定通知情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_ImageArriveNotice} の JavaDoc を参照してください。
 * @see     GenWT_ImageArriveNotice
 * @see     PKWT_ImageArriveNotice
 * @see     QWT_ImageArriveNotice
 * @see     GenQWT_ImageArriveNotice
 */
@Entity
public class WT_ImageArriveNotice extends GenWT_ImageArriveNotice {

    private static final long serialVersionUID = 1L;

    public WT_ImageArriveNotice() {
    }

    public WT_ImageArriveNotice(String pArriveKey) {
        super(pArriveKey);
    }

}
