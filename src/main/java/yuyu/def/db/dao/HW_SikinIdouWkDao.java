package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HW_SikinIdouWk;

/**
 * 資金移動ワークテーブル(HW_SikinIdouWkDao) アクセス用の DAO クラスです。<br />
 */
public class HW_SikinIdouWkDao extends AbstractDao<HW_SikinIdouWk> {

    public HW_SikinIdouWkDao() {
        super(HW_SikinIdouWk.class);
    }

    public HW_SikinIdouWk getSikinIdouWk(BizDate pNyksyoriymd, String pItirenno) {
        HW_SikinIdouWk hW_SikinIdouWk =  new HW_SikinIdouWk();
        hW_SikinIdouWk.setNyksyoriymd(pNyksyoriymd);
        hW_SikinIdouWk.setItirenno(pItirenno);
        return this.selectOne(hW_SikinIdouWk);
    }
}
