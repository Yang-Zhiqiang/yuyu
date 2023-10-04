package yuyu.batch.hozen.khinterf.khdairitenkykidoudtldbsks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.resource.ResourceUtil;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khdairitenkykidoudtldbsks.dba.KhDairitenKykIdouDtlDBSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DrtenChannelSyurui;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_Kouza;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.ZT_DrtenKykIdouDetailTy;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 代理店契約異動明細ＤＢ作成クラス</BR>
 */
public class KhDairitenKykIdouDtlDBSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private KhDairitenKykIdouDtlDBSksDao khDairitenKykIdouDtlDBSksDao;

    @Inject
    private BizDomManager bizDomManager;

    private static final String TYSYTTAISYOUTABLEID = "IT_KhTtdkRireki";

    private static final String RECOVERYFILTERID = "Kh001";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        BizDateYM syoriYm = syoriYmd.getBizDateYM();
        BizDateYM preSyoriYm = syoriYmd.addMonths(-1).getRekijyou().getBizDateYM();
        BizDate preSyoriYmOne = BizDate.valueOf(preSyoriYm, 1).getRekijyou();
        BizDate syoriYmOne = BizDate.valueOf(syoriYm, 1).getRekijyou();
        BizDate preSyoriYmEnd = syoriYmOne.addDays(-1).getRekijyou();
        String syono = "";
        String breakKeySyono = "";
        BizDate breakKeySyoriYmd = null;
        String breakKeyGyoumuKousinKinou = "";
        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        int kensuCount = 0;
        Map<String, Boolean> mapIdoukbn = new HashMap<>();

        try (EntityInserter<ZT_DrtenKykIdouDetailTy> entityInserter = new EntityInserter<>();
            ExDBResults<IT_KhTtdkRireki> exDBResults = khDairitenKykIdouDtlDBSksDao.
                getKhTtdkRirekisByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(
                    ibKakutyoujobCd, preSyoriYmOne, preSyoriYmEnd)) {

            for (IT_KhTtdkRireki itKhTtdkRireki : exDBResults) {

                ZT_DrtenKykIdouDetailTy ztDrtenKykIdouDetailTy = new ZT_DrtenKykIdouDetailTy();
                ZT_DrtenKykIdouDetailTy ztDrtenKykIdouDetailTy1 = new ZT_DrtenKykIdouDetailTy();

                BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean =
                    SWAKInjector.getInstance(BzRecoveryDatasikibetuBean.class);

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(itKhTtdkRireki.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(itKhTtdkRireki.getSyono());

                if (!breakKeySyono.equals(itKhTtdkRireki.getSyono())
                    || !itKhTtdkRireki.getSyoriYmd().equals(breakKeySyoriYmd)
                    || !breakKeyGyoumuKousinKinou.equals(itKhTtdkRireki.getGyoumuKousinKinou())) {

                    String gyoumuKousinKinou = itKhTtdkRireki.getGyoumuKousinKinou();
                    String idouKbn = "";

                    if (IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU.equals(gyoumuKousinKinou)) {

                        idouKbn = "44";

                    }
                    else if (IKhozenCommonConstants.KINOUID_MEIGIHENKOU.equals(gyoumuKousinKinou)) {

                        idouKbn = "13";

                    }
                    else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(gyoumuKousinKinou) ||
                        IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(gyoumuKousinKinou)) {

                        idouKbn = "03";

                    }
                    else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(gyoumuKousinKinou)) {

                        idouKbn = "19";

                    }
                    else if (IKhozenCommonConstants.KINOUID_SITEIDAIRITOKUYAKUHUKA.equals(gyoumuKousinKinou)) {

                        idouKbn = "18";

                    }
                    else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(gyoumuKousinKinou)) {

                        idouKbn = "46";

                    }
                    else if (IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(gyoumuKousinKinou)) {

                        idouKbn = "37";

                    }
                    else if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(gyoumuKousinKinou)) {

                        idouKbn = "53";

                    }
                    else if (IKhozenCommonConstants.KINOUID_SYOUKENSAIHAKKOU.equals(
                        gyoumuKousinKinou)) {

                        idouKbn = "14";

                    }
                    else if (IKhozenCommonConstants.KINOUID_KAIGOMAEBARAITKHENKOU.equals(
                        gyoumuKousinKinou)) {

                        idouKbn = "02";

                    }
                    else if (IKhozenCommonConstants.KINOUID_KHMKHGKHENKOU.equals(gyoumuKousinKinou) ||
                        IKhozenCommonConstants.KINOUID_KHBATCHMKHGKHENKOU.equals(gyoumuKousinKinou)) {

                        idouKbn = "R1";

                    }
                    else if (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(gyoumuKousinKinou)) {
                        if(C_SyoriKbn.ZEISEITEKIKAKUHUKA.eq(itKhTtdkRireki.getSyorikbn())
                            || C_SyoriKbn.ZEISEITEKIKAKUSYOUMETU.eq(itKhTtdkRireki.getSyorikbn())){

                            idouKbn = "02";
                        }
                        else if (C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI.equals(itKhTtdkRireki.getSyorikbn())) {

                            idouKbn = "66";
                        }
                        else if (C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.equals(itKhTtdkRireki.getSyorikbn())) {

                            idouKbn = "67";
                        }
                    }
                    else if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou)) {
                        if(C_SyoriKbn.YENDTHNK_MKHGKTTT.eq(itKhTtdkRireki.getSyorikbn())){

                            idouKbn = "63";
                        }
                        else if (C_SyoriKbn.YENDTHNK_NINISEIKYUU.equals(itKhTtdkRireki.getSyorikbn())) {

                            idouKbn = "65";
                        }
                    }
                    else if(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(gyoumuKousinKinou)
                        || IKhozenCommonConstants.KINOUID_YOYAKUIDOUKOUSIN.equals(gyoumuKousinKinou)){

                        idouKbn = "06";

                    }
                    else if(IKhozenCommonConstants.KINOUID_DATTAI.equals(gyoumuKousinKinou)
                        || IKhozenCommonConstants.KINOUID_ONLINEDATTAI.equals(gyoumuKousinKinou)){

                        idouKbn = "07";

                    }
                    else if(IKhozenCommonConstants.KINOUID_KZSEIBI.equals(gyoumuKousinKinou)){

                        idouKbn = "02";

                    }
                    else if(IKhozenCommonConstants.KINOUID_DSHR.equals(gyoumuKousinKinou)){

                        idouKbn = "05";

                    }
                    else if(IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(gyoumuKousinKinou)){
                        if(C_SyoriKbn.TMTTKNHANEI_ITEN.eq(itKhTtdkRireki.getSyorikbn())){

                            idouKbn = "16";
                        }
                    }
                    else if(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(gyoumuKousinKinou)){

                        idouKbn = "43";

                    }
                    else if(IKhozenCommonConstants.KINOUID_KHKZKTRKKYKDRTKYKHNK.equals(gyoumuKousinKinou)){

                        idouKbn = "02";

                    }

                    IT_KykKihon itKykKihon = new IT_KykKihon();
                    List<IT_KykSyouhn> itKykSyouhnList = new ArrayList<IT_KykSyouhn>();
                    String bosyuuCd = "";
                    BM_SyouhnZokusei bmSyouhnZokusei = new BM_SyouhnZokusei();
                    String kinyuuCd = "";
                    String kinyuuSitenCd = "";
                    String bsydrtenCd = "";
                    String kydatkiKbn = "";
                    String kykNm = "";
                    String hrkkaisuuKbn = "";
                    String hrkkeiroKbn = "";
                    String kzhurikaebankcd = "";
                    String kzhurikaesitencd = "";
                    String kzhurikaeyokinKbn = "";
                    String kzhurikaekouzano = "";
                    String iktbriKbn = "";
                    String iktbriKaisuu = "";
                    C_UmuKbn drtenBunumu = C_UmuKbn.NONE;
                    IT_KykDairiten itKykDairitenKydbosyuu = new IT_KykDairiten();

                    itKykKihon = hozenDomManager.getKykKihon(itKhTtdkRireki.getSyono());

                    itKykKihon = IT_KykKihonDetacher.detachKykSyouhnKykDairitenKykSyaKouzatouched(itKykKihon);

                    itKykSyouhnList = itKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

                    IT_KykDairiten itKykDairiten = itKykKihon.getKykDairitenByDrtenrenno(1);

                    IT_KykSya itKykSya = itKykKihon.getKykSya();

                    IT_Kouza itKouza = itKykKihon.getKouza();

                    syono = itKykKihon.getSyono();
                    drtenBunumu = itKykDairiten.getDrtenbunumu();
                    String drtenCd = itKykDairiten.getDrtencd();
                    bosyuuCd = itKykDairiten.getBosyuucd();

                    if (breakKeySyono.equals(syono) && itKhTtdkRireki.getSyoriYmd().equals(breakKeySyoriYmd)){
                        if (mapIdoukbn.containsKey(idouKbn)) {
                            continue;
                        }
                    }else {
                        mapIdoukbn.clear();
                    }

                    String syouhnCd = itKykSyouhnList.get(0).getSyouhncd();
                    Integer syouhnsdNo = itKykSyouhnList.get(0).getSyouhnsdno();

                    bmSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnsdNo);

                    if (bmSyouhnZokusei == null) {

                        throw new CommonBizAppException("商品属性マスタにデータが存在しません。" +
                            "商品コード：" + syouhnCd + "　商品世代番号：" + syouhnsdNo);

                    }
                    BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                    List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(drtenCd);

                    if (bzGetAgInfoBeanList.size() == 0) {

                        throw new CommonBizAppException("代理店情報取得（代理店コード指定）に失敗しました。" +
                            "代理店コード：" + drtenCd);

                    }

                    BzGetAgInfoBean shiteikoBzGetAgInfoBean = bzGetAgInfoBeanList.get(0);

                    if (C_UmuKbn.ARI.eq(drtenBunumu)) {

                        itKykDairitenKydbosyuu = itKykKihon.getKykDairitenByDrtenrenno(2);

                        if (itKykDairitenKydbosyuu == null) {

                            throw new CommonBizAppException("契約代理店TBLにデータが存在しません。" +
                                "証券番号：" + syono + "　代理店連番：2");

                        }

                    }

                    if ("03".equals(idouKbn)) {
                        if(!C_Syoumetujiyuu.KAIYAKU.eq(itKykSyouhnList.get(0).getSyoumetujiyuu())){
                            continue;
                        }
                    }

                    if (C_DrtenChannelSyurui.GINHONTAIMADO.eq(shiteikoBzGetAgInfoBean.getDrtenChannelSyurui())) {

                        kinyuuCd = shiteikoBzGetAgInfoBean.getKinyuuCd();
                        kinyuuSitenCd = shiteikoBzGetAgInfoBean.getKinyuuSitenCd();

                    }
                    else {

                        kinyuuCd = "0000";
                        kinyuuSitenCd = "";

                    }

                    if (BizUtil.isBlank(shiteikoBzGetAgInfoBean.getKeisyousakiDrtenCd())) {

                        bsydrtenCd = itKykDairiten.getDrtencd();

                    }
                    else {

                        bsydrtenCd = shiteikoBzGetAgInfoBean.getKeisyousakiDrtenCd();

                    }

                    if (C_UmuKbn.NONE.eq(drtenBunumu)) {

                        kydatkiKbn = "";

                    }
                    else if (itKykDairiten.getOyadrtencd().equals(itKykDairitenKydbosyuu.getOyadrtencd())) {

                        kydatkiKbn = "2";

                    }
                    else {

                        kydatkiKbn = "3";

                    }

                    if (BizUtil.isBlank(itKykSya.getKyknmkj())) {

                        kykNm = itKykSya.getKyknmkn();

                    }
                    else {

                        kykNm = itKykSya.getKyknmkj();

                    }

                    if(C_Kykjyoutai.ITIJIBARAI.eq(itKykSyouhnList.get(0).getKykjyoutai())){

                        hrkkaisuuKbn = "0";

                    } else {
                        if(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(itKykKihon.getTikiktbrisyuruikbn()) ||
                            C_Hrkkaisuu.HALFY.eq(itKykKihon.getHrkkaisuu())) {

                            hrkkaisuuKbn = "2";

                        } else if(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(itKykKihon.getTikiktbrisyuruikbn()) ||
                            C_Hrkkaisuu.NEN.eq(itKykKihon.getHrkkaisuu())) {

                            hrkkaisuuKbn = "1";

                        } else {

                            hrkkaisuuKbn = "3";

                        }
                    }

                    BzKbnHenkanUtil bzKbnHenkanUtil = new BzKbnHenkanUtil();
                    KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(String.valueOf(itKykKihon.getHrkkeiro()),C_Hrkkeiro.class,C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
                    if(kbnInfoBean.isHenkanFlg()){

                        hrkkeiroKbn = String.valueOf(kbnInfoBean.getKbnData());

                    } else {
                        throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1046 ,ResourceUtil.getApplicationResources().getString("hrkkeiro"),
                            itKykKihon.getHrkkeiro().getValue()));
                    }

                    if(C_Hrkkeiro.KOUHURI.eq(itKykKihon.getHrkkeiro())){

                        kzhurikaebankcd = itKouza.getBankcd();
                        kzhurikaesitencd = itKouza.getSitencd();
                        kzhurikaeyokinKbn = itKouza.getYokinkbn().getValue();
                        kzhurikaekouzano = itKouza.getKouzano();

                    } else {

                        kzhurikaebankcd = "0000";
                        kzhurikaesitencd = "000";
                        kzhurikaeyokinKbn = "0";
                        kzhurikaekouzano = "0000000";

                    }

                    if(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(itKykKihon.getTikiktbrisyuruikbn())){

                        iktbriKaisuu = "06";

                    } else if(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(itKykKihon.getTikiktbrisyuruikbn())){

                        iktbriKaisuu = "12";

                    } else {

                        iktbriKaisuu = "00";

                    }

                    if (!"00".equals(iktbriKaisuu)){

                        iktbriKbn = "2";

                    } else {

                        iktbriKbn = "0";

                    }

                    ztDrtenKykIdouDetailTy.setZtykinyuukikancd(kinyuuCd);
                    ztDrtenKykIdouDetailTy.setZtykinyuukikansitencd(kinyuuSitenCd);
                    ztDrtenKykIdouDetailTy.setZtybsydrtencd(bsydrtenCd);
                    ztDrtenKykIdouDetailTy.setZtycifcd(itKykKihon.getCifcd());
                    ztDrtenKykIdouDetailTy.setZtybosyuunincd(bosyuuCd);
                    ztDrtenKykIdouDetailTy.setZtysyono(syono);
                    ztDrtenKykIdouDetailTy.setZtyidouhasseiymd(itKhTtdkRireki.getSyoriYmd().toString());
                    ztDrtenKykIdouDetailTy.setZtykykmfksnctrlkh(0L);
                    ztDrtenKykIdouDetailTy.setZtysyoricd("");
                    ztDrtenKykIdouDetailTy.setZtyidoukbn(idouKbn);
                    ztDrtenKykIdouDetailTy.setZtybsyym(itKykKihon.getBosyuuym().toString());
                    ztDrtenKykIdouDetailTy.setZtykydatkikbn(kydatkiKbn);
                    ztDrtenKykIdouDetailTy.setZtykykymd(itKykSyouhnList.get(0).getKykymd().toString());
                    ztDrtenKykIdouDetailTy.setZtyjikaipjyuutouym("000000");
                    ztDrtenKykIdouDetailTy.setZtyhrkkaisuukbn(hrkkaisuuKbn);
                    ztDrtenKykIdouDetailTy.setZtyhrkkeirokbn(hrkkeiroKbn);
                    ztDrtenKykIdouDetailTy.setZtyanniskcd("00000000");
                    ztDrtenKykIdouDetailTy.setZtydntcd("00000000");
                    ztDrtenKykIdouDetailTy.setZtyharaikomip(0L);
                    ztDrtenKykIdouDetailTy.setZtykjsyagaihknnm(bmSyouhnZokusei.getSyouhnnmsyouken());
                    ztDrtenKykIdouDetailTy.setZtytelno("");
                    ztDrtenKykIdouDetailTy.setZtyhensyuubosyuudrtennm("");
                    ztDrtenKykIdouDetailTy.setZtykyknmkjdirtnkykido(kykNm);
                    ztDrtenKykIdouDetailTy.setZtykjdntnm("");
                    ztDrtenKykIdouDetailTy.setZtykzhurikaebankcd(kzhurikaebankcd);
                    ztDrtenKykIdouDetailTy.setZtykzhurikaesitencd(kzhurikaesitencd);
                    ztDrtenKykIdouDetailTy.setZtykzhurikaeyokinkbn(kzhurikaeyokinKbn);
                    ztDrtenKykIdouDetailTy.setZtykzhurikaekouzano(kzhurikaekouzano);
                    ztDrtenKykIdouDetailTy.setZtyoyabosyuudairitencd("");
                    ztDrtenKykIdouDetailTy.setZtybsydrtenkanrisosikicd("0000000");
                    ztDrtenKykIdouDetailTy.setZtybosyuudairitengyousyukbn("00");
                    ztDrtenKykIdouDetailTy.setZtybosyuudrtennmkj("");
                    ztDrtenKykIdouDetailTy.setZtydoujitusyoricount("");
                    ztDrtenKykIdouDetailTy.setZtyhjnkykhyj("");
                    ztDrtenKykIdouDetailTy.setZtyhjnnmkj("");
                    ztDrtenKykIdouDetailTy.setZtysyuhrkkaisuukbn("0");
                    ztDrtenKykIdouDetailTy.setZtyikkatubaraikbn(iktbriKbn);
                    ztDrtenKykIdouDetailTy.setZtyikkatubaraikaisuu(iktbriKaisuu);
                    ztDrtenKykIdouDetailTy.setZtyyobiv103("");

                    BizPropertyInitializer.initialize(ztDrtenKykIdouDetailTy);

                    entityInserter.add(ztDrtenKykIdouDetailTy);

                    kensuCount ++;

                    if (C_UmuKbn.ARI.eq(drtenBunumu)) {


                        List<BzGetAgInfoBean> bzGetAgInfoKydBosyuuBeanList = bzGetAgInfo.exec(
                            itKykDairitenKydbosyuu.getDrtencd());

                        BzGetAgInfoBean shiteikoBzGetAgInfoKydBosyuuBean = bzGetAgInfoKydBosyuuBeanList.get(0);

                        bosyuuCd = itKykDairitenKydbosyuu.getBosyuucd();

                        if (C_DrtenChannelSyurui.GINHONTAIMADO.eq(shiteikoBzGetAgInfoKydBosyuuBean.getDrtenChannelSyurui())) {

                            kinyuuCd = shiteikoBzGetAgInfoKydBosyuuBean.getKinyuuCd();
                            kinyuuSitenCd = shiteikoBzGetAgInfoKydBosyuuBean.getKinyuuSitenCd();

                        }
                        else {

                            kinyuuCd = "0000";
                            kinyuuSitenCd = "";

                        }

                        if (BizUtil.isBlank(shiteikoBzGetAgInfoKydBosyuuBean.getKeisyousakiDrtenCd())) {

                            bsydrtenCd = itKykDairitenKydbosyuu.getDrtencd();

                        }
                        else {

                            bsydrtenCd = shiteikoBzGetAgInfoKydBosyuuBean.getKeisyousakiDrtenCd();

                        }

                        ztDrtenKykIdouDetailTy1.setZtykinyuukikancd(kinyuuCd);
                        ztDrtenKykIdouDetailTy1.setZtykinyuukikansitencd(kinyuuSitenCd);
                        ztDrtenKykIdouDetailTy1.setZtybsydrtencd(bsydrtenCd);
                        ztDrtenKykIdouDetailTy1.setZtycifcd(itKykKihon.getCifcd());
                        ztDrtenKykIdouDetailTy1.setZtybosyuunincd(bosyuuCd);
                        ztDrtenKykIdouDetailTy1.setZtysyono(syono);
                        ztDrtenKykIdouDetailTy1.setZtyidouhasseiymd(itKhTtdkRireki.getSyoriYmd().toString());
                        ztDrtenKykIdouDetailTy1.setZtykykmfksnctrlkh(0L);
                        ztDrtenKykIdouDetailTy1.setZtysyoricd("");
                        ztDrtenKykIdouDetailTy1.setZtyidoukbn(idouKbn);
                        ztDrtenKykIdouDetailTy1.setZtybsyym(itKykKihon.getBosyuuym().toString());
                        ztDrtenKykIdouDetailTy1.setZtykydatkikbn(kydatkiKbn);
                        ztDrtenKykIdouDetailTy1.setZtykykymd(itKykSyouhnList.get(0).getKykymd().toString());
                        ztDrtenKykIdouDetailTy1.setZtyjikaipjyuutouym("000000");
                        ztDrtenKykIdouDetailTy1.setZtyhrkkaisuukbn(hrkkaisuuKbn);
                        ztDrtenKykIdouDetailTy1.setZtyhrkkeirokbn(hrkkeiroKbn);
                        ztDrtenKykIdouDetailTy1.setZtyanniskcd("00000000");
                        ztDrtenKykIdouDetailTy1.setZtydntcd("00000000");
                        ztDrtenKykIdouDetailTy1.setZtyharaikomip(0L);
                        ztDrtenKykIdouDetailTy1.setZtykjsyagaihknnm(bmSyouhnZokusei.getSyouhnnmsyouken());
                        ztDrtenKykIdouDetailTy1.setZtytelno("");
                        ztDrtenKykIdouDetailTy1.setZtyhensyuubosyuudrtennm("");
                        ztDrtenKykIdouDetailTy1.setZtykyknmkjdirtnkykido(kykNm);
                        ztDrtenKykIdouDetailTy1.setZtykjdntnm("");
                        ztDrtenKykIdouDetailTy1.setZtykzhurikaebankcd(kzhurikaebankcd);
                        ztDrtenKykIdouDetailTy1.setZtykzhurikaesitencd(kzhurikaesitencd);
                        ztDrtenKykIdouDetailTy1.setZtykzhurikaeyokinkbn(kzhurikaeyokinKbn);
                        ztDrtenKykIdouDetailTy1.setZtykzhurikaekouzano(kzhurikaekouzano);
                        ztDrtenKykIdouDetailTy1.setZtyoyabosyuudairitencd("");
                        ztDrtenKykIdouDetailTy1.setZtybsydrtenkanrisosikicd("0000000");
                        ztDrtenKykIdouDetailTy1.setZtybosyuudairitengyousyukbn("00");
                        ztDrtenKykIdouDetailTy1.setZtybosyuudrtennmkj("");
                        ztDrtenKykIdouDetailTy1.setZtydoujitusyoricount("");
                        ztDrtenKykIdouDetailTy1.setZtyhjnkykhyj("");
                        ztDrtenKykIdouDetailTy1.setZtyhjnnmkj("");
                        ztDrtenKykIdouDetailTy1.setZtysyuhrkkaisuukbn("0");
                        ztDrtenKykIdouDetailTy1.setZtyikkatubaraikbn(iktbriKbn);
                        ztDrtenKykIdouDetailTy1.setZtyikkatubaraikaisuu(iktbriKaisuu);
                        ztDrtenKykIdouDetailTy1.setZtyyobiv103("");

                        BizPropertyInitializer.initialize(ztDrtenKykIdouDetailTy1);

                        entityInserter.add(ztDrtenKykIdouDetailTy1);

                        kensuCount ++;

                    }

                    if (!mapIdoukbn.containsKey(idouKbn)) {
                        mapIdoukbn.put(idouKbn, true);
                    }
                }

                breakKeySyono = itKhTtdkRireki.getSyono();

                breakKeySyoriYmd = itKhTtdkRireki.getSyoriYmd();

                breakKeyGyoumuKousinKinou = itKhTtdkRireki.getGyoumuKousinKinou();

            }

        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(kensuCount)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
