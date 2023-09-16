package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_KouzahuriStartAnnai;

/**
 * 口座振替開始案内テーブル(IT_KouzahuriStartAnnaiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KouzahuriStartAnnaiDao extends AbstractDao<IT_KouzahuriStartAnnai> {

    public IT_KouzahuriStartAnnaiDao() {
        super(IT_KouzahuriStartAnnai.class);
    }

    public IT_KouzahuriStartAnnai getKouzahuriStartAnnai(String pSyono) {
        IT_KouzahuriStartAnnai iT_KouzahuriStartAnnai =  new IT_KouzahuriStartAnnai();
        iT_KouzahuriStartAnnai.setSyono(pSyono);
        return this.selectOne(iT_KouzahuriStartAnnai);
    }
}
