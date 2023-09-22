package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.sinkeiyaku.skcommon.EditPdfKykKakuninIraisyo;
import yuyu.def.classification.C_KykkakiraisyoyhKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.sorter.SortHT_KykKak;

/**
 * 新契約 申込内容チェック 帳票ファイル編集
 */
public class EditPrintFile {

    @Inject
    private EditPdfKykKakuninIraisyo editPdfKykKakuninIraisyo;

    @Inject
    private static Logger logger;

    public EditPrintFile() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {
        HT_SyoriCTL syoriCTL = null;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 帳票ファイル編集 開始");
        }

        syoriCTL = pMP.getDataSyoriControl();

        C_KykkakiraisyoyhKbn kykkakiraisyoyhKbn;
        kykkakiraisyoyhKbn = pMP.getKykKakuninIraisyoYouhiKbn();
        if (kykkakiraisyoyhKbn.eq(C_KykkakiraisyoyhKbn.YOU)) {
            Integer kykKakMaxRennobySyono = null;

            List<HT_KykKak> kykKakLst = syoriCTL.getKykKaks();
            if (kykKakLst.size() > 0) {
                kykKakLst = new SortHT_KykKak().OrderHT_KykKakByPkDesc(kykKakLst);
                kykKakMaxRennobySyono = kykKakLst.get(0).getRenno();
            }

            int kykKakRennoMax = 1;

            if (kykKakMaxRennobySyono != null) {
                kykKakRennoMax = kykKakMaxRennobySyono + 1;
            }

            HT_SyoriCTL syoriCTLIns = syoriCTL;
            HT_KykKak kykKakIns = syoriCTLIns.createKykKak();
            kykKakIns.setRenno(kykKakRennoMax);
            kykKakIns.setKykkaksyrui(C_Kykkaksyrui.KETMAE);
            kykKakIns.setKykkakiraiymd(pMP.getSysDate());
            kykKakIns.setGyoumuKousinsyaId(pMP.getKosID());
            kykKakIns.setGyoumuKousinTime(pMP.getKosTime());

            BizPropertyInitializer.initialize(kykKakIns);

            editPdfKykKakuninIraisyo.exec(pMP, kykKakIns);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 帳票ファイル編集 終了");
        }
    }
}