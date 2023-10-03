package yuyu.batch.suuri.srsuuritoukei.srkariwariatedmeisailistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknKarid;

/**
 * 仮割当配当金明細リスト作成のDAOクラス
 */
public class SrKariwariateDMeisaiListSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<KariDMeisaiDataBean> getKariDMeisai(String pKijyunym, String pKakutyoujobcd) {

        QST_YuukoukykHtjynbknKarid qST_YuukoukykHtjynbknKarid = new QST_YuukoukykHtjynbknKarid(
            "qST_YuukoukykHtjynbknKarid");

        String queryStr = $SELECT + $NEW(KariDMeisaiDataBean.class,
            qST_YuukoukykHtjynbknKarid.kbnkeiriyousegmentkbn,
            qST_YuukoukykHtjynbknKarid.kbnkeiriyourgnbnskkbn,
            qST_YuukoukykHtjynbknKarid.syukeiyakusyuruicd,
            qST_YuukoukykHtjynbknKarid.srhaitoukinsyuukeiptnkbn,
            $COUNT + "(*)",
            qST_YuukoukykHtjynbknKarid.hsys.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.hsys.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.znnndkrkskrwratdruigk.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.znnndkrkskrwratdruigk.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.kariwariatedrisoku.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.kariwariatedrisoku.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.tounendokariwariated.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.tounendokariwariated.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.tndmatukrkskrwratdruigk.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.tndmatukrkskrwratdruigk.getValueFieldName())) +
            $FROM (qST_YuukoukykHtjynbknKarid) +
            $WHERE + qST_YuukoukykHtjynbknKarid.srkijyunym.eq(pKijyunym) +
            $AND + qST_YuukoukykHtjynbknKarid.kakutyoujobcd.eq(pKakutyoujobcd) +
            $GROUP_BY + qST_YuukoukykHtjynbknKarid.kbnkeiriyousegmentkbn + "," +
            qST_YuukoukykHtjynbknKarid.kbnkeiriyourgnbnskkbn + "," +
            qST_YuukoukykHtjynbknKarid.syukeiyakusyuruicd + "," +
            qST_YuukoukykHtjynbknKarid.srhaitoukinsyuukeiptnkbn + "," +
            qST_YuukoukykHtjynbknKarid.hsys.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.znnndkrkskrwratdruigk.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.kariwariatedrisoku.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.tounendokariwariated.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.tndmatukrkskrwratdruigk.getTypeFieldName() +
            $ORDER_BY(qST_YuukoukykHtjynbknKarid.kbnkeiriyousegmentkbn.asc(),
                qST_YuukoukykHtjynbknKarid.kbnkeiriyourgnbnskkbn.asc(),
                qST_YuukoukykHtjynbknKarid.syukeiyakusyuruicd.asc(),
                qST_YuukoukykHtjynbknKarid.srhaitoukinsyuukeiptnkbn.asc());

        return exDBEntityManager.createJPQL(queryStr, KariDMeisaiDataBean.class).bind(qST_YuukoukykHtjynbknKarid)
            .getResultList();
    }

    public List<KariDMeisaiDataBean> getKariDSegmentGoukei(String pKijyunym, String pKakutyoujobcd,
        String pKbnkeiriyousegmentkbn, String pKbnkeiriyourgnbnskkbn) {

        QST_YuukoukykHtjynbknKarid qST_YuukoukykHtjynbknKarid = new QST_YuukoukykHtjynbknKarid(
            "qST_YuukoukykHtjynbknKarid");

        String queryStr = $SELECT + $NEW(KariDMeisaiDataBean.class,
            qST_YuukoukykHtjynbknKarid.kbnkeiriyousegmentkbn,
            qST_YuukoukykHtjynbknKarid.kbnkeiriyourgnbnskkbn,
            qST_YuukoukykHtjynbknKarid.srhaitoukinsyuukeiptnkbn,
            $COUNT + "(*)",
            qST_YuukoukykHtjynbknKarid.hsys.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.hsys.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.znnndkrkskrwratdruigk.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.znnndkrkskrwratdruigk.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.kariwariatedrisoku.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.kariwariatedrisoku.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.tounendokariwariated.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.tounendokariwariated.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.tndmatukrkskrwratdruigk.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.tndmatukrkskrwratdruigk.getValueFieldName())) +
            $FROM (qST_YuukoukykHtjynbknKarid) +
            $WHERE + qST_YuukoukykHtjynbknKarid.srkijyunym.eq(pKijyunym) +
            $AND + qST_YuukoukykHtjynbknKarid.kakutyoujobcd.eq(pKakutyoujobcd) +
            $AND + qST_YuukoukykHtjynbknKarid.kbnkeiriyousegmentkbn.eq(pKbnkeiriyousegmentkbn) +
            $AND + qST_YuukoukykHtjynbknKarid.kbnkeiriyourgnbnskkbn.eq(pKbnkeiriyourgnbnskkbn) +
            $GROUP_BY + qST_YuukoukykHtjynbknKarid.kbnkeiriyousegmentkbn + "," +
            qST_YuukoukykHtjynbknKarid.kbnkeiriyourgnbnskkbn + "," +
            qST_YuukoukykHtjynbknKarid.srhaitoukinsyuukeiptnkbn + "," +
            qST_YuukoukykHtjynbknKarid.hsys.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.znnndkrkskrwratdruigk.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.kariwariatedrisoku.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.tounendokariwariated.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.tndmatukrkskrwratdruigk.getTypeFieldName() +
            $ORDER_BY(qST_YuukoukykHtjynbknKarid.kbnkeiriyousegmentkbn.asc(),
                qST_YuukoukykHtjynbknKarid.kbnkeiriyourgnbnskkbn.asc(),
                qST_YuukoukykHtjynbknKarid.srhaitoukinsyuukeiptnkbn.asc());

        return exDBEntityManager.createJPQL(queryStr, KariDMeisaiDataBean.class).bind(qST_YuukoukykHtjynbknKarid)
            .getResultList();
    }

    public List<KariDMeisaiDataBean> getKariDZensyuGoukei(String pKijyunym, String pKakutyoujobcd) {

        QST_YuukoukykHtjynbknKarid qST_YuukoukykHtjynbknKarid = new QST_YuukoukykHtjynbknKarid(
            "qST_YuukoukykHtjynbknKarid");

        String queryStr = $SELECT + $NEW(KariDMeisaiDataBean.class,
            qST_YuukoukykHtjynbknKarid.srhaitoukinsyuukeiptnkbn,
            $COUNT + "(*)",
            qST_YuukoukykHtjynbknKarid.hsys.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.hsys.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.znnndkrkskrwratdruigk.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.znnndkrkskrwratdruigk.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.kariwariatedrisoku.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.kariwariatedrisoku.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.tounendokariwariated.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.tounendokariwariated.getValueFieldName()),
            qST_YuukoukykHtjynbknKarid.tndmatukrkskrwratdruigk.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknKarid.tndmatukrkskrwratdruigk.getValueFieldName())) +
            $FROM (qST_YuukoukykHtjynbknKarid) +
            $WHERE + qST_YuukoukykHtjynbknKarid.srkijyunym.eq(pKijyunym) +
            $AND + qST_YuukoukykHtjynbknKarid.kakutyoujobcd.eq(pKakutyoujobcd) +
            $GROUP_BY + qST_YuukoukykHtjynbknKarid.srhaitoukinsyuukeiptnkbn + "," +
            qST_YuukoukykHtjynbknKarid.hsys.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.znnndkrkskrwratdruigk.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.kariwariatedrisoku.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.tounendokariwariated.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknKarid.tndmatukrkskrwratdruigk.getTypeFieldName() +
            $ORDER_BY(qST_YuukoukykHtjynbknKarid.srhaitoukinsyuukeiptnkbn.asc());

        return exDBEntityManager.createJPQL(queryStr, KariDMeisaiDataBean.class).bind(qST_YuukoukykHtjynbknKarid)
            .getResultList();
    }
}
