package yuyu.app.biz.bzmaster.bzsimekiribi;

import static yuyu.app.biz.bzmaster.bzsimekiribi.GenBzSimekiribiConstants.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.biz.bzmaster.bzsimekiribi.BzSimekiribiConstants.E_SyoriKbn;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Simekiribi;

/**
 * 締切日登録 のビジネスロジックです。
 */
public class BzSimekiribiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private BzSimekiribiUiBean uiBean;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    void init() {
    }

    void clear() {
    }

    void pushAddBL() {
        BizPropertyInitializer.initialize(uiBean);
        BizDateYM bosyuuYm = null;
        BM_Simekiribi simekiribi = null;

        bosyuuYm = uiBean.getBosyuuym();
        simekiribi = bizDomManager.getSimekiribi(bosyuuYm);

        if (simekiribi != null) {
            throw new BizLogicException(MessageId.EHA0041,
                    MessageUtil.getMessage(DDID_KEYINFO_BOSYUUYM.getErrorResourceKey()));
        }

        uiBean.setGmsyorikbn(E_SyoriKbn.ADD);
    }

    void pushUpdBL() {

        BizPropertyInitializer.initialize(uiBean);
        BizDateYM bosyuuYm = uiBean.getBosyuuym();

        BM_Simekiribi simekiribi = bizDomManager.getSimekiribi(bosyuuYm);

        if (simekiribi == null) {
            throw new BizLogicException(MessageId.EBA0030,
                    MessageUtil.getMessage(DDID_KEYINFO_BOSYUUYM.getErrorResourceKey()));
        }

        setUiBean(simekiribi);
        uiBean.setSimekiribi(simekiribi);
        uiBean.setGmsyorikbn(E_SyoriKbn.UPD);
    }

    void pushDelBL() {

        BizPropertyInitializer.initialize(uiBean);
        BizDateYM bosyuuYm = uiBean.getBosyuuym();

        BM_Simekiribi simekiribi = bizDomManager.getSimekiribi(bosyuuYm);

        if (simekiribi == null) {
            throw new BizLogicException(MessageId.EBA0030,
                    MessageUtil.getMessage(DDID_KEYINFO_BOSYUUYM.getErrorResourceKey()));
        }

        setUiBean(simekiribi);
        uiBean.setSimekiribi(simekiribi);
        uiBean.setGmsyorikbn(E_SyoriKbn.DEL);
        messageManager.addMessageId(MessageId.QAC0010);
    }

    void pushKakuninBL() {

        check();

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if (syoriKbn == E_SyoriKbn.ADD) {
            messageManager.addMessageId(MessageId.QAC0008);
        }
        else {
            messageManager.addMessageId(MessageId.QAC0009);
        }
    }

    @Transactional
    void pushkakuteiBL() {
        doUpdateTables();

        messageManager.addMessageId(MessageId.IAC0009);
    }


    private void setUiBean(BM_Simekiribi simekiribi) {


        uiBean.setMossimefromymd(simekiribi.getMossimefromymd());
        uiBean.setMossimetoymd(simekiribi.getMossimetoymd());
        uiBean.setMosnrksimefromymd(simekiribi.getMosnrksimefromymd());
        uiBean.setMosnrksimetoymd(simekiribi.getMosnrksimetoymd());
        uiBean.setNyknsimefromymd(simekiribi.getNyknsimefromymd());
        uiBean.setNyknsimetoymd(simekiribi.getNyknsimetoymd());
        uiBean.setSyorisimefromymd(simekiribi.getSyorisimefromymd());
        uiBean.setSyorisimetoymd(simekiribi.getSyorisimetoymd());
    }


    private void check() {

        BizDate gdMosF = uiBean.getMossimefromymd();
        BizDate gdMosT = uiBean.getMossimetoymd();
        BizDate mosnrkSimeFromYmd = uiBean.getMosnrksimefromymd();
        BizDate mosnrkSimeToYmd = uiBean.getMosnrksimetoymd();
        BizDate gdNyknF = uiBean.getNyknsimefromymd();
        BizDate gdNyknT = uiBean.getNyknsimetoymd();
        BizDate gdSyoriF = uiBean.getSyorisimefromymd();
        BizDate gdSyoriT = uiBean.getSyorisimetoymd();

        if (BizDateUtil.compareYmd(gdMosF, gdMosT) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHA0301,
                    MessageUtil.getMessage(DDID_SIMEKIRIBIINFO_MOSSIMEFROMYMD.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SIMEKIRIBIINFO_MOSSIMETOYMD.getErrorResourceKey()));

        }
        if (BizDateUtil.compareYmd(mosnrkSimeFromYmd, mosnrkSimeToYmd) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHA0301,
                    MessageUtil.getMessage(DDID_SIMEKIRIBIINFO_MOSNRKSIMEFROMYMD.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SIMEKIRIBIINFO_MOSNRKSIMETOYMD.getErrorResourceKey()));
        }
        if (BizDateUtil.compareYmd(gdNyknF, gdNyknT) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHA0301,
                    MessageUtil.getMessage(DDID_SIMEKIRIBIINFO_NYKNSIMEFROMYMD.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SIMEKIRIBIINFO_NYKNSIMETOYMD.getErrorResourceKey()));
        }
        if (BizDateUtil.compareYmd(gdSyoriF, gdSyoriT) == BizDateUtil.COMPARE_GREATER) {
            throw new BizLogicException(MessageId.EHA0301,
                    MessageUtil.getMessage(DDID_SIMEKIRIBIINFO_SYORISIMEFROMYMD.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SIMEKIRIBIINFO_SYORISIMETOYMD.getErrorResourceKey()));
        }
    }

    private void doUpdateTables() {

        BM_Simekiribi simekiribi = null;
        String userID = baseUserInfo.getUserId();
        String kostime = BizDate.getSysDateTimeMilli();

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();


        if (syoriKbn == E_SyoriKbn.ADD) {
            simekiribi = setSimekiribi();
            setSystemKoumoku(simekiribi, userID, kostime);
            BizPropertyInitializer.initialize(simekiribi);
            bizDomManager.insert(simekiribi);
        }
        else if (syoriKbn == E_SyoriKbn.UPD)  {
            simekiribi = setSimekiribi();
            setSystemKoumoku(simekiribi, userID, kostime);
            bizDomManager.update(simekiribi);
        }
        else {
            simekiribi = uiBean.getSimekiribi();

            bizDomManager.delete(simekiribi);
        }
    }

    private void setSystemKoumoku(BM_Simekiribi pSimekiribi, String pUserID, String pSysDate) {
        pSimekiribi.setGyoumuKousinsyaId(pUserID);
        pSimekiribi.setGyoumuKousinTime(pSysDate);
    }

    private BM_Simekiribi setSimekiribi() {

        BM_Simekiribi simekiribi = null;

        E_SyoriKbn syoriKbn = uiBean.getGmsyorikbn();

        if (syoriKbn == E_SyoriKbn.ADD) {
            simekiribi = new BM_Simekiribi();
        }
        else {
            simekiribi = uiBean.getSimekiribi();

        }

        simekiribi.setBosyuuym(uiBean.getBosyuuym());
        simekiribi.setMossimefromymd(uiBean.getMossimefromymd());
        simekiribi.setMossimetoymd(uiBean.getMossimetoymd());
        simekiribi.setMosnrksimefromymd(uiBean.getMosnrksimefromymd());
        simekiribi.setMosnrksimetoymd(uiBean.getMosnrksimetoymd());
        simekiribi.setNyknsimefromymd(uiBean.getNyknsimefromymd());
        simekiribi.setNyknsimetoymd(uiBean.getNyknsimetoymd());
        simekiribi.setSyorisimefromymd(uiBean.getSyorisimefromymd());
        simekiribi.setSyorisimetoymd(uiBean.getSyorisimetoymd());

        return simekiribi;
    }
}