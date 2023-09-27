package yuyu.common.direct.dscommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.direct.manager.DirectDomManager;

/**
 * ダイレクト ダイレクト共通 ＤＳ名寄せ
 */
public class DsNayose {

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    public DsNayose() {
        super();
    }

    public DsNayoseBean exec(String pNmkn, String pNmkj, BizDate pSeiymd, String pPostalCd) {

        logger.debug("▽ ＤＳ名寄せ 開始");

        List<MT_DsKokyakuKanri> dsKokyakuKanri =
            directDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(pNmkn, pNmkj, pSeiymd, pPostalCd);

        DsNayoseBean dsNayoseBean = SWAKInjector.getInstance(DsNayoseBean.class);

        if (dsKokyakuKanri.size() == 0) {

            dsNayoseBean.setNayoseJissiKekkaKbn(C_NayoseJissiKekkaKbn.DOUITUNONE);
        }
        else {

            if (dsKokyakuKanri.size() == 1) {

                dsNayoseBean.setNayoseJissiKekkaKbn(C_NayoseJissiKekkaKbn.DOUITUARI);
                dsNayoseBean.setKokno(dsKokyakuKanri.get(0).getDskokno());
            }
            else {

                dsNayoseBean.setNayoseJissiKekkaKbn(C_NayoseJissiKekkaKbn.NAYOSEHUMEI);
            }
        }

        logger.debug("△ ＤＳ名寄せ 終了");

        return dsNayoseBean;
    }
}
