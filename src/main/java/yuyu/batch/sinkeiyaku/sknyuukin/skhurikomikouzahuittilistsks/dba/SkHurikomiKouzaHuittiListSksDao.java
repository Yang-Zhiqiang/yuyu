package yuyu.batch.sinkeiyaku.sknyuukin.skhurikomikouzahuittilistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QHM_Honkouza;
import yuyu.def.db.meta.QHW_SikinIdouWk;

/**
 * 新契約 入金 振込口座不一致リスト作成の機能DAOクラスです。
 */
public class SkHurikomiKouzaHuittiListSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public ExDBResults<SikinidouInfoBean> getSikinidouInfosBySyoriYmd(BizDate pSyoriYmd) {

        QHW_SikinIdouWk qHW_SikinIdouWk = new QHW_SikinIdouWk("qHW_SikinIdouWk");
        QHM_Honkouza qHM_HonkouzaSikinidoumoto = new QHM_Honkouza("qHM_Honkouza1");
        QHM_Honkouza qHM_HonkouzaSikinidousaki = new QHM_Honkouza("qHM_Honkouza2");

        String strSql = $SELECT + $NEW(SikinidouInfoBean.class,
            qHW_SikinIdouWk.sikinidoumotohonkouzacd,
            qHM_HonkouzaSikinidoumoto.bankcd,
            qHM_HonkouzaSikinidoumoto.sitencd,
            qHM_HonkouzaSikinidoumoto.kouzano,
            qHM_HonkouzaSikinidoumoto.tuukasyu,
            qHW_SikinIdouWk.sikinidougaku.getTypeFieldName(),
            qHW_SikinIdouWk.sikinidougaku.getValueFieldName(),
            qHW_SikinIdouWk.sikinidousakihonkouzacd,
            qHM_HonkouzaSikinidousaki.sikinidousakibankcd,
            qHM_HonkouzaSikinidousaki.sikinidousakisitencd,
            qHM_HonkouzaSikinidousaki.sikinidousakikouzano,
            qHM_HonkouzaSikinidousaki.tuukasyu,
            qHW_SikinIdouWk.nykmosno) +
            $FROM(qHW_SikinIdouWk,
                qHM_HonkouzaSikinidoumoto,
                qHM_HonkouzaSikinidousaki) +
                $WHERE + qHW_SikinIdouWk.syoriYmd.eq(pSyoriYmd) +
                $AND + qHW_SikinIdouWk.sikinidoumotohonkouzacd.eq(qHM_HonkouzaSikinidoumoto.honkouzacd) +
                $AND + qHW_SikinIdouWk.sikinidousakihonkouzacd.eq(qHM_HonkouzaSikinidousaki.honkouzacd) +
                $ORDER_BY(qHM_HonkouzaSikinidoumoto.hyoujijyun.asc(),
                    qHM_HonkouzaSikinidousaki.hyoujijyun.asc());

        return exDBEntityManager.createJPQL(strSql)
            .bind(qHW_SikinIdouWk, qHM_HonkouzaSikinidoumoto, qHM_HonkouzaSikinidousaki).getResults();

    }
}
