package yuyu.batch.hozen.khinterf.khkesikomisks.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.db.entity.IT_KhKesikomiData;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditTy;
import yuyu.def.db.entity.ZT_KesikomiSousinHurikaeTy;
import yuyu.def.db.entity.ZT_KesikomiSousinKouhuriTy;
import yuyu.def.db.meta.QIT_KhKesikomiData;

/**
 * 契約保全 インターフェイス 消込送信Ｆ作成Daoクラス
 */
public class KhKesikomiSksDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<ItKhKesikomiDataBean> getKesikomiData(C_Nykkeiro pNykkeiro) {

        QIT_KhKesikomiData qIT_KhKesikomiData = new QIT_KhKesikomiData("qIT_KhKesikomiData");

        String strSql = $SELECT + $NEW(ItKhKesikomiDataBean.class,
            qIT_KhKesikomiData.kbnkey,
            qIT_KhKesikomiData.nyuukinkakusyouno,
            qIT_KhKesikomiData.syono,
            qIT_KhKesikomiData.nyknaiyoukbn,
            qIT_KhKesikomiData.nyuuryokukbn,
            qIT_KhKesikomiData.nykkeiro,
            qIT_KhKesikomiData.jyuutouym,
            qIT_KhKesikomiData.nyuukinkakusyounrkymd,
            qIT_KhKesikomiData.ryosyuymd,
            qIT_KhKesikomiData.rsgaku.getTypeFieldName(),
            qIT_KhKesikomiData.rsgaku.getValueFieldName(),
            qIT_KhKesikomiData.nykdenymd,
            qIT_KhKesikomiData.nyuukinkakusyounrkno,
            qIT_KhKesikomiData.taisyakukbn,
            qIT_KhKesikomiData.suitono,
            qIT_KhKesikomiData.suitoubumoncd,
            qIT_KhKesikomiData.kzhurikaebankcd,
            qIT_KhKesikomiData.karikanjyono,
            qIT_KhKesikomiData.hrkmyousinkkbn,
            qIT_KhKesikomiData.suitososhikicd,
            qIT_KhKesikomiData.creditcardhrkskmkbn,
            qIT_KhKesikomiData.syuudaikocd) +
            $FROM(qIT_KhKesikomiData) ;
        if (null == pNykkeiro || C_Nykkeiro.BLNK.eq(pNykkeiro)) {
        }
        else {
            strSql = strSql + $WHERE + qIT_KhKesikomiData.nykkeiro.eq(pNykkeiro);
        }

        ExDBResults<ItKhKesikomiDataBean> exDBResults = exDBEntityManager.createJPQL(strSql, ItKhKesikomiDataBean.class).bind(qIT_KhKesikomiData).getResults();

        return exDBResults;
    }

    public void addMultipleInserterEntity(MultipleEntityInserter pMultipleEntityInserter,
        ZT_KesikomiSousinKouhuriTy pKesikomiSousinKouhuriTy) {

        pMultipleEntityInserter.add(pKesikomiSousinKouhuriTy);
    }

    public void addMultipleInserterEntity(MultipleEntityInserter pMultipleEntityInserter,
        ZT_KesikomiSousinCreditTy pKesikomiSousinCreditTy) {

        pMultipleEntityInserter.add(pKesikomiSousinCreditTy);
    }

    public void addMultipleInserterEntity(MultipleEntityInserter pMultipleEntityInserter,
        ZT_KesikomiSousinHurikaeTy pKesikomiSousinHurikaeTy) {

        pMultipleEntityInserter.add(pKesikomiSousinHurikaeTy);
    }

    public void deleteKesikomiData(EntityDeleter<IT_KhKesikomiData> pKhKesikomiDataDeleter,
        IT_KhKesikomiData pKhKesikomiData) {

        pKhKesikomiDataDeleter.add(pKhKesikomiData);
    }

}
