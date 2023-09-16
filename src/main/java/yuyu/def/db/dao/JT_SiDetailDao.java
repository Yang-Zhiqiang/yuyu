package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.meta.QJM_Kyuuhu;
import yuyu.def.db.meta.QJT_SiDetail;
import yuyu.def.siharai.result.bean.SiDetailInfosBySknoSyonoSeikyuurirekinoBean;

/**
 * 支払明細テーブル(JT_SiDetailDao) アクセス用の DAO クラスです。<br />
 */
public class JT_SiDetailDao extends AbstractDao<JT_SiDetail> {

    public JT_SiDetailDao() {
        super(JT_SiDetail.class);
    }

    @Deprecated
    public JT_SiDetail getSiDetail(String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        C_KyhgndkataKbn pKyhgndkatakbn,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno,
        String pKyuuhucd,
        Integer pRenno){
        JT_SiDetail jT_SiDetail =  new JT_SiDetail();
        jT_SiDetail.setSkno(pSkno);
        jT_SiDetail.setSyono(pSyono);
        jT_SiDetail.setSeikyuurirekino(pSeikyuurirekino);
        jT_SiDetail.setUketukeno(pUketukeno);
        jT_SiDetail.setSyutkkbn(pSyutkkbn);
        jT_SiDetail.setSyouhncd(pSyouhncd);
        jT_SiDetail.setKyhgndkatakbn(pKyhgndkatakbn);
        jT_SiDetail.setSyouhnsdno(pSyouhnsdno);
        jT_SiDetail.setKyksyouhnrenno(pKyksyouhnrenno);
        jT_SiDetail.setKyuuhucd(pKyuuhucd);
        jT_SiDetail.setRenno(pRenno);
        return this.selectOne(jT_SiDetail);
    }

    @Override
    @Deprecated
    public List<JT_SiDetail> selectAll() {
        return super.selectAll();
    }

    public List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> getSiDetailInfosBySknoSyonoSeikyuurirekino(String pSkno,
        String pSyono, Integer pSeikyuurirekino) {


        QJT_SiDetail qJT_SiDetail = new QJT_SiDetail();
        QJM_Kyuuhu qJM_Kyuuhu = new QJM_Kyuuhu();


        String strSql = $SELECT + $NEW(SiDetailInfosBySknoSyonoSeikyuurirekinoBean.class,
            qJT_SiDetail,
            qJM_Kyuuhu.kyuuhucd,
            qJM_Kyuuhu.hokenkinsyuruikbn) +
            $FROM + qJT_SiDetail.JT_SiDetail() + "," +
            qJM_Kyuuhu.JM_Kyuuhu() +
            $WHERE + qJT_SiDetail.skno.eq(pSkno) +
            $AND + qJT_SiDetail.syono.eq(pSyono) +
            $AND + qJT_SiDetail.seikyuurirekino.eq(pSeikyuurirekino) +
            $AND + qJT_SiDetail.kyuuhucd.eq(qJM_Kyuuhu.kyuuhucd) +
            $ORDER_BY(qJM_Kyuuhu.hokenkinsyuruikbn.asc(),
                qJM_Kyuuhu.kyuuhucd.asc());

        return em.createJPQL(strSql, SiDetailInfosBySknoSyonoSeikyuurirekinoBean.class).bind(qJT_SiDetail, qJM_Kyuuhu).getResultList();
    }

    public List<JT_SiDetail> getSiDetailsBySknoSyonoSeikyuurirekino(String pSkno, String pSyono,
        Integer pSeikyuurirekino) {

        QJT_SiDetail qJT_SiDetail = new QJT_SiDetail();


        String strSql = $SELECT +  qJT_SiDetail +
            $FROM + qJT_SiDetail.JT_SiDetail() +
            $WHERE + qJT_SiDetail.skno.eq(pSkno) +
            $AND + qJT_SiDetail.syono.eq(pSyono) +
            $AND + qJT_SiDetail.seikyuurirekino.eq(pSeikyuurirekino) +
            $AND + qJT_SiDetail.kyhkg.gtZero() +
            $ORDER_BY(qJT_SiDetail.uketukeno.asc(),
                qJT_SiDetail.renno.asc());


        return em.createJPQL(strSql).bind(qJT_SiDetail).getResultList();
    }
}
