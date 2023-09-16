package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SiDetailKkn;

/**
 * 支払明細期間テーブル(JT_SiDetailKknDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiDetailKknDao extends AbstractDao<JT_SiDetailKkn> {

    public JT_SiDetailKknDao() {
        super(JT_SiDetailKkn.class);
    }

    @Deprecated
    public JT_SiDetailKkn getSiDetailKkn(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino,
         Integer pUketukeno,
         String pKyuuhucd,
         Integer pRenno,
         Integer pRenno2keta2){
        JT_SiDetailKkn jT_SiDetailKkn =  new JT_SiDetailKkn();
        jT_SiDetailKkn.setSkno(pSkno);
        jT_SiDetailKkn.setSyono(pSyono);
        jT_SiDetailKkn.setSeikyuurirekino(pSeikyuurirekino);
        jT_SiDetailKkn.setUketukeno(pUketukeno);
        jT_SiDetailKkn.setKyuuhucd(pKyuuhucd);
        jT_SiDetailKkn.setRenno(pRenno);
        jT_SiDetailKkn.setRenno2keta2(pRenno2keta2);
        return this.selectOne(jT_SiDetailKkn);
    }

    @Override
    @Deprecated
    public List<JT_SiDetailKkn> selectAll() {
        return super.selectAll();
    }
}
