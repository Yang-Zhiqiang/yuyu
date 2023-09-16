package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SdsGizouKaizanInfo;

/**
 * 診断書偽造改竄情報テーブル(JT_SdsGizouKaizanInfoDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SdsGizouKaizanInfoDao extends AbstractDao<JT_SdsGizouKaizanInfo> {

    public JT_SdsGizouKaizanInfoDao() {
        super(JT_SdsGizouKaizanInfo.class);
    }

    @Deprecated
    public JT_SdsGizouKaizanInfo getSdsGizouKaizanInfo(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino){
        JT_SdsGizouKaizanInfo jT_SdsGizouKaizanInfo =  new JT_SdsGizouKaizanInfo();
        jT_SdsGizouKaizanInfo.setSkno(pSkno);
        jT_SdsGizouKaizanInfo.setSyono(pSyono);
        jT_SdsGizouKaizanInfo.setSeikyuurirekino(pSeikyuurirekino);
        return this.selectOne(jT_SdsGizouKaizanInfo);
    }

    @Override
    @Deprecated
    public List<JT_SdsGizouKaizanInfo> selectAll() {
        return super.selectAll();
    }
}
