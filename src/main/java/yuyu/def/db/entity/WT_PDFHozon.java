package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_PDFHozon;
import yuyu.def.db.mapping.GenWT_PDFHozon;
import yuyu.def.db.meta.GenQWT_PDFHozon;
import yuyu.def.db.meta.QWT_PDFHozon;

/**
 * ＰＤＦ保存テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_PDFHozon} の JavaDoc を参照してください。
 * @see     GenWT_PDFHozon
 * @see     PKWT_PDFHozon
 * @see     QWT_PDFHozon
 * @see     GenQWT_PDFHozon
 */
@Entity
public class WT_PDFHozon extends GenWT_PDFHozon {

    private static final long serialVersionUID = 1L;

    public WT_PDFHozon() {
    }

    public WT_PDFHozon(String pIwfImageId, String pPageId) {
        super(pIwfImageId, pPageId);
    }

}
