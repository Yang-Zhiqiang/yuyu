package yuyu.batch.hozen.khinterf.khtyouhyousinsyouken;

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
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KeisanTargetMokuhyougk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kykjyoutai;
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
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.def.db.entity.ZT_SinkeiyakuHokensyoukenTy;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuii2Ty;
import yuyu.def.db.entity.ZT_SinkeiyakuSyoukenSuiiTy;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス 新契約保険証券Ｆ作成
 */
public class KhTyouhyouSinSyoukenBatch implements Batch {

    private final String TABLE_ID = "IT_HokenSyouken";

    private final String FILTER_KBN_ID = "Kh001";

    private final String SUIIHYOU_PTN1 = "1";

    private final String SUIIHYOU_PTN2 = "2";

    private final String SUIIHYOU_PTN3 = "3";

    private final String SUIIHYOU_PTN4 = "4";

    private final String SUIIHYOU_PTN5 = "5";

    private final String SISUUUPRITU_PTN1 = "５．００";

    private final String SISUUUPRITU_PTN2 = "５．００";

    private final String SISUUUPRITU_PTN3 = "１０．００";

    private final String SUIIHYOUSYUBETU_SYSN2 = "10";

    private final String TEL_MITOUROKU = "未登録";

    private String kyknmkj = "";

    private String hhknnmkj = "";

    private String shsnmkj = "";

    private String hosyounyhihknsyameikanji = "";

    private String koujyosyoumeikyknmkj = "";

    private String hrkkknmnrykeikanensuu = "";

    private String hrkkknmnrynen = "";

    private String hokenryouGk = "";

    private String znntikiktbrihrkGk = "";

    private String syukykTkykHknknGk1 = "";

    private String syukykTkykHknknGk2 = "";

    private String syukykTkykHknknGk3 = "";

    private String syukykTkykHknknGk4 = "";

    private String syukykTkykHknknGk5 = "";

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

    private String fstphrkpkngkkei = "";

    private String fstpznnkngk = "";

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

    private String yoteiRiritu = "";

    private String sonotanytumitateriritu = "";

    private String sonotanytumitateriritu2 = "";

    private String sonotanytmttknzkrtjygn = "";

    private String sonotanyransetteibairitu = "";

    private String dai1sKwsRateYenDaka = "";

    private String dai1sKwsRateYenKijyun = "";

    private String dai1sKwsRateYenyasu = "";

    private String sonotaNyranmKhwaRiai = "";

    private String sonotanyranmkhgk = "";

    private String sonotanyranenkhrikmrate = "";

    private String sonotanyranstigikwsrate = "";

    private String sonotanyransjkkktusirrt = "";

    private String mkhyouysysnikcurrentgk = "";

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

    private String yenknsnkwsrateyendaka2 = "";

    private String yenknsnkwsrateyenkijyun2 = "";

    private String yenknsnkwsrateyenyasu2 = "";

    private String yenknsnkwsrateyendaka3 = "";

    private String yenknsnkwsrateyenkijyun3 = "";

    private String yenknsnkwsrateyenyasu3 = "";

    private String sjkkktusirrtup2 = "";

    private String sjkkktusirrtsame2 = "";

    private String sjkkktusirrtdown2 = "";

    private String sjkkktusirrthendouup2 = "";

    private String sjkkktusirrthendoudown2 = "";

    private String sjkkktusirrtup3 = "";

    private String sjkkktusirrtsame3 = "";

    private String sjkkktusirrtdown3 = "";

    private String sjkkktusirrthendouup3 = "";

    private String sjkkktusirrthendoudown3 = "";

    private String koujyoSymHknKkn = "";

    private String koujyoSyoumeiHrkHuhu = "";

    private String newHknjytuKikan = "";

    private String ippanSymGkNasiHyouji = "";

    private String kaigoIryouSmGknaHyj = "";

    private String nenIppanSymGknasiHyouji = "";

    private String nenIryouSymGkNasiHyouji = "";

    private String[] mvaarikeikanensuu = new String[15];

    private String[] mvaariwtuktypeup = new String[15];

    private String[] mvaariwupyendaka = new String[15];

    private String[] mvaariwupyenkijyun = new String[15];

    private String[] mvaariwupyenyasu = new String[15];

    private String[] mvaariwumupyendaka = new String[15];

    private String[] mvaariumupyenkijyun = new String[15];

    private String[] mvaariumupyenyasu = new String[15];

    private String[] mvaariwtuktypesame = new String[15];

    private String[] mvaariwsameyendaka = new String[15];

    private String[] mvaariwsameyenkijyun = new String[15];

    private String[] mvaariwsameyenyasu = new String[15];

    private String[] mvaariumsameyendaka = new String[15];

    private String[] mvaariumsameyenkijyun = new String[15];

    private String[] mvaariumsameyenyasu = new String[15];

    private String[] mvaariwtuktypedown = new String[15];

    private String[] mvaariwdownyendaka = new String[15];

    private String[] mvaariwdownyenkijyun = new String[15];

    private String[] mvaariwdownyenyasu = new String[15];

    private String[] mvaariumdownyendaka = new String[15];

    private String[] mvaariumdownyenkijyun = new String[15];

    private String[] mvaariumdownyenyasu = new String[15];

    private String[] sisuuupritu = new String[15];

    private String[] tmttknzoukaritu = new String[15];

    private String[] mvaariwupyendaka2 = new String[15];

    private String[] mvaariwupyenkijyun2 = new String[15];

    private String[] mvaariwupyenyasu2 = new String[15];

    private String[] mvaariwumupyendaka2 = new String[15];

    private String[] mvaariumupyenkijyun2 = new String[15];

    private String[] mvaariumupyenyasu2 = new String[15];

    private String[] mvaariwsameyendaka2 = new String[15];

    private String[] mvaariwsameyenkijyun2 = new String[15];

    private String[] mvaariwsameyenyasu2 = new String[15];

    private String[] mvaariumsameyendaka2 = new String[15];

    private String[] mvaariumsameyenkijyun2 = new String[15];

    private String[] mvaariumsameyenyasu2 = new String[15];

    private String[] mvaariwdownyendaka2 = new String[15];

    private String[] mvaariwdownyenkijyun2 = new String[15];

    private String[] mvaariwdownyenyasu2 = new String[15];

    private String[] mvaariumdownyendaka2 = new String[15];

    private String[] mvaariumdownyenkijyun2 = new String[15];

    private String[] mvaariumdownyenyasu2 = new String[15];

    private String[] sisuuupritu2 = new String[15];

    private String[] tmttknzoukaritu2 = new String[15];

    private String[] mvaariwupyendaka3 = new String[15];

    private String[] mvaariwupyenkijyun3 = new String[15];

    private String[] mvaariwupyenyasu3 = new String[15];

    private String[] mvaariwumupyendaka3 = new String[15];

    private String[] mvaariumupyenkijyun3 = new String[15];

    private String[] mvaariumupyenyasu3 = new String[15];

    private String[] mvaariwsameyendaka3 = new String[15];

    private String[] mvaariwsameyenkijyun3 = new String[15];

    private String[] mvaariwsameyenyasu3 = new String[15];

    private String[] mvaariumsameyendaka3 = new String[15];

    private String[] mvaariumsameyenkijyun3 = new String[15];

    private String[] mvaariumsameyenyasu3 = new String[15];

    private String[] mvaariwdownyendaka3 = new String[15];

    private String[] mvaariwdownyenkijyun3 = new String[15];

    private String[] mvaariwdownyenyasu3 = new String[15];

    private String[] mvaariumdownyendaka3 = new String[15];

    private String[] mvaariumdownyenkijyun3 = new String[15];

    private String[] mvaariumdownyenyasu3 = new String[15];

    private String[] sisuuupritu3 = new String[15];

    private String[] tmttknzoukaritu3 = new String[15];

    private String[] mvaarivtuktype = new String[15];

    private String[] mvaariwup = new String[15];

    private String[] mvaariwsame = new String[15];

    private String[] mvaariwdown = new String[15];

    private String[] mvaariv = new String[15];

    private String[] mvaaritmttkgkkykkjmaeup = new String[15];

    private String[] mvaaritmttkgkkykkjmaesame = new String[15];

    private String[] mvaaritmttkgkkykkjmaedown = new String[15];

    private String[] tutmttknutiwake1 = new String[15];

    private String[] tutmttknutiwake2 = new String[15];


    private String[] mvaariwup2 = new String[15];

    private String[] mvaariwsame2 = new String[15];

    private String[] mvaariwdown2 = new String[15];

    private String[] mvaariv2 = new String[15];

    private String[] mvaaritmttkgkkykkjmaeup2 = new String[15];

    private String[] mvaaritmttkgkkykkjmaesame2 = new String[15];

    private String[] mvaaritmttkgkkykkjmaedown2 = new String[15];

    private String[] tutmttknutiwake12 = new String[15];

    private String[] tutmttknutiwake22 = new String[15];


    private String[] mvaariwup3 = new String[15];

    private String[] mvaariwsame3 = new String[15];

    private String[] mvaariwdown3 = new String[15];

    private String[] mvaariv3 = new String[15];

    private String[] mvaaritmttkgkkykkjmaeup3 = new String[15];

    private String[] mvaaritmttkgkkykkjmaesame3 = new String[15];

    private String[] mvaaritmttkgkkykkjmaedown3 = new String[15];

    private String[] tutmttknutiwake13 = new String[15];

    private String[] tutmttknutiwake23 = new String[15];

    private String[] mvanonekaisiinnumukbn = new String[11];

    private String[] mvanonekeikanensuu = new String[11];

    private String[] mvanonewtuktype = new String[11];

    private String[] mvanonewyendaka = new String[11];

    private String[] mvanonewyenkijyun = new String[11];

    private String[] mvanonewyenyasu = new String[11];

    private String[] mvanoneumyendaka = new String[11];

    private String[] mvanoneumyenkijyun = new String[11];

    private String[] mvanoneumyenyasu = new String[11];

    private String[] mvanonewyendaka2 = new String[11];

    private String[] mvanonewyenkijyun2 = new String[11];

    private String[] mvanonewyenyasu2 = new String[11];

    private String[] mvanonewyendaka3 = new String[11];

    private String[] mvanonewyenkijyun3 = new String[11];

    private String[] mvanonewyenyasu3 = new String[11];

    private String[] mvaNoneVTukType = new String[11];

    private String[] mvaNoneW = new String[11];

    private String[] mvaNoneY = new String[11];

    private String[] mvaNoneW2 = new String[11];

    private String[] mvaNoneY2 = new String[11];

    private String[] mvaNoneW3 = new String[11];

    private String[] mvaNoneY3 = new String[11];

    private String[] keikanensuus = new String[22];

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

    private int suiihyouPtnCnt = 0;

    private int suiihyou2PtnCnt = 0;

    private boolean hrkkknmnryuFlg = false;

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
        int hokenSyoukenInfoCnt = 0;
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
        IT_KoujyoSym koujyoSym = null;
        ZT_SinkeiyakuHokensyoukenTy sinkeiyakuHokensyoukenTy = null;
        ZT_SinkeiyakuSyoukenSuiiTy sinkeiyakuSyoukenSuiiTy = null;
        ZT_SinkeiyakuSyoukenSuii2Ty sinkeiyakuSyoukenSuii2Ty = null;

        try (ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> sinkeiyakuhokenshokenInfoList =
            hozenDomManager.getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(ibKakutyoujobcd, syoriYmd);

            MultipleEntityInserter multipleEntityInserter = new MultipleEntityInserter();

            ) {

            for (SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean
                sinkeiyakuhokenshokenInfo : sinkeiyakuhokenshokenInfoList) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_KBN_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(
                    sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(
                    sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getSyono());

                calcSuiihyouPatternSuu(suiihyouCnt, sinkeiyakuhokenshokenInfo);

                if (!BizUtil.isBlank(keySyouKenSyono)
                    && !keySyouKenSyono.equals(sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getSyono())) {
                    sinkeiyakuHokensyoukenTy = editSinkeiyakuHokensyoukenTy(hokenSyouken);
                    multipleEntityInserter.add(sinkeiyakuHokensyoukenTy);

                    sinkeiyakuSyoukenSuiiTy = editSinkeiyakuSyoukenSuiiTy(hokenSyouken,suiihyou,koujyoSym);
                    multipleEntityInserter.add(sinkeiyakuSyoukenSuiiTy);

                    if (suiihyouPtnCnt == 3) {
                        sinkeiyakuSyoukenSuiiTy = editSinkeiyakuSyoukenSuiiTy2(hokenSyouken,suiihyou,koujyoSym);
                        multipleEntityInserter.add(sinkeiyakuSyoukenSuiiTy);
                        sinkeiyakuSyoukenSuiiTy = editSinkeiyakuSyoukenSuiiTy3(hokenSyouken,suiihyou,koujyoSym);
                        multipleEntityInserter.add(sinkeiyakuSyoukenSuiiTy);
                        suiihyouPtnCnt = 0;
                    }

                    if (suiihyouPtnCnt == 2) {
                        sinkeiyakuSyoukenSuiiTy = editSinkeiyakuSyoukenSuiiTy2(hokenSyouken,suiihyou,koujyoSym);
                        multipleEntityInserter.add(sinkeiyakuSyoukenSuiiTy);
                        suiihyouPtnCnt = 0;
                    }

                    if (suiihyou2PtnCnt == 2) {

                        sinkeiyakuSyoukenSuii2Ty = editSinkeiyakuSyoukenSuii2Ty(suiihyou, suiihyou2Cnt);
                        multipleEntityInserter.add(sinkeiyakuSyoukenSuii2Ty);
                        sinkeiyakuSyoukenSuii2Ty = editSinkeiyakuSyoukenSuii2Ty2(suiihyou, suiihyou2Cnt);
                        multipleEntityInserter.add(sinkeiyakuSyoukenSuii2Ty);
                        suiihyou2PtnCnt = 0;
                        suiihyou2Cnt = 0;
                        hrkkknmnryuFlg = false;
                    }

                    if (suiihyou2PtnCnt == 1) {

                        sinkeiyakuSyoukenSuii2Ty = editSinkeiyakuSyoukenSuii2Ty(suiihyou, suiihyou2Cnt);
                        multipleEntityInserter.add(sinkeiyakuSyoukenSuii2Ty);
                        suiihyou2PtnCnt = 0;
                        suiihyou2Cnt = 0;
                        hrkkknmnryuFlg = false;
                    }

                    suiihyouCnt = 0;
                    mvaariCnt = 0;
                    mvanoneCnt = 0;
                    sinKeiyakuHokenSyoukenCnt++;
                    targetTokuyakuMkhgk = BizCurrency.valueOf(0);
                    sonotanyranmkhgk = "";
                    mkhyouysysnikcurrentgk = "";

                    calcSuiihyouPatternSuu(suiihyouCnt, sinkeiyakuhokenshokenInfo);
                }

                if (BizUtil.isBlank(keySyouKenSyono)
                    || !keySyouKenSyono.equals(sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getSyono())) {

                    IT_KykSonotaTkyk kykSonotaTkyk = sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getKykKihon()
                        .getKykSonotaTkyk();

                    if (kykSonotaTkyk.getTargettkmokuhyouti() > 0) {

                        KeisanTargetMokuhyougk keisanTargetMokuhyougk = SWAKInjector
                            .getInstance(KeisanTargetMokuhyougk.class);
                        targetTokuyakuMkhgk = keisanTargetMokuhyougk.exec(kykSonotaTkyk.getTargettkykkijyungk(),
                            kykSonotaTkyk.getTargettkmokuhyouti());
                        sonotanyranmkhgk = String.valueOf(keisanTargetMokuhyougk.exec(
                            sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getSonotanyranpenknsngk(),
                            kykSonotaTkyk.getTargettkmokuhyouti()));
                        mkhyouysysnikcurrentgk = String.valueOf(targetTokuyakuMkhgk);
                    }
                }

                if (C_UmuKbn.ARI.eq(sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getKoujyosyoumeiumukbn())) {
                    IT_KykKihon kykKihon =
                        hozenDomManager.getKykKihon(sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getSyono());

                    kykKihon = IT_KykKihonDetacher.detachKoujyoSymtouched(kykKihon);

                    koujyoSym = kykKihon.getKoujyoSymByNnendoTyouhyouymdRennoEq(
                        String.valueOf(sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getKykymd().getYear()),
                        sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getTyouhyouymd());

                    if (koujyoSym == null) {
                        throw new CommonBizAppException(
                            "控除証明書TBLにデータが存在しません。"
                                + "証券番号："
                                + sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getSyono()
                                + "　年度："
                                + sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getKykymd().getYear()
                                + "　帳票作成日："
                                + sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getTyouhyouymd().toString()
                                + "　連番：1");
                    }
                }

                keySyouKenSyono = sinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getSyono();
                keiKanenSuu = sinkeiyakuhokenshokenInfo.getKeikanensuu();
                suiihyou = iT_SuiihyouDao.getSuiihyou(keySyouKenSyono, syoriYmd, keiKanenSuu);

                if (suiihyouCnt == 0) {
                    initMemberVarible();

                    hokenSyouken = sinkeiyakuhokenshokenInfo.getIT_HokenSyouken();
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

                        syukykTkykHknknGk5 = hokenSyouken.getSyukyktkykhknkngk5().toString();
                    }

                    else {

                        syukykTkykHknknGk5 = hokenSyouken.getSyukyktkykhknkngk5().multiply(100).toString();
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

                    if (suiihyou2PtnCnt > 0) {

                        if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype())) {

                            znntikiktbrihrkGk = hokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk().toString();
                        }

                        else {

                            znntikiktbrihrkGk = hokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyenhrkgk().multiply(100).toString();
                        }
                    }

                    if (suiihyou2PtnCnt == 1) {

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

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getFstphrkpkngkkeituuktype())) {

                        fstphrkpkngkkei = hokenSyouken.getFstphrkpkngkkei().toString();
                    }

                    else {

                        fstphrkpkngkkei = hokenSyouken.getFstphrkpkngkkei().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getDai1stuuktypehuryo())) {

                        dai1shuryo = hokenSyouken.getDai1shuryo().toString();
                    }

                    else {

                        dai1shuryo = hokenSyouken.getDai1shuryo().multiply(100).toString();
                    }

                    if (C_Tuukasyu.JPY.eq(hokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype())) {

                        fstpznnkngk = hokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk().toString();
                    }

                    else {

                        fstpznnkngk = hokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngk().multiply(100).toString();
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

                    yoteiRiritu = ConvertUtil.toZenAll(seisuuHanndan(hokenSyouken.getSonotanyranytirrt().multiply(100)),0,0);

                    dai1sKwsRateYenDaka = String.valueOf(hokenSyouken.getDai1skwsrateyendaka().round(2, RoundingMode.DOWN).multiply(100));

                    dai1sKwsRateYenKijyun = String.valueOf(hokenSyouken.getDai1skwsrateyenkijyun().round(2, RoundingMode.DOWN).multiply(100));

                    dai1sKwsRateYenyasu = String.valueOf(hokenSyouken.getDai1skwsrateyenyasu().round(2, RoundingMode.DOWN).multiply(100));

                    sonotaNyranmKhwaRiai = ConvertUtil.toZenAll(String.valueOf(hokenSyouken.getSonotanyranmkhwariai()), 0, 0);

                    sonotanyranenkhrikmrate = String.valueOf(hokenSyouken.getSonotanyranenkhrikmrate().round(2, RoundingMode.DOWN).multiply(100));

                    sonotanyranstigikwsrate = String.valueOf(hokenSyouken.getSonotanyranstigikwsrate().multiply(10000));

                    sonotanyransjkkktusirrt = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(hokenSyouken.getSonotanyransjkkktusirrt().multiply(100)),BizUtil.ZERO_FILL, 2),0,0);

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

                    sonotanytumitateriritu = ConvertUtil.toZenAll(seisuuHanndan(hokenSyouken.getSonotanyrantumitateriritu().multiply(100)),0,0);

                    if (hokenSyouken.getSonotanyrantmttknzkrtjygn().multiply(100).compareTo(BizNumber.TEN) < 0) {
                        sonotanytmttknzkrtjygn = "　" + ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(hokenSyouken.getSonotanyrantmttknzkrtjygn().multiply(100)),1, 2),0,0);
                    }
                    else {
                        sonotanytmttknzkrtjygn = ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(hokenSyouken.getSonotanyrantmttknzkrtjygn().multiply(100)),2, 2),0,0);
                    }

                    sonotanyransetteibairitu = ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(hokenSyouken.getSonotanyransetteibairitu()),1, 2),0,0);

                    if (!C_KjkhukaKbn.KJKHUKA.eq(hokenSyouken.getKyknmkjkhukakbn())){
                        kyknmkj = hokenSyouken.getKyknmkj();
                    }

                    if (!C_KjkhukaKbn.KJKHUKA.eq(hokenSyouken.getHhknnmkjkhukakbn())){
                        hhknnmkj = hokenSyouken.getHhknnmkj();
                    }

                    if (!C_KjkhukaKbn.KJKHUKA.eq(hokenSyouken.getKyknmkjkhukakbn())) {

                        shsnmkj = hokenSyouken.getShsnmkj();
                    }
                    else {
                        shsnmkj = hokenSyouken.getKyknmkn();
                    }

                    if (!C_KjkhukaKbn.KJKHUKA.eq(hokenSyouken.getHhknnmkjkhukakbn())) {

                        hosyounyhihknsyameikanji = hokenSyouken.getHosyounyhihknsyameikanji();
                    }
                    else {
                        hosyounyhihknsyameikanji = hokenSyouken.getHhknnmkn();
                    }

                    if (!C_KjkhukaKbn.KJKHUKA.eq(hokenSyouken.getKyknmkjkhukakbn())) {

                        koujyosyoumeikyknmkj = hokenSyouken.getKyknmkj();
                    }
                    else {
                        koujyosyoumeikyknmkj = hokenSyouken.getKyknmkn();
                    }

                    if (!BizUtil.isBlank(hokenSyouken.getHrkkknmsgkbn())) {

                        hrkkknmnrykeikanensuu = hokenSyouken.getHrkkknmsgkbn();
                        hrkkknmnrynen = BizUtil.zeroNum(
                            String.valueOf(Integer.valueOf(hokenSyouken.getHrkkknmsgkbn()) + hokenSyouken.getHhknnen()), 3, 0);
                    }

                    yenKnsnKwsRateYenDaka = String.valueOf(suiihyou.getYenknsnkwsrateyendaka().round(
                        2, RoundingMode.DOWN).multiply(100));

                    yenKnsnKwsRateYenKijyun = String.valueOf(suiihyou.getYenknsnkwsrateyenkijyun().round(
                        2, RoundingMode.DOWN).multiply(100));

                    yenKnsnKwsRateYenYasu = String.valueOf(suiihyou.getYenknsnkwsrateyenyasu().round(
                        2, RoundingMode.DOWN).multiply(100));

                    sjkkktusirrtup = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtup().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                    sjkkktusirrtsame = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtsame().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                    sjkkktusirrtdown = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtdown().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                    sjkkktusirrthendouup = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendouup().multiply(100).round(
                        0, RoundingMode.DOWN)), 0, 0);

                    sjkkktusirrthendoudown = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendoudown().multiply(100).round(
                        0, RoundingMode.DOWN)), 0, 0);


                    if (suiihyouPtnCnt > 0) {

                        yenknsnkwsrateyendaka2 = String.valueOf(suiihyou.getYenknsnkwsrateyendaka2().round(
                            2, RoundingMode.DOWN).multiply(100));

                        yenknsnkwsrateyenkijyun2 = String.valueOf(suiihyou.getYenknsnkwsrateyenkijyun2().round(
                            2, RoundingMode.DOWN).multiply(100));

                        yenknsnkwsrateyenyasu2 = String.valueOf(suiihyou.getYenknsnkwsrateyenyasu2().round(
                            2, RoundingMode.DOWN).multiply(100));

                        sjkkktusirrtup2 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtup2().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                        sjkkktusirrtsame2 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtsame2().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                        sjkkktusirrtdown2 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtdown2().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                        sjkkktusirrthendouup2 = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendouup2().multiply(100).round(
                            0, RoundingMode.DOWN)), 0, 0);

                        sjkkktusirrthendoudown2 = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendoudown2().multiply(100).round(
                            0, RoundingMode.DOWN)), 0, 0);


                        if (suiihyouPtnCnt == 3) {

                            yenknsnkwsrateyendaka3 = String.valueOf(suiihyou.getYenknsnkwsrateyendaka3().round(
                                2, RoundingMode.DOWN).multiply(100));

                            yenknsnkwsrateyenkijyun3 = String.valueOf(suiihyou.getYenknsnkwsrateyenkijyun3().round(
                                2, RoundingMode.DOWN).multiply(100));

                            yenknsnkwsrateyenyasu3 = String.valueOf(suiihyou.getYenknsnkwsrateyenyasu3().round(
                                2, RoundingMode.DOWN).multiply(100));

                            sjkkktusirrtup3 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtup3().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                            sjkkktusirrtsame3 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtsame3().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                            sjkkktusirrtdown3 = ConvertUtil.toZenAll(BizUtil.comma(String.valueOf(suiihyou.getSjkkktusirrtdown3().multiply(100)), BizUtil.ZERO_FILL, 2) , 0, 0);

                            sjkkktusirrthendouup3 = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendouup3().multiply(100).round(
                                0, RoundingMode.DOWN)), 0, 0);

                            sjkkktusirrthendoudown3 = ConvertUtil.toZenAll(String.valueOf(suiihyou.getSjkkktusirrthendoudown3().multiply(100).round(
                                0, RoundingMode.DOWN)), 0, 0);
                        }
                    }

                    if (koujyoSym != null) {
                        if (BizNumber.valueOf(99).compareTo(koujyoSym.getHknkknsyu()) == 0) {
                            koujyoSymHknKkn = "終身";
                        }
                        else {
                            koujyoSymHknKkn = koujyoSym.getHknkknsyu().toString() + "年";
                        }

                        if (koujyoSym.getNenkanhrkkaisuu() == 12) {
                            koujyoSyoumeiHrkHuhu = "01";
                        }
                        else if (koujyoSym.getNenkanhrkkaisuu() == 2) {
                            koujyoSyoumeiHrkHuhu = "06";
                        }
                        else if (koujyoSym.getNenkanhrkkaisuu() == 1) {
                            koujyoSyoumeiHrkHuhu = "12";
                        }
                        else {
                            koujyoSyoumeiHrkHuhu = "99";
                        }

                        String keiyakuYm = DateFormatUtil.dateYmKANJINoEx(koujyoSym.getKykymd().getBizDateYM());
                        if (C_Kykjyoutai.ITIJIBARAI.eq(koujyoSym.getKykjyoutai()) &&
                            koujyoSym.getHknkknsyu().compareTo(BizNumber.valueOf(99)) == 0) {
                            newHknjytuKikan = keiyakuYm + "から終身";
                        }
                        else {

                            if (C_Kykjyoutai.ITIJIBARAI.eq(koujyoSym.getKykjyoutai())) {

                                newHknjytuKikan = keiyakuYm + "から" + koujyoSym.getHknkknsyu().toString() + "年分";
                            }
                            else {

                                if (koujyoSym.getSyoumeikknnensuu() != 0) {

                                    newHknjytuKikan = keiyakuYm + "から" + koujyoSym.getSyoumeikknnensuu().toString() + "年分";
                                }
                                else {

                                    newHknjytuKikan = keiyakuYm + "から" + koujyoSym.getSyoumeikkntukisuu().toString() + "か月分";
                                }
                            }
                        }

                        if (BizUtil.isZero(koujyoSym.getNewippanjissekisyoumeigk())) {
                            ippanSymGkNasiHyouji = "1";
                        } else {
                            ippanSymGkNasiHyouji = "0";
                        }

                        if (BizUtil.isZero(koujyoSym.getNewiryoujissekisyoumeigk())) {
                            kaigoIryouSmGknaHyj = "1";
                        } else {
                            kaigoIryouSmGknaHyj = "0";
                        }

                        nenIppanSymGknasiHyouji = "0";
                        nenIryouSymGkNasiHyouji = "0";

                    }
                }

                if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(suiihyou.getMvatekijyoutaikbn())) {

                    mvaarikeikanensuu[mvaariCnt] = String.valueOf(suiihyou.getKeikanensuu());
                    mvaariwtuktypeup[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                    mvaariwupyendaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka());
                    mvaariwupyenkijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun());
                    mvaariwupyenyasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu());
                    mvaariwtuktypesame[suiihyouCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                    mvaariwsameyendaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka());
                    mvaariwsameyenkijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun());
                    mvaariwsameyenyasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu());
                    mvaariwtuktypedown[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                    mvaariwdownyendaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka());
                    mvaariwdownyenkijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun());
                    mvaariwdownyenyasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu());
                    mvaarivtuktype[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());

                    if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                        mvaariwup[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup());
                        mvaariwsame[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame());
                        mvaariwdown[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown());
                        mvaariv[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin());
                        mvaaritmttkgkkykkjmaeup[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup1());
                        mvaaritmttkgkkykkjmaesame[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame1());
                        mvaaritmttkgkkykkjmaedown[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown1());
                        tutmttknutiwake1[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake11());
                        tutmttknutiwake2[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake21());
                    }
                    else {

                        mvaariwup[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup().multiply(100));
                        mvaariwsame[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame().multiply(100));
                        mvaariwdown[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown().multiply(100));
                        mvaariv[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin().multiply(100));
                        mvaaritmttkgkkykkjmaeup[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup1().multiply(100));
                        mvaaritmttkgkkykkjmaesame[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame1().multiply(100));
                        mvaaritmttkgkkykkjmaedown[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown1().multiply(100));
                        tutmttknutiwake1[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake11().multiply(100));
                        tutmttknutiwake2[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake21().multiply(100));
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

                    if (suiihyou.getKeikanensuu() == 0) {

                        sisuuupritu[mvaariCnt] = "‐";
                        tmttknzoukaritu[mvaariCnt] = "‐";

                        if (SUIIHYOUSYUBETU_SYSN2.equals(suiihyou.getSuiihyousyubetu())) {

                            mvaariwumupyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            mvaariumupyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            mvaariumupyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            mvaariumsameyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            mvaariumsameyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            mvaariumsameyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            mvaariumdownyendaka[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            mvaariumdownyenkijyun[mvaariCnt] = C_UmuKbn.NONE.getValue();
                            mvaariumdownyenyasu[mvaariCnt] = C_UmuKbn.NONE.getValue();
                        }
                    }
                    else {

                        sisuuupritu[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getSisuuupritu1().multiply(100)),0,0);
                        tmttknzoukaritu[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getTmttknzoukaritu1().multiply(100)) , 0, 0);
                    }

                    if (suiihyouPtnCnt > 0) {

                        mvaariwupyendaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka2());
                        mvaariwupyenkijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun2());
                        mvaariwupyenyasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu2());
                        mvaariwsameyendaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka2());
                        mvaariwsameyenkijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun2());
                        mvaariwsameyenyasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu2());
                        mvaariwdownyendaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka2());
                        mvaariwdownyenkijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun2());
                        mvaariwdownyenyasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu2());

                        if (suiihyou.getKeikanensuu() == 0) {

                            sisuuupritu2[mvaariCnt] = "‐";
                            tmttknzoukaritu2[mvaariCnt] = "‐";
                        }
                        else {

                            sisuuupritu2[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getSisuuupritu2().multiply(100)),0,0);
                            tmttknzoukaritu2[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getTmttknzoukaritu2().multiply(100)), 0, 0);
                        }



                        if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                            mvaariwup2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup2());
                            mvaariwsame2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame2());
                            mvaariwdown2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown2());
                            mvaariv2[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin2());
                            mvaaritmttkgkkykkjmaeup2[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup2());
                            mvaaritmttkgkkykkjmaesame2[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame2());
                            mvaaritmttkgkkykkjmaedown2[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown2());
                            tutmttknutiwake12[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake12());
                            tutmttknutiwake22[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake22());
                        }
                        else {

                            mvaariwup2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup2().multiply(100));
                            mvaariwsame2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame2().multiply(100));
                            mvaariwdown2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown2().multiply(100));
                            mvaariv2[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin2().multiply(100));
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

                        if (suiihyouPtnCnt == 3) {

                            mvaariwupyendaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka3());
                            mvaariwupyenkijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun3());
                            mvaariwupyenyasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu3());
                            mvaariwsameyendaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka3());
                            mvaariwsameyenkijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun3());
                            mvaariwsameyenyasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu3());
                            mvaariwdownyendaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka3());
                            mvaariwdownyenkijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun3());
                            mvaariwdownyenyasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu3());

                            if (suiihyou.getKeikanensuu() == 0) {

                                sisuuupritu3[mvaariCnt] = "‐";
                                tmttknzoukaritu3[mvaariCnt] = "‐";
                            }
                            else {

                                sisuuupritu3[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getSisuuupritu3().multiply(100)),0,0);
                                tmttknzoukaritu3[mvaariCnt] = ConvertUtil.toZenAll(seisuuHanndan(suiihyou.getTmttknzoukaritu3().multiply(100)), 0, 0);
                            }

                            if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                                mvaariwup3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup3());
                                mvaariwsame3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame3());
                                mvaariwdown3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown3());
                                mvaariv3[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin3());
                                mvaaritmttkgkkykkjmaeup3[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaeup3());
                                mvaaritmttkgkkykkjmaesame3[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaesame3());
                                mvaaritmttkgkkykkjmaedown3[mvaariCnt] = String.valueOf(suiihyou.getMvaaritmttkgkkykkjmaedown3());
                                tutmttknutiwake13[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake13());
                                tutmttknutiwake23[mvaariCnt] = String.valueOf(suiihyou.getTutmttknutiwake23());
                            }
                            else {

                                mvaariwup3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup3().multiply(100));
                                mvaariwsame3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame3().multiply(100));
                                mvaariwdown3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown3().multiply(100));
                                mvaariv3[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin3().multiply(100));
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
                    mvaariCnt++;
                }

                else if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(suiihyou.getMvatekijyoutaikbn())) {

                    mvanonekaisiinnumukbn[mvanoneCnt] = C_UmuKbn.NONE.toString();
                    mvanonekeikanensuu[mvanoneCnt] = String.valueOf(suiihyou.getKeikanensuu());
                    mvanonewtuktype[mvanoneCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                    mvanonewyendaka[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka());
                    mvanonewyenkijyun[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun());
                    mvanonewyenyasu[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu());
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
                    if (suiihyouPtnCnt > 0) {
                        mvanonewyendaka2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka2());
                        mvanonewyenkijyun2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun2());
                        mvanonewyenyasu2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu2());
                        mvanonewyendaka3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka3());
                        mvanonewyenkijyun3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun3());
                        mvanonewyenyasu3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu3());

                        if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                            mvaNoneW2[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame2());
                            mvaNoneY2[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin2());
                            mvaNoneW3[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame3());
                            mvaNoneY3[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin3());
                        }

                        else {

                            mvaNoneW2[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame2().multiply(100));
                            mvaNoneY2[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin2().multiply(100));
                            mvaNoneW3[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame3().multiply(100));
                            mvaNoneY3[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin3().multiply(100));
                        }
                    }
                    mvanoneCnt++;
                }
                else if (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(suiihyou.getMvatekijyoutaikbn())) {

                    mvaarikeikanensuu[mvaariCnt] = String.valueOf(suiihyou.getKeikanensuu());
                    mvaariwtuktypeup[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                    mvaariwupyendaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka());
                    mvaariwupyenkijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun());
                    mvaariwupyenyasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu());
                    mvaariwtuktypesame[suiihyouCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                    mvaariwsameyendaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka());
                    mvaariwsameyenkijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun());
                    mvaariwsameyenyasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu());
                    mvaariwtuktypedown[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                    mvaariwdownyendaka[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka());
                    mvaariwdownyenkijyun[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun());
                    mvaariwdownyenyasu[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu());
                    mvaarivtuktype[mvaariCnt] = String.valueOf(suiihyou.getKyktuukasyu());

                    if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                        mvaariwup[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup());
                        mvaariwsame[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame());
                        mvaariwdown[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown());
                        mvaariv[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin());
                    }

                    else {

                        mvaariwup[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup().multiply(100));
                        mvaariwsame[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame().multiply(100));
                        mvaariwdown[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown().multiply(100));
                        mvaariv[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin().multiply(100));
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

                    mvanonekaisiinnumukbn[mvanoneCnt] = C_UmuKbn.ARI.toString();
                    mvanonekeikanensuu[mvanoneCnt] = String.valueOf(suiihyou.getKeikanensuu());
                    mvanonewtuktype[mvanoneCnt] = String.valueOf(suiihyou.getKyktuukasyu());
                    mvanonewyendaka[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka());
                    mvanonewyenkijyun[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun());
                    mvanonewyenyasu[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu());
                    mvanoneumyendaka[mvanoneCnt] = C_UmuKbn.NONE.toString();
                    mvanoneumyenkijyun[mvanoneCnt] = C_UmuKbn.NONE.toString();
                    mvanoneumyenyasu[mvanoneCnt] = C_UmuKbn.NONE.toString();
                    mvaNoneVTukType[mvanoneCnt] = String.valueOf(suiihyou.getKyktuukasyu());

                    if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                        mvaNoneW[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame());
                        mvaNoneY[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin());
                    }

                    else {

                        mvaNoneW[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame().multiply(100));
                        mvaNoneY[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin().multiply(100));
                    }

                    if (suiihyouPtnCnt > 0) {
                        mvaariwupyendaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka2());
                        mvaariwupyenkijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun2());
                        mvaariwupyenyasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu2());
                        mvaariwsameyendaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka2());
                        mvaariwsameyenkijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun2());
                        mvaariwsameyenyasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu2());
                        mvaariwdownyendaka2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka2());
                        mvaariwdownyenkijyun2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun2());
                        mvaariwdownyenyasu2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu2());
                        mvanonewyendaka2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka2());
                        mvanonewyenkijyun2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun2());
                        mvanonewyenyasu2[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu2());

                        mvaariwupyendaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyendaka3());
                        mvaariwupyenkijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenkijyun3());
                        mvaariwupyenyasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyenupyenyasu3());
                        mvaariwsameyendaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyendaka3());
                        mvaariwsameyenkijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenkijyun3());
                        mvaariwsameyenyasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyensameyenyasu3());
                        mvaariwdownyendaka3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyendaka3());
                        mvaariwdownyenkijyun3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenkijyun3());
                        mvaariwdownyenyasu3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwyendownyenyasu3());
                        mvanonewyendaka3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyendaka3());
                        mvanonewyenkijyun3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenkijyun3());
                        mvanonewyenyasu3[mvanoneCnt] = String.valueOf(suiihyou.getMvanonewyensameyenyasu3());

                        if (C_Tuukasyu.JPY.eq(suiihyou.getKyktuukasyu())) {

                            mvaariwup2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup2());
                            mvaariwsame2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame2());
                            mvaariwdown2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown2());
                            mvaariv2[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin2());
                            mvaNoneW2[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame2());
                            mvaNoneY2[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin2());

                            mvaariwup3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup3());
                            mvaariwsame3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame3());
                            mvaariwdown3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown3());
                            mvaariv3[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin3());
                            mvaNoneW3[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame3());
                            mvaNoneY3[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin3());
                        }

                        else {

                            mvaariwup2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup2().multiply(100));
                            mvaariwsame2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame2().multiply(100));
                            mvaariwdown2[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown2().multiply(100));
                            mvaariv2[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin2().multiply(100));
                            mvaNoneW2[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame2().multiply(100));
                            mvaNoneY2[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin2().multiply(100));
                            mvaariwup3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwup3().multiply(100));
                            mvaariwsame3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwsame3().multiply(100));
                            mvaariwdown3[mvaariCnt] = String.valueOf(suiihyou.getMvaariwdown3().multiply(100));
                            mvaariv3[mvaariCnt] = String.valueOf(suiihyou.getMvaariptumitatekin3().multiply(100));
                            mvaNoneW3[mvanoneCnt] =  String.valueOf(suiihyou.getMvanonewsame3().multiply(100));
                            mvaNoneY3[mvanoneCnt] =  String.valueOf(suiihyou.getMvanoneptumitatekin3().multiply(100));
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

                if (suiihyou2PtnCnt > 0) {

                    keikanensuus[suiihyou2Cnt] = String.valueOf(keikanensuuHanndan(
                        suiihyou.getKeikanensuu(), suiihyou.getHrkkknmnryumukbn()));
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

                suiihyouCnt++;
                hokenSyoukenInfoCnt++;
            }

            if (hokenSyoukenInfoCnt != 0) {
                sinkeiyakuHokensyoukenTy = editSinkeiyakuHokensyoukenTy(hokenSyouken);
                multipleEntityInserter.add(sinkeiyakuHokensyoukenTy);

                sinkeiyakuSyoukenSuiiTy = editSinkeiyakuSyoukenSuiiTy(hokenSyouken,suiihyou,koujyoSym);
                multipleEntityInserter.add(sinkeiyakuSyoukenSuiiTy);

                if (suiihyouPtnCnt == 3) {
                    sinkeiyakuSyoukenSuiiTy = editSinkeiyakuSyoukenSuiiTy2(hokenSyouken,suiihyou,koujyoSym);
                    multipleEntityInserter.add(sinkeiyakuSyoukenSuiiTy);
                    sinkeiyakuSyoukenSuiiTy = editSinkeiyakuSyoukenSuiiTy3(hokenSyouken,suiihyou,koujyoSym);
                    multipleEntityInserter.add(sinkeiyakuSyoukenSuiiTy);
                }

                if (suiihyouPtnCnt == 2) {
                    sinkeiyakuSyoukenSuiiTy = editSinkeiyakuSyoukenSuiiTy2(hokenSyouken,suiihyou,koujyoSym);
                    multipleEntityInserter.add(sinkeiyakuSyoukenSuiiTy);
                }

                if (suiihyou2PtnCnt == 2) {

                    sinkeiyakuSyoukenSuii2Ty = editSinkeiyakuSyoukenSuii2Ty(suiihyou, suiihyou2Cnt);
                    multipleEntityInserter.add(sinkeiyakuSyoukenSuii2Ty);
                    sinkeiyakuSyoukenSuii2Ty = editSinkeiyakuSyoukenSuii2Ty2(suiihyou, suiihyou2Cnt);
                    multipleEntityInserter.add(sinkeiyakuSyoukenSuii2Ty);
                }

                if (suiihyou2PtnCnt == 1) {

                    sinkeiyakuSyoukenSuii2Ty = editSinkeiyakuSyoukenSuii2Ty(suiihyou, suiihyou2Cnt);
                    multipleEntityInserter.add(sinkeiyakuSyoukenSuii2Ty);
                }

                sinKeiyakuHokenSyoukenCnt++;
            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(sinKeiyakuHokenSyoukenCnt)));
    }

    private void initMemberVarible() {
        hokenryouGk = "";
        znntikiktbrihrkGk = "";
        syukykTkykHknknGk1 = "";
        syukykTkykHknknGk2 = "";
        syukykTkykHknknGk3 = "";
        syukykTkykHknknGk4 = "";
        syukykTkykHknknGk5 = "";
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
        fstphrkpkngkkei = "";
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
        yoteiRiritu = "";
        dai1sKwsRateYenDaka = "";
        dai1sKwsRateYenKijyun = "";
        dai1sKwsRateYenyasu = "";
        sonotaNyranmKhwaRiai = "";
        sonotanyranenkhrikmrate = "";
        sonotanyranstigikwsrate = "";
        sonotanyransjkkktusirrt = "";
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
        koujyoSymHknKkn = "";
        koujyoSyoumeiHrkHuhu = "";
        newHknjytuKikan = "";
        ippanSymGkNasiHyouji = "";
        kaigoIryouSmGknaHyj = "";
        nenIppanSymGknasiHyouji = "";
        nenIryouSymGkNasiHyouji = "";
        kyknmkj = "";
        hhknnmkj = "";
        shsnmkj = "";
        hosyounyhihknsyameikanji = "";
        koujyosyoumeikyknmkj = "";
        hrkkknmnrykeikanensuu = "";
        hrkkknmnrynen = "";
        mvaarikeikanensuu = new String[15];
        mvaariwtuktypeup = new String[15];
        mvaariwupyendaka = new String[15];
        mvaariwupyenkijyun = new String[15];
        mvaariwupyenyasu = new String[15];
        mvaariwumupyendaka = new String[15];
        mvaariumupyenkijyun = new String[15];
        mvaariumupyenyasu = new String[15];
        mvaariwtuktypesame = new String[15];
        mvaariwsameyendaka = new String[15];
        mvaariwsameyenkijyun = new String[15];
        mvaariwsameyenyasu = new String[15];
        mvaariumsameyendaka = new String[15];
        mvaariumsameyenkijyun = new String[15];
        mvaariumsameyenyasu = new String[15];
        mvaariwtuktypedown = new String[15];
        mvaariwdownyendaka = new String[15];
        mvaariwdownyenkijyun = new String[15];
        mvaariwdownyenyasu = new String[15];
        mvaariumdownyendaka = new String[15];
        mvaariumdownyenkijyun = new String[15];
        mvaariumdownyenyasu = new String[15];
        mvaarivtuktype = new String[15];
        mvaariwup = new String[15];
        mvaariwsame = new String[15];
        mvaariwdown = new String[15];
        mvaariv = new String[15];
        mvanonekaisiinnumukbn = new String[11];
        mvanonekeikanensuu = new String[11];
        mvanonewtuktype = new String[11];
        mvanonewyendaka = new String[11];
        mvanonewyenkijyun = new String[11];
        mvanonewyenyasu = new String[11];
        mvanoneumyendaka = new String[11];
        mvanoneumyenkijyun = new String[11];
        mvanoneumyenyasu = new String[11];
        mvaNoneVTukType = new String[11];
        mvaNoneW = new String[11];
        mvaNoneY = new String[11];
        keikanensuus = new String[22];
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

    private ZT_SinkeiyakuHokensyoukenTy editSinkeiyakuHokensyoukenTy(
        IT_HokenSyouken pHokenSyouken) {

        ZT_SinkeiyakuHokensyoukenTy pSinkeiyakuHokensyoukenTy = new ZT_SinkeiyakuHokensyoukenTy();

        pSinkeiyakuHokensyoukenTy.setZtysyoruicd(C_SyoruiCdKbn.KK_HKNSYKN.getValue().toUpperCase());
        pSinkeiyakuHokensyoukenTy.setZtytyouhyouymd(pHokenSyouken.getTyouhyouymd().toString());
        pSinkeiyakuHokensyoukenTy.setZtysyono(pHokenSyouken.getSyono());
        pSinkeiyakuHokensyoukenTy.setZtyhassoukbn(pHokenSyouken.getHassoukbn().getValue());
        pSinkeiyakuHokensyoukenTy.setZtykanryoutuutidouhuukbn(pHokenSyouken.getKanryoutuutiumukbn().getValue());
        pSinkeiyakuHokensyoukenTy.setZtysikibetuno(pHokenSyouken.getHenkousikibetukey());
        pSinkeiyakuHokensyoukenTy.setZtydstirasidouhuukbn(pHokenSyouken.getDstirasidouhuukbn().getValue());

        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSinkeiyakuHokensyoukenTy.setZtykzktirasidouhuukbn1(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn1().getValue());
            pSinkeiyakuHokensyoukenTy.setZtykzktirasidouhuukbn2(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn2().getValue());
            pSinkeiyakuHokensyoukenTy.setZtykykdairitirasidouhuukbn(pHokenSyouken.getHokenSyoukenHukaInfo().getKykdairitirasidouhuukbn().getValue());
            pSinkeiyakuHokensyoukenTy.setZtyskhtirasidouhuukbn(pHokenSyouken.getHokenSyoukenHukaInfo().getSkhtirasidouhuukbn().getValue());
            pSinkeiyakuHokensyoukenTy.setZtyyakkannewoldkbn(pHokenSyouken.getHokenSyoukenHukaInfo().getYakkannewoldkbn());
        }

        pSinkeiyakuHokensyoukenTy.setZtystdrsktirasidouhuukbn(pHokenSyouken.getStdrsktirasidouhuukbn().getValue());
        pSinkeiyakuHokensyoukenTy.setZtyaisyoumeikbn(pHokenSyouken.getAisyoumeikbn().getValue());
        pSinkeiyakuHokensyoukenTy.setZtytnshuyoupostumukbn(pHokenSyouken.getSyotnshuyoupostumukbn().getValue());
        pSinkeiyakuHokensyoukenTy.setZtysagyoukbn(pHokenSyouken.getSagyoukbn());
        pSinkeiyakuHokensyoukenTy.setZtyyakkanbunsyono(pHokenSyouken.getYakkanbunsyono());
        pSinkeiyakuHokensyoukenTy.setZtysiorino(pHokenSyouken.getSiorino());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd1(pHokenSyouken.getHyoujiranhidarimsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd2(pHokenSyouken.getHyoujiranhidarimsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd3(pHokenSyouken.getHyoujiranhidarimsgcd3());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd4(pHokenSyouken.getHyoujiranhidarimsgcd4());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd5(pHokenSyouken.getHyoujiranhidarimsgcd5());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd6(pHokenSyouken.getHyoujiranhidarimsgcd6());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd7(pHokenSyouken.getHyoujiranhidarimsgcd7());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd8(pHokenSyouken.getHyoujiranhidarimsgcd8());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd9(pHokenSyouken.getHyoujiranhidarimsgcd9());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd10(pHokenSyouken.getHyoujiranhidarimsgcd10());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd11(pHokenSyouken.getHyoujiranhidarimsgcd11());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd12(pHokenSyouken.getHyoujiranhidarimsgcd12());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd13(pHokenSyouken.getHyoujiranhidarimsgcd13());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd14(pHokenSyouken.getHyoujiranhidarimsgcd14());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd15(pHokenSyouken.getHyoujiranhidarimsgcd15());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd16(pHokenSyouken.getHyoujiranhidarimsgcd16());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd17(pHokenSyouken.getHyoujiranhidarimsgcd17());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd18(pHokenSyouken.getHyoujiranhidarimsgcd18());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd19(pHokenSyouken.getHyoujiranhidarimsgcd19());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranhidarimsgcd20(pHokenSyouken.getHyoujiranhidarimsgcd20());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd1(pHokenSyouken.getHyoujiranmigiimsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd2(pHokenSyouken.getHyoujiranmigiimsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd3(pHokenSyouken.getHyoujiranmigiimsgcd3());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd4(pHokenSyouken.getHyoujiranmigiimsgcd4());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd5(pHokenSyouken.getHyoujiranmigiimsgcd5());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd6(pHokenSyouken.getHyoujiranmigiimsgcd6());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd7(pHokenSyouken.getHyoujiranmigiimsgcd7());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd8(pHokenSyouken.getHyoujiranmigiimsgcd8());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd9(pHokenSyouken.getHyoujiranmigiimsgcd9());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd10(pHokenSyouken.getHyoujiranmigiimsgcd10());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd11(pHokenSyouken.getHyoujiranmigiimsgcd11());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd12(pHokenSyouken.getHyoujiranmigiimsgcd12());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd13(pHokenSyouken.getHyoujiranmigiimsgcd13());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd14(pHokenSyouken.getHyoujiranmigiimsgcd14());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd15(pHokenSyouken.getHyoujiranmigiimsgcd15());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd16(pHokenSyouken.getHyoujiranmigiimsgcd16());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd17(pHokenSyouken.getHyoujiranmigiimsgcd17());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd18(pHokenSyouken.getHyoujiranmigiimsgcd18());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd19(pHokenSyouken.getHyoujiranmigiimsgcd19());
        pSinkeiyakuHokensyoukenTy.setZtyhyoujiranmigimsgcd20(pHokenSyouken.getHyoujiranmigiimsgcd20());
        pSinkeiyakuHokensyoukenTy.setZtysknnkaisiymdseireki(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pHokenSyouken.getHyoujiransknnkaisiymd()));
        pSinkeiyakuHokensyoukenTy.setZtyhknsyukigou(pHokenSyouken.getHknsyukigou());
        pSinkeiyakuHokensyoukenTy.setZtysyoukenhakkouymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pHokenSyouken.getSyohakkouymd()));
        pSinkeiyakuHokensyoukenTy.setZtyhanbainmsyouken(pHokenSyouken.getHanbainm());
        pSinkeiyakuHokensyoukenTy.setZtyseisikihknnmsyouken(pHokenSyouken.getSeisikihknnm());
        pSinkeiyakuHokensyoukenTy.setZtynksyuruinmsyouken(pHokenSyouken.getHokenSyoukenHukaInfo().getNksyuruinmsyouken());
        pSinkeiyakuHokensyoukenTy.setZtykyknmkj(kyknmkj);
        pSinkeiyakuHokensyoukenTy.setZtyhhknnmkj(hhknnmkj);
        pSinkeiyakuHokensyoukenTy.setZtyhihknsyaseiymdwareki(FixedDateFormatter.formatYMDZenkakuWarekiKanji(pHokenSyouken.getHhknseiymd()));
        pSinkeiyakuHokensyoukenTy.setZtyhhknsei(pHokenSyouken.getHhknsei().getValue());
        pSinkeiyakuHokensyoukenTy.setZtyhhknnen2(String.valueOf(pHokenSyouken.getHhknnen()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn1())){
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn1(pHokenSyouken.getSyoukenuktmidasikbn1().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn1())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn1(pHokenSyouken.getSyoukenuktkbn1().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm1(pHokenSyouken.getSyoukenuktnm1());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari1(String.valueOf(pHokenSyouken.getSyoukenuktbnwari1()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn2())){
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn2(pHokenSyouken.getSyoukenuktmidasikbn2().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn2())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn2(pHokenSyouken.getSyoukenuktkbn2().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm2(pHokenSyouken.getSyoukenuktnm2());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari2(String.valueOf(pHokenSyouken.getSyoukenuktbnwari2()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn3())){
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn3(pHokenSyouken.getSyoukenuktmidasikbn3().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn3())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn3(pHokenSyouken.getSyoukenuktkbn3().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm3(pHokenSyouken.getSyoukenuktnm3());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari3(String.valueOf(pHokenSyouken.getSyoukenuktbnwari3()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn4())){
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn4(pHokenSyouken.getSyoukenuktmidasikbn4().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn4())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn4(pHokenSyouken.getSyoukenuktkbn4().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm4(pHokenSyouken.getSyoukenuktnm4());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari4(String.valueOf(pHokenSyouken.getSyoukenuktbnwari4()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn5())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn5(pHokenSyouken.getSyoukenuktmidasikbn5().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn5())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn5(pHokenSyouken.getSyoukenuktkbn5().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm5(pHokenSyouken.getSyoukenuktnm5());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari5(String.valueOf(pHokenSyouken.getSyoukenuktbnwari5()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn6())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn6(pHokenSyouken.getSyoukenuktmidasikbn6().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn6())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn6(pHokenSyouken.getSyoukenuktkbn6().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm6(pHokenSyouken.getSyoukenuktnm6());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari6(String.valueOf(pHokenSyouken.getSyoukenuktbnwari6()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn7())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn7(pHokenSyouken.getSyoukenuktmidasikbn7().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn7())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn7(pHokenSyouken.getSyoukenuktkbn7().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm7(pHokenSyouken.getSyoukenuktnm7());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari7(String.valueOf(pHokenSyouken.getSyoukenuktbnwari7()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn8())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn8(pHokenSyouken.getSyoukenuktmidasikbn8().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn8())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn8(pHokenSyouken.getSyoukenuktkbn8().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm8(pHokenSyouken.getSyoukenuktnm8());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari8(String.valueOf(pHokenSyouken.getSyoukenuktbnwari8()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn9())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn9(pHokenSyouken.getSyoukenuktmidasikbn9().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn9())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn9(pHokenSyouken.getSyoukenuktkbn9().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm9(pHokenSyouken.getSyoukenuktnm9());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari9(String.valueOf(pHokenSyouken.getSyoukenuktbnwari9()));
        if (!C_SyoukenUktMidasiKbn.BLNK.eq(pHokenSyouken.getSyoukenuktmidasikbn10())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktmidasikbn10(pHokenSyouken.getSyoukenuktmidasikbn10().getValue());
        }
        if (!C_SyoukenUktKbn.BLNK.eq(pHokenSyouken.getSyoukenuktkbn10())) {
            pSinkeiyakuHokensyoukenTy.setZtyuktkbn10(pHokenSyouken.getSyoukenuktkbn10().getValue());
        }
        pSinkeiyakuHokensyoukenTy.setZtyuktnm10(pHokenSyouken.getSyoukenuktnm10());
        pSinkeiyakuHokensyoukenTy.setZtyuktbnwari10(String.valueOf(pHokenSyouken.getSyoukenuktbnwari10()));
        pSinkeiyakuHokensyoukenTy.setZtypmsgcd1(pHokenSyouken.getPmsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtypmsgcd2(pHokenSyouken.getPmsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtypmsgcd3(pHokenSyouken.getPmsgcd3());
        pSinkeiyakuHokensyoukenTy.setZtyptuukatype(pHokenSyouken.getPtuukatype().getValue());
        pSinkeiyakuHokensyoukenTy.setZtypkngk(hokenryouGk);
        pSinkeiyakuHokensyoukenTy.setZtypkngktuuka(pHokenSyouken.getPtuuka());
        pSinkeiyakuHokensyoukenTy.setZtyteikiikkatubaraitukisuu(String.valueOf(
            BizUtil.zeroNum(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getTeikiikkatubaraitukisuu()), 2, 0)));
        pSinkeiyakuHokensyoukenTy.setZtyztikiktbriyhrkgktuktype(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getZnntikiktbriyhrkgktuktype()));
        pSinkeiyakuHokensyoukenTy.setZtyznntikiktbriyenhrkgk(znntikiktbrihrkGk);
        pSinkeiyakuHokensyoukenTy.setZtyznnkai(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getZnnkai2()));
        pSinkeiyakuHokensyoukenTy.setZtytikiktbriyhrkgktuktype(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyhrkgktuktype()));
        pSinkeiyakuHokensyoukenTy.setZtytikiktbriyenhrkgk(String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getTikiktbriyenhrkgk()));
        pSinkeiyakuHokensyoukenTy.setZtyptokuyakumsgcd(pHokenSyouken.getPtokuyakumsgcd());
        pSinkeiyakuHokensyoukenTy.setZtykykymdseireki(
            FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pHokenSyouken.getKykymd()));
        pSinkeiyakuHokensyoukenTy.setZtyphrkkknmidasikbn(pHokenSyouken.getPhrkkknmidasikbn());
        pSinkeiyakuHokensyoukenTy.setZtyhrkkknmsgkbn(pHokenSyouken.getHrkkknmsgkbn());
        pSinkeiyakuHokensyoukenTy.setZtyhrkkaisuumsgkbn(pHokenSyouken.getHrkkaisuumsgkbn());
        pSinkeiyakuHokensyoukenTy.setZtyphrkktuki(pHokenSyouken.getPhrkktuki());
        pSinkeiyakuHokensyoukenTy.setZtyhrkhouhoumsgkbn(pHokenSyouken.getHrkhouhoumsgkbn());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban1(String.valueOf(pHokenSyouken.getSyukyktkykrenban1()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn1(pHokenSyouken.getSyukyktkykmsgkbn1());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn1(pHokenSyouken.getSyukyktkyksmsgkbn1());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn1(pHokenSyouken.getSyukyktkykhknkknmsgkbn1());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype1(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype1()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk1(syukykTkykHknknGk1);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn1(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn1()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn1(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn1()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban2(String.valueOf(pHokenSyouken.getSyukyktkykrenban2()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn2(pHokenSyouken.getSyukyktkykmsgkbn2());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn2(pHokenSyouken.getSyukyktkyksmsgkbn2());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn2(pHokenSyouken.getSyukyktkykhknkknmsgkbn2());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype2(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype2()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk2(syukykTkykHknknGk2);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn2(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn2()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn2(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn2()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban3(String.valueOf(pHokenSyouken.getSyukyktkykrenban3()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn3(pHokenSyouken.getSyukyktkykmsgkbn3());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn3(pHokenSyouken.getSyukyktkyksmsgkbn3());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn3(pHokenSyouken.getSyukyktkykhknkknmsgkbn3());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype3(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype3()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk3(syukykTkykHknknGk3);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn3(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn3()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn3(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn3()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban4(String.valueOf(pHokenSyouken.getSyukyktkykrenban4()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn4(pHokenSyouken.getSyukyktkykmsgkbn4());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn4(pHokenSyouken.getSyukyktkyksmsgkbn4());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn4(pHokenSyouken.getSyukyktkykhknkknmsgkbn4());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype4(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype4()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk4(syukykTkykHknknGk4);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn4(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn4()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn4(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn4()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban5(String.valueOf(pHokenSyouken.getSyukyktkykrenban5()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn5(pHokenSyouken.getSyukyktkykmsgkbn5());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn5(pHokenSyouken.getSyukyktkyksmsgkbn5());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn5(pHokenSyouken.getSyukyktkykhknkknmsgkbn5());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype5(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype5()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk5(syukykTkykHknknGk5);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn5(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn5()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn5(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn5()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban6(String.valueOf(pHokenSyouken.getSyukyktkykrenban6()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn6(pHokenSyouken.getSyukyktkykmsgkbn6());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn6(pHokenSyouken.getSyukyktkyksmsgkbn6());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn6(pHokenSyouken.getSyukyktkykhknkknmsgkbn6());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype6(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype6()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk6(syukykTkykHknknGk6);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn6(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn6()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn6(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn6()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban7(String.valueOf(pHokenSyouken.getSyukyktkykrenban7()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn7(pHokenSyouken.getSyukyktkykmsgkbn7());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn7(pHokenSyouken.getSyukyktkyksmsgkbn7());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn7(pHokenSyouken.getSyukyktkykhknkknmsgkbn7());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype7(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype7()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk7(syukykTkykHknknGk7);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn7(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn7()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn7(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn7()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban8(String.valueOf(pHokenSyouken.getSyukyktkykrenban8()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn8(pHokenSyouken.getSyukyktkykmsgkbn8());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn8(pHokenSyouken.getSyukyktkyksmsgkbn8());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn8(pHokenSyouken.getSyukyktkykhknkknmsgkbn8());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype8(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype8()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk8(syukykTkykHknknGk8);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn8(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn8()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn8(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn8()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban9(String.valueOf(pHokenSyouken.getSyukyktkykrenban9()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn9(pHokenSyouken.getSyukyktkykmsgkbn9());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn9(pHokenSyouken.getSyukyktkyksmsgkbn9());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn9(pHokenSyouken.getSyukyktkykhknkknmsgkbn9());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype9(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype9()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk9(syukykTkykHknknGk9);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn9(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn9()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn9(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn9()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykrenban10(String.valueOf(pHokenSyouken.getSyukyktkykrenban10()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykmsgkbn10(pHokenSyouken.getSyukyktkykmsgkbn10());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkyksmsgkbn10(pHokenSyouken.getSyukyktkyksmsgkbn10());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkknmsgkbn10(pHokenSyouken.getSyukyktkykhknkknmsgkbn10());
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykstuukatype10(String.valueOf(pHokenSyouken.getSyukyktkykstuukatype10()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykhknkngk10(syukykTkykHknknGk10);
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai1hknkkn10(String.valueOf(pHokenSyouken.getSyukyktkykdai1hknkkn10()));
        pSinkeiyakuHokensyoukenTy.setZtysyukyktkykdai2hknkkn10(String.valueOf(pHokenSyouken.getSyukyktkykdai2hknkkn10()));
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd1(pHokenSyouken.getKykniyustmsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd2(pHokenSyouken.getKykniyustmsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd3(pHokenSyouken.getKykniyustmsgcd3());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd4(pHokenSyouken.getKykniyustmsgcd4());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd5(pHokenSyouken.getKykniyustmsgcd5());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd6(pHokenSyouken.getKykniyustmsgcd6());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd7(pHokenSyouken.getKykniyustmsgcd7());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd8(pHokenSyouken.getKykniyustmsgcd8());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd9(pHokenSyouken.getKykniyustmsgcd9());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd10(pHokenSyouken.getKykniyustmsgcd10());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd11(pHokenSyouken.getKykniyustmsgcd11());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd12(pHokenSyouken.getKykniyustmsgcd12());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd13(pHokenSyouken.getKykniyustmsgcd13());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd14(pHokenSyouken.getKykniyustmsgcd14());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustmsgcd15(pHokenSyouken.getKykniyustmsgcd15());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustitjbrptuuktype(String.valueOf(pHokenSyouken.getKykniyustitjbrptuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtykykniyustitjbrp(kykNiyuStitjbrP);
        pSinkeiyakuHokensyoukenTy.setZtykykniyustkihonstype(pHokenSyouken.getSyukyktkykstuukatype1().getValue());
        pSinkeiyakuHokensyoukenTy.setZtykykniyustkihons(kykNiyuStkihonS);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd1(pHokenSyouken.getStnaiyouranmsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd2(pHokenSyouken.getStnaiyouranmsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd3(pHokenSyouken.getStnaiyouranmsgcd3());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd4(pHokenSyouken.getStnaiyouranmsgcd4());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd5(pHokenSyouken.getStnaiyouranmsgcd5());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd6(pHokenSyouken.getStnaiyouranmsgcd6());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd7(pHokenSyouken.getStnaiyouranmsgcd7());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd8(pHokenSyouken.getStnaiyouranmsgcd8());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd9(pHokenSyouken.getStnaiyouranmsgcd9());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd10(pHokenSyouken.getStnaiyouranmsgcd10());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd11(pHokenSyouken.getStnaiyouranmsgcd11());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd12(pHokenSyouken.getStnaiyouranmsgcd12());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd13(pHokenSyouken.getStnaiyouranmsgcd13());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd14(pHokenSyouken.getStnaiyouranmsgcd14());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd15(pHokenSyouken.getStnaiyouranmsgcd15());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd16(pHokenSyouken.getStnaiyouranmsgcd16());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd17(pHokenSyouken.getStnaiyouranmsgcd17());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd18(pHokenSyouken.getStnaiyouranmsgcd18());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd19(pHokenSyouken.getStnaiyouranmsgcd19());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmsgcd20(pHokenSyouken.getStnaiyouranmsgcd20());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyransiteituuka(pHokenSyouken.getSonotanyransiteituuka());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyrannykntuktype(String.valueOf(pHokenSyouken.getSonotanyrannykntuktype()));
        pSinkeiyakuHokensyoukenTy.setZtysonotanyrannykntuukap(sonotaNyranNyknTuukaP);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyrannykntuukasyu(pHokenSyouken.getSonotanyrannykntuukasyu());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranenkhrikmrate(sonotanyranenkhrikmrate);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranstigikwsrate(sonotanyranstigikwsrate);
        pSinkeiyakuHokensyoukenTy.setZtysonotanykjnkngktuktype(String.valueOf(pHokenSyouken.getSonotanyrankjnkngktuktype()));
        pSinkeiyakuHokensyoukenTy.setZtysonotanykjnkngk(sonotanyrankjnkngk);
        pSinkeiyakuHokensyoukenTy.setZtysonotanykjnkngkrate(sonotanyrankjnkngkrate);
        pSinkeiyakuHokensyoukenTy.setZtysonotanykjnkngktuuka(pHokenSyouken.getSonotanyrankjnkngktuuka());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranpentuktype(String.valueOf(pHokenSyouken.getSonotanyranpentuktype()));
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranpenknsngk(String.valueOf(pHokenSyouken.getSonotanyranpenknsngk()));
        pSinkeiyakuHokensyoukenTy.setZtypmkhtoutatuwariai(sonotaNyranmKhwaRiai);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranmkhgk(sonotanyranmkhgk);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyranytirrt(yoteiRiritu);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyransjkkktusirrt(sonotanyransjkkktusirrt);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyrangaimsgcd(pHokenSyouken.getStnaiyourangaimsgcd());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyrannkshrstartymd(FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pHokenSyouken.getSonotanyrannkshrstartymd()));
        pSinkeiyakuHokensyoukenTy.setZtysonotanyrannkkkn(String.valueOf(pHokenSyouken.getSonotanyrannenkinkkn()));
        pSinkeiyakuHokensyoukenTy.setZtysonotanytumitateriritu(sonotanytumitateriritu);
        pSinkeiyakuHokensyoukenTy.setZtysonotanytumitateriritu2(sonotanytumitateriritu2);
        pSinkeiyakuHokensyoukenTy.setZtysonotanytmttknzkrtjygn(sonotanytmttknzkrtjygn);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyransetteibairitu(sonotanyransetteibairitu);
        pSinkeiyakuHokensyoukenTy.setZtysonotanytmttkngktuktype(pHokenSyouken.getSonotanyrantmttkngktuktype());
        pSinkeiyakuHokensyoukenTy.setZtysonotanyteiritutmttkngk(sonotanyranteiritutmttkngk);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyransisuutmttkngk(sonotanyransisuutmttkngk);
        pSinkeiyakuHokensyoukenTy.setZtysonotanyransisuunm(pHokenSyouken.getSonotanyransisuunm());
        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            BizNumber rendouritu = pHokenSyouken.getHokenSyoukenHukaInfo().getRendouritu().multiply(100);

            if (rendouritu.compareTo(BizNumber.TEN) < 0) {

                pSinkeiyakuHokensyoukenTy.setZtysonotanyrendouritu(
                    "　　" +  ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(rendouritu), 1, 2), 0, 0));
            }
            else if (rendouritu.compareTo(BizNumber.valueOf(new BigDecimal(100))) < 0) {

                pSinkeiyakuHokensyoukenTy.setZtysonotanyrendouritu(
                    "　" +  ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(rendouritu), 2, 2), 0, 0));
            }
            else {

                pSinkeiyakuHokensyoukenTy.setZtysonotanyrendouritu(
                    ConvertUtil.toZenAll(BizUtil.zeroNum(String.valueOf(rendouritu), 3, 2), 0, 0));
            }
        }
        pSinkeiyakuHokensyoukenTy.setZtyshskyno(pHokenSyouken.getTsinyno());
        pSinkeiyakuHokensyoukenTy.setZtyshskadr1kj(pHokenSyouken.getTsinadr1kj());
        pSinkeiyakuHokensyoukenTy.setZtyshskadr2kj(pHokenSyouken.getTsinadr2kj());
        pSinkeiyakuHokensyoukenTy.setZtyshskadr3kj(pHokenSyouken.getTsinadr3kj());
        pSinkeiyakuHokensyoukenTy.setZtysouhusakinmkjsyouken(shsnmkj);
        pSinkeiyakuHokensyoukenTy.setZtytnknmissmsg(pHokenSyouken.getTnknmissmsg());
        pSinkeiyakuHokensyoukenTy.setZtyerrormsgcd(pHokenSyouken.getErrormsgcd());
        pSinkeiyakuHokensyoukenTy.setZtysisyacd(pHokenSyouken.getSisyacd());
        pSinkeiyakuHokensyoukenTy.setZtyduhutusnrntousaadrmsgcd(pHokenSyouken.getDuhutusnrntousaadrmsgcd());
        pSinkeiyakuHokensyoukenTy.setZtydufutusnrnsyono(pHokenSyouken.getDuhutusnrnsyono());
        pSinkeiyakuHokensyoukenTy.setZtydairitenmidasikbn(pHokenSyouken.getDairitenmidasikbn());
        pSinkeiyakuHokensyoukenTy.setZtybosyuudairitennmkanji1(pHokenSyouken.getDrtennm1kj());
        pSinkeiyakuHokensyoukenTy.setZtybosyuudairitennmkanji2(pHokenSyouken.getDrtennm2kj());
        pSinkeiyakuHokensyoukenTy.setZtydufutusnrnaisatumsgcd(pHokenSyouken.getAisatumsgcd());
        pSinkeiyakuHokensyoukenTy.setZtycallcentermsgcd(pHokenSyouken.getCcmsgcd());
        pSinkeiyakuHokensyoukenTy.setZtydufutusnrnhskmsgcd(pHokenSyouken.getHskmsgcd());
        pSinkeiyakuHokensyoukenTy.setZtyhosyounymsgcd(pHokenSyouken.getHosyounymsgcd());
        pSinkeiyakuHokensyoukenTy.setZtyhosyounyhihknsyanmkanji(hosyounyhihknsyameikanji);
        pSinkeiyakuHokensyoukenTy.setZtysiboumidasimsgcd(pHokenSyouken.getSiboumidasimsgcd());
        pSinkeiyakuHokensyoukenTy.setZtysiboudai1hknkknmsgcd1(pHokenSyouken.getSiboudai1hknkknmsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtysiboudai1hknkknmsgcd2(pHokenSyouken.getSiboudai1hknkknmsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtysiboudai1hknkknigimsgcd(pHokenSyouken.getSiboudai1hknkknigimsgcd());
        pSinkeiyakuHokensyoukenTy.setZtysiboudai1hknkknhrsmsgcd(pHokenSyouken.getSiboudai1hknkknhrsmsgcd());

        pSinkeiyakuHokensyoukenTy.setZtysiboudai1hknkknsmrmsgcd(pHokenSyouken.getSiboudai1hknkknsmrmsgcd());

        pSinkeiyakuHokensyoukenTy.setZtysiboudai2hknkknmsgcd1(pHokenSyouken.getSiboudai2hknkknmsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtysiboudai2hknkknmsgcd2(pHokenSyouken.getSiboudai2hknkknmsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtysiboudai2hknkknsmsgcd(pHokenSyouken.getSiboudai2hknkknsmsgcd());
        pSinkeiyakuHokensyoukenTy.setZtysiboudai3hknkknmsgcd1(pHokenSyouken.getSiboudai3hknkknmsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtysiboudai3hknkknmsgcd2(pHokenSyouken.getSiboudai3hknkknmsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtysiboudai1hknkkn(String.valueOf(pHokenSyouken.getSiboudai1hknkkn()));
        pSinkeiyakuHokensyoukenTy.setZtysibouitjbrpyentuuktype(String.valueOf(pHokenSyouken.getSibouitjbrpyentuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtysibouitjbrpyentuukgk(String.valueOf(pHokenSyouken.getSibouitjbrpyentuukgk()));
        pSinkeiyakuHokensyoukenTy.setZtysiboudai1kjnkngktuktype(String.valueOf(pHokenSyouken.getSiboudai1kjnkngktuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtysiboudai1kjnkngk(siboudai1kjnkngk);
        if (pHokenSyouken.getSiboudai1hknkknymdto() == null) {
            pSinkeiyakuHokensyoukenTy.setZtysiboudai1hknkknyokuymd("");
        }
        else {
            pSinkeiyakuHokensyoukenTy.setZtysiboudai1hknkknyokuymd(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pHokenSyouken.getSiboudai1hknkknymdto().addDays(1)));
        }
        pSinkeiyakuHokensyoukenTy.setZtysiboudai2hknkkn(String.valueOf(pHokenSyouken.getSiboudai2hknkkn()));
        pSinkeiyakuHokensyoukenTy.setZtysiboudai2kjnkngktuktype(String.valueOf(pHokenSyouken.getSiboudai2kjnkngktuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtysiboudai2kjnkngk(siboudai2kjnkngk);
        if (pHokenSyouken.getSiboudai2hknkknymdto() == null) {
            pSinkeiyakuHokensyoukenTy.setZtysiboudai2hknkknyokuymd("");
        }
        else {
            pSinkeiyakuHokensyoukenTy.setZtysiboudai2hknkknyokuymd(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pHokenSyouken.getSiboudai2hknkknymdto().addDays(1)));
        }
        pSinkeiyakuHokensyoukenTy.setZtysiboudai3kjnkngktuktype(String.valueOf(pHokenSyouken.getSiboudai3kjnkngktuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtysiboudai3kjnkngk(siboudai3kjnkngk);
        pSinkeiyakuHokensyoukenTy.setZtydai1skwsrateyendaka(dai1sKwsRateYenDaka);
        pSinkeiyakuHokensyoukenTy.setZtydai1skwsrateyenkijyun(dai1sKwsRateYenKijyun);
        pSinkeiyakuHokensyoukenTy.setZtydai1skwsrateyenyasu(dai1sKwsRateYenyasu);
        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu01(String.valueOf(pHokenSyouken.getDai1skeikanensuu01()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype01(String.valueOf(pHokenSyouken.getDai1stuuktype01()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s01(dai1s01);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu01(pHokenSyouken.getDai1syenyendakaumu01());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu01(pHokenSyouken.getDai1syenyenkijyunumu01());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu01(pHokenSyouken.getDai1syenyenyasuumu01());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype01(String.valueOf(pHokenSyouken.getDai1syentuuktype01()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka01(String.valueOf(pHokenSyouken.getDai1syenyendaka01()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun01(String.valueOf(pHokenSyouken.getDai1syenyenkijyun01()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu01(String.valueOf(pHokenSyouken.getDai1syenyenyasu01()));

        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndk01(dai1zennouzndk01);
            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndktype01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype01()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgk01(dai1sbjiuktgk01);
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgktype01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype01()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkytype01(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkydaka01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka01()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkykijyun01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun01()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkyyasu01(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu01()));
        }

        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu02(String.valueOf(pHokenSyouken.getDai1skeikanensuu02()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype02(String.valueOf(pHokenSyouken.getDai1stuuktype02()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s02(dai1s02);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu02(pHokenSyouken.getDai1syenyendakaumu02());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu02(pHokenSyouken.getDai1syenyenkijyunumu02());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu02(pHokenSyouken.getDai1syenyenyasuumu02());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype02(String.valueOf(pHokenSyouken.getDai1syentuuktype02()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka02(String.valueOf(pHokenSyouken.getDai1syenyendaka02()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun02(String.valueOf(pHokenSyouken.getDai1syenyenkijyun02()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu02(String.valueOf(pHokenSyouken.getDai1syenyenyasu02()));

        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndk02(dai1zennouzndk02);
            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndktype02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype02()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgk02(dai1sbjiuktgk02);
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgktype02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype02()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkytype02(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkydaka02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka02()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkykijyun02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun02()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkyyasu02(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu02()));
        }
        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu03(String.valueOf(pHokenSyouken.getDai1skeikanensuu03()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype03(String.valueOf(pHokenSyouken.getDai1stuuktype03()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s03(dai1s03);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu03(pHokenSyouken.getDai1syenyendakaumu03());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu03(pHokenSyouken.getDai1syenyenkijyunumu03());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu03(pHokenSyouken.getDai1syenyenyasuumu03());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype03(String.valueOf(pHokenSyouken.getDai1syentuuktype03()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka03(String.valueOf(pHokenSyouken.getDai1syenyendaka03()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun03(String.valueOf(pHokenSyouken.getDai1syenyenkijyun03()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu03(String.valueOf(pHokenSyouken.getDai1syenyenyasu03()));

        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndk03(dai1zennouzndk03);
            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndktype03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype03()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgk03(dai1sbjiuktgk03);
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgktype03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype03()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkytype03(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkydaka03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka03()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkykijyun03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun03()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkyyasu03(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu03()));
        }
        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu04(String.valueOf(pHokenSyouken.getDai1skeikanensuu04()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype04(String.valueOf(pHokenSyouken.getDai1stuuktype04()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s04(dai1s04);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu04(pHokenSyouken.getDai1syenyendakaumu04());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu04(pHokenSyouken.getDai1syenyenkijyunumu04());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu04(pHokenSyouken.getDai1syenyenyasuumu04());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype04(String.valueOf(pHokenSyouken.getDai1syentuuktype04()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka04(String.valueOf(pHokenSyouken.getDai1syenyendaka04()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun04(String.valueOf(pHokenSyouken.getDai1syenyenkijyun04()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu04(String.valueOf(pHokenSyouken.getDai1syenyenyasu04()));

        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndk04(dai1zennouzndk04);
            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndktype04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype04()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgk04(dai1sbjiuktgk04);
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgktype04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype04()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkytype04(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkydaka04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka04()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkykijyun04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun04()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkyyasu04(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu04()));
        }
        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu05(String.valueOf(pHokenSyouken.getDai1skeikanensuu05()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype05(String.valueOf(pHokenSyouken.getDai1stuuktype05()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s05(dai1s05);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu05(pHokenSyouken.getDai1syenyendakaumu05());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu05(pHokenSyouken.getDai1syenyenkijyunumu05());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu05(pHokenSyouken.getDai1syenyenyasuumu05());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype05(String.valueOf(pHokenSyouken.getDai1syentuuktype05()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka05(String.valueOf(pHokenSyouken.getDai1syenyendaka05()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun05(String.valueOf(pHokenSyouken.getDai1syenyenkijyun05()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu05(String.valueOf(pHokenSyouken.getDai1syenyenyasu05()));

        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndk05(dai1zennouzndk05);
            pSinkeiyakuHokensyoukenTy.setZtydai1zennouzndktype05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1zennouzndktype05()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgk05(dai1sbjiuktgk05);
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgktype05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgktype05()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkytype05(
                pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyentype().getValue());
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkydaka05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyendaka05()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkykijyun05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenkijyun05()));
            pSinkeiyakuHokensyoukenTy.setZtydai1sbjiuktgkyyasu05(
                String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getDai1sbjiuktgkyenyasu05()));
        }
        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu06(String.valueOf(pHokenSyouken.getDai1skeikanensuu06()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype06(String.valueOf(pHokenSyouken.getDai1stuuktype06()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s06(dai1s06);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu06(pHokenSyouken.getDai1syenyendakaumu06());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu06(pHokenSyouken.getDai1syenyenkijyunumu06());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu06(pHokenSyouken.getDai1syenyenyasuumu06());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype06(String.valueOf(pHokenSyouken.getDai1syentuuktype06()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka06(String.valueOf(pHokenSyouken.getDai1syenyendaka06()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun06(String.valueOf(pHokenSyouken.getDai1syenyenkijyun06()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu06(String.valueOf(pHokenSyouken.getDai1syenyenyasu06()));
        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu07(String.valueOf(pHokenSyouken.getDai1skeikanensuu07()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype07(String.valueOf(pHokenSyouken.getDai1stuuktype07().toString()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s07(dai1s07);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu07(pHokenSyouken.getDai1syenyendakaumu07());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu07(pHokenSyouken.getDai1syenyenkijyunumu07());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu07(pHokenSyouken.getDai1syenyenyasuumu07());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype07(String.valueOf(pHokenSyouken.getDai1syentuuktype07()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka07(String.valueOf(pHokenSyouken.getDai1syenyendaka07()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun07(String.valueOf(pHokenSyouken.getDai1syenyenkijyun07()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu07(String.valueOf(pHokenSyouken.getDai1syenyenyasu07()));
        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu08(String.valueOf(pHokenSyouken.getDai1skeikanensuu08()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype08(String.valueOf(pHokenSyouken.getDai1stuuktype08()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s08(dai1s08);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu08(pHokenSyouken.getDai1syenyendakaumu08());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu08(pHokenSyouken.getDai1syenyenkijyunumu08());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu08(pHokenSyouken.getDai1syenyenyasuumu08());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype08(String.valueOf(pHokenSyouken.getDai1syentuuktype08()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka08(String.valueOf(pHokenSyouken.getDai1syenyendaka08()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun08(String.valueOf(pHokenSyouken.getDai1syenyenkijyun08()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu08(String.valueOf(pHokenSyouken.getDai1syenyenyasu08()));
        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu09(String.valueOf(pHokenSyouken.getDai1skeikanensuu09()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype09(String.valueOf(pHokenSyouken.getDai1stuuktype09()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s09(dai1s09);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu09(pHokenSyouken.getDai1syenyendakaumu09());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu09(pHokenSyouken.getDai1syenyenkijyunumu09());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu09(pHokenSyouken.getDai1syenyenyasuumu09());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype09(String.valueOf(pHokenSyouken.getDai1syentuuktype09()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka09(String.valueOf(pHokenSyouken.getDai1syenyendaka09()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun09(String.valueOf(pHokenSyouken.getDai1syenyenkijyun09()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu09(String.valueOf(pHokenSyouken.getDai1syenyenyasu09()));
        pSinkeiyakuHokensyoukenTy.setZtydai1skeikanensuu10(String.valueOf(pHokenSyouken.getDai1skeikanensuu10()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktype10(String.valueOf(pHokenSyouken.getDai1stuuktype10()));
        pSinkeiyakuHokensyoukenTy.setZtydai1s10(dai1s10);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumu10(pHokenSyouken.getDai1syenyendakaumu10());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunumu10(pHokenSyouken.getDai1syenyenkijyunumu10());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumu10(pHokenSyouken.getDai1syenyenyasuumu10());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktype10(String.valueOf(pHokenSyouken.getDai1syentuuktype10()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendaka10(String.valueOf(pHokenSyouken.getDai1syenyendaka10()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyun10(String.valueOf(pHokenSyouken.getDai1syenyenkijyun10()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasu10(String.valueOf(pHokenSyouken.getDai1syenyenyasu10()));
        pSinkeiyakuHokensyoukenTy.setZtydai1stuuktypehuryo(String.valueOf(pHokenSyouken.getDai1stuuktypehuryo()));
        pSinkeiyakuHokensyoukenTy.setZtydai1shuryo(dai1shuryo);
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakaumuhuryo(pHokenSyouken.getDai1syenyendakaumuhuryo());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkjnumuhuryo(pHokenSyouken.getDai1syenyenkjnumuhuryo());
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuumuhuryo(pHokenSyouken.getDai1syenyenyasuumuhuryo());
        pSinkeiyakuHokensyoukenTy.setZtydai1syentuuktypehuryo(String.valueOf(pHokenSyouken.getDai1syentuuktypehuryo()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyendakahuryo(String.valueOf(pHokenSyouken.getDai1syenyendakahuryo()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenkijyunhuryo(String.valueOf(pHokenSyouken.getDai1syenyenkijyunhuryo()));
        pSinkeiyakuHokensyoukenTy.setZtydai1syenyenyasuhuryo(String.valueOf(pHokenSyouken.getDai1syenyenyasuhuryo()));
        pSinkeiyakuHokensyoukenTy.setZtydai2stuuktype(String.valueOf(pHokenSyouken.getDai2stuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtydai2s(dai2s);
        pSinkeiyakuHokensyoukenTy.setZtydai2syentuuktype(String.valueOf(pHokenSyouken.getDai2syentuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtydai2syenyendaka(String.valueOf(pHokenSyouken.getDai2syenyendaka()));
        pSinkeiyakuHokensyoukenTy.setZtydai2syenyenkijyun(String.valueOf(pHokenSyouken.getDai2syenyenkijyun()));
        pSinkeiyakuHokensyoukenTy.setZtydai2syenyenyasu(String.valueOf(pHokenSyouken.getDai2syenyenyasu()));
        pSinkeiyakuHokensyoukenTy.setZtydai3stuuktype(String.valueOf(pHokenSyouken.getDai3stuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtydai3s(dai3s);
        pSinkeiyakuHokensyoukenTy.setZtydai3syentuuktype(String.valueOf(pHokenSyouken.getDai3syentuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtydai3syenyendaka(String.valueOf(pHokenSyouken.getDai3syenyendaka()));
        pSinkeiyakuHokensyoukenTy.setZtydai3syenyenkijyun(String.valueOf(pHokenSyouken.getDai3syenyenkijyun()));
        pSinkeiyakuHokensyoukenTy.setZtydai3syenyenyasu(String.valueOf(pHokenSyouken.getDai3syenyenyasu()));
        pSinkeiyakuHokensyoukenTy.setZtysibouinjiptnkbn(pHokenSyouken.getSibouinjiptnkbn());
        pSinkeiyakuHokensyoukenTy.setZtymkhyouyensysnikoumsgcd(pHokenSyouken.getMkhyouyensysnikoumsgcd());
        pSinkeiyakuHokensyoukenTy.setZtymkhyouyensysnikougktype(String.valueOf(pHokenSyouken.getMkhyouyensysnikougktype()));
        pSinkeiyakuHokensyoukenTy.setZtymkhyouyensysnikougk(String.valueOf(pHokenSyouken.getMkhyouyensysnikougk()));
        pSinkeiyakuHokensyoukenTy.setZtymkhyouyensysnikouwra(String.valueOf(pHokenSyouken.getMkhyouyensysnikouwra()));
        pSinkeiyakuHokensyoukenTy.setZtymkhyouysysnikcurrentgk(String.valueOf(mkhyouysysnikcurrentgk));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrtkykmsgcd1(pHokenSyouken.getKaigomaehrtkykmsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrtkykmsgcd2(pHokenSyouken.getKaigomaehrtkykmsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrtkykmsgcdst1(pHokenSyouken.getKaigomaehrtkykmsgcdst1());
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrtkykmsgcdst2(pHokenSyouken.getKaigomaehrtkykmsgcdst2());
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrtkykkyktuuka(pHokenSyouken.getKaigomaehrtkykkyktuuka());
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrtkykstdmsgcd(pHokenSyouken.getKaigomaehrtkykstdmsgcd());
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugktype(String.valueOf(pHokenSyouken.getKaigomaehrjrugktype()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen01(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen01()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn01(kaigomaehrstikkn01);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk01(kaigomaehrjrugk01);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen02(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen02()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn02(kaigomaehrstikkn02);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk02(kaigomaehrjrugk02);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen03(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen03()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn03(kaigomaehrstikkn03);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk03(kaigomaehrjrugk03);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen04(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen04()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn04(kaigomaehrstikkn04);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk04(kaigomaehrjrugk04);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen05(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen05()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn05(kaigomaehrstikkn05);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk05(kaigomaehrjrugk05);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen06(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen06()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn06(kaigomaehrstikkn06);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk06(kaigomaehrjrugk06);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen07(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen07()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn07(kaigomaehrstikkn07);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk07(kaigomaehrjrugk07);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen08(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen08()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn08(kaigomaehrstikkn08);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk08(kaigomaehrjrugk08);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen09(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen09()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn09(kaigomaehrstikkn09);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk09(kaigomaehrjrugk09);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrsikuhhknnen10(String.valueOf(pHokenSyouken.getKaigomaehrsikuhhknnen10()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrstikkn10(kaigomaehrstikkn10);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugk10(kaigomaehrjrugk10);
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka01(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka01()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka02(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka02()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka03(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka03()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka04(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka04()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka05(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka05()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka06(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka06()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka07(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka07()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka08(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka08()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka09(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka09()));
        pSinkeiyakuHokensyoukenTy.setZtykaigomaehrjrugkydaka10(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkydaka10()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun01(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun01()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun02(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun02()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun03(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun03()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun04(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun04()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun05(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun05()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun06(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun06()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun07(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun07()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun08(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun08()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun09(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun09()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkykijyun10(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkykijyun10()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu01(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu01()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu02(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu02()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu03(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu03()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu04(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu04()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu05(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu05()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu06(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu06()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu07(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu07()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu08(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu08()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu09(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu09()));
        pSinkeiyakuHokensyoukenTy.setZtykgmaehrjrugkyyasu10(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getKaigomaehrjrugkyyasu10()));
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd1(pHokenSyouken.getNkmsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd2(pHokenSyouken.getNkmsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd3(pHokenSyouken.getNkmsgcd3());
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd4(pHokenSyouken.getNkmsgcd4());
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd5(pHokenSyouken.getNkmsgcd5());
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd6(pHokenSyouken.getNkmsgcd6());
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd7(pHokenSyouken.getNkmsgcd7());
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd8(pHokenSyouken.getNkmsgcd8());
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd9(pHokenSyouken.getNkmsgcd9());
        pSinkeiyakuHokensyoukenTy.setZtynkmsgcd10(pHokenSyouken.getNkmsgcd10());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd1(pHokenSyouken.getSiboukyuuhukinmsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd2(pHokenSyouken.getSiboukyuuhukinmsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd3(pHokenSyouken.getSiboukyuuhukinmsgcd3());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd4(pHokenSyouken.getSiboukyuuhukinmsgcd4());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd5(pHokenSyouken.getSiboukyuuhukinmsgcd5());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd6(pHokenSyouken.getSiboukyuuhukinmsgcd6());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd7(pHokenSyouken.getSiboukyuuhukinmsgcd7());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd8(pHokenSyouken.getSiboukyuuhukinmsgcd8());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd9(pHokenSyouken.getSiboukyuuhukinmsgcd9());
        pSinkeiyakuHokensyoukenTy.setZtysiboukyuuhukinmsgcd10(pHokenSyouken.getSiboukyuuhukinmsgcd10());
        if (BizUtil.isBlank(pHokenSyouken.getNkshrstartzenymd())) {
            pSinkeiyakuHokensyoukenTy.setZtynkshrstartzenymd("");
        }
        else {
            pSinkeiyakuHokensyoukenTy.setZtynkshrstartzenymd(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(pHokenSyouken.getNkshrstartzenymd())));
        }

        pSinkeiyakuHokensyoukenTy.setZtymkhyouyennkhknhentktype(pHokenSyouken.getMkhyouyennkhknhentktype());
        pSinkeiyakuHokensyoukenTy.setZtymkhyouyennkhknhentkmkhgk(String.valueOf(pHokenSyouken.getMkhyouyennkhknhentkmkhgk()));
        pSinkeiyakuHokensyoukenTy.setZtymkhyennkhknhentkmkhwari(String.valueOf(pHokenSyouken.getMkhyouyennkhknhentkmkhwari()));
        pSinkeiyakuHokensyoukenTy.setZtyhaibunwarimsgcd1(pHokenSyouken.getHaibunwarimsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtyhaibunwarimsgcd2(pHokenSyouken.getHaibunwarimsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtyhaibunwarimsgcd3(pHokenSyouken.getHaibunwarimsgcd3());
        pSinkeiyakuHokensyoukenTy.setZtyteiritutmtthbnwr(String.valueOf(pHokenSyouken.getTeiritutmtthbnwr()));
        pSinkeiyakuHokensyoukenTy.setZtysisuutmtthbnwr(String.valueOf(pHokenSyouken.getSisuutmtthbnwr()));
        pSinkeiyakuHokensyoukenTy.setZtysisuuannaimsg1(pHokenSyouken.getSisuuannaimsg1());
        pSinkeiyakuHokensyoukenTy.setZtysisuuannaimsg2(pHokenSyouken.getSisuuannaimsg2());
        pSinkeiyakuHokensyoukenTy.setZtysisuuannaimsg3(pHokenSyouken.getSisuuannaimsg3());

        if (pHokenSyouken.getHokenSyoukenHukaInfo() != null) {

            pSinkeiyakuHokensyoukenTy.setZtykzktourokuservicemsg1(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg1());
            pSinkeiyakuHokensyoukenTy.setZtykzktourokuservicemsg2(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg2());
            pSinkeiyakuHokensyoukenTy.setZtykzktourokuservicemsg3(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg3());
            pSinkeiyakuHokensyoukenTy.setZtykzktourokuservicemsg4(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg4());
            pSinkeiyakuHokensyoukenTy.setZtykzktourokuservicemsg5(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg5());
            pSinkeiyakuHokensyoukenTy.setZtykzktourokuservicemsg6(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg6());
            pSinkeiyakuHokensyoukenTy.setZtykzktourokuservicemsg7(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg7());
            pSinkeiyakuHokensyoukenTy.setZtykzktourokuservicemsg8(pHokenSyouken.getHokenSyoukenHukaInfo().getKzktourokuservicemsg8());
            pSinkeiyakuHokensyoukenTy.setZtytrkkzknm118(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzknmkj118());
            pSinkeiyakuHokensyoukenTy.setZtytrkkzksei1(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzksei1().getValue());
            pSinkeiyakuHokensyoukenTy.setZtytrkkzkseiymd1zenkaku(
                FixedDateFormatter.formatYMDZenkakuWarekiKanji(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkseiymd1()));
            pSinkeiyakuHokensyoukenTy.setZtytrkkzkyno1zenkaku(
                ConvertUtil.toZenAll(BizUtil.editYno(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkyno1()),0 ,1));
            pSinkeiyakuHokensyoukenTy.setZtytrkkzkadrkj1(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr1kj1() +
                pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr2kj1() +
                pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr3kj1());
            if (BizUtil.isBlank(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno1())) {

                pSinkeiyakuHokensyoukenTy.setZtytrkkzktelno1zenkaku(TEL_MITOUROKU);
            }
            else {

                pSinkeiyakuHokensyoukenTy.setZtytrkkzktelno1zenkaku(
                    ConvertUtil.toZenAll(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno1(), 0, 1));
            }
            pSinkeiyakuHokensyoukenTy.setZtytrkkzknm218(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzknmkj218());
            pSinkeiyakuHokensyoukenTy.setZtytrkkzksei2(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzksei2().getValue());
            pSinkeiyakuHokensyoukenTy.setZtytrkkzkseiymd2zenkaku(
                FixedDateFormatter.formatYMDZenkakuWarekiKanji(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkseiymd2()));
            pSinkeiyakuHokensyoukenTy.setZtytrkkzkyno2zenkaku(
                ConvertUtil.toZenAll(BizUtil.editYno(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkyno2()),0 ,1));
            pSinkeiyakuHokensyoukenTy.setZtytrkkzkadrkj2(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr1kj2() +
                pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr2kj2() +
                pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzkadr3kj2());
            if (BizUtil.isBlank(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno2())) {

                pSinkeiyakuHokensyoukenTy.setZtytrkkzktelno2zenkaku(TEL_MITOUROKU);
            }
            else {

                pSinkeiyakuHokensyoukenTy.setZtytrkkzktelno2zenkaku(
                    ConvertUtil.toZenAll(pHokenSyouken.getHokenSyoukenHukaInfo().getTrkkzktelno2(), 0, 1));
            }
            pSinkeiyakuHokensyoukenTy.setZtykykdairinm18(pHokenSyouken.getHokenSyoukenHukaInfo().getKykdairinm18());
            pSinkeiyakuHokensyoukenTy.setZtyhhkndairinm(pHokenSyouken.getHokenSyoukenHukaInfo().getHhkndairinm());
        }
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmmsgcdue01(pHokenSyouken.getHutanhiyustmmsgcdue01());
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmmsgcdue02(pHokenSyouken.getHutanhiyustmmsgcdue02());
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmmsgcdue03(pHokenSyouken.getHutanhiyustmmsgcdue03());
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmmsgcdue04(pHokenSyouken.getHutanhiyustmmsgcdue04());

        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmknsnhyuptn(pHokenSyouken.getHutanhiyustmknsnhyuptn());
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmmsgcdst01(pHokenSyouken.getHutanhiyustmmsgcdst01());
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmmsgcdst02(pHokenSyouken.getHutanhiyustmmsgcdst02());
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmmsgcdst03(pHokenSyouken.getHutanhiyustmmsgcdst03());
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmytijihiritu(ConvertUtil.toZenAll(
            BizUtil.zeroNum(String.valueOf(pHokenSyouken.getHutanhiyustmytijihiritu()),1, 1),0,0));
        pSinkeiyakuHokensyoukenTy.setZtystdstmmsgcd(pHokenSyouken.getStdstmmsgcd());
        pSinkeiyakuHokensyoukenTy.setZtyfstpmsgcd(pHokenSyouken.getFstpmsgcd());
        pSinkeiyakuHokensyoukenTy.setZtyfstphrkpkngkkeituuktype(String.valueOf(pHokenSyouken.getFstphrkpkngkkeituuktype()));
        pSinkeiyakuHokensyoukenTy.setZtyfstphrkpkngkkei(fstphrkpkngkkei);
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmkyakkjrtmin(ConvertUtil.toZenAll(BizUtil.zeroNum(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmin()), 1, 2), 0, 0));
        pSinkeiyakuHokensyoukenTy.setZtyhutanhiyustmkyakkjrtmax(ConvertUtil.toZenAll(BizUtil.zeroNum(
            String.valueOf(pHokenSyouken.getHokenSyoukenHukaInfo().getHutanhiyustmkyakkjrtmax().multiply(100)), 2, 1), 0, 0));
        pSinkeiyakuHokensyoukenTy.setZtyfstpznnkngktuktype(String.valueOf(
            pHokenSyouken.getHokenSyoukenHukaInfo().getFstpznnkngktuktype()));
        pSinkeiyakuHokensyoukenTy.setZtyfstpznnkngk(fstpznnkngk);
        pSinkeiyakuHokensyoukenTy.setZtydskjnkngkktuktype(String.valueOf(
            pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngkktuktype()));
        pSinkeiyakuHokensyoukenTy.setZtydskjnkngk(String.valueOf(
            pHokenSyouken.getHokenSyoukenHukaInfo().getDskjnkngk()));
        pSinkeiyakuHokensyoukenTy.setZtyfstponegaimsgcd(pHokenSyouken.getFstponegaimsgcd());
        pSinkeiyakuHokensyoukenTy.setZtydsmsgcd(pHokenSyouken.getDsmsgcd());
        pSinkeiyakuHokensyoukenTy.setZtysyouhnhutaimsgcd1(pHokenSyouken.getSyouhnhutaimsgcd1());
        pSinkeiyakuHokensyoukenTy.setZtysyouhnhutaimsgcd2(pHokenSyouken.getSyouhnhutaimsgcd2());
        pSinkeiyakuHokensyoukenTy.setZtypyentuuktype(String.valueOf(pHokenSyouken.getPyentuuktype()));
        pSinkeiyakuHokensyoukenTy.setZtypyen(String.valueOf(pHokenSyouken.getPyen()));
        pSinkeiyakuHokensyoukenTy.setZtytoiawasesakihanyoumsgcd(pHokenSyouken.getToiawasesakihanyoumsgcd());
        pSinkeiyakuHokensyoukenTy.setZtyannaihanyoumsgcd(pHokenSyouken.getAnnaihanyoumsgcd());
        pSinkeiyakuHokensyoukenTy.setZtysioriwebuktriannaimsgcd(pHokenSyouken.getSioriwebuktriannaimsgcd());
        BizPropertyInitializer.initialize(pSinkeiyakuHokensyoukenTy);

        return pSinkeiyakuHokensyoukenTy;
    }

    private ZT_SinkeiyakuSyoukenSuiiTy editSinkeiyakuSyoukenSuiiTy(
        IT_HokenSyouken pHokenSyouken, IT_Suiihyou pSuiihyou, IT_KoujyoSym pKoujyoSym ) {

        ZT_SinkeiyakuSyoukenSuiiTy pSinkeiyakuSyoukenSuiiTy = new ZT_SinkeiyakuSyoukenSuiiTy();

        pSinkeiyakuSyoukenSuiiTy.setZtysyono(pSuiihyou.getSyono());
        pSinkeiyakuSyoukenSuiiTy.setZtytyouhyouymd(pSuiihyou.getTyouhyouymd().toString());
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyouptn(SUIIHYOU_PTN1);
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyousyono(pSuiihyou.getSyono());
        pSinkeiyakuSyoukenSuiiTy.setZtysisuuupritu(SISUUUPRITU_PTN1);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrtup(sjkkktusirrtup);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrtsame(sjkkktusirrtsame);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrtdown(sjkkktusirrtdown);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrthendouup(sjkkktusirrthendouup);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrthendoudown(sjkkktusirrthendoudown);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsrateyendaka(yenKnsnKwsRateYenDaka);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsratehabayendaka(String.valueOf(pSuiihyou.getYenknsnkwsrategkyendaka()));
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsrateyenkijyun(yenKnsnKwsRateYenKijyun);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsrateyenyasu(yenKnsnKwsRateYenYasu);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsratehabayenyasu(String.valueOf(pSuiihyou.getYenknsnkwsrategkyenyasu()));
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyoumkhyouyenwra(String.valueOf(pHokenSyouken.getMkhyouyensysnikouwra()));

        editSinkeiyakuSyoukenSuiiTy1(pSinkeiyakuSyoukenSuiiTy);

        editSinkeiyakuSyoukenSuiiTy2(pHokenSyouken ,pSinkeiyakuSyoukenSuiiTy);

        editSinkeiyakuSyoukenSuiiTy3(pHokenSyouken, pKoujyoSym, pSinkeiyakuSyoukenSuiiTy);

        pSinkeiyakuSyoukenSuiiTy.setZtykyknmkn(pHokenSyouken.getKyknmkn());

        BizPropertyInitializer.initialize(pSinkeiyakuSyoukenSuiiTy);

        return pSinkeiyakuSyoukenSuiiTy;
    }

    private ZT_SinkeiyakuSyoukenSuiiTy editSinkeiyakuSyoukenSuiiTy2(
        IT_HokenSyouken pHokenSyouken, IT_Suiihyou pSuiihyou, IT_KoujyoSym pKoujyoSym ) {

        ZT_SinkeiyakuSyoukenSuiiTy pSinkeiyakuSyoukenSuiiTy = new ZT_SinkeiyakuSyoukenSuiiTy();

        pSinkeiyakuSyoukenSuiiTy.setZtysyono(pSuiihyou.getSyono());
        pSinkeiyakuSyoukenSuiiTy.setZtytyouhyouymd(pSuiihyou.getTyouhyouymd().toString());
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyouptn(SUIIHYOU_PTN2);
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyousyono(pSuiihyou.getSyono());
        pSinkeiyakuSyoukenSuiiTy.setZtysisuuupritu(SISUUUPRITU_PTN2);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrtup(sjkkktusirrtup2);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrtsame(sjkkktusirrtsame2);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrtdown(sjkkktusirrtdown2);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrthendouup(sjkkktusirrthendouup2);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrthendoudown(sjkkktusirrthendoudown2);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsrateyendaka(yenknsnkwsrateyendaka2);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsratehabayendaka(String.valueOf(pSuiihyou.getYenknsnkwsrategkyendaka2()));
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsrateyenkijyun(yenknsnkwsrateyenkijyun2);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsrateyenyasu(yenknsnkwsrateyenyasu2);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsratehabayenyasu(String.valueOf(pSuiihyou.getYenknsnkwsrategkyenyasu2()));
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyoumkhyouyenwra(String.valueOf(pHokenSyouken.getMkhyouyensysnikouwra()));

        editSinkeiyakuSyoukenSuiiTy12(pSinkeiyakuSyoukenSuiiTy);

        editSinkeiyakuSyoukenSuiiTy22(pHokenSyouken ,pSinkeiyakuSyoukenSuiiTy);

        editSinkeiyakuSyoukenSuiiTy3(pHokenSyouken, pKoujyoSym, pSinkeiyakuSyoukenSuiiTy);

        pSinkeiyakuSyoukenSuiiTy.setZtykyknmkn(pHokenSyouken.getKyknmkn());

        BizPropertyInitializer.initialize(pSinkeiyakuSyoukenSuiiTy);

        return pSinkeiyakuSyoukenSuiiTy;
    }

    private ZT_SinkeiyakuSyoukenSuiiTy editSinkeiyakuSyoukenSuiiTy3(
        IT_HokenSyouken pHokenSyouken, IT_Suiihyou pSuiihyou, IT_KoujyoSym pKoujyoSym ) {

        ZT_SinkeiyakuSyoukenSuiiTy pSinkeiyakuSyoukenSuiiTy = new ZT_SinkeiyakuSyoukenSuiiTy();

        pSinkeiyakuSyoukenSuiiTy.setZtysyono(pSuiihyou.getSyono());
        pSinkeiyakuSyoukenSuiiTy.setZtytyouhyouymd(pSuiihyou.getTyouhyouymd().toString());
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyouptn(SUIIHYOU_PTN3);
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyousyono(pSuiihyou.getSyono());
        pSinkeiyakuSyoukenSuiiTy.setZtysisuuupritu(SISUUUPRITU_PTN3);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrtup(sjkkktusirrtup3);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrtsame(sjkkktusirrtsame3);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrtdown(sjkkktusirrtdown3);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrthendouup(sjkkktusirrthendouup3);
        pSinkeiyakuSyoukenSuiiTy.setZtysjkkktusirrthendoudown(sjkkktusirrthendoudown3);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsrateyendaka(yenknsnkwsrateyendaka3);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsratehabayendaka(String.valueOf(pSuiihyou.getYenknsnkwsrategkyendaka3()));
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsrateyenkijyun(yenknsnkwsrateyenkijyun3);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsrateyenyasu(yenknsnkwsrateyenyasu3);
        pSinkeiyakuSyoukenSuiiTy.setZtywkwsratehabayenyasu(String.valueOf(pSuiihyou.getYenknsnkwsrategkyenyasu3()));
        pSinkeiyakuSyoukenSuiiTy.setZtysuiihyoumkhyouyenwra(String.valueOf(pHokenSyouken.getMkhyouyensysnikouwra()));

        editSinkeiyakuSyoukenSuiiTy13(pSinkeiyakuSyoukenSuiiTy);

        editSinkeiyakuSyoukenSuiiTy23(pHokenSyouken ,pSinkeiyakuSyoukenSuiiTy);

        editSinkeiyakuSyoukenSuiiTy3(pHokenSyouken, pKoujyoSym, pSinkeiyakuSyoukenSuiiTy);

        pSinkeiyakuSyoukenSuiiTy.setZtykyknmkn(pHokenSyouken.getKyknmkn());

        BizPropertyInitializer.initialize(pSinkeiyakuSyoukenSuiiTy);

        return pSinkeiyakuSyoukenSuiiTy;
    }

    private void editSinkeiyakuSyoukenSuiiTy1(
        ZT_SinkeiyakuSyoukenSuiiTy pSinkeiyakuSyoukenSuiiTy) {

        if (!BizUtil.isBlank(mvaarikeikanensuu[0])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu01(mvaarikeikanensuu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu01(sisuuupritu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu01(tmttknzoukaritu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup01(mvaariwtuktypeup[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup01(mvaaritmttkgkkykkjmaeup[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup01(mvaariwup[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka01(mvaariwupyendaka[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun01(mvaariwupyenkijyun[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu01(mvaariwupyenyasu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame01(mvaariwtuktypesame[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame01(mvaaritmttkgkkykkjmaesame[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame01(mvaariwsame[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka01(mvaariwsameyendaka[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun01(mvaariwsameyenkijyun[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu01(mvaariwsameyenyasu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown01(mvaariwtuktypedown[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown01(mvaaritmttkgkkykkjmaedown[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown01(mvaariwdown[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka01(mvaariwdownyendaka[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun01(mvaariwdownyenkijyun[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu01(mvaariwdownyenyasu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype01(mvaarivtuktype[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv01(mvaariv[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake101(tutmttknutiwake1[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake201(tutmttknutiwake2[0]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[1])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu02(mvaarikeikanensuu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu02(sisuuupritu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu02(tmttknzoukaritu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup02(mvaariwtuktypeup[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup02(mvaaritmttkgkkykkjmaeup[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup02(mvaariwup[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka02(mvaariwupyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun02(mvaariwupyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu02(mvaariwupyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka02(mvaariwumupyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun02(mvaariumupyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu02(mvaariumupyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame02(mvaariwtuktypesame[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame02(mvaaritmttkgkkykkjmaesame[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame02(mvaariwsame[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka02(mvaariwsameyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun02(mvaariwsameyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu02(mvaariwsameyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka02(mvaariumsameyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun02(mvaariumsameyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu02(mvaariumsameyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown02(mvaariwtuktypedown[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown02(mvaaritmttkgkkykkjmaedown[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown02(mvaariwdown[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka02(mvaariwdownyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun02(mvaariwdownyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu02(mvaariwdownyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka02(mvaariumdownyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun02(mvaariumdownyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu02(mvaariumdownyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype02(mvaarivtuktype[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv02(mvaariv[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake102(tutmttknutiwake1[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake202(tutmttknutiwake2[1]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[2])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu03(mvaarikeikanensuu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu03(sisuuupritu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu03(tmttknzoukaritu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup03(mvaariwtuktypeup[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup03(mvaaritmttkgkkykkjmaeup[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup03(mvaariwup[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka03(mvaariwupyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun03(mvaariwupyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu03(mvaariwupyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka03(mvaariwumupyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun03(mvaariumupyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu03(mvaariumupyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame03(mvaariwtuktypesame[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame03(mvaaritmttkgkkykkjmaesame[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame03(mvaariwsame[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka03(mvaariwsameyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun03(mvaariwsameyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu03(mvaariwsameyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka03(mvaariumsameyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun03(mvaariumsameyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu03(mvaariumsameyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown03(mvaariwtuktypedown[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown03(mvaaritmttkgkkykkjmaedown[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown03(mvaariwdown[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka03(mvaariwdownyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun03(mvaariwdownyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu03(mvaariwdownyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka03(mvaariumdownyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun03(mvaariumdownyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu03(mvaariumdownyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype03(mvaarivtuktype[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv03(mvaariv[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake103(tutmttknutiwake1[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake203(tutmttknutiwake2[2]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[3])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu04(mvaarikeikanensuu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu04(sisuuupritu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu04(tmttknzoukaritu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup04(mvaariwtuktypeup[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup04(mvaaritmttkgkkykkjmaeup[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup04(mvaariwup[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka04(mvaariwupyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun04(mvaariwupyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu04(mvaariwupyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka04(mvaariwumupyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun04(mvaariumupyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu04(mvaariumupyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame04(mvaariwtuktypesame[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame04(mvaaritmttkgkkykkjmaesame[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame04(mvaariwsame[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka04(mvaariwsameyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun04(mvaariwsameyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu04(mvaariwsameyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka04(mvaariumsameyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun04(mvaariumsameyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu04(mvaariumsameyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown04(mvaariwtuktypedown[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown04(mvaaritmttkgkkykkjmaedown[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown04(mvaariwdown[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka04(mvaariwdownyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun04(mvaariwdownyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu04(mvaariwdownyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka04(mvaariumdownyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun04(mvaariumdownyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu04(mvaariumdownyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype04(mvaarivtuktype[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv04(mvaariv[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake104(tutmttknutiwake1[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake204(tutmttknutiwake2[3]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[4])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu05(mvaarikeikanensuu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu05(sisuuupritu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu05(tmttknzoukaritu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup05(mvaariwtuktypeup[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup05(mvaaritmttkgkkykkjmaeup[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup05(mvaariwup[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka05(mvaariwupyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun05(mvaariwupyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu05(mvaariwupyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka05(mvaariwumupyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun05(mvaariumupyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu05(mvaariumupyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame05(mvaariwtuktypesame[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame05(mvaaritmttkgkkykkjmaesame[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame05(mvaariwsame[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka05(mvaariwsameyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun05(mvaariwsameyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu05(mvaariwsameyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka05(mvaariumsameyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun05(mvaariumsameyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu05(mvaariumsameyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown05(mvaariwtuktypedown[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown05(mvaaritmttkgkkykkjmaedown[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown05(mvaariwdown[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka05(mvaariwdownyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun05(mvaariwdownyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu05(mvaariwdownyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka05(mvaariumdownyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun05(mvaariumdownyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu05(mvaariumdownyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype05(mvaarivtuktype[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv05(mvaariv[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake105(tutmttknutiwake1[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake205(tutmttknutiwake2[4]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[5])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu06(mvaarikeikanensuu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu06(sisuuupritu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu06(tmttknzoukaritu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup06(mvaariwtuktypeup[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup06(mvaaritmttkgkkykkjmaeup[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup06(mvaariwup[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka06(mvaariwupyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun06(mvaariwupyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu06(mvaariwupyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka06(mvaariwumupyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun06(mvaariumupyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu06(mvaariumupyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame06(mvaariwtuktypesame[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame06(mvaaritmttkgkkykkjmaesame[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame06(mvaariwsame[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka06(mvaariwsameyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun06(mvaariwsameyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu06(mvaariwsameyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka06(mvaariumsameyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun06(mvaariumsameyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu06(mvaariumsameyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown06(mvaariwtuktypedown[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown06(mvaaritmttkgkkykkjmaedown[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown06(mvaariwdown[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka06(mvaariwdownyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun06(mvaariwdownyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu06(mvaariwdownyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka06(mvaariumdownyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun06(mvaariumdownyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu06(mvaariumdownyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype06(mvaarivtuktype[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv06(mvaariv[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake106(tutmttknutiwake1[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake206(tutmttknutiwake2[5]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[6])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu07(mvaarikeikanensuu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu07(sisuuupritu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu07(tmttknzoukaritu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup07(mvaariwtuktypeup[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup07(mvaaritmttkgkkykkjmaeup[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup07(mvaariwup[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka07(mvaariwupyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun07(mvaariwupyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu07(mvaariwupyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka07(mvaariwumupyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun07(mvaariumupyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu07(mvaariumupyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame07(mvaariwtuktypesame[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame07(mvaaritmttkgkkykkjmaesame[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame07(mvaariwsame[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka07(mvaariwsameyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun07(mvaariwsameyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu07(mvaariwsameyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka07(mvaariumsameyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun07(mvaariumsameyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu07(mvaariumsameyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown07(mvaariwtuktypedown[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown07(mvaaritmttkgkkykkjmaedown[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown07(mvaariwdown[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka07(mvaariwdownyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun07(mvaariwdownyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu07(mvaariwdownyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka07(mvaariumdownyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun07(mvaariumdownyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu07(mvaariumdownyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype07(mvaarivtuktype[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv07(mvaariv[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake107(tutmttknutiwake1[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake207(tutmttknutiwake2[6]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[7])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu08(mvaarikeikanensuu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu08(sisuuupritu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu08(tmttknzoukaritu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup08(mvaariwtuktypeup[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup08(mvaaritmttkgkkykkjmaeup[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup08(mvaariwup[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka08(mvaariwupyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun08(mvaariwupyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu08(mvaariwupyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka08(mvaariwumupyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun08(mvaariumupyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu08(mvaariumupyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame08(mvaariwtuktypesame[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame08(mvaaritmttkgkkykkjmaesame[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame08(mvaariwsame[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka08(mvaariwsameyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun08(mvaariwsameyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu08(mvaariwsameyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka08(mvaariumsameyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun08(mvaariumsameyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu08(mvaariumsameyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown08(mvaariwtuktypedown[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown08(mvaaritmttkgkkykkjmaedown[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown08(mvaariwdown[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka08(mvaariwdownyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun08(mvaariwdownyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu08(mvaariwdownyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka08(mvaariumdownyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun08(mvaariumdownyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu08(mvaariumdownyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype08(mvaarivtuktype[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv08(mvaariv[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake108(tutmttknutiwake1[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake208(tutmttknutiwake2[7]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[8])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu09(mvaarikeikanensuu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu09(sisuuupritu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu09(tmttknzoukaritu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup09(mvaariwtuktypeup[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup09(mvaaritmttkgkkykkjmaeup[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup09(mvaariwup[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka09(mvaariwupyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun09(mvaariwupyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu09(mvaariwupyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka09(mvaariwumupyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun09(mvaariumupyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu09(mvaariumupyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame09(mvaariwtuktypesame[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame09(mvaaritmttkgkkykkjmaesame[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame09(mvaariwsame[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka09(mvaariwsameyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun09(mvaariwsameyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu09(mvaariwsameyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka09(mvaariumsameyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun09(mvaariumsameyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu09(mvaariumsameyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown09(mvaariwtuktypedown[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown09(mvaaritmttkgkkykkjmaedown[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown09(mvaariwdown[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka09(mvaariwdownyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun09(mvaariwdownyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu09(mvaariwdownyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka09(mvaariumdownyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun09(mvaariumdownyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu09(mvaariumdownyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype09(mvaarivtuktype[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv09(mvaariv[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake109(tutmttknutiwake1[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake209(tutmttknutiwake2[8]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[9])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu10(mvaarikeikanensuu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu10(sisuuupritu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu10(tmttknzoukaritu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup10(mvaariwtuktypeup[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup10(mvaaritmttkgkkykkjmaeup[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup10(mvaariwup[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka10(mvaariwupyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun10(mvaariwupyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu10(mvaariwupyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka10(mvaariwumupyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun10(mvaariumupyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu10(mvaariumupyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame10(mvaariwtuktypesame[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame10(mvaaritmttkgkkykkjmaesame[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame10(mvaariwsame[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka10(mvaariwsameyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun10(mvaariwsameyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu10(mvaariwsameyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka10(mvaariumsameyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun10(mvaariumsameyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu10(mvaariumsameyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown10(mvaariwtuktypedown[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown10(mvaaritmttkgkkykkjmaedown[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown10(mvaariwdown[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka10(mvaariwdownyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun10(mvaariwdownyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu10(mvaariwdownyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka10(mvaariumdownyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun10(mvaariumdownyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu10(mvaariumdownyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype10(mvaarivtuktype[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv10(mvaariv[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake110(tutmttknutiwake1[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake210(tutmttknutiwake2[9]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[10])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu11(mvaarikeikanensuu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup11(mvaariwtuktypeup[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup11(mvaariwup[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka11(mvaariwupyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun11(mvaariwupyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu11(mvaariwupyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka11(mvaariwumupyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun11(mvaariumupyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu11(mvaariumupyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame11(mvaariwtuktypesame[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame11(mvaariwsame[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka11(mvaariwsameyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun11(mvaariwsameyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu11(mvaariwsameyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka11(mvaariumsameyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun11(mvaariumsameyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu11(mvaariumsameyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown11(mvaariwtuktypedown[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown11(mvaariwdown[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka11(mvaariwdownyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun11(mvaariwdownyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu11(mvaariwdownyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka11(mvaariumdownyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun11(mvaariumdownyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu11(mvaariumdownyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype11(mvaarivtuktype[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv11(mvaariv[10]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[11])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu12(mvaarikeikanensuu[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup12(mvaariwtuktypeup[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup12(mvaariwup[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup12(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka12(mvaariwupyendaka[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun12(mvaariwupyenkijyun[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu12(mvaariwupyenyasu[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka12(mvaariwumupyendaka[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun12(mvaariumupyenkijyun[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu12(mvaariumupyenyasu[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame12(mvaariwtuktypesame[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame12(mvaariwsame[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame12(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka12(mvaariwsameyendaka[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun12(mvaariwsameyenkijyun[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu12(mvaariwsameyenyasu[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka12(mvaariumsameyendaka[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun12(mvaariumsameyenkijyun[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu12(mvaariumsameyenyasu[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown12(mvaariwtuktypedown[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown12(mvaariwdown[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown12(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka12(mvaariwdownyendaka[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun12(mvaariwdownyenkijyun[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu12(mvaariwdownyenyasu[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka12(mvaariumdownyendaka[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun12(mvaariumdownyenkijyun[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu12(mvaariumdownyenyasu[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype12(mvaarivtuktype[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv12(mvaariv[11]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[12])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu13(mvaarikeikanensuu[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup13(mvaariwtuktypeup[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup13(mvaariwup[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup13(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka13(mvaariwupyendaka[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun13(mvaariwupyenkijyun[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu13(mvaariwupyenyasu[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka13(mvaariwumupyendaka[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun13(mvaariumupyenkijyun[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu13(mvaariumupyenyasu[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame13(mvaariwtuktypesame[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame13(mvaariwsame[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame13(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka13(mvaariwsameyendaka[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun13(mvaariwsameyenkijyun[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu13(mvaariwsameyenyasu[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka13(mvaariumsameyendaka[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun13(mvaariumsameyenkijyun[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu13(mvaariumsameyenyasu[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown13(mvaariwtuktypedown[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown13(mvaariwdown[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown13(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka13(mvaariwdownyendaka[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun13(mvaariwdownyenkijyun[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu13(mvaariwdownyenyasu[12]);

            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka13(mvaariumdownyendaka[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun13(mvaariumdownyenkijyun[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu13(mvaariumdownyenyasu[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype13(mvaarivtuktype[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv13(mvaariv[12]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[13])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu14(mvaarikeikanensuu[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup14(mvaariwtuktypeup[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup14(mvaariwup[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup14(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka14(mvaariwupyendaka[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun14(mvaariwupyenkijyun[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu14(mvaariwupyenyasu[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka14(mvaariwumupyendaka[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun14(mvaariumupyenkijyun[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu14(mvaariumupyenyasu[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame14(mvaariwtuktypesame[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame14(mvaariwsame[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame14(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka14(mvaariwsameyendaka[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun14(mvaariwsameyenkijyun[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu14(mvaariwsameyenyasu[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka14(mvaariumsameyendaka[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun14(mvaariumsameyenkijyun[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu14(mvaariumsameyenyasu[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown14(mvaariwtuktypedown[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown14(mvaariwdown[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown14(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka14(mvaariwdownyendaka[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun14(mvaariwdownyenkijyun[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu14(mvaariwdownyenyasu[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka14(mvaariumdownyendaka[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun14(mvaariumdownyenkijyun[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu14(mvaariumdownyenyasu[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype14(mvaarivtuktype[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv14(mvaariv[13]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[14])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu15(mvaarikeikanensuu[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup15(mvaariwtuktypeup[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup15(mvaariwup[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup15(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka15(mvaariwupyendaka[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun15(mvaariwupyenkijyun[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu15(mvaariwupyenyasu[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka15(mvaariwumupyendaka[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun15(mvaariumupyenkijyun[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu15(mvaariumupyenyasu[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame15(mvaariwtuktypesame[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame15(mvaariwsame[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame15(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka15(mvaariwsameyendaka[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun15(mvaariwsameyenkijyun[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu15(mvaariwsameyenyasu[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka15(mvaariumsameyendaka[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun15(mvaariumsameyenkijyun[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu15(mvaariumsameyenyasu[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown15(mvaariwtuktypedown[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown15(mvaariwdown[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown15(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka15(mvaariwdownyendaka[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun15(mvaariwdownyenkijyun[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu15(mvaariwdownyenyasu[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka15(mvaariumdownyendaka[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun15(mvaariumdownyenkijyun[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu15(mvaariumdownyenyasu[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype15(mvaarivtuktype[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv15(mvaariv[14]);
        }
    }

    private void editSinkeiyakuSyoukenSuiiTy12(
        ZT_SinkeiyakuSyoukenSuiiTy pSinkeiyakuSyoukenSuiiTy) {

        if (!BizUtil.isBlank(mvaarikeikanensuu[0])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu01(mvaarikeikanensuu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu01(sisuuupritu2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu01(tmttknzoukaritu2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup01(mvaariwtuktypeup[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup01(mvaaritmttkgkkykkjmaeup2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup01(mvaariwup2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka01(mvaariwupyendaka2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun01(mvaariwupyenkijyun2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu01(mvaariwupyenyasu2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame01(mvaariwtuktypesame[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame01(mvaaritmttkgkkykkjmaesame2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame01(mvaariwsame2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka01(mvaariwsameyendaka2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun01(mvaariwsameyenkijyun2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu01(mvaariwsameyenyasu2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown01(mvaariwtuktypedown[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown01(mvaaritmttkgkkykkjmaedown2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown01(mvaariwdown2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka01(mvaariwdownyendaka2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun01(mvaariwdownyenkijyun2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu01(mvaariwdownyenyasu2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype01(mvaarivtuktype[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv01(mvaariv2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake101(tutmttknutiwake12[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake201(tutmttknutiwake22[0]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[1])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu02(mvaarikeikanensuu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu02(sisuuupritu2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu02(tmttknzoukaritu2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup02(mvaariwtuktypeup[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup02(mvaaritmttkgkkykkjmaeup2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup02(mvaariwup2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka02(mvaariwupyendaka2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun02(mvaariwupyenkijyun2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu02(mvaariwupyenyasu2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka02(mvaariwumupyendaka2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun02(mvaariumupyenkijyun2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu02(mvaariumupyenyasu2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame02(mvaariwtuktypesame[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame02(mvaaritmttkgkkykkjmaesame2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame02(mvaariwsame2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka02(mvaariwsameyendaka2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun02(mvaariwsameyenkijyun2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu02(mvaariwsameyenyasu2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka02(mvaariumsameyendaka2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun02(mvaariumsameyenkijyun2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu02(mvaariumsameyenyasu2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown02(mvaariwtuktypedown[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown02(mvaaritmttkgkkykkjmaedown2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown02(mvaariwdown2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka02(mvaariwdownyendaka2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun02(mvaariwdownyenkijyun2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu02(mvaariwdownyenyasu2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka02(mvaariumdownyendaka2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun02(mvaariumdownyenkijyun2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu02(mvaariumdownyenyasu2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype02(mvaarivtuktype[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv02(mvaariv2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake102(tutmttknutiwake12[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake202(tutmttknutiwake22[1]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[2])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu03(mvaarikeikanensuu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu03(sisuuupritu2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu03(tmttknzoukaritu2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup03(mvaariwtuktypeup[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup03(mvaaritmttkgkkykkjmaeup2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup03(mvaariwup2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka03(mvaariwupyendaka2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun03(mvaariwupyenkijyun2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu03(mvaariwupyenyasu2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka03(mvaariwumupyendaka2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun03(mvaariumupyenkijyun2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu03(mvaariumupyenyasu2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame03(mvaariwtuktypesame[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame03(mvaaritmttkgkkykkjmaesame2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame03(mvaariwsame2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka03(mvaariwsameyendaka2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun03(mvaariwsameyenkijyun2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu03(mvaariwsameyenyasu2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka03(mvaariumsameyendaka2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun03(mvaariumsameyenkijyun2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu03(mvaariumsameyenyasu2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown03(mvaariwtuktypedown[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown03(mvaaritmttkgkkykkjmaedown2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown03(mvaariwdown2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka03(mvaariwdownyendaka2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun03(mvaariwdownyenkijyun2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu03(mvaariwdownyenyasu2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka03(mvaariumdownyendaka2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun03(mvaariumdownyenkijyun2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu03(mvaariumdownyenyasu2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype03(mvaarivtuktype[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv03(mvaariv2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake103(tutmttknutiwake12[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake203(tutmttknutiwake22[2]);
        }


        if (!BizUtil.isBlank(mvaarikeikanensuu[3])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu04(mvaarikeikanensuu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu04(sisuuupritu2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu04(tmttknzoukaritu2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup04(mvaariwtuktypeup[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup04(mvaaritmttkgkkykkjmaeup2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup04(mvaariwup2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka04(mvaariwupyendaka2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun04(mvaariwupyenkijyun2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu04(mvaariwupyenyasu2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka04(mvaariwumupyendaka2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun04(mvaariumupyenkijyun2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu04(mvaariumupyenyasu2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame04(mvaariwtuktypesame[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame04(mvaaritmttkgkkykkjmaesame2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame04(mvaariwsame2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka04(mvaariwsameyendaka2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun04(mvaariwsameyenkijyun2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu04(mvaariwsameyenyasu2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka04(mvaariumsameyendaka2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun04(mvaariumsameyenkijyun2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu04(mvaariumsameyenyasu2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown04(mvaariwtuktypedown[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown04(mvaaritmttkgkkykkjmaedown2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown04(mvaariwdown2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka04(mvaariwdownyendaka2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun04(mvaariwdownyenkijyun2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu04(mvaariwdownyenyasu2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka04(mvaariumdownyendaka2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun04(mvaariumdownyenkijyun2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu04(mvaariumdownyenyasu2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype04(mvaarivtuktype[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv04(mvaariv2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake104(tutmttknutiwake12[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake204(tutmttknutiwake22[3]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[4])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu05(mvaarikeikanensuu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu05(sisuuupritu2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu05(tmttknzoukaritu2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup05(mvaariwtuktypeup[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup05(mvaaritmttkgkkykkjmaeup2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup05(mvaariwup2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka05(mvaariwupyendaka2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun05(mvaariwupyenkijyun2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu05(mvaariwupyenyasu2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka05(mvaariwumupyendaka2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun05(mvaariumupyenkijyun2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu05(mvaariumupyenyasu2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame05(mvaariwtuktypesame[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame05(mvaaritmttkgkkykkjmaesame2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame05(mvaariwsame2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka05(mvaariwsameyendaka2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun05(mvaariwsameyenkijyun2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu05(mvaariwsameyenyasu2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka05(mvaariumsameyendaka2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun05(mvaariumsameyenkijyun2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu05(mvaariumsameyenyasu2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown05(mvaariwtuktypedown[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown05(mvaaritmttkgkkykkjmaedown2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown05(mvaariwdown2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka05(mvaariwdownyendaka2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun05(mvaariwdownyenkijyun2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu05(mvaariwdownyenyasu2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka05(mvaariumdownyendaka2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun05(mvaariumdownyenkijyun2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu05(mvaariumdownyenyasu2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype05(mvaarivtuktype[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv05(mvaariv2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake105(tutmttknutiwake12[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake205(tutmttknutiwake22[4]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[5])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu06(mvaarikeikanensuu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu06(sisuuupritu2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu06(tmttknzoukaritu2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup06(mvaariwtuktypeup[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup06(mvaaritmttkgkkykkjmaeup2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup06(mvaariwup2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka06(mvaariwupyendaka2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun06(mvaariwupyenkijyun2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu06(mvaariwupyenyasu2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka06(mvaariwumupyendaka2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun06(mvaariumupyenkijyun2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu06(mvaariumupyenyasu2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame06(mvaariwtuktypesame[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame06(mvaaritmttkgkkykkjmaesame2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame06(mvaariwsame2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka06(mvaariwsameyendaka2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun06(mvaariwsameyenkijyun2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu06(mvaariwsameyenyasu2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka06(mvaariumsameyendaka2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun06(mvaariumsameyenkijyun2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu06(mvaariumsameyenyasu2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown06(mvaariwtuktypedown[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown06(mvaaritmttkgkkykkjmaedown2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown06(mvaariwdown2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka06(mvaariwdownyendaka2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun06(mvaariwdownyenkijyun2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu06(mvaariwdownyenyasu2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka06(mvaariumdownyendaka2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun06(mvaariumdownyenkijyun2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu06(mvaariumdownyenyasu2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype06(mvaarivtuktype[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv06(mvaariv2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake106(tutmttknutiwake12[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake206(tutmttknutiwake22[5]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[6])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu07(mvaarikeikanensuu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu07(sisuuupritu2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu07(tmttknzoukaritu2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup07(mvaariwtuktypeup[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup07(mvaaritmttkgkkykkjmaeup2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup07(mvaariwup2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka07(mvaariwupyendaka2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun07(mvaariwupyenkijyun2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu07(mvaariwupyenyasu2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka07(mvaariwumupyendaka2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun07(mvaariumupyenkijyun2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu07(mvaariumupyenyasu2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame07(mvaariwtuktypesame[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame07(mvaaritmttkgkkykkjmaesame2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame07(mvaariwsame2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka07(mvaariwsameyendaka2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun07(mvaariwsameyenkijyun2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu07(mvaariwsameyenyasu2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka07(mvaariumsameyendaka2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun07(mvaariumsameyenkijyun2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu07(mvaariumsameyenyasu2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown07(mvaariwtuktypedown[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown07(mvaaritmttkgkkykkjmaedown2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown07(mvaariwdown2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka07(mvaariwdownyendaka2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun07(mvaariwdownyenkijyun2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu07(mvaariwdownyenyasu2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka07(mvaariumdownyendaka2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun07(mvaariumdownyenkijyun2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu07(mvaariumdownyenyasu2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype07(mvaarivtuktype[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv07(mvaariv2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake107(tutmttknutiwake12[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake207(tutmttknutiwake22[6]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[7])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu08(mvaarikeikanensuu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu08(sisuuupritu2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu08(tmttknzoukaritu2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup08(mvaariwtuktypeup[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup08(mvaaritmttkgkkykkjmaeup2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup08(mvaariwup2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka08(mvaariwupyendaka2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun08(mvaariwupyenkijyun2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu08(mvaariwupyenyasu2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka08(mvaariwumupyendaka2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun08(mvaariumupyenkijyun2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu08(mvaariumupyenyasu2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame08(mvaariwtuktypesame[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame08(mvaaritmttkgkkykkjmaesame2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame08(mvaariwsame2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka08(mvaariwsameyendaka2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun08(mvaariwsameyenkijyun2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu08(mvaariwsameyenyasu2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka08(mvaariumsameyendaka2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun08(mvaariumsameyenkijyun2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu08(mvaariumsameyenyasu2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown08(mvaariwtuktypedown[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown08(mvaaritmttkgkkykkjmaedown2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown08(mvaariwdown2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka08(mvaariwdownyendaka2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun08(mvaariwdownyenkijyun2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu08(mvaariwdownyenyasu2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka08(mvaariumdownyendaka2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun08(mvaariumdownyenkijyun2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu08(mvaariumdownyenyasu2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype08(mvaarivtuktype[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv08(mvaariv2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake108(tutmttknutiwake12[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake208(tutmttknutiwake22[7]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[8])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu09(mvaarikeikanensuu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu09(sisuuupritu2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu09(tmttknzoukaritu2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup09(mvaariwtuktypeup[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup09(mvaaritmttkgkkykkjmaeup2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup09(mvaariwup2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka09(mvaariwupyendaka2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun09(mvaariwupyenkijyun2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu09(mvaariwupyenyasu2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka09(mvaariwumupyendaka2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun09(mvaariumupyenkijyun2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu09(mvaariumupyenyasu2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame09(mvaariwtuktypesame[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame09(mvaaritmttkgkkykkjmaesame2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame09(mvaariwsame2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka09(mvaariwsameyendaka2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun09(mvaariwsameyenkijyun2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu09(mvaariwsameyenyasu2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka09(mvaariumsameyendaka2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun09(mvaariumsameyenkijyun2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu09(mvaariumsameyenyasu2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown09(mvaariwtuktypedown[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown09(mvaaritmttkgkkykkjmaedown2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown09(mvaariwdown2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka09(mvaariwdownyendaka2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun09(mvaariwdownyenkijyun2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu09(mvaariwdownyenyasu2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka09(mvaariumdownyendaka2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun09(mvaariumdownyenkijyun2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu09(mvaariumdownyenyasu2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype09(mvaarivtuktype[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv09(mvaariv2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake109(tutmttknutiwake12[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake209(tutmttknutiwake22[8]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[9])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu10(mvaarikeikanensuu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu10(sisuuupritu2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu10(tmttknzoukaritu2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup10(mvaariwtuktypeup[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup10(mvaaritmttkgkkykkjmaeup2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup10(mvaariwup2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka10(mvaariwupyendaka2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun10(mvaariwupyenkijyun2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu10(mvaariwupyenyasu2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka10(mvaariwumupyendaka2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun10(mvaariumupyenkijyun2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu10(mvaariumupyenyasu2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame10(mvaariwtuktypesame[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame10(mvaaritmttkgkkykkjmaesame2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame10(mvaariwsame2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka10(mvaariwsameyendaka2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun10(mvaariwsameyenkijyun2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu10(mvaariwsameyenyasu2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka10(mvaariumsameyendaka2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun10(mvaariumsameyenkijyun2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu10(mvaariumsameyenyasu2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown10(mvaariwtuktypedown[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown10(mvaaritmttkgkkykkjmaedown2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown10(mvaariwdown2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka10(mvaariwdownyendaka2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun10(mvaariwdownyenkijyun2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu10(mvaariwdownyenyasu2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka10(mvaariumdownyendaka2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun10(mvaariumdownyenkijyun2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu10(mvaariumdownyenyasu2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype10(mvaarivtuktype[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv10(mvaariv2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake110(tutmttknutiwake12[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake210(tutmttknutiwake22[9]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[10])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu11(mvaarikeikanensuu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup11(mvaariwtuktypeup[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup11(mvaariwup2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka11(mvaariwupyendaka2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun11(mvaariwupyenkijyun2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu11(mvaariwupyenyasu2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka11(mvaariwumupyendaka2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun11(mvaariumupyenkijyun2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu11(mvaariumupyenyasu2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame11(mvaariwtuktypesame[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame11(mvaariwsame2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka11(mvaariwsameyendaka2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun11(mvaariwsameyenkijyun2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu11(mvaariwsameyenyasu2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka11(mvaariumsameyendaka2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun11(mvaariumsameyenkijyun2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu11(mvaariumsameyenyasu2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown11(mvaariwtuktypedown[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown11(mvaariwdown2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka11(mvaariwdownyendaka2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun11(mvaariwdownyenkijyun2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu11(mvaariwdownyenyasu2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka11(mvaariumdownyendaka2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun11(mvaariumdownyenkijyun2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu11(mvaariumdownyenyasu2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype11(mvaarivtuktype[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv11(mvaariv2[10]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[11])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu12(mvaarikeikanensuu[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup12(mvaariwtuktypeup[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup12(mvaariwup2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup12(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka12(mvaariwupyendaka2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun12(mvaariwupyenkijyun2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu12(mvaariwupyenyasu2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka12(mvaariwumupyendaka2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun12(mvaariumupyenkijyun2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu12(mvaariumupyenyasu2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame12(mvaariwtuktypesame[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame12(mvaariwsame2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame12(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka12(mvaariwsameyendaka2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun12(mvaariwsameyenkijyun2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu12(mvaariwsameyenyasu2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka12(mvaariumsameyendaka2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun12(mvaariumsameyenkijyun2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu12(mvaariumsameyenyasu2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown12(mvaariwtuktypedown[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown12(mvaariwdown2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown12(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka12(mvaariwdownyendaka2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun12(mvaariwdownyenkijyun2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu12(mvaariwdownyenyasu2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka12(mvaariumdownyendaka2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun12(mvaariumdownyenkijyun2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu12(mvaariumdownyenyasu2[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype12(mvaarivtuktype[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv12(mvaariv2[11]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[12])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu13(mvaarikeikanensuu[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup13(mvaariwtuktypeup[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup13(mvaariwup2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup13(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka13(mvaariwupyendaka2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun13(mvaariwupyenkijyun2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu13(mvaariwupyenyasu2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka13(mvaariwumupyendaka2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun13(mvaariumupyenkijyun2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu13(mvaariumupyenyasu2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame13(mvaariwtuktypesame[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame13(mvaariwsame2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame13(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka13(mvaariwsameyendaka2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun13(mvaariwsameyenkijyun2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu13(mvaariwsameyenyasu2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka13(mvaariumsameyendaka2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun13(mvaariumsameyenkijyun2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu13(mvaariumsameyenyasu2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown13(mvaariwtuktypedown[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown13(mvaariwdown2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown13(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka13(mvaariwdownyendaka2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun13(mvaariwdownyenkijyun2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu13(mvaariwdownyenyasu2[12]);

            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka13(mvaariumdownyendaka2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun13(mvaariumdownyenkijyun2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu13(mvaariumdownyenyasu2[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype13(mvaarivtuktype[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv13(mvaariv2[12]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[13])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu14(mvaarikeikanensuu[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup14(mvaariwtuktypeup[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup14(mvaariwup2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup14(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka14(mvaariwupyendaka2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun14(mvaariwupyenkijyun2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu14(mvaariwupyenyasu2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka14(mvaariwumupyendaka2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun14(mvaariumupyenkijyun2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu14(mvaariumupyenyasu2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame14(mvaariwtuktypesame[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame14(mvaariwsame2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame14(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka14(mvaariwsameyendaka2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun14(mvaariwsameyenkijyun2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu14(mvaariwsameyenyasu2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka14(mvaariumsameyendaka2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun14(mvaariumsameyenkijyun2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu14(mvaariumsameyenyasu2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown14(mvaariwtuktypedown[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown14(mvaariwdown2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown14(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka14(mvaariwdownyendaka2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun14(mvaariwdownyenkijyun2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu14(mvaariwdownyenyasu2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka14(mvaariumdownyendaka2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun14(mvaariumdownyenkijyun2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu14(mvaariumdownyenyasu2[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype14(mvaarivtuktype[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv14(mvaariv2[13]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[14])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu15(mvaarikeikanensuu[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup15(mvaariwtuktypeup[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup15(mvaariwup2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup15(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka15(mvaariwupyendaka2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun15(mvaariwupyenkijyun2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu15(mvaariwupyenyasu2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka15(mvaariwumupyendaka2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun15(mvaariumupyenkijyun2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu15(mvaariumupyenyasu2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame15(mvaariwtuktypesame[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame15(mvaariwsame2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame15(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka15(mvaariwsameyendaka2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun15(mvaariwsameyenkijyun2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu15(mvaariwsameyenyasu2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka15(mvaariumsameyendaka2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun15(mvaariumsameyenkijyun2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu15(mvaariumsameyenyasu2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown15(mvaariwtuktypedown[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown15(mvaariwdown2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown15(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka15(mvaariwdownyendaka2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun15(mvaariwdownyenkijyun2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu15(mvaariwdownyenyasu2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka15(mvaariumdownyendaka2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun15(mvaariumdownyenkijyun2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu15(mvaariumdownyenyasu2[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype15(mvaarivtuktype[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv15(mvaariv2[14]);
        }
    }
    private void editSinkeiyakuSyoukenSuiiTy13(
        ZT_SinkeiyakuSyoukenSuiiTy pSinkeiyakuSyoukenSuiiTy) {

        if (!BizUtil.isBlank(mvaarikeikanensuu[0])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu01(mvaarikeikanensuu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu01(sisuuupritu3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu01(tmttknzoukaritu3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup01(mvaariwtuktypeup[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup01(mvaaritmttkgkkykkjmaeup3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup01(mvaariwup3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka01(mvaariwupyendaka3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun01(mvaariwupyenkijyun3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu01(mvaariwupyenyasu3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame01(mvaariwtuktypesame[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame01(mvaaritmttkgkkykkjmaesame3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame01(mvaariwsame3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka01(mvaariwsameyendaka3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun01(mvaariwsameyenkijyun3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu01(mvaariwsameyenyasu3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown01(mvaariwtuktypedown[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown01(mvaaritmttkgkkykkjmaedown3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown01(mvaariwdown3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka01(mvaariwdownyendaka3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun01(mvaariwdownyenkijyun3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu01(mvaariwdownyenyasu3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu01(C_UmuKbn.NONE.getValue());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype01(mvaarivtuktype[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv01(mvaariv3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake101(tutmttknutiwake13[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake201(tutmttknutiwake23[0]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[1])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu02(mvaarikeikanensuu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu02(sisuuupritu3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu02(tmttknzoukaritu3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup02(mvaariwtuktypeup[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup02(mvaaritmttkgkkykkjmaeup3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup02(mvaariwup3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka02(mvaariwupyendaka3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun02(mvaariwupyenkijyun3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu02(mvaariwupyenyasu3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka02(mvaariwumupyendaka3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun02(mvaariumupyenkijyun3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu02(mvaariumupyenyasu3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame02(mvaariwtuktypesame[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame02(mvaaritmttkgkkykkjmaesame3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame02(mvaariwsame3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka02(mvaariwsameyendaka3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun02(mvaariwsameyenkijyun3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu02(mvaariwsameyenyasu3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka02(mvaariumsameyendaka3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun02(mvaariumsameyenkijyun3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu02(mvaariumsameyenyasu3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown02(mvaariwtuktypedown[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown02(mvaaritmttkgkkykkjmaedown3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown02(mvaariwdown3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka02(mvaariwdownyendaka3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun02(mvaariwdownyenkijyun3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu02(mvaariwdownyenyasu3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka02(mvaariumdownyendaka3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun02(mvaariumdownyenkijyun3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu02(mvaariumdownyenyasu3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype02(mvaarivtuktype[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv02(mvaariv3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake102(tutmttknutiwake13[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake202(tutmttknutiwake23[1]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[2])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu03(mvaarikeikanensuu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu03(sisuuupritu3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu03(tmttknzoukaritu3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup03(mvaariwtuktypeup[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup03(mvaaritmttkgkkykkjmaeup3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup03(mvaariwup3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka03(mvaariwupyendaka3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun03(mvaariwupyenkijyun3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu03(mvaariwupyenyasu3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka03(mvaariwumupyendaka3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun03(mvaariumupyenkijyun3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu03(mvaariumupyenyasu3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame03(mvaariwtuktypesame[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame03(mvaaritmttkgkkykkjmaesame3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame03(mvaariwsame3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka03(mvaariwsameyendaka3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun03(mvaariwsameyenkijyun3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu03(mvaariwsameyenyasu3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka03(mvaariumsameyendaka3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun03(mvaariumsameyenkijyun3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu03(mvaariumsameyenyasu3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown03(mvaariwtuktypedown[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown03(mvaaritmttkgkkykkjmaedown3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown03(mvaariwdown3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka03(mvaariwdownyendaka3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun03(mvaariwdownyenkijyun3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu03(mvaariwdownyenyasu3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka03(mvaariumdownyendaka3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun03(mvaariumdownyenkijyun3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu03(mvaariumdownyenyasu3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype03(mvaarivtuktype[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv03(mvaariv3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake103(tutmttknutiwake13[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake203(tutmttknutiwake23[2]);
        }


        if (!BizUtil.isBlank(mvaarikeikanensuu[3])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu04(mvaarikeikanensuu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu04(sisuuupritu3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu04(tmttknzoukaritu3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup04(mvaariwtuktypeup[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup04(mvaaritmttkgkkykkjmaeup3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup04(mvaariwup3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka04(mvaariwupyendaka3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun04(mvaariwupyenkijyun3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu04(mvaariwupyenyasu3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka04(mvaariwumupyendaka3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun04(mvaariumupyenkijyun3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu04(mvaariumupyenyasu3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame04(mvaariwtuktypesame[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame04(mvaaritmttkgkkykkjmaesame3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame04(mvaariwsame3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka04(mvaariwsameyendaka3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun04(mvaariwsameyenkijyun3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu04(mvaariwsameyenyasu3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka04(mvaariumsameyendaka3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun04(mvaariumsameyenkijyun3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu04(mvaariumsameyenyasu3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown04(mvaariwtuktypedown[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown04(mvaaritmttkgkkykkjmaedown3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown04(mvaariwdown3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka04(mvaariwdownyendaka3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun04(mvaariwdownyenkijyun3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu04(mvaariwdownyenyasu3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka04(mvaariumdownyendaka3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun04(mvaariumdownyenkijyun3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu04(mvaariumdownyenyasu3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype04(mvaarivtuktype[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv04(mvaariv3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake104(tutmttknutiwake13[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake204(tutmttknutiwake23[3]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[4])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu05(mvaarikeikanensuu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu05(sisuuupritu3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu05(tmttknzoukaritu3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup05(mvaariwtuktypeup[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup05(mvaaritmttkgkkykkjmaeup3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup05(mvaariwup3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka05(mvaariwupyendaka3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun05(mvaariwupyenkijyun3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu05(mvaariwupyenyasu3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka05(mvaariwumupyendaka3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun05(mvaariumupyenkijyun3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu05(mvaariumupyenyasu3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame05(mvaariwtuktypesame[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame05(mvaaritmttkgkkykkjmaesame3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame05(mvaariwsame3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka05(mvaariwsameyendaka3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun05(mvaariwsameyenkijyun3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu05(mvaariwsameyenyasu3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka05(mvaariumsameyendaka3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun05(mvaariumsameyenkijyun3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu05(mvaariumsameyenyasu3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown05(mvaariwtuktypedown[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown05(mvaaritmttkgkkykkjmaedown3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown05(mvaariwdown3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka05(mvaariwdownyendaka3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun05(mvaariwdownyenkijyun3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu05(mvaariwdownyenyasu3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka05(mvaariumdownyendaka3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun05(mvaariumdownyenkijyun3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu05(mvaariumdownyenyasu3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype05(mvaarivtuktype[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv05(mvaariv3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake105(tutmttknutiwake13[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake205(tutmttknutiwake23[4]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[5])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu06(mvaarikeikanensuu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu06(sisuuupritu3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu06(tmttknzoukaritu3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup06(mvaariwtuktypeup[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup06(mvaaritmttkgkkykkjmaeup3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup06(mvaariwup3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka06(mvaariwupyendaka3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun06(mvaariwupyenkijyun3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu06(mvaariwupyenyasu3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka06(mvaariwumupyendaka3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun06(mvaariumupyenkijyun3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu06(mvaariumupyenyasu3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame06(mvaariwtuktypesame[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame06(mvaaritmttkgkkykkjmaesame3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame06(mvaariwsame3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka06(mvaariwsameyendaka3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun06(mvaariwsameyenkijyun3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu06(mvaariwsameyenyasu3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka06(mvaariumsameyendaka3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun06(mvaariumsameyenkijyun3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu06(mvaariumsameyenyasu3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown06(mvaariwtuktypedown[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown06(mvaaritmttkgkkykkjmaedown3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown06(mvaariwdown3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka06(mvaariwdownyendaka3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun06(mvaariwdownyenkijyun3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu06(mvaariwdownyenyasu3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka06(mvaariumdownyendaka3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun06(mvaariumdownyenkijyun3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu06(mvaariumdownyenyasu3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype06(mvaarivtuktype[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv06(mvaariv3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake106(tutmttknutiwake13[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake206(tutmttknutiwake23[5]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[6])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu07(mvaarikeikanensuu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu07(sisuuupritu3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu07(tmttknzoukaritu3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup07(mvaariwtuktypeup[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup07(mvaaritmttkgkkykkjmaeup3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup07(mvaariwup3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka07(mvaariwupyendaka3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun07(mvaariwupyenkijyun3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu07(mvaariwupyenyasu3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka07(mvaariwumupyendaka3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun07(mvaariumupyenkijyun3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu07(mvaariumupyenyasu3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame07(mvaariwtuktypesame[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame07(mvaaritmttkgkkykkjmaesame3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame07(mvaariwsame3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka07(mvaariwsameyendaka3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun07(mvaariwsameyenkijyun3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu07(mvaariwsameyenyasu3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka07(mvaariumsameyendaka3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun07(mvaariumsameyenkijyun3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu07(mvaariumsameyenyasu3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown07(mvaariwtuktypedown[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown07(mvaaritmttkgkkykkjmaedown3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown07(mvaariwdown3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka07(mvaariwdownyendaka3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun07(mvaariwdownyenkijyun3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu07(mvaariwdownyenyasu3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka07(mvaariumdownyendaka3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun07(mvaariumdownyenkijyun3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu07(mvaariumdownyenyasu3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype07(mvaarivtuktype[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv07(mvaariv3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake107(tutmttknutiwake13[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake207(tutmttknutiwake23[6]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[7])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu08(mvaarikeikanensuu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu08(sisuuupritu3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu08(tmttknzoukaritu3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup08(mvaariwtuktypeup[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup08(mvaaritmttkgkkykkjmaeup3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup08(mvaariwup3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka08(mvaariwupyendaka3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun08(mvaariwupyenkijyun3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu08(mvaariwupyenyasu3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka08(mvaariwumupyendaka3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun08(mvaariumupyenkijyun3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu08(mvaariumupyenyasu3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame08(mvaariwtuktypesame[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame08(mvaaritmttkgkkykkjmaesame3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame08(mvaariwsame3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka08(mvaariwsameyendaka3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun08(mvaariwsameyenkijyun3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu08(mvaariwsameyenyasu3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka08(mvaariumsameyendaka3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun08(mvaariumsameyenkijyun3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu08(mvaariumsameyenyasu3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown08(mvaariwtuktypedown[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown08(mvaaritmttkgkkykkjmaedown3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown08(mvaariwdown3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka08(mvaariwdownyendaka3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun08(mvaariwdownyenkijyun3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu08(mvaariwdownyenyasu3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka08(mvaariumdownyendaka3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun08(mvaariumdownyenkijyun3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu08(mvaariumdownyenyasu3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype08(mvaarivtuktype[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv08(mvaariv3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake108(tutmttknutiwake13[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake208(tutmttknutiwake23[7]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[8])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu09(mvaarikeikanensuu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu09(sisuuupritu3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu09(tmttknzoukaritu3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup09(mvaariwtuktypeup[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup09(mvaaritmttkgkkykkjmaeup3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup09(mvaariwup3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka09(mvaariwupyendaka3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun09(mvaariwupyenkijyun3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu09(mvaariwupyenyasu3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka09(mvaariwumupyendaka3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun09(mvaariumupyenkijyun3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu09(mvaariumupyenyasu3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame09(mvaariwtuktypesame[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame09(mvaaritmttkgkkykkjmaesame3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame09(mvaariwsame3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka09(mvaariwsameyendaka3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun09(mvaariwsameyenkijyun3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu09(mvaariwsameyenyasu3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka09(mvaariumsameyendaka3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun09(mvaariumsameyenkijyun3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu09(mvaariumsameyenyasu3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown09(mvaariwtuktypedown[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown09(mvaaritmttkgkkykkjmaedown3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown09(mvaariwdown3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka09(mvaariwdownyendaka3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun09(mvaariwdownyenkijyun3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu09(mvaariwdownyenyasu3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka09(mvaariumdownyendaka3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun09(mvaariumdownyenkijyun3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu09(mvaariumdownyenyasu3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype09(mvaarivtuktype[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv09(mvaariv3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake109(tutmttknutiwake13[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake209(tutmttknutiwake23[8]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[9])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu10(mvaarikeikanensuu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarisisuuupritu10(sisuuupritu3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknzkritu10(tmttknzoukaritu3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup10(mvaariwtuktypeup[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmup10(mvaaritmttkgkkykkjmaeup3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup10(mvaariwup3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka10(mvaariwupyendaka3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun10(mvaariwupyenkijyun3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu10(mvaariwupyenyasu3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka10(mvaariwumupyendaka3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun10(mvaariumupyenkijyun3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu10(mvaariumupyenyasu3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame10(mvaariwtuktypesame[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmsame10(mvaaritmttkgkkykkjmaesame3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame10(mvaariwsame3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka10(mvaariwsameyendaka3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun10(mvaariwsameyenkijyun3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu10(mvaariwsameyenyasu3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka10(mvaariumsameyendaka3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun10(mvaariumsameyenkijyun3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu10(mvaariumsameyenyasu3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown10(mvaariwtuktypedown[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaaritmttknkykkjmdown10(mvaaritmttkgkkykkjmaedown3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown10(mvaariwdown3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka10(mvaariwdownyendaka3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun10(mvaariwdownyenkijyun3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu10(mvaariwdownyenyasu3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka10(mvaariumdownyendaka3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun10(mvaariumdownyenkijyun3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu10(mvaariumdownyenyasu3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype10(mvaarivtuktype[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv10(mvaariv3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake110(tutmttknutiwake13[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtyptmttkngkutiwake210(tutmttknutiwake23[9]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[10])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu11(mvaarikeikanensuu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup11(mvaariwtuktypeup[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup11(mvaariwup3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka11(mvaariwupyendaka3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun11(mvaariwupyenkijyun3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu11(mvaariwupyenyasu3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka11(mvaariwumupyendaka3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun11(mvaariumupyenkijyun3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu11(mvaariumupyenyasu3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame11(mvaariwtuktypesame[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame11(mvaariwsame3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka11(mvaariwsameyendaka3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun11(mvaariwsameyenkijyun3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu11(mvaariwsameyenyasu3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka11(mvaariumsameyendaka3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun11(mvaariumsameyenkijyun3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu11(mvaariumsameyenyasu3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown11(mvaariwtuktypedown[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown11(mvaariwdown3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka11(mvaariwdownyendaka3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun11(mvaariwdownyenkijyun3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu11(mvaariwdownyenyasu3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka11(mvaariumdownyendaka3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun11(mvaariumdownyenkijyun3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu11(mvaariumdownyenyasu3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype11(mvaarivtuktype[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv11(mvaariv3[10]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[11])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu12(mvaarikeikanensuu[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup12(mvaariwtuktypeup[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup12(mvaariwup3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup12(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka12(mvaariwupyendaka3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun12(mvaariwupyenkijyun3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu12(mvaariwupyenyasu3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka12(mvaariwumupyendaka3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun12(mvaariumupyenkijyun3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu12(mvaariumupyenyasu3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame12(mvaariwtuktypesame[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame12(mvaariwsame3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame12(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka12(mvaariwsameyendaka3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun12(mvaariwsameyenkijyun3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu12(mvaariwsameyenyasu3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka12(mvaariumsameyendaka3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun12(mvaariumsameyenkijyun3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu12(mvaariumsameyenyasu3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown12(mvaariwtuktypedown[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown12(mvaariwdown3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown12(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka12(mvaariwdownyendaka3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun12(mvaariwdownyenkijyun3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu12(mvaariwdownyenyasu3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka12(mvaariumdownyendaka3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun12(mvaariumdownyenkijyun3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu12(mvaariumdownyenyasu3[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype12(mvaarivtuktype[11]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv12(mvaariv3[11]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[12])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu13(mvaarikeikanensuu[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup13(mvaariwtuktypeup[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup13(mvaariwup3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup13(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka13(mvaariwupyendaka3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun13(mvaariwupyenkijyun3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu13(mvaariwupyenyasu3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka13(mvaariwumupyendaka3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun13(mvaariumupyenkijyun3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu13(mvaariumupyenyasu3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame13(mvaariwtuktypesame[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame13(mvaariwsame3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame13(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka13(mvaariwsameyendaka3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun13(mvaariwsameyenkijyun3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu13(mvaariwsameyenyasu3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka13(mvaariumsameyendaka3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun13(mvaariumsameyenkijyun3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu13(mvaariumsameyenyasu3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown13(mvaariwtuktypedown[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown13(mvaariwdown3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown13(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka13(mvaariwdownyendaka3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun13(mvaariwdownyenkijyun3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu13(mvaariwdownyenyasu3[12]);

            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka13(mvaariumdownyendaka3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun13(mvaariumdownyenkijyun3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu13(mvaariumdownyenyasu3[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype13(mvaarivtuktype[12]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv13(mvaariv3[12]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[13])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu14(mvaarikeikanensuu[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup14(mvaariwtuktypeup[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup14(mvaariwup3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup14(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka14(mvaariwupyendaka3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun14(mvaariwupyenkijyun3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu14(mvaariwupyenyasu3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka14(mvaariwumupyendaka3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun14(mvaariumupyenkijyun3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu14(mvaariumupyenyasu3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame14(mvaariwtuktypesame[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame14(mvaariwsame3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame14(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka14(mvaariwsameyendaka3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun14(mvaariwsameyenkijyun3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu14(mvaariwsameyenyasu3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka14(mvaariumsameyendaka3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun14(mvaariumsameyenkijyun3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu14(mvaariumsameyenyasu3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown14(mvaariwtuktypedown[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown14(mvaariwdown3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown14(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka14(mvaariwdownyendaka3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun14(mvaariwdownyenkijyun3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu14(mvaariwdownyenyasu3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka14(mvaariumdownyendaka3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun14(mvaariumdownyenkijyun3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu14(mvaariumdownyenyasu3[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype14(mvaarivtuktype[13]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv14(mvaariv3[13]);
        }

        if (!BizUtil.isBlank(mvaarikeikanensuu[14])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarikeikanensuu15(mvaarikeikanensuu[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypeup15(mvaariwtuktypeup[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwup15(mvaariwup3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypeup15(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyendaka15(mvaariwupyendaka3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenkijyun15(mvaariwupyenkijyun3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwupyenyasu15(mvaariwupyenyasu3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwumupyendaka15(mvaariwumupyendaka3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenkijyun15(mvaariumupyenkijyun3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumupyenyasu15(mvaariumupyenyasu3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypesame15(mvaariwtuktypesame[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsame15(mvaariwsame3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypesame15(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyendaka15(mvaariwsameyendaka3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenkijyun15(mvaariwsameyenkijyun3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwsameyenyasu15(mvaariwsameyenyasu3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyendaka15(mvaariumsameyendaka3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenkijyun15(mvaariumsameyenkijyun3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumsameyenyasu15(mvaariumsameyenyasu3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwtuktypedown15(mvaariwtuktypedown[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdown15(mvaariwdown3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwyentuktypedown15(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyendaka15(mvaariwdownyendaka3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenkijyun15(mvaariwdownyenkijyun3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariwdownyenyasu15(mvaariwdownyenyasu3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyendaka15(mvaariumdownyendaka3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenkijyun15(mvaariumdownyenkijyun3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariumdownyenyasu15(mvaariumdownyenyasu3[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaarivtuktype15(mvaarivtuktype[14]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvaariv15(mvaariv3[14]);
        }
    }

    private void editSinkeiyakuSyoukenSuiiTy2(
        IT_HokenSyouken pHokenSyouken,
        ZT_SinkeiyakuSyoukenSuiiTy  pSinkeiyakuSyoukenSuiiTy) {

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[0])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn01(mvanonekaisiinnumukbn[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu01(mvanonekeikanensuu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype01(mvanonewtuktype[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew01(mvaNoneW[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka01(mvanonewyendaka[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun01(mvanonewyenkijyun[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu01(mvanonewyenyasu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka01(mvanoneumyendaka[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun01(mvanoneumyenkijyun[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu01(mvanoneumyenyasu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype01(mvaNoneVTukType[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev01(mvaNoneY[0]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[1])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn02(mvanonekaisiinnumukbn[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu02(mvanonekeikanensuu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype02(mvanonewtuktype[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew02(mvaNoneW[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka02(mvanonewyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun02(mvanonewyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu02(mvanonewyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka02(mvanoneumyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun02(mvanoneumyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu02(mvanoneumyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype02(mvaNoneVTukType[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev02(mvaNoneY[1]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[2])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn03(mvanonekaisiinnumukbn[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu03(mvanonekeikanensuu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype03(mvanonewtuktype[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew03(mvaNoneW[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka03(mvanonewyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun03(mvanonewyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu03(mvanonewyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka03(mvanoneumyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun03(mvanoneumyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu03(mvanoneumyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype03(mvaNoneVTukType[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev03(mvaNoneY[2]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[3])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn04(mvanonekaisiinnumukbn[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu04(mvanonekeikanensuu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype04(mvanonewtuktype[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew04(mvaNoneW[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka04(mvanonewyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun04(mvanonewyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu04(mvanonewyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka04(mvanoneumyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun04(mvanoneumyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu04(mvanoneumyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype04(mvaNoneVTukType[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev04(mvaNoneY[3]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[4])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn05(mvanonekaisiinnumukbn[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu05(mvanonekeikanensuu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype05(mvanonewtuktype[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew05(mvaNoneW[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka05(mvanonewyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun05(mvanonewyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu05(mvanonewyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka05(mvanoneumyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun05(mvanoneumyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu05(mvanoneumyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype05(mvaNoneVTukType[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev05(mvaNoneY[4]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[5])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn06(mvanonekaisiinnumukbn[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu06(mvanonekeikanensuu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype06(mvanonewtuktype[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew06(mvaNoneW[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka06(mvanonewyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun06(mvanonewyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu06(mvanonewyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka06(mvanoneumyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun06(mvanoneumyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu06(mvanoneumyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype06(mvaNoneVTukType[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev06(mvaNoneY[5]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[6])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn07(mvanonekaisiinnumukbn[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu07(mvanonekeikanensuu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype07(mvanonewtuktype[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew07(mvaNoneW[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka07(mvanonewyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun07(mvanonewyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu07(mvanonewyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka07(mvanoneumyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun07(mvanoneumyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu07(mvanoneumyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype07(mvaNoneVTukType[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev07(mvaNoneY[6]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[7])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn08(mvanonekaisiinnumukbn[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu08(mvanonekeikanensuu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype08(mvanonewtuktype[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew08(mvaNoneW[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka08(mvanonewyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun08(mvanonewyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu08(mvanonewyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka08(mvanoneumyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun08(mvanoneumyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu08(mvanoneumyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype08(mvaNoneVTukType[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev08(mvaNoneY[7]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[8])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn09(mvanonekaisiinnumukbn[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu09(mvanonekeikanensuu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype09(mvanonewtuktype[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew09(mvaNoneW[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka09(mvanonewyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun09(mvanonewyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu09(mvanonewyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka09(mvanoneumyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun09(mvanoneumyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu09(mvanoneumyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype09(mvaNoneVTukType[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev09(mvaNoneY[8]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[9])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn10(mvanonekaisiinnumukbn[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu10(mvanonekeikanensuu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype10(mvanonewtuktype[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew10(mvaNoneW[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka10(mvanonewyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun10(mvanonewyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu10(mvanonewyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka10(mvanoneumyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun10(mvanoneumyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu10(mvanoneumyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype10(mvaNoneVTukType[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev10(mvaNoneY[9]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[10])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn11(mvanonekaisiinnumukbn[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu11(mvanonekeikanensuu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype11(mvanonewtuktype[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew11(mvaNoneW[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka11(mvanonewyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun11(mvanonewyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu11(mvanonewyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka11(mvanoneumyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun11(mvanoneumyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu11(mvanoneumyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype11(mvaNoneVTukType[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev11(mvaNoneY[10]);
        }

        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd1(pHokenSyouken.getWmsgcd1());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd2(pHokenSyouken.getWmsgcd2());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd3(pHokenSyouken.getWmsgcd3());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd21(pHokenSyouken.getWmsgcd21());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd22(pHokenSyouken.getWmsgcd22());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd23(pHokenSyouken.getWmsgcd23());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd31(pHokenSyouken.getWmsgcd31());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd32(pHokenSyouken.getWmsgcd32());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd33(pHokenSyouken.getWmsgcd33());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd1(pHokenSyouken.getWtyuuijikoumsgcd1());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd2(pHokenSyouken.getWtyuuijikoumsgcd2());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd3(pHokenSyouken.getWtyuuijikoumsgcd3());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd4(pHokenSyouken.getWtyuuijikoumsgcd4());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd5(pHokenSyouken.getWtyuuijikoumsgcd5());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd6(pHokenSyouken.getWtyuuijikoumsgcd6());
        pSinkeiyakuSyoukenSuiiTy.setZtywitjbrptuuktype(String.valueOf(pHokenSyouken.getWitijibrptuktype()));
        pSinkeiyakuSyoukenSuiiTy.setZtywitjbrp(witijibrp);
        pSinkeiyakuSyoukenSuiiTy.setZtywyenhrikmgktuuktype(String.valueOf(pHokenSyouken.getWyenhrkgktuktype()));
        pSinkeiyakuSyoukenSuiiTy.setZtywyenhrikmgk(String.valueOf(pHokenSyouken.getWyenhrkgk()));
        pSinkeiyakuSyoukenSuiiTy.setZtywyenitjbrptuuktype(String.valueOf(pHokenSyouken.getWyenitijibrptuktype()));
        pSinkeiyakuSyoukenSuiiTy.setZtywyenitjbrp(String.valueOf(pHokenSyouken.getWyenitijibrp()));
        pSinkeiyakuSyoukenSuiiTy.setZtyhrkkknmnrykeikanensuu(hrkkknmnrykeikanensuu);
        pSinkeiyakuSyoukenSuiiTy.setZtyhrkkknmnrynen(hrkkknmnrynen);
        pSinkeiyakuSyoukenSuiiTy.setZtysisuuupkaisuu(String.valueOf(pHokenSyouken.getSisuuupkaisuu()));
        pSinkeiyakuSyoukenSuiiTy.setZtysisuudownkaisuu(String.valueOf(pHokenSyouken.getSisuudownkaisuu()));
    }

    private void editSinkeiyakuSyoukenSuiiTy22(
        IT_HokenSyouken pHokenSyouken,
        ZT_SinkeiyakuSyoukenSuiiTy  pSinkeiyakuSyoukenSuiiTy) {

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[0])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn01(mvanonekaisiinnumukbn[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu01(mvanonekeikanensuu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype01(mvanonewtuktype[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew01(mvaNoneW2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka01(mvanonewyendaka2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun01(mvanonewyenkijyun2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu01(mvanonewyenyasu2[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka01(mvanoneumyendaka[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun01(mvanoneumyenkijyun[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu01(mvanoneumyenyasu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype01(mvaNoneVTukType[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev01(mvaNoneY2[0]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[1])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn02(mvanonekaisiinnumukbn[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu02(mvanonekeikanensuu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype02(mvanonewtuktype[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew02(mvaNoneW2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka02(mvanonewyendaka2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun02(mvanonewyenkijyun2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu02(mvanonewyenyasu2[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka02(mvanoneumyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun02(mvanoneumyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu02(mvanoneumyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype02(mvaNoneVTukType[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev02(mvaNoneY2[1]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[2])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn03(mvanonekaisiinnumukbn[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu03(mvanonekeikanensuu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype03(mvanonewtuktype[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew03(mvaNoneW2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka03(mvanonewyendaka2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun03(mvanonewyenkijyun2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu03(mvanonewyenyasu2[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka03(mvanoneumyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun03(mvanoneumyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu03(mvanoneumyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype03(mvaNoneVTukType[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev03(mvaNoneY2[2]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[3])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn04(mvanonekaisiinnumukbn[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu04(mvanonekeikanensuu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype04(mvanonewtuktype[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew04(mvaNoneW2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka04(mvanonewyendaka2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun04(mvanonewyenkijyun2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu04(mvanonewyenyasu2[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka04(mvanoneumyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun04(mvanoneumyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu04(mvanoneumyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype04(mvaNoneVTukType[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev04(mvaNoneY2[3]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[4])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn05(mvanonekaisiinnumukbn[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu05(mvanonekeikanensuu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype05(mvanonewtuktype[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew05(mvaNoneW2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka05(mvanonewyendaka2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun05(mvanonewyenkijyun2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu05(mvanonewyenyasu2[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka05(mvanoneumyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun05(mvanoneumyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu05(mvanoneumyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype05(mvaNoneVTukType[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev05(mvaNoneY2[4]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[5])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn06(mvanonekaisiinnumukbn[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu06(mvanonekeikanensuu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype06(mvanonewtuktype[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew06(mvaNoneW2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka06(mvanonewyendaka2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun06(mvanonewyenkijyun2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu06(mvanonewyenyasu2[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka06(mvanoneumyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun06(mvanoneumyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu06(mvanoneumyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype06(mvaNoneVTukType[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev06(mvaNoneY2[5]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[6])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn07(mvanonekaisiinnumukbn[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu07(mvanonekeikanensuu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype07(mvanonewtuktype[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew07(mvaNoneW2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka07(mvanonewyendaka2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun07(mvanonewyenkijyun2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu07(mvanonewyenyasu2[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka07(mvanoneumyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun07(mvanoneumyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu07(mvanoneumyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype07(mvaNoneVTukType[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev07(mvaNoneY2[6]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[7])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn08(mvanonekaisiinnumukbn[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu08(mvanonekeikanensuu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype08(mvanonewtuktype[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew08(mvaNoneW2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka08(mvanonewyendaka2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun08(mvanonewyenkijyun2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu08(mvanonewyenyasu2[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka08(mvanoneumyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun08(mvanoneumyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu08(mvanoneumyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype08(mvaNoneVTukType[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev08(mvaNoneY2[7]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[8])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn09(mvanonekaisiinnumukbn[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu09(mvanonekeikanensuu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype09(mvanonewtuktype[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew09(mvaNoneW2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka09(mvanonewyendaka2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun09(mvanonewyenkijyun2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu09(mvanonewyenyasu2[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka09(mvanoneumyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun09(mvanoneumyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu09(mvanoneumyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype09(mvaNoneVTukType[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev09(mvaNoneY2[8]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[9])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn10(mvanonekaisiinnumukbn[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu10(mvanonekeikanensuu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype10(mvanonewtuktype[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew10(mvaNoneW2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka10(mvanonewyendaka2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun10(mvanonewyenkijyun2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu10(mvanonewyenyasu2[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka10(mvanoneumyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun10(mvanoneumyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu10(mvanoneumyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype10(mvaNoneVTukType[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev10(mvaNoneY2[9]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[10])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn11(mvanonekaisiinnumukbn[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu11(mvanonekeikanensuu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype11(mvanonewtuktype[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew11(mvaNoneW2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka11(mvanonewyendaka2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun11(mvanonewyenkijyun2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu11(mvanonewyenyasu2[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka11(mvanoneumyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun11(mvanoneumyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu11(mvanoneumyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype11(mvaNoneVTukType[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev11(mvaNoneY2[10]);
        }

        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd1(pHokenSyouken.getWmsgcd1());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd2(pHokenSyouken.getWmsgcd2());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd3(pHokenSyouken.getWmsgcd3());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd21(pHokenSyouken.getWmsgcd21());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd22(pHokenSyouken.getWmsgcd22());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd23(pHokenSyouken.getWmsgcd23());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd31(pHokenSyouken.getWmsgcd31());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd32(pHokenSyouken.getWmsgcd32());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd33(pHokenSyouken.getWmsgcd33());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd1(pHokenSyouken.getWtyuuijikoumsgcd1());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd2(pHokenSyouken.getWtyuuijikoumsgcd2());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd3(pHokenSyouken.getWtyuuijikoumsgcd3());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd4(pHokenSyouken.getWtyuuijikoumsgcd4());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd5(pHokenSyouken.getWtyuuijikoumsgcd5());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd6(pHokenSyouken.getWtyuuijikoumsgcd6());
        pSinkeiyakuSyoukenSuiiTy.setZtywitjbrptuuktype(String.valueOf(pHokenSyouken.getWitijibrptuktype()));
        pSinkeiyakuSyoukenSuiiTy.setZtywitjbrp(witijibrp);
        pSinkeiyakuSyoukenSuiiTy.setZtywyenhrikmgktuuktype(String.valueOf(pHokenSyouken.getWyenhrkgktuktype()));
        pSinkeiyakuSyoukenSuiiTy.setZtywyenhrikmgk(String.valueOf(pHokenSyouken.getWyenhrkgk()));
        pSinkeiyakuSyoukenSuiiTy.setZtywyenitjbrptuuktype(String.valueOf(pHokenSyouken.getWyenitijibrptuktype()));
        pSinkeiyakuSyoukenSuiiTy.setZtywyenitjbrp(String.valueOf(pHokenSyouken.getWyenitijibrp()));

    }
    private void editSinkeiyakuSyoukenSuiiTy23(
        IT_HokenSyouken pHokenSyouken,
        ZT_SinkeiyakuSyoukenSuiiTy  pSinkeiyakuSyoukenSuiiTy) {

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[0])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn01(mvanonekaisiinnumukbn[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu01(mvanonekeikanensuu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype01(mvanonewtuktype[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew01(mvaNoneW3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype01(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka01(mvanonewyendaka3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun01(mvanonewyenkijyun3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu01(mvanonewyenyasu3[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka01(mvanoneumyendaka[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun01(mvanoneumyenkijyun[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu01(mvanoneumyenyasu[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype01(mvaNoneVTukType[0]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev01(mvaNoneY3[0]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[1])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn02(mvanonekaisiinnumukbn[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu02(mvanonekeikanensuu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype02(mvanonewtuktype[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew02(mvaNoneW3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype02(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka02(mvanonewyendaka3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun02(mvanonewyenkijyun3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu02(mvanonewyenyasu3[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka02(mvanoneumyendaka[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun02(mvanoneumyenkijyun[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu02(mvanoneumyenyasu[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype02(mvaNoneVTukType[1]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev02(mvaNoneY3[1]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[2])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn03(mvanonekaisiinnumukbn[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu03(mvanonekeikanensuu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype03(mvanonewtuktype[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew03(mvaNoneW3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype03(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka03(mvanonewyendaka3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun03(mvanonewyenkijyun3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu03(mvanonewyenyasu3[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka03(mvanoneumyendaka[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun03(mvanoneumyenkijyun[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu03(mvanoneumyenyasu[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype03(mvaNoneVTukType[2]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev03(mvaNoneY3[2]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[3])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn04(mvanonekaisiinnumukbn[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu04(mvanonekeikanensuu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype04(mvanonewtuktype[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew04(mvaNoneW3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype04(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka04(mvanonewyendaka3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun04(mvanonewyenkijyun3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu04(mvanonewyenyasu3[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka04(mvanoneumyendaka[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun04(mvanoneumyenkijyun[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu04(mvanoneumyenyasu[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype04(mvaNoneVTukType[3]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev04(mvaNoneY3[3]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[4])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn05(mvanonekaisiinnumukbn[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu05(mvanonekeikanensuu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype05(mvanonewtuktype[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew05(mvaNoneW3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype05(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka05(mvanonewyendaka3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun05(mvanonewyenkijyun3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu05(mvanonewyenyasu3[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka05(mvanoneumyendaka[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun05(mvanoneumyenkijyun[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu05(mvanoneumyenyasu[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype05(mvaNoneVTukType[4]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev05(mvaNoneY3[4]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[5])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn06(mvanonekaisiinnumukbn[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu06(mvanonekeikanensuu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype06(mvanonewtuktype[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew06(mvaNoneW3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype06(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka06(mvanonewyendaka3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun06(mvanonewyenkijyun3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu06(mvanonewyenyasu3[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka06(mvanoneumyendaka[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun06(mvanoneumyenkijyun[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu06(mvanoneumyenyasu[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype06(mvaNoneVTukType[5]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev06(mvaNoneY3[5]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[6])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn07(mvanonekaisiinnumukbn[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu07(mvanonekeikanensuu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype07(mvanonewtuktype[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew07(mvaNoneW3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype07(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka07(mvanonewyendaka3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun07(mvanonewyenkijyun3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu07(mvanonewyenyasu3[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka07(mvanoneumyendaka[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun07(mvanoneumyenkijyun[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu07(mvanoneumyenyasu[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype07(mvaNoneVTukType[6]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev07(mvaNoneY3[6]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[7])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn08(mvanonekaisiinnumukbn[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu08(mvanonekeikanensuu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype08(mvanonewtuktype[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew08(mvaNoneW3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype08(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka08(mvanonewyendaka3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun08(mvanonewyenkijyun3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu08(mvanonewyenyasu3[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka08(mvanoneumyendaka[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun08(mvanoneumyenkijyun[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu08(mvanoneumyenyasu[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype08(mvaNoneVTukType[7]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev08(mvaNoneY3[7]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[8])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn09(mvanonekaisiinnumukbn[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu09(mvanonekeikanensuu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype09(mvanonewtuktype[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew09(mvaNoneW3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype09(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka09(mvanonewyendaka3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun09(mvanonewyenkijyun3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu09(mvanonewyenyasu3[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka09(mvanoneumyendaka[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun09(mvanoneumyenkijyun[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu09(mvanoneumyenyasu[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype09(mvaNoneVTukType[8]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev09(mvaNoneY3[8]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[9])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn10(mvanonekaisiinnumukbn[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu10(mvanonekeikanensuu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype10(mvanonewtuktype[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew10(mvaNoneW3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype10(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka10(mvanonewyendaka3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun10(mvanonewyenkijyun3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu10(mvanonewyenyasu3[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka10(mvanoneumyendaka[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun10(mvanoneumyenkijyun[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu10(mvanoneumyenyasu[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype10(mvaNoneVTukType[9]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev10(mvaNoneY3[9]);
        }

        if (!BizUtil.isBlank(mvanonekaisiinnumukbn[10])) {
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekaisiinnumukbn11(mvanonekaisiinnumukbn[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonekeikanensuu11(mvanonekeikanensuu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewtuktype11(mvanonewtuktype[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonew11(mvaNoneW3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyentuktype11(C_Tuukasyu.JPY.toString());
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyendaka11(mvanonewyendaka3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenkijyun11(mvanonewyenkijyun3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonewyenyasu11(mvanonewyenyasu3[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyendaka11(mvanoneumyendaka[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenkijyun11(mvanoneumyenkijyun[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanoneumyenyasu11(mvanoneumyenyasu[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonevtuktype11(mvaNoneVTukType[10]);
            pSinkeiyakuSyoukenSuiiTy.setZtymvanonev11(mvaNoneY3[10]);
        }

        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd1(pHokenSyouken.getWmsgcd1());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd2(pHokenSyouken.getWmsgcd2());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd3(pHokenSyouken.getWmsgcd3());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd21(pHokenSyouken.getWmsgcd21());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd22(pHokenSyouken.getWmsgcd22());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd23(pHokenSyouken.getWmsgcd23());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd31(pHokenSyouken.getWmsgcd31());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd32(pHokenSyouken.getWmsgcd32());
        pSinkeiyakuSyoukenSuiiTy.setZtywmsgcd33(pHokenSyouken.getWmsgcd33());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd1(pHokenSyouken.getWtyuuijikoumsgcd1());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd2(pHokenSyouken.getWtyuuijikoumsgcd2());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd3(pHokenSyouken.getWtyuuijikoumsgcd3());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd4(pHokenSyouken.getWtyuuijikoumsgcd4());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd5(pHokenSyouken.getWtyuuijikoumsgcd5());
        pSinkeiyakuSyoukenSuiiTy.setZtywtyuuimsgcd6(pHokenSyouken.getWtyuuijikoumsgcd6());
        pSinkeiyakuSyoukenSuiiTy.setZtywitjbrptuuktype(String.valueOf(pHokenSyouken.getWitijibrptuktype()));
        pSinkeiyakuSyoukenSuiiTy.setZtywitjbrp(witijibrp);
        pSinkeiyakuSyoukenSuiiTy.setZtywyenhrikmgktuuktype(String.valueOf(pHokenSyouken.getWyenhrkgktuktype()));
        pSinkeiyakuSyoukenSuiiTy.setZtywyenhrikmgk(String.valueOf(pHokenSyouken.getWyenhrkgk()));
        pSinkeiyakuSyoukenSuiiTy.setZtywyenitjbrptuuktype(String.valueOf(pHokenSyouken.getWyenitijibrptuktype()));
        pSinkeiyakuSyoukenSuiiTy.setZtywyenitjbrp(String.valueOf(pHokenSyouken.getWyenitijibrp()));

    }

    private void editSinkeiyakuSyoukenSuiiTy3(
        IT_HokenSyouken pHokenSyouken,
        IT_KoujyoSym pKoujyoSym,
        ZT_SinkeiyakuSyoukenSuiiTy pSinkeiyakuSyoukenSuiiTy) {

        if (C_UmuKbn.ARI.eq(pHokenSyouken.getKoujyosyoumeiumukbn()))  {

            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeimsgcd1(pHokenSyouken.getKoujyosyoumeimsgcd1());
            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeimsgcd2(pHokenSyouken.getKoujyosyoumeimsgcd2());
            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeimsgcd3(pHokenSyouken.getKoujyosyoumeimsgcd3());
            pSinkeiyakuSyoukenSuiiTy.setZtysyoumeinndseireki(
                FixedDateFormatter.formatYZenkakuSeirekiKanji(BizDate.valueOf(pKoujyoSym.getNendo() + "0101")));
            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeikyknmkj(koujyosyoumeikyknmkj);
            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeisyono(pKoujyoSym.getSyono());
            pSinkeiyakuSyoukenSuiiTy.setZtykykymdseireki(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(pKoujyoSym.getKykymd()));
            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeihknsyurui(pKoujyoSym.getHknsyuruinmrykkj());
            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeihknkkn(koujyoSymHknKkn);
            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeihrkhuhu(koujyoSyoumeiHrkHuhu);
            pSinkeiyakuSyoukenSuiiTy.setZtynewhknjytukikan(newHknjytuKikan);
            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeiseidokbn("01");
            pSinkeiyakuSyoukenSuiiTy.setZtyippanseimeipsyouken(String.valueOf(pKoujyoSym.getNewippanjissekip()));
            pSinkeiyakuSyoukenSuiiTy.setZtyippanhaitoukin(String.valueOf(pKoujyoSym.getNewippanjissekihaitoukin()));
            pSinkeiyakuSyoukenSuiiTy.setZtyippansyoumeigksyouken(String.valueOf(pKoujyoSym.getNewippanjissekisyoumeigk()));
            pSinkeiyakuSyoukenSuiiTy.setZtyippansymgknasihyouji(ippanSymGkNasiHyouji);
            pSinkeiyakuSyoukenSuiiTy.setZtykaigoiryoup(String.valueOf(pKoujyoSym.getNewiryoujissekip()));
            pSinkeiyakuSyoukenSuiiTy.setZtykaigoiryoud(String.valueOf(pKoujyoSym.getNewiryoujissekihaitoukin()));
            pSinkeiyakuSyoukenSuiiTy.setZtykaigoiryousmgk(String.valueOf(pKoujyoSym.getNewiryoujissekisyoumeigk()));
            pSinkeiyakuSyoukenSuiiTy.setZtykaigoiryousmgknahyj(kaigoIryouSmGknaHyj);
            pSinkeiyakuSyoukenSuiiTy.setZtykoujyosyoumeihskmsgcd(pHokenSyouken.getKoujyosyoumeihskmsgcd());
            pSinkeiyakuSyoukenSuiiTy.setZtynenkoujyosyoumeisidkbn("01");

            if ("06".equals(koujyoSyoumeiHrkHuhu) || "12".equals(koujyoSyoumeiHrkHuhu)) {

                pSinkeiyakuSyoukenSuiiTy.setZtynenippanseimeip(String.valueOf(0));
                pSinkeiyakuSyoukenSuiiTy.setZtynenippand(String.valueOf(0));
                pSinkeiyakuSyoukenSuiiTy.setZtynenippansymgk(String.valueOf(0));
                pSinkeiyakuSyoukenSuiiTy.setZtynenippansymgknasihyouji(String.valueOf(0));
                pSinkeiyakuSyoukenSuiiTy.setZtynenkaigoiryoup(String.valueOf(0));
                pSinkeiyakuSyoukenSuiiTy.setZtynenkaigoiryoud(String.valueOf(0));
                pSinkeiyakuSyoukenSuiiTy.setZtyneniryousymgk(String.valueOf(0));
                pSinkeiyakuSyoukenSuiiTy.setZtyneniryousymgknasihyouji(String.valueOf(0));
            }
            else {

                pSinkeiyakuSyoukenSuiiTy.setZtynenippanseimeip(String.valueOf(pKoujyoSym.getNewippannenkanp()));
                pSinkeiyakuSyoukenSuiiTy.setZtynenippand(String.valueOf(pKoujyoSym.getNewippannenkanhaitoukin()));
                pSinkeiyakuSyoukenSuiiTy.setZtynenippansymgk(String.valueOf(pKoujyoSym.getNewippannenkansyoumeigk()));
                pSinkeiyakuSyoukenSuiiTy.setZtynenippansymgknasihyouji(nenIppanSymGknasiHyouji);
                pSinkeiyakuSyoukenSuiiTy.setZtynenkaigoiryoup(String.valueOf(pKoujyoSym.getNewiryounenkanp()));
                pSinkeiyakuSyoukenSuiiTy.setZtynenkaigoiryoud(String.valueOf(pKoujyoSym.getNewiryounenkanhaitoukin()));
                pSinkeiyakuSyoukenSuiiTy.setZtyneniryousymgk(String.valueOf(pKoujyoSym.getNewiryounenkansyoumeigk()));
                pSinkeiyakuSyoukenSuiiTy.setZtyneniryousymgknasihyouji(nenIryouSymGkNasiHyouji);
            }
            pSinkeiyakuSyoukenSuiiTy.setZtynenkoujyosyoumeihskmsgcd(pHokenSyouken.getNenkoujyosyoumeihskmsgcd());
            pSinkeiyakuSyoukenSuiiTy.setZtysyoumeiymdseireki(
                FixedDateFormatter.formatYMDZenkakuSeirekiKanji(BizDate.valueOf(pKoujyoSym.getSyoumeiymd())));
        }
    }

    private ZT_SinkeiyakuSyoukenSuii2Ty editSinkeiyakuSyoukenSuii2Ty(IT_Suiihyou pSuiihyou, int pSuiihyou2Cnt) {

        ZT_SinkeiyakuSyoukenSuii2Ty sinkeiyakuSyoukenSuii2Ty = new ZT_SinkeiyakuSyoukenSuii2Ty();

        sinkeiyakuSyoukenSuii2Ty.setZtysyono(pSuiihyou.getSyono());
        sinkeiyakuSyoukenSuii2Ty.setZtytyouhyouymd(pSuiihyou.getTyouhyouymd().toString());
        sinkeiyakuSyoukenSuii2Ty.setZtysuiihyouptn(SUIIHYOU_PTN4);
        sinkeiyakuSyoukenSuii2Ty.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        sinkeiyakuSyoukenSuii2Ty.setZtysuiihyousyono(pSuiihyou.getSyono());
        sinkeiyakuSyoukenSuii2Ty.setZtyytirrtcalckijyunrrt(ConvertUtil.toZenAll(
            seisuuHanndan(pSuiihyou.getYtirrtcalckijyunrrt1().multiply(100)).toString(), 0, 0));
        sinkeiyakuSyoukenSuii2Ty.setZtywkwsrateyendaka(yenKnsnKwsRateYenDaka);
        sinkeiyakuSyoukenSuii2Ty.setZtywkwsrateyenkijyun(yenKnsnKwsRateYenKijyun);
        sinkeiyakuSyoukenSuii2Ty.setZtywkwsrateyenyasu(yenKnsnKwsRateYenYasu);
        sinkeiyakuSyoukenSuii2Ty.setZtykyktuukatype(String.valueOf(pSuiihyou.getKyktuukasyu()));

        editSinkeiyakuSyoukenSuii2Ty1(sinkeiyakuSyoukenSuii2Ty, pSuiihyou2Cnt);

        BizPropertyInitializer.initialize(sinkeiyakuSyoukenSuii2Ty);

        return sinkeiyakuSyoukenSuii2Ty;
    }

    private ZT_SinkeiyakuSyoukenSuii2Ty editSinkeiyakuSyoukenSuii2Ty2(IT_Suiihyou pSuiihyou, int pSuiihyou2Cnt) {

        ZT_SinkeiyakuSyoukenSuii2Ty sinkeiyakuSyoukenSuii2Ty = new ZT_SinkeiyakuSyoukenSuii2Ty();

        sinkeiyakuSyoukenSuii2Ty.setZtysyono(pSuiihyou.getSyono());
        sinkeiyakuSyoukenSuii2Ty.setZtytyouhyouymd(pSuiihyou.getTyouhyouymd().toString());
        sinkeiyakuSyoukenSuii2Ty.setZtysuiihyouptn(SUIIHYOU_PTN5);
        sinkeiyakuSyoukenSuii2Ty.setZtysuiihyousykbn(pSuiihyou.getSuiihyousyubetu());
        sinkeiyakuSyoukenSuii2Ty.setZtysuiihyousyono(pSuiihyou.getSyono());
        sinkeiyakuSyoukenSuii2Ty.setZtyytirrtcalckijyunrrt(ConvertUtil.toZenAll(
            seisuuHanndan(pSuiihyou.getYtirrtcalckijyunrrt2().multiply(100)).toString(), 0, 0));
        sinkeiyakuSyoukenSuii2Ty.setZtywkwsrateyendaka(yenKnsnKwsRateYenDaka);
        sinkeiyakuSyoukenSuii2Ty.setZtywkwsrateyenkijyun(yenKnsnKwsRateYenKijyun);
        sinkeiyakuSyoukenSuii2Ty.setZtywkwsrateyenyasu(yenKnsnKwsRateYenYasu);
        sinkeiyakuSyoukenSuii2Ty.setZtykyktuukatype(String.valueOf(pSuiihyou.getKyktuukasyu()));

        editSinkeiyakuSyoukenSuii2Ty2(sinkeiyakuSyoukenSuii2Ty, pSuiihyou2Cnt);

        BizPropertyInitializer.initialize(sinkeiyakuSyoukenSuii2Ty);

        return sinkeiyakuSyoukenSuii2Ty;
    }

    private void editSinkeiyakuSyoukenSuii2Ty1(
        ZT_SinkeiyakuSyoukenSuii2Ty pSinkeiyakuSyoukenSuii2Ty, int pSuiihyou2Cnt) {

        for (int methodNo = 0; methodNo < pSuiihyou2Cnt; methodNo++) {

            try {
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtykeikanensuu",
                    methodNo,
                    keikanensuus[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtyhrkkknmnryumukbn",
                    methodNo,
                    hrkkknmnryumukbn[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtyzennouzndkyen",
                    methodNo,
                    zennouzndkyen[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtyyenhrkgkgoukei",
                    methodNo,
                    yenhrkgkgoukei[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtykihrkmp",
                    methodNo,
                    kihrkmp[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtyw",
                    methodNo,
                    w[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtywyenyendaka",
                    methodNo,
                    wyenyendaka[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtywyenkijun",
                    methodNo,
                    wyenkijun[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtywyenyenyasu",
                    methodNo,
                    wyenyenyasu[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtyzennouzndkgaika",
                    methodNo,
                    zennouzndk1[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtykaiykuktgk",
                    methodNo,
                    uktrgk[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtykaiykuktgkyenyendaka",
                    methodNo,
                    uktrgkyenyendaka[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtykaiykuktgkyenkijun",
                    methodNo,
                    uktrgkyenkijun[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtykaiykuktgkyenyenyasu",
                    methodNo,
                    uktrgkyenyenyasu[methodNo]);

            }  catch (IllegalAccessException
                | NoSuchMethodException
                | InvocationTargetException e) {
                throw new CommonBizAppException();
            }
        }
    }

    private void editSinkeiyakuSyoukenSuii2Ty2(
        ZT_SinkeiyakuSyoukenSuii2Ty pSinkeiyakuSyoukenSuii2Ty, int pSuiihyou2Cnt) {

        for (int methodNo = 0; methodNo < pSuiihyou2Cnt; methodNo++) {

            try {
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtykeikanensuu",
                    methodNo,
                    keikanensuus[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtyhrkkknmnryumukbn",
                    methodNo,
                    hrkkknmnryumukbn[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtyzennouzndkyen",
                    methodNo,
                    zennouzndkyen2[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtyyenhrkgkgoukei",
                    methodNo,
                    yenhrkgkgoukei2[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtykihrkmp",
                    methodNo,
                    kihrkmp2[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtyw",
                    methodNo,
                    w2[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtywyenyendaka",
                    methodNo,
                    wyenyendaka2[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
                    "setZtywyenkijun",
                    methodNo,
                    wyenkijun2[methodNo]);
                methodNmEditAndExec(
                    ZT_SinkeiyakuSyoukenSuii2Ty.class,
                    pSinkeiyakuSyoukenSuii2Ty,
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
        SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean pSinkeiyakuhokenshokenInfo) {

        if (pSuiihyouCnt == 0) {

            IT_KykKihon kykKihon = pSinkeiyakuhokenshokenInfo.getIT_HokenSyouken().getKykKihon();
            List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
            IT_KykSyouhn kykSyouhn =kykSyouhnList.get(0);
            int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());
            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR) {
                if (kykSyouhn.getYendthnkymd() == null &&
                    (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai()) ||
                        C_TmttknhaibunjyoutaiKbn.SISUUTEIRITU.eq(kykSyouhn.getTmttknhaibunjyoutai()))) {
                    suiihyouPtnCnt = 3;
                }
            }

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {

                if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(kykSyouhn.getTmttknhaibunjyoutai())) {

                    suiihyouPtnCnt = 2;
                }
            }

            if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                suiihyou2PtnCnt = 2;
            }

            if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                suiihyou2PtnCnt = 1;
            }

            if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19) {

                sonotanytumitateriritu2 = ConvertUtil.toZenAll(seisuuHanndan(kykSyouhn.getLoadinghnkgtumitateriritu().multiply(100)),0,0);
            }
        }
    }

    private void methodNmEditAndExec (
        Class<ZT_SinkeiyakuSyoukenSuii2Ty> pClass,
        ZT_SinkeiyakuSyoukenSuii2Ty pSinkeiyakuSyoukenSuii2Ty,
        String pMethodNm,
        int pMethodNo,
        Object pValue) throws
        IllegalAccessException,
        NoSuchMethodException,
        InvocationTargetException {

        String methodNo = BizUtil.num(String.valueOf(pMethodNo + 1), BizUtil.ZERO_FILL, 2);

        Method setMethod =
            pClass.getMethod(pMethodNm + methodNo, pValue.getClass());
        setMethod.invoke(pSinkeiyakuSyoukenSuii2Ty, pValue);
    }

    private int keikanensuuHanndan(int pKeikanensuu, C_UmuKbn pHrkkknmnryumukbn) {

        if (C_UmuKbn.ARI.eq(pHrkkknmnryumukbn)) {

            hrkkknmnryuFlg = true;
        }

        if (hrkkknmnryuFlg) {

            return pKeikanensuu;
        }

        return pKeikanensuu + 1;
    }

    private String seisuuHanndan(BizNumber pHenkanTaisyou) {

        if (pHenkanTaisyou.compareTo(BizNumber.TEN) < 0) {

            return BizUtil.zeroNum(String.valueOf(pHenkanTaisyou), 1, 2);
        }
        return BizUtil.zeroNum(String.valueOf(pHenkanTaisyou), 2, 2);
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
