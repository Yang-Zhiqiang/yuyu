package yuyu.batch.sinkeiyaku.skkessan.skmiseirijiyuumeisaisakusei;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.db.meta.QHT_SkDenpyoData;
import yuyu.def.sinkeiyaku.result.bean.DengkByMosnoRstuukasyuBean;

/**
 * 新契約 決算 未整理事由別明細作成の機能DAOクラスです。
 */
public class SkMiseiriJiyuuMeisaiSakuseiDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    public DengkByMosnoRstuukasyuBean getDengkByMosnoRstuukasyuNyksyoriymd(String pMosno,
        C_Tuukasyu pRstuukasyu, BizDate pNyksyoriymd, BizDate pRyosyuymd) {

        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin("qHT_Nyuukin");
        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData("qHT_SkDenpyoData");

        String strSql = $SELECT + $NEW(DengkByMosnoRstuukasyuBean.class,
            qHT_SkDenpyoData.denyenkagk.getTypeFieldName(),
            $SUM + $(qHT_SkDenpyoData.denyenkagk.getValueFieldName()),
            qHT_SkDenpyoData.dengaikagk.getTypeFieldName(),
            $SUM + $(qHT_SkDenpyoData.dengaikagk.getValueFieldName())) +
            $FROM(qHT_Nyuukin,
                qHT_SkDenpyoData) +
                $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
                $AND + qHT_Nyuukin.rstuukasyu.eq(pRstuukasyu) +
                $AND + qHT_Nyuukin.denrenno.eq(qHT_SkDenpyoData.denrenno) +
                $AND + qHT_Nyuukin.edano.eq(qHT_SkDenpyoData.edano) +
                $AND + qHT_Nyuukin.nyksyoriymd.ge(pNyksyoriymd) +
                $AND + qHT_Nyuukin.ryosyuymd.le(pRyosyuymd) +
                $GROUP_BY + qHT_SkDenpyoData.denyenkagk.getTypeFieldName() + "," +
                qHT_SkDenpyoData.dengaikagk.getTypeFieldName() +
                $ORDER_BY(qHT_SkDenpyoData.denyenkagk.typeAsc(),
                    qHT_SkDenpyoData.dengaikagk.typeAsc());

        return exDBEntityManager.createJPQL(strSql,DengkByMosnoRstuukasyuBean.class)
            .bind(qHT_Nyuukin, qHT_SkDenpyoData).getSingleResult();
    }

    public DengkByMosnoRstuukasyuBean getDengkByMosnoHnkntuukasyuPkakinsyoriymd(String pMosno,
        C_Tuukasyu pHnkntuukasyu, BizDate pPkakinsyoriymd) {

        QHT_Henkin qHT_Henkin = new QHT_Henkin("qHT_Henkin");
        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData("qHT_SkDenpyoData");

        String strSql = $SELECT + $NEW(DengkByMosnoRstuukasyuBean.class,
            qHT_SkDenpyoData.denyenkagk.getTypeFieldName(),
            $SUM + $(qHT_SkDenpyoData.denyenkagk.getValueFieldName()),
            qHT_SkDenpyoData.dengaikagk.getTypeFieldName(),
            $SUM + $(qHT_SkDenpyoData.dengaikagk.getValueFieldName())) +
            $FROM(qHT_Henkin,
                qHT_SkDenpyoData) +
                $WHERE + qHT_Henkin.mosno.eq(pMosno) +
                $AND + qHT_Henkin.hnkntuukasyu.eq(pHnkntuukasyu) +
                $AND + qHT_Henkin.pkakindenrenno.eq(qHT_SkDenpyoData.denrenno) +
                $AND + qHT_Henkin.pkakindenedano.eq(qHT_SkDenpyoData.edano) +
                $AND + qHT_Henkin.pkakinsyoriymd.lt(pPkakinsyoriymd) +
                $GROUP_BY + qHT_SkDenpyoData.denyenkagk.getTypeFieldName() + "," +
                qHT_SkDenpyoData.dengaikagk.getTypeFieldName() +
                $ORDER_BY(qHT_SkDenpyoData.denyenkagk.typeAsc(),
                    qHT_SkDenpyoData.dengaikagk.typeAsc());

        return exDBEntityManager.createJPQL(strSql,DengkByMosnoRstuukasyuBean.class)
            .bind(qHT_Henkin, qHT_SkDenpyoData).getSingleResult();
    }

}
