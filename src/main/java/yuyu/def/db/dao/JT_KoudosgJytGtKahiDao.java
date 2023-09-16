package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_KoudosgJytGtKahi;

/**
 * 高度障害状態該当可否テーブル(JT_KoudosgJytGtKahiDao) アクセス用の DAO クラスです。<br />
 */
public class JT_KoudosgJytGtKahiDao extends AbstractDao<JT_KoudosgJytGtKahi> {

    public JT_KoudosgJytGtKahiDao() {
        super(JT_KoudosgJytGtKahi.class);
    }

    @Deprecated
    public JT_KoudosgJytGtKahi getKoudosgJytGtKahi(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_KoudosgJytGtKahi jT_KoudosgJytGtKahi =  new JT_KoudosgJytGtKahi();
        jT_KoudosgJytGtKahi.setSkno(pSkno);
        jT_KoudosgJytGtKahi.setSyono(pSyono);
        jT_KoudosgJytGtKahi.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_KoudosgJytGtKahi);
    }

    @Override
    @Deprecated
    public List<JT_KoudosgJytGtKahi> selectAll() {
        return super.selectAll();
    }
}
