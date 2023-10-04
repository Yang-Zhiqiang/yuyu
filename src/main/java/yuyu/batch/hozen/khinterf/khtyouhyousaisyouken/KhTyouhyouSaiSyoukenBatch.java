package yuyu.batch.hozen.khinterf.khtyouhyousaisyouken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.MultipleEntityInserter;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import yuyu.common.base.format.FixedDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KeisanTargetMokuhyougk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoukenUktKbn;
import yuyu.def.classification.C_SyoukenUktMidasiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.dao.IT_SuiihyouDao;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.db.entity.ZT_SaihakkouHokensyoukenTy;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuii2Ty;
import yuyu.def.db.entity.ZT_SaihakkouSyoukenSuiiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 再発行証券Ｆ作成
 */
public class KhTyouhyouSaiSyoukenBatch implements Batch {

    private final String TABLE_ID = "IT_HokenSyouken";

    private final String FILTER_KBN_ID = "Kh001";

    private final String TEL_MITOUROKU = "未登録";

    private static final String KBPERCENT = "％";

    private String kyknmkj = "";

    private String hhknnmkj = "";

    private String hosyounyhihknsyameikanji = "";

    private String hyoujiransjkkktusirrt = "";

    private String hokenryouGk = "";

    private String znntikiktbrihrkGk = "";

    private String syukykTkykHknknGk1 = "";

    private String syukykTkykHknknGk2 = "";

    private String syukykTkykHknknGk3 = "";

    private String syukykTkykHknknGk4 = "";

    private String syukyktkykhknkngk5 = "";

    private String syukykTkykHknknGk6 = "";

    private String syukykTkykHknknGk7 = "";

    private String syukykTkykHknknGk8 = "";

    private String syukykTkykHknknGk9 = "";

    private String syukykTkykHknknGk10 = "";

    private String kykNiyuStitjbrP = "";

    private String kykNiyuStkihonS = "";

    private String sonotaNyranNyknTuukaP = "";

    private String siboudai1kjnkngk = "";

    private String siboudai2kjnkngk = "";

    private String siboudai3kjnkngk = "";

    private String dai1s01 = "";

    private String dai1s02 = "";

    private String dai1s03 = "";

    private String dai1s04 = "";

    private String dai1s05 = "";

    private String dai1s06 = "";

    private String dai1s07 = "";

    private String dai1s08 = "";

    private String dai1s09 = "";

    private String dai1s10 = "";

    private String dai1zennouzndk01 = "";

    private String dai1zennouzndk02 = "";

    private String dai1zennouzndk03 = "";

    private String dai1zennouzndk04 = "";

    private String dai1zennouzndk05 = "";

    private String dai1sbjiuktgk01 = "";

    private String dai1sbjiuktgk02 = "";

    private String dai1sbjiuktgk03 = "";

    private String dai1sbjiuktgk04 = "";

    private String dai1sbjiuktgk05 = "";

    private String dai2s = "";

    private String dai3s = "";

    private String dai1shuryo = "";

    private String kaigomaehrjrugk01 = "";

    private String kaigomaehrjrugk02 = "";

    private String kaigomaehrjrugk03 = "";

    private String kaigomaehrjrugk04 = "";

    private String kaigomaehrjrugk05 = "";

    private String kaigomaehrjrugk06 = "";

    private String kaigomaehrjrugk07 = "";

    private String kaigomaehrjrugk08 = "";

    private String kaigomaehrjrugk09 = "";

    private String kaigomaehrjrugk10 = "";

    private String sonotanyrankjnkngk = "";

    private String witijibrp = "";

    private String sonotanyranteiritutmttkngk = "";

    private String sonotanyransisuutmttkngk = "";

    private String hyoujiranYoteiRiritu = "";

    private String sonotaNyranmKhwaRiai = "";

    private String sonotanyranmkhgk = "";

    private String mkhyouysysnikcurrentgk = "";

    private String dai1sKwsRateYenDaka = "";

    private String dai1sKwsRateYenKijyun = "";

    private String dai1sKwsRateYenyasu = "";

    private String sonotanyranenkhrikmrate = "";

    private String sonotanyranstigikwsrate = "";

    private String kaigomaehrstikkn01 = "";

    private String kaigomaehrstikkn02 = "";

    private String kaigomaehrstikkn03 = "";

    private String kaigomaehrstikkn04 = "";

    private String kaigomaehrstikkn05 = "";

    private String kaigomaehrstikkn06 = "";

    private String kaigomaehrstikkn07 = "";

    private String kaigomaehrstikkn08 = "";

    private String kaigomaehrstikkn09 = "";

    private String kaigomaehrstikkn10 = "";

    private String sonotanyrankjnkngkrate = "";

    private String yenKnsnKwsRateYenDaka = "";

    private String yenKnsnKwsRateYenKijyun = "";

    private String yenKnsnKwsRateYenYasu = "";

    private String sjkkktusirrtup = "";

    private String sjkkktusirrtsame = "";

    private String sjkkktusirrtdown = "";

    private String sjkkktusirrthendoudown = "";

    private String sjkkktusirrthendouup = "";

    private String wsjkkktyouseitkyuym = "";

    private String hrkkknmnryym = "";

    private String hrkkknmnrynen = "";

    private String[] mvaAriNenOuTouYm = new String[15];

    private String[] mvaAriWTukTypeUp = new String[15];


    private String[] mvaAriWUpYenDaka = new String[15];

    private String[] mvaAriWUpYenKijyun = new String[15];

    private String[] mvaAriWUpYenYasu = new String[15];

    private String[] mvaariwumupyendaka = new String[15];

    private String[] mvaariumupyenkijyun = new String[15];

    private String[] mvaariumupyenyasu = new String[15];

    private String[] mvaAriWTukTypeSame = new String[15];


    private String[] mvaAriWSameYenDaka = new String[15];

    private String[] mvaAriWSameYenKijyun = new String[15];

    private String[] mvaariumsameyendaka = new String[15];

    private String[] mvaariumsameyenkijyun = new String[15];

    private String[] mvaariumsameyenyasu = new String[15];

    private String[] mvaAriWSameYenYasu = new String[15];

    private String[] mvaAriWTukTypeDown = new String[15];


    private String[] mvaAriWDownYenDaka = new String[15];

    private String[] mvaAriWDownYenKijyun = new String[15];

    private String[] mvaAriWDownYenYasu = new String[15];

    private String[] mvaariumdownyendaka = new String[15];

    private String[] mvaariumdownyenkijyun = new String[15];

    private String[] mvaariumdownyenyasu = new String[15];

    private String[] mvaAriVTukType = new String[15];

    private String[] mvaAriWUp = new String[15];

    private String[] mvaAriWSame = new String[15];

    private String[] mvaAriWDown = new String[15];

    private String[] mvaAriV = new String[15];

    private String[] mvaNoneKaisiInnUmuKbn = new String[15];

    private String[] mvaNoneNenOutouYm = new String[15];

    private String[] mvaNoneWTukType = new String[15];


    private String[] mvaNoneWYenSameYenDaka = new String[15];

    private String[] mvaNoneWYenSameYenKijyun = new String[15];

    private String[] mvaNoneWYenSameYenYasu = new String[15];

    private String[] mvanoneumyendaka = new String[15];

    private String[] mvanoneumyenkijyun = new String[15];

    private String[] mvanoneumyenyasu = new String[15];

    private String[] mvaNoneVTukType = new String[15];

    private String[] mvaNoneW = new String[15];

    private String[] mvaNoneY = new String[15];

    private String[] tutmttknutiwake1 = new String[15];

    private String[] tutmttknutiwake2 = new String[15];

    private String[] mvaaritmttkgkkykkjmaedown = new String[15];

    private String[] mvaaritmttkgkkykkjmaesame = new String[15];

    private String[] mvaaritmttkgkkykkjmaeup = new String[15];

    private String[] sisuuupritu = new String[15];

    private String[] tmttknzoukaritu = new String[15];

    private int suiihyouPatternSuu = 0;

    private int suiihyou2PatternSuu = 0;

    private int suiihyouPattern1 = 1;

    private int suiihyouPattern2 = 2;

    private int suiihyouPattern3 = 3;

    private int suiihyouPattern4 = 4;

    private int suiihyouPattern5 = 5;

    private String sisuuuprituPattern1  = "５．００";

    private String sisuuuprituPattern2  = "５．００";

    private String sisuuuprituPattern3  = "１０．００";

    private String sjkkktusirrtup2 = "";

    private String sjkkktusirrtsame2 = "";

    private String sjkkktusirrtdown2 = "";

    private String sjkkktusirrthendoudown2 = "";

    private String sjkkktusirrthendouup2 = "";

    private String yenKnsnKwsRateYenDaka2 = "";

    private String yenKnsnKwsRateYenKijyun2 = "";

    private String yenKnsnKwsRateYenYasu2 = "";

    private String[] sisuuupritu2 = new String[15];

    private String[] tmttknzoukaritu2 = new String[15];

    private String[] mvaaritmttkgkkykkjmaeup2 = new String[15];

    private String[] mvaAriWUp2 = new String[15];

    private String[] mvaAriWUpYenDaka2 = new String[15];

    private String[] mvaAriWUpYenKijyun2 = new String[15];

    private String[] mvaAriWUpYenYasu2 =  new String[15];

    private String[] mvaariwumupyendaka2 =  new String[15];

    private String[] mvaariumupyenkijyun2 = new String[15];

    private String[] mvaariumupyenyasu2 = new String[15];

    private String[] mvaariumsameyendaka2 = new String[15];

    private String[] mvaariumsameyenkijyun2 = new String[15];

    private String[] mvaariumsameyenyasu2 = new String[15];

    private String[] mvaariumdownyendaka2 = new String[15];

    private String[] mvaariumdownyenkijyun2 = new String[15];

    private String[] mvaariumdownyenyasu2 = new String[15];

    private String[] mvaaritmttkgkkykkjmaesame2 = new String[15];

    private String[] mvaAriWSame2 = new String[15];

    private String[] mvaAriWSameYenDaka2 = new String[15];

    private String[] mvaAriWSameYenKijyun2 = new String[15];

    private String[] mvaAriWSameYenYasu2 = new String[15];

    private String[] mvaaritmttkgkkykkjmaedown2 = new String[15];

    private String[] mvaAriWDown2 = new String[15];

    private String[] mvaAriWDownYenDaka2 = new String[15];

    private String[] mvaAriWDownYenKijyun2 = new String[15];

    private String[] mvaAriWDownYenYasu2 = new String[15];

    private String[] mvaAriV2 = new String[15];

    private String[] tutmttknutiwake12 = new String[15];

    private String[] tutmttknutiwake22 = new String[15];

    private String[] mvaNoneW2 = new String[15];

    private String[] mvaNoneWYenSameYenDaka2 = new String[15];

    private String[] mvaNoneWYenSameYenKijyun2 = new String[15];

    private String[] mvaNoneWYenSameYenYasu2 = new String[15];

    private String[] mvaNoneY2 = new String[15];

    private String sjkkktusirrtup3 = "";

    private String sjkkktusirrtsame3 = "";

    private String sjkkktusirrtdown3 = "";

    private String sjkkktusirrthendoudown3 = "";

    private String sjkkktusirrthendouup3 = "";

    private String yenKnsnKwsRateYenDaka3 = "";

    private String yenKnsnKwsRateYenKijyun3 = "";

    private String yenKnsnKwsRateYenYasu3 = "";

    private String[] sisuuupritu3 = new String[15];

    private String[] tmttknzoukaritu3 = new String[15];

    private String[] mvaaritmttkgkkykkjmaeup3 = new String[15];

    private String[] mvaAriWUp3 = new String[15];

    private String[] mvaAriWUpYenDaka3 = new String[15];

    private String[] mvaAriWUpYenKijyun3 = new String[15];

    private String[] mvaAriWUpYenYasu3 =  new String[15];

    private String[] mvaariwumupyendaka3 =  new String[15];

    private String[] mvaariumupyenkijyun3 = new String[15];

    private String[] mvaariumupyenyasu3 = new String[15];

    private String[] mvaariumsameyendaka3 = new String[15];

    private String[] mvaariumsameyenkijyun3 = new String[15];

    private String[] mvaariumsameyenyasu3 = new String[15];

    private String[] mvaariumdownyendaka3 = new String[15];

    private String[] mvaariumdownyenkijyun3 = new String[15];

    private String[] mvaariumdownyenyasu3 = new String[15];

    private String[] mvaaritmttkgkkykkjmaesame3 = new String[15];

    private String[] mvaAriWSame3 = new String[15];

    private String[] mvaAriWSameYenDaka3 = new String[15];

    private String[] mvaAriWSameYenKijyun3 = new String[15];

    private String[] mvaAriWSameYenYasu3 = new String[15];

    private String[] mvaaritmttkgkkykkjmaedown3 = new String[15];

    private String[] mvaAriWDown3 = new String[15];

    private String[] mvaAriWDownYenDaka3 = new String[15];

    private String[] mvaAriWDownYenKijyun3 = new String[15];

    private String[] mvaAriWDownYenYasu3 = new String[15];

    private String[] mvaAriV3 = new String[15];

    private String[] tutmttknutiwake13 = new String[15];

    private String[] tutmttknutiwake23 = new String[15];

    private String[] mvaNoneW3 = new String[15];

    private String[] mvaNoneWYenSameYenDaka3 = new String[15];

    private String[] mvaNoneWYenSameYenKijyun3 = new String[15];

    private String[] mvaNoneWYenSameYenYasu3 = new String[15];

    private String[] mvaNoneY3 = new String[15];

    private String[] nenoutouym = new String[22];

    private String[] hrkkknmnryumukbn = new String[22];

    private String[] zennouzndkyen = new String[22];

    private String[] yenhrkgkgoukei = new String[22];

    private String[] kihrkmp = new String[22];

    private String[] w = new String[22];

    private String[] wyenyendaka = new String[22];

    private String[] wyenkijun = new String[22];

    private String[] wyenyenyasu = new String[22];

    private String[] zennouzndkyen2 = new String[22];

    private String[] yenhrkgkgoukei2 = new String[22];

    private String[] kihrkmp2 = new String[22];

    private String[] w2 = new String[22];

    private String[] wyenyendaka2 = new String[22];

    private String[] wyenkijun2 = new String[22];

    private String[] wyenyenyasu2 = new String[22];

    private String[] zennouzndk1 = new String[22];

    private String[] uktrgk = new String[22];

    private String[] uktrgkyenyendaka = new String[22];

    private String[] uktrgkyenkijun = new String[22];

    private String[] uktrgkyenyenyasu = new String[22];

    private String hyoujirantumitateriritu = "";

    private String hyoujirantumitateriritu2 = "";

    private String hyoujirantmttknzkrtjygn = "";

    private String hyoujiransetteibairitu = "";

    private String hutanhiyustmytijihiritu = "";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private IT_SuiihyouDao iT_SuiihyouDao;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();
        int sinKeiyakuHokenSyoukenCnt = 0;
        int suiihyouCnt = 0;
        int mvaariCnt = 0;
        int mvanoneCnt = 0;
        int suiihyou2Cnt = 0;
        String keySyouKenSyono = "";
        Integer keiKanenSuu = 0;
        BizCurrency targetTokuyakuMkhgk = BizCurrency.valueOf(0);
        IT_HokenSyouken hokenSyouken = null;
        IT_Suiihyou suiihyou = null;
        ZT_SaihakkouHokensyoukenTy saihakkouHokensyoukenTy = null;
        ZT_SaihakkouSyoukenSuiiTy saihakkouHokensyoukenSuiiTy = null;
        ZT_SaihakkouSyoukenSuii2Ty saihakkouHokensyoukenSuii2Ty = null;
        boolean dataInsFlg = false;

        try (ExDBResults<SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean> saihakkoshokenInfoList =
            hozenDomManager.getSaihakkoshokenInfosByKakutyoujobcdTyouhyouymd(ibKakutyoujobcd, syoriYmd);

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();

            ) {

            for (SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean
                saihakkoshokenInfo : saihakkoshokenInfoList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_KBN_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(
                    saihakkoshokenInfo.getIT_HokenSyouken().getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(
                    saihakkoshokenInfo.getIT_HokenSyouken().getSyono());
                boolean daiitiRecordSetteiUmu = false;

                dataInsFlg = true;

                calcSuiihyouPatternSuu(suiihyouCnt, saihakkoshokenInfo);

                if (!BizUtil.isBlank(keySyouKenSyono)
                    && !keySyouKenSyono.equals(saihakkoshokenInfo.getIT_HokenSyouken().getSyono())) {

                    saihakkouHokensyoukenTy = new ZT_SaihakkouHokensyoukenTy();
                    editSaihakkouHokensyoukenTy(hokenSyouken, saihakkouHokensyoukenTy);

                    saihakkouHokensyoukenSuiiTy = new ZT_SaihakkouSyoukenSuiiTy();
                    editSaihakkouHokensyoukenSuiiTy(hokenSyouken, suiihyou, saihakkouHokensyoukenSuiiTy);
                    multipleEntityInserter.add(saihakkouHokensyoukenSuiiTy);

                    if (suiihyouPatternSuu == 3) {
                        saihakkouHokensyoukenSuiiTy = new ZT_SaihakkouSyoukenSuiiTy();
                        editSaihakkouHokensyoukenSuiiTyPattern2(hokenSyouken, suiihyou, saihakkouHokensyoukenSuiiTy);
                        multipleEntityInserter.add(saihakkouHokensyoukenSuiiTy);

                        saihakkouHokensyoukenSuiiTy = new ZT_SaihakkouSyoukenSuiiTy();

                        editSaihakkouHokensyoukenSuiiTyPattern3(hokenSyouken, suiihyou, saihakkouHokensyoukenSuiiTy);
                        multipleEntityInserter.add(saihakkouHokensyoukenSuiiTy);
                        suiihyouPatternSuu = 0;
                    }

                    if (suiihyouPatternSuu == 2) {

                        saihakkouHokensyoukenSuiiTy = new ZT_SaihakkouSyoukenSuiiTy();
                        editSaihakkouHokensyoukenSuiiTyPattern2(hokenSyouken, suiihyou, saihakkouHokensyoukenSuiiTy);
                        multipleEntityInserter.add(saihakkouHokensyoukenSuiiTy);

                        suiihyouPatternSuu = 0;
                    }

                    if (suiihyou2PatternSuu == 2) {

                        saihakkouHokensyoukenSuii2Ty = new ZT_SaihakkouSyoukenSuii2Ty();
                        editSaihakkouHokensyoukenSuii2TyPattern4(suiihyou, saihakkouHokensyoukenSuii2Ty, suiihyou2Cnt);
                        multipleEntityInserter.add(saihakkouHokensyoukenSuii2Ty);
                        saihakkouHokensyoukenSuii2Ty = new ZT_SaihakkouSyoukenSuii2Ty();
                        editSaihakkouHokensyoukenSuii2TyPattern5(suiihyou, saihakkouHokensyoukenSuii2Ty, suiihyou2Cnt);
                        multipleEntityInserter.add(saihakkouHokensyoukenSuii2Ty);

                        suiihyou2PatternSuu = 0;
                        suiihyou2Cnt = 0;
                    }

                    if (suiihyou2PatternSuu == 1) {

                        saihakkouHokensyoukenSuii2Ty = new ZT_SaihakkouSyoukenSuii2Ty();
                        editSaihakkouHokensyoukenSuii2TyPattern4(suiihyou, saihakkouHokensyoukenSuii2Ty, suiihyou2Cnt);
                        multipleEntityInserter.add(saihakkouHokensyoukenSuii2Ty);

                        suiihyou2PatternSuu = 0;
                        suiihyou2Cnt = 0;
                    }

                    suiihyouCnt = 0;
                    mvaariCnt = 0;
                    mvanoneCnt = 0;

                    sinKeiyakuHokenSyoukenCnt++;
                    targetTokuyakuMkhgk = BizCurrency.valueOf(0);
                    sonotanyranmkhgk = "";
                    mkhyouysysnikcurrentgk = "";

                    multipleEntityInserter.add(saihakkouHokensyoukenTy);

                    calcSuiihyouPatternSuu(suiihyouCnt, saihakkoshokenInfo);
                }

                if (BizUtil.isBlank(keySyouKenSyono)
                    || !keySyouKenSyono.equals(saihakkoshokenInfo.getIT_HokenSyouken().getSyono())) {
                    IT_KykSonotaTkyk kykSonotaTkyk = saihakkoshokenInfo.getIT_HokenSyouken().getKykKihon()
                        .getKykSonotaTkyk();
                    if (kykSonotaTkyk.getTargettkmokuhyouti() > 0) {
                        KeisanTargetMokuhyougk keisanTargetMokuhyougk = SWAKInjector
                            .getInstance(KeisanTargetMokuhyougk.class);

                        targetTokuyakuMkhgk = keisanTargetMokuhyougk.exec(kykSonotaTkyk.getTargettkykkijyungk(),
                            kykSonotaTkyk.getTargettkmokuhyouti());

                        sonotanyranmkhgk = String.valueOf(keisanTargetMokuhyougk.exec(
                            saihakkoshokenInfo.getIT_HokenSyouken().getSonotanyranpenknsngk(),
                            kykSonotaTkyk.getTargettkmokuhyouti()));
                        mkhyouysysnikcurrentgk = String.valueOf(targetTokuyakuMkhgk);
                    }
                }

                keySyouKenSyono = saihakkoshokenInfo.getIT_HokenSyouken().getSyono();
                keiKanenSuu = saihakkoshokenInfo.getKeikanensuu();
                suiihyou = iT_SuiihyouDao.getSuiihyou(keySyouKenSyono, syoriYmd, keiKanenSuu);

                if (suiihyouCnt == 0) {
                    initMemberVarible();

                    hokenSyouken = saihakkoshokenInfo.getIT_HokenSyouken();
                    hokenSyouken.getHokenSyoukenHukaInfos().size();

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getPtuukatype())) {

                        hokenryouGk = hokenSyouken.getHokenryou().toString();

                    }
                    else {

                        hokenryouGk = hokenSyouken.getHokenryou().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype1())) {

                        syukykTkykHknknGk1 = hokenSyouken.getSyukyktkykhknkngk1().toString();

                    }
                    else {

                        syukykTkykHknknGk1 = hokenSyouken.getSyukyktkykhknkngk1().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype2())) {

                        syukykTkykHknknGk2 = hokenSyouken.getSyukyktkykhknkngk2().toString();

                    }
                    else {

                        syukykTkykHknknGk2 = hokenSyouken.getSyukyktkykhknkngk2().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype3())) {

                        syukykTkykHknknGk3 = hokenSyouken.getSyukyktkykhknkngk3().toString();

                    }
                    else {

                        syukykTkykHknknGk3 = hokenSyouken.getSyukyktkykhknkngk3().multiply(100).toString();
                    }


                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype4())) {

                        syukykTkykHknknGk4 = hokenSyouken.getSyukyktkykhknkngk4().toString();

                    }
                    else {

                        syukykTkykHknknGk4 = hokenSyouken.getSyukyktkykhknkngk4().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype5())) {

                        syukyktkykhknkngk5 = hokenSyouken.getSyukyktkykhknkngk5().toString();

                    }
                    else {

                        syukyktkykhknkngk5 = hokenSyouken.getSyukyktkykhknkngk5().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype6())) {

                        syukykTkykHknknGk6 = hokenSyouken.getSyukyktkykhknkngk6().toString();

                    }
                    else {

                        syukykTkykHknknGk6 = hokenSyouken.getSyukyktkykhknkngk6().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype7())) {

                        syukykTkykHknknGk7 = hokenSyouken.getSyukyktkykhknkngk7().toString();

                    }
                    else {

                        syukykTkykHknknGk7 = hokenSyouken.getSyukyktkykhknkngk7().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype8())) {

                        syukykTkykHknknGk8 = hokenSyouken.getSyukyktkykhknkngk8().toString();

                    }
                    else {

                        syukykTkykHknknGk8 = hokenSyouken.getSyukyktkykhknkngk8().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype9())) {

                        syukykTkykHknknGk9 = hokenSyouken.getSyukyktkykhknkngk9().toString();

                    }
                    else {

                        syukykTkykHknknGk9 = hokenSyouken.getSyukyktkykhknkngk9().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype10())) {

                        syukykTkykHknknGk10 = hokenSyouken.getSyukyktkykhknkngk10().toString();

                    }
                    else {

                        syukykTkykHknknGk10 = hokenSyouken.getSyukyktkykhknkngk10().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getKykniyustitjbrptuuktype())) {

                        kykNiyuStitjbrP = hokenSyouken.getKykniyustitjbrp().toString();

                    }
                    else {

                        kykNiyuStitjbrP = hokenSyouken.getKykniyustitjbrp().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSyukyktkykstuukatype1())) {

                        kykNiyuStkihonS = hokenSyouken.getSyukyktkykhknkngk1().toString();
                    }

                    else {

                        kykNiyuStkihonS = hokenSyouken.getSyukyktkykhknkngk1().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSonotanyrannykntuktype())) {

                        sonotaNyranNyknTuukaP = hokenSyouken.getSonotanyrannykntuukap().toString();

                    }
                    else {

                        sonotaNyranNyknTuukaP = hokenSyouken.getSonotanyrannykntuukap().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSiboudai1kjnkngktuuktype())) {

                        siboudai1kjnkngk = hokenSyouken.getSiboudai1kjnkngk().toString();

                    }
                    else {

                        siboudai1kjnkngk = hokenSyouken.getSiboudai1kjnkngk().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSiboudai2kjnkngktuuktype())) {

                        siboudai2kjnkngk = hokenSyouken.getSiboudai2kjnkngk().toString();

                    }
                    else {

                        siboudai2kjnkngk = hokenSyouken.getSiboudai2kjnkngk().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSiboudai3kjnkngktuuktype())) {

                        siboudai3kjnkngk = hokenSyouken.getSiboudai3kjnkngk().toString();

                    }
                    else {

                        siboudai3kjnkngk = hokenSyouken.getSiboudai3kjnkngk().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype01())) {

                        dai1s01 = hokenSyouken.getDai1s01().toString();

                    }
                    else {

                        dai1s01 = hokenSyouken.getDai1s01().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype02())) {

                        dai1s02 = hokenSyouken.getDai1s02().toString();

                    }
                    else {

                        dai1s02 = hokenSyouken.getDai1s02().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype03())) {

                        dai1s03 = hokenSyouken.getDai1s03().toString();

                    }
                    else {

                        dai1s03 = hokenSyouken.getDai1s03().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype04())) {

                        dai1s04 = hokenSyouken.getDai1s04().toString();

                    }
                    else {

                        dai1s04 = hokenSyouken.getDai1s04().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype05())) {

                        dai1s05 = hokenSyouken.getDai1s05().toString();

                    }
                    else {

                        dai1s05 = hokenSyouken.getDai1s05().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype06())) {

                        dai1s06 = hokenSyouken.getDai1s06().toString();

                    }
                    else {

                        dai1s06 = hokenSyouken.getDai1s06().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype07())) {

                        dai1s07 = hokenSyouken.getDai1s07().toString();

                    }
                    else {

                        dai1s07 = hokenSyouken.getDai1s07().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype08())) {

                        dai1s08 = hokenSyouken.getDai1s08().toString();

                    }
                    else {

                        dai1s08 = hokenSyouken.getDai1s08().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype09())) {

                        dai1s09 = hokenSyouken.getDai1s09().toString();

                    }
                    else {

                        dai1s09 = hokenSyouken.getDai1s09().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktype10())) {

                        dai1s10 = hokenSyouken.getDai1s10().toString();

                    }
                    else {

                        dai1s10 = hokenSyouken.getDai1s10().multiply(100).toString();
                    }

                    if (suiihyou2PatternSuu > 0) {

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype())) {

                            znntikiktbrihrkGk = hokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk().toString();
                        }

                        else {

                            znntikiktbrihrkGk = hokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk().multiply(100).toString();
                        }
                    }

                    if (suiihyou2PatternSuu == 1) {

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype01())) {

                            dai1zennouzndk01 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk01().toString();
                        }

                        else {

                            dai1zennouzndk01 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk01().multiply(100).toString();
                        }

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype02())) {

                            dai1zennouzndk02 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk02().toString();
                        }

                        else {

                            dai1zennouzndk02 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk02().multiply(100).toString();
                        }

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype03())) {

                            dai1zennouzndk03 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk03().toString();
                        }

                        else {

                            dai1zennouzndk03 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk03().multiply(100).toString();
                        }

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype04())) {

                            dai1zennouzndk04 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk04().toString();
                        }

                        else {

                            dai1zennouzndk04 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk04().multiply(100).toString();
                        }

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype05())) {

                            dai1zennouzndk05 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk05().toString();
                        }

                        else {

                            dai1zennouzndk05 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndk05().multiply(100).toString();
                        }

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype01())) {

                            dai1sbjiuktgk01 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk01().toString();
                        }

                        else {

                            dai1sbjiuktgk01 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk01().multiply(100).toString();
                        }

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype02())) {

                            dai1sbjiuktgk02 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk02().toString();
                        }

                        else {

                            dai1sbjiuktgk02 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk02().multiply(100).toString();
                        }

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype03())) {

                            dai1sbjiuktgk03 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk03().toString();
                        }

                        else {

                            dai1sbjiuktgk03 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk03().multiply(100).toString();
                        }

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype04())) {

                            dai1sbjiuktgk04 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk04().toString();
                        }

                        else {

                            dai1sbjiuktgk04 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk04().multiply(100).toString();
                        }

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype05())) {

                            dai1sbjiuktgk05 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk05().toString();
                        }

                        else {

                            dai1sbjiuktgk05 = hokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgk05().multiply(100).toString();
                        }
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai2stuuktype())) {

                        dai2s = hokenSyouken.getDai2s().toString();

                    }
                    else {

                        dai2s = hokenSyouken.getDai2s().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai3stuuktype())) {

                        dai3s = hokenSyouken.getDai3s().toString();

                    }
                    else {

                        dai3s = hokenSyouken.getDai3s().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktypehuryo())) {

                        dai1shuryo = hokenSyouken.getDai1shuryo().toString();
                    }

                    else {

                        dai1shuryo = hokenSyouken.getDai1shuryo().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getKaigomaehrjrugktype())) {

                        kaigomaehrjrugk01 = String.valueOf(hokenSyouken.getKaigomaehrjrugk01());
                        kaigomaehrjrugk02 = String.valueOf(hokenSyouken.getKaigomaehrjrugk02());
                        kaigomaehrjrugk03 = String.valueOf(hokenSyouken.getKaigomaehrjrugk03());
                        kaigomaehrjrugk04 = String.valueOf(hokenSyouken.getKaigomaehrjrugk04());
                        kaigomaehrjrugk05 = String.valueOf(hokenSyouken.getKaigomaehrjrugk05());
                        kaigomaehrjrugk06 = String.valueOf(hokenSyouken.getKaigomaehrjrugk06());
                        kaigomaehrjrugk07 = String.valueOf(hokenSyouken.getKaigomaehrjrugk07());
                        kaigomaehrjrugk08 = String.valueOf(hokenSyouken.getKaigomaehrjrugk08());
                        kaigomaehrjrugk09 = String.valueOf(hokenSyouken.getKaigomaehrjrugk09());
                        kaigomaehrjrugk10 = String.valueOf(hokenSyouken.getKaigomaehrjrugk10());
                    }

                    else {

                        kaigomaehrjrugk01 = String.valueOf(hokenSyouken.getKaigomaehrjrugk01().multiply(100));
                        kaigomaehrjrugk02 = String.valueOf(hokenSyouken.getKaigomaehrjrugk02().multiply(100));
                        kaigomaehrjrugk03 = String.valueOf(hokenSyouken.getKaigomaehrjrugk03().multiply(100));
                        kaigomaehrjrugk04 = String.valueOf(hokenSyouken.getKaigomaehrjrugk04().multiply(100));
                        kaigomaehrjrugk05 = String.valueOf(hokenSyouken.getKaigomaehrjrugk05().multiply(100));
                        kaigomaehrjrugk06 = String.valueOf(hokenSyouken.getKaigomaehrjrugk06().multiply(100));
                        kaigomaehrjrugk07 = String.valueOf(hokenSyouken.getKaigomaehrjrugk07().multiply(100));
                        kaigomaehrjrugk08 = String.valueOf(hokenSyouken.getKaigomaehrjrugk08().multiply(100));
                        kaigomaehrjrugk09 = String.valueOf(hokenSyouken.getKaigomaehrjrugk09().multiply(100));
                        kaigomaehrjrugk10 = String.valueOf(hokenSyouken.getKaigomaehrjrugk10().multiply(100));

                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getSonotanyrankjnkngktuktype())) {

                        sonotanyrankjnkngk = hokenSyouken.getSonotanyrankjnkngk().toString();

                    }
                    else {

                        sonotanyrankjnkngk = hokenSyouken.getSonotanyrankjnkngk().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getWitijibrptuktype())) {

                        witijibrp = hokenSyouken.getWitijibrp().toString();

                    }
                    else {

                        witijibrp = hokenSyouken.getWitijibrp().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.toString().equals(hokenSyouken.getSonotanyrantmttkngktuktype())) {

                        sonotanyranteiritutmttkngk = hokenSyouken.getSonotanyranteiritutmttkngk().toString();
                        sonotanyransisuutmttkngk = hokenSyouken.getSonotanyransisuutmttkngk().toString();
                    }

                    else {

                        sonotanyranteiritutmttkngk = hokenSyouken.getSonotanyranteiritutmttkngk().multiply(100).toString();
                        sonotanyransisuutmttkngk = hokenSyouken.getSonotanyransisuutmttkngk().multiply(100).toString();
                    }

                    hyoujiranYoteiRiritu = ConvertUtil.toZenAll(seisuuHanndan(hokenSyouken.getHyoujiranyoteiriritu().multiply(100)),0,0);
                    sonotaNyranmKhwaRiai = ConvertUtil.toZenAll(String.valueOf(hokenSyouken.getSonotanyranmkhwariai()), 0, 0);
                    dai1sKwsRateYenDaka = hokenSyouken.getDai1skwsrateyendaka().round(2, RoundingMode.DOWN).multiply(100).toString();
                    dai1sKwsRateYenKijyun = hokenSyouken.getDai1skwsrateyenkijyun().round(2, RoundingMode.DOWN).multiply(100).toString();
                    dai1sKwsRateYenyasu = hokenSyouken.getDai1skwsrateyenyasu().round(2, RoundingMode.DOWN).multiply(100).toString();
                    hyoujiransjkkktusirrt = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(hokenSyouken.getHyoujiransjkkktusirrt().multiply(100)),BizUtil.ZERO_FILL, 2),0,0);
                    sonotanyranenkhrikmrate = String.valueOf(hokenSyouken.getSonotanyranenkhrikmrate().round(2, RoundingMode.DOWN).multiply(100));
                    sonotanyranstigikwsrate = String.valueOf(hokenSyouken.getSonotanyranstigikwsrate().multiply(10000));
                    kaigomaehrstikkn01 = String.valueOf(hokenSyouken.getKaigomaehrstikkn01().multiply(10));
                    kaigomaehrstikkn02 = String.valueOf(hokenSyouken.getKaigomaehrstikkn02().multiply(10));
                    kaigomaehrstikkn03 = String.valueOf(hokenSyouken.getKaigomaehrstikkn03().multiply(10));
                    kaigomaehrstikkn04 = String.valueOf(hokenSyouken.getKaigomaehrstikkn04().multiply(10));
                    kaigomaehrstikkn05 = String.valueOf(hokenSyouken.getKaigomaehrstikkn05().multiply(10));
                    kaigomaehrstikkn06 = String.valueOf(hokenSyouken.getKaigomaehrstikkn06().multiply(10));
                    kaigomaehrstikkn07 = String.valueOf(hokenSyouken.getKaigomaehrstikkn07().multiply(10));
                    kaigomaehrstikkn08 = String.valueOf(hokenSyouken.getKaigomaehrstikkn08().multiply(10));
                    kaigomaehrstikkn09 = String.valueOf(hokenSyouken.getKaigomaehrstikkn09().multiply(10));
                    kaigomaehrstikkn10 = String.valueOf(hokenSyouken.getKaigomaehrstikkn10().multiply(10));
                    sonotanyrankjnkngkrate = String.valueOf(hokenSyouken.getSonotanyrankjnkngkrate().round(2, RoundingMode.DOWN).multiply(100));
                    hyoujirantumitateriritu = ConvertUtil.toZenAll(seisuuHanndan(hokenSyouken.getSonotanyrantumitateriritu().multiply(100)),0,0);
                    if (hokenSyouken.getSonotanyrantmttknzkrtjygn().multiply(100).compareTo(BizNumber.TEN) < 0) {
                        hyoujirantmttknzkrtjygn = "　" +  ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(hokenSyouken.getSonotanyrantmttknzkrtjygn().multiply(100)),1, 2),0,0);
                    }
                    else {
                        hyoujirantmttknzkrtjygn = ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(hokenSyouken.getSonotanyrantmttknzkrtjygn().multiply(100)),2, 2),0,0);
                    }
                    hyoujiransetteibairitu = ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(hokenSyouken.getSonotanyransetteibairitu()),1, 2),0,0);
                    hutanhiyustmytijihiritu = ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(hokenSyouken.getHutanhiyustmytijihiritu()),1, 1),0,0);

                    if (!C_KjkhukaKbn.KJKHUKA.eq(hokenSyouken.getKyknmkjkhukakbn())){
                        kyknmkj = hokenSyouken.getKyknmkj();
                    }

                    if (!C_KjkhukaKbn.KJKHUKA.eq(hokenSyouken.getHhknnmkjkhukakbn())){
                        hhknnmkj = hokenSyouken.getHhknnmkj();
                    }

                    if (!C_KjkhukaKbn.KJKHUKA.eq(hokenSyouken.getHhknnmkjkhukakbn())) {
                        hosyounyhihknsyameikanji = hokenSyouken.getHosyounyhihknsyameikanji();
                    }
                    else {
                        hosyounyhihknsyameikanji = hokenSyouken.getHhknnmkn();
                    }

                    if (!BizUtil.isBlank(hokenSyouken.getHrkkknmsgkbn())) {

                        hrkkknmnryym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(hokenSyouken.getKykymd().addYears(
                            Integer.valueOf(hokenSyouken.getHrkkknmsgkbn())));
                        hrkkknmnrynen = BizUtil.zeroNum(String.valueOf(
                            Integer.valueOf(hokenSyouken.getHrkkknmsgkbn()) + hokenSyouken.getHhknnen()), 3, 0);
                    }

                    if(suiihyou != null){
                        yenKnsnKwsRateYenDaka =
                            String.valueOf(suiihyou.getYenknsnkwsrateyendaka().round(2, RoundingMode.DOWN).multiply(100));
                        yenKnsnKwsRateYenKijyun = String.valueOf(suiihyou.getYenknsnkwsrateyenkijyun().round(2, RoundingMode.DOWN).multiply(100));
                        yenKnsnKwsRateYenYasu =
                            String.valueOf(suiihyou.getYenknsnkwsrateyenyasu().round(2, RoundingMode.DOWN).multiply(100));

                        if (!C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn())){

                            sjkkktusirrtup = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtup().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                            sjkkktusirrtsame = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtsame().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                            sjkkktusirrtdown = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtdown().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                            sjkkktusirrthendouup = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendouup().multiply(100).round(
                                0, RoundingMode.DOWN)), 0, 0);

                            sjkkktusirrthendoudown = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendoudown().multiply(100).round(
                                0, RoundingMode.DOWN)), 0, 0);

                        }
                        if (suiihyouPatternSuu > 0) {
                            yenKnsnKwsRateYenDaka2 =
                                String.valueOf(suiihyou.getYenknsnkwsrateyendaka2().round(2, RoundingMode.DOWN).multiply(100));
                            yenKnsnKwsRateYenKijyun2 = String.valueOf(suiihyou.getYenknsnkwsrateyenkijyun2().round(2, RoundingMode.DOWN).multiply(100));
                            yenKnsnKwsRateYenYasu2 =
                                String.valueOf(suiihyou.getYenknsnkwsrateyenyasu2().round(2, RoundingMode.DOWN).multiply(100));

                            if (!C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn())){
                                sjkkktusirrtup2 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtup2().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);
                                sjkkktusirrtsame2 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtsame2().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);
                                sjkkktusirrtdown2 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtdown2().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);
                                sjkkktusirrthendouup2 = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendouup2().multiply(100).round(0, RoundingMode.DOWN)), 0, 0);
                                sjkkktusirrthendoudown2 = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendoudown2().multiply(100).round(0, RoundingMode.DOWN)), 0, 0);
                            }

                            if (suiihyouPatternSuu == 3) {

                                yenKnsnKwsRateYenDaka3 =
                                    String.valueOf(suiihyou.getYenknsnkwsrateyendaka3().round(2, RoundingMode.DOWN).multiply(100));
                                yenKnsnKwsRateYenKijyun3 = String.valueOf(suiihyou.getYenknsnkwsrateyenkijyun3().round(2, RoundingMode.DOWN).multiply(100));
                                yenKnsnKwsRateYenYasu3 =
                                    String.valueOf(suiihyou.getYenknsnkwsrateyenyasu3().round(2, RoundingMode.DOWN).multiply(100));

                                if (!C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn())){

                                    sjkkktusirrtup3 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtup3().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);
                                    sjkkktusirrtsame3 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtsame3().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);
                                    sjkkktusirrtdown3 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtdown3().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);
                                    sjkkktusirrthendouup3 = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendouup3().multiply(100).round(0, RoundingMode.DOWN)), 0, 0);
                                    sjkkktusirrthendoudown3 = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendoudown3().multiply(100).round(0, RoundingMode.DOWN)), 0, 0);
                                }
                            }
                        }
                    }
                }

                if(suiihyou != null){
                    if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(suiihyou.getMvatekijyoutaikbn())) {

                        mvaAriNenOuTouYm[mvaariCnt] = String.valueOf(suiihyou.getCalcym());
                        mvaAriWTukTypeUp[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvaAriWUpYenDaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka());
                        mvaAriWUpYenKijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun());
                        mvaAriWUpYenYasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu());
                        mvaAriWTukTypeSame[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvaAriWSameYenDaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka());
                        mvaAriWSameYenKijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun());
                        mvaAriWSameYenYasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu());
                        mvaAriWTukTypeDown[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvaAriWDownYenDaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka());
                        mvaAriWDownYenKijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun());
                        mvaAriWDownYenYasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu());
                        mvaAriVTukType[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());

                        if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                            mvaAriWUp[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup());
                            mvaAriWSame[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame());
                            mvaAriWDown[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown());
                            mvaAriV[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin());
                            mvaaritmttkgkkykkjmaeup[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup1());
                            mvaaritmttkgkkykkjmaesame[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame1());
                            mvaaritmttkgkkykkjmaedown[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown1());
                            tutmttknutiwake1[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake11());
                            tutmttknutiwake2[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake21());
                        }
                        else {

                            mvaAriWUp[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup().multiply(100));
                            mvaAriWSame[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame().multiply(100));
                            mvaAriWDown[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown().multiply(100));
                            mvaAriV[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin().multiply(100));
                            mvaaritmttkgkkykkjmaeup[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup1().multiply(100));
                            mvaaritmttkgkkykkjmaesame[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame1().multiply(100));
                            mvaaritmttkgkkykkjmaedown[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown1().multiply(100));
                            tutmttknutiwake1[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake11().multiply(100));
                            tutmttknutiwake2[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake21().multiply(100));
                        }

                        if (suiihyouCnt == 0) {

                            if (BizDateUtil.compareYmd(suiihyou.getCalckijyunymd(),
                                hokenSyouken.getKykymd().addYears(1).getRekijyou()) == BizDateUtil.COMPARE_LESSER) {

                                mvaariwumupyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                mvaariumupyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                mvaariumupyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                mvaariumsameyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                mvaariumsameyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                mvaariumsameyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                mvaariumdownyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                mvaariumdownyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                mvaariumdownyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                daiitiRecordSetteiUmu = true;
                            }
                        }

                        if (suiihyouCnt > 0 || !daiitiRecordSetteiUmu) {
                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyendaka()) <= 0) {
                                mvaariwumupyendaka[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariwumupyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenkijyun()) <= 0) {
                                mvaariumupyenkijyun[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumupyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenyasu()) <= 0) {
                                mvaariumupyenyasu[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumupyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyendaka()) <= 0) {
                                mvaariumsameyendaka[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumsameyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenkijyun()) <= 0) {
                                mvaariumsameyenkijyun[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumsameyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenyasu()) <= 0) {
                                mvaariumsameyenyasu[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            } else {
                                mvaariumsameyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyendaka()) <= 0) {
                                mvaariumdownyendaka[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenkijyun()) <= 0) {
                                mvaariumdownyenkijyun[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenyasu()) <= 0) {
                                mvaariumdownyenyasu[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }
                        }

                        sisuuupritu[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getSisuuupritu1().multiply(100)),0,0);
                        tmttknzoukaritu[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getTmttknzoukaritu1().multiply(100)),0,0);

                        if (suiihyouPatternSuu > 0) {
                            mvaAriWUpYenDaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka2());
                            mvaAriWUpYenKijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun2());
                            mvaAriWUpYenYasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu2());
                            mvaAriWSameYenDaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka2());
                            mvaAriWSameYenKijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun2());
                            mvaAriWSameYenYasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu2());
                            mvaAriWDownYenDaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka2());
                            mvaAriWDownYenKijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun2());
                            mvaAriWDownYenYasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu2());
                            sisuuupritu2[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getSisuuupritu2().multiply(100)),0,0);
                            tmttknzoukaritu2[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getTmttknzoukaritu2().multiply(100)),0,0);

                            if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                                mvaAriWUp2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup2());
                                mvaAriWSame2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame2());
                                mvaAriWDown2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown2());
                                mvaAriV2[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin2());
                                mvaaritmttkgkkykkjmaeup2[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup2());
                                mvaaritmttkgkkykkjmaesame2[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame2());
                                mvaaritmttkgkkykkjmaedown2[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown2());
                                tutmttknutiwake12[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake12());
                                tutmttknutiwake22[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake22());
                            }
                            else {
                                mvaAriWUp2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup2().multiply(100));
                                mvaAriWSame2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame2().multiply(100));
                                mvaAriWDown2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown2().multiply(100));
                                mvaAriV2[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin2().multiply(100));
                                mvaaritmttkgkkykkjmaeup2[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup2().multiply(100));
                                mvaaritmttkgkkykkjmaesame2[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame2().multiply(100));
                                mvaaritmttkgkkykkjmaedown2[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown2().multiply(100));
                                tutmttknutiwake12[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake12().multiply(100));
                                tutmttknutiwake22[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake22().multiply(100));
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyendaka2()) <= 0) {
                                mvaariwumupyendaka2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariwumupyendaka2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenkijyun2()) <= 0) {
                                mvaariumupyenkijyun2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumupyenkijyun2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenyasu2()) <= 0) {
                                mvaariumupyenyasu2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumupyenyasu2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyendaka2()) <= 0) {
                                mvaariumsameyendaka2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumsameyendaka2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenkijyun2()) <= 0) {
                                mvaariumsameyenkijyun2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumsameyenkijyun2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenyasu2()) <= 0) {
                                mvaariumsameyenyasu2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            } else {
                                mvaariumsameyenyasu2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyendaka2()) <= 0) {
                                mvaariumdownyendaka2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyendaka2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenkijyun2()) <= 0) {
                                mvaariumdownyenkijyun2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyenkijyun2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenyasu2()) <= 0) {
                                mvaariumdownyenyasu2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyenyasu2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (suiihyouPatternSuu == 3) {

                                mvaAriWUpYenDaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka3());
                                mvaAriWUpYenKijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun3());
                                mvaAriWUpYenYasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu3());
                                mvaAriWSameYenDaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka3());
                                mvaAriWSameYenKijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun3());
                                mvaAriWSameYenYasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu3());
                                mvaAriWDownYenDaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka3());
                                mvaAriWDownYenKijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun3());
                                mvaAriWDownYenYasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu3());
                                sisuuupritu3[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getSisuuupritu3().multiply(100)),0,0);
                                tmttknzoukaritu3[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getTmttknzoukaritu3().multiply(100)),0,0);

                                if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                                    mvaAriWUp3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup3());
                                    mvaAriWSame3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame3());
                                    mvaAriWDown3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown3());
                                    mvaAriV3[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin3());
                                    mvaaritmttkgkkykkjmaeup3[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup3());
                                    mvaaritmttkgkkykkjmaesame3[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame3());
                                    mvaaritmttkgkkykkjmaedown3[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown3());
                                    tutmttknutiwake13[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake13());
                                    tutmttknutiwake23[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake23());
                                }
                                else {

                                    mvaAriWUp3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup3().multiply(100));
                                    mvaAriWSame3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame3().multiply(100));
                                    mvaAriWDown3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown3().multiply(100));
                                    mvaAriV3[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin3().multiply(100));
                                    mvaaritmttkgkkykkjmaeup3[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup3().multiply(100));
                                    mvaaritmttkgkkykkjmaesame3[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame3().multiply(100));
                                    mvaaritmttkgkkykkjmaedown3[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown3().multiply(100));
                                    tutmttknutiwake13[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake13().multiply(100));
                                    tutmttknutiwake23[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake23().multiply(100));
                                }

                                if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                    targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyendaka3()) <= 0) {
                                    mvaariwumupyendaka3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                                }
                                else {
                                    mvaariwumupyendaka3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                }

                                if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                    targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenkijyun3()) <= 0) {
                                    mvaariumupyenkijyun3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                                }
                                else {
                                    mvaariumupyenkijyun3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                }

                                if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                    targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenyasu3()) <= 0) {
                                    mvaariumupyenyasu3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                                }
                                else {
                                    mvaariumupyenyasu3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                }

                                if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                    targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyendaka3()) <= 0) {
                                    mvaariumsameyendaka3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                                }
                                else {
                                    mvaariumsameyendaka3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                }

                                if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                    targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenkijyun3()) <= 0) {
                                    mvaariumsameyenkijyun3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                                }
                                else {
                                    mvaariumsameyenkijyun3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                }

                                if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                    targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenyasu3()) <= 0) {
                                    mvaariumsameyenyasu3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                                } else {
                                    mvaariumsameyenyasu3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                }

                                if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                    targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyendaka3()) <= 0) {
                                    mvaariumdownyendaka3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                                }
                                else {
                                    mvaariumdownyendaka3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                }

                                if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                    targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenkijyun3()) <= 0) {
                                    mvaariumdownyenkijyun3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                                }
                                else {
                                    mvaariumdownyenkijyun3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                }

                                if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                    targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenyasu3()) <= 0) {
                                    mvaariumdownyenyasu3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                                }
                                else {
                                    mvaariumdownyenyasu3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                                }
                            }
                        }

                        wsjkkktyouseitkyuym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(suiihyou.getCalcym().toString() + "01"));

                        mvaariCnt++;
                    }

                    else if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn())) {

                        mvaNoneKaisiInnUmuKbn[mvanoneCnt] = C_UmuKbn.NONE.getValue();
                        mvaNoneNenOutouYm[mvanoneCnt] = String.valueOf(suiihyou.getCalcym());
                        mvaNoneWTukType[mvanoneCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvaNoneWYenSameYenDaka[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka());
                        mvaNoneWYenSameYenKijyun[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun());
                        mvaNoneWYenSameYenYasu[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu());
                        mvaNoneVTukType[mvanoneCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvanoneumyendaka[mvanoneCnt] = C_UmuKbn.NONE.toString();
                        mvanoneumyenkijyun[mvanoneCnt] = C_UmuKbn.NONE.toString();
                        mvanoneumyenyasu[mvanoneCnt] = C_UmuKbn.NONE.toString();

                        if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                            mvaNoneW[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame());
                            mvaNoneY[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin());

                        }
                        else {

                            mvaNoneW[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame().multiply(100));
                            mvaNoneY[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin().multiply(100));
                        }

                        if (suiihyouPatternSuu > 0) {
                            mvaNoneWYenSameYenDaka2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka2());
                            mvaNoneWYenSameYenKijyun2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun2());
                            mvaNoneWYenSameYenYasu2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu2());
                            mvaNoneWYenSameYenDaka3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka3());
                            mvaNoneWYenSameYenKijyun3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun3());
                            mvaNoneWYenSameYenYasu3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu3());

                            if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {
                                mvaNoneW2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame2());
                                mvaNoneY2[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin2());
                                mvaNoneW3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame3());
                                mvaNoneY3[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin3());
                            }
                            else {
                                mvaNoneW2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame2().multiply(100));
                                mvaNoneY2[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin2().multiply(100));
                                mvaNoneW3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame3().multiply(100));
                                mvaNoneY3[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin3().multiply(100));
                            }
                        }
                        mvanoneCnt++;
                    }

                    else if (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(suiihyou.getMvatekijyoutaikbn())) {

                        mvaAriNenOuTouYm[mvaariCnt] = String.valueOf(suiihyou.getCalcym());
                        mvaAriWTukTypeUp[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvaAriWUpYenDaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka());
                        mvaAriWUpYenKijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun());
                        mvaAriWUpYenYasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu());
                        mvaAriWTukTypeSame[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvaAriWSameYenDaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka());
                        mvaAriWSameYenKijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun());
                        mvaAriWSameYenYasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu());
                        mvaAriWTukTypeDown[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvaAriWDownYenDaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka());
                        mvaAriWDownYenKijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun());
                        mvaAriWDownYenYasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu());
                        mvaAriVTukType[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());

                        if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                            mvaAriWUp[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup());
                            mvaAriWSame[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame());
                            mvaAriWDown[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown());
                            mvaAriV[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin());

                        }
                        else {

                            mvaAriWUp[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup().multiply(100));
                            mvaAriWSame[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame().multiply(100));
                            mvaAriWDown[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown().multiply(100));
                            mvaAriV[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin().multiply(100));
                        }

                        if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                            targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyendaka()) <= 0) {
                            mvaariwumupyendaka[mvaariCnt] = C_UmuKbn.ARI.getValue();
                        }
                        else {
                            mvaariwumupyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }

                        if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                            targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenkijyun()) <= 0) {
                            mvaariumupyenkijyun[mvaariCnt] = C_UmuKbn.ARI.getValue();
                        }
                        else {
                            mvaariumupyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }

                        if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                            targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenyasu()) <= 0) {
                            mvaariumupyenyasu[mvaariCnt] = C_UmuKbn.ARI.getValue();
                        }
                        else {
                            mvaariumupyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }

                        if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                            targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyendaka()) <= 0) {
                            mvaariumsameyendaka[mvaariCnt] = C_UmuKbn.ARI.getValue();
                        }
                        else {
                            mvaariumsameyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }

                        if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                            targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenkijyun()) <= 0) {
                            mvaariumsameyenkijyun[mvaariCnt] = C_UmuKbn.ARI.getValue();
                        }
                        else {
                            mvaariumsameyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }

                        if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                            targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenyasu()) <= 0) {
                            mvaariumsameyenyasu[mvaariCnt] = C_UmuKbn.ARI.getValue();
                        } else {
                            mvaariumsameyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }

                        if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                            targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyendaka()) <= 0) {
                            mvaariumdownyendaka[mvaariCnt] = C_UmuKbn.ARI.getValue();
                        }
                        else {
                            mvaariumdownyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }

                        if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                            targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenkijyun()) <= 0) {
                            mvaariumdownyenkijyun[mvaariCnt] = C_UmuKbn.ARI.getValue();
                        }
                        else {
                            mvaariumdownyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }

                        if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                            targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenyasu()) <= 0) {
                            mvaariumdownyenyasu[mvaariCnt] = C_UmuKbn.ARI.getValue();
                        }
                        else {
                            mvaariumdownyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }

                        mvaNoneKaisiInnUmuKbn[mvanoneCnt] = C_UmuKbn.ARI.getValue();
                        mvaNoneNenOutouYm[mvanoneCnt] = String.valueOf(suiihyou.getCalcym());
                        mvaNoneWTukType[mvanoneCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvaNoneWYenSameYenDaka[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka());
                        mvaNoneWYenSameYenKijyun[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun());
                        mvaNoneWYenSameYenYasu[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu());
                        mvaNoneVTukType[mvanoneCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                        mvanoneumyendaka[mvanoneCnt] = C_UmuKbn.NONE.toString();
                        mvanoneumyenkijyun[mvanoneCnt] = C_UmuKbn.NONE.toString();
                        mvanoneumyenyasu[mvanoneCnt] = C_UmuKbn.NONE.toString();

                        if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                            mvaNoneW[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame());
                            mvaNoneY[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin());

                        }
                        else {

                            mvaNoneW[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame().multiply(100));
                            mvaNoneY[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin().multiply(100));
                        }

                        wsjkkktyouseitkyuym = FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(suiihyou.getCalcym().toString() + "01"));

                        if (suiihyouPatternSuu > 0) {
                            mvaAriWUpYenDaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka2());
                            mvaAriWUpYenKijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun2());
                            mvaAriWUpYenYasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu2());
                            mvaAriWSameYenDaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka2());
                            mvaAriWSameYenKijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun2());
                            mvaAriWSameYenYasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu2());
                            mvaAriWDownYenDaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka2());
                            mvaAriWDownYenKijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun2());
                            mvaAriWDownYenYasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu2());
                            mvaNoneWYenSameYenDaka2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka2());
                            mvaNoneWYenSameYenKijyun2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun2());
                            mvaNoneWYenSameYenYasu2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu2());

                            mvaAriWUpYenDaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka3());
                            mvaAriWUpYenKijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun3());
                            mvaAriWUpYenYasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu3());
                            mvaAriWSameYenDaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka3());
                            mvaAriWSameYenKijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun3());
                            mvaAriWSameYenYasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu3());
                            mvaAriWDownYenDaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka3());
                            mvaAriWDownYenKijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun3());
                            mvaAriWDownYenYasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu3());
                            mvaNoneWYenSameYenDaka3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka3());
                            mvaNoneWYenSameYenKijyun3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun3());
                            mvaNoneWYenSameYenYasu3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu3());

                            if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {
                                mvaAriWUp2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup2());
                                mvaAriWSame2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame2());
                                mvaAriWDown2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown2());
                                mvaAriV2[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin2());
                                mvaNoneW2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame2());
                                mvaNoneY2[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin2());

                                mvaAriWUp3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup3());
                                mvaAriWSame3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame3());
                                mvaAriWDown3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown3());
                                mvaAriV3[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin3());
                                mvaNoneW3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame3());
                                mvaNoneY3[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin3());
                            }
                            else {
                                mvaAriWUp2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup2().multiply(100));
                                mvaAriWSame2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame2().multiply(100));
                                mvaAriWDown2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown2().multiply(100));
                                mvaAriV2[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin2().multiply(100));
                                mvaNoneW2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame2().multiply(100));
                                mvaNoneY2[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin2().multiply(100));

                                mvaAriWUp3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup3().multiply(100));
                                mvaAriWSame3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame3().multiply(100));
                                mvaAriWDown3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown3().multiply(100));
                                mvaAriV3[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin3().multiply(100));
                                mvaNoneW3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewsame3().multiply(100));
                                mvaNoneY3[mvanoneCnt] = String.valueOf(suiihyou.getMvanoneptumitatekin3().multiply(100));
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyendaka2()) <= 0) {
                                mvaariwumupyendaka2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariwumupyendaka2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenkijyun2()) <= 0) {
                                mvaariumupyenkijyun2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumupyenkijyun2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenyasu2()) <= 0) {
                                mvaariumupyenyasu2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumupyenyasu2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyendaka2()) <= 0) {
                                mvaariumsameyendaka2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumsameyendaka2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenkijyun2()) <= 0) {
                                mvaariumsameyenkijyun2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumsameyenkijyun2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenyasu2()) <= 0) {
                                mvaariumsameyenyasu2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            } else {
                                mvaariumsameyenyasu2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyendaka2()) <= 0) {
                                mvaariumdownyendaka2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyendaka2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenkijyun2()) <= 0) {
                                mvaariumdownyenkijyun2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyenkijyun2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenyasu2()) <= 0) {
                                mvaariumdownyenyasu2[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyenyasu2[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }


                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyendaka3()) <= 0) {
                                mvaariwumupyendaka3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariwumupyendaka3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenkijyun3()) <= 0) {
                                mvaariumupyenkijyun3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumupyenkijyun3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyenupyenyasu3()) <= 0) {
                                mvaariumupyenyasu3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumupyenyasu3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyendaka3()) <= 0) {
                                mvaariumsameyendaka3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumsameyendaka3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenkijyun3()) <= 0) {
                                mvaariumsameyenkijyun3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumsameyenkijyun3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyensameyenyasu3()) <= 0) {
                                mvaariumsameyenyasu3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            } else {
                                mvaariumsameyenyasu3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyendaka3()) <= 0) {
                                mvaariumdownyendaka3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyendaka3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenkijyun3()) <= 0) {
                                mvaariumdownyenkijyun3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyenkijyun3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }

                            if (targetTokuyakuMkhgk.compareTo(BizCurrency.valueOf(0, targetTokuyakuMkhgk.getType())) > 0 &&
                                targetTokuyakuMkhgk.compareTo(suiihyou.getMvaariwyendownyenyasu3()) <= 0) {
                                mvaariumdownyenyasu3[mvaariCnt] = C_UmuKbn.ARI.getValue();
                            }
                            else {
                                mvaariumdownyenyasu3[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            }
                        }

                        mvaariCnt++;
                        mvanoneCnt++;
                    }

                    if (suiihyou2PatternSuu > 0) {

                        nenoutouym[suiihyou2Cnt] = String.valueOf(FixedDateFormatter.formatYMZenkakuSeirekiKanji(suiihyou.getCalcym().getFirstDay()));
                        hrkkknmnryumukbn[suiihyou2Cnt] = String.valueOf(suiihyou.getHrkkknmnryumukbn());
                        zennouzndkyen[suiihyou2Cnt] = String.valueOf(suiihyou.getZennouzndkyen1());
                        yenhrkgkgoukei[suiihyou2Cnt] = String.valueOf(suiihyou.getKihrkmpyen1());

                        if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                            kihrkmp[suiihyou2Cnt] = String.valueOf(suiihyou.getKihrkmp1());
                            w[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewsame());
                            zennouzndk1[suiihyou2Cnt] = String.valueOf(suiihyou.getZennouzndkyen1());
                            uktrgk[suiihyou2Cnt] = String.valueOf(suiihyou.getKaiyakujuktrgk());
                        }
                        else {

                            kihrkmp[suiihyou2Cnt] = String.valueOf(suiihyou.getKihrkmp1().multiply(100));
                            w[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewsame().multiply(100));
                            zennouzndk1[suiihyou2Cnt] = String.valueOf(suiihyou.getZennouzndk1().multiply(100));
                            uktrgk[suiihyou2Cnt] = String.valueOf(suiihyou.getKaiyakujuktrgk().multiply(100));
                        }
                        wyenyendaka[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka());
                        wyenkijun[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun());
                        wyenyenyasu[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu());
                        uktrgkyenyendaka[suiihyou2Cnt] = String.valueOf(suiihyou.getKaiyakujuktrgkyendaka());
                        uktrgkyenkijun[suiihyou2Cnt] = String.valueOf(suiihyou.getKaiyakujuktrgkyenkijyun());
                        uktrgkyenyenyasu[suiihyou2Cnt] = String.valueOf(suiihyou.getKaiyakujuktrgkyenyasu());

                        zennouzndkyen2[suiihyou2Cnt] = String.valueOf(suiihyou.getZennouzndkyen2());
                        yenhrkgkgoukei2[suiihyou2Cnt] = String.valueOf(suiihyou.getKihrkmpyen2());
                        if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                            kihrkmp2[suiihyou2Cnt] = String.valueOf(suiihyou.getKihrkmp2());
                            w2[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewsame2());
                        }
                        else {

                            kihrkmp2[suiihyou2Cnt] = String.valueOf(suiihyou.getKihrkmp2().multiply(100));
                            w2[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewsame2().multiply(100));
                        }
                        wyenyendaka2[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka2());
                        wyenkijun2[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun2());
                        wyenyenyasu2[suiihyou2Cnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu2());

                        suiihyou2Cnt++;
                    }
                }
                suiihyouCnt++;
            }

            if (dataInsFlg) {

                saihakkouHokensyoukenTy = new ZT_SaihakkouHokensyoukenTy();
                editSaihakkouHokensyoukenTy(hokenSyouken, saihakkouHokensyoukenTy);

                saihakkouHokensyoukenSuiiTy = new ZT_SaihakkouSyoukenSuiiTy();
                editSaihakkouHokensyoukenSuiiTy(hokenSyouken, suiihyou, saihakkouHokensyoukenSuiiTy);

                sinKeiyakuHokenSyoukenCnt++;

                multipleEntityInserter.add(saihakkouHokensyoukenTy);
                multipleEntityInserter.add(saihakkouHokensyoukenSuiiTy);
            }

            if (suiihyouPatternSuu == 3) {
                saihakkouHokensyoukenSuiiTy = new ZT_SaihakkouSyoukenSuiiTy();
                editSaihakkouHokensyoukenSuiiTyPattern2(hokenSyouken, suiihyou, saihakkouHokensyoukenSuiiTy);
                multipleEntityInserter.add(saihakkouHokensyoukenSuiiTy);

                saihakkouHokensyoukenSuiiTy = new ZT_SaihakkouSyoukenSuiiTy();
                editSaihakkouHokensyoukenSuiiTyPattern3(hokenSyouken, suiihyou, saihakkouHokensyoukenSuiiTy);
                multipleEntityInserter.add(saihakkouHokensyoukenSuiiTy);
            }

            if (suiihyouPatternSuu == 2) {

                saihakkouHokensyoukenSuiiTy = new ZT_SaihakkouSyoukenSuiiTy();
                editSaihakkouHokensyoukenSuiiTyPattern2(hokenSyouken, suiihyou, saihakkouHokensyoukenSuiiTy);
                multipleEntityInserter.add(saihakkouHokensyoukenSuiiTy);
            }

            if (suiihyou2PatternSuu == 2) {

                saihakkouHokensyoukenSuii2Ty = new ZT_SaihakkouSyoukenSuii2Ty();
                editSaihakkouHokensyoukenSuii2TyPattern4(suiihyou, saihakkouHokensyoukenSuii2Ty, suiihyou2Cnt);
                multipleEntityInserter.add(saihakkouHokensyoukenSuii2Ty);
                saihakkouHokensyoukenSuii2Ty = new ZT_SaihakkouSyoukenSuii2Ty();
                editSaihakkouHokensyoukenSuii2TyPattern5(suiihyou, saihakkouHokensyoukenSuii2Ty, suiihyou2Cnt);
                multipleEntityInserter.add(saihakkouHokensyoukenSuii2Ty);
            }

            if (suiihyou2PatternSuu == 1) {

                saihakkouHokensyoukenSuii2Ty = new ZT_SaihakkouSyoukenSuii2Ty();
                editSaihakkouHokensyoukenSuii2TyPattern4(suiihyou, saihakkouHokensyoukenSuii2Ty, suiihyou2Cnt);
                multipleEntityInserter.add(saihakkouHokensyoukenSuii2Ty);
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(sinKeiyakuHokenSyoukenCnt)));

    }

    private void initMemberVarible() {
        hyoujiransjkkktusirrt = "";
        hokenryouGk = "";
        znntikiktbrihrkGk = "";
        syukykTkykHknknGk1 = "";
        syukykTkykHknknGk2 = "";
        syukykTkykHknknGk3 = "";
        syukykTkykHknknGk4 = "";
        syukyktkykhknkngk5 = "";
        syukykTkykHknknGk6 = "";
        syukykTkykHknknGk7 = "";
        syukykTkykHknknGk8 = "";
        syukykTkykHknknGk9 = "";
        syukykTkykHknknGk10 = "";
        kykNiyuStitjbrP = "";
        kykNiyuStkihonS = "";
        sonotaNyranNyknTuukaP = "";
        siboudai1kjnkngk = "";
        siboudai2kjnkngk = "";
        siboudai3kjnkngk = "";
        dai1s01 = "";
        dai1s02 = "";
        dai1s03 = "";
        dai1s04 = "";
        dai1s05 = "";
        dai1s06 = "";
        dai1s07 = "";
        dai1s08 = "";
        dai1s09 = "";
        dai1s10 = "";
        dai1zennouzndk01 = "";
        dai1zennouzndk02 = "";
        dai1zennouzndk03 = "";
        dai1zennouzndk04 = "";
        dai1zennouzndk05 = "";
        dai1sbjiuktgk01 = "";
        dai1sbjiuktgk02 = "";
        dai1sbjiuktgk03 = "";
        dai1sbjiuktgk04 = "";
        dai1sbjiuktgk05 = "";
        dai2s = "";
        dai3s = "";
        dai1shuryo = "";
        kaigomaehrjrugk01 = "";
        kaigomaehrjrugk02 = "";
        kaigomaehrjrugk03 = "";
        kaigomaehrjrugk04 = "";
        kaigomaehrjrugk05 = "";
        kaigomaehrjrugk06 = "";
        kaigomaehrjrugk07 = "";
        kaigomaehrjrugk08 = "";
        kaigomaehrjrugk09 = "";
        kaigomaehrjrugk10 = "";
        sonotanyrankjnkngk = "";
        witijibrp = "";
        hyoujiranYoteiRiritu = "";
        sonotaNyranmKhwaRiai = "";
        dai1sKwsRateYenDaka = "";
        dai1sKwsRateYenKijyun = "";
        dai1sKwsRateYenyasu = "";
        sonotanyranenkhrikmrate = "";
        sonotanyranstigikwsrate = "";
        kaigomaehrstikkn01 = "";
        kaigomaehrstikkn02 = "";
        kaigomaehrstikkn03 = "";
        kaigomaehrstikkn04 = "";
        kaigomaehrstikkn05 = "";
        kaigomaehrstikkn06 = "";
        kaigomaehrstikkn07 = "";
        kaigomaehrstikkn08 = "";
        kaigomaehrstikkn09 = "";
        kaigomaehrstikkn10 = "";
        sonotanyrankjnkngkrate = "";
        yenKnsnKwsRateYenDaka = "";
        yenKnsnKwsRateYenKijyun = "";
        yenKnsnKwsRateYenYasu = "";
        sjkkktusirrtup = "";
        sjkkktusirrtsame = "";
        sjkkktusirrtdown = "";
        sjkkktusirrthendoudown = "";
        sjkkktusirrthendouup = "";
        kyknmkj = "";
        hhknnmkj = "";
        hosyounyhihknsyameikanji = "";
        mvaAriNenOuTouYm = new String[15];
        mvaAriWTukTypeUp = new String[15];
        mvaAriWUpYenDaka = new String[15];
        mvaAriWUpYenKijyun = new String[15];
        mvaAriWUpYenYasu = new String[15];
        mvaariwumupyendaka = new String[15];
        mvaariumupyenkijyun = new String[15];
        mvaariumupyenyasu = new String[15];
        mvaAriWTukTypeSame = new String[15];
        mvaAriWSameYenDaka = new String[15];
        mvaAriWSameYenKijyun = new String[15];
        mvaariumsameyendaka = new String[15];
        mvaariumsameyenkijyun = new String[15];
        mvaariumsameyenyasu = new String[15];
        mvaAriWSameYenYasu = new String[15];
        mvaAriWTukTypeDown = new String[15];
        mvaAriWDownYenDaka = new String[15];
        mvaAriWDownYenKijyun = new String[15];
        mvaAriWDownYenYasu = new String[15];
        mvaariumdownyendaka = new String[15];
        mvaariumdownyenkijyun = new String[15];
        mvaariumdownyenyasu = new String[15];
        mvaAriVTukType = new String[15];
        mvaAriWUp = new String[15];
        mvaAriWSame = new String[15];
        mvaAriWDown = new String[15];
        mvaAriV = new String[15];
        mvaNoneKaisiInnUmuKbn = new String[15];
        mvaNoneNenOutouYm = new String[15];
        mvaNoneWTukType = new String[15];
        mvaNoneWYenSameYenDaka = new String[15];
        mvaNoneWYenSameYenKijyun = new String[15];
        mvaNoneWYenSameYenYasu = new String[15];
        mvanoneumyendaka = new String[15];
        mvanoneumyenkijyun = new String[15];
        mvanoneumyenyasu = new String[15];
        mvaNoneVTukType = new String[15];
        mvaNoneW = new String[15];
        mvaNoneY = new String[15];
        tutmttknutiwake1 = new String[15];
        tutmttknutiwake2 = new String[15];
        mvaaritmttkgkkykkjmaedown = new String[15];
        mvaaritmttkgkkykkjmaesame = new String[15];
        mvaaritmttkgkkykkjmaeup = new String[15];
        sisuuupritu = new String[15];
        tmttknzoukaritu = new String[15];
        sjkkktusirrtup2 = "";
        sjkkktusirrtsame2 = "";
        sjkkktusirrtdown2 = "";
        sjkkktusirrthendoudown2 = "";
        sjkkktusirrthendouup2 = "";
        yenKnsnKwsRateYenDaka2 = "";
        yenKnsnKwsRateYenKijyun2 = "";
        yenKnsnKwsRateYenYasu2 = "";
        sisuuupritu2 = new String[15];
        tmttknzoukaritu2 = new String[15];
        mvaaritmttkgkkykkjmaeup2 = new String[15];
        mvaAriWUp2 = new String[15];
        mvaAriWUpYenDaka2 = new String[15];
        mvaAriWUpYenKijyun2 = new String[15];
        mvaAriWUpYenYasu2 =  new String[15];
        mvaariwumupyendaka2 =  new String[15];
        mvaariumupyenkijyun2 = new String[15];
        mvaariumupyenyasu2 = new String[15];
        mvaariumsameyendaka2 = new String[15];
        mvaariumsameyenkijyun2 = new String[15];
        mvaariumsameyenyasu2 = new String[15];
        mvaariumdownyendaka2 = new String[15];
        mvaariumdownyenkijyun2 = new String[15];
        mvaariumdownyenyasu2 = new String[15];
        mvaaritmttkgkkykkjmaesame2 = new String[15];
        mvaAriWSame2 = new String[15];
        mvaAriWSameYenDaka2 = new String[15];
        mvaAriWSameYenKijyun2 = new String[15];
        mvaAriWSameYenYasu2 = new String[15];
        mvaaritmttkgkkykkjmaedown2 = new String[15];
        mvaAriWDown2 = new String[15];
        mvaAriWDownYenDaka2 = new String[15];
        mvaAriWDownYenKijyun2 = new String[15];
        mvaAriWDownYenYasu2 = new String[15];
        mvaAriV2 = new String[15];
        tutmttknutiwake12 = new String[15];
        tutmttknutiwake22 = new String[15];
        mvaNoneW2 = new String[15];
        mvaNoneWYenSameYenDaka2 = new String[15];
        mvaNoneWYenSameYenKijyun2 = new String[15];
        mvaNoneWYenSameYenYasu2 = new String[15];
        mvaNoneY2 = new String[15];
        sjkkktusirrtup3 = "";
        sjkkktusirrtsame3 = "";
        sjkkktusirrtdown3 = "";
        sjkkktusirrthendoudown3 = "";
        sjkkktusirrthendouup3 = "";
        yenKnsnKwsRateYenDaka3 = "";
        yenKnsnKwsRateYenKijyun3 = "";
        yenKnsnKwsRateYenYasu3 = "";
        sisuuupritu3 = new String[15];
        tmttknzoukaritu3 = new String[15];
        mvaaritmttkgkkykkjmaeup3 = new String[15];
        mvaAriWUp3 = new String[15];
        mvaAriWUpYenDaka3 = new String[15];
        mvaAriWUpYenKijyun3 = new String[15];
        mvaAriWUpYenYasu3 =  new String[15];
        mvaariwumupyendaka3 =  new String[15];
        mvaariumupyenkijyun3 = new String[15];
        mvaariumupyenyasu3 = new String[15];
        mvaariumsameyendaka3 = new String[15];
        mvaariumsameyenkijyun3 = new String[15];
        mvaariumsameyenyasu3 = new String[15];
        mvaariumdownyendaka3 = new String[15];
        mvaariumdownyenkijyun3 = new String[15];
        mvaariumdownyenyasu3 = new String[15];
        mvaaritmttkgkkykkjmaesame3 = new String[15];
        mvaAriWSame3 = new String[15];
        mvaAriWSameYenDaka3 = new String[15];
        mvaAriWSameYenKijyun3 = new String[15];
        mvaAriWSameYenYasu3 = new String[15];
        mvaaritmttkgkkykkjmaedown3 = new String[15];
        mvaAriWDown3 = new String[15];
        mvaAriWDownYenDaka3 = new String[15];
        mvaAriWDownYenKijyun3 = new String[15];
        mvaAriWDownYenYasu3 = new String[15];
        mvaAriV3 = new String[15];
        tutmttknutiwake13 = new String[15];
        tutmttknutiwake23 = new String[15];
        mvaNoneW3 = new String[15];
        mvaNoneWYenSameYenDaka3 = new String[15];
        mvaNoneWYenSameYenKijyun3 = new String[15];
        mvaNoneWYenSameYenYasu3 = new String[15];
        mvaNoneY3 = new String[15];
        hyoujirantumitateriritu = "";
        hyoujirantmttknzkrtjygn = "";
        hyoujiransetteibairitu = "";
        hutanhiyustmytijihiritu = "";
        hrkkknmnryym = "";
        hrkkknmnrynen = "";
        nenoutouym = new String[22];
        hrkkknmnryumukbn = new String[22];
        zennouzndkyen = new String[22];
        yenhrkgkgoukei = new String[22];
        kihrkmp = new String[22];
        w = new String[22];
        wyenyendaka = new String[22];
        wyenkijun = new String[22];
        wyenyenyasu = new String[22];
        zennouzndkyen2 = new String[22];
        yenhrkgkgoukei2 = new String[22];
        kihrkmp2 = new String[22];
        w2 = new String[22];
        wyenyendaka2 = new String[22];
        wyenkijun2 = new String[22];
        wyenyenyasu2 = new String[22];
        zennouzndk1  = new String[22];
        uktrgk  = new String[22];
        uktrgkyenyendaka  = new String[22];
        uktrgkyenkijun  = new String[22];
        uktrgkyenyenyasu  = new String[22];
    }

    private void editSaihakkouHokensyoukenTy(
        IT_HokenSyouken pHokenSyouken,
        ZT_SaihakkouHokensyoukenTy pSaihakkouHokensyoukenTy) {

        pSaihakkouHokensyoukenTy.setZtysyoruicd(C_SyoruiCdKbn.KK_HKNSYKN.getValue().toUpperCase());
        pSaihakkouHokensyoukenTy.setZtytyouhyouymd(String.valueOf(pHokenSyouken.getTyouhyouymd()));
        pSaihakkouHokensyoukenTy.setZtysyono(pHokenSyouken.getSyono());
        pSaihakkouHokensyoukenTy.setZtyhassoukbn(pHokenSyouken.getHassoukbn().getValue());
        pSaihakkouHokensyoukenTy.setZtykanryoutuutidouhuukbn(pHokenSyouken.getKanryoutuutiumukbn().getValue());
        pSaihakkouHokensyoukenTy.setZtysikibetuno(pHokenSyouken.getHenkousikibetukey());
        pSaihakkouHokensyoukenTy.setZtystdrsktirasidouhuukbn(pHokenSyouken.getStdrsktirasidouhuukbn().getValue());
        pSaihakkouHokensyoukenTy.setZtyaisyoumeikbn(pHokenSyouken.getAisyoumeikbn().getValue());
        pSaihakkouHokensyoukenTy.setZtysagyoukbn("1");
        pSaihakkouHokensyoukenTy.setZtyyakkanbunsyono(pHokenSyouken.getYakkanbunsyono());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd1(pHokenSyouken.getHyoujiranhidarimsgcd1());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd2(pHokenSyouken.getHyoujiranhidarimsgcd2());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd3(pHokenSyouken.getHyoujiranhidarimsgcd3());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd4(pHokenSyouken.getHyoujiranhidarimsgcd4());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd5(pHokenSyouken.getHyoujiranhidarimsgcd5());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd6(pHokenSyouken.getHyoujiranhidarimsgcd6());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd7(pHokenSyouken.getHyoujiranhidarimsgcd7());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd8(pHokenSyouken.getHyoujiranhidarimsgcd8());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd9(pHokenSyouken.getHyoujiranhidarimsgcd9());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd10(pHokenSyouken.getHyoujiranhidarimsgcd10());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd11(pHokenSyouken.getHyoujiranhidarimsgcd11());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd12(pHokenSyouken.getHyoujiranhidarimsgcd12());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd13(pHokenSyouken.getHyoujiranhidarimsgcd13());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd14(pHokenSyouken.getHyoujiranhidarimsgcd14());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd15(pHokenSyouken.getHyoujiranhidarimsgcd15());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd16(pHokenSyouken.getHyoujiranhidarimsgcd16());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd17(pHokenSyouken.getHyoujiranhidarimsgcd17());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd18(pHokenSyouken.getHyoujiranhidarimsgcd18());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd19(pHokenSyouken.getHyoujiranhidarimsgcd19());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranhidarimsgcd20(pHokenSyouken.getHyoujiranhidarimsgcd20());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd1(pHokenSyouken.getHyoujiranmigiimsgcd1());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd2(pHokenSyouken.getHyoujiranmigiimsgcd2());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd3(pHokenSyouken.getHyoujiranmigiimsgcd3());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd4(pHokenSyouken.getHyoujiranmigiimsgcd4());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd5(pHokenSyouken.getHyoujiranmigiimsgcd5());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd6(pHokenSyouken.getHyoujiranmigiimsgcd6());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd7(pHokenSyouken.getHyoujiranmigiimsgcd7());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd8(pHokenSyouken.getHyoujiranmigiimsgcd8());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd9(pHokenSyouken.getHyoujiranmigiimsgcd9());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd10(pHokenSyouken.getHyoujiranmigiimsgcd10());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd11(pHokenSyouken.getHyoujiranmigiimsgcd11());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd12(pHokenSyouken.getHyoujiranmigiimsgcd12());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd13(pHokenSyouken.getHyoujiranmigiimsgcd13());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd14(pHokenSyouken.getHyoujiranmigiimsgcd14());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd15(pHokenSyouken.getHyoujiranmigiimsgcd15());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd16(pHokenSyouken.getHyoujiranmigiimsgcd16());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd17(pHokenSyouken.getHyoujiranmigiimsgcd17());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd18(pHokenSyouken.getHyoujiranmigiimsgcd18());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd19(pHokenSyouken.getHyoujiranmigiimsgcd19());
        pSaihakkouHokensyoukenTy.setZtyhyoujiranmigimsgcd20(pHokenSyouken.getHyoujiranmigiimsgcd20());
        pSaihakkouHokensyoukenTy.setZtysknnkaisiymdseireki(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getHyoujiransknnkaisiymd()));
        pSaihakkouHokensyoukenTy.setZtyhyoujiranytirrt(hyoujiranYoteiRiritu);
        pSaihakkouHokensyoukenTy.setZtyhyoujiransjkkktusirrt(hyoujiransjkkktusirrt);
        pSaihakkouHokensyoukenTy.setZtyhyoujirantumitateriritu(hyoujirantumitateriritu);
        pSaihakkouHokensyoukenTy.setZtyhyoujirantumitateriritu2(hyoujirantumitateriritu2);
        pSaihakkouHokensyoukenTy.setZtyhyoujirantmttknzkrtjygn(hyoujirantmttknzkrtjygn);
        pSaihakkouHokensyoukenTy.setZtyhyoujiransetteibairitu(hyoujiransetteibairitu);
        pSaihakkouHokensyoukenTy.setZtyhknsyukigou(pHokenSyouken.getHknsyukigou());
        pSaihakkouHokensyoukenTy.setZtysyoukenhakkouymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyohakkouymd()));
        pSaihakkouHokensyoukenTy.setZtyseisikihknnmsyouken(pHokenSyouken.getSeisikihknnm());
        pSaihakkouHokensyoukenTy.setZtynksyuruinmsyouken(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken());
        pSaihakkouHokensyoukenTy.setZtyyobiv116("");
        pSaihakkouHokensyoukenTy.setZtykyknmkj(kyknmkj);
        pSaihakkouHokensyoukenTy.setZtyhhknnmkj(hhknnmkj);
        pSaihakkouHokensyoukenTy.setZtyhihknsyaseiymdwareki(FixedDateFormatter.formatYMDZenkakuWarekiKanji(
            pHokenSyouken.getHhknseiymd()));
        pSaihakkouHokensyoukenTy.setZtyhhknsei(pHokenSyouken.getHhknsei().getValue());
        pSaihakkouHokensyoukenTy.setZtyhhknnen2(String.valueOf(pHokenSyouken.getHhknnen()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn1())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn1(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn1()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn1())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn1(String.valueOf(pHokenSyouken.getSyoukenuktkbn1()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm1(pHokenSyouken.getSyoukenuktnm1());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari1(String.valueOf(pHokenSyouken.getSyoukenuktbnwari1()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn2())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn2(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn2()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn2())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn2(String.valueOf(pHokenSyouken.getSyoukenuktkbn2()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm2(pHokenSyouken.getSyoukenuktnm2());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari2(String.valueOf(pHokenSyouken.getSyoukenuktbnwari2()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn3())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn3(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn3()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn3())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn3(String.valueOf(pHokenSyouken.getSyoukenuktkbn3()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm3(pHokenSyouken.getSyoukenuktnm3());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari3(String.valueOf(pHokenSyouken.getSyoukenuktbnwari3()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn4())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn4(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn4()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn4())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn4(String.valueOf(pHokenSyouken.getSyoukenuktkbn4()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm4(pHokenSyouken.getSyoukenuktnm4());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari4(String.valueOf(pHokenSyouken.getSyoukenuktbnwari4()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn5())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn5(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn5()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn5())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn5(String.valueOf(pHokenSyouken.getSyoukenuktkbn5()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm5(pHokenSyouken.getSyoukenuktnm5());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari5(String.valueOf(pHokenSyouken.getSyoukenuktbnwari5()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn6())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn6(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn6()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn6())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn6(String.valueOf(pHokenSyouken.getSyoukenuktkbn6()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm6(pHokenSyouken.getSyoukenuktnm6());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari6(String.valueOf(pHokenSyouken.getSyoukenuktbnwari6()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn7())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn7(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn7()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn7())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn7(String.valueOf(pHokenSyouken.getSyoukenuktkbn7()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm7(pHokenSyouken.getSyoukenuktnm7());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari7(String.valueOf(pHokenSyouken.getSyoukenuktbnwari7()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn8())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn8(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn8()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn8())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn8(String.valueOf(pHokenSyouken.getSyoukenuktkbn8()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm8(pHokenSyouken.getSyoukenuktnm8());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari8(String.valueOf(pHokenSyouken.getSyoukenuktbnwari8()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn9())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn9(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn9()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn9())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn9(String.valueOf(pHokenSyouken.getSyoukenuktkbn9()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm9(pHokenSyouken.getSyoukenuktnm9());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari9(String.valueOf(pHokenSyouken.getSyoukenuktbnwari9()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn10())) {
            pSaihakkouHokensyoukenTy.setZtyuktmidasikbn10(String.valueOf(pHokenSyouken.getSyoukenuktmidasikbn10()));
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn10())) {
            pSaihakkouHokensyoukenTy.setZtyuktkbn10(String.valueOf(pHokenSyouken.getSyoukenuktkbn10()));
        }
        pSaihakkouHokensyoukenTy.setZtyuktnm10(pHokenSyouken.getSyoukenuktnm10());
        pSaihakkouHokensyoukenTy.setZtyuktbnwari10(String.valueOf(pHokenSyouken.getSyoukenuktbnwari10()));
        pSaihakkouHokensyoukenTy.setZtypmsgcd1(pHokenSyouken.getPmsgcd1());
        pSaihakkouHokensyoukenTy.setZtypmsgcd2(pHokenSyouken.getPmsgcd2());
        pSaihakkouHokensyoukenTy.setZtypmsgcd3(pHokenSyouken.getPmsgcd3());
        pSaihakkouHokensyoukenTy.setZtyyobiv10("");
        pSaihakkouHokensyoukenTy.setZtyptuukatype(pHokenSyouken.getPtuukatype().getValue());
        pSaihakkouHokensyoukenTy.setZtypkngk(hokenryouGk);
        pSaihakkouHokensyoukenTy.setZtypkngktuuka(pHokenSyouken.getPtuuka());
        pSaihakkouHokensyoukenTy.setZtyteikiikkatubaraitukisuu(String.valueOf(
            BizUtil.zeroNum(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()), 2, 0)));
        pSaihakkouHokensyoukenTy.setZtyztikiktbriyhrkgktuktype(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype()));
        pSaihakkouHokensyoukenTy.setZtyznntikiktbriyenhrkgk(znntikiktbrihrkGk);
        pSaihakkouHokensyoukenTy.setZtyznnkai(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()));
        pSaihakkouHokensyoukenTy.setZtytikiktbriyhrkgktuktype(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype()));
        pSaihakkouHokensyoukenTy.setZtytikiktbriyenhrkgk(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk()));
        pSaihakkouHokensyoukenTy.setZtyptokuyakumsgcd(pHokenSyouken.getPtokuyakumsgcd());
        pSaihakkouHokensyoukenTy.setZtykykymdseireki(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getKykymd()));
        pSaihakkouHokensyoukenTy.setZtyphrkkknmidasikbn(pHokenSyouken.getPhrkkknmidasikbn());
        pSaihakkouHokensyoukenTy.setZtyhrkkknmsgkbn(pHokenSyouken.getHrkkknmsgkbn());
        pSaihakkouHokensyoukenTy.setZtyhrkkaisuumsgkbn(pHokenSyouken.getHrkkaisuumsgkbn());
        pSaihakkouHokensyoukenTy.setZtyhrkhouhoumsgkbn(pHokenSyouken.getHrkhouhoumsgkbn());
        pSaihakkouHokensyoukenTy.setZtyphrkktuki(pHokenSyouken.getPhrkktuki());
        pSaihakkouHokensyoukenTy.setZtyyobiv18("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban1(String.valueOf(pHokenSyouken.getSyukyktkykrenban1()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn1(pHokenSyouken.getSyukyktkykmsgkbn1());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn1(pHokenSyouken.getSyukyktkyksmsgkbn1());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn1(pHokenSyouken.getSyukyktkykhknkknmsgkbn1());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype1(pHokenSyouken.getSyukyktkykstuukatype1().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk1(syukykTkykHknknGk1);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto1(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto1()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto1(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto1()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban2(String.valueOf(pHokenSyouken.getSyukyktkykrenban2()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn2(pHokenSyouken.getSyukyktkykmsgkbn2());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn2(pHokenSyouken.getSyukyktkyksmsgkbn2());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn2(pHokenSyouken.getSyukyktkykhknkknmsgkbn2());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype2(pHokenSyouken.getSyukyktkykstuukatype2().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk2(syukykTkykHknknGk2);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto2(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto2()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto2(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto2()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22x2("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban3(String.valueOf(pHokenSyouken.getSyukyktkykrenban3()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn3(pHokenSyouken.getSyukyktkykmsgkbn3());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn3(pHokenSyouken.getSyukyktkyksmsgkbn3());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn3(pHokenSyouken.getSyukyktkykhknkknmsgkbn3());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype3(pHokenSyouken.getSyukyktkykstuukatype3().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk3(syukykTkykHknknGk3);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto3(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto3()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto3(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto3()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22x3("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban4(String.valueOf(pHokenSyouken.getSyukyktkykrenban4()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn4(pHokenSyouken.getSyukyktkykmsgkbn4());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn4(pHokenSyouken.getSyukyktkyksmsgkbn4());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn4(pHokenSyouken.getSyukyktkykhknkknmsgkbn4());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype4(pHokenSyouken.getSyukyktkykstuukatype4().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk4(syukykTkykHknknGk4);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto4(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto4()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto4(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto4()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22x4("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban5(String.valueOf(pHokenSyouken.getSyukyktkykrenban5()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn5(pHokenSyouken.getSyukyktkykmsgkbn5());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn5(pHokenSyouken.getSyukyktkyksmsgkbn5());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn5(pHokenSyouken.getSyukyktkykhknkknmsgkbn5());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype5(pHokenSyouken.getSyukyktkykstuukatype5().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk5(syukyktkykhknkngk5);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto5(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto5()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto5(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto5()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22x5("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban6(String.valueOf(pHokenSyouken.getSyukyktkykrenban6()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn6(pHokenSyouken.getSyukyktkykmsgkbn6());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn6(pHokenSyouken.getSyukyktkyksmsgkbn6());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn6(pHokenSyouken.getSyukyktkykhknkknmsgkbn6());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype6(pHokenSyouken.getSyukyktkykstuukatype6().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk6(syukykTkykHknknGk6);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto6(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto6()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto6(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto6()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22x6("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban7(String.valueOf(pHokenSyouken.getSyukyktkykrenban7()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn7(pHokenSyouken.getSyukyktkykmsgkbn7());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn7(pHokenSyouken.getSyukyktkyksmsgkbn7());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn7(pHokenSyouken.getSyukyktkykhknkknmsgkbn7());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype7(pHokenSyouken.getSyukyktkykstuukatype7().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk7(syukykTkykHknknGk7);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto7(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto7()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto7(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto7()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22x7("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban8(String.valueOf(pHokenSyouken.getSyukyktkykrenban8()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn8(pHokenSyouken.getSyukyktkykmsgkbn8());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn8(pHokenSyouken.getSyukyktkyksmsgkbn8());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn8(pHokenSyouken.getSyukyktkykhknkknmsgkbn8());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype8(pHokenSyouken.getSyukyktkykstuukatype8().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk8(syukykTkykHknknGk8);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto8(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto8()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto8(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto8()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22x8("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban9(String.valueOf(pHokenSyouken.getSyukyktkykrenban9()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn9(pHokenSyouken.getSyukyktkykmsgkbn9());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn9(pHokenSyouken.getSyukyktkyksmsgkbn9());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn9(pHokenSyouken.getSyukyktkykhknkknmsgkbn9());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype9(pHokenSyouken.getSyukyktkykstuukatype9().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk9(syukykTkykHknknGk9);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto9(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto9()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto9(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto9()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22x9("");
        pSaihakkouHokensyoukenTy.setZtysyukyktkykrenban10(String.valueOf(pHokenSyouken.getSyukyktkykrenban10()));
        pSaihakkouHokensyoukenTy.setZtysyukyktkykmsgkbn10(pHokenSyouken.getSyukyktkykmsgkbn10());
        pSaihakkouHokensyoukenTy.setZtysyukyktkyksmsgkbn10(pHokenSyouken.getSyukyktkyksmsgkbn10());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn10(pHokenSyouken.getSyukyktkykhknkknmsgkbn10());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykstuukatype10(pHokenSyouken.getSyukyktkykstuukatype10().getValue());
        pSaihakkouHokensyoukenTy.setZtysyukyktkykhknkngk10(syukykTkykHknknGk10);
        pSaihakkouHokensyoukenTy.setZtysyutkdai1hknkknymdto10(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai1hknkknymdto10()));
        pSaihakkouHokensyoukenTy.setZtysyutkdai2hknkknymdto10(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSyutkdai2hknkknymdto10()));
        pSaihakkouHokensyoukenTy.setZtyyobiv22x10("");
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd1(pHokenSyouken.getKykniyustmsgcd1());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd2(pHokenSyouken.getKykniyustmsgcd2());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd3(pHokenSyouken.getKykniyustmsgcd3());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd4(pHokenSyouken.getKykniyustmsgcd4());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd5(pHokenSyouken.getKykniyustmsgcd5());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd6(pHokenSyouken.getKykniyustmsgcd6());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd7(pHokenSyouken.getKykniyustmsgcd7());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd8(pHokenSyouken.getKykniyustmsgcd8());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd9(pHokenSyouken.getKykniyustmsgcd9());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd10(pHokenSyouken.getKykniyustmsgcd10());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd11(pHokenSyouken.getKykniyustmsgcd11());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd12(pHokenSyouken.getKykniyustmsgcd12());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd13(pHokenSyouken.getKykniyustmsgcd13());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd14(pHokenSyouken.getKykniyustmsgcd14());
        pSaihakkouHokensyoukenTy.setZtykykniyustmsgcd15(pHokenSyouken.getKykniyustmsgcd15());
        pSaihakkouHokensyoukenTy.setZtykykniyustitjbrptuuktype(pHokenSyouken.getKykniyustitjbrptuuktype().getValue());
        pSaihakkouHokensyoukenTy.setZtykykniyustitjbrp(kykNiyuStitjbrP);
        pSaihakkouHokensyoukenTy.setZtykykniyustkihonstype(pHokenSyouken.getSyukyktkykstuukatype1().getValue());
        pSaihakkouHokensyoukenTy.setZtykykniyustkihons(kykNiyuStkihonS);
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd1(pHokenSyouken.getStnaiyouranmsgcd1());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd2(pHokenSyouken.getStnaiyouranmsgcd2());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd3(pHokenSyouken.getStnaiyouranmsgcd3());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd4(pHokenSyouken.getStnaiyouranmsgcd4());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd5(pHokenSyouken.getStnaiyouranmsgcd5());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd6(pHokenSyouken.getStnaiyouranmsgcd6());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd7(pHokenSyouken.getStnaiyouranmsgcd7());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd8(pHokenSyouken.getStnaiyouranmsgcd8());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd9(pHokenSyouken.getStnaiyouranmsgcd9());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd10(pHokenSyouken.getStnaiyouranmsgcd10());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd11(pHokenSyouken.getStnaiyouranmsgcd11());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd12(pHokenSyouken.getStnaiyouranmsgcd12());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd13(pHokenSyouken.getStnaiyouranmsgcd13());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd14(pHokenSyouken.getStnaiyouranmsgcd14());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd15(pHokenSyouken.getStnaiyouranmsgcd15());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd16(pHokenSyouken.getStnaiyouranmsgcd16());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd17(pHokenSyouken.getStnaiyouranmsgcd17());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd18(pHokenSyouken.getStnaiyouranmsgcd18());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd19(pHokenSyouken.getStnaiyouranmsgcd19());
        pSaihakkouHokensyoukenTy.setZtysonotanyranmsgcd20(pHokenSyouken.getStnaiyouranmsgcd20());
        pSaihakkouHokensyoukenTy.setZtysonotanyransiteituuka(pHokenSyouken.getSonotanyransiteituuka());
        pSaihakkouHokensyoukenTy.setZtysonotanyrannykntuktype(pHokenSyouken.getSonotanyrannykntuktype().getValue());
        pSaihakkouHokensyoukenTy.setZtysonotanyrannykntuukap(sonotaNyranNyknTuukaP);
        pSaihakkouHokensyoukenTy.setZtysonotanyrannykntuukasyu(pHokenSyouken.getSonotanyrannykntuukasyu());
        pSaihakkouHokensyoukenTy.setZtysonotanyranenkhrikmrate(sonotanyranenkhrikmrate);
        pSaihakkouHokensyoukenTy.setZtysonotanyranstigikwsrate(sonotanyranstigikwsrate);

        pSaihakkouHokensyoukenTy.setZtysonotanykjnkngktuktype(String.valueOf(pHokenSyouken.getSonotanyrankjnkngktuktype()));
        pSaihakkouHokensyoukenTy.setZtysonotanykjnkngk(sonotanyrankjnkngk);
        pSaihakkouHokensyoukenTy.setZtysonotanykjnkngkrate(sonotanyrankjnkngkrate);
        pSaihakkouHokensyoukenTy.setZtysonotanykjnkngktuuka(pHokenSyouken.getSonotanyrankjnkngktuuka());

        pSaihakkouHokensyoukenTy.setZtysonotanyranpentuktype(String.valueOf(pHokenSyouken.getSonotanyranpentuktype()));
        pSaihakkouHokensyoukenTy.setZtysonotanyranpenknsngk(String.valueOf(pHokenSyouken.getSonotanyranpenknsngk()));
        pSaihakkouHokensyoukenTy.setZtypmkhtoutatuwariai(sonotaNyranmKhwaRiai);
        pSaihakkouHokensyoukenTy.setZtysonotanyranmkhgk(sonotanyranmkhgk);
        pSaihakkouHokensyoukenTy.setZtysonotanyrannkshrstartymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSonotanyrannkshrstartymd()));
        pSaihakkouHokensyoukenTy.setZtysonotanyrannkkkn(String.valueOf(pHokenSyouken.getSonotanyrannenkinkkn()));
        pSaihakkouHokensyoukenTy.setZtysonotanyyensysnhkhnkymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSonotanyranyensysnhkhnkymd()));
        pSaihakkouHokensyoukenTy.setZtysonotanytmttkngktuktype(pHokenSyouken.getSonotanyrantmttkngktuktype());
        pSaihakkouHokensyoukenTy.setZtysonotanyteiritutmttkngk(sonotanyranteiritutmttkngk);
        pSaihakkouHokensyoukenTy.setZtysonotanyransisuutmttkngk(sonotanyransisuutmttkngk);
        pSaihakkouHokensyoukenTy.setZtysonotanyransisuunm(pHokenSyouken.getSonotanyransisuunm());
        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            BizNumber rendouritu = pHokenSyouken.getHokenSyoukenHukaInfo().getRendouritu().multiply(100);

            if (rendouritu.compareTo(BizNumber.TEN) < 0) {

                pSaihakkouHokensyoukenTy.setZtysonotanyrendouritu(
                    "　　" +  ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(rendouritu), 1, 2), 0, 0));
            }
            else if (rendouritu.compareTo(BizNumber.valueOf(new BigDecimal(100))) < 0) {

                pSaihakkouHokensyoukenTy.setZtysonotanyrendouritu(
                    "　" +  ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(rendouritu), 2, 2), 0, 0));
            }
            else {

                pSaihakkouHokensyoukenTy.setZtysonotanyrendouritu(
                    ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(rendouritu), 3, 2), 0, 0));
            }
        }
        pSaihakkouHokensyoukenTy.setZtysonotanyrangaimsgcd(pHokenSyouken.getStnaiyourangaimsgcd());
        pSaihakkouHokensyoukenTy.setZtyhosyounymsgcd(pHokenSyouken.getHosyounymsgcd());
        pSaihakkouHokensyoukenTy.setZtyyobiv15("");
        pSaihakkouHokensyoukenTy.setZtyhosyounyhihknsyanmkanji(hosyounyhihknsyameikanji);
        pSaihakkouHokensyoukenTy.setZtysiboumidasimsgcd(pHokenSyouken.getSiboumidasimsgcd());
        pSaihakkouHokensyoukenTy.setZtysiboumidasimsgcd2(pHokenSyouken.getSiboumidasimsgcd2());
        pSaihakkouHokensyoukenTy.setZtysiboudai1hknkknmsgcd1(pHokenSyouken.getSiboudai1hknkknmsgcd1());
        pSaihakkouHokensyoukenTy.setZtysiboudai1hknkknmsgcd2(pHokenSyouken.getSiboudai1hknkknmsgcd2());
        pSaihakkouHokensyoukenTy.setZtysiboudai1hknkknigimsgcd(pHokenSyouken.getSiboudai1hknkknigimsgcd());
        pSaihakkouHokensyoukenTy.setZtysiboudai1hknkknigimsgcd2(pHokenSyouken.getSiboudai1hknkknigimsgcd2());
        pSaihakkouHokensyoukenTy.setZtysiboudai1hknkknhrsmsgcd(pHokenSyouken.getSiboudai1hknkknhrsmsgcd());
        pSaihakkouHokensyoukenTy.setZtysiboudai1hknkknhrsmsgcd2(pHokenSyouken.getSiboudai1hknkknhrsmsgcd2());
        pSaihakkouHokensyoukenTy.setZtysiboudai1hknkknsmrmsgcd(pHokenSyouken.getSiboudai1hknkknsmrmsgcd());
        pSaihakkouHokensyoukenTy.setZtysiboudai2hknkknmsgcd1(pHokenSyouken.getSiboudai2hknkknmsgcd1());
        pSaihakkouHokensyoukenTy.setZtysiboudai2hknkknmsgcd2(pHokenSyouken.getSiboudai2hknkknmsgcd2());
        pSaihakkouHokensyoukenTy.setZtysiboudai2hknkknsmsgcd(pHokenSyouken.getSiboudai2hknkknsmsgcd());
        pSaihakkouHokensyoukenTy.setZtysiboudai2hknkknsmsgcd2(pHokenSyouken.getSiboudai2hknkknsmsgcd2());
        pSaihakkouHokensyoukenTy.setZtysiboudai3hknkknmsgcd1(pHokenSyouken.getSiboudai3hknkknmsgcd1());
        pSaihakkouHokensyoukenTy.setZtysiboudai3hknkknmsgcd2(pHokenSyouken.getSiboudai3hknkknmsgcd2());
        pSaihakkouHokensyoukenTy.setZtyyobiv15x2("");
        pSaihakkouHokensyoukenTy.setZtysiboudai1hknkknymdto(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSiboudai1hknkknymdto()));
        pSaihakkouHokensyoukenTy.setZtysibouitjbrpyentuuktype(String.valueOf(pHokenSyouken.getSibouitjbrpyentuuktype()));
        pSaihakkouHokensyoukenTy.setZtysibouitjbrpyentuukgk(pHokenSyouken.getSibouitjbrpyentuukgk().toString());

        pSaihakkouHokensyoukenTy.setZtysiboudai1kjnkngktuktype(String.valueOf(pHokenSyouken.getSiboudai1kjnkngktuuktype()));
        pSaihakkouHokensyoukenTy.setZtysiboudai1kjnkngk(siboudai1kjnkngk);

        pSaihakkouHokensyoukenTy.setZtysiboudai2hknkknymdto(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getSiboudai2hknkknymdto()));

        pSaihakkouHokensyoukenTy.setZtysiboudai2kjnkngktuktype(String.valueOf(pHokenSyouken.getSiboudai2kjnkngktuuktype()));
        pSaihakkouHokensyoukenTy.setZtysiboudai2kjnkngk(siboudai2kjnkngk);
        pSaihakkouHokensyoukenTy.setZtysiboudai3kjnkngktuktype(String.valueOf(pHokenSyouken.getSiboudai3kjnkngktuuktype()));
        pSaihakkouHokensyoukenTy.setZtysiboudai3kjnkngk(siboudai3kjnkngk);

        pSaihakkouHokensyoukenTy.setZtydai1skwsrateyendaka(dai1sKwsRateYenDaka);
        pSaihakkouHokensyoukenTy.setZtydai1skwsrateyenkijyun(dai1sKwsRateYenKijyun);
        pSaihakkouHokensyoukenTy.setZtydai1skwsrateyenyasu(dai1sKwsRateYenyasu);
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd1(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd01()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype01(pHokenSyouken.getDai1stuuktype01().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s01(dai1s01);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu01(pHokenSyouken.getDai1syenyendakaumu01());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu01(pHokenSyouken.getDai1syenyenkijyunumu01());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu01(pHokenSyouken.getDai1syenyenyasuumu01());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype01(pHokenSyouken.getDai1syentuuktype01().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka01(pHokenSyouken.getDai1syenyendaka01().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun01(pHokenSyouken.getDai1syenyenkijyun01().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu01(pHokenSyouken.getDai1syenyenyasu01().toString());
        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSaihakkouHokensyoukenTy.setZtydai1zennouzndk01(dai1zennouzndk01);
            pSaihakkouHokensyoukenTy.setZtydai1zennouzndktype01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype01()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgk01(dai1sbjiuktgk01);
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgktype01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype01()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkytype01(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkydaka01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka01()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkykijyun01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun01()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkyyasu01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu01()));
        }
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd2(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd02()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype02(pHokenSyouken.getDai1stuuktype02().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s02(dai1s02);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu02(pHokenSyouken.getDai1syenyendakaumu02());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu02(pHokenSyouken.getDai1syenyenkijyunumu02());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu02(pHokenSyouken.getDai1syenyenyasuumu02());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype02(pHokenSyouken.getDai1syentuuktype02().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka02(pHokenSyouken.getDai1syenyendaka02().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun02(pHokenSyouken.getDai1syenyenkijyun02().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu02(pHokenSyouken.getDai1syenyenyasu02().toString());
        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSaihakkouHokensyoukenTy.setZtydai1zennouzndk02(dai1zennouzndk02);
            pSaihakkouHokensyoukenTy.setZtydai1zennouzndktype02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype02()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgk02(dai1sbjiuktgk02);
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgktype02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype02()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkytype02(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkydaka02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka02()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkykijyun02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun02()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkyyasu02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu02()));
        }
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd3(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd03()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype03(pHokenSyouken.getDai1stuuktype03().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s03(dai1s03);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu03(pHokenSyouken.getDai1syenyendakaumu03());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu03(pHokenSyouken.getDai1syenyenkijyunumu03());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu03(pHokenSyouken.getDai1syenyenyasuumu03());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype03(pHokenSyouken.getDai1syentuuktype03().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka03(pHokenSyouken.getDai1syenyendaka03().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun03(pHokenSyouken.getDai1syenyenkijyun03().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu03(pHokenSyouken.getDai1syenyenyasu03().toString());
        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSaihakkouHokensyoukenTy.setZtydai1zennouzndk03(dai1zennouzndk03);
            pSaihakkouHokensyoukenTy.setZtydai1zennouzndktype03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype03()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgk03(dai1sbjiuktgk03);
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgktype03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype03()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkytype03(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkydaka03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka03()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkykijyun03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun03()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkyyasu03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu03()));
        }
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd4(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd04()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype04(pHokenSyouken.getDai1stuuktype04().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s04(dai1s04);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu04(pHokenSyouken.getDai1syenyendakaumu04());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu04(pHokenSyouken.getDai1syenyenkijyunumu04());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu04(pHokenSyouken.getDai1syenyenyasuumu04());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype04(pHokenSyouken.getDai1syentuuktype04().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka04(pHokenSyouken.getDai1syenyendaka04().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun04(pHokenSyouken.getDai1syenyenkijyun04().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu04(pHokenSyouken.getDai1syenyenyasu04().toString());
        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSaihakkouHokensyoukenTy.setZtydai1zennouzndk04(dai1zennouzndk04);
            pSaihakkouHokensyoukenTy.setZtydai1zennouzndktype04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype04()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgk04(dai1sbjiuktgk04);
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgktype04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype04()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkytype04(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkydaka04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka04()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkykijyun04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun04()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkyyasu04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu04()));
        }
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd5(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd05()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype05(pHokenSyouken.getDai1stuuktype05().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s05(dai1s05);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu05(pHokenSyouken.getDai1syenyendakaumu05());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu05(pHokenSyouken.getDai1syenyenkijyunumu05());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu05(pHokenSyouken.getDai1syenyenyasuumu05());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype05(pHokenSyouken.getDai1syentuuktype05().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka05(pHokenSyouken.getDai1syenyendaka05().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun05(pHokenSyouken.getDai1syenyenkijyun05().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu05(pHokenSyouken.getDai1syenyenyasu05().toString());
        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSaihakkouHokensyoukenTy.setZtydai1zennouzndk05(dai1zennouzndk05);
            pSaihakkouHokensyoukenTy.setZtydai1zennouzndktype05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype05()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgk05(dai1sbjiuktgk05);
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgktype05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype05()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkytype05(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkydaka05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka05()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkykijyun05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun05()));
            pSaihakkouHokensyoukenTy.setZtydai1sbjiuktgkyyasu05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu05()));
        }
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd6(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd06()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype06(pHokenSyouken.getDai1stuuktype06().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s06(dai1s06);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu06(pHokenSyouken.getDai1syenyendakaumu06());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu06(pHokenSyouken.getDai1syenyenkijyunumu06());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu06(pHokenSyouken.getDai1syenyenyasuumu06());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype06(pHokenSyouken.getDai1syentuuktype06().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka06(pHokenSyouken.getDai1syenyendaka06().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun06(pHokenSyouken.getDai1syenyenkijyun06().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu06(pHokenSyouken.getDai1syenyenyasu06().toString());
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd7(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd07()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype07(pHokenSyouken.getDai1stuuktype07().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s07(dai1s07);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu07(pHokenSyouken.getDai1syenyendakaumu07());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu07(pHokenSyouken.getDai1syenyenkijyunumu07());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu07(pHokenSyouken.getDai1syenyenyasuumu07());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype07(pHokenSyouken.getDai1syentuuktype07().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka07(pHokenSyouken.getDai1syenyendaka07().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun07(pHokenSyouken.getDai1syenyenkijyun07().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu07(pHokenSyouken.getDai1syenyenyasu07().toString());
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd8(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd08()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype08(pHokenSyouken.getDai1stuuktype08().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s08(dai1s08);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu08(pHokenSyouken.getDai1syenyendakaumu08());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu08(pHokenSyouken.getDai1syenyenkijyunumu08());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu08(pHokenSyouken.getDai1syenyenyasuumu08());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype08(pHokenSyouken.getDai1syentuuktype08().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka08(pHokenSyouken.getDai1syenyendaka08().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun08(pHokenSyouken.getDai1syenyenkijyun08().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu08(pHokenSyouken.getDai1syenyenyasu08().toString());
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd9(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd09()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype09(pHokenSyouken.getDai1stuuktype09().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s09(dai1s09);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu09(pHokenSyouken.getDai1syenyendakaumu09());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu09(pHokenSyouken.getDai1syenyenkijyunumu09());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu09(pHokenSyouken.getDai1syenyenyasuumu09());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype09(pHokenSyouken.getDai1syentuuktype09().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka09(pHokenSyouken.getDai1syenyendaka09().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun09(pHokenSyouken.getDai1syenyenkijyun09().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu09(pHokenSyouken.getDai1syenyenyasu09().toString());
        pSaihakkouHokensyoukenTy.setZtydai1sibousnenoutouymd10(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getDai1sibousnenoutouymd10()));
        pSaihakkouHokensyoukenTy.setZtydai1stuuktype10(pHokenSyouken.getDai1stuuktype10().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1s10(dai1s10);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumu10(pHokenSyouken.getDai1syenyendakaumu10());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunumu10(pHokenSyouken.getDai1syenyenkijyunumu10());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumu10(pHokenSyouken.getDai1syenyenyasuumu10());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktype10(pHokenSyouken.getDai1syentuuktype10().getValue());
        pSaihakkouHokensyoukenTy.setZtydai1syenyendaka10(pHokenSyouken.getDai1syenyendaka10().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyun10(pHokenSyouken.getDai1syenyenkijyun10().toString());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasu10(pHokenSyouken.getDai1syenyenyasu10().toString());
        pSaihakkouHokensyoukenTy.setZtydai1stuuktypehuryo(String.valueOf(pHokenSyouken.getDai1stuuktypehuryo()));
        pSaihakkouHokensyoukenTy.setZtydai1shuryo(dai1shuryo);
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakaumuhuryo(pHokenSyouken.getDai1syenyendakaumuhuryo());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkjnumuhuryo(pHokenSyouken.getDai1syenyenkjnumuhuryo());
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuumuhuryo(pHokenSyouken.getDai1syenyenyasuumuhuryo());
        pSaihakkouHokensyoukenTy.setZtydai1syentuuktypehuryo(String.valueOf(pHokenSyouken.getDai1syentuuktypehuryo()));
        pSaihakkouHokensyoukenTy.setZtydai1syenyendakahuryo(String.valueOf(pHokenSyouken.getDai1syenyendakahuryo()));
        pSaihakkouHokensyoukenTy.setZtydai1syenyenkijyunhuryo(String.valueOf(pHokenSyouken.getDai1syenyenkijyunhuryo()));
        pSaihakkouHokensyoukenTy.setZtydai1syenyenyasuhuryo(String.valueOf(pHokenSyouken.getDai1syenyenyasuhuryo()));
        pSaihakkouHokensyoukenTy.setZtydai2stuuktype(pHokenSyouken.getDai2stuuktype().getValue());
        pSaihakkouHokensyoukenTy.setZtydai2s(dai2s);
        pSaihakkouHokensyoukenTy.setZtydai2syentuuktype(pHokenSyouken.getDai2syentuuktype().getValue());
        pSaihakkouHokensyoukenTy.setZtydai2syenyendaka(pHokenSyouken.getDai2syenyendaka().toString());
        pSaihakkouHokensyoukenTy.setZtydai2syenyenkijyun(pHokenSyouken.getDai2syenyenkijyun().toString());
        pSaihakkouHokensyoukenTy.setZtydai2syenyenyasu(pHokenSyouken.getDai2syenyenyasu().toString());

        pSaihakkouHokensyoukenTy.setZtydai3stuuktype(pHokenSyouken.getDai3stuuktype().getValue());
        pSaihakkouHokensyoukenTy.setZtydai3s(dai3s);
        pSaihakkouHokensyoukenTy.setZtydai3syentuuktype(pHokenSyouken.getDai3syentuuktype().getValue());
        pSaihakkouHokensyoukenTy.setZtydai3syenyendaka(pHokenSyouken.getDai3syenyendaka().toString());
        pSaihakkouHokensyoukenTy.setZtydai3syenyenkijyun(pHokenSyouken.getDai3syenyenkijyun().toString());
        pSaihakkouHokensyoukenTy.setZtydai3syenyenyasu(pHokenSyouken.getDai3syenyenyasu().toString());
        pSaihakkouHokensyoukenTy.setZtysibouinjiptnkbn(pHokenSyouken.getSibouinjiptnkbn());

        pSaihakkouHokensyoukenTy.setZtymkhyouyensysnikoumsgcd(pHokenSyouken.getMkhyouyensysnikoumsgcd());
        pSaihakkouHokensyoukenTy.setZtymkhyouyensysnikoumsgcd2(pHokenSyouken.getMkhyouyensysnikoumsgcd2());
        pSaihakkouHokensyoukenTy.setZtymkhyouyensysnikoumsgcd3(pHokenSyouken.getMkhyouyensysnikoumsgcd3());

        pSaihakkouHokensyoukenTy.setZtymkhyouyensysnikougktype(String.valueOf(pHokenSyouken.getMkhyouyensysnikougktype()));
        pSaihakkouHokensyoukenTy.setZtymkhyouyensysnikougk(String.valueOf(pHokenSyouken.getMkhyouyensysnikougk()));
        pSaihakkouHokensyoukenTy.setZtymkhyouyensysnikouwra(String.valueOf(pHokenSyouken.getMkhyouyensysnikouwra()));
        pSaihakkouHokensyoukenTy.setZtymkhyouysysnikcurrentgk(mkhyouysysnikcurrentgk);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrtkykmsgcd1(pHokenSyouken.getKaigomaehrtkykmsgcd1());
        pSaihakkouHokensyoukenTy.setZtykaigomaehrtkykmsgcd2(pHokenSyouken.getKaigomaehrtkykmsgcd2());
        pSaihakkouHokensyoukenTy.setZtykaigomaehrtkykmsgcdst1(pHokenSyouken.getKaigomaehrtkykmsgcdst1());
        pSaihakkouHokensyoukenTy.setZtykaigomaehrtkykmsgcdst2(pHokenSyouken.getKaigomaehrtkykmsgcdst2());
        pSaihakkouHokensyoukenTy.setZtykgmaehrtkhknkkn1mnryymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
            pHokenSyouken.getKgmaehrtkdai1hknkknmnryymd()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrtkykitrnumu(pHokenSyouken.getKaigomaehruktgkumu());

        pSaihakkouHokensyoukenTy.setZtykaigomaehrtkykkyktuuka(pHokenSyouken.getKaigomaehrtkykkyktuuka());
        pSaihakkouHokensyoukenTy.setZtykaigomaehrtkykstdmsgcd(pHokenSyouken.getKaigomaehrtkykstdmsgcd());
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugktype(String.valueOf(pHokenSyouken.getKaigomaehrjrugktype()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen01(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen01()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn01(kaigomaehrstikkn01);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk01(kaigomaehrjrugk01);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen02(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen02()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn02(kaigomaehrstikkn02);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk02(kaigomaehrjrugk02);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen03(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen03()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn03(kaigomaehrstikkn03);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk03(kaigomaehrjrugk03);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen04(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen04()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn04(kaigomaehrstikkn04);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk04(kaigomaehrjrugk04);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen05(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen05()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn05(kaigomaehrstikkn05);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk05(kaigomaehrjrugk05);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen06(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen06()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn06(kaigomaehrstikkn06);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk06(kaigomaehrjrugk06);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen07(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen07()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn07(kaigomaehrstikkn07);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk07(kaigomaehrjrugk07);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen08(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen08()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn08(kaigomaehrstikkn08);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk08(kaigomaehrjrugk08);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen09(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen09()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn09(kaigomaehrstikkn09);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk09(kaigomaehrjrugk09);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrsikuhhknnen10(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen10()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrstikkn10(kaigomaehrstikkn10);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugk10(kaigomaehrjrugk10);
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka01(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka01()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka02(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka02()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka03(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka03()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka04(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka04()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka05(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka05()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka06(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka06()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka07(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka07()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka08(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka08()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka09(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka09()));
        pSaihakkouHokensyoukenTy.setZtykaigomaehrjrugkydaka10(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka10()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun01(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun01()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun02(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun02()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun03(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun03()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun04(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun04()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun05(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun05()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun06(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun06()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun07(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun07()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun08(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun08()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun09(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun09()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkykijyun10(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun10()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu01(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu01()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu02(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu02()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu03(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu03()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu04(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu04()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu05(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu05()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu06(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu06()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu07(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu07()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu08(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu08()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu09(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu09()));
        pSaihakkouHokensyoukenTy.setZtykgmaehrjrugkyyasu10(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu10()));
        pSaihakkouHokensyoukenTy.setZtynkmsgcd1(pHokenSyouken.getNkmsgcd1());
        pSaihakkouHokensyoukenTy.setZtynkmsgcd2(pHokenSyouken.getNkmsgcd2());
        pSaihakkouHokensyoukenTy.setZtynkmsgcd3(pHokenSyouken.getNkmsgcd3());
        pSaihakkouHokensyoukenTy.setZtynkmsgcd4(pHokenSyouken.getNkmsgcd4());
        pSaihakkouHokensyoukenTy.setZtynkmsgcd5(pHokenSyouken.getNkmsgcd5());
        pSaihakkouHokensyoukenTy.setZtynkmsgcd6(pHokenSyouken.getNkmsgcd6());
        pSaihakkouHokensyoukenTy.setZtynkmsgcd7(pHokenSyouken.getNkmsgcd7());
        pSaihakkouHokensyoukenTy.setZtynkmsgcd8(pHokenSyouken.getNkmsgcd8());
        pSaihakkouHokensyoukenTy.setZtynkmsgcd9(pHokenSyouken.getNkmsgcd9());
        pSaihakkouHokensyoukenTy.setZtynkmsgcd10(pHokenSyouken.getNkmsgcd10());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd1(pHokenSyouken.getSiboukyuuhukinmsgcd1());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd2(pHokenSyouken.getSiboukyuuhukinmsgcd2());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd3(pHokenSyouken.getSiboukyuuhukinmsgcd3());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd4(pHokenSyouken.getSiboukyuuhukinmsgcd4());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd5(pHokenSyouken.getSiboukyuuhukinmsgcd5());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd6(pHokenSyouken.getSiboukyuuhukinmsgcd6());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd7(pHokenSyouken.getSiboukyuuhukinmsgcd7());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd8(pHokenSyouken.getSiboukyuuhukinmsgcd8());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd9(pHokenSyouken.getSiboukyuuhukinmsgcd9());
        pSaihakkouHokensyoukenTy.setZtysiboukyuuhukinmsgcd10(pHokenSyouken.getSiboukyuuhukinmsgcd10());

        if (BizUtil.isBlank(pHokenSyouken.getNkshrstartzenymd())) {
            pSaihakkouHokensyoukenTy.setZtynkshrstartzenymd("");
        }
        else {
            pSaihakkouHokensyoukenTy.setZtynkshrstartzenymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(
                BizDate.valueOf(pHokenSyouken.getNkshrstartzenymd())));
        }

        pSaihakkouHokensyoukenTy.setZtymkhyouyennkhknhentktype(pHokenSyouken.getMkhyouyennkhknhentktype());
        pSaihakkouHokensyoukenTy.setZtymkhyouyennkhknhentkmkhgk(String.valueOf(pHokenSyouken.getMkhyouyennkhknhentkmkhgk()));
        pSaihakkouHokensyoukenTy.setZtymkhyennkhknhentkmkhwari(String.valueOf(pHokenSyouken.getMkhyouyennkhknhentkmkhwari()));
        pSaihakkouHokensyoukenTy.setZtyhaibunwarimsgcd1(pHokenSyouken.getHaibunwarimsgcd1());
        pSaihakkouHokensyoukenTy.setZtyhaibunwarimsgcd2(pHokenSyouken.getHaibunwarimsgcd2());
        pSaihakkouHokensyoukenTy.setZtyhaibunwarimsgcd3(pHokenSyouken.getHaibunwarimsgcd3());
        pSaihakkouHokensyoukenTy.setZtyteiritutmtthbnwr(String.valueOf(pHokenSyouken.getTeiritutmtthbnwr()));
        pSaihakkouHokensyoukenTy.setZtysisuutmtthbnwr(String.valueOf(pHokenSyouken.getSisuutmtthbnwr()));
        pSaihakkouHokensyoukenTy.setZtysisuuannaimsg1(pHokenSyouken.getSisuuannaimsg1());
        pSaihakkouHokensyoukenTy.setZtysisuuannaimsg2(pHokenSyouken.getSisuuannaimsg2());
        pSaihakkouHokensyoukenTy.setZtysisuuannaimsg3(pHokenSyouken.getSisuuannaimsg3());

        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSaihakkouHokensyoukenTy.setZtykzktourokuservicemsg1(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg1());
            pSaihakkouHokensyoukenTy.setZtykzktourokuservicemsg2(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg2());
            pSaihakkouHokensyoukenTy.setZtykzktourokuservicemsg3(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg3());
            pSaihakkouHokensyoukenTy.setZtykzktourokuservicemsg4(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg4());
            pSaihakkouHokensyoukenTy.setZtykzktourokuservicemsg5(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg5());
            pSaihakkouHokensyoukenTy.setZtykzktourokuservicemsg6(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg6());
            pSaihakkouHokensyoukenTy.setZtykzktourokuservicemsg7(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg7());
            pSaihakkouHokensyoukenTy.setZtykzktourokuservicemsg8(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg8());
            pSaihakkouHokensyoukenTy.setZtytrkkzknm118(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzknmkj118());
            pSaihakkouHokensyoukenTy.setZtytrkkzksei1(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzksei1().getValue());
            pSaihakkouHokensyoukenTy.setZtytrkkzkseiymd1zenkaku(
                FixedDateFormatter.formatYMDZenkakuWarekiKanji(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkseiymd1()));
            pSaihakkouHokensyoukenTy.setZtytrkkzkyno1zenkaku(
                ConvertUtil.toZenAll(BizUtil.editYno(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkyno1()),0 ,1));
            pSaihakkouHokensyoukenTy.setZtytrkkzkadrkj1(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr1kj1() +
                pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr2kj1() +
                pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr3kj1());
            if (BizUtil.isBlank(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno1())) {

                pSaihakkouHokensyoukenTy.setZtytrkkzktelno1zenkaku(TEL_MITOUROKU);
            }
            else {

                pSaihakkouHokensyoukenTy.setZtytrkkzktelno1zenkaku(
                    ConvertUtil.toZenAll(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno1(), 0, 1));
            }
            pSaihakkouHokensyoukenTy.setZtytrkkzknm218(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzknmkj218());
            pSaihakkouHokensyoukenTy.setZtytrkkzksei2(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzksei2().getValue());
            pSaihakkouHokensyoukenTy.setZtytrkkzkseiymd2zenkaku(
                FixedDateFormatter.formatYMDZenkakuWarekiKanji(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkseiymd2()));
            pSaihakkouHokensyoukenTy.setZtytrkkzkyno2zenkaku(
                ConvertUtil.toZenAll(BizUtil.editYno(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkyno2()),0 ,1));
            pSaihakkouHokensyoukenTy.setZtytrkkzkadrkj2(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr1kj2() +
                pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr2kj2() +
                pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr3kj2());
            if (BizUtil.isBlank(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno2())) {

                pSaihakkouHokensyoukenTy.setZtytrkkzktelno2zenkaku(TEL_MITOUROKU);
            }
            else {

                pSaihakkouHokensyoukenTy.setZtytrkkzktelno2zenkaku(
                    ConvertUtil.toZenAll(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno2(), 0, 1));
            }
            pSaihakkouHokensyoukenTy.setZtykykdairinm18(pHokenSyouken.getHokenSyoukenHukaInfo().getKykdairinm18());
            pSaihakkouHokensyoukenTy.setZtyhhkndairinm(pHokenSyouken.getHokenSyoukenHukaInfo().getHhkndairinm());
        }

        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmmsgcdue01(pHokenSyouken.getHutanhiyustmmsgcdue01());
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmmsgcdue02(pHokenSyouken.getHutanhiyustmmsgcdue02());
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmmsgcdue03(pHokenSyouken.getHutanhiyustmmsgcdue03());
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmmsgcdue04(pHokenSyouken.getHutanhiyustmmsgcdue04());
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmknsnhyuptn(pHokenSyouken.getHutanhiyustmknsnhyuptn());
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmmsgcdst01(pHokenSyouken.getHutanhiyustmmsgcdst01());
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmmsgcdst02(pHokenSyouken.getHutanhiyustmmsgcdst02());
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmmsgcdst03(pHokenSyouken.getHutanhiyustmmsgcdst03());
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmytijihiritu(hutanhiyustmytijihiritu);
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmkyakkjrtmin("　" +  ConvertUtil.toZenAll(BizUtil.zeroNum(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin().multiply(100)), 1, 1), 0, 0) + KBPERCENT);
        pSaihakkouHokensyoukenTy.setZtyhutanhiyustmkyakkjrtmax(ConvertUtil.toZenAll(BizUtil.zeroNum(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax().multiply(100)), 2, 1), 0, 0));
        pSaihakkouHokensyoukenTy.setZtystdstmmsgcd(pHokenSyouken.getStdstmmsgcd());
        pSaihakkouHokensyoukenTy.setZtysioriwebuktriannaimsgcd(pHokenSyouken.getSioriwebuktriannaimsgcd());

        BizPropertyInitializer.initialize(pSaihakkouHokensyoukenTy);
    }

    private void editSaihakkouHokensyoukenSuiiTy(
        IT_HokenSyouken pHokenSyouken,
        IT_Suiihyou pSuiihyou,
        ZT_SaihakkouSyoukenSuiiTy pSaihakkouHokensyoukenSuiiTy) {

        pSaihakkouHokensyoukenSuiiTy.setZtysyono(pHokenSyouken.getSyono());
        pSaihakkouHokensyoukenSuiiTy.setZtytyouhyouymd(String.valueOf(pHokenSyouken.getTyouhyouymd()));
        pSaihakkouHokensyoukenSuiiTy.setZtysuiihyouptn(String.valueOf(suiihyouPattern1));
        pSaihakkouHokensyoukenSuiiTy.setZtysuiihyousyono(pHokenSyouken.getSyono());
        pSaihakkouHokensyoukenSuiiTy.setZtysisuuupritu(sisuuuprituPattern1);
        pSaihakkouHokensyoukenSuiiTy.setZtysjkkktusirrtup(sjkkktusirrtup);
        pSaihakkouHokensyoukenSuiiTy.setZtysjkkktusirrtsame(sjkkktusirrtsame);
        pSaihakkouHokensyoukenSuiiTy.setZtysjkkktusirrtdown(sjkkktusirrtdown);
        pSaihakkouHokensyoukenSuiiTy.setZtysjkkktusirrthendouup(sjkkktusirrthendouup);
        pSaihakkouHokensyoukenSuiiTy.setZtysjkkktusirrthendoudown(sjkkktusirrthendoudown);
        pSaihakkouHokensyoukenSuiiTy.setZtywkwsrateyendaka(yenKnsnKwsRateYenDaka);
        pSaihakkouHokensyoukenSuiiTy.setZtywkwsrateyenkijyun(yenKnsnKwsRateYenKijyun);
        pSaihakkouHokensyoukenSuiiTy.setZtywkwsrateyenyasu(yenKnsnKwsRateYenYasu);
        pSaihakkouHokensyoukenSuiiTy.setZtysuiihyoumkhyouyenwra(String.valueOf(pHokenSyouken.getMkhyouyensysnikouwra()));
        if (pSuiihyou != null) {
            pSaihakkouHokensyoukenSuiiTy.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        }

        editSaihakkouHokensyoukenSuiiTy2(pSaihakkouHokensyoukenSuiiTy);

        editSaihakkouHokensyoukenSuiiTy3(pHokenSyouken, pSaihakkouHokensyoukenSuiiTy);

        BizPropertyInitializer.initialize(pSaihakkouHokensyoukenSuiiTy);
    }

    private void editSaihakkouHokensyoukenSuiiTyPattern2(
        IT_HokenSyouken pHokenSyouken,
        IT_Suiihyou pSuiihyou,
        ZT_SaihakkouSyoukenSuiiTy pSaihakkouSyoukenSuiiTy) {

        pSaihakkouSyoukenSuiiTy.setZtysyono(pHokenSyouken.getSyono());
        pSaihakkouSyoukenSuiiTy.setZtytyouhyouymd(String.valueOf(pHokenSyouken.getTyouhyouymd()));
        pSaihakkouSyoukenSuiiTy.setZtysuiihyouptn(String.valueOf(suiihyouPattern2));
        pSaihakkouSyoukenSuiiTy.setZtysuiihyousyono(pHokenSyouken.getSyono());
        pSaihakkouSyoukenSuiiTy.setZtysisuuupritu(sisuuuprituPattern2);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrtup(sjkkktusirrtup2);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrtsame(sjkkktusirrtsame2);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrtdown(sjkkktusirrtdown2);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrthendouup(sjkkktusirrthendouup2);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrthendoudown(sjkkktusirrthendoudown2);
        pSaihakkouSyoukenSuiiTy.setZtywkwsrateyendaka(yenKnsnKwsRateYenDaka2);
        pSaihakkouSyoukenSuiiTy.setZtywkwsrateyenkijyun(yenKnsnKwsRateYenKijyun2);
        pSaihakkouSyoukenSuiiTy.setZtywkwsrateyenyasu(yenKnsnKwsRateYenYasu2);
        pSaihakkouSyoukenSuiiTy.setZtysuiihyoumkhyouyenwra(String.valueOf(pHokenSyouken.getMkhyouyensysnikouwra()));
        if (pSuiihyou != null) {
            pSaihakkouSyoukenSuiiTy.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        }
        editSaihakkouHokensyoukenSuiiTyPattern2_2(pSaihakkouSyoukenSuiiTy);
        editSaihakkouHokensyoukenSuiiTyPattern2_3(pHokenSyouken,pSaihakkouSyoukenSuiiTy);

        BizPropertyInitializer.initialize(pSaihakkouSyoukenSuiiTy);
    }

    private void editSaihakkouHokensyoukenSuiiTyPattern3(
        IT_HokenSyouken pHokenSyouken,
        IT_Suiihyou pSuiihyou,
        ZT_SaihakkouSyoukenSuiiTy pSaihakkouSyoukenSuiiTy) {

        pSaihakkouSyoukenSuiiTy.setZtysyono(pHokenSyouken.getSyono());
        pSaihakkouSyoukenSuiiTy.setZtytyouhyouymd(String.valueOf(pHokenSyouken.getTyouhyouymd()));
        pSaihakkouSyoukenSuiiTy.setZtysuiihyouptn(String.valueOf(suiihyouPattern3));
        pSaihakkouSyoukenSuiiTy.setZtysuiihyousyono(pHokenSyouken.getSyono());
        pSaihakkouSyoukenSuiiTy.setZtysisuuupritu(sisuuuprituPattern3);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrtup(sjkkktusirrtup3);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrtsame(sjkkktusirrtsame3);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrtdown(sjkkktusirrtdown3);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrthendouup(sjkkktusirrthendouup3);
        pSaihakkouSyoukenSuiiTy.setZtysjkkktusirrthendoudown(sjkkktusirrthendoudown3);
        pSaihakkouSyoukenSuiiTy.setZtywkwsrateyendaka(yenKnsnKwsRateYenDaka3);
        pSaihakkouSyoukenSuiiTy.setZtywkwsrateyenkijyun(yenKnsnKwsRateYenKijyun3);
        pSaihakkouSyoukenSuiiTy.setZtywkwsrateyenyasu(yenKnsnKwsRateYenYasu3);
        pSaihakkouSyoukenSuiiTy.setZtysuiihyoumkhyouyenwra(String.valueOf(pHokenSyouken.getMkhyouyensysnikouwra()));
        if (pSuiihyou != null) {
            pSaihakkouSyoukenSuiiTy.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        }
        editSaihakkouHokensyoukenSuiiTyPattern3_2(pSaihakkouSyoukenSuiiTy);
        editSaihakkouHokensyoukenSuiiTyPattern3_3(pHokenSyouken,pSaihakkouSyoukenSuiiTy);

        BizPropertyInitializer.initialize(pSaihakkouSyoukenSuiiTy);
    }

    private void editSaihakkouHokensyoukenSuiiTy2(
        ZT_SaihakkouSyoukenSuiiTy pSaihakkouHokensyoukenSuiiTy) {
        if (!BizUtil.isBlank(mvaAriNenOuTouYm[0])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym01(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[0] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu01(sisuuupritu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu01(tmttknzoukaritu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup01(mvaAriWTukTypeUp[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup01(mvaaritmttkgkkykkjmaeup[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup01(mvaAriWUp[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup01(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka01(mvaAriWUpYenDaka[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun01(mvaAriWUpYenKijyun[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu01(mvaAriWUpYenYasu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka01(mvaariwumupyendaka[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun01(mvaariumupyenkijyun[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu01(mvaariumupyenyasu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame01(mvaAriWTukTypeSame[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame01(mvaaritmttkgkkykkjmaesame[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame01(mvaAriWSame[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame01(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka01(mvaAriWSameYenDaka[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun01(mvaAriWSameYenKijyun[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu01(mvaAriWSameYenYasu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka01(mvaariumsameyendaka[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun01(mvaariumsameyenkijyun[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu01(mvaariumsameyenyasu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown01(mvaAriWTukTypeDown[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown01(mvaaritmttkgkkykkjmaedown[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown01(mvaAriWDown[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown01(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka01(mvaAriWDownYenDaka[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun01(mvaAriWDownYenKijyun[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu01(mvaAriWDownYenYasu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka01(mvaariumdownyendaka[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun01(mvaariumdownyenkijyun[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu01(mvaariumdownyenyasu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype01(mvaAriVTukType[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv01(mvaAriV[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake101(tutmttknutiwake1[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake201(tutmttknutiwake2[0]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[1])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym02(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[1] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu02(sisuuupritu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu02(tmttknzoukaritu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup02(mvaAriWTukTypeUp[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup02(mvaaritmttkgkkykkjmaeup[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup02(mvaAriWUp[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup02(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka02(mvaAriWUpYenDaka[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun02(mvaAriWUpYenKijyun[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu02(mvaAriWUpYenYasu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka02(mvaariwumupyendaka[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun02(mvaariumupyenkijyun[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu02(mvaariumupyenyasu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame02(mvaAriWTukTypeSame[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame02(mvaaritmttkgkkykkjmaesame[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame02(mvaAriWSame[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame02(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka02(mvaAriWSameYenDaka[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun02(mvaAriWSameYenKijyun[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu02(mvaAriWSameYenYasu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka02(mvaariumsameyendaka[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun02(mvaariumsameyenkijyun[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu02(mvaariumsameyenyasu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown02(mvaAriWTukTypeDown[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown02(mvaaritmttkgkkykkjmaedown[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown02(mvaAriWDown[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown02(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka02(mvaAriWDownYenDaka[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun02(mvaAriWDownYenKijyun[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu02(mvaAriWDownYenYasu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka02(mvaariumdownyendaka[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun02(mvaariumdownyenkijyun[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu02(mvaariumdownyenyasu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype02(mvaAriVTukType[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv02(mvaAriV[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake102(tutmttknutiwake1[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake202(tutmttknutiwake2[1]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[2])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym03(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[2] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu03(sisuuupritu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu03(tmttknzoukaritu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup03(mvaAriWTukTypeUp[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup03(mvaaritmttkgkkykkjmaeup[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup03(mvaAriWUp[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup03(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka03(mvaAriWUpYenDaka[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun03(mvaAriWUpYenKijyun[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu03(mvaariumupyenyasu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka03(mvaariwumupyendaka[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun03(mvaariumupyenkijyun[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu03(mvaAriWUpYenYasu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame03(mvaAriWTukTypeSame[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame03(mvaaritmttkgkkykkjmaesame[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame03(mvaAriWSame[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame03(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka03(mvaAriWSameYenDaka[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun03(mvaAriWSameYenKijyun[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu03(mvaAriWSameYenYasu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka03(mvaariumsameyendaka[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun03(mvaariumsameyenkijyun[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu03(mvaariumsameyenyasu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown03(mvaAriWTukTypeDown[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown03(mvaaritmttkgkkykkjmaedown[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown03(mvaAriWDown[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown03(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka03(mvaAriWDownYenDaka[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun03(mvaAriWDownYenKijyun[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu03(mvaAriWDownYenYasu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka03(mvaariumdownyendaka[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun03(mvaariumdownyenkijyun[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu03(mvaariumdownyenyasu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype03(mvaAriVTukType[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv03(mvaAriV[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake103(tutmttknutiwake1[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake203(tutmttknutiwake2[2]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[3])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym04(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[3] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu04(sisuuupritu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu04(tmttknzoukaritu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup04(mvaAriWTukTypeUp[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup04(mvaaritmttkgkkykkjmaeup[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup04(mvaAriWUp[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup04(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka04(mvaAriWUpYenDaka[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun04(mvaAriWUpYenKijyun[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu04(mvaariumupyenyasu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka04(mvaariwumupyendaka[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun04(mvaariumupyenkijyun[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu04(mvaAriWUpYenYasu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame04(mvaAriWTukTypeSame[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame04(mvaaritmttkgkkykkjmaesame[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame04(mvaAriWSame[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame04(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka04(mvaAriWSameYenDaka[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun04(mvaAriWSameYenKijyun[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu04(mvaAriWSameYenYasu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka04(mvaariumsameyendaka[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun04(mvaariumsameyenkijyun[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu04(mvaariumsameyenyasu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown04(mvaAriWTukTypeDown[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown04(mvaaritmttkgkkykkjmaedown[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown04(mvaAriWDown[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown04(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka04(mvaAriWDownYenDaka[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun04(mvaAriWDownYenKijyun[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu04(mvaAriWDownYenYasu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka04(mvaariumdownyendaka[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun04(mvaariumdownyenkijyun[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu04(mvaariumdownyenyasu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype04(mvaAriVTukType[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv04(mvaAriV[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake104(tutmttknutiwake1[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake204(tutmttknutiwake2[3]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[4])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym05(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[4] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu05(sisuuupritu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu05(tmttknzoukaritu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup05(mvaAriWTukTypeUp[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup05(mvaaritmttkgkkykkjmaeup[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup05(mvaAriWUp[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup05(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka05(mvaAriWUpYenDaka[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun05(mvaAriWUpYenKijyun[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu05(mvaariumupyenyasu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka05(mvaariwumupyendaka[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun05(mvaariumupyenkijyun[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu05(mvaAriWUpYenYasu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame05(mvaAriWTukTypeSame[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame05(mvaaritmttkgkkykkjmaesame[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame05(mvaAriWSame[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame05(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka05(mvaAriWSameYenDaka[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun05(mvaAriWSameYenKijyun[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka05(mvaariumsameyendaka[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun05(mvaariumsameyenkijyun[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu05(mvaariumsameyenyasu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu05(mvaAriWSameYenYasu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown05(mvaAriWTukTypeDown[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown05(mvaaritmttkgkkykkjmaedown[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown05(mvaAriWDown[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown05(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka05(mvaAriWDownYenDaka[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun05(mvaAriWDownYenKijyun[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka05(mvaariumdownyendaka[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun05(mvaariumdownyenkijyun[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu05(mvaariumdownyenyasu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu05(mvaAriWDownYenYasu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype05(mvaAriVTukType[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv05(mvaAriV[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake105(tutmttknutiwake1[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake205(tutmttknutiwake2[4]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[5])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym06(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[5] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu06(sisuuupritu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu06(tmttknzoukaritu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup06(mvaAriWTukTypeUp[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup06(mvaaritmttkgkkykkjmaeup[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup06(mvaAriWUp[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup06(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka06(mvaAriWUpYenDaka[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun06(mvaAriWUpYenKijyun[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu06(mvaAriWUpYenYasu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka06(mvaariwumupyendaka[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun06(mvaariumupyenkijyun[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu06(mvaariumupyenyasu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame06(mvaAriWTukTypeSame[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame06(mvaaritmttkgkkykkjmaesame[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame06(mvaAriWSame[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame06(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka06(mvaAriWSameYenDaka[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun06(mvaAriWSameYenKijyun[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu06(mvaAriWSameYenYasu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka06(mvaariumsameyendaka[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun06(mvaariumsameyenkijyun[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu06(mvaariumsameyenyasu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown06(mvaAriWTukTypeDown[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown06(mvaaritmttkgkkykkjmaedown[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown06(mvaAriWDown[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown06(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka06(mvaAriWDownYenDaka[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun06(mvaAriWDownYenKijyun[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu06(mvaAriWDownYenYasu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka06(mvaariumdownyendaka[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun06(mvaariumdownyenkijyun[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu06(mvaariumdownyenyasu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype06(mvaAriVTukType[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv06(mvaAriV[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake106(tutmttknutiwake1[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake206(tutmttknutiwake2[5]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[6])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym07(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[6] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu07(sisuuupritu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu07(tmttknzoukaritu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup07(mvaAriWTukTypeUp[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup07(mvaaritmttkgkkykkjmaeup[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup07(mvaAriWUp[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup07(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka07(mvaAriWUpYenDaka[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun07(mvaAriWUpYenKijyun[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu07(mvaAriWUpYenYasu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka07(mvaariwumupyendaka[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun07(mvaariumupyenkijyun[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu07(mvaariumupyenyasu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame07(mvaAriWTukTypeSame[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame07(mvaaritmttkgkkykkjmaesame[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame07(mvaAriWSame[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame07(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka07(mvaAriWSameYenDaka[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun07(mvaAriWSameYenKijyun[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu07(mvaAriWSameYenYasu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka07(mvaariumsameyendaka[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun07(mvaariumsameyenkijyun[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu07(mvaariumsameyenyasu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown07(mvaAriWTukTypeDown[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown07(mvaaritmttkgkkykkjmaedown[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown07(mvaAriWDown[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown07(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka07(mvaAriWDownYenDaka[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun07(mvaAriWDownYenKijyun[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu07(mvaAriWDownYenYasu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka07(mvaariumdownyendaka[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun07(mvaariumdownyenkijyun[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu07(mvaariumdownyenyasu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype07(mvaAriVTukType[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv07(mvaAriV[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake107(tutmttknutiwake1[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake207(tutmttknutiwake2[6]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[7])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym08(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[7] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu08(sisuuupritu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu08(tmttknzoukaritu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup08(mvaAriWTukTypeUp[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup08(mvaaritmttkgkkykkjmaeup[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup08(mvaAriWUp[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup08(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka08(mvaAriWUpYenDaka[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun08(mvaAriWUpYenKijyun[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu08(mvaAriWUpYenYasu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka08(mvaariwumupyendaka[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun08(mvaariumupyenkijyun[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu08(mvaariumupyenyasu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame08(mvaAriWTukTypeSame[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame08(mvaaritmttkgkkykkjmaesame[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame08(mvaAriWSame[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame08(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka08(mvaAriWSameYenDaka[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun08(mvaAriWSameYenKijyun[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu08(mvaAriWSameYenYasu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka08(mvaariumsameyendaka[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun08(mvaariumsameyenkijyun[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu08(mvaariumsameyenyasu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown08(mvaAriWTukTypeDown[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown08(mvaaritmttkgkkykkjmaedown[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown08(mvaAriWDown[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown08(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka08(mvaAriWDownYenDaka[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun08(mvaAriWDownYenKijyun[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu08(mvaAriWDownYenYasu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka08(mvaariumdownyendaka[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun08(mvaariumdownyenkijyun[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu08(mvaariumdownyenyasu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype08(mvaAriVTukType[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv08(mvaAriV[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake108(tutmttknutiwake1[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake208(tutmttknutiwake2[7]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[8])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym09(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[8] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu09(sisuuupritu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu09(tmttknzoukaritu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup09(mvaAriWTukTypeUp[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup09(mvaaritmttkgkkykkjmaeup[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup09(mvaAriWUp[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup09(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka09(mvaAriWUpYenDaka[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun09(mvaAriWUpYenKijyun[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka09(mvaariwumupyendaka[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun09(mvaariumupyenkijyun[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu09(mvaariumupyenyasu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu09(mvaAriWUpYenYasu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame09(mvaAriWTukTypeSame[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame09(mvaaritmttkgkkykkjmaesame[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame09(mvaAriWSame[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame09(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka09(mvaAriWSameYenDaka[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun09(mvaAriWSameYenKijyun[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu09(mvaAriWSameYenYasu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka09(mvaariumsameyendaka[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun09(mvaariumsameyenkijyun[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu09(mvaariumsameyenyasu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown09(mvaAriWTukTypeDown[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown09(mvaaritmttkgkkykkjmaedown[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown09(mvaAriWDown[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown09(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka09(mvaAriWDownYenDaka[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun09(mvaAriWDownYenKijyun[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu09(mvaAriWDownYenYasu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka09(mvaariumdownyendaka[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun09(mvaariumdownyenkijyun[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu09(mvaariumdownyenyasu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype09(mvaAriVTukType[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv09(mvaAriV[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake109(tutmttknutiwake1[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake209(tutmttknutiwake2[8]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[9])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym10(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[9] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarisisuuupritu10(sisuuupritu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknzkritu10(tmttknzoukaritu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup10(mvaAriWTukTypeUp[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmup10(mvaaritmttkgkkykkjmaeup[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup10(mvaAriWUp[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup10(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka10(mvaAriWUpYenDaka[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun10(mvaAriWUpYenKijyun[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu10(mvaAriWUpYenYasu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka10(mvaariwumupyendaka[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun10(mvaariumupyenkijyun[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu10(mvaariumupyenyasu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame10(mvaAriWTukTypeSame[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmsame10(mvaaritmttkgkkykkjmaesame[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame10(mvaAriWSame[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame10(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka10(mvaAriWSameYenDaka[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun10(mvaAriWSameYenKijyun[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu10(mvaAriWSameYenYasu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka10(mvaariumsameyendaka[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun10(mvaariumsameyenkijyun[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu10(mvaariumsameyenyasu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown10(mvaAriWTukTypeDown[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaaritmttknkykkjmdown10(mvaaritmttkgkkykkjmaedown[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown10(mvaAriWDown[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown10(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka10(mvaAriWDownYenDaka[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun10(mvaAriWDownYenKijyun[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu10(mvaAriWDownYenYasu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka10(mvaariumdownyendaka[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun10(mvaariumdownyenkijyun[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu10(mvaariumdownyenyasu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype10(mvaAriVTukType[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv10(mvaAriV[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake110(tutmttknutiwake1[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtyptmttkngkutiwake210(tutmttknutiwake2[9]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[10])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym11(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[10] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup11(mvaAriWTukTypeUp[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup11(mvaAriWUp[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup11(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka11(mvaAriWUpYenDaka[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun11(mvaAriWUpYenKijyun[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu11(mvaAriWUpYenYasu[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka11(mvaariwumupyendaka[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun11(mvaariumupyenkijyun[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu11(mvaariumupyenyasu[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame11(mvaAriWTukTypeSame[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame11(mvaAriWSame[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame11(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka11(mvaAriWSameYenDaka[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun11(mvaAriWSameYenKijyun[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu11(mvaAriWSameYenYasu[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka11(mvaariumsameyendaka[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun11(mvaariumsameyenkijyun[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu11(mvaariumsameyenyasu[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown11(mvaAriWTukTypeDown[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown11(mvaAriWDown[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown11(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka11(mvaAriWDownYenDaka[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun11(mvaAriWDownYenKijyun[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu11(mvaAriWDownYenYasu[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka11(mvaariumdownyendaka[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun11(mvaariumdownyenkijyun[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu11(mvaariumdownyenyasu[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype11(mvaAriVTukType[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv11(mvaAriV[10]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[11])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym12(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[11] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup12(mvaAriWTukTypeUp[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup12(mvaAriWUp[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup12(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka12(mvaAriWUpYenDaka[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun12(mvaAriWUpYenKijyun[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu12(mvaAriWUpYenYasu[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka12(mvaariwumupyendaka[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun12(mvaariumupyenkijyun[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu12(mvaariumupyenyasu[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame12(mvaAriWTukTypeSame[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame12(mvaAriWSame[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame12(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka12(mvaAriWSameYenDaka[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun12(mvaAriWSameYenKijyun[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu12(mvaAriWSameYenYasu[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka12(mvaariumsameyendaka[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun12(mvaariumsameyenkijyun[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu12(mvaariumsameyenyasu[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown12(mvaAriWTukTypeDown[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown12(mvaAriWDown[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown12(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka12(mvaAriWDownYenDaka[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun12(mvaAriWDownYenKijyun[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu12(mvaAriWDownYenYasu[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka12(mvaariumdownyendaka[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun12(mvaariumdownyenkijyun[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu12(mvaariumdownyenyasu[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype12(mvaAriVTukType[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv12(mvaAriV[11]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[12])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym13(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[12] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup13(mvaAriWTukTypeUp[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup13(mvaAriWUp[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup13(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka13(mvaAriWUpYenDaka[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun13(mvaAriWUpYenKijyun[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu13(mvaAriWUpYenYasu[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka13(mvaariwumupyendaka[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun13(mvaariumupyenkijyun[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu13(mvaariumupyenyasu[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame13(mvaAriWTukTypeSame[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame13(mvaAriWSame[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame13(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka13(mvaAriWSameYenDaka[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun13(mvaAriWSameYenKijyun[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu13(mvaAriWSameYenYasu[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka13(mvaariumsameyendaka[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun13(mvaariumsameyenkijyun[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu13(mvaariumsameyenyasu[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown13(mvaAriWTukTypeDown[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown13(mvaAriWDown[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown13(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka13(mvaAriWDownYenDaka[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun13(mvaAriWDownYenKijyun[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu13(mvaAriWDownYenYasu[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka13(mvaariumdownyendaka[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun13(mvaariumdownyenkijyun[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu13(mvaariumdownyenyasu[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype13(mvaAriVTukType[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv13(mvaAriV[12]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[13])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym14(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[13] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup14(mvaAriWTukTypeUp[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup14(mvaAriWUp[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup14(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka14(mvaAriWUpYenDaka[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun14(mvaAriWUpYenKijyun[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu14(mvaAriWUpYenYasu[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka14(mvaariwumupyendaka[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun14(mvaariumupyenkijyun[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu14(mvaariumupyenyasu[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame14(mvaAriWTukTypeSame[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame14(mvaAriWSame[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame14(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka14(mvaAriWSameYenDaka[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun14(mvaAriWSameYenKijyun[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu14(mvaAriWSameYenYasu[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka14(mvaariumsameyendaka[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun14(mvaariumsameyenkijyun[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu14(mvaariumsameyenyasu[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown14(mvaAriWTukTypeDown[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown14(mvaAriWDown[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown14(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka14(mvaAriWDownYenDaka[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun14(mvaAriWDownYenKijyun[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu14(mvaAriWDownYenYasu[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka14(mvaariumdownyendaka[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun14(mvaariumdownyenkijyun[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu14(mvaariumdownyenyasu[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype14(mvaAriVTukType[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv14(mvaAriV[13]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[14])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarinenoutouym15(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[14] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypeup15(mvaAriWTukTypeUp[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwup15(mvaAriWUp[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypeup15(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyendaka15(mvaAriWUpYenDaka[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenkijyun15(mvaAriWUpYenKijyun[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwupyenyasu15(mvaAriWUpYenYasu[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwumupyendaka15(mvaariwumupyendaka[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenkijyun15(mvaariumupyenkijyun[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumupyenyasu15(mvaariumupyenyasu[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypesame15(mvaAriWTukTypeSame[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsame15(mvaAriWSame[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypesame15(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyendaka15(mvaAriWSameYenDaka[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenkijyun15(mvaAriWSameYenKijyun[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwsameyenyasu15(mvaAriWSameYenYasu[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyendaka15(mvaariumsameyendaka[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenkijyun15(mvaariumsameyenkijyun[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumsameyenyasu15(mvaariumsameyenyasu[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwtuktypedown15(mvaAriWTukTypeDown[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdown15(mvaAriWDown[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwyentuktypedown15(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyendaka15(mvaAriWDownYenDaka[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenkijyun15(mvaAriWDownYenKijyun[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariwdownyenyasu15(mvaAriWDownYenYasu[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyendaka15(mvaariumdownyendaka[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenkijyun15(mvaariumdownyenkijyun[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariumdownyenyasu15(mvaariumdownyenyasu[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaarivtuktype15(mvaAriVTukType[14]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvaariv15(mvaAriV[14]);
        }

    }

    private void editSaihakkouHokensyoukenSuiiTy3(
        IT_HokenSyouken pHokenSyouken,
        ZT_SaihakkouSyoukenSuiiTy pSaihakkouHokensyoukenSuiiTy) {
        if (!BizUtil.isBlank(mvaNoneNenOutouYm[0])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn01(mvaNoneKaisiInnUmuKbn[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym01(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[0] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype01(mvaNoneWTukType[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew01(mvaNoneW[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype01(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka01(mvaNoneWYenSameYenDaka[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun01(mvaNoneWYenSameYenKijyun[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu01(mvaNoneWYenSameYenYasu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka01(mvanoneumyendaka[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun01(mvanoneumyenkijyun[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu01(mvanoneumyenyasu[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype01(mvaNoneVTukType[0]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev01(mvaNoneY[0]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[1])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn02(mvaNoneKaisiInnUmuKbn[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym02(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[1] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype02(mvaNoneWTukType[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew02(mvaNoneW[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype02(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka02(mvaNoneWYenSameYenDaka[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun02(mvaNoneWYenSameYenKijyun[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu02(mvaNoneWYenSameYenYasu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka02(mvanoneumyendaka[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun02(mvanoneumyenkijyun[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu02(mvanoneumyenyasu[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype02(mvaNoneVTukType[1]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev02(mvaNoneY[1]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[2])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn03(mvaNoneKaisiInnUmuKbn[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym03(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[2] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype03(mvaNoneWTukType[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew03(mvaNoneW[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype03(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka03(mvaNoneWYenSameYenDaka[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun03(mvaNoneWYenSameYenKijyun[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu03(mvaNoneWYenSameYenYasu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka03(mvanoneumyendaka[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun03(mvanoneumyenkijyun[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu03(mvanoneumyenyasu[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype03(mvaNoneVTukType[2]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev03(mvaNoneY[2]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[3])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn04(mvaNoneKaisiInnUmuKbn[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym04(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[3] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype04(mvaNoneWTukType[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew04(mvaNoneW[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype04(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka04(mvaNoneWYenSameYenDaka[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun04(mvaNoneWYenSameYenKijyun[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu04(mvaNoneWYenSameYenYasu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka04(mvanoneumyendaka[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun04(mvanoneumyenkijyun[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu04(mvanoneumyenyasu[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype04(mvaNoneVTukType[3]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev04(mvaNoneY[3]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[4])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn05(mvaNoneKaisiInnUmuKbn[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym05(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[4] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype05(mvaNoneWTukType[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew05(mvaNoneW[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype05(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka05(mvaNoneWYenSameYenDaka[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun05(mvaNoneWYenSameYenKijyun[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu05(mvaNoneWYenSameYenYasu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka05(mvanoneumyendaka[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun05(mvanoneumyenkijyun[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu05(mvanoneumyenyasu[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype05(mvaNoneVTukType[4]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev05(mvaNoneY[4]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[5])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn06(mvaNoneKaisiInnUmuKbn[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym06(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[5] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype06(mvaNoneWTukType[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew06(mvaNoneW[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype06(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka06(mvaNoneWYenSameYenDaka[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun06(mvaNoneWYenSameYenKijyun[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu06(mvaNoneWYenSameYenYasu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka06(mvanoneumyendaka[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun06(mvanoneumyenkijyun[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu06(mvanoneumyenyasu[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype06(mvaNoneVTukType[5]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev06(mvaNoneY[5]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[6])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn07(mvaNoneKaisiInnUmuKbn[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym07(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[6] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype07(mvaNoneWTukType[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew07(mvaNoneW[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype07(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka07(mvaNoneWYenSameYenDaka[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun07(mvaNoneWYenSameYenKijyun[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu07(mvaNoneWYenSameYenYasu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka07(mvanoneumyendaka[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun07(mvanoneumyenkijyun[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu07(mvanoneumyenyasu[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype07(mvaNoneVTukType[6]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev07(mvaNoneY[6]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[7])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn08(mvaNoneKaisiInnUmuKbn[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym08(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[7] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype08(mvaNoneWTukType[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew08(mvaNoneW[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype08(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka08(mvaNoneWYenSameYenDaka[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun08(mvaNoneWYenSameYenKijyun[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu08(mvaNoneWYenSameYenYasu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka08(mvanoneumyendaka[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun08(mvanoneumyenkijyun[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu08(mvanoneumyenyasu[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype08(mvaNoneVTukType[7]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev08(mvaNoneY[7]);
        }
        if (!BizUtil.isBlank(mvaNoneNenOutouYm[8])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn09(mvaNoneKaisiInnUmuKbn[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym09(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[8] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype09(mvaNoneWTukType[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew09(mvaNoneW[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype09(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka09(mvaNoneWYenSameYenDaka[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun09(mvaNoneWYenSameYenKijyun[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu09(mvaNoneWYenSameYenYasu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka09(mvanoneumyendaka[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun09(mvanoneumyenkijyun[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu09(mvanoneumyenyasu[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype09(mvaNoneVTukType[8]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev09(mvaNoneY[8]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[9])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn10(mvaNoneKaisiInnUmuKbn[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym10(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[9] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype10(mvaNoneWTukType[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew10(mvaNoneW[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype10(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka10(mvaNoneWYenSameYenDaka[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun10(mvaNoneWYenSameYenKijyun[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu10(mvaNoneWYenSameYenYasu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka10(mvanoneumyendaka[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun10(mvanoneumyenkijyun[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu10(mvanoneumyenyasu[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype10(mvaNoneVTukType[9]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev10(mvaNoneY[9]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[10])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn11(mvaNoneKaisiInnUmuKbn[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym11(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[10] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype11(mvaNoneWTukType[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew11(mvaNoneW[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype11(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka11(mvaNoneWYenSameYenDaka[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun11(mvaNoneWYenSameYenKijyun[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu11(mvaNoneWYenSameYenYasu[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka11(mvanoneumyendaka[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun11(mvanoneumyenkijyun[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu11(mvanoneumyenyasu[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype11(mvaNoneVTukType[10]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev11(mvaNoneY[10]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[11])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn12(mvaNoneKaisiInnUmuKbn[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym12(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[11] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype12(mvaNoneWTukType[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew12(mvaNoneW[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype12(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka12(mvaNoneWYenSameYenDaka[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun12(mvaNoneWYenSameYenKijyun[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu12(mvaNoneWYenSameYenYasu[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka12(mvanoneumyendaka[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun12(mvanoneumyenkijyun[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu12(mvanoneumyenyasu[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype12(mvaNoneVTukType[11]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev12(mvaNoneY[11]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[12])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn13(mvaNoneKaisiInnUmuKbn[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym13(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[12] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype13(mvaNoneWTukType[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew13(mvaNoneW[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype13(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka13(mvaNoneWYenSameYenDaka[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun13(mvaNoneWYenSameYenKijyun[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu13(mvaNoneWYenSameYenYasu[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka13(mvanoneumyendaka[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun13(mvanoneumyenkijyun[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu13(mvanoneumyenyasu[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype13(mvaNoneVTukType[12]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev13(mvaNoneY[12]);
        }
        if (!BizUtil.isBlank(mvaNoneNenOutouYm[13])) {
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonekaisiinnumukbn14(mvaNoneKaisiInnUmuKbn[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonenenoutouym14(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[13] + "01")));
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewtuktype14(mvaNoneWTukType[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonew14(mvaNoneW[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyentuktype14(C_Tuukasyu.JPY.toString());
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyendaka14(mvaNoneWYenSameYenDaka[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenkijyun14(mvaNoneWYenSameYenKijyun[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonewyenyasu14(mvaNoneWYenSameYenYasu[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyendaka14(mvanoneumyendaka[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenkijyun14(mvanoneumyenkijyun[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanoneumyenyasu14(mvanoneumyenyasu[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonevtuktype14(mvaNoneVTukType[13]);
            pSaihakkouHokensyoukenSuiiTy.setZtymvanonev14(mvaNoneY[13]);
        }
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcd1(pHokenSyouken.getWmsgcd1());
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcd2(pHokenSyouken.getWmsgcd2());
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcd3(pHokenSyouken.getWmsgcd3());
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcd21(pHokenSyouken.getWmsgcd21());
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcd22(pHokenSyouken.getWmsgcd22());
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcd23(pHokenSyouken.getWmsgcd23());
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcd31(pHokenSyouken.getWmsgcd31());
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcd32(pHokenSyouken.getWmsgcd32());
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcd33(pHokenSyouken.getWmsgcd33());
        pSaihakkouHokensyoukenSuiiTy.setZtywmsgcdst1(pHokenSyouken.getWmsgcdst1());
        pSaihakkouHokensyoukenSuiiTy.setZtywtyuuimsgcd1(pHokenSyouken.getWtyuuijikoumsgcd1());
        pSaihakkouHokensyoukenSuiiTy.setZtywtyuuimsgcd2(pHokenSyouken.getWtyuuijikoumsgcd2());
        pSaihakkouHokensyoukenSuiiTy.setZtywtyuuimsgcd3(pHokenSyouken.getWtyuuijikoumsgcd3());
        pSaihakkouHokensyoukenSuiiTy.setZtywtyuuimsgcd4(pHokenSyouken.getWtyuuijikoumsgcd4());
        pSaihakkouHokensyoukenSuiiTy.setZtywtyuuimsgcd5(pHokenSyouken.getWtyuuijikoumsgcd5());
        pSaihakkouHokensyoukenSuiiTy.setZtywtyuuimsgcd6(pHokenSyouken.getWtyuuijikoumsgcd6());
        pSaihakkouHokensyoukenSuiiTy.setZtywtyuuimsgcd7(pHokenSyouken.getWtyuuijikoumsgcd7());
        pSaihakkouHokensyoukenSuiiTy.setZtywitjbrptuuktype(String.valueOf(pHokenSyouken.getWitijibrptuktype()));
        pSaihakkouHokensyoukenSuiiTy.setZtywitjbrp(witijibrp);
        pSaihakkouHokensyoukenSuiiTy.setZtywyenhrikmgktuuktype(String.valueOf(pHokenSyouken.getWyenhrkgktuktype()));
        pSaihakkouHokensyoukenSuiiTy.setZtywyenhrikmgk(String.valueOf(pHokenSyouken.getWyenhrkgk()));
        pSaihakkouHokensyoukenSuiiTy.setZtywyenitjbrptuuktype(String.valueOf(pHokenSyouken.getWyenitijibrptuktype()));
        pSaihakkouHokensyoukenSuiiTy.setZtywyenitjbrp(String.valueOf(pHokenSyouken.getWyenitijibrp()));
        pSaihakkouHokensyoukenSuiiTy.setZtywsjkkktyouseitkyuym(wsjkkktyouseitkyuym);
        pSaihakkouHokensyoukenSuiiTy.setZtyhrkkknmnryym(hrkkknmnryym);
        pSaihakkouHokensyoukenSuiiTy.setZtyhrkkknmnrynen(hrkkknmnrynen);
        pSaihakkouHokensyoukenSuiiTy.setZtyyobiv49(String.valueOf(pHokenSyouken.getSisuuupkaisuu()) +
            String.valueOf(pHokenSyouken.getSisuudownkaisuu()));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

    private void editSaihakkouHokensyoukenSuiiTyPattern2_2(
        ZT_SaihakkouSyoukenSuiiTy pSaihakkouSyoukenSuiiTy) {
        if (!BizUtil.isBlank(mvaAriNenOuTouYm[0])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym01(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[0] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu01(sisuuupritu2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu01(tmttknzoukaritu2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup01(mvaAriWTukTypeUp[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup01(mvaaritmttkgkkykkjmaeup2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup01(mvaAriWUp2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup01(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka01(mvaAriWUpYenDaka2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun01(mvaAriWUpYenKijyun2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu01(mvaAriWUpYenYasu2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka01(mvaariwumupyendaka2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun01(mvaariumupyenkijyun2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu01(mvaariumupyenyasu2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame01(mvaAriWTukTypeSame[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame01(mvaaritmttkgkkykkjmaesame2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame01(mvaAriWSame2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame01(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka01(mvaAriWSameYenDaka2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun01(mvaAriWSameYenKijyun2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu01(mvaAriWSameYenYasu2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka01(mvaariumsameyendaka2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun01(mvaariumsameyenkijyun2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu01(mvaariumsameyenyasu2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown01(mvaAriWTukTypeDown[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown01(mvaaritmttkgkkykkjmaedown2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown01(mvaAriWDown2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown01(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka01(mvaAriWDownYenDaka2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun01(mvaAriWDownYenKijyun2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu01(mvaAriWDownYenYasu2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka01(mvaariumdownyendaka2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun01(mvaariumdownyenkijyun2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu01(mvaariumdownyenyasu2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype01(mvaAriVTukType[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv01(mvaAriV2[0]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake101(tutmttknutiwake12[0]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake201(tutmttknutiwake22[0]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[1])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym02(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[1] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu02(sisuuupritu2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu02(tmttknzoukaritu2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup02(mvaAriWTukTypeUp[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup02(mvaaritmttkgkkykkjmaeup2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup02(mvaAriWUp2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup02(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka02(mvaAriWUpYenDaka2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun02(mvaAriWUpYenKijyun2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu02(mvaAriWUpYenYasu2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka02(mvaariwumupyendaka2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun02(mvaariumupyenkijyun2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu02(mvaariumupyenyasu2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame02(mvaAriWTukTypeSame[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame02(mvaaritmttkgkkykkjmaesame2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame02(mvaAriWSame2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame02(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka02(mvaAriWSameYenDaka2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun02(mvaAriWSameYenKijyun2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu02(mvaAriWSameYenYasu2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka02(mvaariumsameyendaka2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun02(mvaariumsameyenkijyun2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu02(mvaariumsameyenyasu2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown02(mvaAriWTukTypeDown[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown02(mvaaritmttkgkkykkjmaedown2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown02(mvaAriWDown2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown02(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka02(mvaAriWDownYenDaka2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun02(mvaAriWDownYenKijyun2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu02(mvaAriWDownYenYasu2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka02(mvaariumdownyendaka2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun02(mvaariumdownyenkijyun2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu02(mvaariumdownyenyasu2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype02(mvaAriVTukType[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv02(mvaAriV2[1]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake102(tutmttknutiwake12[1]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake202(tutmttknutiwake22[1]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[2])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym03(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[2] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu03(sisuuupritu2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu03(tmttknzoukaritu2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup03(mvaAriWTukTypeUp[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup03(mvaaritmttkgkkykkjmaeup2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup03(mvaAriWUp2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup03(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka03(mvaAriWUpYenDaka2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun03(mvaAriWUpYenKijyun2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu03(mvaAriWUpYenYasu2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka03(mvaariwumupyendaka2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun03(mvaariumupyenkijyun2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu03(mvaariumupyenyasu2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame03(mvaAriWTukTypeSame[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame03(mvaaritmttkgkkykkjmaesame2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame03(mvaAriWSame2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame03(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka03(mvaAriWSameYenDaka2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun03(mvaAriWSameYenKijyun2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu03(mvaAriWSameYenYasu2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka03(mvaariumsameyendaka2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun03(mvaariumsameyenkijyun2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu03(mvaariumsameyenyasu2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown03(mvaAriWTukTypeDown[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown03(mvaaritmttkgkkykkjmaedown2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown03(mvaAriWDown2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown03(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka03(mvaAriWDownYenDaka2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun03(mvaAriWDownYenKijyun2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu03(mvaAriWDownYenYasu2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka03(mvaariumdownyendaka2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun03(mvaariumdownyenkijyun2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu03(mvaariumdownyenyasu2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype03(mvaAriVTukType[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv03(mvaAriV2[2]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake103(tutmttknutiwake12[2]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake203(tutmttknutiwake22[2]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[3])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym04(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[3] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu04(sisuuupritu2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu04(tmttknzoukaritu2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup04(mvaAriWTukTypeUp[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup04(mvaaritmttkgkkykkjmaeup2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup04(mvaAriWUp2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup04(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka04(mvaAriWUpYenDaka2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun04(mvaAriWUpYenKijyun2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu04(mvaAriWUpYenYasu2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka04(mvaariwumupyendaka2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun04(mvaariumupyenkijyun2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu04(mvaariumupyenyasu2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame04(mvaAriWTukTypeSame[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame04(mvaaritmttkgkkykkjmaesame2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame04(mvaAriWSame2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame04(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka04(mvaAriWSameYenDaka2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun04(mvaAriWSameYenKijyun2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu04(mvaAriWSameYenYasu2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka04(mvaariumsameyendaka2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun04(mvaariumsameyenkijyun2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu04(mvaariumsameyenyasu2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown04(mvaAriWTukTypeDown[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown04(mvaaritmttkgkkykkjmaedown2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown04(mvaAriWDown2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown04(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka04(mvaAriWDownYenDaka2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun04(mvaAriWDownYenKijyun2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu04(mvaAriWDownYenYasu2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka04(mvaariumdownyendaka2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun04(mvaariumdownyenkijyun2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu04(mvaariumdownyenyasu2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype04(mvaAriVTukType[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv04(mvaAriV2[3]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake104(tutmttknutiwake12[3]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake204(tutmttknutiwake22[3]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[4])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym05(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[4] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu05(sisuuupritu2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu05(tmttknzoukaritu2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup05(mvaAriWTukTypeUp[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup05(mvaaritmttkgkkykkjmaeup2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup05(mvaAriWUp2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup05(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka05(mvaAriWUpYenDaka2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun05(mvaAriWUpYenKijyun2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu05(mvaAriWUpYenYasu2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka05(mvaariwumupyendaka2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun05(mvaariumupyenkijyun2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu05(mvaariumupyenyasu2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame05(mvaAriWTukTypeSame[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame05(mvaaritmttkgkkykkjmaesame2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame05(mvaAriWSame2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame05(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka05(mvaAriWSameYenDaka2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun05(mvaAriWSameYenKijyun2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu05(mvaAriWSameYenYasu2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka05(mvaariumsameyendaka2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun05(mvaariumsameyenkijyun2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu05(mvaariumsameyenyasu2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown05(mvaAriWTukTypeDown[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown05(mvaaritmttkgkkykkjmaedown2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown05(mvaAriWDown2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown05(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka05(mvaAriWDownYenDaka2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun05(mvaAriWDownYenKijyun2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu05(mvaAriWDownYenYasu2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka05(mvaariumdownyendaka2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun05(mvaariumdownyenkijyun2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu05(mvaariumdownyenyasu2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype05(mvaAriVTukType[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv05(mvaAriV2[4]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake105(tutmttknutiwake12[4]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake205(tutmttknutiwake22[4]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[5])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym06(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[5] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu06(sisuuupritu2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu06(tmttknzoukaritu2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup06(mvaAriWTukTypeUp[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup06(mvaaritmttkgkkykkjmaeup2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup06(mvaAriWUp2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup06(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka06(mvaAriWUpYenDaka2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun06(mvaAriWUpYenKijyun2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu06(mvaAriWUpYenYasu2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka06(mvaariwumupyendaka2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun06(mvaariumupyenkijyun2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu06(mvaariumupyenyasu2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame06(mvaAriWTukTypeSame[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame06(mvaaritmttkgkkykkjmaesame2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame06(mvaAriWSame2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame06(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka06(mvaAriWSameYenDaka2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun06(mvaAriWSameYenKijyun2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu06(mvaAriWSameYenYasu2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka06(mvaariumsameyendaka2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun06(mvaariumsameyenkijyun2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu06(mvaariumsameyenyasu2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown06(mvaAriWTukTypeDown[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown06(mvaaritmttkgkkykkjmaedown2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown06(mvaAriWDown2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown06(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka06(mvaAriWDownYenDaka2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun06(mvaAriWDownYenKijyun2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu06(mvaAriWDownYenYasu2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka06(mvaariumdownyendaka2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun06(mvaariumdownyenkijyun2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu06(mvaariumdownyenyasu2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype06(mvaAriVTukType[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv06(mvaAriV2[5]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake106(tutmttknutiwake12[5]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake206(tutmttknutiwake22[5]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[6])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym07(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[6] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu07(sisuuupritu2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu07(tmttknzoukaritu2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup07(mvaAriWTukTypeUp[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup07(mvaaritmttkgkkykkjmaeup2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup07(mvaAriWUp2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup07(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka07(mvaAriWUpYenDaka2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun07(mvaAriWUpYenKijyun2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu07(mvaAriWUpYenYasu2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka07(mvaariwumupyendaka2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun07(mvaariumupyenkijyun2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu07(mvaariumupyenyasu2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame07(mvaAriWTukTypeSame[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame07(mvaaritmttkgkkykkjmaesame2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame07(mvaAriWSame2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame07(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka07(mvaAriWSameYenDaka2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun07(mvaAriWSameYenKijyun2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu07(mvaAriWSameYenYasu2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka07(mvaariumsameyendaka2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun07(mvaariumsameyenkijyun2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu07(mvaariumsameyenyasu2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown07(mvaAriWTukTypeDown[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown07(mvaaritmttkgkkykkjmaedown2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown07(mvaAriWDown2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown07(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka07(mvaAriWDownYenDaka2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun07(mvaAriWDownYenKijyun2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu07(mvaAriWDownYenYasu2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka07(mvaariumdownyendaka2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun07(mvaariumdownyenkijyun2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu07(mvaariumdownyenyasu2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype07(mvaAriVTukType[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv07(mvaAriV2[6]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake107(tutmttknutiwake12[6]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake207(tutmttknutiwake22[6]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[7])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym08(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[7] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu08(sisuuupritu2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu08(tmttknzoukaritu2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup08(mvaAriWTukTypeUp[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup08(mvaaritmttkgkkykkjmaeup2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup08(mvaAriWUp2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup08(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka08(mvaAriWUpYenDaka2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun08(mvaAriWUpYenKijyun2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu08(mvaAriWUpYenYasu2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka08(mvaariwumupyendaka2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun08(mvaariumupyenkijyun2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu08(mvaariumupyenyasu2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame08(mvaAriWTukTypeSame[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame08(mvaaritmttkgkkykkjmaesame2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame08(mvaAriWSame2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame08(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka08(mvaAriWSameYenDaka2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun08(mvaAriWSameYenKijyun2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu08(mvaAriWSameYenYasu2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka08(mvaariumsameyendaka2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun08(mvaariumsameyenkijyun2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu08(mvaariumsameyenyasu2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown08(mvaAriWTukTypeDown[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown08(mvaaritmttkgkkykkjmaedown2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown08(mvaAriWDown2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown08(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka08(mvaAriWDownYenDaka2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun08(mvaAriWDownYenKijyun2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu08(mvaAriWDownYenYasu2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka08(mvaariumdownyendaka2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun08(mvaariumdownyenkijyun2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu08(mvaariumdownyenyasu2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype08(mvaAriVTukType[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv08(mvaAriV2[7]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake108(tutmttknutiwake12[7]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake208(tutmttknutiwake22[7]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[8])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym09(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[8] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu09(sisuuupritu2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu09(tmttknzoukaritu2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup09(mvaAriWTukTypeUp[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup09(mvaaritmttkgkkykkjmaeup2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup09(mvaAriWUp2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup09(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka09(mvaAriWUpYenDaka2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun09(mvaAriWUpYenKijyun2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu09(mvaAriWUpYenYasu2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka09(mvaariwumupyendaka2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun09(mvaariumupyenkijyun2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu09(mvaariumupyenyasu2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame09(mvaAriWTukTypeSame[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame09(mvaaritmttkgkkykkjmaesame2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame09(mvaAriWSame2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame09(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka09(mvaAriWSameYenDaka2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun09(mvaAriWSameYenKijyun2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu09(mvaAriWSameYenYasu2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka09(mvaariumsameyendaka2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun09(mvaariumsameyenkijyun2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu09(mvaariumsameyenyasu2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown09(mvaAriWTukTypeDown[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown09(mvaaritmttkgkkykkjmaedown2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown09(mvaAriWDown2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown09(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka09(mvaAriWDownYenDaka2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun09(mvaAriWDownYenKijyun2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu09(mvaAriWDownYenYasu2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka09(mvaariumdownyendaka2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun09(mvaariumdownyenkijyun2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu09(mvaariumdownyenyasu2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype09(mvaAriVTukType[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv09(mvaAriV2[8]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake109(tutmttknutiwake12[8]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake209(tutmttknutiwake22[8]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[9])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym10(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[9] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu10(sisuuupritu2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu10(tmttknzoukaritu2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup10(mvaAriWTukTypeUp[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup10(mvaaritmttkgkkykkjmaeup2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup10(mvaAriWUp2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup10(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka10(mvaAriWUpYenDaka2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun10(mvaAriWUpYenKijyun2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu10(mvaAriWUpYenYasu2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka10(mvaariwumupyendaka2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun10(mvaariumupyenkijyun2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu10(mvaariumupyenyasu2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame10(mvaAriWTukTypeSame[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame10(mvaaritmttkgkkykkjmaesame2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame10(mvaAriWSame2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame10(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka10(mvaAriWSameYenDaka2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun10(mvaAriWSameYenKijyun2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu10(mvaAriWSameYenYasu2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka10(mvaariumsameyendaka2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun10(mvaariumsameyenkijyun2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu10(mvaariumsameyenyasu2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown10(mvaAriWTukTypeDown[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown10(mvaaritmttkgkkykkjmaedown2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown10(mvaAriWDown2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown10(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka10(mvaAriWDownYenDaka2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun10(mvaAriWDownYenKijyun2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu10(mvaAriWDownYenYasu2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka10(mvaariumdownyendaka2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun10(mvaariumdownyenkijyun2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu10(mvaariumdownyenyasu2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype10(mvaAriVTukType[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv10(mvaAriV2[9]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake110(tutmttknutiwake12[9]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake210(tutmttknutiwake22[9]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[10])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym11(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[10] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup11(mvaAriWTukTypeUp[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup11(mvaAriWUp2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup11(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka11(mvaAriWUpYenDaka2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun11(mvaAriWUpYenKijyun2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu11(mvaAriWUpYenYasu2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka11(mvaariwumupyendaka2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun11(mvaariumupyenkijyun2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu11(mvaariumupyenyasu2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame11(mvaAriWTukTypeSame[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame11(mvaAriWSame2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame11(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka11(mvaAriWSameYenDaka2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun11(mvaAriWSameYenKijyun2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu11(mvaAriWSameYenYasu2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka11(mvaariumsameyendaka2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun11(mvaariumsameyenkijyun2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu11(mvaariumsameyenyasu2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown11(mvaAriWTukTypeDown[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown11(mvaAriWDown2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown11(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka11(mvaAriWDownYenDaka2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun11(mvaAriWDownYenKijyun2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu11(mvaAriWDownYenYasu2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka11(mvaariumdownyendaka2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun11(mvaariumdownyenkijyun2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu11(mvaariumdownyenyasu2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype11(mvaAriVTukType[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv11(mvaAriV2[10]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[11])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym12(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[11] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup12(mvaAriWTukTypeUp[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup12(mvaAriWUp2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup12(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka12(mvaAriWUpYenDaka2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun12(mvaAriWUpYenKijyun2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu12(mvaAriWUpYenYasu2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka12(mvaariwumupyendaka2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun12(mvaariumupyenkijyun2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu12(mvaariumupyenyasu2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame12(mvaAriWTukTypeSame[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame12(mvaAriWSame2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame12(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka12(mvaAriWSameYenDaka2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun12(mvaAriWSameYenKijyun2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu12(mvaAriWSameYenYasu2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka12(mvaariumsameyendaka2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun12(mvaariumsameyenkijyun2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu12(mvaariumsameyenyasu2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown12(mvaAriWTukTypeDown[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown12(mvaAriWDown2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown12(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka12(mvaAriWDownYenDaka2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun12(mvaAriWDownYenKijyun2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu12(mvaAriWDownYenYasu2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka12(mvaariumdownyendaka2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun12(mvaariumdownyenkijyun2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu12(mvaariumdownyenyasu2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype12(mvaAriVTukType[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv12(mvaAriV2[11]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[12])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym13(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[12] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup13(mvaAriWTukTypeUp[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup13(mvaAriWUp2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup13(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka13(mvaAriWUpYenDaka2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun13(mvaAriWUpYenKijyun2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu13(mvaAriWUpYenYasu2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka13(mvaariwumupyendaka2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun13(mvaariumupyenkijyun2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu13(mvaariumupyenyasu2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame13(mvaAriWTukTypeSame[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame13(mvaAriWSame2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame13(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka13(mvaAriWSameYenDaka2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun13(mvaAriWSameYenKijyun2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu13(mvaAriWSameYenYasu2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka13(mvaariumsameyendaka2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun13(mvaariumsameyenkijyun2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu13(mvaariumsameyenyasu2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown13(mvaAriWTukTypeDown[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown13(mvaAriWDown2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown13(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka13(mvaAriWDownYenDaka2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun13(mvaAriWDownYenKijyun2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu13(mvaAriWDownYenYasu2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka13(mvaariumdownyendaka2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun13(mvaariumdownyenkijyun2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu13(mvaariumdownyenyasu2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype13(mvaAriVTukType[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv13(mvaAriV2[12]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[13])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym14(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[13] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup14(mvaAriWTukTypeUp[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup14(mvaAriWUp2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup14(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka14(mvaAriWUpYenDaka2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun14(mvaAriWUpYenKijyun2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu14(mvaAriWUpYenYasu2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka14(mvaariwumupyendaka2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun14(mvaariumupyenkijyun2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu14(mvaariumupyenyasu2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame14(mvaAriWTukTypeSame[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame14(mvaAriWSame2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame14(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka14(mvaAriWSameYenDaka2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun14(mvaAriWSameYenKijyun2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu14(mvaAriWSameYenYasu2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka14(mvaariumsameyendaka2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun14(mvaariumsameyenkijyun2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu14(mvaariumsameyenyasu2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown14(mvaAriWTukTypeDown[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown14(mvaAriWDown2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown14(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka14(mvaAriWDownYenDaka2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun14(mvaAriWDownYenKijyun2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu14(mvaAriWDownYenYasu2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka14(mvaariumdownyendaka2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun14(mvaariumdownyenkijyun2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu14(mvaariumdownyenyasu2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype14(mvaAriVTukType[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv14(mvaAriV2[13]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[14])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym15(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[14] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup15(mvaAriWTukTypeUp[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup15(mvaAriWUp2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup15(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka15(mvaAriWUpYenDaka2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun15(mvaAriWUpYenKijyun2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu15(mvaAriWUpYenYasu2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka15(mvaariwumupyendaka2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun15(mvaariumupyenkijyun2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu15(mvaariumupyenyasu2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame15(mvaAriWTukTypeSame[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame15(mvaAriWSame2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame15(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka15(mvaAriWSameYenDaka2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun15(mvaAriWSameYenKijyun2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu15(mvaAriWSameYenYasu2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka15(mvaariumsameyendaka2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun15(mvaariumsameyenkijyun2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu15(mvaariumsameyenyasu2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown15(mvaAriWTukTypeDown[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown15(mvaAriWDown2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown15(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka15(mvaAriWDownYenDaka2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun15(mvaAriWDownYenKijyun2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu15(mvaAriWDownYenYasu2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka15(mvaariumdownyendaka2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun15(mvaariumdownyenkijyun2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu15(mvaariumdownyenyasu2[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype15(mvaAriVTukType[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv15(mvaAriV2[14]);
        }
    }


    private void editSaihakkouHokensyoukenSuiiTyPattern2_3(
        IT_HokenSyouken pHokenSyouken,
        ZT_SaihakkouSyoukenSuiiTy pSaihakkouSyoukenSuiiTy) {
        if (!BizUtil.isBlank(mvaNoneNenOutouYm[0])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn01(mvaNoneKaisiInnUmuKbn[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym01(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[0] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype01(mvaNoneWTukType[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew01(mvaNoneW2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype01(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka01(mvaNoneWYenSameYenDaka2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun01(mvaNoneWYenSameYenKijyun2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu01(mvaNoneWYenSameYenYasu2[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka01(mvanoneumyendaka[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun01(mvanoneumyenkijyun[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu01(mvanoneumyenyasu[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype01(mvaNoneVTukType[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev01(mvaNoneY2[0]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[1])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn02(mvaNoneKaisiInnUmuKbn[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym02(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[1] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype02(mvaNoneWTukType[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew02(mvaNoneW2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype02(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka02(mvaNoneWYenSameYenDaka2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun02(mvaNoneWYenSameYenKijyun2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu02(mvaNoneWYenSameYenYasu2[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka02(mvanoneumyendaka[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun02(mvanoneumyenkijyun[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu02(mvanoneumyenyasu[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype02(mvaNoneVTukType[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev02(mvaNoneY2[1]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[2])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn03(mvaNoneKaisiInnUmuKbn[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym03(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[2] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype03(mvaNoneWTukType[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew03(mvaNoneW2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype03(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka03(mvaNoneWYenSameYenDaka2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun03(mvaNoneWYenSameYenKijyun2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu03(mvaNoneWYenSameYenYasu2[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka03(mvanoneumyendaka[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun03(mvanoneumyenkijyun[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu03(mvanoneumyenyasu[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype03(mvaNoneVTukType[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev03(mvaNoneY2[2]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[3])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn04(mvaNoneKaisiInnUmuKbn[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym04(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[3] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype04(mvaNoneWTukType[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew04(mvaNoneW2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype04(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka04(mvaNoneWYenSameYenDaka2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun04(mvaNoneWYenSameYenKijyun2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu04(mvaNoneWYenSameYenYasu2[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka04(mvanoneumyendaka[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun04(mvanoneumyenkijyun[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu04(mvanoneumyenyasu[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype04(mvaNoneVTukType[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev04(mvaNoneY2[3]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[4])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn05(mvaNoneKaisiInnUmuKbn[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym05(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[4] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype05(mvaNoneWTukType[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew05(mvaNoneW2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype05(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka05(mvaNoneWYenSameYenDaka2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun05(mvaNoneWYenSameYenKijyun2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu05(mvaNoneWYenSameYenYasu2[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka05(mvanoneumyendaka[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun05(mvanoneumyenkijyun[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu05(mvanoneumyenyasu[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype05(mvaNoneVTukType[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev05(mvaNoneY2[4]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[5])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn06(mvaNoneKaisiInnUmuKbn[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym06(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[5] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype06(mvaNoneWTukType[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew06(mvaNoneW2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype06(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka06(mvaNoneWYenSameYenDaka2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun06(mvaNoneWYenSameYenKijyun2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu06(mvaNoneWYenSameYenYasu2[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka06(mvanoneumyendaka[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun06(mvanoneumyenkijyun[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu06(mvanoneumyenyasu[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype06(mvaNoneVTukType[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev06(mvaNoneY2[5]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[6])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn07(mvaNoneKaisiInnUmuKbn[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym07(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[6] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype07(mvaNoneWTukType[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew07(mvaNoneW2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype07(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka07(mvaNoneWYenSameYenDaka2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun07(mvaNoneWYenSameYenKijyun2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu07(mvaNoneWYenSameYenYasu2[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka07(mvanoneumyendaka[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun07(mvanoneumyenkijyun[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu07(mvanoneumyenyasu[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype07(mvaNoneVTukType[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev07(mvaNoneY2[6]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[7])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn08(mvaNoneKaisiInnUmuKbn[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym08(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[7] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype08(mvaNoneWTukType[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew08(mvaNoneW2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype08(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka08(mvaNoneWYenSameYenDaka2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun08(mvaNoneWYenSameYenKijyun2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu08(mvaNoneWYenSameYenYasu2[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka08(mvanoneumyendaka[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun08(mvanoneumyenkijyun[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu08(mvanoneumyenyasu[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype08(mvaNoneVTukType[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev08(mvaNoneY2[7]);
        }
        if (!BizUtil.isBlank(mvaNoneNenOutouYm[8])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn09(mvaNoneKaisiInnUmuKbn[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym09(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[8] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype09(mvaNoneWTukType[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew09(mvaNoneW2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype09(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka09(mvaNoneWYenSameYenDaka2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun09(mvaNoneWYenSameYenKijyun2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu09(mvaNoneWYenSameYenYasu2[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka09(mvanoneumyendaka[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun09(mvanoneumyenkijyun[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu09(mvanoneumyenyasu[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype09(mvaNoneVTukType[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev09(mvaNoneY2[8]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[9])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn10(mvaNoneKaisiInnUmuKbn[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym10(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[9] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype10(mvaNoneWTukType[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew10(mvaNoneW2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype10(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka10(mvaNoneWYenSameYenDaka2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun10(mvaNoneWYenSameYenKijyun2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu10(mvaNoneWYenSameYenYasu2[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka10(mvanoneumyendaka[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun10(mvanoneumyenkijyun[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu10(mvanoneumyenyasu[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype10(mvaNoneVTukType[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev10(mvaNoneY2[9]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[10])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn11(mvaNoneKaisiInnUmuKbn[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym11(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[10] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype11(mvaNoneWTukType[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew11(mvaNoneW2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype11(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka11(mvaNoneWYenSameYenDaka2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun11(mvaNoneWYenSameYenKijyun2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu11(mvaNoneWYenSameYenYasu2[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka11(mvanoneumyendaka[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun11(mvanoneumyenkijyun[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu11(mvanoneumyenyasu[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype11(mvaNoneVTukType[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev11(mvaNoneY2[10]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[11])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn12(mvaNoneKaisiInnUmuKbn[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym12(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[11] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype12(mvaNoneWTukType[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew12(mvaNoneW2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype12(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka12(mvaNoneWYenSameYenDaka2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun12(mvaNoneWYenSameYenKijyun2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu12(mvaNoneWYenSameYenYasu2[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka12(mvanoneumyendaka[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun12(mvanoneumyenkijyun[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu12(mvanoneumyenyasu[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype12(mvaNoneVTukType[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev12(mvaNoneY2[11]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[12])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn13(mvaNoneKaisiInnUmuKbn[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym13(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[12] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype13(mvaNoneWTukType[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew13(mvaNoneW2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype13(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka13(mvaNoneWYenSameYenDaka2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun13(mvaNoneWYenSameYenKijyun2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu13(mvaNoneWYenSameYenYasu2[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka13(mvanoneumyendaka[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun13(mvanoneumyenkijyun[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu13(mvanoneumyenyasu[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype13(mvaNoneVTukType[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev13(mvaNoneY2[12]);
        }
        if (!BizUtil.isBlank(mvaNoneNenOutouYm[13])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn14(mvaNoneKaisiInnUmuKbn[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym14(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[13] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype14(mvaNoneWTukType[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew14(mvaNoneW2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype14(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka14(mvaNoneWYenSameYenDaka2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun14(mvaNoneWYenSameYenKijyun2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu14(mvaNoneWYenSameYenYasu2[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka14(mvanoneumyendaka[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun14(mvanoneumyenkijyun[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu14(mvanoneumyenyasu[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype14(mvaNoneVTukType[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev14(mvaNoneY2[13]);
        }

        pSaihakkouSyoukenSuiiTy.setZtywmsgcd1(pHokenSyouken.getWmsgcd1());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd2(pHokenSyouken.getWmsgcd2());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd3(pHokenSyouken.getWmsgcd3());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd21(pHokenSyouken.getWmsgcd21());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd22(pHokenSyouken.getWmsgcd22());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd23(pHokenSyouken.getWmsgcd23());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd31(pHokenSyouken.getWmsgcd31());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd32(pHokenSyouken.getWmsgcd32());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd33(pHokenSyouken.getWmsgcd33());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcdst1(pHokenSyouken.getWmsgcdst1());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd1(pHokenSyouken.getWtyuuijikoumsgcd1());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd2(pHokenSyouken.getWtyuuijikoumsgcd2());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd3(pHokenSyouken.getWtyuuijikoumsgcd3());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd4(pHokenSyouken.getWtyuuijikoumsgcd4());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd5(pHokenSyouken.getWtyuuijikoumsgcd5());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd6(pHokenSyouken.getWtyuuijikoumsgcd6());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd7(pHokenSyouken.getWtyuuijikoumsgcd7());
        pSaihakkouSyoukenSuiiTy.setZtywitjbrptuuktype(String.valueOf(pHokenSyouken.getWitijibrptuktype()));
        pSaihakkouSyoukenSuiiTy.setZtywitjbrp(witijibrp);
        pSaihakkouSyoukenSuiiTy.setZtywyenhrikmgktuuktype(String.valueOf(pHokenSyouken.getWyenhrkgktuktype()));
        pSaihakkouSyoukenSuiiTy.setZtywyenhrikmgk(String.valueOf(pHokenSyouken.getWyenhrkgk()));
        pSaihakkouSyoukenSuiiTy.setZtywyenitjbrptuuktype(String.valueOf(pHokenSyouken.getWyenitijibrptuktype()));
        pSaihakkouSyoukenSuiiTy.setZtywyenitjbrp(String.valueOf(pHokenSyouken.getWyenitijibrp()));
        pSaihakkouSyoukenSuiiTy.setZtywsjkkktyouseitkyuym(wsjkkktyouseitkyuym);
    }


    private void editSaihakkouHokensyoukenSuiiTyPattern3_2(
        ZT_SaihakkouSyoukenSuiiTy pSaihakkouSyoukenSuiiTy) {
        if (!BizUtil.isBlank(mvaAriNenOuTouYm[0])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym01(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[0] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu01(sisuuupritu3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu01(tmttknzoukaritu3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup01(mvaAriWTukTypeUp[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup01(mvaaritmttkgkkykkjmaeup3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup01(mvaAriWUp3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup01(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka01(mvaAriWUpYenDaka3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun01(mvaAriWUpYenKijyun3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu01(mvaAriWUpYenYasu3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka01(mvaariwumupyendaka3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun01(mvaariumupyenkijyun3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu01(mvaariumupyenyasu3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame01(mvaAriWTukTypeSame[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame01(mvaaritmttkgkkykkjmaesame3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame01(mvaAriWSame3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame01(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka01(mvaAriWSameYenDaka3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun01(mvaAriWSameYenKijyun3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu01(mvaAriWSameYenYasu3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka01(mvaariumsameyendaka3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun01(mvaariumsameyenkijyun3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu01(mvaariumsameyenyasu3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown01(mvaAriWTukTypeDown[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown01(mvaaritmttkgkkykkjmaedown3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown01(mvaAriWDown3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown01(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka01(mvaAriWDownYenDaka3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun01(mvaAriWDownYenKijyun3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu01(mvaAriWDownYenYasu3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka01(mvaariumdownyendaka3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun01(mvaariumdownyenkijyun3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu01(mvaariumdownyenyasu3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype01(mvaAriVTukType[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv01(mvaAriV3[0]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake101(tutmttknutiwake13[0]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake201(tutmttknutiwake23[0]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[1])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym02(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[1] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu02(sisuuupritu3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu02(tmttknzoukaritu3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup02(mvaAriWTukTypeUp[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup02(mvaaritmttkgkkykkjmaeup3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup02(mvaAriWUp3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup02(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka02(mvaAriWUpYenDaka3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun02(mvaAriWUpYenKijyun3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu02(mvaAriWUpYenYasu3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka02(mvaariwumupyendaka3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun02(mvaariumupyenkijyun3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu02(mvaariumupyenyasu3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame02(mvaAriWTukTypeSame[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame02(mvaaritmttkgkkykkjmaesame3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame02(mvaAriWSame3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame02(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka02(mvaAriWSameYenDaka3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun02(mvaAriWSameYenKijyun3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu02(mvaAriWSameYenYasu3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka02(mvaariumsameyendaka3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun02(mvaariumsameyenkijyun3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu02(mvaariumsameyenyasu3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown02(mvaAriWTukTypeDown[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown02(mvaaritmttkgkkykkjmaedown3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown02(mvaAriWDown3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown02(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka02(mvaAriWDownYenDaka3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun02(mvaAriWDownYenKijyun3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu02(mvaAriWDownYenYasu3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka02(mvaariumdownyendaka3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun02(mvaariumdownyenkijyun3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu02(mvaariumdownyenyasu3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype02(mvaAriVTukType[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv02(mvaAriV3[1]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake102(tutmttknutiwake13[1]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake202(tutmttknutiwake23[1]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[2])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym03(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[2] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu03(sisuuupritu3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu03(tmttknzoukaritu3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup03(mvaAriWTukTypeUp[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup03(mvaaritmttkgkkykkjmaeup3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup03(mvaAriWUp3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup03(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka03(mvaAriWUpYenDaka3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun03(mvaAriWUpYenKijyun3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu03(mvaAriWUpYenYasu3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka03(mvaariwumupyendaka3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun03(mvaariumupyenkijyun3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu03(mvaariumupyenyasu3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame03(mvaAriWTukTypeSame[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame03(mvaaritmttkgkkykkjmaesame3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame03(mvaAriWSame3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame03(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka03(mvaAriWSameYenDaka3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun03(mvaAriWSameYenKijyun3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu03(mvaAriWSameYenYasu3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka03(mvaariumsameyendaka3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun03(mvaariumsameyenkijyun3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu03(mvaariumsameyenyasu3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown03(mvaAriWTukTypeDown[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown03(mvaaritmttkgkkykkjmaedown3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown03(mvaAriWDown3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown03(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka03(mvaAriWDownYenDaka3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun03(mvaAriWDownYenKijyun3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu03(mvaAriWDownYenYasu3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka03(mvaariumdownyendaka3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun03(mvaariumdownyenkijyun3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu03(mvaariumdownyenyasu3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype03(mvaAriVTukType[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv03(mvaAriV3[2]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake103(tutmttknutiwake13[2]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake203(tutmttknutiwake23[2]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[3])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym04(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[3] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu04(sisuuupritu3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu04(tmttknzoukaritu3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup04(mvaAriWTukTypeUp[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup04(mvaaritmttkgkkykkjmaeup3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup04(mvaAriWUp3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup04(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka04(mvaAriWUpYenDaka3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun04(mvaAriWUpYenKijyun3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu04(mvaAriWUpYenYasu3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka04(mvaariwumupyendaka3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun04(mvaariumupyenkijyun3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu04(mvaariumupyenyasu3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame04(mvaAriWTukTypeSame[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame04(mvaaritmttkgkkykkjmaesame3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame04(mvaAriWSame3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame04(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka04(mvaAriWSameYenDaka3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun04(mvaAriWSameYenKijyun3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu04(mvaAriWSameYenYasu3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka04(mvaariumsameyendaka3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun04(mvaariumsameyenkijyun3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu04(mvaariumsameyenyasu3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown04(mvaAriWTukTypeDown[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown04(mvaaritmttkgkkykkjmaedown3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown04(mvaAriWDown3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown04(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka04(mvaAriWDownYenDaka3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun04(mvaAriWDownYenKijyun3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu04(mvaAriWDownYenYasu3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka04(mvaariumdownyendaka3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun04(mvaariumdownyenkijyun3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu04(mvaariumdownyenyasu3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype04(mvaAriVTukType[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv04(mvaAriV3[3]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake104(tutmttknutiwake13[3]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake204(tutmttknutiwake23[3]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[4])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym05(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[4] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu05(sisuuupritu3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu05(tmttknzoukaritu3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup05(mvaAriWTukTypeUp[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup05(mvaaritmttkgkkykkjmaeup3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup05(mvaAriWUp3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup05(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka05(mvaAriWUpYenDaka3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun05(mvaAriWUpYenKijyun3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu05(mvaAriWUpYenYasu3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka05(mvaariwumupyendaka3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun05(mvaariumupyenkijyun3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu05(mvaariumupyenyasu3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame05(mvaAriWTukTypeSame[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame05(mvaaritmttkgkkykkjmaesame3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame05(mvaAriWSame3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame05(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka05(mvaAriWSameYenDaka3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun05(mvaAriWSameYenKijyun3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu05(mvaAriWSameYenYasu3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka05(mvaariumsameyendaka3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun05(mvaariumsameyenkijyun3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu05(mvaariumsameyenyasu3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown05(mvaAriWTukTypeDown[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown05(mvaaritmttkgkkykkjmaedown3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown05(mvaAriWDown3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown05(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka05(mvaAriWDownYenDaka3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun05(mvaAriWDownYenKijyun3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu05(mvaAriWDownYenYasu3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka05(mvaariumdownyendaka3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun05(mvaariumdownyenkijyun3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu05(mvaariumdownyenyasu3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype05(mvaAriVTukType[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv05(mvaAriV3[4]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake105(tutmttknutiwake13[4]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake205(tutmttknutiwake23[4]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[5])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym06(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[5] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu06(sisuuupritu3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu06(tmttknzoukaritu3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup06(mvaAriWTukTypeUp[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup06(mvaaritmttkgkkykkjmaeup3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup06(mvaAriWUp3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup06(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka06(mvaAriWUpYenDaka3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun06(mvaAriWUpYenKijyun3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu06(mvaAriWUpYenYasu3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka06(mvaariwumupyendaka3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun06(mvaariumupyenkijyun3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu06(mvaariumupyenyasu3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame06(mvaAriWTukTypeSame[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame06(mvaaritmttkgkkykkjmaesame3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame06(mvaAriWSame3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame06(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka06(mvaAriWSameYenDaka3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun06(mvaAriWSameYenKijyun3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu06(mvaAriWSameYenYasu3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka06(mvaariumsameyendaka3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun06(mvaariumsameyenkijyun3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu06(mvaariumsameyenyasu3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown06(mvaAriWTukTypeDown[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown06(mvaaritmttkgkkykkjmaedown3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown06(mvaAriWDown3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown06(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka06(mvaAriWDownYenDaka3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun06(mvaAriWDownYenKijyun3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu06(mvaAriWDownYenYasu3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka06(mvaariumdownyendaka3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun06(mvaariumdownyenkijyun3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu06(mvaariumdownyenyasu3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype06(mvaAriVTukType[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv06(mvaAriV3[5]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake106(tutmttknutiwake13[5]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake206(tutmttknutiwake23[5]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[6])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym07(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[6] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu07(sisuuupritu3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu07(tmttknzoukaritu3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup07(mvaAriWTukTypeUp[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup07(mvaaritmttkgkkykkjmaeup3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup07(mvaAriWUp3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup07(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka07(mvaAriWUpYenDaka3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun07(mvaAriWUpYenKijyun3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu07(mvaAriWUpYenYasu3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka07(mvaariwumupyendaka3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun07(mvaariumupyenkijyun3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu07(mvaariumupyenyasu3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame07(mvaAriWTukTypeSame[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame07(mvaaritmttkgkkykkjmaesame3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame07(mvaAriWSame3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame07(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka07(mvaAriWSameYenDaka3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun07(mvaAriWSameYenKijyun3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu07(mvaAriWSameYenYasu3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka07(mvaariumsameyendaka3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun07(mvaariumsameyenkijyun3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu07(mvaariumsameyenyasu3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown07(mvaAriWTukTypeDown[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown07(mvaaritmttkgkkykkjmaedown3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown07(mvaAriWDown3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown07(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka07(mvaAriWDownYenDaka3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun07(mvaAriWDownYenKijyun3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu07(mvaAriWDownYenYasu3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka07(mvaariumdownyendaka3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun07(mvaariumdownyenkijyun3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu07(mvaariumdownyenyasu3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype07(mvaAriVTukType[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv07(mvaAriV3[6]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake107(tutmttknutiwake13[6]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake207(tutmttknutiwake23[6]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[7])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym08(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[7] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu08(sisuuupritu3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu08(tmttknzoukaritu3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup08(mvaAriWTukTypeUp[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup08(mvaaritmttkgkkykkjmaeup3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup08(mvaAriWUp3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup08(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka08(mvaAriWUpYenDaka3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun08(mvaAriWUpYenKijyun3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu08(mvaAriWUpYenYasu3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka08(mvaariwumupyendaka3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun08(mvaariumupyenkijyun3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu08(mvaariumupyenyasu3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame08(mvaAriWTukTypeSame[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame08(mvaaritmttkgkkykkjmaesame3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame08(mvaAriWSame3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame08(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka08(mvaAriWSameYenDaka3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun08(mvaAriWSameYenKijyun3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu08(mvaAriWSameYenYasu3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka08(mvaariumsameyendaka3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun08(mvaariumsameyenkijyun3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu08(mvaariumsameyenyasu3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown08(mvaAriWTukTypeDown[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown08(mvaaritmttkgkkykkjmaedown3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown08(mvaAriWDown3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown08(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka08(mvaAriWDownYenDaka3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun08(mvaAriWDownYenKijyun3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu08(mvaAriWDownYenYasu3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka08(mvaariumdownyendaka3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun08(mvaariumdownyenkijyun3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu08(mvaariumdownyenyasu3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype08(mvaAriVTukType[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv08(mvaAriV3[7]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake108(tutmttknutiwake13[7]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake208(tutmttknutiwake23[7]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[8])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym09(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[8] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu09(sisuuupritu3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu09(tmttknzoukaritu3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup09(mvaAriWTukTypeUp[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup09(mvaaritmttkgkkykkjmaeup3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup09(mvaAriWUp3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup09(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka09(mvaAriWUpYenDaka3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun09(mvaAriWUpYenKijyun3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu09(mvaAriWUpYenYasu3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka09(mvaariwumupyendaka3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun09(mvaariumupyenkijyun3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu09(mvaariumupyenyasu3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame09(mvaAriWTukTypeSame[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame09(mvaaritmttkgkkykkjmaesame3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame09(mvaAriWSame3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame09(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka09(mvaAriWSameYenDaka3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun09(mvaAriWSameYenKijyun3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu09(mvaAriWSameYenYasu3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka09(mvaariumsameyendaka3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun09(mvaariumsameyenkijyun3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu09(mvaariumsameyenyasu3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown09(mvaAriWTukTypeDown[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown09(mvaaritmttkgkkykkjmaedown3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown09(mvaAriWDown3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown09(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka09(mvaAriWDownYenDaka3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun09(mvaAriWDownYenKijyun3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu09(mvaAriWDownYenYasu3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka09(mvaariumdownyendaka3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun09(mvaariumdownyenkijyun3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu09(mvaariumdownyenyasu3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype09(mvaAriVTukType[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv09(mvaAriV3[8]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake109(tutmttknutiwake13[8]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake209(tutmttknutiwake23[8]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[9])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym10(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[9] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaarisisuuupritu10(sisuuupritu3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknzkritu10(tmttknzoukaritu3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup10(mvaAriWTukTypeUp[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmup10(mvaaritmttkgkkykkjmaeup3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup10(mvaAriWUp3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup10(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka10(mvaAriWUpYenDaka3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun10(mvaAriWUpYenKijyun3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu10(mvaAriWUpYenYasu3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka10(mvaariwumupyendaka3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun10(mvaariumupyenkijyun3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu10(mvaariumupyenyasu3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame10(mvaAriWTukTypeSame[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame10(mvaaritmttkgkkykkjmaesame3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame10(mvaAriWSame3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame10(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka10(mvaAriWSameYenDaka3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun10(mvaAriWSameYenKijyun3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu10(mvaAriWSameYenYasu3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka10(mvaariumsameyendaka3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun10(mvaariumsameyenkijyun3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu10(mvaariumsameyenyasu3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown10(mvaAriWTukTypeDown[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown10(mvaaritmttkgkkykkjmaedown3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown10(mvaAriWDown3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown10(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka10(mvaAriWDownYenDaka3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun10(mvaAriWDownYenKijyun3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu10(mvaAriWDownYenYasu3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka10(mvaariumdownyendaka3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun10(mvaariumdownyenkijyun3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu10(mvaariumdownyenyasu3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype10(mvaAriVTukType[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv10(mvaAriV3[9]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake110(tutmttknutiwake13[9]);
            pSaihakkouSyoukenSuiiTy.setZtyptmttkngkutiwake210(tutmttknutiwake23[9]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[10])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym11(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[10] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup11(mvaAriWTukTypeUp[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup11(mvaAriWUp3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup11(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka11(mvaAriWUpYenDaka3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun11(mvaAriWUpYenKijyun3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu11(mvaAriWUpYenYasu3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka11(mvaariwumupyendaka3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun11(mvaariumupyenkijyun3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu11(mvaariumupyenyasu3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame11(mvaAriWTukTypeSame[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame11(mvaAriWSame3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame11(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka11(mvaAriWSameYenDaka3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun11(mvaAriWSameYenKijyun3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu11(mvaAriWSameYenYasu3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka11(mvaariumsameyendaka3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun11(mvaariumsameyenkijyun3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu11(mvaariumsameyenyasu3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown11(mvaAriWTukTypeDown[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown11(mvaAriWDown3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown11(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka11(mvaAriWDownYenDaka3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun11(mvaAriWDownYenKijyun3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu11(mvaAriWDownYenYasu3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka11(mvaariumdownyendaka3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun11(mvaariumdownyenkijyun3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu11(mvaariumdownyenyasu3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype11(mvaAriVTukType[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv11(mvaAriV3[10]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[11])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym12(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[11] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup12(mvaAriWTukTypeUp[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup12(mvaAriWUp3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup12(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka12(mvaAriWUpYenDaka3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun12(mvaAriWUpYenKijyun3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu12(mvaAriWUpYenYasu3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka12(mvaariwumupyendaka3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun12(mvaariumupyenkijyun3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu12(mvaariumupyenyasu3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame12(mvaAriWTukTypeSame[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame12(mvaAriWSame3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame12(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka12(mvaAriWSameYenDaka3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun12(mvaAriWSameYenKijyun3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu12(mvaAriWSameYenYasu3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka12(mvaariumsameyendaka3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun12(mvaariumsameyenkijyun3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu12(mvaariumsameyenyasu3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown12(mvaAriWTukTypeDown[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown12(mvaAriWDown3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown12(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka12(mvaAriWDownYenDaka3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun12(mvaAriWDownYenKijyun3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu12(mvaAriWDownYenYasu3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka12(mvaariumdownyendaka3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun12(mvaariumdownyenkijyun3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu12(mvaariumdownyenyasu3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype12(mvaAriVTukType[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv12(mvaAriV3[11]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[12])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym13(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[12] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup13(mvaAriWTukTypeUp[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup13(mvaAriWUp3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup13(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka13(mvaAriWUpYenDaka3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun13(mvaAriWUpYenKijyun3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu13(mvaAriWUpYenYasu3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka13(mvaariwumupyendaka3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun13(mvaariumupyenkijyun3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu13(mvaariumupyenyasu3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame13(mvaAriWTukTypeSame[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame13(mvaAriWSame3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame13(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka13(mvaAriWSameYenDaka3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun13(mvaAriWSameYenKijyun3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu13(mvaAriWSameYenYasu3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka13(mvaariumsameyendaka3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun13(mvaariumsameyenkijyun3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu13(mvaariumsameyenyasu3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown13(mvaAriWTukTypeDown[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown13(mvaAriWDown3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown13(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka13(mvaAriWDownYenDaka3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun13(mvaAriWDownYenKijyun3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu13(mvaAriWDownYenYasu3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka13(mvaariumdownyendaka3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun13(mvaariumdownyenkijyun3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu13(mvaariumdownyenyasu3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype13(mvaAriVTukType[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv13(mvaAriV3[12]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[13])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym14(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[13] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup14(mvaAriWTukTypeUp[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup14(mvaAriWUp3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup14(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka14(mvaAriWUpYenDaka3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun14(mvaAriWUpYenKijyun3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu14(mvaAriWUpYenYasu3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka14(mvaariwumupyendaka3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun14(mvaariumupyenkijyun3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu14(mvaariumupyenyasu3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame14(mvaAriWTukTypeSame[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame14(mvaAriWSame3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame14(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka14(mvaAriWSameYenDaka3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun14(mvaAriWSameYenKijyun3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu14(mvaAriWSameYenYasu3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka14(mvaariumsameyendaka3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun14(mvaariumsameyenkijyun3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu14(mvaariumsameyenyasu3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown14(mvaAriWTukTypeDown[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown14(mvaAriWDown3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown14(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka14(mvaAriWDownYenDaka3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun14(mvaAriWDownYenKijyun3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu14(mvaAriWDownYenYasu3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka14(mvaariumdownyendaka3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun14(mvaariumdownyenkijyun3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu14(mvaariumdownyenyasu3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype14(mvaAriVTukType[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv14(mvaAriV3[13]);
        }

        if (!BizUtil.isBlank(mvaAriNenOuTouYm[14])) {
            pSaihakkouSyoukenSuiiTy.setZtymvaarinenoutouym15(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaAriNenOuTouYm[14] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypeup15(mvaAriWTukTypeUp[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwup15(mvaAriWUp3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypeup15(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyendaka15(mvaAriWUpYenDaka3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenkijyun15(mvaAriWUpYenKijyun3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwupyenyasu15(mvaAriWUpYenYasu3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwumupyendaka15(mvaariwumupyendaka3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenkijyun15(mvaariumupyenkijyun3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumupyenyasu15(mvaariumupyenyasu3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypesame15(mvaAriWTukTypeSame[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsame15(mvaAriWSame3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypesame15(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyendaka15(mvaAriWSameYenDaka3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenkijyun15(mvaAriWSameYenKijyun3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwsameyenyasu15(mvaAriWSameYenYasu3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyendaka15(mvaariumsameyendaka3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenkijyun15(mvaariumsameyenkijyun3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumsameyenyasu15(mvaariumsameyenyasu3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwtuktypedown15(mvaAriWTukTypeDown[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdown15(mvaAriWDown3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwyentuktypedown15(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyendaka15(mvaAriWDownYenDaka3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenkijyun15(mvaAriWDownYenKijyun3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariwdownyenyasu15(mvaAriWDownYenYasu3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyendaka15(mvaariumdownyendaka3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenkijyun15(mvaariumdownyenkijyun3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariumdownyenyasu15(mvaariumdownyenyasu3[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaarivtuktype15(mvaAriVTukType[14]);
            pSaihakkouSyoukenSuiiTy.setZtymvaariv15(mvaAriV3[14]);
        }
    }


    private void editSaihakkouHokensyoukenSuiiTyPattern3_3(
        IT_HokenSyouken pHokenSyouken,
        ZT_SaihakkouSyoukenSuiiTy pSaihakkouSyoukenSuiiTy) {

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[0])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn01(mvaNoneKaisiInnUmuKbn[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym01(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[0] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype01(mvaNoneWTukType[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew01(mvaNoneW3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype01(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka01(mvaNoneWYenSameYenDaka3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun01(mvaNoneWYenSameYenKijyun3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu01(mvaNoneWYenSameYenYasu3[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka01(mvanoneumyendaka[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun01(mvanoneumyenkijyun[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu01(mvanoneumyenyasu[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype01(mvaNoneVTukType[0]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev01(mvaNoneY3[0]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[1])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn02(mvaNoneKaisiInnUmuKbn[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym02(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[1] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype02(mvaNoneWTukType[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew02(mvaNoneW3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype02(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka02(mvaNoneWYenSameYenDaka3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun02(mvaNoneWYenSameYenKijyun3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu02(mvaNoneWYenSameYenYasu3[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka02(mvanoneumyendaka[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun02(mvanoneumyenkijyun[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu02(mvanoneumyenyasu[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype02(mvaNoneVTukType[1]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev02(mvaNoneY3[1]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[2])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn03(mvaNoneKaisiInnUmuKbn[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym03(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[2] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype03(mvaNoneWTukType[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew03(mvaNoneW3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype03(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka03(mvaNoneWYenSameYenDaka3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun03(mvaNoneWYenSameYenKijyun3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu03(mvaNoneWYenSameYenYasu3[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka03(mvanoneumyendaka[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun03(mvanoneumyenkijyun[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu03(mvanoneumyenyasu[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype03(mvaNoneVTukType[2]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev03(mvaNoneY3[2]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[3])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn04(mvaNoneKaisiInnUmuKbn[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym04(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[3] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype04(mvaNoneWTukType[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew04(mvaNoneW3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype04(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka04(mvaNoneWYenSameYenDaka3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun04(mvaNoneWYenSameYenKijyun3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu04(mvaNoneWYenSameYenYasu3[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka04(mvanoneumyendaka[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun04(mvanoneumyenkijyun[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu04(mvanoneumyenyasu[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype04(mvaNoneVTukType[3]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev04(mvaNoneY3[3]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[4])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn05(mvaNoneKaisiInnUmuKbn[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym05(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[4] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype05(mvaNoneWTukType[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew05(mvaNoneW3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype05(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka05(mvaNoneWYenSameYenDaka3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun05(mvaNoneWYenSameYenKijyun3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu05(mvaNoneWYenSameYenYasu3[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka05(mvanoneumyendaka[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun05(mvanoneumyenkijyun[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu05(mvanoneumyenyasu[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype05(mvaNoneVTukType[4]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev05(mvaNoneY3[4]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[5])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn06(mvaNoneKaisiInnUmuKbn[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym06(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[5] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype06(mvaNoneWTukType[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew06(mvaNoneW3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype06(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka06(mvaNoneWYenSameYenDaka3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun06(mvaNoneWYenSameYenKijyun3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu06(mvaNoneWYenSameYenYasu3[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka06(mvanoneumyendaka[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun06(mvanoneumyenkijyun[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu06(mvanoneumyenyasu[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype06(mvaNoneVTukType[5]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev06(mvaNoneY3[5]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[6])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn07(mvaNoneKaisiInnUmuKbn[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym07(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[6] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype07(mvaNoneWTukType[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew07(mvaNoneW3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype07(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka07(mvaNoneWYenSameYenDaka3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun07(mvaNoneWYenSameYenKijyun3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu07(mvaNoneWYenSameYenYasu3[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka07(mvanoneumyendaka[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun07(mvanoneumyenkijyun[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu07(mvanoneumyenyasu[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype07(mvaNoneVTukType[6]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev07(mvaNoneY3[6]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[7])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn08(mvaNoneKaisiInnUmuKbn[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym08(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[7] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype08(mvaNoneWTukType[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew08(mvaNoneW3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype08(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka08(mvaNoneWYenSameYenDaka3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun08(mvaNoneWYenSameYenKijyun3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu08(mvaNoneWYenSameYenYasu3[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka08(mvanoneumyendaka[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun08(mvanoneumyenkijyun[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu08(mvanoneumyenyasu[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype08(mvaNoneVTukType[7]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev08(mvaNoneY3[7]);
        }
        if (!BizUtil.isBlank(mvaNoneNenOutouYm[8])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn09(mvaNoneKaisiInnUmuKbn[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym09(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[8] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype09(mvaNoneWTukType[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew09(mvaNoneW3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype09(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka09(mvaNoneWYenSameYenDaka3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun09(mvaNoneWYenSameYenKijyun3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu09(mvaNoneWYenSameYenYasu3[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka09(mvanoneumyendaka[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun09(mvanoneumyenkijyun[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu09(mvanoneumyenyasu[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype09(mvaNoneVTukType[8]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev09(mvaNoneY3[8]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[9])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn10(mvaNoneKaisiInnUmuKbn[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym10(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[9] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype10(mvaNoneWTukType[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew10(mvaNoneW3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype10(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka10(mvaNoneWYenSameYenDaka3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun10(mvaNoneWYenSameYenKijyun3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu10(mvaNoneWYenSameYenYasu3[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka10(mvanoneumyendaka[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun10(mvanoneumyenkijyun[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu10(mvanoneumyenyasu[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype10(mvaNoneVTukType[9]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev10(mvaNoneY3[9]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[10])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn11(mvaNoneKaisiInnUmuKbn[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym11(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[10] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype11(mvaNoneWTukType[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew11(mvaNoneW3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype11(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka11(mvaNoneWYenSameYenDaka3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun11(mvaNoneWYenSameYenKijyun3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu11(mvaNoneWYenSameYenYasu3[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka11(mvanoneumyendaka[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun11(mvanoneumyenkijyun[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu11(mvanoneumyenyasu[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype11(mvaNoneVTukType[10]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev11(mvaNoneY3[10]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[11])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn12(mvaNoneKaisiInnUmuKbn[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym12(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[11] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype12(mvaNoneWTukType[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew12(mvaNoneW3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype12(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka12(mvaNoneWYenSameYenDaka3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun12(mvaNoneWYenSameYenKijyun3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu12(mvaNoneWYenSameYenYasu3[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka12(mvanoneumyendaka[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun12(mvanoneumyenkijyun[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu12(mvanoneumyenyasu[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype12(mvaNoneVTukType[11]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev12(mvaNoneY3[11]);
        }

        if (!BizUtil.isBlank(mvaNoneNenOutouYm[12])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn13(mvaNoneKaisiInnUmuKbn[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym13(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[12] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype13(mvaNoneWTukType[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew13(mvaNoneW3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype13(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka13(mvaNoneWYenSameYenDaka3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun13(mvaNoneWYenSameYenKijyun3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu13(mvaNoneWYenSameYenYasu3[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka13(mvanoneumyendaka[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun13(mvanoneumyenkijyun[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu13(mvanoneumyenyasu[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype13(mvaNoneVTukType[12]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev13(mvaNoneY3[12]);
        }
        if (!BizUtil.isBlank(mvaNoneNenOutouYm[13])) {
            pSaihakkouSyoukenSuiiTy.setZtymvanonekaisiinnumukbn14(mvaNoneKaisiInnUmuKbn[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonenenoutouym14(FixedDateFormatter.formatYMZenkakuSeirekiKanji(BizDate.valueOf(mvaNoneNenOutouYm[13] + "01")));
            pSaihakkouSyoukenSuiiTy.setZtymvanonewtuktype14(mvaNoneWTukType[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonew14(mvaNoneW3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyentuktype14(C_Tuukasyu.JPY.toString());
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyendaka14(mvaNoneWYenSameYenDaka3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenkijyun14(mvaNoneWYenSameYenKijyun3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonewyenyasu14(mvaNoneWYenSameYenYasu3[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyendaka14(mvanoneumyendaka[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenkijyun14(mvanoneumyenkijyun[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanoneumyenyasu14(mvanoneumyenyasu[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonevtuktype14(mvaNoneVTukType[13]);
            pSaihakkouSyoukenSuiiTy.setZtymvanonev14(mvaNoneY3[13]);
        }

        pSaihakkouSyoukenSuiiTy.setZtywmsgcd1(pHokenSyouken.getWmsgcd1());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd2(pHokenSyouken.getWmsgcd2());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd3(pHokenSyouken.getWmsgcd3());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd21(pHokenSyouken.getWmsgcd21());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd22(pHokenSyouken.getWmsgcd22());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd23(pHokenSyouken.getWmsgcd23());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd31(pHokenSyouken.getWmsgcd31());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd32(pHokenSyouken.getWmsgcd32());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcd33(pHokenSyouken.getWmsgcd33());
        pSaihakkouSyoukenSuiiTy.setZtywmsgcdst1(pHokenSyouken.getWmsgcdst1());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd1(pHokenSyouken.getWtyuuijikoumsgcd1());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd2(pHokenSyouken.getWtyuuijikoumsgcd2());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd3(pHokenSyouken.getWtyuuijikoumsgcd3());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd4(pHokenSyouken.getWtyuuijikoumsgcd4());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd5(pHokenSyouken.getWtyuuijikoumsgcd5());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd6(pHokenSyouken.getWtyuuijikoumsgcd6());
        pSaihakkouSyoukenSuiiTy.setZtywtyuuimsgcd7(pHokenSyouken.getWtyuuijikoumsgcd7());
        pSaihakkouSyoukenSuiiTy.setZtywitjbrptuuktype(String.valueOf(pHokenSyouken.getWitijibrptuktype()));
        pSaihakkouSyoukenSuiiTy.setZtywitjbrp(witijibrp);
        pSaihakkouSyoukenSuiiTy.setZtywyenhrikmgktuuktype(String.valueOf(pHokenSyouken.getWyenhrkgktuktype()));
        pSaihakkouSyoukenSuiiTy.setZtywyenhrikmgk(String.valueOf(pHokenSyouken.getWyenhrkgk()));
        pSaihakkouSyoukenSuiiTy.setZtywyenitjbrptuuktype(String.valueOf(pHokenSyouken.getWyenitijibrptuktype()));
        pSaihakkouSyoukenSuiiTy.setZtywyenitjbrp(String.valueOf(pHokenSyouken.getWyenitijibrp()));
        pSaihakkouSyoukenSuiiTy.setZtywsjkkktyouseitkyuym(wsjkkktyouseitkyuym);
    }

    private void editSaihakkouHokensyoukenSuii2TyPattern4 (
        IT_Suiihyou pSuiihyou,
        ZT_SaihakkouSyoukenSuii2Ty pSaihakkouHokensyoukenSuii2Ty,
        int pSuiihyou2Cnt) {

        pSaihakkouHokensyoukenSuii2Ty.setZtysyono(pSuiihyou.getSyono());
        pSaihakkouHokensyoukenSuii2Ty.setZtytyouhyouymd(pSuiihyou.getTyouhyouymd().toString());
        pSaihakkouHokensyoukenSuii2Ty.setZtysuiihyouptn(String.valueOf(suiihyouPattern4));
        pSaihakkouHokensyoukenSuii2Ty.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        pSaihakkouHokensyoukenSuii2Ty.setZtysuiihyousyono(pSuiihyou.getSyono());
        pSaihakkouHokensyoukenSuii2Ty.setZtyytirrtcalckijyunrrt(ConvertUtil.toZenAll(
            seisuuHanndan(pSuiihyou.getYtirrtcalckijyunrrt1().multiply(100)).toString(), 0, 0));
        pSaihakkouHokensyoukenSuii2Ty.setZtywkwsrateyendaka(yenKnsnKwsRateYenDaka);
        pSaihakkouHokensyoukenSuii2Ty.setZtywkwsrateyenkijyun(yenKnsnKwsRateYenKijyun);
        pSaihakkouHokensyoukenSuii2Ty.setZtywkwsrateyenyasu(yenKnsnKwsRateYenYasu);
        pSaihakkouHokensyoukenSuii2Ty.setZtykyktuukatype(String.valueOf(pSuiihyou.getKyktuukasyu()));

        editSaihakkouHokensyoukenSuii2Ty1(pSaihakkouHokensyoukenSuii2Ty, pSuiihyou2Cnt);

        BizPropertyInitializer.initialize(pSaihakkouHokensyoukenSuii2Ty);
    }

    private void editSaihakkouHokensyoukenSuii2TyPattern5 (
        IT_Suiihyou pSuiihyou,
        ZT_SaihakkouSyoukenSuii2Ty pSaihakkouHokensyoukenSuii2Ty,
        int pSuiihyou2Cnt) {

        pSaihakkouHokensyoukenSuii2Ty.setZtysyono(pSuiihyou.getSyono());
        pSaihakkouHokensyoukenSuii2Ty.setZtytyouhyouymd(pSuiihyou.getTyouhyouymd().toString());
        pSaihakkouHokensyoukenSuii2Ty.setZtysuiihyouptn(String.valueOf(suiihyouPattern5));
        pSaihakkouHokensyoukenSuii2Ty.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        pSaihakkouHokensyoukenSuii2Ty.setZtysuiihyousyono(pSuiihyou.getSyono());
        pSaihakkouHokensyoukenSuii2Ty.setZtyytirrtcalckijyunrrt(ConvertUtil.toZenAll(
            seisuuHanndan(pSuiihyou.getYtirrtcalckijyunrrt2().multiply(100)).toString(), 0, 0));
        pSaihakkouHokensyoukenSuii2Ty.setZtywkwsrateyendaka(yenKnsnKwsRateYenDaka);
        pSaihakkouHokensyoukenSuii2Ty.setZtywkwsrateyenkijyun(yenKnsnKwsRateYenKijyun);
        pSaihakkouHokensyoukenSuii2Ty.setZtywkwsrateyenyasu(yenKnsnKwsRateYenYasu);
        pSaihakkouHokensyoukenSuii2Ty.setZtykyktuukatype(String.valueOf(pSuiihyou.getKyktuukasyu()));

        editSaihakkouHokensyoukenSuii2Ty2(pSaihakkouHokensyoukenSuii2Ty, pSuiihyou2Cnt);

        BizPropertyInitializer.initialize(pSaihakkouHokensyoukenSuii2Ty);
    }

    private void editSaihakkouHokensyoukenSuii2Ty1(
        ZT_SaihakkouSyoukenSuii2Ty pSaihakkouHokensyoukenSuii2Ty, int pSuiihyou2Cnt) {

        for (int methodNo = 0; methodNo < pSuiihyou2Cnt; methodNo++) {

            try {
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtynenoutouym",
                    methodNo,
                    nenoutouym[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtyhrkkknmnryumukbn",
                    methodNo,
                    hrkkknmnryumukbn[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtyzennouzndkyen",
                    methodNo,
                    zennouzndkyen[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtyyenhrkgkgoukei",
                    methodNo,
                    yenhrkgkgoukei[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtykihrkmp",
                    methodNo,
                    kihrkmp[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtyw",
                    methodNo,
                    w[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtywyenyendaka",
                    methodNo,
                    wyenyendaka[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtywyenkijun",
                    methodNo,
                    wyenkijun[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtywyenyenyasu",
                    methodNo,
                    wyenyenyasu[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtyzennouzndkgaika",
                    methodNo,
                    zennouzndk1[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtykaiykuktgk",
                    methodNo,
                    uktrgk[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtykaiykuktgkyenyendaka",
                    methodNo,
                    uktrgkyenyendaka[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtykaiykuktgkyenkijun",
                    methodNo,
                    uktrgkyenkijun[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtykaiykuktgkyenyenyasu",
                    methodNo,
                    uktrgkyenyenyasu[methodNo]);

            } catch (IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException e) {
                throw new CommonBizAppException();
            }
        }
    }

    private void editSaihakkouHokensyoukenSuii2Ty2(
        ZT_SaihakkouSyoukenSuii2Ty pSaihakkouHokensyoukenSuii2Ty, int pSuiihyou2Cnt) {

        for (int methodNo = 0; methodNo < pSuiihyou2Cnt; methodNo++) {

            try {
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtynenoutouym",
                    methodNo,
                    nenoutouym[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtyhrkkknmnryumukbn",
                    methodNo,
                    hrkkknmnryumukbn[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtyzennouzndkyen",
                    methodNo,
                    zennouzndkyen2[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtyyenhrkgkgoukei",
                    methodNo,
                    yenhrkgkgoukei2[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtykihrkmp",
                    methodNo,
                    kihrkmp2[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtyw",
                    methodNo,
                    w2[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtywyenyendaka",
                    methodNo,
                    wyenyendaka2[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtywyenkijun",
                    methodNo,
                    wyenkijun2[methodNo]);
                methodNmEditAndExec(
                    ZT_SaihakkouSyoukenSuii2Ty.class,
                    pSaihakkouHokensyoukenSuii2Ty,
                    "setZtywyenyenyasu",
                    methodNo,
                    wyenyenyasu2[methodNo]);

            } catch (IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException e) {
                throw new CommonBizAppException();
            }
        }
    }

    private void calcSuiihyouPatternSuu(int pSuiihyouCnt,
        SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean pSaihakkoshokenInfo) {

        if (pSuiihyouCnt == 0) {
            IT_KykKihon kykKihon = pSaihakkoshokenInfo.getIT_HokenSyouken().getKykKihon();

            List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

            IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

            int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

            if (SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR == syohinHanteiKbn) {
                if (kykSyouhn.getYendthnkymd() == null &&
                    (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai()) ||
                        C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai()))) {
                    suiihyouPatternSuu = 3;
                }
            }

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                    suiihyouPatternSuu = 2;
                }
            }

            if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                suiihyou2PatternSuu = 2;
            }

            if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                suiihyou2PatternSuu = 1;
            }

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                hyoujirantumitateriritu2 = ConvertUtil.toZenAll(seisuuHanndan(kykSyouhn.getLoadinghnkgtumitateriritu().multiply(100)),0,0);
            }
        }
    }

    private void methodNmEditAndExec (
        Class<ZT_SaihakkouSyoukenSuii2Ty> pClass,
        ZT_SaihakkouSyoukenSuii2Ty pSaihakkouHokensyoukenSuii2Ty,
        String pMethodNm,
        int pMethodNo,
        Object pValue) throws
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException {

        String methodNo = BizUtil.num(String.valueOf(pMethodNo + 1), BizUtil.ZERO_FILL, 2);

        Method setMethod =
            pClass.getMethod(pMethodNm + methodNo, pValue.getClass());
        setMethod.invoke(pSaihakkouHokensyoukenSuii2Ty, pValue);
    }

    private String seisuuHanndan(BizNumber pHenkanTaisyou) {

        if (pHenkanTaisyou.compareTo(BizNumber.TEN) < 0) {

            return BizUtil.zeroNum(String.valueOf(pHenkanTaisyou),1, 2);
        }
        return BizUtil.zeroNum(String.valueOf(pHenkanTaisyou),2, 2);
    }
}
