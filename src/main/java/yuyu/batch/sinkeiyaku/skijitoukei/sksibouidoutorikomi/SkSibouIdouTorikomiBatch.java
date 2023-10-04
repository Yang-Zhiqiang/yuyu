package yuyu.batch.sinkeiyaku.skijitoukei.sksibouidoutorikomi;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.CHolidayAdjustingMode;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.EditIjitoukeiS;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_IjitoukeiKaijyoKbn;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHT_IjitoukeiMeisai;
import yuyu.def.zdb.manager.ZdbDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.file.csv.SkSibougeninmihaneilistLayoutFile;

/**
 * 新契約 医事統計 死亡統計異動情報取込
 */
public class SkSibouIdouTorikomiBatch implements Batch {
    private static final String TYSYTTAISYOUTABLEID = "ZT_IjiToukeiIdouInfoTr";

    private static final String RECOVERYFILTERID = "Bz004";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private ZdbDomManager zdbDomManager;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = batchParam.getSyoriYmd();
        String kakutyouJobCd = batchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;
        long outputKensuu = 0;
        List<SkSibougeninmihaneilistLayoutFile> skSibougeninmihaneilistLayoutFileLst = Lists.newArrayList();
        String sysDateTime = BizDate.getSysDateTimeMilli();
        String syono = "";
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), kakutyouJobCd));

        try (ExDBResults<ZT_IjiToukeiIdouInfoTr> ijiToukeiIdouInfoTrExDBResults =
            zdbDomManager.getIjiToukeiIdouInfoTrsByKakutyoujobcd(kakutyouJobCd);
            EntityInserter<HT_IjitoukeiMeisai> ijitoukeiMeisaiEntityInserter = new EntityInserter<>()) {
            HT_IjitoukeiMeisai ijitoukeiMeisai = new HT_IjitoukeiMeisai();
            HT_IjitoukeiMeisai wkijitoukeiMeisai = new HT_IjitoukeiMeisai();
            for (ZT_IjiToukeiIdouInfoTr ijiToukeiIdouInfoTr : ijiToukeiIdouInfoTrExDBResults) {
                if (!syono.equals(ijiToukeiIdouInfoTr.getZtrsyono())) {
                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                    bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(ijiToukeiIdouInfoTr.getZtrsyono());
                    List<HT_IjitoukeiMeisai> ijitoukeiMeisaiLst = sinkeiyakuDomManager.getIjitoukeiMeisaisBySyono(
                        ijiToukeiIdouInfoTr.getZtrsyono());
                    if (ijitoukeiMeisaiLst.size() == 0) {
                        batchLogger.info(MessageUtil.getMessage(MessageId.EBS0004, "HT_IjitoukeiMeisai", "証券番号",
                            ijiToukeiIdouInfoTr.getZtrsyono()));
                        throw new CommonBizAppException("証券番号=" + ijiToukeiIdouInfoTr.getZtrsyono());
                    }
                    SortHT_IjitoukeiMeisai ijitoukeiMeisaiSort = SWAKInjector.getInstance(SortHT_IjitoukeiMeisai.class);
                    ijitoukeiMeisaiLst = ijitoukeiMeisaiSort.OrderHT_IjitoukeiMeisaiByPkDesc(ijitoukeiMeisaiLst);

                    wkijitoukeiMeisai = ijitoukeiMeisaiLst.get(0);
                    syono = wkijitoukeiMeisai.getSyono();
                }
                else {
                    wkijitoukeiMeisai = ijitoukeiMeisai;
                }
                ijitoukeiMeisai = new HT_IjitoukeiMeisai();
                if ("120".equals(ijiToukeiIdouInfoTr.getZtrsymtgenincd())) {
                    ijitoukeiMeisai.setSyono(wkijitoukeiMeisai.getSyono());
                    ijitoukeiMeisai.setRenno8keta(wkijitoukeiMeisai.getRenno8keta() + 1);
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrbsyym())) {
                    }
                    else {
                        ijitoukeiMeisai.setBosyuuym(BizDateYM.valueOf(ijiToukeiIdouInfoTr.getZtrbsyym()));
                    }
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrkykym())) {
                    }
                    else {
                        ijitoukeiMeisai.setKykymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrkykym() + "01"));
                    }
                    ijitoukeiMeisai.setSknnkaisiymd(wkijitoukeiMeisai.getSknnkaisiymd());
                    ijitoukeiMeisai.setSyoumetuymd(wkijitoukeiMeisai.getSyoumetuymd());
                    ijitoukeiMeisai.setShrymd(wkijitoukeiMeisai.getShrymd());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsyoriymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setIdousyoriymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsyoriymd()));
                    }
                    ijitoukeiMeisai.setSntkhoukbn(wkijitoukeiMeisai.getSntkhoukbn());
                    ijitoukeiMeisai.setKokutikbn(wkijitoukeiMeisai.getKokutikbn());
                    ijitoukeiMeisai.setSkeijimukbn(wkijitoukeiMeisai.getSkeijimukbn());
                    ijitoukeiMeisai.setSirajikykkbn(wkijitoukeiMeisai.getSirajikykkbn());
                    ijitoukeiMeisai.setHrkkaisuu(wkijitoukeiMeisai.getHrkkaisuu());
                    ijitoukeiMeisai.setHaitoukinuketorihoukbn(wkijitoukeiMeisai.getHaitoukinuketorihoukbn());
                    ijitoukeiMeisai.setOyadrtencd(wkijitoukeiMeisai.getOyadrtencd());
                    ijitoukeiMeisai.setAatsukaishasoshikicd(wkijitoukeiMeisai.getAatsukaishasoshikicd());
                    ijitoukeiMeisai.setAatukaikojincd(wkijitoukeiMeisai.getAatukaikojincd());
                    ijitoukeiMeisai.setTratkiagcd(wkijitoukeiMeisai.getTratkiagcd());
                    ijitoukeiMeisai.setBosyuudairitenatkikeitaikbn(
                        wkijitoukeiMeisai.getBosyuudairitenatkikeitaikbn());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrhhknnen2keta())) {
                    }
                    else {
                        ijitoukeiMeisai.setHhknnen(Integer.parseInt(ijiToukeiIdouInfoTr.getZtrhhknnen2keta()));
                    }
                    if ("2".equals(ijiToukeiIdouInfoTr.getZtrhhknseikbn())) {
                        ijitoukeiMeisai.setHhknsei(C_Hhknsei.FEMALE);
                    }
                    else {
                        ijitoukeiMeisai.setHhknsei(C_Hhknsei.MALE);
                    }
                    ijitoukeiMeisai.setHhknyno(wkijitoukeiMeisai.getHhknyno());
                    ijitoukeiMeisai.setHhkntodouhukencd(wkijitoukeiMeisai.getHhkntodouhukencd());
                    ijitoukeiMeisai.setHhknnensyuukbn(wkijitoukeiMeisai.getHhknnensyuukbn());
                    ijitoukeiMeisai.setHhknsykgycd(wkijitoukeiMeisai.getHhknsykgycd());
                    ijitoukeiMeisai.setSintyou(wkijitoukeiMeisai.getSintyou());
                    ijitoukeiMeisai.setTaijyuu(wkijitoukeiMeisai.getTaijyuu());
                    if ("1".equals(ijiToukeiIdouInfoTr.getZtrkituenkbn())) {
                        ijitoukeiMeisai.setKituenkbn(C_KituenKbn.valueOf("1"));
                    }
                    else if ("2".equals(ijiToukeiIdouInfoTr.getZtrkituenkbn())) {
                        ijitoukeiMeisai.setKituenkbn(C_KituenKbn.valueOf("2"));
                    }
                    ijitoukeiMeisai.setKituenhon(Integer.parseInt(ijiToukeiIdouInfoTr.getZtrkituenhonsuu()));
                    ijitoukeiMeisai.setKyktuukasyu(wkijitoukeiMeisai.getKyktuukasyu());
                    ijitoukeiMeisai.setHrktuukasyu(wkijitoukeiMeisai.getHrktuukasyu());
                    ijitoukeiMeisai.setSyouhncd(wkijitoukeiMeisai.getSyouhncd());
                    ijitoukeiMeisai.setSyouhnsdno(wkijitoukeiMeisai.getSyouhnsdno());
                    ijitoukeiMeisai.setSeitoukihons(wkijitoukeiMeisai.getSeitoukihons());
                    ijitoukeiMeisai.setSeitoukihonsmanen(BizCurrency.valueOf(ijiToukeiIdouInfoTr.getZtrkisnkihons(),
                        BizCurrencyTypes.MANYEN));
                    ijitoukeiMeisai.setSyutkp(wkijitoukeiMeisai.getSyutkp());
                    ijitoukeiMeisai.setSyutkpmanen(wkijitoukeiMeisai.getSyutkpmanen());
                    EditIjitoukeiS editIjitoukeiS = SWAKInjector.getInstance(EditIjitoukeiS.class);
                    if (C_ErrorKbn.OK.eq(editIjitoukeiS.torikomiEdit(ijiToukeiIdouInfoTr, wkijitoukeiMeisai))) {
                        ijitoukeiMeisai.setImustiyusbus(editIjitoukeiS.getImustiyuS());
                    }
                    else {
                        ijitoukeiMeisai.setImustiyusbus(BizCurrency.valueOf(0, wkijitoukeiMeisai.getImustiyusbus()
                            .getType()));
                    }
                    ijitoukeiMeisai.setImustiyusbusmanen(BizCurrency.valueOf(ijiToukeiIdouInfoTr.getZtrimustiyusbus(),
                        BizCurrencyTypes.MANYEN));
                    ijitoukeiMeisai.setYenkansantkykwsrate(wkijitoukeiMeisai.getYenkansantkykwsrate());
                    ijitoukeiMeisai.setSyoubyoucd1(wkijitoukeiMeisai.getSyoubyoucd1());
                    ijitoukeiMeisai.setSyoubyoucd2(wkijitoukeiMeisai.getSyoubyoucd2());
                    ijitoukeiMeisai.setDakuhiktkekkacd(wkijitoukeiMeisai.getDakuhiktkekkacd());
                    ijitoukeiMeisai.setDakuhiketsyacd(wkijitoukeiMeisai.getDakuhiketsyacd());
                    ijitoukeiMeisai.setPalketsyacd(wkijitoukeiMeisai.getPalketsyacd());
                    ijitoukeiMeisai.setSyksbyensitihsyutkhkkbn(wkijitoukeiMeisai.getSyksbyensitihsyutkhkkbn());
                    ijitoukeiMeisai.setJyudkaigomehrtkhkkbn(wkijitoukeiMeisai.getJyudkaigomehrtkhkkbn());
                    ijitoukeiMeisai.setSymtgenincd(wkijitoukeiMeisai.getSymtgenincd());
                    ijitoukeiMeisai.setSiincd(wkijitoukeiMeisai.getSiincd());
                    ijitoukeiMeisai.setIjitoukeikaijyokbn(wkijitoukeiMeisai.getIjitoukeikaijyokbn());
                    ijitoukeiMeisai.setSysnikoujiym(wkijitoukeiMeisai.getSysnikoujiym());
                    ijitoukeiMeisai.setIjitoukeizennoukbn(wkijitoukeiMeisai.getIjitoukeizennoukbn());
                    ijitoukeiMeisai.setHrkkeiro(wkijitoukeiMeisai.getHrkkeiro());
                    ijitoukeiMeisai.setTikiktbrisyuruikbn(wkijitoukeiMeisai.getTikiktbrisyuruikbn());
                    ijitoukeiMeisai.setDai1hknkkn(wkijitoukeiMeisai.getDai1hknkkn());
                    ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(wkijitoukeiMeisai.getIjitoukeitikshrtkykkbn());
                    ijitoukeiMeisai.setTeikisiharaikin(wkijitoukeiMeisai.getTeikisiharaikin());
                    ijitoukeiMeisai.setTeikisiharaikinmanen(wkijitoukeiMeisai.getTeikisiharaikinmanen());
                    ijitoukeiMeisai.setGyoumuKousinTime(sysDateTime);
                }
                else if ("135".equals(ijiToukeiIdouInfoTr.getZtrsymtgenincd())) {
                    ijitoukeiMeisai.setSyono(wkijitoukeiMeisai.getSyono());
                    ijitoukeiMeisai.setRenno8keta(wkijitoukeiMeisai.getRenno8keta() + 1);
                    ijitoukeiMeisai.setBosyuuym(wkijitoukeiMeisai.getBosyuuym());
                    ijitoukeiMeisai.setKykymd(wkijitoukeiMeisai.getKykymd());
                    ijitoukeiMeisai.setSknnkaisiymd(wkijitoukeiMeisai.getSknnkaisiymd());
                    ijitoukeiMeisai.setSyoumetuymd(wkijitoukeiMeisai.getKykymd());
                    ijitoukeiMeisai.setShrymd(wkijitoukeiMeisai.getShrymd());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsyoriymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setIdousyoriymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsyoriymd()));
                    }
                    ijitoukeiMeisai.setSntkhoukbn(wkijitoukeiMeisai.getSntkhoukbn());
                    ijitoukeiMeisai.setKokutikbn(wkijitoukeiMeisai.getKokutikbn());
                    ijitoukeiMeisai.setSkeijimukbn(wkijitoukeiMeisai.getSkeijimukbn());
                    ijitoukeiMeisai.setSirajikykkbn(wkijitoukeiMeisai.getSirajikykkbn());
                    ijitoukeiMeisai.setHrkkaisuu(wkijitoukeiMeisai.getHrkkaisuu());
                    ijitoukeiMeisai.setHaitoukinuketorihoukbn(wkijitoukeiMeisai.getHaitoukinuketorihoukbn());
                    ijitoukeiMeisai.setOyadrtencd(wkijitoukeiMeisai.getOyadrtencd());
                    ijitoukeiMeisai.setAatsukaishasoshikicd(wkijitoukeiMeisai.getAatsukaishasoshikicd());
                    ijitoukeiMeisai.setAatukaikojincd(wkijitoukeiMeisai.getAatukaikojincd());
                    ijitoukeiMeisai.setTratkiagcd(wkijitoukeiMeisai.getTratkiagcd());
                    ijitoukeiMeisai.setBosyuudairitenatkikeitaikbn(
                        wkijitoukeiMeisai.getBosyuudairitenatkikeitaikbn());
                    ijitoukeiMeisai.setHhknnen(wkijitoukeiMeisai.getHhknnen());
                    ijitoukeiMeisai.setHhknsei(wkijitoukeiMeisai.getHhknsei());
                    ijitoukeiMeisai.setHhknyno(wkijitoukeiMeisai.getHhknyno());
                    ijitoukeiMeisai.setHhkntodouhukencd(wkijitoukeiMeisai.getHhkntodouhukencd());
                    ijitoukeiMeisai.setHhknnensyuukbn(wkijitoukeiMeisai.getHhknnensyuukbn());
                    ijitoukeiMeisai.setHhknsykgycd(wkijitoukeiMeisai.getHhknsykgycd());
                    ijitoukeiMeisai.setSintyou(wkijitoukeiMeisai.getSintyou());
                    ijitoukeiMeisai.setTaijyuu(wkijitoukeiMeisai.getTaijyuu());
                    ijitoukeiMeisai.setKituenkbn(wkijitoukeiMeisai.getKituenkbn());
                    ijitoukeiMeisai.setKituenhon(wkijitoukeiMeisai.getKituenhon());
                    ijitoukeiMeisai.setKyktuukasyu(wkijitoukeiMeisai.getKyktuukasyu());
                    ijitoukeiMeisai.setHrktuukasyu(wkijitoukeiMeisai.getHrktuukasyu());
                    ijitoukeiMeisai.setSyouhncd(wkijitoukeiMeisai.getSyouhncd());
                    ijitoukeiMeisai.setSyouhnsdno(wkijitoukeiMeisai.getSyouhnsdno());
                    ijitoukeiMeisai.setSeitoukihons(wkijitoukeiMeisai.getSeitoukihons());
                    ijitoukeiMeisai.setSeitoukihonsmanen(wkijitoukeiMeisai.getSeitoukihonsmanen());
                    ijitoukeiMeisai.setSyutkp(wkijitoukeiMeisai.getSyutkp());
                    ijitoukeiMeisai.setSyutkpmanen(wkijitoukeiMeisai.getSyutkpmanen());
                    ijitoukeiMeisai.setImustiyusbus(wkijitoukeiMeisai.getImustiyusbus());
                    ijitoukeiMeisai.setImustiyusbusmanen(wkijitoukeiMeisai.getImustiyusbusmanen());
                    ijitoukeiMeisai.setYenkansantkykwsrate(wkijitoukeiMeisai.getYenkansantkykwsrate());
                    ijitoukeiMeisai.setSyoubyoucd1(wkijitoukeiMeisai.getSyoubyoucd1());
                    ijitoukeiMeisai.setSyoubyoucd2(wkijitoukeiMeisai.getSyoubyoucd2());
                    ijitoukeiMeisai.setDakuhiktkekkacd(wkijitoukeiMeisai.getDakuhiktkekkacd());
                    ijitoukeiMeisai.setDakuhiketsyacd(wkijitoukeiMeisai.getDakuhiketsyacd());
                    ijitoukeiMeisai.setPalketsyacd(wkijitoukeiMeisai.getPalketsyacd());
                    ijitoukeiMeisai.setSyksbyensitihsyutkhkkbn(wkijitoukeiMeisai.getSyksbyensitihsyutkhkkbn());
                    ijitoukeiMeisai.setJyudkaigomehrtkhkkbn(wkijitoukeiMeisai.getJyudkaigomehrtkhkkbn());
                    ijitoukeiMeisai.setSymtgenincd(ijiToukeiIdouInfoTr.getZtrsymtgenincd());
                    ijitoukeiMeisai.setSiincd(wkijitoukeiMeisai.getSiincd());
                    ijitoukeiMeisai.setIjitoukeikaijyokbn(C_IjitoukeiKaijyoKbn.valueOf("2"));
                    ijitoukeiMeisai.setSysnikoujiym(wkijitoukeiMeisai.getSysnikoujiym());
                    ijitoukeiMeisai.setIjitoukeizennoukbn(wkijitoukeiMeisai.getIjitoukeizennoukbn());
                    ijitoukeiMeisai.setHrkkeiro(wkijitoukeiMeisai.getHrkkeiro());
                    ijitoukeiMeisai.setTikiktbrisyuruikbn(wkijitoukeiMeisai.getTikiktbrisyuruikbn());
                    ijitoukeiMeisai.setDai1hknkkn(wkijitoukeiMeisai.getDai1hknkkn());
                    ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(wkijitoukeiMeisai.getIjitoukeitikshrtkykkbn());
                    ijitoukeiMeisai.setTeikisiharaikin(wkijitoukeiMeisai.getTeikisiharaikin());
                    ijitoukeiMeisai.setTeikisiharaikinmanen(wkijitoukeiMeisai.getTeikisiharaikinmanen());
                    ijitoukeiMeisai.setGyoumuKousinTime(sysDateTime);
                }
                else if ("300".equals(ijiToukeiIdouInfoTr.getZtrsymtgenincd())) {
                    ijitoukeiMeisai.setSyono(wkijitoukeiMeisai.getSyono());
                    ijitoukeiMeisai.setRenno8keta(wkijitoukeiMeisai.getRenno8keta() + 1);
                    ijitoukeiMeisai.setBosyuuym(wkijitoukeiMeisai.getBosyuuym());
                    ijitoukeiMeisai.setKykymd(wkijitoukeiMeisai.getKykymd());
                    ijitoukeiMeisai.setSknnkaisiymd(wkijitoukeiMeisai.getSknnkaisiymd());
                    ijitoukeiMeisai.setSyoumetuymd(wkijitoukeiMeisai.getSyoumetuymd());
                    ijitoukeiMeisai.setShrymd(wkijitoukeiMeisai.getShrymd());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsyoriymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setIdousyoriymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsyoriymd()));
                    }
                    ijitoukeiMeisai.setSntkhoukbn(wkijitoukeiMeisai.getSntkhoukbn());
                    ijitoukeiMeisai.setKokutikbn(wkijitoukeiMeisai.getKokutikbn());
                    ijitoukeiMeisai.setSkeijimukbn(wkijitoukeiMeisai.getSkeijimukbn());
                    ijitoukeiMeisai.setSirajikykkbn(wkijitoukeiMeisai.getSirajikykkbn());
                    ijitoukeiMeisai.setHrkkaisuu(wkijitoukeiMeisai.getHrkkaisuu());
                    ijitoukeiMeisai.setHaitoukinuketorihoukbn(wkijitoukeiMeisai.getHaitoukinuketorihoukbn());
                    ijitoukeiMeisai.setOyadrtencd(wkijitoukeiMeisai.getOyadrtencd());
                    ijitoukeiMeisai.setAatsukaishasoshikicd(wkijitoukeiMeisai.getAatsukaishasoshikicd());
                    ijitoukeiMeisai.setAatukaikojincd(wkijitoukeiMeisai.getAatukaikojincd());
                    ijitoukeiMeisai.setTratkiagcd(wkijitoukeiMeisai.getTratkiagcd());
                    ijitoukeiMeisai.setBosyuudairitenatkikeitaikbn(
                        wkijitoukeiMeisai.getBosyuudairitenatkikeitaikbn());
                    ijitoukeiMeisai.setHhknnen(wkijitoukeiMeisai.getHhknnen());
                    ijitoukeiMeisai.setHhknsei(wkijitoukeiMeisai.getHhknsei());
                    ijitoukeiMeisai.setHhknyno(wkijitoukeiMeisai.getHhknyno());
                    ijitoukeiMeisai.setHhkntodouhukencd(wkijitoukeiMeisai.getHhkntodouhukencd());
                    ijitoukeiMeisai.setHhknnensyuukbn(wkijitoukeiMeisai.getHhknnensyuukbn());
                    ijitoukeiMeisai.setHhknsykgycd(wkijitoukeiMeisai.getHhknsykgycd());
                    ijitoukeiMeisai.setSintyou(wkijitoukeiMeisai.getSintyou());
                    ijitoukeiMeisai.setTaijyuu(wkijitoukeiMeisai.getTaijyuu());
                    ijitoukeiMeisai.setKituenkbn(wkijitoukeiMeisai.getKituenkbn());
                    ijitoukeiMeisai.setKituenhon(wkijitoukeiMeisai.getKituenhon());
                    ijitoukeiMeisai.setKyktuukasyu(wkijitoukeiMeisai.getKyktuukasyu());
                    ijitoukeiMeisai.setHrktuukasyu(wkijitoukeiMeisai.getHrktuukasyu());
                    ijitoukeiMeisai.setSyouhncd(wkijitoukeiMeisai.getSyouhncd());
                    ijitoukeiMeisai.setSyouhnsdno(wkijitoukeiMeisai.getSyouhnsdno());
                    ijitoukeiMeisai.setSeitoukihons(wkijitoukeiMeisai.getSeitoukihons());
                    ijitoukeiMeisai.setSeitoukihonsmanen(wkijitoukeiMeisai.getSeitoukihonsmanen());
                    ijitoukeiMeisai.setSyutkp(wkijitoukeiMeisai.getSyutkp());
                    ijitoukeiMeisai.setSyutkpmanen(wkijitoukeiMeisai.getSyutkpmanen());
                    ijitoukeiMeisai.setImustiyusbus(wkijitoukeiMeisai.getImustiyusbus());
                    ijitoukeiMeisai.setImustiyusbusmanen(wkijitoukeiMeisai.getImustiyusbusmanen());
                    ijitoukeiMeisai.setYenkansantkykwsrate(wkijitoukeiMeisai.getYenkansantkykwsrate());
                    ijitoukeiMeisai.setSyoubyoucd1(wkijitoukeiMeisai.getSyoubyoucd1());
                    ijitoukeiMeisai.setSyoubyoucd2(wkijitoukeiMeisai.getSyoubyoucd2());
                    ijitoukeiMeisai.setDakuhiktkekkacd(wkijitoukeiMeisai.getDakuhiktkekkacd());
                    ijitoukeiMeisai.setDakuhiketsyacd(wkijitoukeiMeisai.getDakuhiketsyacd());
                    ijitoukeiMeisai.setPalketsyacd(wkijitoukeiMeisai.getPalketsyacd());
                    ijitoukeiMeisai.setSyksbyensitihsyutkhkkbn(wkijitoukeiMeisai.getSyksbyensitihsyutkhkkbn());
                    ijitoukeiMeisai.setJyudkaigomehrtkhkkbn(wkijitoukeiMeisai.getJyudkaigomehrtkhkkbn());
                    ijitoukeiMeisai.setSymtgenincd(wkijitoukeiMeisai.getSymtgenincd());
                    ijitoukeiMeisai.setSiincd(wkijitoukeiMeisai.getSiincd());
                    ijitoukeiMeisai.setIjitoukeikaijyokbn(wkijitoukeiMeisai.getIjitoukeikaijyokbn());
                    ijitoukeiMeisai.setSysnikoujiym(wkijitoukeiMeisai.getSysnikoujiym());
                    ijitoukeiMeisai.setIjitoukeizennoukbn(wkijitoukeiMeisai.getIjitoukeizennoukbn());
                    ijitoukeiMeisai.setHrkkeiro(wkijitoukeiMeisai.getHrkkeiro());
                    ijitoukeiMeisai.setTikiktbrisyuruikbn(wkijitoukeiMeisai.getTikiktbrisyuruikbn());
                    ijitoukeiMeisai.setDai1hknkkn(wkijitoukeiMeisai.getDai1hknkkn());
                    ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(wkijitoukeiMeisai.getIjitoukeitikshrtkykkbn());
                    ijitoukeiMeisai.setTeikisiharaikin(wkijitoukeiMeisai.getTeikisiharaikin());
                    ijitoukeiMeisai.setTeikisiharaikinmanen(wkijitoukeiMeisai.getTeikisiharaikinmanen());
                    ijitoukeiMeisai.setGyoumuKousinTime(sysDateTime);
                }
                else if ("360".equals(ijiToukeiIdouInfoTr.getZtrsymtgenincd())) {
                    ijitoukeiMeisai.setSyono(wkijitoukeiMeisai.getSyono());
                    ijitoukeiMeisai.setRenno8keta(wkijitoukeiMeisai.getRenno8keta() + 1);
                    ijitoukeiMeisai.setBosyuuym(wkijitoukeiMeisai.getBosyuuym());
                    ijitoukeiMeisai.setKykymd(wkijitoukeiMeisai.getKykymd());
                    ijitoukeiMeisai.setSknnkaisiymd(wkijitoukeiMeisai.getSknnkaisiymd());
                    ijitoukeiMeisai.setSyoumetuymd(wkijitoukeiMeisai.getSyoumetuymd());
                    ijitoukeiMeisai.setShrymd(wkijitoukeiMeisai.getShrymd());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsyoriymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setIdousyoriymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsyoriymd()));
                    }
                    ijitoukeiMeisai.setSntkhoukbn(wkijitoukeiMeisai.getSntkhoukbn());
                    ijitoukeiMeisai.setKokutikbn(wkijitoukeiMeisai.getKokutikbn());
                    ijitoukeiMeisai.setSkeijimukbn(wkijitoukeiMeisai.getSkeijimukbn());
                    ijitoukeiMeisai.setSirajikykkbn(wkijitoukeiMeisai.getSirajikykkbn());
                    ijitoukeiMeisai.setHrkkaisuu(wkijitoukeiMeisai.getHrkkaisuu());
                    ijitoukeiMeisai.setHaitoukinuketorihoukbn(wkijitoukeiMeisai.getHaitoukinuketorihoukbn());
                    ijitoukeiMeisai.setOyadrtencd(wkijitoukeiMeisai.getOyadrtencd());
                    ijitoukeiMeisai.setAatsukaishasoshikicd(wkijitoukeiMeisai.getAatsukaishasoshikicd());
                    ijitoukeiMeisai.setAatukaikojincd(wkijitoukeiMeisai.getAatukaikojincd());
                    ijitoukeiMeisai.setTratkiagcd(wkijitoukeiMeisai.getTratkiagcd());
                    ijitoukeiMeisai.setBosyuudairitenatkikeitaikbn(
                        wkijitoukeiMeisai.getBosyuudairitenatkikeitaikbn());
                    ijitoukeiMeisai.setHhknnen(wkijitoukeiMeisai.getHhknnen());
                    ijitoukeiMeisai.setHhknsei(wkijitoukeiMeisai.getHhknsei());
                    ijitoukeiMeisai.setHhknyno(wkijitoukeiMeisai.getHhknyno());
                    ijitoukeiMeisai.setHhkntodouhukencd(wkijitoukeiMeisai.getHhkntodouhukencd());
                    ijitoukeiMeisai.setHhknnensyuukbn(wkijitoukeiMeisai.getHhknnensyuukbn());
                    ijitoukeiMeisai.setHhknsykgycd(wkijitoukeiMeisai.getHhknsykgycd());
                    ijitoukeiMeisai.setSintyou(wkijitoukeiMeisai.getSintyou());
                    ijitoukeiMeisai.setTaijyuu(wkijitoukeiMeisai.getTaijyuu());
                    ijitoukeiMeisai.setKituenkbn(wkijitoukeiMeisai.getKituenkbn());
                    ijitoukeiMeisai.setKituenhon(wkijitoukeiMeisai.getKituenhon());
                    ijitoukeiMeisai.setKyktuukasyu(wkijitoukeiMeisai.getKyktuukasyu());
                    ijitoukeiMeisai.setHrktuukasyu(wkijitoukeiMeisai.getHrktuukasyu());
                    ijitoukeiMeisai.setSyouhncd(wkijitoukeiMeisai.getSyouhncd());
                    ijitoukeiMeisai.setSyouhnsdno(wkijitoukeiMeisai.getSyouhnsdno());
                    ijitoukeiMeisai.setSeitoukihons(wkijitoukeiMeisai.getSeitoukihons());
                    ijitoukeiMeisai.setSeitoukihonsmanen(wkijitoukeiMeisai.getSeitoukihonsmanen());
                    ijitoukeiMeisai.setSyutkp(wkijitoukeiMeisai.getSyutkp());
                    ijitoukeiMeisai.setSyutkpmanen(wkijitoukeiMeisai.getSyutkpmanen());
                    ijitoukeiMeisai.setImustiyusbus(wkijitoukeiMeisai.getImustiyusbus());
                    ijitoukeiMeisai.setImustiyusbusmanen(wkijitoukeiMeisai.getImustiyusbusmanen());
                    ijitoukeiMeisai.setYenkansantkykwsrate(wkijitoukeiMeisai.getYenkansantkykwsrate());
                    ijitoukeiMeisai.setSyoubyoucd1(wkijitoukeiMeisai.getSyoubyoucd1());
                    ijitoukeiMeisai.setSyoubyoucd2(wkijitoukeiMeisai.getSyoubyoucd2());
                    ijitoukeiMeisai.setDakuhiktkekkacd(wkijitoukeiMeisai.getDakuhiktkekkacd());
                    ijitoukeiMeisai.setDakuhiketsyacd(wkijitoukeiMeisai.getDakuhiketsyacd());
                    ijitoukeiMeisai.setPalketsyacd(wkijitoukeiMeisai.getPalketsyacd());
                    ijitoukeiMeisai.setSyksbyensitihsyutkhkkbn(wkijitoukeiMeisai.getSyksbyensitihsyutkhkkbn());
                    ijitoukeiMeisai.setJyudkaigomehrtkhkkbn(wkijitoukeiMeisai.getJyudkaigomehrtkhkkbn());
                    ijitoukeiMeisai.setSymtgenincd(wkijitoukeiMeisai.getSymtgenincd());
                    ijitoukeiMeisai.setSiincd(wkijitoukeiMeisai.getSiincd());
                    ijitoukeiMeisai.setIjitoukeikaijyokbn(wkijitoukeiMeisai.getIjitoukeikaijyokbn());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsysnikoujiym()) ||
                        ijiToukeiIdouInfoTr.getZtrsysnikoujiym().equals("000000")) {
                    }
                    else {
                        ijitoukeiMeisai.setSysnikoujiym(BizDateYM.valueOf(ijiToukeiIdouInfoTr.getZtrsysnikoujiym()));
                    }
                    ijitoukeiMeisai.setIjitoukeizennoukbn(wkijitoukeiMeisai.getIjitoukeizennoukbn());
                    ijitoukeiMeisai.setHrkkeiro(wkijitoukeiMeisai.getHrkkeiro());
                    ijitoukeiMeisai.setTikiktbrisyuruikbn(wkijitoukeiMeisai.getTikiktbrisyuruikbn());
                    ijitoukeiMeisai.setDai1hknkkn(wkijitoukeiMeisai.getDai1hknkkn());
                    ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(wkijitoukeiMeisai.getIjitoukeitikshrtkykkbn());
                    ijitoukeiMeisai.setTeikisiharaikin(wkijitoukeiMeisai.getTeikisiharaikin());
                    ijitoukeiMeisai.setTeikisiharaikinmanen(wkijitoukeiMeisai.getTeikisiharaikinmanen());
                    ijitoukeiMeisai.setGyoumuKousinTime(sysDateTime);

                }
                else if ("415".equals(ijiToukeiIdouInfoTr.getZtrsymtgenincd())
                    || "425".equals(ijiToukeiIdouInfoTr.getZtrsymtgenincd())
                    || "435".equals(ijiToukeiIdouInfoTr.getZtrsymtgenincd())) {
                    ijitoukeiMeisai.setSyono(wkijitoukeiMeisai.getSyono());
                    ijitoukeiMeisai.setRenno8keta(wkijitoukeiMeisai.getRenno8keta() + 1);
                    ijitoukeiMeisai.setBosyuuym(wkijitoukeiMeisai.getBosyuuym());
                    ijitoukeiMeisai.setKykymd(wkijitoukeiMeisai.getKykymd());
                    ijitoukeiMeisai.setSknnkaisiymd(wkijitoukeiMeisai.getSknnkaisiymd());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsymtymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setSyoumetuymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsymtymd()));
                    }
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrshrymd()) ||
                        ijiToukeiIdouInfoTr.getZtrshrymd().equals("00000000")) {
                    }
                    else {
                        ijitoukeiMeisai.setShrymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrshrymd()));
                    }
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsyoriymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setIdousyoriymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsyoriymd()));
                    }
                    ijitoukeiMeisai.setSntkhoukbn(wkijitoukeiMeisai.getSntkhoukbn());
                    ijitoukeiMeisai.setKokutikbn(wkijitoukeiMeisai.getKokutikbn());
                    ijitoukeiMeisai.setSkeijimukbn(wkijitoukeiMeisai.getSkeijimukbn());
                    ijitoukeiMeisai.setSirajikykkbn(wkijitoukeiMeisai.getSirajikykkbn());
                    ijitoukeiMeisai.setHrkkaisuu(wkijitoukeiMeisai.getHrkkaisuu());
                    ijitoukeiMeisai.setHaitoukinuketorihoukbn(wkijitoukeiMeisai.getHaitoukinuketorihoukbn());
                    ijitoukeiMeisai.setOyadrtencd(wkijitoukeiMeisai.getOyadrtencd());
                    ijitoukeiMeisai.setAatsukaishasoshikicd(wkijitoukeiMeisai.getAatsukaishasoshikicd());
                    ijitoukeiMeisai.setAatukaikojincd(wkijitoukeiMeisai.getAatukaikojincd());
                    ijitoukeiMeisai.setTratkiagcd(wkijitoukeiMeisai.getTratkiagcd());
                    ijitoukeiMeisai.setBosyuudairitenatkikeitaikbn(
                        wkijitoukeiMeisai.getBosyuudairitenatkikeitaikbn());
                    ijitoukeiMeisai.setHhknnen(wkijitoukeiMeisai.getHhknnen());
                    ijitoukeiMeisai.setHhknsei(wkijitoukeiMeisai.getHhknsei());
                    ijitoukeiMeisai.setHhknyno(wkijitoukeiMeisai.getHhknyno());
                    ijitoukeiMeisai.setHhkntodouhukencd(wkijitoukeiMeisai.getHhkntodouhukencd());
                    ijitoukeiMeisai.setHhknnensyuukbn(wkijitoukeiMeisai.getHhknnensyuukbn());
                    ijitoukeiMeisai.setHhknsykgycd(wkijitoukeiMeisai.getHhknsykgycd());
                    ijitoukeiMeisai.setSintyou(wkijitoukeiMeisai.getSintyou());
                    ijitoukeiMeisai.setTaijyuu(wkijitoukeiMeisai.getTaijyuu());
                    ijitoukeiMeisai.setKituenkbn(wkijitoukeiMeisai.getKituenkbn());
                    ijitoukeiMeisai.setKituenhon(wkijitoukeiMeisai.getKituenhon());
                    ijitoukeiMeisai.setKyktuukasyu(wkijitoukeiMeisai.getKyktuukasyu());
                    ijitoukeiMeisai.setHrktuukasyu(wkijitoukeiMeisai.getHrktuukasyu());
                    ijitoukeiMeisai.setSyouhncd(wkijitoukeiMeisai.getSyouhncd());
                    ijitoukeiMeisai.setSyouhnsdno(wkijitoukeiMeisai.getSyouhnsdno());
                    ijitoukeiMeisai.setSeitoukihons(wkijitoukeiMeisai.getSeitoukihons());
                    ijitoukeiMeisai.setSeitoukihonsmanen(wkijitoukeiMeisai.getSeitoukihonsmanen());
                    ijitoukeiMeisai.setSyutkp(wkijitoukeiMeisai.getSyutkp());
                    ijitoukeiMeisai.setSyutkpmanen(wkijitoukeiMeisai.getSyutkpmanen());
                    ijitoukeiMeisai.setImustiyusbus(wkijitoukeiMeisai.getImustiyusbus());
                    ijitoukeiMeisai.setImustiyusbusmanen(wkijitoukeiMeisai.getImustiyusbusmanen());
                    ijitoukeiMeisai.setYenkansantkykwsrate(wkijitoukeiMeisai.getYenkansantkykwsrate());
                    ijitoukeiMeisai.setSyoubyoucd1(wkijitoukeiMeisai.getSyoubyoucd1());
                    ijitoukeiMeisai.setSyoubyoucd2(wkijitoukeiMeisai.getSyoubyoucd2());
                    ijitoukeiMeisai.setDakuhiktkekkacd(wkijitoukeiMeisai.getDakuhiktkekkacd());
                    ijitoukeiMeisai.setDakuhiketsyacd(wkijitoukeiMeisai.getDakuhiketsyacd());
                    ijitoukeiMeisai.setPalketsyacd(wkijitoukeiMeisai.getPalketsyacd());
                    ijitoukeiMeisai.setSyksbyensitihsyutkhkkbn(wkijitoukeiMeisai.getSyksbyensitihsyutkhkkbn());
                    ijitoukeiMeisai.setJyudkaigomehrtkhkkbn(wkijitoukeiMeisai.getJyudkaigomehrtkhkkbn());
                    ijitoukeiMeisai.setSymtgenincd(ijiToukeiIdouInfoTr.getZtrsymtgenincd());
                    if (StringUtils.isNumeric(ijiToukeiIdouInfoTr.getZtrsbugenincd())) {
                        ijitoukeiMeisai.setSiincd(ijiToukeiIdouInfoTr.getZtrsbugenincd());
                    }
                    else {
                    }
                    ijitoukeiMeisai.setIjitoukeikaijyokbn(wkijitoukeiMeisai.getIjitoukeikaijyokbn());
                    ijitoukeiMeisai.setSysnikoujiym(wkijitoukeiMeisai.getSysnikoujiym());
                    ijitoukeiMeisai.setIjitoukeizennoukbn(wkijitoukeiMeisai.getIjitoukeizennoukbn());
                    ijitoukeiMeisai.setHrkkeiro(wkijitoukeiMeisai.getHrkkeiro());
                    ijitoukeiMeisai.setTikiktbrisyuruikbn(wkijitoukeiMeisai.getTikiktbrisyuruikbn());
                    ijitoukeiMeisai.setDai1hknkkn(wkijitoukeiMeisai.getDai1hknkkn());
                    ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(wkijitoukeiMeisai.getIjitoukeitikshrtkykkbn());
                    ijitoukeiMeisai.setTeikisiharaikin(wkijitoukeiMeisai.getTeikisiharaikin());
                    ijitoukeiMeisai.setTeikisiharaikinmanen(wkijitoukeiMeisai.getTeikisiharaikinmanen());
                    ijitoukeiMeisai.setGyoumuKousinTime(sysDateTime);
                }
                else if ("505".equals(ijiToukeiIdouInfoTr.getZtrsymtgenincd())) {
                    ijitoukeiMeisai.setSyono(wkijitoukeiMeisai.getSyono());
                    ijitoukeiMeisai.setRenno8keta(wkijitoukeiMeisai.getRenno8keta() + 1);
                    ijitoukeiMeisai.setBosyuuym(wkijitoukeiMeisai.getBosyuuym());
                    ijitoukeiMeisai.setKykymd(wkijitoukeiMeisai.getKykymd());
                    ijitoukeiMeisai.setSknnkaisiymd(wkijitoukeiMeisai.getSknnkaisiymd());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsymtymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setSyoumetuymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsymtymd()));
                    }
                    ijitoukeiMeisai.setShrymd(wkijitoukeiMeisai.getShrymd());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsyoriymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setIdousyoriymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsyoriymd()));
                    }
                    ijitoukeiMeisai.setSntkhoukbn(wkijitoukeiMeisai.getSntkhoukbn());
                    ijitoukeiMeisai.setKokutikbn(wkijitoukeiMeisai.getKokutikbn());
                    ijitoukeiMeisai.setSkeijimukbn(wkijitoukeiMeisai.getSkeijimukbn());
                    ijitoukeiMeisai.setSirajikykkbn(wkijitoukeiMeisai.getSirajikykkbn());
                    ijitoukeiMeisai.setHrkkaisuu(wkijitoukeiMeisai.getHrkkaisuu());
                    ijitoukeiMeisai.setHaitoukinuketorihoukbn(wkijitoukeiMeisai.getHaitoukinuketorihoukbn());
                    ijitoukeiMeisai.setOyadrtencd(wkijitoukeiMeisai.getOyadrtencd());
                    ijitoukeiMeisai.setAatsukaishasoshikicd(wkijitoukeiMeisai.getAatsukaishasoshikicd());
                    ijitoukeiMeisai.setAatukaikojincd(wkijitoukeiMeisai.getAatukaikojincd());
                    ijitoukeiMeisai.setTratkiagcd(wkijitoukeiMeisai.getTratkiagcd());
                    ijitoukeiMeisai.setBosyuudairitenatkikeitaikbn(
                        wkijitoukeiMeisai.getBosyuudairitenatkikeitaikbn());
                    ijitoukeiMeisai.setHhknnen(wkijitoukeiMeisai.getHhknnen());
                    ijitoukeiMeisai.setHhknsei(wkijitoukeiMeisai.getHhknsei());
                    ijitoukeiMeisai.setHhknyno(wkijitoukeiMeisai.getHhknyno());
                    ijitoukeiMeisai.setHhkntodouhukencd(wkijitoukeiMeisai.getHhkntodouhukencd());
                    ijitoukeiMeisai.setHhknnensyuukbn(wkijitoukeiMeisai.getHhknnensyuukbn());
                    ijitoukeiMeisai.setHhknsykgycd(wkijitoukeiMeisai.getHhknsykgycd());
                    ijitoukeiMeisai.setSintyou(wkijitoukeiMeisai.getSintyou());
                    ijitoukeiMeisai.setTaijyuu(wkijitoukeiMeisai.getTaijyuu());
                    ijitoukeiMeisai.setKituenkbn(wkijitoukeiMeisai.getKituenkbn());
                    ijitoukeiMeisai.setKituenhon(wkijitoukeiMeisai.getKituenhon());
                    ijitoukeiMeisai.setKyktuukasyu(wkijitoukeiMeisai.getKyktuukasyu());
                    ijitoukeiMeisai.setHrktuukasyu(wkijitoukeiMeisai.getHrktuukasyu());
                    ijitoukeiMeisai.setSyouhncd(wkijitoukeiMeisai.getSyouhncd());
                    ijitoukeiMeisai.setSyouhnsdno(wkijitoukeiMeisai.getSyouhnsdno());
                    ijitoukeiMeisai.setSeitoukihons(wkijitoukeiMeisai.getSeitoukihons());
                    ijitoukeiMeisai.setSeitoukihonsmanen(wkijitoukeiMeisai.getSeitoukihonsmanen());
                    ijitoukeiMeisai.setSyutkp(wkijitoukeiMeisai.getSyutkp());
                    ijitoukeiMeisai.setSyutkpmanen(wkijitoukeiMeisai.getSyutkpmanen());
                    ijitoukeiMeisai.setImustiyusbus(wkijitoukeiMeisai.getImustiyusbus());
                    ijitoukeiMeisai.setImustiyusbusmanen(wkijitoukeiMeisai.getImustiyusbusmanen());
                    ijitoukeiMeisai.setYenkansantkykwsrate(wkijitoukeiMeisai.getYenkansantkykwsrate());
                    ijitoukeiMeisai.setSyoubyoucd1(wkijitoukeiMeisai.getSyoubyoucd1());
                    ijitoukeiMeisai.setSyoubyoucd2(wkijitoukeiMeisai.getSyoubyoucd2());
                    ijitoukeiMeisai.setDakuhiktkekkacd(wkijitoukeiMeisai.getDakuhiktkekkacd());
                    ijitoukeiMeisai.setDakuhiketsyacd(wkijitoukeiMeisai.getDakuhiketsyacd());
                    ijitoukeiMeisai.setPalketsyacd(wkijitoukeiMeisai.getPalketsyacd());
                    ijitoukeiMeisai.setSyksbyensitihsyutkhkkbn(wkijitoukeiMeisai.getSyksbyensitihsyutkhkkbn());
                    ijitoukeiMeisai.setJyudkaigomehrtkhkkbn(wkijitoukeiMeisai.getJyudkaigomehrtkhkkbn());
                    ijitoukeiMeisai.setSymtgenincd(ijiToukeiIdouInfoTr.getZtrsymtgenincd());
                    if (StringUtils.isNumeric(ijiToukeiIdouInfoTr.getZtrsbugenincd())) {
                        ijitoukeiMeisai.setSiincd(ijiToukeiIdouInfoTr.getZtrsbugenincd());
                    }
                    else {
                    }
                    ijitoukeiMeisai.setIjitoukeikaijyokbn(C_IjitoukeiKaijyoKbn.valueOf("3"));
                    ijitoukeiMeisai.setSysnikoujiym(wkijitoukeiMeisai.getSysnikoujiym());
                    ijitoukeiMeisai.setIjitoukeizennoukbn(wkijitoukeiMeisai.getIjitoukeizennoukbn());
                    ijitoukeiMeisai.setHrkkeiro(wkijitoukeiMeisai.getHrkkeiro());
                    ijitoukeiMeisai.setTikiktbrisyuruikbn(wkijitoukeiMeisai.getTikiktbrisyuruikbn());
                    ijitoukeiMeisai.setDai1hknkkn(wkijitoukeiMeisai.getDai1hknkkn());
                    ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(wkijitoukeiMeisai.getIjitoukeitikshrtkykkbn());
                    ijitoukeiMeisai.setTeikisiharaikin(wkijitoukeiMeisai.getTeikisiharaikin());
                    ijitoukeiMeisai.setTeikisiharaikinmanen(wkijitoukeiMeisai.getTeikisiharaikinmanen());
                    ijitoukeiMeisai.setGyoumuKousinTime(sysDateTime);
                }
                else if ("805".equals(ijiToukeiIdouInfoTr.getZtrsymtgenincd())) {
                    ijitoukeiMeisai.setSyono(wkijitoukeiMeisai.getSyono());
                    ijitoukeiMeisai.setRenno8keta(wkijitoukeiMeisai.getRenno8keta() + 1);
                    ijitoukeiMeisai.setBosyuuym(wkijitoukeiMeisai.getBosyuuym());
                    ijitoukeiMeisai.setKykymd(wkijitoukeiMeisai.getKykymd());
                    ijitoukeiMeisai.setSknnkaisiymd(wkijitoukeiMeisai.getSknnkaisiymd());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsymtymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setSyoumetuymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsymtymd()));
                    }
                    ijitoukeiMeisai.setShrymd(wkijitoukeiMeisai.getShrymd());
                    if (BizUtil.isBlank(ijiToukeiIdouInfoTr.getZtrsyoriymd())) {
                    }
                    else {
                        ijitoukeiMeisai.setIdousyoriymd(BizDate.valueOf(ijiToukeiIdouInfoTr.getZtrsyoriymd()));
                    }
                    ijitoukeiMeisai.setSntkhoukbn(wkijitoukeiMeisai.getSntkhoukbn());
                    ijitoukeiMeisai.setKokutikbn(wkijitoukeiMeisai.getKokutikbn());
                    ijitoukeiMeisai.setSkeijimukbn(wkijitoukeiMeisai.getSkeijimukbn());
                    ijitoukeiMeisai.setSirajikykkbn(wkijitoukeiMeisai.getSirajikykkbn());
                    ijitoukeiMeisai.setHrkkaisuu(wkijitoukeiMeisai.getHrkkaisuu());
                    ijitoukeiMeisai.setHaitoukinuketorihoukbn(wkijitoukeiMeisai.getHaitoukinuketorihoukbn());
                    ijitoukeiMeisai.setOyadrtencd(wkijitoukeiMeisai.getOyadrtencd());
                    ijitoukeiMeisai.setAatsukaishasoshikicd(wkijitoukeiMeisai.getAatsukaishasoshikicd());
                    ijitoukeiMeisai.setAatukaikojincd(wkijitoukeiMeisai.getAatukaikojincd());
                    ijitoukeiMeisai.setTratkiagcd(wkijitoukeiMeisai.getTratkiagcd());
                    ijitoukeiMeisai.setBosyuudairitenatkikeitaikbn(
                        wkijitoukeiMeisai.getBosyuudairitenatkikeitaikbn());
                    ijitoukeiMeisai.setHhknnen(wkijitoukeiMeisai.getHhknnen());
                    ijitoukeiMeisai.setHhknsei(wkijitoukeiMeisai.getHhknsei());
                    ijitoukeiMeisai.setHhknyno(wkijitoukeiMeisai.getHhknyno());
                    ijitoukeiMeisai.setHhkntodouhukencd(wkijitoukeiMeisai.getHhkntodouhukencd());
                    ijitoukeiMeisai.setHhknnensyuukbn(wkijitoukeiMeisai.getHhknnensyuukbn());
                    ijitoukeiMeisai.setHhknsykgycd(wkijitoukeiMeisai.getHhknsykgycd());
                    ijitoukeiMeisai.setSintyou(wkijitoukeiMeisai.getSintyou());
                    ijitoukeiMeisai.setTaijyuu(wkijitoukeiMeisai.getTaijyuu());
                    ijitoukeiMeisai.setKituenkbn(wkijitoukeiMeisai.getKituenkbn());
                    ijitoukeiMeisai.setKituenhon(wkijitoukeiMeisai.getKituenhon());
                    ijitoukeiMeisai.setKyktuukasyu(wkijitoukeiMeisai.getKyktuukasyu());
                    ijitoukeiMeisai.setHrktuukasyu(wkijitoukeiMeisai.getHrktuukasyu());
                    ijitoukeiMeisai.setSyouhncd(wkijitoukeiMeisai.getSyouhncd());
                    ijitoukeiMeisai.setSyouhnsdno(wkijitoukeiMeisai.getSyouhnsdno());
                    ijitoukeiMeisai.setSeitoukihons(wkijitoukeiMeisai.getSeitoukihons());
                    ijitoukeiMeisai.setSeitoukihonsmanen(wkijitoukeiMeisai.getSeitoukihonsmanen());
                    ijitoukeiMeisai.setSyutkp(wkijitoukeiMeisai.getSyutkp());
                    ijitoukeiMeisai.setSyutkpmanen(wkijitoukeiMeisai.getSyutkpmanen());
                    ijitoukeiMeisai.setImustiyusbus(wkijitoukeiMeisai.getImustiyusbus());
                    ijitoukeiMeisai.setImustiyusbusmanen(wkijitoukeiMeisai.getImustiyusbusmanen());
                    ijitoukeiMeisai.setYenkansantkykwsrate(wkijitoukeiMeisai.getYenkansantkykwsrate());
                    ijitoukeiMeisai.setSyoubyoucd1(wkijitoukeiMeisai.getSyoubyoucd1());
                    ijitoukeiMeisai.setSyoubyoucd2(wkijitoukeiMeisai.getSyoubyoucd2());
                    ijitoukeiMeisai.setDakuhiktkekkacd(wkijitoukeiMeisai.getDakuhiktkekkacd());
                    ijitoukeiMeisai.setDakuhiketsyacd(wkijitoukeiMeisai.getDakuhiketsyacd());
                    ijitoukeiMeisai.setPalketsyacd(wkijitoukeiMeisai.getPalketsyacd());
                    ijitoukeiMeisai.setSyksbyensitihsyutkhkkbn(wkijitoukeiMeisai.getSyksbyensitihsyutkhkkbn());
                    ijitoukeiMeisai.setJyudkaigomehrtkhkkbn(wkijitoukeiMeisai.getJyudkaigomehrtkhkkbn());
                    ijitoukeiMeisai.setSymtgenincd(ijiToukeiIdouInfoTr.getZtrsymtgenincd());
                    if (StringUtils.isNumeric(ijiToukeiIdouInfoTr.getZtrsbugenincd())) {
                        ijitoukeiMeisai.setSiincd(ijiToukeiIdouInfoTr.getZtrsbugenincd());
                    }
                    else {
                    }
                    ijitoukeiMeisai.setIjitoukeikaijyokbn(C_IjitoukeiKaijyoKbn.valueOf(
                        ijiToukeiIdouInfoTr.getZtrkaijyokbn()));
                    ijitoukeiMeisai.setSysnikoujiym(wkijitoukeiMeisai.getSysnikoujiym());
                    ijitoukeiMeisai.setIjitoukeizennoukbn(wkijitoukeiMeisai.getIjitoukeizennoukbn());
                    ijitoukeiMeisai.setHrkkeiro(wkijitoukeiMeisai.getHrkkeiro());
                    ijitoukeiMeisai.setTikiktbrisyuruikbn(wkijitoukeiMeisai.getTikiktbrisyuruikbn());
                    ijitoukeiMeisai.setDai1hknkkn(wkijitoukeiMeisai.getDai1hknkkn());
                    ijitoukeiMeisai.setIjitoukeitikshrtkykkbn(wkijitoukeiMeisai.getIjitoukeitikshrtkykkbn());
                    ijitoukeiMeisai.setTeikisiharaikin(wkijitoukeiMeisai.getTeikisiharaikin());
                    ijitoukeiMeisai.setTeikisiharaikinmanen(wkijitoukeiMeisai.getTeikisiharaikinmanen());
                    ijitoukeiMeisai.setGyoumuKousinTime(sysDateTime);
                }
                else {
                    continue;
                }
                BizPropertyInitializer.initialize(ijitoukeiMeisai);
                ijitoukeiMeisaiEntityInserter.add(ijitoukeiMeisai);
                syoriKensuu++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        sinkeiyakuDomManager.flush();

        try (ExDBResults<HT_IjitoukeiMeisai> ijitoukeiMeisaiNewExDBResults =
            sinkeiyakuDomManager.getIjitoukeiMeisaisBySyoumetuymdFromSyoumetuymdTo(
                BizDate.valueOf("20170401"),
                syoriYmd.addMonths(-YuyuSinkeiyakuConfig.getInstance().getSbugenincdMihaneiKyoyouTksu().intValue())
                .getBizDateYM().getFirstDay().getBusinessDay(CHolidayAdjustingMode.NEXT));) {
            for (HT_IjitoukeiMeisai ijitoukeiMeisai : ijitoukeiMeisaiNewExDBResults) {
                SkSibougeninmihaneilistLayoutFile skSibougeninmihaneilistLayoutFile =
                    SWAKInjector.getInstance(SkSibougeninmihaneilistLayoutFile.class);
                if (ijitoukeiMeisai.getIdousyoriymd() == null) {
                    skSibougeninmihaneilistLayoutFile.setIfcIdousyoriymd(String.valueOf(""));
                }
                else {
                    skSibougeninmihaneilistLayoutFile.setIfcIdousyoriymd(String.valueOf(
                        ijitoukeiMeisai.getIdousyoriymd()));
                }
                skSibougeninmihaneilistLayoutFile.setIfcSyono(ijitoukeiMeisai.getSyono());
                if (ijitoukeiMeisai.getSyoumetuymd() == null) {
                    skSibougeninmihaneilistLayoutFile.setIfcSyoumetuymd(String.valueOf(""));
                }
                else {
                    skSibougeninmihaneilistLayoutFile.setIfcSyoumetuymd(String.valueOf(
                        ijitoukeiMeisai.getSyoumetuymd()));
                }
                skSibougeninmihaneilistLayoutFile.setIfcSymtgenincd(ijitoukeiMeisai.getSymtgenincd());
                skSibougeninmihaneilistLayoutFileLst.add(skSibougeninmihaneilistLayoutFile);
                outputKensuu++;
            }
        }
        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);
        C_ErrorKbn errorKbn = bzFileUploadUtil.exec(C_FileSyuruiCdKbn.SK_SIBOUGENINMIHANEILIST,
            skSibougeninmihaneilistLayoutFileLst, true);
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
            throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "死亡統計異動情報取込"));
        if (outputKensuu > 0) {
            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(outputKensuu), "死亡原因未反映リスト"));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();

    }
}
