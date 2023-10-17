package yuyu.app.siharai.simakefile.simakeseikyuuinfof.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiharaiSyoriJyoutaiKbn;
import yuyu.def.db.entity.JV_SeikyuuInfo;
import yuyu.def.db.meta.QJV_SeikyuuInfo;

/**
 * 請求情報ファイル作成(SiMakeSeikyuuInfoF) のDAOクラスです。<br/>
 * 請求情報ビュー（JV_SeikyuuInfo) にアクセスします。
 */
public class SiMakeSeikyuuInfoFDao {

    @Inject
    private ExDBEntityManager em;

    public List<JV_SeikyuuInfo> getSeikyuuInfoBySyuturyokutaisyou(C_SiharaiSyoriJyoutaiKbn pSiharaisyorijyoutaikbn,
        C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSibouymdfrom, BizDate pSibouymdto, BizDate siboukariymdfrom,
        BizDate siboukariymdto, BizDate pSyoruiukeymdfrom, BizDate pSyoruiukeymdto,
        BizDate pShrymdfrom, BizDate pShrymdto) {

        QJV_SeikyuuInfo qJV_SeikyuuInfo = new QJV_SeikyuuInfo("qJV_SeikyuuInfo");

        String jyoukenHensuu = "";

        jyoukenHensuu = qJV_SeikyuuInfo.seikyuusyubetu.eq(pSeikyuusyubetu);

        if(C_SiharaiSyoriJyoutaiKbn.UKETUKETYUU.eq(pSiharaisyorijyoutaikbn)){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.shrkekkakbn.eq(C_ShrKekkaKbn.BLNK);
        }

        if(C_SiharaiSyoriJyoutaiKbn.SIHARAIZUMI.eq(pSiharaisyorijyoutaikbn)){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.shrkekkakbn.ne(C_ShrKekkaKbn.BLNK);
        }

        if(pSibouymdfrom != null){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.sibouymd.ge(pSibouymdfrom);
        }

        if(pSibouymdto != null){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.sibouymd.le(pSibouymdto);
        }

        if(siboukariymdfrom != null){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.siboukaritrkymd.ge(siboukariymdfrom);
        }

        if(siboukariymdto != null){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.siboukaritrkymd.le(siboukariymdto);
        }

        if(pSyoruiukeymdfrom != null){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.syoruiukeymd.ge(pSyoruiukeymdfrom);
        }

        if(pSyoruiukeymdto != null){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.syoruiukeymd.le(pSyoruiukeymdto);
        }

        if(pShrymdfrom != null){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.tyakkinymd.ge(pShrymdfrom);
        }

        if(pShrymdto != null){
            jyoukenHensuu =  jyoukenHensuu + $AND + qJV_SeikyuuInfo.tyakkinymd.le(pShrymdto);
        }

        String strSql = $SELECT + qJV_SeikyuuInfo +
            $FROM + qJV_SeikyuuInfo.JV_SeikyuuInfo()  +
            $WHERE + jyoukenHensuu +
            $ORDER_BY(qJV_SeikyuuInfo.syono.asc(),
                qJV_SeikyuuInfo.skno.asc());

        return em.createJPQL(strSql).bind(qJV_SeikyuuInfo).setFirstResult(0).setMaxResults(301).getResultList();

    }
}
