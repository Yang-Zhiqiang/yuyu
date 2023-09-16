package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_Page;
import yuyu.def.db.mapping.GenWT_Page;
import yuyu.def.db.meta.GenQWT_Page;
import yuyu.def.db.meta.QWT_Page;

/**
 * ページテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_Page} の JavaDoc を参照してください。
 * @see     GenWT_Page
 * @see     PKWT_Page
 * @see     QWT_Page
 * @see     GenQWT_Page
 */
@Entity
public class WT_Page extends GenWT_Page {

    private static final long serialVersionUID = 1L;

    public WT_Page() {
    }

    public WT_Page(
        String pIwfImageId,
        String pSyoruittykymdtime,
        Integer pPageno
    ) {
        super(
            pIwfImageId,
            pSyoruittykymdtime,
            pPageno
        );
    }

}
