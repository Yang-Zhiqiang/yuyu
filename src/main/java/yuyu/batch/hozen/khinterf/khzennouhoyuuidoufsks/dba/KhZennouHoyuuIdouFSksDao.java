package yuyu.batch.hozen.khinterf.khzennouhoyuuidoufsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.meta.QIT_ZennouHoyuuIdouKykDtl;

/**
 * 契約保全 インターフェイス 前納保有異動契約明細Ｆ作成DAO
 */
public class KhZennouHoyuuIdouFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<ZennouHoyuuIdouKykDtlBean> getZennouHoyuuIdouKykDtlBeans(BizDate pSyoriYmd) {

        QIT_ZennouHoyuuIdouKykDtl qIT_ZennouHoyuuIdouKykDtl = new QIT_ZennouHoyuuIdouKykDtl("qIT_ZennouHoyuuIdouKykDtl");

        String strSql = $SELECT + $NEW(ZennouHoyuuIdouKykDtlBean.class,
            qIT_ZennouHoyuuIdouKykDtl.kbnkey,
            qIT_ZennouHoyuuIdouKykDtl.syono,
            qIT_ZennouHoyuuIdouKykDtl.sakuseiymd,
            qIT_ZennouHoyuuIdouKykDtl.syoricd,
            qIT_ZennouHoyuuIdouKykDtl.kykmfksnctr,
            qIT_ZennouHoyuuIdouKykDtl.henkousyoriymd,
            qIT_ZennouHoyuuIdouKykDtl.zennoukessanrecordkbn,
            qIT_ZennouHoyuuIdouKykDtl.keijyouym,
            qIT_ZennouHoyuuIdouKykDtl.denymd,
            qIT_ZennouHoyuuIdouKykDtl.zennoucalckijyunymd,
            qIT_ZennouHoyuuIdouKykDtl.zennoubikinkbn,
            qIT_ZennouHoyuuIdouKykDtl.syukeiyakusyuruicd,
            qIT_ZennouHoyuuIdouKykDtl.kbnkeirisegcd,
            qIT_ZennouHoyuuIdouKykDtl.zennoutoukeilistkbn,
            qIT_ZennouHoyuuIdouKykDtl.keiyakuymd,
            qIT_ZennouHoyuuIdouKykDtl.zennouwrbkrt,
            qIT_ZennouHoyuuIdouKykDtl.tndmatutkyrt,
            qIT_ZennouHoyuuIdouKykDtl.tndzndkhikakukbn,
            qIT_ZennouHoyuuIdouKykDtl.zennoukaisiymd,
            qIT_ZennouHoyuuIdouKykDtl.zennoukbn,
            qIT_ZennouHoyuuIdouKykDtl.zennoukikan,
            qIT_ZennouHoyuuIdouKykDtl.zennounyuukinymd,
            qIT_ZennouHoyuuIdouKykDtl.zennounyuukinkgk.getTypeFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.zennounyuukinkgk.getValueFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.toukimatuzennouzndk.getTypeFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.toukimatuzennouzndk.getValueFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.toukijyuutoup.getTypeFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.toukijyuutoup.getValueFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.toukizennouseisangk.getTypeFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.toukizennouseisangk.getValueFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.toukizennounyuukinkgk.getTypeFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.toukizennounyuukinkgk.getValueFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.yokukinenbaraip.getTypeFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.yokukinenbaraip.getValueFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.wrbkrttkyrt.getTypeFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.wrbkrttkyrt.getValueFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.gkdtznnhyj,
            qIT_ZennouHoyuuIdouKykDtl.znngaikakbn,
            qIT_ZennouHoyuuIdouKykDtl.yenkanyknhyj,
            qIT_ZennouHoyuuIdouKykDtl.znnnyknjikawaserate,
            qIT_ZennouHoyuuIdouKykDtl.znnnyknjikawaseratetkyuymd,
            qIT_ZennouHoyuuIdouKykDtl.ksnkisikawaserate,
            qIT_ZennouHoyuuIdouKykDtl.znncalckjynymdkwsrate,
            qIT_ZennouHoyuuIdouKykDtl.ksnkimatukawaserate,
            qIT_ZennouHoyuuIdouKykDtl.zennounyuukinkgktkmatu.getTypeFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.zennounyuukinkgktkmatu.getValueFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.tkmatuznnzndktkmatu.getTypeFieldName(),
            qIT_ZennouHoyuuIdouKykDtl.tkmatuznnzndktkmatu.getValueFieldName()) +
            $FROM(qIT_ZennouHoyuuIdouKykDtl) +
            $WHERE + qIT_ZennouHoyuuIdouKykDtl.sakuseiymd.eq(pSyoriYmd);

        return exDBEntityManager.createJPQL(strSql, ZennouHoyuuIdouKykDtlBean.class).bind(qIT_ZennouHoyuuIdouKykDtl).getResults();
    }
}
