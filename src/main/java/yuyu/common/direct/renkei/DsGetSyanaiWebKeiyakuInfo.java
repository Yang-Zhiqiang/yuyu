package yuyu.common.direct.renkei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.string.ConvertUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.direct.dscommon.CheckKaiyakuUketuke;
import yuyu.common.direct.renkei.dba4dsgetsyanaiwebkeiyakuinfo.DsGetSyanaiWebKeiyakuInfoDao;
import yuyu.def.biz.bean.webservice.IwssnSyanaiDsInfoOutputBean;
import yuyu.def.classification.C_CheckKaiyakuUketukeKekkaKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通 社内Web用DS契約内容情報取得
 */
public class DsGetSyanaiWebKeiyakuInfo {

    private static final String SPACE_HANKAKU = " ";

    private static final String SPACE_ZENKAKU = "　";

    private static final String ZERO_DATE = "00000000";

    private IwssnSyanaiDsInfoOutputBean iwssnSyanaiDsInfoOutputBean;

    @Inject
    private DsGetSyanaiWebKeiyakuInfoDao dsGetSyanaiWebKeiyakuInfoDao;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public DsGetSyanaiWebKeiyakuInfo(){
        super();
    }

    public C_IwssnKykSyoukaiKekkaKbn exec(String pSyono) {

        logger.debug("▽ 社内Web用DS契約内容情報取得 開始");

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = C_IwssnKykSyoukaiKekkaKbn.NORMAL;

        iwssnSyanaiDsInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiDsInfoOutputBean.class);

        iwssnSyanaiDsInfoOutputBean.setIwssnDsokyksmno("0");
        iwssnSyanaiDsInfoOutputBean.setIwssnDsmailaddress(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDskokyakujtkbn(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDskokyakujtkbnnm(SPACE_ZENKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnKaripasswordhkymd("00000000");
        iwssnSyanaiDsInfoOutputBean.setIwssnKaripasswordykymd(ZERO_DATE);
        iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkkahikbn(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkahikbnnm(SPACE_ZENKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkhukariyuukbn(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkhukariyuukbnnm(SPACE_ZENKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDskouzano(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDskzmeigii(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDskinyunm(SPACE_ZENKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnSitennm(SPACE_ZENKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDsyokinkbnnm(SPACE_ZENKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDskzsyuruikbn(C_KouzasyuruiKbn.BLNK.getValue());
        iwssnSyanaiDsInfoOutputBean.setIwssnDskzsyuruikbnnm(C_KouzasyuruiKbn.BLNK.getContent());
        iwssnSyanaiDsInfoOutputBean.setIwssnDsbankcd(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDssitencd(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDsyokinkbn(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDskzdoukbn(SPACE_HANKAKU);
        iwssnSyanaiDsInfoOutputBean.setIwssnDskzdoukbnnm(SPACE_ZENKAKU);

        try {
            CheckKaiyakuUketuke checkKaiyakuUketuke = SWAKInjector.getInstance(CheckKaiyakuUketuke.class);

            C_ErrorKbn errorKbn = checkKaiyakuUketuke.kaiyakusyokaiChk(pSyono);
            C_CheckKaiyakuUketukeKekkaKbn checkKaiyakuUketukeKekkaKbn = checkKaiyakuUketuke
                .getCheckKaiyakuUketukeKekkaKbn();

            if (C_ErrorKbn.OK.eq(errorKbn)) {

                iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkkahikbn(C_KahiKbn.KA.getValue());
                iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkahikbnnm(C_KahiKbn.KA.getContent());
            }
            else {

                iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkkahikbn(C_KahiKbn.HUKA.getValue());
                iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkahikbnnm(C_KahiKbn.HUKA.getContent());
                iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkhukariyuukbn(checkKaiyakuUketukeKekkaKbn.getValue());
                iwssnSyanaiDsInfoOutputBean.setIwssnTelttdkhukariyuukbnnm(checkKaiyakuUketukeKekkaKbn.getContent());
            }

            MT_DsKokyakuKanri dsKokyakuKanri = dsGetSyanaiWebKeiyakuInfoDao.getYuukouKeiyakuDskokyakuInfoBySyono(pSyono);

            if (dsKokyakuKanri == null
                || (!C_DsKokyakuJtKbn.YUUKOU.eq(dsKokyakuKanri.getDskokyakujtkbn())
                    && !C_DsKokyakuJtKbn.ITIJI_TEISI.eq(dsKokyakuKanri.getDskokyakujtkbn()))) {

                logger.debug("△ 社内Web用DS契約内容情報取得 終了");

                return iwssnKykSyoukaiKekkaKbn;
            }

            IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
            IT_KykSya kykSya = kykKihon.getKykSya();

            if (!kykSya.getKyknmkn().equals(dsKokyakuKanri.getDskokyakunmkn())
                || !kykSya.getKyknmkj().equals(dsKokyakuKanri.getDskokyakunmkj())
                || !kykSya.getKykseiymd().equals(dsKokyakuKanri.getDskokyakuseiymd())
                || !kykSya.getTsinyno().equals(dsKokyakuKanri.getDskokyakuyno())) {

                logger.debug("△ 社内Web用DS契約内容情報取得 終了");

                return iwssnKykSyoukaiKekkaKbn;
            }

            MT_DsMailAddress dsMailAddress = dsKokyakuKanri.getDsMailAddresss().get(0);
            MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.getDsHonninKakuninCd();

            iwssnSyanaiDsInfoOutputBean.setIwssnDsokyksmno(dsKokyakuKanri.getDskokno());
            iwssnSyanaiDsInfoOutputBean.setIwssnDskokyakujtkbn(dsKokyakuKanri.getDskokyakujtkbn().getValue());
            iwssnSyanaiDsInfoOutputBean.setIwssnDskokyakujtkbnnm(dsKokyakuKanri.getDskokyakujtkbn().getContent());

            if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(dsMailAddress.getDsmailsousinjyoutaikbn())) {

                iwssnSyanaiDsInfoOutputBean.setIwssnDsmailaddress(dsMailAddress.getDsmailaddress());
            }

            if (dsHonninKakuninCd.getDskrhnnkakcdsetymd() != null) {

                iwssnSyanaiDsInfoOutputBean.setIwssnKaripasswordhkymd(dsHonninKakuninCd.getDskrhnnkakcdsetymd().toString());
            }

            if (dsHonninKakuninCd.getDskrhnnkakcdyuukouymd() != null) {

                iwssnSyanaiDsInfoOutputBean.setIwssnKaripasswordykymd(dsHonninKakuninCd.getDskrhnnkakcdyuukouymd().toString());
            }

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku =dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(pSyono);
            MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

            if (dsTorihikiServiceKanri != null &&
                C_DsTrhkserviceRiyoujkKbn.RIYOU_KA.eq(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn())) {

                MT_DsSoukinyouKouza dsSoukinyouKouza =
                    dsGetSyanaiWebKeiyakuInfoDao.getDsSoukinyouKouzaByDskoknoSyonoKouzaSyuruiKbn(
                        dsKokyakuKanri.getDskokno(),
                        pSyono,
                        C_KouzasyuruiKbn.YENKOUZA);

                if (dsSoukinyouKouza != null) {

                    iwssnSyanaiDsInfoOutputBean.setIwssnDskouzano(dsSoukinyouKouza.getKouzano());
                    iwssnSyanaiDsInfoOutputBean.setIwssnDskzmeigii(ConvertUtil.toHanAll(dsSoukinyouKouza.getKzmeiginmkn(),0 ,1));
                    iwssnSyanaiDsInfoOutputBean.setIwssnDsyokinkbnnm(dsSoukinyouKouza.getYokinkbn().getContent());
                    iwssnSyanaiDsInfoOutputBean.setIwssnDskzsyuruikbn(dsSoukinyouKouza.getKzsyuruikbn().getValue());
                    iwssnSyanaiDsInfoOutputBean.setIwssnDskzsyuruikbnnm(dsSoukinyouKouza.getKzsyuruikbn().getContent());
                    iwssnSyanaiDsInfoOutputBean.setIwssnDsbankcd(dsSoukinyouKouza.getBankcd());
                    iwssnSyanaiDsInfoOutputBean.setIwssnDssitencd(dsSoukinyouKouza.getSitencd());
                    iwssnSyanaiDsInfoOutputBean.setIwssnDsyokinkbn(dsSoukinyouKouza.getYokinkbn().getValue());
                    iwssnSyanaiDsInfoOutputBean.setIwssnDskzdoukbn(dsSoukinyouKouza.getKzdoukbn().getValue());
                    iwssnSyanaiDsInfoOutputBean.setIwssnDskzdoukbnnm(dsSoukinyouKouza.getKzdoukbn().getContent());

                    BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);
                    BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(dsSoukinyouKouza.getBankcd(),
                        dsSoukinyouKouza.getSitencd());

                    if (!BizUtil.isBlank(bzGetBankDataBean.getBankNmKj())
                        && !BizUtil.isBlank(bzGetBankDataBean.getSitenNmKj())) {

                        iwssnSyanaiDsInfoOutputBean.setIwssnDskinyunm(bzGetBankDataBean.getBankNmKj());
                        iwssnSyanaiDsInfoOutputBean.setIwssnSitennm(bzGetBankDataBean.getSitenNmKj());
                    }
                }
            }
        } catch (Exception e) {
            iwssnKykSyoukaiKekkaKbn = C_IwssnKykSyoukaiKekkaKbn.EXCEPTION;

            logger.debug("△ 社内Web用DS契約内容情報取得 終了");
            return iwssnKykSyoukaiKekkaKbn;
        }

        logger.debug("△ 社内Web用DS契約内容情報取得 終了");

        return iwssnKykSyoukaiKekkaKbn;

    }

    public IwssnSyanaiDsInfoOutputBean getIwssnSyanaiDsInfoOutputBean() {
        return iwssnSyanaiDsInfoOutputBean;
    }

}
