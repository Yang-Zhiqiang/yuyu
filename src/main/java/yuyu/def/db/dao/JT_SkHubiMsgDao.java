package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JT_SkHubiMsg;

/**
 * 請求不備テーブル(JT_SkHubiMsgDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SkHubiMsgDao extends AbstractDao<JT_SkHubiMsg> {

    public JT_SkHubiMsgDao() {
        super(JT_SkHubiMsg.class);
    }

    @Deprecated
    public JT_SkHubiMsg getSkHubiMsg(String pSkno,
         String pSyono,
         Integer pSeikyuurirekino,
         Integer pRenno3keta){
        JT_SkHubiMsg jT_SkHubiMsg =  new JT_SkHubiMsg();
        jT_SkHubiMsg.setSkno(pSkno);
        jT_SkHubiMsg.setSyono(pSyono);
        jT_SkHubiMsg.setSeikyuurirekino(pSeikyuurirekino);
        jT_SkHubiMsg.setRenno3keta(pRenno3keta);
        return this.selectOne(jT_SkHubiMsg);
    }

    @Override
    @Deprecated
    public List<JT_SkHubiMsg> selectAll() {
        return super.selectAll();
    }
}
