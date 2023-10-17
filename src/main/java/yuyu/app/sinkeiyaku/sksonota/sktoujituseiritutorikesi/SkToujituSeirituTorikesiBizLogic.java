package yuyu.app.sinkeiyaku.sksonota.sktoujituseiritutorikesi;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzCommonLockProcess;
import yuyu.common.biz.koutei.BzGetProcessSummary;
import yuyu.common.biz.koutei.BzGetProcessSummaryInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardInBean;
import yuyu.common.sinkeiyaku.koutei.SkProcessForwardToujituSeirituTorikesi;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdate;
import yuyu.common.sinkeiyaku.skcommon.GetMsgAitemosno;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouKekkaBean;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;
import yuyu.common.sinkeiyaku.skcommon.SkToujituIdounaiyouEdit;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_KykkakjkKbn;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_SateijtKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SknnkaisikitkhukaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_UriagesousinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 当日成立取消 のビジネスロジックです。
 */
public class SkToujituSeirituTorikesiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkToujituSeirituTorikesiUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private MessageManager messageManager;

    @Inject
    private GetMsgAitemosno getMsgAitemosno;

    @Inject
    private BzCommonLockProcess bzCommonLockProcess;

    @Inject
    private BzGetProcessSummary bzGetProcessSummary;

    @Inject
    private BzGetProcessSummaryInBean bzGetProcessSummaryInBean;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    void init() {
    }

    void clear() {
    }

    void pushKakuninBL() {

        BizPropertyInitializer.initialize(uiBean);

        String mosNo = uiBean.getMosno();
        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo);

        if (syoriCtl == null) {

            throw new BizLogicException(MessageId.EBA0090);
        }

        if (!C_SeirituKbn.SEIRITU.eq(syoriCtl.getSeiritukbn()) &&
            !C_SeirituKbn.HUSEIRITU.eq(syoriCtl.getSeiritukbn())) {

            throw new BizLogicException(MessageId.EBA0031, syoriCtl.getSeiritukbn().getContent());
        }

        if(BizDateUtil.compareYmd(syoriCtl.getSrsyoriymd(), BizDate.getSysDate()) != BizDateUtil.COMPARE_EQUAL) {

            throw new BizLogicException(MessageId.EHA0375);
        }

        if (C_SeirituKbn.HUSEIRITU.eq(syoriCtl.getSeiritukbn())) {

            List<HT_Henkin> henkinLst = syoriCtl.getHenkinsByHnknsyoriymd(BizDate.getSysDate());

            if (henkinLst.size() > 0) {

                for (HT_Henkin henkin : henkinLst) {

                    if (C_HenkinriyuuKbn.MIAWASEENKI.eq(henkin.getHnknriyuukbn())
                        || C_HenkinriyuuKbn.YUUKOUKKNKKA.eq(henkin.getHnknriyuukbn())
                        || C_HenkinriyuuKbn.MOS_TORIKESI.eq(henkin.getHnknriyuukbn())) {

                        throw new BizLogicException(MessageId.EHF1003);

                    }
                }
            }
        }

        HT_MosKihon mosKihon = syoriCtl.getMosKihon();

        if (mosKihon == null) {
            throw new CommonBizAppException("申込番号=" + mosNo);
        }

        bzGetProcessSummaryInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        bzGetProcessSummaryInBean.setKouteiKanriStatuss(C_Kouteikanristatus.SYORITYUU);
        bzGetProcessSummaryInBean.setMosNo(mosNo);

        bzCommonLockProcess.lockProcess(bzGetProcessSummary.exec(bzGetProcessSummaryInBean).get(0).getKouteiKanriId(),
            ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        int kekkaKbn = getMsgAitemosno.exec(syoriCtl.getMosnrkumu(), mosKihon.getAitemosno());

        if (GetMsgAitemosno.KEKKAKBN_ARI == kekkaKbn) {

            messageManager.addConversationMessageId(SkMessageGroupConstants.GROUP_WARNING,
                BizUtil.getGeneralMessageId(getMsgAitemosno.getS_gmmsgid()),
                getMsgAitemosno.getS_gmmsg());
        }

        uiBean.setHhknnmkj(mosKihon.getHhknnmkj());

        messageManager.addMessageId(MessageId.QHA0016);

        uiBean.setSyoriCTL(syoriCtl);

        uiBean.setSkIdounaiyouBeforeBean(skToujituIdounaiyouEdit.setSkIdounaiyouBefore(syoriCtl));
    }

    @Transactional
    void pushKakuteiBL() {

        String sysTime = BizDate.getSysDateTimeMilli();
        SkToujituIdounaiyouEdit skToujituIdounaiyouEdit = SWAKInjector.getInstance(SkToujituIdounaiyouEdit.class);
        SkProcessForwardInBean skProcessForwardInBean = SWAKInjector.getInstance(SkProcessForwardInBean.class);

        String mosNo = uiBean.getMosno();

        HT_SyoriCTL syoriCtl = uiBean.getSyoriCTL();
        C_SeirituKbn seirituKbn = syoriCtl.getSeiritukbn();
        C_KykkakjkKbn kykkakjkKbn = syoriCtl.getKykkakjkkbn();
        C_UmuKbn nyknnrkUmu = syoriCtl.getNyknnrkumu();

        if (C_UmuKbn.ARI.eq(nyknnrkUmu)) {
            syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.NYUUKINCHKMIRYOU);
        }
        else {
            syoriCtl.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.SONOTA_MINYUUKIN);
        }
        syoriCtl.setSeiritukbn(C_SeirituKbn.NONE);
        syoriCtl.setSrsyoriymd(null);
        syoriCtl.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        syoriCtl.setGyoumuKousinTime(sysTime);

        HT_MosKihon mosKihon = syoriCtl.getMosKihon();
        mosKihon.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        mosKihon.setGyoumuKousinTime(sysTime);

        if (C_SeirituKbn.SEIRITU.eq(seirituKbn)) {

            List<HT_SkDenpyoData> skDenpyoDataLst1 = null;

            List<HT_SkDenpyoData> skDenpyoDataLst2 = null;

            if ((!C_SknnkaisikitkhukaKbn.HUKA.eq(mosKihon.getSknnkaisikitkhukakbn())) &&
                (C_FstphrkkeiroKbn.CREDIT.eq(mosKihon.getFstphrkkeirokbn()))) {

                HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMaxRenno(mosNo);

                if (nyuukin == null) {
                    throw new CommonBizAppException("申込番号=" + mosNo);
                }

                skDenpyoDataLst1 = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno(nyuukin.getDenrenno());

                skDenpyoDataLst2 = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno(nyuukin.getDenrenno2());

                sinkeiyakuDomManager.delete(skDenpyoDataLst1);

                sinkeiyakuDomManager.delete(skDenpyoDataLst2);

                syoriCtl.getNyuukins().remove(nyuukin);
                syoriCtl.setNyknnrkumu(C_UmuKbn.NONE);
                syoriCtl.setUriagesousinkbn(C_UriagesousinKbn.BLNK);
            }

            if ((C_SknnkaisikitkhukaKbn.HUKA.eq(mosKihon.getSknnkaisikitkhukakbn())) &&
                (C_FstphrkkeiroKbn.CREDIT.eq(mosKihon.getFstphrkkeirokbn()))) {

                if (C_UmuKbn.ARI.eq(nyknnrkUmu)) {

                    List<HT_Nyuukin> nyuukinLst = syoriCtl.getNyuukinsByNyknsyubetu(C_NyknsyubetuKbn.CREDIT);

                    if (nyuukinLst.size() != 0) {

                        for (HT_Nyuukin nyuukin : nyuukinLst) {

                            skDenpyoDataLst1 = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno(nyuukin.getDenrenno());

                            skDenpyoDataLst2 = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno(nyuukin.getDenrenno2());

                            sinkeiyakuDomManager.delete(skDenpyoDataLst1);

                            sinkeiyakuDomManager.delete(skDenpyoDataLst2);

                        }

                        syoriCtl.getNyuukins().removeAll(nyuukinLst);
                        syoriCtl.setNyknnrkumu(C_UmuKbn.NONE);
                        syoriCtl.setUriagesousinkbn(C_UriagesousinKbn.BLNK);
                    }
                }
            }

            if (C_KykkakjkKbn.SEIRITUGO_KAK_IRAISU.eq(kykkakjkKbn)) {
                syoriCtl.setKykkakjkkbn(C_KykkakjkKbn.KAKUNIN_SUMI);
            }
        }
        else if (C_SeirituKbn.HUSEIRITU.eq(seirituKbn)) {

            syoriCtl.setKetteikbn(C_KetteiKbn.NONE);
            syoriCtl.setSateijtkbn(C_SateijtKbn.SATEI_TYUU);
            syoriCtl.setSateizumiymd(null);

            Integer renNo = sinkeiyakuDomManager.getDakuhiKetteiMaxDakuhiktrennoByMosno(mosNo);

            if (renNo == null) {
                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            HT_DakuhiKettei dakuhiKettei = syoriCtl.getDakuhiKetteiByDakuhiktrenno(renNo);

            if (dakuhiKettei == null) {
                throw new CommonBizAppException("申込番号=" + mosNo);
            }

            syoriCtl.getDakuhiKetteis().remove(dakuhiKettei);

            sinkeiyakuDomManager.flush();

            List<HT_Henkin> henkinLst = syoriCtl.getHenkinsByHnknsyoriymdNull();

            if (henkinLst.size() > 0) {

                for (HT_Henkin henkin : henkinLst) {

                    if (C_HenkinriyuuKbn.MIAWASEENKI.eq(henkin.getHnknriyuukbn())
                        || C_HenkinriyuuKbn.YUUKOUKKNKKA.eq(henkin.getHnknriyuukbn())
                        || C_HenkinriyuuKbn.MOS_TORIKESI.eq(henkin.getHnknriyuukbn())) {

                        List<HT_SkDenpyoData> skDenpyoDataLst =
                            sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno(henkin.getPkakindenrenno());

                        if (skDenpyoDataLst.size() > 0) {

                            sinkeiyakuDomManager.delete(skDenpyoDataLst);
                        }

                        syoriCtl.getHenkins().remove(henkin);

                        skProcessForwardInBean.setHnkninputTorikesiyhKbn(C_YouhiKbn.YOU);
                    }
                }
            }
        }

        sinkeiyakuDomManager.update(syoriCtl);

        SkProcessForwardToujituSeirituTorikesi skProcessForward =
            SWAKInjector.getInstance(SkProcessForwardToujituSeirituTorikesi.class);

        skProcessForwardInBean.setMosNo(uiBean.getMosno());
        skProcessForwardInBean.setTskNm("当日成立取消");
        skProcessForwardInBean.setKouteiLockkey(bzCommonLockProcess.getKouteiLockKey());
        skProcessForwardInBean.setSyorikekkaKbn(C_SyorikekkaKbn.KANRYOU);
        skProcessForwardInBean.setSyoriComment("");

        skProcessForward.exec(skProcessForwardInBean);

        SkProcessUpdate skProcessUpdate = SWAKInjector.getInstance(SkProcessUpdate.class);

        skProcessUpdate.exec(syoriCtl, bzCommonLockProcess.getKouteiLockKey(), null);

        if (skToujituIdounaiyouEdit.skIdounaiyouHenkouCheck(syoriCtl, uiBean.getSkIdounaiyouBeforeBean())) {

            SkIdounaiyouKekkaBean skIdounaiyouKekkaBean = skToujituIdounaiyouEdit.skIdounaiyouMQEdit(syoriCtl);

            if (!C_ErrorKbn.OK.eq(skIdounaiyouKekkaBean.getErrorKbn())) {

                for (String errorMsg : skIdounaiyouKekkaBean.getErrorMsgLst()) {

                    errorMessageCollector.addMessage(errorMsg);
                }

                errorMessageCollector.addMessage(MessageId.QHA0016);
                errorMessageCollector.throwBizLogicException();
            }
        }
        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);
        messageManager.addMessageId(MessageId.IAC0009);
    }

    void continueLockProcessBL() {

        bzCommonLockProcess.continueLockProcess();
    }

    void unlockProcessBL() {

        bzCommonLockProcess.unlockProcess();
    }

}
