package yuyu.common.direct.dscommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ加入要件チェック
 */
public class DsKanyuuYoukenCheck {

    private static final int DS_KANYUU_NENKIJYUN = 18;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public DsKanyuuYoukenCheck() {
        super();
    }

    public DsKanyuuYoukenCheckBean exec(String pSyoNo) {
        logger.debug("▽ ＤＳ加入要件チェック 開始");

        C_ErrorKbn dsKanyuuYoukenCheckKbn = C_ErrorKbn.OK;
        C_UmuKbn kyksyaYisiNouryoukuNasiUmuKbn = C_UmuKbn.NONE;
        C_UmuKbn kyksyaYukueFumeiUmuKbn = C_UmuKbn.NONE;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        kykKihon = IT_KykKihonDetacher.detachKhTtdkTyuuitouched(kykKihon);
        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        if (khTtdkTyuui == null) {
            dsKanyuuYoukenCheckKbn = C_ErrorKbn.OK;
            kyksyaYisiNouryoukuNasiUmuKbn = C_UmuKbn.NONE;
            kyksyaYukueFumeiUmuKbn = C_UmuKbn.NONE;
        }
        else {
            List<C_TtdktyuuiKbn> ttdktyuuiKbnList = new ArrayList<>();
            ttdktyuuiKbnList.add(khTtdkTyuui.getTtdktyuuikbn1());
            ttdktyuuiKbnList.add(khTtdkTyuui.getTtdktyuuikbn2());
            ttdktyuuiKbnList.add(khTtdkTyuui.getTtdktyuuikbn3());
            ttdktyuuiKbnList.add(khTtdkTyuui.getTtdktyuuikbn4());
            ttdktyuuiKbnList.add(khTtdkTyuui.getTtdktyuuikbn5());

            if (ttdktyuuiKbnList.contains(C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI)) {
                dsKanyuuYoukenCheckKbn = C_ErrorKbn.ERROR;
                kyksyaYisiNouryoukuNasiUmuKbn = C_UmuKbn.ARI;
            }
            else {
                kyksyaYisiNouryoukuNasiUmuKbn = C_UmuKbn.NONE;
            }

            if (ttdktyuuiKbnList.contains(C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI)) {
                dsKanyuuYoukenCheckKbn = C_ErrorKbn.ERROR;
                kyksyaYukueFumeiUmuKbn = C_UmuKbn.ARI;
            }
            else {
                kyksyaYukueFumeiUmuKbn = C_UmuKbn.NONE;
            }
        }

        DsKanyuuYoukenCheckBean dsKanyuuYoukenCheckBean = SWAKInjector.getInstance(DsKanyuuYoukenCheckBean.class);
        dsKanyuuYoukenCheckBean.setDsKanyuuYoukenCheckKbn(dsKanyuuYoukenCheckKbn);
        dsKanyuuYoukenCheckBean.setKyksyaYisiNouryoukuNasiUmuKbn(kyksyaYisiNouryoukuNasiUmuKbn);
        dsKanyuuYoukenCheckBean.setKyksyaYukueFumeiUmuKbn(kyksyaYukueFumeiUmuKbn);

        logger.debug("△ ＤＳ加入要件チェック 終了");

        return dsKanyuuYoukenCheckBean;
    }

    public C_ErrorKbn checkDsKanyuuNenrei(BizDate pKykseiymd) {

        logger.debug("▽ ＤＳ加入年齢チェック 開始");

        C_ErrorKbn nenErrorkKbn = C_ErrorKbn.ERROR;
        int kyksyaNen = 0;

        if (pKykseiymd == null) {

            logger.debug("△ ＤＳ加入年齢チェック 終了");

            return nenErrorkKbn;

        }

        SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);

        kyksyaNen = setNenrei.exec(
            BizDate.getSysDate(),
            pKykseiymd
            );

        if (kyksyaNen >= DS_KANYUU_NENKIJYUN) {

            nenErrorkKbn = C_ErrorKbn.OK;

        }

        logger.debug("△ ＤＳ加入年齢チェック 終了");

        return nenErrorkKbn;
    }
}
