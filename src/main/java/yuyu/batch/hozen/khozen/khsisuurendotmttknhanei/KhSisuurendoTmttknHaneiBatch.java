package yuyu.batch.hozen.khozen.khsisuurendotmttknhanei;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;
import jp.co.slcs.swak.util.message.MessageUtil;
import lombok.Getter;
import lombok.Setter;
import yuyu.batch.hozen.khozen.khsisuurendotmttknhanei.dba.KhKykSyouhnBean;
import yuyu.batch.hozen.khozen.khsisuurendotmttknhanei.dba.KhSisuurendoTmttknHaneiDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetSisuu;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiParam;
import yuyu.common.hozen.khcommon.EditKhMisslstParam;
import yuyu.common.hozen.khcommon.EditKykSyhnRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.HanteiTetuduki;
import yuyu.common.hozen.khcommon.KeisanSisuuRendouNkTmttkn;
import yuyu.common.hozen.khcommon.KeisanTmHntiSisuuRendouTmttkn;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_Dbhanei;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyorikahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhHenkouUktk;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 指数連動積増型年金積立金反映
 */
public class KhSisuurendoTmttknHaneiBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = "IT_KykSyouhn";

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    private int dateRenNo = 0;

    private List<EditKhMisslstParam> misslstPrmList = new ArrayList<>();

    private KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    protected HozenDomManager hozenDomManager;

    @Inject
    protected KhSisuurendoTmttknHaneiDao khSisuurendoTmttknHaneiDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        long syoriKensu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobcd));

        String[] syouhncds = SyouhinUtil. HENKOUKUBETU_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBRS_YENHENKOUMAE;
        try (ExDBResults<KhKykSyouhnBean> khKykSyouhnBeanLst = khSisuurendoTmttknHaneiDao.
            getKhKykSyouhnBeans(syouhncds, C_SyutkKbn.SYU, C_YuukousyoumetuKbn.YUUKOU, C_Kykjyoutai.ITIJIBARAI, kakutyoujobcd)){
            List<String> khUkeYoyakuSyoNoLst = khSisuurendoTmttknHaneiDao.getKykHozenHenkoUktYyk(C_UktkSyoriKbn.KAIYAKU, C_UktkJyoutaiKbn.MISYORI);

            for (KhKykSyouhnBean khKykSyouhnBean : khKykSyouhnBeanLst) {
                IT_KykSyouhn iT_KykSyouhn = khKykSyouhnBean.getIT_KykSyouhn();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(iT_KykSyouhn.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(iT_KykSyouhn.getSyono());

                dateRenNo++;

                BizDate konkiTumitateOutouYmd = null;
                BizDate konkiTumimasiHanteiYmd = null;
                BizNumber konkiTumimasiHanteiYmdSisu = BizNumber.ZERO;
                int seqNo = 0;
                String misslistMsg = "";

                IT_KhSisuurendoTmttkn iT_KhSisuurendoTmttkn = khSisuurendoTmttknHaneiDao.getSisurendoTmttknInfo(iT_KykSyouhn.getSyono());

                SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
                konkiTumitateOutouYmd = setOutoubi.
                    exec(C_TykzentykgoKbn.TYKGO, iT_KykSyouhn.getKykymd(), C_Hrkkaisuu.NEN, iT_KhSisuurendoTmttkn.getTmttknkouryokukaisiymd());
                konkiTumimasiHanteiYmd = konkiTumitateOutouYmd.addBusinessDays(-1);

                if(BizDateUtil.compareYmd(konkiTumimasiHanteiYmd, syoriYmd) == BizDateUtil.COMPARE_GREATER) {
                    continue;
                }
                if(BizDateUtil.compareYm(iT_KykSyouhn.getHknkknmanryouymd().getBizDateYM(),
                    iT_KhSisuurendoTmttkn.getTmttkntaisyouym()) <= BizDateUtil.COMPARE_EQUAL) {
                    continue;
                }

                if (khUkeYoyakuSyoNoLst.size() > 0) {
                    if (khUkeYoyakuSyoNoLst.contains(iT_KykSyouhn.getSyono())) {
                        seqNo++;
                        misslistMsg = "契約応当日：" + konkiTumitateOutouYmd.toString() + "\n";
                        misslistMsg = misslistMsg + "ＤＳ解約受付中契約のため処理できません。";
                        addMissListTblEditPrm(iT_KykSyouhn.getSyono(), seqNo, misslistMsg);
                        continue;
                    }
                }

                CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);
                CheckYuukouJyoutaiParam checkYuukouJyoutaiParam = SWAKInjector.getInstance(CheckYuukouJyoutaiParam.class);
                checkYuukouJyoutaiParam.setSyono(iT_KykSyouhn.getSyono());
                C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, checkYuukouJyoutaiParam);
                if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
                    seqNo++;
                    misslistMsg = "契約応当日：" + konkiTumitateOutouYmd.toString() + "\n";
                    misslistMsg = misslistMsg + checkYuukouJyoutai.getErrorMessage() + "契約のため処理できません。";
                    addMissListTblEditPrm(iT_KykSyouhn.getSyono(), seqNo, misslistMsg);
                    continue;
                }
                checkYuukouJyoutai.detachAllEntities(iT_KykSyouhn.getSyono());

                HanteiTetuduki hanteiTetuduki = SWAKInjector.getInstance(HanteiTetuduki.class);
                C_SyorikahiKbn syorikahiKbn = hanteiTetuduki.exec(khozenCommonParam, iT_KykSyouhn.getSyono());
                if (C_SyorikahiKbn.SYORIHUKA.eq(syorikahiKbn)) {
                    seqNo++;
                    misslistMsg = "契約応当日：" + konkiTumitateOutouYmd.toString() + "\n";
                    misslistMsg = misslistMsg + "手続注意[" + hanteiTetuduki.getMessageParam() + "]が設定されている契約のため、処理できません。";
                    addMissListTblEditPrm(iT_KykSyouhn.getSyono(), seqNo, misslistMsg);
                    continue;
                }

                IT_KhHenkouUktk iT_KhHenkouUktk = hozenDomManager.getKykHozenHenkoUkt(iT_KykSyouhn.getSyono(),
                    C_UktkSyoriKbn.TMTTKNITEN, C_UktkJyoutaiKbn.MISYORI, konkiTumitateOutouYmd);
                boolean tumitateKinUketukeAriFlg = false;
                Integer hozenHenkoUkeRenNo = 0;
                if (iT_KhHenkouUktk != null) {
                    tumitateKinUketukeAriFlg = true;
                    hozenHenkoUkeRenNo = iT_KhHenkouUktk.getHozenhenkouuktkrenno();
                }

                IT_KykSonotaTkyk kykSonotaTkyk = khSisuurendoTmttknHaneiDao.getKykSonotaTkyk(iT_KykSyouhn.getSyono());

                if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(iT_KykSyouhn.getTmttknhaibunjyoutai())
                    || C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(iT_KykSyouhn.getTmttknhaibunjyoutai())) {
                    GetSisuu getSisuu = SWAKInjector.getInstance(GetSisuu.class);
                    C_ErrorKbn result = getSisuu.exec(iT_KykSyouhn.getSisuukbn(), konkiTumimasiHanteiYmd, C_YouhiKbn.HUYOU);
                    if (C_ErrorKbn.ERROR.eq(result)) {
                        if (BizDateUtil.compareYmd(konkiTumimasiHanteiYmd, syoriYmd) == BizDateUtil.COMPARE_EQUAL) {
                            throw new CommonBizAppException("指数取得が実行できませんでした。");
                        }
                        seqNo++;
                        misslistMsg = "契約応当日：" + konkiTumitateOutouYmd.toString() + "\n";
                        misslistMsg = misslistMsg + "指数取得エラーのため処理できません。";
                        addMissListTblEditPrm(iT_KykSyouhn.getSyono(), seqNo, misslistMsg);
                        continue;
                    }
                    konkiTumimasiHanteiYmdSisu = getSisuu.getSisuu();
                }
                VKeisanKekkaBean vKeisanKekkaBean = keisanV(iT_KykSyouhn.getSyouhncd(), iT_KykSyouhn.getTmttknhaibunjyoutai(),
                    tumitateKinUketukeAriFlg, iT_KykSyouhn.getSyono(),iT_KykSyouhn.getKyktuukasyu(), konkiTumitateOutouYmd.getBizDateYM(),
                    iT_KhSisuurendoTmttkn.getTmttkntaisyouym(), iT_KykSyouhn.getTumitateriritu(), iT_KhSisuurendoTmttkn.getTeiritutmttkngk(),
                    iT_KhSisuurendoTmttkn.getSisuurendoutmttkngk(), konkiTumimasiHanteiYmdSisu, iT_KhSisuurendoTmttkn.getTmttknhaneisisuu(),
                    iT_KykSyouhn.getSetteibairitu(), iT_KykSyouhn.getTmttknzoukaritujygn(), iT_KykSyouhn.getRendouritu(),
                    iT_KykSyouhn.getKykymd(), iT_KykSyouhn.getHknkkn(), kykSonotaTkyk.getTeikishrtkykhukaumu(),
                    konkiTumitateOutouYmd);

                khozenCommonParam.setSikibetuKey(null);
                khozenCommonParam.getSikibetuKey(iT_KykSyouhn.getSyono());

                IT_KykKihon iT_KykKihon = hozenDomManager.getKykKihon(iT_KykSyouhn.getSyono());
                IT_AnsyuKihon iT_AnsyuKihon = hozenDomManager.getAnsyuKihon(iT_KykSyouhn.getSyono());
                khozenCommonParam.setBatchKeiyakuKihon(iT_KykKihon);
                khozenCommonParam.setBatchAnsyuKihon(iT_AnsyuKihon);

                syoriKensu++;

                if (!tumitateKinUketukeAriFlg) {
                    iT_KykKihon.setSyhenkouymd(syoriYmd);
                    iT_KykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                    iT_KykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                    iT_KykKihon.setGyoumuKousinTime(sysDateTimeMilli);

                    IT_KhSisuurendoTmttkn insertIT_KhSisuurendoTmttkn = iT_KykKihon.createKhSisuurendoTmttkn();
                    insertIT_KhSisuurendoTmttkn.setTmttkntaisyouym(konkiTumitateOutouYmd.getBizDateYM());
                    insertIT_KhSisuurendoTmttkn.setRenno(1);
                    insertIT_KhSisuurendoTmttkn.setTmttknkouryokukaisiymd(konkiTumitateOutouYmd);
                    insertIT_KhSisuurendoTmttkn.setTeiritutmttkngk(vKeisanKekkaBean.getTeirituTumitateKingaku());
                    insertIT_KhSisuurendoTmttkn.setSisuurendoutmttkngk(vKeisanKekkaBean.getSisuRendoTumitateKingaku());
                    insertIT_KhSisuurendoTmttkn.setSisuuupritu(vKeisanKekkaBean.getSisuJousyouRitu());
                    insertIT_KhSisuurendoTmttkn.setTmttknzoukaritu(vKeisanKekkaBean.getTumitateKinZoukaRitu());
                    if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(iT_KykSyouhn.getTmttknhaibunjyoutai())) {
                        insertIT_KhSisuurendoTmttkn.setTmttknhaneitmmshanteiymd(null);
                        insertIT_KhSisuurendoTmttkn.setTmttknhaneisisuu(BizNumber.ZERO);
                    }
                    else {
                        insertIT_KhSisuurendoTmttkn.setTmttknhaneitmmshanteiymd(konkiTumimasiHanteiYmd);
                        insertIT_KhSisuurendoTmttkn.setTmttknhaneisisuu(konkiTumimasiHanteiYmdSisu);
                    }
                    insertIT_KhSisuurendoTmttkn.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                    insertIT_KhSisuurendoTmttkn.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                    insertIT_KhSisuurendoTmttkn.setGyoumuKousinTime(sysDateTimeMilli);
                    insertIT_KhSisuurendoTmttkn.setItenmaeteiritutmttkngk(vKeisanKekkaBean.getItenmaeTeirituTumitateKingaku());
                    insertIT_KhSisuurendoTmttkn.setItenmaesisuurendoutmttkngk(vKeisanKekkaBean.getItenmaeSisuRendoTumitateKingaku());
                    BizPropertyInitializer.initialize(insertIT_KhSisuurendoTmttkn);

                    IT_KhTtdkRireki iT_KhTtdkRireki = iT_KykKihon.createKhTtdkRireki();
                    iT_KhTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(iT_KykSyouhn.getSyono()));
                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoNo(iT_KykSyouhn.getSyono());
                    editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                    editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.NONE);
                    editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.TMTTKNHANEI);
                    editTtdkRirekiTblParam.setSysTime(sysDateTimeMilli);
                    editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.HUYOU);
                    EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
                }
                else {
                    TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);
                    tableMaintenanceUtil.backUp(iT_KykSyouhn.getSyono(), khozenCommonParam.getSikibetuKey(iT_KykSyouhn.getSyono()));

                    khozenCommonParam.setBatchBakKykKihon(tableMaintenanceUtil.getBakKykKihon());
                    khozenCommonParam.setBatchBakAnsyuKihon(tableMaintenanceUtil.getBakAnsyuKihon());

                    iT_KykKihon.setSyhenkouymd(syoriYmd);
                    iT_KykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                    iT_KykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                    iT_KykKihon.setGyoumuKousinTime(sysDateTimeMilli);

                    IT_KhSisuurendoTmttkn insertIT_KhSisuurendoTmttkn = iT_KykKihon.createKhSisuurendoTmttkn();
                    insertIT_KhSisuurendoTmttkn.setTmttkntaisyouym(konkiTumitateOutouYmd.getBizDateYM());
                    insertIT_KhSisuurendoTmttkn.setRenno(1);
                    insertIT_KhSisuurendoTmttkn.setTmttknkouryokukaisiymd(konkiTumitateOutouYmd);
                    insertIT_KhSisuurendoTmttkn.setTeiritutmttkngk(vKeisanKekkaBean.getTeirituTumitateKingaku());
                    insertIT_KhSisuurendoTmttkn.setSisuurendoutmttkngk(vKeisanKekkaBean.getSisuRendoTumitateKingaku());
                    insertIT_KhSisuurendoTmttkn.setSisuuupritu(vKeisanKekkaBean.getSisuJousyouRitu());
                    insertIT_KhSisuurendoTmttkn.setTmttknzoukaritu(vKeisanKekkaBean.getTumitateKinZoukaRitu());
                    if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(iT_KykSyouhn.getTmttknhaibunjyoutai())) {
                        insertIT_KhSisuurendoTmttkn.setTmttknhaneitmmshanteiymd(null);
                        insertIT_KhSisuurendoTmttkn.setTmttknhaneisisuu(BizNumber.ZERO);
                    }
                    else {
                        insertIT_KhSisuurendoTmttkn.setTmttknhaneitmmshanteiymd(konkiTumimasiHanteiYmd);
                        insertIT_KhSisuurendoTmttkn.setTmttknhaneisisuu(konkiTumimasiHanteiYmdSisu);
                    }
                    insertIT_KhSisuurendoTmttkn.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                    insertIT_KhSisuurendoTmttkn.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                    insertIT_KhSisuurendoTmttkn.setGyoumuKousinTime(sysDateTimeMilli);
                    insertIT_KhSisuurendoTmttkn.setItenmaeteiritutmttkngk(vKeisanKekkaBean.getItenmaeTeirituTumitateKingaku());
                    insertIT_KhSisuurendoTmttkn.setItenmaesisuurendoutmttkngk(vKeisanKekkaBean.getItenmaeSisuRendoTumitateKingaku());
                    BizPropertyInitializer.initialize(insertIT_KhSisuurendoTmttkn);

                    EditKykSyhnRirekiTbl editKykSyhnRirekiTbl = SWAKInjector.getInstance(EditKykSyhnRirekiTbl.class);
                    editKykSyhnRirekiTbl.exec(khozenCommonParam, iT_KykSyouhn.getSyono());

                    IT_KykSyouhn updateIT_KykSyouhn = iT_KykKihon.getKykSyouhnByPK(iT_KykSyouhn.getSyutkkbn(),
                        iT_KykSyouhn.getSyouhncd(), iT_KykSyouhn.getSyouhnsdno(), iT_KykSyouhn.getKyksyouhnrenno());
                    updateIT_KykSyouhn.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(iT_KykSyouhn.getSyono()));
                    updateIT_KykSyouhn.setKouryokuhasseiymd(konkiTumitateOutouYmd);
                    updateIT_KykSyouhn.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                    updateIT_KykSyouhn.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                    updateIT_KykSyouhn.setGyoumuKousinTime(sysDateTimeMilli);
                    updateIT_KykSyouhn.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);
                    updateIT_KykSyouhn.setTmttknitenymd(konkiTumitateOutouYmd);

                    IT_KhHenkouUktk khHenkouUktk = hozenDomManager.getKhHenkouUktk(iT_KykSyouhn.getSyono(),
                        hozenHenkoUkeRenNo);
                    khHenkouUktk.setUktkjyoutaikbn(C_UktkJyoutaiKbn.SYORIZUMI);
                    khHenkouUktk.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                    khHenkouUktk.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                    khHenkouUktk.setGyoumuKousinTime(sysDateTimeMilli);

                    IT_KhTtdkRireki iT_KhTtdkRireki = iT_KykKihon.createKhTtdkRireki();
                    iT_KhTtdkRireki.setHenkousikibetukey(khozenCommonParam.getSikibetuKey(iT_KykSyouhn.getSyono()));
                    EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);
                    editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
                    editTtdkRirekiTblParam.setSyoNo(iT_KykSyouhn.getSyono());
                    editTtdkRirekiTblParam.setSyoriYmd(syoriYmd);
                    editTtdkRirekiTblParam.setShrSyousaiUmu(C_UmuKbn.NONE);
                    editTtdkRirekiTblParam.setSyoriKbn(C_SyoriKbn.TMTTKNHANEI_ITEN);
                    editTtdkRirekiTblParam.setSysTime(sysDateTimeMilli);
                    editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
                    EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
                    editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        if (misslstPrmList.size() > 0) {
            C_SyoruiCdKbn[] syoruiCdKbnLst = new C_SyoruiCdKbn[1];
            KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);
            syoruiCdKbnLst[0] = C_SyoruiCdKbn.KK_SISUURENDOTMTTKNHANEI_MISSLIST;
            khozenTyouhyouCtl.setEditKkMisslstParam(misslstPrmList);
            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam, syoruiCdKbnLst, C_YouhiKbn.HUYOU);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(dateRenNo)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensu), "指数連動積増型年金積立金テーブル"));
        if (misslstPrmList.size() > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IAC1001, "ミスリスト", String.valueOf(misslstPrmList.size())));
        }
    }

    private VKeisanKekkaBean keisanV(String pSyouhncd, C_TmttknhaibunjyoutaiKbn pTmttknhaibunjyoutai, boolean pTumitateKinUketukeAriFlg, String pSyono,
        C_Tuukasyu pKyktuukasyu, BizDateYM pKeisankijyunym, BizDateYM pKeisankaisiym, BizNumber pTumitateriritu, BizCurrency pTeiritutmttkngk,
        BizCurrency pSisuurendoutmttkngk, BizNumber pTumimasiHanteiYmdSisu, BizNumber pTyokuzenTumimasiHanteiYmdSisu, BizNumber pSetteibairitu,
        BizNumber pTmttknzoukaritujygn, BizNumber pRendouritu, BizDate pKykymd, Integer pHknkkn, C_UmuKbn pTeikishrtkykhukaumu,
        BizDate pCalckijyunymd) {
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType kykCurrencyType = henkanTuuka.henkanTuukaKbnToType(pKyktuukasyu);

        C_ErrorKbn result = C_ErrorKbn.ERROR;
        BizCurrency teirituTumitateKingaku = BizCurrency.valueOf(0, kykCurrencyType);
        BizCurrency sisuRendoTumitateKingaku = BizCurrency.valueOf(0, kykCurrencyType);
        BizNumber sisuJousyouRitu = BizNumber.ZERO;
        BizNumber tumitateKinZoukaRitu = BizNumber.ZERO;

        if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(pTmttknhaibunjyoutai)
            || C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(pTmttknhaibunjyoutai)) {
            KeisanSisuuRendouNkTmttkn keisanSisuuRendouNkTmttkn = SWAKInjector.getInstance(KeisanSisuuRendouNkTmttkn.class);
            result = keisanSisuuRendouNkTmttkn.exec(pKykymd, pHknkkn, pTeikishrtkykhukaumu, pKyktuukasyu, pCalckijyunymd,
                pKeisankijyunym, pKeisankaisiym, pTumitateriritu, pTeiritutmttkngk, pSisuurendoutmttkngk);
            if (C_ErrorKbn.ERROR.eq(result)) {
                throw new CommonBizAppException("指数連動年金積立金計算が実行できませんでした。");
            }
            teirituTumitateKingaku = keisanSisuuRendouNkTmttkn.getTeiritutmttkngk();
            sisuRendoTumitateKingaku = keisanSisuuRendouNkTmttkn.getSisuurendoutmttkngk();
        }
        if (C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(pTmttknhaibunjyoutai)
            || C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(pTmttknhaibunjyoutai)) {

            KeisanTmHntiSisuuRendouTmttkn keisanTmHntiSisuuRendouTmttkn = SWAKInjector.getInstance(KeisanTmHntiSisuuRendouTmttkn.class);
            result = keisanTmHntiSisuuRendouTmttkn.exec(pSyouhncd, pKyktuukasyu, pTumimasiHanteiYmdSisu,
                pTyokuzenTumimasiHanteiYmdSisu, pSetteibairitu, pTmttknzoukaritujygn, pSisuurendoutmttkngk,
                pRendouritu);
            if (C_ErrorKbn.ERROR.eq(result)) {
                throw new CommonBizAppException("積増判定時指数連動積立金計算が実行できませんでした。");
            }
            sisuRendoTumitateKingaku = keisanTmHntiSisuuRendouTmttkn.getSisuurendoutmttkngk();
            sisuJousyouRitu = keisanTmHntiSisuuRendouTmttkn.getSisuuUpRitu();
            tumitateKinZoukaRitu = keisanTmHntiSisuuRendouTmttkn.getTmttknZoukaRitu();

            if (sisuJousyouRitu.compareTo(BizNumber.ZERO) >= 0) {
                sisuJousyouRitu = sisuJousyouRitu.round(4, RoundingMode.DOWN);
            }
            else {
                sisuJousyouRitu = sisuJousyouRitu.round(4, RoundingMode.UP);
            }
        }

        VKeisanKekkaBean vKeisanKekkaBean = new VKeisanKekkaBean();
        if (pTumitateKinUketukeAriFlg) {
            vKeisanKekkaBean.setTeirituTumitateKingaku(teirituTumitateKingaku.add(sisuRendoTumitateKingaku));
            vKeisanKekkaBean.setSisuRendoTumitateKingaku(BizCurrency.valueOf(0,kykCurrencyType));
            vKeisanKekkaBean.setItenmaeTeirituTumitateKingaku(teirituTumitateKingaku);
            vKeisanKekkaBean.setItenmaeSisuRendoTumitateKingaku(sisuRendoTumitateKingaku);
        }
        else {
            vKeisanKekkaBean.setTeirituTumitateKingaku(teirituTumitateKingaku);
            vKeisanKekkaBean.setSisuRendoTumitateKingaku(sisuRendoTumitateKingaku);
        }
        vKeisanKekkaBean.setSisuJousyouRitu(sisuJousyouRitu);
        vKeisanKekkaBean.setTumitateKinZoukaRitu(tumitateKinZoukaRitu);
        return vKeisanKekkaBean;
    }

    private void addMissListTblEditPrm(String pSyono, int pSeqNo, String pMisslistMsg) {
        EditKhMisslstParam editKhMisslstParam = SWAKInjector.getInstance(EditKhMisslstParam.class);
        editKhMisslstParam.setDataNo(dateRenNo);
        editKhMisslstParam.setSeqNo(pSeqNo);
        editKhMisslstParam.setMisslistMsg(pMisslistMsg);
        editKhMisslstParam.setDBhaneikbn(C_Dbhanei.NONE);
        editKhMisslstParam.setSyoNo(pSyono);
        misslstPrmList.add(editKhMisslstParam);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }

    class VKeisanKekkaBean {

        @Getter @Setter
        private BizCurrency teirituTumitateKingaku;

        @Getter @Setter
        private BizCurrency sisuRendoTumitateKingaku;

        @Getter @Setter
        private BizCurrency itenmaeTeirituTumitateKingaku;

        @Getter @Setter
        private BizCurrency itenmaeSisuRendoTumitateKingaku;

        @Getter @Setter
        private BizNumber sisuJousyouRitu;

        @Getter @Setter
        private BizNumber tumitateKinZoukaRitu;

        public VKeisanKekkaBean() {
        }
    }
}
