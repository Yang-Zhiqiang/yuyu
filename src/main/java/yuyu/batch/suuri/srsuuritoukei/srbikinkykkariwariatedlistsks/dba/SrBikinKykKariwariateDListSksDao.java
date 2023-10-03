package yuyu.batch.suuri.srsuuritoukei.srbikinkykkariwariatedlistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QST_BknkykHtjynbkn;

/**
 * 数理 数理統計 備金契約仮割当Ｄ集計リスト作成機能DAOクラス
 */
public class SrBikinKykKariwariateDListSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<BknKykKariDDataBean> getBknKykKariD(String pKijyunymd, String pKakutyoujobcd) {

        QST_BknkykHtjynbkn qST_BknkykHtjynbkn = new QST_BknkykHtjynbkn("qST_BknkykHtjynbkn");

        String sql = $SELECT + $NEW(BknKykKariDDataBean.class,
            qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn,
            qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn,
            qST_BknkykHtjynbkn.syukeiyakusyuruicd,
            qST_BknkykHtjynbkn.bikinnendokbn,
            qST_BknkykHtjynbkn.bikinkbn,
            $COUNT + "(*)",
            qST_BknkykHtjynbkn.kariwariatedrisoku.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.kariwariatedrisoku.getValueFieldName()),
            qST_BknkykHtjynbkn.kariwariatedganrikin.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.kariwariatedganrikin.getValueFieldName())) +

            $FROM(qST_BknkykHtjynbkn) +
            $WHERE + qST_BknkykHtjynbkn.srkijyunym.eq(pKijyunymd) +
            $AND + qST_BknkykHtjynbkn.kakutyoujobcd.eq(pKakutyoujobcd) +

            $GROUP_BY + qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn + "," +
            qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn + "," +
            qST_BknkykHtjynbkn.syukeiyakusyuruicd + "," +
            qST_BknkykHtjynbkn.bikinnendokbn + "," +
            qST_BknkykHtjynbkn.bikinkbn + "," +
            qST_BknkykHtjynbkn.kariwariatedrisoku.getTypeFieldName() + "," +
            qST_BknkykHtjynbkn.kariwariatedganrikin.getTypeFieldName() +

            $ORDER_BY(qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn.asc(),
                qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn.asc(),
                qST_BknkykHtjynbkn.syukeiyakusyuruicd.asc(),
                qST_BknkykHtjynbkn.bikinnendokbn.asc(),
                qST_BknkykHtjynbkn.bikinkbn.asc());

        return exDBEntityManager.createJPQL(sql, BknKykKariDDataBean.class).bind(qST_BknkykHtjynbkn).getResultList();
    }

    public List<BknKykKariDDataBean> getBknKykKariDSegmentGoukei(String pKijyunymd, String pKakutyoujobcd,
        String pKbnkeiriyousegmentkbn, String pKbnkeiriyourgnbnskkbn) {

        QST_BknkykHtjynbkn qST_BknkykHtjynbkn = new QST_BknkykHtjynbkn("qST_BknkykHtjynbkn");

        String sql = $SELECT + $NEW(BknKykKariDDataBean.class,
            qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn,
            qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn,
            qST_BknkykHtjynbkn.bikinnendokbn,
            qST_BknkykHtjynbkn.bikinkbn,
            $COUNT + "(*)",
            qST_BknkykHtjynbkn.kariwariatedrisoku.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.kariwariatedrisoku.getValueFieldName()),
            qST_BknkykHtjynbkn.kariwariatedganrikin.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.kariwariatedganrikin.getValueFieldName())) +

            $FROM(qST_BknkykHtjynbkn) +
            $WHERE + qST_BknkykHtjynbkn.srkijyunym.eq(pKijyunymd) +
            $AND + qST_BknkykHtjynbkn.kakutyoujobcd.eq(pKakutyoujobcd) +
            $AND + qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn.eq(pKbnkeiriyousegmentkbn) +
            $AND + qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn.eq(pKbnkeiriyourgnbnskkbn) +

            $GROUP_BY + qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn + "," +
            qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn + "," +
            qST_BknkykHtjynbkn.bikinnendokbn + "," +
            qST_BknkykHtjynbkn.bikinkbn + "," +
            qST_BknkykHtjynbkn.kariwariatedrisoku.getTypeFieldName() + "," +
            qST_BknkykHtjynbkn.kariwariatedganrikin.getTypeFieldName() +

            $ORDER_BY(qST_BknkykHtjynbkn.kbnkeiriyousegmentkbn.asc(),
                qST_BknkykHtjynbkn.kbnkeiriyourgnbnskkbn.asc(),
                qST_BknkykHtjynbkn.bikinnendokbn.asc(),
                qST_BknkykHtjynbkn.bikinkbn.asc());

        return exDBEntityManager.createJPQL(sql, BknKykKariDDataBean.class).bind(qST_BknkykHtjynbkn).getResultList();
    }

    public List<BknKykKariDDataBean> getBknKykKariDZensyuGoukei(String pKijyunymd, String pKakutyoujobcd) {

        QST_BknkykHtjynbkn qST_BknkykHtjynbkn = new QST_BknkykHtjynbkn("qST_BknkykHtjynbkn");

        String sql = $SELECT + $NEW(BknKykKariDDataBean.class,
            qST_BknkykHtjynbkn.bikinnendokbn,
            qST_BknkykHtjynbkn.bikinkbn,
            $COUNT + "(*)",
            qST_BknkykHtjynbkn.kariwariatedrisoku.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.kariwariatedrisoku.getValueFieldName()),
            qST_BknkykHtjynbkn.kariwariatedganrikin.getTypeFieldName(),
            $SUM + $(qST_BknkykHtjynbkn.kariwariatedganrikin.getValueFieldName())) +

            $FROM(qST_BknkykHtjynbkn) +
            $WHERE + qST_BknkykHtjynbkn.srkijyunym.eq(pKijyunymd) +
            $AND + qST_BknkykHtjynbkn.kakutyoujobcd.eq(pKakutyoujobcd) +

            $GROUP_BY + qST_BknkykHtjynbkn.bikinnendokbn + "," +
            qST_BknkykHtjynbkn.bikinkbn + "," +
            qST_BknkykHtjynbkn.kariwariatedrisoku.getTypeFieldName() + "," +
            qST_BknkykHtjynbkn.kariwariatedganrikin.getTypeFieldName() +

            $ORDER_BY(qST_BknkykHtjynbkn.bikinnendokbn.asc(),
                qST_BknkykHtjynbkn.bikinkbn.asc());

        return exDBEntityManager.createJPQL(sql, BknKykKariDDataBean.class).bind(qST_BknkykHtjynbkn).getResultList();
    }

}
