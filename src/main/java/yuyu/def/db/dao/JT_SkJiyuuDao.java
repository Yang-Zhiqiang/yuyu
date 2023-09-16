package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SkJiyuu;

/**
 * 請求事由テーブル(JT_SkJiyuuDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SkJiyuuDao extends AbstractDao<JT_SkJiyuu> {

    public JT_SkJiyuuDao() {
        super(JT_SkJiyuu.class);
    }

    @Deprecated
    public JT_SkJiyuu getSkJiyuu(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino,
         Integer pUketukeno){
        JT_SkJiyuu jT_SkJiyuu =  new JT_SkJiyuu();
        jT_SkJiyuu.setSkno(pSkno);
        jT_SkJiyuu.setSyono(pSyono);
        jT_SkJiyuu.setSeikyuurirekino(pSeikyuurirekino);
        jT_SkJiyuu.setUketukeno(pUketukeno);
        return this.selectOne(jT_SkJiyuu);
    }

    @Override
    @Deprecated
    public List<JT_SkJiyuu> selectAll() {
        return super.selectAll();
    }
}
