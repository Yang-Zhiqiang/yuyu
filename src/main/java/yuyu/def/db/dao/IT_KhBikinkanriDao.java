package yuyu.def.db.dao;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.meta.QIT_KhBikinkanri;
import yuyu.def.hozen.result.bean.KhBikinkanriItemsBySyonoBean;

/**
 * 契約保全備金管理テーブル(IT_KhBikinkanriDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhBikinkanriDao extends AbstractDao<IT_KhBikinkanri> {

    public IT_KhBikinkanriDao() {
        super(IT_KhBikinkanri.class);
    }

    public IT_KhBikinkanri getKhBikinkanri(String pSyono,
        BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn,
        BizDate pBknkktymd,
        Integer pRenno){
        IT_KhBikinkanri iT_KhBikinkanri =  new IT_KhBikinkanri();
        iT_KhBikinkanri.setSyono(pSyono);
        iT_KhBikinkanri.setKessankijyunymd(pKessankijyunymd);
        iT_KhBikinkanri.setBkncdkbn(pBkncdkbn);
        iT_KhBikinkanri.setBknkktymd(pBknkktymd);
        iT_KhBikinkanri.setRenno(pRenno);
        return this.selectOne(iT_KhBikinkanri);
    }

    public List<IT_KhBikinkanri> getKhBikinkanrisBySyono(String pSyono) {


        IT_KhBikinkanri it_KhBikinkanri = new IT_KhBikinkanri();
        it_KhBikinkanri.setSyono(pSyono);


        return select(it_KhBikinkanri);
    }

    public List<IT_KhBikinkanri> getKhBikinkanrisByKessankijyunymdBknrigikbn(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {


        IT_KhBikinkanri iT_KhBikinkanri =  new IT_KhBikinkanri();

        iT_KhBikinkanri.setKessankijyunymd(pKessankijyunymd);

        iT_KhBikinkanri.setBknrigikbn(pBknrigikbn);

        return this.select(iT_KhBikinkanri);
    }

    public ExDBResults<IT_KhBikinkanri> getKhBikinkanrisByKakutyoujobcdKessankijyunymd(BizDate pKessankijyunymd) {


        QIT_KhBikinkanri qIT_KhBikinkanri = new QIT_KhBikinkanri();

        String mainStry = $SELECT + qIT_KhBikinkanri +
            $FROM + qIT_KhBikinkanri.IT_KhBikinkanri() +
            $WHERE + qIT_KhBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qIT_KhBikinkanri.bkncdkbn.eq(C_BkncdKbn.KAIYAKU) +
            $AND + qIT_KhBikinkanri.bknrigikbn.eq(C_BknrigiKbn.BLNK) +
            $ORDER_BY (qIT_KhBikinkanri.kbnkeirisegcd.asc(),
                qIT_KhBikinkanri.bknkktymd.asc(),
                qIT_KhBikinkanri.calckijyunymd.desc(),
                qIT_KhBikinkanri.syono.asc());

        return em.createJPQL(mainStry).bind(qIT_KhBikinkanri).getResults();
    }

    public ExDBResults<IT_KhBikinkanri> getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn(BizDate pKessankijyunymd) {


        QIT_KhBikinkanri qIT_KhBikinkanri = new QIT_KhBikinkanri();


        String strSql = $SELECT + qIT_KhBikinkanri +
            $FROM + qIT_KhBikinkanri.IT_KhBikinkanri() +
            $WHERE + qIT_KhBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qIT_KhBikinkanri.bkncdkbn.eq(C_BkncdKbn.GENGK) +
            $AND + qIT_KhBikinkanri.bknrigikbn.eq(C_BknrigiKbn.BLNK) +
            $ORDER_BY(qIT_KhBikinkanri.kbnkeirisegcd.asc(),
                qIT_KhBikinkanri.bknkktymd.asc(),
                qIT_KhBikinkanri.syono.asc());


        return em.createJPQL(strSql).bind(qIT_KhBikinkanri).getResults();
    }

    public List<IT_KhBikinkanri> getKhBikinkanrisByPKWithoutRenno(String pSyono, BizDate pKessankijyunymd,
        C_BkncdKbn pBkncdkbn, BizDate pBknkktymd) {


        IT_KhBikinkanri iT_KhBikinkanri = new IT_KhBikinkanri();
        iT_KhBikinkanri.setSyono(pSyono);
        iT_KhBikinkanri.setKessankijyunymd(pKessankijyunymd);
        iT_KhBikinkanri.setBkncdkbn(pBkncdkbn);
        iT_KhBikinkanri.setBknkktymd(pBknkktymd);


        return this.select(iT_KhBikinkanri);
    }

    public List<KhBikinkanriItemsBySyonoBean> getKhBikinkanriItemsBySyono(String pSyono) {


        QIT_KhBikinkanri qIT_KhBikinkanri = new QIT_KhBikinkanri();


        String strSql = $SELECT + $NEW(KhBikinkanriItemsBySyonoBean.class,
            qIT_KhBikinkanri.kessankijyunymd,
            qIT_KhBikinkanri.bknrigikbn,
            qIT_KhBikinkanri.bkncdkbn) +
            $FROM (qIT_KhBikinkanri) +
            $WHERE + qIT_KhBikinkanri.syono.eq(pSyono);


        return em.createJPQL(strSql, KhBikinkanriItemsBySyonoBean.class).bind(qIT_KhBikinkanri).getResultList();
    }

    public List<IT_KhBikinkanri> getKhBikinkanrisByKessankijyunymdBknrigikbnBkncdkbn(
        BizDate pKessankijyunymd, C_BkncdKbn[] pBkncdkbn) {


        QIT_KhBikinkanri qIT_KhBikinkanri = new QIT_KhBikinkanri("qIT_KhBikinkanri");


        String strSql = $SELECT + qIT_KhBikinkanri +
            $FROM (qIT_KhBikinkanri) +
            $WHERE + qIT_KhBikinkanri.kessankijyunymd.eq(pKessankijyunymd) +
            $AND + qIT_KhBikinkanri.bknrigikbn.eq(C_BknrigiKbn.BLNK) +
            $AND + qIT_KhBikinkanri.bkncdkbn.in(pBkncdkbn);


        return em.createJPQL(strSql).bind(qIT_KhBikinkanri).getResultList();
    }

}
