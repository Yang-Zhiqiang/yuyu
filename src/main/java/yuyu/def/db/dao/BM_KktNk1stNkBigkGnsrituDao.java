package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KktNk1stNkBigkGnsritu;

/**
 * 確定年金（第１回年金倍額型）原資率マスタ(BM_KktNk1stNkBigkGnsrituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_KktNk1stNkBigkGnsrituDao extends AbstractDao<BM_KktNk1stNkBigkGnsritu> {

    public BM_KktNk1stNkBigkGnsrituDao() {
        super(BM_KktNk1stNkBigkGnsritu.class);
    }

    public BM_KktNk1stNkBigkGnsritu getKktNk1stNkBigkGnsritu(String pRyouritusdno, C_Tuukasyu pTuukasyu, Integer pShrkkn) {
        BM_KktNk1stNkBigkGnsritu bM_KktNk1stNkBigkGnsritu =  new BM_KktNk1stNkBigkGnsritu();
        bM_KktNk1stNkBigkGnsritu.setRyouritusdno(pRyouritusdno);
        bM_KktNk1stNkBigkGnsritu.setTuukasyu(pTuukasyu);
        bM_KktNk1stNkBigkGnsritu.setShrkkn(pShrkkn);
        return this.selectOne(bM_KktNk1stNkBigkGnsritu);
    }
}
