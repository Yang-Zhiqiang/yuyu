package yuyu.common.hozen.khcommon;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.slf4j.Logger;

import yuyu.common.suuri.srcommon.EditDshrTukiTanKoumokuBean;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 契約保全共通 契約保全Ｄ支払統計契約情報設定
 */
public class SetKhDshrTukiKykInfo {

    @Inject
    private static Logger logger;

    public SetKhDshrTukiKykInfo() {
        super();
    }

    public EditDshrTukiTanKoumokuBean exec(IT_KykKihon pKykKihon, KhozenCommonParam pKhozenCommonParam, BizDate pDenYmd,
        BizDate pSyoriYmd) {

        logger.debug("▽ 契約保全Ｄ支払統計契約情報設定 開始");

        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = SWAKInjector.getInstance(
            EditDshrTukiTanKoumokuBean.class);

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (kykSyouhnLst.size() > 0) {

            editDshrTukiTanKoumokuBean.setRenno(1);
            editDshrTukiTanKoumokuBean.setSkno("");
            editDshrTukiTanKoumokuBean.setSyono(pKykKihon.getSyono());
            editDshrTukiTanKoumokuBean.setSeikyuurirekiNo(0);
            editDshrTukiTanKoumokuBean.setHenkousikibetuKey("");
            editDshrTukiTanKoumokuBean.setSyoriYmd(pSyoriYmd);
            editDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
            editDshrTukiTanKoumokuBean.setHrkkeiro(pKykKihon.getHrkkeiro());
            editDshrTukiTanKoumokuBean.setSyouhnCd(kykSyouhnLst.get(0).getSyouhncd());
            editDshrTukiTanKoumokuBean.setSyouhnsdNo(kykSyouhnLst.get(0).getSyouhnsdno());
            editDshrTukiTanKoumokuBean.setKykjyoutai(kykSyouhnLst.get(0).getKykjyoutai());
            editDshrTukiTanKoumokuBean.setSyoumetujiyuu(kykSyouhnLst.get(0).getSyoumetujiyuu());
            editDshrTukiTanKoumokuBean.setKykymd(kykSyouhnLst.get(0).getKykymd());
            editDshrTukiTanKoumokuBean.setYendthnkYmd(kykSyouhnLst.get(0).getYendthnkymd());
            editDshrTukiTanKoumokuBean.setKihons(kykSyouhnLst.get(0).getKihons());
            editDshrTukiTanKoumokuBean.setYoteiriritu(kykSyouhnLst.get(0).getYoteiriritu());
            editDshrTukiTanKoumokuBean.setDenymd(pDenYmd);
            editDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
            editDshrTukiTanKoumokuBean.setKhHaitouKanri(null);
            editDshrTukiTanKoumokuBean.setKhTumitateDKanri(null);
            editDshrTukiTanKoumokuBean.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());
            editDshrTukiTanKoumokuBean.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

        }

        logger.debug("△ 契約保全Ｄ支払統計契約情報設定 終了");

        return editDshrTukiTanKoumokuBean;
    }
}
