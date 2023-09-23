package yuyu.common.siharai.edittbl;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.suuri.srcommon.EditDshrTukiTanKoumokuBean;
import yuyu.common.suuri.srcommon.SrDshrTukiDataSks;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.db.entity.JT_SiDshrTuki;

/**
 * 保険金給付金支払 保険金給付金支払共通 保険金給付金Ｄ支払統計TBL編集
 */
public class EditSiDshrTukiTbl {

    @Inject
    private static Logger logger;

    private static final Integer RENNO = Integer.valueOf("1");

    public EditSiDshrTukiTbl() {
        super();
    }

    public JT_SiDshrTuki exec(EditSiDshrTukiTblBean pEditSiDshrTukiTblBean) {
        logger.debug("▽ 保険金給付金Ｄ支払統計TBL編集 開始");

        if (pEditSiDshrTukiTblBean.getEditDshrTukiDKoumokuBean() == null) {
            logger.debug("△ 保険金給付金Ｄ支払統計TBL編集 終了");
            return null;
        }

        EditDshrTukiTanKoumokuBean editDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        editDshrTukiTanKoumokuBean.setRenno(RENNO);
        editDshrTukiTanKoumokuBean.setSkno(pEditSiDshrTukiTblBean.getSkno());
        editDshrTukiTanKoumokuBean.setSyono(pEditSiDshrTukiTblBean.getSiKykKihon().getSyono());
        editDshrTukiTanKoumokuBean.setSeikyuurirekiNo(pEditSiDshrTukiTblBean.getSeikyuurirekino());
        editDshrTukiTanKoumokuBean.setHenkousikibetuKey(null);
        editDshrTukiTanKoumokuBean.setSyoriYmd(pEditSiDshrTukiTblBean.getSyoriYmd());
        editDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        editDshrTukiTanKoumokuBean.setHrkkeiro(pEditSiDshrTukiTblBean.getSiKykKihon().getHrkkeiro());
        editDshrTukiTanKoumokuBean.setSyouhnCd(pEditSiDshrTukiTblBean.getSiKykSyouhn().getSyouhncd());
        editDshrTukiTanKoumokuBean.setSyouhnsdNo(pEditSiDshrTukiTblBean.getSiKykSyouhn().getSyouhnsdno());
        editDshrTukiTanKoumokuBean.setKykjyoutai(pEditSiDshrTukiTblBean.getSiKykKihon().getKykjyoutai());
        editDshrTukiTanKoumokuBean.setSyoumetujiyuu(null);
        editDshrTukiTanKoumokuBean.setKykymd(pEditSiDshrTukiTblBean.getSiKykSyouhn().getKykymd());
        editDshrTukiTanKoumokuBean.setYendthnkYmd(pEditSiDshrTukiTblBean.getSiKykSyouhn().getYendthnkymd());
        editDshrTukiTanKoumokuBean.setKihons(pEditSiDshrTukiTblBean.getSiKykSyouhn().getKihons());
        editDshrTukiTanKoumokuBean.setYoteiriritu(pEditSiDshrTukiTblBean.getSiKykSyouhn().getYoteiriritu());
        editDshrTukiTanKoumokuBean.setDenymd(pEditSiDshrTukiTblBean.getDenymd());
        editDshrTukiTanKoumokuBean.setSiharaid(pEditSiDshrTukiTblBean.getSiharaid());
        editDshrTukiTanKoumokuBean.setKhHaitouKanri(null);
        editDshrTukiTanKoumokuBean.setKhTumitateDKanri(null);
        editDshrTukiTanKoumokuBean.setGyoumuKousinsyaId(pEditSiDshrTukiTblBean.getGyoumuKousinsyaId());
        editDshrTukiTanKoumokuBean.setGyoumuKousinKinou(pEditSiDshrTukiTblBean.getGyoumuKousinKinou());

        SrDshrTukiDataSks srDshrTukiDataSks = SWAKInjector.getInstance(SrDshrTukiDataSks.class);
        JT_SiDshrTuki siDshrTuki = srDshrTukiDataSks.execSi(editDshrTukiTanKoumokuBean,
            pEditSiDshrTukiTblBean.getEditDshrTukiDKoumokuBean());

        logger.debug("△ 保険金給付金Ｄ支払統計TBL編集 終了");
        return siDshrTuki;
    }
}
