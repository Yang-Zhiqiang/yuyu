package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.WT_PDFHozon;
import yuyu.def.db.id.PKWT_PDFHozon;

/**
 * ＰＤＦ保存テーブル(WT_PDFHozon) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_PDFHozonDao extends AbstractDao<WT_PDFHozon> {

    public WT_PDFHozonDao() {

        super(WT_PDFHozon.class);
    }

    public WT_PDFHozon getPDFHozon(String pImageId, String pPageId) {
        return selectPk(new PKWT_PDFHozon(pImageId, pPageId));
    }

    public List<WT_PDFHozon> getAllPDFHozon() {

        return selectAll();
    }
}