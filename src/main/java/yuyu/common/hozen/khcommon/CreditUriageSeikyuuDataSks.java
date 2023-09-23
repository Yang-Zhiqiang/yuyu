package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.dba4credituriageseikyuudatasks.CreditUriageSeikyuuDataSksDao;
import yuyu.def.classification.C_AuthoriKbn;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_UriageSeikyuuData;

/**
 * 契約保全 契約保全共通 クレカ売上請求データ作成
 */
public class CreditUriageSeikyuuDataSks {

    @Inject
    private CreditUriageSeikyuuDataSksDao creditUriageSeikyuuDataSksDao;

    @Inject
    private static Logger logger;

    public CreditUriageSeikyuuDataSks() {
        super();
    }


    public IT_UriageSeikyuuData editTuujyouUriageData(KhozenCommonParam pKhonzenCommonParam,
        UriageSeikyuuDataSksParam pUriageSeikyuuDataSksParam) {

        logger.debug("▽ クレカ売上請求データ作成 開始");

        IT_UriageSeikyuuData uriageSeikyuuData = SWAKInjector.getInstance(IT_UriageSeikyuuData.class);
        C_AuthoriKbn authoriKbn = null;

        if (pUriageSeikyuuDataSksParam.getUriagegk().compareTo(BizCurrency.valueOf(100000,
            pUriageSeikyuuDataSksParam.getUriagegk().getType())) > 0) {

            authoriKbn = C_AuthoriKbn.AUTHORIJISSI;
        }
        else {

            authoriKbn = C_AuthoriKbn.AUTHORINASI;
        }

        Integer renNo = getRenNo(pUriageSeikyuuDataSksParam.getAnsyuKihonTblentity(),
            pUriageSeikyuuDataSksParam.getKessaiyouno(),
            pUriageSeikyuuDataSksParam.getUriagenengappi());

        String recordNo = getRecordNo4TuujyouUriage(pUriageSeikyuuDataSksParam.getAnsyuKihonTblentity(),
            pUriageSeikyuuDataSksParam.getKessaiyouno(),
            pUriageSeikyuuDataSksParam.getUriagenengappi());

        uriageSeikyuuData = pUriageSeikyuuDataSksParam.getAnsyuKihonTblentity().createUriageSeikyuuData();

        uriageSeikyuuData.setSyono(pUriageSeikyuuDataSksParam.getAnsyuKihonTblentity().getSyono());

        uriageSeikyuuData.setCreditkessaiyouno(pUriageSeikyuuDataSksParam.getKessaiyouno());

        uriageSeikyuuData.setUriagenengappi(pUriageSeikyuuDataSksParam.getUriagenengappi());

        uriageSeikyuuData.setRenno3keta(renNo);

        uriageSeikyuuData.setRecordno(recordNo);

        uriageSeikyuuData.setSyoriYmd(pUriageSeikyuuDataSksParam.getSyoriYmd());

        uriageSeikyuuData.setCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn.TUUJYOU);

        uriageSeikyuuData.setAuthorikbn(authoriKbn);

        uriageSeikyuuData.setCredituriagegk(pUriageSeikyuuDataSksParam.getUriagegk());

        uriageSeikyuuData.setFukusuukameitennokey("1200010");

        uriageSeikyuuData.setJyuutouym(pUriageSeikyuuDataSksParam.getAnsyuRirekiTblentity().getJyuutouym());

        uriageSeikyuuData.setJyutoukaisuuy(pUriageSeikyuuDataSksParam.getAnsyuRirekiTblentity().getJyutoukaisuuy());

        uriageSeikyuuData.setJyutoukaisuum(pUriageSeikyuuDataSksParam.getAnsyuRirekiTblentity().getJyutoukaisuum());

        uriageSeikyuuData.setHrkkaisuu(pUriageSeikyuuDataSksParam.getAnsyuRirekiTblentity().getHrkkaisuu());

        uriageSeikyuuData.setTikiktbrisyuruikbn(
            pUriageSeikyuuDataSksParam.getAnsyuRirekiTblentity().getTikiktbrisyuruikbn());

        uriageSeikyuuData.setNyknaiyoukbn(pUriageSeikyuuDataSksParam.getAnsyuRirekiTblentity().getNyknaiyoukbn());

        uriageSeikyuuData.setAnnaino(pUriageSeikyuuDataSksParam.getAnsyuRirekiTblentity().getAnnaino());

        uriageSeikyuuData.setGyoumuKousinKinou(pKhonzenCommonParam.getFunctionId());

        uriageSeikyuuData.setGyoumuKousinsyaId(pKhonzenCommonParam.getUserID());

        uriageSeikyuuData.setGyoumuKousinTime(BizDate.getSysDateTime());

        logger.debug("△ クレカ売上請求データ作成 終了");

        BizPropertyInitializer.initialize(uriageSeikyuuData);

        return uriageSeikyuuData;
    }

    public IT_UriageSeikyuuData editRinjiUriageData(KhozenCommonParam pKhonzenCommonParam,
        UriageSeikyuuDataSksParam pUriageSeikyuuDataSksParam) {

        logger.debug("▽ クレカ売上請求データ作成 開始");

        IT_UriageSeikyuuData uriageSeikyuuData = SWAKInjector.getInstance(IT_UriageSeikyuuData.class);
        C_AuthoriKbn authoriKbn = C_AuthoriKbn.AUTHORIJISSI;

        Integer renNo = getRenNo(pUriageSeikyuuDataSksParam.getAnsyuKihonTblentity(),
            pUriageSeikyuuDataSksParam.getKessaiyouno(),
            pUriageSeikyuuDataSksParam.getUriagenengappi());

        String recordNo = "11";

        uriageSeikyuuData = pUriageSeikyuuDataSksParam.getAnsyuKihonTblentity().createUriageSeikyuuData();

        uriageSeikyuuData.setCreditkessaiyouno(pUriageSeikyuuDataSksParam.getKessaiyouno());

        uriageSeikyuuData.setUriagenengappi(pUriageSeikyuuDataSksParam.getUriagenengappi());

        uriageSeikyuuData.setRenno3keta(renNo);

        uriageSeikyuuData.setRecordno(recordNo);

        uriageSeikyuuData.setSyoriYmd(pUriageSeikyuuDataSksParam.getSyoriYmd());

        uriageSeikyuuData.setCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn.RINJI);

        uriageSeikyuuData.setAuthorikbn(authoriKbn);

        uriageSeikyuuData.setCredituriagegk(pUriageSeikyuuDataSksParam.getUriagegk());

        uriageSeikyuuData.setFukusuukameitennokey("1300010");

        uriageSeikyuuData.setJyutoukaisuuy(0);

        uriageSeikyuuData.setJyutoukaisuum(0);

        uriageSeikyuuData.setHrkkaisuu(C_Hrkkaisuu.BLNK);

        uriageSeikyuuData.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);

        uriageSeikyuuData.setNyknaiyoukbn(pUriageSeikyuuDataSksParam.getNyknaiyoukbn());

        uriageSeikyuuData.setAnnaino(0);

        uriageSeikyuuData.setGyoumuKousinKinou(pKhonzenCommonParam.getFunctionId());

        uriageSeikyuuData.setGyoumuKousinsyaId(pKhonzenCommonParam.getUserID());

        uriageSeikyuuData.setGyoumuKousinTime(BizDate.getSysDateTime());

        BizPropertyInitializer.initialize(uriageSeikyuuData);

        logger.debug("△ クレカ売上請求データ作成 終了");

        return uriageSeikyuuData;
    }

    public IT_UriageSeikyuuData editHenkinUriageData(KhozenCommonParam pKhonzenCommonParam,
        UriageSeikyuuDataSksParam pUriageSeikyuuDataSksParam) {

        logger.debug("▽ クレカ売上請求データ作成 開始");

        IT_UriageSeikyuuData uriageSeikyuuData = SWAKInjector.getInstance(IT_UriageSeikyuuData.class);
        C_AuthoriKbn authoriKbn = C_AuthoriKbn.MOSNAINISITAGAU;

        Integer renNo = getRenNo(pUriageSeikyuuDataSksParam.getAnsyuKihonTblentity(),
            pUriageSeikyuuDataSksParam.getKessaiyouno(),
            pUriageSeikyuuDataSksParam.getUriagenengappi());

        String recordNo = getRecordNo4MinusUriage(
            pUriageSeikyuuDataSksParam.getAnsyuKihonTblentity(),
            pUriageSeikyuuDataSksParam.getKessaiyouno(),
            pUriageSeikyuuDataSksParam.getUriagenengappi());

        uriageSeikyuuData = pUriageSeikyuuDataSksParam.getAnsyuKihonTblentity().createUriageSeikyuuData();

        uriageSeikyuuData.setCreditkessaiyouno(pUriageSeikyuuDataSksParam.getKessaiyouno());

        uriageSeikyuuData.setUriagenengappi(pUriageSeikyuuDataSksParam.getUriagenengappi());

        uriageSeikyuuData.setRenno3keta(renNo);

        uriageSeikyuuData.setRecordno(recordNo);

        uriageSeikyuuData.setSyoriYmd(pUriageSeikyuuDataSksParam.getSyoriYmd());

        uriageSeikyuuData.setCredituriageseikyuukbn(C_CreditUriageSeikyuuKbn.MINUS);

        uriageSeikyuuData.setAuthorikbn(authoriKbn);

        uriageSeikyuuData.setCredituriagegk(pUriageSeikyuuDataSksParam.getUriagegk().multiply(BizNumber.valueOf(-1)));

        uriageSeikyuuData.setFukusuukameitennokey("1300010");

        uriageSeikyuuData.setJyuutouym(pUriageSeikyuuDataSksParam.getJyuutouym());

        uriageSeikyuuData.setJyutoukaisuuy(0);

        uriageSeikyuuData.setJyutoukaisuum(0);

        uriageSeikyuuData.setHrkkaisuu(C_Hrkkaisuu.BLNK);

        uriageSeikyuuData.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.BLNK);

        uriageSeikyuuData.setNyknaiyoukbn(pUriageSeikyuuDataSksParam.getNyknaiyoukbn());

        uriageSeikyuuData.setAnnaino(0);

        uriageSeikyuuData.setGyoumuKousinKinou(pKhonzenCommonParam.getFunctionId());

        uriageSeikyuuData.setGyoumuKousinsyaId(pKhonzenCommonParam.getUserID());

        uriageSeikyuuData.setGyoumuKousinTime(BizDate.getSysDateTime());

        BizPropertyInitializer.initialize(uriageSeikyuuData);

        logger.debug("△ クレカ売上請求データ作成 終了");

        return uriageSeikyuuData;
    }

    private Integer getRenNo(IT_AnsyuKihon pAnsyuKihon,String pKessaiyouNo,BizDate pUriAgenengappi) {

        Integer renNo = creditUriageSeikyuuDataSksDao.getUriageSeikyuuDataMaxRenno3keta(
            pAnsyuKihon,pKessaiyouNo,pUriAgenengappi);

        if (renNo == null) {

            renNo = 1;
        }
        else {

            renNo += 1;
        }
        return renNo;
    }

    private String getRecordNo4TuujyouUriage(IT_AnsyuKihon pAnsyuKihon, String pKessaiyouNo, BizDate pUriagenengappi) {

        String maxRecordNo = creditUriageSeikyuuDataSksDao.getUriageSeikyuuDataMaxRecordno(pAnsyuKihon, pKessaiyouNo,
            pUriagenengappi, C_CreditUriageSeikyuuKbn.TUUJYOU);

        if (maxRecordNo == null) {

            maxRecordNo = "01";
        }
        else {

            maxRecordNo = BizUtil.zeroNum((String.valueOf(Integer.valueOf(maxRecordNo) + 1)), 2, 0);
        }
        return maxRecordNo;
    }

    private String getRecordNo4MinusUriage(IT_AnsyuKihon pAnsyuKihon, String pKessaiyouNo, BizDate pUriageymd) {

        String maxRecordNo = creditUriageSeikyuuDataSksDao.getUriageSeikyuuDataMaxRecordno(pAnsyuKihon, pKessaiyouNo,
            pUriageymd, C_CreditUriageSeikyuuKbn.MINUS);

        if (maxRecordNo == null) {

            maxRecordNo = "21";
        }
        else {

            maxRecordNo = BizUtil.zeroNum((String.valueOf(Integer.valueOf(maxRecordNo) + 1)), 2, 0);
        }
        return maxRecordNo;
    }

}