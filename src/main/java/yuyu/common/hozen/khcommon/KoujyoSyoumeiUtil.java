package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.hozen.khcommon.dba4koujyosyoumeiutil.KoujyoSyoumeiUtilDao;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.infr.report.swakreport.ReportServicesBean;

/**
 * 契約保全 契約保全共通 控除証明ユーティリティ
 */
public class KoujyoSyoumeiUtil {

    private static final String KUGIRIMOJIRETU = "<br />";

    @Inject
    private KoujyoSyoumeiUtilDao koujyoSyoumeiUtilDao;

    @Inject
    private static Logger logger;

    public KoujyoSyoumeiUtil() {
        super();
    }

    public BizCurrency sumSyouhnp(List<KykSyouhnCommonParam> pKykSyouhnCommonParamLst) {
        logger.debug("▽ 商品保険料合計 開始");

        BizCurrency keip = BizCurrency.valueOf(0);
        for (KykSyouhnCommonParam kykSyouhnCommonParam : pKykSyouhnCommonParamLst) {
            keip = keip.add(kykSyouhnCommonParam.getHokenryou());
        }
        logger.debug("△ 商品保険料合計 終了");

        return keip;
    }

    public ReportServicesBean createKsnHkJmrnTyhyBean(KhozenCommonParam pKhozenCommonParam, String pSyono,
        String pSyoumeinnd, String keisanHukariyuuMsg, BizDate pSyoriYmd) {
        logger.debug("▽ 計算不可時事務連絡票Bean作成 開始");

        String msg = MessageUtil.getMessage(MessageId.EIF1104, pSyono, pSyoumeinnd, keisanHukariyuuMsg);
        List<String> jimuRenrakuMsgList = new ArrayList<>();
        jimuRenrakuMsgList.addAll(Arrays.asList(msg.split(KUGIRIMOJIRETU)));
        EditJimuRenrakusyuunouParam editJimuRenrakusyuunouParam = SWAKInjector.getInstance(EditJimuRenrakusyuunouParam.class);
        editJimuRenrakusyuunouParam.setJimurenrakuMsgList(jimuRenrakuMsgList);
        EditJimuRenrakusyuunou editJimuRenrakusyuunou = SWAKInjector.getInstance(EditJimuRenrakusyuunou.class);
        ReportServicesBean reportServicesBean = editJimuRenrakusyuunou.exec(pKhozenCommonParam,
            pSyono, C_SyoruiCdKbn.AS_JIMURENRAKU_SYUUNOU, editJimuRenrakusyuunouParam, pSyoriYmd);

        logger.debug("△ 計算不可時事務連絡票Bean作成 終了");

        return reportServicesBean;
    }

    public String chkTkZennouStkkntySeisan(IT_KykKihon pKykKihon, BizDateYM pSyoumeistartYm, BizDateYM pSyoumeiendYm,
        Integer pKihrkpSeisanRenno, BizDateYM pKihrkpSeisanJytYm) {
        logger.debug("▽ 月払前納指定期間中精算チェック 開始");

        C_UmuKbn umuKbn = chkSymkkntySsnKjyUmu(pKykKihon, pSyoumeistartYm, pSyoumeiendYm);

        if (C_UmuKbn.ARI.eq(umuKbn)) {
            return KeisanKoujyogakuConstants.KEISANHUKARIYUUCD_TKBRIZENHUKUSUUKAISEISAN;
        }

        umuKbn = chkSsnkkntyMikeikapUmu(pKykKihon, pKihrkpSeisanRenno, pKihrkpSeisanJytYm);

        if (C_UmuKbn.ARI.eq(umuKbn)) {
            return KeisanKoujyogakuConstants.KEISANHUKARIYUUCD_TKBRIZENHUKUSUUKAISEISAN;
        }

        logger.debug("△ 月払前納指定期間中精算チェック 終了");

        return "";
    }

    public C_UmuKbn chkYenkanzanrateUmu(BizDate pYenkanzanrateYmd, C_Tuukasyu pTuukasyu) {

        logger.debug("▽ 円換算レート有無チェック 開始");

        C_UmuKbn umuKbn = C_UmuKbn.ARI;

        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

        C_ErrorKbn errorKbn = getKawaseRate.exec(
            pYenkanzanrateYmd,
            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
            pTuukasyu,
            C_Tuukasyu.JPY,
            C_KawasetekiyoKbn.TTM,
            C_KawasetsryKbn.NYUKINRATE,
            C_EigyoubiHoseiKbn.ZENEIGYOUBI,
            C_YouhiKbn.HUYOU);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            umuKbn = C_UmuKbn.NONE;
        }

        logger.debug("△ 円換算レート有無チェック 終了");

        return umuKbn;

    }

    private C_UmuKbn chkSymkkntySsnKjyUmu(IT_KykKihon pKykKihon, BizDateYM pSyoumeistartYm, BizDateYM pSyoumeiendYm) {
        C_UmuKbn umuKbn = C_UmuKbn.NONE;

        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouLst = koujyoSyoumeiUtilDao.getSymkkntySeisanKoujyoNaiyous(
            pKykKihon, pSyoumeistartYm, pSyoumeiendYm);

        if (koujyoSymNaiyouLst.size() > 0) {

            umuKbn = C_UmuKbn.ARI;
        }

        return umuKbn;
    }

    private C_UmuKbn chkSsnkkntyMikeikapUmu(IT_KykKihon pKykKihon, Integer pKihrkpSeisanRenno, BizDateYM pKihrkpSeisanJytYm) {

        C_UmuKbn umuKbn = C_UmuKbn.NONE;

        List<IT_KihrkmpSeisanRireki> kihrkmpSeisanRirekiLst = koujyoSyoumeiUtilDao.getSsnkkntyMikeikaps(
            pKykKihon, pKihrkpSeisanRenno, pKihrkpSeisanJytYm);

        if (kihrkmpSeisanRirekiLst.size() > 0) {

            umuKbn = C_UmuKbn.ARI;
        }

        return umuKbn;
    }
}