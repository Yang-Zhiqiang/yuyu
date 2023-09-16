package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisin;
import java.util.List;

/**
 * ＤＳメール配信テーブル(MT_DsMailHaisinDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsMailHaisinDao extends AbstractDao<MT_DsMailHaisin> {

    public MT_DsMailHaisinDao() {
        super(MT_DsMailHaisin.class);
    }

    @Deprecated
    public MT_DsMailHaisin getDsMailHaisin(BizDate pSousinymd, String pDskokmailaddressskbtkey, C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn, String pDssousinno) {
        MT_DsMailHaisin mT_DsMailHaisin =  new MT_DsMailHaisin();
        mT_DsMailHaisin.setSousinymd(pSousinymd);
        mT_DsMailHaisin.setDskokmailaddressskbtkey(pDskokmailaddressskbtkey);
        mT_DsMailHaisin.setDssousinmailsyubetukbn(pDssousinmailsyubetukbn);
        mT_DsMailHaisin.setDssousinno(pDssousinno);
        return this.selectOne(mT_DsMailHaisin);
    }

    @Override
    @Deprecated
    public List<MT_DsMailHaisin> selectAll() {
        return super.selectAll();
    }
}
