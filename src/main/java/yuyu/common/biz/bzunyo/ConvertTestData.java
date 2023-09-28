package yuyu.common.biz.bzunyo;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBTransactionalUtil;
import jp.co.slcs.swak.util.string.ConvertUtil;
import jp.co.slcs.swak.util.string.IDataConvert;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.SyokenNoCheck;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.db.entity.BM_TestSyonokanri;


/**
 * 業務共通 業務共通運用 テストデータ変換
 */

public class ConvertTestData {

    @Inject
    private static Logger logger;

    @Inject
    private ConvertTestDataDao convertTestDataDao;


    public  ConvertTestDataOutBean getTestSyoukenNo(String pMosNO, String pBosyuuSosikiCD,String pSousasyaCD){

        logger.debug("▽テストデータ変換  テスト用証券番号採番号処理 開始");

        String seirekiNen2keta = "17";

        String bosyuuSosikiCd = pBosyuuSosikiCD;

        String syonoRenbanFive = "";

        Integer syonoRenban = 0 ;

        String syoNo = "";

        Integer checkDegit = 0;

        String imiNoObjectStr = "";

        BM_TestSyonokanri testSyonoKanri = null;

        String kbnKey = "";


        syonoRenban = convertTestDataDao.getTestSyonokanriMaxSyonorennoBySeirekinen2ketaBosyuusosikicd(seirekiNen2keta,bosyuuSosikiCd);

        if(syonoRenban != null){
            syonoRenban = syonoRenban + 1;
        }
        else{
            syonoRenban = 1;
        }

        while(true){

            syonoRenbanFive = String.format("%05d", syonoRenban);

            syoNo = seirekiNen2keta + bosyuuSosikiCd + syonoRenbanFive;

            checkDegit = SyokenNoCheck.calcDegit(syoNo);

            imiNoObjectStr = syonoRenbanFive + String.valueOf(checkDegit);

            boolean chkResult = imiNoObjectStr.matches(YuyuBizConfig.getInstance().getImiBangouChkPtn());

            if (!chkResult) {
                syoNo = syoNo + String.valueOf(checkDegit);

                break;
            }
            syonoRenban = syonoRenban + 1;

        }

        testSyonoKanri = new BM_TestSyonokanri();

        testSyonoKanri.setSeirekinen2keta(seirekiNen2keta);

        testSyonoKanri.setBosyuusosikicd(bosyuuSosikiCd);

        testSyonoKanri.setSyonorenno(syonoRenban);

        testSyonoKanri.setSyono(syoNo);

        testSyonoKanri.setMosno(pMosNO);

        testSyonoKanri.setSaibanymd(BizDate.getSysDate());

        testSyonoKanri.setGyoumuKousinsyaId(pSousasyaCD);

        testSyonoKanri.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        ExDBTransactionalUtil.insert(testSyonoKanri);

        if(!"".equals(syoNo)){

            kbnKey = "0" + syoNo.substring(syoNo.length() - 2,syoNo.length()-1);
        }

        ConvertTestDataOutBean convertTestDataOutBean = SWAKInjector.getInstance(ConvertTestDataOutBean.class);

        convertTestDataOutBean.setTestSyono(syoNo);

        convertTestDataOutBean.setKbnKey(kbnKey);

        logger.debug("△テストデータ変換  テスト用証券番号採番処理 終了");

        return convertTestDataOutBean;

    }

    public  String setTestKanjiNm(String pKnjNm, String pKnjNmKmk, String pKeyKmk){

        logger.debug("▽テストデータ変換  テスト用漢字氏名設定処理 開始");

        String hensyuuResultKngNm = "";

        if (pKnjNm == null) {
            hensyuuResultKngNm = "<NULL>";
        }else if("".equals(pKnjNm)){
            hensyuuResultKngNm = "";
        }else{
            hensyuuResultKngNm = pKnjNmKmk + "　" + ConvertUtil.convZenHan(IDataConvert.iCONVERT_H2Z_ALL,pKeyKmk.substring(pKeyKmk.length() - 3));
        }

        logger.debug("△テストデータ変換  テスト用漢字氏名設定処理 終了");

        return hensyuuResultKngNm;
    }

    public  String setNull(String pNullChkTaisyouKmk){

        logger.debug("▽テストデータ変換  NULL値設定処理 開始");

        String chkNullResult = "";

        if (pNullChkTaisyouKmk == null || "null".equals(pNullChkTaisyouKmk)) {
            chkNullResult = "<NULL>";
        }else{
            chkNullResult = pNullChkTaisyouKmk;
        }
        logger.debug("△テストデータ変換  NULL値設定処理 終了");
        return chkNullResult;
    }
}
