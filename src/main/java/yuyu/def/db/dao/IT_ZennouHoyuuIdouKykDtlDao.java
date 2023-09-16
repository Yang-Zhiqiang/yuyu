package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_ZennouHoyuuIdouKykDtl;

/**
 * 前納保有異動契約明細テーブル(IT_ZennouHoyuuIdouKykDtlDao) アクセス用の DAO クラスです。<br />
 */
public class IT_ZennouHoyuuIdouKykDtlDao extends AbstractDao<IT_ZennouHoyuuIdouKykDtl> {

    public IT_ZennouHoyuuIdouKykDtlDao() {
        super(IT_ZennouHoyuuIdouKykDtl.class);
    }

    public IT_ZennouHoyuuIdouKykDtl getZennouHoyuuIdouKykDtl(String pSyono, BizDate pSakuseiymd, String pSyoricd, Integer pKykmfksnctr) {
        IT_ZennouHoyuuIdouKykDtl iT_ZennouHoyuuIdouKykDtl =  new IT_ZennouHoyuuIdouKykDtl();
        iT_ZennouHoyuuIdouKykDtl.setSyono(pSyono);
        iT_ZennouHoyuuIdouKykDtl.setSakuseiymd(pSakuseiymd);
        iT_ZennouHoyuuIdouKykDtl.setSyoricd(pSyoricd);
        iT_ZennouHoyuuIdouKykDtl.setKykmfksnctr(pKykmfksnctr);
        return this.selectOne(iT_ZennouHoyuuIdouKykDtl);
    }
}
