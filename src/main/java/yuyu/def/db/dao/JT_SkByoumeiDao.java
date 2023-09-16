package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SkByoumei;

/**
 * 請求病名テーブル(JT_SkByoumeiDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SkByoumeiDao extends AbstractDao<JT_SkByoumei> {

    public JT_SkByoumeiDao() {
        super(JT_SkByoumei.class);
    }

    @Deprecated
    public JT_SkByoumei getSkByoumei(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino,
         Integer pUketukeno,
         Integer pRenno){
        JT_SkByoumei jT_SkByoumei =  new JT_SkByoumei();
        jT_SkByoumei.setSkno(pSkno);
        jT_SkByoumei.setSyono(pSyono);
        jT_SkByoumei.setSeikyuurirekino(pSeikyuurirekino);
        jT_SkByoumei.setUketukeno(pUketukeno);
        jT_SkByoumei.setRenno(pRenno);
        return this.selectOne(jT_SkByoumei);
    }

    @Override
    @Deprecated
    public List<JT_SkByoumei> selectAll() {
        return super.selectAll();
    }
}
