package yuyu.batch.sinkeiyaku.skijitoukei.sksyuhukugousikkansks;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.skijitoukei.sksyuhukugousikkansks.dba.SkSyuHukugouSikkanDataBean;
import yuyu.batch.sinkeiyaku.skijitoukei.sksyuhukugousikkansks.dba.SkSyuHukugouSikkanSksDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.ZT_SyuHukugouSikkanDataTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 新契約 医事統計 主契約複合疾患作成
 */
public class SkSyuHukugouSikkanSksBatch implements Batch {

    private static final String TASKNM = "普保Ⅱ主契約複合疾患データテーブル（中）";

    private static final String BLANK = "";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkSyuHukugouSikkanSksDao skSyuHukugouSikkanSksDao;

    @Inject
    ExDBEntityManager exDBEntityManager;

    private static final int MAX_CNT = 100000;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @SuppressWarnings("resource")
    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        long syoriKensuu = 0;

        @SuppressWarnings("deprecation")
        Connection c = exDBEntityManager.getJDBCConnection();

        try {
            c.setHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT);

            try (ExDBResults<SkSyuHukugouSikkanDataBean> skSyuHukugouSikkanDataBeanList =
                skSyuHukugouSikkanSksDao.getSkSyuHukugouSikkanData();
                EntityInserter<ZT_SyuHukugouSikkanDataTy> syuHukugouSikkanTyInserter = new EntityInserter<>()) {

                ZT_SyuHukugouSikkanDataTy syuHukugouSikkanDataTy = null;
                String nensyuuKbn;
                String kykTuukaSyu;
                String hrkTuukaSyu;
                BizNumber ijiToukeiKeikaN;
                int ijiToukeiSibouN;
                BizNumber ijiToukeiKeikaS;
                int ijiToukeiSibouS;
                int tmpCnt = 0;

                for (SkSyuHukugouSikkanDataBean skSyuHukugouSikkanDataBean : skSyuHukugouSikkanDataBeanList) {

                    nensyuuKbn = BLANK;
                    kykTuukaSyu = BLANK;
                    hrkTuukaSyu = BLANK;
                    ijiToukeiKeikaN = BizNumber.ZERO;
                    ijiToukeiSibouN = 0;
                    ijiToukeiKeikaS = BizNumber.ZERO;
                    ijiToukeiSibouS = 0;

                    if (C_NensyuuKbn.UNDER300.eq(skSyuHukugouSikkanDataBean.getHhknnensyuukbn())) {
                        nensyuuKbn = "1";
                    }
                    else if (C_NensyuuKbn.UNDER500.eq(skSyuHukugouSikkanDataBean.getHhknnensyuukbn())) {
                        nensyuuKbn = "2";
                    }
                    else if (C_NensyuuKbn.UNDER700.eq(skSyuHukugouSikkanDataBean.getHhknnensyuukbn())) {
                        nensyuuKbn = "3";
                    }
                    else if (C_NensyuuKbn.UNDER1000.eq(skSyuHukugouSikkanDataBean.getHhknnensyuukbn())) {
                        nensyuuKbn = "4";
                    }
                    else if (C_NensyuuKbn.MORETHAN1000.eq(skSyuHukugouSikkanDataBean.getHhknnensyuukbn())) {
                        nensyuuKbn = "5";
                    }
                    else {
                        nensyuuKbn = "0";
                    }

                    ijiToukeiKeikaN = skSyuHukugouSikkanDataBean.getIjitoukeikeikan().round(3, RoundingMode.HALF_UP);
                    if (ijiToukeiKeikaN.compareTo(BizNumber.valueOf(99999999.999)) > 0) {
                        ijiToukeiKeikaN = BizNumber.valueOf(99999999.999);
                    }

                    ijiToukeiSibouN = Integer.parseInt(skSyuHukugouSikkanDataBean.getIjitoukeisiboun().toString());
                    if (ijiToukeiSibouN > 99999) {
                        ijiToukeiSibouN = 99999;
                    }

                    ijiToukeiKeikaS = skSyuHukugouSikkanDataBean.getIjitoukeikeikas().round(1, RoundingMode.HALF_UP);
                    if (ijiToukeiKeikaS.compareTo(BizNumber.valueOf(9999999999.9)) > 0) {
                        ijiToukeiKeikaS = BizNumber.valueOf(9999999999.9);
                    }

                    ijiToukeiSibouS = Integer.parseInt(skSyuHukugouSikkanDataBean.getIjitoukeisibous().toString());
                    if (ijiToukeiSibouS > 999999999) {
                        ijiToukeiSibouS = 999999999;
                    }

                    kykTuukaSyu = tuukaSyuHenkanSyori(skSyuHukugouSikkanDataBean.getKyktuukasyu());

                    hrkTuukaSyu = tuukaSyuHenkanSyori(skSyuHukugouSikkanDataBean.getHrktuukasyu());

                    syuHukugouSikkanDataTy = new ZT_SyuHukugouSikkanDataTy();

                    syuHukugouSikkanDataTy.setZtyijitoukeidaihyousyurui(editStringPadZero(skSyuHukugouSikkanDataBean.getIjitoukeidaihyousyurui(), 2));
                    syuHukugouSikkanDataTy.setZtykeiyakunendo(editStringPadZero(skSyuHukugouSikkanDataBean.getKyknendo(), 4));
                    syuHukugouSikkanDataTy.setZtyhknnendo(editStringPadZero(skSyuHukugouSikkanDataBean.getHknnendo(), 2));
                    syuHukugouSikkanDataTy.setZtyhhknseikbn(editStringPadZero(skSyuHukugouSikkanDataBean.getHhknsei(), 1));
                    syuHukugouSikkanDataTy.setZtykykage(editStringPadZero(skSyuHukugouSikkanDataBean.getKykage(), 3));
                    syuHukugouSikkanDataTy.setZtytoutatunenrei(editStringPadZero(skSyuHukugouSikkanDataBean.getToutatunenrei(), 3));
                    syuHukugouSikkanDataTy.setZtyatukaibetu(editStringPadZero(skSyuHukugouSikkanDataBean.getAtukaibetu(), 1));
                    syuHukugouSikkanDataTy.setZtysinsahouhou(editStringPadZero(skSyuHukugouSikkanDataBean.getIjitoukeisinsahouhou(), 2));
                    syuHukugouSikkanDataTy.setZtyketteikekkakbn(editStringPadZero(skSyuHukugouSikkanDataBean.getKetteikekkaa(), 1));
                    syuHukugouSikkanDataTy.setZtysibousrank(editStringPadZero(skSyuHukugouSikkanDataBean.getSibousrank(), 2));
                    syuHukugouSikkanDataTy.setZtyjissituhosyousrank(editStringPadZero(skSyuHukugouSikkanDataBean.getJissituhosyousrank(), 2));
                    syuHukugouSikkanDataTy.setZtysirajikykkbn(editStringPadZero(skSyuHukugouSikkanDataBean.getSirajikykkbn(), 1));
                    syuHukugouSikkanDataTy.setZtyhrkhuhukbn(editStringPadZero(skSyuHukugouSikkanDataBean.getHrkhouhoukbn(), 1));
                    syuHukugouSikkanDataTy.setZtyhknsyurui2keta(editStringPadZero(skSyuHukugouSikkanDataBean.getIjitoukeihokensyuruikbn(), 2));
                    syuHukugouSikkanDataTy.setZtydaisiincd(editStringPadZero(skSyuHukugouSikkanDataBean.getDaisiincd(), 1));
                    syuHukugouSikkanDataTy.setZtytyuusiincd(editStringPadZero(skSyuHukugouSikkanDataBean.getTyuusiincd(), 2));
                    syuHukugouSikkanDataTy.setZtysyousiincd(editStringPadZero(skSyuHukugouSikkanDataBean.getSiincd(), 3));
                    syuHukugouSikkanDataTy.setZtynenreihousikikbn(editStringPadZero(skSyuHukugouSikkanDataBean.getNenreihousikikbn(), 1));
                    syuHukugouSikkanDataTy.setZtysykgycd(editStringPadZero(skSyuHukugouSikkanDataBean.getHhknsykgycd(), 3));
                    syuHukugouSikkanDataTy.setZtytodouhukencd(editStringPadZero(skSyuHukugouSikkanDataBean.getHhkntodouhukencd(), 2));
                    syuHukugouSikkanDataTy.setZtybotaisisyaeigyouhonbu(editStringPadZero(skSyuHukugouSikkanDataBean.getBotaisisyaeigyouhonbu(), 3));
                    syuHukugouSikkanDataTy.setZtysisyaeigyoubu(editStringPadZero(skSyuHukugouSikkanDataBean.getSisyaeigyoubu(), 3));
                    syuHukugouSikkanDataTy.setZtyaatukaisosikicd(editStringPadZero(skSyuHukugouSikkanDataBean.getAatsukaishasoshikicd(), 7));
                    syuHukugouSikkanDataTy.setZtynensyuukbn(nensyuuKbn);
                    syuHukugouSikkanDataTy.setZtyhanbaikeirokbn(editStringPadZero(skSyuHukugouSikkanDataBean.getHanbaikeirokbn(), 1));
                    syuHukugouSikkanDataTy.setZtyoyadairitencd(editStringPadZero(skSyuHukugouSikkanDataBean.getOyadrtencd(), 7));
                    syuHukugouSikkanDataTy.setZtytratkidrtencd(editStringPadZero(skSyuHukugouSikkanDataBean.getTratkiagcd(), 7));
                    syuHukugouSikkanDataTy.setZtybsudirtnatkikeitaikbn(editStringPadZero(skSyuHukugouSikkanDataBean.getBosyuudairitenatkikeitaikbn(), 1));
                    syuHukugouSikkanDataTy.setZtykyktuuka(kykTuukaSyu);
                    syuHukugouSikkanDataTy.setZtyhrktuuka(hrkTuukaSyu);
                    syuHukugouSikkanDataTy.setZtyhknsyukigou(skSyuHukugouSikkanDataBean.getSyouhncd().substring(0, 2));
                    syuHukugouSikkanDataTy.setZtysyksbyensitihsyutyhkumu(editStringPadZero(skSyuHukugouSikkanDataBean.getInitsbjiyensitihsytkhukaumu(), 1));
                    syuHukugouSikkanDataTy.setZtyjyudkaigomehrtkhkumu(editStringPadZero(skSyuHukugouSikkanDataBean.getJyudkaigomeharaitkhukaumu(), 1));
                    syuHukugouSikkanDataTy.setZtyijitoukeizennoukbn(editStringPadZero(skSyuHukugouSikkanDataBean.getIjitoukeizennoukbn(), 1));
                    syuHukugouSikkanDataTy.setZtydai1hknkkn(editStringPadZero(skSyuHukugouSikkanDataBean.getDai1hknkkn(), 2));
                    syuHukugouSikkanDataTy.setZtyijitoukeitikshrtkykkbn(editStringPadZero(skSyuHukugouSikkanDataBean.getIjitoukeitikshrtkykkbn(), 1));
                    syuHukugouSikkanDataTy.setZtyijitoukeikeikan(ijiToukeiKeikaN);
                    syuHukugouSikkanDataTy.setZtyijitoukeisiboun(ijiToukeiSibouN);
                    syuHukugouSikkanDataTy.setZtyijitoukeikeikas(ijiToukeiKeikaS);
                    syuHukugouSikkanDataTy.setZtyijitoukeisibous(ijiToukeiSibouS);

                    BizPropertyInitializer.initialize(syuHukugouSikkanDataTy);

                    syuHukugouSikkanTyInserter.add(syuHukugouSikkanDataTy);

                    syoriKensuu++;

                    tmpCnt++;
                    if(tmpCnt==MAX_CNT){
                        c.commit();
                        tmpCnt=0;
                    }
                }
            }

        } catch (SQLException e) {
        } finally{
            try {
                c.setHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT);
            } catch (SQLException e) {
            }
        }



        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), TASKNM));
    }

    private String tuukaSyuHenkanSyori(C_Tuukasyu pTuukaSyu) {

        String henkanTuukaSyu = BLANK;

        if (C_Tuukasyu.JPY.eq(pTuukaSyu)) {
            henkanTuukaSyu = "1";
        }
        else if (C_Tuukasyu.USD.eq(pTuukaSyu)) {
            henkanTuukaSyu = "2";
        }
        else if (C_Tuukasyu.EUR.eq(pTuukaSyu)) {
            henkanTuukaSyu = "3";
        }
        else if (C_Tuukasyu.AUD.eq(pTuukaSyu)) {
            henkanTuukaSyu = "4";
        }
        else {
            henkanTuukaSyu = "0";
        }

        return henkanTuukaSyu;
    }

    private String editStringPadZero(Object pObject, int pMaxLen) {

        if (pObject != null && pObject.toString().length() == pMaxLen) {
            return pObject.toString();
        }
        else if (pObject == null || pObject.toString().length() == 0) {
            return Strings.padStart(BLANK, pMaxLen, '0');
        }
        else {
            return Strings.padStart(pObject.toString(), pMaxLen, '0');

        }
    }
}
