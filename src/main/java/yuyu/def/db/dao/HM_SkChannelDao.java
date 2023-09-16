package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.HM_SkChannel;
import yuyu.def.db.meta.QBM_Tyouhyourenrakusaki;
import yuyu.def.db.meta.QHM_SkChannel;

/**
 * 新契約チャネルマスタ(HM_SkChannelDao) アクセス用の DAO クラスです。<br />
 */
public class HM_SkChannelDao extends AbstractDao<HM_SkChannel> {

    public HM_SkChannelDao() {
        super(HM_SkChannel.class);
    }

    public HM_SkChannel getSkChannel(C_Channelcd pChannelcd,
        String pOyadrtencd){
        HM_SkChannel hM_SkChannel =  new HM_SkChannel();
        hM_SkChannel.setChannelcd(pChannelcd);
        hM_SkChannel.setOyadrtencd(pOyadrtencd);
        return this.selectOne(hM_SkChannel);
    }

    public List<HM_SkChannel> getSkChannelsByChannelcd(C_Channelcd pChannelcd) {


        QHM_SkChannel qHM_SkChannel = new QHM_SkChannel();


        QBM_Tyouhyourenrakusaki qBM_Tyouhyourenrakusaki = new QBM_Tyouhyourenrakusaki();

        String querySql = $SELECT + qHM_SkChannel +
            $FROM + qHM_SkChannel.HM_SkChannel() + "," +
            qBM_Tyouhyourenrakusaki.BM_Tyouhyourenrakusaki() +
            $WHERE + qHM_SkChannel.channelcd.eq(pChannelcd) +
            $AND + qHM_SkChannel.tyhyrenrakusikibetukbn.eq(qBM_Tyouhyourenrakusaki.tyhyrenrakusikibetukbn);

        return em.createJPQL(querySql).bind(qHM_SkChannel, qBM_Tyouhyourenrakusaki).getResultList();
    }
}
