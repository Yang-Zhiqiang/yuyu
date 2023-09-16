package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.db.entity.JT_SkKkn;

/**
 * 請求期間テーブル(JT_SkKknDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SkKknDao extends AbstractDao<JT_SkKkn> {

    public JT_SkKknDao() {
        super(JT_SkKkn.class);
    }

    @Deprecated
    public JT_SkKkn getSkKkn(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino,
         Integer pUketukeno,
         C_KyuuhuKbn pKyuuhukbn,
         Integer pRenno){
        JT_SkKkn jT_SkKkn =  new JT_SkKkn();
        jT_SkKkn.setSkno(pSkno);
        jT_SkKkn.setSyono(pSyono);
        jT_SkKkn.setSeikyuurirekino(pSeikyuurirekino);
        jT_SkKkn.setUketukeno(pUketukeno);
        jT_SkKkn.setKyuuhukbn(pKyuuhukbn);
        jT_SkKkn.setRenno(pRenno);
        return this.selectOne(jT_SkKkn);
    }

    @Override
    @Deprecated
    public List<JT_SkKkn> selectAll() {
        return super.selectAll();
    }
}
