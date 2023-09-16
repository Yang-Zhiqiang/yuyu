package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_HubiMsg;

/**
 * 不備メッセージテーブル(HT_HubiMsgDao) アクセス用の DAO クラスです。<br />
 */
public class HT_HubiMsgDao extends AbstractDao<HT_HubiMsg> {

    public HT_HubiMsgDao() {
        super(HT_HubiMsg.class);
    }

    @Deprecated
    public HT_HubiMsg getHubiMsg(String pMosno,
         Integer pRenno){
        HT_HubiMsg hT_HubiMsg =  new HT_HubiMsg();
        hT_HubiMsg.setMosno(pMosno);
        hT_HubiMsg.setRenno(pRenno);
        return this.selectOne(hT_HubiMsg);
    }

    @Override
    @Deprecated
    public List<HT_HubiMsg> selectAll() {
        return super.selectAll();
    }
}
