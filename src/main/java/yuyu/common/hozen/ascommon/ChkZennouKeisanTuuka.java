package yuyu.common.hozen.ascommon;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanBean;
import yuyu.common.suuri.srcommon.SrSuuriKbnHenkanSet;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SrKbnHenkanKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 案内収納共通 前納計算通貨チェック
 */
public class ChkZennouKeisanTuuka {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public C_ErrorKbn exec(String pSyono, String pZnngaikakbn) {

        logger.debug("▽ 前納計算通貨チェック 開始");

        C_Tuukasyu zennoucalctuuka = C_Tuukasyu.BLNK;
        C_Tuukasyu kykTuukasyu = C_Tuukasyu.BLNK;
        C_YennykntksyuruiKbn yennyknsyuruikbn = C_YennykntksyuruiKbn.BLNK;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        kykTuukasyu = kykSyouhnLst.get(0).getKyktuukasyu();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        yennyknsyuruikbn = kykSonotaTkyk.getYennyknsyuruikbn();

        if (C_YennykntksyuruiKbn.PYENHRKM_GKSITEI.eq(yennyknsyuruikbn)) {
            zennoucalctuuka = C_Tuukasyu.JPY;
        }
        else {
            zennoucalctuuka = kykTuukasyu;
        }

        SrSuuriKbnHenkanSet srSuuriKbnHenkanSet = SWAKInjector.getInstance(SrSuuriKbnHenkanSet.class);

        SrSuuriKbnHenkanBean srSuuriKbnHenkanBean = srSuuriKbnHenkanSet.exec(C_SrKbnHenkanKbn.SUURI_KEIYAKUDATE_TUUKA,
            zennoucalctuuka.getValue());

        if (C_ErrorKbn.ERROR.eq(srSuuriKbnHenkanBean.getKekkaKbn())) {
            logger.debug("△ 前納計算通貨チェック 終了");
            return C_ErrorKbn.ERROR;
        }
        if (!srSuuriKbnHenkanBean.getHenkanAtoKbn().equals(pZnngaikakbn)) {
            logger.debug("△ 前納計算通貨チェック 終了");
            return C_ErrorKbn.ERROR;
        }
        logger.debug("△ 前納計算通貨チェック 終了");
        return C_ErrorKbn.OK;
    }
}
