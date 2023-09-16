package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.def.db.meta.QAT_FileHozonInfo;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;

/**
 * ファイル保存情報テーブル(AT_FileHozonInfo) テーブルアクセス用の DAO クラスです。
 *
 */
public class AT_FileHozonInfoDao extends AbstractDao<AT_FileHozonInfo> {

    protected AT_FileHozonInfoDao() {
        super(AT_FileHozonInfo.class);
    }

    public List<AT_FileHozonInfo> getAllFileHozonInfo() {
        return uniqueIdOrder.sortedCopy(selectAll());
    }

    public AT_FileHozonInfo getAT_FileHozonInfo(String pUniqueId) {
        AT_FileHozonInfo condEntity = new AT_FileHozonInfo();
        condEntity.setUniqueId(pUniqueId);
        return selectOne(condEntity);
    }

    public List<AT_FileHozonInfo> getFileHozonInfoByHaitaKey(C_FileSyuruiCdKbn pFileSyuruiCd, String pHaitaKey) {

        AT_FileHozonInfo condEntity = new AT_FileHozonInfo();
        condEntity.setFileSyuruiCd(pFileSyuruiCd);
        condEntity.setHaitaKey(pHaitaKey);
        return tourokuTimeOrder.sortedCopy(select(condEntity));
    }

    public List<AT_FileHozonInfo> getFileHozonInfoByFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {

        AT_FileHozonInfo condEntity = new AT_FileHozonInfo();
        condEntity.setFileSyuruiCd(pFileSyuruiCd);
        return tourokuTimeOrder.sortedCopy(select(condEntity));
    }

    public List<AT_FileHozonInfo> getFileHozonInfoByTourokuTime(C_FileSyuruiCdKbn pFileSyuruiCd,
            String pHaitaKey,
            String pTourokuTimeFrom,
            String pTourokuTimeTo) {

        AT_FileHozonInfo condEntity = new AT_FileHozonInfo();
        condEntity.setFileSyuruiCd(pFileSyuruiCd);
        condEntity.setHaitaKey(pHaitaKey);

        return ImmutableList.copyOf(
                Iterables.filter(tourokuTimeOrder.sortedCopy(select(condEntity)),
                        new TourokuTimePredicate(pTourokuTimeFrom, pTourokuTimeTo)));
    }

    public List<AT_FileHozonInfo> getFileHozonInfoByAllCondition(String pUniqueId,
            String pFileName,
            C_FileSyuruiCdKbn pFileSyuruiCd,
            String pHaitaKey,
            String pTourokuTimeFrom,
            String pTourokuTimeTo,
            String pSakuseiKinouId,
            String pSakuseiUserId) {


        AT_FileHozonInfo condEntity = new AT_FileHozonInfo();
        condEntity.setUniqueId(pUniqueId);
        condEntity.setFileNm(pFileName);
        condEntity.setFileSyuruiCd(pFileSyuruiCd);
        condEntity.setHaitaKey(pHaitaKey);
        condEntity.setSakuseiKinouId(pSakuseiKinouId);
        condEntity.setKousinsyaId(pSakuseiUserId);


        return ImmutableList.copyOf(
                Iterables.filter(tourokuTimeOrder.sortedCopy(select(condEntity)),
                        new TourokuTimePredicate(pTourokuTimeFrom, pTourokuTimeTo)));
    }

    public long getFileHozonInfoCountByFileNm(String pFileNm) {

        QAT_FileHozonInfo qFileHozonInfo = new QAT_FileHozonInfo();

        return em.createJPQL(
                $SELECT + $COUNT(qFileHozonInfo.fileNm) +
                $FROM + qFileHozonInfo.AT_FileHozonInfo() +
                $WHERE + qFileHozonInfo.fileNm.eq(pFileNm)
                ).bind(qFileHozonInfo).<Long>getSingleResult();

    }


    private static final Ordering<AT_FileHozonInfo> tourokuTimeOrder = new Ordering<AT_FileHozonInfo>() {
        @Override
        public int compare(AT_FileHozonInfo left, AT_FileHozonInfo right) {
            return left.getTourokuTime().compareTo(right.getTourokuTime());
        }
    };

    private static final Ordering<AT_FileHozonInfo> uniqueIdOrder = new Ordering<AT_FileHozonInfo>() {
        @Override
        public int compare(AT_FileHozonInfo left, AT_FileHozonInfo right) {
            return left.getUniqueId().compareTo(right.getUniqueId());
        }
    };

    public class TourokuTimePredicate implements Predicate<AT_FileHozonInfo> {

        private String tourokuTimeFrom;
        private String tourokuTimeTo;

        public TourokuTimePredicate(String pTourokuTimeFrom, String pTourokuTimeTo) {

            this.tourokuTimeFrom = pTourokuTimeFrom;
            this.tourokuTimeTo   = pTourokuTimeTo;
        }

        @Override
        public boolean apply(AT_FileHozonInfo fileHozonInfo) {

            String tourokuTime = fileHozonInfo.getTourokuTime();


            if (!Strings.isNullOrEmpty(this.tourokuTimeFrom) && Long.parseLong(this.tourokuTimeFrom) > Long.parseLong(tourokuTime)) {
                return false;
            }


            if (!Strings.isNullOrEmpty(this.tourokuTimeTo) && Long.parseLong(this.tourokuTimeTo) < Long.parseLong(tourokuTime)) {
                return false;
            }

            return true;
        }
    }
    public List<AT_FileHozonInfo> getFileHozonInfosByFileSyuruiCdTourokuTime(C_FileSyuruiCdKbn pFileSyuruiCd, String pTourokuTime) {


        QAT_FileHozonInfo qAT_FileHozonInfo = new QAT_FileHozonInfo();


        String queryStr = $SELECT + qAT_FileHozonInfo +
                $FROM + qAT_FileHozonInfo.AT_FileHozonInfo() +
                $WHERE + qAT_FileHozonInfo.fileSyuruiCd.eq(pFileSyuruiCd) +
                $AND + qAT_FileHozonInfo.tourokuTime.lt(pTourokuTime) +
                $ORDER_BY(qAT_FileHozonInfo.uniqueId.asc());

        return em.createJPQL(queryStr).bind(qAT_FileHozonInfo).getResultList();
    }
}
