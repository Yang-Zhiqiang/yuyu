package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakusyuunyuuptoukei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.suuri.srcommon.SrCommonKinouDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.sinkeiyaku.detacher.HT_SyoriCTLDetacher;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_Nyuukin;

/**
 * バッチ機能のＤＢアクセスクラス
 */
public class SrSinkeiyakuSyuunyuupToukeiDbaStatement {

    @Inject
    private SrSinkeiyakuSyuunyuupToukeiDao srSinkeiyakuSyuunyuupToukeiDao;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SrCommonKinouDao srCommonKinouDao;
    public ExDBResults<SV_SnkiykSyunyup> getSnkiykSyunyups(C_SeirituKbn pSeirituKbn) {

        ExDBResults<SV_SnkiykSyunyup> snkiykSyunyupLst =
            srSinkeiyakuSyuunyuupToukeiDao.getSnkiykSyunyupsBySeiritukbn(pSeirituKbn);

        return snkiykSyunyupLst;
    }

    public BM_TantouCd getTantouCd(C_TantouCdKbn pTantouCdKbn) {

        BM_TantouCd tantouCd = bizDomManager.getTantouCd(pTantouCdKbn);

        return tantouCd;
    }

    public List<HT_MosSyouhn> getMosSyouhns(String pMosno, C_SyutkKbn pSyutkKbn) {

        HT_SyoriCTL syoriCTL = HT_SyoriCTLDetacher.detachMosSyouhntouched(sinkeiyakuDomManager.getSyoriCTL(pMosno));

        List<HT_MosSyouhn>  mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(pSyutkKbn);

        return mosSyouhnLst;
    }

    public List<HT_Nyuukin> getNyuukin(String pMosno) {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno);

        syoriCTL = HT_SyoriCTLDetacher.detachNyuukintouched(syoriCTL);

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();

        SortHT_Nyuukin sortHtNyuukin =  SWAKInjector.getInstance(SortHT_Nyuukin.class);

        nyuukinLst = sortHtNyuukin.OrderHT_NyuukinByRyosyuymdRennoAsc(nyuukinLst);

        return nyuukinLst;
    }

    public List<BT_DenpyoData> getDenpyoData(C_DensysKbn pDensysKbn, String pMosno, C_DensyoriKbn pDensyoriKbn) {

        List<BT_DenpyoData> denpyoDataLst = srCommonKinouDao.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(pDensysKbn,
            pMosno, pDensyoriKbn);

        return denpyoDataLst;
    }

    public List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean>
    getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(String pSyono) {

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList =
            hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(pSyono);

        return khHenkouRirekiBeanList;
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(String pSyono,
        BizDate pKijyunYmd) {

        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknLst = srCommonKinouDao.
            getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pSyono, pKijyunYmd);

        return khSisuurendoTmttknLst;
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekisBySyonoNnykdenno(String pSyono, String pNykdenno) {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = srCommonKinouDao.getNyknJissekiRirekisBySyonoNnykdenno(
            pSyono, pNykdenno);

        return nyknJissekiRirekiLst;
    }

}
