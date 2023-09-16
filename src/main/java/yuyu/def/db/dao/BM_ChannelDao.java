package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_Channel;

/**
 * チャネルマスタ(BM_ChannelDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChannelDao extends AbstractDao<BM_Channel> {

    public BM_ChannelDao() {
        super(BM_Channel.class);
    }

    public BM_Channel getChannel(C_Channelcd pChannelcd) {
        BM_Channel bM_Channel =  new BM_Channel();
        bM_Channel.setChannelcd(pChannelcd);
        return this.selectOne(bM_Channel);
    }
}
