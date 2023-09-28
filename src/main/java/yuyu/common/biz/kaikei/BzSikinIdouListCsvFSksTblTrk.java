package yuyu.common.biz.kaikei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.kaikei.dba4bzsikinidoulistcsvfskstbltrk.BzSikinIdouListCsvFSksTblTrkDao;
import yuyu.def.biz.bean.report.BzSikinIdouListHijynbrNykDataSourceBean;
import yuyu.def.biz.bean.report.BzSikinIdouListHtkinDataSourceBean;
import yuyu.def.biz.bean.report.BzSikinIdouListSokujibunDataSourceBean;
import yuyu.def.biz.bean.report.BzSikinIdouListTyakkinbibunDataSourceBean;
import yuyu.def.biz.bean.report.BzSikinIdouListYendthnkbunDataSourceBean;
import yuyu.def.classification.C_SikinidoulistKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_SikinIdouListCsvFSks;
import yuyu.def.sinkeiyaku.bean.report.SkSikinIdouListHrkmKouzaHuittibunDataSourceBean;
import yuyu.infr.report.swakreport.IReportDataSouceBean;

/**
 * 業務共通 経理・会計 資金移動リストＣＳＶファイル作成用テーブル登録
 */
public class BzSikinIdouListCsvFSksTblTrk {

    private static final String YENDTHNKTORIKESINM = "円建変更取消分";

    private static final String NYKTRKSNM = "入金取消分";

    private int syoriKensuu;

    @Inject
    private static Logger logger;

    @Inject
    private BzSikinIdouListCsvFSksTblTrkDao dao;

    public BzSikinIdouListCsvFSksTblTrk() {
        super();
    }

    public void exec(BizDate pSyoriYmd, List<IReportDataSouceBean> pReportDsBeanLst) {

        logger.debug("▽ 資金移動リストＣＳＶファイル作成用テーブル登録 開始");

        BizDate syoriYmd = pSyoriYmd;
        C_SikinidoulistKbn[] sikinidoulistKbns = null;
        BizDate sikinidouYmd = pSyoriYmd.addBusinessDays(1);
        syoriKensuu = 0;

        sikinidoulistKbns = getSikinidoulistKbn(pReportDsBeanLst.get(0));

        dao.delBzSikinIdouCsvFileSksTbl(syoriYmd, sikinidoulistKbns);

        try (
            EntityInserter<BT_SikinIdouListCsvFSks> sikinIdouListCsvFSksInserter = new EntityInserter<>();) {

            for (IReportDataSouceBean reportDsBean : pReportDsBeanLst) {

                BT_SikinIdouListCsvFSks sikinIdouListCsvFSks =
                    getSikinIdouListCsvFSks(pSyoriYmd, sikinidoulistKbns[0], sikinidouYmd, reportDsBean);

                if (sikinIdouListCsvFSks != null) {
                    sikinIdouListCsvFSksInserter.add(sikinIdouListCsvFSks);
                }
            }
        }

        logger.debug("△ 資金移動リストＣＳＶファイル作成用テーブル登録 終了");
    }

    private C_SikinidoulistKbn[] getSikinidoulistKbn(IReportDataSouceBean pReportDsBean) {

        C_SikinidoulistKbn[] sikinidoulistKbns = null;

        if (pReportDsBean instanceof BzSikinIdouListSokujibunDataSourceBean) {

            sikinidoulistKbns = new C_SikinidoulistKbn[1];
            sikinidoulistKbns[0] = C_SikinidoulistKbn.SOKUJI;
        }
        else if (pReportDsBean instanceof BzSikinIdouListTyakkinbibunDataSourceBean) {

            sikinidoulistKbns = new C_SikinidoulistKbn[1];
            sikinidoulistKbns[0] = C_SikinidoulistKbn.TYAKKINYMD;
        }
        else if (pReportDsBean instanceof BzSikinIdouListYendthnkbunDataSourceBean) {

            sikinidoulistKbns = new C_SikinidoulistKbn[2];

            sikinidoulistKbns[0] = C_SikinidoulistKbn.YENDTHNK;
            sikinidoulistKbns[1] = C_SikinidoulistKbn.YENDTHNKTRK;
        }
        else if (pReportDsBean instanceof BzSikinIdouListHijynbrNykDataSourceBean) {

            sikinidoulistKbns = new C_SikinidoulistKbn[2];

            sikinidoulistKbns[0] = C_SikinidoulistKbn.HIJYNBRNYK;
            sikinidoulistKbns[1] = C_SikinidoulistKbn.HIJYNBRNYKTRK;
        }
        else if (pReportDsBean instanceof BzSikinIdouListHtkinDataSourceBean) {

            sikinidoulistKbns = new C_SikinidoulistKbn[1];
            sikinidoulistKbns[0] = C_SikinidoulistKbn.HAITOUKIN;
        }
        else if (pReportDsBean instanceof SkSikinIdouListHrkmKouzaHuittibunDataSourceBean) {

            sikinidoulistKbns = new C_SikinidoulistKbn[1];
            sikinidoulistKbns[0] = C_SikinidoulistKbn.HRKKZHUITTI;
        }

        return sikinidoulistKbns;
    }

    private BT_SikinIdouListCsvFSks getSikinIdouListCsvFSks(BizDate pSyoriYmd,
        C_SikinidoulistKbn pSikinidoulistKbn, BizDate pSikinidouYmd, IReportDataSouceBean pIReportDsBean) {

        BT_SikinIdouListCsvFSks sikinIdouListCsvFSks = new BT_SikinIdouListCsvFSks();

        sikinIdouListCsvFSks.setSyoriYmd(pSyoriYmd);
        sikinIdouListCsvFSks.setSikinidoulistkbn(pSikinidoulistKbn);
        sikinIdouListCsvFSks.setSikinidouymd(pSikinidouYmd);
        sikinIdouListCsvFSks.setSyukkinkouzano("");
        sikinIdouListCsvFSks.setNyuukinkouzano("");

        if (C_SikinidoulistKbn.SOKUJI.eq(pSikinidoulistKbn)) {

            BzSikinIdouListSokujibunDataSourceBean dsBean = (BzSikinIdouListSokujibunDataSourceBean)pIReportDsBean;

            if (dsBean.getIrKeirisiteituukagkgaika() == null) {
                return null;
            }

            sikinIdouListCsvFSks.setSikinidoumeisaigk(dsBean.getIrKeirisiteituukagkgaika());
            sikinIdouListCsvFSks.setSyukkinkouzatuukasyu(dsBean.getIrKeirisiteituukasyu());
            sikinIdouListCsvFSks.setNyuukinkouzatuukasyu(C_Tuukasyu.JPY);
        }
        else if (C_SikinidoulistKbn.TYAKKINYMD.eq(pSikinidoulistKbn)) {

            BzSikinIdouListTyakkinbibunDataSourceBean dsBean = (BzSikinIdouListTyakkinbibunDataSourceBean)pIReportDsBean;

            sikinIdouListCsvFSks.setSikinidouymd(dsBean.getIrTyakkinymd8keta());
            sikinIdouListCsvFSks.setSikinidoumeisaigk(dsBean.getIrKeirisiteituukagkgaika());
            sikinIdouListCsvFSks.setSyukkinkouzatuukasyu(dsBean.getIrKeirisiteituukasyu());
            sikinIdouListCsvFSks.setNyuukinkouzatuukasyu(C_Tuukasyu.JPY);
        }
        else if (C_SikinidoulistKbn.YENDTHNK.eq(pSikinidoulistKbn)) {

            BzSikinIdouListYendthnkbunDataSourceBean dsBean = (BzSikinIdouListYendthnkbunDataSourceBean)pIReportDsBean;

            if (YENDTHNKTORIKESINM.equals(dsBean.getIrSikinidoukbnnm())) {

                sikinIdouListCsvFSks.setSikinidoulistkbn(C_SikinidoulistKbn.YENDTHNKTRK);
                sikinIdouListCsvFSks.setSikinidoumeisaigk(dsBean.getIrKeiritrhktuukagk());
                sikinIdouListCsvFSks.setSyukkinkouzatuukasyu(C_Tuukasyu.JPY);
                sikinIdouListCsvFSks.setNyuukinkouzatuukasyu(dsBean.getIrKeirisiteituukasyu());
            }
            else {

                sikinIdouListCsvFSks.setSikinidoumeisaigk(dsBean.getIrKeirisiteituukagkgaika());
                sikinIdouListCsvFSks.setSyukkinkouzatuukasyu(dsBean.getIrKeirisiteituukasyu());
                sikinIdouListCsvFSks.setNyuukinkouzatuukasyu(C_Tuukasyu.JPY);
            }
        }
        else if (C_SikinidoulistKbn.HIJYNBRNYK.eq(pSikinidoulistKbn)) {

            BzSikinIdouListHijynbrNykDataSourceBean dsBean = (BzSikinIdouListHijynbrNykDataSourceBean)pIReportDsBean;

            if (NYKTRKSNM.equals(dsBean.getIrSikinidoukbnnm())) {

                sikinIdouListCsvFSks.setSikinidoulistkbn(C_SikinidoulistKbn.HIJYNBRNYKTRK);
                sikinIdouListCsvFSks.setSikinidoumeisaigk(dsBean.getIrKeirisiteituukagkgaika());
                sikinIdouListCsvFSks.setSyukkinkouzatuukasyu(dsBean.getIrKeirisiteituukasyu());
                sikinIdouListCsvFSks.setNyuukinkouzatuukasyu(C_Tuukasyu.JPY);
            }
            else {

                sikinIdouListCsvFSks.setSikinidoumeisaigk(dsBean.getIrKeiritrhktuukagk());
                sikinIdouListCsvFSks.setSyukkinkouzatuukasyu(C_Tuukasyu.JPY);
                sikinIdouListCsvFSks.setNyuukinkouzatuukasyu(dsBean.getIrKeirisiteituukasyu());
            }
        }
        else if (C_SikinidoulistKbn.HAITOUKIN.eq(pSikinidoulistKbn)) {

            BzSikinIdouListHtkinDataSourceBean dsBean = (BzSikinIdouListHtkinDataSourceBean)pIReportDsBean;

            sikinIdouListCsvFSks.setSikinidoumeisaigk(dsBean.getIrKeirisiteituukagkgaika());
            sikinIdouListCsvFSks.setSyukkinkouzatuukasyu(dsBean.getIrKeirisiteituukasyu());
            sikinIdouListCsvFSks.setNyuukinkouzatuukasyu(C_Tuukasyu.JPY);
        }
        else if (C_SikinidoulistKbn.HRKKZHUITTI.eq(pSikinidoulistKbn)) {

            SkSikinIdouListHrkmKouzaHuittibunDataSourceBean dsBean =
                (SkSikinIdouListHrkmKouzaHuittibunDataSourceBean)pIReportDsBean;

            sikinIdouListCsvFSks.setSikinidoumeisaigk(dsBean.getIrSikinidougaku());
            sikinIdouListCsvFSks.setSyukkinkouzatuukasyu(dsBean.getIrSikinidoumototuukasyu());
            sikinIdouListCsvFSks.setNyuukinkouzatuukasyu(dsBean.getIrSeitoukouzatuukasyu());
            sikinIdouListCsvFSks.setSyukkinkouzano(dsBean.getIrSikinidoumotokouzano());
            sikinIdouListCsvFSks.setNyuukinkouzano(dsBean.getIrSeitoukouzano());
        }

        syoriKensuu = syoriKensuu + 1;

        sikinIdouListCsvFSks.setRenno(syoriKensuu);

        BizPropertyInitializer.initialize(sikinIdouListCsvFSks);

        return sikinIdouListCsvFSks;
    }
}
