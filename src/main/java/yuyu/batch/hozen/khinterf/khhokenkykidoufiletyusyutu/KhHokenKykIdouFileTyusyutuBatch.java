package yuyu.batch.hozen.khinterf.khhokenkykidoufiletyusyutu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyouriritu;
import yuyu.common.biz.bzcommon.GetSjkkktyouseiyourirituBean;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.GetKhHenkouRireki;
import yuyu.common.hozen.khcommon.GetKhSisuurendoTmttknTblBean;
import yuyu.common.hozen.khcommon.GetKhSisuurendoTmttknTblSakujyoBean;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KeisanKihrkPRuikeigk;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttknOverNnd;
import yuyu.common.hozen.khcommon.KeisanW;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.KeisanWKijunYM;
import yuyu.common.hozen.khcommon.KykSyouhnCommonParam;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.sinkeiyaku.skcommon.ConvNenSaiManki;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KykIdouHaraikataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TumitatekinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZfiIdoujiyuuKbn;
import yuyu.def.classification.C_ZougenKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HokenKykIdouRireki;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.ZT_HknkykIdouInfoTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 契約保全 インターフェイス 保険契約異動情報ファイル抽出
 */
public class KhHokenKykIdouFileTyusyutuBatch implements Batch {

    public enum E_SyutokuSyubetu {
        HENKOUMAE ("1"),
        HENKOUATO("2");

        private String name;
        E_SyutokuSyubetu(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    public final String TABLE_ID = "IT_KykKihon";

    public final String IB_RECOVERY_FILTER_ID = "Kh001";

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;
        String syono = null;
        C_UmuKbn yendthnkUmuFlg = C_UmuKbn.NONE;
        String hannteiYouSyono = null;
        BizCurrency beforeSisuuS = BizCurrency.valueOf(0);
        BizCurrency beforeSisuuP = BizCurrency.valueOf(0);
        BizCurrency beforeSisuuW = BizCurrency.valueOf(0);
        BizCurrency beforeTeirituS = BizCurrency.valueOf(0);
        BizCurrency beforeTeirituP = BizCurrency.valueOf(0);
        BizCurrency beforeTeirituW = BizCurrency.valueOf(0);
        BizCurrency afterSisuuS = BizCurrency.valueOf(0);
        BizCurrency afterSisuuP = BizCurrency.valueOf(0);
        BizCurrency afterSisuuW = BizCurrency.valueOf(0);
        BizCurrency afterTeirituS = BizCurrency.valueOf(0);
        BizCurrency afterTeirituP = BizCurrency.valueOf(0);
        BizCurrency afterTeirituW = BizCurrency.valueOf(0);
        long genngakuRenNo = 0;
        BizDate sisuurendoTmttknSyutokuYmd = null;
        C_Tuukasyu kyktuukasyu = C_Tuukasyu.BLNK;
        String hknsyuKigou = null;
        BizNumber yoteiriritu = BizNumber.valueOf(0);
        String renNo0edit = null;

        HeijunbaraiJikkou heijunbaraiJikkou = new HeijunbaraiJikkou();
        HeijunbaraiJikkouRirekiHensyuu heijunbaraiJikkouRirekiHensyuu = new HeijunbaraiJikkouRirekiHensyuu();

        KhHokenKykIdouFileTyusyutuDao pKhHokenKykIdouFileTyusyutuDao = SWAKInjector
            .getInstance(KhHokenKykIdouFileTyusyutuDao.class);

        try (ExDBResults<KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean> exDBResults =
            pKhHokenKykIdouFileTyusyutuDao.getKhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbn(
                ibKakutyoujobCd, syoriYmd);
            MultipleEntityInserter hknkykIdouInfoTyentityInserter = new MultipleEntityInserter()) {

            for (KhTtdkRirekiInfosByKakutyoujobcdSyoriYmdGyoumuKousinKinouSyorikbnBean khTtdkRirekiInfosBean :
                exDBResults) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(IB_RECOVERY_FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khTtdkRirekiInfosBean.getIT_KykKihon().getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(khTtdkRirekiInfosBean.getIT_KykKihon().getSyono());

                IT_KykKihon kykKihon = khTtdkRirekiInfosBean.getIT_KykKihon();
                IT_KhTtdkRireki khTtdkRireki = khTtdkRirekiInfosBean.getIT_KhTtdkRireki();
                syono = khTtdkRireki.getSyono();
                String gyoumuKousinKinou = khTtdkRireki.getGyoumuKousinKinou();
                C_SyoriKbn syoriKbn = khTtdkRireki.getSyorikbn();

                List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
                IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

                if (!C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())){

                    Long count = 0L;

                    int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN){
                        count = heijunbaraiJikkou.exec(
                            kykKihon, khTtdkRireki, hknkykIdouInfoTyentityInserter, bzBatchParam);
                    }
                    else if(syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN){
                        count = heijunbaraiJikkouRirekiHensyuu.exec(khTtdkRireki, hknkykIdouInfoTyentityInserter);
                    }

                    syoriKensuu = syoriKensuu + count;

                    continue;

                }

                if (!syono.equals(hannteiYouSyono)) {

                    yendthnkUmuFlg = C_UmuKbn.NONE;
                    hannteiYouSyono = syono;
                    genngakuRenNo = 0;
                    sisuurendoTmttknSyutokuYmd = null;
                }

                if (kykSyouhn.getYendthnkymd() != null &&
                    !IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou) &&
                    C_UmuKbn.NONE.eq(yendthnkUmuFlg)) {

                    continue;
                }

                KhHokenKykIdouFileTyusyutuCommon khHokenKykIdouFileTyusyutuCommon = new KhHokenKykIdouFileTyusyutuCommon();

                String dataKanriNo = khHokenKykIdouFileTyusyutuCommon.scramble(syono);

                BizDate idoubiYmd = khTtdkRireki.getSyoriYmd();
                BizDate kykymd = kykSyouhn.getKykymd();
                Integer hhknnen = kykSyouhn.getHhknnen();
                C_Hhknsei hhknsei = kykSyouhn.getHhknsei();
                C_AisyoumeiKbn aisyoumeiKbn = kykKihon.getAisyoumeikbn();
                Integer hknkkn = kykSyouhn.getHknkkn();
                C_TumitatekinKbn tumitatekinKbn = C_TumitatekinKbn.BLNK;
                C_KykIdouHaraikataKbn kykIdouHaraikataKbn = C_KykIdouHaraikataKbn.ITIJI;

                if (!IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou)) {

                    kyktuukasyu = kykSyouhn.getKyktuukasyu();
                    hknsyuKigou = kykSyouhn.getSyouhncd().substring(0, 2);
                    yoteiriritu = kykSyouhn.getYoteiriritu();
                }

                KaiyakuHenreikinDataSksBean kaiyakuHenreikinDataSksBean = null;
                SisuuTeirituKinngakuKsBean sisuuTeirituKinngakuKsBean = null;
                BizCurrency hokenKingaku = BizCurrency.valueOf(0);
                BizCurrency hokenryou = BizCurrency.valueOf(0);
                BizCurrency idouHokenKingaku = BizCurrency.valueOf(0);
                BizCurrency idouHokenryou = BizCurrency.valueOf(0);
                BizCurrency pTumitateKin = BizCurrency.valueOf(0);
                BizCurrency kiykHnrikn = BizCurrency.valueOf(0);
                BizCurrency idouPTumitateKin = BizCurrency.valueOf(0);
                BizCurrency idouKiykHnrikn = BizCurrency.valueOf(0);

                if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(gyoumuKousinKinou)) {

                    C_ZfiIdoujiyuuKbn zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SINKEIYAKU;
                    C_ZougenKbn zougenKbn = C_ZougenKbn.ZOU;
                    BizDate calcKijyunymd = kykSyouhn.getKykymd();
                    BizDateYM kijyunYM = calcKijyunymd.getBizDateYM();

                    renNo0edit = "01";

                    kaiyakuHenreikinDataSksBean = kykYmdHanteiKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, null, kykymd, syoriYmd, yendthnkUmuFlg);

                    BizCurrency ssyPTumitatekin = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency ssyKaiyakuhr = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
                    BizCurrency sisuuRendouTmttkngk = kaiyakuHenreikinDataSksBean.getSsySisuuRendouTmttkngk();
                    BizCurrency teirituTmttkngk = kaiyakuHenreikinDataSksBean.getSsyTeirituTmttkngk();

                    if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                        sisuuTeirituKinngakuKsBean = sisuuTeirituKinngakuKs(
                            kykSyouhn.getKykjisisuurendourate(),
                            kykSyouhn.getKihons(),
                            kykSyouhn.getHokenryou(),
                            ssyKaiyakuhr);

                        tumitatekinKbn = C_TumitatekinKbn.SISUU;
                        hokenKingaku = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        hokenryou = sisuuTeirituKinngakuKsBean.getSisuuP();
                        idouHokenKingaku = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        idouHokenryou = sisuuTeirituKinngakuKsBean.getSisuuP();
                        pTumitateKin = sisuuRendouTmttkngk ;
                        kiykHnrikn = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();
                        idouPTumitateKin = sisuuRendouTmttkngk;
                        idouKiykHnrikn = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;

                        tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                        hokenKingaku = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        hokenryou = sisuuTeirituKinngakuKsBean.getTeirituP();
                        idouHokenKingaku  = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        idouHokenryou = sisuuTeirituKinngakuKsBean.getTeirituP();
                        pTumitateKin = teirituTmttkngk ;
                        kiykHnrikn = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();
                        idouPTumitateKin = teirituTmttkngk;
                        idouKiykHnrikn = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();

                        hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();
                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                    else {

                        if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.SISUU;
                        }
                        else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                        }
                        hokenKingaku = kykSyouhn.getKihons();
                        hokenryou = kykSyouhn.getHokenryou();
                        idouHokenKingaku = kykSyouhn.getKihons();
                        idouHokenryou = kykSyouhn.getHokenryou();
                        pTumitateKin = ssyPTumitatekin;
                        kiykHnrikn = ssyKaiyakuhr;
                        idouPTumitateKin = ssyPTumitatekin;
                        idouKiykHnrikn = ssyKaiyakuhr;

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                }
                else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(gyoumuKousinKinou) ||
                    IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(gyoumuKousinKinou)) {

                    C_ZfiIdoujiyuuKbn zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.KAIYAKU;
                    C_ZougenKbn zougenKbn = C_ZougenKbn.GEN;
                    BizDate calcKijyunymd = kykSyouhn.getSyoumetuymd();

                    renNo0edit = "01";

                    KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                    BizDateYM kijunYM = keisanWKijunYM.exec(kykymd, calcKijyunymd, null, kykKihon.getHrkkaisuu(),
                        kykSyouhn.getKykjyoutai(), kykSyouhn.getSyouhncd(), null) ;

                    kaiyakuHenreikinDataSksBean = kaiyakuHenreikinDataSks(syono, calcKijyunymd, kijunYM, null, yendthnkUmuFlg);

                    BizCurrency ssyPTumitatekin = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency ssyKaiyakuhr = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
                    BizCurrency sisuuRendouTmttkngk = kaiyakuHenreikinDataSksBean.getSsySisuuRendouTmttkngk();
                    BizCurrency teirituTmttkngk = kaiyakuHenreikinDataSksBean.getSsyTeirituTmttkngk();

                    if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                        sisuuTeirituKinngakuKsBean = sisuuTeirituKinngakuKs(
                            kykSyouhn.getKykjisisuurendourate(),
                            kykSyouhn.getKihons(),
                            kykSyouhn.getHokenryou(),
                            ssyKaiyakuhr);

                        tumitatekinKbn = C_TumitatekinKbn.SISUU;
                        hokenKingaku = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        hokenryou = sisuuTeirituKinngakuKsBean.getSisuuP();
                        idouHokenKingaku  = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        idouHokenryou = sisuuTeirituKinngakuKsBean.getSisuuP();
                        pTumitateKin = sisuuRendouTmttkngk ;
                        kiykHnrikn = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();
                        idouPTumitateKin = sisuuRendouTmttkngk;
                        idouKiykHnrikn = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;

                        tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                        hokenKingaku = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        hokenryou = sisuuTeirituKinngakuKsBean.getTeirituP();
                        idouHokenKingaku  = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        idouHokenryou = sisuuTeirituKinngakuKsBean.getTeirituP();
                        pTumitateKin = teirituTmttkngk ;
                        kiykHnrikn = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();
                        idouPTumitateKin = teirituTmttkngk;
                        idouKiykHnrikn = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();

                        hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();
                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                    else {

                        if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.SISUU;
                        }
                        else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                        }

                        hokenKingaku = kykSyouhn.getKihons();
                        hokenryou = kykSyouhn.getHokenryou();
                        idouHokenKingaku = kykSyouhn.getKihons();
                        idouHokenryou = kykSyouhn.getHokenryou();
                        pTumitateKin = ssyPTumitatekin;
                        kiykHnrikn = ssyKaiyakuhr;
                        idouPTumitateKin = ssyPTumitatekin;
                        idouKiykHnrikn = ssyKaiyakuhr;

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                }
                else if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(gyoumuKousinKinou)
                    || IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(gyoumuKousinKinou) ) {

                    C_ZougenKbn zougenKbn = C_ZougenKbn.GEN;

                    renNo0edit = "01";

                    C_ZfiIdoujiyuuKbn zfiIdoujiyuuKbn = null;
                    BizDate calcKijyunymd = null;
                    BizDateYM kijyunYm = null;

                    if(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(gyoumuKousinKinou) && C_SyoriKbn.KAIJO.eq(syoriKbn)){
                        IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();
                        calcKijyunymd = khShrRireki.getKouryokuhasseiymd();
                        kijyunYm = calcKijyunymd.getBizDateYM().getNextMonth();
                    } else if (C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(syoriKbn) || C_SyoriKbn.SBMUKOU_SHRNASI.eq(syoriKbn) || C_SyoriKbn.SBMUKOU.eq(syoriKbn)
                        || C_SyoriKbn.CLGOFF.eq(syoriKbn) || C_SyoriKbn.KYKTORIKESI.eq(syoriKbn) || C_SyoriKbn.MUKOU.eq(syoriKbn)) {
                        calcKijyunymd = syoriYmd;
                        kijyunYm = calcKijyunymd.getBizDateYM().getNextMonth();
                    }else{
                        calcKijyunymd = kykSyouhn.getSyoumetuymd();
                        kijyunYm = calcKijyunymd.getBizDateYM().getNextMonth();
                    }

                    if (C_SyoriKbn.KYKTORIKESI.eq(syoriKbn)) {
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.KEIYAKUTORIKESI;
                    }
                    else if (C_SyoriKbn.MUKOU.eq(syoriKbn)) {
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.MUKOU;
                    }
                    else if (C_SyoriKbn.CLGOFF.eq(syoriKbn)) {
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.COOLINGOFF;
                    }
                    else if (C_SyoriKbn.SBKAIJO.eq(syoriKbn)) {
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUKAIJYO;
                    }
                    else if (C_SyoriKbn.KAIJO.eq(syoriKbn)) {
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.KAIJYO;

                        KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                        kijyunYm = keisanWKijunYM.exec(kykymd, calcKijyunymd, null, kykKihon.getHrkkaisuu(),
                            kykSyouhn.getKykjyoutai(), kykSyouhn.getSyouhncd(), null);
                    }
                    else if (C_SyoriKbn.SIBOU.eq(syoriKbn) || C_SyoriKbn.SBKYUUHUSHR.eq(syoriKbn)) {
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOU;
                    }
                    else if (C_SyoriKbn.KOUDOSYOUGAI.eq(syoriKbn)) {
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.KOUDOSYOUGAI;
                    }
                    else if(C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(syoriKbn)){
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMUKOUKIBARAIPSHR;
                    }
                    else if(C_SyoriKbn.SBMUKOU_SHRNASI.eq(syoriKbn)){
                        zfiIdoujiyuuKbn =  C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI;
                    }
                    else if(C_SyoriKbn.SBMENSEKI.eq(syoriKbn)){
                        zfiIdoujiyuuKbn =  C_ZfiIdoujiyuuKbn.SIBOUMENSEKI;
                    }
                    else if(C_SyoriKbn.SBMENSEKI_SHRNASI.eq(syoriKbn)){
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMENSEKISHRNASI;
                    }
                    else if(C_SyoriKbn.SBMUKOU.eq(syoriKbn)){
                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI;
                    }

                    if (BizDateUtil.compareYmd(calcKijyunymd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {

                        calcKijyunymd = kykSyouhn.getKykymd();
                        kijyunYm = calcKijyunymd.getBizDateYM();
                    }

                    kaiyakuHenreikinDataSksBean = kykYmdHanteiKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYm, null, kykymd, syoriYmd, yendthnkUmuFlg);

                    BizCurrency ssyPTumitatekin = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency ssyKaiyakuhr = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
                    BizCurrency sisuuRendouTmttkngk = kaiyakuHenreikinDataSksBean.getSsySisuuRendouTmttkngk();
                    BizCurrency teirituTmttkngk = kaiyakuHenreikinDataSksBean.getSsyTeirituTmttkngk();

                    if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                        sisuuTeirituKinngakuKsBean = sisuuTeirituKinngakuKs(
                            kykSyouhn.getKykjisisuurendourate(),
                            kykSyouhn.getKihons(),
                            kykSyouhn.getHokenryou(),
                            ssyKaiyakuhr);

                        tumitatekinKbn = C_TumitatekinKbn.SISUU;
                        hokenKingaku = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        hokenryou = sisuuTeirituKinngakuKsBean.getSisuuP();
                        idouHokenKingaku  = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        idouHokenryou = sisuuTeirituKinngakuKsBean.getSisuuP();
                        pTumitateKin = sisuuRendouTmttkngk ;
                        kiykHnrikn = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();
                        idouPTumitateKin = sisuuRendouTmttkngk;
                        idouKiykHnrikn = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        if (zfiIdoujiyuuKbn != null) {
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        }
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;

                        tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                        hokenKingaku = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        hokenryou = sisuuTeirituKinngakuKsBean.getTeirituP();
                        idouHokenKingaku  = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        idouHokenryou = sisuuTeirituKinngakuKsBean.getTeirituP();
                        pTumitateKin = teirituTmttkngk ;
                        kiykHnrikn = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();
                        idouPTumitateKin = teirituTmttkngk;
                        idouKiykHnrikn = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();

                        hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        if (zfiIdoujiyuuKbn != null) {
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        }
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                    else {
                        if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.SISUU;
                        }
                        else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                        }

                        hokenKingaku = kykSyouhn.getKihons();
                        hokenryou = kykSyouhn.getHokenryou();
                        idouHokenKingaku = kykSyouhn.getKihons();
                        idouHokenryou = kykSyouhn.getHokenryou();
                        pTumitateKin = ssyPTumitatekin;
                        kiykHnrikn = ssyKaiyakuhr;
                        idouPTumitateKin = ssyPTumitatekin;
                        idouKiykHnrikn = ssyKaiyakuhr;

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        if (zfiIdoujiyuuKbn != null) {
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        }
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                }
                else if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou) ||
                    (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(gyoumuKousinKinou) &&
                        C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI.eq(syoriKbn))) {

                    if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou)) {

                        yendthnkUmuFlg = C_UmuKbn.ARI;
                    }

                    renNo0edit = "01";

                    IT_KykSyouhnRireki kykSyouhnRireki = new IT_KykSyouhnRireki();

                    if (!khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                        List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = pKhHokenKykIdouFileTyusyutuDao.
                            getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukey(syono, C_SyutkKbn.SYU, khTtdkRireki.getHenkousikibetukey());

                        kykSyouhnRireki = kykSyouhnRirekiLst.get(0);

                    }
                    else{

                        kykSyouhnRireki = pKhHokenKykIdouFileTyusyutuDao.
                            getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukeyLt(syono, C_SyutkKbn.SYU, khTtdkRireki.getHenkousikibetukey());
                    }

                    if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou) ||
                        !khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                        kyktuukasyu = kykSyouhnRireki.getKyktuukasyu();
                        hknsyuKigou = kykSyouhnRireki.getSyouhncd().substring(0, 2);
                        yoteiriritu = kykSyouhnRireki.getYoteiriritu();
                    }

                    C_ZfiIdoujiyuuKbn zfiIdoujiyuuKbn = null;
                    C_ZougenKbn zougenKbn = null;
                    BizDate calcKijyunymd = null;
                    C_Kykjyoutai kykjyoutai = null;
                    String syouhncd = null;


                    if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou)) {

                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.MKHGKTTTYENDTHNK;
                        zougenKbn = C_ZougenKbn.GEN;
                    }
                    else {

                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.MKHGKTTTYENDTHNKTRKS;
                        zougenKbn = C_ZougenKbn.ZOU;
                    }

                    if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou)) {

                        calcKijyunymd = kykSyouhn.getYendthnkymd().addDays(-1);
                        kykjyoutai = kykSyouhn.getKykjyoutai();
                        syouhncd = kykSyouhnRireki.getSyouhncd();
                    }
                    else {

                        if(!khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {
                            IT_KykSyouhnRireki kykSyouhnRirekiResult = pKhHokenKykIdouFileTyusyutuDao.
                                getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukeyLt(syono, C_SyutkKbn.SYU, khTtdkRireki.getHenkousikibetukey());
                            calcKijyunymd = kykSyouhnRirekiResult.getYendthnkymd().addDays(-1);
                            kykjyoutai = kykSyouhnRirekiResult.getKykjyoutai();
                            syouhncd = kykSyouhnRirekiResult.getSyouhncd();
                        }
                        else{
                            calcKijyunymd = kykSyouhnRireki.getYendthnkymd().addDays(-1);
                            kykjyoutai = kykSyouhnRireki.getKykjyoutai();
                            syouhncd = kykSyouhnRireki.getSyouhncd();
                        }
                    }

                    KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                    BizDateYM kijyunYM = keisanWKijunYM.exec(kykymd, calcKijyunymd, null, kykKihon.getHrkkaisuu(),
                        kykjyoutai, syouhncd, null);

                    BizCurrency ssyPTumitatekin = null;
                    BizCurrency ssyKaiyakuhr = null;
                    BizCurrency sisuuRendouTmttkngk = null;
                    BizCurrency teirituTmttkngk = null;

                    int syohinHanteiKbn = SyouhinUtil.hantei(syouhncd);

                    if (syohinHanteiKbn != SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {

                        if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou) ||
                            !khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                            kaiyakuHenreikinDataSksBean = kaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, kykSyouhnRireki, yendthnkUmuFlg);
                        }
                        else {

                            kaiyakuHenreikinDataSksBean = kaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, null, yendthnkUmuFlg);
                        }

                        ssyPTumitatekin = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                        ssyKaiyakuhr = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
                        sisuuRendouTmttkngk = kaiyakuHenreikinDataSksBean.getSsySisuuRendouTmttkngk();
                        teirituTmttkngk = kaiyakuHenreikinDataSksBean.getSsyTeirituTmttkngk();
                    }
                    else {
                        if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou)) {

                            kaiyakuHenreikinDataSksBean = kaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, kykSyouhnRireki, yendthnkUmuFlg);
                        }
                        else {

                            IT_KhSisuurendoTmttkn tetudukiTyokugoSisuurendoTmttknTbl =
                                searchSisuurendoTmttknTblForTetudukiji(khTtdkRireki);

                            if (!khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {
                                kaiyakuHenreikinDataSksBean =
                                    tumitateKinKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, kykSyouhnRireki,
                                        tetudukiTyokugoSisuurendoTmttknTbl.getTeiritutmttkngk(),
                                        tetudukiTyokugoSisuurendoTmttknTbl.getSisuurendoutmttkngk(),
                                        yendthnkUmuFlg);
                            } else {
                                kaiyakuHenreikinDataSksBean =
                                    tumitateKinKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, null,
                                        tetudukiTyokugoSisuurendoTmttknTbl.getTeiritutmttkngk(),
                                        tetudukiTyokugoSisuurendoTmttknTbl.getSisuurendoutmttkngk(),
                                        yendthnkUmuFlg);
                            }
                        }

                        ssyPTumitatekin = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                        ssyKaiyakuhr = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
                        sisuuRendouTmttkngk = kaiyakuHenreikinDataSksBean.getSsySisuuRendouTmttkngk();
                        teirituTmttkngk = kaiyakuHenreikinDataSksBean.getSsyTeirituTmttkngk();
                    }

                    if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                        tumitatekinKbn = C_TumitatekinKbn.SISUU;

                        if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou) ||
                            !khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                            sisuuTeirituKinngakuKsBean = sisuuTeirituKinngakuKs(
                                kykSyouhn.getKykjisisuurendourate(),
                                kykSyouhnRireki.getKihons(),
                                kykSyouhnRireki.getHokenryou(),
                                ssyKaiyakuhr);
                        }
                        else {

                            sisuuTeirituKinngakuKsBean = sisuuTeirituKinngakuKs(
                                kykSyouhn.getKykjisisuurendourate(),
                                kykSyouhn.getKihons(),
                                kykSyouhn.getHokenryou(),
                                ssyKaiyakuhr);
                        }

                        hokenKingaku = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        hokenryou = sisuuTeirituKinngakuKsBean.getSisuuP();
                        idouHokenKingaku  = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        idouHokenryou = sisuuTeirituKinngakuKsBean.getSisuuP();
                        pTumitateKin = sisuuRendouTmttkngk ;
                        kiykHnrikn = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();
                        idouPTumitateKin = sisuuRendouTmttkngk;
                        idouKiykHnrikn = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;

                        tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                        hokenKingaku = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        hokenryou = sisuuTeirituKinngakuKsBean.getTeirituP();
                        idouHokenKingaku  = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        idouHokenryou = sisuuTeirituKinngakuKsBean.getTeirituP();
                        pTumitateKin = teirituTmttkngk ;
                        kiykHnrikn = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();
                        idouPTumitateKin = teirituTmttkngk;
                        idouKiykHnrikn = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();

                        hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                    else {

                        if (IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(gyoumuKousinKinou) ||
                            !khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhnRireki.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.SISUU;
                            }
                            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhnRireki.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                            }

                            hokenKingaku = kykSyouhnRireki.getKihons();
                            hokenryou = kykSyouhnRireki.getHokenryou();
                            idouHokenKingaku = kykSyouhnRireki.getKihons();
                            idouHokenryou = kykSyouhnRireki.getHokenryou();
                            pTumitateKin = ssyPTumitatekin;
                            kiykHnrikn = ssyKaiyakuhr;
                            idouPTumitateKin = ssyPTumitatekin;
                            idouKiykHnrikn = ssyKaiyakuhr;
                        }
                        else {
                            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.SISUU;
                            }
                            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                            }

                            hokenKingaku = kykSyouhn.getKihons();
                            hokenryou = kykSyouhn.getHokenryou();
                            idouHokenKingaku = kykSyouhn.getKihons();
                            idouHokenryou = kykSyouhn.getHokenryou();
                            pTumitateKin = ssyPTumitatekin;
                            kiykHnrikn = ssyKaiyakuhr;
                            idouPTumitateKin = ssyPTumitatekin;
                            idouKiykHnrikn = ssyKaiyakuhr;
                        }

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }

                }
                else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(gyoumuKousinKinou)) {

                    genngakuRenNo = genngakuRenNo + 1;

                    renNo0edit = BizUtil.zeroNum(String.valueOf(genngakuRenNo), 2, 0) ;

                    List<IT_KykSyouhnRireki> kykSyouhnRirekilst = new ArrayList<IT_KykSyouhnRireki>();

                    if (C_UmuKbn.ARI.eq(yendthnkUmuFlg)) {

                        List<IT_KykSyouhnRireki> yenSyouhnRirekLst = pKhHokenKykIdouFileTyusyutuDao.
                            getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukey(syono, C_SyutkKbn.SYU, khTtdkRireki.getHenkousikibetukey());

                        kykSyouhnRirekilst = hozenDomManager.getKykSyouhnRirekisByPk(
                            syono,
                            C_SyutkKbn.SYU,
                            yenSyouhnRirekLst.get(0).getSyouhncd(),
                            yenSyouhnRirekLst.get(0).getSyouhnsdno(),
                            yenSyouhnRirekLst.get(0).getKyksyouhnrenno());
                    }
                    else {

                        kykSyouhnRirekilst = hozenDomManager.getKykSyouhnRirekisByPk(
                            syono,
                            C_SyutkKbn.SYU,
                            kykSyouhn.getSyouhncd(),
                            kykSyouhn.getSyouhnsdno(),
                            kykSyouhn.getKyksyouhnrenno());
                    }

                    BizCurrency beforeS = BizCurrency.valueOf(0);
                    BizCurrency beforeP = BizCurrency.valueOf(0);
                    BizCurrency afterS = BizCurrency.valueOf(0);
                    BizCurrency afterP = BizCurrency.valueOf(0);

                    IT_KykSyouhnRireki beforeKykSyohnRireki = null;
                    IT_KykSyouhnRireki afterKykSyohnRireki = null;

                    if (khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                        beforeS = kykSyouhnRirekilst.get(0).getKihons();
                        beforeP = kykSyouhnRirekilst.get(0).getHokenryou();
                        beforeKykSyohnRireki = kykSyouhnRirekilst.get(0);
                        afterS = kykSyouhn.getKihons();
                        afterP = kykSyouhn.getHokenryou();
                    }
                    else {

                        for (int i = 0; i < kykSyouhnRirekilst.size(); i++) {

                            if (khTtdkRireki.getHenkousikibetukey().equals(kykSyouhnRirekilst.get(i).getHenkousikibetukey())) {
                                beforeS = kykSyouhnRirekilst.get(i + 1).getKihons();
                                beforeP = kykSyouhnRirekilst.get(i + 1).getHokenryou();
                                beforeKykSyohnRireki = kykSyouhnRirekilst.get(i + 1);
                                afterS = kykSyouhnRirekilst.get(i).getKihons();
                                afterP = kykSyouhnRirekilst.get(i).getHokenryou();
                                afterKykSyohnRireki = kykSyouhnRirekilst.get(i);
                                kyktuukasyu = kykSyouhnRirekilst.get(i).getKyktuukasyu();
                                hknsyuKigou = kykSyouhnRirekilst.get(i).getSyouhncd().substring(0, 2);
                                yoteiriritu = kykSyouhnRirekilst.get(i).getYoteiriritu();

                                break;
                            }
                        }
                    }

                    C_ZfiIdoujiyuuKbn zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.GENGAKUBFR;
                    C_ZougenKbn zougenKbn = C_ZougenKbn.GEN;

                    BizDate calcKijyunymd = null;
                    C_Kykjyoutai kykjyoutai = null;

                    if (khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                        calcKijyunymd = kykSyouhn.getKouryokuhasseiymd();

                        kykjyoutai = kykSyouhn.getKykjyoutai();
                    }
                    else {

                        calcKijyunymd = afterKykSyohnRireki.getKouryokuhasseiymd();

                        kykjyoutai = afterKykSyohnRireki.getKykjyoutai();
                    }

                    KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

                    BizDateYM kijyunYM = keisanWKijunYM.exec(kykymd, calcKijyunymd, null, kykKihon.getHrkkaisuu(),
                        kykjyoutai, beforeKykSyohnRireki.getSyouhncd(), null);

                    int syohinHanteiKbn = SyouhinUtil.hantei(beforeKykSyohnRireki.getSyouhncd());

                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                    CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(beforeKykSyohnRireki.getKyktuukasyu());

                    BizCurrency beforeTeiritutmttkngk = BizCurrency.valueOf(0, currencyType);
                    BizCurrency beforeSisuurendoutmttkngk = BizCurrency.valueOf(0, currencyType);
                    BizCurrency afterTeiritutmttkngk = BizCurrency.valueOf(0, currencyType);
                    BizCurrency afterSisuurendoutmttkngk = BizCurrency.valueOf(0, currencyType);

                    if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                        syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                        if (sisuurendoTmttknSyutokuYmd == null) {
                            sisuurendoTmttknSyutokuYmd = calcKijyunymd;
                        }


                        List<IT_KhSisuurendoTmttkn> khSisuurendoTmttknList =
                            pKhHokenKykIdouFileTyusyutuDao.getKhSisuurendoTmttknsBySyonoTmttknkouryokukaisiymdLe(syono, sisuurendoTmttknSyutokuYmd);

                        int getNo = (int)genngakuRenNo - 1;
                        beforeTeiritutmttkngk = khSisuurendoTmttknList.get(getNo + 1).getTeiritutmttkngk();
                        beforeSisuurendoutmttkngk = khSisuurendoTmttknList.get(getNo + 1).getSisuurendoutmttkngk();
                        afterTeiritutmttkngk = khSisuurendoTmttknList.get(getNo).getTeiritutmttkngk();
                        afterSisuurendoutmttkngk = khSisuurendoTmttknList.get(getNo).getSisuurendoutmttkngk();

                    }

                    kaiyakuHenreikinDataSksBean =
                        tumitateKinKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, beforeKykSyohnRireki, beforeTeiritutmttkngk, beforeSisuurendoutmttkngk, yendthnkUmuFlg);

                    BizCurrency beforeV = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency beforeW = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
                    BizCurrency beforeSisuuV = kaiyakuHenreikinDataSksBean.getSsySisuuRendouTmttkngk();
                    BizCurrency beforeTeirituV = kaiyakuHenreikinDataSksBean.getSsyTeirituTmttkngk();

                    kaiyakuHenreikinDataSksBean =
                        tumitateKinKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, afterKykSyohnRireki, afterTeiritutmttkngk, afterSisuurendoutmttkngk, yendthnkUmuFlg);

                    BizCurrency afterV = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency afterW = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
                    BizCurrency afterSisuuV = kaiyakuHenreikinDataSksBean.getSsySisuuRendouTmttkngk();
                    BizCurrency afterTeirituV = kaiyakuHenreikinDataSksBean.getSsyTeirituTmttkngk();

                    if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                        tumitatekinKbn = C_TumitatekinKbn.SISUU;

                        sisuuTeirituKinngakuKsBean =
                            sisuuTeirituKinngakuKs(kykSyouhn.getKykjisisuurendourate(), beforeS, beforeP, beforeW);

                        beforeSisuuS = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        beforeSisuuP = sisuuTeirituKinngakuKsBean.getSisuuP();
                        beforeSisuuW = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();
                        beforeTeirituS = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        beforeTeirituP = sisuuTeirituKinngakuKsBean.getTeirituP();
                        beforeTeirituW = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();

                        sisuuTeirituKinngakuKsBean =
                            sisuuTeirituKinngakuKs(kykSyouhn.getKykjisisuurendourate(), afterS, afterP, afterW);

                        afterSisuuS = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        afterSisuuP = sisuuTeirituKinngakuKsBean.getSisuuP();
                        afterSisuuW = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();
                        afterTeirituS = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        afterTeirituP = sisuuTeirituKinngakuKsBean.getTeirituP();
                        afterTeirituW = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();

                        idouHokenKingaku = beforeSisuuS.subtract(afterSisuuS);
                        idouHokenryou = beforeSisuuP.subtract(afterSisuuP);
                        idouPTumitateKin = beforeSisuuV.subtract(afterSisuuV);
                        idouKiykHnrikn = beforeSisuuW.subtract(afterSisuuW);

                        hokenKingaku = beforeSisuuS;
                        hokenryou = beforeSisuuP;
                        pTumitateKin = beforeSisuuV;
                        kiykHnrikn = beforeSisuuW;

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;

                        tumitatekinKbn = C_TumitatekinKbn.TEIRITU;

                        idouHokenKingaku = beforeTeirituS.subtract(afterTeirituS);
                        idouHokenryou = beforeTeirituP.subtract(afterTeirituP);
                        idouPTumitateKin = beforeTeirituV.subtract(afterTeirituV);
                        idouKiykHnrikn = beforeTeirituW.subtract(afterTeirituW);

                        hokenKingaku = beforeTeirituS;
                        hokenryou = beforeTeirituP;
                        pTumitateKin = beforeTeirituV;
                        kiykHnrikn = beforeTeirituW;

                        hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                    else {

                        if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(beforeKykSyohnRireki.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.SISUU;
                        }
                        else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(beforeKykSyohnRireki.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                        }

                        idouHokenKingaku = beforeS.subtract(afterS);
                        idouHokenryou =  beforeP.subtract(afterP);
                        idouPTumitateKin =  beforeV.subtract(afterV);
                        idouKiykHnrikn =  beforeW.subtract(afterW);

                        hokenKingaku =  beforeS;
                        hokenryou =  beforeP;
                        pTumitateKin=  beforeV;
                        kiykHnrikn =  beforeW;

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }

                    zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.GENGAKUNEW;
                    zougenKbn = C_ZougenKbn.ZOU;

                    idouHokenKingaku = BizCurrency.valueOf(0);
                    idouHokenryou =  BizCurrency.valueOf(0);
                    idouPTumitateKin =  BizCurrency.valueOf(0);
                    idouKiykHnrikn =  BizCurrency.valueOf(0);

                    if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                        tumitatekinKbn = C_TumitatekinKbn.SISUU;

                        hokenKingaku = afterSisuuS;
                        hokenryou = afterSisuuP;
                        pTumitateKin = afterSisuuV;
                        kiykHnrikn = afterSisuuW;

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;

                        tumitatekinKbn = C_TumitatekinKbn.TEIRITU;

                        hokenKingaku = afterTeirituS;
                        hokenryou = afterTeirituP;
                        pTumitateKin = afterTeirituV;
                        kiykHnrikn = afterTeirituW;

                        hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();
                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                    else {

                        if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(beforeKykSyohnRireki.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.SISUU;
                        }
                        else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(beforeKykSyohnRireki.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                        }

                        hokenKingaku =  afterS;
                        hokenryou =  afterP;
                        pTumitateKin=  afterV;
                        kiykHnrikn =  afterW;

                        ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                        hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                        if (idoubiYmd != null) {
                            hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                        }
                        hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                        hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                        hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                        if (kykymd != null) {
                            hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                        }
                        hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                        hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                        hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                        hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                        hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                        hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                        hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                        hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                        hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                        hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                        hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                        hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                        hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                        hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                        BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                        hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                        syoriKensuu ++;
                    }
                }
                else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(gyoumuKousinKinou)) {

                    renNo0edit = "01";

                    List<IT_KykSyouhnRireki> kykSyouhnRirekilst = new ArrayList<IT_KykSyouhnRireki>();

                    if (C_UmuKbn.ARI.eq(yendthnkUmuFlg)) {

                        List<IT_KykSyouhnRireki> yenSyouhnRirekLst = pKhHokenKykIdouFileTyusyutuDao.
                            getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukey(
                                syono, C_SyutkKbn.SYU, khTtdkRireki.getHenkousikibetukey());

                        kykSyouhnRirekilst = hozenDomManager.getKykSyouhnRirekisByPk(
                            syono,
                            C_SyutkKbn.SYU,
                            yenSyouhnRirekLst.get(0).getSyouhncd(),
                            yenSyouhnRirekLst.get(0).getSyouhnsdno(),
                            yenSyouhnRirekLst.get(0).getKyksyouhnrenno());

                    }
                    else {

                        kykSyouhnRirekilst = hozenDomManager.getKykSyouhnRirekisByPk(
                            syono,
                            C_SyutkKbn.SYU,
                            kykSyouhn.getSyouhncd(),
                            kykSyouhn.getSyouhnsdno(),
                            kykSyouhn.getKyksyouhnrenno());
                    }

                    BizCurrency beforeS = BizCurrency.valueOf(0);
                    BizCurrency beforeP = BizCurrency.valueOf(0);
                    BizCurrency afterS = BizCurrency.valueOf(0);
                    BizCurrency afterP = BizCurrency.valueOf(0);
                    IT_KykSyouhnRireki beforeKykSyohnRireki = null;
                    IT_KykSyouhnRireki afterKykSyohnRireki = null;

                    if (khTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                        beforeS = kykSyouhnRirekilst.get(0).getKihons();
                        beforeP = kykSyouhnRirekilst.get(0).getHokenryou();
                        beforeKykSyohnRireki = kykSyouhnRirekilst.get(0);
                        afterS = kykSyouhn.getKihons();
                        afterP = kykSyouhn.getHokenryou();
                    }
                    else {

                        for (int i = 0; i < kykSyouhnRirekilst.size(); i++) {

                            if (khTtdkRireki.getHenkousikibetukey().equals(kykSyouhnRirekilst.get(i).getHenkousikibetukey())) {
                                beforeS = kykSyouhnRirekilst.get(i + 1).getKihons();
                                beforeP = kykSyouhnRirekilst.get(i + 1).getHokenryou();
                                beforeKykSyohnRireki = kykSyouhnRirekilst.get(i + 1);
                                afterS = kykSyouhnRirekilst.get(i).getKihons();
                                afterP = kykSyouhnRirekilst.get(i).getHokenryou();
                                afterKykSyohnRireki = kykSyouhnRirekilst.get(i);
                                kyktuukasyu = kykSyouhnRirekilst.get(i).getKyktuukasyu();
                                hknsyuKigou = kykSyouhnRirekilst.get(i).getSyouhncd().substring(0, 2);
                                yoteiriritu = kykSyouhnRirekilst.get(i).getYoteiriritu();

                                break;
                            }
                        }
                    }

                    C_ZfiIdoujiyuuKbn zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSBFR;
                    C_ZougenKbn zougenKbn = C_ZougenKbn.GEN;
                    BizDate calcKijyunymd;
                    BizDateYM kijyunYM;

                    if (BizDateUtil.compareYmd(idoubiYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
                        calcKijyunymd = kykSyouhn.getKykymd();
                        kijyunYM = calcKijyunymd.getBizDateYM();
                    }
                    else {
                        calcKijyunymd = idoubiYmd;
                        kijyunYM = calcKijyunymd.getBizDateYM().getNextMonth();
                    }

                    kaiyakuHenreikinDataSksBean = kykYmdHanteiKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM,
                        beforeKykSyohnRireki, kykymd, syoriYmd, yendthnkUmuFlg);

                    BizCurrency beforeV = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency beforeW = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
                    BizCurrency beforeSisuuV = kaiyakuHenreikinDataSksBean.getSsySisuuRendouTmttkngk();
                    BizCurrency beforeTeirituV = kaiyakuHenreikinDataSksBean.getSsyTeirituTmttkngk();

                    kaiyakuHenreikinDataSksBean = kykYmdHanteiKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM,
                        afterKykSyohnRireki, kykymd, syoriYmd, yendthnkUmuFlg);

                    BizCurrency afterV = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency afterW = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();
                    BizCurrency afterSisuuV = kaiyakuHenreikinDataSksBean.getSsySisuuRendouTmttkngk();
                    BizCurrency afterTeirituV = kaiyakuHenreikinDataSksBean.getSsyTeirituTmttkngk();

                    if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                        sisuuTeirituKinngakuKsBean =
                            sisuuTeirituKinngakuKs(kykSyouhn.getKykjisisuurendourate(), beforeS, beforeP, beforeW);

                        beforeSisuuS = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        beforeSisuuP = sisuuTeirituKinngakuKsBean.getSisuuP();
                        beforeSisuuW = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();
                        beforeTeirituS = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        beforeTeirituP = sisuuTeirituKinngakuKsBean.getTeirituP();
                        beforeTeirituW = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();

                        sisuuTeirituKinngakuKsBean =
                            sisuuTeirituKinngakuKs(kykSyouhn.getKykjisisuurendourate(), afterS, afterP, afterW);

                        afterSisuuS = sisuuTeirituKinngakuKsBean.getSisuuKihonS();
                        afterSisuuP = sisuuTeirituKinngakuKsBean.getSisuuP();
                        afterSisuuW = sisuuTeirituKinngakuKsBean.getSisuuKaiyakuhr();
                        afterTeirituS = sisuuTeirituKinngakuKsBean.getTeirituKihonS();
                        afterTeirituP = sisuuTeirituKinngakuKsBean.getTeirituP();
                        afterTeirituW = sisuuTeirituKinngakuKsBean.getTeirituKaiyakuhr();
                    }

                    if (beforeS.compareTo(afterS) > 0 || beforeP.compareTo(afterP) > 0) {

                        if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.SISUU;

                            idouHokenKingaku = beforeSisuuS.subtract(afterSisuuS);
                            idouHokenryou = beforeSisuuP.subtract(afterSisuuP);
                            idouPTumitateKin = beforeSisuuV.subtract(afterSisuuV);
                            idouKiykHnrikn = beforeSisuuW.subtract(afterSisuuW);

                            hokenKingaku = beforeSisuuS;
                            hokenryou = beforeSisuuP;
                            pTumitateKin = beforeSisuuV;
                            kiykHnrikn = beforeSisuuW;

                            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;

                            tumitatekinKbn = C_TumitatekinKbn.TEIRITU;

                            idouHokenKingaku = beforeTeirituS.subtract(afterTeirituS);
                            idouHokenryou = beforeTeirituP.subtract(afterTeirituP);
                            idouPTumitateKin = beforeTeirituV.subtract(afterTeirituV);
                            idouKiykHnrikn = beforeTeirituW.subtract(afterTeirituW);

                            hokenKingaku = beforeTeirituS;
                            hokenryou = beforeTeirituP;
                            pTumitateKin = beforeTeirituV;
                            kiykHnrikn = beforeTeirituW;

                            hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();
                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;
                        }
                        else {

                            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.SISUU;
                            }
                            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                            }

                            idouHokenKingaku = beforeS.subtract(afterS);
                            idouHokenryou =  beforeP.subtract(afterP);
                            idouPTumitateKin =  beforeV.subtract(afterV);
                            idouKiykHnrikn =  beforeW.subtract(afterW);

                            hokenKingaku =  beforeS;
                            hokenryou =  beforeP;
                            pTumitateKin=  beforeV;
                            kiykHnrikn =  beforeW;

                            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;
                        }

                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW;
                        zougenKbn = C_ZougenKbn.ZOU;

                        idouHokenKingaku = BizCurrency.valueOf(0);
                        idouHokenryou = BizCurrency.valueOf(0);
                        idouPTumitateKin = BizCurrency.valueOf(0);
                        idouKiykHnrikn = BizCurrency.valueOf(0);

                        if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.SISUU;

                            hokenKingaku =  afterSisuuS;
                            hokenryou =  afterSisuuP;
                            pTumitateKin=  afterSisuuV;
                            kiykHnrikn =  afterSisuuW;

                            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;

                            tumitatekinKbn = C_TumitatekinKbn.TEIRITU;

                            hokenKingaku =  afterTeirituS;
                            hokenryou =  afterTeirituP;
                            pTumitateKin=  afterTeirituV;
                            kiykHnrikn =  afterTeirituW;

                            hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();
                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;
                        }
                        else {

                            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.SISUU;
                            }
                            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                            }

                            hokenKingaku =  afterS;
                            hokenryou =  afterP;
                            pTumitateKin=  afterV;
                            kiykHnrikn =  afterW;

                            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;
                        }
                    }

                    if (afterS.compareTo(beforeS) > 0 || afterP.compareTo(beforeP) > 0) {

                        if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.SISUU;

                            idouHokenKingaku = BizCurrency.valueOf(0);
                            idouHokenryou = BizCurrency.valueOf(0);
                            idouPTumitateKin = BizCurrency.valueOf(0);
                            idouKiykHnrikn = BizCurrency.valueOf(0);

                            hokenKingaku = beforeSisuuS;
                            hokenryou = beforeSisuuP;
                            pTumitateKin = beforeSisuuV;
                            kiykHnrikn = beforeSisuuW;

                            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;

                            tumitatekinKbn = C_TumitatekinKbn.TEIRITU;

                            hokenKingaku = beforeTeirituS;
                            hokenryou = beforeTeirituP;
                            pTumitateKin = beforeTeirituV;
                            kiykHnrikn = beforeTeirituW;

                            hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;
                        }
                        else {

                            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.SISUU;
                            }
                            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                            }

                            hokenKingaku = beforeS;
                            hokenryou = beforeP;
                            pTumitateKin = beforeV;
                            kiykHnrikn = beforeW;

                            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;
                        }

                        zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW;
                        zougenKbn = C_ZougenKbn.ZOU;

                        if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                            tumitatekinKbn = C_TumitatekinKbn.SISUU;

                            idouHokenKingaku = afterSisuuS.subtract(beforeSisuuS);
                            idouHokenryou = afterSisuuP.subtract(beforeSisuuP);
                            idouPTumitateKin = afterSisuuV.subtract(beforeSisuuV);
                            idouKiykHnrikn = afterSisuuW.subtract(beforeSisuuW);

                            hokenKingaku = afterSisuuS;
                            hokenryou = afterSisuuP;
                            pTumitateKin = afterSisuuV;
                            kiykHnrikn = afterSisuuW;

                            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;

                            tumitatekinKbn = C_TumitatekinKbn.TEIRITU;

                            idouHokenKingaku = afterTeirituS.subtract(beforeTeirituS);
                            idouHokenryou = afterTeirituP.subtract(beforeTeirituP);
                            idouPTumitateKin = afterTeirituV.subtract(beforeTeirituV);
                            idouKiykHnrikn = afterTeirituW.subtract(beforeTeirituW);

                            hokenKingaku = afterTeirituS;
                            hokenryou = afterTeirituP;
                            pTumitateKin = afterTeirituV;
                            kiykHnrikn = afterTeirituW;

                            hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();
                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;
                        }
                        else {

                            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.SISUU;
                            }
                            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                                tumitatekinKbn = C_TumitatekinKbn.TEIRITU;
                            }

                            idouHokenKingaku = afterS.subtract(beforeS);
                            idouHokenryou = afterP.subtract(beforeP);
                            idouPTumitateKin = afterV.subtract(beforeV);
                            idouKiykHnrikn = afterW.subtract(beforeW);

                            hokenKingaku = afterS;
                            hokenryou = afterP;
                            pTumitateKin = afterV;
                            kiykHnrikn = afterW;

                            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

                            hknkykIdouInfoTy.setZtykyktuukasyu(kyktuukasyu.getValue());
                            if (idoubiYmd != null) {
                                hknkykIdouInfoTy.setZtyidouymd(idoubiYmd.toString());
                            }
                            hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(zfiIdoujiyuuKbn.getValue());
                            hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                            hknkykIdouInfoTy.setZtyrenno(renNo0edit);
                            if (kykymd != null) {
                                hknkykIdouInfoTy.setZtykeiyakuymd(kykymd.toString());
                            }
                            hknkykIdouInfoTy.setZtyhhknnen2(hhknnen.toString());
                            hknkykIdouInfoTy.setZtyhhknsei(hhknsei.getValue());
                            hknkykIdouInfoTy.setZtyhknsyukigou(hknsyuKigou);
                            hknkykIdouInfoTy.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                            hknkykIdouInfoTy.setZtyzougenkbn(zougenKbn.getValue());
                            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(hokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(hokenryou.toString())));
                            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(pTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(kiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(idouHokenKingaku.toString())));
                            hknkykIdouInfoTy.setZtyidoup(BizNumber.valueOf(new BigDecimal(idouHokenryou.toString())));
                            hknkykIdouInfoTy.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(idouPTumitateKin.toString())));
                            hknkykIdouInfoTy.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(idouKiykHnrikn.toString())));
                            hknkykIdouInfoTy.setZtyhknkkn(hknkkn.toString());
                            hknkykIdouInfoTy.setZtyyoteiriritun5(yoteiriritu);
                            hknkykIdouInfoTy.setZtytumitatekinkbn(tumitatekinKbn.getValue());
                            hknkykIdouInfoTy.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                            BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                            hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTy);

                            syoriKensuu ++;
                        }
                    }
                }
                else if (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(gyoumuKousinKinou)) {

                    renNo0edit = "01";

                    KykSyouhnCommonParam pKykSyouhnCommonParamSyoriGo;
                    IT_KykSyouhnRireki syouhnRirekiForCal;

                    if (Long.parseLong(khTtdkRireki.getHenkousikibetukey()) >= Long.parseLong(kykSyouhn.getHenkousikibetukey())) {
                        pKykSyouhnCommonParamSyoriGo = kykSyouhn;
                        syouhnRirekiForCal = null;
                    }
                    else {
                        syouhnRirekiForCal = pKhHokenKykIdouFileTyusyutuDao.
                            getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukeyLt(syono, C_SyutkKbn.SYU, khTtdkRireki.getHenkousikibetukey());
                        pKykSyouhnCommonParamSyoriGo = syouhnRirekiForCal;
                    }

                    if (C_SyoriKbn.TMTTKNHANEI.eq(syoriKbn)) {
                        if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pKykSyouhnCommonParamSyoriGo.getTmttknhaibunjyoutai())) {
                            continue;
                        }
                    }

                    IT_KhSisuurendoTmttkn sisuurendoTmttknLatest = pKhHokenKykIdouFileTyusyutuDao.getKhSisuurendoTmttknsBySyono(syono);
                    BizDateYM tmttkntaisyouymLatest = sisuurendoTmttknLatest.getTmttkntaisyouym();

                    List<IT_KhSisuurendoTmttkn> sisuurendoTmttknList = pKhHokenKykIdouFileTyusyutuDao.
                        getKhSisuurendoTmttknsBySyonoTmttknkouryokukaisiymdGe(syono, tmttkntaisyouymLatest.addYears(-1));

                    IT_KhSisuurendoTmttkn sisuurendoTmttknShoriMae = null;
                    IT_KhSisuurendoTmttkn sisuurendoTmttknShoriGo = null;
                    Integer rennno = new Integer(1);
                    for (int index = 0; index < sisuurendoTmttknList.size(); index++) {
                        if (tmttkntaisyouymLatest.equals(sisuurendoTmttknList.get(index).getTmttkntaisyouym())
                            && rennno.equals(sisuurendoTmttknList.get(index).getRenno())) {
                            sisuurendoTmttknShoriGo = sisuurendoTmttknList.get(index);
                            sisuurendoTmttknShoriMae = sisuurendoTmttknList.get(index + 1);

                            break;
                        }
                    }

                    if (C_SyoriKbn.TMTTKNHANEI.eq(syoriKbn)) {
                        if (sisuurendoTmttknShoriMae.getSisuurendoutmttkngk().
                            equals(sisuurendoTmttknShoriGo.getSisuurendoutmttkngk())) {
                            continue;
                        }
                    }


                    KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                    BizDateYM kijyunYM;


                    BizDate calcKijyunymd = sisuurendoTmttknShoriGo.getTmttknkouryokukaisiymd().addDays(-1);

                    kijyunYM = keisanWKijunYM.exec(kykymd, calcKijyunymd, null, kykKihon.getHrkkaisuu(),
                        pKykSyouhnCommonParamSyoriGo.getKykjyoutai(), pKykSyouhnCommonParamSyoriGo.getSyouhncd(), null);

                    kaiyakuHenreikinDataSksBean =
                        tumitateKinKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, syouhnRirekiForCal,
                            sisuurendoTmttknShoriMae.getTeiritutmttkngk(), sisuurendoTmttknShoriMae.getSisuurendoutmttkngk(),
                            yendthnkUmuFlg);

                    BizCurrency beforeS = pKykSyouhnCommonParamSyoriGo.getKihons();
                    BizCurrency beforeP = pKykSyouhnCommonParamSyoriGo.getHokenryou();
                    BizCurrency beforeV = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency beforeW = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();



                    calcKijyunymd = sisuurendoTmttknShoriGo.getTmttknkouryokukaisiymd();

                    kijyunYM = keisanWKijunYM.exec(kykymd, calcKijyunymd, null, kykKihon.getHrkkaisuu(),
                        pKykSyouhnCommonParamSyoriGo.getKykjyoutai(), pKykSyouhnCommonParamSyoriGo.getSyouhncd(), null);

                    kaiyakuHenreikinDataSksBean =
                        tumitateKinKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, syouhnRirekiForCal,
                            sisuurendoTmttknShoriGo.getTeiritutmttkngk(), sisuurendoTmttknShoriGo.getSisuurendoutmttkngk(),
                            yendthnkUmuFlg);

                    BizCurrency afterS = pKykSyouhnCommonParamSyoriGo.getKihons();
                    BizCurrency afterP = pKykSyouhnCommonParamSyoriGo.getHokenryou();
                    BizCurrency afterV = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency afterW = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();



                    ZT_HknkykIdouInfoTy hknkykIdouInfoTyBefore = new ZT_HknkykIdouInfoTy();


                    hknkykIdouInfoTyBefore.setZtykyktuukasyu(pKykSyouhnCommonParamSyoriGo.getKyktuukasyu().getValue());
                    if (idoubiYmd != null) {
                        hknkykIdouInfoTyBefore.setZtyidouymd(idoubiYmd.toString());
                    }
                    hknkykIdouInfoTyBefore.setZtydatakanrino(dataKanriNo);
                    hknkykIdouInfoTyBefore.setZtyrenno(renNo0edit);
                    if (pKykSyouhnCommonParamSyoriGo.getKykymd() != null) {
                        hknkykIdouInfoTyBefore.setZtykeiyakuymd(pKykSyouhnCommonParamSyoriGo.getKykymd().toString());
                    }
                    hknkykIdouInfoTyBefore.setZtyhhknnen2(pKykSyouhnCommonParamSyoriGo.getHhknnen().toString());
                    hknkykIdouInfoTyBefore.setZtyhhknsei(pKykSyouhnCommonParamSyoriGo.getHhknsei().getValue());
                    hknkykIdouInfoTyBefore.setZtyhknsyukigou(pKykSyouhnCommonParamSyoriGo.getSyouhncd().substring(0, 2));
                    hknkykIdouInfoTyBefore.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                    hknkykIdouInfoTyBefore.setZtyzougenkbn(C_ZougenKbn.GEN.getValue());
                    hknkykIdouInfoTyBefore.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(beforeS.toString())));
                    hknkykIdouInfoTyBefore.setZtyp13(BizNumber.valueOf(new BigDecimal(beforeP.toString())));
                    hknkykIdouInfoTyBefore.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(beforeV.toString())));
                    hknkykIdouInfoTyBefore.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(beforeW.toString())));
                    hknkykIdouInfoTyBefore.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(beforeS.toString())));
                    hknkykIdouInfoTyBefore.setZtyidoup(BizNumber.valueOf(new BigDecimal(beforeP.toString())));
                    hknkykIdouInfoTyBefore.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(BizCurrency.valueOf(0).toString())));
                    hknkykIdouInfoTyBefore.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(BizCurrency.valueOf(0).toString())));
                    hknkykIdouInfoTyBefore.setZtyhknkkn(pKykSyouhnCommonParamSyoriGo.getHknkkn().toString());
                    hknkykIdouInfoTyBefore.setZtyyoteiriritun5(pKykSyouhnCommonParamSyoriGo.getYoteiriritu());
                    hknkykIdouInfoTyBefore.setZtytumitatekinkbn(C_TumitatekinKbn.SISUU.getValue());
                    hknkykIdouInfoTyBefore.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                    if (C_SyoriKbn.TMTTKNHANEI.eq(syoriKbn)) {
                        hknkykIdouInfoTyBefore.setZtyidoujiyuukbnzfi(C_ZfiIdoujiyuuKbn.SISUURNDTMTTKNUPBFR.getValue());
                    }
                    else {
                        hknkykIdouInfoTyBefore.setZtyidoujiyuukbnzfi(C_ZfiIdoujiyuuKbn.SISUURNDTMTTKNUPITNBFR.getValue());
                    }


                    ZT_HknkykIdouInfoTy hknkykIdouInfoTyAfter = new ZT_HknkykIdouInfoTy();


                    hknkykIdouInfoTyAfter.setZtykyktuukasyu(pKykSyouhnCommonParamSyoriGo.getKyktuukasyu().getValue());
                    if (idoubiYmd != null) {
                        hknkykIdouInfoTyAfter.setZtyidouymd(idoubiYmd.toString());
                    }
                    hknkykIdouInfoTyAfter.setZtydatakanrino(dataKanriNo);
                    hknkykIdouInfoTyAfter.setZtyrenno(renNo0edit);
                    if (pKykSyouhnCommonParamSyoriGo.getKykymd() != null) {
                        hknkykIdouInfoTyAfter.setZtykeiyakuymd(pKykSyouhnCommonParamSyoriGo.getKykymd().toString());
                    }
                    hknkykIdouInfoTyAfter.setZtyhhknnen2(pKykSyouhnCommonParamSyoriGo.getHhknnen().toString());
                    hknkykIdouInfoTyAfter.setZtyhhknsei(pKykSyouhnCommonParamSyoriGo.getHhknsei().getValue());
                    hknkykIdouInfoTyAfter.setZtyhknsyukigou(pKykSyouhnCommonParamSyoriGo.getSyouhncd().substring(0, 2));
                    hknkykIdouInfoTyAfter.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                    hknkykIdouInfoTyAfter.setZtyzougenkbn(C_ZougenKbn.ZOU.getValue());
                    hknkykIdouInfoTyAfter.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(afterS.toString())));
                    hknkykIdouInfoTyAfter.setZtyp13(BizNumber.valueOf(new BigDecimal(afterP.toString())));
                    hknkykIdouInfoTyAfter.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(afterV.toString())));
                    hknkykIdouInfoTyAfter.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(afterW.toString())));
                    hknkykIdouInfoTyAfter.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(afterS.toString())));
                    hknkykIdouInfoTyAfter.setZtyidoup(BizNumber.valueOf(new BigDecimal(afterP.toString())));
                    hknkykIdouInfoTyAfter.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(afterV.subtract(beforeV).toString())));
                    hknkykIdouInfoTyAfter.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(afterW.subtract(beforeW).toString())));
                    hknkykIdouInfoTyAfter.setZtyhknkkn(pKykSyouhnCommonParamSyoriGo.getHknkkn().toString());
                    hknkykIdouInfoTyAfter.setZtyyoteiriritun5(pKykSyouhnCommonParamSyoriGo.getYoteiriritu());
                    hknkykIdouInfoTyAfter.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                    if (C_SyoriKbn.TMTTKNHANEI.eq(syoriKbn)) {
                        hknkykIdouInfoTyAfter.setZtyidoujiyuukbnzfi(C_ZfiIdoujiyuuKbn.SISUURNDTMTTKNUPNEW.getValue());
                        hknkykIdouInfoTyAfter.setZtytumitatekinkbn(C_TumitatekinKbn.SISUU.getValue());
                    }
                    else {
                        hknkykIdouInfoTyAfter.setZtyidoujiyuukbnzfi(C_ZfiIdoujiyuuKbn.SISUURNDTMTTKNUPITNNEW.getValue());
                        hknkykIdouInfoTyAfter.setZtytumitatekinkbn(C_TumitatekinKbn.TEIRITU.getValue());
                    }



                    BizPropertyInitializer.initialize(hknkykIdouInfoTyBefore);
                    hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTyBefore);

                    BizPropertyInitializer.initialize(hknkykIdouInfoTyAfter);
                    hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTyAfter);

                    syoriKensuu = syoriKensuu + 2;
                }

                else if (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(gyoumuKousinKinou) &&
                    C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(syoriKbn))  {

                    renNo0edit = "01";

                    KykSyouhnCommonParam pKykSyouhnCommonParamItenji;

                    if (Long.parseLong(khTtdkRireki.getHenkousikibetukey()) >= Long.parseLong(kykSyouhn.getHenkousikibetukey())) {
                        pKykSyouhnCommonParamItenji = kykSyouhn;
                    }
                    else {
                        pKykSyouhnCommonParamItenji = pKhHokenKykIdouFileTyusyutuDao.
                            getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukeyLt(syono, C_SyutkKbn.SYU, khTtdkRireki.getHenkousikibetukey());
                    }

                    IT_KhHenkouRireki henkouRireki = pKhHokenKykIdouFileTyusyutuDao
                        .getKykSyouhnRirekiBySyonoSyutkkbnHenkousikibetukey(syono, khTtdkRireki.getHenkousikibetukey());

                    GetKhHenkouRireki getKhHenkouRireki = SWAKInjector.getInstance(GetKhHenkouRireki.class);

                    GetKhSisuurendoTmttknTblSakujyoBean getKhHenkouRirekInputBean = SWAKInjector.getInstance(GetKhSisuurendoTmttknTblSakujyoBean.class);
                    getKhHenkouRirekInputBean.setKhHenkouRireki(henkouRireki);

                    GetKhSisuurendoTmttknTblBean getKhHenkouRirekOutputBean = getKhHenkouRireki.getKhSisuurendoTmttknTblSakujyo(getKhHenkouRirekInputBean);

                    IT_KhSisuurendoTmttkn sisuurendoTmttknShoriMae = getKhHenkouRirekOutputBean.getKhSisuurendoTmttkn();

                    IT_KhSisuurendoTmttkn sisuurendoTmttknShoriGo = searchSisuurendoTmttknTblForTetudukiji(khTtdkRireki);



                    KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
                    BizDateYM kijyunYM;


                    BizDate calcKijyunymd = sisuurendoTmttknShoriMae.getTmttknkouryokukaisiymd();

                    kijyunYM = keisanWKijunYM.exec(kykymd, calcKijyunymd, null, kykKihon.getHrkkaisuu(),
                        pKykSyouhnCommonParamItenji.getKykjyoutai(), pKykSyouhnCommonParamItenji.getSyouhncd(), null);

                    kaiyakuHenreikinDataSksBean =
                        tumitateKinKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, kykKihon, pKykSyouhnCommonParamItenji,
                            sisuurendoTmttknShoriMae.getTmttkntaisyouym(), sisuurendoTmttknShoriMae.getTeiritutmttkngk(),
                            sisuurendoTmttknShoriMae.getSisuurendoutmttkngk(), sisuurendoTmttknShoriMae.getTmttknhaneisisuu(), yendthnkUmuFlg);

                    BizCurrency beforeS = pKykSyouhnCommonParamItenji.getKihons();
                    BizCurrency beforeP = pKykSyouhnCommonParamItenji.getHokenryou();
                    BizCurrency beforeV = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency beforeW = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();



                    calcKijyunymd = sisuurendoTmttknShoriMae.getTmttknkouryokukaisiymd().addDays(-1);

                    kijyunYM = keisanWKijunYM.exec(kykymd, calcKijyunymd, null, kykKihon.getHrkkaisuu(),
                        pKykSyouhnCommonParamItenji.getKykjyoutai(), pKykSyouhnCommonParamItenji.getSyouhncd(), null);

                    kaiyakuHenreikinDataSksBean =
                        tumitateKinKaiyakuHenreikinDataSks(syono, calcKijyunymd, kijyunYM, kykKihon, pKykSyouhnCommonParamItenji,
                            sisuurendoTmttknShoriGo.getTmttkntaisyouym(),sisuurendoTmttknShoriGo.getTeiritutmttkngk(),
                            sisuurendoTmttknShoriGo.getSisuurendoutmttkngk(), sisuurendoTmttknShoriGo.getTmttknhaneisisuu(), yendthnkUmuFlg);

                    BizCurrency afterS = pKykSyouhnCommonParamItenji.getKihons();
                    BizCurrency afterP = pKykSyouhnCommonParamItenji.getHokenryou();
                    BizCurrency afterV = kaiyakuHenreikinDataSksBean.getSsyPTumitatekin();
                    BizCurrency afterW = kaiyakuHenreikinDataSksBean.getSsyKaiyakuhr();



                    ZT_HknkykIdouInfoTy hknkykIdouInfoTyBefore = new ZT_HknkykIdouInfoTy();


                    hknkykIdouInfoTyBefore.setZtykyktuukasyu(pKykSyouhnCommonParamItenji.getKyktuukasyu().getValue());
                    if (idoubiYmd != null) {
                        hknkykIdouInfoTyBefore.setZtyidouymd(idoubiYmd.toString());
                    }
                    hknkykIdouInfoTyBefore.setZtyidoujiyuukbnzfi(C_ZfiIdoujiyuuKbn.SISUURNDTMTTKNUPITNBFRTRKS.getValue());
                    hknkykIdouInfoTyBefore.setZtydatakanrino(dataKanriNo);
                    hknkykIdouInfoTyBefore.setZtyrenno(renNo0edit);
                    if (pKykSyouhnCommonParamItenji.getKykymd() != null) {
                        hknkykIdouInfoTyBefore.setZtykeiyakuymd(pKykSyouhnCommonParamItenji.getKykymd().toString());
                    }
                    hknkykIdouInfoTyBefore.setZtyhhknnen2(pKykSyouhnCommonParamItenji.getHhknnen().toString());
                    hknkykIdouInfoTyBefore.setZtyhhknsei(pKykSyouhnCommonParamItenji.getHhknsei().getValue());
                    hknkykIdouInfoTyBefore.setZtyhknsyukigou(pKykSyouhnCommonParamItenji.getSyouhncd().substring(0, 2));
                    hknkykIdouInfoTyBefore.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                    hknkykIdouInfoTyBefore.setZtyzougenkbn(C_ZougenKbn.ZOU.getValue());
                    hknkykIdouInfoTyBefore.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(beforeS.toString())));
                    hknkykIdouInfoTyBefore.setZtyp13(BizNumber.valueOf(new BigDecimal(beforeP.toString())));
                    hknkykIdouInfoTyBefore.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(beforeV.toString())));
                    hknkykIdouInfoTyBefore.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(beforeW.toString())));
                    hknkykIdouInfoTyBefore.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(beforeS.toString())));
                    hknkykIdouInfoTyBefore.setZtyidoup(BizNumber.valueOf(new BigDecimal(beforeP.toString())));
                    hknkykIdouInfoTyBefore.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(BizCurrency.valueOf(0).toString())));
                    hknkykIdouInfoTyBefore.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(BizCurrency.valueOf(0).toString())));
                    hknkykIdouInfoTyBefore.setZtyhknkkn(pKykSyouhnCommonParamItenji.getHknkkn().toString());
                    hknkykIdouInfoTyBefore.setZtyyoteiriritun5(pKykSyouhnCommonParamItenji.getYoteiriritu());
                    hknkykIdouInfoTyBefore.setZtytumitatekinkbn(C_TumitatekinKbn.TEIRITU.getValue());
                    hknkykIdouInfoTyBefore.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());

                    ZT_HknkykIdouInfoTy hknkykIdouInfoTyAfter = new ZT_HknkykIdouInfoTy();


                    hknkykIdouInfoTyAfter.setZtykyktuukasyu(pKykSyouhnCommonParamItenji.getKyktuukasyu().getValue());
                    if (idoubiYmd != null) {
                        hknkykIdouInfoTyAfter.setZtyidouymd(idoubiYmd.toString());
                    }
                    hknkykIdouInfoTyAfter.setZtyidoujiyuukbnzfi(C_ZfiIdoujiyuuKbn.SISUURNDTMTTKNUPITNNEWTRKS.getValue());
                    hknkykIdouInfoTyAfter.setZtydatakanrino(dataKanriNo);
                    hknkykIdouInfoTyAfter.setZtyrenno(renNo0edit);
                    if (pKykSyouhnCommonParamItenji.getKykymd() != null) {
                        hknkykIdouInfoTyAfter.setZtykeiyakuymd(pKykSyouhnCommonParamItenji.getKykymd().toString());
                    }
                    hknkykIdouInfoTyAfter.setZtyhhknnen2(pKykSyouhnCommonParamItenji.getHhknnen().toString());
                    hknkykIdouInfoTyAfter.setZtyhhknsei(pKykSyouhnCommonParamItenji.getHhknsei().getValue());
                    hknkykIdouInfoTyAfter.setZtyhknsyukigou(pKykSyouhnCommonParamItenji.getSyouhncd().substring(0, 2));
                    hknkykIdouInfoTyAfter.setZtyaisyoumeikbn(aisyoumeiKbn.getValue());
                    hknkykIdouInfoTyAfter.setZtyzougenkbn(C_ZougenKbn.GEN.getValue());
                    hknkykIdouInfoTyAfter.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(afterS.toString())));
                    hknkykIdouInfoTyAfter.setZtyp13(BizNumber.valueOf(new BigDecimal(afterP.toString())));
                    hknkykIdouInfoTyAfter.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(afterV.toString())));
                    hknkykIdouInfoTyAfter.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(afterW.toString())));
                    hknkykIdouInfoTyAfter.setZtyidouhokenkngk(BizNumber.valueOf(new BigDecimal(afterS.toString())));
                    hknkykIdouInfoTyAfter.setZtyidoup(BizNumber.valueOf(new BigDecimal(afterP.toString())));
                    hknkykIdouInfoTyAfter.setZtyidouptumitatekin(BizNumber.valueOf(new BigDecimal(beforeV.subtract(afterV).toString())));
                    hknkykIdouInfoTyAfter.setZtyidoukiykhnrikn(BizNumber.valueOf(new BigDecimal(beforeW.subtract(afterW).toString())));
                    hknkykIdouInfoTyAfter.setZtyhknkkn(pKykSyouhnCommonParamItenji.getHknkkn().toString());
                    hknkykIdouInfoTyAfter.setZtyyoteiriritun5(pKykSyouhnCommonParamItenji.getYoteiriritu());
                    hknkykIdouInfoTyAfter.setZtytumitatekinkbn(C_TumitatekinKbn.SISUU.getValue());
                    hknkykIdouInfoTyAfter.setZtyharaikatakbnkykidou(kykIdouHaraikataKbn.getValue());


                    BizPropertyInitializer.initialize(hknkykIdouInfoTyBefore);
                    hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTyBefore);

                    BizPropertyInitializer.initialize(hknkykIdouInfoTyAfter);
                    hknkykIdouInfoTyentityInserter.add(hknkykIdouInfoTyAfter);

                    syoriKensuu = syoriKensuu + 2;

                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private KaiyakuHenreikinDataSksBean kaiyakuHenreikinDataSks(
        String pSyono, BizDate pCalcKijyunymd, BizDateYM pKijyunYM, IT_KykSyouhnRireki pKykSyouhnRireki,
        C_UmuKbn pYendthnkUmuFlg) {

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);

        C_ErrorKbn errorKbn = keisanWExt.exec(pSyono, pCalcKijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new CommonBizAppException("解約返戻金計算拡張情報作成処理　　対象証券番号：" + pSyono);
        }

        KeisanWExtBean keisanWExtBean = keisanWExt.getKeisanWExtBean();

        if (pKykSyouhnRireki != null) {

            keisanWExtBean.setSyouhncd(pKykSyouhnRireki.getSyouhncd());
            keisanWExtBean.setSyouhnsdno(pKykSyouhnRireki.getSyouhnsdno());
            keisanWExtBean.setRyouritusdno(pKykSyouhnRireki.getRyouritusdno());
            keisanWExtBean.setYoteiriritu(pKykSyouhnRireki.getYoteiriritu());
            keisanWExtBean.setHknkknsmnkbn(pKykSyouhnRireki.getHknkknsmnkbn());
            keisanWExtBean.setHknkkn(pKykSyouhnRireki.getHknkkn());
            keisanWExtBean.setHrkkkn(pKykSyouhnRireki.getHrkkkn());
            keisanWExtBean.setHhknnen(pKykSyouhnRireki.getHhknnen());
            keisanWExtBean.setHhknsei(pKykSyouhnRireki.getHhknsei());
            keisanWExtBean.setKihons(pKykSyouhnRireki.getKihons());
            keisanWExtBean.setHokenryou(pKykSyouhnRireki.getHokenryou());
            keisanWExtBean.setKykymd(pKykSyouhnRireki.getKykymd());
            keisanWExtBean.setTuukasyu(pKykSyouhnRireki.getKyktuukasyu());
            keisanWExtBean.setKyksjkkktyouseiriritu(pKykSyouhnRireki.getKyksjkkktyouseiriritu());
            keisanWExtBean.setTumitateriritu(pKykSyouhnRireki.getTumitateriritu());
            keisanWExtBean.setYendthnkymd(pKykSyouhnRireki.getYendthnkymd());
            keisanWExtBean.setDai1hknkkn(pKykSyouhnRireki.getDai1hknkkn());
            keisanWExtBean.setKykJyoutai(pKykSyouhnRireki.getKykjyoutai());

            if (C_UmuKbn.ARI.eq(pYendthnkUmuFlg)) {

                GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
                getSjkkktyouseiyourirituBean.setSyouhncd(pKykSyouhnRireki.getSyouhncd());
                getSjkkktyouseiyourirituBean.setKijyunymd(pCalcKijyunymd);
                getSjkkktyouseiyourirituBean.setHknkkn(pKykSyouhnRireki.getHknkkn());

                GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

                C_ErrorKbn sjkkkTsyRirituKekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                if (C_ErrorKbn.ERROR.eq(sjkkkTsyRirituKekkaKbn)) {

                    throw new CommonBizAppException("市場価格調整用利率取得　　対象証券番号：" + pSyono);
                }

                keisanWExtBean.setKaiyakusjkkktyouseiriritu(getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu());
            }
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(keisanWExtBean.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (BizDateUtil.calcDifferenceMonths(pKijyunYM, keisanWExtBean.getTmttkntaisyouym()) > 12) {
                keisanWExtBean = hotenSisuurendouTmttkngkByTmttknmihanei(pSyono, pKijyunYM, keisanWExtBean);
            }
        }

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        C_ErrorKbn keisanWErrorKbn = keisanW.exec(pCalcKijyunymd, pKijyunYM, keisanWExtBean);

        if (C_ErrorKbn.ERROR.eq(keisanWErrorKbn)) {

            throw new CommonBizAppException("解約返戻金計算処理　　対象証券番号：" + pSyono);
        }

        KaiyakuHenreikinDataSksBean kaiyakuHenreikinDataSksBean =
            SWAKInjector.getInstance(KaiyakuHenreikinDataSksBean.class);

        kaiyakuHenreikinDataSksBean.setSsyPTumitatekin(keisanW.getV());
        kaiyakuHenreikinDataSksBean.setSsyKaiyakuhr(keisanW.getW());
        kaiyakuHenreikinDataSksBean.setSsyTeirituTmttkngk(keisanW.getTeirituTmttkngk());
        kaiyakuHenreikinDataSksBean.setSsySisuuRendouTmttkngk(keisanW.getSisuurendouTmttkngk());

        return kaiyakuHenreikinDataSksBean;
    }

    private KeisanWExtBean hotenSisuurendouTmttkngkByTmttknmihanei(String pSyono, BizDateYM pKijyunYM, KeisanWExtBean pKeisanWExtBean) {


        BizDate kijunYmlastDay = pKijyunYM.getLastDay();
        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
        BizDate tyokuzenKykoutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN, pKeisanWExtBean.getKykymd(),
            C_Hrkkaisuu.NEN, kijunYmlastDay);

        BizDateYM tyokuzenKykoutouYm = tyokuzenKykoutouYmd.getBizDateYM();


        KeisanSisuuRendouNkTmttknOverNnd keisanSisuuRendouNkTmttknOverNnd = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttknOverNnd.class);

        C_ErrorKbn KeisanSisuuRendouNkTmttknOverNndErrorKbn = keisanSisuuRendouNkTmttknOverNnd.exec(
            pKeisanWExtBean.getKykymd(),
            pKeisanWExtBean.getHknkkn(),
            pKeisanWExtBean.getTeikishrtkykhukaumu(),
            pKeisanWExtBean.getTuukasyu(),
            tyokuzenKykoutouYmd,
            tyokuzenKykoutouYm,
            pKeisanWExtBean.getTmttkntaisyouym(),
            pKeisanWExtBean.getTumitateriritu(),
            pKeisanWExtBean.getTeiritutmttkngk(),
            pKeisanWExtBean.getSisuurendoutmttkngk());

        if (C_ErrorKbn.ERROR.eq(KeisanSisuuRendouNkTmttknOverNndErrorKbn)) {

            throw new CommonBizAppException("指数連動年金積立金計算(年度越)処理　　対象証券番号：" + pSyono);
        }

        pKeisanWExtBean.setTmttkntaisyouym(tyokuzenKykoutouYm);
        pKeisanWExtBean.setTeiritutmttkngk(keisanSisuuRendouNkTmttknOverNnd.getTeiritutmttkngk());
        pKeisanWExtBean.setSisuurendoutmttkngk(keisanSisuuRendouNkTmttknOverNnd.getSisuurendoutmttkngk());

        return pKeisanWExtBean;
    }

    private SisuuTeirituKinngakuKsBean sisuuTeirituKinngakuKs(
        BizNumber pSisuuWariai, BizCurrency pKihonS, BizCurrency pHokenryou, BizCurrency pKiykHnrikn) {

        SisuuTeirituKinngakuKsBean sisuuTeirituKinngakuKsBean = SWAKInjector
            .getInstance(SisuuTeirituKinngakuKsBean.class);

        BizNumber sisuuWariai = pSisuuWariai;
        BizCurrency sisuuKihonS = pKihonS.multiply(sisuuWariai.divide(100)).toValidValue(RoundingMode.HALF_UP);
        BizCurrency sisuuHokenryou = pHokenryou.multiply(sisuuWariai.divide(100)).toValidValue(RoundingMode.HALF_UP);
        BizCurrency sisuuKiykHnrikn = pKiykHnrikn.multiply(sisuuWariai.divide(100)).toValidValue(RoundingMode.HALF_UP);
        BizCurrency teirituKihonS = pKihonS.subtract(sisuuKihonS);
        BizCurrency teirituHokenryou = pHokenryou.subtract(sisuuHokenryou);
        BizCurrency teirituKiykHnrikn = pKiykHnrikn.subtract(sisuuKiykHnrikn);

        sisuuTeirituKinngakuKsBean.setSisuuKihonS(sisuuKihonS);
        sisuuTeirituKinngakuKsBean.setSisuuP(sisuuHokenryou);
        sisuuTeirituKinngakuKsBean.setSisuuKaiyakuhr(sisuuKiykHnrikn);
        sisuuTeirituKinngakuKsBean.setTeirituKihonS(teirituKihonS);
        sisuuTeirituKinngakuKsBean.setTeirituP(teirituHokenryou);
        sisuuTeirituKinngakuKsBean.setTeirituKaiyakuhr(teirituKiykHnrikn);

        return sisuuTeirituKinngakuKsBean;
    }

    private KaiyakuHenreikinDataSksBean tumitateKinKaiyakuHenreikinDataSks(
        String pSyono,
        BizDate pCalcKijyunymd,
        BizDateYM pKijyunYM,
        IT_KykSyouhnRireki pKykSyouhnRireki,
        BizCurrency pTeiritutmttkngk,
        BizCurrency pSisuurendoutmttkngk,
        C_UmuKbn pYendthnkUmuFlg) {

        KeisanWExt keisanWExt = SWAKInjector.getInstance(KeisanWExt.class);

        C_ErrorKbn errorKbn = keisanWExt.exec(pSyono, pCalcKijyunymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            throw new CommonBizAppException("解約返戻金計算拡張情報作成処理　　対象証券番号：" + pSyono);
        }

        KeisanWExtBean keisanWExtBean = keisanWExt.getKeisanWExtBean();

        if (pKykSyouhnRireki != null) {

            keisanWExtBean.setSyouhncd(pKykSyouhnRireki.getSyouhncd());
            keisanWExtBean.setSyouhnsdno(pKykSyouhnRireki.getSyouhnsdno());
            keisanWExtBean.setRyouritusdno(pKykSyouhnRireki.getRyouritusdno());
            keisanWExtBean.setYoteiriritu(pKykSyouhnRireki.getYoteiriritu());
            keisanWExtBean.setHknkknsmnkbn(pKykSyouhnRireki.getHknkknsmnkbn());
            keisanWExtBean.setHknkkn(pKykSyouhnRireki.getHknkkn());
            keisanWExtBean.setHrkkkn(pKykSyouhnRireki.getHrkkkn());
            keisanWExtBean.setHhknnen(pKykSyouhnRireki.getHhknnen());
            keisanWExtBean.setHhknsei(pKykSyouhnRireki.getHhknsei());
            keisanWExtBean.setKihons(pKykSyouhnRireki.getKihons());
            keisanWExtBean.setHokenryou(pKykSyouhnRireki.getHokenryou());
            keisanWExtBean.setKykymd(pKykSyouhnRireki.getKykymd());
            keisanWExtBean.setTuukasyu(pKykSyouhnRireki.getKyktuukasyu());
            keisanWExtBean.setKyksjkkktyouseiriritu(pKykSyouhnRireki.getKyksjkkktyouseiriritu());
            keisanWExtBean.setTeiritutmttkngk(pTeiritutmttkngk);
            keisanWExtBean.setSisuurendoutmttkngk(pSisuurendoutmttkngk);
            keisanWExtBean.setTumitateriritu(pKykSyouhnRireki.getTumitateriritu());
            keisanWExtBean.setYendthnkymd(pKykSyouhnRireki.getYendthnkymd());
            keisanWExtBean.setDai1hknkkn(pKykSyouhnRireki.getDai1hknkkn());
            keisanWExtBean.setKykJyoutai(pKykSyouhnRireki.getKykjyoutai());

            if (C_UmuKbn.ARI.eq(pYendthnkUmuFlg)) {

                GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
                getSjkkktyouseiyourirituBean.setSyouhncd(pKykSyouhnRireki.getSyouhncd());
                getSjkkktyouseiyourirituBean.setKijyunymd(pCalcKijyunymd);
                getSjkkktyouseiyourirituBean.setHknkkn(pKykSyouhnRireki.getHknkkn());

                GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

                C_ErrorKbn sjkkkTsyRirituKekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

                if (C_ErrorKbn.ERROR.eq(sjkkkTsyRirituKekkaKbn)) {

                    throw new CommonBizAppException("市場価格調整用利率取得処理　　対象証券番号：" + pSyono);
                }

                keisanWExtBean.setKaiyakusjkkktyouseiriritu(getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu());
            }
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(keisanWExtBean.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
            if (BizDateUtil.calcDifferenceMonths(pKijyunYM, keisanWExtBean.getTmttkntaisyouym()) > 12) {
                keisanWExtBean = hotenSisuurendouTmttkngkByTmttknmihanei(pSyono, pKijyunYM, keisanWExtBean);
            }
        }

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        C_ErrorKbn keisanWErrorKbn = keisanW.exec(pCalcKijyunymd, pKijyunYM, keisanWExtBean);

        if (C_ErrorKbn.ERROR.eq(keisanWErrorKbn)) {

            throw new CommonBizAppException("解約返戻金計算処理　　対象証券番号：" + pSyono);
        }

        KaiyakuHenreikinDataSksBean kaiyakuHenreikinDataSksBean =
            SWAKInjector.getInstance(KaiyakuHenreikinDataSksBean.class);

        kaiyakuHenreikinDataSksBean.setSsyPTumitatekin(keisanW.getV());
        kaiyakuHenreikinDataSksBean.setSsyKaiyakuhr(keisanW.getW());
        kaiyakuHenreikinDataSksBean.setSsyTeirituTmttkngk(keisanW.getTeirituTmttkngk());
        kaiyakuHenreikinDataSksBean.setSsySisuuRendouTmttkngk(keisanW.getSisuurendouTmttkngk());

        return kaiyakuHenreikinDataSksBean;
    }

    private KaiyakuHenreikinDataSksBean tumitateKinKaiyakuHenreikinDataSks(
        String pSyono,
        BizDate pCalcKijyunymd,
        BizDateYM pKijyunYM,
        IT_KykKihon pKykkihon,
        KykSyouhnCommonParam pKykSyouhnPram,
        BizDateYM pTmttkntaisyouym,
        BizCurrency pTeiritutmttkngk,
        BizCurrency pSisuurendoutmttkngk,
        BizNumber pTmttknhaneisisuu,
        C_UmuKbn pYendthnkUmuFlg) {

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);


        keisanWExtBean.setSyouhncd(pKykSyouhnPram.getSyouhncd());
        keisanWExtBean.setSyouhnsdno(pKykSyouhnPram.getSyouhnsdno());
        keisanWExtBean.setRyouritusdno(pKykSyouhnPram.getRyouritusdno());
        keisanWExtBean.setYoteiriritu(pKykSyouhnPram.getYoteiriritu());
        keisanWExtBean.setHrkkaisuu(pKykkihon.getHrkkaisuu());
        keisanWExtBean.setHknkknsmnkbn(pKykSyouhnPram.getHknkknsmnkbn());
        keisanWExtBean.setHrkkknsmnkbn(pKykSyouhnPram.getHrkkknsmnkbn());
        keisanWExtBean.setHknkkn(pKykSyouhnPram.getHknkkn());
        keisanWExtBean.setHrkkkn(pKykSyouhnPram.getHrkkkn());
        keisanWExtBean.setHhknnen(pKykSyouhnPram.getHhknnen());
        keisanWExtBean.setHhknsei(pKykSyouhnPram.getHhknsei());
        keisanWExtBean.setKihons(pKykSyouhnPram.getKihons());
        keisanWExtBean.setHokenryou(pKykSyouhnPram.getHokenryou());
        keisanWExtBean.setKykymd(pKykSyouhnPram.getKykymd());
        keisanWExtBean.setTuukasyu(pKykSyouhnPram.getKyktuukasyu());
        keisanWExtBean.setKyksjkkktyouseiriritu(pKykSyouhnPram.getKyksjkkktyouseiriritu());

        GetSjkkktyouseiyourirituBean getSjkkktyouseiyourirituBean = SWAKInjector.getInstance(GetSjkkktyouseiyourirituBean.class);
        getSjkkktyouseiyourirituBean.setSyouhncd(pKykSyouhnPram.getSyouhncd());
        getSjkkktyouseiyourirituBean.setKijyunymd(pCalcKijyunymd);
        getSjkkktyouseiyourirituBean.setHknkkn(pKykSyouhnPram.getHknkkn());


        GetSjkkktyouseiyouriritu getSjkkktyouseiyouriritu = SWAKInjector.getInstance(GetSjkkktyouseiyouriritu.class);

        C_ErrorKbn sjkkkTsyRirituKekkaKbn = getSjkkktyouseiyouriritu.exec(getSjkkktyouseiyourirituBean);

        if (C_ErrorKbn.ERROR.eq(sjkkkTsyRirituKekkaKbn)) {

            throw new CommonBizAppException("市場価格調整用利率取得処理　　対象証券番号：" + pSyono);
        }

        keisanWExtBean.setKaiyakusjkkktyouseiriritu(getSjkkktyouseiyouriritu.getSjkkktyouseiyouriritu());

        keisanWExtBean.setTmttkntaisyouym(pTmttkntaisyouym);
        keisanWExtBean.setTeiritutmttkngk(pTeiritutmttkngk);
        keisanWExtBean.setSisuurendoutmttkngk(pSisuurendoutmttkngk);
        keisanWExtBean.setTmttknhaneisisuu(pTmttknhaneisisuu);
        keisanWExtBean.setTumitateriritu(pKykSyouhnPram.getTumitateriritu());
        keisanWExtBean.setFstpryosyuymd(pKykkihon.getFstpnyknymd());
        keisanWExtBean.setYoteirrthendohosyurrt(pKykSyouhnPram.getYoteirrthendohosyurrt());
        keisanWExtBean.setYendthnkymd(pKykSyouhnPram.getYendthnkymd());
        keisanWExtBean.setDai1hknkkn(pKykSyouhnPram.getDai1hknkkn());
        keisanWExtBean.setKykJyoutai(pKykSyouhnPram.getKykjyoutai());

        KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        C_ErrorKbn keisanWErrorKbn = keisanW.exec(pCalcKijyunymd, pKijyunYM, keisanWExtBean);

        if (C_ErrorKbn.ERROR.eq(keisanWErrorKbn)) {

            throw new CommonBizAppException("解約返戻金計算処理　　対象証券番号：" + pSyono);
        }

        KaiyakuHenreikinDataSksBean kaiyakuHenreikinDataSksBean =
            SWAKInjector.getInstance(KaiyakuHenreikinDataSksBean.class);

        kaiyakuHenreikinDataSksBean.setSsyPTumitatekin(keisanW.getV());
        kaiyakuHenreikinDataSksBean.setSsyKaiyakuhr(keisanW.getW());
        kaiyakuHenreikinDataSksBean.setSsyTeirituTmttkngk(keisanW.getTeirituTmttkngk());
        kaiyakuHenreikinDataSksBean.setSsySisuuRendouTmttkngk(keisanW.getSisuurendouTmttkngk());

        return kaiyakuHenreikinDataSksBean;
    }

    private KaiyakuHenreikinDataSksBean kykYmdHanteiKaiyakuHenreikinDataSks(
        String pSyono,
        BizDate pCalcKijyunymd,
        BizDateYM pKijyunYM,
        IT_KykSyouhnRireki pKykSyouhnRireki,
        BizDate pKykYmd,
        BizDate pSyoriYmd,
        C_UmuKbn pYendthnkUmuFlg) {

        if ((BizDateUtil.compareYmd(pKykYmd, pSyoriYmd) == BizDateUtil.COMPARE_EQUAL)
            || (BizDateUtil.compareYmd(pKykYmd, pSyoriYmd) == BizDateUtil.COMPARE_LESSER)) {
            return kaiyakuHenreikinDataSks(pSyono, pCalcKijyunymd, pKijyunYM, pKykSyouhnRireki, pYendthnkUmuFlg);
        }
        return kykYmdMaeKaiyakuHenreikinDataSks(pSyono, pCalcKijyunymd);
    }

    private KaiyakuHenreikinDataSksBean kykYmdMaeKaiyakuHenreikinDataSks(
        String pSyono, BizDate pCalcKijyunymd) {

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(pSyono,
            pCalcKijyunymd);

        BizCurrency ssyPTumitatekin = sisurendoTmttknInfoBean.getTeirituTmttknGK().add(
            sisurendoTmttknInfoBean.getSisuuRendouTmttknGK());

        KaiyakuHenreikinDataSksBean kaiyakuHenreikinDataSksBean = SWAKInjector
            .getInstance(KaiyakuHenreikinDataSksBean.class);

        kaiyakuHenreikinDataSksBean.setSsyPTumitatekin(ssyPTumitatekin);
        kaiyakuHenreikinDataSksBean.setSsyKaiyakuhr(ssyPTumitatekin);
        kaiyakuHenreikinDataSksBean.setSsyTeirituTmttkngk(sisurendoTmttknInfoBean.getTeirituTmttknGK());
        kaiyakuHenreikinDataSksBean.setSsySisuuRendouTmttkngk(sisurendoTmttknInfoBean.getSisuuRendouTmttknGK());

        return kaiyakuHenreikinDataSksBean;
    }

    private IT_KhSisuurendoTmttkn searchSisuurendoTmttknTblForTetudukiji(IT_KhTtdkRireki pKhTtdkRireki) {

        KhHokenKykIdouFileTyusyutuDao pKhHokenKykIdouFileTyusyutuDao = SWAKInjector
            .getInstance(KhHokenKykIdouFileTyusyutuDao.class);

        List<IT_KhTtdkRireki> allTtdkRirekiList =
            pKhHokenKykIdouFileTyusyutuDao.getKhTtdkRirekiForTotugouBySyono(pKhTtdkRireki.getSyono());

        List<IT_KhSisuurendoTmttkn> allSisuurendoTmttknList = pKhHokenKykIdouFileTyusyutuDao.
            getKhSisuurendoTmttknsAllBySyono(pKhTtdkRireki.getSyono());


        int tmttknIdx = 0;

        for (IT_KhTtdkRireki ttdkRireki : allTtdkRirekiList) {
            if (pKhTtdkRireki.getHenkousikibetukey().equals(ttdkRireki.getHenkousikibetukey())) {
                break;
            }

            if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(ttdkRireki.getGyoumuKousinKinou())
                || IKhozenCommonConstants.KINOUID_GENGAKU.equals((ttdkRireki.getGyoumuKousinKinou()))
                || IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(ttdkRireki.getGyoumuKousinKinou())) {

                tmttknIdx = tmttknIdx + 1;
            }
        }

        return allSisuurendoTmttknList.get(tmttknIdx);
    }

    public class HeijunbaraiJikkouRirekiHensyuu {

        public Long exec(IT_KhTtdkRireki pKhTtdkRireki, MultipleEntityInserter pMultipleEntityInserter) {

            Long count = 0L;

            KhHokenKykIdouFileTyusyutuDao khHokenKykIdouFileTyusyutuDao = SWAKInjector
                .getInstance(KhHokenKykIdouFileTyusyutuDao.class);

            List<IT_HokenKykIdouRireki> hokenKykIdouRirekiList =
                khHokenKykIdouFileTyusyutuDao.getHokenKykIdouRirekiBySyonoHenkouSikibetukey(
                    pKhTtdkRireki.getSyono(), pKhTtdkRireki.getHenkousikibetukey());

            if (hokenKykIdouRirekiList.size() > 0) {
                KhHokenKykIdouFileTyusyutuCommon khHokenKykIdouFileTyusyutuCommon =
                    new KhHokenKykIdouFileTyusyutuCommon();

                String dataKanriNo = khHokenKykIdouFileTyusyutuCommon.scramble(hokenKykIdouRirekiList.get(0).getSyono());

                for (int i = 0; i < hokenKykIdouRirekiList.size(); i++) {

                    count += 1;

                    ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();
                    hknkykIdouInfoTy.setZtykyktuukasyu(hokenKykIdouRirekiList.get(i).getKyktuukasyu().getValue());
                    hknkykIdouInfoTy.setZtyidouymd(hokenKykIdouRirekiList.get(i).getIdouymd().toString());
                    hknkykIdouInfoTy.setZtyidoujiyuukbnzfi(hokenKykIdouRirekiList.get(i).getIdoujiyuukbn().getValue());
                    hknkykIdouInfoTy.setZtydatakanrino(dataKanriNo);
                    hknkykIdouInfoTy.setZtyrenno(
                        BizUtil.zeroNum(String.valueOf(hokenKykIdouRirekiList.get(i).getTtdkrenno()), 2, 0));
                    hknkykIdouInfoTy.setZtykeiyakuymd(hokenKykIdouRirekiList.get(i).getKykymd().toString());
                    hknkykIdouInfoTy.setZtyhhknnen2(hokenKykIdouRirekiList.get(i).getHhknnen().toString());
                    hknkykIdouInfoTy.setZtyhhknsei(hokenKykIdouRirekiList.get(i).getHhknsei().getValue());
                    hknkykIdouInfoTy.setZtyhknsyukigou(hokenKykIdouRirekiList.get(i).getHknsyukigou());
                    hknkykIdouInfoTy.setZtyaisyoumeikbn(hokenKykIdouRirekiList.get(i).getAisyoumeikbn().getValue());
                    hknkykIdouInfoTy.setZtyzougenkbn(hokenKykIdouRirekiList.get(i).getZougenkbn().getValue());
                    hknkykIdouInfoTy.setZtyhokenkngk13(
                        BizNumber.valueOf(new BigDecimal(hokenKykIdouRirekiList.get(i).getHokenkngk().toString())));
                    hknkykIdouInfoTy.setZtyp13(
                        BizNumber.valueOf(new BigDecimal(hokenKykIdouRirekiList.get(i).getHokenryou().toString())));
                    hknkykIdouInfoTy.setZtyptumitatekin13(
                        BizNumber.valueOf(new BigDecimal(hokenKykIdouRirekiList.get(i).getPtumitatekin().toString())));
                    hknkykIdouInfoTy.setZtykiykhnrikn13(
                        BizNumber.valueOf(new BigDecimal(hokenKykIdouRirekiList.get(i).getKaiyakuhrgoukei().toString())));
                    hknkykIdouInfoTy.setZtyidouhokenkngk(
                        BizNumber.valueOf(new BigDecimal(hokenKykIdouRirekiList.get(i).getIdouhokenkngk().toString())));
                    hknkykIdouInfoTy.setZtyidoup(
                        BizNumber.valueOf(new BigDecimal(hokenKykIdouRirekiList.get(i).getIdoup().toString())));
                    hknkykIdouInfoTy.setZtyidouptumitatekin(
                        BizNumber.valueOf(new BigDecimal(hokenKykIdouRirekiList.get(i).getIdouptumitatekin().toString())));
                    hknkykIdouInfoTy.setZtyidoukiykhnrikn(
                        BizNumber.valueOf(new BigDecimal(hokenKykIdouRirekiList.get(i).getIdoukiykhnrikn().toString())));
                    hknkykIdouInfoTy.setZtyhknkkn(hokenKykIdouRirekiList.get(i).getHknkkn().toString());
                    hknkykIdouInfoTy.setZtyyoteiriritun5(hokenKykIdouRirekiList.get(i).getYoteiriritu());
                    hknkykIdouInfoTy.setZtytumitatekinkbn(hokenKykIdouRirekiList.get(i).getTumitatekinkbn().getValue());
                    hknkykIdouInfoTy.setZtyharaikatakbnkykidou(
                        hokenKykIdouRirekiList.get(i).getKykidouharaikatakbn().getValue());

                    BizPropertyInitializer.initialize(hknkykIdouInfoTy);

                    pMultipleEntityInserter.add(hknkykIdouInfoTy);
                }
            }

            return count;
        }

    }

    public class HeijunbaraiJikkou {

        private String syono;

        private Map<String, HeijunbaraiCommon> heijunbaraiCommonMap;

        public Long exec(IT_KykKihon pKykKihon, IT_KhTtdkRireki pKhTtdkRireki,
            MultipleEntityInserter pMultipleEntityInserter, BatchParam pBatchParam) {

            if (!pKhTtdkRireki.getSyono().equals(syono)) {

                init(pKhTtdkRireki.getSyono());
            }

            List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
            IT_KykSyouhn kykSyouhn = kykSyouhnLst.get(0);

            HeijunbaraiCommon heijunbaraiCommon = getSyoriObject(pKhTtdkRireki.getGyoumuKousinKinou(),
                pKhTtdkRireki.getSyorikbn());

            if (heijunbaraiCommon == null) {

                return 0L;
            }

            Long count = heijunbaraiCommon.exec(pKykKihon, kykSyouhn, pKhTtdkRireki, pBatchParam.getSyoriYmd(),
                pMultipleEntityInserter);

            return count;
        }

        private void init(String pSyono) {

            syono = pSyono;

            heijunbaraiCommonMap = new HashMap<String, HeijunbaraiCommon>();

        }

        private String createSyoriKensakuKey(String pGyoumuKousinsyaId, C_SyoriKbn pSyoriKbn) {

            return pGyoumuKousinsyaId + "："+ pSyoriKbn.getContent();
        }

        private HeijunbaraiCommon createSyoriObject(String pGyoumuKousinsyaId, C_SyoriKbn pSyoriKbn) {

            HeijunbaraiCommon heijunbaraiCommon = null;

            if (IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI.equals(pGyoumuKousinsyaId)) {

                heijunbaraiCommon = new HeijunbaraiCommonZougakuForKykInfotorikomi();
            }

            else if (IKhozenCommonConstants.KINOUID_KAIYAKU.equals(pGyoumuKousinsyaId)) {

                heijunbaraiCommon = new HeijunbaraiCommonGengakuForKaiyaku();

            }

            else if (IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU.equals(pGyoumuKousinsyaId)) {

                heijunbaraiCommon = new HeijunbaraiCommonGengakuForBatchKaiyaku();

            }

            else if (IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pGyoumuKousinsyaId)) {

                heijunbaraiCommon = new HeijunbaraiCommonGengakuForPminyuusyoumetusyori();

            }

            else if (IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI.equals(pGyoumuKousinsyaId)) {

                if (C_SyoriKbn.KYKTORIKESI.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForKyktorikesi();
                }

                else if (C_SyoriKbn.CLGOFF.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForClgoff();
                }

                else if (C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForSbmukouKihrkpshr();
                }

                else if (C_SyoriKbn.SBMUKOU_SHRNASI.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForSbmukouShrnasi();
                }

                else if (C_SyoriKbn.KAIJO.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForKaijo();
                }

                else if (C_SyoriKbn.MUKOU.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForMukou();
                }

                else if (C_SyoriKbn.SBKAIJO.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForSbkaijo();
                }

                else if (C_SyoriKbn.SBMENSEKI.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForSbmenseki();
                }

                else if (C_SyoriKbn.SBMENSEKI_SHRNASI.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForSbmensekiShrnasi();
                }
            }

            else if (IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI.equals(pGyoumuKousinsyaId)) {

                if (C_SyoriKbn.SBKYUUHUSHR.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForSbkyuuhushr();
                }

                else if (C_SyoriKbn.SBMUKOU.eq(pSyoriKbn)) {

                    heijunbaraiCommon = new HeijunbaraiCommonGengakuForSbmukou();
                }
            }

            else if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(pGyoumuKousinsyaId)) {

                heijunbaraiCommon = new HeijunbaraiCommonZouGengakuForGengaku();

            }

            else if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pGyoumuKousinsyaId)) {

                heijunbaraiCommon = new HeijunbaraiCommonZouGengakuForSeinengappiSeiTeisei();

            }

            return heijunbaraiCommon;
        }

        private HeijunbaraiCommon getSyoriObject(String pGyoumuKousinsyaId, C_SyoriKbn pSyoriKbn) {

            HeijunbaraiCommon heijunbaraiCommon = null;

            String syoriKensakuKey = createSyoriKensakuKey(pGyoumuKousinsyaId, pSyoriKbn);

            if (heijunbaraiCommonMap.containsKey(syoriKensakuKey)) {

                heijunbaraiCommon = heijunbaraiCommonMap.get(syoriKensakuKey);
            }
            else {
                heijunbaraiCommon = createSyoriObject(pGyoumuKousinsyaId, pSyoriKbn);

                heijunbaraiCommonMap.put(syoriKensakuKey, heijunbaraiCommon);
            }

            return heijunbaraiCommon;

        }

    }

    public class KhHokenKykIdouFileTyusyutuCommon {

        public String scramble(String pSyono) {

            String syono = pSyono;
            if (syono.length() != 11) {
                return "";
            }

            long longSyono = Long.valueOf(syono);
            long longSyonoMax = Long.valueOf("99999999999");
            long calSyono = longSyonoMax - longSyono;
            syono = String.valueOf(calSyono);
            syono = Strings.padStart(String.valueOf(String.valueOf(syono)), 11, '0');
            syono = syono.substring(2, 11) + syono.substring(0, 2);

            return syono;
        }

    }

    public class HeijunbaraiCommon extends KhHokenKykIdouFileTyusyutuCommon {

        protected String gyoumuKousinsyaId = null;

        protected C_SyoriKbn syoriKbn = null;

        protected C_ZfiIdoujiyuuKbn zfiIdoujiyuuKbn  = null;

        protected C_ZougenKbn zougenKbn = null;

        protected Integer recordRenban = 0;

        protected IT_KykKihon kykKihon = null;

        protected IT_KhTtdkRireki khTtdkRireki = null;

        protected IT_KykSyouhn kykSyouhn = null;

        protected BizDate syoriYmd = null;

        private HozenDomManager hozenDomManagerforclass = SWAKInjector.getInstance(HozenDomManager.class);

        public Long exec(IT_KykKihon pKykKihon, IT_KykSyouhn pKykSyouhn, IT_KhTtdkRireki pKhTtdkRireki,
            BizDate pSyoriYmd, MultipleEntityInserter pMultipleEntityInserter) {

            return 0L;
        }

        protected void init(IT_KykKihon pKykKihon, IT_KykSyouhn pKykSyouhn, IT_KhTtdkRireki pKhTtdkRireki,
            BizDate pSyoriYmd) {

            kykKihon = pKykKihon;

            kykSyouhn = pKykSyouhn;

            khTtdkRireki = pKhTtdkRireki;

            syoriYmd = pSyoriYmd;
        }

        protected C_YouhiKbn syoriyouhiHantei(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            return C_YouhiKbn.YOU;
        }

        protected BizDate setCalckijyunymd() {

            return null;
        }

        protected BizDateYM setKeisankijyunym() {

            return null;
        }

        protected BizDateYM getJikaipjutoYM() {
            return setKeisankijyunym();
        }

        protected KykSyouhnCommonParam searchSyohinRireki(E_SyutokuSyubetu pSyutokuSyubetu, IT_KhTtdkRireki pKhTtdkRireki) {

            KykSyouhnCommonParam result = null;

            if (pKhTtdkRireki.getHenkousikibetukey().equals(kykSyouhn.getHenkousikibetukey())) {

                if (E_SyutokuSyubetu.HENKOUMAE.equals(pSyutokuSyubetu)) {

                    List<IT_KykSyouhnRireki> kykSyouhnRirekiList = hozenDomManagerforclass.getKykSyouhnRirekisByPk(
                        getSyono(), C_SyutkKbn.SYU, kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno(),
                        kykSyouhn.getKyksyouhnrenno());

                    if (kykSyouhnRirekiList.size() != 0) {

                        result =  kykSyouhnRirekiList.get(0);
                    }
                }
                else {

                    result = kykSyouhn;
                }
            }
            else {

                List<IT_KykSyouhnRireki> kykSyouhnRirekiList = hozenDomManagerforclass.getKykSyouhnRirekisByPk(
                    getSyono(), C_SyutkKbn.SYU, kykSyouhn.getSyouhncd(), kykSyouhn.getSyouhnsdno(),
                    kykSyouhn.getKyksyouhnrenno());

                int kykSyouhnRirekiIndex = 0;

                for (IT_KykSyouhnRireki kykSyouhnRireki : kykSyouhnRirekiList) {

                    if (pKhTtdkRireki.getHenkousikibetukey().equals(kykSyouhnRireki.getHenkousikibetukey())) {

                        break;
                    }

                    kykSyouhnRirekiIndex = kykSyouhnRirekiIndex + 1;
                }

                if (E_SyutokuSyubetu.HENKOUMAE.equals(pSyutokuSyubetu)) {

                    if (kykSyouhnRirekiList.size() > kykSyouhnRirekiIndex + 1) {

                        result = kykSyouhnRirekiList.get(kykSyouhnRirekiIndex + 1);
                    }
                }
                else {

                    result = kykSyouhnRirekiList.get(kykSyouhnRirekiIndex);
                }
            }

            return result;
        }

        protected String getSyono() {

            return khTtdkRireki.getSyono();
        }

        protected KeisanWExtBean setTmttknKaiyakuhrkn(KykSyouhnCommonParam pKykSyouhnCommonParam, BizDate pCalckijyunymd) {

            KeisanWExtBean KeisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

            KeisanWExtBean.setSyouhncd(pKykSyouhnCommonParam.getSyouhncd());
            KeisanWExtBean.setSyouhnsdno(pKykSyouhnCommonParam.getSyouhnsdno());
            KeisanWExtBean.setRyouritusdno(pKykSyouhnCommonParam.getRyouritusdno());
            KeisanWExtBean.setYoteiriritu(pKykSyouhnCommonParam.getYoteiriritu());
            KeisanWExtBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
            KeisanWExtBean.setFstpryosyuymd(kykKihon.getFstpnyknymd());
            KeisanWExtBean.setHknkknsmnkbn(pKykSyouhnCommonParam.getHknkknsmnkbn());
            KeisanWExtBean.setHrkkknsmnkbn(pKykSyouhnCommonParam.getHrkkknsmnkbn());
            KeisanWExtBean.setHrkkkn(pKykSyouhnCommonParam.getHrkkkn());
            KeisanWExtBean.setHknkkn(pKykSyouhnCommonParam.getHknkkn());
            KeisanWExtBean.setHhknnen(pKykSyouhnCommonParam.getHhknnen());
            KeisanWExtBean.setHhknsei(pKykSyouhnCommonParam.getHhknsei());
            KeisanWExtBean.setKihons(pKykSyouhnCommonParam.getKihons());
            KeisanWExtBean.setHokenryou(pKykSyouhnCommonParam.getHokenryou());
            KeisanWExtBean.setKykymd(pKykSyouhnCommonParam.getKykymd());
            KeisanWExtBean.setTuukasyu(pKykSyouhnCommonParam.getKyktuukasyu());
            KeisanWExtBean.setDai1hknkkn(pKykSyouhnCommonParam.getDai1hknkkn());
            KeisanWExtBean.setKykJyoutai(pKykSyouhnCommonParam.getKykjyoutai());
            KeisanWExtBean.setJkipjytym(getJikaipjutoYM());
            KeisanWExtBean.setYoteirrthendohosyurrt(pKykSyouhnCommonParam.getYoteirrthendohosyurrt());

            if (checkSeinengappiSeiTeiseiSebetuHenkou()) {

                IT_HokenryouTmttkn hokenryouTmttkn = getHokenryouTmttknForSeinengappiSeiTeiseiSebetuHenkou();
                KeisanWExtBean.setTmttkntaisyouym(hokenryouTmttkn.getTmttkntaisyouym());
                KeisanWExtBean.setPtmttkngk(hokenryouTmttkn.getPtmttkngk());
                KeisanWExtBean.setKihrkmpstgk(hokenryouTmttkn.getKihrkmpstgk());
            }
            else {
                KeisanWExtBean.setTmttkntaisyouym(null);
                KeisanWExtBean.setPtmttkngk(null);
                KeisanWExtBean.setKihrkmpstgk(null);
            }

            return KeisanWExtBean;
        }

        protected boolean checkSeinengappiSeiTeiseiSebetuHenkou() {
            final int SAISIN_INDEX = 0;
            C_SyoriKbn[] syorikbn = {C_SyoriKbn.SEIBETUHENKOU};


            KhHokenKykIdouFileTyusyutuDao pKhHokenKykIdouFileTyusyutuDao = SWAKInjector
                .getInstance(KhHokenKykIdouFileTyusyutuDao.class);

            List<IT_KhTtdkRireki> ttdkRirekiListBySeinengappiSeiTeiseiSebetuHenkou
            = pKhHokenKykIdouFileTyusyutuDao.getKhTtdkRirekiBySyonoSyorikbnGyoumukousinkinou(getSyono(),
                syorikbn, IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);


            if (ttdkRirekiListBySeinengappiSeiTeiseiSebetuHenkou.size() == 0) {
                return false;
            }
            else {

                Integer henkousikibetukeyOfTetuduki = new Integer(khTtdkRireki.getHenkousikibetukey());
                Integer henkousikibetukeyOfSeinengappiSeiTeisei =
                    new Integer(ttdkRirekiListBySeinengappiSeiTeiseiSebetuHenkou.get(SAISIN_INDEX).getHenkousikibetukey());

                if (henkousikibetukeyOfTetuduki.compareTo(henkousikibetukeyOfSeinengappiSeiTeisei) > 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        protected IT_HokenryouTmttkn getHokenryouTmttknForSeinengappiSeiTeiseiSebetuHenkou() {
            final int SAISIN_INDEX = 0;

            KhHokenKykIdouFileTyusyutuDao pKhHokenKykIdouFileTyusyutuDao = SWAKInjector
                .getInstance(KhHokenKykIdouFileTyusyutuDao.class);

            List<IT_HokenryouTmttkn> hokenryouTmttknListBySeinengappiSeiTeiseiSebetuHenkou =
                pKhHokenKykIdouFileTyusyutuDao.getHokenryouTmttknBySyonoGyoumukousinkinou(
                    getSyono(), IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

            return hokenryouTmttknListBySeinengappiSeiTeiseiSebetuHenkou.get(SAISIN_INDEX);
        }

        protected KeisanW keisanW(BizDate pCalcKijyunYmd, BizDateYM pKijyunYm, KeisanWExtBean pKeisanWExtBean) {

            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);

            C_ErrorKbn errorKbn = keisanW.exec(pCalcKijyunYmd, pKijyunYm, pKeisanWExtBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("保険契約異動情報ファイル抽出　　証券番号：" + khTtdkRireki.getSyono()
                    + "変更識別キー：" + khTtdkRireki.getHenkousikibetukey());
            }

            return keisanW;
        }

        protected BizNumber getYoteiriritu(BizDateYM pKijyunYm, KeisanWExtBean pKeisanWExtBean) {

            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);

            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

            getYoteirirituBean.setSyouhncd(pKeisanWExtBean.getSyouhncd());
            getYoteirirituBean.setKijyunymd(BizDate.valueOf(pKijyunYm.addMonths(-1), pKeisanWExtBean.getKykymd()
                .getDay()));
            getYoteirirituBean.setSknnkaisiymd(pKeisanWExtBean.getKykymd());
            getYoteirirituBean.setKykymd(pKeisanWExtBean.getKykymd());
            getYoteirirituBean.setHknkkn(pKeisanWExtBean.getHknkkn());
            getYoteirirituBean.setHknkknsmnkbn(pKeisanWExtBean.getHknkknsmnkbn());
            getYoteirirituBean.setHhknnen(pKeisanWExtBean.getHhknnen());
            getYoteirirituBean.setSitihsyuriritu(pKeisanWExtBean.getYoteirrthendohosyurrt());
            getYoteirirituBean.setTuukasyu(pKeisanWExtBean.getTuukasyu());

            C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("保険契約異動情報ファイル抽出　　証券番号：" + khTtdkRireki.getSyono()
                    + "変更識別キー：" + khTtdkRireki.getHenkousikibetukey());
            }

            BizNumber yoteiriritu = getYoteiriritu.getYoteiriritu();

            return yoteiriritu;
        }

        protected ZT_HknkykIdouInfoTy initHknkykIdouInfoTy() {

            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

            hknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(0));
            hknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(0));
            hknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(0));
            hknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(0));

            return hknkykIdouInfoTy;

        }

        protected ZT_HknkykIdouInfoTy editHknkykIdouInfoTyCommon(String pRenban, C_ZougenKbn pZougenKbn,
            C_ZfiIdoujiyuuKbn pZfiIdoujiyuuKbn, BizNumber pYoteiriritu, C_TumitatekinKbn pTumitatekinKbn,
            KykSyouhnCommonParam pKykSyouhnCommonParamCommon, KykSyouhnCommonParam pKykSyouhnCommonParam,
            KeisanW pKkeisanW, BizDateYM pKijyunYm) {

            ZT_HknkykIdouInfoTy hknkykIdouInfoTy = new ZT_HknkykIdouInfoTy();

            editOutputItemCommon(pRenban, pZougenKbn, pZfiIdoujiyuuKbn, pYoteiriritu, pTumitatekinKbn,
                pKykSyouhnCommonParamCommon, hknkykIdouInfoTy);

            editOutputItemSPVW(pKykSyouhnCommonParam, pKkeisanW, pKijyunYm, hknkykIdouInfoTy);

            return hknkykIdouInfoTy;
        }

        private void editOutputItemCommon(String pRenban, C_ZougenKbn pZougenKbn, C_ZfiIdoujiyuuKbn pZfiIdoujiyuuKbn,
            BizNumber pYoteiriritu, C_TumitatekinKbn pTumitatekinKbn, KykSyouhnCommonParam pKykSyouhnCommonParam,
            ZT_HknkykIdouInfoTy pHknkykIdouInfoTy) {

            pHknkykIdouInfoTy.setZtykyktuukasyu(pKykSyouhnCommonParam.getKyktuukasyu().getValue());

            if (khTtdkRireki.getSyoriYmd() != null) {

                pHknkykIdouInfoTy.setZtyidouymd(khTtdkRireki.getSyoriYmd().toString());
            }

            pHknkykIdouInfoTy.setZtyidoujiyuukbnzfi(pZfiIdoujiyuuKbn.getValue());

            pHknkykIdouInfoTy.setZtydatakanrino(scramble(getSyono()));

            pHknkykIdouInfoTy.setZtyrenno(pRenban);

            if (kykSyouhn.getKykymd() != null) {

                pHknkykIdouInfoTy.setZtykeiyakuymd(kykSyouhn.getKykymd().toString());
            }

            pHknkykIdouInfoTy.setZtyhhknnen2(String.valueOf(pKykSyouhnCommonParam.getHhknnen()));

            pHknkykIdouInfoTy.setZtyhhknsei(pKykSyouhnCommonParam.getHhknsei().getValue());

            pHknkykIdouInfoTy.setZtyhknsyukigou(pKykSyouhnCommonParam.getSyouhncd().substring(0, 2));

            pHknkykIdouInfoTy.setZtyaisyoumeikbn(kykKihon.getAisyoumeikbn().getValue());

            pHknkykIdouInfoTy.setZtyzougenkbn(pZougenKbn.getValue());

            pHknkykIdouInfoTy.setZtyhknkkn(getHknkkn(pKykSyouhnCommonParam));

            pHknkykIdouInfoTy.setZtyyoteiriritun5(pYoteiriritu);

            pHknkykIdouInfoTy.setZtytumitatekinkbn(pTumitatekinKbn.getValue());

            pHknkykIdouInfoTy.setZtyharaikatakbnkykidou(C_KykIdouHaraikataKbn.TUKI.getValue());

        }

        private String getHknkkn(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);

            C_ErrorKbn errorKbn = convNenSaiManki.convHknkknNen(pKykSyouhnCommonParam.getHknkkn(),
                pKykSyouhnCommonParam.getHknkknsmnkbn(), pKykSyouhnCommonParam.getHhknnen());

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("保険契約異動情報ファイル抽出　　証券番号：" + khTtdkRireki.getSyono()
                    + "変更識別キー：" + khTtdkRireki.getHenkousikibetukey());
            }

            Integer hknkknNen = convNenSaiManki.getHknkknNen();

            String hknkknNenString = String.valueOf(hknkknNen);

            return hknkknNenString;
        }

        protected C_TumitatekinKbn getTumitatekinKbn(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            return C_TumitatekinKbn.BLNK;
        }

        private void editOutputItemSPVW(KykSyouhnCommonParam pKykSyouhnCommonParam, KeisanW pKkeisanW,
            BizDateYM pKijyunYm, ZT_HknkykIdouInfoTy pHknkykIdouInfoTy) {

            pHknkykIdouInfoTy.setZtyhokenkngk13(BizNumber.valueOf(new BigDecimal(getSGaika(pKykSyouhnCommonParam)
                .toString())));

            pHknkykIdouInfoTy.setZtyp13(BizNumber.valueOf(new BigDecimal(getPGaika(pKykSyouhnCommonParam, pKijyunYm)
                .toString())));

            pHknkykIdouInfoTy.setZtyptumitatekin13(BizNumber.valueOf(new BigDecimal(getVGaika(pKkeisanW)
                .toString())));

            pHknkykIdouInfoTy.setZtykiykhnrikn13(BizNumber.valueOf(new BigDecimal(getWGaika(pKkeisanW)
                .toString())));

        }

        private BizCurrency getSGaika(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            return pKykSyouhnCommonParam.getKihons();
        }

        protected BizCurrency getP(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            return BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }

        protected BizCurrency getPGaika(KykSyouhnCommonParam pKykSyouhnCommonParam, BizDateYM pKijyunYm) {

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            return BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pKykSyouhnCommonParam.getKyktuukasyu()));
        }

        private BizCurrency getVGaika(KeisanW pKeisanW) {

            return pKeisanW.getV();

        }

        private BizCurrency getWGaika(KeisanW pKeisanW) {

            return pKeisanW.getW();
        }

        protected void editHknkykIdouInfoTyIdou(ZT_HknkykIdouInfoTy pHknkykIdouInfoTyBefore,
            ZT_HknkykIdouInfoTy pHknkykIdouInfoTyAfter) {

            pHknkykIdouInfoTyBefore.setZtyidouhokenkngk(BizNumber.valueOf(0));
            pHknkykIdouInfoTyAfter.setZtyidouhokenkngk(BizNumber.valueOf(0));

            if (pHknkykIdouInfoTyBefore.getZtyhokenkngk13().compareTo(pHknkykIdouInfoTyAfter.getZtyhokenkngk13()) > 0) {

                pHknkykIdouInfoTyBefore.setZtyidouhokenkngk(pHknkykIdouInfoTyBefore.getZtyhokenkngk13().subtract(
                    pHknkykIdouInfoTyAfter.getZtyhokenkngk13()));
            }
            else if (pHknkykIdouInfoTyBefore.getZtyhokenkngk13().compareTo(pHknkykIdouInfoTyAfter.getZtyhokenkngk13()) < 0) {

                pHknkykIdouInfoTyAfter.setZtyidouhokenkngk(pHknkykIdouInfoTyAfter.getZtyhokenkngk13().subtract(
                    pHknkykIdouInfoTyBefore.getZtyhokenkngk13()));
            }

            pHknkykIdouInfoTyBefore.setZtyidoup(BizNumber.valueOf(0));
            pHknkykIdouInfoTyAfter.setZtyidoup(BizNumber.valueOf(0));

            if (pHknkykIdouInfoTyBefore.getZtyp13().compareTo(pHknkykIdouInfoTyAfter.getZtyp13()) > 0) {

                pHknkykIdouInfoTyBefore.setZtyidoup(pHknkykIdouInfoTyBefore.getZtyp13().subtract(
                    pHknkykIdouInfoTyAfter.getZtyp13()));
            }
            else if (pHknkykIdouInfoTyBefore.getZtyp13().compareTo(pHknkykIdouInfoTyAfter.getZtyp13()) < 0) {

                pHknkykIdouInfoTyAfter.setZtyidoup(pHknkykIdouInfoTyAfter.getZtyp13().subtract(
                    pHknkykIdouInfoTyBefore.getZtyp13()));
            }

            pHknkykIdouInfoTyBefore.setZtyidouptumitatekin(BizNumber.valueOf(0));
            pHknkykIdouInfoTyAfter.setZtyidouptumitatekin(BizNumber.valueOf(0));

            if (pHknkykIdouInfoTyBefore.getZtyptumitatekin13().compareTo(pHknkykIdouInfoTyAfter.getZtyptumitatekin13()) > 0) {

                pHknkykIdouInfoTyBefore.setZtyidouptumitatekin(pHknkykIdouInfoTyBefore.getZtyptumitatekin13().subtract(
                    pHknkykIdouInfoTyAfter.getZtyptumitatekin13()));
            }
            else if (pHknkykIdouInfoTyBefore.getZtyptumitatekin13().compareTo(pHknkykIdouInfoTyAfter.getZtyptumitatekin13()) < 0) {

                pHknkykIdouInfoTyAfter.setZtyidouptumitatekin(pHknkykIdouInfoTyAfter.getZtyptumitatekin13().subtract(
                    pHknkykIdouInfoTyBefore.getZtyptumitatekin13()));
            }

            pHknkykIdouInfoTyBefore.setZtyidoukiykhnrikn(BizNumber.valueOf(0));
            pHknkykIdouInfoTyAfter.setZtyidoukiykhnrikn(BizNumber.valueOf(0));

            if (pHknkykIdouInfoTyBefore.getZtykiykhnrikn13().compareTo(pHknkykIdouInfoTyAfter.getZtykiykhnrikn13()) > 0) {

                pHknkykIdouInfoTyBefore.setZtyidoukiykhnrikn(pHknkykIdouInfoTyBefore.getZtykiykhnrikn13().subtract(
                    pHknkykIdouInfoTyAfter.getZtykiykhnrikn13()));
            }
            else if (pHknkykIdouInfoTyBefore.getZtykiykhnrikn13().compareTo(pHknkykIdouInfoTyAfter.getZtykiykhnrikn13()) < 0) {

                pHknkykIdouInfoTyAfter.setZtyidoukiykhnrikn(pHknkykIdouInfoTyAfter.getZtykiykhnrikn13().subtract(
                    pHknkykIdouInfoTyBefore.getZtykiykhnrikn13()));
            }
        }

        public String getRecordRenban() {

            recordRenban = recordRenban + 1;

            String renban = BizUtil.zeroNum(String.valueOf(recordRenban), 2, 0);

            return renban;
        }

        protected String getGyoumuKousinKinou() {

            return gyoumuKousinsyaId;
        }

        protected C_SyoriKbn getSyoriKbn() {

            return syoriKbn;
        }

    }

    public class HeijunbaraiCommonZougaku extends HeijunbaraiCommon {

        public HeijunbaraiCommonZougaku () {

            zougenKbn = C_ZougenKbn.ZOU;

        }

        @Override
        public Long exec(IT_KykKihon pKykKihon, IT_KykSyouhn pKykSyouhn, IT_KhTtdkRireki pKhTtdkRireki,
            BizDate pSyoriYmd, MultipleEntityInserter pMultipleEntityInserter) {

            init(pKykKihon, pKykSyouhn, pKhTtdkRireki, pSyoriYmd);

            KykSyouhnCommonParam kykSyouhnCommonParam = searchSyohinRireki(E_SyutokuSyubetu.HENKOUATO, pKhTtdkRireki);

            BizDate calckijyunymd = setCalckijyunymd();

            BizDateYM keisankijyunym = setKeisankijyunym();

            if (C_YouhiKbn.HUYOU.eq(syoriyouhiHantei(kykSyouhnCommonParam))) {
                return 0L;
            }

            KeisanWExtBean keisanWExtBean = setTmttknKaiyakuhrkn(kykSyouhnCommonParam, calckijyunymd);

            KeisanW keisanW = keisanW(calckijyunymd, keisankijyunym, keisanWExtBean);

            BizNumber yoteiriritu = getYoteiriritu(keisankijyunym, keisanWExtBean);

            C_TumitatekinKbn tumitatekinKbn = getTumitatekinKbn(kykSyouhnCommonParam);

            String renban = getRecordRenban ();

            ZT_HknkykIdouInfoTy hknkykIdouInfoTyTtdktoki = editHknkykIdouInfoTyCommon(renban, zougenKbn,
                zfiIdoujiyuuKbn, yoteiriritu, tumitatekinKbn, kykSyouhnCommonParam, kykSyouhnCommonParam, keisanW,
                keisankijyunym);

            ZT_HknkykIdouInfoTy hknkykIdouInfoTyTtdkmae = initHknkykIdouInfoTy();

            editHknkykIdouInfoTyIdou(hknkykIdouInfoTyTtdkmae, hknkykIdouInfoTyTtdktoki);

            BizPropertyInitializer.initialize(hknkykIdouInfoTyTtdktoki);

            pMultipleEntityInserter.add(hknkykIdouInfoTyTtdktoki);

            return 1L;
        }
    }

    public class HeijunbaraiCommonGengaku extends HeijunbaraiCommon {

        public HeijunbaraiCommonGengaku () {

            zougenKbn = C_ZougenKbn.GEN;

        }

        @Override
        public Long exec(IT_KykKihon pKykKihon, IT_KykSyouhn pKykSyouhn, IT_KhTtdkRireki pKhTtdkRireki,
            BizDate pSyoriYmd, MultipleEntityInserter pMultipleEntityInserter) {

            init(pKykKihon, pKykSyouhn, pKhTtdkRireki, pSyoriYmd);

            KykSyouhnCommonParam kykSyouhnCommonParam = searchSyohinRireki(E_SyutokuSyubetu.HENKOUATO, pKhTtdkRireki);

            BizDate calckijyunymd = setCalckijyunymd();

            BizDateYM keisankijyunym = setKeisankijyunym();

            if (C_YouhiKbn.HUYOU.eq(syoriyouhiHantei(kykSyouhnCommonParam))) {
                return 0L;
            }

            KeisanWExtBean keisanWExtBean = setTmttknKaiyakuhrkn(kykSyouhnCommonParam, calckijyunymd);

            KeisanW keisanW = keisanW(calckijyunymd, keisankijyunym, keisanWExtBean);

            BizNumber yoteiriritu = getYoteiriritu(keisankijyunym, keisanWExtBean);

            C_TumitatekinKbn tumitatekinKbn = getTumitatekinKbn(kykSyouhnCommonParam);

            String renban = getRecordRenban ();

            ZT_HknkykIdouInfoTy hknkykIdouInfoTyTtdktoki = editHknkykIdouInfoTyCommon(renban, zougenKbn,
                zfiIdoujiyuuKbn, yoteiriritu, tumitatekinKbn, kykSyouhnCommonParam, kykSyouhnCommonParam, keisanW,
                keisankijyunym);

            ZT_HknkykIdouInfoTy hknkykIdouInfoTyTtdkmae = initHknkykIdouInfoTy();

            editHknkykIdouInfoTyIdou(hknkykIdouInfoTyTtdkmae, hknkykIdouInfoTyTtdktoki);

            BizPropertyInitializer.initialize(hknkykIdouInfoTyTtdktoki);

            pMultipleEntityInserter.add(hknkykIdouInfoTyTtdktoki);

            return 1L;
        }
    }

    public class HeijunbaraiCommonZouGengaku extends HeijunbaraiCommon {

        protected C_ZfiIdoujiyuuKbn zfiIdoujiyuuKbnBefore  = null;

        protected C_ZfiIdoujiyuuKbn zfiIdoujiyuuKbnAfter  = null;

        protected C_ZougenKbn zougenKbnBefore = C_ZougenKbn.GEN;

        protected C_ZougenKbn zougenKbnAfter = C_ZougenKbn.ZOU;

        public HeijunbaraiCommonZouGengaku () {
        }

        @Override
        public Long exec(IT_KykKihon pKykKihon, IT_KykSyouhn pKykSyouhn, IT_KhTtdkRireki pKhTtdkRireki,
            BizDate pSyoriYmd, MultipleEntityInserter pMultipleEntityInserter) {

            init(pKykKihon, pKykSyouhn, pKhTtdkRireki, pSyoriYmd);

            KykSyouhnCommonParam kykSyouhnCommonParamBefore = searchSyohinRireki(E_SyutokuSyubetu.HENKOUMAE,
                pKhTtdkRireki);

            KykSyouhnCommonParam kykSyouhnCommonParamAfter = searchSyohinRireki(E_SyutokuSyubetu.HENKOUATO,
                pKhTtdkRireki);

            if (C_YouhiKbn.HUYOU.eq(syoriyouhiHantei(kykSyouhnCommonParamBefore, kykSyouhnCommonParamAfter))) {
                return 0L;
            }

            BizDate calckijyunymd = setCalckijyunymd(kykSyouhnCommonParamAfter);

            BizDateYM keisankijyunym = setKeisankijyunym(kykSyouhnCommonParamAfter);

            KeisanWExtBean keisanWExtBeanBefore = setTmttknKaiyakuhrkn(kykSyouhnCommonParamBefore, calckijyunymd);

            KeisanW keisanWBefore = keisanW(calckijyunymd, keisankijyunym, keisanWExtBeanBefore);

            KeisanWExtBean keisanWExtBeanAfter = setTmttknKaiyakuhrkn(kykSyouhnCommonParamAfter, calckijyunymd);

            KeisanW keisanWAfter = keisanW(calckijyunymd, keisankijyunym, keisanWExtBeanAfter);

            boolean result = checkIdouKingakuUmu(keisanWBefore, keisanWAfter);

            if (!result) {

                return 0L;
            }

            BizNumber yoteirirituBefore = getYoteiriritu(keisankijyunym, keisanWExtBeanBefore);

            BizNumber yoteirirituAfter = getYoteiriritu(keisankijyunym, keisanWExtBeanAfter);

            C_TumitatekinKbn tumitatekinKbnBefore = getTumitatekinKbn(kykSyouhnCommonParamBefore);

            C_TumitatekinKbn tumitatekinKbnAfter = getTumitatekinKbn(kykSyouhnCommonParamAfter);

            String renban = getRecordRenban ();

            ZT_HknkykIdouInfoTy hknkykIdouInfoTyTtdktokiBefore = editHknkykIdouInfoTyCommon(renban, zougenKbnBefore,
                zfiIdoujiyuuKbnBefore, yoteirirituBefore, tumitatekinKbnBefore, kykSyouhnCommonParamAfter,
                kykSyouhnCommonParamBefore, keisanWBefore, keisankijyunym);

            ZT_HknkykIdouInfoTy hknkykIdouInfoTyTtdktokiAfter = editHknkykIdouInfoTyCommon(renban, zougenKbnAfter,
                zfiIdoujiyuuKbnAfter, yoteirirituAfter, tumitatekinKbnAfter, kykSyouhnCommonParamAfter,
                kykSyouhnCommonParamAfter, keisanWAfter, keisankijyunym);

            editHknkykIdouInfoTyIdou(hknkykIdouInfoTyTtdktokiBefore, hknkykIdouInfoTyTtdktokiAfter);

            BizPropertyInitializer.initialize(hknkykIdouInfoTyTtdktokiBefore);

            pMultipleEntityInserter.add(hknkykIdouInfoTyTtdktokiBefore);

            BizPropertyInitializer.initialize(hknkykIdouInfoTyTtdktokiAfter);

            pMultipleEntityInserter.add(hknkykIdouInfoTyTtdktokiAfter);

            return 2L;
        }

        protected C_YouhiKbn syoriyouhiHantei(KykSyouhnCommonParam pKykSyouhnCommonParamBefore,
            KykSyouhnCommonParam pKykSyouhnCommonParamAfter) {

            return C_YouhiKbn.YOU;
        }

        protected BizDate setCalckijyunymd(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            return null;
        }

        protected BizDateYM setKeisankijyunym(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            return null;
        }

        private Boolean checkIdouKingakuUmu(KeisanW pKeisanWBefore, KeisanW pKeisanWAfter) {

            if (pKeisanWBefore.getV().compareTo(pKeisanWAfter.getV()) != 0) {

                return true;

            }

            if (pKeisanWBefore.getW().compareTo(pKeisanWAfter.getW()) != 0) {

                return true;

            }

            return false;
        }
    }

    public class HeijunbaraiCommonZougakuForKykInfotorikomi extends HeijunbaraiCommonZougaku {


        public HeijunbaraiCommonZougakuForKykInfotorikomi() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI;

            syoriKbn = C_SyoriKbn.BLNK;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SINKEIYAKU;

        }

        @Override
        protected BizDate setCalckijyunymd() {

            BizDate calckijyunymd;

            if (BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_EQUAL) {

                calckijyunymd = kykKihon.getSeirituymd();
            }
            else {

                calckijyunymd = kykSyouhn.getKykymd();
            }

            return calckijyunymd;
        }

        @Override
        protected BizDateYM setKeisankijyunym() {

            BizDate calckijyunymd = setCalckijyunymd();

            BizDateYM keisankijyunym = calckijyunymd.getBizDateYM().addMonths(1);

            return keisankijyunym;
        }

        @Override
        protected BizCurrency getP(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            return pKykSyouhnCommonParam.getHokenryou();
        }

        @Override
        protected BizCurrency getPGaika(KykSyouhnCommonParam pKykSyouhnCommonParam, BizDateYM pKijyunYm) {

            BizDateYM kijyunYm;

            if (BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_GREATER  ||
                BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_EQUAL) {

                kijyunYm = syoriYmd.getBizDateYM().addMonths(1);
            }
            else {

                kijyunYm = pKijyunYm;
            }

            KeisanKihrkPRuikeigk keisanKihrkPRuikeigk = SWAKInjector.getInstance(KeisanKihrkPRuikeigk.class);

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

            C_ErrorKbn errorKbn = keisanKihrkPRuikeigk.exec(pKykSyouhnCommonParam.getHokenryou(),
                pKykSyouhnCommonParam.getKyktuukasyu(), pKykSyouhnCommonParam.getKykymd().getBizDateYM(), kijyunYm,
                C_Hrkkaisuu.TUKI, pKykSyouhnCommonParam.getKykymd(), kykKihon.getFstpnyknymd(),
                BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pKykSyouhnCommonParam.getKyktuukasyu())));

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                throw new CommonBizAppException("保険契約異動情報ファイル抽出　　証券番号：" + khTtdkRireki.getSyono()
                    + "変更識別キー：" + khTtdkRireki.getHenkousikibetukey());
            }

            BizCurrency p = keisanKihrkPRuikeigk.getKibaraiP();

            return p;
        }
    }

    public class HeijunbaraiCommonGengakuForKaiyaku extends HeijunbaraiCommonGengaku {

        public HeijunbaraiCommonGengakuForKaiyaku() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KAIYAKU;

            syoriKbn = C_SyoriKbn.BLNK;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.KAIYAKU;

        }

        @Override
        protected C_YouhiKbn syoriyouhiHantei(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            if (C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(pKykSyouhnCommonParam.getSyoumetujiyuu())) {

                return C_YouhiKbn.HUYOU;
            }

            return C_YouhiKbn.YOU;
        }

        @Override
        protected BizDate setCalckijyunymd() {

            return kykSyouhn.getSyoumetuymd();
        }

        @Override
        protected BizDateYM setKeisankijyunym() {

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            return keisanWKijunYM.exec(kykSyouhn.getKykymd(), setCalckijyunymd(), getJikaipjutoYM(),
                kykKihon.getHrkkaisuu(), kykSyouhn.getKykjyoutai(), kykSyouhn.getSyouhncd(), null);
        }

        @Override
        protected BizDateYM getJikaipjutoYM() {
            return khTtdkRireki.getSeihowebIdouRireki().getJkipjytym();
        }
    }

    public class HeijunbaraiCommonGengakuForBatchKaiyaku extends HeijunbaraiCommonGengakuForKaiyaku {

        public HeijunbaraiCommonGengakuForBatchKaiyaku() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU;

        }
    }

    public class HeijunbaraiCommonGengakuForPminyuusyoumetusyori extends HeijunbaraiCommonGengaku {

        public HeijunbaraiCommonGengakuForPminyuusyoumetusyori() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU;

            syoriKbn = C_SyoriKbn.BLNK;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.PMINYUSYOUMETU;

        }

        @Override
        protected BizDate setCalckijyunymd() {

            return kykSyouhn.getSyoumetuymd();
        }

        @Override
        protected BizDateYM setKeisankijyunym() {

            return getJikaipjutoYM();
        }

        @Override
        protected BizDateYM getJikaipjutoYM() {
            IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(getSyono());
            if (ansyuKihon == null) {
                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA0089));
            }
            return ansyuKihon.getJkipjytym();
        }
    }

    public class HeijunbaraiCommonGengakuForKyktorikesi extends HeijunbaraiCommonGengaku {

        public HeijunbaraiCommonGengakuForKyktorikesi() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;

            syoriKbn = C_SyoriKbn.KYKTORIKESI;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.KEIYAKUTORIKESI;

        }

        @Override
        protected BizDate setCalckijyunymd() {

            BizDate calckijyunymd;

            if (BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_EQUAL) {

                calckijyunymd =  syoriYmd;

            }
            else {

                calckijyunymd = kykSyouhn.getKykymd();
            }

            return calckijyunymd;
        }

        @Override
        protected BizDateYM setKeisankijyunym() {

            BizDate calckijyunymd = setCalckijyunymd();

            BizDateYM keisankijyunym = calckijyunymd.getBizDateYM().addMonths(1);

            return keisankijyunym;
        }
    }

    public class HeijunbaraiCommonGengakuForClgoff extends HeijunbaraiCommonGengakuForKyktorikesi {

        public HeijunbaraiCommonGengakuForClgoff() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;

            syoriKbn = C_SyoriKbn.CLGOFF;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.COOLINGOFF;

        }
    }


    public class HeijunbaraiCommonGengakuForSbmukouKihrkpshr extends HeijunbaraiCommonGengakuForKyktorikesi {

        public HeijunbaraiCommonGengakuForSbmukouKihrkpshr() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;

            syoriKbn = C_SyoriKbn.SBMUKOU_KIHRKPSHR;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMUKOUKIBARAIPSHR;

        }
    }

    public class HeijunbaraiCommonGengakuForSbmukouShrnasi extends HeijunbaraiCommonGengakuForKyktorikesi {

        public HeijunbaraiCommonGengakuForSbmukouShrnasi() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;

            syoriKbn = C_SyoriKbn.SBMUKOU_SHRNASI;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI;

        }
    }

    public class HeijunbaraiCommonGengakuForKaijo extends HeijunbaraiCommonGengaku {

        public HeijunbaraiCommonGengakuForKaijo() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;

            syoriKbn = C_SyoriKbn.KAIJO;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.KAIJYO;

        }

        @Override
        protected BizDate setCalckijyunymd() {

            IT_KhShrRireki khShrRireki = khTtdkRireki.getKhShrRireki();

            return khShrRireki.getKouryokuhasseiymd();
        }

        @Override
        protected BizDateYM setKeisankijyunym() {

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            return keisanWKijunYM.exec(kykSyouhn.getKykymd(), setCalckijyunymd(), getJikaipjutoYM(),
                kykKihon.getHrkkaisuu(), kykSyouhn.getKykjyoutai(),kykSyouhn.getSyouhncd(), null);
        }

        @Override
        protected BizDateYM getJikaipjutoYM() {
            return khTtdkRireki.getSeihowebIdouRireki().getJkipjytym();
        }

    }

    public class HeijunbaraiCommonGengakuForMukou extends HeijunbaraiCommonGengaku {

        public HeijunbaraiCommonGengakuForMukou() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;

            syoriKbn = C_SyoriKbn.MUKOU;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.MUKOU;

        }

        @Override
        protected BizDate setCalckijyunymd() {

            BizDate calckijyunymd;

            if (BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_EQUAL) {

                calckijyunymd =  syoriYmd;

            }
            else {

                calckijyunymd = kykSyouhn.getKykymd();
            }

            return calckijyunymd;
        }

        @Override
        protected BizDateYM setKeisankijyunym() {

            BizDate calckijyunymd = setCalckijyunymd();

            BizDateYM keisankijyunym = calckijyunymd.getBizDateYM().addMonths(1);

            return keisankijyunym;
        }
    }

    public class HeijunbaraiCommonGengakuForSbkaijo extends HeijunbaraiCommonGengaku {

        public HeijunbaraiCommonGengakuForSbkaijo() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;

            syoriKbn = C_SyoriKbn.SBKAIJO;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUKAIJYO;

        }

        @Override
        protected BizDate setCalckijyunymd() {

            BizDate calckijyunymd;

            if (BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_EQUAL) {

                calckijyunymd =  kykSyouhn.getSyoumetuymd();

            }
            else {

                calckijyunymd = kykSyouhn.getKykymd();
            }

            return calckijyunymd;
        }

        @Override
        protected BizDateYM setKeisankijyunym() {

            BizDate calckijyunymd = setCalckijyunymd();

            BizDateYM keisankijyunym = calckijyunymd.getBizDateYM().addMonths(1);

            return keisankijyunym;
        }
    }

    public class HeijunbaraiCommonGengakuForSbmenseki extends HeijunbaraiCommonGengakuForSbkaijo {

        public HeijunbaraiCommonGengakuForSbmenseki() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;

            syoriKbn = C_SyoriKbn.SBMENSEKI;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMENSEKI;

        }
    }

    public class HeijunbaraiCommonGengakuForSbmensekiShrnasi extends HeijunbaraiCommonGengakuForSbkaijo {

        public HeijunbaraiCommonGengakuForSbmensekiShrnasi() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;

            syoriKbn = C_SyoriKbn.SBMENSEKI_SHRNASI;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMENSEKISHRNASI;

        }
    }

    public class HeijunbaraiCommonGengakuForSbkyuuhushr extends HeijunbaraiCommonGengaku {

        public HeijunbaraiCommonGengakuForSbkyuuhushr() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;

            syoriKbn = C_SyoriKbn.SBKYUUHUSHR;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOU;

        }

        @Override
        protected BizDate setCalckijyunymd() {

            BizDate calckijyunymd;

            if (BizDateUtil.compareYmd(kykSyouhn.getSyoumetuymd(), kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(kykSyouhn.getSyoumetuymd(), kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_EQUAL) {

                calckijyunymd =  kykSyouhn.getSyoumetuymd();

            }
            else {

                calckijyunymd = kykSyouhn.getKykymd();
            }

            return calckijyunymd;
        }

        @Override
        protected BizDateYM setKeisankijyunym() {

            BizDate calckijyunymd = setCalckijyunymd();

            BizDateYM keisankijyunym = calckijyunymd.getBizDateYM().addMonths(1);

            return keisankijyunym;
        }
    }

    public class HeijunbaraiCommonGengakuForSbmukou extends HeijunbaraiCommonGengaku {

        public HeijunbaraiCommonGengakuForSbmukou() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI;

            syoriKbn = C_SyoriKbn.SBMUKOU;

            zfiIdoujiyuuKbn = C_ZfiIdoujiyuuKbn.SIBOUMUKOUSHRNASI;

        }

        @Override
        protected BizDate setCalckijyunymd() {

            BizDate calckijyunymd;

            if (BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_GREATER ||
                BizDateUtil.compareYmd(syoriYmd, kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_EQUAL) {

                calckijyunymd =  syoriYmd;

            }
            else {

                calckijyunymd = kykSyouhn.getKykymd();
            }

            return calckijyunymd;
        }

        @Override
        protected BizDateYM setKeisankijyunym() {

            BizDate calckijyunymd = setCalckijyunymd();

            BizDateYM keisankijyunym = calckijyunymd.getBizDateYM().addMonths(1);

            return keisankijyunym;
        }
    }

    public class HeijunbaraiCommonZouGengakuForGengaku extends HeijunbaraiCommonZouGengaku {

        public HeijunbaraiCommonZouGengakuForGengaku() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_GENGAKU;

            syoriKbn = C_SyoriKbn.BLNK;

            zfiIdoujiyuuKbnBefore = C_ZfiIdoujiyuuKbn.GENGAKUBFR;

            zfiIdoujiyuuKbnAfter = C_ZfiIdoujiyuuKbn.GENGAKUNEW;

        }

        @Override
        protected BizDate setCalckijyunymd(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            return pKykSyouhnCommonParam.getKouryokuhasseiymd();
        }

        @Override
        protected BizDateYM setKeisankijyunym(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);

            return keisanWKijunYM.exec(kykSyouhn.getKykymd(), setCalckijyunymd(pKykSyouhnCommonParam),
                getJikaipjutoYM(), kykKihon.getHrkkaisuu(), kykSyouhn.getKykjyoutai(), kykSyouhn.getSyouhncd(), null);
        }

        @Override
        protected BizDateYM getJikaipjutoYM() {
            return khTtdkRireki.getSeihowebIdouRireki().getJkipjytym();
        }

    }

    public class HeijunbaraiCommonZouGengakuForSeinengappiSeiTeisei extends HeijunbaraiCommonZouGengaku {

        public HeijunbaraiCommonZouGengakuForSeinengappiSeiTeisei() {

            super();

            gyoumuKousinsyaId = IKhozenCommonConstants.KINOUID_SEINENGAPPISEI;

            syoriKbn = C_SyoriKbn.BLNK;

            zfiIdoujiyuuKbnBefore = C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSBFR;

            zfiIdoujiyuuKbnAfter = C_ZfiIdoujiyuuKbn.SEINENGAPPISEITSNEW;

        }

        @Override
        protected BizDate setCalckijyunymd(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            BizDate calckijyunymd;

            if (BizDateUtil.compareYmd(khTtdkRireki.getSyoriYmd(), kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_GREATER
                || BizDateUtil.compareYmd(khTtdkRireki.getSyoriYmd(), kykSyouhn.getKykymd()) == BizDateUtil.COMPARE_EQUAL) {

                calckijyunymd =  khTtdkRireki.getSyoriYmd();

            }
            else {

                calckijyunymd = kykSyouhn.getKykymd();
            }

            return calckijyunymd;
        }

        @Override
        protected BizDateYM setKeisankijyunym(KykSyouhnCommonParam pKykSyouhnCommonParam) {

            BizDateYM keisankijyunym = null;

            BizDate calckijyunymd = setCalckijyunymd(pKykSyouhnCommonParam);

            keisankijyunym = calckijyunymd.getBizDateYM().addMonths(1);

            return keisankijyunym;

        }
    }
}
