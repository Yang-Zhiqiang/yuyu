package yuyu.app.sinkeiyaku.sknyuukin.sktoujitunyuukintorikesi.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_NyuukinHenkinSyoriKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.meta.QHT_Nyuukin;

/**
 * 新契約 入金 当日入金取消の機能DAOクラスです。
 */
public class SkToujituNyuukinTorikesiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<HT_Nyuukin> getNyuukinTorikesiInfo(String pMosno, BizDate pNyksyoriymd, C_ZenhnknKbn pZenhnknkbn,
        C_NyuukinHenkinSyoriKbn pNyuukinhenkinsyorikbn) {

        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin("qHT_Nyuukin");

        String strSql = $SELECT + qHT_Nyuukin +
            $FROM(qHT_Nyuukin) +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.nyksyoriymd.eq(pNyksyoriymd) +
            $AND + qHT_Nyuukin.zenhnknkbn.eq(pZenhnknkbn) +
            $AND + qHT_Nyuukin.nyuukinhenkinsyorikbn.eq(pNyuukinhenkinsyorikbn) +
            $ORDER_BY(qHT_Nyuukin.renno.asc());
        return exDBEntityManager.createJPQL(strSql).bind(qHT_Nyuukin).getResultList();
    }
}
