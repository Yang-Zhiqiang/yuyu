package yuyu.common.siharai.sicommon;

import java.math.RoundingMode;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.MathUtil;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_JydkgmbHkKsnKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.db.entity.JM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 保険金給付金支払共通 重度介護前払保険金額計算
 */
public class CalcJdkghkKngk {

    @Inject
    private static Logger logger;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    private CalcJdkghkKngkBean calcJdkghkKngkBean;

    public CalcJdkghkKngk() {
        super();
    }

    public CalcJdkghkKngkBean getCalcJdkghkKngkBean() {
        return calcJdkghkKngkBean;
    }

    public C_ErrorKbn exec(C_JydkgmbHkKsnKbn pJydkgmbHkKsnKbn, BizCurrency pTkkijyunHokenkngk, BizCurrency pKaiyakuhr,
        BizNumber pYoteiriritu, BizDate pKykymd, BizDate pCalckijyunymd, BizDate pHhknseiymd, Integer pNen,
        C_Hhknsei pHhknsei) {

        logger.debug("▽ 重度介護前払保険金額計算 開始");

        calcJdkghkKngkBean = SWAKInjector.getInstance(CalcJdkghkKngkBean.class);
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pTkkijyunHokenkngk == null) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 重度介護前払保険金額計算 終了");
            return errorKbn;
        }
        if (pYoteiriritu == null) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 重度介護前払保険金額計算 終了");
            return errorKbn;
        }
        if (C_JydkgmbHkKsnKbn.KIJUNBISITEI.eq(pJydkgmbHkKsnKbn)) {
            if (pKykymd == null) {
                errorKbn = C_ErrorKbn.ERROR;
                logger.debug("△ 重度介護前払保険金額計算 終了");
                return errorKbn;
            }
            if (pCalckijyunymd == null) {
                errorKbn = C_ErrorKbn.ERROR;
                logger.debug("△ 重度介護前払保険金額計算 終了");
                return errorKbn;
            }
            if (pHhknseiymd == null) {
                errorKbn = C_ErrorKbn.ERROR;
                logger.debug("△ 重度介護前払保険金額計算 終了");
                return errorKbn;
            }
            if (pKykymd.compareTo(pCalckijyunymd) > 0) {
                errorKbn = C_ErrorKbn.ERROR;
                logger.debug("△ 重度介護前払保険金額計算 終了");
                return errorKbn;
            }
        }
        if (C_JydkgmbHkKsnKbn.NENREISITEI.eq(pJydkgmbHkKsnKbn)) {
            if (pNen == null) {
                errorKbn = C_ErrorKbn.ERROR;
                logger.debug("△ 重度介護前払保険金額計算 終了");
                return errorKbn;
            }
        }
        if (C_Hhknsei.BLNK.eq(pHhknsei)) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 重度介護前払保険金額計算 終了");
            return errorKbn;
        }

        Integer hhknNen = 0;
        if (C_JydkgmbHkKsnKbn.KIJUNBISITEI.eq(pJydkgmbHkKsnKbn)) {
            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
            Integer kykjiHhknNen = setNenrei.exec(pKykymd, pHhknseiymd);
            Integer kykOutoubiKeikaCnt = getKykOutoubiKeikaCnt(pKykymd, pCalckijyunymd);
            hhknNen = kykjiHhknNen + kykOutoubiKeikaCnt;
        }
        else {
            hhknNen = pNen;
        }

        BizNumber waribikiKikan = null;
        JM_JyudkaigomebrtkWrbkkkn jyudkaigomebrtkWrbkkkn =
            siharaiDomManager.getJyudkaigomebrtkWrbkkkn(hhknNen, C_Seibetu.valueOf(pHhknsei.getValue()));
        if (jyudkaigomebrtkWrbkkkn == null) {
            errorKbn = C_ErrorKbn.ERROR;
            logger.debug("△ 重度介護前払保険金額計算 終了");
            return errorKbn;
        }
        waribikiKikan = jyudkaigomebrtkWrbkkkn.getWaribikikikan();

        BizNumber gnkritu = BizNumber.ONE.divide((BizNumber.ONE.add(pYoteiriritu)), 8, RoundingMode.DOWN);
        BizNumber kknGnkritu = MathUtil.powDecimal(gnkritu, waribikiKikan, 8, 1);
        BizCurrency koujyoRisoku = pTkkijyunHokenkngk.multiply(BizNumber.ONE.subtract(kknGnkritu)).toValidValue();
        BizCurrency jdkghkKnGkCompareBefore = pTkkijyunHokenkngk.subtract(koujyoRisoku);

        BizCurrency jdkghkKnGk = null;
        if (jdkghkKnGkCompareBefore.compareTo(pKaiyakuhr) > 0) {
            jdkghkKnGk = jdkghkKnGkCompareBefore;
        }
        else {
            jdkghkKnGk = pKaiyakuhr;
        }

        calcJdkghkKngkBean.setJdkghkKnGkCompareBefore(jdkghkKnGkCompareBefore);
        calcJdkghkKngkBean.setJdkghkKnGk(jdkghkKnGk);
        calcJdkghkKngkBean.setWaribikiKikan(waribikiKikan);

        logger.debug("△ 重度介護前払保険金額計算 終了");

        return errorKbn;
    }

    private Integer getKykOutoubiKeikaCnt(BizDate pKykymd, BizDate pCalckijyunymd) {
        Integer kykOutoubiKeikaCnt = 0;

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
        BizDate kykOutoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, pKykymd, C_Hrkkaisuu.NEN, pKykymd);

        while (kykOutoubi.compareTo(pCalckijyunymd) <= 0) {
            kykOutoubiKeikaCnt++;
            kykOutoubi = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, pKykymd, C_Hrkkaisuu.NEN, kykOutoubi);
        }
        return kykOutoubiKeikaCnt;
    }
}