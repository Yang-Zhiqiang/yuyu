package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 発送区分チェック
 */
public class ChkSubhassoKbn {

    @Inject
    private static Logger logger;

    public ChkSubhassoKbn() {
        super();
    }

    public void exec(C_SaisateiKbn pSaisateiKbn, String pSaikennmKj, String SaikennYno,
        String SaikenAdr1Kj, C_Tkhukaumu pTkhukaumu, C_KanryotuutioutKbn pShrDtlsyoOutKbn,
        C_HassouKbn pHassouKbn, C_InputShrhousiteiKbn pInputShrhousiteiKbn,
        JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 発送区分チェック 開始");

        if (C_SaisateiKbn.BLNK.eq(pSaisateiKbn)) {

            if (C_KanryotuutioutKbn.BLNK.eq(pShrDtlsyoOutKbn)) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAKUSEIKBN_MINYUCHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }

            if (C_KanryotuutioutKbn.GAIBU.eq(pShrDtlsyoOutKbn)) {
                chkHassouKbn(pHassouKbn, pChkKekkaBeanLst);

                chkSakuseiKbnKrkkeijyo(pInputShrhousiteiKbn, pChkKekkaBeanLst);
            }

            if (C_UmuKbn.ARI.eq(pSiKykKihon.getNstkhkumu())
                || (C_UmuKbn.NONE.eq(pSiKykKihon.getNstkhkumu()) && C_Tkhukaumu.HUKA.eq(pTkhukaumu))) {
                chkSakuseiKbn(pShrDtlsyoOutKbn, pChkKekkaBeanLst);
            }

            if (!BizUtil.isBlank(pSaikennmKj)
                && !BizUtil.isBlank(SaikennYno)
                && !BizUtil.isBlank(SaikenAdr1Kj)) {
                chkSaikensya(pShrDtlsyoOutKbn, pChkKekkaBeanLst);
            }
        }



        logger.debug("△ 発送区分チェック 終了");
    }

    private void chkHassouKbn(C_HassouKbn pHassouKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_HassouKbn.BLNK.eq(pHassouKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAKUSEI_HASSOU_SKCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSakuseiKbn(C_KanryotuutioutKbn pShrDtlsyoOutKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (!C_KanryotuutioutKbn.GAIBU.eq(pShrDtlsyoOutKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.NSTK_HASSOU_SKCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }


    private void chkSaikensya(C_KanryotuutioutKbn pShrDtlsyoOutKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_KanryotuutioutKbn.GAIBU.eq(pShrDtlsyoOutKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAIKEN_SAKUSEIKBN_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

    private void chkSakuseiKbnKrkkeijyo(C_InputShrhousiteiKbn pInputShrhousiteiKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI.eq(pInputShrhousiteiKbn) || C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI.eq(pInputShrhousiteiKbn)) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KRKKEIJYOU_SAKUSEIKBN_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }

}