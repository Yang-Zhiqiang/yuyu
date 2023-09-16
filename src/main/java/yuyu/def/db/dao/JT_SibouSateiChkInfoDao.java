package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;

/**
 * 死亡査定チェック情報テーブル(JT_SibouSateiChkInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SibouSateiChkInfoDao extends AbstractDao<JT_SibouSateiChkInfo> {

    public JT_SibouSateiChkInfoDao() {
        super(JT_SibouSateiChkInfo.class);
    }

    @Deprecated
    public JT_SibouSateiChkInfo getSibouSateiChkInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_SibouSateiChkInfo jT_SibouSateiChkInfo =  new JT_SibouSateiChkInfo();
        jT_SibouSateiChkInfo.setSkno(pSkno);
        jT_SibouSateiChkInfo.setSyono(pSyono);
        jT_SibouSateiChkInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_SibouSateiChkInfo);
    }

    @Override
    @Deprecated
    public List<JT_SibouSateiChkInfo> selectAll() {
        return super.selectAll();
    }
}
