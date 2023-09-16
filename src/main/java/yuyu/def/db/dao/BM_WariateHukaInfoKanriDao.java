package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_WariateHukaInfoKanri;

/**
 * 割当不可情報管理マスタ(BM_WariateHukaInfoKanriDao) アクセス用の DAO クラスです。<br />
 */
public class BM_WariateHukaInfoKanriDao extends AbstractDao<BM_WariateHukaInfoKanri> {

    public BM_WariateHukaInfoKanriDao() {
        super(BM_WariateHukaInfoKanri.class);
    }

    public BM_WariateHukaInfoKanri getWariateHukaInfoKanri(String pSubSystemId,
        String pJimutetuzukicd,
        String pCurrenttskid,
        Integer pRenno){
        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri =  new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri.setSubSystemId(pSubSystemId);
        bM_WariateHukaInfoKanri.setJimutetuzukicd(pJimutetuzukicd);
        bM_WariateHukaInfoKanri.setCurrenttskid(pCurrenttskid);
        bM_WariateHukaInfoKanri.setRenno(pRenno);
        return this.selectOne(bM_WariateHukaInfoKanri);
    }

    public List<BM_WariateHukaInfoKanri> getWariateHukaInfoKanrisBySubSystemIdJimutetuzukicdCurrenttskidNexttskid(String pSubSystemId,
        String pJimutetuzukicd,
        String pCurrenttskid,
        String pNexttskid) {
        BM_WariateHukaInfoKanri bM_WariateHukaInfoKanri =  new BM_WariateHukaInfoKanri();
        bM_WariateHukaInfoKanri.setSubSystemId(pSubSystemId);
        bM_WariateHukaInfoKanri.setJimutetuzukicd(pJimutetuzukicd);
        bM_WariateHukaInfoKanri.setCurrenttskid(pCurrenttskid);
        bM_WariateHukaInfoKanri.setNexttskid(pNexttskid);
        return this.select(bM_WariateHukaInfoKanri);
    }
}
