package yuyu.batch.direct.dsneugokihantei.dsneugokihanteikekkahanei.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.def.db.mapping.AbstractExDBEntity;
import yuyu.def.db.meta.QMW_DsMailHaisinRirekiWk;
import yuyu.def.db.meta.QMW_DsNeugokiHanteiKekkaWk;

/**
 * ダイレクトサービス 値動き判定 値動き判定結果反映機能DAOクラス
 */
public class DsNeugokiHanteiKekkaHaneiDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<MW_DsNeugokiHanteiKekkaWk> getDsNeugokiHanteiKekkaWk() {

        QMW_DsNeugokiHanteiKekkaWk qMW_DsNeugokiHanteiKekkaWk = new QMW_DsNeugokiHanteiKekkaWk(
            "qMW_DsNeugokiHanteiKekkaWk");

        String strSql = $SELECT + qMW_DsNeugokiHanteiKekkaWk +
            $FROM(qMW_DsNeugokiHanteiKekkaWk) +
            $ORDER_BY(qMW_DsNeugokiHanteiKekkaWk.syono.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qMW_DsNeugokiHanteiKekkaWk).getResults();
    }

    public ExDBResults<MW_DsMailHaisinRirekiWk> getDsMailHaisinRirekiWk() {

        QMW_DsMailHaisinRirekiWk qMW_DsMailHaisinRirekiWk = new QMW_DsMailHaisinRirekiWk("qQMW_DsMailHaisinRirekiWk");

        String strSql = $SELECT + qMW_DsMailHaisinRirekiWk +
            $FROM(qMW_DsMailHaisinRirekiWk) +
            $ORDER_BY(qMW_DsMailHaisinRirekiWk.syono.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qMW_DsMailHaisinRirekiWk).getResults();
    }

    public void deleteDsNeugokiHanteiKekkaWk() {

        QMW_DsNeugokiHanteiKekkaWk qMW_DsNeugokiHanteiKekkaWk = new QMW_DsNeugokiHanteiKekkaWk(
            "qMW_DsNeugokiHanteiKekkaWk");

        String strSql = $DELETE_FROM(qMW_DsNeugokiHanteiKekkaWk);

        exDBEntityManager.createJPQL(strSql).bind(qMW_DsNeugokiHanteiKekkaWk).executeUpdate();
    }

    public void deleteDsMailHaisinRirekiWk() {

        QMW_DsMailHaisinRirekiWk qMW_DsMailHaisinRirekiWk = new QMW_DsMailHaisinRirekiWk("qQMW_DsMailHaisinRirekiWk");

        String strSql = $DELETE_FROM(qMW_DsMailHaisinRirekiWk);

        exDBEntityManager.createJPQL(strSql).bind(qMW_DsMailHaisinRirekiWk).executeUpdate();
    }

    public void addMultipleInsertEntity(MultipleEntityInserter pMultipleEntityInserter,
        AbstractExDBEntity<?, ?> pDBEntity) {

        pMultipleEntityInserter.add(pDBEntity);
    }
}
