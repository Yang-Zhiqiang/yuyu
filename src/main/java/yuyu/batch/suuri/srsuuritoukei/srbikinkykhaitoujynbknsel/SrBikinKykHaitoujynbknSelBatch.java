package yuyu.batch.suuri.srsuuritoukei.srbikinkykhaitoujynbknsel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.hozen.haitou.CheckDJyoutai;
import yuyu.common.hozen.haitou.KeisanDCommonKaiyaku;
import yuyu.common.hozen.haitou.KeisanDCommonSibou;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.SV_BikinKykHaitouMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 備金契約配当準備金データ抽出
 */
public class SrBikinKykHaitoujynbknSelBatch  implements Batch {

    private int tableTourokuCount;

    @Inject
    private SrBikinKykHaitoujynbknSelBatchParam batchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public SrBikinKykHaitoujynbknSelBatchParam getParam() {

        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        tableTourokuCount = 0;
        BizDate kijyunymd = batchParam.getKijyunymd();
        BizDate syoriYmd = batchParam.getSyoriYmd();
        String ibKakutyoujobcd = batchParam.getIbKakutyoujobcd();

        SrBikinKykHaitoujynbknSelBatchDbAccess dbAccess = SWAKInjector.getInstance(SrBikinKykHaitoujynbknSelBatchDbAccess.class);

        try (
            ExDBResults<SV_BikinKykHaitouMeisai> bikinKykHaitouMeisaiList = dbAccess.getBikinKykHaitouMeisais(
                C_BknrigiKbn.DEL, kijyunymd);
            EntityInserter<ST_BknkykHtjynbkn> entityInserter = new EntityInserter<>()) {

            for (SV_BikinKykHaitouMeisai bikinKykHaitouMeisai : bikinKykHaitouMeisaiList) {

                String syono = bikinKykHaitouMeisai.getSyono();

                BizDate logKijunYmd = BizDate.valueOf(20200930);
                if (kijyunymd.compareTo(logKijunYmd) == 0){

                    logInfo("1．【備金契約配当明細情報】", new String[]{"証券番号","計算基準日", "決算基準日"},
                        new Object[]{syono, bikinKykHaitouMeisai.getCalckijyunymd(),
                        bikinKykHaitouMeisai.getKessankijyunymd()});
                }


                if (C_BkncdKbn.SIBOUKARIUKETUKE.eq(bikinKykHaitouMeisai.getBkncdkbn()) ||
                    C_BkncdKbn.SIBOUUKETUKE.eq(bikinKykHaitouMeisai.getBkncdkbn())) {

                    List<JT_SiBikinkanri> siBikinkanrilist =
                        dbAccess.getSiBikinkanris(syono, bikinKykHaitouMeisai.getKessankijyunymd());

                    if (siBikinkanrilist != null && siBikinkanrilist.size() != 0) {

                        if (kijyunymd.compareTo(logKijunYmd) == 0){

                            logInfo("2．【備金コード区分の判定結果 スキップ】", new String[]{"証券番号","決算基準日"},
                                new Object[]{syono, bikinKykHaitouMeisai.getKessankijyunymd()});
                        }

                        continue;
                    }
                }

                List<SV_KiykSyuhnData> kiykSyuhnDataList = dbAccess.getKiykSyuhnDatas(syono, C_SyutkKbn.SYU);

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    syono,
                    kijyunymd,
                    "",
                    kiykSyuhnDataList);

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
                    tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                if (kijyunymd.compareTo(logKijunYmd) == 0){

                    logInfo("3．【特定時点契約商品情報の取得】",
                        new String[]{"特定時点判定処理区分","特定時点判定証券番号", "特定時点判定基準日", "特定時点判定変更識別キー"},
                        new Object[]{C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO, syono, kijyunymd, ""});

                    logInfo("4．【特定時点契約商品情報の取得　結果】",
                        new String[]{"商品コード","商品世代番号", "変更識別キー", "契約日", "円建変更日"},
                        new Object[]{tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd(), tkJitenKeiyakuSyouhinKijyunBean.getSyouhnsdno(),
                        tkJitenKeiyakuSyouhinKijyunBean.getHenkousikibetukey(), tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd()});
                }

                BizDateY haitounendo = null;

                List<IT_KhHaitouKanri> khHaitouKanrilist = dbAccess.getHaitouKanris(syono, C_HaitoumeisaiKbn.SYU,
                    bikinKykHaitouMeisai.getCalckijyunymd());

                if (kijyunymd.compareTo(logKijunYmd) == 0){

                    logInfo("5．【配当管理テーブル取得】",
                        new String[]{"証券番号", "配当明細区分", "基準日"},
                        new Object[]{syono, C_HaitoumeisaiKbn.SYU, bikinKykHaitouMeisai.getCalckijyunymd()});
                }

                if (khHaitouKanrilist != null && khHaitouKanrilist.size() > 0) {
                    haitounendo = khHaitouKanrilist.get(0).getHaitounendo();

                    if (kijyunymd.compareTo(logKijunYmd) == 0){

                        logInfo("6．【配当管理テーブル取得 結果①】",
                            new String[]{"配当年度"},
                            new Object[]{haitounendo});
                    }
                }
                List<IT_KhTumitateDKanri> khTumitateDKanriList = dbAccess.getTumitateDKanris(syono,
                    bikinKykHaitouMeisai.getCalckijyunymd());

                if (kijyunymd.compareTo(logKijunYmd) == 0){

                    logInfo("7．【配当管理テーブル取得 結果②】",
                        new String[]{"配当年度"},
                        new Object[]{haitounendo});
                }

                CheckDJyoutai checkDJyoutai = SWAKInjector.getInstance(CheckDJyoutai.class);

                C_UmuKbn haitoukinMihaneiJyoutai = checkDJyoutai.execForMibaraiHaitouHantei(
                    bikinKykHaitouMeisai.getCalckijyunymd(),
                    tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                    tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),
                    haitounendo);

                if (kijyunymd.compareTo(logKijunYmd) == 0){

                    logInfo("8．【未反映配当判定用メイン処理】",
                        new String[]{"判定基準日","契約日","円建変更日","配当年度"},
                        new Object[]{bikinKykHaitouMeisai.getCalckijyunymd(), tkJitenKeiyakuSyouhinKijyunBean.getKykymd(),
                        tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd(),haitounendo});

                    logInfo("9．【未反映配当判定用メイン処理 結果】",
                        new String[]{"配当金未反映状態"},
                        new Object[]{haitoukinMihaneiJyoutai.toString()});
                }


                if (C_UmuKbn.ARI.eq(haitoukinMihaneiJyoutai)) {

                    String msg = MessageUtil.getMessage(MessageId.ESA1005, syono);

                    batchLogger.warn(msg);

                    ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                    suuriyouErrJyouhou.setSyoriYmd(syoriYmd);
                    suuriyouErrJyouhou.setKakutyoujobcd(ibKakutyoujobcd);
                    suuriyouErrJyouhou.setSyono(syono);
                    suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                    suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

                    BizPropertyInitializer.initialize(suuriyouErrJyouhou);

                    ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                    batchParam.setErrorSyoriKensuu(batchParam.getErrorSyoriKensuu() + 1);

                    continue;
                }

                if (kijyunymd.compareTo(logKijunYmd) == 0){

                    logInfo("10．【最終】",
                        new String[]{"証券番号"},
                        new Object[]{syono});
                }

                int syouhinUtilKekka = SyouhinUtil.hantei(tkJitenKeiyakuSyouhinKijyunBean.getSyouhncd());

                JT_SiDshrTuki siDshrTuki = null;
                IT_KhDshrTuki khDshrTuki = null;
                List<JT_SiDshrTuki> siDshrTukiList = new ArrayList<JT_SiDshrTuki>();
                List<IT_KhDshrTuki> khDshrTukiList = new ArrayList<IT_KhDshrTuki>();
                BizCurrency seisSnd = BizCurrency.valueOf(0);
                BizCurrency kariwariateDGanrikin = BizCurrency.valueOf(0);
                BizCurrency tumitateDGanrikin = BizCurrency.valueOf(0);

                if (C_BkncdKbn.SIBOUKARIUKETUKE.eq(bikinKykHaitouMeisai.getBkncdkbn()) ||
                    C_BkncdKbn.SIBOUUKETUKE.eq(bikinKykHaitouMeisai.getBkncdkbn())) {

                    if (C_ShrKekkaKbn.HSHR.eq(bikinKykHaitouMeisai.getShrkekkakbn())) {

                        continue;
                    }

                    if (C_BkncdKbn.SIBOUKARIUKETUKE.eq(bikinKykHaitouMeisai.getBkncdkbn()) ||
                        (C_BkncdKbn.SIBOUUKETUKE.eq(bikinKykHaitouMeisai.getBkncdkbn()) &&
                            bikinKykHaitouMeisai.getTyakkinymd() == null)) {

                        KeisanDCommonSibou keisanDCommonSibou = SWAKInjector.getInstance(KeisanDCommonSibou.class);

                        C_ErrorKbn errorKbn = keisanDCommonSibou.calcDShrgk(syono,
                            bikinKykHaitouMeisai.getCalckijyunymd(),
                            bikinKykHaitouMeisai.getCalckijyunymd());

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001, "配当共通計算（死亡）", syono);

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(syoriYmd);
                            suuriyouErrJyouhou.setKakutyoujobcd(ibKakutyoujobcd);
                            suuriyouErrJyouhou.setSyono(syono);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

                            BizPropertyInitializer.initialize(suuriyouErrJyouhou);

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            batchParam.setErrorSyoriKensuu(batchParam.getErrorSyoriKensuu() + 1);

                            continue;
                        }

                        seisSnd = keisanDCommonSibou.getDShrkn();
                        if (keisanDCommonSibou.getKariwariateKeisanDGanrikin() != null) {
                            kariwariateDGanrikin = keisanDCommonSibou.getKariwariateDGanrikin();
                        }
                        tumitateDGanrikin = keisanDCommonSibou.getTumitateDGanrikin();
                    }
                    else {

                        siDshrTukiList = dbAccess.getSiDshrTukis(syono, TeisuuSiharai.SISATEISB);

                        if (siDshrTukiList != null && siDshrTukiList.size() > 0) {

                            siDshrTuki = siDshrTukiList.get(0);
                        }
                    }
                }
                else {

                    String henkousikibetuKey = null;
                    String gyoumuKousinKinou = null;
                    C_Syoumetujiyuu syoumetujiyuu = null;

                    if (C_BkncdKbn.KAIYAKU.eq(bikinKykHaitouMeisai.getBkncdkbn())) {

                        henkousikibetuKey = bikinKykHaitouMeisai.getHenkousikibetukey();
                    }
                    else if (C_BkncdKbn.SIBOUKAIJYO.eq(bikinKykHaitouMeisai.getBkncdkbn())) {

                        gyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;
                        syoumetujiyuu = C_Syoumetujiyuu.SBKAIJO;
                    }
                    else if (C_BkncdKbn.MENSEKI.eq(bikinKykHaitouMeisai.getBkncdkbn())) {

                        gyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI;
                        syoumetujiyuu = C_Syoumetujiyuu.MENSEKI;
                    }
                    else if (C_BkncdKbn.PMINYUUSYOUMETU.eq(bikinKykHaitouMeisai.getBkncdkbn())) {

                        gyoumuKousinKinou = IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU;
                        syoumetujiyuu = C_Syoumetujiyuu.BLNK;
                    }

                    if (C_BkncdKbn.KAIYAKU.eq(bikinKykHaitouMeisai.getBkncdkbn())) {

                        khDshrTukiList = dbAccess.getKhDshrTukisBySyonoHenkousikibetukey(syono, henkousikibetuKey);
                    }
                    else {

                        khDshrTukiList = dbAccess.getKhDshrTukis(syono, syoumetujiyuu, gyoumuKousinKinou);
                    }

                    if (khDshrTukiList != null && khDshrTukiList.size() > 0) {

                        khDshrTuki = khDshrTukiList.get(0);
                    }
                    else {

                        KeisanDCommonKaiyaku keisanDCommonKaiyaku = SWAKInjector.getInstance(KeisanDCommonKaiyaku.class);

                        C_ErrorKbn errorKbn = keisanDCommonKaiyaku.calcDShrgk(syono,
                            bikinKykHaitouMeisai.getCalckijyunymd(),
                            bikinKykHaitouMeisai.getCalckijyunymd(),
                            bikinKykHaitouMeisai.getJkipjytym());

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                            String msg = MessageUtil.getMessage(MessageId.ESA1001, "配当共通計算（解約）", syono);

                            batchLogger.warn(msg);

                            ST_SuuriyouErrJyouhou suuriyouErrJyouhou = new ST_SuuriyouErrJyouhou();

                            suuriyouErrJyouhou.setSyoriYmd(syoriYmd);
                            suuriyouErrJyouhou.setKakutyoujobcd(ibKakutyoujobcd);
                            suuriyouErrJyouhou.setSyono(syono);
                            suuriyouErrJyouhou.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
                            suuriyouErrJyouhou.setSuuritoukeiyouerrnaiyou(msg);

                            BizPropertyInitializer.initialize(suuriyouErrJyouhou);

                            ExDBTransactionalUtil.insert(suuriyouErrJyouhou);

                            batchParam.setErrorSyoriKensuu(batchParam.getErrorSyoriKensuu() + 1);

                            continue;
                        }

                        seisSnd = keisanDCommonKaiyaku.getDShrkn();
                        if (keisanDCommonKaiyaku.getKariwariateKeisanDGanrikin() != null) {
                            kariwariateDGanrikin = keisanDCommonKaiyaku.getKariwariateDGanrikin();
                        }
                        tumitateDGanrikin = keisanDCommonKaiyaku.getTumitateDGanrikin();
                    }
                }

                ST_BknkykHtjynbkn bknkykHtjynbkn = new ST_BknkykHtjynbkn(syoriYmd, ibKakutyoujobcd, syono,
                    String.valueOf(kijyunymd.getBizDateYM()));

                SrBikinKykHaitoujynbknSelBatchEdit koumokuEdit = SWAKInjector.getInstance(SrBikinKykHaitoujynbknSelBatchEdit.class);

                boolean editKoumokuErrorFlg = koumokuEdit.editKoumoku(
                    batchParam,
                    tkJitenKeiyakuSyouhinKijyunBean,
                    bikinKykHaitouMeisai,
                    bknkykHtjynbkn,
                    syouhinUtilKekka,
                    kiykSyuhnDataList,
                    siDshrTuki,
                    khDshrTuki,
                    khHaitouKanrilist,
                    khTumitateDKanriList,
                    seisSnd,
                    kariwariateDGanrikin,
                    tumitateDGanrikin);

                if (!editKoumokuErrorFlg) {

                    entityInserter.add(bknkykHtjynbkn);

                    tableTourokuCount = tableTourokuCount + 1;
                }
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "備金契約配当準備金テーブル",
                String.valueOf(tableTourokuCount) ));

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
                String.valueOf(batchParam.getErrorSyoriKensuu())));
        }
    }

    private void logInfo(String msg, String[] keys, Object[] values){
        StringBuilder sb = new StringBuilder();
        sb.append(msg);
        for(int i = 0; i < keys.length; i++){
            if (i == 0){
                sb.append("⇒");
            }else{
                sb.append(", ");
            }
            sb.append(keys[i]);
            sb.append(":");
            sb.append(String.valueOf(values[i]));
        }
        batchLogger.info(sb.toString());
    }
}
