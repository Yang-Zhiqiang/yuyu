package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.MousikomiNoCheck;
import yuyu.common.biz.bzcommon.SyokenNoCheck;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Syonokanri;

/**
 * 新契約 新契約共通 証券番号自動採番
 */
public class SyoukenNoUtil {

    private static final int RETRY_COUNT = 100;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    @Transactional
    public String getShokenNo(String pMosNo, String pBosyuuSosikiCd, String pSousasyaCd) {

        String syono = "";

        int loopCount = 1;

        if (!BizUtil.isBlank(pMosNo)) {

            boolean result = MousikomiNoCheck.isValid(pMosNo);

            if (!result) {

                throw new CommonBizAppException();
            }
        }

        for (loopCount = 1;; loopCount++) {

            try {

                syono = exec(pSousasyaCd, pMosNo, pBosyuuSosikiCd);
            }

            catch (CommonBizAppException bizEx) {

                throw bizEx;
            }

            catch (Exception ex) {

                if (loopCount > RETRY_COUNT) {

                    throw new CommonBizAppException();
                }

                logger.debug("証券番号採番リトライ（"+String.valueOf(loopCount)+"回目）");

                continue;
            }

            break;
        }

        return syono;
    }

    private String exec(String pSousasyaCD, String pMosNO, String pBosyuuSosikiCD) throws CommonBizAppException,
    Exception {

        String syoNo = "";

        int checkDegit = 0;

        BizDate sysDate = BizDate.getSysDate();

        String seirekiYear = "";

        String bosyuuSosikiCd = "";

        String syonoRenban = "";

        String imiNoObjectStr = "";

        int bosyuuSosikiCdThree = 806;

        int syonoRenbanFive = 0;

        BM_Syonokanri syonoKanri = null;

        seirekiYear = sysDate.toString().substring(2, 4);

        bosyuuSosikiCd = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2ketaSaibanymd(seirekiYear,
            BizDate.getSysDate());

        if (BizUtil.isBlank(bosyuuSosikiCd)) {

            bosyuuSosikiCd = bizDomManager.getSyonokanriMaxBosyuusosikicdBySeirekinen2keta(seirekiYear);

            if (BizUtil.isBlank(bosyuuSosikiCd)) {

                bosyuuSosikiCd = "806";
            }
        }

        Integer syonoRenbanFiveTmp = bizDomManager.getSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(
            seirekiYear,bosyuuSosikiCd);

        if (syonoRenbanFiveTmp != null) {

            syonoRenbanFive = syonoRenbanFiveTmp;
        }

        syonoRenbanFive = syonoRenbanFive + 1;

        while (true) {

            if (syonoRenbanFive > 79989) {

                if ("810".equals(bosyuuSosikiCd)) {

                    throw new CommonBizAppException();
                }

                bosyuuSosikiCdThree = Integer.parseInt(pBosyuuSosikiCD) + 1;

                bosyuuSosikiCd = String.valueOf(bosyuuSosikiCdThree);

                syonoRenbanFive = 1;

                syonoRenban = "00001";
            }
            else {

                syonoRenban = String.format("%05d", syonoRenbanFive);
            }

            syoNo = seirekiYear + bosyuuSosikiCd + syonoRenban;

            checkDegit = SyokenNoCheck.calcDegit(syoNo);

            if (checkDegit < 0) {

                throw new CommonBizAppException();
            }

            imiNoObjectStr = syonoRenban + String.valueOf(checkDegit);

            boolean chkResult = imiNoObjectStr.matches(YuyuBizConfig.getInstance().getImiBangouChkPtn());

            if (!chkResult) {

                syoNo = syoNo + String.valueOf(checkDegit);

                break;
            }

            syonoRenbanFive = syonoRenbanFive + 1;
        }

        syonoKanri = new BM_Syonokanri();

        syonoKanri.setSeirekinen2keta(seirekiYear);

        syonoKanri.setBosyuusosikicd(bosyuuSosikiCd);

        syonoKanri.setSyonorenno(syonoRenbanFive);

        syonoKanri.setSyono(syoNo);

        syonoKanri.setMosno(pMosNO);

        syonoKanri.setSaibanymd(sysDate);

        syonoKanri.setGyoumuKousinsyaId(pSousasyaCD);

        syonoKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        BizPropertyInitializer.initialize(syonoKanri);

        ExDBTransactionalUtil.insert(syonoKanri);

        return syoNo;
    }
}
