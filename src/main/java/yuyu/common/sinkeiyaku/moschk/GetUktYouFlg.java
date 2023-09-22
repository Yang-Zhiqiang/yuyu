package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 受取人要フラグ取得
 */
public class GetUktYouFlg {

    private boolean sbUktFlg = false;

    private boolean mnkUktFlg = false;

    private boolean kzkTrkSrvFlg = false;

    private boolean kykDrFlg = false;

    private boolean hhknDrFlg = false;

    private boolean sbHnknUktFlg = false;

    private boolean sbhkkUktFlg = false;

    private boolean sbkyhkUktFlg = false;

    private boolean nenkinUktFlg = false;

    private boolean teikShrknUktFlg = false;

    @Inject
    private static Logger logger;

    public GetUktYouFlg() {
        super();
    }

    public boolean getFlgSbUkt() {
        return this.sbUktFlg;
    }

    public boolean getFlgMnkUkt() {
        return this.mnkUktFlg;
    }

    public boolean getFlgKzkTrkSrv() {
        return this.kzkTrkSrvFlg;
    }

    public boolean getFlgKykDr() {
        return this.kykDrFlg;
    }

    public boolean getFlgHhknDr() {
        return this.hhknDrFlg;
    }

    public boolean getFlgSbHnknknUkt() {
        return this.sbHnknUktFlg;
    }

    public boolean getFlgSbHknknUkt() {
        return this.sbhkkUktFlg;
    }

    public boolean getFlgSbKyhknUkt() {
        return this.sbkyhkUktFlg;
    }

    public boolean getFlgNkUkt() {
        return this.nenkinUktFlg;
    }

    public boolean getFlgTikShrknUkt() {
        return this.teikShrknUktFlg;
    }

    public void exec(MosnaiCheckParam pMp) {

        C_UmuKbn sbUktUmu;
        C_UmuKbn mnkUktUmu;
        C_UmuKbn kzkTrkSrvUmu;
        C_UmuKbn kykDrUmu;
        C_UmuKbn hhknDrUmu;
        C_UmuKbn sbHnknuktUmu;
        C_UmuKbn sbHkkuktUmu;
        C_UmuKbn sbKyhkuktUmu;
        C_UmuKbn nenkinUktUmu;
        C_UmuKbn teikShrUktUmu;

        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();
        String mosNo = syoriCtl.getMosno();

        List<HT_MosSyouhn> mosSyouhnLst = new ArrayList<>();

        mosSyouhnLst = syoriCtl.getMosSyouhns();

        if (mosSyouhnLst.size() == 0) {

            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

            String syouhncd = mosSyouhn.getSyouhncd();
            Integer syouhnsdno = mosSyouhn.getSyouhnsdno();

            BM_SyouhnZokusei syouhnZokusei =pMp.getSyouhnZokusei(syouhncd, syouhnsdno);

            sbUktUmu = syouhnZokusei.getSbuktumu();
            mnkUktUmu = syouhnZokusei.getMnkuktumu();
            kzkTrkSrvUmu = syouhnZokusei.getKzktourokuserviceumu();
            kykDrUmu = syouhnZokusei.getKykdrtkykumu();
            hhknDrUmu = syouhnZokusei.getStdrsktkumu();
            sbHnknuktUmu = syouhnZokusei.getSbhnknuktumu();
            sbHkkuktUmu = syouhnZokusei.getSbhkuktumu();
            sbKyhkuktUmu = syouhnZokusei.getSbkyuuhukinuktumu();
            nenkinUktUmu = syouhnZokusei.getNkuktumu();
            teikShrUktUmu = syouhnZokusei.getTeikisiharaikinumu();

            if (!sbUktFlg && C_UmuKbn.ARI.eq(sbUktUmu)) {
                sbUktFlg = true;
            }
            if (!mnkUktFlg && C_UmuKbn.ARI.eq(mnkUktUmu)) {
                mnkUktFlg = true;
            }
            if (C_SyutkKbn.SYU.eq(mosSyouhn.getSyutkkbn()) && !kzkTrkSrvFlg && C_UmuKbn.ARI.eq(kzkTrkSrvUmu)) {
                kzkTrkSrvFlg = true;
            }
            if (!kykDrFlg && C_UmuKbn.ARI.eq(kykDrUmu)) {
                kykDrFlg = true;
            }
            if (!hhknDrFlg && C_UmuKbn.ARI.eq(hhknDrUmu)) {
                hhknDrFlg = true;
            }
            if (!sbHnknUktFlg && C_UmuKbn.ARI.eq(sbHnknuktUmu)) {
                sbHnknUktFlg = true;
            }
            if (!sbhkkUktFlg && C_UmuKbn.ARI.eq(sbHkkuktUmu)) {
                sbhkkUktFlg = true;
            }
            if (!sbkyhkUktFlg && C_UmuKbn.ARI.eq(sbKyhkuktUmu)) {
                sbkyhkUktFlg = true;
            }
            if (!nenkinUktFlg && C_UmuKbn.ARI.eq(nenkinUktUmu)) {
                nenkinUktFlg = true;
            }
            if (!teikShrknUktFlg && C_UmuKbn.ARI.eq(teikShrUktUmu)) {
                teikShrknUktFlg = true;
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("死亡受取人要フラグ=" + sbUktFlg);
            logger.debug("満期受取人要フラグ=" + mnkUktFlg);
            logger.debug("家族登録サービス要フラグ=" + kzkTrkSrvFlg);
            logger.debug("契約者代理人要フラグ=" + kykDrFlg);
            logger.debug("被保険者代理人要フラグ=" + hhknDrFlg);
            logger.debug("死亡返還金受取人要フラグ=" + sbHnknUktFlg);
            logger.debug("死亡保険金受取人要フラグ=" + sbhkkUktFlg);
            logger.debug("死亡給付金受取人要フラグ=" + sbkyhkUktFlg);
            logger.debug("年金受取人要フラグ=" + nenkinUktFlg);
            logger.debug("定期支払金受取人要フラグ=" + teikShrknUktFlg);
        }
    }
}
