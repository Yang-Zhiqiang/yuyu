package yuyu.batch.suuri.srsuuritoukei.sridoumeisai;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.SetHokenNenrei;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.SetDenSimebi;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.srcommon.KhSisuurendoTmttknBean;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrGetTokutejitenSisuurendoTmttknInfo;
import yuyu.common.suuri.srcommon.SrGetTokutejitenTmttknInfoBean;
import yuyu.common.suuri.srcommon.SrTyukeiyouItzHznSakujyo;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_IdouRecordKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SuuriIdoKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_IdouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_IdouMeisaiTy;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 異動明細情報作成
 */
public class SrIdouMeisaiBatch implements Batch {

    private static final String SRIDMEISAIINFOTABLE = "異動明細Fテーブル（中）";

    private static final String  KIJYUNYMD_20190331  = "20190331";

    private static final String KIJYUNYMD_20190430 = "20190430";

    private static final String DENSIMEYMD_20190410 = "20190410";

    private static final String ITKHSISUURENDOTMTTKN = "IT_KhSisuurendoTmttkn";

    private static final String SISUURENDOUTMTTKNGN = "sisuurendoutmttkngk";

    private static final String TEIRITUTMTTKNGK = "teiritutmttkngk";

    private static final String TUMIMASI_NASI = "0";

    private static final String TUMIMASI_ARI = "1";

    private C_SuuriIdoKbn suuriIdoKbn;

    private int tableCount;

    private int itTableCount;

    private BizDate targetTkykkykhenkoYmd;

    private BizDate sisuuTumimasiKrkYmd;

    private boolean sokyuuGengakuUmuFlg;

    private String sokyuuGengakuHenkousikibetukey;

    private BizDate sokyuuGengakuSyoruiUkeYmd;

    private BizDate sokyuuGengakuSyoriYmd;

    private String syoriMaeSisuuTumimasiUmu;

    private boolean jmtSokyuuIdouFlg;

    @Inject
    private SrIdouMeisaiBatchParam srIdouMeisaiBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {
        return srIdouMeisaiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        suuriIdoKbn = C_SuuriIdoKbn.BLNK;
        tableCount = 0;
        itTableCount = 0;

        srIdouMeisaiBatchParam.setParam();

        SrTyukeiyouItzHznSakujyo srTyukeiyouItzHznSakujyo = SWAKInjector.getInstance(SrTyukeiyouItzHznSakujyo.class);
        srTyukeiyouItzHznSakujyo.deleteItzHznTable(srIdouMeisaiBatchParam);

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess = SWAKInjector.getInstance(SrIdouMeisaiBatchDbAccess.class);

        SrCreateMokuhyourituHenkou mokuhrtHenkNbCreate = SWAKInjector.getInstance(SrCreateMokuhyourituHenkou.class);

        SrCreateSisuuTumiMasi sisuuTumiMasi = SWAKInjector.getInstance(SrCreateSisuuTumiMasi.class);

        try (ExDBResults<SV_IdouMeisai> idouMeisaiLst =
            srIdouMeisaiBatchDbAccess.getIdouMeisaisBySyoriYmdSyutkkbn(
                srIdouMeisaiBatchParam.getZenkaidensimeymd(), srIdouMeisaiBatchParam.getKonkaidensimeymd(), C_SyutkKbn.SYU);
            EntityInserter<ZT_IdouMeisaiTy> idouMeisaiTyLst = new EntityInserter<>();
            EntityInserter<ST_IdouMeisaiTyukeiyouItzHzn> idouMeisaiTyukeiyouItzHznLst = new EntityInserter<>();) {

            String syonoBefore = "";
            BizDate syoriYmdBefore = null;

            for (SV_IdouMeisai idouMeisai : idouMeisaiLst) {

                if (BizDateUtil.compareYmd(srIdouMeisaiBatchParam.getKijyunymd(), BizDate.valueOf(KIJYUNYMD_20190331)) ==
                    BizDateUtil.COMPARE_EQUAL) {
                    List<IT_KykSyouhn> kykSyouhnLst = srIdouMeisaiBatchDbAccess.getKykSyouhns(idouMeisai.getSyono(), C_SyutkKbn.SYU);

                    if (kykSyouhnLst.size() == 0) {
                        continue;
                    }

                    String wkSyouhncd = kykSyouhnLst.get(0).getSyouhncd();

                    int syouhinUtilResult = SyouhinUtil.hantei(wkSyouhncd);

                    if (syouhinUtilResult == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        continue;
                    }
                }

                if (BizDateUtil.compareYmd(srIdouMeisaiBatchParam.getKijyunymd(), BizDate.valueOf(KIJYUNYMD_20190430)) ==
                    BizDateUtil.COMPARE_EQUAL &&
                    (BizDateUtil.compareYmd(idouMeisai.getSyoriYmd(), BizDate.valueOf(DENSIMEYMD_20190410)) == BizDateUtil.COMPARE_LESSER
                    || BizDateUtil.compareYmd(idouMeisai.getSyoriYmd(), BizDate.valueOf(DENSIMEYMD_20190410)) == BizDateUtil.COMPARE_EQUAL)) {
                    List<IT_KykSyouhn> kykSyouhnLst = srIdouMeisaiBatchDbAccess.getKykSyouhns(idouMeisai.getSyono(), C_SyutkKbn.SYU);

                    if (kykSyouhnLst.size() == 0) {
                        continue;
                    }

                    String wkSyouhncd = kykSyouhnLst.get(0).getSyouhncd();

                    int syouhinUtilResult = SyouhinUtil.hantei(wkSyouhncd);

                    if (syouhinUtilResult != SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        continue;
                    }
                }

                boolean naibuFlg = false;
                boolean naibusisuutumimasitrksUmuFlg = false;
                String naibuSeiseiRecordKbn = "";
                List<SV_IdouMeisai> wkIdouMeisaiList= new ArrayList<SV_IdouMeisai>();
                List<SV_IdouMeisai> teiseiLst = new ArrayList<SV_IdouMeisai>();

                if (IKhozenCommonConstants.KINOUID_GENGAKU.equals(idouMeisai.getGyoumuKousinKinou()) &&
                    BizDateUtil.compareYmd(idouMeisai.getSyoruiukeymd(),
                        idouMeisai.getSyoriYmd()) == BizDateUtil.COMPARE_LESSER) {

                    checkSokyuuIdouBikin(idouMeisai.getSyono(), idouMeisai.getHenkousikibetukey(), idouMeisai.getSyoriYmd());

                    if (jmtSokyuuIdouFlg) {
                        continue;
                    }

                    try (ExDBResults<SV_IdouMeisai> idouMeisaiList = srIdouMeisaiBatchDbAccess.getIdouMeisaiSokyuukikannai(
                        idouMeisai.getSyono(),
                        C_SyutkKbn.SYU,
                        idouMeisai.getSyoruiukeymd(),
                        idouMeisai.getSyoriYmd(),
                        idouMeisai.getHenkousikibetukey());
                        ) {

                        for (SV_IdouMeisai idouMeisaiDb : idouMeisaiList) {
                            wkIdouMeisaiList.add(idouMeisaiDb);
                        }
                    }

                    try (ExDBResults<SV_IdouMeisai> idouMeisaiList = srIdouMeisaiBatchDbAccess.getIdouMeisaiSokyuukikannai(
                        idouMeisai.getSyono(),
                        C_SyutkKbn.SYU,
                        idouMeisai.getSyoruiukeymd(),
                        idouMeisai.getSyoriYmd(),
                        idouMeisai.getHenkousikibetukey());
                        ) {

                        for (SV_IdouMeisai idouMeisaiDb : idouMeisaiList) {

                            setSuuriIdoKbn(idouMeisaiDb);

                            if (C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(suuriIdoKbn)){
                                naibusisuutumimasitrksUmuFlg = true;
                            }

                            if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn)) {
                                if (naibusisuutumimasitrksUmuFlg) {
                                    naibusisuutumimasitrksUmuFlg = false;
                                }
                                else {
                                    getSisuuTumimasiKrkYmd(idouMeisaiDb);

                                    BizDate naibuSisuuTumimasiKrkYmd = sisuuTumimasiKrkYmd;

                                    if (BizDateUtil.compareYmd(naibuSisuuTumimasiKrkYmd, idouMeisai.getSyoruiukeymd()) == BizDateUtil.COMPARE_GREATER) {

                                        naibuFlg = true;
                                        teiseiLst.add(idouMeisaiDb);

                                        idouMeisaiDb.setKouryokuhasseiymd(naibuSisuuTumimasiKrkYmd);
                                        idouMeisaiDb.detach();

                                        if (syonoBefore.equals(idouMeisai.getSyono()) &&
                                            BizDateUtil.compareYmd(syoriYmdBefore, idouMeisai.getSyoriYmd()) == BizDateUtil.COMPARE_EQUAL) {

                                            srIdouMeisaiBatchParam.setKeiyakuMFkoushinCTRrenban(
                                                srIdouMeisaiBatchParam.getKeiyakuMFkoushinCTRrenban() + 1);
                                        }
                                        else {

                                            srIdouMeisaiBatchParam.setKeiyakuMFkoushinCTRrenban(1);
                                        }

                                        syonoBefore = idouMeisai.getSyono();
                                        syoriYmdBefore = idouMeisai.getSyoriYmd();

                                        sisuuTumiMasi.execute(srIdouMeisaiBatchParam,
                                            SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITRKSRECORD,
                                            idouMeisaiDb,
                                            naibuSisuuTumimasiKrkYmd,
                                            idouMeisai.getHenkousikibetukey(),
                                            idouMeisai.getSyoriYmd());
                                    }
                                }
                            }

                            if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(suuriIdoKbn)) {
                                getTargetTkKykHenkoYmd(idouMeisaiDb);

                                BizDate wkTargetTkykkykhenkoYmd = targetTkykkykhenkoYmd;

                                if ((BizDateUtil.compareYmd(wkTargetTkykkykhenkoYmd,
                                    idouMeisai.getSyoruiukeymd()) == BizDateUtil.COMPARE_GREATER) &&
                                    idouMeisaiDb.getHenkousikibetukey().compareTo(idouMeisai.getHenkousikibetukey()) < 0) {

                                    naibuFlg = true;
                                    teiseiLst.add(idouMeisaiDb);

                                    idouMeisaiDb.setTargettkykkykhenkoymd(wkTargetTkykkykhenkoYmd);
                                    idouMeisaiDb.detach();

                                    if (syonoBefore.equals(idouMeisai.getSyono()) &&
                                        BizDateUtil.compareYmd(syoriYmdBefore, idouMeisai.getSyoriYmd()) == BizDateUtil.COMPARE_EQUAL) {

                                        srIdouMeisaiBatchParam.setKeiyakuMFkoushinCTRrenban(
                                            srIdouMeisaiBatchParam.getKeiyakuMFkoushinCTRrenban() + 1);
                                    }
                                    else {

                                        srIdouMeisaiBatchParam.setKeiyakuMFkoushinCTRrenban(1);
                                    }

                                    syonoBefore = idouMeisai.getSyono();
                                    syoriYmdBefore = idouMeisai.getSyoriYmd();

                                    searchNaibuSeiseiSyorimaeSisuuTumimasi(idouMeisaiDb.getHenkousikibetukey(), wkIdouMeisaiList);

                                    if(syoriMaeSisuuTumimasiUmu.equals(TUMIMASI_NASI)) {
                                        naibuSeiseiRecordKbn = SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD;
                                    }
                                    else {
                                        naibuSeiseiRecordKbn = SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTRKSRECORD_TMMSGO;
                                    }

                                    mokuhrtHenkNbCreate.execute(srIdouMeisaiBatchParam,
                                        naibuSeiseiRecordKbn,
                                        idouMeisaiDb,
                                        wkTargetTkykkykhenkoYmd,
                                        idouMeisai.getHenkousikibetukey(),
                                        idouMeisai.getSyoriYmd(),
                                        idouMeisai.getSyoruiukeymd());
                                }
                            }
                        }
                    }
                }

                if (syonoBefore.equals(idouMeisai.getSyono()) && idouMeisai.getSyoriYmd().equals(syoriYmdBefore)) {

                    srIdouMeisaiBatchParam.setKeiyakuMFkoushinCTRrenban(
                        srIdouMeisaiBatchParam.getKeiyakuMFkoushinCTRrenban() + 1);
                }
                else {

                    srIdouMeisaiBatchParam.setKeiyakuMFkoushinCTRrenban(1);
                }

                syonoBefore = idouMeisai.getSyono();
                syoriYmdBefore = idouMeisai.getSyoriYmd();

                setSuuriIdoKbn(idouMeisai);

                if (C_SuuriIdoKbn.MUKOU.eq(suuriIdoKbn)) {

                    String msg = MessageUtil.getMessage(MessageId.WSA1001, "無効異動が出力されました。", idouMeisai.getSyono());

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(srIdouMeisaiBatchParam.getSyoriYmd());
                    suuriyouErrJyouhou.setKakutyoujobcd(srIdouMeisaiBatchParam.getIbKakutyoujobcd());
                    suuriyouErrJyouhou.setSyono(idouMeisai.getSyono());
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    srIdouMeisaiBatchParam.setWarningSyoriKensuu(srIdouMeisaiBatchParam.getWarningSyoriKensuu() + 1);
                }

                if (C_SuuriIdoKbn.SIBOU.eq(suuriIdoKbn)) {
                    List<JT_SiBikinkanri> siBikinkanriLst = srIdouMeisaiBatchDbAccess.getSiBikinkanrisBySyonoBknjkukbn(
                        idouMeisai.getSyono());
                    if (checkBikinShibou(siBikinkanriLst, idouMeisai.getSyoriYmd())) {
                        continue;
                    }
                } else if (C_SuuriIdoKbn.SBKAIJO.eq(suuriIdoKbn) || C_SuuriIdoKbn.MENSEKI.eq(suuriIdoKbn)) {

                    List<JT_SiBikinkanri> siBikinkanriLst = srIdouMeisaiBatchDbAccess.getSiBikinkanrisBySyonoBknjkukbn(
                        idouMeisai.getSyono());
                    if (checkBikinShibou(siBikinkanriLst, idouMeisai.getSyoriYmd())) {
                        continue;
                    }

                } else if (C_SuuriIdoKbn.KAIYAKU.eq(suuriIdoKbn) || C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn)) {
                    List<IT_KhBikinkanri> khBikinkanriLst =
                        srIdouMeisaiBatchDbAccess.getKhBikinkanrisBySyonoHenkousikibetukey(
                            idouMeisai.getSyono(), idouMeisai.getHenkousikibetukey());

                    if (checkBikinKaiyakuGengaku(khBikinkanriLst, idouMeisai.getSyoriYmd())) {
                        continue;
                    }
                } else if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn)) {
                    List<JT_SiBikinkanri> siBikinkanriLst = srIdouMeisaiBatchDbAccess.getSiBikinkanrisBySyonoBknjkukbn(
                        idouMeisai.getSyono());
                    if (checkBikinSinengappiSeiTeisei(siBikinkanriLst, idouMeisai.getSyoriYmd())) {
                        continue;
                    }
                }

                insertData(idouMeisai, idouMeisaiTyLst, idouMeisaiTyukeiyouItzHznLst);

                if (naibuFlg) {

                    for (int i = teiseiLst.size() -1; i >= 0; i--) {
                        SV_IdouMeisai teisei = teiseiLst.get(i);
                        srIdouMeisaiBatchParam.setKeiyakuMFkoushinCTRrenban(
                            srIdouMeisaiBatchParam.getKeiyakuMFkoushinCTRrenban() + 1);

                        syonoBefore = idouMeisai.getSyono();
                        syoriYmdBefore = idouMeisai.getSyoriYmd();

                        if (IKhozenCommonConstants.KINOUID_KHMKHGKHENKOU.equals(teisei.getGyoumuKousinKinou()) ||
                            IKhozenCommonConstants.KINOUID_KHBATCHMKHGKHENKOU.equals(teisei.getGyoumuKousinKinou())) {
                            searchNaibuSeiseiSyorimaeSisuuTumimasi(teisei.getHenkousikibetukey(), wkIdouMeisaiList);

                            if(syoriMaeSisuuTumimasiUmu.equals(TUMIMASI_NASI)) {
                                naibuSeiseiRecordKbn = SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD;
                            }
                            else {
                                naibuSeiseiRecordKbn = SrCommonConstants.NAIBUSSRECORDKBN_MKHRITUHKTSRECORD_TMMSGO;
                            }

                            mokuhrtHenkNbCreate.execute(srIdouMeisaiBatchParam,
                                naibuSeiseiRecordKbn,
                                teisei,
                                teisei.getTargettkykkykhenkoymd(),
                                idouMeisai.getHenkousikibetukey(),
                                idouMeisai.getSyoriYmd(),
                                idouMeisai.getSyoruiukeymd());
                        }
                        else if (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(teisei.getGyoumuKousinKinou()) &&
                            C_SyoriKbn.TMTTKNHANEI.eq(teisei.getSyorikbn())) {

                            sisuuTumiMasi.execute(srIdouMeisaiBatchParam,
                                SrCommonConstants.NAIBUSSRECORDKBN_SISUUTUMIMASITSRECORD,
                                teisei,
                                teisei.getKouryokuhasseiymd(),
                                idouMeisai.getHenkousikibetukey(),
                                idouMeisai.getSyoriYmd());
                        }
                    }
                }
            }
        }

        if (srIdouMeisaiBatchParam.getErrorSyoriKensuu() != 0 &&
            (SrIdouMeisaiBatchParam.RGHBM000.equals(srIdouMeisaiBatchParam.getIbKakutyoujobcd()) ||
                SrIdouMeisaiBatchParam.RGHBM004.equals(srIdouMeisaiBatchParam.getIbKakutyoujobcd()))) {

            throw new BizAppException(MessageId.ISA1001, "数理用エラー情報テーブル",
                String.valueOf(srIdouMeisaiBatchParam.getErrorSyoriKensuu()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SRIDMEISAIINFOTABLE,
            String.valueOf(tableCount + mokuhrtHenkNbCreate.getTableCount())));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "異動明細中継用一時保存テーブル",
            String.valueOf(itTableCount + mokuhrtHenkNbCreate.getItTableCount())));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
            String.valueOf(srIdouMeisaiBatchParam.getErrorSyoriKensuu())));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル（警告）",
            String.valueOf(srIdouMeisaiBatchParam.getWarningSyoriKensuu())));
    }

    private void insertData(SV_IdouMeisai pIdouMeisai, EntityInserter<ZT_IdouMeisaiTy> zTIdouMeisaiTy,
        EntityInserter<ST_IdouMeisaiTyukeiyouItzHzn> sTIdouMeisaiTyukeiyouItzHzn) {

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess =
            SWAKInjector.getInstance(SrIdouMeisaiBatchDbAccess.class);

        List<SV_KiykSyuhnData> svKiykSyuhnDataLst = srIdouMeisaiBatchDbAccess.getKiykSyuhnData(
            pIdouMeisai.getSyono(),
            C_SyutkKbn.SYU);

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
            SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);
        SetHokenNenrei setHokenNenrei = SWAKInjector.getInstance(SetHokenNenrei.class);
        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanAto =
            SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBeanMae =
            SWAKInjector.getInstance(TkJitenKeiyakuSyouhinKijyunBean.class);
        int hhknnenBe = 0;
        int hhknnenAf = 0;
        BizDate targettkykkykhenkoymd = null;
        BizDate kouryokuhasseiymd = null;

        if (C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn) || C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn)||
            C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn) || C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn) ||
            C_SuuriIdoKbn.TEIRITUITEN.eq(suuriIdoKbn) || C_SuuriIdoKbn.TEIRITUITENTRKS.eq(suuriIdoKbn) ||
            C_SuuriIdoKbn.HARAIKATAHNK.eq(suuriIdoKbn)) {

            TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                C_TokutejitenSyoriKbn.TOKUTEIIDOUSYOUHININFO,
                pIdouMeisai.getSyono(),
                null,
                pIdouMeisai.getHenkousikibetukey(),
                svKiykSyuhnDataLst);

            tkJitenKeiyakuSyouhinKijyunBeanAto = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();
            tkJitenKeiyakuSyouhinKijyunBeanMae = tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanMae();

            if (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn) || C_SuuriIdoKbn.TEIRITUITENTRKS.eq(suuriIdoKbn)) {

                if (svKiykSyuhnDataLst.size() > 0) {

                    for (SV_KiykSyuhnData kiykSyuhnData : svKiykSyuhnDataLst) {

                        if ((IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(kiykSyuhnData.getGyoumuKousinKinou()) ||
                            (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(kiykSyuhnData.getGyoumuKousinKinou()) &&
                                C_SyoriKbn.TMTTKNHANEI_ITEN.eq(kiykSyuhnData.getSyorikbn())))
                                && kiykSyuhnData.getHenkousikibetukey().compareTo(pIdouMeisai.getHenkousikibetukey()) < 0) {

                            kouryokuhasseiymd = kiykSyuhnData.getKouryokuhasseiymd();
                            break;
                        }
                    }
                }

            }
            else {
                kouryokuhasseiymd = tkJitenKeiyakuSyouhinKijyunBeanAto.getKouryokuhasseiymd();
            }

            if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn)) {

                int hhknnen = setHokenNenrei.exec(
                    tkJitenKeiyakuSyouhinKijyunBeanMae.getKykymd(),
                    tkJitenKeiyakuSyouhinKijyunBeanMae.getHhknseiymd());

                if (tkJitenKeiyakuSyouhinKijyunBeanMae.getHhknnen() != hhknnen) {

                    hhknnenBe = 1;
                }

                hhknnen = setHokenNenrei.exec(
                    tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd(),
                    tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknseiymd());

                if (tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknnen() != hhknnen) {

                    hhknnenAf = 1;
                }

                if (tkJitenKeiyakuSyouhinKijyunBeanMae.getHhknnen().
                    equals(tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknnen()) &&
                    tkJitenKeiyakuSyouhinKijyunBeanMae.getHhknsei().
                    equals(tkJitenKeiyakuSyouhinKijyunBeanAto.getHhknsei()) && hhknnenBe == hhknnenAf) {

                    return;
                }
            }
        }
        else if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(suuriIdoKbn)) {

            targettkykkykhenkoymd = pIdouMeisai.getTargettkykkykhenkoymd();

            if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(), targettkykkykhenkoymd) ==
                BizDateUtil.COMPARE_LESSER || targettkykkykhenkoymd == null ) {

                List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targettkykkykhenkoymdRirekiBeanList =
                    srIdouMeisaiBatchDbAccess.getTargetTokuyakuBefaAftKykhenkoYmdList(
                        pIdouMeisai.getSyono(), pIdouMeisai.getHenkousikibetukey() );

                targettkykkykhenkoymd = BizDate.valueOf(targettkykkykhenkoymdRirekiBeanList.get(0)
                    .getNewnaiyouoriginal());
            }

            kouryokuhasseiymd = targettkykkykhenkoymd;

            for (SV_KiykSyuhnData kiykSyuhnData : svKiykSyuhnDataLst) {
                if (kiykSyuhnData.getHenkousikibetukey().compareTo(pIdouMeisai.getHenkousikibetukey()) < 0) {

                    BeanUtil.copyProperties(tkJitenKeiyakuSyouhinKijyunBeanAto, kiykSyuhnData);
                    BeanUtil.copyProperties(tkJitenKeiyakuSyouhinKijyunBeanMae, kiykSyuhnData);

                    tkJitenKeiyakuSyouhinKijyunBeanAto.setSyutkKbn(kiykSyuhnData.getSyutkkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setSyutkKbn(kiykSyuhnData.getSyutkkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setYuukousyoumetuKbn(kiykSyuhnData.getYuukousyoumetukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setYuukousyoumetuKbn(kiykSyuhnData.getYuukousyoumetukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setKykymdsiteiumuKbn(kiykSyuhnData.getKykymdsiteiumukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setKykymdsiteiumuKbn(kiykSyuhnData.getKykymdsiteiumukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setHknkknsmnKbn(kiykSyuhnData.getHknkknsmnkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setHknkknsmnKbn(kiykSyuhnData.getHknkknsmnkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setHrkkknsmnKbn(kiykSyuhnData.getHrkkknsmnkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setHrkkknsmnKbn(kiykSyuhnData.getHrkkknsmnkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setKataKbn(kiykSyuhnData.getKatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setKataKbn(kiykSyuhnData.getKatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setKyhgndkataKbn(kiykSyuhnData.getKyhgndkatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setKyhgndkataKbn(kiykSyuhnData.getKyhgndkatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setSyukyhkinkataKbn(kiykSyuhnData.getSyukyhkinkatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setSyukyhkinkataKbn(kiykSyuhnData.getSyukyhkinkatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setKhnkyhkgbairituKbn(kiykSyuhnData.getKhnkyhkgbairitukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setKhnkyhkgbairituKbn(kiykSyuhnData.getKhnkyhkgbairitukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setPmnjtkKbn(kiykSyuhnData.getPmnjtkkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setPmnjtkKbn(kiykSyuhnData.getPmnjtkkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setTmttknitenYmd(kiykSyuhnData.getTmttknitenymd());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setTmttknitenYmd(kiykSyuhnData.getTmttknitenymd());

                    break;
                }
            }
        }
        else if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn) || C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(suuriIdoKbn)) {
            for (SV_KiykSyuhnData kiykSyuhnData : svKiykSyuhnDataLst) {
                if (kiykSyuhnData.getHenkousikibetukey().compareTo(pIdouMeisai.getHenkousikibetukey()) < 0) {

                    BeanUtil.copyProperties(tkJitenKeiyakuSyouhinKijyunBeanAto, kiykSyuhnData);
                    BeanUtil.copyProperties(tkJitenKeiyakuSyouhinKijyunBeanMae, kiykSyuhnData);

                    tkJitenKeiyakuSyouhinKijyunBeanAto.setSyutkKbn(kiykSyuhnData.getSyutkkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setSyutkKbn(kiykSyuhnData.getSyutkkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setYuukousyoumetuKbn(kiykSyuhnData.getYuukousyoumetukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setYuukousyoumetuKbn(kiykSyuhnData.getYuukousyoumetukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setKykymdsiteiumuKbn(kiykSyuhnData.getKykymdsiteiumukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setKykymdsiteiumuKbn(kiykSyuhnData.getKykymdsiteiumukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setHknkknsmnKbn(kiykSyuhnData.getHknkknsmnkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setHknkknsmnKbn(kiykSyuhnData.getHknkknsmnkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setHrkkknsmnKbn(kiykSyuhnData.getHrkkknsmnkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setHrkkknsmnKbn(kiykSyuhnData.getHrkkknsmnkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setKataKbn(kiykSyuhnData.getKatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setKataKbn(kiykSyuhnData.getKatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setKyhgndkataKbn(kiykSyuhnData.getKyhgndkatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setKyhgndkataKbn(kiykSyuhnData.getKyhgndkatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setSyukyhkinkataKbn(kiykSyuhnData.getSyukyhkinkatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setSyukyhkinkataKbn(kiykSyuhnData.getSyukyhkinkatakbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setKhnkyhkgbairituKbn(kiykSyuhnData.getKhnkyhkgbairitukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setKhnkyhkgbairituKbn(kiykSyuhnData.getKhnkyhkgbairitukbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setPmnjtkKbn(kiykSyuhnData.getPmnjtkkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setPmnjtkKbn(kiykSyuhnData.getPmnjtkkbn());
                    tkJitenKeiyakuSyouhinKijyunBeanAto.setTmttknitenYmd(kiykSyuhnData.getTmttknitenymd());
                    tkJitenKeiyakuSyouhinKijyunBeanMae.setTmttknitenYmd(kiykSyuhnData.getTmttknitenymd());

                    break;
                }
            }

            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tkJitenKeiyakuSyouhinKijyunBeanAto.getTmttknhaibunjyoutai())) {

                return;
            }
        }
        else {

            if (C_SuuriIdoKbn.MUKOU.eq(suuriIdoKbn)) {

                tkJitenKeiyakuSyouhinKijyunBeanAto = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    pIdouMeisai.getSyono(),
                    svKiykSyuhnDataLst.get(0).getSknnkaisiymd(),
                    "",
                    svKiykSyuhnDataLst).getTkJitenKeiyakuSyouhinKijyunBeanAto();
            }
            else {

                tkJitenKeiyakuSyouhinKijyunBeanAto = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    pIdouMeisai.getSyono(),
                    pIdouMeisai.getSyoriYmd(),
                    "",
                    svKiykSyuhnDataLst).getTkJitenKeiyakuSyouhinKijyunBeanAto();
            }
        }

        int syouhinUtilResult = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBeanAto.getSyouhncd());

        BizDate idoubtKrkHasseiymd = null;

        if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ||
            (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            tkJitenKeiyakuSyouhinKijyunBeanMae != null &&
            tkJitenKeiyakuSyouhinKijyunBeanMae.getYendthnkymd() != null) ||
            (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
            tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() != null) ) {

            if (C_SuuriIdoKbn.KAIYAKU.eq(suuriIdoKbn) || C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = pIdouMeisai.getSyoruiukeymd();
            }
            else if(C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = pIdouMeisai.getSyoriYmd();
            }
            else if (C_SuuriIdoKbn.KYKTORIKESI.eq(suuriIdoKbn)||
                C_SuuriIdoKbn.CLGOFF.eq(suuriIdoKbn)||
                C_SuuriIdoKbn.MUKOU.eq(suuriIdoKbn)) {

                if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(),
                    tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd()) == BizDateUtil.COMPARE_LESSER) {
                    idoubtKrkHasseiymd = pIdouMeisai.getSyoriYmd();
                }
                else {
                    idoubtKrkHasseiymd = tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd();
                }
            }
            else if (C_SuuriIdoKbn.KAIJO.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = pIdouMeisai.getKouryokuhasseiymd();
            }
            else if (C_SuuriIdoKbn.SBKAIJO.eq(suuriIdoKbn) ||
                C_SuuriIdoKbn.MENSEKI.eq(suuriIdoKbn) ||
                C_SuuriIdoKbn.SBMUKOU_KIHRKPSHR.eq(suuriIdoKbn) ||
                C_SuuriIdoKbn.SBMUKOU_SHRNASI.eq(suuriIdoKbn) ||
                C_SuuriIdoKbn.SIBOU.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = tkJitenKeiyakuSyouhinKijyunBeanAto.getSyoumetuymd();
            }
            else if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = targettkykkykhenkoymd;
            }
            else if (C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd();
            }
            else if (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = tkJitenKeiyakuSyouhinKijyunBeanMae.getYendthnkymd();
            }
            else if (C_SuuriIdoKbn.TEIRITUITEN.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = tkJitenKeiyakuSyouhinKijyunBeanAto.getTmttknitenYmd();
            }
            else if (C_SuuriIdoKbn.TEIRITUITENTRKS.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = tkJitenKeiyakuSyouhinKijyunBeanMae.getTmttknitenYmd();
            }
            else if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn) || C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(suuriIdoKbn)) {

                idoubtKrkHasseiymd = tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd();
            }

        }

        IT_KhSisuurendoTmttkn khSisuurendoTmttknMae;
        IT_KhSisuurendoTmttkn khSisuurendoTmttknAto;
        BizDate tmttkinInfoSyutokuKijyunYmd = null;
        String naibuRcdKbn = "";
        String nbHoseiHenkSkbtkey = "";

        if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

            khSisuurendoTmttknMae = new IT_KhSisuurendoTmttkn();
            khSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();

            tmttkinInfoSyutokuKijyunYmd = idoubtKrkHasseiymd;

            if ((tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() == null) ||
                (C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn)) ||
                (C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn)) ) {

                if (BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd(),
                    tmttkinInfoSyutokuKijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd(),
                        tmttkinInfoSyutokuKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {

                    SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo = SWAKInjector
                        .getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

                    if (C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn) ||
                        C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn) ||
                        C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(suuriIdoKbn) ||
                        C_SuuriIdoKbn.TEIRITUITEN.eq(suuriIdoKbn) ||
                        C_SuuriIdoKbn.TEIRITUITENTRKS.eq(suuriIdoKbn)) {

                        List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
                            .exec(pIdouMeisai.getSyono(), null, pIdouMeisai.getHenkousikibetukey(), svKiykSyuhnDataLst);

                        KhSisuurendoTmttknBean khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                            .getSisuurendoTmttknInfo(null, pIdouMeisai.getHenkousikibetukey(),
                                srGetTokutejitenTmttknInfoBeanLst);
                        khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();
                        khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                        if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn)) {

                            tmttkinInfoSyutokuKijyunYmd = khSisuurendoTmttknAto.getTmttknkouryokukaisiymd();
                            kouryokuhasseiymd = khSisuurendoTmttknAto.getTmttknkouryokukaisiymd();

                        }
                        else if (C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(suuriIdoKbn)) {

                            tmttkinInfoSyutokuKijyunYmd = khSisuurendoTmttknMae.getTmttknkouryokukaisiymd();
                            kouryokuhasseiymd = khSisuurendoTmttknMae.getTmttknkouryokukaisiymd();

                        }

                        if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn) ||
                            C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(suuriIdoKbn)) {

                            selectSokyuuGengaku(pIdouMeisai,
                                tmttkinInfoSyutokuKijyunYmd);

                            if (sokyuuGengakuUmuFlg) {

                                srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
                                    .exec(pIdouMeisai.getSyono(), null, sokyuuGengakuHenkousikibetukey, svKiykSyuhnDataLst);

                                khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                                    .getSisuurendoTmttknInfo(null, sokyuuGengakuHenkousikibetukey,
                                        srGetTokutejitenTmttknInfoBeanLst);

                                if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn)) {
                                    khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();
                                }
                                else {
                                    khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();
                                }

                                List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiLst =
                                    srIdouMeisaiBatchDbAccess.getKhHenkouRirekis(pIdouMeisai.getSyono(),
                                        sokyuuGengakuHenkousikibetukey,
                                        ITKHSISUURENDOTMTTKN,
                                        SISUURENDOUTMTTKNGN);

                                if (khHenkouRirekiLst.size() > 0) {
                                    if (C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn)) {
                                        khSisuurendoTmttknAto.setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal()),
                                            khSisuurendoTmttknAto.getSisuurendoutmttkngk().getType()));
                                    }
                                    else {
                                        khSisuurendoTmttknMae.setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal()),
                                            khSisuurendoTmttknMae.getSisuurendoutmttkngk().getType()));
                                    }
                                }

                                naibuRcdKbn = SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD;
                                nbHoseiHenkSkbtkey = sokyuuGengakuHenkousikibetukey;
                            }
                        }
                    }
                    else {

                        if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn) ||
                            C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(suuriIdoKbn)) {

                            List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                                srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisai.getSyono(),
                                    null, pIdouMeisai.getHenkousikibetukey(), svKiykSyuhnDataLst);

                            KhSisuurendoTmttknBean khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                                .getSisuurendoTmttknInfo(tmttkinInfoSyutokuKijyunYmd, pIdouMeisai.getHenkousikibetukey(),
                                    srGetTokutejitenTmttknInfoBeanLst);

                            khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                            khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();

                            if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(suuriIdoKbn)) {

                                selectSokyuuGengaku(pIdouMeisai,
                                    tmttkinInfoSyutokuKijyunYmd);

                                if (sokyuuGengakuUmuFlg) {

                                    List<SV_IdouMeisai> wkIdouMeisaiList= new ArrayList<SV_IdouMeisai>();

                                    try (ExDBResults<SV_IdouMeisai> idouMeisaiList = srIdouMeisaiBatchDbAccess.getIdouMeisaiSokyuukikannai(
                                        pIdouMeisai.getSyono(),
                                        C_SyutkKbn.SYU,
                                        sokyuuGengakuSyoruiUkeYmd,
                                        sokyuuGengakuSyoriYmd,
                                        sokyuuGengakuHenkousikibetukey);
                                        ) {

                                        for (SV_IdouMeisai idouMeisaiDb : idouMeisaiList) {
                                            wkIdouMeisaiList.add(idouMeisaiDb);
                                        }
                                    }

                                    searchNaibuSeiseiSyorimaeSisuuTumimasi(pIdouMeisai.getHenkousikibetukey(), wkIdouMeisaiList);

                                    if (TUMIMASI_NASI.equals(syoriMaeSisuuTumimasiUmu)) {

                                        srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
                                            .exec(pIdouMeisai.getSyono(), null, sokyuuGengakuHenkousikibetukey, svKiykSyuhnDataLst);

                                        khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                                            .getSisuurendoTmttknInfo(null, sokyuuGengakuHenkousikibetukey,
                                                srGetTokutejitenTmttknInfoBeanLst);

                                        khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();
                                        khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknMae();

                                        naibuRcdKbn = SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD;
                                    }
                                    else if (TUMIMASI_ARI.equals(syoriMaeSisuuTumimasiUmu)) {

                                        String tmttkngkkomukuID = "";

                                        if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tkJitenKeiyakuSyouhinKijyunBeanAto.getTmttknhaibunjyoutai())) {

                                            tmttkngkkomukuID = TEIRITUTMTTKNGK;
                                        }
                                        else {

                                            tmttkngkkomukuID = SISUURENDOUTMTTKNGN;
                                        }

                                        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> khHenkouRirekiLst =
                                            srIdouMeisaiBatchDbAccess.getKhHenkouRirekis(pIdouMeisai.getSyono(),
                                                sokyuuGengakuHenkousikibetukey,
                                                ITKHSISUURENDOTMTTKN,
                                                tmttkngkkomukuID);

                                        if (khHenkouRirekiLst.size() > 0) {
                                            if(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tkJitenKeiyakuSyouhinKijyunBeanAto.getTmttknhaibunjyoutai())) {

                                                khSisuurendoTmttknMae.setTeiritutmttkngk(BizCurrency.valueOf(new BigDecimal(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal()),
                                                    khSisuurendoTmttknMae.getTeiritutmttkngk().getType()));
                                                khSisuurendoTmttknAto.setTeiritutmttkngk(BizCurrency.valueOf(new BigDecimal(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal()),
                                                    khSisuurendoTmttknAto.getTeiritutmttkngk().getType()));
                                            }
                                            else {

                                                khSisuurendoTmttknMae.setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal()),
                                                    khSisuurendoTmttknMae.getSisuurendoutmttkngk().getType()));
                                                khSisuurendoTmttknAto.setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(khHenkouRirekiLst.get(0).getBfrnaiyouoriginal()),
                                                    khSisuurendoTmttknAto.getSisuurendoutmttkngk().getType()));
                                            }
                                        }

                                        naibuRcdKbn = SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD_TMMSGO;
                                    }

                                    nbHoseiHenkSkbtkey = sokyuuGengakuHenkousikibetukey;
                                }
                            }
                        }
                        else {
                            if (C_SuuriIdoKbn.MUKOU.eq(suuriIdoKbn)) {

                                List<IT_KhSisuurendoTmttkn>  khSisuurendoTmttknLst = srIdouMeisaiBatchDbAccess.
                                    getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pIdouMeisai.getSyono(), tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd());

                                khSisuurendoTmttknAto = khSisuurendoTmttknLst.get(0);
                            }
                            else {
                                List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst =
                                    srGetTokutejitenSisuurendoTmttknInfo.exec(pIdouMeisai.getSyono(),
                                        tmttkinInfoSyutokuKijyunYmd, null, svKiykSyuhnDataLst);

                                KhSisuurendoTmttknBean khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
                                    .getSisuurendoTmttknInfo(tmttkinInfoSyutokuKijyunYmd, null, srGetTokutejitenTmttknInfoBeanLst);

                                if (C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn) ||
                                    C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn)) {

                                    khSisuurendoTmttknMae = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                                    khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                                }
                                else {

                                    khSisuurendoTmttknAto = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto();
                                }
                            }
                        }
                    }
                }
                else {
                    List<IT_KhSisuurendoTmttkn>  khSisuurendoTmttknLst = srIdouMeisaiBatchDbAccess.
                        getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(pIdouMeisai.getSyono(), tkJitenKeiyakuSyouhinKijyunBeanAto.getKykymd());

                    khSisuurendoTmttknMae = khSisuurendoTmttknLst.get(0);
                    khSisuurendoTmttknAto = khSisuurendoTmttknLst.get(0);
                }
            }

        }
        else {

            khSisuurendoTmttknMae = new IT_KhSisuurendoTmttkn();
            khSisuurendoTmttknAto = new IT_KhSisuurendoTmttkn();

            if ((syouhinUtilResult == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                tkJitenKeiyakuSyouhinKijyunBeanMae != null &&
                tkJitenKeiyakuSyouhinKijyunBeanMae.getYendthnkymd() != null) ||
                (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() != null)) {

                tmttkinInfoSyutokuKijyunYmd = idoubtKrkHasseiymd;
            }

            if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(suuriIdoKbn)) {

                naibuRcdKbn = "";
                nbHoseiHenkSkbtkey = "";

                selectSokyuuGengaku(pIdouMeisai,
                    kouryokuhasseiymd);

                if (sokyuuGengakuUmuFlg) {

                    naibuRcdKbn = SrCommonConstants.NAIBUSSRECORDKBN_HISOKYUUIDOURECORD;
                    nbHoseiHenkSkbtkey = sokyuuGengakuHenkousikibetukey;
                }
            }
        }


        List<IT_KykSyouhnHnkmae> kykSyouhnHnkmaeLst ;

        kykSyouhnHnkmaeLst = srIdouMeisaiBatchDbAccess.getKykSyouhnHnkmaes(pIdouMeisai.getSyono());

        List<IT_HokenryouTmttkn> hokenryouTmttknLst = new ArrayList<IT_HokenryouTmttkn>();
        if (syouhinUtilResult == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN  &&
            !C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn)) {

            hokenryouTmttknLst = srIdouMeisaiBatchDbAccess.getHokenryouTmttkns(
                pIdouMeisai.getSyono(),
                BizDateYM.valueOf(SrCommonConstants.YM_ALL9));
        }

        SrIdouMeisaiBatchEdit srIdouMeisaiBatchEdit = SWAKInjector.getInstance(SrIdouMeisaiBatchEdit.class);
        ZT_IdouMeisaiTy zTIdouMeisaiTyDec = new ZT_IdouMeisaiTy();
        ZT_IdouMeisaiTy zTIdouMeisaiTyAdd = new ZT_IdouMeisaiTy();
        ZT_IdouMeisaiTy zTIdouMeisaiTySin = new ZT_IdouMeisaiTy();
        ST_IdouMeisaiTyukeiyouItzHzn sTIdouMeisaiTyukeiyouItzHznDec = new ST_IdouMeisaiTyukeiyouItzHzn();
        ST_IdouMeisaiTyukeiyouItzHzn sTIdouMeisaiTyukeiyouItzHznAdd = new ST_IdouMeisaiTyukeiyouItzHzn();
        ST_IdouMeisaiTyukeiyouItzHzn sTIdouMeisaiTyukeiyouItzHznSin = new ST_IdouMeisaiTyukeiyouItzHzn();
        ZT_IdouMeisaiTy idouMeisaiTySisuuTumimasiDec = new ZT_IdouMeisaiTy();
        ZT_IdouMeisaiTy idouMeisaiTySisuuTumimasiAdd = new ZT_IdouMeisaiTy();
        ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHznSisuuTumimasiDec = new ST_IdouMeisaiTyukeiyouItzHzn();
        ST_IdouMeisaiTyukeiyouItzHzn idouMeisaiTyukeiyouItzHznSisuuTumimasiAdd = new ST_IdouMeisaiTyukeiyouItzHzn();
        boolean editKoumokuErrorFlag = false;

        if (C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn) || C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn) ||
            (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn) && C_SyoriKbn.SEIBETUHENKOU.eq(pIdouMeisai.getSyorikbn()))
            || C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(suuriIdoKbn) || C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn) ||
            C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn) || C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn) ||
            C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(suuriIdoKbn)||
            C_SuuriIdoKbn.HARAIKATAHNK.eq(suuriIdoKbn)) {

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanMae,
                zTIdouMeisaiTyDec,
                suuriIdoKbn,
                C_IdouRecordKbn.MINUSRECORD,
                kouryokuhasseiymd,
                sTIdouMeisaiTyukeiyouItzHznDec,
                syouhinUtilResult,
                khSisuurendoTmttknMae,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                naibuRcdKbn,
                null,
                nbHoseiHenkSkbtkey);

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                zTIdouMeisaiTyAdd,
                suuriIdoKbn,
                C_IdouRecordKbn.PLUSRECORD,
                kouryokuhasseiymd,
                sTIdouMeisaiTyukeiyouItzHznAdd,
                syouhinUtilResult,
                khSisuurendoTmttknAto,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                naibuRcdKbn,
                null,
                nbHoseiHenkSkbtkey);
        }
        else if (C_SuuriIdoKbn.TEIRITUITEN.eq(suuriIdoKbn)) {

            IT_KhSisuurendoTmttkn khSisuurendoTmttknHoseigo = new IT_KhSisuurendoTmttkn();

            BeanUtil.copyProperties(khSisuurendoTmttknHoseigo, khSisuurendoTmttknAto);
            khSisuurendoTmttknHoseigo.setTeiritutmttkngk(khSisuurendoTmttknAto.getItenmaeteiritutmttkngk());
            khSisuurendoTmttknHoseigo.setSisuurendoutmttkngk(khSisuurendoTmttknAto.getItenmaesisuurendoutmttkngk());

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanMae,
                idouMeisaiTySisuuTumimasiDec,
                C_SuuriIdoKbn.SISUUTUMIMASI,
                C_IdouRecordKbn.MINUSRECORD,
                kouryokuhasseiymd,
                idouMeisaiTyukeiyouItzHznSisuuTumimasiDec,
                syouhinUtilResult,
                khSisuurendoTmttknMae,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                "",
                null,
                "");

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanMae,
                idouMeisaiTySisuuTumimasiAdd,
                C_SuuriIdoKbn.SISUUTUMIMASI,
                C_IdouRecordKbn.PLUSRECORD,
                kouryokuhasseiymd,
                idouMeisaiTyukeiyouItzHznSisuuTumimasiAdd,
                syouhinUtilResult,
                khSisuurendoTmttknHoseigo,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                "",
                null,
                "");

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanMae,
                zTIdouMeisaiTyDec,
                suuriIdoKbn,
                C_IdouRecordKbn.MINUSRECORD,
                kouryokuhasseiymd,
                sTIdouMeisaiTyukeiyouItzHznDec,
                syouhinUtilResult,
                khSisuurendoTmttknHoseigo,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                "",
                null,
                "");

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                zTIdouMeisaiTyAdd,
                suuriIdoKbn,
                C_IdouRecordKbn.PLUSRECORD,
                kouryokuhasseiymd,
                sTIdouMeisaiTyukeiyouItzHznAdd,
                syouhinUtilResult,
                khSisuurendoTmttknAto,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                "",
                null,
                "");
        }
        else if (C_SuuriIdoKbn.TEIRITUITENTRKS.eq(suuriIdoKbn)) {

            IT_KhSisuurendoTmttkn khSisuurendoTmttknHoseigo = new IT_KhSisuurendoTmttkn();

            BeanUtil.copyProperties(khSisuurendoTmttknHoseigo, khSisuurendoTmttknMae);
            khSisuurendoTmttknHoseigo.setTeiritutmttkngk(khSisuurendoTmttknMae.getItenmaeteiritutmttkngk());
            khSisuurendoTmttknHoseigo.setSisuurendoutmttkngk(khSisuurendoTmttknMae.getItenmaesisuurendoutmttkngk());

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanMae,
                zTIdouMeisaiTyDec,
                suuriIdoKbn,
                C_IdouRecordKbn.MINUSRECORD,
                kouryokuhasseiymd,
                sTIdouMeisaiTyukeiyouItzHznDec,
                syouhinUtilResult,
                khSisuurendoTmttknMae,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                "",
                null,
                "");

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                zTIdouMeisaiTyAdd,
                suuriIdoKbn,
                C_IdouRecordKbn.PLUSRECORD,
                kouryokuhasseiymd,
                sTIdouMeisaiTyukeiyouItzHznAdd,
                syouhinUtilResult,
                khSisuurendoTmttknHoseigo,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                "",
                null,
                "");

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                idouMeisaiTySisuuTumimasiDec,
                C_SuuriIdoKbn.SISUUTUMIMASITRKS,
                C_IdouRecordKbn.MINUSRECORD,
                kouryokuhasseiymd,
                idouMeisaiTyukeiyouItzHznSisuuTumimasiDec,
                syouhinUtilResult,
                khSisuurendoTmttknHoseigo,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                "",
                null,
                "");

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                idouMeisaiTySisuuTumimasiAdd,
                C_SuuriIdoKbn.SISUUTUMIMASITRKS,
                C_IdouRecordKbn.PLUSRECORD,
                kouryokuhasseiymd,
                idouMeisaiTyukeiyouItzHznSisuuTumimasiAdd,
                syouhinUtilResult,
                khSisuurendoTmttknAto,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                "",
                null,
                "");
        }
        else {

            editKoumokuErrorFlag = srIdouMeisaiBatchEdit.editKoumoku(
                srIdouMeisaiBatchParam,
                pIdouMeisai,
                tkJitenKeiyakuSyouhinKijyunBeanAto,
                zTIdouMeisaiTySin,
                suuriIdoKbn,
                C_IdouRecordKbn.SINGLERECORD,
                null,
                sTIdouMeisaiTyukeiyouItzHznSin,
                syouhinUtilResult,
                khSisuurendoTmttknAto,
                tmttkinInfoSyutokuKijyunYmd,
                svKiykSyuhnDataLst,
                kykSyouhnHnkmaeLst,
                hokenryouTmttknLst,
                "",
                null,
                "");
        }

        if (editKoumokuErrorFlag == true) {

            return;
        }

        if (C_SuuriIdoKbn.GENGAKU.eq(suuriIdoKbn) || C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(suuriIdoKbn) ||
            C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(suuriIdoKbn) || C_SuuriIdoKbn.YENDTHENKOU.eq(suuriIdoKbn) ||
            C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(suuriIdoKbn)  || C_SuuriIdoKbn.SISUUTUMIMASI.eq(suuriIdoKbn) ||
            C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(suuriIdoKbn)||
            C_SuuriIdoKbn.HARAIKATAHNK.eq(suuriIdoKbn)) {

            BizPropertyInitializer.initialize(zTIdouMeisaiTyDec);

            SrIdouMeisaiConverter.convertPadding(zTIdouMeisaiTyDec);

            zTIdouMeisaiTy.add(zTIdouMeisaiTyDec);

            tableCount++;

            BizPropertyInitializer.initialize(zTIdouMeisaiTyAdd);

            SrIdouMeisaiConverter.convertPadding(zTIdouMeisaiTyAdd);

            zTIdouMeisaiTy.add(zTIdouMeisaiTyAdd);

            tableCount++;

            if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznDec);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznDec);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznDec);

                itTableCount++;

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznAdd);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznAdd);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznAdd);

                itTableCount++;
            }

            if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                tkJitenKeiyakuSyouhinKijyunBeanMae.getYendthnkymd() != null) {

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznDec);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznDec);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznDec);

                itTableCount++;
            }

            if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() != null) {

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznAdd);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznAdd);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznAdd);

                itTableCount++;
            }
        }
        else if (C_SuuriIdoKbn.TEIRITUITEN.eq(suuriIdoKbn)) {

            BizPropertyInitializer.initialize(idouMeisaiTySisuuTumimasiDec);

            SrIdouMeisaiConverter.convertPadding(idouMeisaiTySisuuTumimasiDec);

            zTIdouMeisaiTy.add(idouMeisaiTySisuuTumimasiDec);

            tableCount++;

            BizPropertyInitializer.initialize(idouMeisaiTySisuuTumimasiAdd);

            SrIdouMeisaiConverter.convertPadding(idouMeisaiTySisuuTumimasiAdd);

            zTIdouMeisaiTy.add(idouMeisaiTySisuuTumimasiAdd);

            tableCount++;

            BizPropertyInitializer.initialize(zTIdouMeisaiTyDec);

            SrIdouMeisaiConverter.convertPadding(zTIdouMeisaiTyDec);

            zTIdouMeisaiTy.add(zTIdouMeisaiTyDec);

            tableCount++;

            BizPropertyInitializer.initialize(zTIdouMeisaiTyAdd);

            SrIdouMeisaiConverter.convertPadding(zTIdouMeisaiTyAdd);

            zTIdouMeisaiTy.add(zTIdouMeisaiTyAdd);

            tableCount++;

            if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                BizPropertyInitializer.initialize(idouMeisaiTyukeiyouItzHznSisuuTumimasiDec);

                SrIdouMeisaiConverter.convertPadding(idouMeisaiTyukeiyouItzHznSisuuTumimasiDec);

                sTIdouMeisaiTyukeiyouItzHzn.add(idouMeisaiTyukeiyouItzHznSisuuTumimasiDec);

                itTableCount++;

                BizPropertyInitializer.initialize(idouMeisaiTyukeiyouItzHznSisuuTumimasiAdd);

                SrIdouMeisaiConverter.convertPadding(idouMeisaiTyukeiyouItzHznSisuuTumimasiAdd);

                sTIdouMeisaiTyukeiyouItzHzn.add(idouMeisaiTyukeiyouItzHznSisuuTumimasiAdd);

                itTableCount++;

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznDec);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznDec);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznDec);

                itTableCount++;

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznAdd);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznAdd);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznAdd);

                itTableCount++;
            }
        }
        else if (C_SuuriIdoKbn.TEIRITUITENTRKS.eq(suuriIdoKbn)) {

            BizPropertyInitializer.initialize(zTIdouMeisaiTyDec);

            SrIdouMeisaiConverter.convertPadding(zTIdouMeisaiTyDec);

            zTIdouMeisaiTy.add(zTIdouMeisaiTyDec);

            tableCount++;

            BizPropertyInitializer.initialize(zTIdouMeisaiTyAdd);

            SrIdouMeisaiConverter.convertPadding(zTIdouMeisaiTyAdd);

            zTIdouMeisaiTy.add(zTIdouMeisaiTyAdd);

            tableCount++;

            BizPropertyInitializer.initialize(idouMeisaiTySisuuTumimasiDec);

            SrIdouMeisaiConverter.convertPadding(idouMeisaiTySisuuTumimasiDec);

            zTIdouMeisaiTy.add(idouMeisaiTySisuuTumimasiDec);

            tableCount++;

            BizPropertyInitializer.initialize(idouMeisaiTySisuuTumimasiAdd);

            SrIdouMeisaiConverter.convertPadding(idouMeisaiTySisuuTumimasiAdd);

            zTIdouMeisaiTy.add(idouMeisaiTySisuuTumimasiAdd);

            tableCount++;

            if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznDec);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznDec);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznDec);

                itTableCount++;

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznAdd);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznAdd);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznAdd);

                itTableCount++;

                BizPropertyInitializer.initialize(idouMeisaiTyukeiyouItzHznSisuuTumimasiDec);

                SrIdouMeisaiConverter.convertPadding(idouMeisaiTyukeiyouItzHznSisuuTumimasiDec);

                sTIdouMeisaiTyukeiyouItzHzn.add(idouMeisaiTyukeiyouItzHznSisuuTumimasiDec);

                itTableCount++;

                BizPropertyInitializer.initialize(idouMeisaiTyukeiyouItzHznSisuuTumimasiAdd);

                SrIdouMeisaiConverter.convertPadding(idouMeisaiTyukeiyouItzHznSisuuTumimasiAdd);

                sTIdouMeisaiTyukeiyouItzHzn.add(idouMeisaiTyukeiyouItzHznSisuuTumimasiAdd);

                itTableCount++;
            }
        }
        else {

            BizPropertyInitializer.initialize(zTIdouMeisaiTySin);

            SrIdouMeisaiConverter.convertPadding(zTIdouMeisaiTySin);

            zTIdouMeisaiTy.add(zTIdouMeisaiTySin);

            tableCount++;

            if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                syouhinUtilResult == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznSin);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznSin);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznSin);

                itTableCount++;

            }

            if (syouhinUtilResult == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 &&
                tkJitenKeiyakuSyouhinKijyunBeanAto.getYendthnkymd() != null) {

                BizPropertyInitializer.initialize(sTIdouMeisaiTyukeiyouItzHznSin);

                SrIdouMeisaiConverter.convertPadding(sTIdouMeisaiTyukeiyouItzHznSin);

                sTIdouMeisaiTyukeiyouItzHzn.add(sTIdouMeisaiTyukeiyouItzHznSin);

                itTableCount++;

            }
        }
    }

    private void setSuuriIdoKbn(SV_IdouMeisai pIdouMeisai) {

        if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            IKhozenCommonConstants.KINOUID_GENGAKU.equals(pIdouMeisai.getGyoumuKousinKinou())) {

            suuriIdoKbn = C_SuuriIdoKbn.GENGAKU;
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pIdouMeisai.getGyoumuKousinKinou())) {

            suuriIdoKbn = C_SuuriIdoKbn.SINENGAPPISEITEISEI;
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            (IKhozenCommonConstants.KINOUID_KHMKHGKHENKOU.equals(pIdouMeisai.getGyoumuKousinKinou()) ||
                IKhozenCommonConstants.KINOUID_KHBATCHMKHGKHENKOU.equals(pIdouMeisai.getGyoumuKousinKinou()))) {

            suuriIdoKbn = C_SuuriIdoKbn.MOKUHYOURITUHENKOU;
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK.equals(pIdouMeisai.getGyoumuKousinKinou())) {

            suuriIdoKbn = C_SuuriIdoKbn.YENDTHENKOU;
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(pIdouMeisai.getGyoumuKousinKinou())  &&
            C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI.eq(pIdouMeisai.getSyorikbn())) {

            suuriIdoKbn = C_SuuriIdoKbn.YENDTHENKOUTRKS;
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(pIdouMeisai.getGyoumuKousinKinou())  &&
            C_SyoriKbn.TMTTKNHANEI.eq(pIdouMeisai.getSyorikbn())) {

            suuriIdoKbn = C_SuuriIdoKbn.SISUUTUMIMASI;
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(pIdouMeisai.getGyoumuKousinKinou())  &&
            C_SyoriKbn.TMTTKNHANEI_TORIKESI.eq(pIdouMeisai.getSyorikbn())) {

            suuriIdoKbn = C_SuuriIdoKbn.SISUUTUMIMASITRKS;
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(pIdouMeisai.getGyoumuKousinKinou())  &&
            C_SyoriKbn.TMTTKNHANEI_ITEN.eq(pIdouMeisai.getSyorikbn())) {

            suuriIdoKbn = C_SuuriIdoKbn.TEIRITUITEN;
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(pIdouMeisai.getGyoumuKousinKinou())  &&
            C_SyoriKbn.TMTTKNHANEI_ITEN_TORIKESI.eq(pIdouMeisai.getSyorikbn())) {

            suuriIdoKbn = C_SuuriIdoKbn.TEIRITUITENTRKS;
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null
            && IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(pIdouMeisai.getGyoumuKousinKinou())
            && ((C_SyoriKbn.KAISUUHENKOU.eq(pIdouMeisai.getSyorikbn()))
                || (C_SyoriKbn.KAISUUHENKOU_KOUZAHENKOU.eq(pIdouMeisai.getSyorikbn()))
                || (C_SyoriKbn.CRECAHENNYUU.eq(pIdouMeisai.getSyorikbn()))
                || (C_SyoriKbn.YOHURIHENNYUU.eq(pIdouMeisai.getSyorikbn()))
                || (C_SyoriKbn.TIKIKTSYURUIHENKOU_CRECAHENNYUU.eq(pIdouMeisai.getSyorikbn()))
                || (C_SyoriKbn.TIKIKTSYURUIHENKOU_YOHURIHENNYUU.eq(pIdouMeisai.getSyorikbn())))) {

            suuriIdoKbn = C_SuuriIdoKbn.HARAIKATAHNK;

        }

        else if (C_Syoumetujiyuu.KAIYAKU.eq(pIdouMeisai.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.KAIYAKU;
        }

        else if (C_Syoumetujiyuu.KYKTORIKESI.eq(pIdouMeisai.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.KYKTORIKESI;
        }

        else if (C_Syoumetujiyuu.CLGOFF.eq(pIdouMeisai.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.CLGOFF;
        }

        else if (C_Syoumetujiyuu.KAIJO.eq(pIdouMeisai.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.KAIJO;
        }

        else if (C_Syoumetujiyuu.MUKOU.eq(pIdouMeisai.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.MUKOU;
        }

        else if (C_SeikyuuSyubetu.SB.eq(pIdouMeisai.getSeikyuusyubetu())) {

            suuriIdoKbn = C_SuuriIdoKbn.SIBOU;
        }

        else if (C_Syoumetujiyuu.SBKAIJO.eq(pIdouMeisai.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.SBKAIJO;
        }

        else if (C_Syoumetujiyuu.MENSEKI.eq(pIdouMeisai.getSyoumetujiyuu())) {

            suuriIdoKbn = C_SuuriIdoKbn.MENSEKI;
        }

        else if (C_Syoumetujiyuu.SBMUKOU.eq(pIdouMeisai.getSyoumetujiyuu())) {

            if (C_SyoriKbn.SBMUKOU_KIHRKPSHR.eq(pIdouMeisai.getSyorikbn())) {

                suuriIdoKbn = C_SuuriIdoKbn.SBMUKOU_KIHRKPSHR;
            }
            else if (C_SyoriKbn.SBMUKOU_SHRNASI.eq(pIdouMeisai.getSyorikbn())
                || C_SyoriKbn.SBMUKOU.eq(pIdouMeisai.getSyorikbn())) {

                suuriIdoKbn = C_SuuriIdoKbn.SBMUKOU_SHRNASI;
            }
        }

        else if (pIdouMeisai.getGyoumuKousinKinou() != null &&
            IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU.equals(pIdouMeisai.getGyoumuKousinKinou())) {

            suuriIdoKbn = C_SuuriIdoKbn.PMINYUUSYOUMETU;
        }
    }

    private boolean checkBikinShibou(List<JT_SiBikinkanri> pSiBikinkanriLst, BizDate pSyoriYmd) {

        if (pSiBikinkanriLst.isEmpty()) {
            return false;
        }

        for (JT_SiBikinkanri siBikinkanri : pSiBikinkanriLst) {
            String kessanKijyunMd = siBikinkanri.getKessankijyunymd().getBizDateMD().toString();
            if (SrCommonConstants.FIXEDDAY_NENDOKSNBI.equals(kessanKijyunMd)) {
                if (BizDateUtil.compareYmd(siBikinkanri.getBknkktymd(), pSyoriYmd) <= BizDateUtil.COMPARE_EQUAL) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkBikinSinengappiSeiTeisei(List<JT_SiBikinkanri> pSiBikinkanriLst, BizDate pSyoriYmd) {

        if (pSiBikinkanriLst.isEmpty()) {
            return false;
        }

        SetDenSimebi setDenSimebi = SWAKInjector.getInstance(SetDenSimebi.class);

        for (JT_SiBikinkanri siBikinkanri : pSiBikinkanriLst) {
            String kessanKijyunMd = siBikinkanri.getKessankijyunymd().getBizDateMD().toString();
            if (SrCommonConstants.FIXEDDAY_NENDOKSNBI.equals(kessanKijyunMd)) {
                BizDate zengetuDenSimeYMD = setDenSimebi.exec(
                    siBikinkanri.getKessankijyunymd().addBusinessDays(SrCommonConstants.DAY_1D));
                if (BizDateUtil.compareYmd(zengetuDenSimeYMD, pSyoriYmd) == BizDateUtil.COMPARE_LESSER) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkBikinKaiyakuGengaku(List<IT_KhBikinkanri> pKhBikinkanriLst, BizDate pSyoriYmd) {

        if (pKhBikinkanriLst.isEmpty()) {
            return false;
        }

        for (IT_KhBikinkanri khBikinkanri : pKhBikinkanriLst) {
            String kessanKijyunMd = khBikinkanri.getKessankijyunymd().getBizDateMD().toString();
            if (SrCommonConstants.FIXEDDAY_NENDOKSNBI.equals(kessanKijyunMd)) {
                if (BizDateUtil.compareYmd(khBikinkanri.getBknkktymd(), pSyoriYmd) <= BizDateUtil.COMPARE_EQUAL) {
                    return true;
                }
            }
        }

        return false;
    }

    private void getTargetTkKykHenkoYmd(SV_IdouMeisai pIdouMeisai) {

        targetTkykkykhenkoYmd = pIdouMeisai.getTargettkykkykhenkoymd();

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess =
            SWAKInjector.getInstance(SrIdouMeisaiBatchDbAccess.class);

        if (BizDateUtil.compareYmd(pIdouMeisai.getSyoriYmd(),
            pIdouMeisai.getTargettkykkykhenkoymd()) == BizDateUtil.COMPARE_LESSER  ||
            pIdouMeisai.getTargettkykkykhenkoymd() == null) {

            List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetTkykkykhenkoYmdBeanLst =
                srIdouMeisaiBatchDbAccess.getTargetTokuyakuBefaAftKykhenkoYmdList(
                    pIdouMeisai.getSyono(),
                    pIdouMeisai.getHenkousikibetukey());

            targetTkykkykhenkoYmd = BizDate.valueOf(targetTkykkykhenkoYmdBeanLst.get(0).getNewnaiyouoriginal());
        }
    }

    private void getSisuuTumimasiKrkYmd(SV_IdouMeisai pIdouMeisai) {

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess =
            SWAKInjector.getInstance(SrIdouMeisaiBatchDbAccess.class);

        List<SV_KiykSyuhnData> svKiykSyuhnDataLst = srIdouMeisaiBatchDbAccess.getKiykSyuhnData(
            pIdouMeisai.getSyono(),
            C_SyutkKbn.SYU);

        sisuuTumimasiKrkYmd = svKiykSyuhnDataLst.get(0).getKykymd();

        SrGetTokutejitenSisuurendoTmttknInfo srGetTokutejitenSisuurendoTmttknInfo = SWAKInjector
            .getInstance(SrGetTokutejitenSisuurendoTmttknInfo.class);

        List<SrGetTokutejitenTmttknInfoBean> srGetTokutejitenTmttknInfoBeanLst = srGetTokutejitenSisuurendoTmttknInfo
            .exec(pIdouMeisai.getSyono(), null, pIdouMeisai.getHenkousikibetukey(), svKiykSyuhnDataLst);

        KhSisuurendoTmttknBean khSisuurendoTmttknBean = srGetTokutejitenSisuurendoTmttknInfo
            .getSisuurendoTmttknInfo(null, pIdouMeisai.getHenkousikibetukey(),
                srGetTokutejitenTmttknInfoBeanLst);

        sisuuTumimasiKrkYmd = khSisuurendoTmttknBean.getKhSisuurendoTmttknAto().getTmttknkouryokukaisiymd();
    }

    private void selectSokyuuGengaku(SV_IdouMeisai pIdouMeisai, BizDate pKouryokuHasseiYmd) {

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess =
            SWAKInjector.getInstance(SrIdouMeisaiBatchDbAccess.class);

        try (ExDBResults<SV_IdouMeisai> idouMeisaisSokyuugengakuLst = srIdouMeisaiBatchDbAccess.
            getIdouMeisaisSokyuugengaku(pIdouMeisai.getSyono(), C_SyutkKbn.SYU, pIdouMeisai.getHenkousikibetukey())) {

            sokyuuGengakuUmuFlg = false;
            sokyuuGengakuHenkousikibetukey = null;
            sokyuuGengakuSyoruiUkeYmd = null;
            sokyuuGengakuSyoriYmd = null;

            for (SV_IdouMeisai idouMeisaisSokyuugengaku : idouMeisaisSokyuugengakuLst) {

                checkSokyuuIdouBikin(idouMeisaisSokyuugengaku.getSyono(),
                    idouMeisaisSokyuugengaku.getHenkousikibetukey(), idouMeisaisSokyuugengaku.getSyoriYmd());

                if (jmtSokyuuIdouFlg) {
                    continue;
                }

                if (BizDateUtil.compareYmd(idouMeisaisSokyuugengaku.getSyoruiukeymd(), pKouryokuHasseiYmd) == BizDateUtil.COMPARE_LESSER) {

                    sokyuuGengakuUmuFlg = true;
                    sokyuuGengakuHenkousikibetukey = idouMeisaisSokyuugengaku.getHenkousikibetukey();
                    sokyuuGengakuSyoruiUkeYmd = idouMeisaisSokyuugengaku.getSyoruiukeymd();
                    sokyuuGengakuSyoriYmd = idouMeisaisSokyuugengaku.getSyoriYmd();
                }
            }
        }
    }

    private void searchNaibuSeiseiSyorimaeSisuuTumimasi(String pHenkousikibetukey, List<SV_IdouMeisai> pIdouMeisaiList) {

        syoriMaeSisuuTumimasiUmu = TUMIMASI_NASI;

        boolean sisuuTumimasiUmuFlg = false;

        for (SV_IdouMeisai idouMeisai : pIdouMeisaiList) {

            if (pHenkousikibetukey.compareTo(idouMeisai.getHenkousikibetukey()) > 0) {

                if (IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI.equals(idouMeisai.getGyoumuKousinKinou()) &&
                    C_SyoriKbn.TMTTKNHANEI_TORIKESI.eq(idouMeisai.getSyorikbn())) {

                    sisuuTumimasiUmuFlg = true;
                }

                if (IKhozenCommonConstants.KINOUID_KHSISUURENDOTMTTKNHANEI.equals(idouMeisai.getGyoumuKousinKinou()) &&
                    C_SyoriKbn.TMTTKNHANEI.eq(idouMeisai.getSyorikbn())) {

                    if (sisuuTumimasiUmuFlg) {

                        sisuuTumimasiUmuFlg = false;
                    }
                    else {

                        syoriMaeSisuuTumimasiUmu = TUMIMASI_ARI;
                    }
                }
            }
        }
    }

    private void checkSokyuuIdouBikin(String pSyonoy, String pHenkousikibetukey, BizDate pSyoriYmd) {

        jmtSokyuuIdouFlg = false;

        SrIdouMeisaiBatchDbAccess srIdouMeisaiBatchDbAccess = SWAKInjector.getInstance(SrIdouMeisaiBatchDbAccess.class);

        List<IT_KhBikinkanri> khBikinkanriLst =
            srIdouMeisaiBatchDbAccess.getKhBikinkanrisBySyonoHenkousikibetukey(pSyonoy, pHenkousikibetukey);

        for (IT_KhBikinkanri khBikinkanri :  khBikinkanriLst) {
            String kessanKijyunMd = khBikinkanri.getKessankijyunymd().getBizDateMD().toString();
            if (SrCommonConstants.FIXEDDAY_NENDOKSNBI.equals(kessanKijyunMd)) {
                if (BizDateUtil.compareYmd(khBikinkanri.getBknkktymd(), pSyoriYmd) <= BizDateUtil.COMPARE_EQUAL) {
                    jmtSokyuuIdouFlg = true;
                }
            }
        }
    }
}