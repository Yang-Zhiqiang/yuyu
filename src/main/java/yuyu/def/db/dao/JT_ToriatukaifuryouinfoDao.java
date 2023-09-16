package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;

/**
 * 取扱不良情報テーブル(JT_ToriatukaifuryouinfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_ToriatukaifuryouinfoDao extends AbstractDao<JT_Toriatukaifuryouinfo> {

    public JT_ToriatukaifuryouinfoDao() {
        super(JT_Toriatukaifuryouinfo.class);
    }

    @Deprecated
    public JT_Toriatukaifuryouinfo getToriatukaifuryouinfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_Toriatukaifuryouinfo jT_Toriatukaifuryouinfo =  new JT_Toriatukaifuryouinfo();
        jT_Toriatukaifuryouinfo.setSkno(pSkno);
        jT_Toriatukaifuryouinfo.setSyono(pSyono);
        jT_Toriatukaifuryouinfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_Toriatukaifuryouinfo);
    }

    @Override
    @Deprecated
    public List<JT_Toriatukaifuryouinfo> selectAll() {
        return super.selectAll();
    }
}
