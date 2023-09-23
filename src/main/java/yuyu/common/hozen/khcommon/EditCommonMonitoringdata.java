package yuyu.common.hozen.khcommon;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.interf.ConvBossRnkKoumoku;
import yuyu.common.biz.interf.ConvBossRnkKoumokuBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 共通 契約保全モニタリングデータ共通項目編集
 */
public class EditCommonMonitoringdata {

    @Inject
    private static Logger logger;

    public EditCommonMonitoringdata() {
        super();
    }

    public EditCommonMonitoringdataBean exec(IT_KykKihon pKykKihon, BizDateYM pTaiSyoukknto) {

        EditCommonMonitoringdataBean editCommonMonitoringdataBean;

        C_KzkykdouKbn kzkykdoukbn = C_KzkykdouKbn.BLNK;

        BizDate lastkykmeighnkymd = BizDate.valueOf(00000000);

        C_UmuKbn tetudutyuui74hyouji = C_UmuKbn.NONE;

        logger.debug("▽ 契約保全モニタリングデータ共通項目編集 開始");

        if (pKykKihon == null) {
            throw new BizAppException(MessageId.EBS1003, "契約基本テーブル", "null");
        }

        IT_KykSya kykSya = pKykKihon.getKykSya();

        IT_KykDairiten kykDairiten = pKykKihon.getKykDairitens().get(0);

        IT_KhTtdkTyuui khTtdkTyuui = pKykKihon.getKhTtdkTyuui();

        List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();

        editCommonMonitoringdataBean = SWAKInjector.getInstance(EditCommonMonitoringdataBean.class);

        if (C_Hrkkeiro.KOUHURI.eq(pKykKihon.getHrkkeiro())) {
            kzkykdoukbn = pKykKihon.getKouza().getKzkykdoukbn();
        }

        if (pTaiSyoukknto == null) {
            if (pKykKihon.getLastkykmeighnkymd() != null) {
                lastkykmeighnkymd = pKykKihon.getLastkykmeighnkymd();
            }
        }
        else {
            if (pKykKihon.getLastkykmeighnkymd() != null) {
                if ((BizDateUtil.compareYm(pKykKihon.getLastkykmeighnkymd().getBizDateYM(),
                    pTaiSyoukknto.addYears(-1)) == BizDateUtil.COMPARE_GREATER  ||
                    BizDateUtil.compareYm(pKykKihon.getLastkykmeighnkymd().getBizDateYM(),
                        pTaiSyoukknto.addYears(-1)) == BizDateUtil.COMPARE_EQUAL) &&
                        (BizDateUtil.compareYm(pKykKihon.getLastkykmeighnkymd().getBizDateYM(),
                            pTaiSyoukknto) == BizDateUtil.COMPARE_LESSER  ||
                            BizDateUtil.compareYm(pKykKihon.getLastkykmeighnkymd().getBizDateYM(),
                                pTaiSyoukknto) == BizDateUtil.COMPARE_EQUAL)) {
                    lastkykmeighnkymd = pKykKihon.getLastkykmeighnkymd();
                }
            }
        }

        BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);

        KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(
            pKykKihon.getHrkkeiro().getValue(),
            C_Hrkkeiro.class,
            C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        String hrkkeirokbn = kbnInfoBean.getKbnData();

        ConvBossRnkKoumoku convBossRnkKoumoku = SWAKInjector.getInstance(ConvBossRnkKoumoku.class);

        ConvBossRnkKoumokuBean convBossRnkKoumokuBean = convBossRnkKoumoku.execAll(syouhnZokusei, pKykKihon.getHrkkeiro(),kykSyouhn.getKyktuukasyu());

        SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);

        C_ErrorKbn tyotkhknhyjsetkbn = setTyotikuseihokenhyouji.exec(pKykKihon);
        C_UmuKbn houteityotkhknhyj = setTyotikuseihokenhyouji.getHouteityotkhknhyj();
        C_UmuKbn tyotkhknhyj = setTyotikuseihokenhyouji.getTyotkhknhyj();


        String highcverrorkbn = "";

        if (C_ErrorKbn.ERROR.eq(tyotkhknhyjsetkbn)) {
            highcverrorkbn = "99";
        }
        else {
            highcverrorkbn = "0";
        }

        if ((C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU.eq(khTtdkTyuui.getTtdktyuuikbn1()) ||
            C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU.eq(khTtdkTyuui.getTtdktyuuikbn2()) ||
            C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU.eq(khTtdkTyuui.getTtdktyuuikbn3()) ||
            C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU.eq(khTtdkTyuui.getTtdktyuuikbn4()) ||
            C_TtdktyuuiKbn.TORIHIKIJIKAKUNINRYUUIJIKOU.eq(khTtdkTyuui.getTtdktyuuikbn5())) &&
            (C_UmuKbn.ARI.eq(houteityotkhknhyj) || C_UmuKbn.ARI.eq(tyotkhknhyj))) {
            tetudutyuui74hyouji = C_UmuKbn.ARI;
        }

        editCommonMonitoringdataBean.setSyono(pKykKihon.getSyono());
        editCommonMonitoringdataBean.setOkyksmno("0000000000");
        editCommonMonitoringdataBean.setKyknmkn(ConvertUtil.convZenHan(IDataConvert.iCONVERT_Z2H_ALL, kykSya.getKyknmkn()));
        editCommonMonitoringdataBean.setKyknmkj(kykSya.getKyknmkj());
        editCommonMonitoringdataBean.setSeiymd(kykSya.getKykseiymd());
        editCommonMonitoringdataBean.setKihontikucd(kykSya.getTsinyno());
        editCommonMonitoringdataBean.setKykymd(kykSyouhn.getKykymd());
        editCommonMonitoringdataBean.setZougakukeii(BizDate.valueOf(00000000));
        editCommonMonitoringdataBean.setZougakukingaku(BizCurrency.valueOf(0));
        editCommonMonitoringdataBean.setMeighnkkeii(lastkykmeighnkymd);
        editCommonMonitoringdataBean.setHrkkeirokbn(hrkkeirokbn);
        editCommonMonitoringdataBean.setSyuunoukeirokbn(convBossRnkKoumokuBean.getSyuunouKeiroKbn());
        editCommonMonitoringdataBean.setKzkykdoukbn(kzkykdoukbn);
        editCommonMonitoringdataBean.setAtukaisisyacd("000");
        editCommonMonitoringdataBean.setAtukaisibucd("0000");
        editCommonMonitoringdataBean.setAtukaikojincd(kykDairiten.getBosyuucd());
        editCommonMonitoringdataBean.setMrkykhyj(C_UmuKbn.NONE);
        editCommonMonitoringdataBean.setNaibukykhyj(C_UmuKbn.NONE);
        editCommonMonitoringdataBean.setJikokykhyj(C_UmuKbn.NONE);
        editCommonMonitoringdataBean.setHjnkykhyj(C_UmuKbn.NONE);
        editCommonMonitoringdataBean.setSyouhnbunruikbn(convBossRnkKoumokuBean.getSyouhinBunruiKbn());
        editCommonMonitoringdataBean.setSyouhnnmkbn(convBossRnkKoumokuBean.getSyouhnNmKbn());
        editCommonMonitoringdataBean.setHouteityotkhknhyj(houteityotkhknhyj);
        editCommonMonitoringdataBean.setTyotkhknhyj(tyotkhknhyj);
        editCommonMonitoringdataBean.setHighcverrorkbn(highcverrorkbn);
        editCommonMonitoringdataBean.setHighriskflg(tetudutyuui74hyouji);

        logger.debug("△ 契約保全モニタリングデータ共通項目編集 終了");

        return editCommonMonitoringdataBean;
    }
}
