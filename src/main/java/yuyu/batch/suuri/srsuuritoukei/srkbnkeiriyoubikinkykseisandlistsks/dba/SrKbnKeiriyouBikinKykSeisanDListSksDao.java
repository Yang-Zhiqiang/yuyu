package yuyu.batch.suuri.srsuuritoukei.srkbnkeiriyoubikinkykseisandlistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QST_BknkykHtjynbkn;

/**
 * 数理 数理統計 区分経理用備金契約精算Ｄ集計リスト作成機能DAOクラス
 */
public class SrKbnKeiriyouBikinKykSeisanDListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<KbnkeiriyouBknKykSeisanDDataBean> getKbnKeiriBknKykSisnD(String pKijyunymd, String pKakutyoujobcd) {

        QST_BknkykHtjynbkn qST_BknkykHtjynbkn = new QST_BknkykHtjynbkn("qST_BknkykHtjynbkn");

        String sql = $SELECT + $NEW(KbnkeiriyouBknKykSeisanDDataBean.class,
            qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn,
            qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn,
            qST_BknkykHtjynbkn.bikinnendokbn,
            qST_BknkykHtjynbkn.bikinkbn,
            $COUNT + "(*)",
            qST_BknkykHtjynbkn.tumitaterisoku.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.tumitaterisoku.getValueFieldName()),
            qST_BknkykHtjynbkn.seisand.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.seisand.getValueFieldName())) +

            $FROM(qST_BknkykHtjynbkn) +
            $WHERE + qST_BknkykHtjynbkn.srkijyunym.eq(pKijyunymd) +
            $AND + qST_BknkykHtjynbkn.kakutyoujobcd.eq(pKakutyoujobcd) +

            $GROUP_BY + qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn + "," +
            qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn + "," +
            qST_BknkykHtjynbkn.bikinnendokbn + "," +
            qST_BknkykHtjynbkn.bikinkbn + "," +
            qST_BknkykHtjynbkn.tumitaterisoku.getTypeFieldName() + "," +
            qST_BknkykHtjynbkn.seisand.getTypeFieldName() +

            $ORDER_BY(qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn.asc(),
                qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn.asc(),
                qST_BknkykHtjynbkn.bikinnendokbn.asc(),
                qST_BknkykHtjynbkn.bikinkbn.asc());

        return exDBEntityManager.createJPQL(sql, KbnkeiriyouBknKykSeisanDDataBean.class).bind(qST_BknkykHtjynbkn).getResultList();
    }

    public List<KbnkeiriyouBknKykSeisanDDataBean> getKbnKeiriBknKykSisnDZensyuGoukei(String pKijyunymd, String pKakutyoujobcd) {

        QST_BknkykHtjynbkn qST_BknkykHtjynbkn = new QST_BknkykHtjynbkn("qST_BknkykHtjynbkn");

        String sql = $SELECT + $NEW(KbnkeiriyouBknKykSeisanDDataBean.class,
            qST_BknkykHtjynbkn.bikinnendokbn,
            qST_BknkykHtjynbkn.bikinkbn,
            $COUNT + "(*)",
            qST_BknkykHtjynbkn.tumitaterisoku.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.tumitaterisoku.getValueFieldName()),
            qST_BknkykHtjynbkn.seisand.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.seisand.getValueFieldName())) +

            $FROM(qST_BknkykHtjynbkn) +
            $WHERE + qST_BknkykHtjynbkn.srkijyunym.eq(pKijyunymd) +
            $AND + qST_BknkykHtjynbkn.kakutyoujobcd.eq(pKakutyoujobcd) +

            $GROUP_BY + qST_BknkykHtjynbkn.bikinnendokbn + "," +
            qST_BknkykHtjynbkn.bikinkbn + "," +
            qST_BknkykHtjynbkn.tumitaterisoku.getTypeFieldName() + "," +
            qST_BknkykHtjynbkn.seisand.getTypeFieldName() +

            $ORDER_BY(qST_BknkykHtjynbkn.bikinnendokbn.asc(),
                qST_BknkykHtjynbkn.bikinkbn.asc());

        return exDBEntityManager.createJPQL(sql, KbnkeiriyouBknKykSeisanDDataBean.class).bind(qST_BknkykHtjynbkn).getResultList();
    }

}
