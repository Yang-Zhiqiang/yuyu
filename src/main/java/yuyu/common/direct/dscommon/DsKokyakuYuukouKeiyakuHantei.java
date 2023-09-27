package yuyu.common.direct.dscommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.direct.dscommon.dba4dskokyakuyuukoukeiyakuhantei.DsKokyakuKeiyakuInfoBean;
import yuyu.common.direct.dscommon.dba4dskokyakuyuukoukeiyakuhantei.DsKokyakuYuukouKeiyakuHanteiDao;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.def.classification.C_UmuKbn;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ顧客有効契約判定
 */
public class DsKokyakuYuukouKeiyakuHantei {

    @Inject
    private static Logger logger;

    @Inject
    private DsKokyakuYuukouKeiyakuHanteiDao dsKokyakuYuukouKeiyakuHanteiDao;

    public DsKokyakuYuukouKeiyakuHantei(){
        super();
    }

    public DsKokyakuYuukouKeiyakuHanteiBean exec(String pDsKokNo) {

        logger.debug("▽ ＤＳ顧客有効契約判定 開始");

        DsKokyakuYuukouKeiyakuHanteiBean dsKokyakuYuukouKeiyakuHanteiBean = SWAKInjector.getInstance(DsKokyakuYuukouKeiyakuHanteiBean.class);

        C_UmuKbn yuukouKeiyakuUmuKbn = C_UmuKbn.NONE;

        List<DsKokyakuKeiyakuInfoBean> dsKokyakuKeiyakuInfoBeanList = null;

        String syoNo = null;

        Long kykSyouhnCount = null;

        Long sibouKariuketsukeCount = null;

        CheckDsKaiyaku checkDsKaiyaku = SWAKInjector.getInstance(CheckDsKaiyaku.class);

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        C_UmuKbn checkDsKaiyakuResult = null;

        dsKokyakuKeiyakuInfoBeanList = dsKokyakuYuukouKeiyakuHanteiDao.getDsKokyakuKeiyakuInfoByDskokno(pDsKokNo);

        if (dsKokyakuKeiyakuInfoBeanList.size() == 0) {
            dsKokyakuYuukouKeiyakuHanteiBean.setYuukouKeiyakuUmuKbn(yuukouKeiyakuUmuKbn);

            logger.debug("△ ＤＳ顧客有効契約判定 終了");

            return dsKokyakuYuukouKeiyakuHanteiBean;
        }

        for (DsKokyakuKeiyakuInfoBean dsKokyakuKeiyakuInfoBean : dsKokyakuKeiyakuInfoBeanList) {

            syoNo = dsKokyakuKeiyakuInfoBean.getSyono();

            kykSyouhnCount = dsKokyakuYuukouKeiyakuHanteiDao.getKykSyouhnCountBySyono(syoNo);

            if (kykSyouhnCount == 0) {
                continue;
            }

            boolean yuuyokkngaiHanteiKekka = checkYuuyokkngai.exec(syoNo, BizDate.getSysDate());

            if (!yuuyokkngaiHanteiKekka) {
                continue;
            }

            sibouKariuketsukeCount = dsKokyakuYuukouKeiyakuHanteiDao.getSibouKariuketsukeCountBySyono(syoNo);

            if (sibouKariuketsukeCount > 0) {
                continue;
            }

            checkDsKaiyakuResult = checkDsKaiyaku.kaiyakuUkeUmuChk(syoNo);

            if (C_UmuKbn.ARI.eq(checkDsKaiyakuResult)) {
                continue;
            }

            yuukouKeiyakuUmuKbn = C_UmuKbn.ARI;

            break;
        }
        dsKokyakuYuukouKeiyakuHanteiBean.setYuukouKeiyakuUmuKbn(yuukouKeiyakuUmuKbn);

        logger.debug("△ ＤＳ顧客有効契約判定 終了");

        return dsKokyakuYuukouKeiyakuHanteiBean;
    }
}
