package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JM_Syujyutu;

/**
 * 手術マスタ(JM_SyujyutuDao) アクセス用の DAO クラスです。<br />
 */
public class JM_SyujyutuDao extends AbstractDao<JM_Syujyutu> {

    public JM_SyujyutuDao() {
        super(JM_Syujyutu.class);
    }

    public JM_Syujyutu getSyujyutu(String pSyujyututourokuno){
        JM_Syujyutu jM_Syujyutu =  new JM_Syujyutu();
        jM_Syujyutu.setSyujyututourokuno(pSyujyututourokuno);
        return this.selectOne(jM_Syujyutu);
    }
}
