package yuyu.common.hozen.ascommon;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 案内収納共通 保険料領収通貨取得
 */
public class GetasPRsTuuka {

    private C_Tuukasyu rstuukasyu;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public C_Tuukasyu getRstuukasyu() {
        return rstuukasyu;
    }

    public C_ErrorKbn exec(String pSyono) {

        logger.debug("▽ 保険料領収通貨取得 開始");

        rstuukasyu = C_Tuukasyu.BLNK;

        if (BizUtil.isBlank(pSyono)) {

            logger.debug("△ 保険料領収通貨取得 終了");
            return C_ErrorKbn.ERROR;
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnLst == null || kykSyouhnLst.size() == 0) {

            logger.debug("△ 保険料領収通貨取得 終了");
            return C_ErrorKbn.ERROR;
        }

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        if (kykSonotaTkyk == null) {

            logger.debug("△ 保険料領収通貨取得 終了");
            return C_ErrorKbn.ERROR;
        }

        C_Tuukasyu kyktuukasyu = kykSyouhnLst.get(0).getKyktuukasyu();
        C_UmuKbn yennykntkhkumu = kykSonotaTkyk.getYennykntkhkumu();
        C_UmuKbn gaikanykntkhkumu = kykSonotaTkyk.getGaikanykntkhkumu();

        C_ErrorKbn kekkaKbn = editRyousyuuTuukaSyuruiHantei(kyktuukasyu, yennykntkhkumu, gaikanykntkhkumu);

        logger.debug("△ 保険料領収通貨取得 終了");

        return kekkaKbn;
    }

    public C_ErrorKbn editRyousyuuTuukaSyuruiHantei(C_Tuukasyu pKyktuukasyu, C_UmuKbn pYennykntkhkumu, C_UmuKbn pGaikanykntkhkumu) {

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;
        rstuukasyu = C_Tuukasyu.BLNK;

        if (pKyktuukasyu == null ||
            pYennykntkhkumu == null ||
            pGaikanykntkhkumu == null) {

            return C_ErrorKbn.ERROR;
        }

        if (C_Tuukasyu.JPY.eq(pKyktuukasyu)) {

            rstuukasyu = C_Tuukasyu.JPY;
        }
        else if (C_UmuKbn.ARI.eq(pYennykntkhkumu)) {

            rstuukasyu = C_Tuukasyu.JPY;
        }
        else if ((C_Tuukasyu.USD.eq(pKyktuukasyu) || C_Tuukasyu.AUD.eq(pKyktuukasyu)) &&
            C_UmuKbn.ARI.eq(pGaikanykntkhkumu)) {

            if (C_Tuukasyu.USD.eq(pKyktuukasyu)) {

                rstuukasyu = C_Tuukasyu.AUD;
            }
            else if (C_Tuukasyu.AUD.eq(pKyktuukasyu)) {

                rstuukasyu = C_Tuukasyu.USD;
            }
        }
        else {

            rstuukasyu = pKyktuukasyu;
        }

        return kekkaKbn;
    }
}
