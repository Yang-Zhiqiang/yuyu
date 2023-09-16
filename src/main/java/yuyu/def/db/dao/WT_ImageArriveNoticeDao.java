package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import org.apache.commons.lang.StringUtils;

import yuyu.def.db.entity.WT_ImageArriveNotice;
import yuyu.def.db.id.PKWT_ImageArriveNotice;
import yuyu.def.db.meta.QWT_ImageArriveNotice;

/**
 * 到着予定通知情報テーブル(WT_ImageArriveNotice) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_ImageArriveNoticeDao extends AbstractDao<WT_ImageArriveNotice> {

    public WT_ImageArriveNoticeDao() {

        super(WT_ImageArriveNotice.class);
    }

    public WT_ImageArriveNotice getImageArriveNotice(String pArrivekey) {

        return selectPk(new PKWT_ImageArriveNotice(pArrivekey));
    }

    public List<WT_ImageArriveNotice> getAllImageArriveNotice() {

        return selectAll();
    }

    public List<WT_ImageArriveNotice> getImageArriveNoticeByCond(String pArrivekey, String pFlowid, String pGyoumukey,
            String pTorikomisyoruicd, String pSubsystemid) {

        QWT_ImageArriveNotice qWT_ImageArriveNotice = new QWT_ImageArriveNotice("imageArriveNotice");

        StringBuffer mainQuery = new StringBuffer();
        mainQuery.append($SELECT + qWT_ImageArriveNotice);
        mainQuery.append($FROM + qWT_ImageArriveNotice.WT_ImageArriveNotice());
        mainQuery.append($WHERE + "1 = 1");

        if (StringUtils.isNotEmpty(pArrivekey)) {

            mainQuery.append($AND + qWT_ImageArriveNotice.arriveKey.eq(pArrivekey));
        }

        if (StringUtils.isNotEmpty(pFlowid)) {

            mainQuery.append($AND + qWT_ImageArriveNotice.flowId.eq(pFlowid));
        }

        if (StringUtils.isNotEmpty(pGyoumukey)) {

            mainQuery.append($AND + qWT_ImageArriveNotice.gyoumuKey.eq(pGyoumukey));
        }

        if (StringUtils.isNotEmpty(pTorikomisyoruicd)) {

            mainQuery.append($AND + qWT_ImageArriveNotice.torikomiSyoruiCd.eq(pTorikomisyoruicd));
        }

        if (StringUtils.isNotEmpty(pSubsystemid)) {

            mainQuery.append($AND + qWT_ImageArriveNotice.subSystemId.eq(pSubsystemid));
        }

        return em.createJPQL(mainQuery.toString()).bind(qWT_ImageArriveNotice).getResultList();
    }
}