package yuyu.batch.hozen.khansyuu.khkariukekinseibitokusoku.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.meta.QIT_Kariukekin;
import yuyu.def.db.meta.QIT_KrkknSeibiTokusokuInfo;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 案内収納 仮受金整備督促Daoクラス
 */
public class KhKariukekinSeibiTokusokuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<KariukeTokusokuTaisyouBean> getKariukeTokusokuTaisyouBean(String pIbKakutyoujobcd,
        BizDate pKrkkeijyoymd) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");

        String strSql = $SELECT + $NEW(KariukeTokusokuTaisyouBean.class,
            qIT_Kariukekin.syono,
            qIT_Kariukekin.kbnkey,
            qIT_Kariukekin.krkno,
            qIT_Kariukekin.krkkeijyoymd,
            qIT_Kariukekin.krkgk.getTypeFieldName(),
            qIT_Kariukekin.krkgk.getValueFieldName(),
            qIT_Kariukekin.hasseidenymd,
            qIT_Kariukekin.seisandenymd,
            qIT_Kariukekin.krkseisanzumiflg,
            qIT_Kariukekin.krkriyuukbn,
            qIT_Kariukekin.nyknaiyoukbn,
            qIT_Kariukekin.nykkeiro,
            qIT_Kariukekin.jyuutouym,
            qIT_Kariukekin.jyutoukaisuuy,
            qIT_Kariukekin.jyutoukaisuum,
            qIT_Kariukekin.ryosyuymd,
            qIT_Kariukekin.hrkkaisuu) +
            $FROM(qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.krkkeijyoymd.le(pKrkkeijyoymd) +
            $AND + qIT_Kariukekin.krkseisanzumiflg.ne(C_Krkseisanzumiflg.SUMI) +
            $ORDER_BY(qIT_Kariukekin.krkkeijyoymd.asc(),
                qIT_Kariukekin.syono.asc(),
                qIT_Kariukekin.krkno.asc());

        ExDBResults<KariukeTokusokuTaisyouBean> exDBResults = exDBEntityManager.createJPQL(strSql,
            KariukeTokusokuTaisyouBean.class).bind(qIT_Kariukekin).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pIbKakutyoujobcd));

        return exDBResults;
    }

    public IT_KykKihon getKykKihon(String pSyono) {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        return kykKihon;
    }

    public IT_KykSya getKykSya(IT_KykKihon pKykKihon) {
        try {
            IT_KykSya kykSya = pKykKihon.getKykSya();

            return kykSya;
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Long getKariukekinCount(String pSyono) {

        QIT_Kariukekin qIT_Kariukekin = new QIT_Kariukekin("qIT_Kariukekin");

        String strSql = $SELECT + $COUNT + "(*)" +
            $FROM(qIT_Kariukekin) +
            $WHERE + qIT_Kariukekin.syono.eq(pSyono)+
            $AND + qIT_Kariukekin.krkseisanzumiflg.ne(C_Krkseisanzumiflg.SUMI);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_Kariukekin).getSingleResult();
    }

    public void deleteKrkknSeibiTokusokuInfo() {

        QIT_KrkknSeibiTokusokuInfo qIT_KrkknSeibiTokusokuInfo = new QIT_KrkknSeibiTokusokuInfo("qIT_KrkknSeibiTokusokuInfo");

        String strSql = $DELETE_FROM(qIT_KrkknSeibiTokusokuInfo);

        exDBEntityManager.createJPQL(strSql).bind(qIT_KrkknSeibiTokusokuInfo).executeUpdate();
    }
}
