package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import java.util.List;

/**
 * ＤＳメール配信履歴ワークテーブル(MW_DsMailHaisinRirekiWkDao) アクセス用の DAO クラスです。<br />
 */
public class MW_DsMailHaisinRirekiWkDao extends AbstractDao<MW_DsMailHaisinRirekiWk> {

    public MW_DsMailHaisinRirekiWkDao() {
        super(MW_DsMailHaisinRirekiWk.class);
    }

    @Deprecated
    public MW_DsMailHaisinRirekiWk getDsMailHaisinRirekiWk(BizDate pDsdatasakuseiymd, String pDskokno, Integer pDsmailhaisinrenban) {
        MW_DsMailHaisinRirekiWk mW_DsMailHaisinRirekiWk =  new MW_DsMailHaisinRirekiWk();
        mW_DsMailHaisinRirekiWk.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mW_DsMailHaisinRirekiWk.setDskokno(pDskokno);
        mW_DsMailHaisinRirekiWk.setDsmailhaisinrenban(pDsmailhaisinrenban);
        return this.selectOne(mW_DsMailHaisinRirekiWk);
    }

    @Override
    @Deprecated
    public List<MW_DsMailHaisinRirekiWk> selectAll() {
        return super.selectAll();
    }
}
