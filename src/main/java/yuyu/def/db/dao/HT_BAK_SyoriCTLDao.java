package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_BAK_SyoriCTL;

/**
 * 処理コントロールバックアップテーブル(HT_BAK_SyoriCTLDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BAK_SyoriCTLDao extends AbstractDao<HT_BAK_SyoriCTL> {

    public HT_BAK_SyoriCTLDao() {
        super(HT_BAK_SyoriCTL.class);
    }

    public HT_BAK_SyoriCTL getBAKSyoriCTL(String pMosno,
            String pTrkssikibetukey){
        HT_BAK_SyoriCTL hT_BAK_SyoriCTL =  new HT_BAK_SyoriCTL();
        hT_BAK_SyoriCTL.setMosno(pMosno);
        hT_BAK_SyoriCTL.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(hT_BAK_SyoriCTL);
    }

    public List<HT_BAK_SyoriCTL> getBAKSyoriCTLsByMosno(String pMosno) {
        HT_BAK_SyoriCTL hT_BAK_SyoriCTL = new HT_BAK_SyoriCTL();

        hT_BAK_SyoriCTL.setMosno(pMosno);

        return this.select(hT_BAK_SyoriCTL);
    }

    public List<HT_BAK_SyoriCTL> getBAKSyoriCTLsBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {
        HT_BAK_SyoriCTL hT_BAK_SyoriCTL = new HT_BAK_SyoriCTL();
        hT_BAK_SyoriCTL.setSyono(pSyono);
        hT_BAK_SyoriCTL.setTrkssikibetukey(pTrkssikibetukey);
        return this.select(hT_BAK_SyoriCTL);
    }
}
