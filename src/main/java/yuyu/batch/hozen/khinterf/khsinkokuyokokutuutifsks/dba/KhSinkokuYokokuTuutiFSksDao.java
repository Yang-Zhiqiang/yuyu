package yuyu.batch.hozen.khinterf.khsinkokuyokokutuutifsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.db.meta.QIT_SinkokuyokokuTuuti;

/**
 * 契約保全 インターフェイス 申告予告通知Ｆ作成機能DAOクラス
 */
public class KhSinkokuYokokuTuutiFSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<SinkokuYokokuTuutiDataBean> getSinkokuYokokuTuutiByKakutyoujobcdTyouhyouymdKbnkey(
        String pKakutyoujobcd, BizDate pSyoriYmd, String pKbnkey) {

        QIT_SinkokuyokokuTuuti qIT_SinkokuyokokuTuuti = new QIT_SinkokuyokokuTuuti("qIT_SinkokuyokokuTuuti");

        String strSql = $SELECT + $NEW(SinkokuYokokuTuutiDataBean.class,
            qIT_SinkokuyokokuTuuti.kbnkey,
            qIT_SinkokuyokokuTuuti.syono,
            qIT_SinkokuyokokuTuuti.nendo,
            qIT_SinkokuyokokuTuuti.tyouhyouymd,
            qIT_SinkokuyokokuTuuti.renno,
            qIT_SinkokuyokokuTuuti.syoruiCd,
            qIT_SinkokuyokokuTuuti.hassoukbn,
            qIT_SinkokuyokokuTuuti.tsinyno,
            qIT_SinkokuyokokuTuuti.tsinadr1kj,
            qIT_SinkokuyokokuTuuti.tsinadr2kj,
            qIT_SinkokuyokokuTuuti.tsinadr3kj,
            qIT_SinkokuyokokuTuuti.toiawasesosikinmkj,
            qIT_SinkokuyokokuTuuti.toiawaseyno,
            qIT_SinkokuyokokuTuuti.toiawaseadr1kj,
            qIT_SinkokuyokokuTuuti.toiawaseadr2kj,
            qIT_SinkokuyokokuTuuti.toiawaseadr3kj,
            qIT_SinkokuyokokuTuuti.toiawasetelno,
            qIT_SinkokuyokokuTuuti.toiawaseteluktkkanou1,
            qIT_SinkokuyokokuTuuti.toiawaseteluktkkanou2,
            qIT_SinkokuyokokuTuuti.toiawasesosikinmkj2,
            qIT_SinkokuyokokuTuuti.toiawasetelno2,
            qIT_SinkokuyokokuTuuti.kyknmkj,
            qIT_SinkokuyokokuTuuti.sinkokunen,
            qIT_SinkokuyokokuTuuti.midasi1,
            qIT_SinkokuyokokuTuuti.midasi2,
            qIT_SinkokuyokokuTuuti.midasi3,
            qIT_SinkokuyokokuTuuti.midasi4,
            qIT_SinkokuyokokuTuuti.midasi5,
            qIT_SinkokuyokokuTuuti.midasi6,
            qIT_SinkokuyokokuTuuti.midasi7,
            qIT_SinkokuyokokuTuuti.kihonjouhoumongon1,
            qIT_SinkokuyokokuTuuti.kihonjouhoumongon2,
            qIT_SinkokuyokokuTuuti.kihonjouhoumongon3,
            qIT_SinkokuyokokuTuuti.kihonjouhoumongon4,
            qIT_SinkokuyokokuTuuti.kihonjouhoumongon5,
            qIT_SinkokuyokokuTuuti.kihonjouhoumongon6,
            qIT_SinkokuyokokuTuuti.kihonjouhoumongon7,
            qIT_SinkokuyokokuTuuti.newippanykkp.getTypeFieldName(),
            qIT_SinkokuyokokuTuuti.newippanykkp.getValueFieldName(),
            qIT_SinkokuyokokuTuuti.newippanykkhaitoukin.getTypeFieldName(),
            qIT_SinkokuyokokuTuuti.newippanykkhaitoukin.getValueFieldName(),
            qIT_SinkokuyokokuTuuti.newippanykksyoumeigk.getTypeFieldName(),
            qIT_SinkokuyokokuTuuti.newippanykksyoumeigk.getValueFieldName(),
            qIT_SinkokuyokokuTuuti.newiryouykkp.getTypeFieldName(),
            qIT_SinkokuyokokuTuuti.newiryouykkp.getValueFieldName(),
            qIT_SinkokuyokokuTuuti.newiryouykkhaitoukin.getTypeFieldName(),
            qIT_SinkokuyokokuTuuti.newiryouykkhaitoukin.getValueFieldName(),
            qIT_SinkokuyokokuTuuti.newiryouykksyoumeigk.getTypeFieldName(),
            qIT_SinkokuyokokuTuuti.newiryouykksyoumeigk.getValueFieldName(),
            qIT_SinkokuyokokuTuuti.newnenkinykkp.getTypeFieldName(),
            qIT_SinkokuyokokuTuuti.newnenkinykkp.getValueFieldName(),
            qIT_SinkokuyokokuTuuti.newnenkinykkhaitoukin.getTypeFieldName(),
            qIT_SinkokuyokokuTuuti.newnenkinykkhaitoukin.getValueFieldName(),
            qIT_SinkokuyokokuTuuti.newnenkinykksyoumeigk.getTypeFieldName(),
            qIT_SinkokuyokokuTuuti.newnenkinykksyoumeigk.getValueFieldName(),
            qIT_SinkokuyokokuTuuti.hknjyutoukikan,
            qIT_SinkokuyokokuTuuti.kykymd,
            qIT_SinkokuyokokuTuuti.hrkkaisuu) +
            $FROM(qIT_SinkokuyokokuTuuti) +
            $WHERE + qIT_SinkokuyokokuTuuti.tyouhyouymd.eq(pSyoriYmd);

        if (!BizUtil.isBlank(pKbnkey)) {

            strSql = strSql + $AND + qIT_SinkokuyokokuTuuti.kbnkey.eq(pKbnkey);
        }

        ExDBResults<SinkokuYokokuTuutiDataBean> exDBResults = exDBEntityManager.createJPQL(
            strSql, SinkokuYokokuTuutiDataBean.class).bind(qIT_SinkokuyokokuTuuti).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
