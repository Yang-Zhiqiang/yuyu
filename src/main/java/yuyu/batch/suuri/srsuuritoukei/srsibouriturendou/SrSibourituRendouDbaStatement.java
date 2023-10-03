package yuyu.batch.suuri.srsuuritoukei.srsibouriturendou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.SV_SibourituRendou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.def.sinkeiyaku.detacher.HT_SyoriCTLDetacher;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 死亡率用連動情報作成ＤＢＡ宣言
 */
public class SrSibourituRendouDbaStatement {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public ExDBResults<SV_SibourituRendou> getSkSeirituDate(BizDateYM pTysyttaisyouym, C_SeirituKbn pSeirituKbn) {

        SrSibourituRendouDao srSibourituRendouDao = SWAKInjector.getInstance(SrSibourituRendouDao.class);

        ExDBResults<SV_SibourituRendou> sibourituRendouLst = srSibourituRendouDao
            .getSibourituRendousByBosyuuymSeiritukbn(pTysyttaisyouym, pSeirituKbn);

        return sibourituRendouLst;
    }

    public List<HT_MosSyouhn> getMosJyouhouDate(String pMosno, C_SyutkKbn pSyutkKbn) {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(pMosno);

        syoriCTL = HT_SyoriCTLDetacher.detachMosSyouhntouched(syoriCTL);

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(pSyutkKbn);

        return mosSyouhnLst;
    }

    public BM_SyouhnZokusei getSyouhnZokuseiMstDate(String pSyouhncd, int pSyouhnsdno) {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhncd, pSyouhnsdno);

        return syouhnZokusei;
    }

    public List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean>
    getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(String pSyono) {

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> khHenkouRirekiBeanList =
            hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono(pSyono);

        return khHenkouRirekiBeanList;
    }

}
