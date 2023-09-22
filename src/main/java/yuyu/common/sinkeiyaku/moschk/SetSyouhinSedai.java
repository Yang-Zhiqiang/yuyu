package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.biz.sorter.SortBM_SyouhnZokusei;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 商品世代番号設定
 */
public class SetSyouhinSedai {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    @Inject
    private BizDomManager bizDomManager;

    public SetSyouhinSedai() {
        super();
    }

    public void exec(MosnaiCheckParam pMp, BizDate pKykYmd) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 商品世代番号設定 開始");
        }

        HT_SyoriCTL syoriCTL = pMp.getDataSyoriControl();
        String mosNo = syoriCTL.getMosno();
        C_SysKbn sysKbn = pMp.getSysKbn();
        List<HT_MosSyouhn> mosSyouhnLst = new ArrayList<>();

        mosSyouhnLst = syoriCTL.getMosSyouhns();

        if (mosSyouhnLst.size() == 0) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

            String syouhinCd = mosSyouhn.getSyouhncd();

            Integer syouhnsdNoMax = bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(syouhinCd, pKykYmd);

            if (syouhnsdNoMax != null) {

                HT_MosSyouhn mosSyouhnUpd = syoriCTL.getMosSyouhnBySyouhncd(syouhinCd);

                BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(syouhinCd,syouhnsdNoMax);

                if (syouhnZokusei == null) {
                    throw new CommonBizAppException("商品コード=" + syouhinCd);
                }

                mosSyouhnUpd.setSyouhnsdno(syouhnsdNoMax);

                mosSyouhnUpd.setRyouritusdno(syouhnZokusei.getRyouritusdno());

                mosSyouhnUpd.setGyoumuKousinsyaId(pMp.getKosID());
                mosSyouhnUpd.setGyoumuKousinTime(pMp.getKosTime());

            }
            else {
                List<BM_SyouhnZokusei> syouhnZokuseiLst = bizDomManager.getSyouhnZokuseisBySyouhncd(syouhinCd);

                if (syouhnZokuseiLst.size() == 0) {
                    throw new CommonBizAppException("商品コード=" + syouhinCd);
                }

                if (syouhnZokuseiLst != null) {
                    SortBM_SyouhnZokusei syouhnZokusei = SWAKInjector.getInstance(SortBM_SyouhnZokusei.class);
                    syouhnZokuseiLst = syouhnZokusei.OrderBM_SyouhnZokuseiByPkDesc(syouhnZokuseiLst);
                }

                String syouhnNm = syouhnZokuseiLst.get(0).getSyouhnnm();
                Integer syouhnSdNo = syouhnZokuseiLst.get(0).getSyouhnsdno();
                String ryouritusdno = syouhnZokuseiLst.get(0).getRyouritusdno();

                if (C_SysKbn.ESHIEN.eq(sysKbn)){

                    pMp.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);

                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EHC0190, syouhnNm),
                        pMp);
                }
                else {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI,
                        makeMsg(MessageId.EHC0049, syouhnNm),
                        pMp);
                }

                HT_MosSyouhn mosSyouhnUpd = syoriCTL.getMosSyouhnBySyouhncd(syouhinCd);

                mosSyouhnUpd.setSyouhnsdno(syouhnSdNo);
                mosSyouhnUpd.setRyouritusdno(ryouritusdno);
                mosSyouhnUpd.setGyoumuKousinsyaId(pMp.getKosID());
                mosSyouhnUpd.setGyoumuKousinTime(pMp.getKosTime());
            }
        }

        if(logger.isDebugEnabled()) {
            logger.debug("△ 商品世代番号設定 終了");
        }
    }

    private  String makeMsg(String pMsgID, String pReplaceMsg)  {
        StringBuffer ret = new StringBuffer();
        ret.append(pMsgID);
        ret.append(" ");
        ret.append(MessageUtil.getMessage(pMsgID, pReplaceMsg));
        return ret.toString();
    }
}