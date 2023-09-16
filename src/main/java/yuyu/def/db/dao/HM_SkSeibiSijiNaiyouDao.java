package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HM_SkSeibiSijiNaiyou;

/**
 * 新契約整備指示内容マスタ(HM_SkSeibiSijiNaiyouDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SkSeibiSijiNaiyouDao extends AbstractDao<HM_SkSeibiSijiNaiyou> {

    public HM_SkSeibiSijiNaiyouDao() {
        super(HM_SkSeibiSijiNaiyou.class);
    }

    public HM_SkSeibiSijiNaiyou getSkSeibiSijiNaiyou(String pSkseibisijinaiyoucd){
        HM_SkSeibiSijiNaiyou hM_SkSeibiSijiNaiyou =  new HM_SkSeibiSijiNaiyou();
        hM_SkSeibiSijiNaiyou.setSkseibisijinaiyoucd(pSkseibisijinaiyoucd);
        return this.selectOne(hM_SkSeibiSijiNaiyou);
    }

}
