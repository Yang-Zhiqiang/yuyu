package yuyu.batch.suuri.srsuuritoukei.srkbnkeiriyoutmttdmeisailistsks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.db.meta.QST_YuukoukykHtjynbknTmttd;

/**
 * 数理 数理統計 区分経理用積立配当金明細リスト作成DAOクラス
 */
public class SrKbnKeiriyouTmttDMeisaiListSksDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public List<KbnKeiriyouTmttDMeisaiDataBean> getKbnKeiriyouTmttDMeisai(String pKijyunym, String pKakutyoujobcd) {

        QST_YuukoukykHtjynbknTmttd qST_YuukoukykHtjynbknTmttd = new QST_YuukoukykHtjynbknTmttd("qST_YuukoukykHtjynbknTmttd");

        String queryStr = $SELECT + $NEW(KbnKeiriyouTmttDMeisaiDataBean.class,
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

        return exDBEntityManager.createJPQL(queryStr, KbnKeiriyouTmttDMeisaiDataBean.class).bind(
            qST_YuukoukykHtjynbknTmttd).getResultList();
    }

    public List<KbnKeiriyouTmttDMeisaiDataBean> getKbnKeiriyouTmttDZensyuGoukei(String pKijyunym, String pKakutyoujobcd) {

        QST_YuukoukykHtjynbknTmttd qST_YuukoukykHtjynbknTmttd = new QST_YuukoukykHtjynbknTmttd("qST_YuukoukykHtjynbknTmttd");

        String queryStr = $SELECT + $NEW(KbnKeiriyouTmttDMeisaiDataBean.class,
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

        return exDBEntityManager.createJPQL(queryStr, KbnKeiriyouTmttDMeisaiDataBean.class).bind(
            qST_YuukoukykHtjynbknTmttd).getResultList();
    }
}
