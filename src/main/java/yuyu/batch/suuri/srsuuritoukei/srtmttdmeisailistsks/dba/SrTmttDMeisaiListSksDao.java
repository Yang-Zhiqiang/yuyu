package yuyu.batch.suuri.srsuuritoukei.srtmttdmeisailistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknTmttd;

/**
 * 数理統計 数理統計 積立配当金明細情報作成DAOクラス
 */
public class SrTmttDMeisaiListSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<TmttDMeisaiDataBean> getTmttDMeisai(String pKijyunym, String pKakutyoujobcd) {

        QST_YuukoukykHtjynbknTmttd qST_YuukoukykHtjynbknTmttd = new QST_YuukoukykHtjynbknTmttd("qST_YuukoukykHtjynbknTmttd");

        String queryStr = $SELECT + $NEW(TmttDMeisaiDataBean.class,
            qST_YuukoukykHtjynbknTmttd.kbnkeiriyousegmentkbn,
            qST_YuukoukykHtjynbknTmttd.kbnkeiriyourgnbnskkbn,
            qST_YuukoukykHtjynbknTmttd.syukeiyakusyuruicd,
            qST_YuukoukykHtjynbknTmttd.srhaitoukinsyuukeiptnkbn,
            $COUNT + "(*)",
            qST_YuukoukykHtjynbknTmttd.hsys.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.hsys.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.zennendkurikosid.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.zennendkurikosid.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.tumitaterisoku.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.tumitaterisoku.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.tounendod.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.tounendod.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.tndmatutumitated.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.tndmatutumitated.getValueFieldName())) +

            $FROM + qST_YuukoukykHtjynbknTmttd.ST_YuukoukykHtjynbknTmttd() +

            $WHERE + qST_YuukoukykHtjynbknTmttd.srkijyunym.eq(pKijyunym) +
            $AND + qST_YuukoukykHtjynbknTmttd.kakutyoujobcd.eq(pKakutyoujobcd) +

            $GROUP_BY + qST_YuukoukykHtjynbknTmttd.kbnkeiriyousegmentkbn + "," +
            qST_YuukoukykHtjynbknTmttd.kbnkeiriyourgnbnskkbn + "," +
            qST_YuukoukykHtjynbknTmttd.syukeiyakusyuruicd + "," +
            qST_YuukoukykHtjynbknTmttd.srhaitoukinsyuukeiptnkbn + "," +
            qST_YuukoukykHtjynbknTmttd.hsys.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.zennendkurikosid.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.tumitaterisoku.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.tounendod.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.tndmatutumitated.getTypeFieldName() +

            $ORDER_BY(qST_YuukoukykHtjynbknTmttd.kbnkeiriyousegmentkbn.asc(),
                qST_YuukoukykHtjynbknTmttd.kbnkeiriyourgnbnskkbn.asc(),
                qST_YuukoukykHtjynbknTmttd.syukeiyakusyuruicd.asc(),
                qST_YuukoukykHtjynbknTmttd.srhaitoukinsyuukeiptnkbn.asc());

        return exDBEntityManager.createJPQL(queryStr, TmttDMeisaiDataBean.class).bind(
            qST_YuukoukykHtjynbknTmttd).getResultList();
    }

    public List<TmttDMeisaiDataBean> getTmttDSegmentGoukei(String pKijyunym, String pKakutyoujobcd,
        String pKbnkeiriyousegmentkbn, String pKbnkeiriyourgnbnskkbn) {

        QST_YuukoukykHtjynbknTmttd qST_YuukoukykHtjynbknTmttd = new QST_YuukoukykHtjynbknTmttd("qST_YuukoukykHtjynbknTmttd");

        String queryStr = $SELECT + $NEW(TmttDMeisaiDataBean.class,
            qST_YuukoukykHtjynbknTmttd.kbnkeiriyousegmentkbn,
            qST_YuukoukykHtjynbknTmttd.kbnkeiriyourgnbnskkbn,
            qST_YuukoukykHtjynbknTmttd.srhaitoukinsyuukeiptnkbn,
            $COUNT + "(*)",
            qST_YuukoukykHtjynbknTmttd.hsys.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.hsys.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.zennendkurikosid.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.zennendkurikosid.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.tumitaterisoku.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.tumitaterisoku.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.tounendod.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.tounendod.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.tndmatutumitated.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.tndmatutumitated.getValueFieldName())) +

            $FROM + qST_YuukoukykHtjynbknTmttd.ST_YuukoukykHtjynbknTmttd() +

            $WHERE + qST_YuukoukykHtjynbknTmttd.srkijyunym.eq(pKijyunym) +
            $AND + qST_YuukoukykHtjynbknTmttd.kakutyoujobcd.eq(pKakutyoujobcd) +
            $AND + qST_YuukoukykHtjynbknTmttd.kbnkeiriyousegmentkbn.eq(pKbnkeiriyousegmentkbn) +
            $AND + qST_YuukoukykHtjynbknTmttd.kbnkeiriyourgnbnskkbn.eq(pKbnkeiriyourgnbnskkbn) +

            $GROUP_BY + qST_YuukoukykHtjynbknTmttd.kbnkeiriyousegmentkbn + "," +
            qST_YuukoukykHtjynbknTmttd.kbnkeiriyourgnbnskkbn + "," +
            qST_YuukoukykHtjynbknTmttd.srhaitoukinsyuukeiptnkbn + "," +
            qST_YuukoukykHtjynbknTmttd.hsys.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.zennendkurikosid.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.tumitaterisoku.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.tounendod.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.tndmatutumitated.getTypeFieldName() +

            $ORDER_BY(qST_YuukoukykHtjynbknTmttd.kbnkeiriyousegmentkbn.asc(),
                qST_YuukoukykHtjynbknTmttd.kbnkeiriyourgnbnskkbn.asc(),
                qST_YuukoukykHtjynbknTmttd.srhaitoukinsyuukeiptnkbn.asc());

        return exDBEntityManager.createJPQL(queryStr, TmttDMeisaiDataBean.class).bind(
            qST_YuukoukykHtjynbknTmttd).getResultList();
    }

    public List<TmttDMeisaiDataBean> getTmttDZensyuGoukei(String pKijyunym, String pKakutyoujobcd) {

        QST_YuukoukykHtjynbknTmttd qST_YuukoukykHtjynbknTmttd = new QST_YuukoukykHtjynbknTmttd("qST_YuukoukykHtjynbknTmttd");

        String queryStr = $SELECT + $NEW(TmttDMeisaiDataBean.class,
            qST_YuukoukykHtjynbknTmttd.srhaitoukinsyuukeiptnkbn,
            $COUNT + "(*)",
            qST_YuukoukykHtjynbknTmttd.hsys.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.hsys.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.zennendkurikosid.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.zennendkurikosid.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.tumitaterisoku.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.tumitaterisoku.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.tounendod.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.tounendod.getValueFieldName()),
            qST_YuukoukykHtjynbknTmttd.tndmatutumitated.getTypeFieldName(),
            $SUM + $(qST_YuukoukykHtjynbknTmttd.tndmatutumitated.getValueFieldName())) +

            $FROM + qST_YuukoukykHtjynbknTmttd.ST_YuukoukykHtjynbknTmttd() +

            $WHERE + qST_YuukoukykHtjynbknTmttd.srkijyunym.eq(pKijyunym) +
            $AND + qST_YuukoukykHtjynbknTmttd.kakutyoujobcd.eq(pKakutyoujobcd) +

            $GROUP_BY + qST_YuukoukykHtjynbknTmttd.srhaitoukinsyuukeiptnkbn + "," +
            qST_YuukoukykHtjynbknTmttd.hsys.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.zennendkurikosid.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.tumitaterisoku.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.tounendod.getTypeFieldName() + "," +
            qST_YuukoukykHtjynbknTmttd.tndmatutumitated.getTypeFieldName() +

            $ORDER_BY(qST_YuukoukykHtjynbknTmttd.srhaitoukinsyuukeiptnkbn.asc());

        return exDBEntityManager.createJPQL(queryStr, TmttDMeisaiDataBean.class).bind(
            qST_YuukoukykHtjynbknTmttd).getResultList();
    }
}
