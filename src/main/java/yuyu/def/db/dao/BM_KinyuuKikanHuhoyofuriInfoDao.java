package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_KinyuuKikanHuhoyofuriInfo;

/**
 * 金融機関普保預振情報マスタ(BM_KinyuuKikanHuhoyofuriInfoDao) アクセス用の DAO クラスです。<br />
 */
public class BM_KinyuuKikanHuhoyofuriInfoDao extends AbstractDao<BM_KinyuuKikanHuhoyofuriInfo> {

    public BM_KinyuuKikanHuhoyofuriInfoDao() {
        super(BM_KinyuuKikanHuhoyofuriInfo.class);
    }

    public BM_KinyuuKikanHuhoyofuriInfo getKinyuuKikanHuhoyofuriInfo(String pBankcd) {
        BM_KinyuuKikanHuhoyofuriInfo bM_KinyuuKikanHuhoyofuriInfo =  new BM_KinyuuKikanHuhoyofuriInfo();
        bM_KinyuuKikanHuhoyofuriInfo.setBankcd(pBankcd);
        return this.selectOne(bM_KinyuuKikanHuhoyofuriInfo);
    }

}
