package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.meta.QIT_AzukarikinKessankanri;

/**
 * 預り金決算管理テーブル(IT_AzukarikinKessankanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_AzukarikinKessankanriDao extends AbstractDao<IT_AzukarikinKessankanri> {

    public IT_AzukarikinKessankanriDao() {
        super(IT_AzukarikinKessankanri.class);
    }

    public IT_AzukarikinKessankanri getAzukarikinKessankanri(String pSyono, BizDate pKessankijyunymd, String pHenkousikibetukey, C_Tuukasyu pTuukasyu) {
        IT_AzukarikinKessankanri iT_AzukarikinKessankanri =  new IT_AzukarikinKessankanri();
        iT_AzukarikinKessankanri.setSyono(pSyono);
        iT_AzukarikinKessankanri.setKessankijyunymd(pKessankijyunymd);
        iT_AzukarikinKessankanri.setHenkousikibetukey(pHenkousikibetukey);
        iT_AzukarikinKessankanri.setTuukasyu(pTuukasyu);
        return this.selectOne(iT_AzukarikinKessankanri);
    }

    public ExDBResults<IT_AzukarikinKessankanri> getKhAzukarikinKessankanrisByKakutyoujobcdKessankijyunymd(BizDate pKessankijyunymd) {


        QIT_AzukarikinKessankanri qIT_AzukarikinKessankanri = new QIT_AzukarikinKessankanri();

        String mainStry = $SELECT + qIT_AzukarikinKessankanri +
            $FROM + qIT_AzukarikinKessankanri.IT_AzukarikinKessankanri() +

            $WHERE + qIT_AzukarikinKessankanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + "((" + qIT_AzukarikinKessankanri.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
            $AND + qIT_AzukarikinKessankanri.bknjkukbn.eq(C_BknJkuKbn.BLNK) +
            $OR  + qIT_AzukarikinKessankanri.bknjkukbn.eq(C_BknJkuKbn.SINBI) + ")" +
            $OR  + "(" + qIT_AzukarikinKessankanri.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.SYOUMETU) + "))" +

            $ORDER_BY (qIT_AzukarikinKessankanri.kbnkeirisegcd.asc(),
                qIT_AzukarikinKessankanri.tuukasyu.asc());


        return em.createJPQL(mainStry).bind(qIT_AzukarikinKessankanri).getResults();
    }

    public ExDBResults<IT_AzukarikinKessankanri> getKhAzukarikinBikinKessankanrisByKakutyoujobcdKessankijyunymd(BizDate pKessankijyunymd) {


        QIT_AzukarikinKessankanri qIT_AzukarikinKessankanri = new QIT_AzukarikinKessankanri();

        String mainStry = $SELECT + qIT_AzukarikinKessankanri +
            $FROM + qIT_AzukarikinKessankanri.IT_AzukarikinKessankanri() +

            $WHERE + qIT_AzukarikinKessankanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qIT_AzukarikinKessankanri.bknjkukbn.ne(C_BknJkuKbn.BLNK) +

            $ORDER_BY (qIT_AzukarikinKessankanri.kbnkeirisegcd.asc(),
                qIT_AzukarikinKessankanri.bknjkukbn.desc(),
                qIT_AzukarikinKessankanri.bikinkeiymd.asc(),
                qIT_AzukarikinKessankanri.bkncdkbn.asc(),
                qIT_AzukarikinKessankanri.syono.asc());


        return em.createJPQL(mainStry).bind(qIT_AzukarikinKessankanri).getResults();
    }

    public List<String> getKhAzukarikinBikinYenGaikaTyoufukuSyonosByKessankijyunymd(BizDate pKessankijyunymd) {


        QIT_AzukarikinKessankanri qIT_AzukarikinKessankanri1 = new QIT_AzukarikinKessankanri("qIT_AzukarikinKessankanri1");

        QIT_AzukarikinKessankanri qIT_AzukarikinKessankanri2 = new QIT_AzukarikinKessankanri("qIT_AzukarikinKessankanri2");

        String mainStry = $SELECT + qIT_AzukarikinKessankanri1.syono +
            $FROM(qIT_AzukarikinKessankanri1,
                qIT_AzukarikinKessankanri2) +
                $WHERE + qIT_AzukarikinKessankanri1.syono.eq(qIT_AzukarikinKessankanri2.syono) +
                $AND + qIT_AzukarikinKessankanri1.kessankijyunymd.eq(pKessankijyunymd) +
                $AND + qIT_AzukarikinKessankanri1.bknjkukbn.ne(C_BknJkuKbn.BLNK) +
                $AND + qIT_AzukarikinKessankanri1.tuukasyu.eq(C_Tuukasyu.JPY) +
                $AND + qIT_AzukarikinKessankanri2.kessankijyunymd.eq(pKessankijyunymd) +
                $AND + qIT_AzukarikinKessankanri2.bknjkukbn.ne(C_BknJkuKbn.BLNK) +
                $AND + qIT_AzukarikinKessankanri2.tuukasyu.ne(C_Tuukasyu.JPY) +
                $GROUP_BY + qIT_AzukarikinKessankanri1.syono;


        return em.createJPQL(mainStry).bind(qIT_AzukarikinKessankanri1,qIT_AzukarikinKessankanri2).getResultList();
    }

}
